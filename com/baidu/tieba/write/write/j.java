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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
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
public class j {
    private static final Pattern mDV = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext dVN;
    public com.baidu.tieba.write.c iFa;
    private WriteUrlModel mDR;
    private k mDW;
    private com.baidu.tieba.write.model.a mDX;
    private com.baidu.tieba.write.transmit.model.a mDY;
    private com.baidu.tbadk.core.view.a mDZ;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.dxl();
                    TiebaStatic.log(new ap("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.dxk();
                }
            }
        }
    };
    private View.OnClickListener mEa = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new ap("c12163"));
                String dxy = j.this.mDW.dxy();
                if (j.mDV.matcher(dxy).matches()) {
                    j.this.dxk();
                    j.this.mDX.PG(dxy);
                    j.this.mDW.a(null, true);
                    return;
                }
                TiebaStatic.log(new ap("c12164"));
                j.this.mDW.dxz();
            }
        }
    };
    private TextWatcher mEb = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.mDW.dxq();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.iFa != null) {
                if (!j.this.iFa.duc()) {
                    j.this.ww(false);
                }
                j.this.iFa.wj(false);
            }
        }
    };
    private DialogInterface.OnCancelListener mEc = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.mDY != null) {
                j.this.mDY.ceq();
            }
        }
    };
    private a.InterfaceC0782a mtA = new a.InterfaceC0782a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0782a
        public void onError() {
            j.this.fw(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0782a
        public void t(List<SimpleForum> list, int i) {
            j.this.fw(list);
        }
    };
    private a.InterfaceC0021a fBG = new a.InterfaceC0021a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0021a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            j.this.mDW.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.iFa.aZ(null);
                j.this.iFa.wi(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.f(j.this.dVN.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.dVN.getPageActivity().setResult(-1, intent);
                    j.this.dVN.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.dVN.showToast(postWriteCallBackData.getErrorString());
                    j.this.iFa.aZ(postWriteCallBackData.getSensitiveWords());
                    j.this.iFa.Py(postWriteCallBackData.getErrorString());
                    if (!x.isEmpty(j.this.iFa.dtZ())) {
                        j.this.ww(true);
                    }
                } else if ((adVar == null || writeData == null || adVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.mDW.l(postWriteCallBackData);
                } else if (adVar != null && writeData != null && adVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(adVar.getVcode_md5());
                    writeData.setVcodeUrl(adVar.getVcode_pic_url());
                    writeData.setVcodeExtra(adVar.bep());
                    if (!com.baidu.tbadk.t.a.Ay(adVar.beo())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(j.this.dVN.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(j.this.dVN.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, adVar.beo())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(j.this.dVN.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.mDZ = null;
        this.dVN = tbPageContext;
        this.mDW = kVar;
        this.mDX = aVar;
        this.mDR = writeUrlModel;
        this.mDW.al(this.mClickListener);
        this.mDW.am(this.mEa);
        this.mDW.e(this.mEb);
        dxl();
        this.mDZ = new com.baidu.tbadk.core.view.a(this.dVN);
        this.mDZ.setCancelListener(this.mEc);
        dxj();
        this.mDR.b(this.eCe);
        this.iFa = new com.baidu.tieba.write.c();
        this.iFa.GV(R.color.cp_cont_a);
        this.iFa.GW(R.color.cp_cont_h_alpha85);
    }

    private void dxj() {
        this.mDY = new com.baidu.tieba.write.transmit.model.a(this.dVN.getUniqueId());
        this.mDY.a(this.mtA);
        if (this.mDR.dhF() != null) {
            this.mDY.setForumId(this.mDR.dhF().getForumId());
        }
    }

    protected void dxk() {
        this.mDW.dxx();
    }

    protected void dxl() {
        this.mDW.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw(List<SimpleForum> list) {
        WriteData dhF = this.mDR.dhF();
        if (dhF != null) {
            this.mDZ.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(dhF.getForumId()) && !dhF.getForumId().equals("0") && !StringUtils.isNull(dhF.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(dhF.getForumId(), 0L), dhF.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (x.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(dhF.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.dVN.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void dlQ() {
        if (com.baidu.tbadk.core.util.ad.checkLocationForBaiduLocation(this.dVN.getPageActivity())) {
            com.baidu.adp.lib.c.a.kG().a(true, this.fBG);
        }
    }

    public void destroy() {
        if (this.mDY != null) {
            this.mDY.destroy();
        }
        if (this.mDX != null) {
            this.mDX.destroy();
        }
        if (this.mDR != null) {
            this.mDR.cancelLoadData();
        }
    }

    public void bSM() {
        this.mDY.setThreadContent(this.mDW.dxr());
        this.mDY.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ww(boolean z) {
        if (this.mDW.dxt() != null && this.mDW.dxr() != null) {
            int selectionEnd = this.mDW.dxt().getSelectionEnd();
            SpannableStringBuilder d = this.iFa.d(this.mDW.dxt().getText());
            if (d != null) {
                this.iFa.wj(true);
                this.mDW.dxt().setText(d);
                if (z && this.iFa.dua() >= 0) {
                    this.mDW.dxt().requestFocus();
                    this.mDW.dxt().setSelection(this.iFa.dua());
                } else {
                    this.mDW.dxt().setSelection(selectionEnd);
                }
                this.iFa.wi(this.iFa.dua() >= 0);
            }
        }
    }

    public boolean dxm() {
        if (this.iFa.dub()) {
            this.dVN.showToast(this.iFa.dud());
            ww(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.iFa.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData dhF;
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
                    this.dVN.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (dhF = this.mDR.dhF()) != null && this.mDX.duS() != null) {
                if (intent != null) {
                    dhF.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                dhF.setForumId("0");
                dhF.setCanNoForum(true);
                dhF.setRecommendExt(this.mDY.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    dxn();
                } else if (com.baidu.tbadk.core.util.ad.checkLocationForBaiduLocation(this.dVN.getPageActivity())) {
                    com.baidu.adp.lib.c.a.kG().a(true, new a.InterfaceC0021a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0021a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.dxn();
                        }
                    });
                }
                this.mDW.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.dVN.showToast(postWriteCallBackData.getErrorString());
                        this.iFa.aZ(postWriteCallBackData.getSensitiveWords());
                        if (!x.isEmpty(this.iFa.dtZ())) {
                            ww(true);
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

    public void dxn() {
        this.mDR.e("", this.mDW.dxr(), this.mDX.duS().linkUrl, this.mDX.duS().linkUrlCode, this.mLat, this.mLng);
    }
}
