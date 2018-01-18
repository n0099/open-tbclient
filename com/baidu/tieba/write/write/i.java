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
    private static final Pattern hKV = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext aQp;
    public com.baidu.tieba.write.b fWg;
    private com.baidu.tbadk.core.view.b hBu;
    private WriteUrlModel hKQ;
    private j hKW;
    private com.baidu.tieba.write.model.a hKX;
    private com.baidu.tieba.write.transmit.model.a hKY;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    i.this.bIu();
                    TiebaStatic.log(new ak("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    i.this.bIt();
                }
            }
        }
    };
    private View.OnClickListener hKZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new ak("c12163"));
                String bII = i.this.hKW.bII();
                if (i.hKV.matcher(bII).matches()) {
                    i.this.bIt();
                    i.this.hKX.uh(bII);
                    i.this.hKW.a(null, true);
                    return;
                }
                TiebaStatic.log(new ak("c12164"));
                i.this.hKW.bIJ();
            }
        }
    };
    private TextWatcher hLa = new TextWatcher() { // from class: com.baidu.tieba.write.write.i.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            i.this.hKW.bIA();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (i.this.fWg != null) {
                if (!i.this.fWg.bEP()) {
                    i.this.nz(false);
                }
                i.this.fWg.nr(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hBD = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.i.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (i.this.hKY != null) {
                i.this.hKY.avN();
            }
        }
    };
    private a.InterfaceC0170a hBC = new a.InterfaceC0170a() { // from class: com.baidu.tieba.write.write.i.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0170a
        public void onError() {
            i.this.dT(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0170a
        public void u(List<SimpleForum> list, int i) {
            i.this.dT(list);
        }
    };
    private a.InterfaceC0017a cbD = new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.i.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                i.this.mLat = String.valueOf(address.getLatitude());
                i.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d brY = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.i.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            i.this.hKW.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                i.this.fWg.av(null);
                i.this.fWg.nq(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (i.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(i.this.aQp.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    i.this.aQp.getPageActivity().setResult(-1, intent);
                    i.this.aQp.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    i.this.aQp.showToast(postWriteCallBackData.getErrorString());
                    i.this.fWg.av(postWriteCallBackData.getSensitiveWords());
                    i.this.fWg.tZ(postWriteCallBackData.getErrorString());
                    if (!v.E(i.this.fWg.bEM())) {
                        i.this.nz(true);
                    }
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    i.this.hKW.k(postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.FA());
                    if (!com.baidu.tbadk.p.a.hg(tVar.Fz())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(i.this.aQp.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(i.this.aQp.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Fz())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(i.this.aQp.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public i(TbPageContext tbPageContext, j jVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hBu = null;
        this.aQp = tbPageContext;
        this.hKW = jVar;
        this.hKX = aVar;
        this.hKQ = writeUrlModel;
        this.hKW.U(this.mClickListener);
        this.hKW.V(this.hKZ);
        this.hKW.e(this.hLa);
        bIu();
        this.hBu = new com.baidu.tbadk.core.view.b(this.aQp);
        this.hBu.c(this.hBD);
        bIs();
        this.hKQ.b(this.brY);
        this.fWg = new com.baidu.tieba.write.b();
        this.fWg.xg(d.C0107d.cp_cont_i);
        this.fWg.xh(d.C0107d.cp_cont_h_alpha85);
    }

    private void bIs() {
        this.hKY = new com.baidu.tieba.write.transmit.model.a(this.aQp.getUniqueId());
        this.hKY.a(this.hBC);
        if (this.hKQ.getWriteData() != null) {
            this.hKY.setForumId(this.hKQ.getWriteData().getForumId());
        }
    }

    protected void bIt() {
        this.hKW.bIH();
    }

    protected void bIu() {
        this.hKW.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dT(List<SimpleForum> list) {
        WriteData writeData = this.hKQ.getWriteData();
        if (writeData != null) {
            this.hBu.bm(false);
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
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.aQp.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bwr() {
        if (ab.aS(this.aQp.getPageActivity())) {
            com.baidu.adp.lib.d.a.mF().a(true, this.cbD);
        }
    }

    public void destroy() {
        if (this.hKY != null) {
            this.hKY.destroy();
        }
        if (this.hKX != null) {
            this.hKX.destroy();
        }
        if (this.hKQ != null) {
            this.hKQ.cancelLoadData();
        }
    }

    public void bIv() {
        this.hKY.setThreadContent(this.hKW.bIB());
        this.hKY.Vz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(boolean z) {
        if (this.hKW.bID() != null && this.hKW.bIB() != null) {
            int selectionEnd = this.hKW.bID().getSelectionEnd();
            SpannableStringBuilder b = this.fWg.b(this.hKW.bID().getText());
            if (b != null) {
                this.fWg.nr(true);
                this.hKW.bID().setText(b);
                if (z && this.fWg.bEN() >= 0) {
                    this.hKW.bID().requestFocus();
                    this.hKW.bID().setSelection(this.fWg.bEN());
                } else {
                    this.hKW.bID().setSelection(selectionEnd);
                }
                this.fWg.nq(this.fWg.bEN() >= 0);
            }
        }
    }

    public boolean bIw() {
        if (this.fWg.bEO()) {
            this.aQp.showToast(this.fWg.bEQ());
            nz(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fWg.onChangeSkinType();
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
                    this.aQp.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.hKQ.getWriteData()) != null && this.hKX.bGc() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hKY.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bIx();
                } else if (ab.aS(this.aQp.getPageActivity())) {
                    com.baidu.adp.lib.d.a.mF().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.i.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                i.this.mLat = String.valueOf(address.getLatitude());
                                i.this.mLng = String.valueOf(address.getLongitude());
                            }
                            i.this.bIx();
                        }
                    });
                }
                this.hKW.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.aQp.showToast(postWriteCallBackData.getErrorString());
                        this.fWg.av(postWriteCallBackData.getSensitiveWords());
                        if (!v.E(this.fWg.bEM())) {
                            nz(true);
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

    public void bIx() {
        this.hKQ.e("", this.hKW.bIB(), this.hKX.bGc().linkUrl, this.hKX.bGc().linkUrlCode, this.mLat, this.mLng);
    }
}
