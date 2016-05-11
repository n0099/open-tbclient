package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, ImageUploadResult imageUploadResult);
    }

    public void a(String str, b bVar) {
        if (!StringUtils.isNull(str)) {
            C0068a c0068a = new C0068a(null);
            c0068a.duo = str;
            c0068a.dup = bVar;
            c0068a.execute("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0068a extends BdAsyncTask<String, Integer, ImageUploadResult> {
        public String duo;
        public b dup;

        private C0068a() {
        }

        /* synthetic */ C0068a(C0068a c0068a) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public ImageUploadResult doInBackground(String... strArr) {
            return new com.baidu.tbadk.img.c("user_pics").s(com.baidu.tbadk.core.util.m.cR(this.duo), false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (this.dup != null) {
                int i = 0;
                String str = "";
                if (imageUploadResult != null) {
                    i = imageUploadResult.error_code;
                    str = imageUploadResult.error_msg;
                }
                this.dup.a(i, str, imageUploadResult);
            }
        }
    }
}
