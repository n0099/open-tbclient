package com.baidu.tieba.sharesdk.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.c.f;
import com.baidu.tieba.sharesdk.a.b;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.tencent.tauth.IUiListener;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class c extends b {
    private IUiListener lBs;
    private final com.baidu.adp.lib.e.b<f.a> lBu;

    public c(Context context) {
        super(context);
        this.lBu = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.ecR == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.cY(2, 4);
                }
                c.this.Ng(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.cY(3, 4);
            }
        };
        this.lBk = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.lBr == null) {
            cY(2, 4);
            if (bVar != null) {
                bVar.cX(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            cY(2, 4);
            if (bVar != null) {
                bVar.cX(0, 2);
            }
        } else {
            this.lBs = new b.a(bVar);
            if (shareEntity.dhe() != 0) {
                b(shareEntity);
            } else {
                c(shareEntity);
            }
        }
    }

    private void b(ShareEntity shareEntity) {
        if (yV(shareEntity.dhc())) {
            Ng(shareEntity.dhc());
        } else if (t(shareEntity.getImageUri())) {
            Ng(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.e.c.ln().a(shareEntity.aUh(), 34, this.lBu, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ng(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.lBs != null) {
            this.lBr.shareToQQ((Activity) this.context, bundle, this.lBs);
        }
    }

    private void c(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.aUh())) {
            arrayList.add(shareEntity.aUh());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.lBs != null) {
            this.lBr.shareToQzone((Activity) this.context, bundle, this.lBs);
        }
    }
}
