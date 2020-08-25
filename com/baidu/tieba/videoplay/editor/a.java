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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes18.dex */
public class a extends e {
    private final NewWriteModel.d eMD;
    private NewWriteModel eMp;
    private TbPageContext<?> efn;
    private com.baidu.tieba.write.c iTY;
    public VideoItemData mEZ;
    private InterfaceC0823a mFS;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC0823a {
        void wQ(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.eMD = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.eMp != null) {
                    if (a.this.brv() != null) {
                        a.this.brv().hide();
                    }
                    if (a.this.mFS != null) {
                        a.this.mFS.wQ(false);
                    }
                    WriteData cKZ = writeData == null ? a.this.eMp.cKZ() : writeData;
                    if (z) {
                        a.this.iTY.Sw(null);
                        a.this.iTY.bf(null);
                        a.this.iTY.wX(false);
                        a.this.dEO();
                        a.this.resetData();
                        if (cKZ != null) {
                            String string = a.this.bmF().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cKZ.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.bmF().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cKZ != null && agVar != null && !TextUtils.isEmpty(agVar.bmY())) {
                        cKZ.setVcodeMD5(agVar.getVcode_md5());
                        cKZ.setVcodeUrl(agVar.getVcode_pic_url());
                        cKZ.setVcodeExtra(agVar.bmZ());
                        if (com.baidu.tbadk.t.a.CO(agVar.bmY())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.efn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cKZ, false, agVar.bmY())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.efn.getPageActivity(), cKZ, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.efn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cKZ, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Sm(postWriteCallBackData.getErrorString());
                        a.this.iTY.bf(postWriteCallBackData.getSensitiveWords());
                        a.this.iTY.Sw(postWriteCallBackData.getErrorString());
                        if (!y.isEmpty(a.this.iTY.dFu())) {
                            a.this.pQ(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.HX(postWriteCallBackData.getErrorCode()))) {
                        a.this.aq(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Sm(postWriteCallBackData.getErrorString());
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
                if (a.this.iTY != null) {
                    if (!a.this.iTY.dFx()) {
                        a.this.pQ(false);
                    }
                    a.this.iTY.wY(false);
                }
            }
        };
        editorTools.jh(true);
        this.iTY = new com.baidu.tieba.write.c();
        this.iTY.Js(R.color.cp_cont_h_alpha85);
        this.iTY.Jr(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.efn = tbPageContext;
    }

    public TbPageContext<?> bmF() {
        return this.efn;
    }

    public void BZ(String str) {
        this.mPostContent = str;
    }

    public void az(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (brv() != null && (brv().qe(28) instanceof c) && ((c) brv().qe(28)).getInputView() != null) {
            EditText inputView = ((c) brv().qe(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.mEZ = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(int i, String str) {
        if (AntiHelper.bz(i, str)) {
            AntiHelper.a(this.efn.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            Cd(str);
        } else {
            Sm(str);
        }
    }

    private void Cd(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bmF().getPageActivity());
        aVar.zz(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bmF()).bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEO() {
        if (brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            brv().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            brv().hide();
        }
        if (this.mFS != null) {
            this.mFS.wQ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.eMp != null) {
            this.eMp.d((WriteData) null);
            this.eMp.wg(false);
        }
    }

    public void onDestroy() {
        if (this.eMp != null) {
            this.eMp.cancelLoadData();
        }
    }

    public void bsu() {
        if (this.eMp == null) {
            this.eMp = new NewWriteModel(this.efn);
            this.eMp.b(this.eMD);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.mEZ != null && this.mEZ.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.mEZ.baijiahaoData);
        }
        this.eMp.d(writeData);
        this.eMp.dxS();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.eMD.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.eMp.cKZ(), null);
                    return;
                } else if (i2 == -1) {
                    dEO();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cqc() {
        if (brv() != null && (brv().qe(28) instanceof c) && ((c) brv().qe(28)).getInputView() != null && ((c) brv().qe(28)).getInputView().getText() != null) {
            ((c) brv().qe(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pQ(boolean z) {
        if (brv() != null && (brv().qe(28) instanceof c) && ((c) brv().qe(28)).getInputView() != null && ((c) brv().qe(28)).getInputView().getText() != null) {
            EditText inputView = ((c) brv().qe(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder c = this.iTY.c(inputView.getText());
            if (c != null) {
                this.iTY.wY(true);
                inputView.setText(c);
                if (z && this.iTY.dFv() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.iTY.dFv());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.iTY.wX(this.iTY.dFv() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sm(String str) {
        if (this.efn != null && !StringUtils.isNull(str)) {
            this.efn.showToast(str);
        }
    }

    public void a(InterfaceC0823a interfaceC0823a) {
        this.mFS = interfaceC0823a;
    }

    public void dEP() {
        aq aqVar = new aq("c13026");
        aqVar.dD("tid", this.mThreadId);
        aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
        aqVar.dD("fid", this.mForumId);
        TiebaStatic.log(aqVar);
    }
}
