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
    private static final Pattern hjM = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b fuY;
    private WriteUrlModel hjI;
    private k hjN;
    private com.baidu.tieba.write.model.a hjO;
    private com.baidu.tieba.write.transmit.model.a hjP;
    private com.baidu.tbadk.core.view.a hjQ;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != null && view2.getId() != 0) {
                if (view2.getId() == d.g.icon_invoke_link) {
                    j.this.bEa();
                    TiebaStatic.log(new al("c12169"));
                }
                if (view2.getId() == d.g.url_edit_back_view) {
                    j.this.bDZ();
                }
            }
        }
    };
    private View.OnClickListener hjR = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != null && view2.getId() == d.g.url_add) {
                TiebaStatic.log(new al("c12163"));
                String bEn = j.this.hjN.bEn();
                if (j.hjM.matcher(bEn).matches()) {
                    j.this.bDZ();
                    j.this.hjO.uO(bEn);
                    j.this.hjN.a(null, true);
                    return;
                }
                TiebaStatic.log(new al("c12164"));
                j.this.hjN.bEo();
            }
        }
    };
    private TextWatcher hjS = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.hjN.bEf();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.fuY != null) {
                if (!j.this.fuY.bAV()) {
                    j.this.nt(false);
                }
                j.this.fuY.nk(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hjT = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.hjP != null) {
                j.this.hjP.arf();
            }
        }
    };
    private a.InterfaceC0236a hbi = new a.InterfaceC0236a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0236a
        public void onError() {
            j.this.dQ(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0236a
        public void p(List<SimpleForum> list, int i) {
            j.this.dQ(list);
        }
    };
    private a.InterfaceC0006a bqq = new a.InterfaceC0006a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0006a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d aEL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            j.this.hjN.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.fuY.ax(null);
                j.this.fuY.nj(false);
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
                    j.this.fuY.ax(postWriteCallBackData.getSensitiveWords());
                    j.this.fuY.uE(postWriteCallBackData.getErrorString());
                    if (!v.w(j.this.fuY.bAS())) {
                        j.this.nt(true);
                    }
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.hjN.l(postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.yK());
                    if (!com.baidu.tbadk.p.a.hr(tVar.yJ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.yJ())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hjQ = null;
        this.mContext = tbPageContext;
        this.hjN = kVar;
        this.hjO = aVar;
        this.hjI = writeUrlModel;
        this.hjN.W(this.mClickListener);
        this.hjN.X(this.hjR);
        this.hjN.e(this.hjS);
        bEa();
        this.hjQ = new com.baidu.tbadk.core.view.a(this.mContext);
        this.hjQ.d(this.hjT);
        bDY();
        this.hjI.b(this.aEL);
        this.fuY = new com.baidu.tieba.write.b();
        this.fuY.uJ(d.C0126d.cp_cont_i);
        this.fuY.uK(d.C0126d.cp_cont_h_alpha85);
    }

    private void bDY() {
        this.hjP = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.hjP.a(this.hbi);
        if (this.hjI.getWriteData() != null) {
            this.hjP.setForumId(this.hjI.getWriteData().getForumId());
        }
    }

    protected void bDZ() {
        this.hjN.bEm();
    }

    protected void bEa() {
        this.hjN.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ(List<SimpleForum> list) {
        WriteData writeData = this.hjI.getWriteData();
        if (writeData != null) {
            this.hjQ.aI(false);
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
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.mContext.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage(2002001, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bsE() {
        if (ab.aB(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.eK().a(true, this.bqq);
        }
    }

    public void destroy() {
        if (this.hjP != null) {
            this.hjP.destroy();
        }
        if (this.hjO != null) {
            this.hjO.destroy();
        }
        if (this.hjI != null) {
            this.hjI.cancelLoadData();
        }
    }

    public void ahc() {
        this.hjP.setThreadContent(this.hjN.bEg());
        this.hjP.OQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt(boolean z) {
        if (this.hjN.bEi() != null && this.hjN.bEg() != null) {
            int selectionEnd = this.hjN.bEi().getSelectionEnd();
            SpannableStringBuilder b = this.fuY.b(this.hjN.bEi().getText());
            if (b != null) {
                this.fuY.nk(true);
                this.hjN.bEi().setText(b);
                if (z && this.fuY.bAT() >= 0) {
                    this.hjN.bEi().requestFocus();
                    this.hjN.bEi().setSelection(this.fuY.bAT());
                } else {
                    this.hjN.bEi().setSelection(selectionEnd);
                }
                this.fuY.nj(this.fuY.bAT() >= 0);
            }
        }
    }

    public boolean bEb() {
        if (this.fuY.bAU()) {
            this.mContext.showToast(this.fuY.bAW());
            nt(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fuY.onChangeSkinType();
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
            } else if (i == 25013 && (writeData = this.hjI.getWriteData()) != null && this.hjO.bCg() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hjP.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bEc();
                } else if (ab.aB(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.eK().a(true, new a.InterfaceC0006a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0006a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.bEc();
                        }
                    });
                }
                this.hjN.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.fuY.ax(postWriteCallBackData.getSensitiveWords());
                        if (!v.w(this.fuY.bAS())) {
                            nt(true);
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

    public void bEc() {
        this.hjI.e("", this.hjN.bEg(), this.hjO.bCg().linkUrl, this.hjO.bCg().linkUrlCode, this.mLat, this.mLng);
    }
}
