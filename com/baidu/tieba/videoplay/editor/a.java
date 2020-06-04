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
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes11.dex */
public class a extends d {
    private TbPageContext<?> dIF;
    private NewWriteModel emH;
    private final NewWriteModel.d emV;
    private com.baidu.tieba.write.c ihP;
    private InterfaceC0745a lMT;
    public VideoItemData lMa;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0745a {
        void vf(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.emV = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.emH != null) {
                    if (a.this.bcX() != null) {
                        a.this.bcX().hide();
                    }
                    if (a.this.lMT != null) {
                        a.this.lMT.vf(false);
                    }
                    WriteData daf = writeData == null ? a.this.emH.daf() : writeData;
                    if (z) {
                        a.this.ihP.Og(null);
                        a.this.ihP.aX(null);
                        a.this.ihP.vm(false);
                        a.this.dlT();
                        a.this.resetData();
                        if (daf != null) {
                            String string = a.this.aXX().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (daf.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.f(a.this.aXX().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (daf != null && abVar != null && !TextUtils.isEmpty(abVar.aYm())) {
                        daf.setVcodeMD5(abVar.getVcode_md5());
                        daf.setVcodeUrl(abVar.getVcode_pic_url());
                        daf.setVcodeExtra(abVar.aYn());
                        if (com.baidu.tbadk.s.a.yX(abVar.aYm())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.dIF.getPageActivity(), RequestResponseCode.REQUEST_VCODE, daf, false, abVar.aYm())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.dIF.getPageActivity(), daf, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.dIF.getPageActivity(), RequestResponseCode.REQUEST_VCODE, daf, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Od(postWriteCallBackData.getErrorString());
                        a.this.ihP.aX(postWriteCallBackData.getSensitiveWords());
                        a.this.ihP.Og(postWriteCallBackData.getErrorString());
                        if (!v.isEmpty(a.this.ihP.dmv())) {
                            a.this.ov(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Ec(postWriteCallBackData.getErrorCode()))) {
                        a.this.ap(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Od(postWriteCallBackData.getErrorString());
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
                if (a.this.ihP != null) {
                    if (!a.this.ihP.dmy()) {
                        a.this.ov(false);
                    }
                    a.this.ihP.vn(false);
                }
            }
        };
        editorTools.hW(true);
        this.ihP = new com.baidu.tieba.write.c();
        this.ihP.Fw(R.color.cp_cont_h_alpha85);
        this.ihP.Fv(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.dIF = tbPageContext;
    }

    public TbPageContext<?> aXX() {
        return this.dIF;
    }

    public void yk(String str) {
        this.mPostContent = str;
    }

    public void az(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (bcX() != null && (bcX().nh(28) instanceof c) && ((c) bcX().nh(28)).getInputView() != null) {
            EditText inputView = ((c) bcX().nh(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.lMa = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(int i, String str) {
        if (AntiHelper.bv(i, str)) {
            AntiHelper.a(this.dIF.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            yo(str);
        } else {
            Od(str);
        }
    }

    private void yo(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aXX().getPageActivity());
        aVar.vO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aXX()).aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlT() {
        if (bcX() != null) {
            bcX().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            bcX().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            bcX().hide();
        }
        if (this.lMT != null) {
            this.lMT.vf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.emH != null) {
            this.emH.d((WriteData) null);
            this.emH.uy(false);
        }
    }

    public void onDestroy() {
        if (this.emH != null) {
            this.emH.cancelLoadData();
        }
    }

    public void bdS() {
        if (this.emH == null) {
            this.emH = new NewWriteModel(this.dIF);
            this.emH.b(this.emV);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.lMa != null && this.lMa.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.lMa.baijiahaoData);
        }
        this.emH.d(writeData);
        this.emH.dfc();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.emV.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.emH.daf(), null);
                    return;
                } else if (i2 == -1) {
                    dlT();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void dlU() {
        if (bcX() != null && (bcX().nh(28) instanceof c) && ((c) bcX().nh(28)).getInputView() != null && ((c) bcX().nh(28)).getInputView().getText() != null) {
            ((c) bcX().nh(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ov(boolean z) {
        if (bcX() != null && (bcX().nh(28) instanceof c) && ((c) bcX().nh(28)).getInputView() != null && ((c) bcX().nh(28)).getInputView().getText() != null) {
            EditText inputView = ((c) bcX().nh(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder a = this.ihP.a(inputView.getText());
            if (a != null) {
                this.ihP.vn(true);
                inputView.setText(a);
                if (z && this.ihP.dmw() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.ihP.dmw());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.ihP.vm(this.ihP.dmw() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Od(String str) {
        if (this.dIF != null && !StringUtils.isNull(str)) {
            this.dIF.showToast(str);
        }
    }

    public void a(InterfaceC0745a interfaceC0745a) {
        this.lMT = interfaceC0745a;
    }

    public void dlV() {
        an anVar = new an("c13026");
        anVar.dh("tid", this.mThreadId);
        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
        anVar.dh("fid", this.mForumId);
        TiebaStatic.log(anVar);
    }
}
