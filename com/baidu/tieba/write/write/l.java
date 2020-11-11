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
    private static final Pattern nPc = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext eIc;
    public com.baidu.tieba.write.c jKh;
    public String mLat;
    public String mLng;
    private WriteUrlModel nOY;
    private m nPd;
    private com.baidu.tieba.write.model.a nPe;
    private com.baidu.tieba.write.transmit.model.a nPf;
    private com.baidu.tbadk.core.view.a nPg;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    l.this.dWA();
                    TiebaStatic.log(new aq("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    l.this.dWz();
                }
            }
        }
    };
    private View.OnClickListener nPh = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new aq("c12163"));
                String dWN = l.this.nPd.dWN();
                if (l.nPc.matcher(dWN).matches()) {
                    l.this.dWz();
                    l.this.nPe.UI(dWN);
                    l.this.nPd.a(null, true);
                    return;
                }
                TiebaStatic.log(new aq("c12164"));
                l.this.nPd.dWO();
            }
        }
    };
    private TextWatcher nPi = new TextWatcher() { // from class: com.baidu.tieba.write.write.l.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            l.this.nPd.dWF();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (l.this.jKh != null) {
                if (!l.this.jKh.dSW()) {
                    l.this.yD(false);
                }
                l.this.jKh.yq(false);
            }
        }
    };
    private DialogInterface.OnCancelListener nPj = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.l.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (l.this.nPf != null) {
                l.this.nPf.cBn();
            }
        }
    };
    private a.InterfaceC0880a nDT = new a.InterfaceC0880a() { // from class: com.baidu.tieba.write.write.l.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0880a
        public void onError() {
            l.this.gi(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0880a
        public void t(List<SimpleForum> list, int i) {
            l.this.gi(list);
        }
    };
    private a.InterfaceC0020a gsz = new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.l.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                l.this.mLat = String.valueOf(address.getLatitude());
                l.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.l.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            l.this.nPd.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                l.this.jKh.bk(null);
                l.this.jKh.yp(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (l.this.g(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(l.this.eIc.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    l.this.eIc.getPageActivity().setResult(-1, intent);
                    l.this.eIc.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    l.this.eIc.showToast(postWriteCallBackData.getErrorString());
                    l.this.jKh.bk(postWriteCallBackData.getSensitiveWords());
                    l.this.jKh.UA(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(l.this.jKh.dST())) {
                        l.this.yD(true);
                    }
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    l.this.nPd.n(postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.buW());
                    if (!com.baidu.tbadk.t.a.EE(ahVar.buV())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(l.this.eIc.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(l.this.eIc.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.buV())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(l.this.eIc.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public l(TbPageContext tbPageContext, m mVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.nPg = null;
        this.eIc = tbPageContext;
        this.nPd = mVar;
        this.nPe = aVar;
        this.nOY = writeUrlModel;
        this.nPd.an(this.mClickListener);
        this.nPd.ao(this.nPh);
        this.nPd.e(this.nPi);
        dWA();
        this.nPg = new com.baidu.tbadk.core.view.a(this.eIc);
        this.nPg.setCancelListener(this.nPj);
        dWy();
        this.nOY.b(this.fpW);
        this.jKh = new com.baidu.tieba.write.c();
        this.jKh.Lg(R.color.cp_cont_a);
        this.jKh.Lh(R.color.cp_cont_h_alpha85);
    }

    private void dWy() {
        this.nPf = new com.baidu.tieba.write.transmit.model.a(this.eIc.getUniqueId());
        this.nPf.a(this.nDT);
        if (this.nOY.cXW() != null) {
            this.nPf.setForumId(this.nOY.cXW().getForumId());
        }
    }

    protected void dWz() {
        this.nPd.dWM();
    }

    protected void dWA() {
        this.nPd.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi(List<SimpleForum> list) {
        WriteData cXW = this.nOY.cXW();
        if (cXW != null) {
            this.nPg.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cXW.getForumId()) && !cXW.getForumId().equals("0") && !StringUtils.isNull(cXW.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cXW.getForumId(), 0L), cXW.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (y.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cXW.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.eIc.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void dKF() {
        if (ae.checkLocationForBaiduLocation(this.eIc.getPageActivity())) {
            com.baidu.adp.lib.c.a.mk().a(true, this.gsz);
        }
    }

    public void destroy() {
        if (this.nPf != null) {
            this.nPf.destroy();
        }
        if (this.nPe != null) {
            this.nPe.destroy();
        }
        if (this.nOY != null) {
            this.nOY.cancelLoadData();
        }
    }

    public void cps() {
        this.nPf.setThreadContent(this.nPd.dWG());
        this.nPf.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD(boolean z) {
        if (this.nPd.dWI() != null && this.nPd.dWG() != null) {
            int selectionEnd = this.nPd.dWI().getSelectionEnd();
            SpannableStringBuilder c = this.jKh.c(this.nPd.dWI().getText());
            if (c != null) {
                this.jKh.yq(true);
                this.nPd.dWI().setText(c);
                if (z && this.jKh.dSU() >= 0) {
                    this.nPd.dWI().requestFocus();
                    this.nPd.dWI().setSelection(this.jKh.dSU());
                } else {
                    this.nPd.dWI().setSelection(selectionEnd);
                }
                this.jKh.yp(this.jKh.dSU() >= 0);
            }
        }
    }

    public boolean dWB() {
        if (this.jKh.dSV()) {
            this.eIc.showToast(this.jKh.dSX());
            yD(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.jKh.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cXW;
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
                    this.eIc.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cXW = this.nOY.cXW()) != null && this.nPe.dTL() != null) {
                if (intent != null) {
                    cXW.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cXW.setForumId("0");
                cXW.setCanNoForum(true);
                cXW.setRecommendExt(this.nPf.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    dWC();
                } else if (ae.checkLocationForBaiduLocation(this.eIc.getPageActivity())) {
                    com.baidu.adp.lib.c.a.mk().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.l.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                l.this.mLat = String.valueOf(address.getLatitude());
                                l.this.mLng = String.valueOf(address.getLongitude());
                            }
                            l.this.dWC();
                        }
                    });
                }
                this.nPd.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.eIc.showToast(postWriteCallBackData.getErrorString());
                        this.jKh.bk(postWriteCallBackData.getSensitiveWords());
                        if (!y.isEmpty(this.jKh.dST())) {
                            yD(true);
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

    public void dWC() {
        this.nOY.h("", this.nPd.dWG(), this.nPe.dTL().linkUrl, this.nPe.dTL().linkUrlCode, this.mLat, this.mLng);
    }
}
