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
    private TbPageContext<?> cVv;
    private NewWriteModel dyM;
    private final NewWriteModel.d dza;
    private com.baidu.tieba.write.c hiD;
    private InterfaceC0629a kIW;
    public VideoItemData kId;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0629a {
        void tF(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.dza = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.dyM != null) {
                    if (a.this.aOy() != null) {
                        a.this.aOy().hide();
                    }
                    if (a.this.kIW != null) {
                        a.this.kIW.tF(false);
                    }
                    WriteData cIp = writeData == null ? a.this.dyM.cIp() : writeData;
                    if (z) {
                        a.this.hiD.KL(null);
                        a.this.hiD.aU(null);
                        a.this.hiD.tN(false);
                        a.this.cTE();
                        a.this.resetData();
                        if (cIp != null) {
                            String string = a.this.aJv().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cIp.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.aJv().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cIp != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJK())) {
                        cIp.setVcodeMD5(aaVar.getVcode_md5());
                        cIp.setVcodeUrl(aaVar.getVcode_pic_url());
                        cIp.setVcodeExtra(aaVar.aJL());
                        if (com.baidu.tbadk.s.a.wc(aaVar.aJK())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.cVv.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cIp, false, aaVar.aJK())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.cVv.getPageActivity(), cIp, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.cVv.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cIp, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.KI(postWriteCallBackData.getErrorString());
                        a.this.hiD.aU(postWriteCallBackData.getSensitiveWords());
                        a.this.hiD.KL(postWriteCallBackData.getErrorString());
                        if (!v.isEmpty(a.this.hiD.cUx())) {
                            a.this.mV(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.CL(postWriteCallBackData.getErrorCode()))) {
                        a.this.T(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.KI(postWriteCallBackData.getErrorString());
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
                if (a.this.hiD != null) {
                    if (!a.this.hiD.cUA()) {
                        a.this.mV(false);
                    }
                    a.this.hiD.tO(false);
                }
            }
        };
        editorTools.gC(true);
        this.hiD = new com.baidu.tieba.write.c();
        this.hiD.Ei(R.color.cp_cont_h_alpha85);
        this.hiD.Eh(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cVv = tbPageContext;
    }

    public TbPageContext<?> aJv() {
        return this.cVv;
    }

    public void vn(String str) {
        this.mPostContent = str;
    }

    public void aw(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (aOy() != null && (aOy().mr(28) instanceof c) && ((c) aOy().mr(28)).getInputView() != null) {
            EditText inputView = ((c) aOy().mr(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.kId = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, String str) {
        if (AntiHelper.bb(i, str)) {
            AntiHelper.a(this.cVv.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            vr(str);
        } else {
            KI(str);
        }
    }

    private void vr(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aJv().getPageActivity());
        aVar.sS(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aJv()).aEG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTE() {
        if (aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            aOy().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            aOy().hide();
        }
        if (this.kIW != null) {
            this.kIW.tF(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.dyM != null) {
            this.dyM.d((WriteData) null);
            this.dyM.sY(false);
        }
    }

    public void onDestroy() {
        if (this.dyM != null) {
            this.dyM.cancelLoadData();
        }
    }

    public void aPt() {
        if (this.dyM == null) {
            this.dyM = new NewWriteModel(this.cVv);
            this.dyM.b(this.dza);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.kId != null && this.kId.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.kId.baijiahaoData);
        }
        this.dyM.d(writeData);
        this.dyM.cME();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.dza.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.dyM.cIp(), null);
                    return;
                } else if (i2 == -1) {
                    cTE();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cTF() {
        if (aOy() != null && (aOy().mr(28) instanceof c) && ((c) aOy().mr(28)).getInputView() != null && ((c) aOy().mr(28)).getInputView().getText() != null) {
            ((c) aOy().mr(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mV(boolean z) {
        if (aOy() != null && (aOy().mr(28) instanceof c) && ((c) aOy().mr(28)).getInputView() != null && ((c) aOy().mr(28)).getInputView().getText() != null) {
            EditText inputView = ((c) aOy().mr(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder a = this.hiD.a(inputView.getText());
            if (a != null) {
                this.hiD.tO(true);
                inputView.setText(a);
                if (z && this.hiD.cUy() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.hiD.cUy());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.hiD.tN(this.hiD.cUy() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KI(String str) {
        if (this.cVv != null && !StringUtils.isNull(str)) {
            this.cVv.showToast(str);
        }
    }

    public void a(InterfaceC0629a interfaceC0629a) {
        this.kIW = interfaceC0629a;
    }

    public void cTG() {
        an anVar = new an("c13026");
        anVar.cx("tid", this.mThreadId);
        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.cx("fid", this.mForumId);
        TiebaStatic.log(anVar);
    }
}
