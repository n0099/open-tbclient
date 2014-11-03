package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private PersonInfoActivity bES;
    private z bET;
    private q bEU;
    private r bEV;
    private t bEW;
    private x bEX;
    private boolean mIsHost;

    public p(PersonInfoActivity personInfoActivity, boolean z) {
        this.bES = personInfoActivity;
        this.mIsHost = z;
        this.bET = new z(this.bES, this.mIsHost);
        this.bEU = new q(this.bES, this.mIsHost);
        this.bEV = new r(this.bES, this.mIsHost);
        this.bEW = new t(this.bES, this.mIsHost);
        this.bEX = new x(this.bES, this.mIsHost);
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
            this.bET.aaJ();
            return this.bET.getRootView();
        } else if (itemViewType == 1) {
            this.bEU.aaJ();
            return this.bEU.getRootView();
        } else if (itemViewType == 2) {
            this.bEV.aaJ();
            return this.bEV.getRootView();
        } else if (itemViewType == 3) {
            this.bEW.aaJ();
            return this.bEW.getRootView();
        } else if (itemViewType == 4) {
            this.bEX.aaJ();
            return this.bEX.getRootView();
        } else {
            return null;
        }
    }

    public RelativeLayout aay() {
        return this.bEV.aay();
    }

    public RelativeLayout aaz() {
        return this.bEU.aaI();
    }

    public RelativeLayout aaA() {
        return this.bEU.aaA();
    }

    public TextView aaB() {
        return this.bEV.aaB();
    }

    public RelativeLayout aaC() {
        return this.bEU.aaC();
    }

    public RelativeLayout aaD() {
        return this.bEV.aaD();
    }

    public RelativeLayout aaE() {
        return this.bEV.aaE();
    }

    public RelativeLayout aaF() {
        return this.bEW.aaF();
    }

    public RelativeLayout aaG() {
        return this.bEW.aaA();
    }

    public RelativeLayout aaH() {
        return this.bEX.aaH();
    }

    public void ey(boolean z) {
        this.bEV.ey(z);
    }

    public void hc(int i) {
        this.bEV.hc(i);
    }
}
