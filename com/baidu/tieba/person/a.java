package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes7.dex */
public class a {

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i, String str, ImageUploadResult imageUploadResult);
    }

    public void a(String str, b bVar) {
        if (!StringUtils.isNull(str)) {
            C0578a c0578a = new C0578a();
            c0578a.jeH = str;
            c0578a.jeI = bVar;
            c0578a.execute("");
        }
    }

    /* renamed from: com.baidu.tieba.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0578a extends BdAsyncTask<String, Integer, ImageUploadResult> {
        public String jeH;
        public b jeI;

        private C0578a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public ImageUploadResult doInBackground(String... strArr) {
            return new com.baidu.tbadk.img.f("user_pics").U(m.getFileDireciory(this.jeH), false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (this.jeI != null) {
                int i = 0;
                String str = "";
                if (imageUploadResult != null) {
                    i = imageUploadResult.error_code;
                    str = imageUploadResult.error_msg;
                }
                this.jeI.a(i, str, imageUploadResult);
            }
        }
    }
}
