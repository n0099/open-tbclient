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
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.sharesdk.a.a {
    protected int iUj;
    protected Tencent iUp;
    IUiListener iUq;
    private final com.baidu.adp.lib.f.b<f.a> iUr;

    public b(Context context) {
        super(context);
        this.iUj = 8;
        this.iUr = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.bVJ != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.iUq);
                } else {
                    b.this.As(2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                b.this.As(3);
            }
        };
        this.iUp = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.iUp == null) {
            As(2);
            if (bVar != null) {
                bVar.cs(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            As(2);
            if (bVar != null) {
                bVar.cs(0, 2);
            }
        } else {
            this.iUq = new a(bVar);
            String acU = shareEntity.acU();
            if (pD(shareEntity.clL())) {
                a(shareEntity.clL(), this.iUq);
            } else if (shareEntity.clN() != 0 && !TextUtils.isEmpty(acU) && (acU.startsWith("http://") || acU.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                com.baidu.adp.lib.f.c.iE().a(acU, 34, this.iUr, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                a(shareEntity, this.iUq);
            } else if (w(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.iUq);
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
            bundle.putString("imageUrl", shareEntity.acU());
            this.iUp.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.iUp.shareToQQ((Activity) this.context, bundle, iUiListener);
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
                    bVar.cs(this.iUj, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.cs(this.iUj, 2);
            }
            As(2);
        }
    }

    /* loaded from: classes6.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b iUt;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.iUt = bVar;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.iUt != null) {
                this.iUt.cs(b.this.iUj, 1);
            }
            b.this.As(1);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.iUt != null) {
                this.iUt.cs(b.this.iUj, 2);
            }
            b.this.aE(2, uiError != null ? uiError.errorMessage : null);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.iUt != null) {
                this.iUt.cs(b.this.iUj, 3);
            }
            if (b.this.iUj != 8 && b.this.iUj == 4) {
            }
        }
    }
}
