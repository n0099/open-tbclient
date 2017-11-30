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
import com.baidu.tbadk.coreExtra.data.r;
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
    private static final Pattern hki = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext acd;
    public com.baidu.tieba.write.b fgD;
    private com.baidu.tbadk.core.view.a haW;
    private WriteUrlModel hkd;
    private j hkj;
    private com.baidu.tieba.write.model.a hkk;
    private com.baidu.tieba.write.transmit.model.a hkl;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    i.this.bIq();
                    TiebaStatic.log(new ak("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    i.this.bIp();
                }
            }
        }
    };
    private View.OnClickListener hkm = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new ak("c12163"));
                String bID = i.this.hkj.bID();
                if (i.hki.matcher(bID).matches()) {
                    i.this.bIp();
                    i.this.hkk.uE(bID);
                    i.this.hkj.a(null, true);
                    return;
                }
                TiebaStatic.log(new ak("c12164"));
                i.this.hkj.bIE();
            }
        }
    };
    private TextWatcher hkn = new TextWatcher() { // from class: com.baidu.tieba.write.write.i.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            i.this.hkj.bIw();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (i.this.fgD != null) {
                if (!i.this.fgD.bEV()) {
                    i.this.oa(false);
                }
                i.this.fgD.nT(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hbf = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.i.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (i.this.hkl != null) {
                i.this.hkl.amU();
            }
        }
    };
    private a.InterfaceC0142a hbe = new a.InterfaceC0142a() { // from class: com.baidu.tieba.write.write.i.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0142a
        public void bER() {
            i.this.ee(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0142a
        public void C(List<SimpleForum> list) {
            i.this.ee(list);
        }
    };
    private a.InterfaceC0004a boe = new a.InterfaceC0004a() { // from class: com.baidu.tieba.write.write.i.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                i.this.mLat = String.valueOf(address.getLatitude());
                i.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d aDN = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.i.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
            i.this.hkj.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                i.this.fgD.aB(null);
                i.this.fgD.nS(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (i.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.d(i.this.acd.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    i.this.acd.getPageActivity().setResult(-1, intent);
                    i.this.acd.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    i.this.acd.showToast(postWriteCallBackData.getErrorString());
                    i.this.fgD.aB(postWriteCallBackData.getSensitiveWords());
                    i.this.fgD.uw(postWriteCallBackData.getErrorString());
                    if (!v.w(i.this.fgD.bES())) {
                        i.this.oa(true);
                    }
                } else if ((rVar == null || writeData == null || rVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    i.this.hkj.k(postWriteCallBackData);
                } else if (rVar != null && writeData != null && rVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(rVar.getVcode_md5());
                    writeData.setVcodeUrl(rVar.getVcode_pic_url());
                    writeData.setVcodeExtra(rVar.yj());
                    if (!com.baidu.tbadk.p.a.he(rVar.yi())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(i.this.acd.getPageActivity(), writeData, 12006)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(i.this.acd.getPageActivity(), 12006, writeData, false, rVar.yi())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(i.this.acd.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public i(TbPageContext tbPageContext, j jVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.haW = null;
        this.acd = tbPageContext;
        this.hkj = jVar;
        this.hkk = aVar;
        this.hkd = writeUrlModel;
        this.hkj.X(this.mClickListener);
        this.hkj.Y(this.hkm);
        this.hkj.e(this.hkn);
        bIq();
        this.haW = new com.baidu.tbadk.core.view.a(this.acd);
        this.haW.c(this.hbf);
        bIo();
        this.hkd.b(this.aDN);
        this.fgD = new com.baidu.tieba.write.b();
        this.fgD.vA(d.C0082d.cp_cont_i);
        this.fgD.vB(d.C0082d.cp_cont_h_alpha85);
    }

    private void bIo() {
        this.hkl = new com.baidu.tieba.write.transmit.model.a(this.acd.getUniqueId());
        this.hkl.a(this.hbe);
        if (this.hkd.getWriteData() != null) {
            this.hkl.setForumId(this.hkd.getWriteData().getForumId());
        }
    }

    protected void bIp() {
        this.hkj.bIC();
    }

    protected void bIq() {
        this.hkj.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ee(List<SimpleForum> list) {
        WriteData writeData = this.hkd.getWriteData();
        if (writeData != null) {
            this.haW.aE(false);
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
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.acd.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bwY() {
        if (ab.aJ(this.acd.getPageActivity())) {
            com.baidu.adp.lib.d.a.fc().a(true, this.boe);
        }
    }

    public void destroy() {
        if (this.hkl != null) {
            this.hkl.destroy();
        }
        if (this.hkk != null) {
            this.hkk.destroy();
        }
        if (this.hkd != null) {
            this.hkd.cancelLoadData();
        }
    }

    public void bIr() {
        this.hkl.setThreadContent(this.hkj.bIx());
        this.hkl.Om();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(boolean z) {
        if (this.hkj.bIz() != null && this.hkj.bIx() != null) {
            int selectionEnd = this.hkj.bIz().getSelectionEnd();
            SpannableStringBuilder b = this.fgD.b(this.hkj.bIz().getText());
            if (b != null) {
                this.fgD.nT(true);
                this.hkj.bIz().setText(b);
                if (z && this.fgD.bET() >= 0) {
                    this.hkj.bIz().requestFocus();
                    this.hkj.bIz().setSelection(this.fgD.bET());
                } else {
                    this.hkj.bIz().setSelection(selectionEnd);
                }
                this.fgD.nS(this.fgD.bET() >= 0);
            }
        }
    }

    public boolean bIs() {
        if (this.fgD.bEU()) {
            this.acd.showToast(this.fgD.bEW());
            oa(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fgD.onChangeSkinType();
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
                    this.acd.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.hkd.getWriteData()) != null && this.hkk.bGd() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hkl.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bIt();
                } else if (ab.aJ(this.acd.getPageActivity())) {
                    com.baidu.adp.lib.d.a.fc().a(true, new a.InterfaceC0004a() { // from class: com.baidu.tieba.write.write.i.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                i.this.mLat = String.valueOf(address.getLatitude());
                                i.this.mLng = String.valueOf(address.getLongitude());
                            }
                            i.this.bIt();
                        }
                    });
                }
                this.hkj.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12006:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.acd.showToast(postWriteCallBackData.getErrorString());
                        this.fgD.aB(postWriteCallBackData.getSensitiveWords());
                        if (!v.w(this.fgD.bES())) {
                            oa(true);
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

    public void bIt() {
        this.hkd.e("", this.hkj.bIx(), this.hkk.bGd().linkUrl, this.hkk.bGd().linkUrlCode, this.mLat, this.mLng);
    }
}
