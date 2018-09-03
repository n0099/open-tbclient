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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tieba.f;
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
    private static final Pattern hBa = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b fKB;
    private WriteUrlModel hAW;
    private k hBb;
    private com.baidu.tieba.write.model.a hBc;
    private com.baidu.tieba.write.transmit.model.a hBd;
    private com.baidu.tbadk.core.view.a hBe;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == f.g.icon_invoke_link) {
                    j.this.bIx();
                    TiebaStatic.log(new an("c12169"));
                }
                if (view.getId() == f.g.url_edit_back_view) {
                    j.this.bIw();
                }
            }
        }
    };
    private View.OnClickListener hBf = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == f.g.url_add) {
                TiebaStatic.log(new an("c12163"));
                String bIK = j.this.hBb.bIK();
                if (j.hBa.matcher(bIK).matches()) {
                    j.this.bIw();
                    j.this.hBc.vJ(bIK);
                    j.this.hBb.a(null, true);
                    return;
                }
                TiebaStatic.log(new an("c12164"));
                j.this.hBb.bIL();
            }
        }
    };
    private TextWatcher hBg = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.hBb.bIC();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.fKB != null) {
                if (!j.this.fKB.bFq()) {
                    j.this.nx(false);
                }
                j.this.fKB.no(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hBh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.hBd != null) {
                j.this.hBd.awr();
            }
        }
    };
    private a.InterfaceC0255a hss = new a.InterfaceC0255a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0255a
        public void onError() {
            j.this.dV(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0255a
        public void r(List<SimpleForum> list, int i) {
            j.this.dV(list);
        }
    };
    private a.InterfaceC0014a bAJ = new a.InterfaceC0014a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d aNZ = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, u uVar, WriteData writeData, AntiData antiData) {
            j.this.hBb.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.fKB.az(null);
                j.this.fKB.nn(false);
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
                    j.this.fKB.az(postWriteCallBackData.getSensitiveWords());
                    j.this.fKB.vz(postWriteCallBackData.getErrorString());
                    if (!w.z(j.this.fKB.bFn())) {
                        j.this.nx(true);
                    }
                } else if ((uVar == null || writeData == null || uVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.hBb.l(postWriteCallBackData);
                } else if (uVar != null && writeData != null && uVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(uVar.getVcode_md5());
                    writeData.setVcodeUrl(uVar.getVcode_pic_url());
                    writeData.setVcodeExtra(uVar.Cs());
                    if (!com.baidu.tbadk.q.a.hN(uVar.Cr())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, uVar.Cr())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hBe = null;
        this.mContext = tbPageContext;
        this.hBb = kVar;
        this.hBc = aVar;
        this.hAW = writeUrlModel;
        this.hBb.Y(this.mClickListener);
        this.hBb.Z(this.hBf);
        this.hBb.e(this.hBg);
        bIx();
        this.hBe = new com.baidu.tbadk.core.view.a(this.mContext);
        this.hBe.d(this.hBh);
        bIv();
        this.hAW.b(this.aNZ);
        this.fKB = new com.baidu.tieba.write.b();
        this.fKB.vi(f.d.cp_cont_i);
        this.fKB.vj(f.d.cp_cont_h_alpha85);
    }

    private void bIv() {
        this.hBd = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.hBd.a(this.hss);
        if (this.hAW.getWriteData() != null) {
            this.hBd.setForumId(this.hAW.getWriteData().getForumId());
        }
    }

    protected void bIw() {
        this.hBb.bIJ();
    }

    protected void bIx() {
        this.hBb.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dV(List<SimpleForum> list) {
        WriteData writeData = this.hAW.getWriteData();
        if (writeData != null) {
            this.hBe.aN(false);
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

    public void bwQ() {
        if (ac.aL(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.hB().a(true, this.bAJ);
        }
    }

    public void destroy() {
        if (this.hBd != null) {
            this.hBd.destroy();
        }
        if (this.hBc != null) {
            this.hBc.destroy();
        }
        if (this.hAW != null) {
            this.hAW.cancelLoadData();
        }
    }

    public void akF() {
        this.hBd.setThreadContent(this.hBb.bID());
        this.hBd.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nx(boolean z) {
        if (this.hBb.bIF() != null && this.hBb.bID() != null) {
            int selectionEnd = this.hBb.bIF().getSelectionEnd();
            SpannableStringBuilder b = this.fKB.b(this.hBb.bIF().getText());
            if (b != null) {
                this.fKB.no(true);
                this.hBb.bIF().setText(b);
                if (z && this.fKB.bFo() >= 0) {
                    this.hBb.bIF().requestFocus();
                    this.hBb.bIF().setSelection(this.fKB.bFo());
                } else {
                    this.hBb.bIF().setSelection(selectionEnd);
                }
                this.fKB.nn(this.fKB.bFo() >= 0);
            }
        }
    }

    public boolean bIy() {
        if (this.fKB.bFp()) {
            this.mContext.showToast(this.fKB.bFr());
            nx(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fKB.onChangeSkinType();
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
            } else if (i == 25013 && (writeData = this.hAW.getWriteData()) != null && this.hBc.bGB() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hBd.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bIz();
                } else if (ac.aL(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.hB().a(true, new a.InterfaceC0014a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.bIz();
                        }
                    });
                }
                this.hBb.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.fKB.az(postWriteCallBackData.getSensitiveWords());
                        if (!w.z(this.fKB.bFn())) {
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

    public void bIz() {
        this.hAW.e("", this.hBb.bID(), this.hBc.bGB().linkUrl, this.hBc.bGB().linkUrlCode, this.mLat, this.mLng);
    }
}
