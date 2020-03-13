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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.c.f;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.Iterator;
import org.apache.http.HttpHost;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.sharesdk.a.a {
    protected int jVS;
    protected Tencent jVZ;
    IUiListener jWa;
    ShareEntity jWb;
    private final com.baidu.adp.lib.e.b<f.a> jWc;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> jWd;

    public b(Context context) {
        super(context);
        this.jVS = 8;
        this.jWc = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.dbR != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.jWa);
                } else {
                    b.this.cE(2, b.this.jVS);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                b.this.cE(3, b.this.jVS);
            }
        };
        this.jWd = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.b.2
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
                            return b.this.a(aVarArr[0].getRawBitmap(), b.this.jWb, true);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public void onPostExecute(Bitmap bitmap) {
                            super.onPostExecute((AnonymousClass1) bitmap);
                            b.this.a(b.this.jWb, b.this.jWa);
                        }
                    };
                    bdAsyncTask.setPriority(3);
                    bdAsyncTask.execute(aVar);
                }
            }
        };
        this.jVZ = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.jVZ == null) {
            cE(2, this.jVS);
            if (bVar != null) {
                bVar.cD(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            cE(2, this.jVS);
            if (bVar != null) {
                bVar.cD(0, 2);
            }
        } else {
            this.jWa = new a(bVar);
            String aAG = shareEntity.aAG();
            if (uz(shareEntity.cHu())) {
                a(shareEntity.cHu(), this.jWa);
            } else if (shareEntity.cHw() != 0 && !TextUtils.isEmpty(aAG) && (aAG.startsWith("http://") || aAG.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                com.baidu.adp.lib.e.c.gr().a(aAG, 34, this.jWc, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                this.jWb = shareEntity;
                if (this.jWb.cHt()) {
                    com.baidu.adp.lib.e.c.gr().a(shareEntity.aAG(), 10, this.jWd, 0, 0, getPageId(), new Object[0]);
                } else {
                    a(shareEntity, this.jWa);
                }
            } else if (w(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.jWa);
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
            if (shareEntity.cHs() >= 0) {
                if (shareEntity.cHs() < 10000) {
                    bundle.putString("summary", this.context.getString(R.string.share_qq_default_content));
                } else {
                    bundle.putString("summary", aq.numberUniformFormatExtra(shareEntity.cHs()) + this.context.getString(R.string.share_qq_content));
                }
            } else {
                bundle.putString("summary", shareEntity.getContent());
            }
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            bundle.putInt("req_type", 1);
            if (shareEntity.cHt() && !StringUtils.isNull(shareEntity.aAG()) && !shareEntity.aAG().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                bundle.putString("imageLocalUrl", shareEntity.aAG());
            } else {
                bundle.putString("imageUrl", shareEntity.aAG());
            }
            this.jVZ.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.jVZ.shareToQQ((Activity) this.context, bundle, iUiListener);
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
                    bVar.cD(this.jVS, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.cD(this.jVS, 2);
            }
            cE(2, this.jVS);
        }
    }

    /* loaded from: classes11.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b jWg;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.jWg = bVar;
        }

        private void cHB() {
            m.deleteFile(new File(com.baidu.tieba.sharesdk.a.a.jVX + com.baidu.tieba.sharesdk.a.a.jVY));
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.jWg != null) {
                this.jWg.cD(b.this.jVS, 1);
            }
            b.this.cE(1, b.this.jVS);
            cHB();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.jWg != null) {
                this.jWg.cD(b.this.jVS, 2);
            }
            b.this.l(2, uiError != null ? uiError.errorMessage : null, b.this.jVS);
            cHB();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.jWg != null) {
                this.jWg.cD(b.this.jVS, 3);
            }
            if (b.this.jVS != 8 && b.this.jVS == 4) {
            }
            cHB();
        }
    }
}
