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
    protected int iNN;
    protected Tencent iNT;
    IUiListener iNU;
    private final com.baidu.adp.lib.f.b<f.a> iNV;

    public b(Context context) {
        super(context);
        this.iNN = 8;
        this.iNV = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.bUH != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.iNU);
                } else {
                    b.this.zM(2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                b.this.zM(3);
            }
        };
        this.iNT = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.iNT == null) {
            zM(2);
            if (bVar != null) {
                bVar.cm(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            zM(2);
            if (bVar != null) {
                bVar.cm(0, 2);
            }
        } else {
            this.iNU = new a(bVar);
            String abS = shareEntity.abS();
            if (pn(shareEntity.ciT())) {
                a(shareEntity.ciT(), this.iNU);
            } else if (shareEntity.ciV() != 0 && !TextUtils.isEmpty(abS) && (abS.startsWith("http://") || abS.startsWith("https://"))) {
                com.baidu.adp.lib.f.c.iv().a(abS, 34, this.iNV, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                a(shareEntity, this.iNU);
            } else if (w(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.iNU);
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
            bundle.putString("imageUrl", shareEntity.abS());
            this.iNT.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.iNT.shareToQQ((Activity) this.context, bundle, iUiListener);
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
                    bVar.cm(this.iNN, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.cm(this.iNN, 2);
            }
            zM(2);
        }
    }

    /* loaded from: classes6.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b iNX;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.iNX = bVar;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.iNX != null) {
                this.iNX.cm(b.this.iNN, 1);
            }
            b.this.zM(1);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.iNX != null) {
                this.iNX.cm(b.this.iNN, 2);
            }
            b.this.aE(2, uiError != null ? uiError.errorMessage : null);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.iNX != null) {
                this.iNX.cm(b.this.iNN, 3);
            }
            if (b.this.iNN != 8 && b.this.iNN == 4) {
            }
        }
    }
}
