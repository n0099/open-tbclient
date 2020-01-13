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
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes9.dex */
public class a extends d {
    private TbPageContext<?> cRe;
    private NewWriteModel duf;
    private final NewWriteModel.d dut;
    private com.baidu.tieba.write.c heO;
    private InterfaceC0620a kGb;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0620a {
        void tv(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.dut = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.duf != null) {
                    if (a.this.aLV() != null) {
                        a.this.aLV().hide();
                    }
                    if (a.this.kGb != null) {
                        a.this.kGb.tv(false);
                    }
                    WriteData cGm = writeData == null ? a.this.duf.cGm() : writeData;
                    if (z) {
                        a.this.heO.Kx(null);
                        a.this.heO.aV(null);
                        a.this.heO.tC(false);
                        a.this.cRL();
                        a.this.resetData();
                        if (cGm != null) {
                            String string = a.this.aGW().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cGm.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.aGW().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cGm != null && zVar != null && !TextUtils.isEmpty(zVar.aHk())) {
                        cGm.setVcodeMD5(zVar.getVcode_md5());
                        cGm.setVcodeUrl(zVar.getVcode_pic_url());
                        cGm.setVcodeExtra(zVar.aHl());
                        if (com.baidu.tbadk.s.a.vG(zVar.aHk())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.cRe.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cGm, false, zVar.aHk())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.cRe.getPageActivity(), cGm, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.cRe.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cGm, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Ku(postWriteCallBackData.getErrorString());
                        a.this.heO.aV(postWriteCallBackData.getSensitiveWords());
                        a.this.heO.Kx(postWriteCallBackData.getErrorString());
                        if (!v.isEmpty(a.this.heO.cSK())) {
                            a.this.mN(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Cx(postWriteCallBackData.getErrorCode()))) {
                        a.this.R(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Ku(postWriteCallBackData.getErrorString());
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
                if (a.this.heO != null) {
                    if (!a.this.heO.cSN()) {
                        a.this.mN(false);
                    }
                    a.this.heO.tD(false);
                }
            }
        };
        editorTools.gu(true);
        this.heO = new com.baidu.tieba.write.c();
        this.heO.DV(R.color.cp_cont_h_alpha85);
        this.heO.DU(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cRe = tbPageContext;
    }

    public TbPageContext<?> aGW() {
        return this.cRe;
    }

    public void uV(String str) {
        this.mPostContent = str;
    }

    public void aw(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (aLV() != null && (aLV().lX(28) instanceof c) && ((c) aLV().lX(28)).getInputView() != null) {
            EditText inputView = ((c) aLV().lX(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, String str) {
        if (AntiHelper.bc(i, str)) {
            AntiHelper.a(this.cRe.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            uZ(str);
        } else {
            Ku(str);
        }
    }

    private void uZ(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aGW().getPageActivity());
        aVar.sC(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aGW()).aCp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRL() {
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            aLV().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            aLV().hide();
        }
        if (this.kGb != null) {
            this.kGb.tv(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.duf != null) {
            this.duf.d((WriteData) null);
            this.duf.sO(false);
        }
    }

    public void onDestroy() {
        if (this.duf != null) {
            this.duf.cancelLoadData();
        }
    }

    public void aMQ() {
        if (this.duf == null) {
            this.duf = new NewWriteModel(this.cRe);
            this.duf.b(this.dut);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        this.duf.d(writeData);
        this.duf.cKK();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.dut.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.duf.cGm(), null);
                    return;
                } else if (i2 == -1) {
                    cRL();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mN(boolean z) {
        if (aLV() != null && (aLV().lX(28) instanceof c) && ((c) aLV().lX(28)).getInputView() != null && ((c) aLV().lX(28)).getInputView().getText() != null) {
            EditText inputView = ((c) aLV().lX(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder a = this.heO.a(inputView.getText());
            if (a != null) {
                this.heO.tD(true);
                inputView.setText(a);
                if (z && this.heO.cSL() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.heO.cSL());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.heO.tC(this.heO.cSL() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ku(String str) {
        if (this.cRe != null && !StringUtils.isNull(str)) {
            this.cRe.showToast(str);
        }
    }

    public void a(InterfaceC0620a interfaceC0620a) {
        this.kGb = interfaceC0620a;
    }

    public void cRM() {
        an anVar = new an("c13026");
        anVar.cp("tid", this.mThreadId);
        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.cp("fid", this.mForumId);
        TiebaStatic.log(anVar);
    }
}
