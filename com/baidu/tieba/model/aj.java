package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.base.e {
    private boolean bps;
    private MarkData bpt;
    private ak bpu;
    private al bpv;

    public aj(Context context) {
        super(context);
        this.bps = false;
        this.bpt = null;
        this.bpu = null;
        this.bpv = null;
        this.bpt = new MarkData();
    }

    public boolean zP() {
        return this.bps;
    }

    public MarkData TK() {
        return this.bpt;
    }

    public void a(al alVar) {
        this.bpv = alVar;
    }

    public void b(MarkData markData) {
        this.bpt = markData;
    }

    public void bs(boolean z) {
        this.bps = z;
    }

    public String zQ() {
        if (this.bpt != null) {
            return this.bpt.getPostId();
        }
        return null;
    }

    public void TL() {
        if (this.bpu != null) {
            this.bpu.cancel();
        }
        this.bpu = new ak(this, true);
        this.bpu.setPriority(3);
        this.bpu.execute(new Boolean[0]);
    }

    public void TM() {
        if (this.bpu != null) {
            this.bpu.cancel();
        }
        this.bpu = new ak(this, false);
        this.bpu.setPriority(3);
        this.bpu.execute(new Boolean[0]);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bpu != null) {
            this.bpu.cancel();
            return false;
        }
        return false;
    }
}
