package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private q bSA;
    private r bSB;
    private t bSC;
    private x bSD;
    private PersonInfoActivity bSy;
    private z bSz;
    private boolean mIsHost;

    public p(PersonInfoActivity personInfoActivity, boolean z) {
        this.bSy = personInfoActivity;
        this.mIsHost = z;
        this.bSz = new z(this.bSy, this.mIsHost);
        this.bSA = new q(this.bSy, this.mIsHost);
        this.bSB = new r(this.bSy, this.mIsHost);
        this.bSC = new t(this.bSy, this.mIsHost);
        this.bSD = new x(this.bSy, this.mIsHost);
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
            this.bSz.aeg();
            return this.bSz.getRootView();
        } else if (itemViewType == 1) {
            this.bSA.aeg();
            return this.bSA.getRootView();
        } else if (itemViewType == 2) {
            this.bSB.aeg();
            return this.bSB.getRootView();
        } else if (itemViewType == 3) {
            this.bSC.aeg();
            return this.bSC.getRootView();
        } else if (itemViewType == 4) {
            this.bSD.aeg();
            return this.bSD.getRootView();
        } else {
            return null;
        }
    }

    public RelativeLayout adU() {
        return this.bSB.adU();
    }

    public void adV() {
        this.bSB.adV();
    }

    public RelativeLayout adW() {
        return this.bSA.aef();
    }

    public RelativeLayout adX() {
        return this.bSA.adX();
    }

    public TextView adY() {
        return this.bSB.adY();
    }

    public RelativeLayout adZ() {
        return this.bSA.adZ();
    }

    public RelativeLayout aea() {
        return this.bSB.aea();
    }

    public RelativeLayout aeb() {
        return this.bSB.aeb();
    }

    public RelativeLayout aec() {
        return this.bSC.aec();
    }

    public RelativeLayout aed() {
        return this.bSC.adX();
    }

    public RelativeLayout aee() {
        return this.bSD.aee();
    }

    public void ef(boolean z) {
        this.bSB.ef(z);
    }

    public void hG(int i) {
        this.bSB.hG(i);
    }
}
