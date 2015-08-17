package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* loaded from: classes.dex */
public class s extends BaseAdapter {
    private PersonInfoActivity cjU;
    private ac clP;
    private t clQ;
    private ab clR;
    private u clS;
    private z clT;
    private y clU;
    private boolean mIsHost;

    public s(PersonInfoActivity personInfoActivity, boolean z) {
        this.cjU = personInfoActivity;
        this.mIsHost = z;
        this.clP = new ac(this.cjU, this.mIsHost);
        this.clQ = new t(this.cjU, this.mIsHost);
        this.clR = new ab(this.cjU, this.mIsHost);
        this.clS = new u(this.cjU, this.mIsHost);
        this.clT = new z(this.cjU, this.mIsHost);
        this.clU = new y(this.cjU);
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
            this.clP.ahi();
            return this.clP.getRootView();
        } else if (itemViewType == 1) {
            this.clQ.ahi();
            return this.clQ.getRootView();
        } else if (itemViewType == 2) {
            this.clR.ahi();
            return this.clR.getRootView();
        } else if (itemViewType == 3) {
            this.clS.ahi();
            return this.clS.getRootView();
        } else if (itemViewType == 4) {
            this.clT.ahi();
            return this.clT.getRootView();
        } else if (itemViewType == 5) {
            this.clU.ahi();
            return this.clU.getRootView();
        } else {
            return null;
        }
    }

    public RelativeLayout agU() {
        return this.clR.agU();
    }

    public void agV() {
        this.clR.agV();
    }

    public RelativeLayout agW() {
        return this.clQ.ahh();
    }

    public RelativeLayout agX() {
        return this.clQ.agX();
    }

    public RelativeLayout agY() {
        return this.clU.agY();
    }

    public TextView agZ() {
        return this.clR.agZ();
    }

    public RelativeLayout aha() {
        return this.clQ.aha();
    }

    public RelativeLayout ahb() {
        return this.clR.ahb();
    }

    public RelativeLayout ahc() {
        return this.clR.ahc();
    }

    public RelativeLayout ahd() {
        return this.clR.ahd();
    }

    public RelativeLayout ahe() {
        return this.clS.ahe();
    }

    public RelativeLayout ahf() {
        return this.clS.agX();
    }

    public RelativeLayout ahg() {
        return this.clT.ahg();
    }

    public void eJ(boolean z) {
        this.clR.eJ(z);
    }

    public void iP(int i) {
        this.clR.iP(i);
    }
}
