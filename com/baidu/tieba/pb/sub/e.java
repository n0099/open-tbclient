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
    private static BdAsyncTaskParallel bAd = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private com.baidu.tieba.b.a aAE;
    protected String alT;
    protected int auI;
    protected String bAa;
    protected g bAb;
    private int bAc;
    private ArrayList<ar> bAe;
    private SubPbRequestMessage bAf;
    private com.baidu.adp.framework.listener.a bAg;
    protected ar bpm;
    protected PbActivity bvu;
    private boolean isLoading;
    protected String stType;

    static {
        rZ();
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.bAa = intent.getStringExtra("thread_id");
            this.alT = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.bAa = bundle.getString("thread_id");
            this.alT = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.bAa);
            bundle.putString("post_id", this.alT);
            bundle.putString("st_type", this.stType);
        }
    }

    public e(PbActivity pbActivity) {
        super(pbActivity);
        this.auI = 0;
        this.bAa = null;
        this.alT = null;
        this.stType = null;
        this.bvu = null;
        this.bpm = null;
        this.bAb = null;
        this.bAc = 0;
        this.bAe = null;
        this.isLoading = false;
        this.aAE = null;
        this.bAg = new f(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.bvu = pbActivity;
        this.bAe = new ArrayList<>();
        this.bpm = new ar();
        setUniqueId(BdUniqueId.gen());
        IG();
    }

    public void ha(String str) {
        this.bAa = str;
    }

    public String WF() {
        return this.bAa;
    }

    public void ey(String str) {
        this.alT = str;
    }

    public String zV() {
        return this.alT;
    }

    public String getStType() {
        return this.stType;
    }

    public void resetData() {
        this.bpm = new ar();
    }

    public ar YK() {
        return this.bpm;
    }

    public WriteData EC() {
        if (this.bpm == null || this.bpm.Aw() == null || this.bpm.Ay() == null || this.bpm.As() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.bpm.Aw().getName());
        writeData.setForumId(this.bpm.Aw().getId());
        writeData.setFloor(this.bpm.As().getId());
        writeData.setType(2);
        writeData.setThreadId(this.bpm.Ay().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void a(g gVar) {
        this.bAb = gVar;
    }

    public void xY() {
        cancelMessage();
        YR();
        Tn();
    }

    private void Tn() {
        if (this.aAE != null) {
            this.aAE.xY();
            this.aAE = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int Tu() {
        return this.auI;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void hb(String str) {
        if (!TextUtils.isEmpty(str) && this.bpm != null && this.bpm.Au() != null) {
            ArrayList<ak> Au = this.bpm.Au();
            int size = Au.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(Au.get(i).getId())) {
                    Au.remove(i);
                    this.bAc++;
                    this.bpm.setTotalCount(this.bpm.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int YL() {
        int currentPage = this.bpm.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.auI == 0) {
            return currentPage + 1;
        }
        if (this.auI == 2 && this.bpm.Au().size() % this.bpm.Av() == 0) {
            return currentPage + 1;
        }
        if (this.auI == 3 && currentPage > 0) {
            return this.bpm.At() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage YM() {
        this.isLoading = true;
        return c((Integer) null);
    }

    private SubPbRequestMessage c(Integer num) {
        long j;
        int intValue;
        long j2 = 0;
        float f = aj.wk().getApp().getResources().getDisplayMetrics().density;
        int n = com.baidu.adp.lib.util.m.n(aj.wk().getApp());
        int o = com.baidu.adp.lib.util.m.o(aj.wk().getApp());
        if (1 != this.auI) {
            j = Long.parseLong(this.alT);
        } else {
            j = 0;
            j2 = Long.parseLong(this.alT);
        }
        if (num == null) {
            intValue = YL();
        } else {
            intValue = num.intValue();
        }
        return new SubPbRequestMessage(this.bvu, Long.parseLong(this.bAa), j, j2, intValue, n, o, f, this.stType);
    }

    public boolean tL() {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.bAa == null || this.alT == null) {
            this.isLoading = false;
            return false;
        }
        YO();
        this.auI = 0;
        this.bAf = YM();
        sendMessage(this.bAf);
        return true;
    }

    public boolean YN() {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.bAa == null || this.alT == null) {
            this.isLoading = false;
            return false;
        } else if (this.bpm.hasMore()) {
            return false;
        } else {
            YO();
            this.auI = 2;
            this.bAf = YM();
            sendMessage(this.bAf);
            return true;
        }
    }

    public void YO() {
        int Av;
        if (this.bAc > 0 && this.bpm != null && (Av = this.bpm.Av()) > 0) {
            int currentPage = this.bpm.getCurrentPage();
            for (int i = (((this.bAc + Av) - 1) / Av) - 1; i >= 0; i--) {
                this.bAf = c(Integer.valueOf(currentPage - i));
                this.bAf.setTreatDelPage(true);
                sendMessage(this.bAf);
            }
        }
        this.bAc = 0;
    }

    public boolean YP() {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.bAa == null || this.alT == null) {
            this.isLoading = false;
            return false;
        }
        YO();
        this.auI = 1;
        this.bAf = YM();
        sendMessage(this.bAf);
        return true;
    }

    public boolean YQ() {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.bAa == null || this.alT == null) {
            this.isLoading = false;
            return false;
        }
        YO();
        this.auI = 3;
        this.bAf = YM();
        sendMessage(this.bAf);
        return true;
    }

    private static void rZ() {
        com.baidu.tbadk.task.b a = ai.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = ai.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(bAd);
        a2.setParallel(bAd);
    }

    private void IG() {
        MessageManager.getInstance().unRegisterListener(this.bAg);
        registerListener(this.bAg);
    }

    private void YR() {
        MessageManager.getInstance().unRegisterListener(this.bAg);
    }

    public void b(ar arVar) {
        String str;
        if (arVar.Ay() == null || arVar.Ay().getAuthor() == null) {
            str = null;
        } else {
            str = arVar.Ay().getAuthor().getUserId();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arVar.Au().size()) {
                arVar.Au().get(i2).a(this.bvu, str.equals(arVar.Au().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            } else {
                this.bAe.add(arVar);
                return;
            }
        }
    }
}
