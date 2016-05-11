package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private ViewEventCenter aXs;
    private boolean bIW;
    private bd dFn;
    private com.baidu.tieba.person.god.view.a dFo;
    private a dFp;
    private int dFq;
    private LinearLayout dFr;
    private UserIconBox dFs;
    private HeadImageView dFt;
    private BdExpandImageView dFu;
    private f dxd;

    public c(f fVar, boolean z, ViewEventCenter viewEventCenter) {
        super(fVar.getActivity());
        this.dFq = -1;
        this.dxd = fVar;
        this.bIW = z;
        this.aXs = viewEventCenter;
        this.dFr = new LinearLayout(this.dxd.getActivity());
        this.dFs = new UserIconBox(this.dxd.getActivity());
        this.dFt = new HeadImageView(this.dxd.getActivity());
        this.dFu = new BdExpandImageView(this.dxd.getActivity(), null);
    }

    public void mC(int i) {
        if (this.dxd != null) {
            if (i == 2) {
                if (this.dFo == null) {
                    this.dFo = new com.baidu.tieba.person.god.view.a(this.dxd, this.bIW, this.aXs);
                }
                if (this.bIW) {
                    this.dxd.aDr().a(2, this.dFo);
                    if (this.dxd.dFR > 0) {
                        this.dxd.aDr().j(true, 2);
                    }
                }
                this.dFp = this.dFo;
            } else {
                if (this.dFn == null) {
                    this.dFn = new bd(this.dxd, this.bIW);
                    setLayoutParams(new AbsListView.LayoutParams(-1, this.dxd.getResources().getDimensionPixelOffset(t.e.ds618)));
                }
                this.dFp = this.dFn;
            }
            if (this.dFq != i && this.dFp != null) {
                removeAllViews();
                addView(this.dFp.getRootView());
            }
            kU();
            this.dFq = i;
        }
    }

    public LinearLayout getMyGiftIcon() {
        return (this.dFp == null || this.dFp.getMyGiftIcon() == null) ? this.dFr : this.dFp.getMyGiftIcon();
    }

    public View getAttentionView() {
        return (this.dFp == null || this.dFp.getAttentionView() == null) ? this.dFr : this.dFp.getAttentionView();
    }

    public UserIconBox getVipIcon() {
        return (this.dFp == null || this.dFp.getVipIcon() == null) ? this.dFs : this.dFp.getVipIcon();
    }

    public LinearLayout getYinjiWraper() {
        return (this.dFp == null || this.dFp.getYinjiWraper() == null) ? this.dFr : this.dFp.getYinjiWraper();
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public HeadImageView getHeadImage() {
        return (this.dFp == null || this.dFp.getHeadImage() == null) ? this.dFt : this.dFp.getHeadImage();
    }

    public a getHeadView() {
        if (this.dFp == null) {
            return null;
        }
        return this.dFp.getHeadView();
    }

    public bd getNormalHeadView() {
        return this.dFn;
    }

    public void Pl() {
        if (this.dFp != null) {
            this.dFp.Pl();
        }
    }

    public UserIconBox getUserIcon() {
        return (this.dFp == null || this.dFp.getUserIcon() == null) ? this.dFs : this.dFp.getUserIcon();
    }

    public void aCJ() {
        if (this.dFp != null) {
            this.dFp.aCJ();
        }
    }

    public void kU() {
        if (this.dFp != null) {
            this.dFp.kU();
        }
    }

    public void aBX() {
        if (this.dFp != null) {
            this.dFp.aBX();
        }
    }

    public void setBackBitmap(UserData userData) {
        if (this.dFp != null) {
            this.dFp.setBackBitmap(userData);
        }
    }

    public void j(float f) {
        if (this.dFp != null) {
            this.dFp.j(f);
        }
    }

    public void jk() {
        if (this.dFp != null) {
            this.dFp.jk();
        }
    }

    public void setGiftIcon(boolean z) {
        if (this.dFp != null) {
            this.dFp.setGiftIcon(z);
        }
    }

    public BdExpandImageView getExpandImg() {
        return this.dFp == null ? this.dFu : this.dFp.getExpandImg();
    }
}
