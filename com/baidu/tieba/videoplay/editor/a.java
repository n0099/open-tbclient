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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes24.dex */
public class a extends e {
    private TbPageContext<?> eNx;
    private final NewWriteModel.d fwI;
    private NewWriteModel fwu;
    private com.baidu.tieba.write.c jYv;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;
    public VideoItemData nMn;
    private InterfaceC0887a nNf;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC0887a {
        void yU(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.fwu != null) {
                    if (a.this.bCn() != null) {
                        a.this.bCn().hide();
                    }
                    if (a.this.nNf != null) {
                        a.this.nNf.yU(false);
                    }
                    WriteData dcD = writeData == null ? a.this.fwu.dcD() : writeData;
                    if (z) {
                        a.this.jYv.VA(null);
                        a.this.jYv.bn(null);
                        a.this.jYv.zb(false);
                        a.this.dXG();
                        a.this.resetData();
                        if (dcD != null) {
                            String string = a.this.bxs().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (dcD.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.h(a.this.bxs().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (dcD != null && ahVar != null && !TextUtils.isEmpty(ahVar.bxL())) {
                        dcD.setVcodeMD5(ahVar.getVcode_md5());
                        dcD.setVcodeUrl(ahVar.getVcode_pic_url());
                        dcD.setVcodeExtra(ahVar.bxM());
                        if (com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.eNx.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dcD, false, ahVar.bxL())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.eNx.getPageActivity(), dcD, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.eNx.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dcD, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Vq(postWriteCallBackData.getErrorString());
                        a.this.jYv.bn(postWriteCallBackData.getSensitiveWords());
                        a.this.jYv.VA(postWriteCallBackData.getErrorString());
                        if (!y.isEmpty(a.this.jYv.dYm())) {
                            a.this.rM(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Le(postWriteCallBackData.getErrorCode()))) {
                        a.this.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Vq(postWriteCallBackData.getErrorString());
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
                if (a.this.jYv != null) {
                    if (!a.this.jYv.dYp()) {
                        a.this.rM(false);
                    }
                    a.this.jYv.zc(false);
                }
            }
        };
        editorTools.ks(true);
        this.jYv = new com.baidu.tieba.write.c();
        this.jYv.MC(R.color.cp_cont_h_alpha85);
        this.jYv.MB(R.color.CAM_X0101);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eNx = tbPageContext;
    }

    public TbPageContext<?> bxs() {
        return this.eNx;
    }

    public void DW(String str) {
        this.mPostContent = str;
    }

    public void aM(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (bCn() != null && (bCn().sj(28) instanceof c) && ((c) bCn().sj(28)).getInputView() != null) {
            EditText inputView = ((c) bCn().sj(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.nMn = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(int i, String str) {
        if (AntiHelper.bP(i, str)) {
            AntiHelper.a(this.eNx.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            Ea(str);
        } else {
            Vq(str);
        }
    }

    private void Ea(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bxs().getPageActivity());
        aVar.Bq(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bxs()).brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXG() {
        if (bCn() != null) {
            bCn().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            bCn().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            bCn().hide();
        }
        if (this.nNf != null) {
            this.nNf.yU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.fwu != null) {
            this.fwu.e((WriteData) null);
            this.fwu.yk(false);
        }
    }

    public void onDestroy() {
        if (this.fwu != null) {
            this.fwu.cancelLoadData();
        }
    }

    public void bDr() {
        if (this.fwu == null) {
            this.fwu = new NewWriteModel(this.eNx);
            this.fwu.b(this.fwI);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.nMn != null && this.nMn.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.nMn.baijiahaoData);
        }
        this.fwu.e(writeData);
        this.fwu.dQD();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.fwI.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.fwu.dcD(), null);
                    return;
                } else if (i2 == -1) {
                    dXG();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cGs() {
        if (bCn() != null && (bCn().sj(28) instanceof c) && ((c) bCn().sj(28)).getInputView() != null && ((c) bCn().sj(28)).getInputView().getText() != null) {
            ((c) bCn().sj(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rM(boolean z) {
        if (bCn() != null && (bCn().sj(28) instanceof c) && ((c) bCn().sj(28)).getInputView() != null && ((c) bCn().sj(28)).getInputView().getText() != null) {
            EditText inputView = ((c) bCn().sj(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder c = this.jYv.c(inputView.getText());
            if (c != null) {
                this.jYv.zc(true);
                inputView.setText(c);
                if (z && this.jYv.dYn() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.jYv.dYn());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.jYv.zb(this.jYv.dYn() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq(String str) {
        if (this.eNx != null && !StringUtils.isNull(str)) {
            this.eNx.showToast(str);
        }
    }

    public void a(InterfaceC0887a interfaceC0887a) {
        this.nNf = interfaceC0887a;
    }

    public void dXH() {
        ar arVar = new ar("c13026");
        arVar.dY("tid", this.mThreadId);
        arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
        arVar.dY("fid", this.mForumId);
        TiebaStatic.log(arVar);
    }
}
