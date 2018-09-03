package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class ax {
    private TbPageContext mPageContext;

    public ax(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void i(String str, byte[] bArr) {
        new a(str, bArr).execute(new String[0]);
    }

    /* loaded from: classes2.dex */
    private class a extends BdAsyncTask<String, Integer, String> {
        byte[] mData;
        String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.mData = null;
            this.mUrl = str;
            this.mData = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, ax.this.mPageContext.getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.l.yh();
                case -1:
                default:
                    return ax.this.mPageContext.getString(f.j.save_fail);
                case 0:
                    return ax.this.mPageContext.getString(f.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            ax.this.mPageContext.showToast(str);
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
