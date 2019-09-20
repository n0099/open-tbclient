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
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class a extends d {
    private String cuE;
    private NewWriteModel cuH;
    private final NewWriteModel.d cuV;
    private com.baidu.tieba.write.b gpc;
    private InterfaceC0441a jJp;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0441a {
        void rU(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.cuE = "";
        this.mThreadId = null;
        this.cuV = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.cuH != null) {
                    if (a.this.asm() != null) {
                        a.this.asm().hide();
                    }
                    if (a.this.jJp != null) {
                        a.this.jJp.rU(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.cuH.getWriteData() : writeData;
                    if (z) {
                        a.this.gpc.Hb(null);
                        a.this.gpc.aI(null);
                        a.this.gpc.sd(false);
                        a.this.cyO();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.amy().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.f(a.this.amy().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && yVar != null && !TextUtils.isEmpty(yVar.amS())) {
                        writeData2.setVcodeMD5(yVar.getVcode_md5());
                        writeData2.setVcodeUrl(yVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(yVar.amT());
                        if (com.baidu.tbadk.v.a.rF(yVar.amS())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), 12006, writeData2, false, yVar.amS())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, 12006)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.GQ(postWriteCallBackData.getErrorString());
                        a.this.gpc.aI(postWriteCallBackData.getSensitiveWords());
                        a.this.gpc.Hb(postWriteCallBackData.getErrorString());
                        if (!v.aa(a.this.gpc.cAn())) {
                            a.this.lB(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Bp(postWriteCallBackData.getErrorCode()))) {
                        a.this.F(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.GQ(postWriteCallBackData.getErrorString());
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
                if (a.this.gpc != null) {
                    if (!a.this.gpc.cAq()) {
                        a.this.lB(false);
                    }
                    a.this.gpc.se(false);
                }
            }
        };
        editorTools.fk(true);
        this.gpc = new com.baidu.tieba.write.b();
        this.gpc.CP(R.color.cp_cont_h_alpha85);
        this.gpc.CO(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> amy() {
        return this.mContext;
    }

    public void qC(String str) {
        this.cuE = str;
    }

    public void af(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (asm() != null && (asm().kt(28) instanceof c) && ((c) asm().kt(28)).getInputView() != null) {
            EditText inputView = ((c) asm().kt(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i, String str) {
        if (AntiHelper.aG(i, str)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            qG(str);
        } else {
            GQ(str);
        }
    }

    private void qG(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(amy().getPageActivity());
        aVar.mQ(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(amy()).agO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyO() {
        if (asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            asm().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            asm().hide();
        }
        if (this.jJp != null) {
            this.jJp.rU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.cuH != null) {
            this.cuH.setWriteData(null);
            this.cuH.rm(false);
        }
    }

    public void onDestroy() {
        if (this.cuH != null) {
            this.cuH.cancelLoadData();
        }
    }

    public void atf() {
        if (this.cuH == null) {
            this.cuH = new NewWriteModel(this.mContext);
            this.cuH.b(this.cuV);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.cuE);
        this.cuH.setWriteData(writeData);
        this.cuH.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 12006:
                if (i2 == 0) {
                    this.cuV.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.cuH.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    cyO();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lB(boolean z) {
        if (asm() != null && (asm().kt(28) instanceof c) && ((c) asm().kt(28)).getInputView() != null && ((c) asm().kt(28)).getInputView().getText() != null) {
            EditText inputView = ((c) asm().kt(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.gpc.b(inputView.getText());
            if (b != null) {
                this.gpc.se(true);
                inputView.setText(b);
                if (z && this.gpc.cAo() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.gpc.cAo());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.gpc.sd(this.gpc.cAo() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GQ(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0441a interfaceC0441a) {
        this.jJp = interfaceC0441a;
    }

    public void cyP() {
        an anVar = new an("c13026");
        anVar.bT("tid", this.mThreadId);
        anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.bT("fid", this.mForumId);
        TiebaStatic.log(anVar);
    }
}
