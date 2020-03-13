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
    private static final Pattern kUO = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext cVi;
    public com.baidu.tieba.write.c hhc;
    private WriteUrlModel kUK;
    private k kUP;
    private com.baidu.tieba.write.model.a kUQ;
    private com.baidu.tieba.write.transmit.model.a kUR;
    private com.baidu.tbadk.core.view.a kUS;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.cWQ();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.cWP();
                }
            }
        }
    };
    private View.OnClickListener kUT = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new an("c12163"));
                String cXd = j.this.kUP.cXd();
                if (j.kUO.matcher(cXd).matches()) {
                    j.this.cWP();
                    j.this.kUQ.KS(cXd);
                    j.this.kUP.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.kUP.cXe();
            }
        }
    };
    private TextWatcher kUU = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.kUP.cWV();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.hhc != null) {
                if (!j.this.hhc.cUg()) {
                    j.this.tP(false);
                }
                j.this.hhc.tH(false);
            }
        }
    };
    private DialogInterface.OnCancelListener kUV = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.kUR != null) {
                j.this.kUR.bGw();
            }
        }
    };
    private a.InterfaceC0634a kLI = new a.InterfaceC0634a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0634a
        public void onError() {
            j.this.eC(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0634a
        public void b(List<SimpleForum> list, int i) {
            j.this.eC(list);
        }
    };
    private a.InterfaceC0016a euv = new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d dyN = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            j.this.kUP.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.hhc.aU(null);
                j.this.hhc.tG(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(j.this.cVi.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.cVi.getPageActivity().setResult(-1, intent);
                    j.this.cVi.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.cVi.showToast(postWriteCallBackData.getErrorString());
                    j.this.hhc.aU(postWriteCallBackData.getSensitiveWords());
                    j.this.hhc.KL(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(j.this.hhc.cUd())) {
                        j.this.tP(true);
                    }
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.kUP.l(postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJH());
                    if (!com.baidu.tbadk.s.a.wb(aaVar.aJG())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(j.this.cVi.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(j.this.cVi.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJG())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(j.this.cVi.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.kUS = null;
        this.cVi = tbPageContext;
        this.kUP = kVar;
        this.kUQ = aVar;
        this.kUK = writeUrlModel;
        this.kUP.ag(this.mClickListener);
        this.kUP.ah(this.kUT);
        this.kUP.f(this.kUU);
        cWQ();
        this.kUS = new com.baidu.tbadk.core.view.a(this.cVi);
        this.kUS.setCancelListener(this.kUV);
        cWO();
        this.kUK.b(this.dyN);
        this.hhc = new com.baidu.tieba.write.c();
        this.hhc.DZ(R.color.cp_cont_a);
        this.hhc.Ea(R.color.cp_cont_h_alpha85);
    }

    private void cWO() {
        this.kUR = new com.baidu.tieba.write.transmit.model.a(this.cVi.getUniqueId());
        this.kUR.a(this.kLI);
        if (this.kUK.cHV() != null) {
            this.kUR.setForumId(this.kUK.cHV().getForumId());
        }
    }

    protected void cWP() {
        this.kUP.cXc();
    }

    protected void cWQ() {
        this.kUP.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC(List<SimpleForum> list) {
        WriteData cHV = this.kUK.cHV();
        if (cHV != null) {
            this.kUS.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cHV.getForumId()) && !cHV.getForumId().equals("0") && !StringUtils.isNull(cHV.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cHV.getForumId(), 0L), cHV.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cHV.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.cVi.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void cLK() {
        if (ab.checkLocationForBaiduLocation(this.cVi.getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, this.euv);
        }
    }

    public void destroy() {
        if (this.kUR != null) {
            this.kUR.destroy();
        }
        if (this.kUQ != null) {
            this.kUQ.destroy();
        }
        if (this.kUK != null) {
            this.kUK.cancelLoadData();
        }
    }

    public void bwg() {
        this.kUR.setThreadContent(this.kUP.cWW());
        this.kUR.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(boolean z) {
        if (this.kUP.cWY() != null && this.kUP.cWW() != null) {
            int selectionEnd = this.kUP.cWY().getSelectionEnd();
            SpannableStringBuilder a = this.hhc.a(this.kUP.cWY().getText());
            if (a != null) {
                this.hhc.tH(true);
                this.kUP.cWY().setText(a);
                if (z && this.hhc.cUe() >= 0) {
                    this.kUP.cWY().requestFocus();
                    this.kUP.cWY().setSelection(this.hhc.cUe());
                } else {
                    this.kUP.cWY().setSelection(selectionEnd);
                }
                this.hhc.tG(this.hhc.cUe() >= 0);
            }
        }
    }

    public boolean cWR() {
        if (this.hhc.cUf()) {
            this.cVi.showToast(this.hhc.cUh());
            tP(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.hhc.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cHV;
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
                    this.cVi.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cHV = this.kUK.cHV()) != null && this.kUQ.cUT() != null) {
                if (intent != null) {
                    cHV.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cHV.setForumId("0");
                cHV.setCanNoForum(true);
                cHV.setRecommendExt(this.kUR.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    cWS();
                } else if (ab.checkLocationForBaiduLocation(this.cVi.getPageActivity())) {
                    com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.cWS();
                        }
                    });
                }
                this.kUP.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.cVi.showToast(postWriteCallBackData.getErrorString());
                        this.hhc.aU(postWriteCallBackData.getSensitiveWords());
                        if (!v.isEmpty(this.hhc.cUd())) {
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

    public void cWS() {
        this.kUK.e("", this.kUP.cWW(), this.kUQ.cUT().linkUrl, this.kUQ.cUT().linkUrlCode, this.mLat, this.mLng);
    }
}
