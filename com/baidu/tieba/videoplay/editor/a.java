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
    private TbPageContext<?> eCn;
    private NewWriteModel fjQ;
    private final NewWriteModel.d fke;
    private com.baidu.tieba.write.c jEj;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;
    public VideoItemData nrk;
    private InterfaceC0853a nsc;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC0853a {
        void xZ(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.fke = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2 = null;
                if (a.this.fjQ != null) {
                    if (a.this.bwY() != null) {
                        a.this.bwY().hide();
                    }
                    if (a.this.nsc != null) {
                        a.this.nsc.xZ(false);
                    }
                    WriteData cVv = writeData == null ? a.this.fjQ.cVv() : writeData;
                    if (z) {
                        a.this.jEj.Uj(null);
                        a.this.jEj.bk(null);
                        a.this.jEj.yg(false);
                        a.this.dPL();
                        a.this.resetData();
                        if (cVv != null) {
                            String string = a.this.bsc().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                str = postWriteCallBackData.getPreMsg();
                                str2 = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                            } else {
                                str = null;
                            }
                            if (cVv.getType() != 7) {
                                com.baidu.tieba.tbadkCore.writeModel.c.g(a.this.bsc().getPageActivity(), string, str, str2);
                            }
                        }
                    } else if (cVv != null && ahVar != null && !TextUtils.isEmpty(ahVar.bsv())) {
                        cVv.setVcodeMD5(ahVar.getVcode_md5());
                        cVv.setVcodeUrl(ahVar.getVcode_pic_url());
                        cVv.setVcodeExtra(ahVar.bsw());
                        if (com.baidu.tbadk.t.a.Eq(ahVar.bsv())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.eCn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cVv, false, ahVar.bsv())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.eCn.getPageActivity(), cVv, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.eCn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cVv, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.TZ(postWriteCallBackData.getErrorString());
                        a.this.jEj.bk(postWriteCallBackData.getSensitiveWords());
                        a.this.jEj.Uj(postWriteCallBackData.getErrorString());
                        if (!y.isEmpty(a.this.jEj.dQr())) {
                            a.this.qY(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.Jy(postWriteCallBackData.getErrorCode()))) {
                        a.this.aE(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.TZ(postWriteCallBackData.getErrorString());
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
                if (a.this.jEj != null) {
                    if (!a.this.jEj.dQu()) {
                        a.this.qY(false);
                    }
                    a.this.jEj.yh(false);
                }
            }
        };
        editorTools.jS(true);
        this.jEj = new com.baidu.tieba.write.c();
        this.jEj.KU(R.color.cp_cont_h_alpha85);
        this.jEj.KT(R.color.cp_cont_a);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eCn = tbPageContext;
    }

    public TbPageContext<?> bsc() {
        return this.eCn;
    }

    public void DB(String str) {
        this.mPostContent = str;
    }

    public void aI(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (bwY() != null && (bwY().ra(28) instanceof c) && ((c) bwY().ra(28)).getInputView() != null) {
            EditText inputView = ((c) bwY().ra(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.nrk = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(int i, String str) {
        if (AntiHelper.bN(i, str)) {
            AntiHelper.a(this.eCn.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            DF(str);
        } else {
            TZ(str);
        }
    }

    private void DF(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bsc().getPageActivity());
        aVar.Ba(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bsc()).bmC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPL() {
        if (bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            bwY().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            bwY().hide();
        }
        if (this.nsc != null) {
            this.nsc.xZ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.fjQ != null) {
            this.fjQ.e((WriteData) null);
            this.fjQ.xp(false);
        }
    }

    public void onDestroy() {
        if (this.fjQ != null) {
            this.fjQ.cancelLoadData();
        }
    }

    public void byc() {
        if (this.fjQ == null) {
            this.fjQ = new NewWriteModel(this.eCn);
            this.fjQ.b(this.fke);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.nrk != null && this.nrk.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.nrk.baijiahaoData);
        }
        this.fjQ.e(writeData);
        this.fjQ.dIK();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.fke.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.fjQ.cVv(), null);
                    return;
                } else if (i2 == -1) {
                    dPL();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void czU() {
        if (bwY() != null && (bwY().ra(28) instanceof c) && ((c) bwY().ra(28)).getInputView() != null && ((c) bwY().ra(28)).getInputView().getText() != null) {
            ((c) bwY().ra(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qY(boolean z) {
        if (bwY() != null && (bwY().ra(28) instanceof c) && ((c) bwY().ra(28)).getInputView() != null && ((c) bwY().ra(28)).getInputView().getText() != null) {
            EditText inputView = ((c) bwY().ra(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder c = this.jEj.c(inputView.getText());
            if (c != null) {
                this.jEj.yh(true);
                inputView.setText(c);
                if (z && this.jEj.dQs() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.jEj.dQs());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.jEj.yg(this.jEj.dQs() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TZ(String str) {
        if (this.eCn != null && !StringUtils.isNull(str)) {
            this.eCn.showToast(str);
        }
    }

    public void a(InterfaceC0853a interfaceC0853a) {
        this.nsc = interfaceC0853a;
    }

    public void dPM() {
        aq aqVar = new aq("c13026");
        aqVar.dR("tid", this.mThreadId);
        aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
        aqVar.dR("fid", this.mForumId);
        TiebaStatic.log(aqVar);
    }
}
