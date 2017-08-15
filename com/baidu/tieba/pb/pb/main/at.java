package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class at {
    private TbPageContext oV;

    public at(TbPageContext tbPageContext) {
        this.oV = tbPageContext;
    }

    public void h(String str, byte[] bArr) {
        new a(str, bArr).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<String, Integer, String> {
        String mUrl;
        byte[] tu;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.tu = null;
            this.mUrl = str;
            this.tu = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.k.a(this.mUrl, this.tu, at.this.oV.getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.k.uI();
                case -1:
                default:
                    return at.this.oV.getString(d.l.save_error);
                case 0:
                    return at.this.oV.getString(d.l.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            at.this.oV.showToast(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }
    }
}
