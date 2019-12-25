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
/* loaded from: classes8.dex */
public class a extends d {
    private TbPageContext<?> cQU;
    private NewWriteModel dtU;
    private final NewWriteModel.d dui;
    private com.baidu.tieba.write.c hbl;
    private InterfaceC0615a kCz;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0615a {
        void tj(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.dui = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.dtU != null) {
                    if (a.this.aLC() != null) {
                        a.this.aLC().hide();
                    }
                    if (a.this.kCz != null) {
                        a.this.kCz.tj(false);
                    }
                    WriteData cFi = writeData == null ? a.this.dtU.cFi() : writeData;
                    if (z) {
                        a.this.hbl.Kn(null);
                        a.this.hbl.aV(null);
                        a.this.hbl.tq(false);
                        a.this.cQI();
                        a.this.resetData();
                        if (cFi != null) {
                            String string = a.this.aGD().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cFi.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.f(a.this.aGD().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cFi != null && yVar != null && !TextUtils.isEmpty(yVar.aGQ())) {
                        cFi.setVcodeMD5(yVar.getVcode_md5());
                        cFi.setVcodeUrl(yVar.getVcode_pic_url());
                        cFi.setVcodeExtra(yVar.aGR());
                        if (com.baidu.tbadk.s.a.vB(yVar.aGQ())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.cQU.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cFi, false, yVar.aGQ())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.cQU.getPageActivity(), cFi, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.cQU.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cFi, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Kk(postWriteCallBackData.getErrorString());
                        a.this.hbl.aV(postWriteCallBackData.getSensitiveWords());
                        a.this.hbl.Kn(postWriteCallBackData.getErrorString());
                        if (!v.isEmpty(a.this.hbl.cRH())) {
                            a.this.mC(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Cs(postWriteCallBackData.getErrorCode()))) {
                        a.this.P(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Kk(postWriteCallBackData.getErrorString());
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
                if (a.this.hbl != null) {
                    if (!a.this.hbl.cRK()) {
                        a.this.mC(false);
                    }
                    a.this.hbl.tr(false);
                }
            }
        };
        editorTools.gp(true);
        this.hbl = new com.baidu.tieba.write.c();
        this.hbl.DP(R.color.cp_cont_h_alpha85);
        this.hbl.DO(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cQU = tbPageContext;
    }

    public TbPageContext<?> aGD() {
        return this.cQU;
    }

    public void uQ(String str) {
        this.mPostContent = str;
    }

    public void av(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (aLC() != null && (aLC().lX(28) instanceof c) && ((c) aLC().lX(28)).getInputView() != null) {
            EditText inputView = ((c) aLC().lX(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i, String str) {
        if (AntiHelper.aW(i, str)) {
            AntiHelper.a(this.cQU.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            uU(str);
        } else {
            Kk(str);
        }
    }

    private void uU(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aGD().getPageActivity());
        aVar.sz(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aGD()).aBW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQI() {
        if (aLC() != null) {
            aLC().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            aLC().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            aLC().hide();
        }
        if (this.kCz != null) {
            this.kCz.tj(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.dtU != null) {
            this.dtU.d((WriteData) null);
            this.dtU.sC(false);
        }
    }

    public void onDestroy() {
        if (this.dtU != null) {
            this.dtU.cancelLoadData();
        }
    }

    public void aMx() {
        if (this.dtU == null) {
            this.dtU = new NewWriteModel(this.cQU);
            this.dtU.b(this.dui);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        this.dtU.d(writeData);
        this.dtU.cJG();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.dui.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.dtU.cFi(), null);
                    return;
                } else if (i2 == -1) {
                    cQI();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mC(boolean z) {
        if (aLC() != null && (aLC().lX(28) instanceof c) && ((c) aLC().lX(28)).getInputView() != null && ((c) aLC().lX(28)).getInputView().getText() != null) {
            EditText inputView = ((c) aLC().lX(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder a = this.hbl.a(inputView.getText());
            if (a != null) {
                this.hbl.tr(true);
                inputView.setText(a);
                if (z && this.hbl.cRI() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.hbl.cRI());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.hbl.tq(this.hbl.cRI() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kk(String str) {
        if (this.cQU != null && !StringUtils.isNull(str)) {
            this.cQU.showToast(str);
        }
    }

    public void a(InterfaceC0615a interfaceC0615a) {
        this.kCz = interfaceC0615a;
    }

    public void cQJ() {
        an anVar = new an("c13026");
        anVar.cp("tid", this.mThreadId);
        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.cp("fid", this.mForumId);
        TiebaStatic.log(anVar);
    }
}
