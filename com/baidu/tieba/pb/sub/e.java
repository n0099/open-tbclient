package com.baidu.tieba.pb.sub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.main.PbActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f<PbActivity> {
    private static BdAsyncTaskParallel bFO = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    protected String Ba;
    private com.baidu.tieba.tbadkCore.d.a aDe;
    private boolean aez;
    protected String bFJ;
    protected PbActivity bFK;
    protected com.baidu.tieba.tbadkCore.b.o bFL;
    protected g bFM;
    private int bFN;
    private ArrayList<com.baidu.tieba.tbadkCore.b.o> bFP;
    private SubPbRequestMessage bFQ;
    private com.baidu.adp.framework.listener.a bFR;
    protected int mLoadType;
    protected String stType;

    static {
        vN();
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.bFJ = intent.getStringExtra("thread_id");
            this.Ba = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.bFJ = bundle.getString("thread_id");
            this.Ba = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.bFJ);
            bundle.putString("post_id", this.Ba);
            bundle.putString("st_type", this.stType);
        }
    }

    public e(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mLoadType = 0;
        this.bFJ = null;
        this.Ba = null;
        this.stType = null;
        this.bFK = null;
        this.bFL = null;
        this.bFM = null;
        this.bFN = 0;
        this.bFP = null;
        this.aez = false;
        this.aDe = null;
        this.bFR = new f(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.bFK = pbActivity;
        this.bFP = new ArrayList<>();
        this.bFL = new com.baidu.tieba.tbadkCore.b.o();
        setUniqueId(BdUniqueId.gen());
        Jw();
    }

    public void hD(String str) {
        this.bFJ = str;
    }

    public String XF() {
        return this.bFJ;
    }

    public void bB(String str) {
        this.Ba = str;
    }

    public String lm() {
        return this.Ba;
    }

    public String getStType() {
        return this.stType;
    }

    public void resetData() {
        this.bFL = new com.baidu.tieba.tbadkCore.b.o();
    }

    public com.baidu.tieba.tbadkCore.b.o ZH() {
        return this.bFL;
    }

    public WriteData Fn() {
        if (this.bFL == null || this.bFL.ahG() == null || this.bFL.ahH() == null || this.bFL.ahC() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.bFL.ahG().getName());
        writeData.setForumId(this.bFL.ahG().getId());
        writeData.setFloor(this.bFL.ahC().getId());
        writeData.setType(2);
        writeData.setThreadId(this.bFL.ahH().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void a(g gVar) {
        this.bFM = gVar;
    }

    public void destory() {
        cancelMessage();
        ZO();
        Uw();
    }

    private void Uw() {
        if (this.aDe != null) {
            this.aDe.destory();
            this.aDe = null;
        }
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    public int UD() {
        return this.mLoadType;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void hE(String str) {
        if (!TextUtils.isEmpty(str) && this.bFL != null && this.bFL.ahE() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahE = this.bFL.ahE();
            int size = ahE.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(ahE.get(i).getId())) {
                    ahE.remove(i);
                    this.bFN++;
                    this.bFL.setTotalCount(this.bFL.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int ZI() {
        int currentPage = this.bFL.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 2 && this.bFL.ahE().size() % this.bFL.ahF() == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 3 && currentPage > 0) {
            return this.bFL.ahD() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage ZJ() {
        this.aez = true;
        return c((Integer) null);
    }

    private SubPbRequestMessage c(Integer num) {
        long j;
        int intValue;
        long j2 = 0;
        float f = TbadkCoreApplication.m255getInst().getApp().getResources().getDisplayMetrics().density;
        int M = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp());
        int N = com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getApp());
        if (1 != this.mLoadType) {
            j = Long.parseLong(this.Ba);
        } else {
            j = 0;
            j2 = Long.parseLong(this.Ba);
        }
        if (num == null) {
            intValue = ZI();
        } else {
            intValue = num.intValue();
        }
        return new SubPbRequestMessage(this.bFK.getPageContext().getPageActivity(), Long.parseLong(this.bFJ), j, j2, intValue, M, N, f, this.stType);
    }

    public boolean xF() {
        if (this.aez) {
            return false;
        }
        cancelMessage();
        if (this.bFJ == null || this.Ba == null) {
            this.aez = false;
            return false;
        }
        ZL();
        this.mLoadType = 0;
        this.bFQ = ZJ();
        sendMessage(this.bFQ);
        return true;
    }

    public boolean ZK() {
        if (this.aez) {
            return false;
        }
        cancelMessage();
        if (this.bFJ == null || this.Ba == null) {
            this.aez = false;
            return false;
        } else if (this.bFL.hasMore()) {
            return false;
        } else {
            ZL();
            this.mLoadType = 2;
            this.bFQ = ZJ();
            sendMessage(this.bFQ);
            return true;
        }
    }

    public void ZL() {
        int ahF;
        if (this.bFN > 0 && this.bFL != null && (ahF = this.bFL.ahF()) > 0) {
            int currentPage = this.bFL.getCurrentPage();
            for (int i = (((this.bFN + ahF) - 1) / ahF) - 1; i >= 0; i--) {
                this.bFQ = c(Integer.valueOf(currentPage - i));
                this.bFQ.setTreatDelPage(true);
                sendMessage(this.bFQ);
            }
        }
        this.bFN = 0;
    }

    public boolean ZM() {
        if (this.aez) {
            return false;
        }
        cancelMessage();
        if (this.bFJ == null || this.Ba == null) {
            this.aez = false;
            return false;
        }
        ZL();
        this.mLoadType = 1;
        this.bFQ = ZJ();
        sendMessage(this.bFQ);
        return true;
    }

    public boolean ZN() {
        if (this.aez) {
            return false;
        }
        cancelMessage();
        if (this.bFJ == null || this.Ba == null) {
            this.aez = false;
            return false;
        }
        ZL();
        this.mLoadType = 3;
        this.bFQ = ZJ();
        sendMessage(this.bFQ);
        return true;
    }

    private static void vN() {
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(bFO);
        a2.setParallel(bFO);
    }

    private void Jw() {
        MessageManager.getInstance().unRegisterListener(this.bFR);
        registerListener(this.bFR);
    }

    private void ZO() {
        MessageManager.getInstance().unRegisterListener(this.bFR);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(com.baidu.tieba.tbadkCore.b.o oVar) {
        String str;
        if (oVar.ahH() == null || oVar.ahH().getAuthor() == null) {
            str = null;
        } else {
            str = oVar.ahH().getAuthor().getUserId();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < oVar.ahE().size()) {
                oVar.ahE().get(i2).a(this.bFK.getPageContext(), str.equals(oVar.ahE().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            } else {
                this.bFP.add(oVar);
                return;
            }
        }
    }
}
