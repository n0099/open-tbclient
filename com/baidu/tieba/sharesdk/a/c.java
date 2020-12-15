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
/* loaded from: classes24.dex */
public class c extends b {
    private IUiListener mZI;
    private final com.baidu.adp.lib.e.b<f.a> mZK;

    public c(Context context) {
        super(context);
        this.mZK = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.eVN == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.dt(2, 4);
                }
                c.this.SX(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.dt(3, 4);
            }
        };
        this.mZz = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.mZH == null) {
            dt(2, 4);
            if (bVar != null) {
                bVar.ds(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            dt(2, 4);
            if (bVar != null) {
                bVar.ds(0, 2);
            }
        } else {
            this.mZI = new b.a(bVar);
            if (shareEntity.dKT() != 0) {
                b(shareEntity);
            } else {
                c(shareEntity);
            }
        }
    }

    private void b(ShareEntity shareEntity) {
        if (Di(shareEntity.dKR())) {
            SX(shareEntity.dKR());
        } else if (u(shareEntity.getImageUri())) {
            SX(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.e.c.mS().a(shareEntity.bmL(), 34, this.mZK, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SX(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.mZI != null) {
            this.mZH.shareToQQ((Activity) this.context, bundle, this.mZI);
        }
    }

    private void c(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.bmL())) {
            arrayList.add(shareEntity.bmL());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.mZI != null) {
            this.mZH.shareToQzone((Activity) this.context, bundle, this.mZI);
        }
    }
}
