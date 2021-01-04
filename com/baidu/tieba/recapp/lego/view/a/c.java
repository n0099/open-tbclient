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
/* loaded from: classes8.dex */
public class c implements h {
    private AdvertAppInfo kQj;
    private String mForumId;
    private String mPostId;
    private j mRN;

    public c(@NonNull TbPageContext<?> tbPageContext, @NonNull final AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        this.kQj = iLegoAdvert.getAdvertAppInfo();
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
                c.this.RM(str3);
                if (i2 == 1) {
                    c.this.RN(c.this.kQj.bph() ? "image" : "video");
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void a(String str3, String str4, HashMap<String, Object> hashMap) {
            }
        });
        this.mRN = bVar;
    }

    @Override // com.baidu.tieba.recapp.h
    public void setDragToExitListener(DragImageView.d dVar) {
        this.mRN.setDragToExitListener(dVar);
    }

    @Override // com.baidu.tieba.recapp.h
    public View deq() {
        return this.mRN.deq();
    }

    @Override // com.baidu.tieba.recapp.h
    public void onAdShow() {
        com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(this.kQj));
        aqH();
    }

    @Override // com.baidu.tieba.recapp.h
    public void onDestroy() {
        this.mRN.onDestroy();
    }

    public void RM(String str) {
        RO("click");
        com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(this.kQj, 2, 0);
        b2.Sf(str);
        e.dFV().a(b2);
    }

    public void RN(String str) {
        RO("click");
        com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(this.kQj, 706, 0);
        b2.Sf(str);
        e.dFV().a(b2);
    }

    public void aqH() {
        RO("show");
        e.dFV().a(com.baidu.tieba.recapp.report.h.b(this.kQj, 3, 0));
    }

    public void RO(String str) {
        com.baidu.tbadk.distribute.a.bEv().a(this.kQj, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PIC_PAGE", str, 1);
    }
}
