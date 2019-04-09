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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class a extends d {
    private String cke;
    private NewWriteModel ckh;
    private final NewWriteModel.d ckv;
    private com.baidu.tieba.write.b fOW;
    private InterfaceC0406a jgG;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0406a {
        void qN(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.cke = "";
        this.mThreadId = null;
        this.ckv = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.ckh != null) {
                    if (a.this.alP() != null) {
                        a.this.alP().hide();
                    }
                    if (a.this.jgG != null) {
                        a.this.jgG.qN(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.ckh.getWriteData() : writeData;
                    if (z) {
                        a.this.fOW.Ei(null);
                        a.this.fOW.aE(null);
                        a.this.fOW.qU(false);
                        a.this.cmL();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.agg().getResources().getString(d.j.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.f(a.this.agg().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.agA())) {
                        writeData2.setVcodeMD5(xVar.getVcode_md5());
                        writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(xVar.agB());
                        if (com.baidu.tbadk.u.a.pU(xVar.agA())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, xVar.agA())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Ec(postWriteCallBackData.getErrorString());
                        a.this.fOW.aE(postWriteCallBackData.getSensitiveWords());
                        a.this.fOW.Ei(postWriteCallBackData.getErrorString());
                        if (!v.T(a.this.fOW.cnW())) {
                            a.this.kt(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.zv(postWriteCallBackData.getErrorCode()))) {
                        a.this.C(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Ec(postWriteCallBackData.getErrorString());
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
                if (a.this.fOW != null) {
                    if (!a.this.fOW.cnZ()) {
                        a.this.kt(false);
                    }
                    a.this.fOW.qV(false);
                }
            }
        };
        editorTools.eH(true);
        this.fOW = new com.baidu.tieba.write.b();
        this.fOW.AT(d.C0277d.cp_cont_h_alpha85);
        this.fOW.AS(d.C0277d.cp_btn_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> agg() {
        return this.mContext;
    }

    public void oT(String str) {
        this.cke = str;
    }

    public void ad(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (alP() != null && (alP().jv(28) instanceof c) && ((c) alP().jv(28)).getInputView() != null) {
            EditText inputView = ((c) alP().jv(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i, String str) {
        if (AntiHelper.aD(i, str)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            oX(str);
        } else {
            Ec(str);
        }
    }

    private void oX(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(agg().getPageActivity());
        aVar.lz(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(agg()).aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmL() {
        if (alP() != null) {
            alP().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            alP().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            alP().hide();
        }
        if (this.jgG != null) {
            this.jgG.qN(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.ckh != null) {
            this.ckh.setWriteData(null);
            this.ckh.qd(false);
        }
    }

    public void onDestroy() {
        if (this.ckh != null) {
            this.ckh.cancelLoadData();
        }
    }

    public void amI() {
        if (this.ckh == null) {
            this.ckh = new NewWriteModel(this.mContext);
            this.ckh.b(this.ckv);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.cke);
        this.ckh.setWriteData(writeData);
        this.ckh.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                if (i2 == 0) {
                    this.ckv.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.ckh.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    cmL();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt(boolean z) {
        if (alP() != null && (alP().jv(28) instanceof c) && ((c) alP().jv(28)).getInputView() != null && ((c) alP().jv(28)).getInputView().getText() != null) {
            EditText inputView = ((c) alP().jv(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.fOW.b(inputView.getText());
            if (b != null) {
                this.fOW.qV(true);
                inputView.setText(b);
                if (z && this.fOW.cnX() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.fOW.cnX());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.fOW.qU(this.fOW.cnX() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ec(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0406a interfaceC0406a) {
        this.jgG = interfaceC0406a;
    }

    public void cmM() {
        am amVar = new am("c13026");
        amVar.bJ("tid", this.mThreadId);
        amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
        amVar.bJ(ImageViewerConfig.FORUM_ID, this.mForumId);
        TiebaStatic.log(amVar);
    }
}
