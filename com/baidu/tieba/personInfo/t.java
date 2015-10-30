package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
public class t extends BaseAdapter {
    private AntiData cgz;
    private PersonInfoActivity cqE;
    private ae csJ;
    private u csK;
    private ad csL;
    private v csM;
    private ab csN;
    private aa csO;
    private boolean mIsHost;

    public t(PersonInfoActivity personInfoActivity, boolean z) {
        this.cqE = personInfoActivity;
        this.mIsHost = z;
        this.csJ = new ae(this.cqE, this.mIsHost);
        this.csK = new u(this.cqE, this.mIsHost);
        this.csL = new ad(this.cqE, this.mIsHost);
        this.csM = new v(this.cqE, this.mIsHost);
        this.csN = new ab(this.cqE, this.mIsHost);
        this.csO = new aa(this.cqE);
    }

    public void b(AntiData antiData) {
        this.cgz = antiData;
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
            this.csJ.ajy();
            return this.csJ.getRootView();
        } else if (itemViewType == 1) {
            this.csK.ajy();
            return this.csK.getRootView();
        } else if (itemViewType == 2) {
            this.csL.ajy();
            return this.csL.getRootView();
        } else if (itemViewType == 3) {
            this.csM.ajy();
            return this.csM.getRootView();
        } else if (itemViewType == 4) {
            this.csN.c(this.cgz);
            return this.csN.getRootView();
        } else if (itemViewType == 5) {
            this.csO.ajy();
            return this.csO.getRootView();
        } else {
            return null;
        }
    }

    public RelativeLayout ajk() {
        return this.csL.ajk();
    }

    public void ajl() {
        this.csL.ajl();
    }

    public RelativeLayout ajm() {
        return this.csK.ajx();
    }

    public RelativeLayout ajn() {
        return this.csK.ajn();
    }

    public RelativeLayout ajo() {
        return this.csO.ajo();
    }

    public TextView ajp() {
        return this.csL.ajp();
    }

    public RelativeLayout ajq() {
        return this.csK.ajq();
    }

    public RelativeLayout ajr() {
        return this.csL.ajr();
    }

    public RelativeLayout ajs() {
        return this.csL.ajs();
    }

    public RelativeLayout ajt() {
        return this.csL.ajt();
    }

    public RelativeLayout aju() {
        return this.csM.aju();
    }

    public RelativeLayout ajv() {
        return this.csM.ajn();
    }

    public RelativeLayout ajw() {
        return this.csN.ajw();
    }

    public void fa(boolean z) {
        this.csL.fa(z);
    }

    public void jm(int i) {
        this.csL.jm(i);
    }
}
