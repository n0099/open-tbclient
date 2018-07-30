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
    private final com.baidu.tieba.qrcode.activity.a glu;
    private a glv;
    private final TbPageContext mTbPageContext;

    public b(com.baidu.tieba.qrcode.activity.a aVar, TbPageContext tbPageContext) {
        this.glu = aVar;
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.a
    public void sv(String str) {
        this.glu.bmw();
        if (StringUtils.isNull(str)) {
            this.glu.bmu();
            return;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921339, null, str);
        if (runTask == null || !(runTask.getData() instanceof Boolean)) {
            this.glu.bmx();
        } else {
            this.mTbPageContext.getPageActivity().finish();
        }
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.a
    public void bmy() {
        l.showToast(this.mTbPageContext.getPageActivity(), d.j.disallow_camera_permission);
        this.mTbPageContext.getPageActivity().finish();
    }

    public void sw(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.glv != null) {
                this.glv.cancel();
            }
            this.glv = new a();
            this.glv.execute(str);
        }
    }

    public void onDestroy() {
        if (this.glv != null) {
            this.glv.cancel();
            this.glv = null;
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
            b.this.glu.bmv();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            return com.baidu.tieba.qrcode.lib.zxing.a.sx(strArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            b.this.glu.bmw();
            b.this.sv(str);
        }
    }
}
