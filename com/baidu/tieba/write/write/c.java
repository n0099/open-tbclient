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
    private static final Pattern gJD = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext acr;
    private com.baidu.tbadk.core.view.a gAP;
    private com.baidu.tieba.write.transmit.model.a gFn;
    private d gJE;
    private com.baidu.tieba.write.model.a gJF;
    private WriteUrlModel gJy;
    private View.OnClickListener aYY = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.h.icon_invoke_link) {
                    c.this.bBd();
                    TiebaStatic.log(new aj("c12169"));
                }
                if (view.getId() == d.h.url_edit_back_view) {
                    c.this.bBc();
                }
            }
        }
    };
    private View.OnClickListener gJG = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.h.url_add) {
                TiebaStatic.log(new aj("c12163"));
                String bBo = c.this.gJE.bBo();
                if (c.gJD.matcher(bBo).matches()) {
                    c.this.bBc();
                    c.this.gJF.td(bBo);
                    c.this.gJE.a(null, true);
                    return;
                }
                TiebaStatic.log(new aj("c12164"));
                c.this.gJE.bBp();
            }
        }
    };
    private DialogInterface.OnCancelListener gAW = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.c.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (c.this.gFn != null) {
                c.this.gFn.aEp();
            }
        }
    };
    private a.InterfaceC0126a gAV = new a.InterfaceC0126a() { // from class: com.baidu.tieba.write.write.c.4
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0126a
        public void bya() {
            c.this.dG(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0126a
        public void B(List<SimpleForum> list) {
            c.this.dG(list);
        }
    };
    private final NewWriteModel.d aEn = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.c.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            c.this.gJE.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (z) {
                    com.baidu.tieba.tbadkCore.writeModel.c.c(c.this.acr.getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    c.this.acr.getPageActivity().setResult(-1, intent);
                    c.this.acr.getPageActivity().finish();
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    c.this.gJE.d(postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.yy());
                    if (!com.baidu.tbadk.q.a.hb(qVar.yx())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(c.this.acr.getPageActivity(), writeData, 12006)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(c.this.acr.getPageActivity(), 12006, writeData, false, qVar.yx())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.acr.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, d dVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.gAP = null;
        this.acr = tbPageContext;
        this.gJE = dVar;
        this.gJF = aVar;
        this.gJy = writeUrlModel;
        this.gJE.U(this.aYY);
        this.gJE.V(this.gJG);
        bBd();
        this.gAP = new com.baidu.tbadk.core.view.a(this.acr);
        this.gAP.c(this.gAW);
        bBb();
        this.gJy.b(this.aEn);
    }

    private void bBb() {
        this.gFn = new com.baidu.tieba.write.transmit.model.a(this.acr.getUniqueId());
        this.gFn.a(this.gAV);
        if (this.gJy.getWriteData() != null) {
            this.gFn.setForumId(this.gJy.getWriteData().getForumId());
        }
    }

    protected void bBc() {
        this.gJE.bBn();
    }

    protected void bBd() {
        this.gJE.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dG(List<SimpleForum> list) {
        WriteData writeData = this.gJy.getWriteData();
        if (writeData != null) {
            this.gAP.aH(false);
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
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.acr.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void destroy() {
        if (this.gFn != null) {
            this.gFn.destroy();
        }
        if (this.gJF != null) {
            this.gJF.destroy();
        }
        if (this.gJy != null) {
            this.gJy.cancelLoadData();
        }
    }

    public void bBe() {
        this.gFn.setThreadContent(this.gJE.bBi());
        this.gFn.Px();
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
                    this.acr.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
                return;
            } else if (i == 25013 && (writeData = this.gJy.getWriteData()) != null && this.gJF.bzc() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.gFn.getRecommendExt());
                this.gJy.l("", this.gJE.bBi(), this.gJF.bzc().linkUrl, this.gJF.bzc().linkUrlCode);
                this.gJE.showLoadingDialog();
                return;
            } else {
                return;
            }
        }
        if (i2 == 0) {
        }
    }
}
