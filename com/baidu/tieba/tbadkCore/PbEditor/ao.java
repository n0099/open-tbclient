package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class ao {
    private com.baidu.tbadk.editortool.w Yg;
    private aq bWH;
    private ap bWI;
    private au bWJ;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public ao(au auVar) {
        this.bWJ = auVar;
    }

    public aq agq() {
        return this.bWH;
    }

    public void a(aq aqVar) {
        this.bWH = aqVar;
    }

    public ap agr() {
        return this.bWI;
    }

    public void a(ap apVar) {
        this.bWI = apVar;
    }

    public int ags() {
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

    public int agt() {
        return this.verticalSpacing;
    }

    public void setVerticalSpacing(int i) {
        this.verticalSpacing = i;
    }

    public int agu() {
        return this.horizontalSpacing;
    }

    public void setHorizontalSpacing(int i) {
        this.horizontalSpacing = i;
    }

    public au agv() {
        return this.bWJ;
    }

    public com.baidu.tbadk.editortool.w agw() {
        return this.Yg;
    }

    public void b(com.baidu.tbadk.editortool.w wVar) {
        this.Yg = wVar;
    }
}
