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
    private IUiListener gkD;
    private final com.baidu.adp.lib.f.b<e.a> gkE;

    public c(Context context) {
        super(context);
        this.gkE = new com.baidu.adp.lib.f.b<e.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(e.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.akH == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.sB(2);
                }
                c.this.st(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.sB(3);
            }
        };
        this.gkw = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gkC == null) {
            sB(2);
            if (bVar != null) {
                bVar.bC(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            sB(2);
            if (bVar != null) {
                bVar.bC(0, 2);
            }
        } else {
            this.gkD = new b.a(bVar);
            if (shareEntity.bns()) {
                a(shareEntity);
            } else {
                b(shareEntity);
            }
        }
    }

    private void a(ShareEntity shareEntity) {
        if (i(shareEntity.bnq())) {
            st(shareEntity.bnq().getPath());
        } else {
            com.baidu.adp.lib.f.c.fp().a(shareEntity.qG(), 34, this.gkE, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void st(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.gkD != null) {
            this.gkC.shareToQQ((Activity) this.context, bundle, this.gkD);
        }
    }

    private void b(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.qG())) {
            arrayList.add(shareEntity.qG());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.gkD != null) {
            this.gkC.shareToQzone((Activity) this.context, bundle, this.gkD);
        }
    }
}
