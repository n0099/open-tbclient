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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.baidu.tieba.ueg.c;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements QRCodeView.a {
    private com.baidu.tieba.ueg.c iTp;
    private boolean kGi;
    private final com.baidu.tieba.qrcode.activity.a kGp;
    private c kGq;
    private C0707b kGr;
    private final TbPageContext mTbPageContext;

    public b(com.baidu.tieba.qrcode.activity.a aVar, TbPageContext tbPageContext) {
        this.kGp = aVar;
        this.mTbPageContext = tbPageContext;
    }

    public void tE(boolean z) {
        this.kGi = z;
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.a
    public void KP(String str) {
        if (StringUtils.isNull(str)) {
            this.kGp.cTp();
            this.kGp.cTn();
        } else if (this.kGi) {
            Intent intent = new Intent();
            intent.putExtra(QRCodeScanActivityConfig.RESULT_SCAN_CODE, str);
            this.mTbPageContext.getPageActivity().setResult(-1, intent);
            this.mTbPageContext.getPageActivity().finish();
        } else if (KS(str)) {
            this.kGp.cTp();
        } else if (!StringUtils.isNull(str) && str.contains("feedavatar.baidu.com")) {
            this.kGp.cTp();
            KT(str);
        } else if (KR(str)) {
            this.kGp.cTp();
            this.mTbPageContext.getPageActivity().finish();
        } else if (!aq.wv(str)) {
            this.kGp.cTp();
            this.kGp.cTn();
        } else {
            KQ(str);
        }
    }

    private void KQ(final String str) {
        if (!l.isNetOk()) {
            this.kGp.cTp();
            l.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(R.string.network_not_available));
            return;
        }
        if (this.iTp != null && !this.iTp.isCancelled()) {
            this.iTp.cancel();
        }
        this.iTp = new com.baidu.tieba.ueg.c(str, new c.a() { // from class: com.baidu.tieba.qrcode.activity.b.1
            @Override // com.baidu.tieba.ueg.c.a
            public void csi() {
                b.this.kGp.cTp();
                b.this.openUrl(str);
            }

            @Override // com.baidu.tieba.ueg.c.a
            public void csj() {
                b.this.kGp.cTp();
                b.this.kGp.KO(str);
            }

            @Override // com.baidu.tieba.ueg.c.a
            public void csk() {
                b.this.kGp.cTp();
                b.this.kGp.cTq();
            }

            @Override // com.baidu.tieba.ueg.c.a
            public void onError(String str2) {
                b.this.kGp.cTp();
                b.this.kGp.cTn();
            }
        });
        this.iTp.setPriority(3);
        this.iTp.execute(new String[0]);
    }

    public void openUrl(String str) {
        ba.aUZ().b(this.mTbPageContext, new String[]{str});
        this.mTbPageContext.getPageActivity().finish();
    }

    private boolean KR(String str) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_QR_CODE_LOGIN, null, str);
        return runTask != null && runTask.getData() != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue();
    }

    private boolean KS(String str) {
        if (StringUtils.isNULL(str)) {
            return false;
        }
        if (str.startsWith("tiebaclient:")) {
            KV(str);
            return true;
        } else if (str.contains("smartapp.baidu.com/mappconsole/api/packagescheme") || str.contains("mappconsole/api/packagescheme")) {
            new a().execute(str);
            return true;
        } else {
            return false;
        }
    }

    private void KT(String str) {
        CookieSyncManager.createInstance(this.mTbPageContext.getPageActivity());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("feedavatar.baidu.com", "cuid=" + TbadkCoreApplication.getInst().getCuid() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        cookieManager.setCookie("feedavatar.baidu.com", "tiebaapp=1;");
        CookieSyncManager.getInstance().sync();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), null, str, false)));
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.a
    public void cTr() {
        l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.disallow_camera_permission);
        this.mTbPageContext.getPageActivity().finish();
    }

    public void KU(String str) {
        if (!StringUtils.isNull(str)) {
            this.kGp.cTo();
            if (this.kGq != null) {
                this.kGq.cancel();
            }
            this.kGq = new c();
            this.kGq.execute(str);
        }
    }

    public void cTs() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            if (Build.VERSION.SDK_INT < 23 || (this.mTbPageContext.getPageActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && this.mTbPageContext.getPageActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0)) {
                String b = b(this.mTbPageContext.getPageActivity().getContentResolver());
                if (!TextUtils.isEmpty(b) && !b.endsWith(".gif") && !b.endsWith(".GIF") && !b.equals(com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_gallery_last_image_path", null))) {
                    if (this.kGr != null) {
                        this.kGr.cancel();
                    }
                    this.kGr = new C0707b(new C0707b.a() { // from class: com.baidu.tieba.qrcode.activity.b.2
                        @Override // com.baidu.tieba.qrcode.activity.b.C0707b.a
                        public void fa(String str, String str2) {
                            if (!TextUtils.isEmpty(str)) {
                                com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_gallery_last_image_path", str);
                                if (!TextUtils.isEmpty(str2)) {
                                    b.this.kGp.eZ(str, str2);
                                }
                            }
                        }
                    });
                    this.kGr.execute(b);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.qrcode.activity.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0707b extends BdAsyncTask<String, Void, String> {
        private String filePath;
        private a kGu;

        /* renamed from: com.baidu.tieba.qrcode.activity.b$b$a */
        /* loaded from: classes10.dex */
        public interface a {
            void fa(String str, String str2);
        }

        public C0707b(a aVar) {
            this.kGu = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            this.filePath = strArr[0];
            return com.baidu.tieba.qrcode.lib.zxing.a.KW(this.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((C0707b) str);
            if (this.kGu != null) {
                this.kGu.fa(this.filePath, str);
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
        if (this.iTp != null && !this.iTp.isCancelled()) {
            this.iTp.cancel();
        }
        if (this.kGq != null) {
            this.kGq.cancel();
            this.kGq = null;
        }
        if (this.kGr != null) {
            this.kGr.cancel();
            this.kGr = null;
        }
    }

    /* loaded from: classes10.dex */
    private class c extends BdAsyncTask<String, Void, String> {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            b.this.kGp.cTo();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            return com.baidu.tieba.qrcode.lib.zxing.a.KW(strArr[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((c) str);
            b.this.kGp.cTp();
            b.this.KP(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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
            b.this.KV(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KV(final String str) {
        if (!StringUtils.isNull(str) && str.startsWith("tiebaclient:")) {
            if (Build.VERSION.SDK_INT <= 21) {
                l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.ai_apps_not_support);
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
