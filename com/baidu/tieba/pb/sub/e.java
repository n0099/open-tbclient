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
    private static BdAsyncTaskParallel bFP = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    protected String Bd;
    private com.baidu.tieba.tbadkCore.d.a aDh;
    private boolean aeC;
    protected String bFK;
    protected PbActivity bFL;
    protected com.baidu.tieba.tbadkCore.b.o bFM;
    protected g bFN;
    private int bFO;
    private ArrayList<com.baidu.tieba.tbadkCore.b.o> bFQ;
    private SubPbRequestMessage bFR;
    private com.baidu.adp.framework.listener.a bFS;
    protected int mLoadType;
    protected String stType;

    static {
        vT();
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.bFK = intent.getStringExtra("thread_id");
            this.Bd = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.bFK = bundle.getString("thread_id");
            this.Bd = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.bFK);
            bundle.putString("post_id", this.Bd);
            bundle.putString("st_type", this.stType);
        }
    }

    public e(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mLoadType = 0;
        this.bFK = null;
        this.Bd = null;
        this.stType = null;
        this.bFL = null;
        this.bFM = null;
        this.bFN = null;
        this.bFO = 0;
        this.bFQ = null;
        this.aeC = false;
        this.aDh = null;
        this.bFS = new f(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.bFL = pbActivity;
        this.bFQ = new ArrayList<>();
        this.bFM = new com.baidu.tieba.tbadkCore.b.o();
        setUniqueId(BdUniqueId.gen());
        JB();
    }

    public void hG(String str) {
        this.bFK = str;
    }

    public String XK() {
        return this.bFK;
    }

    public void bE(String str) {
        this.Bd = str;
    }

    public String lt() {
        return this.Bd;
    }

    public String getStType() {
        return this.stType;
    }

    public void resetData() {
        this.bFM = new com.baidu.tieba.tbadkCore.b.o();
    }

    public com.baidu.tieba.tbadkCore.b.o ZM() {
        return this.bFM;
    }

    public WriteData Ft() {
        if (this.bFM == null || this.bFM.ahL() == null || this.bFM.ahM() == null || this.bFM.ahH() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.bFM.ahL().getName());
        writeData.setForumId(this.bFM.ahL().getId());
        writeData.setFloor(this.bFM.ahH().getId());
        writeData.setType(2);
        writeData.setThreadId(this.bFM.ahM().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void a(g gVar) {
        this.bFN = gVar;
    }

    public void destory() {
        cancelMessage();
        ZT();
        UB();
    }

    private void UB() {
        if (this.aDh != null) {
            this.aDh.destory();
            this.aDh = null;
        }
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    public int UI() {
        return this.mLoadType;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void hH(String str) {
        if (!TextUtils.isEmpty(str) && this.bFM != null && this.bFM.ahJ() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahJ = this.bFM.ahJ();
            int size = ahJ.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(ahJ.get(i).getId())) {
                    ahJ.remove(i);
                    this.bFO++;
                    this.bFM.setTotalCount(this.bFM.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int ZN() {
        int currentPage = this.bFM.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 2 && this.bFM.ahJ().size() % this.bFM.ahK() == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 3 && currentPage > 0) {
            return this.bFM.ahI() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage ZO() {
        this.aeC = true;
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
            j = Long.parseLong(this.Bd);
        } else {
            j = 0;
            j2 = Long.parseLong(this.Bd);
        }
        if (num == null) {
            intValue = ZN();
        } else {
            intValue = num.intValue();
        }
        return new SubPbRequestMessage(this.bFL.getPageContext().getPageActivity(), Long.parseLong(this.bFK), j, j2, intValue, M, N, f, this.stType);
    }

    public boolean xL() {
        if (this.aeC) {
            return false;
        }
        cancelMessage();
        if (this.bFK == null || this.Bd == null) {
            this.aeC = false;
            return false;
        }
        ZQ();
        this.mLoadType = 0;
        this.bFR = ZO();
        sendMessage(this.bFR);
        return true;
    }

    public boolean ZP() {
        if (this.aeC) {
            return false;
        }
        cancelMessage();
        if (this.bFK == null || this.Bd == null) {
            this.aeC = false;
            return false;
        } else if (this.bFM.hasMore()) {
            return false;
        } else {
            ZQ();
            this.mLoadType = 2;
            this.bFR = ZO();
            sendMessage(this.bFR);
            return true;
        }
    }

    public void ZQ() {
        int ahK;
        if (this.bFO > 0 && this.bFM != null && (ahK = this.bFM.ahK()) > 0) {
            int currentPage = this.bFM.getCurrentPage();
            for (int i = (((this.bFO + ahK) - 1) / ahK) - 1; i >= 0; i--) {
                this.bFR = c(Integer.valueOf(currentPage - i));
                this.bFR.setTreatDelPage(true);
                sendMessage(this.bFR);
            }
        }
        this.bFO = 0;
    }

    public boolean ZR() {
        if (this.aeC) {
            return false;
        }
        cancelMessage();
        if (this.bFK == null || this.Bd == null) {
            this.aeC = false;
            return false;
        }
        ZQ();
        this.mLoadType = 1;
        this.bFR = ZO();
        sendMessage(this.bFR);
        return true;
    }

    public boolean ZS() {
        if (this.aeC) {
            return false;
        }
        cancelMessage();
        if (this.bFK == null || this.Bd == null) {
            this.aeC = false;
            return false;
        }
        ZQ();
        this.mLoadType = 3;
        this.bFR = ZO();
        sendMessage(this.bFR);
        return true;
    }

    private static void vT() {
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(bFP);
        a2.setParallel(bFP);
    }

    private void JB() {
        MessageManager.getInstance().unRegisterListener(this.bFS);
        registerListener(this.bFS);
    }

    private void ZT() {
        MessageManager.getInstance().unRegisterListener(this.bFS);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(com.baidu.tieba.tbadkCore.b.o oVar) {
        String str;
        if (oVar.ahM() == null || oVar.ahM().getAuthor() == null) {
            str = null;
        } else {
            str = oVar.ahM().getAuthor().getUserId();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < oVar.ahJ().size()) {
                oVar.ahJ().get(i2).a(this.bFL.getPageContext(), str.equals(oVar.ahJ().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            } else {
                this.bFQ.add(oVar);
                return;
            }
        }
    }
}
