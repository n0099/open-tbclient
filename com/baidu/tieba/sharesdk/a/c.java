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
    private IUiListener iXE;
    private final com.baidu.adp.lib.f.b<f.a> iXF;

    public c(Context context) {
        super(context);
        this.iXF = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.clJ == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.zf(2);
                }
                c.this.Dr(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.zf(3);
            }
        };
        this.iXx = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.iXD == null) {
            zf(2);
            if (bVar != null) {
                bVar.cl(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            zf(2);
            if (bVar != null) {
                bVar.cl(0, 2);
            }
        } else {
            this.iXE = new b.a(bVar);
            if (shareEntity.ckG() != 0) {
                b(shareEntity);
            } else {
                c(shareEntity);
            }
        }
    }

    private void b(ShareEntity shareEntity) {
        if (oY(shareEntity.ckE())) {
            Dr(shareEntity.ckE());
        } else if (t(shareEntity.getImageUri())) {
            Dr(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.f.c.fT().a(shareEntity.ahf(), 34, this.iXF, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dr(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.iXE != null) {
            this.iXD.shareToQQ((Activity) this.context, bundle, this.iXE);
        }
    }

    private void c(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.ahf())) {
            arrayList.add(shareEntity.ahf());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.iXE != null) {
            this.iXD.shareToQzone((Activity) this.context, bundle, this.iXE);
        }
    }
}
