package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* loaded from: classes.dex */
public class s extends BaseAdapter {
    private PersonInfoActivity ckP;
    private ac cmS;
    private t cmT;
    private ab cmU;
    private u cmV;
    private z cmW;
    private y cmX;
    private boolean mIsHost;

    public s(PersonInfoActivity personInfoActivity, boolean z) {
        this.ckP = personInfoActivity;
        this.mIsHost = z;
        this.cmS = new ac(this.ckP, this.mIsHost);
        this.cmT = new t(this.ckP, this.mIsHost);
        this.cmU = new ab(this.ckP, this.mIsHost);
        this.cmV = new u(this.ckP, this.mIsHost);
        this.cmW = new z(this.ckP, this.mIsHost);
        this.cmX = new y(this.ckP);
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
            this.cmS.ahA();
            return this.cmS.getRootView();
        } else if (itemViewType == 1) {
            this.cmT.ahA();
            return this.cmT.getRootView();
        } else if (itemViewType == 2) {
            this.cmU.ahA();
            return this.cmU.getRootView();
        } else if (itemViewType == 3) {
            this.cmV.ahA();
            return this.cmV.getRootView();
        } else if (itemViewType == 4) {
            this.cmW.ahA();
            return this.cmW.getRootView();
        } else if (itemViewType == 5) {
            this.cmX.ahA();
            return this.cmX.getRootView();
        } else {
            return null;
        }
    }

    public RelativeLayout ahm() {
        return this.cmU.ahm();
    }

    public void ahn() {
        this.cmU.ahn();
    }

    public RelativeLayout aho() {
        return this.cmT.ahz();
    }

    public RelativeLayout ahp() {
        return this.cmT.ahp();
    }

    public RelativeLayout ahq() {
        return this.cmX.ahq();
    }

    public TextView ahr() {
        return this.cmU.ahr();
    }

    public RelativeLayout ahs() {
        return this.cmT.ahs();
    }

    public RelativeLayout aht() {
        return this.cmU.aht();
    }

    public RelativeLayout ahu() {
        return this.cmU.ahu();
    }

    public RelativeLayout ahv() {
        return this.cmU.ahv();
    }

    public RelativeLayout ahw() {
        return this.cmV.ahw();
    }

    public RelativeLayout ahx() {
        return this.cmV.ahp();
    }

    public RelativeLayout ahy() {
        return this.cmW.ahy();
    }

    public void eU(boolean z) {
        this.cmU.eU(z);
    }

    public void jc(int i) {
        this.cmU.jc(i);
    }
}
