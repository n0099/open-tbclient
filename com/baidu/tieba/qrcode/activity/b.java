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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.baidu.tieba.ueg.c;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class b implements QRCodeView.a {
    private com.baidu.tieba.ueg.c kza;
    private final TbPageContext mTbPageContext;
    private boolean mpJ;
    private final com.baidu.tieba.qrcode.activity.a mpQ;
    private c mpR;
    private C0830b mpS;

    public b(com.baidu.tieba.qrcode.activity.a aVar, TbPageContext tbPageContext) {
        this.mpQ = aVar;
        this.mTbPageContext = tbPageContext;
    }

    public void wA(boolean z) {
        this.mpJ = z;
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.a
    public void QY(String str) {
        if (StringUtils.isNull(str)) {
            this.mpQ.dzl();
            this.mpQ.dzj();
        } else if (this.mpJ) {
            Intent intent = new Intent();
            intent.putExtra(QRCodeScanActivityConfig.RESULT_SCAN_CODE, str);
            this.mTbPageContext.getPageActivity().setResult(-1, intent);
            this.mTbPageContext.getPageActivity().finish();
        } else if (Rb(str)) {
            this.mpQ.dzl();
        } else if (!StringUtils.isNull(str) && str.contains("feedavatar.baidu.com")) {
            this.mpQ.dzl();
            Rc(str);
        } else if (Ra(str)) {
            this.mpQ.dzl();
            this.mTbPageContext.getPageActivity().finish();
        } else if (!at.BX(str)) {
            this.mpQ.dzl();
            this.mpQ.dzj();
        } else {
            QZ(str);
        }
    }

    private void QZ(final String str) {
        if (!l.isNetOk()) {
            this.mpQ.dzl();
            l.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(R.string.network_not_available));
            return;
        }
        if (this.kza != null && !this.kza.isCancelled()) {
            this.kza.cancel();
        }
        this.kza = new com.baidu.tieba.ueg.c(str, new c.a() { // from class: com.baidu.tieba.qrcode.activity.b.1
            @Override // com.baidu.tieba.ueg.c.a
            public void cXT() {
                b.this.mpQ.dzl();
                b.this.openUrl(str);
            }

            @Override // com.baidu.tieba.ueg.c.a
            public void cXU() {
                b.this.mpQ.dzl();
                b.this.mpQ.QX(str);
            }

            @Override // com.baidu.tieba.ueg.c.a
            public void cXV() {
                b.this.mpQ.dzl();
                b.this.mpQ.dzm();
            }

            @Override // com.baidu.tieba.ueg.c.a
            public void onError(String str2) {
                b.this.mpQ.dzl();
                b.this.mpQ.dzj();
            }
        });
        this.kza.setPriority(3);
        this.kza.execute(new String[0]);
    }

    public void openUrl(String str) {
        be.brr().b(this.mTbPageContext, new String[]{str});
        this.mTbPageContext.getPageActivity().finish();
    }

    private boolean Ra(String str) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_QR_CODE_LOGIN, null, str);
        return runTask != null && runTask.getData() != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue();
    }

    private boolean Rb(String str) {
        if (StringUtils.isNULL(str)) {
            return false;
        }
        if (str.startsWith("tiebaclient:")) {
            Re(str);
            return true;
        } else if (str.contains("smartapp.baidu.com/mappconsole/api/packagescheme") || str.contains("mappconsole/api/packagescheme")) {
            new a().execute(str);
            return true;
        } else {
            return false;
        }
    }

    private void Rc(String str) {
        CookieSyncManager.createInstance(this.mTbPageContext.getPageActivity());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("feedavatar.baidu.com", "cuid=" + TbadkCoreApplication.getInst().getCuid() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        cookieManager.setCookie("feedavatar.baidu.com", "tiebaapp=1;");
        CookieSyncManager.getInstance().sync();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, str, false)));
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.a
    public void dzn() {
        l.showToast(this.mTbPageContext.getPageActivity(), R.string.disallow_camera_permission);
        this.mTbPageContext.getPageActivity().finish();
    }

    public void Rd(String str) {
        if (!StringUtils.isNull(str)) {
            this.mpQ.dzk();
            if (this.mpR != null) {
                this.mpR.cancel();
            }
            this.mpR = new c();
            this.mpR.execute(str);
        }
    }

    public void dzo() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            if (Build.VERSION.SDK_INT < 23 || (this.mTbPageContext.getPageActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && this.mTbPageContext.getPageActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0)) {
                String b = b(this.mTbPageContext.getPageActivity().getContentResolver());
                if (!TextUtils.isEmpty(b) && !b.endsWith(".gif") && !b.endsWith(".GIF") && !b.equals(com.baidu.tbadk.core.sharedPref.b.bqh().getString("key_gallery_last_image_path", null))) {
                    if (this.mpS != null) {
                        this.mpS.cancel();
                    }
                    this.mpS = new C0830b(new C0830b.a() { // from class: com.baidu.tieba.qrcode.activity.b.2
                        @Override // com.baidu.tieba.qrcode.activity.b.C0830b.a
                        public void ga(String str, String str2) {
                            if (!TextUtils.isEmpty(str)) {
                                com.baidu.tbadk.core.sharedPref.b.bqh().putString("key_gallery_last_image_path", str);
                                if (!TextUtils.isEmpty(str2)) {
                                    b.this.mpQ.fZ(str, str2);
                                }
                            }
                        }
                    });
                    this.mpS.execute(b);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.qrcode.activity.b$b  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static class C0830b extends BdAsyncTask<String, Void, String> {
        private String filePath;
        private a mpV;

        /* renamed from: com.baidu.tieba.qrcode.activity.b$b$a */
        /* loaded from: classes23.dex */
        public interface a {
            void ga(String str, String str2);
        }

        public C0830b(a aVar) {
            this.mpV = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            this.filePath = strArr[0];
            return com.baidu.tieba.qrcode.lib.zxing.a.Rf(this.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((C0830b) str);
            if (this.mpV != null) {
                this.mpV.ga(this.filePath, str);
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
        if (this.kza != null && !this.kza.isCancelled()) {
            this.kza.cancel();
        }
        if (this.mpR != null) {
            this.mpR.cancel();
            this.mpR = null;
        }
        if (this.mpS != null) {
            this.mpS.cancel();
            this.mpS = null;
        }
    }

    /* loaded from: classes23.dex */
    private class c extends BdAsyncTask<String, Void, String> {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            b.this.mpQ.dzk();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            return com.baidu.tieba.qrcode.lib.zxing.a.Rf(strArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            b.this.mpQ.dzl();
            b.this.QY(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
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
            String postNetData = new aa(str).postNetData();
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
            b.this.Re(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Re(final String str) {
        if (!StringUtils.isNull(str) && str.startsWith("tiebaclient:")) {
            if (Build.VERSION.SDK_INT <= 21) {
                l.showToast(this.mTbPageContext.getPageActivity(), R.string.ai_apps_not_support);
                return;
            }
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.mTbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.qrcode.activity.b.3
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
                public void onPermissionsGranted() {
                    try {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, URLDecoder.decode(str, "UTF-8")));
                        b.this.mTbPageContext.getPageActivity().finish();
                    } catch (UnsupportedEncodingException e) {
                    }
                }
            });
            permissionJudgePolicy.startRequestPermission(this.mTbPageContext.getPageActivity());
        }
    }
}
