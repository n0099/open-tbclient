package com.baidu.tieba.sharesdk.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.util.d.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.sharesdk.a.a {
    protected int jUE;
    protected Tencent jUJ;
    IUiListener jUK;
    private final com.baidu.adp.lib.e.b<f.a> jUL;

    public b(Context context) {
        super(context);
        this.jUE = 8;
        this.jUL = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.cXA != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.jUK);
                } else {
                    b.this.BF(2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                b.this.BF(3);
            }
        };
        this.jUJ = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.jUJ == null) {
            BF(2);
            if (bVar != null) {
                bVar.cC(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            BF(2);
            if (bVar != null) {
                bVar.cC(0, 2);
            }
        } else {
            this.jUK = new a(bVar);
            String ayq = shareEntity.ayq();
            if (uh(shareEntity.cFM())) {
                a(shareEntity.cFM(), this.jUK);
            } else if (shareEntity.cFO() != 0 && !TextUtils.isEmpty(ayq) && (ayq.startsWith("http://") || ayq.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                com.baidu.adp.lib.e.c.gr().a(ayq, 34, this.jUL, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                a(shareEntity, this.jUK);
            } else if (v(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.jUK);
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
            bundle.putString("imageUrl", shareEntity.ayq());
            this.jUJ.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.jUJ.shareToQQ((Activity) this.context, bundle, iUiListener);
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
            if (com.baidu.tieba.sharesdk.c.a.startActivity(this.context, intent2)) {
                if (bVar != null) {
                    bVar.cC(this.jUE, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.cC(this.jUE, 2);
            }
            BF(2);
        }
    }

    /* loaded from: classes9.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b jUN;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.jUN = bVar;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.jUN != null) {
                this.jUN.cC(b.this.jUE, 1);
            }
            b.this.BF(1);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.jUN != null) {
                this.jUN.cC(b.this.jUE, 2);
            }
            b.this.ba(2, uiError != null ? uiError.errorMessage : null);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.jUN != null) {
                this.jUN.cC(b.this.jUE, 3);
            }
            if (b.this.jUE != 8 && b.this.jUE == 4) {
            }
        }
    }
}
