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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class a extends d {
    private final NewWriteModel.d aEL;
    private String aEu;
    private NewWriteModel aEx;
    private com.baidu.tieba.write.b fuY;
    private InterfaceC0231a gXc;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0231a {
        void nf(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.aEu = "";
        this.mThreadId = null;
        this.aEL = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.aEx != null) {
                    if (a.this.DD() != null) {
                        a.this.DD().hide();
                    }
                    if (a.this.gXc != null) {
                        a.this.gXc.nf(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.aEx.getWriteData() : writeData;
                    if (z) {
                        a.this.fuY.uE(null);
                        a.this.fuY.ax(null);
                        a.this.fuY.nj(false);
                        a.this.bzN();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.yr().getResources().getString(d.k.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.e(a.this.yr().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.yJ())) {
                        writeData2.setVcodeMD5(tVar.getVcode_md5());
                        writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(tVar.yK());
                        if (com.baidu.tbadk.p.a.hr(tVar.yJ())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.yJ())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.uw(postWriteCallBackData.getErrorString());
                        a.this.fuY.ax(postWriteCallBackData.getSensitiveWords());
                        a.this.fuY.uE(postWriteCallBackData.getErrorString());
                        if (!v.w(a.this.fuY.bAS())) {
                            a.this.kG(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.ts(postWriteCallBackData.getErrorCode()))) {
                        a.this.j(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.uw(postWriteCallBackData.getErrorString());
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
                if (a.this.fuY != null) {
                    if (!a.this.fuY.bAV()) {
                        a.this.kG(false);
                    }
                    a.this.fuY.nk(false);
                }
            }
        };
        editorTools.bx(true);
        this.fuY = new com.baidu.tieba.write.b();
        this.fuY.uK(d.C0126d.cp_cont_h_alpha85);
        this.fuY.uJ(d.C0126d.cp_cont_i);
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> yr() {
        return this.mContext;
    }

    public void gn(String str) {
        this.aEu = str;
    }

    public void J(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (DD() != null && (DD().eI(28) instanceof c) && ((c) DD().eI(28)).getInputView() != null) {
            EditText inputView = ((c) DD().eI(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, String str) {
        if (AntiHelper.ts(i)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            gt(str);
        } else {
            uw(str);
        }
    }

    private void gt(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(yr().getPageActivity());
        aVar.dc(str);
        aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(yr()).tC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzN() {
        if (DD() != null) {
            DD().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            DD().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            DD().hide();
        }
        if (this.gXc != null) {
            this.gXc.nf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.aEx != null) {
            this.aEx.setWriteData(null);
            this.aEx.mw(false);
        }
    }

    public void onDestroy() {
        if (this.aEx != null) {
            this.aEx.cancelLoadData();
        }
    }

    public void Eu() {
        if (this.aEx == null) {
            this.aEx = new NewWriteModel(this.mContext);
            this.aEx.b(this.aEL);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.aEu);
        this.aEx.setWriteData(writeData);
        this.aEx.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                if (i2 == 0) {
                    this.aEL.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.aEx.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    bzN();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kG(boolean z) {
        if (DD() != null && (DD().eI(28) instanceof c) && ((c) DD().eI(28)).getInputView() != null && ((c) DD().eI(28)).getInputView().getText() != null) {
            EditText inputView = ((c) DD().eI(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.fuY.b(inputView.getText());
            if (b != null) {
                this.fuY.nk(true);
                inputView.setText(b);
                if (z && this.fuY.bAT() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.fuY.bAT());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.fuY.nj(this.fuY.bAT() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0231a interfaceC0231a) {
        this.gXc = interfaceC0231a;
    }

    public void bzO() {
        al alVar = new al("c13026");
        alVar.ac("tid", this.mThreadId);
        alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
        alVar.ac(ImageViewerConfig.FORUM_ID, this.mForumId);
        TiebaStatic.log(alVar);
    }
}
