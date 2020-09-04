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
/* loaded from: classes18.dex */
public class b extends com.baidu.tieba.sharesdk.a.a {
    protected int lTe;
    protected Tencent lTl;
    IUiListener lTm;
    ShareEntity lTn;
    private final com.baidu.adp.lib.e.b<f.a> lTo;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> lTp;

    public b(Context context) {
        super(context);
        this.lTe = 8;
        this.lTo = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.emE != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.lTm);
                } else {
                    b.this.dg(2, b.this.lTe);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                b.this.dg(3, b.this.lTe);
            }
        };
        this.lTp = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.b.2
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
                            return b.this.a(aVarArr[0].getRawBitmap(), b.this.lTn, true);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public void onPostExecute(Bitmap bitmap) {
                            super.onPostExecute((AnonymousClass1) bitmap);
                            b.this.a(b.this.lTn, b.this.lTm);
                        }
                    };
                    bdAsyncTask.setPriority(3);
                    bdAsyncTask.execute(aVar);
                }
            }
        };
        this.lTl = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.lTl == null) {
            dg(2, this.lTe);
            if (bVar != null) {
                bVar.df(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            dg(2, this.lTe);
            if (bVar != null) {
                bVar.df(0, 2);
            }
        } else {
            this.lTm = new a(bVar);
            String bcA = shareEntity.bcA();
            if (Bm(shareEntity.dsD())) {
                a(shareEntity.dsD(), this.lTm);
            } else if (shareEntity.dsF() != 0 && !TextUtils.isEmpty(bcA) && (bcA.startsWith("http://") || bcA.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                com.baidu.adp.lib.e.c.mM().a(bcA, 34, this.lTo, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                this.lTn = shareEntity;
                if (this.lTn.dsC()) {
                    com.baidu.adp.lib.e.c.mM().a(shareEntity.bcA(), 10, this.lTp, 0, 0, getPageId(), new Object[0]);
                } else {
                    a(shareEntity, this.lTm);
                }
            } else if (t(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.lTm);
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
            if (shareEntity.dsB() >= 0) {
                if (shareEntity.dsB() < 10000) {
                    bundle.putString("summary", this.context.getString(R.string.share_qq_default_content));
                } else {
                    bundle.putString("summary", at.numberUniformFormatExtra(shareEntity.dsB()) + this.context.getString(R.string.share_qq_content));
                }
            } else {
                bundle.putString("summary", shareEntity.getContent());
            }
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            bundle.putInt("req_type", 1);
            if (shareEntity.dsC() && !StringUtils.isNull(shareEntity.bcA()) && !shareEntity.bcA().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                bundle.putString("imageLocalUrl", shareEntity.bcA());
            } else {
                bundle.putString("imageUrl", shareEntity.bcA());
            }
            this.lTl.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.lTl.shareToQQ((Activity) this.context, bundle, iUiListener);
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
                    bVar.df(this.lTe, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.df(this.lTe, 2);
            }
            dg(2, this.lTe);
        }
    }

    /* loaded from: classes18.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b lTs;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.lTs = bVar;
        }

        private void dsL() {
            n.deleteFile(new File(com.baidu.tieba.sharesdk.a.a.lTj + com.baidu.tieba.sharesdk.a.a.lTk));
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.lTs != null) {
                this.lTs.df(b.this.lTe, 1);
            }
            b.this.dg(1, b.this.lTe);
            dsL();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.lTs != null) {
                this.lTs.df(b.this.lTe, 2);
            }
            b.this.g(2, uiError != null ? uiError.errorMessage : null, b.this.lTe);
            dsL();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.lTs != null) {
                this.lTs.df(b.this.lTe, 3);
            }
            if (b.this.lTe != 8 && b.this.lTe == 4) {
            }
            dsL();
        }
    }
}
