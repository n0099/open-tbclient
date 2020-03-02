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
/* loaded from: classes13.dex */
public class j {
    private static final Pattern kUC = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext cVh;
    public com.baidu.tieba.write.c hgQ;
    private k kUD;
    private com.baidu.tieba.write.model.a kUE;
    private com.baidu.tieba.write.transmit.model.a kUF;
    private com.baidu.tbadk.core.view.a kUG;
    private WriteUrlModel kUy;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.cWP();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.cWO();
                }
            }
        }
    };
    private View.OnClickListener kUH = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new an("c12163"));
                String cXc = j.this.kUD.cXc();
                if (j.kUC.matcher(cXc).matches()) {
                    j.this.cWO();
                    j.this.kUE.KR(cXc);
                    j.this.kUD.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.kUD.cXd();
            }
        }
    };
    private TextWatcher kUI = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.kUD.cWU();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.hgQ != null) {
                if (!j.this.hgQ.cUf()) {
                    j.this.tP(false);
                }
                j.this.hgQ.tH(false);
            }
        }
    };
    private DialogInterface.OnCancelListener kUJ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.kUF != null) {
                j.this.kUF.bGv();
            }
        }
    };
    private a.InterfaceC0634a kLw = new a.InterfaceC0634a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0634a
        public void onError() {
            j.this.eC(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0634a
        public void b(List<SimpleForum> list, int i) {
            j.this.eC(list);
        }
    };
    private a.InterfaceC0016a eui = new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d dyA = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            j.this.kUD.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.hgQ.aU(null);
                j.this.hgQ.tG(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(j.this.cVh.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.cVh.getPageActivity().setResult(-1, intent);
                    j.this.cVh.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.cVh.showToast(postWriteCallBackData.getErrorString());
                    j.this.hgQ.aU(postWriteCallBackData.getSensitiveWords());
                    j.this.hgQ.KK(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(j.this.hgQ.cUc())) {
                        j.this.tP(true);
                    }
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.kUD.l(postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJG());
                    if (!com.baidu.tbadk.s.a.wa(aaVar.aJF())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(j.this.cVh.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(j.this.cVh.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJF())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(j.this.cVh.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.kUG = null;
        this.cVh = tbPageContext;
        this.kUD = kVar;
        this.kUE = aVar;
        this.kUy = writeUrlModel;
        this.kUD.ag(this.mClickListener);
        this.kUD.ah(this.kUH);
        this.kUD.f(this.kUI);
        cWP();
        this.kUG = new com.baidu.tbadk.core.view.a(this.cVh);
        this.kUG.setCancelListener(this.kUJ);
        cWN();
        this.kUy.b(this.dyA);
        this.hgQ = new com.baidu.tieba.write.c();
        this.hgQ.DZ(R.color.cp_cont_a);
        this.hgQ.Ea(R.color.cp_cont_h_alpha85);
    }

    private void cWN() {
        this.kUF = new com.baidu.tieba.write.transmit.model.a(this.cVh.getUniqueId());
        this.kUF.a(this.kLw);
        if (this.kUy.cHU() != null) {
            this.kUF.setForumId(this.kUy.cHU().getForumId());
        }
    }

    protected void cWO() {
        this.kUD.cXb();
    }

    protected void cWP() {
        this.kUD.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC(List<SimpleForum> list) {
        WriteData cHU = this.kUy.cHU();
        if (cHU != null) {
            this.kUG.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cHU.getForumId()) && !cHU.getForumId().equals("0") && !StringUtils.isNull(cHU.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cHU.getForumId(), 0L), cHU.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cHU.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.cVh.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void cLJ() {
        if (ab.checkLocationForBaiduLocation(this.cVh.getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, this.eui);
        }
    }

    public void destroy() {
        if (this.kUF != null) {
            this.kUF.destroy();
        }
        if (this.kUE != null) {
            this.kUE.destroy();
        }
        if (this.kUy != null) {
            this.kUy.cancelLoadData();
        }
    }

    public void bwf() {
        this.kUF.setThreadContent(this.kUD.cWV());
        this.kUF.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(boolean z) {
        if (this.kUD.cWX() != null && this.kUD.cWV() != null) {
            int selectionEnd = this.kUD.cWX().getSelectionEnd();
            SpannableStringBuilder a = this.hgQ.a(this.kUD.cWX().getText());
            if (a != null) {
                this.hgQ.tH(true);
                this.kUD.cWX().setText(a);
                if (z && this.hgQ.cUd() >= 0) {
                    this.kUD.cWX().requestFocus();
                    this.kUD.cWX().setSelection(this.hgQ.cUd());
                } else {
                    this.kUD.cWX().setSelection(selectionEnd);
                }
                this.hgQ.tG(this.hgQ.cUd() >= 0);
            }
        }
    }

    public boolean cWQ() {
        if (this.hgQ.cUe()) {
            this.cVh.showToast(this.hgQ.cUg());
            tP(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.hgQ.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cHU;
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
                    this.cVh.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cHU = this.kUy.cHU()) != null && this.kUE.cUS() != null) {
                if (intent != null) {
                    cHU.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cHU.setForumId("0");
                cHU.setCanNoForum(true);
                cHU.setRecommendExt(this.kUF.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    cWR();
                } else if (ab.checkLocationForBaiduLocation(this.cVh.getPageActivity())) {
                    com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.cWR();
                        }
                    });
                }
                this.kUD.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.cVh.showToast(postWriteCallBackData.getErrorString());
                        this.hgQ.aU(postWriteCallBackData.getSensitiveWords());
                        if (!v.isEmpty(this.hgQ.cUc())) {
                            tP(true);
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

    public void cWR() {
        this.kUy.e("", this.kUD.cWV(), this.kUE.cUS().linkUrl, this.kUE.cUS().linkUrlCode, this.mLat, this.mLng);
    }
}
