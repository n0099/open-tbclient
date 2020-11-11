package com.baidu.tieba.image;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import tbclient.VideoInfo;
/* loaded from: classes21.dex */
public class a implements ImagePagerAdapter.a {
    private static int kwV = 7;
    private TbPageContext<?> eIc;
    private boolean fiO;
    private DragImageView.d fkz;
    private AdvertAppInfo kwX;
    private boolean kwY;
    private b kwZ;
    private c kxa;
    private AdCard kxc;
    private VideoInfo kxd;
    private int kwW = 0;
    private boolean kxb = false;
    private final View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.kwX != null && a.this.kxc != null) {
                if (a.this.kwZ == null || !a.this.kwZ.kxj || a.this.kwZ.cXj() != view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(a.this.kwX));
                    if (view.getId() == R.id.image_ad_button) {
                        a.this.cV(view);
                        a.this.kxa.Nv("button");
                    } else if (view.getId() == R.id.bottom_container) {
                        a.this.cXd();
                        a.this.kxa.Nv("title");
                    } else {
                        a.this.cXc();
                        a.this.kxa.Nv(a.this.kwX.bkv() ? "image" : "video");
                    }
                }
            }
        }
    };

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.fiO = false;
        this.kwY = false;
        this.fiO = z;
        this.kwY = z2;
        this.eIc = tbPageContext;
        this.kxa = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.kwX = advertAppInfo;
        this.kwX.page = "PIC_PAGE";
        this.kxa.c(this.kwX);
        this.kwW = i;
        if (this.kwX.legoCard instanceof AdCard) {
            this.kxc = (AdCard) this.kwX.legoCard;
            this.kxd = this.kxc.videoInfo;
        }
    }

    public boolean cWZ() {
        if (!this.kwY || this.kwX == null) {
            return false;
        }
        return this.kwX.bkt() || this.kwX.bks();
    }

    public String getAdId() {
        if (this.kwX != null) {
            return this.kwX.eyO;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View l(ViewGroup viewGroup, int i) {
        if (DM(i)) {
            this.kwZ = new b(viewGroup, this.eIc);
            this.kwZ.setDragToExitListener(this.fkz);
            cXa();
            viewGroup.addView(this.kwZ.getView());
            return this.kwZ.getView();
        }
        return null;
    }

    private boolean DM(int i) {
        return cWZ() && this.kwW != 0 && i == this.kwW;
    }

    private void cXa() {
        if (this.kwX != null && this.kwX.eyX != null) {
            cXb();
            this.kwZ.a(this.kwX, this.kxc);
            if (!TextUtils.isEmpty(this.kwX.eyX.userName)) {
                this.kwZ.kxh.setText(this.kwX.eyX.userName);
                if (!TextUtils.isEmpty(this.kwX.eyX.tagName)) {
                    this.kwZ.kxi.setText(this.kwX.eyX.tagName);
                } else {
                    this.kwZ.kxi.setText(this.eIc.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.kwX.eyX.ezg)) {
                this.kwZ.kxg.setText(this.kwX.eyX.ezg);
            }
            this.kwZ.kxn.setVisibility(this.kwX.bku() ? 0 : 8);
            this.kwZ.F(this.mClickListener);
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fkz = dVar;
    }

    private void cXb() {
        String str;
        this.kwZ.cXj().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z) {
                    a.this.kwZ.cXk();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        if (this.kwX.bku() && this.kxd != null) {
            str = this.kxd.thumbnail_url;
        } else {
            str = this.kwX.eyX.ezi;
        }
        this.kwZ.cXj().a(str, this.fiO ? 30 : 31, 720, 720, false);
        if (this.kwZ.cXi() != null) {
            this.kwZ.cXi().setIsCdn(this.fiO);
            this.kwZ.cXi().setUrl(str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXc() {
        if (this.kwX.bkv()) {
            cXe();
        } else {
            cXf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXd() {
        cXe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(View view) {
        cXe();
    }

    private void cXe() {
        if (s.aY(this.eIc.getPageActivity(), this.kxc.getScheme() != null ? this.kxc.getScheme() : this.kwX.eyQ) == 1) {
            this.kxa.Nw(this.kwX.bkv() ? "image" : "video");
        }
    }

    private void cXf() {
        if (this.kwX != null && this.kxc != null && this.kxd != null && s.a(this.eIc.getPageActivity(), this.kxc.getScheme(), this.kwX) == 1) {
            this.kxa.Nw(this.kwX.bkv() ? "image" : "video");
        }
    }

    public void cXg() {
        if (!this.kxb) {
            this.kxb = true;
            this.kxa.amU();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(this.kwX));
        }
    }

    public void onDestroy() {
        if (this.kwZ != null) {
            this.kwZ.onDestroy();
        }
    }

    public void onCreate() {
        if (this.kwZ != null) {
            this.kwZ.onCreate();
        }
    }
}
