package com.baidu.tieba.qrcode.activity;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
/* loaded from: classes3.dex */
public class b implements QRCodeView.a {
    private final com.baidu.tieba.qrcode.activity.a gkk;
    private a gkl;
    private final TbPageContext mTbPageContext;

    public b(com.baidu.tieba.qrcode.activity.a aVar, TbPageContext tbPageContext) {
        this.gkk = aVar;
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.a
    public void sA(String str) {
        this.gkk.bnS();
        if (StringUtils.isNull(str)) {
            this.gkk.bnQ();
            return;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921339, null, str);
        if (runTask == null || !(runTask.getData() instanceof Boolean)) {
            this.gkk.bnT();
        } else {
            this.mTbPageContext.getPageActivity().finish();
        }
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.a
    public void bnU() {
        l.showToast(this.mTbPageContext.getPageActivity(), d.k.disallow_camera_permission);
        this.mTbPageContext.getPageActivity().finish();
    }

    public void sB(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.gkl != null) {
                this.gkl.cancel();
            }
            this.gkl = new a();
            this.gkl.execute(str);
        }
    }

    public void onDestroy() {
        if (this.gkl != null) {
            this.gkl.cancel();
            this.gkl = null;
        }
    }

    /* loaded from: classes3.dex */
    private class a extends BdAsyncTask<String, Void, String> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            b.this.gkk.bnR();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            return com.baidu.tieba.qrcode.lib.zxing.a.sC(strArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            b.this.gkk.bnS();
            b.this.sA(str);
        }
    }
}
