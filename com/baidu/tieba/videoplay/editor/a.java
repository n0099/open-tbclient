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
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class a extends d {
    private final NewWriteModel.d aWI;
    private String aWr;
    private NewWriteModel aWu;
    private com.baidu.tieba.write.b gbd;
    private InterfaceC0319a hEN;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0319a {
        void oh(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.aWr = "";
        this.mThreadId = null;
        this.aWI = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.aWu != null) {
                    if (a.this.KT() != null) {
                        a.this.KT().hide();
                    }
                    if (a.this.hEN != null) {
                        a.this.hEN.oh(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.aWu.getWriteData() : writeData;
                    if (z) {
                        a.this.gbd.wO(null);
                        a.this.gbd.az(null);
                        a.this.gbd.oo(false);
                        a.this.bJH();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.Fy().getResources().getString(e.j.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.e(a.this.Fy().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && wVar != null && !TextUtils.isEmpty(wVar.FR())) {
                        writeData2.setVcodeMD5(wVar.getVcode_md5());
                        writeData2.setVcodeUrl(wVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(wVar.FS());
                        if (com.baidu.tbadk.q.a.iA(wVar.FR())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, wVar.FR())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.wG(postWriteCallBackData.getErrorString());
                        a.this.gbd.az(postWriteCallBackData.getSensitiveWords());
                        a.this.gbd.wO(postWriteCallBackData.getErrorString());
                        if (!v.I(a.this.gbd.bKP())) {
                            a.this.lI(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.ve(postWriteCallBackData.getErrorCode()))) {
                        a.this.k(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.wG(postWriteCallBackData.getErrorString());
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
                if (a.this.gbd != null) {
                    if (!a.this.gbd.bKS()) {
                        a.this.lI(false);
                    }
                    a.this.gbd.op(false);
                }
            }
        };
        editorTools.cp(true);
        this.gbd = new com.baidu.tieba.write.b();
        this.gbd.wz(e.d.cp_cont_h_alpha85);
        this.gbd.wy(e.d.cp_cont_i);
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> Fy() {
        return this.mContext;
    }

    public void hx(String str) {
        this.aWr = str;
    }

    public void Q(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (KT() != null && (KT().fw(28) instanceof c) && ((c) KT().fw(28)).getInputView() != null) {
            EditText inputView = ((c) KT().fw(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, String str) {
        if (AntiHelper.ai(i, str)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            hC(str);
        } else {
            wG(str);
        }
    }

    private void hC(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Fy().getPageActivity());
        aVar.ej(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(Fy()).AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJH() {
        if (KT() != null) {
            KT().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            KT().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            KT().hide();
        }
        if (this.hEN != null) {
            this.hEN.oh(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.aWu != null) {
            this.aWu.setWriteData(null);
            this.aWu.nx(false);
        }
    }

    public void onDestroy() {
        if (this.aWu != null) {
            this.aWu.cancelLoadData();
        }
    }

    public void LL() {
        if (this.aWu == null) {
            this.aWu = new NewWriteModel(this.mContext);
            this.aWu.b(this.aWI);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.aWr);
        this.aWu.setWriteData(writeData);
        this.aWu.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                if (i2 == 0) {
                    this.aWI.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.aWu.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    bJH();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(boolean z) {
        if (KT() != null && (KT().fw(28) instanceof c) && ((c) KT().fw(28)).getInputView() != null && ((c) KT().fw(28)).getInputView().getText() != null) {
            EditText inputView = ((c) KT().fw(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.gbd.b(inputView.getText());
            if (b != null) {
                this.gbd.op(true);
                inputView.setText(b);
                if (z && this.gbd.bKQ() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.gbd.bKQ());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.gbd.oo(this.gbd.bKQ() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wG(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0319a interfaceC0319a) {
        this.hEN = interfaceC0319a;
    }

    public void bJI() {
        am amVar = new am("c13026");
        amVar.ax("tid", this.mThreadId);
        amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
        amVar.ax(ImageViewerConfig.FORUM_ID, this.mForumId);
        TiebaStatic.log(amVar);
    }
}
