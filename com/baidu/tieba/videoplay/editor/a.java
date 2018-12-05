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
    private String aZO;
    private NewWriteModel aZR;
    private final NewWriteModel.d baf;
    private com.baidu.tieba.write.b ghU;
    private InterfaceC0333a hLY;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0333a {
        void oj(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.aZO = "";
        this.mThreadId = null;
        this.baf = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.aZR != null) {
                    if (a.this.LX() != null) {
                        a.this.LX().hide();
                    }
                    if (a.this.hLY != null) {
                        a.this.hLY.oj(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.aZR.getWriteData() : writeData;
                    if (z) {
                        a.this.ghU.xr(null);
                        a.this.ghU.az(null);
                        a.this.ghU.oq(false);
                        a.this.bLM();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.GC().getResources().getString(e.j.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.e(a.this.GC().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && wVar != null && !TextUtils.isEmpty(wVar.GV())) {
                        writeData2.setVcodeMD5(wVar.getVcode_md5());
                        writeData2.setVcodeUrl(wVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(wVar.GW());
                        if (com.baidu.tbadk.r.a.iS(wVar.GV())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, wVar.GV())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.xj(postWriteCallBackData.getErrorString());
                        a.this.ghU.az(postWriteCallBackData.getSensitiveWords());
                        a.this.ghU.xr(postWriteCallBackData.getErrorString());
                        if (!v.I(a.this.ghU.bMV())) {
                            a.this.lL(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.vA(postWriteCallBackData.getErrorCode()))) {
                        a.this.k(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.xj(postWriteCallBackData.getErrorString());
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
                if (a.this.ghU != null) {
                    if (!a.this.ghU.bMY()) {
                        a.this.lL(false);
                    }
                    a.this.ghU.or(false);
                }
            }
        };
        editorTools.cq(true);
        this.ghU = new com.baidu.tieba.write.b();
        this.ghU.wW(e.d.cp_cont_h_alpha85);
        this.ghU.wV(e.d.cp_cont_i);
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> GC() {
        return this.mContext;
    }

    public void hP(String str) {
        this.aZO = str;
    }

    public void R(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (LX() != null && (LX().fK(28) instanceof c) && ((c) LX().fK(28)).getInputView() != null) {
            EditText inputView = ((c) LX().fK(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, String str) {
        if (AntiHelper.ai(i, str)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            hT(str);
        } else {
            xj(str);
        }
    }

    private void hT(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(GC().getPageActivity());
        aVar.eB(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(GC()).BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLM() {
        if (LX() != null) {
            LX().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            LX().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            LX().hide();
        }
        if (this.hLY != null) {
            this.hLY.oj(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.aZR != null) {
            this.aZR.setWriteData(null);
            this.aZR.nz(false);
        }
    }

    public void onDestroy() {
        if (this.aZR != null) {
            this.aZR.cancelLoadData();
        }
    }

    public void MP() {
        if (this.aZR == null) {
            this.aZR = new NewWriteModel(this.mContext);
            this.aZR.b(this.baf);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.aZO);
        this.aZR.setWriteData(writeData);
        this.aZR.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                if (i2 == 0) {
                    this.baf.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.aZR.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    bLM();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lL(boolean z) {
        if (LX() != null && (LX().fK(28) instanceof c) && ((c) LX().fK(28)).getInputView() != null && ((c) LX().fK(28)).getInputView().getText() != null) {
            EditText inputView = ((c) LX().fK(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.ghU.b(inputView.getText());
            if (b != null) {
                this.ghU.or(true);
                inputView.setText(b);
                if (z && this.ghU.bMW() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.ghU.bMW());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.ghU.oq(this.ghU.bMW() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0333a interfaceC0333a) {
        this.hLY = interfaceC0333a;
    }

    public void bLN() {
        am amVar = new am("c13026");
        amVar.aA("tid", this.mThreadId);
        amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
        amVar.aA(ImageViewerConfig.FORUM_ID, this.mForumId);
        TiebaStatic.log(amVar);
    }
}
