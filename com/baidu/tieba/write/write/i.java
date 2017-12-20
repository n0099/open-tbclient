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
    private static final Pattern hna = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext abX;
    public com.baidu.tieba.write.b fhB;
    private com.baidu.tbadk.core.view.b hdM;
    private WriteUrlModel hmV;
    private j hnb;
    private com.baidu.tieba.write.model.a hnc;
    private com.baidu.tieba.write.transmit.model.a hnd;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    i.this.bJc();
                    TiebaStatic.log(new ak("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    i.this.bJb();
                }
            }
        }
    };
    private View.OnClickListener hne = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new ak("c12163"));
                String bJp = i.this.hnb.bJp();
                if (i.hna.matcher(bJp).matches()) {
                    i.this.bJb();
                    i.this.hnc.uJ(bJp);
                    i.this.hnb.a(null, true);
                    return;
                }
                TiebaStatic.log(new ak("c12164"));
                i.this.hnb.bJq();
            }
        }
    };
    private TextWatcher hnf = new TextWatcher() { // from class: com.baidu.tieba.write.write.i.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            i.this.hnb.bJi();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (i.this.fhB != null) {
                if (!i.this.fhB.bFG()) {
                    i.this.ob(false);
                }
                i.this.fhB.nU(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hdV = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.i.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (i.this.hnd != null) {
                i.this.hnd.anc();
            }
        }
    };
    private a.InterfaceC0159a hdU = new a.InterfaceC0159a() { // from class: com.baidu.tieba.write.write.i.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0159a
        public void bFC() {
            i.this.ed(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0159a
        public void r(List<SimpleForum> list, int i) {
            i.this.ed(list);
        }
    };
    private a.InterfaceC0004a bof = new a.InterfaceC0004a() { // from class: com.baidu.tieba.write.write.i.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                i.this.mLat = String.valueOf(address.getLatitude());
                i.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d aDS = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.i.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            i.this.hnb.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                i.this.fhB.aC(null);
                i.this.fhB.nT(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (i.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.d(i.this.abX.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    i.this.abX.getPageActivity().setResult(-1, intent);
                    i.this.abX.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    i.this.abX.showToast(postWriteCallBackData.getErrorString());
                    i.this.fhB.aC(postWriteCallBackData.getSensitiveWords());
                    i.this.fhB.uB(postWriteCallBackData.getErrorString());
                    if (!v.w(i.this.fhB.bFD())) {
                        i.this.ob(true);
                    }
                } else if ((sVar == null || writeData == null || sVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    i.this.hnb.k(postWriteCallBackData);
                } else if (sVar != null && writeData != null && sVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(sVar.getVcode_md5());
                    writeData.setVcodeUrl(sVar.getVcode_pic_url());
                    writeData.setVcodeExtra(sVar.yk());
                    if (!com.baidu.tbadk.p.a.hc(sVar.yj())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(i.this.abX.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(i.this.abX.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, sVar.yj())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(i.this.abX.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public i(TbPageContext tbPageContext, j jVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hdM = null;
        this.abX = tbPageContext;
        this.hnb = jVar;
        this.hnc = aVar;
        this.hmV = writeUrlModel;
        this.hnb.X(this.mClickListener);
        this.hnb.Y(this.hne);
        this.hnb.e(this.hnf);
        bJc();
        this.hdM = new com.baidu.tbadk.core.view.b(this.abX);
        this.hdM.c(this.hdV);
        bJa();
        this.hmV.b(this.aDS);
        this.fhB = new com.baidu.tieba.write.b();
        this.fhB.vM(d.C0096d.cp_cont_i);
        this.fhB.vN(d.C0096d.cp_cont_h_alpha85);
    }

    private void bJa() {
        this.hnd = new com.baidu.tieba.write.transmit.model.a(this.abX.getUniqueId());
        this.hnd.a(this.hdU);
        if (this.hmV.getWriteData() != null) {
            this.hnd.setForumId(this.hmV.getWriteData().getForumId());
        }
    }

    protected void bJb() {
        this.hnb.bJo();
    }

    protected void bJc() {
        this.hnb.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ed(List<SimpleForum> list) {
        WriteData writeData = this.hmV.getWriteData();
        if (writeData != null) {
            this.hdM.aE(false);
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
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.abX.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bxE() {
        if (ab.aG(this.abX.getPageActivity())) {
            com.baidu.adp.lib.d.a.fc().a(true, this.bof);
        }
    }

    public void destroy() {
        if (this.hnd != null) {
            this.hnd.destroy();
        }
        if (this.hnc != null) {
            this.hnc.destroy();
        }
        if (this.hmV != null) {
            this.hmV.cancelLoadData();
        }
    }

    public void bJd() {
        this.hnd.setThreadContent(this.hnb.bJj());
        this.hnd.Om();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ob(boolean z) {
        if (this.hnb.bJl() != null && this.hnb.bJj() != null) {
            int selectionEnd = this.hnb.bJl().getSelectionEnd();
            SpannableStringBuilder b = this.fhB.b(this.hnb.bJl().getText());
            if (b != null) {
                this.fhB.nU(true);
                this.hnb.bJl().setText(b);
                if (z && this.fhB.bFE() >= 0) {
                    this.hnb.bJl().requestFocus();
                    this.hnb.bJl().setSelection(this.fhB.bFE());
                } else {
                    this.hnb.bJl().setSelection(selectionEnd);
                }
                this.fhB.nT(this.fhB.bFE() >= 0);
            }
        }
    }

    public boolean bJe() {
        if (this.fhB.bFF()) {
            this.abX.showToast(this.fhB.bFH());
            ob(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fhB.onChangeSkinType();
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
                    this.abX.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.hmV.getWriteData()) != null && this.hnc.bGO() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hnd.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bJf();
                } else if (ab.aG(this.abX.getPageActivity())) {
                    com.baidu.adp.lib.d.a.fc().a(true, new a.InterfaceC0004a() { // from class: com.baidu.tieba.write.write.i.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                i.this.mLat = String.valueOf(address.getLatitude());
                                i.this.mLng = String.valueOf(address.getLongitude());
                            }
                            i.this.bJf();
                        }
                    });
                }
                this.hnb.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.abX.showToast(postWriteCallBackData.getErrorString());
                        this.fhB.aC(postWriteCallBackData.getSensitiveWords());
                        if (!v.w(this.fhB.bFD())) {
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

    public void bJf() {
        this.hmV.e("", this.hnb.bJj(), this.hnc.bGO().linkUrl, this.hnc.bGO().linkUrlCode, this.mLat, this.mLng);
    }
}
