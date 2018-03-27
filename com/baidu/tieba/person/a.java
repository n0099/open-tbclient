package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes.dex */
public class a {

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, ImageUploadResult imageUploadResult);
    }

    public void a(String str, b bVar) {
        if (!StringUtils.isNull(str)) {
            C0215a c0215a = new C0215a();
            c0215a.ghR = str;
            c0215a.ghS = bVar;
            c0215a.execute("");
        }
    }

    /* renamed from: com.baidu.tieba.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0215a extends BdAsyncTask<String, Integer, ImageUploadResult> {
        public String ghR;
        public b ghS;

        private C0215a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return new com.baidu.tbadk.img.f("user_pics").o(k.dB(this.ghR), false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (this.ghS != null) {
                int i = 0;
                String str = "";
                if (imageUploadResult != null) {
                    i = imageUploadResult.error_code;
                    str = imageUploadResult.error_msg;
                }
                this.ghS.a(i, str, imageUploadResult);
            }
        }
    }
}
