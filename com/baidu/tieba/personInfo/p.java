package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private PersonInfoActivity bVf;
    private z bVg;
    private q bVh;
    private r bVi;
    private t bVj;
    private x bVk;
    private boolean mIsHost;

    public p(PersonInfoActivity personInfoActivity, boolean z) {
        this.bVf = personInfoActivity;
        this.mIsHost = z;
        this.bVg = new z(this.bVf, this.mIsHost);
        this.bVh = new q(this.bVf, this.mIsHost);
        this.bVi = new r(this.bVf, this.mIsHost);
        this.bVj = new t(this.bVf, this.mIsHost);
        this.bVk = new x(this.bVf, this.mIsHost);
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
            this.bVg.afl();
            return this.bVg.getRootView();
        } else if (itemViewType == 1) {
            this.bVh.afl();
            return this.bVh.getRootView();
        } else if (itemViewType == 2) {
            this.bVi.afl();
            return this.bVi.getRootView();
        } else if (itemViewType == 3) {
            this.bVj.afl();
            return this.bVj.getRootView();
        } else if (itemViewType == 4) {
            this.bVk.afl();
            return this.bVk.getRootView();
        } else {
            return null;
        }
    }

    public RelativeLayout aeZ() {
        return this.bVi.aeZ();
    }

    public void afa() {
        this.bVi.afa();
    }

    public RelativeLayout afb() {
        return this.bVh.afk();
    }

    public RelativeLayout afc() {
        return this.bVh.afc();
    }

    public TextView afd() {
        return this.bVi.afd();
    }

    public RelativeLayout afe() {
        return this.bVh.afe();
    }

    public RelativeLayout aff() {
        return this.bVi.aff();
    }

    public RelativeLayout afg() {
        return this.bVi.afg();
    }

    public RelativeLayout afh() {
        return this.bVj.afh();
    }

    public RelativeLayout afi() {
        return this.bVj.afc();
    }

    public RelativeLayout afj() {
        return this.bVk.afj();
    }

    public void er(boolean z) {
        this.bVi.er(z);
    }

    public void hV(int i) {
        this.bVi.hV(i);
    }
}
