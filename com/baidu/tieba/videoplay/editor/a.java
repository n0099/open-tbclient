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
/* loaded from: classes4.dex */
public class a extends d {
    private String aVB;
    private NewWriteModel aVE;
    private final NewWriteModel.d aVS;
    private com.baidu.tieba.write.b fZH;
    private InterfaceC0291a hDd;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0291a {
        void nT(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.aVB = "";
        this.mThreadId = null;
        this.aVS = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.aVE != null) {
                    if (a.this.KH() != null) {
                        a.this.KH().hide();
                    }
                    if (a.this.hDd != null) {
                        a.this.hDd.nT(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.aVE.getWriteData() : writeData;
                    if (z) {
                        a.this.fZH.wJ(null);
                        a.this.fZH.aA(null);
                        a.this.fZH.oa(false);
                        a.this.bKi();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.Fm().getResources().getString(e.j.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.e(a.this.Fm().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && vVar != null && !TextUtils.isEmpty(vVar.FF())) {
                        writeData2.setVcodeMD5(vVar.getVcode_md5());
                        writeData2.setVcodeUrl(vVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(vVar.FG());
                        if (com.baidu.tbadk.q.a.iy(vVar.FF())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, vVar.FF())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.wB(postWriteCallBackData.getErrorString());
                        a.this.fZH.aA(postWriteCallBackData.getSensitiveWords());
                        a.this.fZH.wJ(postWriteCallBackData.getErrorString());
                        if (!com.baidu.tbadk.core.util.v.J(a.this.fZH.bLq())) {
                            a.this.lx(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.uL(postWriteCallBackData.getErrorCode()))) {
                        a.this.l(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.wB(postWriteCallBackData.getErrorString());
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
                if (a.this.fZH != null) {
                    if (!a.this.fZH.bLt()) {
                        a.this.lx(false);
                    }
                    a.this.fZH.ob(false);
                }
            }
        };
        editorTools.bY(true);
        this.fZH = new com.baidu.tieba.write.b();
        this.fZH.wg(e.d.cp_cont_h_alpha85);
        this.fZH.wf(e.d.cp_cont_i);
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> Fm() {
        return this.mContext;
    }

    public void hw(String str) {
        this.aVB = str;
    }

    public void Q(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (KH() != null && (KH().fi(28) instanceof c) && ((c) KH().fi(28)).getInputView() != null) {
            EditText inputView = ((c) KH().fi(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, String str) {
        if (AntiHelper.am(i, str)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            hB(str);
        } else {
            wB(str);
        }
    }

    private void hB(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Fm().getPageActivity());
        aVar.ej(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(Fm()).Au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKi() {
        if (KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            KH().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            KH().hide();
        }
        if (this.hDd != null) {
            this.hDd.nT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.aVE != null) {
            this.aVE.setWriteData(null);
            this.aVE.nm(false);
        }
    }

    public void onDestroy() {
        if (this.aVE != null) {
            this.aVE.cancelLoadData();
        }
    }

    public void Lz() {
        if (this.aVE == null) {
            this.aVE = new NewWriteModel(this.mContext);
            this.aVE.b(this.aVS);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.aVB);
        this.aVE.setWriteData(writeData);
        this.aVE.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                if (i2 == 0) {
                    this.aVS.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.aVE.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    bKi();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lx(boolean z) {
        if (KH() != null && (KH().fi(28) instanceof c) && ((c) KH().fi(28)).getInputView() != null && ((c) KH().fi(28)).getInputView().getText() != null) {
            EditText inputView = ((c) KH().fi(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.fZH.b(inputView.getText());
            if (b != null) {
                this.fZH.ob(true);
                inputView.setText(b);
                if (z && this.fZH.bLr() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.fZH.bLr());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.fZH.oa(this.fZH.bLr() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wB(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0291a interfaceC0291a) {
        this.hDd = interfaceC0291a;
    }

    public void bKj() {
        am amVar = new am("c13026");
        amVar.ax("tid", this.mThreadId);
        amVar.h("uid", TbadkCoreApplication.getCurrentAccountId());
        amVar.ax(ImageViewerConfig.FORUM_ID, this.mForumId);
        TiebaStatic.log(amVar);
    }
}
