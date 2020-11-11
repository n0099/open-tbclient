package com.baidu.tieba.sharesdk.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.c.f;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.Iterator;
import org.apache.http.HttpHost;
/* loaded from: classes24.dex */
public class b extends com.baidu.tieba.sharesdk.a.a {
    protected int mKM;
    protected Tencent mKT;
    IUiListener mKU;
    ShareEntity mKV;
    private final com.baidu.adp.lib.e.b<f.a> mKW;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> mKX;

    public b(Context context) {
        super(context);
        this.mKM = 8;
        this.mKW = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.ePu != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.mKU);
                } else {
                    b.this.m43do(2, b.this.mKM);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                b.this.m43do(3, b.this.mKM);
            }
        };
        this.mKX = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (aVar != null) {
                    BdAsyncTask<com.baidu.adp.widget.ImageView.a, Void, Bitmap> bdAsyncTask = new BdAsyncTask<com.baidu.adp.widget.ImageView.a, Void, Bitmap>() { // from class: com.baidu.tieba.sharesdk.a.b.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        /* renamed from: a */
                        public Bitmap doInBackground(com.baidu.adp.widget.ImageView.a... aVarArr) {
                            if (aVarArr.length <= 0 || aVarArr[0] == null) {
                                return null;
                            }
                            return b.this.a(aVarArr[0].getRawBitmap(), b.this.mKV, true);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public void onPostExecute(Bitmap bitmap) {
                            super.onPostExecute((AnonymousClass1) bitmap);
                            b.this.a(b.this.mKV, b.this.mKU);
                        }
                    };
                    bdAsyncTask.setPriority(3);
                    bdAsyncTask.execute(aVar);
                }
            }
        };
        this.mKT = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.mKT == null) {
            m43do(2, this.mKM);
            if (bVar != null) {
                bVar.dn(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            m43do(2, this.mKM);
            if (bVar != null) {
                bVar.dn(0, 2);
            }
        } else {
            this.mKU = new a(bVar);
            String bkw = shareEntity.bkw();
            if (Db(shareEntity.dFQ())) {
                a(shareEntity.dFQ(), this.mKU);
            } else if (shareEntity.dFS() != 0 && !TextUtils.isEmpty(bkw) && (bkw.startsWith("http://") || bkw.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                com.baidu.adp.lib.e.c.mS().a(bkw, 34, this.mKW, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                this.mKV = shareEntity;
                if (this.mKV.dFP()) {
                    com.baidu.adp.lib.e.c.mS().a(shareEntity.bkw(), 10, this.mKX, 0, 0, getPageId(), new Object[0]);
                } else {
                    a(shareEntity, this.mKU);
                }
            } else if (u(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.mKU);
            } else {
                b(shareEntity, bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, IUiListener iUiListener) {
        if (shareEntity != null && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("title", shareEntity.getTitle());
            if (shareEntity.dFO() >= 0) {
                if (shareEntity.dFO() < 10000) {
                    bundle.putString("summary", this.context.getString(R.string.share_qq_default_content));
                } else {
                    bundle.putString("summary", at.numberUniformFormatExtra(shareEntity.dFO()) + this.context.getString(R.string.share_qq_content));
                }
            } else {
                bundle.putString("summary", shareEntity.getContent());
            }
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            bundle.putInt("req_type", 1);
            if (shareEntity.dFP() && !StringUtils.isNull(shareEntity.bkw()) && !shareEntity.bkw().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                bundle.putString("imageLocalUrl", shareEntity.bkw());
            } else {
                bundle.putString("imageUrl", shareEntity.bkw());
            }
            this.mKT.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.mKT.shareToQQ((Activity) this.context, bundle, iUiListener);
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
                    bVar.dn(this.mKM, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.dn(this.mKM, 2);
            }
            m43do(2, this.mKM);
        }
    }

    /* loaded from: classes24.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b mLa;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.mLa = bVar;
        }

        private void dFY() {
            n.deleteFile(new File(com.baidu.tieba.sharesdk.a.a.mKR + com.baidu.tieba.sharesdk.a.a.mKS));
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.mLa != null) {
                this.mLa.dn(b.this.mKM, 1);
            }
            b.this.m43do(1, b.this.mKM);
            dFY();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.mLa != null) {
                this.mLa.dn(b.this.mKM, 2);
            }
            b.this.g(2, uiError != null ? uiError.errorMessage : null, b.this.mKM);
            dFY();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.mLa != null) {
                this.mLa.dn(b.this.mKM, 3);
            }
            if (b.this.mKM != 8 && b.this.mKM == 4) {
            }
            dFY();
        }
    }
}
