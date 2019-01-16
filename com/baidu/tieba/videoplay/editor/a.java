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
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class a extends d {
    private String baC;
    private NewWriteModel baF;
    private final NewWriteModel.d baT;
    private com.baidu.tieba.write.b glP;
    private InterfaceC0332a hQq;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0332a {
        void on(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.baC = "";
        this.mThreadId = null;
        this.baT = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.baF != null) {
                    if (a.this.Mp() != null) {
                        a.this.Mp().hide();
                    }
                    if (a.this.hQq != null) {
                        a.this.hQq.on(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.baF.getWriteData() : writeData;
                    if (z) {
                        a.this.glP.xK(null);
                        a.this.glP.aA(null);
                        a.this.glP.ou(false);
                        a.this.bNj();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.GQ().getResources().getString(e.j.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.e(a.this.GQ().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.Hk())) {
                        writeData2.setVcodeMD5(xVar.getVcode_md5());
                        writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(xVar.Hl());
                        if (com.baidu.tbadk.r.a.jj(xVar.Hk())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, xVar.Hk())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.xC(postWriteCallBackData.getErrorString());
                        a.this.glP.aA(postWriteCallBackData.getSensitiveWords());
                        a.this.glP.xK(postWriteCallBackData.getErrorString());
                        if (!v.I(a.this.glP.bOt())) {
                            a.this.lO(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.vQ(postWriteCallBackData.getErrorCode()))) {
                        a.this.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.xC(postWriteCallBackData.getErrorString());
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
                if (a.this.glP != null) {
                    if (!a.this.glP.bOw()) {
                        a.this.lO(false);
                    }
                    a.this.glP.ov(false);
                }
            }
        };
        editorTools.ct(true);
        this.glP = new com.baidu.tieba.write.b();
        this.glP.xl(e.d.cp_cont_h_alpha85);
        this.glP.xk(e.d.cp_cont_i);
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> GQ() {
        return this.mContext;
    }

    /* renamed from: if  reason: not valid java name */
    public void m22if(String str) {
        this.baC = str;
    }

    public void R(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (Mp() != null && (Mp().fL(28) instanceof c) && ((c) Mp().fL(28)).getInputView() != null) {
            EditText inputView = ((c) Mp().fL(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str) {
        if (AntiHelper.al(i, str)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            ij(str);
        } else {
            xC(str);
        }
    }

    private void ij(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(GQ().getPageActivity());
        aVar.eK(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(GQ()).BS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNj() {
        if (Mp() != null) {
            Mp().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            Mp().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            Mp().hide();
        }
        if (this.hQq != null) {
            this.hQq.on(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.baF != null) {
            this.baF.setWriteData(null);
            this.baF.nD(false);
        }
    }

    public void onDestroy() {
        if (this.baF != null) {
            this.baF.cancelLoadData();
        }
    }

    public void Nh() {
        if (this.baF == null) {
            this.baF = new NewWriteModel(this.mContext);
            this.baF.b(this.baT);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.baC);
        this.baF.setWriteData(writeData);
        this.baF.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                if (i2 == 0) {
                    this.baT.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.baF.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    bNj();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(boolean z) {
        if (Mp() != null && (Mp().fL(28) instanceof c) && ((c) Mp().fL(28)).getInputView() != null && ((c) Mp().fL(28)).getInputView().getText() != null) {
            EditText inputView = ((c) Mp().fL(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.glP.b(inputView.getText());
            if (b != null) {
                this.glP.ov(true);
                inputView.setText(b);
                if (z && this.glP.bOu() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.glP.bOu());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.glP.ou(this.glP.bOu() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xC(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0332a interfaceC0332a) {
        this.hQq = interfaceC0332a;
    }

    public void bNk() {
        am amVar = new am("c13026");
        amVar.aB("tid", this.mThreadId);
        amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
        amVar.aB(ImageViewerConfig.FORUM_ID, this.mForumId);
        TiebaStatic.log(amVar);
    }
}
