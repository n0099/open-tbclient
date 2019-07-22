package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class v extends bg {
    public static final BdUniqueId jee = BdUniqueId.gen();
    private boolean dtI = false;
    private bi jef;
    private bl jeg;

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jee;
    }

    public boolean bvh() {
        return this.dtI;
    }

    public void qY(boolean z) {
        this.dtI = z;
    }

    public bi coK() {
        return this.jef;
    }

    public void a(bi biVar) {
        this.jef = biVar;
    }

    public bl coL() {
        return this.jeg;
    }

    public void a(bl blVar) {
        this.jeg = blVar;
    }
}
