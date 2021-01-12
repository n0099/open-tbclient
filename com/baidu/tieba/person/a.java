package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes2.dex */
public class a {

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i, String str, ImageUploadResult imageUploadResult);
    }

    public void a(String str, b bVar) {
        if (!StringUtils.isNull(str)) {
            C0841a c0841a = new C0841a();
            c0841a.miS = str;
            c0841a.miT = bVar;
            c0841a.execute("");
        }
    }

    /* renamed from: com.baidu.tieba.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0841a extends BdAsyncTask<String, Integer, ImageUploadResult> {
        public String miS;
        public b miT;

        private C0841a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: P */
        public ImageUploadResult doInBackground(String... strArr) {
            return new com.baidu.tbadk.img.f("user_pics").ay(n.getFileDireciory(this.miS), false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (this.miT != null) {
                int i = 0;
                String str = "";
                if (imageUploadResult != null) {
                    i = imageUploadResult.error_code;
                    str = imageUploadResult.error_msg;
                }
                this.miT.a(i, str, imageUploadResult);
            }
        }
    }
}
