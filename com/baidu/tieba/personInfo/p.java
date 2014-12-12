package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private PersonInfoActivity bIn;
    private z bIo;
    private q bIp;
    private r bIq;
    private t bIr;
    private x bIs;
    private boolean mIsHost;

    public p(PersonInfoActivity personInfoActivity, boolean z) {
        this.bIn = personInfoActivity;
        this.mIsHost = z;
        this.bIo = new z(this.bIn, this.mIsHost);
        this.bIp = new q(this.bIn, this.mIsHost);
        this.bIq = new r(this.bIn, this.mIsHost);
        this.bIr = new t(this.bIn, this.mIsHost);
        this.bIs = new x(this.bIn, this.mIsHost);
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
            this.bIo.abe();
            return this.bIo.getRootView();
        } else if (itemViewType == 1) {
            this.bIp.abe();
            return this.bIp.getRootView();
        } else if (itemViewType == 2) {
            this.bIq.abe();
            return this.bIq.getRootView();
        } else if (itemViewType == 3) {
            this.bIr.abe();
            return this.bIr.getRootView();
        } else if (itemViewType == 4) {
            this.bIs.abe();
            return this.bIs.getRootView();
        } else {
            return null;
        }
    }

    public RelativeLayout aaS() {
        return this.bIq.aaS();
    }

    public void aaT() {
        this.bIq.aaT();
    }

    public RelativeLayout aaU() {
        return this.bIp.abd();
    }

    public RelativeLayout aaV() {
        return this.bIp.aaV();
    }

    public TextView aaW() {
        return this.bIq.aaW();
    }

    public RelativeLayout aaX() {
        return this.bIp.aaX();
    }

    public RelativeLayout aaY() {
        return this.bIq.aaY();
    }

    public RelativeLayout aaZ() {
        return this.bIq.aaZ();
    }

    public RelativeLayout aba() {
        return this.bIr.aba();
    }

    public RelativeLayout abb() {
        return this.bIr.aaV();
    }

    public RelativeLayout abc() {
        return this.bIs.abc();
    }

    public void ee(boolean z) {
        this.bIq.ee(z);
    }

    public void hl(int i) {
        this.bIq.hl(i);
    }
}
