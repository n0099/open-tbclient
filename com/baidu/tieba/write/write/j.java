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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    private static final Pattern hzQ = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b fKu;
    private WriteUrlModel hzM;
    private k hzR;
    private com.baidu.tieba.write.model.a hzS;
    private com.baidu.tieba.write.transmit.model.a hzT;
    private com.baidu.tbadk.core.view.a hzU;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    j.this.bJG();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    j.this.bJF();
                }
            }
        }
    };
    private View.OnClickListener hzV = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new an("c12163"));
                String bJT = j.this.hzR.bJT();
                if (j.hzQ.matcher(bJT).matches()) {
                    j.this.bJF();
                    j.this.hzS.vE(bJT);
                    j.this.hzR.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.hzR.bJU();
            }
        }
    };
    private TextWatcher hzW = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.hzR.bJL();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.fKu != null) {
                if (!j.this.fKu.bGB()) {
                    j.this.nJ(false);
                }
                j.this.fKu.nA(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hzX = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.hzT != null) {
                j.this.hzT.avN();
            }
        }
    };
    private a.InterfaceC0255a hrj = new a.InterfaceC0255a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0255a
        public void onError() {
            j.this.dZ(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0255a
        public void r(List<SimpleForum> list, int i) {
            j.this.dZ(list);
        }
    };
    private a.InterfaceC0014a bAa = new a.InterfaceC0014a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d aOd = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            j.this.hzR.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.fKu.aB(null);
                j.this.fKu.nz(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(j.this.mContext.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.mContext.getPageActivity().setResult(-1, intent);
                    j.this.mContext.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.mContext.showToast(postWriteCallBackData.getErrorString());
                    j.this.fKu.aB(postWriteCallBackData.getSensitiveWords());
                    j.this.fKu.vu(postWriteCallBackData.getErrorString());
                    if (!w.A(j.this.fKu.bGy())) {
                        j.this.nJ(true);
                    }
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.hzR.l(postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.CC());
                    if (!com.baidu.tbadk.p.a.hQ(tVar.CB())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.CB())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hzU = null;
        this.mContext = tbPageContext;
        this.hzR = kVar;
        this.hzS = aVar;
        this.hzM = writeUrlModel;
        this.hzR.aa(this.mClickListener);
        this.hzR.ab(this.hzV);
        this.hzR.e(this.hzW);
        bJG();
        this.hzU = new com.baidu.tbadk.core.view.a(this.mContext);
        this.hzU.d(this.hzX);
        bJE();
        this.hzM.b(this.aOd);
        this.fKu = new com.baidu.tieba.write.b();
        this.fKu.vj(d.C0142d.cp_cont_i);
        this.fKu.vk(d.C0142d.cp_cont_h_alpha85);
    }

    private void bJE() {
        this.hzT = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.hzT.a(this.hrj);
        if (this.hzM.getWriteData() != null) {
            this.hzT.setForumId(this.hzM.getWriteData().getForumId());
        }
    }

    protected void bJF() {
        this.hzR.bJS();
    }

    protected void bJG() {
        this.hzR.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZ(List<SimpleForum> list) {
        WriteData writeData = this.hzM.getWriteData();
        if (writeData != null) {
            this.hzU.aO(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (w.z(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.mContext.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage(2002001, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bym() {
        if (ac.aL(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.hB().a(true, this.bAa);
        }
    }

    public void destroy() {
        if (this.hzT != null) {
            this.hzT.destroy();
        }
        if (this.hzS != null) {
            this.hzS.destroy();
        }
        if (this.hzM != null) {
            this.hzM.cancelLoadData();
        }
    }

    public void ake() {
        this.hzT.setThreadContent(this.hzR.bJM());
        this.hzT.SK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ(boolean z) {
        if (this.hzR.bJO() != null && this.hzR.bJM() != null) {
            int selectionEnd = this.hzR.bJO().getSelectionEnd();
            SpannableStringBuilder b = this.fKu.b(this.hzR.bJO().getText());
            if (b != null) {
                this.fKu.nA(true);
                this.hzR.bJO().setText(b);
                if (z && this.fKu.bGz() >= 0) {
                    this.hzR.bJO().requestFocus();
                    this.hzR.bJO().setSelection(this.fKu.bGz());
                } else {
                    this.hzR.bJO().setSelection(selectionEnd);
                }
                this.fKu.nz(this.fKu.bGz() >= 0);
            }
        }
    }

    public boolean bJH() {
        if (this.fKu.bGA()) {
            this.mContext.showToast(this.fKu.bGC());
            nJ(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fKu.onChangeSkinType();
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
                    this.mContext.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.hzM.getWriteData()) != null && this.hzS.bHM() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hzT.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bJI();
                } else if (ac.aL(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.hB().a(true, new a.InterfaceC0014a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.bJI();
                        }
                    });
                }
                this.hzR.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.fKu.aB(postWriteCallBackData.getSensitiveWords());
                        if (!w.A(this.fKu.bGy())) {
                            nJ(true);
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

    public void bJI() {
        this.hzM.e("", this.hzR.bJM(), this.hzS.bHM().linkUrl, this.hzS.bHM().linkUrlCode, this.mLat, this.mLng);
    }
}
