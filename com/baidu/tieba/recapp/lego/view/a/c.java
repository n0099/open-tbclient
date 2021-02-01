package com.baidu.tieba.recapp.lego.view.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.recapp.h;
import com.baidu.tieba.recapp.report.d;
import com.baidu.tieba.recapp.report.e;
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class c implements h {
    private AdvertAppInfo kTH;
    private String mForumId;
    private String mPostId;
    private j mWu;

    public c(@NonNull TbPageContext<?> tbPageContext, @NonNull final AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        this.kTH = iLegoAdvert.getAdvertAppInfo();
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
                if (i2 != 0 && c.this.kTH != null) {
                    if (hashMap == null) {
                        str3 = "image";
                    } else {
                        str3 = (String) hashMap.get("da_area");
                        if (TextUtils.isEmpty(str3)) {
                            str3 = "image";
                        }
                    }
                    if (s.HL(i2)) {
                        d.a(c.this.kTH, 0, str3, i2);
                    } else {
                        d.a(c.this.kTH, 0, (String) null, (String) null, str3);
                    }
                    com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(iLegoAdvert.getAdvertAppInfo()));
                }
            }

            @Override // com.baidu.tieba.lego.card.a
            public void b(String str3, String str4, HashMap<String, Object> hashMap) {
            }
        });
        this.mWu = bVar;
    }

    @Override // com.baidu.tieba.recapp.h
    public void setDragToExitListener(DragImageView.d dVar) {
        this.mWu.setDragToExitListener(dVar);
    }

    @Override // com.baidu.tieba.recapp.h
    public View dcx() {
        return this.mWu.dcx();
    }

    @Override // com.baidu.tieba.recapp.h
    public void onAdShow() {
        com.baidu.tieba.lego.card.a.c.b(com.baidu.tieba.lego.card.a.c.c(this.kTH));
        anl();
    }

    @Override // com.baidu.tieba.recapp.h
    public void onDestroy() {
        this.mWu.onDestroy();
    }

    public void anl() {
        Rz("show");
        e.dEm().a(com.baidu.tieba.recapp.report.h.b(this.kTH, 3, 0));
    }

    public void Rz(String str) {
        com.baidu.tbadk.distribute.a.bAU().a(this.kTH, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PIC_PAGE", str, 1);
    }
}
