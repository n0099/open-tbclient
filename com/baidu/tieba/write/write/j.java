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
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tieba.d;
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
    private static final Pattern hiI = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext adf;
    public com.baidu.tieba.write.b ftR;
    private WriteUrlModel hiE;
    private k hiJ;
    private com.baidu.tieba.write.model.a hiK;
    private com.baidu.tieba.write.transmit.model.a hiL;
    private com.baidu.tbadk.core.view.a hiM;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != null && view2.getId() != 0) {
                if (view2.getId() == d.g.icon_invoke_link) {
                    j.this.bEc();
                    TiebaStatic.log(new al("c12169"));
                }
                if (view2.getId() == d.g.url_edit_back_view) {
                    j.this.bEb();
                }
            }
        }
    };
    private View.OnClickListener hiN = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != null && view2.getId() == d.g.url_add) {
                TiebaStatic.log(new al("c12163"));
                String bEp = j.this.hiJ.bEp();
                if (j.hiI.matcher(bEp).matches()) {
                    j.this.bEb();
                    j.this.hiK.uL(bEp);
                    j.this.hiJ.a(null, true);
                    return;
                }
                TiebaStatic.log(new al("c12164"));
                j.this.hiJ.bEq();
            }
        }
    };
    private TextWatcher hiO = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.hiJ.bEh();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.ftR != null) {
                if (!j.this.ftR.bAX()) {
                    j.this.ns(false);
                }
                j.this.ftR.nj(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hiP = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.hiL != null) {
                j.this.hiL.arg();
            }
        }
    };
    private a.InterfaceC0236a hae = new a.InterfaceC0236a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0236a
        public void onError() {
            j.this.dN(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0236a
        public void p(List<SimpleForum> list, int i) {
            j.this.dN(list);
        }
    };
    private a.InterfaceC0006a bqb = new a.InterfaceC0006a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0006a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d aEK = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            j.this.hiJ.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.ftR.ax(null);
                j.this.ftR.ni(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(j.this.adf.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.adf.getPageActivity().setResult(-1, intent);
                    j.this.adf.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.adf.showToast(postWriteCallBackData.getErrorString());
                    j.this.ftR.ax(postWriteCallBackData.getSensitiveWords());
                    j.this.ftR.uB(postWriteCallBackData.getErrorString());
                    if (!v.w(j.this.ftR.bAU())) {
                        j.this.ns(true);
                    }
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.hiJ.l(postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.yL());
                    if (!com.baidu.tbadk.p.a.hq(tVar.yK())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.adf.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.adf.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.yK())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.adf.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hiM = null;
        this.adf = tbPageContext;
        this.hiJ = kVar;
        this.hiK = aVar;
        this.hiE = writeUrlModel;
        this.hiJ.W(this.mClickListener);
        this.hiJ.X(this.hiN);
        this.hiJ.e(this.hiO);
        bEc();
        this.hiM = new com.baidu.tbadk.core.view.a(this.adf);
        this.hiM.d(this.hiP);
        bEa();
        this.hiE.b(this.aEK);
        this.ftR = new com.baidu.tieba.write.b();
        this.ftR.uK(d.C0126d.cp_cont_i);
        this.ftR.uL(d.C0126d.cp_cont_h_alpha85);
    }

    private void bEa() {
        this.hiL = new com.baidu.tieba.write.transmit.model.a(this.adf.getUniqueId());
        this.hiL.a(this.hae);
        if (this.hiE.getWriteData() != null) {
            this.hiL.setForumId(this.hiE.getWriteData().getForumId());
        }
    }

    protected void bEb() {
        this.hiJ.bEo();
    }

    protected void bEc() {
        this.hiJ.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dN(List<SimpleForum> list) {
        WriteData writeData = this.hiE.getWriteData();
        if (writeData != null) {
            this.hiM.aI(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.v(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.adf.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage(2002001, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bsG() {
        if (ab.aB(this.adf.getPageActivity())) {
            com.baidu.adp.lib.d.a.eK().a(true, this.bqb);
        }
    }

    public void destroy() {
        if (this.hiL != null) {
            this.hiL.destroy();
        }
        if (this.hiK != null) {
            this.hiK.destroy();
        }
        if (this.hiE != null) {
            this.hiE.cancelLoadData();
        }
    }

    public void ahc() {
        this.hiL.setThreadContent(this.hiJ.bEi());
        this.hiL.OT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ns(boolean z) {
        if (this.hiJ.bEk() != null && this.hiJ.bEi() != null) {
            int selectionEnd = this.hiJ.bEk().getSelectionEnd();
            SpannableStringBuilder b = this.ftR.b(this.hiJ.bEk().getText());
            if (b != null) {
                this.ftR.nj(true);
                this.hiJ.bEk().setText(b);
                if (z && this.ftR.bAV() >= 0) {
                    this.hiJ.bEk().requestFocus();
                    this.hiJ.bEk().setSelection(this.ftR.bAV());
                } else {
                    this.hiJ.bEk().setSelection(selectionEnd);
                }
                this.ftR.ni(this.ftR.bAV() >= 0);
            }
        }
    }

    public boolean bEd() {
        if (this.ftR.bAW()) {
            this.adf.showToast(this.ftR.bAY());
            ns(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.ftR.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData writeData;
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
                    this.adf.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.hiE.getWriteData()) != null && this.hiK.bCi() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hiL.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bEe();
                } else if (ab.aB(this.adf.getPageActivity())) {
                    com.baidu.adp.lib.d.a.eK().a(true, new a.InterfaceC0006a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0006a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.bEe();
                        }
                    });
                }
                this.hiJ.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.adf.showToast(postWriteCallBackData.getErrorString());
                        this.ftR.ax(postWriteCallBackData.getSensitiveWords());
                        if (!v.w(this.ftR.bAU())) {
                            ns(true);
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

    public void bEe() {
        this.hiE.e("", this.hiJ.bEi(), this.hiK.bCi().linkUrl, this.hiK.bCi().linkUrlCode, this.mLat, this.mLng);
    }
}
