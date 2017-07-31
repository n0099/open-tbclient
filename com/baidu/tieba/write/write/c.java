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
    private static final Pattern gHL = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext acp;
    private com.baidu.tieba.write.transmit.model.a gDv;
    private WriteUrlModel gHG;
    private d gHM;
    private com.baidu.tieba.write.model.a gHN;
    private com.baidu.tbadk.core.view.a gyX;
    private View.OnClickListener aYW = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.h.icon_invoke_link) {
                    c.this.bAE();
                    TiebaStatic.log(new aj("c12169"));
                }
                if (view.getId() == d.h.url_edit_back_view) {
                    c.this.bAD();
                }
            }
        }
    };
    private View.OnClickListener gHO = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.h.url_add) {
                TiebaStatic.log(new aj("c12163"));
                String bAP = c.this.gHM.bAP();
                if (c.gHL.matcher(bAP).matches()) {
                    c.this.bAD();
                    c.this.gHN.sW(bAP);
                    c.this.gHM.a(null, true);
                    return;
                }
                TiebaStatic.log(new aj("c12164"));
                c.this.gHM.bAQ();
            }
        }
    };
    private DialogInterface.OnCancelListener gze = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.c.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (c.this.gDv != null) {
                c.this.gDv.aDN();
            }
        }
    };
    private a.InterfaceC0125a gzd = new a.InterfaceC0125a() { // from class: com.baidu.tieba.write.write.c.4
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0125a
        public void bxA() {
            c.this.dD(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0125a
        public void B(List<SimpleForum> list) {
            c.this.dD(list);
        }
    };
    private final NewWriteModel.d aEl = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.c.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            c.this.gHM.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (z) {
                    com.baidu.tieba.tbadkCore.writeModel.c.c(c.this.acp.getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    c.this.acp.getPageActivity().setResult(-1, intent);
                    c.this.acp.getPageActivity().finish();
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    c.this.gHM.d(postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.yy());
                    if (!com.baidu.tbadk.q.a.gY(qVar.yx())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(c.this.acp.getPageActivity(), writeData, 12006)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(c.this.acp.getPageActivity(), 12006, writeData, false, qVar.yx())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.acp.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, d dVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.gyX = null;
        this.acp = tbPageContext;
        this.gHM = dVar;
        this.gHN = aVar;
        this.gHG = writeUrlModel;
        this.gHM.Y(this.aYW);
        this.gHM.Z(this.gHO);
        bAE();
        this.gyX = new com.baidu.tbadk.core.view.a(this.acp);
        this.gyX.c(this.gze);
        bAC();
        this.gHG.b(this.aEl);
    }

    private void bAC() {
        this.gDv = new com.baidu.tieba.write.transmit.model.a(this.acp.getUniqueId());
        this.gDv.a(this.gzd);
        if (this.gHG.getWriteData() != null) {
            this.gDv.setForumId(this.gHG.getWriteData().getForumId());
        }
    }

    protected void bAD() {
        this.gHM.bAO();
    }

    protected void bAE() {
        this.gHM.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(List<SimpleForum> list) {
        WriteData writeData = this.gHG.getWriteData();
        if (writeData != null) {
            this.gyX.aH(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.d(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (u.u(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.d(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.acp.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void destroy() {
        if (this.gDv != null) {
            this.gDv.destroy();
        }
        if (this.gHN != null) {
            this.gHN.destroy();
        }
        if (this.gHG != null) {
            this.gHG.cancelLoadData();
        }
    }

    public void bAF() {
        this.gDv.setThreadContent(this.gHM.bAJ());
        this.gDv.Pr();
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
                    this.acp.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
                return;
            } else if (i == 25013 && (writeData = this.gHG.getWriteData()) != null && this.gHN.byD() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.gDv.getRecommendExt());
                this.gHG.n("", this.gHM.bAJ(), this.gHN.byD().linkUrl, this.gHN.byD().linkUrlCode);
                this.gHM.QX();
                return;
            } else {
                return;
            }
        }
        if (i2 == 0) {
        }
    }
}
