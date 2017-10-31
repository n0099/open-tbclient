package com.baidu.tieba.write.write;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import tbclient.SimpleForum;
/* loaded from: classes2.dex */
public class e {
    private static final Pattern gXS = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext abI;
    public com.baidu.tieba.write.b eZq;
    private com.baidu.tbadk.core.view.a gOR;
    private WriteUrlModel gXN;
    private f gXT;
    private com.baidu.tieba.write.model.a gXU;
    private com.baidu.tieba.write.transmit.model.a gXV;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    e.this.bFi();
                    TiebaStatic.log(new ak("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    e.this.bFh();
                }
            }
        }
    };
    private View.OnClickListener gXW = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new ak("c12163"));
                String bFu = e.this.gXT.bFu();
                if (e.gXS.matcher(bFu).matches()) {
                    e.this.bFh();
                    e.this.gXU.tQ(bFu);
                    e.this.gXT.a(null, true);
                    return;
                }
                TiebaStatic.log(new ak("c12164"));
                e.this.gXT.bFv();
            }
        }
    };
    private TextWatcher gXX = new TextWatcher() { // from class: com.baidu.tieba.write.write.e.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            e.this.gXT.bFn();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (e.this.eZq != null) {
                if (!e.this.eZq.bCg()) {
                    e.this.nr(false);
                }
                e.this.eZq.nj(false);
            }
        }
    };
    private DialogInterface.OnCancelListener gOY = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.e.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (e.this.gXV != null) {
                e.this.gXV.akK();
            }
        }
    };
    private a.InterfaceC0140a gOX = new a.InterfaceC0140a() { // from class: com.baidu.tieba.write.write.e.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0140a
        public void bCc() {
            e.this.dO(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0140a
        public void B(List<SimpleForum> list) {
            e.this.dO(list);
        }
    };
    private final NewWriteModel.d aDo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.e.6
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            e.this.gXT.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                e.this.eZq.aB(null);
                e.this.eZq.ni(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (e.this.c(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.d(e.this.abI.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    e.this.abI.getPageActivity().setResult(-1, intent);
                    e.this.abI.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    e.this.abI.showToast(postWriteCallBackData.getErrorString());
                    e.this.eZq.aB(postWriteCallBackData.getSensitiveWords());
                    e.this.eZq.tI(postWriteCallBackData.getErrorString());
                    if (!v.v(e.this.eZq.bCd())) {
                        e.this.nr(true);
                    }
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    e.this.gXT.j(postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.ya());
                    if (!com.baidu.tbadk.q.a.ha(qVar.xZ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.abI.getPageActivity(), writeData, 12006)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.abI.getPageActivity(), 12006, writeData, false, qVar.xZ())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.abI.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public e(TbPageContext tbPageContext, f fVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.gOR = null;
        this.abI = tbPageContext;
        this.gXT = fVar;
        this.gXU = aVar;
        this.gXN = writeUrlModel;
        this.gXT.V(this.mClickListener);
        this.gXT.W(this.gXW);
        this.gXT.e(this.gXX);
        bFi();
        this.gOR = new com.baidu.tbadk.core.view.a(this.abI);
        this.gOR.c(this.gOY);
        bFg();
        this.gXN.b(this.aDo);
        this.eZq = new com.baidu.tieba.write.b();
        this.eZq.vc(d.C0080d.cp_cont_i);
        this.eZq.vd(d.C0080d.cp_cont_h_alpha85);
    }

    private void bFg() {
        this.gXV = new com.baidu.tieba.write.transmit.model.a(this.abI.getUniqueId());
        this.gXV.a(this.gOX);
        if (this.gXN.getWriteData() != null) {
            this.gXV.setForumId(this.gXN.getWriteData().getForumId());
        }
    }

    protected void bFh() {
        this.gXT.bFt();
    }

    protected void bFi() {
        this.gXT.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO(List<SimpleForum> list) {
        WriteData writeData = this.gXN.getWriteData();
        if (writeData != null) {
            this.gOR.aE(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.u(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.abI.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void destroy() {
        if (this.gXV != null) {
            this.gXV.destroy();
        }
        if (this.gXU != null) {
            this.gXU.destroy();
        }
        if (this.gXN != null) {
            this.gXN.cancelLoadData();
        }
    }

    public void bFj() {
        this.gXV.setThreadContent(this.gXT.bFo());
        this.gXV.Rx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(boolean z) {
        if (this.gXT.bFq() != null && this.gXT.bFo() != null) {
            int selectionEnd = this.gXT.bFq().getSelectionEnd();
            SpannableStringBuilder b = this.eZq.b(this.gXT.bFq().getText());
            if (b != null) {
                this.eZq.nj(true);
                this.gXT.bFq().setText(b);
                if (z && this.eZq.bCe() >= 0) {
                    this.gXT.bFq().requestFocus();
                    this.gXT.bFq().setSelection(this.eZq.bCe());
                } else {
                    this.gXT.bFq().setSelection(selectionEnd);
                }
                this.eZq.ni(this.eZq.bCe() >= 0);
            }
        }
    }

    public boolean bFk() {
        if (this.eZq.bCf()) {
            this.abI.showToast(this.eZq.bCh());
            nr(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.eZq.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData writeData;
        if (i2 == -1) {
            if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = null;
                if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData)) {
                    postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                }
                if (postWriteCallBackData2 != null) {
                    Intent intent2 = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData2);
                    intent2.putExtras(bundle);
                    this.abI.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.gXN.getWriteData()) != null && this.gXU.bDl() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.gXV.getRecommendExt());
                this.gXN.o("", this.gXT.bFo(), this.gXU.bDl().linkUrl, this.gXU.bDl().linkUrlCode);
                this.gXT.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12006:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA)) != null && postWriteCallBackData.isSensitiveError()) {
                        this.abI.showToast(postWriteCallBackData.getErrorString());
                        this.eZq.aB(postWriteCallBackData.getSensitiveWords());
                        if (!v.v(this.eZq.bCd())) {
                            nr(true);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
