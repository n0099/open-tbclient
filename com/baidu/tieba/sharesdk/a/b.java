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
    protected Tencent jXB;
    IUiListener jXC;
    ShareEntity jXD;
    private final com.baidu.adp.lib.e.b<f.a> jXE;
    private com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> jXF;
    protected int jXu;

    public b(Context context) {
        super(context);
        this.jXu = 8;
        this.jXE = new com.baidu.adp.lib.e.b<f.a>() { // from class: com.baidu.tieba.sharesdk.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            /* renamed from: a */
            public void onLoaded(f.a aVar, String str, int i) {
                super.onLoaded(aVar, str, i);
                if (aVar != null && aVar.dce != null && !TextUtils.isEmpty(aVar.path)) {
                    b.this.a(aVar.path, b.this.jXC);
                } else {
                    b.this.cF(2, b.this.jXu);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                b.this.cF(3, b.this.jXu);
            }
        };
        this.jXF = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.b.2
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
                            return b.this.a(aVarArr[0].getRawBitmap(), b.this.jXD, true);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                        public void onPostExecute(Bitmap bitmap) {
                            super.onPostExecute((AnonymousClass1) bitmap);
                            b.this.a(b.this.jXD, b.this.jXC);
                        }
                    };
                    bdAsyncTask.setPriority(3);
                    bdAsyncTask.execute(aVar);
                }
            }
        };
        this.jXB = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.jXB == null) {
            cF(2, this.jXu);
            if (bVar != null) {
                bVar.cE(0, 2);
            }
        } else if (this.context == null || !(this.context instanceof Activity)) {
            cF(2, this.jXu);
            if (bVar != null) {
                bVar.cE(0, 2);
            }
        } else {
            this.jXC = new a(bVar);
            String aAJ = shareEntity.aAJ();
            if (uz(shareEntity.cHO())) {
                a(shareEntity.cHO(), this.jXC);
            } else if (shareEntity.cHQ() != 0 && !TextUtils.isEmpty(aAJ) && (aAJ.startsWith("http://") || aAJ.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
                com.baidu.adp.lib.e.c.gr().a(aAJ, 34, this.jXE, 0, 0, getPageId(), new Object[0]);
            } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                this.jXD = shareEntity;
                if (this.jXD.cHN()) {
                    com.baidu.adp.lib.e.c.gr().a(shareEntity.aAJ(), 10, this.jXF, 0, 0, getPageId(), new Object[0]);
                } else {
                    a(shareEntity, this.jXC);
                }
            } else if (w(shareEntity.getImageUri())) {
                a(shareEntity.getImageUri().getPath(), this.jXC);
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
            if (shareEntity.cHM() >= 0) {
                if (shareEntity.cHM() < 10000) {
                    bundle.putString("summary", this.context.getString(R.string.share_qq_default_content));
                } else {
                    bundle.putString("summary", aq.numberUniformFormatExtra(shareEntity.cHM()) + this.context.getString(R.string.share_qq_content));
                }
            } else {
                bundle.putString("summary", shareEntity.getContent());
            }
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            bundle.putInt("req_type", 1);
            if (shareEntity.cHN() && !StringUtils.isNull(shareEntity.aAJ()) && !shareEntity.aAJ().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                bundle.putString("imageLocalUrl", shareEntity.aAJ());
            } else {
                bundle.putString("imageUrl", shareEntity.aAJ());
            }
            this.jXB.shareToQQ((Activity) this.context, bundle, iUiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IUiListener iUiListener) {
        if (!TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.jXB.shareToQQ((Activity) this.context, bundle, iUiListener);
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
                    bVar.cE(this.jXu, 1);
                    return;
                }
                return;
            }
            if (bVar != null) {
                bVar.cE(this.jXu, 2);
            }
            cF(2, this.jXu);
        }
    }

    /* loaded from: classes11.dex */
    protected class a implements IUiListener {
        private com.baidu.tieba.sharesdk.b.b jXI;

        public a(com.baidu.tieba.sharesdk.b.b bVar) {
            this.jXI = bVar;
        }

        private void cHV() {
            m.deleteFile(new File(com.baidu.tieba.sharesdk.a.a.jXz + com.baidu.tieba.sharesdk.a.a.jXA));
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (this.jXI != null) {
                this.jXI.cE(b.this.jXu, 1);
            }
            b.this.cF(1, b.this.jXu);
            cHV();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.jXI != null) {
                this.jXI.cE(b.this.jXu, 2);
            }
            b.this.l(2, uiError != null ? uiError.errorMessage : null, b.this.jXu);
            cHV();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.jXI != null) {
                this.jXI.cE(b.this.jXu, 3);
            }
            if (b.this.jXu != 8 && b.this.jXu == 4) {
            }
            cHV();
        }
    }
}
