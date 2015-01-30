package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private PersonInfoActivity bJZ;
    private z bKa;
    private q bKb;
    private r bKc;
    private t bKd;
    private x bKe;
    private boolean mIsHost;

    public p(PersonInfoActivity personInfoActivity, boolean z) {
        this.bJZ = personInfoActivity;
        this.mIsHost = z;
        this.bKa = new z(this.bJZ, this.mIsHost);
        this.bKb = new q(this.bJZ, this.mIsHost);
        this.bKc = new r(this.bJZ, this.mIsHost);
        this.bKd = new t(this.bJZ, this.mIsHost);
        this.bKe = new x(this.bJZ, this.mIsHost);
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
            this.bKa.abI();
            return this.bKa.getRootView();
        } else if (itemViewType == 1) {
            this.bKb.abI();
            return this.bKb.getRootView();
        } else if (itemViewType == 2) {
            this.bKc.abI();
            return this.bKc.getRootView();
        } else if (itemViewType == 3) {
            this.bKd.abI();
            return this.bKd.getRootView();
        } else if (itemViewType == 4) {
            this.bKe.abI();
            return this.bKe.getRootView();
        } else {
            return null;
        }
    }

    public RelativeLayout abw() {
        return this.bKc.abw();
    }

    public void abx() {
        this.bKc.abx();
    }

    public RelativeLayout aby() {
        return this.bKb.abH();
    }

    public RelativeLayout abz() {
        return this.bKb.abz();
    }

    public TextView abA() {
        return this.bKc.abA();
    }

    public RelativeLayout abB() {
        return this.bKb.abB();
    }

    public RelativeLayout abC() {
        return this.bKc.abC();
    }

    public RelativeLayout abD() {
        return this.bKc.abD();
    }

    public RelativeLayout abE() {
        return this.bKd.abE();
    }

    public RelativeLayout abF() {
        return this.bKd.abz();
    }

    public RelativeLayout abG() {
        return this.bKe.abG();
    }

    public void ek(boolean z) {
        this.bKc.ek(z);
    }

    public void hu(int i) {
        this.bKc.hu(i);
    }
}
