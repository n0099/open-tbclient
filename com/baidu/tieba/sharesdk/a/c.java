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
/* loaded from: classes23.dex */
public class c extends b {
    private IUiListener mLD;
    private final com.baidu.adp.lib.e.b<f.a> mLF;

    public c(Context context) {
        super(context);
        this.mLF = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.eOy == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.m45do(2, 4);
                }
                c.this.RJ(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.m45do(3, 4);
            }
        };
        this.mLv = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.mLC == null) {
            m45do(2, 4);
            if (bVar != null) {
                bVar.dn(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            m45do(2, 4);
            if (bVar != null) {
                bVar.dn(0, 2);
            }
        } else {
            this.mLD = new b.a(bVar);
            if (shareEntity.dFG() != 0) {
                b(shareEntity);
            } else {
                c(shareEntity);
            }
        }
    }

    private void b(ShareEntity shareEntity) {
        if (CA(shareEntity.dFE())) {
            RJ(shareEntity.dFE());
        } else if (u(shareEntity.getImageUri())) {
            RJ(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.e.c.mS().a(shareEntity.bjy(), 34, this.mLF, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RJ(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.mLD != null) {
            this.mLC.shareToQQ((Activity) this.context, bundle, this.mLD);
        }
    }

    private void c(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.bjy())) {
            arrayList.add(shareEntity.bjy());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.mLD != null) {
            this.mLC.shareToQzone((Activity) this.context, bundle, this.mLD);
        }
    }
}
