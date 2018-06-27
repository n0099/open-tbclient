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
    private String aNM;
    private NewWriteModel aNP;
    private final NewWriteModel.d aOd;
    private com.baidu.tieba.write.b fKu;
    private InterfaceC0250a hmJ;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0250a {
        void nt(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.aNM = "";
        this.mThreadId = null;
        this.aOd = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.aNP != null) {
                    if (a.this.Hy() != null) {
                        a.this.Hy().hide();
                    }
                    if (a.this.hmJ != null) {
                        a.this.hmJ.nt(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.aNP.getWriteData() : writeData;
                    if (z) {
                        a.this.fKu.vu(null);
                        a.this.fKu.aB(null);
                        a.this.fKu.nz(false);
                        a.this.bFs();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.Ci().getResources().getString(d.k.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.e(a.this.Ci().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.CB())) {
                        writeData2.setVcodeMD5(tVar.getVcode_md5());
                        writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(tVar.CC());
                        if (com.baidu.tbadk.p.a.hQ(tVar.CB())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.CB())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.vm(postWriteCallBackData.getErrorString());
                        a.this.fKu.aB(postWriteCallBackData.getSensitiveWords());
                        a.this.fKu.vu(postWriteCallBackData.getErrorString());
                        if (!w.A(a.this.fKu.bGy())) {
                            a.this.kW(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.tQ(postWriteCallBackData.getErrorCode()))) {
                        a.this.j(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.vm(postWriteCallBackData.getErrorString());
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
                if (a.this.fKu != null) {
                    if (!a.this.fKu.bGB()) {
                        a.this.kW(false);
                    }
                    a.this.fKu.nA(false);
                }
            }
        };
        editorTools.bE(true);
        this.fKu = new com.baidu.tieba.write.b();
        this.fKu.vk(d.C0142d.cp_cont_h_alpha85);
        this.fKu.vj(d.C0142d.cp_cont_i);
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> Ci() {
        return this.mContext;
    }

    public void gQ(String str) {
        this.aNM = str;
    }

    public void I(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (Hy() != null && (Hy().eN(28) instanceof c) && ((c) Hy().eN(28)).getInputView() != null) {
            EditText inputView = ((c) Hy().eN(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, String str) {
        if (AntiHelper.tQ(i)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            gV(str);
        } else {
            vm(str);
        }
    }

    private void gV(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Ci().getPageActivity());
        aVar.dE(str);
        aVar.b(d.k.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(Ci()).xn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFs() {
        if (Hy() != null) {
            Hy().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            Hy().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            Hy().hide();
        }
        if (this.hmJ != null) {
            this.hmJ.nt(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.aNP != null) {
            this.aNP.setWriteData(null);
            this.aNP.mN(false);
        }
    }

    public void onDestroy() {
        if (this.aNP != null) {
            this.aNP.cancelLoadData();
        }
    }

    public void Iq() {
        if (this.aNP == null) {
            this.aNP = new NewWriteModel(this.mContext);
            this.aNP.b(this.aOd);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.aNM);
        this.aNP.setWriteData(writeData);
        this.aNP.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                if (i2 == 0) {
                    this.aOd.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.aNP.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    bFs();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW(boolean z) {
        if (Hy() != null && (Hy().eN(28) instanceof c) && ((c) Hy().eN(28)).getInputView() != null && ((c) Hy().eN(28)).getInputView().getText() != null) {
            EditText inputView = ((c) Hy().eN(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.fKu.b(inputView.getText());
            if (b != null) {
                this.fKu.nA(true);
                inputView.setText(b);
                if (z && this.fKu.bGz() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.fKu.bGz());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.fKu.nz(this.fKu.bGz() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vm(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0250a interfaceC0250a) {
        this.hmJ = interfaceC0250a;
    }

    public void bFt() {
        an anVar = new an("c13026");
        anVar.ah("tid", this.mThreadId);
        anVar.f("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.ah(ImageViewerConfig.FORUM_ID, this.mForumId);
        TiebaStatic.log(anVar);
    }
}
