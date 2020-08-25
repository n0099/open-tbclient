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
/* loaded from: classes15.dex */
public class a implements ImagePagerAdapter.a {
    private static int jGU = 7;
    private boolean eGg;
    private DragImageView.d eHS;
    private TbPageContext<?> efn;
    private AdvertAppInfo jGW;
    private boolean jGX;
    private b jGY;
    private c jGZ;
    private AdCard jHb;
    private VideoInfo jHc;
    private int jGV = 0;
    private boolean jHa = false;
    private final View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jGW != null && a.this.jHb != null) {
                if (a.this.jGY == null || !a.this.jGY.jHi || a.this.jGY.cKm() != view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(a.this.jGW));
                    if (view.getId() == R.id.image_ad_button) {
                        a.this.cz(view);
                        a.this.jGZ.Lo("button");
                    } else if (view.getId() == R.id.bottom_container) {
                        a.this.cKg();
                        a.this.jGZ.Lo("title");
                    } else {
                        a.this.cKf();
                        a.this.jGZ.Lo(a.this.jGW.bcz() ? "image" : "video");
                    }
                }
            }
        }
    };

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.eGg = false;
        this.jGX = false;
        this.eGg = z;
        this.jGX = z2;
        this.efn = tbPageContext;
        this.jGZ = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.jGW = advertAppInfo;
        this.jGW.page = "PIC_PAGE";
        this.jGZ.c(this.jGW);
        this.jGV = i;
        if (this.jGW.legoCard instanceof AdCard) {
            this.jHb = (AdCard) this.jGW.legoCard;
            this.jHc = this.jHb.videoInfo;
        }
    }

    public boolean cKc() {
        if (!this.jGX || this.jGW == null) {
            return false;
        }
        return this.jGW.bcx() || this.jGW.bcw();
    }

    public String getAdId() {
        if (this.jGW != null) {
            return this.jGW.dWf;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View j(ViewGroup viewGroup, int i) {
        if (BZ(i)) {
            this.jGY = new b(viewGroup, this.efn);
            this.jGY.setDragToExitListener(this.eHS);
            cKd();
            viewGroup.addView(this.jGY.getView());
            return this.jGY.getView();
        }
        return null;
    }

    private boolean BZ(int i) {
        return cKc() && this.jGV != 0 && i == this.jGV;
    }

    private void cKd() {
        if (this.jGW != null && this.jGW.dWo != null) {
            cKe();
            this.jGY.a(this.jGW, this.jHb);
            if (!TextUtils.isEmpty(this.jGW.dWo.userName)) {
                this.jGY.jHg.setText(this.jGW.dWo.userName);
                if (!TextUtils.isEmpty(this.jGW.dWo.tagName)) {
                    this.jGY.jHh.setText(this.jGW.dWo.tagName);
                } else {
                    this.jGY.jHh.setText(this.efn.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.jGW.dWo.dWx)) {
                this.jGY.jHf.setText(this.jGW.dWo.dWx);
            }
            this.jGY.jHm.setVisibility(this.jGW.bcy() ? 0 : 8);
            this.jGY.E(this.mClickListener);
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eHS = dVar;
    }

    private void cKe() {
        String str;
        this.jGY.cKm().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z) {
                    a.this.jGY.cKn();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        if (this.jGW.bcy() && this.jHc != null) {
            str = this.jHc.thumbnail_url;
        } else {
            str = this.jGW.dWo.dWz;
        }
        this.jGY.cKm().a(str, this.eGg ? 30 : 31, 720, 720, false);
        if (this.jGY.cKl() != null) {
            this.jGY.cKl().setIsCdn(this.eGg);
            this.jGY.cKl().setUrl(str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKf() {
        if (this.jGW.bcz()) {
            cKh();
        } else {
            cKi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKg() {
        cKh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(View view) {
        cKh();
    }

    private void cKh() {
        if (s.aR(this.efn.getPageActivity(), this.jHb.getScheme() != null ? this.jHb.getScheme() : this.jGW.dWh) == 1) {
            this.jGZ.Lp(this.jGW.bcz() ? "image" : "video");
        }
    }

    private void cKi() {
        if (this.jGW != null && this.jHb != null && this.jHc != null && s.a(this.efn.getPageActivity(), this.jHb.getScheme(), this.jGW) == 1) {
            this.jGZ.Lp(this.jGW.bcz() ? "image" : "video");
        }
    }

    public void cKj() {
        if (!this.jHa) {
            this.jHa = true;
            this.jGZ.aff();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(this.jGW));
        }
    }

    public void onDestroy() {
        if (this.jGY != null) {
            this.jGY.onDestroy();
        }
    }

    public void onCreate() {
        if (this.jGY != null) {
            this.jGY.onCreate();
        }
    }
}
