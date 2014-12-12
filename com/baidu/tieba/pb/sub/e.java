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
    private static BdAsyncTaskParallel bEe = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    protected String Bd;
    private com.baidu.tieba.tbadkCore.d.a aCg;
    private boolean aef;
    protected String bDZ;
    protected PbActivity bEa;
    protected com.baidu.tieba.tbadkCore.b.o bEb;
    protected g bEc;
    private int bEd;
    private ArrayList<com.baidu.tieba.tbadkCore.b.o> bEf;
    private SubPbRequestMessage bEg;
    private com.baidu.adp.framework.listener.a bEh;
    protected int mLoadType;
    protected String stType;

    static {
        vB();
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.bDZ = intent.getStringExtra("thread_id");
            this.Bd = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.bDZ = bundle.getString("thread_id");
            this.Bd = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.bDZ);
            bundle.putString("post_id", this.Bd);
            bundle.putString("st_type", this.stType);
        }
    }

    public e(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mLoadType = 0;
        this.bDZ = null;
        this.Bd = null;
        this.stType = null;
        this.bEa = null;
        this.bEb = null;
        this.bEc = null;
        this.bEd = 0;
        this.bEf = null;
        this.aef = false;
        this.aCg = null;
        this.bEh = new f(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.bEa = pbActivity;
        this.bEf = new ArrayList<>();
        this.bEb = new com.baidu.tieba.tbadkCore.b.o();
        setUniqueId(BdUniqueId.gen());
        Jd();
    }

    public void hz(String str) {
        this.bDZ = str;
    }

    public String Xf() {
        return this.bDZ;
    }

    public void bG(String str) {
        this.Bd = str;
    }

    public String lt() {
        return this.Bd;
    }

    public String getStType() {
        return this.stType;
    }

    public void resetData() {
        this.bEb = new com.baidu.tieba.tbadkCore.b.o();
    }

    public com.baidu.tieba.tbadkCore.b.o Zh() {
        return this.bEb;
    }

    public WriteData EV() {
        if (this.bEb == null || this.bEb.ahg() == null || this.bEb.ahh() == null || this.bEb.ahc() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.bEb.ahg().getName());
        writeData.setForumId(this.bEb.ahg().getId());
        writeData.setFloor(this.bEb.ahc().getId());
        writeData.setType(2);
        writeData.setThreadId(this.bEb.ahh().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void a(g gVar) {
        this.bEc = gVar;
    }

    public void destory() {
        cancelMessage();
        Zo();
        Ue();
    }

    private void Ue() {
        if (this.aCg != null) {
            this.aCg.destory();
            this.aCg = null;
        }
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    public int Ul() {
        return this.mLoadType;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void hA(String str) {
        if (!TextUtils.isEmpty(str) && this.bEb != null && this.bEb.ahe() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahe = this.bEb.ahe();
            int size = ahe.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(ahe.get(i).getId())) {
                    ahe.remove(i);
                    this.bEd++;
                    this.bEb.setTotalCount(this.bEb.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int Zi() {
        int currentPage = this.bEb.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 2 && this.bEb.ahe().size() % this.bEb.ahf() == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 3 && currentPage > 0) {
            return this.bEb.ahd() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage Zj() {
        this.aef = true;
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
            intValue = Zi();
        } else {
            intValue = num.intValue();
        }
        return new SubPbRequestMessage(this.bEa.getPageContext().getPageActivity(), Long.parseLong(this.bDZ), j, j2, intValue, M, N, f, this.stType);
    }

    public boolean xv() {
        if (this.aef) {
            return false;
        }
        cancelMessage();
        if (this.bDZ == null || this.Bd == null) {
            this.aef = false;
            return false;
        }
        Zl();
        this.mLoadType = 0;
        this.bEg = Zj();
        sendMessage(this.bEg);
        return true;
    }

    public boolean Zk() {
        if (this.aef) {
            return false;
        }
        cancelMessage();
        if (this.bDZ == null || this.Bd == null) {
            this.aef = false;
            return false;
        } else if (this.bEb.hasMore()) {
            return false;
        } else {
            Zl();
            this.mLoadType = 2;
            this.bEg = Zj();
            sendMessage(this.bEg);
            return true;
        }
    }

    public void Zl() {
        int ahf;
        if (this.bEd > 0 && this.bEb != null && (ahf = this.bEb.ahf()) > 0) {
            int currentPage = this.bEb.getCurrentPage();
            for (int i = (((this.bEd + ahf) - 1) / ahf) - 1; i >= 0; i--) {
                this.bEg = c(Integer.valueOf(currentPage - i));
                this.bEg.setTreatDelPage(true);
                sendMessage(this.bEg);
            }
        }
        this.bEd = 0;
    }

    public boolean Zm() {
        if (this.aef) {
            return false;
        }
        cancelMessage();
        if (this.bDZ == null || this.Bd == null) {
            this.aef = false;
            return false;
        }
        Zl();
        this.mLoadType = 1;
        this.bEg = Zj();
        sendMessage(this.bEg);
        return true;
    }

    public boolean Zn() {
        if (this.aef) {
            return false;
        }
        cancelMessage();
        if (this.bDZ == null || this.Bd == null) {
            this.aef = false;
            return false;
        }
        Zl();
        this.mLoadType = 3;
        this.bEg = Zj();
        sendMessage(this.bEg);
        return true;
    }

    private static void vB() {
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(bEe);
        a2.setParallel(bEe);
    }

    private void Jd() {
        MessageManager.getInstance().unRegisterListener(this.bEh);
        registerListener(this.bEh);
    }

    private void Zo() {
        MessageManager.getInstance().unRegisterListener(this.bEh);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(com.baidu.tieba.tbadkCore.b.o oVar) {
        String str;
        if (oVar.ahh() == null || oVar.ahh().getAuthor() == null) {
            str = null;
        } else {
            str = oVar.ahh().getAuthor().getUserId();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < oVar.ahe().size()) {
                oVar.ahe().get(i2).a(this.bEa.getPageContext(), str.equals(oVar.ahe().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            } else {
                this.bEf.add(oVar);
                return;
            }
        }
    }
}
