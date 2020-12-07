package com.baidu.tieba.recapp.lego.view.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.recapp.h;
import com.baidu.tieba.recapp.report.d;
import com.baidu.tieba.recapp.report.g;
import java.util.HashMap;
/* loaded from: classes26.dex */
public class c implements h {
    private AdvertAppInfo kKY;
    private String mForumId;
    private j mMC;
    private String mPostId;

    public c(@NonNull TbPageContext<?> tbPageContext, @NonNull final AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        this.kKY = iLegoAdvert.getAdvertAppInfo();
        this.mForumId = str;
        this.mPostId = str2;
        b bVar = new b(tbPageContext);
        bVar.setBusinessType(i);
        bVar.setFromCDN(z);
        bVar.aN(iLegoAdvert);
        bVar.setAfterClickSchemeListener(new com.baidu.tieba.lego.card.a() { // from class: com.baidu.tieba.recapp.lego.view.a.c.1
            @Override // com.baidu.tieba.lego.card.a
            public void d(int i2, HashMap<String, Object> hashMap) {
                String str3;
                com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.c(iLegoAdvert.getAdvertAppInfo()));
                if (hashMap == null) {
                    str3 = "image";
                } else {
                    str3 = (String) hashMap.get("da_area");
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "image";
                    }
                }
                c.this.Sh(str3);
                if (i2 == 1) {
                    c.this.Si(c.this.kKY.bmH() ? "image" : "video");
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str3, String str4, HashMap<String, Object> hashMap) {
            }
        });
        this.mMC = bVar;
    }

    @Override // com.baidu.tieba.recapp.h
    public void setDragToExitListener(DragImageView.d dVar) {
        this.mMC.setDragToExitListener(dVar);
    }

    @Override // com.baidu.tieba.recapp.h
    public View deE() {
        return this.mMC.deE();
    }

    @Override // com.baidu.tieba.recapp.h
    public void onAdShow() {
        com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.c(this.kKY));
        apv();
    }

    @Override // com.baidu.tieba.recapp.h
    public void onDestroy() {
        this.mMC.onDestroy();
    }

    public void Sh(String str) {
        Sj("click");
        com.baidu.tieba.recapp.report.c c = g.c(this.kKY, 2, 0);
        c.Sx(str);
        d.dGf().a(c);
    }

    public void Si(String str) {
        Sj("click");
        com.baidu.tieba.recapp.report.c c = g.c(this.kKY, 706, 0);
        c.Sx(str);
        d.dGf().a(c);
    }

    public void apv() {
        Sj("show");
        d.dGf().a(g.c(this.kKY, 3, 0));
    }

    public void Sj(String str) {
        com.baidu.tbadk.distribute.a.bCa().a(this.kKY, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PIC_PAGE", str, 1);
    }
}
