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
    private TbPageContext<?> etO;
    private final NewWriteModel.d fbF;
    private NewWriteModel fbr;
    private com.baidu.tieba.write.c jrJ;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;
    public VideoItemData neJ;
    private InterfaceC0838a nfB;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC0838a {
        void xI(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.fbF = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.fbr != null) {
                    if (a.this.bvf() != null) {
                        a.this.bvf().hide();
                    }
                    if (a.this.nfB != null) {
                        a.this.nfB.xI(false);
                    }
                    WriteData cSo = writeData == null ? a.this.fbr.cSo() : writeData;
                    if (z) {
                        a.this.jrJ.TK(null);
                        a.this.jrJ.bh(null);
                        a.this.jrJ.xP(false);
                        a.this.dMD();
                        a.this.resetData();
                        if (cSo != null) {
                            String string = a.this.bqj().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cSo.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.bqj().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cSo != null && ahVar != null && !TextUtils.isEmpty(ahVar.bqC())) {
                        cSo.setVcodeMD5(ahVar.getVcode_md5());
                        cSo.setVcodeUrl(ahVar.getVcode_pic_url());
                        cSo.setVcodeExtra(ahVar.bqD());
                        if (com.baidu.tbadk.t.a.DX(ahVar.bqC())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.etO.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cSo, false, ahVar.bqC())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.etO.getPageActivity(), cSo, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.etO.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cSo, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.TA(postWriteCallBackData.getErrorString());
                        a.this.jrJ.bh(postWriteCallBackData.getSensitiveWords());
                        a.this.jrJ.TK(postWriteCallBackData.getErrorString());
                        if (!y.isEmpty(a.this.jrJ.dNj())) {
                            a.this.qG(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Jg(postWriteCallBackData.getErrorCode()))) {
                        a.this.aC(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.TA(postWriteCallBackData.getErrorString());
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
                if (a.this.jrJ != null) {
                    if (!a.this.jrJ.dNm()) {
                        a.this.qG(false);
                    }
                    a.this.jrJ.xQ(false);
                }
            }
        };
        editorTools.jF(true);
        this.jrJ = new com.baidu.tieba.write.c();
        this.jrJ.KC(R.color.cp_cont_h_alpha85);
        this.jrJ.KB(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.etO = tbPageContext;
    }

    public TbPageContext<?> bqj() {
        return this.etO;
    }

    public void Di(String str) {
        this.mPostContent = str;
    }

    public void aB(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (bvf() != null && (bvf().qP(28) instanceof c) && ((c) bvf().qP(28)).getInputView() != null) {
            EditText inputView = ((c) bvf().qP(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.neJ = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, String str) {
        if (AntiHelper.bM(i, str)) {
            AntiHelper.a(this.etO.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            Dm(str);
        } else {
            TA(str);
        }
    }

    private void Dm(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bqj().getPageActivity());
        aVar.AH(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bqj()).bkJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMD() {
        if (bvf() != null) {
            bvf().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            bvf().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            bvf().hide();
        }
        if (this.nfB != null) {
            this.nfB.xI(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.fbr != null) {
            this.fbr.e((WriteData) null);
            this.fbr.wY(false);
        }
    }

    public void onDestroy() {
        if (this.fbr != null) {
            this.fbr.cancelLoadData();
        }
    }

    public void bwj() {
        if (this.fbr == null) {
            this.fbr = new NewWriteModel(this.etO);
            this.fbr.b(this.fbF);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.neJ != null && this.neJ.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.neJ.baijiahaoData);
        }
        this.fbr.e(writeData);
        this.fbr.dFC();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.fbF.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.fbr.cSo(), null);
                    return;
                } else if (i2 == -1) {
                    dMD();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cwN() {
        if (bvf() != null && (bvf().qP(28) instanceof c) && ((c) bvf().qP(28)).getInputView() != null && ((c) bvf().qP(28)).getInputView().getText() != null) {
            ((c) bvf().qP(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qG(boolean z) {
        if (bvf() != null && (bvf().qP(28) instanceof c) && ((c) bvf().qP(28)).getInputView() != null && ((c) bvf().qP(28)).getInputView().getText() != null) {
            EditText inputView = ((c) bvf().qP(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder c = this.jrJ.c(inputView.getText());
            if (c != null) {
                this.jrJ.xQ(true);
                inputView.setText(c);
                if (z && this.jrJ.dNk() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.jrJ.dNk());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.jrJ.xP(this.jrJ.dNk() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TA(String str) {
        if (this.etO != null && !StringUtils.isNull(str)) {
            this.etO.showToast(str);
        }
    }

    public void a(InterfaceC0838a interfaceC0838a) {
        this.nfB = interfaceC0838a;
    }

    public void dME() {
        aq aqVar = new aq("c13026");
        aqVar.dK("tid", this.mThreadId);
        aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
        aqVar.dK("fid", this.mForumId);
        TiebaStatic.log(aqVar);
    }
}
