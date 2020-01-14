package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
/* loaded from: classes.dex */
public class x extends bj {
    public static final BdUniqueId keA = BdUniqueId.gen();
    private boolean eng = false;
    private bl keB;
    private bo keC;

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return keA;
    }

    public boolean cIU() {
        return this.eng;
    }

    public void sF(boolean z) {
        this.eng = z;
    }

    public bl cIV() {
        return this.keB;
    }

    public void a(bl blVar) {
        this.keB = blVar;
    }

    public bo cIW() {
        return this.keC;
    }

    public void a(bo boVar) {
        this.keC = boVar;
    }
}
