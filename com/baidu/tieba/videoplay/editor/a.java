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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class a extends d {
    private String cFW;
    private NewWriteModel cFZ;
    private final NewWriteModel.d cGo;
    private TbPageContext<?> ceu;
    private com.baidu.tieba.write.b gnK;
    private InterfaceC0536a jIq;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0536a {
        void rD(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.cFW = "";
        this.mThreadId = null;
        this.cGo = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.cFZ != null) {
                    if (a.this.atX() != null) {
                        a.this.atX().hide();
                    }
                    if (a.this.jIq != null) {
                        a.this.jIq.rD(false);
                    }
                    WriteData cla = writeData == null ? a.this.cFZ.cla() : writeData;
                    if (z) {
                        a.this.gnK.Fv(null);
                        a.this.gnK.aM(null);
                        a.this.gnK.rK(false);
                        a.this.cwB();
                        a.this.resetData();
                        if (cla != null) {
                            String string = a.this.apb().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cla.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.apb().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cla != null && yVar != null && !TextUtils.isEmpty(yVar.apr())) {
                        cla.setVcodeMD5(yVar.getVcode_md5());
                        cla.setVcodeUrl(yVar.getVcode_pic_url());
                        cla.setVcodeExtra(yVar.aps());
                        if (com.baidu.tbadk.v.a.qv(yVar.apr())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.ceu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cla, false, yVar.apr())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.ceu.getPageActivity(), cla, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.ceu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cla, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Fs(postWriteCallBackData.getErrorString());
                        a.this.gnK.aM(postWriteCallBackData.getSensitiveWords());
                        a.this.gnK.Fv(postWriteCallBackData.getErrorString());
                        if (!v.isEmpty(a.this.gnK.cxw())) {
                            a.this.lp(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.zX(postWriteCallBackData.getErrorCode()))) {
                        a.this.H(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Fs(postWriteCallBackData.getErrorString());
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
                if (a.this.gnK != null) {
                    if (!a.this.gnK.cxz()) {
                        a.this.lp(false);
                    }
                    a.this.gnK.rL(false);
                }
            }
        };
        editorTools.fe(true);
        this.gnK = new com.baidu.tieba.write.b();
        this.gnK.Bs(R.color.cp_cont_h_alpha85);
        this.gnK.Br(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.ceu = tbPageContext;
    }

    public TbPageContext<?> apb() {
        return this.ceu;
    }

    public void pL(String str) {
        this.cFW = str;
    }

    public void ah(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (atX() != null && (atX().jK(28) instanceof c) && ((c) atX().jK(28)).getInputView() != null) {
            EditText inputView = ((c) atX().jK(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i, String str) {
        if (AntiHelper.aG(i, str)) {
            AntiHelper.a(this.ceu.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            pP(str);
        } else {
            Fs(str);
        }
    }

    private void pP(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(apb().getPageActivity());
        aVar.nn(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(apb()).akM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwB() {
        if (atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            atX().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            atX().hide();
        }
        if (this.jIq != null) {
            this.jIq.rD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.cFZ != null) {
            this.cFZ.d((WriteData) null);
            this.cFZ.qV(false);
        }
    }

    public void onDestroy() {
        if (this.cFZ != null) {
            this.cFZ.cancelLoadData();
        }
    }

    public void auP() {
        if (this.cFZ == null) {
            this.cFZ = new NewWriteModel(this.ceu);
            this.cFZ.b(this.cGo);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.cFW);
        this.cFZ.d(writeData);
        this.cFZ.cpC();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.cGo.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.cFZ.cla(), null);
                    return;
                } else if (i2 == -1) {
                    cwB();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp(boolean z) {
        if (atX() != null && (atX().jK(28) instanceof c) && ((c) atX().jK(28)).getInputView() != null && ((c) atX().jK(28)).getInputView().getText() != null) {
            EditText inputView = ((c) atX().jK(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder a = this.gnK.a(inputView.getText());
            if (a != null) {
                this.gnK.rL(true);
                inputView.setText(a);
                if (z && this.gnK.cxx() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.gnK.cxx());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.gnK.rK(this.gnK.cxx() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fs(String str) {
        if (this.ceu != null && !StringUtils.isNull(str)) {
            this.ceu.showToast(str);
        }
    }

    public void a(InterfaceC0536a interfaceC0536a) {
        this.jIq = interfaceC0536a;
    }

    public void cwC() {
        an anVar = new an("c13026");
        anVar.bS("tid", this.mThreadId);
        anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.bS("fid", this.mForumId);
        TiebaStatic.log(anVar);
    }
}
