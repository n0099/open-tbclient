package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private PersonInfoActivity bEE;
    private z bEF;
    private q bEG;
    private r bEH;
    private t bEI;
    private x bEJ;
    private boolean mIsHost;

    public p(PersonInfoActivity personInfoActivity, boolean z) {
        this.bEE = personInfoActivity;
        this.mIsHost = z;
        this.bEF = new z(this.bEE, this.mIsHost);
        this.bEG = new q(this.bEE, this.mIsHost);
        this.bEH = new r(this.bEE, this.mIsHost);
        this.bEI = new t(this.bEE, this.mIsHost);
        this.bEJ = new x(this.bEE, this.mIsHost);
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
            this.bEF.Hu();
            return this.bEF.getRootView();
        } else if (itemViewType == 1) {
            this.bEG.Hu();
            return this.bEG.getRootView();
        } else if (itemViewType == 2) {
            this.bEH.Hu();
            return this.bEH.getRootView();
        } else if (itemViewType == 3) {
            this.bEI.Hu();
            return this.bEI.getRootView();
        } else if (itemViewType == 4) {
            this.bEJ.Hu();
            return this.bEJ.getRootView();
        } else {
            return null;
        }
    }

    public RelativeLayout aaw() {
        return this.bEH.aaw();
    }

    public RelativeLayout aax() {
        return this.bEG.aaG();
    }

    public RelativeLayout aay() {
        return this.bEG.aay();
    }

    public TextView aaz() {
        return this.bEH.aaz();
    }

    public RelativeLayout aaA() {
        return this.bEG.aaA();
    }

    public RelativeLayout aaB() {
        return this.bEH.aaB();
    }

    public RelativeLayout aaC() {
        return this.bEH.aaC();
    }

    public RelativeLayout aaD() {
        return this.bEI.aaD();
    }

    public RelativeLayout aaE() {
        return this.bEI.aay();
    }

    public RelativeLayout aaF() {
        return this.bEJ.aaF();
    }

    public void ey(boolean z) {
        this.bEH.ey(z);
    }

    public void hc(int i) {
        this.bEH.hc(i);
    }
}
