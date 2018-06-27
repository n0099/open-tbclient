package com.baidu.tieba.sharesdk.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.d.f;
import com.baidu.tieba.sharesdk.a.b;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.tencent.tauth.IUiListener;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends b {
    private IUiListener gAX;
    private final com.baidu.adp.lib.f.b<f.a> gAY;

    public c(Context context) {
        super(context);
        this.gAY = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.ats == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.sV(2);
                }
                c.this.tm(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.sV(3);
            }
        };
        this.gAQ = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gAW == null) {
            sV(2);
            if (bVar != null) {
                bVar.bC(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            sV(2);
            if (bVar != null) {
                bVar.bC(0, 2);
            }
        } else {
            this.gAX = new b.a(bVar);
            if (shareEntity.bsQ()) {
                a(shareEntity);
            } else {
                b(shareEntity);
            }
        }
    }

    private void a(ShareEntity shareEntity) {
        if (h(shareEntity.getImageUri())) {
            tm(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.f.c.ig().a(shareEntity.uh(), 34, this.gAY, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tm(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.gAX != null) {
            this.gAW.shareToQQ((Activity) this.context, bundle, this.gAX);
        }
    }

    private void b(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.uh())) {
            arrayList.add(shareEntity.uh());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.gAX != null) {
            this.gAW.shareToQzone((Activity) this.context, bundle, this.gAX);
        }
    }
}
