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
    private static int kqZ = 7;
    private TbPageContext<?> eCn;
    private boolean fcV;
    private DragImageView.d feG;
    private AdvertAppInfo krb;
    private boolean krc;
    private b krd;
    private c kre;
    private AdCard krg;
    private VideoInfo krh;
    private int kra = 0;
    private boolean krf = false;
    private final View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.krb != null && a.this.krg != null) {
                if (a.this.krd == null || !a.this.krd.krn || a.this.krd.cUI() != view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(a.this.krb));
                    if (view.getId() == R.id.image_ad_button) {
                        a.this.cQ(view);
                        a.this.kre.Ne("button");
                    } else if (view.getId() == R.id.bottom_container) {
                        a.this.cUC();
                        a.this.kre.Ne("title");
                    } else {
                        a.this.cUB();
                        a.this.kre.Ne(a.this.krb.bhV() ? "image" : "video");
                    }
                }
            }
        }
    };

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.fcV = false;
        this.krc = false;
        this.fcV = z;
        this.krc = z2;
        this.eCn = tbPageContext;
        this.kre = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.krb = advertAppInfo;
        this.krb.page = "PIC_PAGE";
        this.kre.c(this.krb);
        this.kra = i;
        if (this.krb.legoCard instanceof AdCard) {
            this.krg = (AdCard) this.krb.legoCard;
            this.krh = this.krg.videoInfo;
        }
    }

    public boolean cUy() {
        if (!this.krc || this.krb == null) {
            return false;
        }
        return this.krb.bhT() || this.krb.bhS();
    }

    public String getAdId() {
        if (this.krb != null) {
            return this.krb.esU;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View l(ViewGroup viewGroup, int i) {
        if (Dz(i)) {
            this.krd = new b(viewGroup, this.eCn);
            this.krd.setDragToExitListener(this.feG);
            cUz();
            viewGroup.addView(this.krd.getView());
            return this.krd.getView();
        }
        return null;
    }

    private boolean Dz(int i) {
        return cUy() && this.kra != 0 && i == this.kra;
    }

    private void cUz() {
        if (this.krb != null && this.krb.ete != null) {
            cUA();
            this.krd.a(this.krb, this.krg);
            if (!TextUtils.isEmpty(this.krb.ete.userName)) {
                this.krd.krl.setText(this.krb.ete.userName);
                if (!TextUtils.isEmpty(this.krb.ete.tagName)) {
                    this.krd.krm.setText(this.krb.ete.tagName);
                } else {
                    this.krd.krm.setText(this.eCn.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.krb.ete.etn)) {
                this.krd.krk.setText(this.krb.ete.etn);
            }
            this.krd.krr.setVisibility(this.krb.bhU() ? 0 : 8);
            this.krd.E(this.mClickListener);
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.feG = dVar;
    }

    private void cUA() {
        String str;
        this.krd.cUI().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z) {
                    a.this.krd.cUJ();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        if (this.krb.bhU() && this.krh != null) {
            str = this.krh.thumbnail_url;
        } else {
            str = this.krb.ete.etp;
        }
        this.krd.cUI().a(str, this.fcV ? 30 : 31, 720, 720, false);
        if (this.krd.cUH() != null) {
            this.krd.cUH().setIsCdn(this.fcV);
            this.krd.cUH().setUrl(str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUB() {
        if (this.krb.bhV()) {
            cUD();
        } else {
            cUE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUC() {
        cUD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(View view) {
        cUD();
    }

    private void cUD() {
        if (s.aY(this.eCn.getPageActivity(), this.krg.getScheme() != null ? this.krg.getScheme() : this.krb.esW) == 1) {
            this.kre.Nf(this.krb.bhV() ? "image" : "video");
        }
    }

    private void cUE() {
        if (this.krb != null && this.krg != null && this.krh != null && s.a(this.eCn.getPageActivity(), this.krg.getScheme(), this.krb) == 1) {
            this.kre.Nf(this.krb.bhV() ? "image" : "video");
        }
    }

    public void cUF() {
        if (!this.krf) {
            this.krf = true;
            this.kre.aku();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(this.krb));
        }
    }

    public void onDestroy() {
        if (this.krd != null) {
            this.krd.onDestroy();
        }
    }

    public void onCreate() {
        if (this.krd != null) {
            this.krd.onCreate();
        }
    }
}
