package com.baidu.tieba.sharesdk.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.util.e.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.sharesdk.a.a {
    protected int iXI;
    protected Tencent iXO;
    IUiListener iXP;
    private final com.baidu.adp.lib.f.b<f.a> iXQ;

    public b(Context context) {
        super(context);
        this.iXI = 8;
        this.iXQ = new com.baidu.adp.lib.f.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.bWG != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.iXP);
                } else {
                    b.this.Ax(2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                b.this.Ax(3);
            }
        };
        this.iXO = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.iXO == null) {
            Ax(2);
            if (bVar != null) {
                bVar.cs(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            Ax(2);
            if (bVar != null) {
                bVar.cs(0, 2);
            }
        } else {
            this.iXP = new a(bVar);
            String acZ = shareEntity.acZ();
            if (pO(shareEntity.cmP())) {
                a(shareEntity.cmP(), this.iXP);
            } else if (shareEntity.cmR() != 0 && !TextUtils.isEmpty(acZ) && (acZ.startsWith("http://") || acZ.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                com.baidu.adp.lib.f.c.iE().a(acZ, 34, this.iXQ, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                a(shareEntity, this.iXP);
            } else if (w(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.iXP);
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
            bundle.putString("imageUrl", shareEntity.acZ());
            this.iXO.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.iXO.shareToQQ((Activity) this.context, bundle, iUiListener);
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
                    bVar.cs(this.iXI, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.cs(this.iXI, 2);
            }
            Ax(2);
        }
    }

    /* loaded from: classes6.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b iXS;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.iXS = bVar;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.iXS != null) {
                this.iXS.cs(b.this.iXI, 1);
            }
            b.this.Ax(1);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.iXS != null) {
                this.iXS.cs(b.this.iXI, 2);
            }
            b.this.aE(2, uiError != null ? uiError.errorMessage : null);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.iXS != null) {
                this.iXS.cs(b.this.iXI, 3);
            }
            if (b.this.iXI != 8 && b.this.iXI == 4) {
            }
        }
    }
}
