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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
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
public class ck {
    private static final Pattern gmE = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext aat;
    private com.baidu.tbadk.core.view.a gdr;
    private com.baidu.tieba.write.transmit.model.a gio;
    private cq gmF;
    private com.baidu.tieba.write.model.a gmG;
    private WriteUrlModel gmz;
    private View.OnClickListener bkk = new cl(this);
    private View.OnClickListener gmH = new cm(this);
    private DialogInterface.OnCancelListener gdy = new cn(this);
    private a.InterfaceC0088a gdx = new co(this);
    private final NewWriteModel.d aBU = new cp(this);

    public ck(TbPageContext tbPageContext, cq cqVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.gdr = null;
        this.aat = tbPageContext;
        this.gmF = cqVar;
        this.gmG = aVar;
        this.gmz = writeUrlModel;
        this.gmF.Z(this.bkk);
        this.gmF.aa(this.gmH);
        buP();
        this.gdr = new com.baidu.tbadk.core.view.a(this.aat);
        this.gdr.c(this.gdy);
        buN();
        this.gmz.b(this.aBU);
    }

    private void buN() {
        this.gio = new com.baidu.tieba.write.transmit.model.a(this.aat.getUniqueId());
        this.gio.a(this.gdx);
        if (this.gmz.getWriteData() != null) {
            this.gio.setForumId(this.gmz.getWriteData().getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buO() {
        this.gmF.buZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buP() {
        this.gmF.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(List<SimpleForum> list) {
        WriteData writeData = this.gmz.getWriteData();
        if (writeData != null) {
            this.gdr.aI(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (com.baidu.tbadk.core.util.z.s(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.aat.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void destroy() {
        if (this.gio != null) {
            this.gio.destroy();
        }
        if (this.gmG != null) {
            this.gmG.destroy();
        }
        if (this.gmz != null) {
            this.gmz.cancelLoadData();
        }
    }

    public void buQ() {
        this.gio.setThreadContent(this.gmF.buT());
        this.gio.OZ();
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
                    this.aat.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.gmz.getWriteData()) != null && this.gmG.bsN() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.gio.getRecommendExt());
                this.gmz.n("", this.gmF.buT(), this.gmG.bsN().linkUrl, this.gmG.bsN().linkUrlCode);
                this.gmF.Qx();
            }
        }
    }
}
