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
    protected int msf;
    protected Tencent msn;
    IUiListener mso;
    ShareEntity msp;
    private final com.baidu.adp.lib.e.b<f.a> msq;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> msr;

    public b(Context context) {
        super(context);
        this.msf = 8;
        this.msq = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.eBj != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.mso);
                } else {
                    b.this.dk(2, b.this.msf);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                b.this.dk(3, b.this.msf);
            }
        };
        this.msr = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.b.2
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
                            return b.this.a(aVarArr[0].getRawBitmap(), b.this.msp, true);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public void onPostExecute(Bitmap bitmap) {
                            super.onPostExecute((AnonymousClass1) bitmap);
                            b.this.a(b.this.msp, b.this.mso);
                        }
                    };
                    bdAsyncTask.setPriority(3);
                    bdAsyncTask.execute(aVar);
                }
            }
        };
        this.msn = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.msn == null) {
            dk(2, this.msf);
            if (bVar != null) {
                bVar.dj(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            dk(2, this.msf);
            if (bVar != null) {
                bVar.dj(0, 2);
            }
        } else {
            this.mso = new a(bVar);
            String bgd = shareEntity.bgd();
            if (Cu(shareEntity.dAg())) {
                a(shareEntity.dAg(), this.mso);
            } else if (shareEntity.dAi() != 0 && !TextUtils.isEmpty(bgd) && (bgd.startsWith("http://") || bgd.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                com.baidu.adp.lib.e.c.mS().a(bgd, 34, this.msq, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                this.msp = shareEntity;
                if (this.msp.dAf()) {
                    com.baidu.adp.lib.e.c.mS().a(shareEntity.bgd(), 10, this.msr, 0, 0, getPageId(), new Object[0]);
                } else {
                    a(shareEntity, this.mso);
                }
            } else if (u(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.mso);
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
            if (shareEntity.dAe() >= 0) {
                if (shareEntity.dAe() < 10000) {
                    bundle.putString("summary", this.context.getString(R.string.share_qq_default_content));
                } else {
                    bundle.putString("summary", at.numberUniformFormatExtra(shareEntity.dAe()) + this.context.getString(R.string.share_qq_content));
                }
            } else {
                bundle.putString("summary", shareEntity.getContent());
            }
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            bundle.putInt("req_type", 1);
            if (shareEntity.dAf() && !StringUtils.isNull(shareEntity.bgd()) && !shareEntity.bgd().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                bundle.putString("imageLocalUrl", shareEntity.bgd());
            } else {
                bundle.putString("imageUrl", shareEntity.bgd());
            }
            this.msn.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.msn.shareToQQ((Activity) this.context, bundle, iUiListener);
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
                    bVar.dj(this.msf, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.dj(this.msf, 2);
            }
            dk(2, this.msf);
        }
    }

    /* loaded from: classes24.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b msu;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.msu = bVar;
        }

        private void dAo() {
            n.deleteFile(new File(com.baidu.tieba.sharesdk.a.a.msl + com.baidu.tieba.sharesdk.a.a.msm));
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.msu != null) {
                this.msu.dj(b.this.msf, 1);
            }
            b.this.dk(1, b.this.msf);
            dAo();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.msu != null) {
                this.msu.dj(b.this.msf, 2);
            }
            b.this.g(2, uiError != null ? uiError.errorMessage : null, b.this.msf);
            dAo();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.msu != null) {
                this.msu.dj(b.this.msf, 3);
            }
            if (b.this.msf != 8 && b.this.msf == 4) {
            }
            dAo();
        }
    }
}
