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
    private boolean bIP;
    private ViewEventCenter bbj;
    private bc dCf;
    private com.baidu.tieba.person.god.view.a dCg;
    private a dCh;
    private int dCi;
    private LinearLayout dCj;
    private UserIconBox dCk;
    private HeadImageView dCl;
    private BdExpandImageView dCm;
    private f duk;

    public c(f fVar, boolean z, ViewEventCenter viewEventCenter) {
        super(fVar.getActivity());
        this.dCi = -1;
        this.duk = fVar;
        this.bIP = z;
        this.bbj = viewEventCenter;
        this.dCj = new LinearLayout(this.duk.getActivity());
        this.dCk = new UserIconBox(this.duk.getActivity());
        this.dCl = new HeadImageView(this.duk.getActivity());
        this.dCm = new BdExpandImageView(this.duk.getActivity(), null);
    }

    public void mL(int i) {
        if (this.duk != null) {
            if (i == 2) {
                if (this.dCg == null) {
                    this.dCg = new com.baidu.tieba.person.god.view.a(this.duk, this.bIP, this.bbj);
                }
                if (this.bIP) {
                    this.duk.aCW().a(2, this.dCg);
                    if (this.duk.dCK > 0) {
                        this.duk.aCW().h(true, 2);
                    }
                }
                this.dCh = this.dCg;
            } else {
                if (this.dCf == null) {
                    this.dCf = new bc(this.duk, this.bIP);
                    setLayoutParams(new AbsListView.LayoutParams(-1, this.duk.getResources().getDimensionPixelOffset(t.e.ds618)));
                }
                this.dCh = this.dCf;
            }
            if (this.dCi != i && this.dCh != null) {
                removeAllViews();
                addView(this.dCh.getRootView());
            }
            oH();
            this.dCi = i;
        }
    }

    public LinearLayout getMyGiftIcon() {
        return (this.dCh == null || this.dCh.getMyGiftIcon() == null) ? this.dCj : this.dCh.getMyGiftIcon();
    }

    public View getAttentionView() {
        return (this.dCh == null || this.dCh.getAttentionView() == null) ? this.dCj : this.dCh.getAttentionView();
    }

    public UserIconBox getVipIcon() {
        return (this.dCh == null || this.dCh.getVipIcon() == null) ? this.dCk : this.dCh.getVipIcon();
    }

    public LinearLayout getYinjiWraper() {
        return (this.dCh == null || this.dCh.getYinjiWraper() == null) ? this.dCj : this.dCh.getYinjiWraper();
    }

    @Override // android.view.View
    public View getRootView() {
        return this;
    }

    public HeadImageView getHeadImage() {
        return (this.dCh == null || this.dCh.getHeadImage() == null) ? this.dCl : this.dCh.getHeadImage();
    }

    public a getHeadView() {
        if (this.dCh == null) {
            return null;
        }
        return this.dCh.getHeadView();
    }

    public bc getNormalHeadView() {
        return this.dCf;
    }

    public void Qo() {
        if (this.dCh != null) {
            this.dCh.Qo();
        }
    }

    public UserIconBox getUserIcon() {
        return (this.dCh == null || this.dCh.getUserIcon() == null) ? this.dCk : this.dCh.getUserIcon();
    }

    public void aCr() {
        if (this.dCh != null) {
            this.dCh.aCr();
        }
    }

    public void oH() {
        if (this.dCh != null) {
            this.dCh.oH();
        }
    }

    public void arP() {
        if (this.dCh != null) {
            this.dCh.arP();
        }
    }

    public void setBackBitmap(UserData userData) {
        if (this.dCh != null) {
            this.dCh.setBackBitmap(userData);
        }
    }

    public void l(float f) {
        if (this.dCh != null) {
            this.dCh.l(f);
        }
    }

    public void mW() {
        if (this.dCh != null) {
            this.dCh.mW();
        }
    }

    public void setGiftIcon(boolean z) {
        if (this.dCh != null) {
            this.dCh.setGiftIcon(z);
        }
    }

    public BdExpandImageView getExpandImg() {
        return this.dCh == null ? this.dCm : this.dCh.getExpandImg();
    }
}
