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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
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
/* loaded from: classes2.dex */
public class j {
    private static final Pattern lGw = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext duK;
    public com.baidu.tieba.write.c hSs;
    private com.baidu.tbadk.core.view.a lGA;
    private WriteUrlModel lGs;
    private k lGx;
    private com.baidu.tieba.write.model.a lGy;
    private com.baidu.tieba.write.transmit.model.a lGz;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.dhT();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.dhS();
                }
            }
        }
    };
    private View.OnClickListener lGB = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new an("c12163"));
                String dig = j.this.lGx.dig();
                if (j.lGw.matcher(dig).matches()) {
                    j.this.dhS();
                    j.this.lGy.Mz(dig);
                    j.this.lGx.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.lGx.dih();
            }
        }
    };
    private TextWatcher lGC = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.lGx.dhY();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.hSs != null) {
                if (!j.this.hSs.deS()) {
                    j.this.uY(false);
                }
                j.this.hSs.uO(false);
            }
        }
    };
    private DialogInterface.OnCancelListener lGD = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.lGz != null) {
                j.this.lGz.bRh();
            }
        }
    };
    private a.InterfaceC0701a lwM = new a.InterfaceC0701a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0701a
        public void onError() {
            j.this.eR(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0701a
        public void c(List<SimpleForum> list, int i) {
            j.this.eR(list);
        }
    };
    private a.InterfaceC0018a eYr = new a.InterfaceC0018a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d dYM = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            j.this.lGx.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.hSs.aW(null);
                j.this.hSs.uN(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(j.this.duK.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.duK.getPageActivity().setResult(-1, intent);
                    j.this.duK.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.duK.showToast(postWriteCallBackData.getErrorString());
                    j.this.hSs.aW(postWriteCallBackData.getSensitiveWords());
                    j.this.hSs.Ms(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(j.this.hSs.deP())) {
                        j.this.uY(true);
                    }
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.lGx.l(postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aSf());
                    if (!com.baidu.tbadk.s.a.xr(aaVar.aSe())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(j.this.duK.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(j.this.duK.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aSe())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(j.this.duK.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.lGA = null;
        this.duK = tbPageContext;
        this.lGx = kVar;
        this.lGy = aVar;
        this.lGs = writeUrlModel;
        this.lGx.aj(this.mClickListener);
        this.lGx.ak(this.lGB);
        this.lGx.f(this.lGC);
        dhT();
        this.lGA = new com.baidu.tbadk.core.view.a(this.duK);
        this.lGA.setCancelListener(this.lGD);
        dhR();
        this.lGs.b(this.dYM);
        this.hSs = new com.baidu.tieba.write.c();
        this.hSs.EI(R.color.cp_cont_a);
        this.hSs.EJ(R.color.cp_cont_h_alpha85);
    }

    private void dhR() {
        this.lGz = new com.baidu.tieba.write.transmit.model.a(this.duK.getUniqueId());
        this.lGz.a(this.lwM);
        if (this.lGs.cSK() != null) {
            this.lGz.setForumId(this.lGs.cSK().getForumId());
        }
    }

    protected void dhS() {
        this.lGx.dif();
    }

    protected void dhT() {
        this.lGx.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eR(List<SimpleForum> list) {
        WriteData cSK = this.lGs.cSK();
        if (cSK != null) {
            this.lGA.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cSK.getForumId()) && !cSK.getForumId().equals("0") && !StringUtils.isNull(cSK.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cSK.getForumId(), 0L), cSK.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cSK.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.duK.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void cWX() {
        if (ab.checkLocationForBaiduLocation(this.duK.getPageActivity())) {
            com.baidu.adp.lib.c.a.ko().a(true, this.eYr);
        }
    }

    public void destroy() {
        if (this.lGz != null) {
            this.lGz.destroy();
        }
        if (this.lGy != null) {
            this.lGy.destroy();
        }
        if (this.lGs != null) {
            this.lGs.cancelLoadData();
        }
    }

    public void bFU() {
        this.lGz.setThreadContent(this.lGx.dhZ());
        this.lGz.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uY(boolean z) {
        if (this.lGx.dib() != null && this.lGx.dhZ() != null) {
            int selectionEnd = this.lGx.dib().getSelectionEnd();
            SpannableStringBuilder a = this.hSs.a(this.lGx.dib().getText());
            if (a != null) {
                this.hSs.uO(true);
                this.lGx.dib().setText(a);
                if (z && this.hSs.deQ() >= 0) {
                    this.lGx.dib().requestFocus();
                    this.lGx.dib().setSelection(this.hSs.deQ());
                } else {
                    this.lGx.dib().setSelection(selectionEnd);
                }
                this.hSs.uN(this.hSs.deQ() >= 0);
            }
        }
    }

    public boolean dhU() {
        if (this.hSs.deR()) {
            this.duK.showToast(this.hSs.deT());
            uY(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.hSs.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cSK;
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
                    this.duK.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cSK = this.lGs.cSK()) != null && this.lGy.dfH() != null) {
                if (intent != null) {
                    cSK.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cSK.setForumId("0");
                cSK.setCanNoForum(true);
                cSK.setRecommendExt(this.lGz.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    dhV();
                } else if (ab.checkLocationForBaiduLocation(this.duK.getPageActivity())) {
                    com.baidu.adp.lib.c.a.ko().a(true, new a.InterfaceC0018a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.dhV();
                        }
                    });
                }
                this.lGx.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.duK.showToast(postWriteCallBackData.getErrorString());
                        this.hSs.aW(postWriteCallBackData.getSensitiveWords());
                        if (!v.isEmpty(this.hSs.deP())) {
                            uY(true);
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

    public void dhV() {
        this.lGs.e("", this.lGx.dhZ(), this.lGy.dfH().linkUrl, this.lGy.dfH().linkUrlCode, this.mLat, this.mLng);
    }
}
