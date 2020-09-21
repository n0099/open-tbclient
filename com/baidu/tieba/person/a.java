package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes21.dex */
public class a {

    /* loaded from: classes21.dex */
    public interface b {
        void a(int i, String str, ImageUploadResult imageUploadResult);
    }

    public void a(String str, b bVar) {
        if (!StringUtils.isNull(str)) {
            C0775a c0775a = new C0775a();
            c0775a.lmf = str;
            c0775a.lmg = bVar;
            c0775a.execute("");
        }
    }

    /* renamed from: com.baidu.tieba.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private static class C0775a extends BdAsyncTask<String, Integer, ImageUploadResult> {
        public String lmf;
        public b lmg;

        private C0775a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public ImageUploadResult doInBackground(String... strArr) {
            return new com.baidu.tbadk.img.f("user_pics").ar(n.getFileDireciory(this.lmf), false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            if (this.lmg != null) {
                int i = 0;
                String str = "";
                if (imageUploadResult != null) {
                    i = imageUploadResult.error_code;
                    str = imageUploadResult.error_msg;
                }
                this.lmg.a(i, str, imageUploadResult);
            }
        }
    }
}
