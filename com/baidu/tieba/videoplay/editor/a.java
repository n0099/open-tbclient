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
    private final NewWriteModel.d dYH;
    private NewWriteModel dYt;
    private TbPageContext<?> duG;
    private com.baidu.tieba.write.c hSm;
    public VideoItemData lsj;
    private InterfaceC0670a ltd;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0670a {
        void uH(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.dYH = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.dYt != null) {
                    if (a.this.aWP() != null) {
                        a.this.aWP().hide();
                    }
                    if (a.this.ltd != null) {
                        a.this.ltd.uH(false);
                    }
                    WriteData cSN = writeData == null ? a.this.dYt.cSN() : writeData;
                    if (z) {
                        a.this.hSm.Mp(null);
                        a.this.hSm.aW(null);
                        a.this.hSm.uN(false);
                        a.this.der();
                        a.this.resetData();
                        if (cSN != null) {
                            String string = a.this.aRS().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cSN.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.aRS().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cSN != null && aaVar != null && !TextUtils.isEmpty(aaVar.aSh())) {
                        cSN.setVcodeMD5(aaVar.getVcode_md5());
                        cSN.setVcodeUrl(aaVar.getVcode_pic_url());
                        cSN.setVcodeExtra(aaVar.aSi());
                        if (com.baidu.tbadk.s.a.xo(aaVar.aSh())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.duG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cSN, false, aaVar.aSh())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.duG.getPageActivity(), cSN, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.duG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cSN, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Mm(postWriteCallBackData.getErrorString());
                        a.this.hSm.aW(postWriteCallBackData.getSensitiveWords());
                        a.this.hSm.Mp(postWriteCallBackData.getErrorString());
                        if (!v.isEmpty(a.this.hSm.deS())) {
                            a.this.nZ(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Dp(postWriteCallBackData.getErrorCode()))) {
                        a.this.ak(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Mm(postWriteCallBackData.getErrorString());
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
                if (a.this.hSm != null) {
                    if (!a.this.hSm.deV()) {
                        a.this.nZ(false);
                    }
                    a.this.hSm.uO(false);
                }
            }
        };
        editorTools.hA(true);
        this.hSm = new com.baidu.tieba.write.c();
        this.hSm.EJ(R.color.cp_cont_h_alpha85);
        this.hSm.EI(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.duG = tbPageContext;
    }

    public TbPageContext<?> aRS() {
        return this.duG;
    }

    public void wB(String str) {
        this.mPostContent = str;
    }

    public void av(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (aWP() != null && (aWP().mD(28) instanceof c) && ((c) aWP().mD(28)).getInputView() != null) {
            EditText inputView = ((c) aWP().mD(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.lsj = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(int i, String str) {
        if (AntiHelper.bq(i, str)) {
            AntiHelper.a(this.duG.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            wF(str);
        } else {
            Mm(str);
        }
    }

    private void wF(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aRS().getPageActivity());
        aVar.uf(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aRS()).aMU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void der() {
        if (aWP() != null) {
            aWP().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            aWP().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            aWP().hide();
        }
        if (this.ltd != null) {
            this.ltd.uH(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.dYt != null) {
            this.dYt.d((WriteData) null);
            this.dYt.ua(false);
        }
    }

    public void onDestroy() {
        if (this.dYt != null) {
            this.dYt.cancelLoadData();
        }
    }

    public void aXK() {
        if (this.dYt == null) {
            this.dYt = new NewWriteModel(this.duG);
            this.dYt.b(this.dYH);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.lsj != null && this.lsj.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.lsj.baijiahaoData);
        }
        this.dYt.d(writeData);
        this.dYt.cXB();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.dYH.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.dYt.cSN(), null);
                    return;
                } else if (i2 == -1) {
                    der();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void des() {
        if (aWP() != null && (aWP().mD(28) instanceof c) && ((c) aWP().mD(28)).getInputView() != null && ((c) aWP().mD(28)).getInputView().getText() != null) {
            ((c) aWP().mD(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nZ(boolean z) {
        if (aWP() != null && (aWP().mD(28) instanceof c) && ((c) aWP().mD(28)).getInputView() != null && ((c) aWP().mD(28)).getInputView().getText() != null) {
            EditText inputView = ((c) aWP().mD(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder a = this.hSm.a(inputView.getText());
            if (a != null) {
                this.hSm.uO(true);
                inputView.setText(a);
                if (z && this.hSm.deT() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.hSm.deT());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.hSm.uN(this.hSm.deT() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mm(String str) {
        if (this.duG != null && !StringUtils.isNull(str)) {
            this.duG.showToast(str);
        }
    }

    public void a(InterfaceC0670a interfaceC0670a) {
        this.ltd = interfaceC0670a;
    }

    public void det() {
        an anVar = new an("c13026");
        anVar.cI("tid", this.mThreadId);
        anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.cI("fid", this.mForumId);
        TiebaStatic.log(anVar);
    }
}
