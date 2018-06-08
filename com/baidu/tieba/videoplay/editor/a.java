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
    private String aMQ;
    private NewWriteModel aMT;
    private final NewWriteModel.d aNh;
    private com.baidu.tieba.write.b fGt;
    private InterfaceC0248a hiE;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0248a {
        void nl(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.aMQ = "";
        this.mThreadId = null;
        this.aNh = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.aMT != null) {
                    if (a.this.Hg() != null) {
                        a.this.Hg().hide();
                    }
                    if (a.this.hiE != null) {
                        a.this.hiE.nl(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.aMT.getWriteData() : writeData;
                    if (z) {
                        a.this.fGt.vy(null);
                        a.this.fGt.ax(null);
                        a.this.fGt.nr(false);
                        a.this.bES();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.BR().getResources().getString(d.k.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.e(a.this.BR().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.Cj())) {
                        writeData2.setVcodeMD5(tVar.getVcode_md5());
                        writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(tVar.Ck());
                        if (com.baidu.tbadk.p.a.hM(tVar.Cj())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.Cj())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.vq(postWriteCallBackData.getErrorString());
                        a.this.fGt.ax(postWriteCallBackData.getSensitiveWords());
                        a.this.fGt.vy(postWriteCallBackData.getErrorString());
                        if (!w.z(a.this.fGt.bFY())) {
                            a.this.kM(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.tE(postWriteCallBackData.getErrorCode()))) {
                        a.this.j(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.vq(postWriteCallBackData.getErrorString());
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
                if (a.this.fGt != null) {
                    if (!a.this.fGt.bGb()) {
                        a.this.kM(false);
                    }
                    a.this.fGt.ns(false);
                }
            }
        };
        editorTools.bB(true);
        this.fGt = new com.baidu.tieba.write.b();
        this.fGt.vb(d.C0141d.cp_cont_h_alpha85);
        this.fGt.va(d.C0141d.cp_cont_i);
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> BR() {
        return this.mContext;
    }

    public void gM(String str) {
        this.aMQ = str;
    }

    public void K(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (Hg() != null && (Hg().eM(28) instanceof c) && ((c) Hg().eM(28)).getInputView() != null) {
            EditText inputView = ((c) Hg().eM(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, String str) {
        if (AntiHelper.tE(i)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            gR(str);
        } else {
            vq(str);
        }
    }

    private void gR(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(BR().getPageActivity());
        aVar.dB(str);
        aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(BR()).xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bES() {
        if (Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            Hg().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            Hg().hide();
        }
        if (this.hiE != null) {
            this.hiE.nl(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.aMT != null) {
            this.aMT.setWriteData(null);
            this.aMT.mC(false);
        }
    }

    public void onDestroy() {
        if (this.aMT != null) {
            this.aMT.cancelLoadData();
        }
    }

    public void HY() {
        if (this.aMT == null) {
            this.aMT = new NewWriteModel(this.mContext);
            this.aMT.b(this.aNh);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.aMQ);
        this.aMT.setWriteData(writeData);
        this.aMT.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                if (i2 == 0) {
                    this.aNh.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.aMT.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    bES();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kM(boolean z) {
        if (Hg() != null && (Hg().eM(28) instanceof c) && ((c) Hg().eM(28)).getInputView() != null && ((c) Hg().eM(28)).getInputView().getText() != null) {
            EditText inputView = ((c) Hg().eM(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.fGt.b(inputView.getText());
            if (b != null) {
                this.fGt.ns(true);
                inputView.setText(b);
                if (z && this.fGt.bFZ() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.fGt.bFZ());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.fGt.nr(this.fGt.bFZ() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0248a interfaceC0248a) {
        this.hiE = interfaceC0248a;
    }

    public void bET() {
        am amVar = new am("c13026");
        amVar.ah("tid", this.mThreadId);
        amVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
        amVar.ah(ImageViewerConfig.FORUM_ID, this.mForumId);
        TiebaStatic.log(amVar);
    }
}
