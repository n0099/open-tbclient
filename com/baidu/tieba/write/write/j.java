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
    private static final Pattern kUA = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext cVg;
    public com.baidu.tieba.write.c hgO;
    private k kUB;
    private com.baidu.tieba.write.model.a kUC;
    private com.baidu.tieba.write.transmit.model.a kUD;
    private com.baidu.tbadk.core.view.a kUE;
    private WriteUrlModel kUw;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.cWN();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.cWM();
                }
            }
        }
    };
    private View.OnClickListener kUF = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new an("c12163"));
                String cXa = j.this.kUB.cXa();
                if (j.kUA.matcher(cXa).matches()) {
                    j.this.cWM();
                    j.this.kUC.KR(cXa);
                    j.this.kUB.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.kUB.cXb();
            }
        }
    };
    private TextWatcher kUG = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.kUB.cWS();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.hgO != null) {
                if (!j.this.hgO.cUd()) {
                    j.this.tP(false);
                }
                j.this.hgO.tH(false);
            }
        }
    };
    private DialogInterface.OnCancelListener kUH = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.kUD != null) {
                j.this.kUD.bGt();
            }
        }
    };
    private a.InterfaceC0634a kLu = new a.InterfaceC0634a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0634a
        public void onError() {
            j.this.eC(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0634a
        public void b(List<SimpleForum> list, int i) {
            j.this.eC(list);
        }
    };
    private a.InterfaceC0016a euh = new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d dyz = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            j.this.kUB.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.hgO.aU(null);
                j.this.hgO.tG(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(j.this.cVg.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.cVg.getPageActivity().setResult(-1, intent);
                    j.this.cVg.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.cVg.showToast(postWriteCallBackData.getErrorString());
                    j.this.hgO.aU(postWriteCallBackData.getSensitiveWords());
                    j.this.hgO.KK(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(j.this.hgO.cUa())) {
                        j.this.tP(true);
                    }
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.kUB.l(postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJE());
                    if (!com.baidu.tbadk.s.a.wa(aaVar.aJD())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(j.this.cVg.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(j.this.cVg.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJD())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(j.this.cVg.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.kUE = null;
        this.cVg = tbPageContext;
        this.kUB = kVar;
        this.kUC = aVar;
        this.kUw = writeUrlModel;
        this.kUB.ag(this.mClickListener);
        this.kUB.ah(this.kUF);
        this.kUB.f(this.kUG);
        cWN();
        this.kUE = new com.baidu.tbadk.core.view.a(this.cVg);
        this.kUE.setCancelListener(this.kUH);
        cWL();
        this.kUw.b(this.dyz);
        this.hgO = new com.baidu.tieba.write.c();
        this.hgO.DZ(R.color.cp_cont_a);
        this.hgO.Ea(R.color.cp_cont_h_alpha85);
    }

    private void cWL() {
        this.kUD = new com.baidu.tieba.write.transmit.model.a(this.cVg.getUniqueId());
        this.kUD.a(this.kLu);
        if (this.kUw.cHS() != null) {
            this.kUD.setForumId(this.kUw.cHS().getForumId());
        }
    }

    protected void cWM() {
        this.kUB.cWZ();
    }

    protected void cWN() {
        this.kUB.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC(List<SimpleForum> list) {
        WriteData cHS = this.kUw.cHS();
        if (cHS != null) {
            this.kUE.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cHS.getForumId()) && !cHS.getForumId().equals("0") && !StringUtils.isNull(cHS.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cHS.getForumId(), 0L), cHS.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cHS.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.cVg.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void cLH() {
        if (ab.checkLocationForBaiduLocation(this.cVg.getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, this.euh);
        }
    }

    public void destroy() {
        if (this.kUD != null) {
            this.kUD.destroy();
        }
        if (this.kUC != null) {
            this.kUC.destroy();
        }
        if (this.kUw != null) {
            this.kUw.cancelLoadData();
        }
    }

    public void bwd() {
        this.kUD.setThreadContent(this.kUB.cWT());
        this.kUD.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(boolean z) {
        if (this.kUB.cWV() != null && this.kUB.cWT() != null) {
            int selectionEnd = this.kUB.cWV().getSelectionEnd();
            SpannableStringBuilder a = this.hgO.a(this.kUB.cWV().getText());
            if (a != null) {
                this.hgO.tH(true);
                this.kUB.cWV().setText(a);
                if (z && this.hgO.cUb() >= 0) {
                    this.kUB.cWV().requestFocus();
                    this.kUB.cWV().setSelection(this.hgO.cUb());
                } else {
                    this.kUB.cWV().setSelection(selectionEnd);
                }
                this.hgO.tG(this.hgO.cUb() >= 0);
            }
        }
    }

    public boolean cWO() {
        if (this.hgO.cUc()) {
            this.cVg.showToast(this.hgO.cUe());
            tP(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.hgO.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cHS;
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
                    this.cVg.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cHS = this.kUw.cHS()) != null && this.kUC.cUQ() != null) {
                if (intent != null) {
                    cHS.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cHS.setForumId("0");
                cHS.setCanNoForum(true);
                cHS.setRecommendExt(this.kUD.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    cWP();
                } else if (ab.checkLocationForBaiduLocation(this.cVg.getPageActivity())) {
                    com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.cWP();
                        }
                    });
                }
                this.kUB.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.cVg.showToast(postWriteCallBackData.getErrorString());
                        this.hgO.aU(postWriteCallBackData.getSensitiveWords());
                        if (!v.isEmpty(this.hgO.cUa())) {
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

    public void cWP() {
        this.kUw.e("", this.kUB.cWT(), this.kUC.cUQ().linkUrl, this.kUC.cUQ().linkUrlCode, this.mLat, this.mLng);
    }
}
