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
    private AntiData che;
    private PersonInfoActivity csa;
    private ae cuf;
    private u cug;
    private ad cuh;
    private v cui;
    private ab cuj;
    private aa cuk;
    private boolean mIsHost;

    public t(PersonInfoActivity personInfoActivity, boolean z) {
        this.csa = personInfoActivity;
        this.mIsHost = z;
        this.cuf = new ae(this.csa, this.mIsHost);
        this.cug = new u(this.csa, this.mIsHost);
        this.cuh = new ad(this.csa, this.mIsHost);
        this.cui = new v(this.csa, this.mIsHost);
        this.cuj = new ab(this.csa, this.mIsHost);
        this.cuk = new aa(this.csa);
    }

    public void b(AntiData antiData) {
        this.che = antiData;
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
            this.cuf.ake();
            return this.cuf.getRootView();
        } else if (itemViewType == 1) {
            this.cug.ake();
            return this.cug.getRootView();
        } else if (itemViewType == 2) {
            this.cuh.ake();
            return this.cuh.getRootView();
        } else if (itemViewType == 3) {
            this.cui.ake();
            return this.cui.getRootView();
        } else if (itemViewType == 4) {
            this.cuj.c(this.che);
            return this.cuj.getRootView();
        } else if (itemViewType == 5) {
            this.cuk.ake();
            return this.cuk.getRootView();
        } else {
            return null;
        }
    }

    public RelativeLayout ajQ() {
        return this.cuh.ajQ();
    }

    public void ajR() {
        this.cuh.ajR();
    }

    public RelativeLayout ajS() {
        return this.cug.akd();
    }

    public RelativeLayout ajT() {
        return this.cug.ajT();
    }

    public RelativeLayout ajU() {
        return this.cuk.ajU();
    }

    public TextView ajV() {
        return this.cuh.ajV();
    }

    public RelativeLayout ajW() {
        return this.cug.ajW();
    }

    public RelativeLayout ajX() {
        return this.cuh.ajX();
    }

    public RelativeLayout ajY() {
        return this.cuh.ajY();
    }

    public RelativeLayout ajZ() {
        return this.cuh.ajZ();
    }

    public RelativeLayout aka() {
        return this.cui.aka();
    }

    public RelativeLayout akb() {
        return this.cui.ajT();
    }

    public RelativeLayout akc() {
        return this.cuj.akc();
    }

    public void fd(boolean z) {
        this.cuh.fd(z);
    }

    public void jA(int i) {
        this.cuh.jA(i);
    }
}
