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
    private TbPageContext<?> dIF;
    private NewWriteModel emH;
    private final NewWriteModel.d emV;
    private com.baidu.tieba.write.c ihc;
    public VideoItemData lKS;
    private InterfaceC0744a lLL;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0744a {
        void vf(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.emV = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.emH != null) {
                    if (a.this.bcW() != null) {
                        a.this.bcW().hide();
                    }
                    if (a.this.lLL != null) {
                        a.this.lLL.vf(false);
                    }
                    WriteData cZP = writeData == null ? a.this.emH.cZP() : writeData;
                    if (z) {
                        a.this.ihc.Of(null);
                        a.this.ihc.aX(null);
                        a.this.ihc.vl(false);
                        a.this.dlE();
                        a.this.resetData();
                        if (cZP != null) {
                            String string = a.this.aXW().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cZP.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.f(a.this.aXW().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cZP != null && aaVar != null && !TextUtils.isEmpty(aaVar.aYl())) {
                        cZP.setVcodeMD5(aaVar.getVcode_md5());
                        cZP.setVcodeUrl(aaVar.getVcode_pic_url());
                        cZP.setVcodeExtra(aaVar.aYm());
                        if (com.baidu.tbadk.s.a.yX(aaVar.aYl())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.dIF.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cZP, false, aaVar.aYl())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.dIF.getPageActivity(), cZP, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.dIF.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cZP, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Oc(postWriteCallBackData.getErrorString());
                        a.this.ihc.aX(postWriteCallBackData.getSensitiveWords());
                        a.this.ihc.Of(postWriteCallBackData.getErrorString());
                        if (!v.isEmpty(a.this.ihc.dmg())) {
                            a.this.ov(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Ea(postWriteCallBackData.getErrorCode()))) {
                        a.this.ap(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Oc(postWriteCallBackData.getErrorString());
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
                if (a.this.ihc != null) {
                    if (!a.this.ihc.dmj()) {
                        a.this.ov(false);
                    }
                    a.this.ihc.vm(false);
                }
            }
        };
        editorTools.hW(true);
        this.ihc = new com.baidu.tieba.write.c();
        this.ihc.Fu(R.color.cp_cont_h_alpha85);
        this.ihc.Ft(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.dIF = tbPageContext;
    }

    public TbPageContext<?> aXW() {
        return this.dIF;
    }

    public void yk(String str) {
        this.mPostContent = str;
    }

    public void az(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (bcW() != null && (bcW().nf(28) instanceof c) && ((c) bcW().nf(28)).getInputView() != null) {
            EditText inputView = ((c) bcW().nf(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.lKS = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(int i, String str) {
        if (AntiHelper.bv(i, str)) {
            AntiHelper.a(this.dIF.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            yo(str);
        } else {
            Oc(str);
        }
    }

    private void yo(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aXW().getPageActivity());
        aVar.vO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aXW()).aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlE() {
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            bcW().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            bcW().hide();
        }
        if (this.lLL != null) {
            this.lLL.vf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.emH != null) {
            this.emH.d((WriteData) null);
            this.emH.uy(false);
        }
    }

    public void onDestroy() {
        if (this.emH != null) {
            this.emH.cancelLoadData();
        }
    }

    public void bdR() {
        if (this.emH == null) {
            this.emH = new NewWriteModel(this.dIF);
            this.emH.b(this.emV);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.lKS != null && this.lKS.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.lKS.baijiahaoData);
        }
        this.emH.d(writeData);
        this.emH.deN();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.emV.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.emH.cZP(), null);
                    return;
                } else if (i2 == -1) {
                    dlE();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void dlF() {
        if (bcW() != null && (bcW().nf(28) instanceof c) && ((c) bcW().nf(28)).getInputView() != null && ((c) bcW().nf(28)).getInputView().getText() != null) {
            ((c) bcW().nf(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ov(boolean z) {
        if (bcW() != null && (bcW().nf(28) instanceof c) && ((c) bcW().nf(28)).getInputView() != null && ((c) bcW().nf(28)).getInputView().getText() != null) {
            EditText inputView = ((c) bcW().nf(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder a = this.ihc.a(inputView.getText());
            if (a != null) {
                this.ihc.vm(true);
                inputView.setText(a);
                if (z && this.ihc.dmh() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.ihc.dmh());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.ihc.vl(this.ihc.dmh() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oc(String str) {
        if (this.dIF != null && !StringUtils.isNull(str)) {
            this.dIF.showToast(str);
        }
    }

    public void a(InterfaceC0744a interfaceC0744a) {
        this.lLL = interfaceC0744a;
    }

    public void dlG() {
        an anVar = new an("c13026");
        anVar.dh("tid", this.mThreadId);
        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.dh("fid", this.mForumId);
        TiebaStatic.log(anVar);
    }
}
