package com.baidu.tieba.qrcode.activity;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.qrcode.lib.a.e;
/* loaded from: classes3.dex */
public class b implements e.a {
    private final com.baidu.tieba.qrcode.activity.a gzf;
    private a gzg;
    private final TbPageContext mTbPageContext;

    public b(com.baidu.tieba.qrcode.activity.a aVar, TbPageContext tbPageContext) {
        this.gzf = aVar;
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.qrcode.lib.a.e.a
    public void rA(String str) {
        this.gzf.bnk();
        if (StringUtils.isNull(str)) {
            this.gzf.bni();
        } else if (SapiUtils.isQrLoginSchema(str)) {
            if (SapiUtils.QR_LOGIN_LP_PC.equals(SapiUtils.parseQrLoginSchema(str).get(SapiUtils.KEY_QR_LOGIN_LP))) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, str));
                this.mTbPageContext.getPageActivity().finish();
            }
        } else {
            this.gzf.bnl();
        }
    }

    @Override // com.baidu.tieba.qrcode.lib.a.e.a
    public void bnm() {
        l.showToast(this.mTbPageContext.getPageActivity(), d.j.disallow_camera_permission);
        this.mTbPageContext.getPageActivity().finish();
    }

    public void rB(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.gzg != null) {
                this.gzg.cancel();
            }
            this.gzg = new a();
            this.gzg.execute(str);
        }
    }

    public void onDestroy() {
        if (this.gzg != null) {
            this.gzg.cancel();
            this.gzg = null;
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
            b.this.gzf.bnj();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            return com.baidu.tieba.qrcode.lib.zxing.a.rC(strArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            b.this.gzf.bnk();
            b.this.rA(str);
        }
    }
}
