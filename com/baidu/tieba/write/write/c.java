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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.u;
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
/* loaded from: classes.dex */
public class c {
    private static final Pattern gGA = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext aaS;
    private com.baidu.tieba.write.transmit.model.a gCk;
    private d gGB;
    private com.baidu.tieba.write.model.a gGC;
    private WriteUrlModel gGv;
    private com.baidu.tbadk.core.view.a gxM;
    private View.OnClickListener aXL = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.h.icon_invoke_link) {
                    c.this.bAx();
                    TiebaStatic.log(new aj("c12169"));
                }
                if (view.getId() == d.h.url_edit_back_view) {
                    c.this.bAw();
                }
            }
        }
    };
    private View.OnClickListener gGD = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.h.url_add) {
                TiebaStatic.log(new aj("c12163"));
                String bAI = c.this.gGB.bAI();
                if (c.gGA.matcher(bAI).matches()) {
                    c.this.bAw();
                    c.this.gGC.sR(bAI);
                    c.this.gGB.a(null, true);
                    return;
                }
                TiebaStatic.log(new aj("c12164"));
                c.this.gGB.bAJ();
            }
        }
    };
    private DialogInterface.OnCancelListener gxT = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.c.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (c.this.gCk != null) {
                c.this.gCk.aDC();
            }
        }
    };
    private a.InterfaceC0126a gxS = new a.InterfaceC0126a() { // from class: com.baidu.tieba.write.write.c.4
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0126a
        public void bxt() {
            c.this.dD(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0126a
        public void B(List<SimpleForum> list) {
            c.this.dD(list);
        }
    };
    private final NewWriteModel.d aCV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.c.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            c.this.gGB.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (z) {
                    com.baidu.tieba.tbadkCore.writeModel.c.c(c.this.aaS.getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    c.this.aaS.getPageActivity().setResult(-1, intent);
                    c.this.aaS.getPageActivity().finish();
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    c.this.gGB.d(postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.yq());
                    if (!com.baidu.tbadk.q.a.gT(qVar.yp())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(c.this.aaS.getPageActivity(), writeData, 12006)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(c.this.aaS.getPageActivity(), 12006, writeData, false, qVar.yp())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.aaS.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, d dVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.gxM = null;
        this.aaS = tbPageContext;
        this.gGB = dVar;
        this.gGC = aVar;
        this.gGv = writeUrlModel;
        this.gGB.Y(this.aXL);
        this.gGB.Z(this.gGD);
        bAx();
        this.gxM = new com.baidu.tbadk.core.view.a(this.aaS);
        this.gxM.c(this.gxT);
        bAv();
        this.gGv.b(this.aCV);
    }

    private void bAv() {
        this.gCk = new com.baidu.tieba.write.transmit.model.a(this.aaS.getUniqueId());
        this.gCk.a(this.gxS);
        if (this.gGv.getWriteData() != null) {
            this.gCk.setForumId(this.gGv.getWriteData().getForumId());
        }
    }

    protected void bAw() {
        this.gGB.bAH();
    }

    protected void bAx() {
        this.gGB.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(List<SimpleForum> list) {
        WriteData writeData = this.gGv.getWriteData();
        if (writeData != null) {
            this.gxM.aH(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (u.u(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.aaS.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void destroy() {
        if (this.gCk != null) {
            this.gCk.destroy();
        }
        if (this.gGC != null) {
            this.gGC.destroy();
        }
        if (this.gGv != null) {
            this.gGv.cancelLoadData();
        }
    }

    public void bAy() {
        this.gCk.setThreadContent(this.gGB.bAC());
        this.gCk.Pm();
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
                    this.aaS.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
                return;
            } else if (i == 25013 && (writeData = this.gGv.getWriteData()) != null && this.gGC.byw() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.gCk.getRecommendExt());
                this.gGv.n("", this.gGB.bAC(), this.gGC.byw().linkUrl, this.gGC.byw().linkUrlCode);
                this.gGB.QS();
                return;
            } else {
                return;
            }
        }
        if (i2 == 0) {
        }
    }
}
