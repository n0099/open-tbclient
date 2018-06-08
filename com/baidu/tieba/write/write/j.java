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
import com.baidu.tbadk.core.util.am;
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
    private static final Pattern hvH = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b fGt;
    private WriteUrlModel hvD;
    private k hvI;
    private com.baidu.tieba.write.model.a hvJ;
    private com.baidu.tieba.write.transmit.model.a hvK;
    private com.baidu.tbadk.core.view.a hvL;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    j.this.bJf();
                    TiebaStatic.log(new am("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    j.this.bJe();
                }
            }
        }
    };
    private View.OnClickListener hvM = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new am("c12163"));
                String bJs = j.this.hvI.bJs();
                if (j.hvH.matcher(bJs).matches()) {
                    j.this.bJe();
                    j.this.hvJ.vI(bJs);
                    j.this.hvI.a(null, true);
                    return;
                }
                TiebaStatic.log(new am("c12164"));
                j.this.hvI.bJt();
            }
        }
    };
    private TextWatcher hvN = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.hvI.bJk();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.fGt != null) {
                if (!j.this.fGt.bGb()) {
                    j.this.nB(false);
                }
                j.this.fGt.ns(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hvO = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.hvK != null) {
                j.this.hvK.avk();
            }
        }
    };
    private a.InterfaceC0253a hnd = new a.InterfaceC0253a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0253a
        public void onError() {
            j.this.dW(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0253a
        public void q(List<SimpleForum> list, int i) {
            j.this.dW(list);
        }
    };
    private a.InterfaceC0014a byv = new a.InterfaceC0014a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d aNh = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            j.this.hvI.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.fGt.ax(null);
                j.this.fGt.nr(false);
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
                    j.this.fGt.ax(postWriteCallBackData.getSensitiveWords());
                    j.this.fGt.vy(postWriteCallBackData.getErrorString());
                    if (!w.z(j.this.fGt.bFY())) {
                        j.this.nB(true);
                    }
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.hvI.l(postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.Ck());
                    if (!com.baidu.tbadk.p.a.hM(tVar.Cj())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Cj())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hvL = null;
        this.mContext = tbPageContext;
        this.hvI = kVar;
        this.hvJ = aVar;
        this.hvD = writeUrlModel;
        this.hvI.W(this.mClickListener);
        this.hvI.X(this.hvM);
        this.hvI.e(this.hvN);
        bJf();
        this.hvL = new com.baidu.tbadk.core.view.a(this.mContext);
        this.hvL.d(this.hvO);
        bJd();
        this.hvD.b(this.aNh);
        this.fGt = new com.baidu.tieba.write.b();
        this.fGt.va(d.C0141d.cp_cont_i);
        this.fGt.vb(d.C0141d.cp_cont_h_alpha85);
    }

    private void bJd() {
        this.hvK = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.hvK.a(this.hnd);
        if (this.hvD.getWriteData() != null) {
            this.hvK.setForumId(this.hvD.getWriteData().getForumId());
        }
    }

    protected void bJe() {
        this.hvI.bJr();
    }

    protected void bJf() {
        this.hvI.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dW(List<SimpleForum> list) {
        WriteData writeData = this.hvD.getWriteData();
        if (writeData != null) {
            this.hvL.aM(false);
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

    public void bxJ() {
        if (ac.aL(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.hB().a(true, this.byv);
        }
    }

    public void destroy() {
        if (this.hvK != null) {
            this.hvK.destroy();
        }
        if (this.hvJ != null) {
            this.hvJ.destroy();
        }
        if (this.hvD != null) {
            this.hvD.cancelLoadData();
        }
    }

    public void akK() {
        this.hvK.setThreadContent(this.hvI.bJl());
        this.hvK.So();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nB(boolean z) {
        if (this.hvI.bJn() != null && this.hvI.bJl() != null) {
            int selectionEnd = this.hvI.bJn().getSelectionEnd();
            SpannableStringBuilder b = this.fGt.b(this.hvI.bJn().getText());
            if (b != null) {
                this.fGt.ns(true);
                this.hvI.bJn().setText(b);
                if (z && this.fGt.bFZ() >= 0) {
                    this.hvI.bJn().requestFocus();
                    this.hvI.bJn().setSelection(this.fGt.bFZ());
                } else {
                    this.hvI.bJn().setSelection(selectionEnd);
                }
                this.fGt.nr(this.fGt.bFZ() >= 0);
            }
        }
    }

    public boolean bJg() {
        if (this.fGt.bGa()) {
            this.mContext.showToast(this.fGt.bGc());
            nB(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fGt.onChangeSkinType();
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
            } else if (i == 25013 && (writeData = this.hvD.getWriteData()) != null && this.hvJ.bHl() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hvK.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bJh();
                } else if (ac.aL(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.hB().a(true, new a.InterfaceC0014a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.bJh();
                        }
                    });
                }
                this.hvI.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.fGt.ax(postWriteCallBackData.getSensitiveWords());
                        if (!w.z(this.fGt.bFY())) {
                            nB(true);
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

    public void bJh() {
        this.hvD.e("", this.hvI.bJl(), this.hvJ.bHl().linkUrl, this.hvJ.bHl().linkUrlCode, this.mLat, this.mLng);
    }
}
