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
    private static final Pattern kWr = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext cVv;
    public com.baidu.tieba.write.c hiD;
    private WriteUrlModel kWn;
    private k kWs;
    private com.baidu.tieba.write.model.a kWt;
    private com.baidu.tieba.write.transmit.model.a kWu;
    private com.baidu.tbadk.core.view.a kWv;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.cXo();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.cXn();
                }
            }
        }
    };
    private View.OnClickListener kWw = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new an("c12163"));
                String cXB = j.this.kWs.cXB();
                if (j.kWr.matcher(cXB).matches()) {
                    j.this.cXn();
                    j.this.kWt.KS(cXB);
                    j.this.kWs.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.kWs.cXC();
            }
        }
    };
    private TextWatcher kWx = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.kWs.cXt();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.hiD != null) {
                if (!j.this.hiD.cUA()) {
                    j.this.tW(false);
                }
                j.this.hiD.tO(false);
            }
        }
    };
    private DialogInterface.OnCancelListener kWy = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.kWu != null) {
                j.this.kWu.bGI();
            }
        }
    };
    private a.InterfaceC0635a kNr = new a.InterfaceC0635a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0635a
        public void onError() {
            j.this.eC(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0635a
        public void b(List<SimpleForum> list, int i) {
            j.this.eC(list);
        }
    };
    private a.InterfaceC0016a euR = new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d dza = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            j.this.kWs.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.hiD.aU(null);
                j.this.hiD.tN(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(j.this.cVv.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.cVv.getPageActivity().setResult(-1, intent);
                    j.this.cVv.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.cVv.showToast(postWriteCallBackData.getErrorString());
                    j.this.hiD.aU(postWriteCallBackData.getSensitiveWords());
                    j.this.hiD.KL(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(j.this.hiD.cUx())) {
                        j.this.tW(true);
                    }
                } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.kWs.l(postWriteCallBackData);
                } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJL());
                    if (!com.baidu.tbadk.s.a.wc(aaVar.aJK())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(j.this.cVv.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(j.this.cVv.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJK())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(j.this.cVv.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.kWv = null;
        this.cVv = tbPageContext;
        this.kWs = kVar;
        this.kWt = aVar;
        this.kWn = writeUrlModel;
        this.kWs.ag(this.mClickListener);
        this.kWs.ah(this.kWw);
        this.kWs.f(this.kWx);
        cXo();
        this.kWv = new com.baidu.tbadk.core.view.a(this.cVv);
        this.kWv.setCancelListener(this.kWy);
        cXm();
        this.kWn.b(this.dza);
        this.hiD = new com.baidu.tieba.write.c();
        this.hiD.Eh(R.color.cp_cont_a);
        this.hiD.Ei(R.color.cp_cont_h_alpha85);
    }

    private void cXm() {
        this.kWu = new com.baidu.tieba.write.transmit.model.a(this.cVv.getUniqueId());
        this.kWu.a(this.kNr);
        if (this.kWn.cIp() != null) {
            this.kWu.setForumId(this.kWn.cIp().getForumId());
        }
    }

    protected void cXn() {
        this.kWs.cXA();
    }

    protected void cXo() {
        this.kWs.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC(List<SimpleForum> list) {
        WriteData cIp = this.kWn.cIp();
        if (cIp != null) {
            this.kWv.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cIp.getForumId()) && !cIp.getForumId().equals("0") && !StringUtils.isNull(cIp.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cIp.getForumId(), 0L), cIp.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cIp.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.cVv.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void cMe() {
        if (ab.checkLocationForBaiduLocation(this.cVv.getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, this.euR);
        }
    }

    public void destroy() {
        if (this.kWu != null) {
            this.kWu.destroy();
        }
        if (this.kWt != null) {
            this.kWt.destroy();
        }
        if (this.kWn != null) {
            this.kWn.cancelLoadData();
        }
    }

    public void bwl() {
        this.kWu.setThreadContent(this.kWs.cXu());
        this.kWu.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tW(boolean z) {
        if (this.kWs.cXw() != null && this.kWs.cXu() != null) {
            int selectionEnd = this.kWs.cXw().getSelectionEnd();
            SpannableStringBuilder a = this.hiD.a(this.kWs.cXw().getText());
            if (a != null) {
                this.hiD.tO(true);
                this.kWs.cXw().setText(a);
                if (z && this.hiD.cUy() >= 0) {
                    this.kWs.cXw().requestFocus();
                    this.kWs.cXw().setSelection(this.hiD.cUy());
                } else {
                    this.kWs.cXw().setSelection(selectionEnd);
                }
                this.hiD.tN(this.hiD.cUy() >= 0);
            }
        }
    }

    public boolean cXp() {
        if (this.hiD.cUz()) {
            this.cVv.showToast(this.hiD.cUB());
            tW(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.hiD.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cIp;
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
                    this.cVv.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cIp = this.kWn.cIp()) != null && this.kWt.cVo() != null) {
                if (intent != null) {
                    cIp.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cIp.setForumId("0");
                cIp.setCanNoForum(true);
                cIp.setRecommendExt(this.kWu.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    cXq();
                } else if (ab.checkLocationForBaiduLocation(this.cVv.getPageActivity())) {
                    com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.cXq();
                        }
                    });
                }
                this.kWs.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.cVv.showToast(postWriteCallBackData.getErrorString());
                        this.hiD.aU(postWriteCallBackData.getSensitiveWords());
                        if (!v.isEmpty(this.hiD.cUx())) {
                            tW(true);
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

    public void cXq() {
        this.kWn.e("", this.kWs.cXu(), this.kWt.cVo().linkUrl, this.kWt.cVo().linkUrlCode, this.mLat, this.mLng);
    }
}
