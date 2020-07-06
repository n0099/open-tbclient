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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes11.dex */
public class a extends d {
    private TbPageContext<?> dPv;
    private final NewWriteModel.d evL;
    private NewWriteModel evx;
    private com.baidu.tieba.write.c iyU;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;
    public VideoItemData mfU;
    private InterfaceC0761a mgN;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0761a {
        void vx(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.evL = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.evx != null) {
                    if (a.this.bfa() != null) {
                        a.this.bfa().hide();
                    }
                    if (a.this.mgN != null) {
                        a.this.mgN.vx(false);
                    }
                    WriteData dew = writeData == null ? a.this.evx.dew() : writeData;
                    if (z) {
                        a.this.iyU.ON(null);
                        a.this.iyU.aY(null);
                        a.this.iyU.vE(false);
                        a.this.dqj();
                        a.this.resetData();
                        if (dew != null) {
                            String string = a.this.bac().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (dew.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.f(a.this.bac().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (dew != null && adVar != null && !TextUtils.isEmpty(adVar.bar())) {
                        dew.setVcodeMD5(adVar.getVcode_md5());
                        dew.setVcodeUrl(adVar.getVcode_pic_url());
                        dew.setVcodeExtra(adVar.bas());
                        if (com.baidu.tbadk.t.a.zq(adVar.bar())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.dPv.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dew, false, adVar.bar())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.dPv.getPageActivity(), dew, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.dPv.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dew, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.OG(postWriteCallBackData.getErrorString());
                        a.this.iyU.aY(postWriteCallBackData.getSensitiveWords());
                        a.this.iyU.ON(postWriteCallBackData.getErrorString());
                        if (!w.isEmpty(a.this.iyU.dqM())) {
                            a.this.oF(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Fe(postWriteCallBackData.getErrorCode()))) {
                        a.this.ar(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.OG(postWriteCallBackData.getErrorString());
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
                if (a.this.iyU != null) {
                    if (!a.this.iyU.dqP()) {
                        a.this.oF(false);
                    }
                    a.this.iyU.vF(false);
                }
            }
        };
        editorTools.m32if(true);
        this.iyU = new com.baidu.tieba.write.c();
        this.iyU.GA(R.color.cp_cont_h_alpha85);
        this.iyU.Gz(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.dPv = tbPageContext;
    }

    public TbPageContext<?> bac() {
        return this.dPv;
    }

    public void yD(String str) {
        this.mPostContent = str;
    }

    public void aA(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (bfa() != null && (bfa().nB(28) instanceof c) && ((c) bfa().nB(28)).getInputView() != null) {
            EditText inputView = ((c) bfa().nB(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.mfU = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(int i, String str) {
        if (AntiHelper.bA(i, str)) {
            AntiHelper.a(this.dPv.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            yH(str);
        } else {
            OG(str);
        }
    }

    private void yH(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bac().getPageActivity());
        aVar.we(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bac()).aUN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqj() {
        if (bfa() != null) {
            bfa().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            bfa().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            bfa().hide();
        }
        if (this.mgN != null) {
            this.mgN.vx(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.evx != null) {
            this.evx.d((WriteData) null);
            this.evx.uN(false);
        }
    }

    public void onDestroy() {
        if (this.evx != null) {
            this.evx.cancelLoadData();
        }
    }

    public void bfX() {
        if (this.evx == null) {
            this.evx = new NewWriteModel(this.dPv);
            this.evx.b(this.evL);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.mfU != null && this.mfU.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.mfU.baijiahaoData);
        }
        this.evx.d(writeData);
        this.evx.djo();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.evL.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.evx.dew(), null);
                    return;
                } else if (i2 == -1) {
                    dqj();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cbZ() {
        if (bfa() != null && (bfa().nB(28) instanceof c) && ((c) bfa().nB(28)).getInputView() != null && ((c) bfa().nB(28)).getInputView().getText() != null) {
            ((c) bfa().nB(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oF(boolean z) {
        if (bfa() != null && (bfa().nB(28) instanceof c) && ((c) bfa().nB(28)).getInputView() != null && ((c) bfa().nB(28)).getInputView().getText() != null) {
            EditText inputView = ((c) bfa().nB(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder d = this.iyU.d(inputView.getText());
            if (d != null) {
                this.iyU.vF(true);
                inputView.setText(d);
                if (z && this.iyU.dqN() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.iyU.dqN());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.iyU.vE(this.iyU.dqN() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OG(String str) {
        if (this.dPv != null && !StringUtils.isNull(str)) {
            this.dPv.showToast(str);
        }
    }

    public void a(InterfaceC0761a interfaceC0761a) {
        this.mgN = interfaceC0761a;
    }

    public void dqk() {
        ao aoVar = new ao("c13026");
        aoVar.dk("tid", this.mThreadId);
        aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
        aoVar.dk("fid", this.mForumId);
        TiebaStatic.log(aoVar);
    }
}
