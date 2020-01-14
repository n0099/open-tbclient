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
    protected int jUJ;
    protected Tencent jUO;
    IUiListener jUP;
    private final com.baidu.adp.lib.e.b<f.a> jUQ;

    public b(Context context) {
        super(context);
        this.jUJ = 8;
        this.jUQ = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.cXA != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.jUP);
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
        this.jUO = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.jUO == null) {
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
            this.jUP = new a(bVar);
            String ayq = shareEntity.ayq();
            if (uh(shareEntity.cFO())) {
                a(shareEntity.cFO(), this.jUP);
            } else if (shareEntity.cFQ() != 0 && !TextUtils.isEmpty(ayq) && (ayq.startsWith("http://") || ayq.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                com.baidu.adp.lib.e.c.gr().a(ayq, 34, this.jUQ, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                a(shareEntity, this.jUP);
            } else if (v(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.jUP);
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
            this.jUO.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.jUO.shareToQQ((Activity) this.context, bundle, iUiListener);
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
                    bVar.cC(this.jUJ, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.cC(this.jUJ, 2);
            }
            BF(2);
        }
    }

    /* loaded from: classes9.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b jUS;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.jUS = bVar;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.jUS != null) {
                this.jUS.cC(b.this.jUJ, 1);
            }
            b.this.BF(1);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.jUS != null) {
                this.jUS.cC(b.this.jUJ, 2);
            }
            b.this.ba(2, uiError != null ? uiError.errorMessage : null);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.jUS != null) {
                this.jUS.cC(b.this.jUJ, 3);
            }
            if (b.this.jUJ != 8 && b.this.jUJ == 4) {
            }
        }
    }
}
