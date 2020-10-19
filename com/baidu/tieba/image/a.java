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
    private static int keB = 7;
    private boolean eUy;
    private DragImageView.d eWk;
    private TbPageContext<?> etO;
    private AdvertAppInfo keD;
    private boolean keE;
    private b keF;
    private c keG;
    private AdCard keI;
    private VideoInfo keJ;
    private int keC = 0;
    private boolean keH = false;
    private final View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.keD != null && a.this.keI != null) {
                if (a.this.keF == null || !a.this.keF.keP || a.this.keF.cRB() != view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(a.this.keD));
                    if (view.getId() == R.id.image_ad_button) {
                        a.this.cM(view);
                        a.this.keG.MG("button");
                    } else if (view.getId() == R.id.bottom_container) {
                        a.this.cRv();
                        a.this.keG.MG("title");
                    } else {
                        a.this.cRu();
                        a.this.keG.MG(a.this.keD.bgc() ? "image" : "video");
                    }
                }
            }
        }
    };

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.eUy = false;
        this.keE = false;
        this.eUy = z;
        this.keE = z2;
        this.etO = tbPageContext;
        this.keG = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.keD = advertAppInfo;
        this.keD.page = "PIC_PAGE";
        this.keG.c(this.keD);
        this.keC = i;
        if (this.keD.legoCard instanceof AdCard) {
            this.keI = (AdCard) this.keD.legoCard;
            this.keJ = this.keI.videoInfo;
        }
    }

    public boolean cRr() {
        if (!this.keE || this.keD == null) {
            return false;
        }
        return this.keD.bga() || this.keD.bfZ();
    }

    public String getAdId() {
        if (this.keD != null) {
            return this.keD.ekv;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View l(ViewGroup viewGroup, int i) {
        if (Dg(i)) {
            this.keF = new b(viewGroup, this.etO);
            this.keF.setDragToExitListener(this.eWk);
            cRs();
            viewGroup.addView(this.keF.getView());
            return this.keF.getView();
        }
        return null;
    }

    private boolean Dg(int i) {
        return cRr() && this.keC != 0 && i == this.keC;
    }

    private void cRs() {
        if (this.keD != null && this.keD.ekE != null) {
            cRt();
            this.keF.a(this.keD, this.keI);
            if (!TextUtils.isEmpty(this.keD.ekE.userName)) {
                this.keF.keN.setText(this.keD.ekE.userName);
                if (!TextUtils.isEmpty(this.keD.ekE.tagName)) {
                    this.keF.keO.setText(this.keD.ekE.tagName);
                } else {
                    this.keF.keO.setText(this.etO.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.keD.ekE.ekN)) {
                this.keF.keM.setText(this.keD.ekE.ekN);
            }
            this.keF.keT.setVisibility(this.keD.bgb() ? 0 : 8);
            this.keF.E(this.mClickListener);
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eWk = dVar;
    }

    private void cRt() {
        String str;
        this.keF.cRB().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z) {
                    a.this.keF.cRC();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        if (this.keD.bgb() && this.keJ != null) {
            str = this.keJ.thumbnail_url;
        } else {
            str = this.keD.ekE.ekP;
        }
        this.keF.cRB().a(str, this.eUy ? 30 : 31, 720, 720, false);
        if (this.keF.cRA() != null) {
            this.keF.cRA().setIsCdn(this.eUy);
            this.keF.cRA().setUrl(str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRu() {
        if (this.keD.bgc()) {
            cRw();
        } else {
            cRx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRv() {
        cRw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(View view) {
        cRw();
    }

    private void cRw() {
        if (s.aW(this.etO.getPageActivity(), this.keI.getScheme() != null ? this.keI.getScheme() : this.keD.ekx) == 1) {
            this.keG.MH(this.keD.bgc() ? "image" : "video");
        }
    }

    private void cRx() {
        if (this.keD != null && this.keI != null && this.keJ != null && s.a(this.etO.getPageActivity(), this.keI.getScheme(), this.keD) == 1) {
            this.keG.MH(this.keD.bgc() ? "image" : "video");
        }
    }

    public void cRy() {
        if (!this.keH) {
            this.keH = true;
            this.keG.aiA();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.d(this.keD));
        }
    }

    public void onDestroy() {
        if (this.keF != null) {
            this.keF.onDestroy();
        }
    }

    public void onCreate() {
        if (this.keF != null) {
            this.keF.onCreate();
        }
    }
}
