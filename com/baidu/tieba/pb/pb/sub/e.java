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
    private static BdAsyncTaskParallel bNw = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private com.baidu.tieba.tbadkCore.e.a aDi;
    private boolean amT;
    protected String bNr;
    protected PbActivity bNs;
    protected com.baidu.tieba.pb.a.c bNt;
    protected g bNu;
    private int bNv;
    private ArrayList<com.baidu.tieba.pb.a.c> bNx;
    private SubPbRequestMessage bNy;
    private com.baidu.adp.framework.listener.a bNz;
    protected int mLoadType;
    protected String postID;
    protected String stType;

    static {
        zn();
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.bNr = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.bNr = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.bNr);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
        }
    }

    public e(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mLoadType = 0;
        this.bNr = null;
        this.postID = null;
        this.stType = null;
        this.bNs = null;
        this.bNt = null;
        this.bNu = null;
        this.bNv = 0;
        this.bNx = null;
        this.amT = false;
        this.aDi = null;
        this.bNz = new f(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.bNs = pbActivity;
        this.bNx = new ArrayList<>();
        this.bNt = new com.baidu.tieba.pb.a.c();
        setUniqueId(BdUniqueId.gen());
        abX();
    }

    public void hN(String str) {
        this.bNr = str;
    }

    public String ZN() {
        return this.bNr;
    }

    public void hx(String str) {
        this.postID = str;
    }

    public String Yd() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public void resetData() {
        this.bNt = new com.baidu.tieba.pb.a.c();
    }

    public com.baidu.tieba.pb.a.c abP() {
        return this.bNt;
    }

    public WriteData IM() {
        if (this.bNt == null || this.bNt.Zb() == null || this.bNt.Zd() == null || this.bNt.YX() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.bNt.Zb().getName());
        writeData.setForumId(this.bNt.Zb().getId());
        writeData.setFloor(this.bNt.YX().getId());
        writeData.setType(2);
        writeData.setThreadId(this.bNt.Zd().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void a(g gVar) {
        this.bNu = gVar;
    }

    public void destory() {
        cancelMessage();
        abY();
        GW();
    }

    private void GW() {
        if (this.aDi != null) {
            this.aDi.destory();
            this.aDi = null;
        }
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    public int abQ() {
        return this.mLoadType;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void hO(String str) {
        if (!TextUtils.isEmpty(str) && this.bNt != null && this.bNt.YZ() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.c.j> YZ = this.bNt.YZ();
            int size = YZ.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(YZ.get(i).getId())) {
                    YZ.remove(i);
                    this.bNv++;
                    this.bNt.setTotalCount(this.bNt.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int abR() {
        int currentPage = this.bNt.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 2 && this.bNt.YZ().size() % this.bNt.Za() == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 3 && currentPage > 0) {
            return this.bNt.YY() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage abS() {
        this.amT = true;
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
            intValue = abR();
        } else {
            intValue = num.intValue();
        }
        return new SubPbRequestMessage(this.bNs.getPageContext().getPageActivity(), Long.parseLong(this.bNr), j, j2, intValue, M, N, f, this.stType);
    }

    public boolean AT() {
        return hs(0);
    }

    public boolean abT() {
        return hs(2);
    }

    public void abU() {
        int Za;
        if (this.bNv > 0 && this.bNt != null && (Za = this.bNt.Za()) > 0) {
            int currentPage = this.bNt.getCurrentPage();
            for (int i = (((this.bNv + Za) - 1) / Za) - 1; i >= 0; i--) {
                this.bNy = d(Integer.valueOf(currentPage - i));
                this.bNy.setTreatDelPage(true);
                sendMessage(this.bNy);
            }
        }
        this.bNv = 0;
    }

    public boolean abV() {
        return hs(1);
    }

    public boolean abW() {
        return hs(3);
    }

    public boolean hs(int i) {
        if (this.amT) {
            return false;
        }
        cancelMessage();
        if (this.bNr == null || this.postID == null) {
            this.amT = false;
            return false;
        }
        abU();
        this.mLoadType = i;
        this.bNy = abS();
        sendMessage(this.bNy);
        return true;
    }

    private static void zn() {
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(bNw);
        a2.setParallel(bNw);
    }

    private void abX() {
        MessageManager.getInstance().unRegisterListener(this.bNz);
        registerListener(this.bNz);
    }

    private void abY() {
        MessageManager.getInstance().unRegisterListener(this.bNz);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(com.baidu.tieba.pb.a.c cVar) {
        String str;
        if (cVar.Zd() == null || cVar.Zd().getAuthor() == null) {
            str = null;
        } else {
            str = cVar.Zd().getAuthor().getUserId();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cVar.YZ().size()) {
                cVar.YZ().get(i2).b(this.bNs.getPageContext(), str.equals(cVar.YZ().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            } else {
                this.bNx.add(cVar);
                return;
            }
        }
    }
}
