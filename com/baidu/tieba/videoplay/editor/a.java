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
import com.baidu.tieba.tbadkCore.writeModel.g;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes8.dex */
public class a extends e {
    private TbPageContext<?> eUY;
    private NewWriteModel fDH;
    private final NewWriteModel.d fDW;
    private com.baidu.tieba.write.c kpy;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;
    public VideoItemData nVp;
    private InterfaceC0896a nWo;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0896a {
        void zl(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2;
                if (a.this.fDH != null) {
                    if (a.this.bBh() != null) {
                        a.this.bBh().hide();
                    }
                    if (a.this.nWo != null) {
                        a.this.nWo.zl(false);
                    }
                    WriteData daC = writeData == null ? a.this.fDH.daC() : writeData;
                    if (z) {
                        a.this.kpy.Vh(null);
                        a.this.kpy.bg(null);
                        a.this.kpy.zt(false);
                        a.this.dVN();
                        a.this.resetData();
                        if (daC != null) {
                            String string = a.this.bwm().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                String preMsg = postWriteCallBackData.getPreMsg();
                                str = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                                str2 = preMsg;
                            } else {
                                str = null;
                                str2 = null;
                            }
                            if (daC.getType() != 7) {
                                g.j(a.this.bwm().getPageActivity(), string, str2, str);
                            }
                        }
                    } else if (daC != null && ahVar != null && !TextUtils.isEmpty(ahVar.bwE())) {
                        daC.setVcodeMD5(ahVar.getVcode_md5());
                        daC.setVcodeUrl(ahVar.getVcode_pic_url());
                        daC.setVcodeExtra(ahVar.bwF());
                        if (com.baidu.tbadk.t.a.DY(ahVar.bwE())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.eUY.getPageActivity(), RequestResponseCode.REQUEST_VCODE, daC, false, ahVar.bwE())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.eUY.getPageActivity(), daC, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.eUY.getPageActivity(), RequestResponseCode.REQUEST_VCODE, daC, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.UW(postWriteCallBackData.getErrorString());
                        a.this.kpy.bg(postWriteCallBackData.getSensitiveWords());
                        a.this.kpy.Vh(postWriteCallBackData.getErrorString());
                        if (!y.isEmpty(a.this.kpy.dWv())) {
                            a.this.ss(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.JN(postWriteCallBackData.getErrorCode()))) {
                        a.this.aN(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.UW(postWriteCallBackData.getErrorString());
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
                if (a.this.kpy != null) {
                    if (!a.this.kpy.dWy()) {
                        a.this.ss(false);
                    }
                    a.this.kpy.zu(false);
                }
            }
        };
        editorTools.kN(true);
        this.kpy = new com.baidu.tieba.write.c();
        this.kpy.Le(R.color.cp_cont_h_alpha85);
        this.kpy.Ld(R.color.CAM_X0101);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eUY = tbPageContext;
    }

    public TbPageContext<?> bwm() {
        return this.eUY;
    }

    public void CW(String str) {
        this.mPostContent = str;
    }

    public void aQ(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (bBh() != null && (bBh().qU(28) instanceof c) && ((c) bBh().qU(28)).getInputView() != null) {
            EditText inputView = ((c) bBh().qU(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.nVp = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(int i, String str) {
        if (AntiHelper.bX(i, str)) {
            AntiHelper.a(this.eUY.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            Da(str);
        } else {
            UW(str);
        }
    }

    private void Da(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bwm().getPageActivity());
        aVar.Au(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bwm()).bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVN() {
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            bBh().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            bBh().hide();
        }
        if (this.nWo != null) {
            this.nWo.zl(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.fDH != null) {
            this.fDH.f((WriteData) null);
            this.fDH.yE(false);
        }
    }

    public void onDestroy() {
        if (this.fDH != null) {
            this.fDH.cancelLoadData();
        }
    }

    public void bCm() {
        if (this.fDH == null) {
            this.fDH = new NewWriteModel(this.eUY);
            this.fDH.b(this.fDW);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.nVp != null && this.nVp.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.nVp.baijiahaoData);
        }
        this.fDH.f(writeData);
        this.fDH.dPd();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.fDW.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.fDH.daC(), null);
                    return;
                } else if (i2 == -1) {
                    dVN();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cGV() {
        if (bBh() != null && (bBh().qU(28) instanceof c) && ((c) bBh().qU(28)).getInputView() != null && ((c) bBh().qU(28)).getInputView().getText() != null) {
            ((c) bBh().qU(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ss(boolean z) {
        if (bBh() != null && (bBh().qU(28) instanceof c) && ((c) bBh().qU(28)).getInputView() != null && ((c) bBh().qU(28)).getInputView().getText() != null) {
            EditText inputView = ((c) bBh().qU(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder d = this.kpy.d(inputView.getText());
            if (d != null) {
                this.kpy.zu(true);
                inputView.setText(d);
                if (z && this.kpy.dWw() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.kpy.dWw());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.kpy.zt(this.kpy.dWw() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UW(String str) {
        if (this.eUY != null && !StringUtils.isNull(str)) {
            this.eUY.showToast(str);
        }
    }

    public void a(InterfaceC0896a interfaceC0896a) {
        this.nWo = interfaceC0896a;
    }

    public void dVO() {
        ar arVar = new ar("c13026");
        arVar.dR("tid", this.mThreadId);
        arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
        arVar.dR("fid", this.mForumId);
        TiebaStatic.log(arVar);
    }
}
