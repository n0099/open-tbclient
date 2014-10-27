package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.data.MarkData;
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.base.e {
    private boolean bpe;
    private MarkData bpf;
    private ak bpg;
    private al bph;

    public aj(Context context) {
        super(context);
        this.bpe = false;
        this.bpf = null;
        this.bpg = null;
        this.bph = null;
        this.bpf = new MarkData();
    }

    public boolean zN() {
        return this.bpe;
    }

    public MarkData TH() {
        return this.bpf;
    }

    public void a(al alVar) {
        this.bph = alVar;
    }

    public void b(MarkData markData) {
        this.bpf = markData;
    }

    public void bs(boolean z) {
        this.bpe = z;
    }

    public String zO() {
        if (this.bpf != null) {
            return this.bpf.getPostId();
        }
        return null;
    }

    public void TI() {
        if (this.bpg != null) {
            this.bpg.cancel();
        }
        this.bpg = new ak(this, true);
        this.bpg.setPriority(3);
        this.bpg.execute(new Boolean[0]);
    }

    public void TJ() {
        if (this.bpg != null) {
            this.bpg.cancel();
        }
        this.bpg = new ak(this, false);
        this.bpg.setPriority(3);
        this.bpg.execute(new Boolean[0]);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bpg != null) {
            this.bpg.cancel();
            return false;
        }
        return false;
    }
}
