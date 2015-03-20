package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private PersonInfoActivity bSi;
    private z bSj;
    private q bSk;
    private r bSl;
    private t bSm;
    private x bSn;
    private boolean mIsHost;

    public p(PersonInfoActivity personInfoActivity, boolean z) {
        this.bSi = personInfoActivity;
        this.mIsHost = z;
        this.bSj = new z(this.bSi, this.mIsHost);
        this.bSk = new q(this.bSi, this.mIsHost);
        this.bSl = new r(this.bSi, this.mIsHost);
        this.bSm = new t(this.bSi, this.mIsHost);
        this.bSn = new x(this.bSi, this.mIsHost);
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
            this.bSj.adR();
            return this.bSj.getRootView();
        } else if (itemViewType == 1) {
            this.bSk.adR();
            return this.bSk.getRootView();
        } else if (itemViewType == 2) {
            this.bSl.adR();
            return this.bSl.getRootView();
        } else if (itemViewType == 3) {
            this.bSm.adR();
            return this.bSm.getRootView();
        } else if (itemViewType == 4) {
            this.bSn.adR();
            return this.bSn.getRootView();
        } else {
            return null;
        }
    }

    public RelativeLayout adF() {
        return this.bSl.adF();
    }

    public void adG() {
        this.bSl.adG();
    }

    public RelativeLayout adH() {
        return this.bSk.adQ();
    }

    public RelativeLayout adI() {
        return this.bSk.adI();
    }

    public TextView adJ() {
        return this.bSl.adJ();
    }

    public RelativeLayout adK() {
        return this.bSk.adK();
    }

    public RelativeLayout adL() {
        return this.bSl.adL();
    }

    public RelativeLayout adM() {
        return this.bSl.adM();
    }

    public RelativeLayout adN() {
        return this.bSm.adN();
    }

    public RelativeLayout adO() {
        return this.bSm.adI();
    }

    public RelativeLayout adP() {
        return this.bSn.adP();
    }

    public void eh(boolean z) {
        this.bSl.eh(z);
    }

    public void hD(int i) {
        this.bSl.hD(i);
    }
}
