package com.baidu.tieba.recapp.lego.view.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.recapp.h;
import com.baidu.tieba.recapp.report.e;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class c implements h {
    private AdvertAppInfo kLE;
    private String mForumId;
    private j mNg;
    private String mPostId;

    public c(@NonNull TbPageContext<?> tbPageContext, @NonNull final AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        this.kLE = iLegoAdvert.getAdvertAppInfo();
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
                com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(iLegoAdvert.getAdvertAppInfo()));
                if (hashMap == null) {
                    str3 = "image";
                } else {
                    str3 = (String) hashMap.get("da_area");
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "image";
                    }
                }
                c.this.QE(str3);
                if (i2 == 1) {
                    c.this.QF(c.this.kLE.blo() ? "image" : "video");
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str3, String str4, HashMap<String, Object> hashMap) {
            }
        });
        this.mNg = bVar;
    }

    @Override // com.baidu.tieba.recapp.h
    public void setDragToExitListener(DragImageView.d dVar) {
        this.mNg.setDragToExitListener(dVar);
    }

    @Override // com.baidu.tieba.recapp.h
    public View daz() {
        return this.mNg.daz();
    }

    @Override // com.baidu.tieba.recapp.h
    public void onAdShow() {
        com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(this.kLE));
        amN();
    }

    @Override // com.baidu.tieba.recapp.h
    public void onDestroy() {
        this.mNg.onDestroy();
    }

    public void QE(String str) {
        QG("click");
        com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(this.kLE, 2, 0);
        b2.QX(str);
        e.dCe().a(b2);
    }

    public void QF(String str) {
        QG("click");
        com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(this.kLE, 706, 0);
        b2.QX(str);
        e.dCe().a(b2);
    }

    public void amN() {
        QG("show");
        e.dCe().a(com.baidu.tieba.recapp.report.h.b(this.kLE, 3, 0));
    }

    public void QG(String str) {
        com.baidu.tbadk.distribute.a.bAC().a(this.kLE, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PIC_PAGE", str, 1);
    }
}
