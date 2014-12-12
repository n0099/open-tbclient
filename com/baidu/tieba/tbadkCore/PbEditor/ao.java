package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class ao {
    private com.baidu.tbadk.editortool.w XD;
    private aq bUP;
    private ap bUQ;
    private au bUR;
    private int column = 0;
    private int row = 0;
    private int verticalSpacing = 0;
    private int horizontalSpacing = 0;

    public abstract void exit();

    public abstract int getCount();

    public abstract void init(Context context);

    public ao(au auVar) {
        this.bUR = auVar;
    }

    public aq afR() {
        return this.bUP;
    }

    public void a(aq aqVar) {
        this.bUP = aqVar;
    }

    public ap afS() {
        return this.bUQ;
    }

    public void a(ap apVar) {
        this.bUQ = apVar;
    }

    public int afT() {
        return this.column;
    }

    public void hI(int i) {
        this.column = i;
    }

    public int getRow() {
        return this.row;
    }

    public void hJ(int i) {
        this.row = i;
    }

    public int afU() {
        return this.verticalSpacing;
    }

    public void setVerticalSpacing(int i) {
        this.verticalSpacing = i;
    }

    public int afV() {
        return this.horizontalSpacing;
    }

    public void setHorizontalSpacing(int i) {
        this.horizontalSpacing = i;
    }

    public au afW() {
        return this.bUR;
    }

    public com.baidu.tbadk.editortool.w afX() {
        return this.XD;
    }

    public void b(com.baidu.tbadk.editortool.w wVar) {
        this.XD = wVar;
    }
}
