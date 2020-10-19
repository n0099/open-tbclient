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
    private static final Pattern nwK = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext etO;
    public com.baidu.tieba.write.c jrJ;
    public String mLat;
    public String mLng;
    private WriteUrlModel nwG;
    private m nwL;
    private com.baidu.tieba.write.model.a nwM;
    private com.baidu.tieba.write.transmit.model.a nwN;
    private com.baidu.tbadk.core.view.a nwO;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    l.this.dQS();
                    TiebaStatic.log(new aq("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    l.this.dQR();
                }
            }
        }
    };
    private View.OnClickListener nwP = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new aq("c12163"));
                String dRf = l.this.nwL.dRf();
                if (l.nwK.matcher(dRf).matches()) {
                    l.this.dQR();
                    l.this.nwM.TS(dRf);
                    l.this.nwL.a(null, true);
                    return;
                }
                TiebaStatic.log(new aq("c12164"));
                l.this.nwL.dRg();
            }
        }
    };
    private TextWatcher nwQ = new TextWatcher() { // from class: com.baidu.tieba.write.write.l.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            l.this.nwL.dQX();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (l.this.jrJ != null) {
                if (!l.this.jrJ.dNm()) {
                    l.this.yd(false);
                }
                l.this.jrJ.xQ(false);
            }
        }
    };
    private DialogInterface.OnCancelListener nwR = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.l.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (l.this.nwN != null) {
                l.this.nwN.cvF();
            }
        }
    };
    private a.InterfaceC0850a nly = new a.InterfaceC0850a() { // from class: com.baidu.tieba.write.write.l.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0850a
        public void onError() {
            l.this.fS(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0850a
        public void s(List<SimpleForum> list, int i) {
            l.this.fS(list);
        }
    };
    private a.InterfaceC0020a gcI = new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.l.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                l.this.mLat = String.valueOf(address.getLatitude());
                l.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d fbF = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.l.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            l.this.nwL.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                l.this.jrJ.bh(null);
                l.this.jrJ.xP(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (l.this.g(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(l.this.etO.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    l.this.etO.getPageActivity().setResult(-1, intent);
                    l.this.etO.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    l.this.etO.showToast(postWriteCallBackData.getErrorString());
                    l.this.jrJ.bh(postWriteCallBackData.getSensitiveWords());
                    l.this.jrJ.TK(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(l.this.jrJ.dNj())) {
                        l.this.yd(true);
                    }
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    l.this.nwL.n(postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bqD());
                    if (!com.baidu.tbadk.t.a.DX(ahVar.bqC())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(l.this.etO.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(l.this.etO.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bqC())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(l.this.etO.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public l(TbPageContext tbPageContext, m mVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.nwO = null;
        this.etO = tbPageContext;
        this.nwL = mVar;
        this.nwM = aVar;
        this.nwG = writeUrlModel;
        this.nwL.am(this.mClickListener);
        this.nwL.an(this.nwP);
        this.nwL.e(this.nwQ);
        dQS();
        this.nwO = new com.baidu.tbadk.core.view.a(this.etO);
        this.nwO.setCancelListener(this.nwR);
        dQQ();
        this.nwG.b(this.fbF);
        this.jrJ = new com.baidu.tieba.write.c();
        this.jrJ.KB(R.color.cp_cont_a);
        this.jrJ.KC(R.color.cp_cont_h_alpha85);
    }

    private void dQQ() {
        this.nwN = new com.baidu.tieba.write.transmit.model.a(this.etO.getUniqueId());
        this.nwN.a(this.nly);
        if (this.nwG.cSo() != null) {
            this.nwN.setForumId(this.nwG.cSo().getForumId());
        }
    }

    protected void dQR() {
        this.nwL.dRe();
    }

    protected void dQS() {
        this.nwL.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fS(List<SimpleForum> list) {
        WriteData cSo = this.nwG.cSo();
        if (cSo != null) {
            this.nwO.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cSo.getForumId()) && !cSo.getForumId().equals("0") && !StringUtils.isNull(cSo.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cSo.getForumId(), 0L), cSo.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (y.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cSo.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.etO.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void dEV() {
        if (ae.checkLocationForBaiduLocation(this.etO.getPageActivity())) {
            com.baidu.adp.lib.c.a.mk().a(true, this.gcI);
        }
    }

    public void destroy() {
        if (this.nwN != null) {
            this.nwN.destroy();
        }
        if (this.nwM != null) {
            this.nwM.destroy();
        }
        if (this.nwG != null) {
            this.nwG.cancelLoadData();
        }
    }

    public void cjK() {
        this.nwN.setThreadContent(this.nwL.dQY());
        this.nwN.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yd(boolean z) {
        if (this.nwL.dRa() != null && this.nwL.dQY() != null) {
            int selectionEnd = this.nwL.dRa().getSelectionEnd();
            SpannableStringBuilder c = this.jrJ.c(this.nwL.dRa().getText());
            if (c != null) {
                this.jrJ.xQ(true);
                this.nwL.dRa().setText(c);
                if (z && this.jrJ.dNk() >= 0) {
                    this.nwL.dRa().requestFocus();
                    this.nwL.dRa().setSelection(this.jrJ.dNk());
                } else {
                    this.nwL.dRa().setSelection(selectionEnd);
                }
                this.jrJ.xP(this.jrJ.dNk() >= 0);
            }
        }
    }

    public boolean dQT() {
        if (this.jrJ.dNl()) {
            this.etO.showToast(this.jrJ.dNn());
            yd(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.jrJ.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cSo;
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
                    this.etO.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cSo = this.nwG.cSo()) != null && this.nwM.dOd() != null) {
                if (intent != null) {
                    cSo.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cSo.setForumId("0");
                cSo.setCanNoForum(true);
                cSo.setRecommendExt(this.nwN.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    dQU();
                } else if (ae.checkLocationForBaiduLocation(this.etO.getPageActivity())) {
                    com.baidu.adp.lib.c.a.mk().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.l.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                l.this.mLat = String.valueOf(address.getLatitude());
                                l.this.mLng = String.valueOf(address.getLongitude());
                            }
                            l.this.dQU();
                        }
                    });
                }
                this.nwL.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.etO.showToast(postWriteCallBackData.getErrorString());
                        this.jrJ.bh(postWriteCallBackData.getSensitiveWords());
                        if (!y.isEmpty(this.jrJ.dNj())) {
                            yd(true);
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

    public void dQU() {
        this.nwG.g("", this.nwL.dQY(), this.nwM.dOd().linkUrl, this.nwM.dOd().linkUrlCode, this.mLat, this.mLng);
    }
}
