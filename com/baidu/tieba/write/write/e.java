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
import com.baidu.tbadk.coreExtra.data.r;
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
    private static final Pattern gZc = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext abI;
    public com.baidu.tieba.write.b eZL;
    private com.baidu.tbadk.core.view.a gPZ;
    private WriteUrlModel gYX;
    private f gZd;
    private com.baidu.tieba.write.model.a gZe;
    private com.baidu.tieba.write.transmit.model.a gZf;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    e.this.bFv();
                    TiebaStatic.log(new ak("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    e.this.bFu();
                }
            }
        }
    };
    private View.OnClickListener gZg = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new ak("c12163"));
                String bFH = e.this.gZd.bFH();
                if (e.gZc.matcher(bFH).matches()) {
                    e.this.bFu();
                    e.this.gZe.tW(bFH);
                    e.this.gZd.a(null, true);
                    return;
                }
                TiebaStatic.log(new ak("c12164"));
                e.this.gZd.bFI();
            }
        }
    };
    private TextWatcher gZh = new TextWatcher() { // from class: com.baidu.tieba.write.write.e.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            e.this.gZd.bFA();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (e.this.eZL != null) {
                if (!e.this.eZL.bCs()) {
                    e.this.nz(false);
                }
                e.this.eZL.nr(false);
            }
        }
    };
    private DialogInterface.OnCancelListener gQg = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.e.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (e.this.gZf != null) {
                e.this.gZf.akY();
            }
        }
    };
    private a.InterfaceC0143a gQf = new a.InterfaceC0143a() { // from class: com.baidu.tieba.write.write.e.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0143a
        public void bCo() {
            e.this.dP(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0143a
        public void B(List<SimpleForum> list) {
            e.this.dP(list);
        }
    };
    private final NewWriteModel.d aDw = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.e.6
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
            e.this.gZd.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                e.this.eZL.aB(null);
                e.this.eZL.nq(false);
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
                    e.this.eZL.aB(postWriteCallBackData.getSensitiveWords());
                    e.this.eZL.tO(postWriteCallBackData.getErrorString());
                    if (!v.v(e.this.eZL.bCp())) {
                        e.this.nz(true);
                    }
                } else if ((rVar == null || writeData == null || rVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    e.this.gZd.j(postWriteCallBackData);
                } else if (rVar != null && writeData != null && rVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(rVar.getVcode_md5());
                    writeData.setVcodeUrl(rVar.getVcode_pic_url());
                    writeData.setVcodeExtra(rVar.yi());
                    if (!com.baidu.tbadk.q.a.hb(rVar.yh())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.abI.getPageActivity(), writeData, 12006)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.abI.getPageActivity(), 12006, writeData, false, rVar.yh())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.abI.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public e(TbPageContext tbPageContext, f fVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.gPZ = null;
        this.abI = tbPageContext;
        this.gZd = fVar;
        this.gZe = aVar;
        this.gYX = writeUrlModel;
        this.gZd.V(this.mClickListener);
        this.gZd.W(this.gZg);
        this.gZd.e(this.gZh);
        bFv();
        this.gPZ = new com.baidu.tbadk.core.view.a(this.abI);
        this.gPZ.c(this.gQg);
        bFt();
        this.gYX.b(this.aDw);
        this.eZL = new com.baidu.tieba.write.b();
        this.eZL.vg(d.C0080d.cp_cont_i);
        this.eZL.vh(d.C0080d.cp_cont_h_alpha85);
    }

    private void bFt() {
        this.gZf = new com.baidu.tieba.write.transmit.model.a(this.abI.getUniqueId());
        this.gZf.a(this.gQf);
        if (this.gYX.getWriteData() != null) {
            this.gZf.setForumId(this.gYX.getWriteData().getForumId());
        }
    }

    protected void bFu() {
        this.gZd.bFG();
    }

    protected void bFv() {
        this.gZd.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dP(List<SimpleForum> list) {
        WriteData writeData = this.gYX.getWriteData();
        if (writeData != null) {
            this.gPZ.aE(false);
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
        if (this.gZf != null) {
            this.gZf.destroy();
        }
        if (this.gZe != null) {
            this.gZe.destroy();
        }
        if (this.gYX != null) {
            this.gYX.cancelLoadData();
        }
    }

    public void bFw() {
        this.gZf.setThreadContent(this.gZd.bFB());
        this.gZf.RG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(boolean z) {
        if (this.gZd.bFD() != null && this.gZd.bFB() != null) {
            int selectionEnd = this.gZd.bFD().getSelectionEnd();
            SpannableStringBuilder b = this.eZL.b(this.gZd.bFD().getText());
            if (b != null) {
                this.eZL.nr(true);
                this.gZd.bFD().setText(b);
                if (z && this.eZL.bCq() >= 0) {
                    this.gZd.bFD().requestFocus();
                    this.gZd.bFD().setSelection(this.eZL.bCq());
                } else {
                    this.gZd.bFD().setSelection(selectionEnd);
                }
                this.eZL.nq(this.eZL.bCq() >= 0);
            }
        }
    }

    public boolean bFx() {
        if (this.eZL.bCr()) {
            this.abI.showToast(this.eZL.bCt());
            nz(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.eZL.onChangeSkinType();
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
            } else if (i == 25013 && (writeData = this.gYX.getWriteData()) != null && this.gZe.bDx() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.gZf.getRecommendExt());
                this.gYX.o("", this.gZd.bFB(), this.gZe.bDx().linkUrl, this.gZe.bDx().linkUrlCode);
                this.gZd.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12006:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA)) != null && postWriteCallBackData.isSensitiveError()) {
                        this.abI.showToast(postWriteCallBackData.getErrorString());
                        this.eZL.aB(postWriteCallBackData.getSensitiveWords());
                        if (!v.v(this.eZL.bCp())) {
                            nz(true);
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
