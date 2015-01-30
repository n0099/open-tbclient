package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class ao {
    private com.baidu.tbadk.editortool.w Yj;
    private aq bWI;
    private ap bWJ;
    private au bWK;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public ao(au auVar) {
        this.bWK = auVar;
    }

    public aq agv() {
        return this.bWI;
    }

    public void a(aq aqVar) {
        this.bWI = aqVar;
    }

    public ap agw() {
        return this.bWJ;
    }

    public void a(ap apVar) {
        this.bWJ = apVar;
    }

    public int agx() {
        return this.column;
    }

    public void hR(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void hS(int i) {
        this.row = i;
    }

    public int agy() {
        return this.verticalSpacing;
    }

    public void setVerticalSpacing(int i) {
        this.verticalSpacing = i;
    }

    public int agz() {
        return this.horizontalSpacing;
    }

    public void setHorizontalSpacing(int i) {
        this.horizontalSpacing = i;
    }

    public au agA() {
        return this.bWK;
    }

    public com.baidu.tbadk.editortool.w agB() {
        return this.Yj;
    }

    public void b(com.baidu.tbadk.editortool.w wVar) {
        this.Yj = wVar;
    }
}
