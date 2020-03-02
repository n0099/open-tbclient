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
/* loaded from: classes11.dex */
public class c extends b {
    private IUiListener jVO;
    private final com.baidu.adp.lib.e.b<f.a> jVQ;

    public c(Context context) {
        super(context);
        this.jVQ = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.dbE == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.cE(2, 4);
                }
                c.this.IC(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.cE(3, 4);
            }
        };
        this.jVG = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.jVN == null) {
            cE(2, 4);
            if (bVar != null) {
                bVar.cD(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            cE(2, 4);
            if (bVar != null) {
                bVar.cD(0, 2);
            }
        } else {
            this.jVO = new b.a(bVar);
            if (shareEntity.cHv() != 0) {
                b(shareEntity);
            } else {
                c(shareEntity);
            }
        }
    }

    private void b(ShareEntity shareEntity) {
        if (uy(shareEntity.cHt())) {
            IC(shareEntity.cHt());
        } else if (w(shareEntity.getImageUri())) {
            IC(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.e.c.gr().a(shareEntity.aAG(), 34, this.jVQ, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IC(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.jVO != null) {
            this.jVN.shareToQQ((Activity) this.context, bundle, this.jVO);
        }
    }

    private void c(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.aAG())) {
            arrayList.add(shareEntity.aAG());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.jVO != null) {
            this.jVN.shareToQzone((Activity) this.context, bundle, this.jVO);
        }
    }
}
