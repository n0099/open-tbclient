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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
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
/* loaded from: classes2.dex */
public class i {
    private static final Pattern hnf = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext aca;
    public com.baidu.tieba.write.b fhG;
    private com.baidu.tbadk.core.view.b hdR;
    private WriteUrlModel hna;
    private j hng;
    private com.baidu.tieba.write.model.a hnh;
    private com.baidu.tieba.write.transmit.model.a hni;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    i.this.bJd();
                    TiebaStatic.log(new ak("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    i.this.bJc();
                }
            }
        }
    };
    private View.OnClickListener hnj = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new ak("c12163"));
                String bJq = i.this.hng.bJq();
                if (i.hnf.matcher(bJq).matches()) {
                    i.this.bJc();
                    i.this.hnh.uJ(bJq);
                    i.this.hng.a(null, true);
                    return;
                }
                TiebaStatic.log(new ak("c12164"));
                i.this.hng.bJr();
            }
        }
    };
    private TextWatcher hnk = new TextWatcher() { // from class: com.baidu.tieba.write.write.i.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            i.this.hng.bJj();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (i.this.fhG != null) {
                if (!i.this.fhG.bFH()) {
                    i.this.ob(false);
                }
                i.this.fhG.nU(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hea = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.i.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (i.this.hni != null) {
                i.this.hni.and();
            }
        }
    };
    private a.InterfaceC0158a hdZ = new a.InterfaceC0158a() { // from class: com.baidu.tieba.write.write.i.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0158a
        public void bFD() {
            i.this.ed(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0158a
        public void r(List<SimpleForum> list, int i) {
            i.this.ed(list);
        }
    };
    private a.InterfaceC0004a boj = new a.InterfaceC0004a() { // from class: com.baidu.tieba.write.write.i.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                i.this.mLat = String.valueOf(address.getLatitude());
                i.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d aDV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.i.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            i.this.hng.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                i.this.fhG.aC(null);
                i.this.fhG.nT(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (i.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.d(i.this.aca.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    i.this.aca.getPageActivity().setResult(-1, intent);
                    i.this.aca.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    i.this.aca.showToast(postWriteCallBackData.getErrorString());
                    i.this.fhG.aC(postWriteCallBackData.getSensitiveWords());
                    i.this.fhG.uB(postWriteCallBackData.getErrorString());
                    if (!v.w(i.this.fhG.bFE())) {
                        i.this.ob(true);
                    }
                } else if ((sVar == null || writeData == null || sVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    i.this.hng.k(postWriteCallBackData);
                } else if (sVar != null && writeData != null && sVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(sVar.getVcode_md5());
                    writeData.setVcodeUrl(sVar.getVcode_pic_url());
                    writeData.setVcodeExtra(sVar.yk());
                    if (!com.baidu.tbadk.p.a.hc(sVar.yj())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(i.this.aca.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(i.this.aca.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, sVar.yj())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(i.this.aca.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public i(TbPageContext tbPageContext, j jVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hdR = null;
        this.aca = tbPageContext;
        this.hng = jVar;
        this.hnh = aVar;
        this.hna = writeUrlModel;
        this.hng.X(this.mClickListener);
        this.hng.Y(this.hnj);
        this.hng.e(this.hnk);
        bJd();
        this.hdR = new com.baidu.tbadk.core.view.b(this.aca);
        this.hdR.c(this.hea);
        bJb();
        this.hna.b(this.aDV);
        this.fhG = new com.baidu.tieba.write.b();
        this.fhG.vM(d.C0095d.cp_cont_i);
        this.fhG.vN(d.C0095d.cp_cont_h_alpha85);
    }

    private void bJb() {
        this.hni = new com.baidu.tieba.write.transmit.model.a(this.aca.getUniqueId());
        this.hni.a(this.hdZ);
        if (this.hna.getWriteData() != null) {
            this.hni.setForumId(this.hna.getWriteData().getForumId());
        }
    }

    protected void bJc() {
        this.hng.bJp();
    }

    protected void bJd() {
        this.hng.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ed(List<SimpleForum> list) {
        WriteData writeData = this.hna.getWriteData();
        if (writeData != null) {
            this.hdR.aE(false);
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
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.aca.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bxF() {
        if (ab.aG(this.aca.getPageActivity())) {
            com.baidu.adp.lib.d.a.fc().a(true, this.boj);
        }
    }

    public void destroy() {
        if (this.hni != null) {
            this.hni.destroy();
        }
        if (this.hnh != null) {
            this.hnh.destroy();
        }
        if (this.hna != null) {
            this.hna.cancelLoadData();
        }
    }

    public void bJe() {
        this.hni.setThreadContent(this.hng.bJk());
        this.hni.Om();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ob(boolean z) {
        if (this.hng.bJm() != null && this.hng.bJk() != null) {
            int selectionEnd = this.hng.bJm().getSelectionEnd();
            SpannableStringBuilder b = this.fhG.b(this.hng.bJm().getText());
            if (b != null) {
                this.fhG.nU(true);
                this.hng.bJm().setText(b);
                if (z && this.fhG.bFF() >= 0) {
                    this.hng.bJm().requestFocus();
                    this.hng.bJm().setSelection(this.fhG.bFF());
                } else {
                    this.hng.bJm().setSelection(selectionEnd);
                }
                this.fhG.nT(this.fhG.bFF() >= 0);
            }
        }
    }

    public boolean bJf() {
        if (this.fhG.bFG()) {
            this.aca.showToast(this.fhG.bFI());
            ob(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fhG.onChangeSkinType();
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
                    this.aca.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.hna.getWriteData()) != null && this.hnh.bGP() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hni.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bJg();
                } else if (ab.aG(this.aca.getPageActivity())) {
                    com.baidu.adp.lib.d.a.fc().a(true, new a.InterfaceC0004a() { // from class: com.baidu.tieba.write.write.i.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                i.this.mLat = String.valueOf(address.getLatitude());
                                i.this.mLng = String.valueOf(address.getLongitude());
                            }
                            i.this.bJg();
                        }
                    });
                }
                this.hng.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.aca.showToast(postWriteCallBackData.getErrorString());
                        this.fhG.aC(postWriteCallBackData.getSensitiveWords());
                        if (!v.w(this.fhG.bFE())) {
                            ob(true);
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

    public void bJg() {
        this.hna.e("", this.hng.bJk(), this.hnh.bGP().linkUrl, this.hnh.bGP().linkUrlCode, this.mLat, this.mLng);
    }
}
