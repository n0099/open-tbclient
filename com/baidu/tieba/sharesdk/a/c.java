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
    private IUiListener ivt;
    private final com.baidu.adp.lib.f.b<f.a> ivu;

    public c(Context context) {
        super(context);
        this.ivu = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar == null || aVar.bMT == null || TextUtils.isEmpty(aVar.path)) {
                    c.this.yJ(2);
                }
                c.this.Cb(aVar.path);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                c.this.yJ(3);
            }
        };
        this.ivm = 4;
    }

    @Override // com.baidu.tieba.sharesdk.a.b, com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.ivs == null) {
            yJ(2);
            if (bVar != null) {
                bVar.cf(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            yJ(2);
            if (bVar != null) {
                bVar.cf(0, 2);
            }
        } else {
            this.ivt = new b.a(bVar);
            if (shareEntity.caT() != 0) {
                b(shareEntity);
            } else {
                c(shareEntity);
            }
        }
    }

    private void b(ShareEntity shareEntity) {
        if (oc(shareEntity.caR())) {
            Cb(shareEntity.caR());
        } else if (q(shareEntity.getImageUri())) {
            Cb(shareEntity.getImageUri().getPath());
        } else {
            com.baidu.adp.lib.f.c.jB().a(shareEntity.Xn(), 34, this.ivu, 0, 0, getPageId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cb(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        if (this.ivt != null) {
            this.ivs.shareToQQ((Activity) this.context, bundle, this.ivt);
        }
    }

    private void c(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.getTitle());
        bundle.putString("summary", shareEntity.getContent());
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.Xn())) {
            arrayList.add(shareEntity.Xn());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        if (this.ivt != null) {
            this.ivs.shareToQzone((Activity) this.context, bundle, this.ivt);
        }
    }
}
