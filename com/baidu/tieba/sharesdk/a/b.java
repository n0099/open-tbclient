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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.d.e;
import com.baidu.tbadk.core.util.o;
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
    protected int njW;
    protected Tencent nke;
    IUiListener nkf;
    ShareEntity nkg;
    private final com.baidu.adp.lib.e.c<e.a> nkh;
    private com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> nki;

    public b(Context context) {
        super(context);
        this.njW = 8;
        this.nkh = new com.baidu.adp.lib.e.c<e.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void onLoaded(e.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.fcS != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.nkf);
                } else {
                    b.this.dm(2, b.this.njW);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                super.onCancelled(str);
                b.this.dm(3, b.this.njW);
            }
        };
        this.nki = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.b.2
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
                            return b.this.a(aVarArr[0].getRawBitmap(), b.this.nkg, true);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public void onPostExecute(Bitmap bitmap) {
                            super.onPostExecute((AnonymousClass1) bitmap);
                            b.this.a(b.this.nkg, b.this.nkf);
                        }
                    };
                    bdAsyncTask.setPriority(3);
                    bdAsyncTask.execute(aVar);
                }
            }
        };
        this.nke = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.nke == null) {
            dm(2, this.njW);
            if (bVar != null) {
                bVar.dl(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            dm(2, this.njW);
            if (bVar != null) {
                bVar.dl(0, 2);
            }
        } else {
            this.nkf = new a(bVar);
            String imgUrl = shareEntity.getImgUrl();
            if (Cl(shareEntity.dJa())) {
                a(shareEntity.dJa(), this.nkf);
            } else if (shareEntity.dJc() != 0 && !TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                com.baidu.adp.lib.e.d.mw().a(imgUrl, 34, this.nkh, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                this.nkg = shareEntity;
                if (this.nkg.dIZ()) {
                    com.baidu.adp.lib.e.d.mw().a(shareEntity.getImgUrl(), 10, this.nki, 0, 0, getPageId(), new Object[0]);
                } else {
                    a(shareEntity, this.nkf);
                }
            } else if (z(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.nkf);
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
            if (shareEntity.dIY() >= 0) {
                if (shareEntity.dIY() < 10000) {
                    bundle.putString("summary", this.context.getString(R.string.share_qq_default_content));
                } else {
                    bundle.putString("summary", au.numberUniformFormatExtra(shareEntity.dIY()) + this.context.getString(R.string.share_qq_content));
                }
            } else {
                bundle.putString("summary", shareEntity.getContent());
            }
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            bundle.putInt("req_type", 1);
            if (shareEntity.dIZ() && !StringUtils.isNull(shareEntity.getImgUrl()) && !shareEntity.getImgUrl().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                bundle.putString("imageLocalUrl", shareEntity.getImgUrl());
            } else {
                bundle.putString("imageUrl", shareEntity.getImgUrl());
            }
            this.nke.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.nke.shareToQQ((Activity) this.context, bundle, iUiListener);
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
                    bVar.dl(this.njW, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.dl(this.njW, 2);
            }
            dm(2, this.njW);
        }
    }

    /* loaded from: classes8.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b nkl;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.nkl = bVar;
        }

        private void dJi() {
            o.deleteFile(new File(com.baidu.tieba.sharesdk.a.a.nkb + com.baidu.tieba.sharesdk.a.a.nkc));
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.nkl != null) {
                this.nkl.dl(b.this.njW, 1);
            }
            b.this.dm(1, b.this.njW);
            dJi();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.nkl != null) {
                this.nkl.dl(b.this.njW, 2);
            }
            b.this.h(2, uiError != null ? uiError.errorMessage : null, b.this.njW);
            dJi();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.nkl != null) {
                this.nkl.dl(b.this.njW, 3);
            }
            if (b.this.njW != 8 && b.this.njW == 4) {
            }
            dJi();
        }
    }
}
