package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends LinearLayout {
    private ViewEventCenter bgJ;
    private boolean ciS;
    private bk eAh;
    private com.baidu.tieba.person.god.view.a eAi;
    private a eAj;
    private int eAk;
    private LinearLayout eAl;
    private UserIconBox eAm;
    private HeadImageView eAn;
    private BdExpandImageView eAo;
    private h epz;

    public e(h hVar, boolean z, ViewEventCenter viewEventCenter) {
        super(hVar.getActivity());
        this.eAk = -1;
        this.epz = hVar;
        this.ciS = z;
        this.bgJ = viewEventCenter;
        this.eAl = new LinearLayout(this.epz.getActivity());
        this.eAm = new UserIconBox(this.epz.getActivity());
        this.eAn = new HeadImageView(this.epz.getActivity());
        this.eAo = new BdExpandImageView(this.epz.getActivity(), null);
    }

    public void ot(int i) {
        if (this.epz != null) {
            if (i == 2) {
                if (this.eAi == null) {
                    this.eAi = new com.baidu.tieba.person.god.view.a(this.epz, this.ciS, this.bgJ, 2);
                }
                if (this.ciS) {
                    this.epz.aPu().a(2, this.eAi);
                    if (this.epz.eAL > 0) {
                        this.epz.aPu().n(true, 2);
                    }
                }
                this.eAj = this.eAi;
            } else if (i == 3) {
                if (this.eAi == null) {
                    this.eAi = new com.baidu.tieba.person.god.view.a(this.epz, this.ciS, this.bgJ, 3);
                }
                if (this.ciS) {
                    this.epz.aPu().a(2, this.eAi);
                    if (this.epz.eAL > 0) {
                        this.epz.aPu().n(true, 2);
                    }
                }
                this.eAj = this.eAi;
            } else {
                if (this.eAh == null) {
                    this.eAh = new bk(this.epz, this.ciS);
                    setLayoutParams(new AbsListView.LayoutParams(-1, this.epz.getResources().getDimensionPixelOffset(u.e.ds618)));
                }
                this.eAj = this.eAh;
            }
            if (this.eAk != i && this.eAj != null) {
                removeAllViews();
                addView(this.eAj.getRootView());
            }
            kT();
            this.eAk = i;
        }
    }

    public LinearLayout getMyGiftIcon() {
        return (this.eAj == null || this.eAj.getMyGiftIcon() == null) ? this.eAl : this.eAj.getMyGiftIcon();
    }

    public View getAttentionView() {
        return (this.eAj == null || this.eAj.getAttentionView() == null) ? this.eAl : this.eAj.getAttentionView();
    }

    public UserIconBox getVipIcon() {
        return (this.eAj == null || this.eAj.getVipIcon() == null) ? this.eAm : this.eAj.getVipIcon();
    }

    public LinearLayout getYinjiWraper() {
        return (this.eAj == null || this.eAj.getYinjiWraper() == null) ? this.eAl : this.eAj.getYinjiWraper();
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public HeadImageView getHeadImage() {
        return (this.eAj == null || this.eAj.getHeadImage() == null) ? this.eAn : this.eAj.getHeadImage();
    }

    public a getHeadView() {
        if (this.eAj == null) {
            return null;
        }
        return this.eAj.getHeadView();
    }

    public bk getNormalHeadView() {
        return this.eAh;
    }

    public void aap() {
        if (this.eAj != null) {
            this.eAj.aap();
        }
    }

    public UserIconBox getUserIcon() {
        return (this.eAj == null || this.eAj.getUserIcon() == null) ? this.eAm : this.eAj.getUserIcon();
    }

    public void aOj() {
        if (this.eAj != null) {
            this.eAj.aOj();
        }
    }

    public void kT() {
        if (this.eAj != null) {
            this.eAj.kT();
        }
    }

    public void RP() {
        if (this.eAj != null) {
            this.eAj.RP();
        }
    }

    public void setBackBitmap(UserData userData) {
        if (this.eAj != null) {
            this.eAj.setBackBitmap(userData);
        }
    }

    public void t(float f) {
        if (this.eAj != null) {
            this.eAj.t(f);
        }
    }

    public void jm() {
        if (this.eAj != null) {
            this.eAj.jm();
        }
    }

    public void setGiftIcon(boolean z) {
        if (this.eAj != null) {
            this.eAj.setGiftIcon(z);
        }
    }

    public BdExpandImageView getExpandImg() {
        return this.eAj == null ? this.eAo : this.eAj.getExpandImg();
    }
}
