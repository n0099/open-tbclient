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
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.sharesdk.a.a {
    protected int gZr;
    protected Tencent gZx;
    IUiListener gZy;
    private final com.baidu.adp.lib.f.b<f.a> gZz;

    public b(Context context) {
        super(context);
        this.gZr = 8;
        this.gZz = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.aEv != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.gZy);
                } else {
                    b.this.uE(2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                b.this.uE(3);
            }
        };
        this.gZx = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gZx == null) {
            uE(2);
            if (bVar != null) {
                bVar.bI(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            uE(2);
            if (bVar != null) {
                bVar.bI(0, 2);
            }
        } else {
            this.gZy = new a(bVar);
            String ys = shareEntity.ys();
            if (shareEntity.byD() != 0 && !TextUtils.isEmpty(ys) && (ys.startsWith("http://") || ys.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                com.baidu.adp.lib.f.c.jA().a(ys, 34, this.gZz, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                a(shareEntity, this.gZy);
            } else if (i(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.gZy);
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
            bundle.putString("imageUrl", shareEntity.ys());
            this.gZx.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.gZx.shareToQQ((Activity) this.context, bundle, iUiListener);
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
            if (com.baidu.tieba.sharesdk.c.a.h(this.context, intent2)) {
                if (bVar != null) {
                    bVar.bI(this.gZr, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.bI(this.gZr, 2);
            }
            uE(2);
        }
    }

    /* loaded from: classes3.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b gZB;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.gZB = bVar;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.gZB != null) {
                this.gZB.bI(b.this.gZr, 1);
            }
            b.this.uE(1);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.gZB != null) {
                this.gZB.bI(b.this.gZr, 2);
            }
            b.this.ag(2, uiError != null ? uiError.errorMessage : null);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.gZB != null) {
                this.gZB.bI(b.this.gZr, 3);
            }
            if (b.this.gZr != 8 && b.this.gZr == 4) {
                b.this.uE(3);
            }
        }
    }
}
