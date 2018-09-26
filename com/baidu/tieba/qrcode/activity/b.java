package com.baidu.tieba.qrcode.activity;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tieba.e;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
/* loaded from: classes3.dex */
public class b implements QRCodeView.a {
    private final com.baidu.tieba.qrcode.activity.a gsP;
    private a gsQ;
    private final TbPageContext mTbPageContext;

    public b(com.baidu.tieba.qrcode.activity.a aVar, TbPageContext tbPageContext) {
        this.gsP = aVar;
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.a
    public void tf(String str) {
        this.gsP.bpd();
        if (StringUtils.isNull(str)) {
            this.gsP.bpb();
            return;
        }
        if (!StringUtils.isNull(str) && str.contains("feedavatar.baidu.com")) {
            tg(str);
        } else {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921339, null, str);
            if (runTask == null || !(runTask.getData() instanceof Boolean) || !((Boolean) runTask.getData()).booleanValue()) {
                this.gsP.bpe();
                return;
            }
        }
        this.mTbPageContext.getPageActivity().finish();
    }

    private void tg(String str) {
        CookieSyncManager.createInstance(this.mTbPageContext.getPageActivity());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("feedavatar.baidu.com", "cuid=" + TbadkCoreApplication.getInst().getCuid() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        cookieManager.setCookie("feedavatar.baidu.com", "tiebaapp=1;");
        CookieSyncManager.getInstance().sync();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, str, false)));
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.a
    public void bpf() {
        l.showToast(this.mTbPageContext.getPageActivity(), e.j.disallow_camera_permission);
        this.mTbPageContext.getPageActivity().finish();
    }

    public void th(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.gsQ != null) {
                this.gsQ.cancel();
            }
            this.gsQ = new a();
            this.gsQ.execute(str);
        }
    }

    public void onDestroy() {
        if (this.gsQ != null) {
            this.gsQ.cancel();
            this.gsQ = null;
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
            b.this.gsP.bpc();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            return com.baidu.tieba.qrcode.lib.zxing.a.ti(strArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            b.this.gsP.bpd();
            b.this.tf(str);
        }
    }
}
