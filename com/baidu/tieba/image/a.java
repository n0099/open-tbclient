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
/* loaded from: classes20.dex */
public class a implements ImagePagerAdapter.a {
    private static int jPC = 7;
    private boolean eIr;
    private DragImageView.d eKd;
    private TbPageContext<?> ehG;
    private AdvertAppInfo jPE;
    private boolean jPF;
    private b jPG;
    private c jPH;
    private AdCard jPJ;
    private VideoInfo jPK;
    private int jPD = 0;
    private boolean jPI = false;
    private final View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jPE != null && a.this.jPJ != null) {
                if (a.this.jPG == null || !a.this.jPG.jPQ || a.this.jPG.cNT() != view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(a.this.jPE));
                    if (view.getId() == R.id.image_ad_button) {
                        a.this.cI(view);
                        a.this.jPH.LR("button");
                    } else if (view.getId() == R.id.bottom_container) {
                        a.this.cNN();
                        a.this.jPH.LR("title");
                    } else {
                        a.this.cNM();
                        a.this.jPH.LR(a.this.jPE.bdt() ? "image" : "video");
                    }
                }
            }
        }
    };

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.eIr = false;
        this.jPF = false;
        this.eIr = z;
        this.jPF = z2;
        this.ehG = tbPageContext;
        this.jPH = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.jPE = advertAppInfo;
        this.jPE.page = "PIC_PAGE";
        this.jPH.c(this.jPE);
        this.jPD = i;
        if (this.jPE.legoCard instanceof AdCard) {
            this.jPJ = (AdCard) this.jPE.legoCard;
            this.jPK = this.jPJ.videoInfo;
        }
    }

    public boolean cNJ() {
        if (!this.jPF || this.jPE == null) {
            return false;
        }
        return this.jPE.bdr() || this.jPE.bdq();
    }

    public String getAdId() {
        if (this.jPE != null) {
            return this.jPE.dYt;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View j(ViewGroup viewGroup, int i) {
        if (CA(i)) {
            this.jPG = new b(viewGroup, this.ehG);
            this.jPG.setDragToExitListener(this.eKd);
            cNK();
            viewGroup.addView(this.jPG.getView());
            return this.jPG.getView();
        }
        return null;
    }

    private boolean CA(int i) {
        return cNJ() && this.jPD != 0 && i == this.jPD;
    }

    private void cNK() {
        if (this.jPE != null && this.jPE.dYC != null) {
            cNL();
            this.jPG.a(this.jPE, this.jPJ);
            if (!TextUtils.isEmpty(this.jPE.dYC.userName)) {
                this.jPG.jPO.setText(this.jPE.dYC.userName);
                if (!TextUtils.isEmpty(this.jPE.dYC.tagName)) {
                    this.jPG.jPP.setText(this.jPE.dYC.tagName);
                } else {
                    this.jPG.jPP.setText(this.ehG.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.jPE.dYC.dYL)) {
                this.jPG.jPN.setText(this.jPE.dYC.dYL);
            }
            this.jPG.jPU.setVisibility(this.jPE.bds() ? 0 : 8);
            this.jPG.E(this.mClickListener);
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eKd = dVar;
    }

    private void cNL() {
        String str;
        this.jPG.cNT().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z) {
                    a.this.jPG.cNU();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        if (this.jPE.bds() && this.jPK != null) {
            str = this.jPK.thumbnail_url;
        } else {
            str = this.jPE.dYC.dYN;
        }
        this.jPG.cNT().a(str, this.eIr ? 30 : 31, 720, 720, false);
        if (this.jPG.cNS() != null) {
            this.jPG.cNS().setIsCdn(this.eIr);
            this.jPG.cNS().setUrl(str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNM() {
        if (this.jPE.bdt()) {
            cNO();
        } else {
            cNP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNN() {
        cNO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(View view) {
        cNO();
    }

    private void cNO() {
        if (s.aU(this.ehG.getPageActivity(), this.jPJ.getScheme() != null ? this.jPJ.getScheme() : this.jPE.dYv) == 1) {
            this.jPH.LS(this.jPE.bdt() ? "image" : "video");
        }
    }

    private void cNP() {
        if (this.jPE != null && this.jPJ != null && this.jPK != null && s.a(this.ehG.getPageActivity(), this.jPJ.getScheme(), this.jPE) == 1) {
            this.jPH.LS(this.jPE.bdt() ? "image" : "video");
        }
    }

    public void cNQ() {
        if (!this.jPI) {
            this.jPI = true;
            this.jPH.afP();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(this.jPE));
        }
    }

    public void onDestroy() {
        if (this.jPG != null) {
            this.jPG.onDestroy();
        }
    }

    public void onCreate() {
        if (this.jPG != null) {
            this.jPG.onCreate();
        }
    }
}
