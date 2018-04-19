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
    private final NewWriteModel.d aEK;
    private String aEt;
    private NewWriteModel aEw;
    private TbPageContext<?> adf;
    private com.baidu.tieba.write.b ftU;
    private InterfaceC0231a gWb;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0231a {
        void ne(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.aEt = "";
        this.mThreadId = null;
        this.aEK = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.aEw != null) {
                    if (a.this.DF() != null) {
                        a.this.DF().hide();
                    }
                    if (a.this.gWb != null) {
                        a.this.gWb.ne(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.aEw.getWriteData() : writeData;
                    if (z) {
                        a.this.ftU.uB(null);
                        a.this.ftU.ax(null);
                        a.this.ftU.ni(false);
                        a.this.bzP();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.ys().getResources().getString(d.k.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.e(a.this.ys().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.yK())) {
                        writeData2.setVcodeMD5(tVar.getVcode_md5());
                        writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(tVar.yL());
                        if (com.baidu.tbadk.p.a.hq(tVar.yK())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.adf.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.yK())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.adf.getPageActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.adf.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.ut(postWriteCallBackData.getErrorString());
                        a.this.ftU.ax(postWriteCallBackData.getSensitiveWords());
                        a.this.ftU.uB(postWriteCallBackData.getErrorString());
                        if (!v.w(a.this.ftU.bAU())) {
                            a.this.kF(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.tt(postWriteCallBackData.getErrorCode()))) {
                        a.this.j(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.ut(postWriteCallBackData.getErrorString());
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
                if (a.this.ftU != null) {
                    if (!a.this.ftU.bAX()) {
                        a.this.kF(false);
                    }
                    a.this.ftU.nj(false);
                }
            }
        };
        editorTools.bx(true);
        this.ftU = new com.baidu.tieba.write.b();
        this.ftU.uL(d.C0126d.cp_cont_h_alpha85);
        this.ftU.uK(d.C0126d.cp_cont_i);
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.adf = tbPageContext;
    }

    public TbPageContext<?> ys() {
        return this.adf;
    }

    public void gn(String str) {
        this.aEt = str;
    }

    public void J(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (DF() != null && (DF().eH(28) instanceof c) && ((c) DF().eH(28)).getInputView() != null) {
            EditText inputView = ((c) DF().eH(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, String str) {
        if (AntiHelper.tt(i)) {
            AntiHelper.a(this.adf.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            gt(str);
        } else {
            ut(str);
        }
    }

    private void gt(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ys().getPageActivity());
        aVar.dc(str);
        aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(ys()).tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzP() {
        if (DF() != null) {
            DF().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            DF().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            DF().hide();
        }
        if (this.gWb != null) {
            this.gWb.ne(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.aEw != null) {
            this.aEw.setWriteData(null);
            this.aEw.mv(false);
        }
    }

    public void onDestroy() {
        if (this.aEw != null) {
            this.aEw.cancelLoadData();
        }
    }

    public void Ew() {
        if (this.aEw == null) {
            this.aEw = new NewWriteModel(this.adf);
            this.aEw.b(this.aEK);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.aEt);
        this.aEw.setWriteData(writeData);
        this.aEw.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                if (i2 == 0) {
                    this.aEK.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.aEw.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    bzP();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kF(boolean z) {
        if (DF() != null && (DF().eH(28) instanceof c) && ((c) DF().eH(28)).getInputView() != null && ((c) DF().eH(28)).getInputView().getText() != null) {
            EditText inputView = ((c) DF().eH(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.ftU.b(inputView.getText());
            if (b != null) {
                this.ftU.nj(true);
                inputView.setText(b);
                if (z && this.ftU.bAV() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.ftU.bAV());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.ftU.ni(this.ftU.bAV() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ut(String str) {
        if (this.adf != null && !StringUtils.isNull(str)) {
            this.adf.showToast(str);
        }
    }

    public void a(InterfaceC0231a interfaceC0231a) {
        this.gWb = interfaceC0231a;
    }

    public void bzQ() {
        al alVar = new al("c13026");
        alVar.ac("tid", this.mThreadId);
        alVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
        alVar.ac(ImageViewerConfig.FORUM_ID, this.mForumId);
        TiebaStatic.log(alVar);
    }
}
