package com.baidu.tieba.write.write;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
public class c {
    private static final Pattern gNY = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext abz;
    private com.baidu.tbadk.core.view.a gFq;
    private WriteUrlModel gNT;
    private d gNZ;
    private com.baidu.tieba.write.model.a gOa;
    private com.baidu.tieba.write.transmit.model.a gOb;
    private View.OnClickListener aPe = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.h.icon_invoke_link) {
                    c.this.bBR();
                    TiebaStatic.log(new ak("c12169"));
                }
                if (view.getId() == d.h.url_edit_back_view) {
                    c.this.bBQ();
                }
            }
        }
    };
    private View.OnClickListener gOc = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.h.url_add) {
                TiebaStatic.log(new ak("c12163"));
                String bCc = c.this.gNZ.bCc();
                if (c.gNY.matcher(bCc).matches()) {
                    c.this.bBQ();
                    c.this.gOa.te(bCc);
                    c.this.gNZ.a(null, true);
                    return;
                }
                TiebaStatic.log(new ak("c12164"));
                c.this.gNZ.bCd();
            }
        }
    };
    private DialogInterface.OnCancelListener gFx = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.c.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (c.this.gOb != null) {
                c.this.gOb.aiD();
            }
        }
    };
    private a.InterfaceC0139a gFw = new a.InterfaceC0139a() { // from class: com.baidu.tieba.write.write.c.4
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0139a
        public void byP() {
            c.this.dL(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0139a
        public void A(List<SimpleForum> list) {
            c.this.dL(list);
        }
    };
    private final NewWriteModel.d aCR = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.c.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            c.this.gNZ.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (c.this.c(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.d(c.this.abz.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    c.this.abz.getPageActivity().setResult(-1, intent);
                    c.this.abz.getPageActivity().finish();
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    c.this.gNZ.e(postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.ya());
                    if (!com.baidu.tbadk.p.a.gT(qVar.xZ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(c.this.abz.getPageActivity(), writeData, 12006)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(c.this.abz.getPageActivity(), 12006, writeData, false, qVar.xZ())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.abz.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, d dVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.gFq = null;
        this.abz = tbPageContext;
        this.gNZ = dVar;
        this.gOa = aVar;
        this.gNT = writeUrlModel;
        this.gNZ.T(this.aPe);
        this.gNZ.U(this.gOc);
        bBR();
        this.gFq = new com.baidu.tbadk.core.view.a(this.abz);
        this.gFq.c(this.gFx);
        bBP();
        this.gNT.b(this.aCR);
    }

    private void bBP() {
        this.gOb = new com.baidu.tieba.write.transmit.model.a(this.abz.getUniqueId());
        this.gOb.a(this.gFw);
        if (this.gNT.getWriteData() != null) {
            this.gOb.setForumId(this.gNT.getWriteData().getForumId());
        }
    }

    protected void bBQ() {
        this.gNZ.bCb();
    }

    protected void bBR() {
        this.gNZ.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dL(List<SimpleForum> list) {
        WriteData writeData = this.gNT.getWriteData();
        if (writeData != null) {
            this.gFq.aH(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.t(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.abz.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void destroy() {
        if (this.gOb != null) {
            this.gOb.destroy();
        }
        if (this.gOa != null) {
            this.gOa.destroy();
        }
        if (this.gNT != null) {
            this.gNT.cancelLoadData();
        }
    }

    public void bBS() {
        this.gOb.setThreadContent(this.gNZ.bBW());
        this.gOb.Qj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        WriteData writeData;
        if (i2 == -1) {
            if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                if (postWriteCallBackData != null) {
                    Intent intent2 = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent2.putExtras(bundle);
                    this.abz.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
                return;
            } else if (i == 25013 && (writeData = this.gNT.getWriteData()) != null && this.gOa.bzT() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.gOb.getRecommendExt());
                this.gNT.n("", this.gNZ.bBW(), this.gOa.bzT().linkUrl, this.gOa.bzT().linkUrlCode);
                this.gNZ.showLoadingDialog();
                return;
            } else {
                return;
            }
        }
        if (i2 == 0) {
        }
    }
}
