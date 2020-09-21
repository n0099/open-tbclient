package com.baidu.tieba.write.write;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class l {
    private static final Pattern nhl = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext ehG;
    public com.baidu.tieba.write.c jcK;
    public String mLat;
    public String mLng;
    private WriteUrlModel nhh;
    private m nhm;
    private com.baidu.tieba.write.model.a nhn;
    private com.baidu.tieba.write.transmit.model.a nho;
    private com.baidu.tbadk.core.view.a nhp;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    l.this.dNg();
                    TiebaStatic.log(new aq("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    l.this.dNf();
                }
            }
        }
    };
    private View.OnClickListener nhq = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new aq("c12163"));
                String dNt = l.this.nhm.dNt();
                if (l.nhl.matcher(dNt).matches()) {
                    l.this.dNf();
                    l.this.nhn.Te(dNt);
                    l.this.nhm.a(null, true);
                    return;
                }
                TiebaStatic.log(new aq("c12164"));
                l.this.nhm.dNu();
            }
        }
    };
    private TextWatcher nhr = new TextWatcher() { // from class: com.baidu.tieba.write.write.l.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            l.this.nhm.dNl();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (l.this.jcK != null) {
                if (!l.this.jcK.dJA()) {
                    l.this.xw(false);
                }
                l.this.jcK.xj(false);
            }
        }
    };
    private DialogInterface.OnCancelListener nhs = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.l.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (l.this.nho != null) {
                l.this.nho.csi();
            }
        }
    };
    private a.InterfaceC0832a mVZ = new a.InterfaceC0832a() { // from class: com.baidu.tieba.write.write.l.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0832a
        public void onError() {
            l.this.fP(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0832a
        public void w(List<SimpleForum> list, int i) {
            l.this.fP(list);
        }
    };
    private a.InterfaceC0019a fQq = new a.InterfaceC0019a() { // from class: com.baidu.tieba.write.write.l.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0019a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                l.this.mLat = String.valueOf(address.getLatitude());
                l.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d ePy = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.l.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            l.this.nhm.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                l.this.jcK.bh(null);
                l.this.jcK.xi(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (l.this.g(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(l.this.ehG.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    l.this.ehG.getPageActivity().setResult(-1, intent);
                    l.this.ehG.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    l.this.ehG.showToast(postWriteCallBackData.getErrorString());
                    l.this.jcK.bh(postWriteCallBackData.getSensitiveWords());
                    l.this.jcK.SW(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(l.this.jcK.dJx())) {
                        l.this.xw(true);
                    }
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    l.this.nhm.n(postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bnT());
                    if (!com.baidu.tbadk.t.a.Dl(ahVar.bnS())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(l.this.ehG.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(l.this.ehG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bnS())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(l.this.ehG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public l(TbPageContext tbPageContext, m mVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.nhp = null;
        this.ehG = tbPageContext;
        this.nhm = mVar;
        this.nhn = aVar;
        this.nhh = writeUrlModel;
        this.nhm.am(this.mClickListener);
        this.nhm.an(this.nhq);
        this.nhm.e(this.nhr);
        dNg();
        this.nhp = new com.baidu.tbadk.core.view.a(this.ehG);
        this.nhp.setCancelListener(this.nhs);
        dNe();
        this.nhh.b(this.ePy);
        this.jcK = new com.baidu.tieba.write.c();
        this.jcK.JV(R.color.cp_cont_a);
        this.jcK.JW(R.color.cp_cont_h_alpha85);
    }

    private void dNe() {
        this.nho = new com.baidu.tieba.write.transmit.model.a(this.ehG.getUniqueId());
        this.nho.a(this.mVZ);
        if (this.nhh.cOG() != null) {
            this.nho.setForumId(this.nhh.cOG().getForumId());
        }
    }

    protected void dNf() {
        this.nhm.dNs();
    }

    protected void dNg() {
        this.nhm.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(List<SimpleForum> list) {
        WriteData cOG = this.nhh.cOG();
        if (cOG != null) {
            this.nhp.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cOG.getForumId()) && !cOG.getForumId().equals("0") && !StringUtils.isNull(cOG.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cOG.getForumId(), 0L), cOG.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (y.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cOG.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.ehG.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void dBj() {
        if (ae.checkLocationForBaiduLocation(this.ehG.getPageActivity())) {
            com.baidu.adp.lib.c.a.mj().a(true, this.fQq);
        }
    }

    public void destroy() {
        if (this.nho != null) {
            this.nho.destroy();
        }
        if (this.nhn != null) {
            this.nhn.destroy();
        }
        if (this.nhh != null) {
            this.nhh.cancelLoadData();
        }
    }

    public void cgo() {
        this.nho.setThreadContent(this.nhm.dNm());
        this.nho.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xw(boolean z) {
        if (this.nhm.dNo() != null && this.nhm.dNm() != null) {
            int selectionEnd = this.nhm.dNo().getSelectionEnd();
            SpannableStringBuilder c = this.jcK.c(this.nhm.dNo().getText());
            if (c != null) {
                this.jcK.xj(true);
                this.nhm.dNo().setText(c);
                if (z && this.jcK.dJy() >= 0) {
                    this.nhm.dNo().requestFocus();
                    this.nhm.dNo().setSelection(this.jcK.dJy());
                } else {
                    this.nhm.dNo().setSelection(selectionEnd);
                }
                this.jcK.xi(this.jcK.dJy() >= 0);
            }
        }
    }

    public boolean dNh() {
        if (this.jcK.dJz()) {
            this.ehG.showToast(this.jcK.dJB());
            xw(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.jcK.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cOG;
        if (i2 == -1) {
            if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = null;
                if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                }
                if (postWriteCallBackData2 != null) {
                    Intent intent2 = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData2);
                    intent2.putExtras(bundle);
                    this.ehG.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cOG = this.nhh.cOG()) != null && this.nhn.dKr() != null) {
                if (intent != null) {
                    cOG.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cOG.setForumId("0");
                cOG.setCanNoForum(true);
                cOG.setRecommendExt(this.nho.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    dNi();
                } else if (ae.checkLocationForBaiduLocation(this.ehG.getPageActivity())) {
                    com.baidu.adp.lib.c.a.mj().a(true, new a.InterfaceC0019a() { // from class: com.baidu.tieba.write.write.l.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0019a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                l.this.mLat = String.valueOf(address.getLatitude());
                                l.this.mLng = String.valueOf(address.getLongitude());
                            }
                            l.this.dNi();
                        }
                    });
                }
                this.nhm.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.ehG.showToast(postWriteCallBackData.getErrorString());
                        this.jcK.bh(postWriteCallBackData.getSensitiveWords());
                        if (!y.isEmpty(this.jcK.dJx())) {
                            xw(true);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void dNi() {
        this.nhh.g("", this.nhm.dNm(), this.nhn.dKr().linkUrl, this.nhn.dKr().linkUrlCode, this.mLat, this.mLng);
    }
}
