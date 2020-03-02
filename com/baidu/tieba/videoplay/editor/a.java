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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes11.dex */
public class a extends d {
    private TbPageContext<?> cVh;
    private final NewWriteModel.d dyA;
    private NewWriteModel dym;
    private com.baidu.tieba.write.c hgQ;
    public VideoItemData kGk;
    private InterfaceC0628a kHd;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0628a {
        void tz(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.dyA = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.dym != null) {
                    if (a.this.aOt() != null) {
                        a.this.aOt().hide();
                    }
                    if (a.this.kHd != null) {
                        a.this.kHd.tz(false);
                    }
                    WriteData cHU = writeData == null ? a.this.dym.cHU() : writeData;
                    if (z) {
                        a.this.hgQ.KK(null);
                        a.this.hgQ.aU(null);
                        a.this.hgQ.tG(false);
                        a.this.cTj();
                        a.this.resetData();
                        if (cHU != null) {
                            String string = a.this.aJq().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cHU.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.aJq().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cHU != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJF())) {
                        cHU.setVcodeMD5(aaVar.getVcode_md5());
                        cHU.setVcodeUrl(aaVar.getVcode_pic_url());
                        cHU.setVcodeExtra(aaVar.aJG());
                        if (com.baidu.tbadk.s.a.wa(aaVar.aJF())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.cVh.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cHU, false, aaVar.aJF())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.cVh.getPageActivity(), cHU, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.cVh.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cHU, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.KH(postWriteCallBackData.getErrorString());
                        a.this.hgQ.aU(postWriteCallBackData.getSensitiveWords());
                        a.this.hgQ.KK(postWriteCallBackData.getErrorString());
                        if (!v.isEmpty(a.this.hgQ.cUc())) {
                            a.this.mP(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.CD(postWriteCallBackData.getErrorCode()))) {
                        a.this.T(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.KH(postWriteCallBackData.getErrorString());
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
                if (a.this.hgQ != null) {
                    if (!a.this.hgQ.cUf()) {
                        a.this.mP(false);
                    }
                    a.this.hgQ.tH(false);
                }
            }
        };
        editorTools.gB(true);
        this.hgQ = new com.baidu.tieba.write.c();
        this.hgQ.Ea(R.color.cp_cont_h_alpha85);
        this.hgQ.DZ(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cVh = tbPageContext;
    }

    public TbPageContext<?> aJq() {
        return this.cVh;
    }

    public void vm(String str) {
        this.mPostContent = str;
    }

    public void aw(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (aOt() != null && (aOt().mp(28) instanceof c) && ((c) aOt().mp(28)).getInputView() != null) {
            EditText inputView = ((c) aOt().mp(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.kGk = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, String str) {
        if (AntiHelper.bb(i, str)) {
            AntiHelper.a(this.cVh.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            vq(str);
        } else {
            KH(str);
        }
    }

    private void vq(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aJq().getPageActivity());
        aVar.sS(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aJq()).aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTj() {
        if (aOt() != null) {
            aOt().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            aOt().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            aOt().hide();
        }
        if (this.kHd != null) {
            this.kHd.tz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.dym != null) {
            this.dym.d((WriteData) null);
            this.dym.sS(false);
        }
    }

    public void onDestroy() {
        if (this.dym != null) {
            this.dym.cancelLoadData();
        }
    }

    public void aPo() {
        if (this.dym == null) {
            this.dym = new NewWriteModel(this.cVh);
            this.dym.b(this.dyA);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.kGk != null && this.kGk.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.kGk.baijiahaoData);
        }
        this.dym.d(writeData);
        this.dym.cMj();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.dyA.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.dym.cHU(), null);
                    return;
                } else if (i2 == -1) {
                    cTj();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cTk() {
        if (aOt() != null && (aOt().mp(28) instanceof c) && ((c) aOt().mp(28)).getInputView() != null && ((c) aOt().mp(28)).getInputView().getText() != null) {
            ((c) aOt().mp(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mP(boolean z) {
        if (aOt() != null && (aOt().mp(28) instanceof c) && ((c) aOt().mp(28)).getInputView() != null && ((c) aOt().mp(28)).getInputView().getText() != null) {
            EditText inputView = ((c) aOt().mp(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder a = this.hgQ.a(inputView.getText());
            if (a != null) {
                this.hgQ.tH(true);
                inputView.setText(a);
                if (z && this.hgQ.cUd() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.hgQ.cUd());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.hgQ.tG(this.hgQ.cUd() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KH(String str) {
        if (this.cVh != null && !StringUtils.isNull(str)) {
            this.cVh.showToast(str);
        }
    }

    public void a(InterfaceC0628a interfaceC0628a) {
        this.kHd = interfaceC0628a;
    }

    public void cTl() {
        an anVar = new an("c13026");
        anVar.cy("tid", this.mThreadId);
        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.cy("fid", this.mForumId);
        TiebaStatic.log(anVar);
    }
}
