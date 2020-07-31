package com.baidu.tieba.videoplay.editor;

import android.content.Intent;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes18.dex */
public class a extends d {
    private TbPageContext<?> dVN;
    private NewWriteModel eBQ;
    private final NewWriteModel.d eCe;
    private com.baidu.tieba.write.c iEY;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;
    public VideoItemData mnk;
    private InterfaceC0771a moc;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC0771a {
        void wb(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.eBQ != null) {
                    if (a.this.biJ() != null) {
                        a.this.biJ().hide();
                    }
                    if (a.this.moc != null) {
                        a.this.moc.wb(false);
                    }
                    WriteData dhF = writeData == null ? a.this.eBQ.dhF() : writeData;
                    if (z) {
                        a.this.iEY.Py(null);
                        a.this.iEY.aZ(null);
                        a.this.iEY.wi(false);
                        a.this.dts();
                        a.this.resetData();
                        if (dhF != null) {
                            String string = a.this.bdZ().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (dhF.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.f(a.this.bdZ().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (dhF != null && adVar != null && !TextUtils.isEmpty(adVar.beo())) {
                        dhF.setVcodeMD5(adVar.getVcode_md5());
                        dhF.setVcodeUrl(adVar.getVcode_pic_url());
                        dhF.setVcodeExtra(adVar.bep());
                        if (com.baidu.tbadk.t.a.Ay(adVar.beo())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.dVN.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dhF, false, adVar.beo())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.dVN.getPageActivity(), dhF, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.dVN.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dhF, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Po(postWriteCallBackData.getErrorString());
                        a.this.iEY.aZ(postWriteCallBackData.getSensitiveWords());
                        a.this.iEY.Py(postWriteCallBackData.getErrorString());
                        if (!x.isEmpty(a.this.iEY.dtY())) {
                            a.this.pk(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.FA(postWriteCallBackData.getErrorCode()))) {
                        a.this.as(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Po(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.a.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (a.this.iEY != null) {
                    if (!a.this.iEY.dub()) {
                        a.this.pk(false);
                    }
                    a.this.iEY.wj(false);
                }
            }
        };
        editorTools.iJ(true);
        this.iEY = new com.baidu.tieba.write.c();
        this.iEY.GW(R.color.cp_cont_h_alpha85);
        this.iEY.GV(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.dVN = tbPageContext;
    }

    public TbPageContext<?> bdZ() {
        return this.dVN;
    }

    public void zJ(String str) {
        this.mPostContent = str;
    }

    public void az(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (biJ() != null && (biJ().nT(28) instanceof c) && ((c) biJ().nT(28)).getInputView() != null) {
            EditText inputView = ((c) biJ().nT(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.mnk = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(int i, String str) {
        if (AntiHelper.bB(i, str)) {
            AntiHelper.a(this.dVN.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            zN(str);
        } else {
            Po(str);
        }
    }

    private void zN(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bdZ().getPageActivity());
        aVar.xl(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bdZ()).aYL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dts() {
        if (biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            biJ().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            biJ().hide();
        }
        if (this.moc != null) {
            this.moc.wb(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.eBQ != null) {
            this.eBQ.d((WriteData) null);
            this.eBQ.vr(false);
        }
    }

    public void onDestroy() {
        if (this.eBQ != null) {
            this.eBQ.cancelLoadData();
        }
    }

    public void bjI() {
        if (this.eBQ == null) {
            this.eBQ = new NewWriteModel(this.dVN);
            this.eBQ.b(this.eCe);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.mnk != null && this.mnk.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.mnk.baijiahaoData);
        }
        this.eBQ.d(writeData);
        this.eBQ.dmw();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.eCe.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.eBQ.dhF(), null);
                    return;
                } else if (i2 == -1) {
                    dts();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cfx() {
        if (biJ() != null && (biJ().nT(28) instanceof c) && ((c) biJ().nT(28)).getInputView() != null && ((c) biJ().nT(28)).getInputView().getText() != null) {
            ((c) biJ().nT(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pk(boolean z) {
        if (biJ() != null && (biJ().nT(28) instanceof c) && ((c) biJ().nT(28)).getInputView() != null && ((c) biJ().nT(28)).getInputView().getText() != null) {
            EditText inputView = ((c) biJ().nT(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder d = this.iEY.d(inputView.getText());
            if (d != null) {
                this.iEY.wj(true);
                inputView.setText(d);
                if (z && this.iEY.dtZ() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.iEY.dtZ());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.iEY.wi(this.iEY.dtZ() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Po(String str) {
        if (this.dVN != null && !StringUtils.isNull(str)) {
            this.dVN.showToast(str);
        }
    }

    public void a(InterfaceC0771a interfaceC0771a) {
        this.moc = interfaceC0771a;
    }

    public void dtt() {
        ap apVar = new ap("c13026");
        apVar.dn("tid", this.mThreadId);
        apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
        apVar.dn("fid", this.mForumId);
        TiebaStatic.log(apVar);
    }
}
