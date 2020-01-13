package com.baidu.tieba.qrcode.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.baidu.tieba.ueg.c;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b implements QRCodeView.a {
    private com.baidu.tieba.ueg.c hQH;
    private boolean jBH;
    private final com.baidu.tieba.qrcode.activity.a jBO;
    private c jBP;
    private C0585b jBQ;
    private final TbPageContext mTbPageContext;

    public b(com.baidu.tieba.qrcode.activity.a aVar, TbPageContext tbPageContext) {
        this.jBO = aVar;
        this.mTbPageContext = tbPageContext;
    }

    public void rT(boolean z) {
        this.jBH = z;
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.a
    public void Hh(String str) {
        if (StringUtils.isNull(str)) {
            this.jBO.czY();
            this.jBO.czW();
        } else if (this.jBH) {
            Intent intent = new Intent();
            intent.putExtra(QRCodeScanActivityConfig.RESULT_SCAN_CODE, str);
            this.mTbPageContext.getPageActivity().setResult(-1, intent);
            this.mTbPageContext.getPageActivity().finish();
        } else if (Hk(str)) {
            this.jBO.czY();
        } else if (!StringUtils.isNull(str) && str.contains("feedavatar.baidu.com")) {
            this.jBO.czY();
            Hl(str);
        } else if (Hj(str)) {
            this.jBO.czY();
            this.mTbPageContext.getPageActivity().finish();
        } else if (!aq.tj(str)) {
            this.jBO.czY();
            this.jBO.czW();
        } else {
            Hi(str);
        }
    }

    private void Hi(final String str) {
        if (!l.isNetOk()) {
            this.jBO.czY();
            l.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(R.string.network_not_available));
            return;
        }
        if (this.hQH != null && !this.hQH.isCancelled()) {
            this.hQH.cancel();
        }
        this.hQH = new com.baidu.tieba.ueg.c(str, new c.a() { // from class: com.baidu.tieba.qrcode.activity.b.1
            @Override // com.baidu.tieba.ueg.c.a
            public void bZj() {
                b.this.jBO.czY();
                b.this.openUrl(str);
            }

            @Override // com.baidu.tieba.ueg.c.a
            public void bZk() {
                b.this.jBO.czY();
                b.this.jBO.Hg(str);
            }

            @Override // com.baidu.tieba.ueg.c.a
            public void bZl() {
                b.this.jBO.czY();
                b.this.jBO.czZ();
            }

            @Override // com.baidu.tieba.ueg.c.a
            public void onError(String str2) {
                b.this.jBO.czY();
                b.this.jBO.czW();
            }
        });
        this.hQH.setPriority(3);
        this.hQH.execute(new String[0]);
    }

    public void openUrl(String str) {
        ba.aEt().b(this.mTbPageContext, new String[]{str});
        this.mTbPageContext.getPageActivity().finish();
    }

    private boolean Hj(String str) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_QR_CODE_LOGIN, null, str);
        return runTask != null && runTask.getData() != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue();
    }

    private boolean Hk(String str) {
        if (StringUtils.isNULL(str)) {
            return false;
        }
        if (str.startsWith("tiebaclient:")) {
            Hn(str);
            return true;
        } else if (str.contains("smartapp.baidu.com/mappconsole/api/packagescheme") || str.contains("mappconsole/api/packagescheme")) {
            new a().execute(str);
            return true;
        } else {
            return false;
        }
    }

    private void Hl(String str) {
        CookieSyncManager.createInstance(this.mTbPageContext.getPageActivity());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("feedavatar.baidu.com", "cuid=" + TbadkCoreApplication.getInst().getCuid() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        cookieManager.setCookie("feedavatar.baidu.com", "tiebaapp=1;");
        CookieSyncManager.getInstance().sync();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, str, false)));
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.a
    public void cAa() {
        l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.disallow_camera_permission);
        this.mTbPageContext.getPageActivity().finish();
    }

    public void Hm(String str) {
        if (!StringUtils.isNull(str)) {
            this.jBO.czX();
            if (this.jBP != null) {
                this.jBP.cancel();
            }
            this.jBP = new c();
            this.jBP.execute(str);
        }
    }

    public void cAb() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            if (Build.VERSION.SDK_INT < 23 || (this.mTbPageContext.getPageActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && this.mTbPageContext.getPageActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0)) {
                String b = b(this.mTbPageContext.getPageActivity().getContentResolver());
                if (!TextUtils.isEmpty(b) && !b.endsWith(".gif") && !b.endsWith(".GIF") && !b.equals(com.baidu.tbadk.core.sharedPref.b.aDr().getString("key_gallery_last_image_path", null))) {
                    if (this.jBQ != null) {
                        this.jBQ.cancel();
                    }
                    this.jBQ = new C0585b(new C0585b.a() { // from class: com.baidu.tieba.qrcode.activity.b.2
                        @Override // com.baidu.tieba.qrcode.activity.b.C0585b.a
                        public void ed(String str, String str2) {
                            if (!TextUtils.isEmpty(str)) {
                                com.baidu.tbadk.core.sharedPref.b.aDr().putString("key_gallery_last_image_path", str);
                                if (!TextUtils.isEmpty(str2)) {
                                    b.this.jBO.ec(str, str2);
                                }
                            }
                        }
                    });
                    this.jBQ.execute(b);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.qrcode.activity.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0585b extends BdAsyncTask<String, Void, String> {
        private String filePath;
        private a jBT;

        /* renamed from: com.baidu.tieba.qrcode.activity.b$b$a */
        /* loaded from: classes8.dex */
        public interface a {
            void ed(String str, String str2);
        }

        public C0585b(a aVar) {
            this.jBT = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            this.filePath = strArr[0];
            return com.baidu.tieba.qrcode.lib.zxing.a.Ho(this.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((C0585b) str);
            if (this.jBT != null) {
                this.jBT.ed(this.filePath, str);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [334=7, 335=6] */
    private String b(ContentResolver contentResolver) {
        String str;
        Cursor cursor = null;
        if (contentResolver == null) {
            return null;
        }
        try {
            Cursor query = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{IMConstants.MSG_ROW_ID, "_display_name", "_data", "_size", "bucket_display_name", "date_modified"}, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                try {
                    query.moveToLast();
                    str = query.getString(query.getColumnIndex("_data"));
                    try {
                        if (TextUtils.isEmpty(str)) {
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        } else if (!new File(str).exists()) {
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        } else {
                            query.close();
                            if (query != null) {
                                query.close();
                                return str;
                            }
                            return str;
                        }
                    } catch (Exception e) {
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                            return str;
                        }
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                str = null;
                cursor = query;
            }
        } catch (Exception e3) {
            str = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void onDestroy() {
        if (this.hQH != null && !this.hQH.isCancelled()) {
            this.hQH.cancel();
        }
        if (this.jBP != null) {
            this.jBP.cancel();
            this.jBP = null;
        }
        if (this.jBQ != null) {
            this.jBQ.cancel();
            this.jBQ = null;
        }
    }

    /* loaded from: classes8.dex */
    private class c extends BdAsyncTask<String, Void, String> {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            b.this.jBO.czX();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            return com.baidu.tieba.qrcode.lib.zxing.a.Ho(strArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            b.this.jBO.czY();
            b.this.Hh(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, Void, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String str = strArr[0];
            if (StringUtils.isNull(str)) {
                return null;
            }
            String postNetData = new x(str).postNetData();
            if (StringUtils.isNull(postNetData)) {
                return null;
            }
            try {
                return new JSONObject(postNetData).optString("data");
            } catch (JSONException e) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            b.this.Hn(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hn(final String str) {
        if (!StringUtils.isNull(str) && str.startsWith("tiebaclient:")) {
            if (Build.VERSION.SDK_INT <= 21) {
                l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.ai_apps_not_support);
                return;
            }
            com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
            aVar.clearRequestPermissionList();
            aVar.appendRequestPermission(this.mTbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            aVar.a(new a.InterfaceC0368a() { // from class: com.baidu.tieba.qrcode.activity.b.3
                @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0368a
                public void onPermissionsGranted() {
                    try {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, URLDecoder.decode(str, "UTF-8")));
                        b.this.mTbPageContext.getPageActivity().finish();
                    } catch (UnsupportedEncodingException e) {
                    }
                }
            });
            aVar.startRequestPermission(this.mTbPageContext.getPageActivity());
        }
    }
}
