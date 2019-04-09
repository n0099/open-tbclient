package com.baidu.tieba.sharesdk.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.d.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.sharesdk.a.a {
    protected int iuX;
    protected Tencent ivd;
    IUiListener ive;
    private final com.baidu.adp.lib.f.b<f.a> ivf;

    public b(Context context) {
        super(context);
        this.iuX = 8;
        this.ivf = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.bMW != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.ive);
                } else {
                    b.this.yF(2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                b.this.yF(3);
            }
        };
        this.ivd = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
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
            this.ive = new a(bVar);
            String Xk = shareEntity.Xk();
            if (od(shareEntity.caN())) {
                a(shareEntity.caN(), this.ive);
            } else if (shareEntity.caP() != 0 && !TextUtils.isEmpty(Xk) && (Xk.startsWith("http://") || Xk.startsWith("https://"))) {
                com.baidu.adp.lib.f.c.jB().a(Xk, 34, this.ivf, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                a(shareEntity, this.ive);
            } else if (q(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.ive);
            } else {
                b(shareEntity, bVar);
            }
        }
    }

    private void a(ShareEntity shareEntity, IUiListener iUiListener) {
        if (shareEntity != null && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("title", shareEntity.getTitle());
            bundle.putString("summary", shareEntity.getContent());
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            bundle.putInt("req_type", 1);
            bundle.putString("imageUrl", shareEntity.Xk());
            this.ivd.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.ivd.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    private void b(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        String str;
        if (shareEntity != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            Iterator<ResolveInfo> it = this.context.getPackageManager().queryIntentActivities(intent, 0).iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = "";
                    break;
                }
                ResolveInfo next = it.next();
                if (TextUtils.equals("com.tencent.mobileqq", next.activityInfo.packageName)) {
                    str = next.activityInfo.name;
                    break;
                }
            }
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setType("text/plain");
            intent2.putExtra("android.intent.extra.SUBJECT", shareEntity.getTitle());
            intent2.putExtra("android.intent.extra.TEXT", shareEntity.getContent());
            intent2.setClassName("com.tencent.mobileqq", str);
            intent2.setFlags(268435456);
            if (com.baidu.tieba.sharesdk.c.a.i(this.context, intent2)) {
                if (bVar != null) {
                    bVar.cf(this.iuX, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.cf(this.iuX, 2);
            }
            yF(2);
        }
    }

    /* loaded from: classes6.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b ivh;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.ivh = bVar;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.ivh != null) {
                this.ivh.cf(b.this.iuX, 1);
            }
            b.this.yF(1);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.ivh != null) {
                this.ivh.cf(b.this.iuX, 2);
            }
            b.this.aB(2, uiError != null ? uiError.errorMessage : null);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.ivh != null) {
                this.ivh.cf(b.this.iuX, 3);
            }
            if (b.this.iuX != 8 && b.this.iuX == 4) {
                b.this.yF(3);
            }
        }
    }
}
