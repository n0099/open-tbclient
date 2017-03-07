package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
/* loaded from: classes.dex */
public class af extends bj {
    public static final BdUniqueId ftm = BdUniqueId.gen();
    private bm ftn;
    private bp fto;
    private boolean ftp = false;

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ftm;
    }

    public boolean bgR() {
        return this.ftp;
    }

    public void le(boolean z) {
        this.ftp = z;
    }

    public bm bgS() {
        return this.ftn;
    }

    public void a(bm bmVar) {
        this.ftn = bmVar;
    }

    public bp bgT() {
        return this.fto;
    }

    public void a(bp bpVar) {
        this.fto = bpVar;
    }
}
