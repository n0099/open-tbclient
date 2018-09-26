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
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class a extends d {
    private String aRa;
    private NewWriteModel aRd;
    private final NewWriteModel.d aRr;
    private com.baidu.tieba.write.b fSg;
    private InterfaceC0256a hvQ;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0256a {
        void nD(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.aRa = "";
        this.mThreadId = null;
        this.aRr = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.aRd != null) {
                    if (a.this.IJ() != null) {
                        a.this.IJ().hide();
                    }
                    if (a.this.hvQ != null) {
                        a.this.hvQ.nD(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.aRd.getWriteData() : writeData;
                    if (z) {
                        a.this.fSg.wi(null);
                        a.this.fSg.aA(null);
                        a.this.fSg.nK(false);
                        a.this.bGW();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.Dl().getResources().getString(e.j.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.e(a.this.Dl().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && vVar != null && !TextUtils.isEmpty(vVar.DE())) {
                        writeData2.setVcodeMD5(vVar.getVcode_md5());
                        writeData2.setVcodeUrl(vVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(vVar.DF());
                        if (com.baidu.tbadk.q.a.il(vVar.DE())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, vVar.DE())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.wa(postWriteCallBackData.getErrorString());
                        a.this.fSg.aA(postWriteCallBackData.getSensitiveWords());
                        a.this.fSg.wi(postWriteCallBackData.getErrorString());
                        if (!com.baidu.tbadk.core.util.v.z(a.this.fSg.bIe())) {
                            a.this.lg(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.uo(postWriteCallBackData.getErrorCode()))) {
                        a.this.l(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.wa(postWriteCallBackData.getErrorString());
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
                if (a.this.fSg != null) {
                    if (!a.this.fSg.bIh()) {
                        a.this.lg(false);
                    }
                    a.this.fSg.nL(false);
                }
            }
        };
        editorTools.bP(true);
        this.fSg = new com.baidu.tieba.write.b();
        this.fSg.vJ(e.d.cp_cont_h_alpha85);
        this.fSg.vI(e.d.cp_cont_i);
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> Dl() {
        return this.mContext;
    }

    public void hi(String str) {
        this.aRa = str;
    }

    public void J(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (IJ() != null && (IJ().eZ(28) instanceof c) && ((c) IJ().eZ(28)).getInputView() != null) {
            EditText inputView = ((c) IJ().eZ(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, String str) {
        if (AntiHelper.am(i, str)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            hn(str);
        } else {
            wa(str);
        }
    }

    private void hn(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Dl().getPageActivity());
        aVar.dT(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(Dl()).yl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGW() {
        if (IJ() != null) {
            IJ().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            IJ().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            IJ().hide();
        }
        if (this.hvQ != null) {
            this.hvQ.nD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.aRd != null) {
            this.aRd.setWriteData(null);
            this.aRd.mV(false);
        }
    }

    public void onDestroy() {
        if (this.aRd != null) {
            this.aRd.cancelLoadData();
        }
    }

    public void JB() {
        if (this.aRd == null) {
            this.aRd = new NewWriteModel(this.mContext);
            this.aRd.b(this.aRr);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.aRa);
        this.aRd.setWriteData(writeData);
        this.aRd.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                if (i2 == 0) {
                    this.aRr.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.aRd.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    bGW();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lg(boolean z) {
        if (IJ() != null && (IJ().eZ(28) instanceof c) && ((c) IJ().eZ(28)).getInputView() != null && ((c) IJ().eZ(28)).getInputView().getText() != null) {
            EditText inputView = ((c) IJ().eZ(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.fSg.b(inputView.getText());
            if (b != null) {
                this.fSg.nL(true);
                inputView.setText(b);
                if (z && this.fSg.bIf() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.fSg.bIf());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.fSg.nK(this.fSg.bIf() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0256a interfaceC0256a) {
        this.hvQ = interfaceC0256a;
    }

    public void bGX() {
        am amVar = new am("c13026");
        amVar.al("tid", this.mThreadId);
        amVar.g("uid", TbadkCoreApplication.getCurrentAccountId());
        amVar.al(ImageViewerConfig.FORUM_ID, this.mForumId);
        TiebaStatic.log(amVar);
    }
}
