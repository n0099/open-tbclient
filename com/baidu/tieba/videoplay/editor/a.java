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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class a extends d {
    private final NewWriteModel.d csD;
    private String csm;
    private NewWriteModel csp;
    private com.baidu.tieba.write.b ggd;
    private InterfaceC0425a jzA;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0425a {
        void rC(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.csm = "";
        this.mThreadId = null;
        this.csD = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.csp != null) {
                    if (a.this.aqS() != null) {
                        a.this.aqS().hide();
                    }
                    if (a.this.jzA != null) {
                        a.this.jzA.rC(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.csp.getWriteData() : writeData;
                    if (z) {
                        a.this.ggd.FE(null);
                        a.this.ggd.aI(null);
                        a.this.ggd.rJ(false);
                        a.this.cuO();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.alf().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.f(a.this.alf().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.alz())) {
                        writeData2.setVcodeMD5(xVar.getVcode_md5());
                        writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(xVar.alA());
                        if (com.baidu.tbadk.v.a.rd(xVar.alz())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, xVar.alz())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Fy(postWriteCallBackData.getErrorString());
                        a.this.ggd.aI(postWriteCallBackData.getSensitiveWords());
                        a.this.ggd.FE(postWriteCallBackData.getErrorString());
                        if (!v.aa(a.this.ggd.cwc())) {
                            a.this.lj(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.AD(postWriteCallBackData.getErrorCode()))) {
                        a.this.F(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Fy(postWriteCallBackData.getErrorString());
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
                if (a.this.ggd != null) {
                    if (!a.this.ggd.cwf()) {
                        a.this.lj(false);
                    }
                    a.this.ggd.rK(false);
                }
            }
        };
        editorTools.fd(true);
        this.ggd = new com.baidu.tieba.write.b();
        this.ggd.Cc(R.color.cp_cont_h_alpha85);
        this.ggd.Cb(R.color.cp_btn_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> alf() {
        return this.mContext;
    }

    public void qb(String str) {
        this.csm = str;
    }

    public void ad(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (aqS() != null && (aqS().kj(28) instanceof c) && ((c) aqS().kj(28)).getInputView() != null) {
            EditText inputView = ((c) aqS().kj(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i, String str) {
        if (AntiHelper.aG(i, str)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            qf(str);
        } else {
            Fy(str);
        }
    }

    private void qf(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(alf().getPageActivity());
        aVar.mE(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(alf()).afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuO() {
        if (aqS() != null) {
            aqS().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            aqS().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            aqS().hide();
        }
        if (this.jzA != null) {
            this.jzA.rC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.csp != null) {
            this.csp.setWriteData(null);
            this.csp.qS(false);
        }
    }

    public void onDestroy() {
        if (this.csp != null) {
            this.csp.cancelLoadData();
        }
    }

    public void arL() {
        if (this.csp == null) {
            this.csp = new NewWriteModel(this.mContext);
            this.csp.b(this.csD);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.csm);
        this.csp.setWriteData(writeData);
        this.csp.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                if (i2 == 0) {
                    this.csD.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.csp.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    cuO();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(boolean z) {
        if (aqS() != null && (aqS().kj(28) instanceof c) && ((c) aqS().kj(28)).getInputView() != null && ((c) aqS().kj(28)).getInputView().getText() != null) {
            EditText inputView = ((c) aqS().kj(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.ggd.b(inputView.getText());
            if (b != null) {
                this.ggd.rK(true);
                inputView.setText(b);
                if (z && this.ggd.cwd() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.ggd.cwd());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.ggd.rJ(this.ggd.cwd() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fy(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0425a interfaceC0425a) {
        this.jzA = interfaceC0425a;
    }

    public void cuP() {
        am amVar = new am("c13026");
        amVar.bT("tid", this.mThreadId);
        amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
        amVar.bT("fid", this.mForumId);
        TiebaStatic.log(amVar);
    }
}
