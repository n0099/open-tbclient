package com.baidu.tieba.write.write;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.TransmitForumData;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class cm {
    private static final Pattern gbG = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext aas;
    private com.baidu.tieba.write.transmit.model.a fXo;
    private com.baidu.tbadk.core.view.a gap;
    private WriteUrlModel gbB;
    private cs gbH;
    private com.baidu.tieba.write.model.a gbI;
    private View.OnClickListener bhc = new cn(this);
    private View.OnClickListener gbJ = new co(this);
    private DialogInterface.OnCancelListener gaP = new cp(this);
    private a.InterfaceC0086a fWS = new cq(this);
    private final NewWriteModel.d aAR = new cr(this);

    public cm(TbPageContext tbPageContext, cs csVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.gap = null;
        this.aas = tbPageContext;
        this.gbH = csVar;
        this.gbI = aVar;
        this.gbB = writeUrlModel;
        this.gbH.Y(this.bhc);
        this.gbH.Z(this.gbJ);
        bqp();
        this.gap = new com.baidu.tbadk.core.view.a(this.aas);
        this.gap.c(this.gaP);
        bpK();
        this.gbB.b(this.aAR);
    }

    private void bpK() {
        this.fXo = new com.baidu.tieba.write.transmit.model.a(this.aas.getUniqueId());
        this.fXo.a(this.fWS);
        if (this.gbB.getWriteData() != null) {
            this.fXo.setForumId(this.gbB.getWriteData().getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqo() {
        this.gbH.bqy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqp() {
        this.gbH.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(List<SimpleForum> list) {
        WriteData writeData = this.gbB.getWriteData();
        if (writeData != null) {
            this.gap.aH(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (com.baidu.tbadk.core.util.x.q(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.aas.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void destroy() {
        if (this.fXo != null) {
            this.fXo.destroy();
        }
        if (this.gbI != null) {
            this.gbI.destroy();
        }
        if (this.gbB != null) {
            this.gbB.cancelLoadData();
        }
    }

    public void bqq() {
        this.fXo.setThreadContent(this.gbH.bqs());
        this.fXo.NJ();
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        WriteData writeData;
        if (i2 == -1) {
            if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (postWriteCallBackData != null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(TbadkCoreApplication.m9getInst().getContext()).createNormalCfg(postWriteCallBackData.getThreadId(), null, null);
                    createNormalCfg.setNeedRepostRecommendForum(true);
                    createNormalCfg.setPostThreadTip(postWriteCallBackData.getErrorString());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.gbB.getWriteData()) != null && this.gbI.bop() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.fXo.getRecommendExt());
                this.gbB.n("", this.gbH.bqs(), this.gbI.bop().linkUrl, this.gbI.bop().linkUrlCode);
                this.gbH.Pd();
            }
        }
    }
}
