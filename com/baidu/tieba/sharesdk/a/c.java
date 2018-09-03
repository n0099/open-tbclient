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
    private IUiListener gCi;
    private final com.baidu.adp.lib.f.b<f.a> gCj;

    public c(Context context) {
        super(context);
        this.gCj = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.asX == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.sT(2);
                }
                c.this.to(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.sT(3);
            }
        };
        this.gCb = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gCh == null) {
            sT(2);
            if (bVar != null) {
                bVar.bD(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            sT(2);
            if (bVar != null) {
                bVar.bD(0, 2);
            }
        } else {
            this.gCi = new b.a(bVar);
            if (shareEntity.bru()) {
                a(shareEntity);
            } else {
                b(shareEntity);
            }
        }
    }

    private void a(ShareEntity shareEntity) {
        if (h(shareEntity.getImageUri())) {
            to(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.f.c.ih().a(shareEntity.tT(), 34, this.gCj, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void to(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.gCi != null) {
            this.gCh.shareToQQ((Activity) this.context, bundle, this.gCi);
        }
    }

    private void b(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.tT())) {
            arrayList.add(shareEntity.tT());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.gCi != null) {
            this.gCh.shareToQzone((Activity) this.context, bundle, this.gCi);
        }
    }
}
