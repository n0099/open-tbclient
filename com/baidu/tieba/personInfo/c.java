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
public class c extends LinearLayout {
    private ViewEventCenter bfx;
    private boolean cgJ;
    private f efz;
    private bm eor;
    private com.baidu.tieba.person.god.view.a eos;
    private a eot;
    private int eou;
    private LinearLayout eov;
    private UserIconBox eow;
    private HeadImageView eox;
    private BdExpandImageView eoy;

    public c(f fVar, boolean z, ViewEventCenter viewEventCenter) {
        super(fVar.getActivity());
        this.eou = -1;
        this.efz = fVar;
        this.cgJ = z;
        this.bfx = viewEventCenter;
        this.eov = new LinearLayout(this.efz.getActivity());
        this.eow = new UserIconBox(this.efz.getActivity());
        this.eox = new HeadImageView(this.efz.getActivity());
        this.eoy = new BdExpandImageView(this.efz.getActivity(), null);
    }

    public void od(int i) {
        if (this.efz != null) {
            if (i == 2) {
                if (this.eos == null) {
                    this.eos = new com.baidu.tieba.person.god.view.a(this.efz, this.cgJ, this.bfx);
                }
                if (this.cgJ) {
                    this.efz.aMp().a(2, this.eos);
                    if (this.efz.eoV > 0) {
                        this.efz.aMp().m(true, 2);
                    }
                }
                this.eot = this.eos;
            } else {
                if (this.eor == null) {
                    this.eor = new bm(this.efz, this.cgJ);
                    setLayoutParams(new AbsListView.LayoutParams(-1, this.efz.getResources().getDimensionPixelOffset(u.e.ds618)));
                }
                this.eot = this.eor;
            }
            if (this.eou != i && this.eot != null) {
                removeAllViews();
                addView(this.eot.getRootView());
            }
            kX();
            this.eou = i;
        }
    }

    public LinearLayout getMyGiftIcon() {
        return (this.eot == null || this.eot.getMyGiftIcon() == null) ? this.eov : this.eot.getMyGiftIcon();
    }

    public View getAttentionView() {
        return (this.eot == null || this.eot.getAttentionView() == null) ? this.eov : this.eot.getAttentionView();
    }

    public UserIconBox getVipIcon() {
        return (this.eot == null || this.eot.getVipIcon() == null) ? this.eow : this.eot.getVipIcon();
    }

    public LinearLayout getYinjiWraper() {
        return (this.eot == null || this.eot.getYinjiWraper() == null) ? this.eov : this.eot.getYinjiWraper();
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public HeadImageView getHeadImage() {
        return (this.eot == null || this.eot.getHeadImage() == null) ? this.eox : this.eot.getHeadImage();
    }

    public a getHeadView() {
        if (this.eot == null) {
            return null;
        }
        return this.eot.getHeadView();
    }

    public bm getNormalHeadView() {
        return this.eor;
    }

    public void US() {
        if (this.eot != null) {
            this.eot.US();
        }
    }

    public UserIconBox getUserIcon() {
        return (this.eot == null || this.eot.getUserIcon() == null) ? this.eow : this.eot.getUserIcon();
    }

    public void aLG() {
        if (this.eot != null) {
            this.eot.aLG();
        }
    }

    public void kX() {
        if (this.eot != null) {
            this.eot.kX();
        }
    }

    public void Ri() {
        if (this.eot != null) {
            this.eot.Ri();
        }
    }

    public void setBackBitmap(UserData userData) {
        if (this.eot != null) {
            this.eot.setBackBitmap(userData);
        }
    }

    public void j(float f) {
        if (this.eot != null) {
            this.eot.j(f);
        }
    }

    public void jn() {
        if (this.eot != null) {
            this.eot.jn();
        }
    }

    public void setGiftIcon(boolean z) {
        if (this.eot != null) {
            this.eot.setGiftIcon(z);
        }
    }

    public BdExpandImageView getExpandImg() {
        return this.eot == null ? this.eoy : this.eot.getExpandImg();
    }
}
