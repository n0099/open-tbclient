package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, ImageUploadResult imageUploadResult);
    }

    public void a(String str, b bVar) {
        if (!StringUtils.isNull(str)) {
            C0073a c0073a = new C0073a(null);
            c0073a.exE = str;
            c0073a.exF = bVar;
            c0073a.execute("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0073a extends BdAsyncTask<String, Integer, ImageUploadResult> {
        public String exE;
        public b exF;

        private C0073a() {
        }

        /* synthetic */ C0073a(C0073a c0073a) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return new com.baidu.tbadk.img.c("user_pics").u(l.cU(this.exE), false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (this.exF != null) {
                int i = 0;
                String str = "";
                if (imageUploadResult != null) {
                    i = imageUploadResult.error_code;
                    str = imageUploadResult.error_msg;
                }
                this.exF.a(i, str, imageUploadResult);
            }
        }
    }
}
