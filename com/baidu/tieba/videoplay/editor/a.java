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
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes24.dex */
public class a extends e {
    private TbPageContext<?> eIc;
    private NewWriteModel fpI;
    private final NewWriteModel.d fpW;
    private com.baidu.tieba.write.c jKh;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;
    private InterfaceC0868a nxX;
    public VideoItemData nxf;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC0868a {
        void yi(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.fpI != null) {
                    if (a.this.bzx() != null) {
                        a.this.bzx().hide();
                    }
                    if (a.this.nxX != null) {
                        a.this.nxX.yi(false);
                    }
                    WriteData cXW = writeData == null ? a.this.fpI.cXW() : writeData;
                    if (z) {
                        a.this.jKh.UA(null);
                        a.this.jKh.bk(null);
                        a.this.jKh.yp(false);
                        a.this.dSn();
                        a.this.resetData();
                        if (cXW != null) {
                            String string = a.this.buC().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cXW.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.buC().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cXW != null && ahVar != null && !TextUtils.isEmpty(ahVar.buV())) {
                        cXW.setVcodeMD5(ahVar.getVcode_md5());
                        cXW.setVcodeUrl(ahVar.getVcode_pic_url());
                        cXW.setVcodeExtra(ahVar.buW());
                        if (com.baidu.tbadk.t.a.EE(ahVar.buV())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.eIc.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cXW, false, ahVar.buV())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.eIc.getPageActivity(), cXW, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.eIc.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cXW, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Uq(postWriteCallBackData.getErrorString());
                        a.this.jKh.bk(postWriteCallBackData.getSensitiveWords());
                        a.this.jKh.UA(postWriteCallBackData.getErrorString());
                        if (!y.isEmpty(a.this.jKh.dST())) {
                            a.this.rh(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.JL(postWriteCallBackData.getErrorCode()))) {
                        a.this.aI(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Uq(postWriteCallBackData.getErrorString());
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
                if (a.this.jKh != null) {
                    if (!a.this.jKh.dSW()) {
                        a.this.rh(false);
                    }
                    a.this.jKh.yq(false);
                }
            }
        };
        editorTools.kb(true);
        this.jKh = new com.baidu.tieba.write.c();
        this.jKh.Lh(R.color.cp_cont_h_alpha85);
        this.jKh.Lg(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eIc = tbPageContext;
    }

    public TbPageContext<?> buC() {
        return this.eIc;
    }

    public void DP(String str) {
        this.mPostContent = str;
    }

    public void aJ(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (bzx() != null && (bzx().rk(28) instanceof c) && ((c) bzx().rk(28)).getInputView() != null) {
            EditText inputView = ((c) bzx().rk(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.nxf = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(int i, String str) {
        if (AntiHelper.bR(i, str)) {
            AntiHelper.a(this.eIc.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            DT(str);
        } else {
            Uq(str);
        }
    }

    private void DT(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(buC().getPageActivity());
        aVar.Bo(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(buC()).bpc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSn() {
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            bzx().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            bzx().hide();
        }
        if (this.nxX != null) {
            this.nxX.yi(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.fpI != null) {
            this.fpI.e((WriteData) null);
            this.fpI.xy(false);
        }
    }

    public void onDestroy() {
        if (this.fpI != null) {
            this.fpI.cancelLoadData();
        }
    }

    public void bAB() {
        if (this.fpI == null) {
            this.fpI = new NewWriteModel(this.eIc);
            this.fpI.b(this.fpW);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.nxf != null && this.nxf.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.nxf.baijiahaoData);
        }
        this.fpI.e(writeData);
        this.fpI.dLm();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.fpW.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.fpI.cXW(), null);
                    return;
                } else if (i2 == -1) {
                    dSn();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cCv() {
        if (bzx() != null && (bzx().rk(28) instanceof c) && ((c) bzx().rk(28)).getInputView() != null && ((c) bzx().rk(28)).getInputView().getText() != null) {
            ((c) bzx().rk(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh(boolean z) {
        if (bzx() != null && (bzx().rk(28) instanceof c) && ((c) bzx().rk(28)).getInputView() != null && ((c) bzx().rk(28)).getInputView().getText() != null) {
            EditText inputView = ((c) bzx().rk(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder c = this.jKh.c(inputView.getText());
            if (c != null) {
                this.jKh.yq(true);
                inputView.setText(c);
                if (z && this.jKh.dSU() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.jKh.dSU());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.jKh.yp(this.jKh.dSU() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uq(String str) {
        if (this.eIc != null && !StringUtils.isNull(str)) {
            this.eIc.showToast(str);
        }
    }

    public void a(InterfaceC0868a interfaceC0868a) {
        this.nxX = interfaceC0868a;
    }

    public void dSo() {
        aq aqVar = new aq("c13026");
        aqVar.dR("tid", this.mThreadId);
        aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
        aqVar.dR("fid", this.mForumId);
        TiebaStatic.log(aqVar);
    }
}
