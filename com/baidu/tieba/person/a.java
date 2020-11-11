package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes22.dex */
public class a {

    /* loaded from: classes22.dex */
    public interface b {
        void a(int i, String str, ImageUploadResult imageUploadResult);
    }

    public void a(String str, b bVar) {
        if (!StringUtils.isNull(str)) {
            C0823a c0823a = new C0823a();
            c0823a.lTQ = str;
            c0823a.lTR = bVar;
            c0823a.execute("");
        }
    }

    /* renamed from: com.baidu.tieba.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    private static class C0823a extends BdAsyncTask<String, Integer, ImageUploadResult> {
        public String lTQ;
        public b lTR;

        private C0823a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public ImageUploadResult doInBackground(String... strArr) {
            return new com.baidu.tbadk.img.f("user_pics").ax(n.getFileDireciory(this.lTQ), false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (this.lTR != null) {
                int i = 0;
                String str = "";
                if (imageUploadResult != null) {
                    i = imageUploadResult.error_code;
                    str = imageUploadResult.error_msg;
                }
                this.lTR.a(i, str, imageUploadResult);
            }
        }
    }
}
