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
            C0076a c0076a = new C0076a(null);
            c0076a.cMX = str;
            c0076a.cMY = bVar;
            c0076a.execute("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0076a extends BdAsyncTask<String, Integer, ImageUploadResult> {
        public String cMX;
        public b cMY;

        private C0076a() {
        }

        /* synthetic */ C0076a(C0076a c0076a) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ImageUploadResult doInBackground(String... strArr) {
            return new com.baidu.tbadk.img.c("user_pics").s(com.baidu.tbadk.core.util.n.cT(this.cMX), false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (this.cMY != null) {
                int i = 0;
                String str = "";
                if (imageUploadResult != null) {
                    i = imageUploadResult.error_code;
                    str = imageUploadResult.error_msg;
                }
                this.cMY.a(i, str, imageUploadResult);
            }
        }
    }
}
