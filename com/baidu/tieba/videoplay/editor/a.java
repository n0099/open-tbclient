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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    private String aNL;
    private NewWriteModel aNO;
    private final NewWriteModel.d aOc;
    private com.baidu.tieba.write.b fKI;
    private InterfaceC0250a hnX;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0250a {
        void ng(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.aNL = "";
        this.mThreadId = null;
        this.aOc = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.aNO != null) {
                    if (a.this.Ht() != null) {
                        a.this.Ht().hide();
                    }
                    if (a.this.hnX != null) {
                        a.this.hnX.ng(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.aNO.getWriteData() : writeData;
                    if (z) {
                        a.this.fKI.vv(null);
                        a.this.fKI.az(null);
                        a.this.fKI.nn(false);
                        a.this.bEd();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.Ca().getResources().getString(d.j.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.e(a.this.Ca().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.Ct())) {
                        writeData2.setVcodeMD5(tVar.getVcode_md5());
                        writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(tVar.Cu());
                        if (com.baidu.tbadk.q.a.hN(tVar.Ct())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.Ct())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.vn(postWriteCallBackData.getErrorString());
                        a.this.fKI.az(postWriteCallBackData.getSensitiveWords());
                        a.this.fKI.vv(postWriteCallBackData.getErrorString());
                        if (!w.z(a.this.fKI.bFj())) {
                            a.this.kI(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.tO(postWriteCallBackData.getErrorCode()))) {
                        a.this.l(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.vn(postWriteCallBackData.getErrorString());
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
                if (a.this.fKI != null) {
                    if (!a.this.fKI.bFm()) {
                        a.this.kI(false);
                    }
                    a.this.fKI.no(false);
                }
            }
        };
        editorTools.bC(true);
        this.fKI = new com.baidu.tieba.write.b();
        this.fKI.vj(d.C0140d.cp_cont_h_alpha85);
        this.fKI.vi(d.C0140d.cp_cont_i);
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> Ca() {
        return this.mContext;
    }

    public void gM(String str) {
        this.aNL = str;
    }

    public void J(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (Ht() != null && (Ht().eO(28) instanceof c) && ((c) Ht().eO(28)).getInputView() != null) {
            EditText inputView = ((c) Ht().eO(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, String str) {
        if (AntiHelper.al(i, str)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            gR(str);
        } else {
            vn(str);
        }
    }

    private void gR(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Ca().getPageActivity());
        aVar.dB(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(Ca()).xf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEd() {
        if (Ht() != null) {
            Ht().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            Ht().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            Ht().hide();
        }
        if (this.hnX != null) {
            this.hnX.ng(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.aNO != null) {
            this.aNO.setWriteData(null);
            this.aNO.my(false);
        }
    }

    public void onDestroy() {
        if (this.aNO != null) {
            this.aNO.cancelLoadData();
        }
    }

    public void Il() {
        if (this.aNO == null) {
            this.aNO = new NewWriteModel(this.mContext);
            this.aNO.b(this.aOc);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.aNL);
        this.aNO.setWriteData(writeData);
        this.aNO.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                if (i2 == 0) {
                    this.aOc.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.aNO.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    bEd();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kI(boolean z) {
        if (Ht() != null && (Ht().eO(28) instanceof c) && ((c) Ht().eO(28)).getInputView() != null && ((c) Ht().eO(28)).getInputView().getText() != null) {
            EditText inputView = ((c) Ht().eO(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.fKI.b(inputView.getText());
            if (b != null) {
                this.fKI.no(true);
                inputView.setText(b);
                if (z && this.fKI.bFk() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.fKI.bFk());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.fKI.nn(this.fKI.bFk() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vn(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0250a interfaceC0250a) {
        this.hnX = interfaceC0250a;
    }

    public void bEe() {
        an anVar = new an("c13026");
        anVar.af("tid", this.mThreadId);
        anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.af(ImageViewerConfig.FORUM_ID, this.mForumId);
        TiebaStatic.log(anVar);
    }
}
