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
import com.baidu.tbadk.core.util.ar;
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
    private static final Pattern nQF = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext eGu;
    public com.baidu.tieba.write.c jKS;
    public String mLat;
    public String mLng;
    private WriteUrlModel nQB;
    private m nQG;
    private com.baidu.tieba.write.model.a nQH;
    private com.baidu.tieba.write.transmit.model.a nQI;
    private com.baidu.tbadk.core.view.a nQJ;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    l.this.dWz();
                    TiebaStatic.log(new ar("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    l.this.dWy();
                }
            }
        }
    };
    private View.OnClickListener nQK = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.l.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new ar("c12163"));
                String dWM = l.this.nQG.dWM();
                if (l.nQF.matcher(dWM).matches()) {
                    l.this.dWy();
                    l.this.nQH.Ut(dWM);
                    l.this.nQG.a(null, true);
                    return;
                }
                TiebaStatic.log(new ar("c12164"));
                l.this.nQG.dWN();
            }
        }
    };
    private TextWatcher nQL = new TextWatcher() { // from class: com.baidu.tieba.write.write.l.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            l.this.nQG.dWE();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (l.this.jKS != null) {
                if (!l.this.jKS.dSV()) {
                    l.this.yK(false);
                }
                l.this.jKS.yx(false);
            }
        }
    };
    private DialogInterface.OnCancelListener nQM = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.l.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (l.this.nQI != null) {
                l.this.nQI.cAQ();
            }
        }
    };
    private a.InterfaceC0883a nFq = new a.InterfaceC0883a() { // from class: com.baidu.tieba.write.write.l.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0883a
        public void onError() {
            l.this.gi(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0883a
        public void t(List<SimpleForum> list, int i) {
            l.this.gi(list);
        }
    };
    private a.InterfaceC0020a gsg = new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.l.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                l.this.mLat = String.valueOf(address.getLatitude());
                l.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d fpd = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.l.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            l.this.nQG.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                l.this.jKS.bl(null);
                l.this.jKS.yw(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (l.this.g(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(l.this.eGu.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    l.this.eGu.getPageActivity().setResult(-1, intent);
                    l.this.eGu.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    l.this.eGu.showToast(postWriteCallBackData.getErrorString());
                    l.this.jKS.bl(postWriteCallBackData.getSensitiveWords());
                    l.this.jKS.Ul(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(l.this.jKS.dSS())) {
                        l.this.yK(true);
                    }
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    l.this.nQG.n(postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bum());
                    if (!com.baidu.tbadk.t.a.Ef(ahVar.bul())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(l.this.eGu.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(l.this.eGu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bul())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(l.this.eGu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public l(TbPageContext tbPageContext, m mVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.nQJ = null;
        this.eGu = tbPageContext;
        this.nQG = mVar;
        this.nQH = aVar;
        this.nQB = writeUrlModel;
        this.nQG.an(this.mClickListener);
        this.nQG.ao(this.nQK);
        this.nQG.e(this.nQL);
        dWz();
        this.nQJ = new com.baidu.tbadk.core.view.a(this.eGu);
        this.nQJ.setCancelListener(this.nQM);
        dWx();
        this.nQB.b(this.fpd);
        this.jKS = new com.baidu.tieba.write.c();
        this.jKS.LJ(R.color.CAM_X0101);
        this.jKS.LK(R.color.cp_cont_h_alpha85);
    }

    private void dWx() {
        this.nQI = new com.baidu.tieba.write.transmit.model.a(this.eGu.getUniqueId());
        this.nQI.a(this.nFq);
        if (this.nQB.cXs() != null) {
            this.nQI.setForumId(this.nQB.cXs().getForumId());
        }
    }

    protected void dWy() {
        this.nQG.dWL();
    }

    protected void dWz() {
        this.nQG.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi(List<SimpleForum> list) {
        WriteData cXs = this.nQB.cXs();
        if (cXs != null) {
            this.nQJ.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cXs.getForumId()) && !cXs.getForumId().equals("0") && !StringUtils.isNull(cXs.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cXs.getForumId(), 0L), cXs.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (y.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cXs.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.eGu.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void dKE() {
        if (ae.checkLocationForBaiduLocation(this.eGu.getPageActivity())) {
            com.baidu.adp.lib.c.a.mk().a(true, this.gsg);
        }
    }

    public void destroy() {
        if (this.nQI != null) {
            this.nQI.destroy();
        }
        if (this.nQH != null) {
            this.nQH.destroy();
        }
        if (this.nQB != null) {
            this.nQB.cancelLoadData();
        }
    }

    public void coT() {
        this.nQI.setThreadContent(this.nQG.dWF());
        this.nQI.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yK(boolean z) {
        if (this.nQG.dWH() != null && this.nQG.dWF() != null) {
            int selectionEnd = this.nQG.dWH().getSelectionEnd();
            SpannableStringBuilder c = this.jKS.c(this.nQG.dWH().getText());
            if (c != null) {
                this.jKS.yx(true);
                this.nQG.dWH().setText(c);
                if (z && this.jKS.dST() >= 0) {
                    this.nQG.dWH().requestFocus();
                    this.nQG.dWH().setSelection(this.jKS.dST());
                } else {
                    this.nQG.dWH().setSelection(selectionEnd);
                }
                this.jKS.yw(this.jKS.dST() >= 0);
            }
        }
    }

    public boolean dWA() {
        if (this.jKS.dSU()) {
            this.eGu.showToast(this.jKS.dSW());
            yK(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.jKS.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cXs;
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
                    this.eGu.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cXs = this.nQB.cXs()) != null && this.nQH.dTK() != null) {
                if (intent != null) {
                    cXs.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cXs.setForumId("0");
                cXs.setCanNoForum(true);
                cXs.setRecommendExt(this.nQI.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    dWB();
                } else if (ae.checkLocationForBaiduLocation(this.eGu.getPageActivity())) {
                    com.baidu.adp.lib.c.a.mk().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.write.l.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                l.this.mLat = String.valueOf(address.getLatitude());
                                l.this.mLng = String.valueOf(address.getLongitude());
                            }
                            l.this.dWB();
                        }
                    });
                }
                this.nQG.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.eGu.showToast(postWriteCallBackData.getErrorString());
                        this.jKS.bl(postWriteCallBackData.getSensitiveWords());
                        if (!y.isEmpty(this.jKS.dSS())) {
                            yK(true);
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

    public void dWB() {
        this.nQB.h("", this.nQG.dWF(), this.nQH.dTK().linkUrl, this.nQH.dTK().linkUrlCode, this.mLat, this.mLng);
    }
}
