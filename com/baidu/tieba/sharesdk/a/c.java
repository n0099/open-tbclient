package com.baidu.tieba.sharesdk.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.e.f;
import com.baidu.tieba.sharesdk.a.b;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.tencent.tauth.IUiListener;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c extends b {
    private IUiListener iXP;
    private final com.baidu.adp.lib.f.b<f.a> iXQ;

    public c(Context context) {
        super(context);
        this.iXQ = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.bWG == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.Ax(2);
                }
                c.this.EM(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.Ax(3);
            }
        };
        this.iXI = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.iXO == null) {
            Ax(2);
            if (bVar != null) {
                bVar.cs(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            Ax(2);
            if (bVar != null) {
                bVar.cs(0, 2);
            }
        } else {
            this.iXP = new b.a(bVar);
            if (shareEntity.cmR() != 0) {
                b(shareEntity);
            } else {
                c(shareEntity);
            }
        }
    }

    private void b(ShareEntity shareEntity) {
        if (pO(shareEntity.cmP())) {
            EM(shareEntity.cmP());
        } else if (w(shareEntity.getImageUri())) {
            EM(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.f.c.iE().a(shareEntity.acZ(), 34, this.iXQ, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EM(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.iXP != null) {
            this.iXO.shareToQQ((Activity) this.context, bundle, this.iXP);
        }
    }

    private void c(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.acZ())) {
            arrayList.add(shareEntity.acZ());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.iXP != null) {
            this.iXO.shareToQzone((Activity) this.context, bundle, this.iXP);
        }
    }
}
