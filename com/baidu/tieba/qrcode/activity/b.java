package com.baidu.tieba.qrcode.activity;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.QRCodeLoginConfirmActivityConfig;
import com.baidu.tieba.d;
import com.baidu.tieba.qrcode.lib.a.e;
/* loaded from: classes3.dex */
public class b implements e.a {
    private final com.baidu.tieba.qrcode.activity.a gza;
    private a gzb;
    private final TbPageContext mTbPageContext;

    public b(com.baidu.tieba.qrcode.activity.a aVar, TbPageContext tbPageContext) {
        this.gza = aVar;
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.qrcode.lib.a.e.a
    public void rA(String str) {
        this.gza.bnk();
        if (StringUtils.isNull(str)) {
            this.gza.bni();
        } else if (SapiUtils.isQrLoginSchema(str)) {
            if (SapiUtils.QR_LOGIN_LP_PC.equals(SapiUtils.parseQrLoginSchema(str).get(SapiUtils.KEY_QR_LOGIN_LP))) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeLoginConfirmActivityConfig(this.mTbPageContext.getPageActivity(), str)));
                this.mTbPageContext.getPageActivity().finish();
            }
        } else {
            this.gza.bnl();
        }
    }

    @Override // com.baidu.tieba.qrcode.lib.a.e.a
    public void bnm() {
        l.showToast(this.mTbPageContext.getPageActivity(), d.j.disallow_camera_permission);
        this.mTbPageContext.getPageActivity().finish();
    }

    public void rB(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.gzb != null) {
                this.gzb.cancel();
            }
            this.gzb = new a();
            this.gzb.execute(str);
        }
    }

    public void onDestroy() {
        if (this.gzb != null) {
            this.gzb.cancel();
            this.gzb = null;
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
            b.this.gza.bnj();
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
            b.this.gza.bnk();
            b.this.rA(str);
        }
    }
}
