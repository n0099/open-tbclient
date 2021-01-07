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
import com.baidu.tbadk.core.util.d.e;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.Iterator;
import org.apache.http.HttpHost;
/* loaded from: classes8.dex */
public class b extends com.baidu.tieba.sharesdk.a.a {
    protected int neT;
    protected Tencent nfb;
    IUiListener nfc;
    ShareEntity nfd;
    private final com.baidu.adp.lib.e.c<e.a> nfe;
    private com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> nff;

    public b(Context context) {
        super(context);
        this.neT = 8;
        this.nfe = new com.baidu.adp.lib.e.c<e.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void onLoaded(e.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.ffl != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.nfc);
                } else {
                    b.this.dp(2, b.this.neT);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                super.onCancelled(str);
                b.this.dp(3, b.this.neT);
            }
        };
        this.nff = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
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
                            return b.this.a(aVarArr[0].getRawBitmap(), b.this.nfd, true);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public void onPostExecute(Bitmap bitmap) {
                            super.onPostExecute((AnonymousClass1) bitmap);
                            b.this.a(b.this.nfd, b.this.nfc);
                        }
                    };
                    bdAsyncTask.setPriority(3);
                    bdAsyncTask.execute(aVar);
                }
            }
        };
        this.nfb = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.nfb == null) {
            dp(2, this.neT);
            if (bVar != null) {
                bVar.mo52do(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            dp(2, this.neT);
            if (bVar != null) {
                bVar.mo52do(0, 2);
            }
        } else {
            this.nfc = new a(bVar);
            String imgUrl = shareEntity.getImgUrl();
            if (Df(shareEntity.dKH())) {
                a(shareEntity.dKH(), this.nfc);
            } else if (shareEntity.dKJ() != 0 && !TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                com.baidu.adp.lib.e.d.mx().a(imgUrl, 34, this.nfe, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                this.nfd = shareEntity;
                if (this.nfd.dKG()) {
                    com.baidu.adp.lib.e.d.mx().a(shareEntity.getImgUrl(), 10, this.nff, 0, 0, getPageId(), new Object[0]);
                } else {
                    a(shareEntity, this.nfc);
                }
            } else if (w(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.nfc);
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
            if (shareEntity.dKF() >= 0) {
                if (shareEntity.dKF() < 10000) {
                    bundle.putString("summary", this.context.getString(R.string.share_qq_default_content));
                } else {
                    bundle.putString("summary", at.numberUniformFormatExtra(shareEntity.dKF()) + this.context.getString(R.string.share_qq_content));
                }
            } else {
                bundle.putString("summary", shareEntity.getContent());
            }
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            bundle.putInt("req_type", 1);
            if (shareEntity.dKG() && !StringUtils.isNull(shareEntity.getImgUrl()) && !shareEntity.getImgUrl().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                bundle.putString("imageLocalUrl", shareEntity.getImgUrl());
            } else {
                bundle.putString("imageUrl", shareEntity.getImgUrl());
            }
            this.nfb.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.nfb.shareToQQ((Activity) this.context, bundle, iUiListener);
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
                    bVar.mo52do(this.neT, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.mo52do(this.neT, 2);
            }
            dp(2, this.neT);
        }
    }

    /* loaded from: classes8.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b nfi;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.nfi = bVar;
        }

        private void dKP() {
            n.deleteFile(new File(com.baidu.tieba.sharesdk.a.a.neY + com.baidu.tieba.sharesdk.a.a.neZ));
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.nfi != null) {
                this.nfi.mo52do(b.this.neT, 1);
            }
            b.this.dp(1, b.this.neT);
            dKP();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.nfi != null) {
                this.nfi.mo52do(b.this.neT, 2);
            }
            b.this.g(2, uiError != null ? uiError.errorMessage : null, b.this.neT);
            dKP();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.nfi != null) {
                this.nfi.mo52do(b.this.neT, 3);
            }
            if (b.this.neT != 8 && b.this.neT == 4) {
            }
            dKP();
        }
    }
}
