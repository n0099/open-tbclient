package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class az {
    private TbPageContext mPageContext;

    public az(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void j(String str, byte[] bArr) {
        new a(str, bArr).execute(new String[0]);
    }

    /* loaded from: classes.dex */
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
            switch (com.baidu.tbadk.core.util.m.saveImageFileByUser(this.mUrl, this.mData, az.this.mPageContext.getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.m.getSdErrorString();
                case -1:
                default:
                    return az.this.mPageContext.getString(R.string.save_fail);
                case 0:
                    return az.this.mPageContext.getString(R.string.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            az.this.mPageContext.showToast(str);
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
