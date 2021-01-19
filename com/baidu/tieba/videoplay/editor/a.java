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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.g;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes7.dex */
public class a extends e {
    private TbPageContext<?> eSJ;
    private final NewWriteModel.d fBH;
    private NewWriteModel fBs;
    private com.baidu.tieba.write.c khc;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;
    private InterfaceC0891a nLX;
    public VideoItemData nLf;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0891a {
        void yQ(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.fBH = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2;
                if (a.this.fBs != null) {
                    if (a.this.bAP() != null) {
                        a.this.bAP().hide();
                    }
                    if (a.this.nLX != null) {
                        a.this.nLX.yQ(false);
                    }
                    WriteData cYx = writeData == null ? a.this.fBs.cYx() : writeData;
                    if (z) {
                        a.this.khc.TX(null);
                        a.this.khc.bh(null);
                        a.this.khc.yX(false);
                        a.this.dTt();
                        a.this.resetData();
                        if (cYx != null) {
                            String string = a.this.bvT().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                String preMsg = postWriteCallBackData.getPreMsg();
                                str = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                                str2 = preMsg;
                            } else {
                                str = null;
                                str2 = null;
                            }
                            if (cYx.getType() != 7) {
                                g.i(a.this.bvT().getPageActivity(), string, str2, str);
                            }
                        }
                    } else if (cYx != null && ahVar != null && !TextUtils.isEmpty(ahVar.bwm())) {
                        cYx.setVcodeMD5(ahVar.getVcode_md5());
                        cYx.setVcodeUrl(ahVar.getVcode_pic_url());
                        cYx.setVcodeExtra(ahVar.bwn());
                        if (com.baidu.tbadk.t.a.DE(ahVar.bwm())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.eSJ.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cYx, false, ahVar.bwm())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.eSJ.getPageActivity(), cYx, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.eSJ.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cYx, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.TN(postWriteCallBackData.getErrorString());
                        a.this.khc.bh(postWriteCallBackData.getSensitiveWords());
                        a.this.khc.TX(postWriteCallBackData.getErrorString());
                        if (!x.isEmpty(a.this.khc.dTZ())) {
                            a.this.sf(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Jt(postWriteCallBackData.getErrorCode()))) {
                        a.this.aJ(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.TN(postWriteCallBackData.getErrorString());
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
                if (a.this.khc != null) {
                    if (!a.this.khc.dUc()) {
                        a.this.sf(false);
                    }
                    a.this.khc.yY(false);
                }
            }
        };
        editorTools.kK(true);
        this.khc = new com.baidu.tieba.write.c();
        this.khc.KI(R.color.cp_cont_h_alpha85);
        this.khc.KH(R.color.CAM_X0101);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eSJ = tbPageContext;
    }

    public TbPageContext<?> bvT() {
        return this.eSJ;
    }

    public void CH(String str) {
        this.mPostContent = str;
    }

    public void aO(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (bAP() != null && (bAP().qP(28) instanceof c) && ((c) bAP().qP(28)).getInputView() != null) {
            EditText inputView = ((c) bAP().qP(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.nLf = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(int i, String str) {
        if (AntiHelper.bQ(i, str)) {
            AntiHelper.a(this.eSJ.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            CL(str);
        } else {
            TN(str);
        }
    }

    private void CL(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bvT().getPageActivity());
        aVar.Ad(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bvT()).bqe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTt() {
        if (bAP() != null) {
            bAP().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            bAP().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            bAP().hide();
        }
        if (this.nLX != null) {
            this.nLX.yQ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.fBs != null) {
            this.fBs.f((WriteData) null);
            this.fBs.yl(false);
        }
    }

    public void onDestroy() {
        if (this.fBs != null) {
            this.fBs.cancelLoadData();
        }
    }

    public void bBU() {
        if (this.fBs == null) {
            this.fBs = new NewWriteModel(this.eSJ);
            this.fBs.b(this.fBH);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.nLf != null && this.nLf.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.nLf.baijiahaoData);
        }
        this.fBs.f(writeData);
        this.fBs.dMK();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.fBH.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.fBs.cYx(), null);
                    return;
                } else if (i2 == -1) {
                    dTt();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cFB() {
        if (bAP() != null && (bAP().qP(28) instanceof c) && ((c) bAP().qP(28)).getInputView() != null && ((c) bAP().qP(28)).getInputView().getText() != null) {
            ((c) bAP().qP(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sf(boolean z) {
        if (bAP() != null && (bAP().qP(28) instanceof c) && ((c) bAP().qP(28)).getInputView() != null && ((c) bAP().qP(28)).getInputView().getText() != null) {
            EditText inputView = ((c) bAP().qP(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder d = this.khc.d(inputView.getText());
            if (d != null) {
                this.khc.yY(true);
                inputView.setText(d);
                if (z && this.khc.dUa() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.khc.dUa());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.khc.yX(this.khc.dUa() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TN(String str) {
        if (this.eSJ != null && !StringUtils.isNull(str)) {
            this.eSJ.showToast(str);
        }
    }

    public void a(InterfaceC0891a interfaceC0891a) {
        this.nLX = interfaceC0891a;
    }

    public void dTu() {
        aq aqVar = new aq("c13026");
        aqVar.dW("tid", this.mThreadId);
        aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
        aqVar.dW("fid", this.mForumId);
        TiebaStatic.log(aqVar);
    }
}
