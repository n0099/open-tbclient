package com.baidu.tieba.recapp.lego.view.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.recapp.g;
import com.baidu.tieba.recapp.report.d;
import java.util.HashMap;
/* loaded from: classes25.dex */
public class c implements g {
    private AdvertAppInfo kxG;
    private String mForumId;
    private String mPostId;
    private j myq;

    public c(@NonNull TbPageContext<?> tbPageContext, @NonNull final AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        this.kxG = iLegoAdvert.getAdvertAppInfo();
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
                c.this.QY(str3);
                if (i2 == 1) {
                    c.this.QZ(c.this.kxG.bjx() ? "image" : "video");
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str3, String str4, HashMap<String, Object> hashMap) {
            }
        });
        this.myq = bVar;
    }

    @Override // com.baidu.tieba.recapp.g
    public void setDragToExitListener(DragImageView.d dVar) {
        this.myq.setDragToExitListener(dVar);
    }

    @Override // com.baidu.tieba.recapp.g
    public View cZt() {
        return this.myq.cZt();
    }

    @Override // com.baidu.tieba.recapp.g
    public void onAdShow() {
        com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.c(this.kxG));
        amm();
    }

    @Override // com.baidu.tieba.recapp.g
    public void onDestroy() {
        this.myq.onDestroy();
    }

    public void QY(String str) {
        Ra("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.kxG, 2, 0);
        c.Rl(str);
        d.dAT().a(c);
    }

    public void QZ(String str) {
        Ra("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.kxG, 706, 0);
        c.Rl(str);
        d.dAT().a(c);
    }

    public void amm() {
        Ra("show");
        d.dAT().a(com.baidu.tieba.recapp.report.g.c(this.kxG, 3, 0));
    }

    public void Ra(String str) {
        com.baidu.tbadk.distribute.a.byA().a(this.kxG, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PIC_PAGE", str, 1);
    }
}
