package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private PersonInfoActivity bJY;
    private z bJZ;
    private q bKa;
    private r bKb;
    private t bKc;
    private x bKd;
    private boolean mIsHost;

    public p(PersonInfoActivity personInfoActivity, boolean z) {
        this.bJY = personInfoActivity;
        this.mIsHost = z;
        this.bJZ = new z(this.bJY, this.mIsHost);
        this.bKa = new q(this.bJY, this.mIsHost);
        this.bKb = new r(this.bJY, this.mIsHost);
        this.bKc = new t(this.bJY, this.mIsHost);
        this.bKd = new x(this.bJY, this.mIsHost);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.mIsHost ? 4 : 5;
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
        return this.mIsHost ? 4 : 5;
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
            this.bJZ.abD();
            return this.bJZ.getRootView();
        } else if (itemViewType == 1) {
            this.bKa.abD();
            return this.bKa.getRootView();
        } else if (itemViewType == 2) {
            this.bKb.abD();
            return this.bKb.getRootView();
        } else if (itemViewType == 3) {
            this.bKc.abD();
            return this.bKc.getRootView();
        } else if (itemViewType == 4) {
            this.bKd.abD();
            return this.bKd.getRootView();
        } else {
            return null;
        }
    }

    public RelativeLayout abr() {
        return this.bKb.abr();
    }

    public void abs() {
        this.bKb.abs();
    }

    public RelativeLayout abt() {
        return this.bKa.abC();
    }

    public RelativeLayout abu() {
        return this.bKa.abu();
    }

    public TextView abv() {
        return this.bKb.abv();
    }

    public RelativeLayout abw() {
        return this.bKa.abw();
    }

    public RelativeLayout abx() {
        return this.bKb.abx();
    }

    public RelativeLayout aby() {
        return this.bKb.aby();
    }

    public RelativeLayout abz() {
        return this.bKc.abz();
    }

    public RelativeLayout abA() {
        return this.bKc.abu();
    }

    public RelativeLayout abB() {
        return this.bKd.abB();
    }

    public void ek(boolean z) {
        this.bKb.ek(z);
    }

    public void hu(int i) {
        this.bKb.hu(i);
    }
}
