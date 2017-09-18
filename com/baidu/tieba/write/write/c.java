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
    private static final Pattern gJc = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext aby;
    private com.baidu.tbadk.core.view.a gAj;
    private com.baidu.tieba.write.transmit.model.a gEM;
    private WriteUrlModel gIX;
    private d gJd;
    private com.baidu.tieba.write.model.a gJe;
    private View.OnClickListener aYH = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.h.icon_invoke_link) {
                    c.this.bAE();
                    TiebaStatic.log(new ak("c12169"));
                }
                if (view.getId() == d.h.url_edit_back_view) {
                    c.this.bAD();
                }
            }
        }
    };
    private View.OnClickListener gJf = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.h.url_add) {
                TiebaStatic.log(new ak("c12163"));
                String bAP = c.this.gJd.bAP();
                if (c.gJc.matcher(bAP).matches()) {
                    c.this.bAD();
                    c.this.gJe.ta(bAP);
                    c.this.gJd.a(null, true);
                    return;
                }
                TiebaStatic.log(new ak("c12164"));
                c.this.gJd.bAQ();
            }
        }
    };
    private DialogInterface.OnCancelListener gAq = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.c.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (c.this.gEM != null) {
                c.this.gEM.aiz();
            }
        }
    };
    private a.InterfaceC0128a gAp = new a.InterfaceC0128a() { // from class: com.baidu.tieba.write.write.c.4
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0128a
        public void bxB() {
            c.this.dF(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0128a
        public void B(List<SimpleForum> list) {
            c.this.dF(list);
        }
    };
    private final NewWriteModel.d aDB = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.c.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            c.this.gJd.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (z) {
                    com.baidu.tieba.tbadkCore.writeModel.c.c(c.this.aby.getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    c.this.aby.getPageActivity().setResult(-1, intent);
                    c.this.aby.getPageActivity().finish();
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    c.this.gJd.d(postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.yB());
                    if (!com.baidu.tbadk.q.a.gX(qVar.yA())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(c.this.aby.getPageActivity(), writeData, 12006)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(c.this.aby.getPageActivity(), 12006, writeData, false, qVar.yA())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.aby.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, d dVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.gAj = null;
        this.aby = tbPageContext;
        this.gJd = dVar;
        this.gJe = aVar;
        this.gIX = writeUrlModel;
        this.gJd.S(this.aYH);
        this.gJd.T(this.gJf);
        bAE();
        this.gAj = new com.baidu.tbadk.core.view.a(this.aby);
        this.gAj.c(this.gAq);
        bAC();
        this.gIX.b(this.aDB);
    }

    private void bAC() {
        this.gEM = new com.baidu.tieba.write.transmit.model.a(this.aby.getUniqueId());
        this.gEM.a(this.gAp);
        if (this.gIX.getWriteData() != null) {
            this.gEM.setForumId(this.gIX.getWriteData().getForumId());
        }
    }

    protected void bAD() {
        this.gJd.bAO();
    }

    protected void bAE() {
        this.gJd.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(List<SimpleForum> list) {
        WriteData writeData = this.gIX.getWriteData();
        if (writeData != null) {
            this.gAj.aH(false);
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
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.aby.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void destroy() {
        if (this.gEM != null) {
            this.gEM.destroy();
        }
        if (this.gJe != null) {
            this.gJe.destroy();
        }
        if (this.gIX != null) {
            this.gIX.cancelLoadData();
        }
    }

    public void bAF() {
        this.gEM.setThreadContent(this.gJd.bAJ());
        this.gEM.PP();
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
                    this.aby.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
                return;
            } else if (i == 25013 && (writeData = this.gIX.getWriteData()) != null && this.gJe.byD() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.gEM.getRecommendExt());
                this.gIX.n("", this.gJd.bAJ(), this.gJe.byD().linkUrl, this.gJe.byD().linkUrlCode);
                this.gJd.showLoadingDialog();
                return;
            } else {
                return;
            }
        }
        if (i2 == 0) {
        }
    }
}
