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
import com.baidu.tbadk.coreExtra.data.z;
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
/* loaded from: classes11.dex */
public class j {
    private static final Pattern kTP = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext cRe;
    public com.baidu.tieba.write.c heO;
    private WriteUrlModel kTL;
    private k kTQ;
    private com.baidu.tieba.write.model.a kTR;
    private com.baidu.tieba.write.transmit.model.a kTS;
    private com.baidu.tbadk.core.view.a kTT;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.cVx();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.cVw();
                }
            }
        }
    };
    private View.OnClickListener kTU = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new an("c12163"));
                String cVK = j.this.kTQ.cVK();
                if (j.kTP.matcher(cVK).matches()) {
                    j.this.cVw();
                    j.this.kTR.KE(cVK);
                    j.this.kTQ.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.kTQ.cVL();
            }
        }
    };
    private TextWatcher kTV = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.kTQ.cVC();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.heO != null) {
                if (!j.this.heO.cSN()) {
                    j.this.tL(false);
                }
                j.this.heO.tD(false);
            }
        }
    };
    private DialogInterface.OnCancelListener kTW = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.kTS != null) {
                j.this.kTS.bER();
            }
        }
    };
    private a.InterfaceC0626a kKJ = new a.InterfaceC0626a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0626a
        public void onError() {
            j.this.eH(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0626a
        public void b(List<SimpleForum> list, int i) {
            j.this.eH(list);
        }
    };
    private a.InterfaceC0016a epW = new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
        public void onLocationGeted(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d dut = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
            j.this.kTQ.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.heO.aV(null);
                j.this.heO.tC(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.e(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.g(j.this.cRe.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.cRe.getPageActivity().setResult(-1, intent);
                    j.this.cRe.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.cRe.showToast(postWriteCallBackData.getErrorString());
                    j.this.heO.aV(postWriteCallBackData.getSensitiveWords());
                    j.this.heO.Kx(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(j.this.heO.cSK())) {
                        j.this.tL(true);
                    }
                } else if ((zVar == null || writeData == null || zVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.kTQ.l(postWriteCallBackData);
                } else if (zVar != null && writeData != null && zVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(zVar.getVcode_md5());
                    writeData.setVcodeUrl(zVar.getVcode_pic_url());
                    writeData.setVcodeExtra(zVar.aHl());
                    if (!com.baidu.tbadk.s.a.vG(zVar.aHk())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(j.this.cRe.getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(j.this.cRe.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, zVar.aHk())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(j.this.cRe.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.kTT = null;
        this.cRe = tbPageContext;
        this.kTQ = kVar;
        this.kTR = aVar;
        this.kTL = writeUrlModel;
        this.kTQ.ag(this.mClickListener);
        this.kTQ.ah(this.kTU);
        this.kTQ.f(this.kTV);
        cVx();
        this.kTT = new com.baidu.tbadk.core.view.a(this.cRe);
        this.kTT.setCancelListener(this.kTW);
        cVv();
        this.kTL.b(this.dut);
        this.heO = new com.baidu.tieba.write.c();
        this.heO.DU(R.color.cp_cont_a);
        this.heO.DV(R.color.cp_cont_h_alpha85);
    }

    private void cVv() {
        this.kTS = new com.baidu.tieba.write.transmit.model.a(this.cRe.getUniqueId());
        this.kTS.a(this.kKJ);
        if (this.kTL.cGm() != null) {
            this.kTS.setForumId(this.kTL.cGm().getForumId());
        }
    }

    protected void cVw() {
        this.kTQ.cVJ();
    }

    protected void cVx() {
        this.kTQ.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(List<SimpleForum> list) {
        WriteData cGm = this.kTL.cGm();
        if (cGm != null) {
            this.kTT.setDialogVisiable(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(cGm.getForumId()) && !cGm.getForumId().equals("0") && !StringUtils.isNull(cGm.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.f.b.toLong(cGm.getForumId(), 0L), cGm.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.getCount(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.f.b.toLong(cGm.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.cRe.getPageActivity(), RequestResponseCode.REQUEST_SELECT_TRANSMIT_FORUM);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void cKh() {
        if (ab.checkLocationForBaiduLocation(this.cRe.getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, this.epW);
        }
    }

    public void destroy() {
        if (this.kTS != null) {
            this.kTS.destroy();
        }
        if (this.kTR != null) {
            this.kTR.destroy();
        }
        if (this.kTL != null) {
            this.kTL.cancelLoadData();
        }
    }

    public void buz() {
        this.kTS.setThreadContent(this.kTQ.cVD());
        this.kTS.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tL(boolean z) {
        if (this.kTQ.cVF() != null && this.kTQ.cVD() != null) {
            int selectionEnd = this.kTQ.cVF().getSelectionEnd();
            SpannableStringBuilder a = this.heO.a(this.kTQ.cVF().getText());
            if (a != null) {
                this.heO.tD(true);
                this.kTQ.cVF().setText(a);
                if (z && this.heO.cSL() >= 0) {
                    this.kTQ.cVF().requestFocus();
                    this.kTQ.cVF().setSelection(this.heO.cSL());
                } else {
                    this.kTQ.cVF().setSelection(selectionEnd);
                }
                this.heO.tC(this.heO.cSL() >= 0);
            }
        }
    }

    public boolean cVy() {
        if (this.heO.cSM()) {
            this.cRe.showToast(this.heO.cSO());
            tL(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.heO.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData cGm;
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
                    this.cRe.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (cGm = this.kTL.cGm()) != null && this.kTR.cTA() != null) {
                if (intent != null) {
                    cGm.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                cGm.setForumId("0");
                cGm.setCanNoForum(true);
                cGm.setRecommendExt(this.kTS.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    cVz();
                } else if (ab.checkLocationForBaiduLocation(this.cRe.getPageActivity())) {
                    com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                        public void onLocationGeted(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.cVz();
                        }
                    });
                }
                this.kTQ.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.cRe.showToast(postWriteCallBackData.getErrorString());
                        this.heO.aV(postWriteCallBackData.getSensitiveWords());
                        if (!v.isEmpty(this.heO.cSK())) {
                            tL(true);
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

    public void cVz() {
        this.kTL.e("", this.kTQ.cVD(), this.kTR.cTA().linkUrl, this.kTR.cTA().linkUrlCode, this.mLat, this.mLng);
    }
}
