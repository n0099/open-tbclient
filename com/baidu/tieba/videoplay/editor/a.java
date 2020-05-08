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
    private final NewWriteModel.d dYM;
    private NewWriteModel dYy;
    private TbPageContext<?> duK;
    private com.baidu.tieba.write.c hSs;
    public VideoItemData lsn;
    private InterfaceC0691a lth;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0691a {
        void uH(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.dYM = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.dYy != null) {
                    if (a.this.aWN() != null) {
                        a.this.aWN().hide();
                    }
                    if (a.this.lth != null) {
                        a.this.lth.uH(false);
                    }
                    WriteData cSK = writeData == null ? a.this.dYy.cSK() : writeData;
                    if (z) {
                        a.this.hSs.Ms(null);
                        a.this.hSs.aW(null);
                        a.this.hSs.uN(false);
                        a.this.deo();
                        a.this.resetData();
                        if (cSK != null) {
                            String string = a.this.aRP().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cSK.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.aRP().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cSK != null && aaVar != null && !TextUtils.isEmpty(aaVar.aSe())) {
                        cSK.setVcodeMD5(aaVar.getVcode_md5());
                        cSK.setVcodeUrl(aaVar.getVcode_pic_url());
                        cSK.setVcodeExtra(aaVar.aSf());
                        if (com.baidu.tbadk.s.a.xr(aaVar.aSe())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.duK.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cSK, false, aaVar.aSe())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.duK.getPageActivity(), cSK, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.duK.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cSK, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Mp(postWriteCallBackData.getErrorString());
                        a.this.hSs.aW(postWriteCallBackData.getSensitiveWords());
                        a.this.hSs.Ms(postWriteCallBackData.getErrorString());
                        if (!v.isEmpty(a.this.hSs.deP())) {
                            a.this.nZ(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Dp(postWriteCallBackData.getErrorCode()))) {
                        a.this.ak(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Mp(postWriteCallBackData.getErrorString());
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
                if (a.this.hSs != null) {
                    if (!a.this.hSs.deS()) {
                        a.this.nZ(false);
                    }
                    a.this.hSs.uO(false);
                }
            }
        };
        editorTools.hA(true);
        this.hSs = new com.baidu.tieba.write.c();
        this.hSs.EJ(R.color.cp_cont_h_alpha85);
        this.hSs.EI(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.duK = tbPageContext;
    }

    public TbPageContext<?> aRP() {
        return this.duK;
    }

    public void wE(String str) {
        this.mPostContent = str;
    }

    public void av(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (aWN() != null && (aWN().mD(28) instanceof c) && ((c) aWN().mD(28)).getInputView() != null) {
            EditText inputView = ((c) aWN().mD(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.lsn = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(int i, String str) {
        if (AntiHelper.bq(i, str)) {
            AntiHelper.a(this.duK.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            wI(str);
        } else {
            Mp(str);
        }
    }

    private void wI(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aRP().getPageActivity());
        aVar.ui(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aRP()).aMS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deo() {
        if (aWN() != null) {
            aWN().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            aWN().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            aWN().hide();
        }
        if (this.lth != null) {
            this.lth.uH(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.dYy != null) {
            this.dYy.d((WriteData) null);
            this.dYy.ua(false);
        }
    }

    public void onDestroy() {
        if (this.dYy != null) {
            this.dYy.cancelLoadData();
        }
    }

    public void aXI() {
        if (this.dYy == null) {
            this.dYy = new NewWriteModel(this.duK);
            this.dYy.b(this.dYM);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.lsn != null && this.lsn.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.lsn.baijiahaoData);
        }
        this.dYy.d(writeData);
        this.dYy.cXy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.dYM.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.dYy.cSK(), null);
                    return;
                } else if (i2 == -1) {
                    deo();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void dep() {
        if (aWN() != null && (aWN().mD(28) instanceof c) && ((c) aWN().mD(28)).getInputView() != null && ((c) aWN().mD(28)).getInputView().getText() != null) {
            ((c) aWN().mD(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nZ(boolean z) {
        if (aWN() != null && (aWN().mD(28) instanceof c) && ((c) aWN().mD(28)).getInputView() != null && ((c) aWN().mD(28)).getInputView().getText() != null) {
            EditText inputView = ((c) aWN().mD(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder a = this.hSs.a(inputView.getText());
            if (a != null) {
                this.hSs.uO(true);
                inputView.setText(a);
                if (z && this.hSs.deQ() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.hSs.deQ());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.hSs.uN(this.hSs.deQ() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mp(String str) {
        if (this.duK != null && !StringUtils.isNull(str)) {
            this.duK.showToast(str);
        }
    }

    public void a(InterfaceC0691a interfaceC0691a) {
        this.lth = interfaceC0691a;
    }

    public void deq() {
        an anVar = new an("c13026");
        anVar.cI("tid", this.mThreadId);
        anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.cI("fid", this.mForumId);
        TiebaStatic.log(anVar);
    }
}
