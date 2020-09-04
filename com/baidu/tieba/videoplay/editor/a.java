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
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes18.dex */
public class a extends e {
    private final NewWriteModel.d eMH;
    private NewWriteModel eMt;
    private TbPageContext<?> efr;
    private com.baidu.tieba.write.c iUe;
    private String mForumId;
    private String mForumName;
    public VideoItemData mFs;
    private InterfaceC0823a mGk;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC0823a {
        void wS(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.eMH = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.eMt != null) {
                    if (a.this.brw() != null) {
                        a.this.brw().hide();
                    }
                    if (a.this.mGk != null) {
                        a.this.mGk.wS(false);
                    }
                    WriteData cLa = writeData == null ? a.this.eMt.cLa() : writeData;
                    if (z) {
                        a.this.iUe.Sw(null);
                        a.this.iUe.bf(null);
                        a.this.iUe.wZ(false);
                        a.this.dEX();
                        a.this.resetData();
                        if (cLa != null) {
                            String string = a.this.bmF().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cLa.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.bmF().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cLa != null && agVar != null && !TextUtils.isEmpty(agVar.bmY())) {
                        cLa.setVcodeMD5(agVar.getVcode_md5());
                        cLa.setVcodeUrl(agVar.getVcode_pic_url());
                        cLa.setVcodeExtra(agVar.bmZ());
                        if (com.baidu.tbadk.t.a.CP(agVar.bmY())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.efr.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cLa, false, agVar.bmY())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.efr.getPageActivity(), cLa, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.efr.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cLa, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Sm(postWriteCallBackData.getErrorString());
                        a.this.iUe.bf(postWriteCallBackData.getSensitiveWords());
                        a.this.iUe.Sw(postWriteCallBackData.getErrorString());
                        if (!y.isEmpty(a.this.iUe.dFD())) {
                            a.this.pS(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.HX(postWriteCallBackData.getErrorCode()))) {
                        a.this.aq(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Sm(postWriteCallBackData.getErrorString());
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
                if (a.this.iUe != null) {
                    if (!a.this.iUe.dFG()) {
                        a.this.pS(false);
                    }
                    a.this.iUe.xa(false);
                }
            }
        };
        editorTools.jj(true);
        this.iUe = new com.baidu.tieba.write.c();
        this.iUe.Js(R.color.cp_cont_h_alpha85);
        this.iUe.Jr(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.efr = tbPageContext;
    }

    public TbPageContext<?> bmF() {
        return this.efr;
    }

    public void Ca(String str) {
        this.mPostContent = str;
    }

    public void az(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (brw() != null && (brw().qe(28) instanceof c) && ((c) brw().qe(28)).getInputView() != null) {
            EditText inputView = ((c) brw().qe(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.mFs = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(int i, String str) {
        if (AntiHelper.by(i, str)) {
            AntiHelper.a(this.efr.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            Ce(str);
        } else {
            Sm(str);
        }
    }

    private void Ce(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bmF().getPageActivity());
        aVar.zA(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bmF()).bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEX() {
        if (brw() != null) {
            brw().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            brw().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            brw().hide();
        }
        if (this.mGk != null) {
            this.mGk.wS(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.eMt != null) {
            this.eMt.d((WriteData) null);
            this.eMt.wi(false);
        }
    }

    public void onDestroy() {
        if (this.eMt != null) {
            this.eMt.cancelLoadData();
        }
    }

    public void bsv() {
        if (this.eMt == null) {
            this.eMt = new NewWriteModel(this.efr);
            this.eMt.b(this.eMH);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.mFs != null && this.mFs.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.mFs.baijiahaoData);
        }
        this.eMt.d(writeData);
        this.eMt.dxX();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.eMH.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.eMt.cLa(), null);
                    return;
                } else if (i2 == -1) {
                    dEX();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cqd() {
        if (brw() != null && (brw().qe(28) instanceof c) && ((c) brw().qe(28)).getInputView() != null && ((c) brw().qe(28)).getInputView().getText() != null) {
            ((c) brw().qe(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS(boolean z) {
        if (brw() != null && (brw().qe(28) instanceof c) && ((c) brw().qe(28)).getInputView() != null && ((c) brw().qe(28)).getInputView().getText() != null) {
            EditText inputView = ((c) brw().qe(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder c = this.iUe.c(inputView.getText());
            if (c != null) {
                this.iUe.xa(true);
                inputView.setText(c);
                if (z && this.iUe.dFE() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.iUe.dFE());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.iUe.wZ(this.iUe.dFE() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sm(String str) {
        if (this.efr != null && !StringUtils.isNull(str)) {
            this.efr.showToast(str);
        }
    }

    public void a(InterfaceC0823a interfaceC0823a) {
        this.mGk = interfaceC0823a;
    }

    public void dEY() {
        aq aqVar = new aq("c13026");
        aqVar.dD("tid", this.mThreadId);
        aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
        aqVar.dD("fid", this.mForumId);
        TiebaStatic.log(aqVar);
    }
}
