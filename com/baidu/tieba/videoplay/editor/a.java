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
import com.baidu.tieba.tbadkCore.writeModel.g;
import com.baidu.tieba.video.VideoItemData;
/* loaded from: classes7.dex */
public class a extends e {
    private TbPageContext<?> eWx;
    private NewWriteModel fFg;
    private final NewWriteModel.d fFv;
    private com.baidu.tieba.write.c krA;
    private String mForumId;
    private String mForumName;
    private String mPostContent;
    private TextWatcher mTextWatcher;
    private String mThreadId;
    public VideoItemData nXt;
    private InterfaceC0902a nYs;

    /* renamed from: com.baidu.tieba.videoplay.editor.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0902a {
        void zk(boolean z);
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.mThreadId = null;
        this.fFv = new NewWriteModel.d() { // from class: com.baidu.tieba.videoplay.editor.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                String str;
                String str2;
                if (a.this.fFg != null) {
                    if (a.this.bBk() != null) {
                        a.this.bBk().hide();
                    }
                    if (a.this.nYs != null) {
                        a.this.nYs.zk(false);
                    }
                    WriteData daL = writeData == null ? a.this.fFg.daL() : writeData;
                    if (z) {
                        a.this.krA.Vo(null);
                        a.this.krA.bg(null);
                        a.this.krA.zs(false);
                        a.this.dVV();
                        a.this.resetData();
                        if (daL != null) {
                            String string = a.this.bwp().getResources().getString(R.string.replay_success);
                            if (postWriteCallBackData != null) {
                                String preMsg = postWriteCallBackData.getPreMsg();
                                str = postWriteCallBackData.getColorMsg();
                                string = postWriteCallBackData.getErrorString();
                                str2 = preMsg;
                            } else {
                                str = null;
                                str2 = null;
                            }
                            if (daL.getType() != 7) {
                                g.j(a.this.bwp().getPageActivity(), string, str2, str);
                            }
                        }
                    } else if (daL != null && ahVar != null && !TextUtils.isEmpty(ahVar.bwH())) {
                        daL.setVcodeMD5(ahVar.getVcode_md5());
                        daL.setVcodeUrl(ahVar.getVcode_pic_url());
                        daL.setVcodeExtra(ahVar.bwI());
                        if (com.baidu.tbadk.t.a.Ef(ahVar.bwH())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.eWx.getPageActivity(), RequestResponseCode.REQUEST_VCODE, daL, false, ahVar.bwH())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.eWx.getPageActivity(), daL, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.eWx.getPageActivity(), RequestResponseCode.REQUEST_VCODE, daL, postWriteCallBackData.getAccessState())));
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 220015) {
                        a.this.Vd(postWriteCallBackData.getErrorString());
                        a.this.krA.bg(postWriteCallBackData.getSensitiveWords());
                        a.this.krA.Vo(postWriteCallBackData.getErrorString());
                        if (!y.isEmpty(a.this.krA.dWD())) {
                            a.this.ss(true);
                        }
                    } else if (postWriteCallBackData != null && (postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278 || postWriteCallBackData.getErrorCode() == 340016 || postWriteCallBackData.getErrorCode() == 1990032 || AntiHelper.JS(postWriteCallBackData.getErrorCode()))) {
                        a.this.aN(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString());
                    } else if (postWriteCallBackData != null) {
                        a.this.Vd(postWriteCallBackData.getErrorString());
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
                if (a.this.krA != null) {
                    if (!a.this.krA.dWG()) {
                        a.this.ss(false);
                    }
                    a.this.krA.zt(false);
                }
            }
        };
        editorTools.kN(true);
        this.krA = new com.baidu.tieba.write.c();
        this.krA.Li(R.color.cp_cont_h_alpha85);
        this.krA.Lh(R.color.CAM_X0101);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eWx = tbPageContext;
    }

    public TbPageContext<?> bwp() {
        return this.eWx;
    }

    public void Dd(String str) {
        this.mPostContent = str;
    }

    public void aQ(String str, String str2, String str3) {
        this.mThreadId = str;
        this.mForumId = str2;
        this.mForumName = str3;
        if (bBk() != null && (bBk().qV(28) instanceof c) && ((c) bBk().qV(28)).getInputView() != null) {
            EditText inputView = ((c) bBk().qV(28)).getInputView();
            inputView.removeTextChangedListener(this.mTextWatcher);
            inputView.addTextChangedListener(this.mTextWatcher);
        }
    }

    public void c(VideoItemData videoItemData) {
        this.nXt = videoItemData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(int i, String str) {
        if (AntiHelper.bX(i, str)) {
            AntiHelper.a(this.eWx.getPageActivity(), str, i, (AntiHelper.a) null);
        } else if (i == 230277 || i == 230278) {
            Dh(str);
        } else {
            Vd(str);
        }
    }

    private void Dh(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bwp().getPageActivity());
        aVar.AB(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.videoplay.editor.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bwp()).bqz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVV() {
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(9, -1, true));
            bBk().b(new com.baidu.tbadk.editortools.a(4, -1, ""));
            bBk().hide();
        }
        if (this.nYs != null) {
            this.nYs.zk(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        if (this.fFg != null) {
            this.fFg.f((WriteData) null);
            this.fFg.yD(false);
        }
    }

    public void onDestroy() {
        if (this.fFg != null) {
            this.fFg.cancelLoadData();
        }
    }

    public void bCp() {
        if (this.fFg == null) {
            this.fFg = new NewWriteModel(this.eWx);
            this.fFg.b(this.fFv);
        }
        WriteData writeData = new WriteData();
        writeData.setType(1);
        writeData.setThreadId(this.mThreadId);
        writeData.setForumId(this.mForumId);
        writeData.setForumName(this.mForumName);
        writeData.setContent(this.mPostContent);
        if (this.nXt != null && this.nXt.baijiahaoData != null) {
            writeData.setIsBJHPost(true);
            writeData.setBaijiahaoData(this.nXt.baijiahaoData);
        }
        this.fFg.f(writeData);
        this.fFg.dPm();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                if (i2 == 0) {
                    this.fFv.callback(false, (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data"), null, this.fFg.daL(), null);
                    return;
                } else if (i2 == -1) {
                    dVV();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void cHb() {
        if (bBk() != null && (bBk().qV(28) instanceof c) && ((c) bBk().qV(28)).getInputView() != null && ((c) bBk().qV(28)).getInputView().getText() != null) {
            ((c) bBk().qV(28)).getInputView().setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ss(boolean z) {
        if (bBk() != null && (bBk().qV(28) instanceof c) && ((c) bBk().qV(28)).getInputView() != null && ((c) bBk().qV(28)).getInputView().getText() != null) {
            EditText inputView = ((c) bBk().qV(28)).getInputView();
            int selectionEnd = inputView.getSelectionEnd();
            SpannableStringBuilder d = this.krA.d(inputView.getText());
            if (d != null) {
                this.krA.zt(true);
                inputView.setText(d);
                if (z && this.krA.dWE() >= 0) {
                    inputView.requestFocus();
                    inputView.setSelection(this.krA.dWE());
                } else {
                    inputView.setSelection(selectionEnd);
                }
                this.krA.zs(this.krA.dWE() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vd(String str) {
        if (this.eWx != null && !StringUtils.isNull(str)) {
            this.eWx.showToast(str);
        }
    }

    public void a(InterfaceC0902a interfaceC0902a) {
        this.nYs = interfaceC0902a;
    }

    public void dVW() {
        ar arVar = new ar("c13026");
        arVar.dR("tid", this.mThreadId);
        arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
        arVar.dR("fid", this.mForumId);
        TiebaStatic.log(arVar);
    }
}
