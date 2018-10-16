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
    private IUiListener gRj;
    private final com.baidu.adp.lib.f.b<f.a> gRk;

    public c(Context context) {
        super(context);
        this.gRk = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.aAg == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.tQ(2);
                }
                c.this.ux(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.tQ(3);
            }
        };
        this.gRc = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gRi == null) {
            tQ(2);
            if (bVar != null) {
                bVar.bI(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            tQ(2);
            if (bVar != null) {
                bVar.bI(0, 2);
            }
        } else {
            this.gRj = new b.a(bVar);
            if (shareEntity.bxo()) {
                a(shareEntity);
            } else {
                b(shareEntity);
            }
        }
    }

    private void a(ShareEntity shareEntity) {
        if (h(shareEntity.getImageUri())) {
            ux(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.f.c.jC().a(shareEntity.xf(), 34, this.gRk, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.gRj != null) {
            this.gRi.shareToQQ((Activity) this.context, bundle, this.gRj);
        }
    }

    private void b(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.xf())) {
            arrayList.add(shareEntity.xf());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.gRj != null) {
            this.gRi.shareToQzone((Activity) this.context, bundle, this.gRj);
        }
    }
}
