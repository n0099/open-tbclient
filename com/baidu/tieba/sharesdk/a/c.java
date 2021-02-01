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
/* loaded from: classes8.dex */
public class c extends b {
    private IUiListener nkf;
    private final com.baidu.adp.lib.e.c<e.a> nkh;

    public c(Context context) {
        super(context);
        this.nkh = new com.baidu.adp.lib.e.c<e.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void onLoaded(e.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.fcS == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.dm(2, 4);
                }
                c.this.Sv(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.dm(3, 4);
            }
        };
        this.njW = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.nke == null) {
            dm(2, 4);
            if (bVar != null) {
                bVar.dl(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            dm(2, 4);
            if (bVar != null) {
                bVar.dl(0, 2);
            }
        } else {
            this.nkf = new b.a(bVar);
            if (shareEntity.dJc() != 0) {
                b(shareEntity);
            } else {
                c(shareEntity);
            }
        }
    }

    private void b(ShareEntity shareEntity) {
        if (Cl(shareEntity.dJa())) {
            Sv(shareEntity.dJa());
        } else if (z(shareEntity.getImageUri())) {
            Sv(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.e.d.mw().a(shareEntity.getImgUrl(), 34, this.nkh, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sv(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.nkf != null) {
            this.nke.shareToQQ((Activity) this.context, bundle, this.nkf);
        }
    }

    private void c(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.getImgUrl())) {
            arrayList.add(shareEntity.getImgUrl());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.nkf != null) {
            this.nke.shareToQzone((Activity) this.context, bundle, this.nkf);
        }
    }
}
