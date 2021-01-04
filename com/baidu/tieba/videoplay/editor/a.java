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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.g;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes8.dex */
public class a extends e {
    private TbPageContext<?> eXu;
    private NewWriteModel fGa;
    private final NewWriteModel.d fGo;
    private com.baidu.tieba.write.c klI;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;
    public VideoItemData nPK;
    private InterfaceC0870a nQC;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0870a {
        void yU(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2;
                if (a.this.fGa != null) {
                    if (a.this.bEI() != null) {
                        a.this.bEI().hide();
                    }
                    if (a.this.nQC != null) {
                        a.this.nQC.yU(false);
                    }
                    WriteData dco = writeData == null ? a.this.fGa.dco() : writeData;
                    if (z) {
                        a.this.klI.Vf(null);
                        a.this.klI.bm(null);
                        a.this.klI.zb(false);
                        a.this.dXk();
                        a.this.resetData();
                        if (dco != null) {
                            String string = a.this.bzM().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                String preMsg = postWriteCallBackData.getPreMsg();
                                str = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                                str2 = preMsg;
                            } else {
                                str = null;
                                str2 = null;
                            }
                            if (dco.getType() != 7) {
                                g.i(a.this.bzM().getPageActivity(), string, str2, str);
                            }
                        }
                    } else if (dco != null && ahVar != null && !TextUtils.isEmpty(ahVar.bAf())) {
                        dco.setVcodeMD5(ahVar.getVcode_md5());
                        dco.setVcodeUrl(ahVar.getVcode_pic_url());
                        dco.setVcodeExtra(ahVar.bAg());
                        if (com.baidu.tbadk.t.a.EQ(ahVar.bAf())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.eXu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dco, false, ahVar.bAf())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.eXu.getPageActivity(), dco, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.eXu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dco, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.UV(postWriteCallBackData.getErrorString());
                        a.this.klI.bm(postWriteCallBackData.getSensitiveWords());
                        a.this.klI.Vf(postWriteCallBackData.getErrorString());
                        if (!x.isEmpty(a.this.klI.dXQ())) {
                            a.this.sj(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.La(postWriteCallBackData.getErrorCode()))) {
                        a.this.aI(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.UV(postWriteCallBackData.getErrorString());
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
                if (a.this.klI != null) {
                    if (!a.this.klI.dXT()) {
                        a.this.sj(false);
                    }
                    a.this.klI.zc(false);
                }
            }
        };
        editorTools.kO(true);
        this.klI = new com.baidu.tieba.write.c();
        this.klI.Mp(R.color.cp_cont_h_alpha85);
        this.klI.Mo(R.color.CAM_X0101);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eXu = tbPageContext;
    }

    public TbPageContext<?> bzM() {
        return this.eXu;
    }

    public void DT(String str) {
        this.mPostContent = str;
    }

    public void aP(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (bEI() != null && (bEI().sv(28) instanceof c) && ((c) bEI().sv(28)).getInputView() != null) {
            EditText inputView = ((c) bEI().sv(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.nPK = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(int i, String str) {
        if (AntiHelper.bP(i, str)) {
            AntiHelper.a(this.eXu.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            DX(str);
        } else {
            UV(str);
        }
    }

    private void DX(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bzM().getPageActivity());
        aVar.Bp(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bzM()).btX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXk() {
        if (bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            bEI().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            bEI().hide();
        }
        if (this.nQC != null) {
            this.nQC.yU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.fGa != null) {
            this.fGa.f((WriteData) null);
            this.fGa.yp(false);
        }
    }

    public void onDestroy() {
        if (this.fGa != null) {
            this.fGa.cancelLoadData();
        }
    }

    public void bFM() {
        if (this.fGa == null) {
            this.fGa = new NewWriteModel(this.eXu);
            this.fGa.b(this.fGo);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.nPK != null && this.nPK.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.nPK.baijiahaoData);
        }
        this.fGa.f(writeData);
        this.fGa.dQB();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.fGo.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.fGa.dco(), null);
                    return;
                } else if (i2 == -1) {
                    dXk();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cJs() {
        if (bEI() != null && (bEI().sv(28) instanceof c) && ((c) bEI().sv(28)).getInputView() != null && ((c) bEI().sv(28)).getInputView().getText() != null) {
            ((c) bEI().sv(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(boolean z) {
        if (bEI() != null && (bEI().sv(28) instanceof c) && ((c) bEI().sv(28)).getInputView() != null && ((c) bEI().sv(28)).getInputView().getText() != null) {
            EditText inputView = ((c) bEI().sv(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder d = this.klI.d(inputView.getText());
            if (d != null) {
                this.klI.zc(true);
                inputView.setText(d);
                if (z && this.klI.dXR() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.klI.dXR());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.klI.zb(this.klI.dXR() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UV(String str) {
        if (this.eXu != null && !StringUtils.isNull(str)) {
            this.eXu.showToast(str);
        }
    }

    public void a(InterfaceC0870a interfaceC0870a) {
        this.nQC = interfaceC0870a;
    }

    public void dXl() {
        aq aqVar = new aq("c13026");
        aqVar.dX("tid", this.mThreadId);
        aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
        aqVar.dX("fid", this.mForumId);
        TiebaStatic.log(aqVar);
    }
}
