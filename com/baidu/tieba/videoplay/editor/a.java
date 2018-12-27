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
    private String aZR;
    private NewWriteModel aZU;
    private final NewWriteModel.d bai;
    private com.baidu.tieba.write.b gkM;
    private InterfaceC0333a hPj;
    private TbPageContext<?> mContext;
    private String mForumId;
    private String mForumName;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0333a {
        void om(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.aZR = "";
        this.mThreadId = null;
        this.bai = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.aZU != null) {
                    if (a.this.LY() != null) {
                        a.this.LY().hide();
                    }
                    if (a.this.hPj != null) {
                        a.this.hPj.om(false);
                    }
                    WriteData writeData2 = writeData == null ? a.this.aZU.getWriteData() : writeData;
                    if (z) {
                        a.this.gkM.xu(null);
                        a.this.gkM.aA(null);
                        a.this.gkM.ot(false);
                        a.this.bMB();
                        a.this.resetData();
                        if (writeData2 != null) {
                            String string = a.this.GD().getResources().getString(e.j.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (writeData2.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.e(a.this.GD().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (writeData2 != null && wVar != null && !TextUtils.isEmpty(wVar.GW())) {
                        writeData2.setVcodeMD5(wVar.getVcode_md5());
                        writeData2.setVcodeUrl(wVar.getVcode_pic_url());
                        writeData2.setVcodeExtra(wVar.GX());
                        if (com.baidu.tbadk.r.a.iT(wVar.GW())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, wVar.GW())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.mContext.getPageActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.xm(postWriteCallBackData.getErrorString());
                        a.this.gkM.aA(postWriteCallBackData.getSensitiveWords());
                        a.this.gkM.xu(postWriteCallBackData.getErrorString());
                        if (!v.I(a.this.gkM.bNL())) {
                            a.this.lO(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.vN(postWriteCallBackData.getErrorCode()))) {
                        a.this.k(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.xm(postWriteCallBackData.getErrorString());
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
                if (a.this.gkM != null) {
                    if (!a.this.gkM.bNO()) {
                        a.this.lO(false);
                    }
                    a.this.gkM.ou(false);
                }
            }
        };
        editorTools.cq(true);
        this.gkM = new com.baidu.tieba.write.b();
        this.gkM.xj(e.d.cp_cont_h_alpha85);
        this.gkM.xi(e.d.cp_cont_i);
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> GD() {
        return this.mContext;
    }

    public void hQ(String str) {
        this.aZR = str;
    }

    public void R(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (LY() != null && (LY().fL(28) instanceof c) && ((c) LY().fL(28)).getInputView() != null) {
            EditText inputView = ((c) LY().fL(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, String str) {
        if (AntiHelper.aj(i, str)) {
            AntiHelper.a(this.mContext.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            hU(str);
        } else {
            xm(str);
        }
    }

    private void hU(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(GD().getPageActivity());
        aVar.eB(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(GD()).BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMB() {
        if (LY() != null) {
            LY().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            LY().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            LY().hide();
        }
        if (this.hPj != null) {
            this.hPj.om(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.aZU != null) {
            this.aZU.setWriteData(null);
            this.aZU.nC(false);
        }
    }

    public void onDestroy() {
        if (this.aZU != null) {
            this.aZU.cancelLoadData();
        }
    }

    public void MQ() {
        if (this.aZU == null) {
            this.aZU = new NewWriteModel(this.mContext);
            this.aZU.b(this.bai);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.aZR);
        this.aZU.setWriteData(writeData);
        this.aZU.startPostWrite();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                if (i2 == 0) {
                    this.bai.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.aZU.getWriteData(), null);
                    return;
                } else if (i2 == -1) {
                    bMB();
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
        if (LY() != null && (LY().fL(28) instanceof c) && ((c) LY().fL(28)).getInputView() != null && ((c) LY().fL(28)).getInputView().getText() != null) {
            EditText inputView = ((c) LY().fL(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder b = this.gkM.b(inputView.getText());
            if (b != null) {
                this.gkM.ou(true);
                inputView.setText(b);
                if (z && this.gkM.bNM() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.gkM.bNM());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.gkM.ot(this.gkM.bNM() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xm(String str) {
        if (this.mContext != null && !StringUtils.isNull(str)) {
            this.mContext.showToast(str);
        }
    }

    public void a(InterfaceC0333a interfaceC0333a) {
        this.hPj = interfaceC0333a;
    }

    public void bMC() {
        am amVar = new am("c13026");
        amVar.aA("tid", this.mThreadId);
        amVar.i("uid", TbadkCoreApplication.getCurrentAccountId());
        amVar.aA(ImageViewerConfig.FORUM_ID, this.mForumId);
        TiebaStatic.log(amVar);
    }
}
