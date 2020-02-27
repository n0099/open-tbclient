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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes11.dex */
public class a extends d {
    private TbPageContext<?> cVg;
    private NewWriteModel dyl;
    private final NewWriteModel.d dyz;
    private com.baidu.tieba.write.c hgO;
    public VideoItemData kGi;
    private InterfaceC0628a kHb;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0628a {
        void tz(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.dyz = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.dyl != null) {
                    if (a.this.aOr() != null) {
                        a.this.aOr().hide();
                    }
                    if (a.this.kHb != null) {
                        a.this.kHb.tz(false);
                    }
                    WriteData cHS = writeData == null ? a.this.dyl.cHS() : writeData;
                    if (z) {
                        a.this.hgO.KK(null);
                        a.this.hgO.aU(null);
                        a.this.hgO.tG(false);
                        a.this.cTh();
                        a.this.resetData();
                        if (cHS != null) {
                            String string = a.this.aJo().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cHS.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.aJo().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cHS != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJD())) {
                        cHS.setVcodeMD5(aaVar.getVcode_md5());
                        cHS.setVcodeUrl(aaVar.getVcode_pic_url());
                        cHS.setVcodeExtra(aaVar.aJE());
                        if (com.baidu.tbadk.s.a.wa(aaVar.aJD())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.cVg.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cHS, false, aaVar.aJD())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.cVg.getPageActivity(), cHS, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.cVg.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cHS, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.KH(postWriteCallBackData.getErrorString());
                        a.this.hgO.aU(postWriteCallBackData.getSensitiveWords());
                        a.this.hgO.KK(postWriteCallBackData.getErrorString());
                        if (!v.isEmpty(a.this.hgO.cUa())) {
                            a.this.mP(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.CD(postWriteCallBackData.getErrorCode()))) {
                        a.this.T(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.KH(postWriteCallBackData.getErrorString());
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
                if (a.this.hgO != null) {
                    if (!a.this.hgO.cUd()) {
                        a.this.mP(false);
                    }
                    a.this.hgO.tH(false);
                }
            }
        };
        editorTools.gB(true);
        this.hgO = new com.baidu.tieba.write.c();
        this.hgO.Ea(R.color.cp_cont_h_alpha85);
        this.hgO.DZ(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cVg = tbPageContext;
    }

    public TbPageContext<?> aJo() {
        return this.cVg;
    }

    public void vm(String str) {
        this.mPostContent = str;
    }

    public void aw(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (aOr() != null && (aOr().mp(28) instanceof c) && ((c) aOr().mp(28)).getInputView() != null) {
            EditText inputView = ((c) aOr().mp(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.kGi = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, String str) {
        if (AntiHelper.bb(i, str)) {
            AntiHelper.a(this.cVg.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            vq(str);
        } else {
            KH(str);
        }
    }

    private void vq(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aJo().getPageActivity());
        aVar.sS(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aJo()).aEA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTh() {
        if (aOr() != null) {
            aOr().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            aOr().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            aOr().hide();
        }
        if (this.kHb != null) {
            this.kHb.tz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.dyl != null) {
            this.dyl.d((WriteData) null);
            this.dyl.sS(false);
        }
    }

    public void onDestroy() {
        if (this.dyl != null) {
            this.dyl.cancelLoadData();
        }
    }

    public void aPm() {
        if (this.dyl == null) {
            this.dyl = new NewWriteModel(this.cVg);
            this.dyl.b(this.dyz);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.kGi != null && this.kGi.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.kGi.baijiahaoData);
        }
        this.dyl.d(writeData);
        this.dyl.cMh();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.dyz.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.dyl.cHS(), null);
                    return;
                } else if (i2 == -1) {
                    cTh();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cTi() {
        if (aOr() != null && (aOr().mp(28) instanceof c) && ((c) aOr().mp(28)).getInputView() != null && ((c) aOr().mp(28)).getInputView().getText() != null) {
            ((c) aOr().mp(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mP(boolean z) {
        if (aOr() != null && (aOr().mp(28) instanceof c) && ((c) aOr().mp(28)).getInputView() != null && ((c) aOr().mp(28)).getInputView().getText() != null) {
            EditText inputView = ((c) aOr().mp(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder a = this.hgO.a(inputView.getText());
            if (a != null) {
                this.hgO.tH(true);
                inputView.setText(a);
                if (z && this.hgO.cUb() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.hgO.cUb());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.hgO.tG(this.hgO.cUb() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KH(String str) {
        if (this.cVg != null && !StringUtils.isNull(str)) {
            this.cVg.showToast(str);
        }
    }

    public void a(InterfaceC0628a interfaceC0628a) {
        this.kHb = interfaceC0628a;
    }

    public void cTj() {
        an anVar = new an("c13026");
        anVar.cy("tid", this.mThreadId);
        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.cy("fid", this.mForumId);
        TiebaStatic.log(anVar);
    }
}
