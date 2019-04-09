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
/* loaded from: classes6.dex */
public class c extends b {
    private IUiListener ive;
    private final com.baidu.adp.lib.f.b<f.a> ivf;

    public c(Context context) {
        super(context);
        this.ivf = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.bMW == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.yF(2);
                }
                c.this.Ca(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.yF(3);
            }
        };
        this.iuX = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.ivd == null) {
            yF(2);
            if (bVar != null) {
                bVar.cf(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            yF(2);
            if (bVar != null) {
                bVar.cf(0, 2);
            }
        } else {
            this.ive = new b.a(bVar);
            if (shareEntity.caP() != 0) {
                b(shareEntity);
            } else {
                c(shareEntity);
            }
        }
    }

    private void b(ShareEntity shareEntity) {
        if (od(shareEntity.caN())) {
            Ca(shareEntity.caN());
        } else if (q(shareEntity.getImageUri())) {
            Ca(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.f.c.jB().a(shareEntity.Xk(), 34, this.ivf, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ca(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.ive != null) {
            this.ivd.shareToQQ((Activity) this.context, bundle, this.ive);
        }
    }

    private void c(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.Xk())) {
            arrayList.add(shareEntity.Xk());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.ive != null) {
            this.ivd.shareToQzone((Activity) this.context, bundle, this.ive);
        }
    }
}
