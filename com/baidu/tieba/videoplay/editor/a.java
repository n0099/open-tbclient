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
    public VideoItemData nPJ;
    private InterfaceC0908a nQB;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0908a {
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
                    if (a.this.bEJ() != null) {
                        a.this.bEJ().hide();
                    }
                    if (a.this.nQB != null) {
                        a.this.nQB.yU(false);
                    }
                    WriteData dcp = writeData == null ? a.this.fGa.dcp() : writeData;
                    if (z) {
                        a.this.klI.Ve(null);
                        a.this.klI.bm(null);
                        a.this.klI.zb(false);
                        a.this.dXl();
                        a.this.resetData();
                        if (dcp != null) {
                            String string = a.this.bzN().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                String preMsg = postWriteCallBackData.getPreMsg();
                                str = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                                str2 = preMsg;
                            } else {
                                str = null;
                                str2 = null;
                            }
                            if (dcp.getType() != 7) {
                                g.i(a.this.bzN().getPageActivity(), string, str2, str);
                            }
                        }
                    } else if (dcp != null && ahVar != null && !TextUtils.isEmpty(ahVar.bAg())) {
                        dcp.setVcodeMD5(ahVar.getVcode_md5());
                        dcp.setVcodeUrl(ahVar.getVcode_pic_url());
                        dcp.setVcodeExtra(ahVar.bAh());
                        if (com.baidu.tbadk.t.a.EP(ahVar.bAg())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.eXu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dcp, false, ahVar.bAg())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.eXu.getPageActivity(), dcp, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.eXu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dcp, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.UU(postWriteCallBackData.getErrorString());
                        a.this.klI.bm(postWriteCallBackData.getSensitiveWords());
                        a.this.klI.Ve(postWriteCallBackData.getErrorString());
                        if (!x.isEmpty(a.this.klI.dXR())) {
                            a.this.sj(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.La(postWriteCallBackData.getErrorCode()))) {
                        a.this.aI(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.UU(postWriteCallBackData.getErrorString());
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
                    if (!a.this.klI.dXU()) {
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

    public TbPageContext<?> bzN() {
        return this.eXu;
    }

    public void DS(String str) {
        this.mPostContent = str;
    }

    public void aP(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (bEJ() != null && (bEJ().sv(28) instanceof c) && ((c) bEJ().sv(28)).getInputView() != null) {
            EditText inputView = ((c) bEJ().sv(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.nPJ = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(int i, String str) {
        if (AntiHelper.bP(i, str)) {
            AntiHelper.a(this.eXu.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            DW(str);
        } else {
            UU(str);
        }
    }

    private void DW(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bzN().getPageActivity());
        aVar.Bo(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bzN()).btY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXl() {
        if (bEJ() != null) {
            bEJ().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            bEJ().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            bEJ().hide();
        }
        if (this.nQB != null) {
            this.nQB.yU(true);
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

    public void bFN() {
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
        if (this.nPJ != null && this.nPJ.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.nPJ.baijiahaoData);
        }
        this.fGa.f(writeData);
        this.fGa.dQC();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.fGo.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.fGa.dcp(), null);
                    return;
                } else if (i2 == -1) {
                    dXl();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cJt() {
        if (bEJ() != null && (bEJ().sv(28) instanceof c) && ((c) bEJ().sv(28)).getInputView() != null && ((c) bEJ().sv(28)).getInputView().getText() != null) {
            ((c) bEJ().sv(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(boolean z) {
        if (bEJ() != null && (bEJ().sv(28) instanceof c) && ((c) bEJ().sv(28)).getInputView() != null && ((c) bEJ().sv(28)).getInputView().getText() != null) {
            EditText inputView = ((c) bEJ().sv(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder d = this.klI.d(inputView.getText());
            if (d != null) {
                this.klI.zc(true);
                inputView.setText(d);
                if (z && this.klI.dXS() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.klI.dXS());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.klI.zb(this.klI.dXS() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UU(String str) {
        if (this.eXu != null && !StringUtils.isNull(str)) {
            this.eXu.showToast(str);
        }
    }

    public void a(InterfaceC0908a interfaceC0908a) {
        this.nQB = interfaceC0908a;
    }

    public void dXm() {
        aq aqVar = new aq("c13026");
        aqVar.dX("tid", this.mThreadId);
        aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
        aqVar.dX("fid", this.mForumId);
        TiebaStatic.log(aqVar);
    }
}
