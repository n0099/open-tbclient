package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
/* loaded from: classes.dex */
public class x extends bj {
    public static final BdUniqueId keu = BdUniqueId.gen();
    private boolean eng = false;
    private bl kev;
    private bo kew;

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return keu;
    }

    public boolean cIS() {
        return this.eng;
    }

    public void sF(boolean z) {
        this.eng = z;
    }

    public bl cIT() {
        return this.kev;
    }

    public void a(bl blVar) {
        this.kev = blVar;
    }

    public bo cIU() {
        return this.kew;
    }

    public void a(bo boVar) {
        this.kew = boVar;
    }
}
