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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes23.dex */
public class a extends e {
    private NewWriteModel ePk;
    private final NewWriteModel.d ePy;
    private TbPageContext<?> ehG;
    private com.baidu.tieba.write.c jcK;
    private String mForumId;
    private String mForumName;
    private InterfaceC0820a mPW;
    public VideoItemData mPc;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0820a {
        void xb(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.ePy = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.ePk != null) {
                    if (a.this.bsv() != null) {
                        a.this.bsv().hide();
                    }
                    if (a.this.mPW != null) {
                        a.this.mPW.xb(false);
                    }
                    WriteData cOG = writeData == null ? a.this.ePk.cOG() : writeData;
                    if (z) {
                        a.this.jcK.SW(null);
                        a.this.jcK.bh(null);
                        a.this.jcK.xi(false);
                        a.this.dIR();
                        a.this.resetData();
                        if (cOG != null) {
                            String string = a.this.bnz().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cOG.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.bnz().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cOG != null && ahVar != null && !TextUtils.isEmpty(ahVar.bnS())) {
                        cOG.setVcodeMD5(ahVar.getVcode_md5());
                        cOG.setVcodeUrl(ahVar.getVcode_pic_url());
                        cOG.setVcodeExtra(ahVar.bnT());
                        if (com.baidu.tbadk.t.a.Dl(ahVar.bnS())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.ehG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cOG, false, ahVar.bnS())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.ehG.getPageActivity(), cOG, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.ehG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cOG, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.SM(postWriteCallBackData.getErrorString());
                        a.this.jcK.bh(postWriteCallBackData.getSensitiveWords());
                        a.this.jcK.SW(postWriteCallBackData.getErrorString());
                        if (!y.isEmpty(a.this.jcK.dJx())) {
                            a.this.qa(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.IA(postWriteCallBackData.getErrorCode()))) {
                        a.this.ar(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.SM(postWriteCallBackData.getErrorString());
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
                if (a.this.jcK != null) {
                    if (!a.this.jcK.dJA()) {
                        a.this.qa(false);
                    }
                    a.this.jcK.xj(false);
                }
            }
        };
        editorTools.jh(true);
        this.jcK = new com.baidu.tieba.write.c();
        this.jcK.JW(R.color.cp_cont_h_alpha85);
        this.jcK.JV(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.ehG = tbPageContext;
    }

    public TbPageContext<?> bnz() {
        return this.ehG;
    }

    public void Cw(String str) {
        this.mPostContent = str;
    }

    public void az(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (bsv() != null && (bsv().qr(28) instanceof c) && ((c) bsv().qr(28)).getInputView() != null) {
            EditText inputView = ((c) bsv().qr(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.mPc = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(int i, String str) {
        if (AntiHelper.bC(i, str)) {
            AntiHelper.a(this.ehG.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            CA(str);
        } else {
            SM(str);
        }
    }

    private void CA(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bnz().getPageActivity());
        aVar.zV(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bnz()).bia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIR() {
        if (bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            bsv().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            bsv().hide();
        }
        if (this.mPW != null) {
            this.mPW.xb(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.ePk != null) {
            this.ePk.e((WriteData) null);
            this.ePk.wr(false);
        }
    }

    public void onDestroy() {
        if (this.ePk != null) {
            this.ePk.cancelLoadData();
        }
    }

    public void btz() {
        if (this.ePk == null) {
            this.ePk = new NewWriteModel(this.ehG);
            this.ePk.b(this.ePy);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.mPc != null && this.mPc.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.mPc.baijiahaoData);
        }
        this.ePk.e(writeData);
        this.ePk.dBQ();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.ePy.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.ePk.cOG(), null);
                    return;
                } else if (i2 == -1) {
                    dIR();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void ctq() {
        if (bsv() != null && (bsv().qr(28) instanceof c) && ((c) bsv().qr(28)).getInputView() != null && ((c) bsv().qr(28)).getInputView().getText() != null) {
            ((c) bsv().qr(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa(boolean z) {
        if (bsv() != null && (bsv().qr(28) instanceof c) && ((c) bsv().qr(28)).getInputView() != null && ((c) bsv().qr(28)).getInputView().getText() != null) {
            EditText inputView = ((c) bsv().qr(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder c = this.jcK.c(inputView.getText());
            if (c != null) {
                this.jcK.xj(true);
                inputView.setText(c);
                if (z && this.jcK.dJy() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.jcK.dJy());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.jcK.xi(this.jcK.dJy() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SM(String str) {
        if (this.ehG != null && !StringUtils.isNull(str)) {
            this.ehG.showToast(str);
        }
    }

    public void a(InterfaceC0820a interfaceC0820a) {
        this.mPW = interfaceC0820a;
    }

    public void dIS() {
        aq aqVar = new aq("c13026");
        aqVar.dF("tid", this.mThreadId);
        aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
        aqVar.dF("fid", this.mForumId);
        TiebaStatic.log(aqVar);
    }
}
