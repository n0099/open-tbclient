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
    private static int jHa = 7;
    private boolean eGk;
    private DragImageView.d eHW;
    private TbPageContext<?> efr;
    private AdvertAppInfo jHc;
    private boolean jHd;
    private b jHe;
    private c jHf;
    private AdCard jHh;
    private VideoInfo jHi;
    private int jHb = 0;
    private boolean jHg = false;
    private final View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jHc != null && a.this.jHh != null) {
                if (a.this.jHe == null || !a.this.jHe.jHo || a.this.jHe.cKn() != view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(a.this.jHc));
                    if (view.getId() == R.id.image_ad_button) {
                        a.this.cz(view);
                        a.this.jHf.Lp("button");
                    } else if (view.getId() == R.id.bottom_container) {
                        a.this.cKh();
                        a.this.jHf.Lp("title");
                    } else {
                        a.this.cKg();
                        a.this.jHf.Lp(a.this.jHc.bcz() ? "image" : "video");
                    }
                }
            }
        }
    };

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.eGk = false;
        this.jHd = false;
        this.eGk = z;
        this.jHd = z2;
        this.efr = tbPageContext;
        this.jHf = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.jHc = advertAppInfo;
        this.jHc.page = "PIC_PAGE";
        this.jHf.c(this.jHc);
        this.jHb = i;
        if (this.jHc.legoCard instanceof AdCard) {
            this.jHh = (AdCard) this.jHc.legoCard;
            this.jHi = this.jHh.videoInfo;
        }
    }

    public boolean cKd() {
        if (!this.jHd || this.jHc == null) {
            return false;
        }
        return this.jHc.bcx() || this.jHc.bcw();
    }

    public String getAdId() {
        if (this.jHc != null) {
            return this.jHc.dWj;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View j(ViewGroup viewGroup, int i) {
        if (BZ(i)) {
            this.jHe = new b(viewGroup, this.efr);
            this.jHe.setDragToExitListener(this.eHW);
            cKe();
            viewGroup.addView(this.jHe.getView());
            return this.jHe.getView();
        }
        return null;
    }

    private boolean BZ(int i) {
        return cKd() && this.jHb != 0 && i == this.jHb;
    }

    private void cKe() {
        if (this.jHc != null && this.jHc.dWs != null) {
            cKf();
            this.jHe.a(this.jHc, this.jHh);
            if (!TextUtils.isEmpty(this.jHc.dWs.userName)) {
                this.jHe.jHm.setText(this.jHc.dWs.userName);
                if (!TextUtils.isEmpty(this.jHc.dWs.tagName)) {
                    this.jHe.jHn.setText(this.jHc.dWs.tagName);
                } else {
                    this.jHe.jHn.setText(this.efr.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.jHc.dWs.dWB)) {
                this.jHe.jHl.setText(this.jHc.dWs.dWB);
            }
            this.jHe.jHs.setVisibility(this.jHc.bcy() ? 0 : 8);
            this.jHe.E(this.mClickListener);
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eHW = dVar;
    }

    private void cKf() {
        String str;
        this.jHe.cKn().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z) {
                    a.this.jHe.cKo();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        if (this.jHc.bcy() && this.jHi != null) {
            str = this.jHi.thumbnail_url;
        } else {
            str = this.jHc.dWs.dWD;
        }
        this.jHe.cKn().a(str, this.eGk ? 30 : 31, 720, 720, false);
        if (this.jHe.cKm() != null) {
            this.jHe.cKm().setIsCdn(this.eGk);
            this.jHe.cKm().setUrl(str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKg() {
        if (this.jHc.bcz()) {
            cKi();
        } else {
            cKj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKh() {
        cKi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(View view) {
        cKi();
    }

    private void cKi() {
        if (s.aR(this.efr.getPageActivity(), this.jHh.getScheme() != null ? this.jHh.getScheme() : this.jHc.dWl) == 1) {
            this.jHf.Lq(this.jHc.bcz() ? "image" : "video");
        }
    }

    private void cKj() {
        if (this.jHc != null && this.jHh != null && this.jHi != null && s.a(this.efr.getPageActivity(), this.jHh.getScheme(), this.jHc) == 1) {
            this.jHf.Lq(this.jHc.bcz() ? "image" : "video");
        }
    }

    public void cKk() {
        if (!this.jHg) {
            this.jHg = true;
            this.jHf.aff();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(this.jHc));
        }
    }

    public void onDestroy() {
        if (this.jHe != null) {
            this.jHe.onDestroy();
        }
    }

    public void onCreate() {
        if (this.jHe != null) {
            this.jHe.onCreate();
        }
    }
}
