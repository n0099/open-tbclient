package com.baidu.tieba.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a<T> {
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

    public void a(int i, int i2, int i3, int i4) {
        this.f.a(i, i2, i3, i4);
    }

    public void a() {
        if (this.e == null) {
            this.e = new c(this, null);
            this.e.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    class c extends BdAsyncTask<String, Integer, ImageUploadResult> implements i {
        private c() {
        }

        /* synthetic */ c(a aVar, c cVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public ImageUploadResult a(String... strArr) {
            return e();
        }

        private ImageUploadResult e() {
            a.this.f.a(this, null);
            ImageUploadResult a = a.this.f.a(a.this.d);
            c((Object[]) new Integer[]{100});
            return a;
        }

        @Override // com.baidu.tieba.img.i
        public void a(String str, Object obj, long j, long j2) {
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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void b(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.b != null) {
                a.this.b.a(numArr[0].intValue(), a.this.a);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void a() {
            super.a();
            if (a.this.c != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TiebaApplication.g().b().getString(R.string.send_error);
                a.this.c.a(a.this.d, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.e = null;
            a.this.f.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void a(ImageUploadResult imageUploadResult) {
            super.a((c) imageUploadResult);
            a.this.e = null;
            if (a.this.c != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TiebaApplication.g().b().getString(R.string.send_error);
                    cb.a("", -1002, imageUploadResult.error_msg, "");
                }
                a.this.c.a(a.this.d, imageUploadResult);
            }
        }
    }

    public void b() {
        if (this.e != null) {
            this.e.cancel();
            this.e = null;
        }
    }

    public void a(b<T> bVar) {
        this.b = bVar;
    }

    public void a(d dVar) {
        this.c = dVar;
    }

    public void a(String str) {
        this.f.b(str);
    }

    public T c() {
        return this.a;
    }

    public void a(T t) {
        this.a = t;
    }
}
