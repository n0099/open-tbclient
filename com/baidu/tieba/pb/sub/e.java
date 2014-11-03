package com.baidu.tieba.pb.sub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ai;
import com.baidu.tieba.aj;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.data.ar;
import com.baidu.tieba.pb.main.PbActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e {
    private static BdAsyncTaskParallel bAr = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private com.baidu.tieba.b.a aAO;
    protected String amc;
    protected int auR;
    protected String bAo;
    protected g bAp;
    private int bAq;
    private ArrayList<ar> bAs;
    private SubPbRequestMessage bAt;
    private com.baidu.adp.framework.listener.a bAu;
    protected ar bpA;
    protected PbActivity bvI;
    private boolean isLoading;
    protected String stType;

    static {
        sb();
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.bAo = intent.getStringExtra("thread_id");
            this.amc = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.bAo = bundle.getString("thread_id");
            this.amc = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.bAo);
            bundle.putString("post_id", this.amc);
            bundle.putString("st_type", this.stType);
        }
    }

    public e(PbActivity pbActivity) {
        super(pbActivity);
        this.auR = 0;
        this.bAo = null;
        this.amc = null;
        this.stType = null;
        this.bvI = null;
        this.bpA = null;
        this.bAp = null;
        this.bAq = 0;
        this.bAs = null;
        this.isLoading = false;
        this.aAO = null;
        this.bAu = new f(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.bvI = pbActivity;
        this.bAs = new ArrayList<>();
        this.bpA = new ar();
        setUniqueId(BdUniqueId.gen());
        IK();
    }

    public void ha(String str) {
        this.bAo = str;
    }

    public String WI() {
        return this.bAo;
    }

    public void ey(String str) {
        this.amc = str;
    }

    public String zX() {
        return this.amc;
    }

    public String getStType() {
        return this.stType;
    }

    public void resetData() {
        this.bpA = new ar();
    }

    public ar YN() {
        return this.bpA;
    }

    public WriteData EE() {
        if (this.bpA == null || this.bpA.Ay() == null || this.bpA.AA() == null || this.bpA.Au() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.bpA.Ay().getName());
        writeData.setForumId(this.bpA.Ay().getId());
        writeData.setFloor(this.bpA.Au().getId());
        writeData.setType(2);
        writeData.setThreadId(this.bpA.AA().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void a(g gVar) {
        this.bAp = gVar;
    }

    public void ya() {
        cancelMessage();
        YU();
        Tq();
    }

    private void Tq() {
        if (this.aAO != null) {
            this.aAO.ya();
            this.aAO = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int Tx() {
        return this.auR;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void hb(String str) {
        if (!TextUtils.isEmpty(str) && this.bpA != null && this.bpA.Aw() != null) {
            ArrayList<ak> Aw = this.bpA.Aw();
            int size = Aw.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(Aw.get(i).getId())) {
                    Aw.remove(i);
                    this.bAq++;
                    this.bpA.setTotalCount(this.bpA.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int YO() {
        int currentPage = this.bpA.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.auR == 0) {
            return currentPage + 1;
        }
        if (this.auR == 2 && this.bpA.Aw().size() % this.bpA.Ax() == 0) {
            return currentPage + 1;
        }
        if (this.auR == 3 && currentPage > 0) {
            return this.bpA.Av() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage YP() {
        this.isLoading = true;
        return c((Integer) null);
    }

    private SubPbRequestMessage c(Integer num) {
        long j;
        int intValue;
        long j2 = 0;
        float f = aj.wm().getApp().getResources().getDisplayMetrics().density;
        int n = com.baidu.adp.lib.util.m.n(aj.wm().getApp());
        int o = com.baidu.adp.lib.util.m.o(aj.wm().getApp());
        if (1 != this.auR) {
            j = Long.parseLong(this.amc);
        } else {
            j = 0;
            j2 = Long.parseLong(this.amc);
        }
        if (num == null) {
            intValue = YO();
        } else {
            intValue = num.intValue();
        }
        return new SubPbRequestMessage(this.bvI, Long.parseLong(this.bAo), j, j2, intValue, n, o, f, this.stType);
    }

    public boolean tN() {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.bAo == null || this.amc == null) {
            this.isLoading = false;
            return false;
        }
        YR();
        this.auR = 0;
        this.bAt = YP();
        sendMessage(this.bAt);
        return true;
    }

    public boolean YQ() {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.bAo == null || this.amc == null) {
            this.isLoading = false;
            return false;
        } else if (this.bpA.hasMore()) {
            return false;
        } else {
            YR();
            this.auR = 2;
            this.bAt = YP();
            sendMessage(this.bAt);
            return true;
        }
    }

    public void YR() {
        int Ax;
        if (this.bAq > 0 && this.bpA != null && (Ax = this.bpA.Ax()) > 0) {
            int currentPage = this.bpA.getCurrentPage();
            for (int i = (((this.bAq + Ax) - 1) / Ax) - 1; i >= 0; i--) {
                this.bAt = c(Integer.valueOf(currentPage - i));
                this.bAt.setTreatDelPage(true);
                sendMessage(this.bAt);
            }
        }
        this.bAq = 0;
    }

    public boolean YS() {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.bAo == null || this.amc == null) {
            this.isLoading = false;
            return false;
        }
        YR();
        this.auR = 1;
        this.bAt = YP();
        sendMessage(this.bAt);
        return true;
    }

    public boolean YT() {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.bAo == null || this.amc == null) {
            this.isLoading = false;
            return false;
        }
        YR();
        this.auR = 3;
        this.bAt = YP();
        sendMessage(this.bAt);
        return true;
    }

    private static void sb() {
        com.baidu.tbadk.task.b a = ai.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = ai.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(bAr);
        a2.setParallel(bAr);
    }

    private void IK() {
        MessageManager.getInstance().unRegisterListener(this.bAu);
        registerListener(this.bAu);
    }

    private void YU() {
        MessageManager.getInstance().unRegisterListener(this.bAu);
    }

    public void b(ar arVar) {
        String str;
        if (arVar.AA() == null || arVar.AA().getAuthor() == null) {
            str = null;
        } else {
            str = arVar.AA().getAuthor().getUserId();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arVar.Aw().size()) {
                arVar.Aw().get(i2).a(this.bvI, str.equals(arVar.Aw().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            } else {
                this.bAs.add(arVar);
                return;
            }
        }
    }
}
