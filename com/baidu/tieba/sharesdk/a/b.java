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
    protected int mEK;
    protected Tencent mER;
    IUiListener mES;
    ShareEntity mET;
    private final com.baidu.adp.lib.e.b<f.a> mEU;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> mEV;

    public b(Context context) {
        super(context);
        this.mEK = 8;
        this.mEU = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.eJF != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.mES);
                } else {
                    b.this.dm(2, b.this.mEK);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                b.this.dm(3, b.this.mEK);
            }
        };
        this.mEV = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.b.2
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
                            return b.this.a(aVarArr[0].getRawBitmap(), b.this.mET, true);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public void onPostExecute(Bitmap bitmap) {
                            super.onPostExecute((AnonymousClass1) bitmap);
                            b.this.a(b.this.mET, b.this.mES);
                        }
                    };
                    bdAsyncTask.setPriority(3);
                    bdAsyncTask.execute(aVar);
                }
            }
        };
        this.mER = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.mER == null) {
            dm(2, this.mEK);
            if (bVar != null) {
                bVar.dl(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            dm(2, this.mEK);
            if (bVar != null) {
                bVar.dl(0, 2);
            }
        } else {
            this.mES = new a(bVar);
            String bhW = shareEntity.bhW();
            if (CN(shareEntity.dDo())) {
                a(shareEntity.dDo(), this.mES);
            } else if (shareEntity.dDq() != 0 && !TextUtils.isEmpty(bhW) && (bhW.startsWith("http://") || bhW.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                com.baidu.adp.lib.e.c.mS().a(bhW, 34, this.mEU, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                this.mET = shareEntity;
                if (this.mET.dDn()) {
                    com.baidu.adp.lib.e.c.mS().a(shareEntity.bhW(), 10, this.mEV, 0, 0, getPageId(), new Object[0]);
                } else {
                    a(shareEntity, this.mES);
                }
            } else if (u(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.mES);
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
            if (shareEntity.dDm() >= 0) {
                if (shareEntity.dDm() < 10000) {
                    bundle.putString("summary", this.context.getString(R.string.share_qq_default_content));
                } else {
                    bundle.putString("summary", at.numberUniformFormatExtra(shareEntity.dDm()) + this.context.getString(R.string.share_qq_content));
                }
            } else {
                bundle.putString("summary", shareEntity.getContent());
            }
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            bundle.putInt("req_type", 1);
            if (shareEntity.dDn() && !StringUtils.isNull(shareEntity.bhW()) && !shareEntity.bhW().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                bundle.putString("imageLocalUrl", shareEntity.bhW());
            } else {
                bundle.putString("imageUrl", shareEntity.bhW());
            }
            this.mER.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.mER.shareToQQ((Activity) this.context, bundle, iUiListener);
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
                    bVar.dl(this.mEK, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.dl(this.mEK, 2);
            }
            dm(2, this.mEK);
        }
    }

    /* loaded from: classes24.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b mEY;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.mEY = bVar;
        }

        private void dDw() {
            n.deleteFile(new File(com.baidu.tieba.sharesdk.a.a.mEP + com.baidu.tieba.sharesdk.a.a.mEQ));
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.mEY != null) {
                this.mEY.dl(b.this.mEK, 1);
            }
            b.this.dm(1, b.this.mEK);
            dDw();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.mEY != null) {
                this.mEY.dl(b.this.mEK, 2);
            }
            b.this.g(2, uiError != null ? uiError.errorMessage : null, b.this.mEK);
            dDw();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.mEY != null) {
                this.mEY.dl(b.this.mEK, 3);
            }
            if (b.this.mEK != 8 && b.this.mEK == 4) {
            }
            dDw();
        }
    }
}
