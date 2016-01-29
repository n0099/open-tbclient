package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private ViewEventCenter aWA;
    private boolean bDs;
    private f cZH;
    private bc dhE;
    private com.baidu.tieba.person.god.view.a dhF;
    private a dhG;
    private int dhH;
    private LinearLayout dhI;
    private UserIconBox dhJ;
    private HeadImageView dhK;

    public c(f fVar, boolean z, ViewEventCenter viewEventCenter) {
        super(fVar.getActivity());
        this.dhH = -1;
        this.cZH = fVar;
        this.bDs = z;
        this.aWA = viewEventCenter;
        this.dhI = new LinearLayout(this.cZH.getActivity());
        this.dhJ = new UserIconBox(this.cZH.getActivity());
        this.dhK = new HeadImageView(this.cZH.getActivity());
    }

    public void lC(int i) {
        if (this.cZH != null) {
            if (i == 2) {
                if (this.dhF == null) {
                    this.dhF = new com.baidu.tieba.person.god.view.a(this.cZH, this.bDs, this.aWA);
                }
                if (this.bDs) {
                    this.cZH.avq().a(2, this.dhF);
                    if (this.cZH.dii > 0) {
                        this.cZH.avq().f(true, 2);
                    }
                }
                this.dhG = this.dhF;
            } else {
                if (this.dhE == null) {
                    this.dhE = new bc(this.cZH, this.bDs);
                    setLayoutParams(new AbsListView.LayoutParams(-1, this.cZH.getResources().getDimensionPixelOffset(t.e.ds618)));
                }
                this.dhG = this.dhE;
            }
            if (this.dhH != i && this.dhG != null) {
                removeAllViews();
                addView(this.dhG.getRootView());
            }
            oO();
            this.dhH = i;
        }
    }

    public LinearLayout getMyGiftIcon() {
        return (this.dhG == null || this.dhG.getMyGiftIcon() == null) ? this.dhI : this.dhG.getMyGiftIcon();
    }

    public View getAttentionView() {
        return (this.dhG == null || this.dhG.getAttentionView() == null) ? this.dhI : this.dhG.getAttentionView();
    }

    public UserIconBox getVipIcon() {
        return (this.dhG == null || this.dhG.getVipIcon() == null) ? this.dhJ : this.dhG.getVipIcon();
    }

    public LinearLayout getYinjiWraper() {
        return (this.dhG == null || this.dhG.getYinjiWraper() == null) ? this.dhI : this.dhG.getYinjiWraper();
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public HeadImageView getHeadImage() {
        return (this.dhG == null || this.dhG.getHeadImage() == null) ? this.dhK : this.dhG.getHeadImage();
    }

    public a getHeadView() {
        if (this.dhG == null) {
            return null;
        }
        return this.dhG.getHeadView();
    }

    public void Oz() {
        if (this.dhG != null) {
            this.dhG.Oz();
        }
    }

    public UserIconBox getUserIcon() {
        return (this.dhG == null || this.dhG.getUserIcon() == null) ? this.dhJ : this.dhG.getUserIcon();
    }

    public void auL() {
        if (this.dhG != null) {
            this.dhG.auL();
        }
    }

    public void oO() {
        if (this.dhG != null) {
            this.dhG.oO();
        }
    }

    public void akY() {
        if (this.dhG != null) {
            this.dhG.akY();
        }
    }

    public void setBackBitmap(UserData userData) {
        if (this.dhG != null) {
            this.dhG.setBackBitmap(userData);
        }
    }

    public void l(float f) {
        if (this.dhG != null) {
            this.dhG.l(f);
        }
    }

    public void nf() {
        if (this.dhG != null) {
            this.dhG.nf();
        }
    }

    public void setGiftIcon(boolean z) {
        if (this.dhG != null) {
            this.dhG.setGiftIcon(z);
        }
    }
}
