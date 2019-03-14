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
    private String ckb;
    private NewWriteModel cke;
    private final NewWriteModel.d cks;
    private com.baidu.tieba.write.b fPi;
    private InterfaceC0406a jgR;
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
        this.ckb = "";
        this.mThreadId = null;
        this.cks = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.cke != null) {
                    if (a.this.alS() != null) {
                        a.this.alS().hide();
                    }
                    if (a.this.jgR != null) {
                        a.this.jgR.qN(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.cke.getWriteData() : writeData;
                    if (z) {
                        a.this.fPi.Ej(null);
                        a.this.fPi.aE(null);
                        a.this.fPi.qU(false);
                        a.this.cmN();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.agj().getResources().getString(d.j.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.f(a.this.agj().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.agD())) {
                        writeData2.setVcodeMD5(xVar.getVcode_md5());
                        writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(xVar.agE());
                        if (com.baidu.tbadk.u.a.pT(xVar.agD())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, xVar.agD())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Ed(postWriteCallBackData.getErrorString());
                        a.this.fPi.aE(postWriteCallBackData.getSensitiveWords());
                        a.this.fPi.Ej(postWriteCallBackData.getErrorString());
                        if (!v.T(a.this.fPi.cnY())) {
                            a.this.kt(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.zz(postWriteCallBackData.getErrorCode()))) {
                        a.this.C(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Ed(postWriteCallBackData.getErrorString());
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
                if (a.this.fPi != null) {
                    if (!a.this.fPi.cob()) {
                        a.this.kt(false);
                    }
                    a.this.fPi.qV(false);
                }
            }
        };
        editorTools.eH(true);
        this.fPi = new com.baidu.tieba.write.b();
        this.fPi.AX(d.C0277d.cp_cont_h_alpha85);
        this.fPi.AW(d.C0277d.cp_btn_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> agj() {
        return this.mContext;
    }

    public void oS(String str) {
        this.ckb = str;
    }

    public void ad(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (alS() != null && (alS().jw(28) instanceof c) && ((c) alS().jw(28)).getInputView() != null) {
            EditText inputView = ((c) alS().jw(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i, String str) {
        if (AntiHelper.aB(i, str)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            oW(str);
        } else {
            Ed(str);
        }
    }

    private void oW(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(agj().getPageActivity());
        aVar.ly(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(agj()).aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmN() {
        if (alS() != null) {
            alS().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            alS().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            alS().hide();
        }
        if (this.jgR != null) {
            this.jgR.qN(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.cke != null) {
            this.cke.setWriteData(null);
            this.cke.qd(false);
        }
    }

    public void onDestroy() {
        if (this.cke != null) {
            this.cke.cancelLoadData();
        }
    }

    public void amL() {
        if (this.cke == null) {
            this.cke = new NewWriteModel(this.mContext);
            this.cke.b(this.cks);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.ckb);
        this.cke.setWriteData(writeData);
        this.cke.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                if (i2 == 0) {
                    this.cks.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.cke.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    cmN();
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
        if (alS() != null && (alS().jw(28) instanceof c) && ((c) alS().jw(28)).getInputView() != null && ((c) alS().jw(28)).getInputView().getText() != null) {
            EditText inputView = ((c) alS().jw(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.fPi.b(inputView.getText());
            if (b != null) {
                this.fPi.qV(true);
                inputView.setText(b);
                if (z && this.fPi.cnZ() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.fPi.cnZ());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.fPi.qU(this.fPi.cnZ() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ed(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0406a interfaceC0406a) {
        this.jgR = interfaceC0406a;
    }

    public void cmO() {
        am amVar = new am("c13026");
        amVar.bJ("tid", this.mThreadId);
        amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
        amVar.bJ(ImageViewerConfig.FORUM_ID, this.mForumId);
        TiebaStatic.log(amVar);
    }
}
