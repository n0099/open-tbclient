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
/* loaded from: classes2.dex */
public class i {
    private static final Pattern hLp = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext aQs;
    public com.baidu.tieba.write.b fWB;
    private com.baidu.tbadk.core.view.b hBO;
    private WriteUrlModel hLk;
    private j hLq;
    private com.baidu.tieba.write.model.a hLr;
    private com.baidu.tieba.write.transmit.model.a hLs;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    i.this.bIw();
                    TiebaStatic.log(new ak("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    i.this.bIv();
                }
            }
        }
    };
    private View.OnClickListener hLt = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new ak("c12163"));
                String bIK = i.this.hLq.bIK();
                if (i.hLp.matcher(bIK).matches()) {
                    i.this.bIv();
                    i.this.hLr.up(bIK);
                    i.this.hLq.a(null, true);
                    return;
                }
                TiebaStatic.log(new ak("c12164"));
                i.this.hLq.bIL();
            }
        }
    };
    private TextWatcher hLu = new TextWatcher() { // from class: com.baidu.tieba.write.write.i.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            i.this.hLq.bIC();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (i.this.fWB != null) {
                if (!i.this.fWB.bER()) {
                    i.this.nC(false);
                }
                i.this.fWB.nu(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hBX = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.i.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (i.this.hLs != null) {
                i.this.hLs.avS();
            }
        }
    };
    private a.InterfaceC0171a hBW = new a.InterfaceC0171a() { // from class: com.baidu.tieba.write.write.i.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0171a
        public void onError() {
            i.this.dT(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0171a
        public void u(List<SimpleForum> list, int i) {
            i.this.dT(list);
        }
    };
    private a.InterfaceC0017a cbL = new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.i.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                i.this.mLat = String.valueOf(address.getLatitude());
                i.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d bsh = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.i.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            i.this.hLq.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                i.this.fWB.av(null);
                i.this.fWB.nt(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (i.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(i.this.aQs.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    i.this.aQs.getPageActivity().setResult(-1, intent);
                    i.this.aQs.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    i.this.aQs.showToast(postWriteCallBackData.getErrorString());
                    i.this.fWB.av(postWriteCallBackData.getSensitiveWords());
                    i.this.fWB.uh(postWriteCallBackData.getErrorString());
                    if (!v.E(i.this.fWB.bEO())) {
                        i.this.nC(true);
                    }
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    i.this.hLq.k(postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.FC());
                    if (!com.baidu.tbadk.p.a.ho(tVar.FB())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(i.this.aQs.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(i.this.aQs.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FB())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(i.this.aQs.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public i(TbPageContext tbPageContext, j jVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hBO = null;
        this.aQs = tbPageContext;
        this.hLq = jVar;
        this.hLr = aVar;
        this.hLk = writeUrlModel;
        this.hLq.U(this.mClickListener);
        this.hLq.V(this.hLt);
        this.hLq.e(this.hLu);
        bIw();
        this.hBO = new com.baidu.tbadk.core.view.b(this.aQs);
        this.hBO.c(this.hBX);
        bIu();
        this.hLk.b(this.bsh);
        this.fWB = new com.baidu.tieba.write.b();
        this.fWB.xg(d.C0108d.cp_cont_i);
        this.fWB.xh(d.C0108d.cp_cont_h_alpha85);
    }

    private void bIu() {
        this.hLs = new com.baidu.tieba.write.transmit.model.a(this.aQs.getUniqueId());
        this.hLs.a(this.hBW);
        if (this.hLk.getWriteData() != null) {
            this.hLs.setForumId(this.hLk.getWriteData().getForumId());
        }
    }

    protected void bIv() {
        this.hLq.bIJ();
    }

    protected void bIw() {
        this.hLq.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dT(List<SimpleForum> list) {
        WriteData writeData = this.hLk.getWriteData();
        if (writeData != null) {
            this.hBO.bn(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.D(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.aQs.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bwt() {
        if (ab.aS(this.aQs.getPageActivity())) {
            com.baidu.adp.lib.d.a.mG().a(true, this.cbL);
        }
    }

    public void destroy() {
        if (this.hLs != null) {
            this.hLs.destroy();
        }
        if (this.hLr != null) {
            this.hLr.destroy();
        }
        if (this.hLk != null) {
            this.hLk.cancelLoadData();
        }
    }

    public void bIx() {
        this.hLs.setThreadContent(this.hLq.bID());
        this.hLs.VB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nC(boolean z) {
        if (this.hLq.bIF() != null && this.hLq.bID() != null) {
            int selectionEnd = this.hLq.bIF().getSelectionEnd();
            SpannableStringBuilder b = this.fWB.b(this.hLq.bIF().getText());
            if (b != null) {
                this.fWB.nu(true);
                this.hLq.bIF().setText(b);
                if (z && this.fWB.bEP() >= 0) {
                    this.hLq.bIF().requestFocus();
                    this.hLq.bIF().setSelection(this.fWB.bEP());
                } else {
                    this.hLq.bIF().setSelection(selectionEnd);
                }
                this.fWB.nt(this.fWB.bEP() >= 0);
            }
        }
    }

    public boolean bIy() {
        if (this.fWB.bEQ()) {
            this.aQs.showToast(this.fWB.bES());
            nC(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fWB.onChangeSkinType();
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
                    this.aQs.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.hLk.getWriteData()) != null && this.hLr.bGe() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hLs.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bIz();
                } else if (ab.aS(this.aQs.getPageActivity())) {
                    com.baidu.adp.lib.d.a.mG().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.i.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                i.this.mLat = String.valueOf(address.getLatitude());
                                i.this.mLng = String.valueOf(address.getLongitude());
                            }
                            i.this.bIz();
                        }
                    });
                }
                this.hLq.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.aQs.showToast(postWriteCallBackData.getErrorString());
                        this.fWB.av(postWriteCallBackData.getSensitiveWords());
                        if (!v.E(this.fWB.bEO())) {
                            nC(true);
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
        this.hLk.e("", this.hLq.bID(), this.hLr.bGe().linkUrl, this.hLr.bGe().linkUrlCode, this.mLat, this.mLng);
    }
}
