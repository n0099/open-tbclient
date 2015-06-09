package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private PersonInfoActivity bVg;
    private z bVh;
    private q bVi;
    private r bVj;
    private t bVk;
    private x bVl;
    private boolean mIsHost;

    public p(PersonInfoActivity personInfoActivity, boolean z) {
        this.bVg = personInfoActivity;
        this.mIsHost = z;
        this.bVh = new z(this.bVg, this.mIsHost);
        this.bVi = new q(this.bVg, this.mIsHost);
        this.bVj = new r(this.bVg, this.mIsHost);
        this.bVk = new t(this.bVg, this.mIsHost);
        this.bVl = new x(this.bVg, this.mIsHost);
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
            this.bVh.afm();
            return this.bVh.getRootView();
        } else if (itemViewType == 1) {
            this.bVi.afm();
            return this.bVi.getRootView();
        } else if (itemViewType == 2) {
            this.bVj.afm();
            return this.bVj.getRootView();
        } else if (itemViewType == 3) {
            this.bVk.afm();
            return this.bVk.getRootView();
        } else if (itemViewType == 4) {
            this.bVl.afm();
            return this.bVl.getRootView();
        } else {
            return null;
        }
    }

    public RelativeLayout afa() {
        return this.bVj.afa();
    }

    public void afb() {
        this.bVj.afb();
    }

    public RelativeLayout afc() {
        return this.bVi.afl();
    }

    public RelativeLayout afd() {
        return this.bVi.afd();
    }

    public TextView afe() {
        return this.bVj.afe();
    }

    public RelativeLayout aff() {
        return this.bVi.aff();
    }

    public RelativeLayout afg() {
        return this.bVj.afg();
    }

    public RelativeLayout afh() {
        return this.bVj.afh();
    }

    public RelativeLayout afi() {
        return this.bVk.afi();
    }

    public RelativeLayout afj() {
        return this.bVk.afd();
    }

    public RelativeLayout afk() {
        return this.bVl.afk();
    }

    public void er(boolean z) {
        this.bVj.er(z);
    }

    public void hV(int i) {
        this.bVj.hV(i);
    }
}
