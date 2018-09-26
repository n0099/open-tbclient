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
    private IUiListener gJL;
    private final com.baidu.adp.lib.f.b<f.a> gJM;

    public c(Context context) {
        super(context);
        this.gJM = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.avv == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.tt(2);
                }
                c.this.tV(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.tt(3);
            }
        };
        this.gJE = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gJK == null) {
            tt(2);
            if (bVar != null) {
                bVar.bF(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            tt(2);
            if (bVar != null) {
                bVar.bF(0, 2);
            }
        } else {
            this.gJL = new b.a(bVar);
            if (shareEntity.btZ()) {
                a(shareEntity);
            } else {
                b(shareEntity);
            }
        }
    }

    private void a(ShareEntity shareEntity) {
        if (h(shareEntity.getImageUri())) {
            tV(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.f.c.jn().a(shareEntity.uW(), 34, this.gJM, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.gJL != null) {
            this.gJK.shareToQQ((Activity) this.context, bundle, this.gJL);
        }
    }

    private void b(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.uW())) {
            arrayList.add(shareEntity.uW());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.gJL != null) {
            this.gJK.shareToQzone((Activity) this.context, bundle, this.gJL);
        }
    }
}
