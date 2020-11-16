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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes23.dex */
public class a extends e {
    private TbPageContext<?> eGu;
    private NewWriteModel foP;
    private final NewWriteModel.d fpd;
    private com.baidu.tieba.write.c jKS;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;
    public VideoItemData nym;
    private InterfaceC0871a nze;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0871a {
        void yp(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.fpd = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.foP != null) {
                    if (a.this.byN() != null) {
                        a.this.byN().hide();
                    }
                    if (a.this.nze != null) {
                        a.this.nze.yp(false);
                    }
                    WriteData cXs = writeData == null ? a.this.foP.cXs() : writeData;
                    if (z) {
                        a.this.jKS.Ul(null);
                        a.this.jKS.bl(null);
                        a.this.jKS.yw(false);
                        a.this.dSm();
                        a.this.resetData();
                        if (cXs != null) {
                            String string = a.this.btS().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cXs.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.btS().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cXs != null && ahVar != null && !TextUtils.isEmpty(ahVar.bul())) {
                        cXs.setVcodeMD5(ahVar.getVcode_md5());
                        cXs.setVcodeUrl(ahVar.getVcode_pic_url());
                        cXs.setVcodeExtra(ahVar.bum());
                        if (com.baidu.tbadk.t.a.Ef(ahVar.bul())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.eGu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cXs, false, ahVar.bul())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.eGu.getPageActivity(), cXs, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.eGu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cXs, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Ub(postWriteCallBackData.getErrorString());
                        a.this.jKS.bl(postWriteCallBackData.getSensitiveWords());
                        a.this.jKS.Ul(postWriteCallBackData.getErrorString());
                        if (!y.isEmpty(a.this.jKS.dSS())) {
                            a.this.rk(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Ko(postWriteCallBackData.getErrorCode()))) {
                        a.this.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Ub(postWriteCallBackData.getErrorString());
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
                if (a.this.jKS != null) {
                    if (!a.this.jKS.dSV()) {
                        a.this.rk(false);
                    }
                    a.this.jKS.yx(false);
                }
            }
        };
        editorTools.kc(true);
        this.jKS = new com.baidu.tieba.write.c();
        this.jKS.LK(R.color.cp_cont_h_alpha85);
        this.jKS.LJ(R.color.CAM_X0101);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eGu = tbPageContext;
    }

    public TbPageContext<?> btS() {
        return this.eGu;
    }

    public void Do(String str) {
        this.mPostContent = str;
    }

    public void aJ(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (byN() != null && (byN().rI(28) instanceof c) && ((c) byN().rI(28)).getInputView() != null) {
            EditText inputView = ((c) byN().rI(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.nym = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(int i, String str) {
        if (AntiHelper.bP(i, str)) {
            AntiHelper.a(this.eGu.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            Ds(str);
        } else {
            Ub(str);
        }
    }

    private void Ds(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(btS().getPageActivity());
        aVar.AJ(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(btS()).bog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSm() {
        if (byN() != null) {
            byN().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            byN().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            byN().hide();
        }
        if (this.nze != null) {
            this.nze.yp(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.foP != null) {
            this.foP.e((WriteData) null);
            this.foP.xF(false);
        }
    }

    public void onDestroy() {
        if (this.foP != null) {
            this.foP.cancelLoadData();
        }
    }

    public void bzR() {
        if (this.foP == null) {
            this.foP = new NewWriteModel(this.eGu);
            this.foP.b(this.fpd);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.nym != null && this.nym.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.nym.baijiahaoData);
        }
        this.foP.e(writeData);
        this.foP.dLl();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.fpd.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.foP.cXs(), null);
                    return;
                } else if (i2 == -1) {
                    dSm();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cBZ() {
        if (byN() != null && (byN().rI(28) instanceof c) && ((c) byN().rI(28)).getInputView() != null && ((c) byN().rI(28)).getInputView().getText() != null) {
            ((c) byN().rI(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk(boolean z) {
        if (byN() != null && (byN().rI(28) instanceof c) && ((c) byN().rI(28)).getInputView() != null && ((c) byN().rI(28)).getInputView().getText() != null) {
            EditText inputView = ((c) byN().rI(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder c = this.jKS.c(inputView.getText());
            if (c != null) {
                this.jKS.yx(true);
                inputView.setText(c);
                if (z && this.jKS.dST() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.jKS.dST());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.jKS.yw(this.jKS.dST() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ub(String str) {
        if (this.eGu != null && !StringUtils.isNull(str)) {
            this.eGu.showToast(str);
        }
    }

    public void a(InterfaceC0871a interfaceC0871a) {
        this.nze = interfaceC0871a;
    }

    public void dSn() {
        ar arVar = new ar("c13026");
        arVar.dR("tid", this.mThreadId);
        arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
        arVar.dR("fid", this.mForumId);
        TiebaStatic.log(arVar);
    }
}
