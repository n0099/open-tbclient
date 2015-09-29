package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
public class t extends BaseAdapter {
    private AntiData cgo;
    private PersonInfoActivity cqt;
    private ad csA;
    private v csB;
    private ab csC;
    private aa csD;
    private ae csy;
    private u csz;
    private boolean mIsHost;

    public t(PersonInfoActivity personInfoActivity, boolean z) {
        this.cqt = personInfoActivity;
        this.mIsHost = z;
        this.csy = new ae(this.cqt, this.mIsHost);
        this.csz = new u(this.cqt, this.mIsHost);
        this.csA = new ad(this.cqt, this.mIsHost);
        this.csB = new v(this.cqt, this.mIsHost);
        this.csC = new ab(this.cqt, this.mIsHost);
        this.csD = new aa(this.cqt);
    }

    public void b(AntiData antiData) {
        this.cgo = antiData;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return (!this.mIsHost || PersonInfoActivityConfig.IS_HAVE_MYMARK) ? 5 : 4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.mIsHost) {
            switch (i) {
                case 0:
                default:
                    return 0;
                case 1:
                    return 2;
                case 2:
                    return 3;
                case 3:
                    return PersonInfoActivityConfig.IS_HAVE_MYMARK ? 5 : 4;
                case 4:
                    return 4;
            }
        }
        switch (i) {
            case 0:
            default:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return (!this.mIsHost || PersonInfoActivityConfig.IS_HAVE_MYMARK) ? 5 : 4;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            this.csy.ajC();
            return this.csy.getRootView();
        } else if (itemViewType == 1) {
            this.csz.ajC();
            return this.csz.getRootView();
        } else if (itemViewType == 2) {
            this.csA.ajC();
            return this.csA.getRootView();
        } else if (itemViewType == 3) {
            this.csB.ajC();
            return this.csB.getRootView();
        } else if (itemViewType == 4) {
            this.csC.c(this.cgo);
            return this.csC.getRootView();
        } else if (itemViewType == 5) {
            this.csD.ajC();
            return this.csD.getRootView();
        } else {
            return null;
        }
    }

    public RelativeLayout ajo() {
        return this.csA.ajo();
    }

    public void ajp() {
        this.csA.ajp();
    }

    public RelativeLayout ajq() {
        return this.csz.ajB();
    }

    public RelativeLayout ajr() {
        return this.csz.ajr();
    }

    public RelativeLayout ajs() {
        return this.csD.ajs();
    }

    public TextView ajt() {
        return this.csA.ajt();
    }

    public RelativeLayout aju() {
        return this.csz.aju();
    }

    public RelativeLayout ajv() {
        return this.csA.ajv();
    }

    public RelativeLayout ajw() {
        return this.csA.ajw();
    }

    public RelativeLayout ajx() {
        return this.csA.ajx();
    }

    public RelativeLayout ajy() {
        return this.csB.ajy();
    }

    public RelativeLayout ajz() {
        return this.csB.ajr();
    }

    public RelativeLayout ajA() {
        return this.csC.ajA();
    }

    public void fa(boolean z) {
        this.csA.fa(z);
    }

    public void jm(int i) {
        this.csA.jm(i);
    }
}
