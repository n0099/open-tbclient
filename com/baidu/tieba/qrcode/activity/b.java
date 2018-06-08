package com.baidu.tieba.qrcode.activity;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
/* loaded from: classes3.dex */
public class b implements QRCodeView.a {
    private final com.baidu.tieba.qrcode.activity.a ggk;
    private a ggl;
    private final TbPageContext mTbPageContext;

    public b(com.baidu.tieba.qrcode.activity.a aVar, TbPageContext tbPageContext) {
        this.ggk = aVar;
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.a
    public void sB(String str) {
        this.ggk.bno();
        if (StringUtils.isNull(str)) {
            this.ggk.bnm();
        } else if (SapiUtils.isQrLoginSchema(str)) {
            if (SapiUtils.QR_LOGIN_LP_PC.equals(SapiUtils.parseQrLoginSchema(str).get(SapiUtils.KEY_QR_LOGIN_LP))) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921339, str));
                this.mTbPageContext.getPageActivity().finish();
            }
        } else {
            this.ggk.bnp();
        }
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.a
    public void bnq() {
        l.showToast(this.mTbPageContext.getPageActivity(), d.k.disallow_camera_permission);
        this.mTbPageContext.getPageActivity().finish();
    }

    public void sC(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.ggl != null) {
                this.ggl.cancel();
            }
            this.ggl = new a();
            this.ggl.execute(str);
        }
    }

    public void onDestroy() {
        if (this.ggl != null) {
            this.ggl.cancel();
            this.ggl = null;
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
            b.this.ggk.bnn();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            return com.baidu.tieba.qrcode.lib.zxing.a.sD(strArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            b.this.ggk.bno();
            b.this.sB(str);
        }
    }
}
