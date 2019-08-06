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
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class a extends d {
    private String ctH;
    private NewWriteModel ctK;
    private final NewWriteModel.d ctY;
    private com.baidu.tieba.write.b gnl;
    private InterfaceC0430a jGU;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0430a {
        void rR(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.ctH = "";
        this.mThreadId = null;
        this.ctY = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.ctK != null) {
                    if (a.this.asa() != null) {
                        a.this.asa().hide();
                    }
                    if (a.this.jGU != null) {
                        a.this.jGU.rR(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.ctK.getWriteData() : writeData;
                    if (z) {
                        a.this.gnl.GB(null);
                        a.this.gnl.aI(null);
                        a.this.gnl.sa(false);
                        a.this.cya();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.amm().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.f(a.this.amm().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.amG())) {
                        writeData2.setVcodeMD5(xVar.getVcode_md5());
                        writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(xVar.amH());
                        if (com.baidu.tbadk.v.a.ru(xVar.amG())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), 12006, writeData2, false, xVar.amG())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, 12006)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Gq(postWriteCallBackData.getErrorString());
                        a.this.gnl.aI(postWriteCallBackData.getSensitiveWords());
                        a.this.gnl.GB(postWriteCallBackData.getErrorString());
                        if (!v.aa(a.this.gnl.czz())) {
                            a.this.ly(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Bl(postWriteCallBackData.getErrorCode()))) {
                        a.this.F(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Gq(postWriteCallBackData.getErrorString());
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
                if (a.this.gnl != null) {
                    if (!a.this.gnl.czC()) {
                        a.this.ly(false);
                    }
                    a.this.gnl.sb(false);
                }
            }
        };
        editorTools.fh(true);
        this.gnl = new com.baidu.tieba.write.b();
        this.gnl.CL(R.color.cp_cont_h_alpha85);
        this.gnl.CK(R.color.cp_btn_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> amm() {
        return this.mContext;
    }

    public void qr(String str) {
        this.ctH = str;
    }

    public void ad(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (asa() != null && (asa().kq(28) instanceof c) && ((c) asa().kq(28)).getInputView() != null) {
            EditText inputView = ((c) asa().kq(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i, String str) {
        if (AntiHelper.aG(i, str)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            qv(str);
        } else {
            Gq(str);
        }
    }

    private void qv(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(amm().getPageActivity());
        aVar.mO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(amm()).agK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cya() {
        if (asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            asa().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            asa().hide();
        }
        if (this.jGU != null) {
            this.jGU.rR(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.ctK != null) {
            this.ctK.setWriteData(null);
            this.ctK.rj(false);
        }
    }

    public void onDestroy() {
        if (this.ctK != null) {
            this.ctK.cancelLoadData();
        }
    }

    public void asT() {
        if (this.ctK == null) {
            this.ctK = new NewWriteModel(this.mContext);
            this.ctK.b(this.ctY);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.ctH);
        this.ctK.setWriteData(writeData);
        this.ctK.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 12006:
                if (i2 == 0) {
                    this.ctY.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.ctK.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    cya();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ly(boolean z) {
        if (asa() != null && (asa().kq(28) instanceof c) && ((c) asa().kq(28)).getInputView() != null && ((c) asa().kq(28)).getInputView().getText() != null) {
            EditText inputView = ((c) asa().kq(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.gnl.b(inputView.getText());
            if (b != null) {
                this.gnl.sb(true);
                inputView.setText(b);
                if (z && this.gnl.czA() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.gnl.czA());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.gnl.sa(this.gnl.czA() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0430a interfaceC0430a) {
        this.jGU = interfaceC0430a;
    }

    public void cyb() {
        an anVar = new an("c13026");
        anVar.bT("tid", this.mThreadId);
        anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.bT("fid", this.mForumId);
        TiebaStatic.log(anVar);
    }
}
