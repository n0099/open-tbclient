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
    private static final Pattern hAY = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b fKI;
    private WriteUrlModel hAU;
    private k hAZ;
    private com.baidu.tieba.write.model.a hBa;
    private com.baidu.tieba.write.transmit.model.a hBb;
    private com.baidu.tbadk.core.view.a hBc;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    j.this.bIt();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    j.this.bIs();
                }
            }
        }
    };
    private View.OnClickListener hBd = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new an("c12163"));
                String bIG = j.this.hAZ.bIG();
                if (j.hAY.matcher(bIG).matches()) {
                    j.this.bIs();
                    j.this.hBa.vF(bIG);
                    j.this.hAZ.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.hAZ.bIH();
            }
        }
    };
    private TextWatcher hBe = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.hAZ.bIy();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.fKI != null) {
                if (!j.this.fKI.bFm()) {
                    j.this.nx(false);
                }
                j.this.fKI.no(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hBf = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.hBb != null) {
                j.this.hBb.aws();
            }
        }
    };
    private a.InterfaceC0255a hsq = new a.InterfaceC0255a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0255a
        public void onError() {
            j.this.dV(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0255a
        public void r(List<SimpleForum> list, int i) {
            j.this.dV(list);
        }
    };
    private a.InterfaceC0014a bAH = new a.InterfaceC0014a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d aOc = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            j.this.hAZ.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.fKI.az(null);
                j.this.fKI.nn(false);
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
                    j.this.fKI.az(postWriteCallBackData.getSensitiveWords());
                    j.this.fKI.vv(postWriteCallBackData.getErrorString());
                    if (!w.z(j.this.fKI.bFj())) {
                        j.this.nx(true);
                    }
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.hAZ.l(postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.Cu());
                    if (!com.baidu.tbadk.q.a.hN(tVar.Ct())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Ct())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hBc = null;
        this.mContext = tbPageContext;
        this.hAZ = kVar;
        this.hBa = aVar;
        this.hAU = writeUrlModel;
        this.hAZ.Y(this.mClickListener);
        this.hAZ.Z(this.hBd);
        this.hAZ.e(this.hBe);
        bIt();
        this.hBc = new com.baidu.tbadk.core.view.a(this.mContext);
        this.hBc.d(this.hBf);
        bIr();
        this.hAU.b(this.aOc);
        this.fKI = new com.baidu.tieba.write.b();
        this.fKI.vi(d.C0140d.cp_cont_i);
        this.fKI.vj(d.C0140d.cp_cont_h_alpha85);
    }

    private void bIr() {
        this.hBb = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.hBb.a(this.hsq);
        if (this.hAU.getWriteData() != null) {
            this.hBb.setForumId(this.hAU.getWriteData().getForumId());
        }
    }

    protected void bIs() {
        this.hAZ.bIF();
    }

    protected void bIt() {
        this.hAZ.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dV(List<SimpleForum> list) {
        WriteData writeData = this.hAU.getWriteData();
        if (writeData != null) {
            this.hBc.aM(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (w.y(list) > 0) {
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

    public void bwP() {
        if (ac.aM(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.hB().a(true, this.bAH);
        }
    }

    public void destroy() {
        if (this.hBb != null) {
            this.hBb.destroy();
        }
        if (this.hBa != null) {
            this.hBa.destroy();
        }
        if (this.hAU != null) {
            this.hAU.cancelLoadData();
        }
    }

    public void akD() {
        this.hBb.setThreadContent(this.hAZ.bIz());
        this.hBb.SS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nx(boolean z) {
        if (this.hAZ.bIB() != null && this.hAZ.bIz() != null) {
            int selectionEnd = this.hAZ.bIB().getSelectionEnd();
            SpannableStringBuilder b = this.fKI.b(this.hAZ.bIB().getText());
            if (b != null) {
                this.fKI.no(true);
                this.hAZ.bIB().setText(b);
                if (z && this.fKI.bFk() >= 0) {
                    this.hAZ.bIB().requestFocus();
                    this.hAZ.bIB().setSelection(this.fKI.bFk());
                } else {
                    this.hAZ.bIB().setSelection(selectionEnd);
                }
                this.fKI.nn(this.fKI.bFk() >= 0);
            }
        }
    }

    public boolean bIu() {
        if (this.fKI.bFl()) {
            this.mContext.showToast(this.fKI.bFn());
            nx(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fKI.onChangeSkinType();
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
            } else if (i == 25013 && (writeData = this.hAU.getWriteData()) != null && this.hBa.bGx() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hBb.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bIv();
                } else if (ac.aM(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.hB().a(true, new a.InterfaceC0014a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.bIv();
                        }
                    });
                }
                this.hAZ.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.fKI.az(postWriteCallBackData.getSensitiveWords());
                        if (!w.z(this.fKI.bFj())) {
                            nx(true);
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

    public void bIv() {
        this.hAU.e("", this.hAZ.bIz(), this.hBa.bGx().linkUrl, this.hBa.bGx().linkUrlCode, this.mLat, this.mLng);
    }
}
