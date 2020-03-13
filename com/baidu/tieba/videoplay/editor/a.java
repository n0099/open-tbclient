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
    private TbPageContext<?> cVi;
    private final NewWriteModel.d dyN;
    private NewWriteModel dyz;
    private com.baidu.tieba.write.c hhc;
    public VideoItemData kGw;
    private InterfaceC0628a kHp;
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
        this.dyN = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.dyz != null) {
                    if (a.this.aOu() != null) {
                        a.this.aOu().hide();
                    }
                    if (a.this.kHp != null) {
                        a.this.kHp.tz(false);
                    }
                    WriteData cHV = writeData == null ? a.this.dyz.cHV() : writeData;
                    if (z) {
                        a.this.hhc.KL(null);
                        a.this.hhc.aU(null);
                        a.this.hhc.tG(false);
                        a.this.cTk();
                        a.this.resetData();
                        if (cHV != null) {
                            String string = a.this.aJr().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cHV.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.aJr().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cHV != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJG())) {
                        cHV.setVcodeMD5(aaVar.getVcode_md5());
                        cHV.setVcodeUrl(aaVar.getVcode_pic_url());
                        cHV.setVcodeExtra(aaVar.aJH());
                        if (com.baidu.tbadk.s.a.wb(aaVar.aJG())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.cVi.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cHV, false, aaVar.aJG())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.cVi.getPageActivity(), cHV, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.cVi.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cHV, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.KI(postWriteCallBackData.getErrorString());
                        a.this.hhc.aU(postWriteCallBackData.getSensitiveWords());
                        a.this.hhc.KL(postWriteCallBackData.getErrorString());
                        if (!v.isEmpty(a.this.hhc.cUd())) {
                            a.this.mP(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.CD(postWriteCallBackData.getErrorCode()))) {
                        a.this.T(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.KI(postWriteCallBackData.getErrorString());
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
                if (a.this.hhc != null) {
                    if (!a.this.hhc.cUg()) {
                        a.this.mP(false);
                    }
                    a.this.hhc.tH(false);
                }
            }
        };
        editorTools.gB(true);
        this.hhc = new com.baidu.tieba.write.c();
        this.hhc.Ea(R.color.cp_cont_h_alpha85);
        this.hhc.DZ(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cVi = tbPageContext;
    }

    public TbPageContext<?> aJr() {
        return this.cVi;
    }

    public void vn(String str) {
        this.mPostContent = str;
    }

    public void aw(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (aOu() != null && (aOu().mp(28) instanceof c) && ((c) aOu().mp(28)).getInputView() != null) {
            EditText inputView = ((c) aOu().mp(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.kGw = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, String str) {
        if (AntiHelper.bb(i, str)) {
            AntiHelper.a(this.cVi.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            vr(str);
        } else {
            KI(str);
        }
    }

    private void vr(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aJr().getPageActivity());
        aVar.sS(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aJr()).aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTk() {
        if (aOu() != null) {
            aOu().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            aOu().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            aOu().hide();
        }
        if (this.kHp != null) {
            this.kHp.tz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.dyz != null) {
            this.dyz.d((WriteData) null);
            this.dyz.sS(false);
        }
    }

    public void onDestroy() {
        if (this.dyz != null) {
            this.dyz.cancelLoadData();
        }
    }

    public void aPp() {
        if (this.dyz == null) {
            this.dyz = new NewWriteModel(this.cVi);
            this.dyz.b(this.dyN);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.kGw != null && this.kGw.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.kGw.baijiahaoData);
        }
        this.dyz.d(writeData);
        this.dyz.cMk();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.dyN.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.dyz.cHV(), null);
                    return;
                } else if (i2 == -1) {
                    cTk();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cTl() {
        if (aOu() != null && (aOu().mp(28) instanceof c) && ((c) aOu().mp(28)).getInputView() != null && ((c) aOu().mp(28)).getInputView().getText() != null) {
            ((c) aOu().mp(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mP(boolean z) {
        if (aOu() != null && (aOu().mp(28) instanceof c) && ((c) aOu().mp(28)).getInputView() != null && ((c) aOu().mp(28)).getInputView().getText() != null) {
            EditText inputView = ((c) aOu().mp(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder a = this.hhc.a(inputView.getText());
            if (a != null) {
                this.hhc.tH(true);
                inputView.setText(a);
                if (z && this.hhc.cUe() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.hhc.cUe());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.hhc.tG(this.hhc.cUe() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KI(String str) {
        if (this.cVi != null && !StringUtils.isNull(str)) {
            this.cVi.showToast(str);
        }
    }

    public void a(InterfaceC0628a interfaceC0628a) {
        this.kHp = interfaceC0628a;
    }

    public void cTm() {
        an anVar = new an("c13026");
        anVar.cy("tid", this.mThreadId);
        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.cy("fid", this.mForumId);
        TiebaStatic.log(anVar);
    }
}
