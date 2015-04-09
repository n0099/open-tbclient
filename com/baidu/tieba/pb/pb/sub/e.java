package com.baidu.tieba.pb.pb.sub;

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
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f<PbActivity> {
    private static BdAsyncTaskParallel bNM = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private com.baidu.tieba.tbadkCore.e.a aDq;
    private boolean anb;
    protected String bNH;
    protected PbActivity bNI;
    protected com.baidu.tieba.pb.a.c bNJ;
    protected g bNK;
    private int bNL;
    private ArrayList<com.baidu.tieba.pb.a.c> bNN;
    private SubPbRequestMessage bNO;
    private com.baidu.adp.framework.listener.a bNP;
    protected int mLoadType;
    protected String postID;
    protected String stType;

    static {
        zt();
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.bNH = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.bNH = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.bNH);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
        }
    }

    public e(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mLoadType = 0;
        this.bNH = null;
        this.postID = null;
        this.stType = null;
        this.bNI = null;
        this.bNJ = null;
        this.bNK = null;
        this.bNL = 0;
        this.bNN = null;
        this.anb = false;
        this.aDq = null;
        this.bNP = new f(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.bNI = pbActivity;
        this.bNN = new ArrayList<>();
        this.bNJ = new com.baidu.tieba.pb.a.c();
        setUniqueId(BdUniqueId.gen());
        acm();
    }

    public void hQ(String str) {
        this.bNH = str;
    }

    public String aaa() {
        return this.bNH;
    }

    public void hA(String str) {
        this.postID = str;
    }

    public String Yp() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public void resetData() {
        this.bNJ = new com.baidu.tieba.pb.a.c();
    }

    public com.baidu.tieba.pb.a.c ace() {
        return this.bNJ;
    }

    public WriteData IS() {
        if (this.bNJ == null || this.bNJ.Zo() == null || this.bNJ.Zq() == null || this.bNJ.Zj() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.bNJ.Zo().getName());
        writeData.setForumId(this.bNJ.Zo().getId());
        writeData.setFloor(this.bNJ.Zj().getId());
        writeData.setType(2);
        writeData.setThreadId(this.bNJ.Zq().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void a(g gVar) {
        this.bNK = gVar;
    }

    public void destory() {
        cancelMessage();
        acn();
        Hc();
    }

    private void Hc() {
        if (this.aDq != null) {
            this.aDq.destory();
            this.aDq = null;
        }
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    public int acf() {
        return this.mLoadType;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void hR(String str) {
        if (!TextUtils.isEmpty(str) && this.bNJ != null && this.bNJ.Zl() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.c.j> Zl = this.bNJ.Zl();
            int size = Zl.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(Zl.get(i).getId())) {
                    Zl.remove(i);
                    this.bNL++;
                    this.bNJ.setTotalCount(this.bNJ.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int acg() {
        int currentPage = this.bNJ.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 2 && this.bNJ.Zl().size() % this.bNJ.Zn() == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 3 && currentPage > 0) {
            return this.bNJ.Zk() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage ach() {
        this.anb = true;
        return d(null);
    }

    private SubPbRequestMessage d(Integer num) {
        long j;
        int intValue;
        long j2 = 0;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int M = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp());
        int N = com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getApp());
        if (1 != this.mLoadType) {
            j = Long.parseLong(this.postID);
        } else {
            j = 0;
            j2 = Long.parseLong(this.postID);
        }
        if (num == null) {
            intValue = acg();
        } else {
            intValue = num.intValue();
        }
        return new SubPbRequestMessage(this.bNI.getPageContext().getPageActivity(), Long.parseLong(this.bNH), j, j2, intValue, M, N, f, this.stType);
    }

    public boolean AZ() {
        return hu(0);
    }

    public boolean aci() {
        return hu(2);
    }

    public void acj() {
        int Zn;
        if (this.bNL > 0 && this.bNJ != null && (Zn = this.bNJ.Zn()) > 0) {
            int currentPage = this.bNJ.getCurrentPage();
            for (int i = (((this.bNL + Zn) - 1) / Zn) - 1; i >= 0; i--) {
                this.bNO = d(Integer.valueOf(currentPage - i));
                this.bNO.setTreatDelPage(true);
                sendMessage(this.bNO);
            }
        }
        this.bNL = 0;
    }

    public boolean ack() {
        return hu(1);
    }

    public boolean acl() {
        return hu(3);
    }

    public boolean hu(int i) {
        if (this.anb) {
            return false;
        }
        cancelMessage();
        if (this.bNH == null || this.postID == null) {
            this.anb = false;
            return false;
        }
        acj();
        this.mLoadType = i;
        this.bNO = ach();
        sendMessage(this.bNO);
        return true;
    }

    private static void zt() {
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(bNM);
        a2.setParallel(bNM);
    }

    private void acm() {
        MessageManager.getInstance().unRegisterListener(this.bNP);
        registerListener(this.bNP);
    }

    private void acn() {
        MessageManager.getInstance().unRegisterListener(this.bNP);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(com.baidu.tieba.pb.a.c cVar) {
        String str;
        if (cVar.Zq() == null || cVar.Zq().getAuthor() == null) {
            str = null;
        } else {
            str = cVar.Zq().getAuthor().getUserId();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cVar.Zl().size()) {
                cVar.Zl().get(i2).b(this.bNI.getPageContext(), str.equals(cVar.Zl().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            } else {
                this.bNN.add(cVar);
                return;
            }
        }
    }
}
