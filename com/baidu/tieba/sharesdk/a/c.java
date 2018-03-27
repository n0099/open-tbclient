package com.baidu.tieba.sharesdk.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.d.e;
import com.baidu.tieba.sharesdk.a.b;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.tencent.tauth.IUiListener;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends b {
    private IUiListener gPx;
    private final com.baidu.adp.lib.f.b<e.a> gPy;

    public c(Context context) {
        super(context);
        this.gPy = new com.baidu.adp.lib.f.b<e.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(e.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.aZe == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.uY(2);
                }
                c.this.sl(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.uY(3);
            }
        };
        this.gPq = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gPw == null) {
            uY(2);
            if (bVar != null) {
                bVar.cA(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            uY(2);
            if (bVar != null) {
                bVar.cA(0, 2);
            }
        } else {
            this.gPx = new b.a(bVar);
            if (shareEntity.bsj()) {
                a(shareEntity);
            } else {
                b(shareEntity);
            }
        }
    }

    private void a(ShareEntity shareEntity) {
        String ya = shareEntity.ya();
        if (ri(ya)) {
            sl(ya);
        } else {
            com.baidu.adp.lib.f.c.nm().a(ya, 34, this.gPy, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.gPx != null) {
            this.gPw.shareToQQ((Activity) this.context, bundle, this.gPx);
        }
    }

    private void b(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.ya())) {
            arrayList.add(shareEntity.ya());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.gPx != null) {
            this.gPw.shareToQzone((Activity) this.context, bundle, this.gPx);
        }
    }
}
