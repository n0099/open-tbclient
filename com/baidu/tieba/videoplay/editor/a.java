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
    private String ctA;
    private NewWriteModel ctD;
    private final NewWriteModel.d ctR;
    private com.baidu.tieba.write.b gmt;
    private InterfaceC0430a jFN;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0430a {
        void rQ(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.ctA = "";
        this.mThreadId = null;
        this.ctR = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.ctD != null) {
                    if (a.this.arY() != null) {
                        a.this.arY().hide();
                    }
                    if (a.this.jFN != null) {
                        a.this.jFN.rQ(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.ctD.getWriteData() : writeData;
                    if (z) {
                        a.this.gmt.GA(null);
                        a.this.gmt.aI(null);
                        a.this.gmt.rZ(false);
                        a.this.cxE();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.amk().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.f(a.this.amk().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.amE())) {
                        writeData2.setVcodeMD5(xVar.getVcode_md5());
                        writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(xVar.amF());
                        if (com.baidu.tbadk.v.a.ru(xVar.amE())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), 12006, writeData2, false, xVar.amE())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, 12006)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Gp(postWriteCallBackData.getErrorString());
                        a.this.gmt.aI(postWriteCallBackData.getSensitiveWords());
                        a.this.gmt.GA(postWriteCallBackData.getErrorString());
                        if (!v.aa(a.this.gmt.cze())) {
                            a.this.ly(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Bj(postWriteCallBackData.getErrorCode()))) {
                        a.this.F(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Gp(postWriteCallBackData.getErrorString());
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
                if (a.this.gmt != null) {
                    if (!a.this.gmt.czh()) {
                        a.this.ly(false);
                    }
                    a.this.gmt.sa(false);
                }
            }
        };
        editorTools.fh(true);
        this.gmt = new com.baidu.tieba.write.b();
        this.gmt.CJ(R.color.cp_cont_h_alpha85);
        this.gmt.CI(R.color.cp_btn_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> amk() {
        return this.mContext;
    }

    public void qr(String str) {
        this.ctA = str;
    }

    public void ad(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (arY() != null && (arY().kp(28) instanceof c) && ((c) arY().kp(28)).getInputView() != null) {
            EditText inputView = ((c) arY().kp(28)).getInputView();
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
            Gp(str);
        }
    }

    private void qv(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(amk().getPageActivity());
        aVar.mO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(amk()).agI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxE() {
        if (arY() != null) {
            arY().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            arY().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            arY().hide();
        }
        if (this.jFN != null) {
            this.jFN.rQ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.ctD != null) {
            this.ctD.setWriteData(null);
            this.ctD.ri(false);
        }
    }

    public void onDestroy() {
        if (this.ctD != null) {
            this.ctD.cancelLoadData();
        }
    }

    public void asR() {
        if (this.ctD == null) {
            this.ctD = new NewWriteModel(this.mContext);
            this.ctD.b(this.ctR);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.ctA);
        this.ctD.setWriteData(writeData);
        this.ctD.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 12006:
                if (i2 == 0) {
                    this.ctR.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.ctD.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    cxE();
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
        if (arY() != null && (arY().kp(28) instanceof c) && ((c) arY().kp(28)).getInputView() != null && ((c) arY().kp(28)).getInputView().getText() != null) {
            EditText inputView = ((c) arY().kp(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.gmt.b(inputView.getText());
            if (b != null) {
                this.gmt.sa(true);
                inputView.setText(b);
                if (z && this.gmt.czf() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.gmt.czf());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.gmt.rZ(this.gmt.czf() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gp(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0430a interfaceC0430a) {
        this.jFN = interfaceC0430a;
    }

    public void cxF() {
        an anVar = new an("c13026");
        anVar.bT("tid", this.mThreadId);
        anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.bT("fid", this.mForumId);
        TiebaStatic.log(anVar);
    }
}
