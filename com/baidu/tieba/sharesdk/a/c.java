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
    private IUiListener iWN;
    private final com.baidu.adp.lib.f.b<f.a> iWO;

    public c(Context context) {
        super(context);
        this.iWO = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.ckS == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.ze(2);
                }
                c.this.Dr(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.ze(3);
            }
        };
        this.iWG = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.iWM == null) {
            ze(2);
            if (bVar != null) {
                bVar.cj(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            ze(2);
            if (bVar != null) {
                bVar.cj(0, 2);
            }
        } else {
            this.iWN = new b.a(bVar);
            if (shareEntity.ckE() != 0) {
                b(shareEntity);
            } else {
                c(shareEntity);
            }
        }
    }

    private void b(ShareEntity shareEntity) {
        if (oY(shareEntity.ckC())) {
            Dr(shareEntity.ckC());
        } else if (t(shareEntity.getImageUri())) {
            Dr(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.f.c.fT().a(shareEntity.ahd(), 34, this.iWO, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dr(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.iWN != null) {
            this.iWM.shareToQQ((Activity) this.context, bundle, this.iWN);
        }
    }

    private void c(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.ahd())) {
            arrayList.add(shareEntity.ahd());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.iWN != null) {
            this.iWM.shareToQzone((Activity) this.context, bundle, this.iWN);
        }
    }
}
