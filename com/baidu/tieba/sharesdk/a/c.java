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
/* loaded from: classes9.dex */
public class c extends b {
    private IUiListener jUP;
    private final com.baidu.adp.lib.e.b<f.a> jUQ;

    public c(Context context) {
        super(context);
        this.jUQ = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.cXA == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.BF(2);
                }
                c.this.Io(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.BF(3);
            }
        };
        this.jUJ = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.jUO == null) {
            BF(2);
            if (bVar != null) {
                bVar.cC(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            BF(2);
            if (bVar != null) {
                bVar.cC(0, 2);
            }
        } else {
            this.jUP = new b.a(bVar);
            if (shareEntity.cFQ() != 0) {
                b(shareEntity);
            } else {
                c(shareEntity);
            }
        }
    }

    private void b(ShareEntity shareEntity) {
        if (uh(shareEntity.cFO())) {
            Io(shareEntity.cFO());
        } else if (v(shareEntity.getImageUri())) {
            Io(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.e.c.gr().a(shareEntity.ayq(), 34, this.jUQ, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.jUP != null) {
            this.jUO.shareToQQ((Activity) this.context, bundle, this.jUP);
        }
    }

    private void c(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.ayq())) {
            arrayList.add(shareEntity.ayq());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.jUP != null) {
            this.jUO.shareToQzone((Activity) this.context, bundle, this.jUP);
        }
    }
}
