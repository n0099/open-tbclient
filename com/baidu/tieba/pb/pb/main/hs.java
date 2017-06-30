package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class hs {
    private TbPageContext ajP;

    public hs(TbPageContext tbPageContext) {
        this.ajP = tbPageContext;
    }

    public void h(String str, byte[] bArr) {
        new a(str, bArr).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<String, Integer, String> {
        String mUrl;
        byte[] rK;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.rK = null;
            this.mUrl = str;
            this.rK = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.n.a(this.mUrl, this.rK, hs.this.ajP.getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.n.us();
                case -1:
                default:
                    return hs.this.ajP.getString(w.l.save_error);
                case 0:
                    return hs.this.ajP.getString(w.l.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            hs.this.ajP.showToast(str);
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
