package com.baidu.tieba.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class a<T> {
    public T a;
    private String d;
    private h f;
    private b<T> b = null;
    private d c = null;
    private a<T>.c e = null;

    public a(String str, String str2) {
        this.d = null;
        this.d = str;
        this.f = new h(str2);
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.f.a(i, i2, i3, i4);
    }

    public final void a() {
        if (this.e == null) {
            this.e = new c(this, (byte) 0);
            this.e.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    final class c extends BdAsyncTask<String, Integer, ImageUploadResult> implements i {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public final /* synthetic */ ImageUploadResult a(String... strArr) {
            a.this.f.a(this, null);
            ImageUploadResult a = a.this.f.a(a.this.d);
            c((Object[]) new Integer[]{100});
            return a;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public final /* synthetic */ void a(ImageUploadResult imageUploadResult) {
            ImageUploadResult imageUploadResult2 = imageUploadResult;
            super.a((c) imageUploadResult2);
            a.this.e = null;
            if (a.this.c != null) {
                if (imageUploadResult2 == null) {
                    imageUploadResult2 = new ImageUploadResult();
                    imageUploadResult2.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult2.error_msg = TiebaApplication.g().b().getString(R.string.send_error);
                    cb.a("", -1002, imageUploadResult2.error_msg, "");
                }
                a.this.c.a(a.this.d, imageUploadResult2);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public final /* synthetic */ void b(Integer... numArr) {
            Integer[] numArr2 = numArr;
            if (numArr2 == null || numArr2.length == 0 || a.this.b == null) {
                return;
            }
            a.this.b.a(numArr2[0].intValue(), a.this.a);
        }

        private c() {
        }

        /* synthetic */ c(a aVar, byte b) {
            this();
        }

        @Override // com.baidu.tieba.img.i
        public final void a(long j, long j2) {
            int i;
            if (j2 == 0) {
                i = 0;
            } else {
                i = (int) ((((float) j) * 100.0f) / ((float) j2));
                if (i > 100) {
                    i = 90;
                }
            }
            c((Object[]) new Integer[]{Integer.valueOf(i)});
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public final void a() {
            super.a();
            if (a.this.c != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TiebaApplication.g().b().getString(R.string.send_error);
                a.this.c.a(a.this.d, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public final void cancel() {
            super.cancel();
            a.this.e = null;
            a.this.f.a();
        }
    }

    public final void b() {
        if (this.e != null) {
            this.e.cancel();
            this.e = null;
        }
    }

    public final void a(b<T> bVar) {
        this.b = bVar;
    }

    public final void a(d dVar) {
        this.c = dVar;
    }

    public final void a(String str) {
        this.f.b(str);
    }
}
