package com.baidu.wallet.qrcodescanner.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.support.Base64;
import com.baidu.idl.barcode.Barcode;
import com.baidu.idl.barcode.BarcodeResult;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.qrcodescanner.a.b;
import com.baidu.wallet.qrcodescanner.beans.QRCodeScannerBeanFactory;
import com.baidu.wallet.qrcodescanner.datamodel.QRCodeShortUrlResponse;
import com.baidu.wallet.qrcodescanner.datamodel.QRCodeWhiteListResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public QRCodeWhiteListResponse f26481a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f26482b;

    /* renamed from: c  reason: collision with root package name */
    public b f26483c;

    /* renamed from: com.baidu.wallet.qrcodescanner.a.a$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass2 implements IBeanResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f26489a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f26490b;

        public AnonymousClass2(String str, Context context) {
            this.f26489a = str;
            this.f26490b = context;
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, final int i3, String str) {
            DXMSdkSAUtils.onEventEnd("@parseQRCodeScannerShortUrl", i3);
            PayStatisticsUtil.onEventEnd("@parseQRCodeScannerShortUrl", i3);
            if (a.this.f26482b == null) {
                a.this.f26482b = new Handler(Looper.getMainLooper());
            }
            a.this.f26482b.post(new Runnable() { // from class: com.baidu.wallet.qrcodescanner.a.a.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == 5003) {
                        WalletLoginHelper.getInstance().login(new LoginBackListenerProxy(AnonymousClass2.this.f26490b, new ILoginBackListener() { // from class: com.baidu.wallet.qrcodescanner.a.a.2.2.1
                            @Override // com.baidu.wallet.api.ILoginBackListener
                            public void onFail(int i4, String str2) {
                                if (a.this.f26483c != null) {
                                    a.this.f26483c.onResultFail(AnonymousClass2.this.f26489a, str2);
                                    a.this.f26483c = null;
                                }
                            }

                            @Override // com.baidu.wallet.api.ILoginBackListener
                            public void onSuccess(int i4, String str2) {
                                if (a.this.f26483c != null) {
                                    a.this.f26483c.onResultFail(AnonymousClass2.this.f26489a, "");
                                    a.this.f26483c = null;
                                }
                            }
                        }));
                        return;
                    }
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    a aVar = a.this;
                    aVar.a(anonymousClass2.f26490b, anonymousClass2.f26489a, aVar.f26483c, false, false);
                }
            });
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            DXMSdkSAUtils.onEventEnd("@parseQRCodeScannerShortUrl", 0);
            PayStatisticsUtil.onEventEnd("@parseQRCodeScannerShortUrl", 0);
            final QRCodeShortUrlResponse qRCodeShortUrlResponse = obj instanceof QRCodeShortUrlResponse ? (QRCodeShortUrlResponse) obj : null;
            if (qRCodeShortUrlResponse == null || !qRCodeShortUrlResponse.checkResponseValidity()) {
                return;
            }
            if (a.this.f26482b == null) {
                a.this.f26482b = new Handler(Looper.getMainLooper());
            }
            a.this.f26482b.post(new Runnable() { // from class: com.baidu.wallet.qrcodescanner.a.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if ("500".equals(qRCodeShortUrlResponse.type) || "3".equals(qRCodeShortUrlResponse.type) || "501".equals(qRCodeShortUrlResponse.type)) {
                        if (a.this.f26483c != null) {
                            b.a aVar = new b.a();
                            QRCodeShortUrlResponse qRCodeShortUrlResponse2 = qRCodeShortUrlResponse;
                            aVar.f26498a = qRCodeShortUrlResponse2.type;
                            aVar.f26499b = qRCodeShortUrlResponse2.link_addr;
                            aVar.f26500c = qRCodeShortUrlResponse2.params;
                            aVar.f26501d = qRCodeShortUrlResponse2.err;
                            a.this.f26483c.onResultSuccessCallBack(AnonymousClass2.this.f26489a, aVar, true);
                            a.this.f26483c = null;
                            return;
                        }
                        return;
                    }
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    a aVar2 = a.this;
                    aVar2.a(anonymousClass2.f26490b, qRCodeShortUrlResponse.link_addr, aVar2.f26483c, false, false);
                }
            });
        }
    }

    /* renamed from: com.baidu.wallet.qrcodescanner.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0267a {

        /* renamed from: a  reason: collision with root package name */
        public static a f26497a = new a();
    }

    private boolean d(String str) {
        if (this.f26481a == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (QRCodeWhiteListResponse.Group group : this.f26481a.getDataGroup()) {
            if (a(str, group.blacklist_preg)) {
                return true;
            }
        }
        return false;
    }

    public a() {
        this.f26482b = new Handler(Looper.getMainLooper());
    }

    private boolean c(String str) {
        for (QRCodeWhiteListResponse.Group group : this.f26481a.getDataGroup()) {
            if (a(str, group.lightapp_outer_open_preg)) {
                return true;
            }
        }
        return false;
    }

    public boolean b(String str) {
        if (this.f26481a == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (QRCodeWhiteListResponse.Group group : this.f26481a.getDataGroup()) {
            if (a(str, group.url_preg)) {
                return true;
            }
        }
        return false;
    }

    public static a a() {
        return C0267a.f26497a;
    }

    public void b() {
        BeanManager.getInstance().removeAllBeans("QRCodeScannerGetWhiteList");
        BeanManager.getInstance().removeAllBeans("QRCodeScannerParseShortUrl");
    }

    public void a(final Context context, final b bVar, final b bVar2) {
        QRCodeWhiteListResponse.Category category;
        if (bVar == null) {
            return;
        }
        BeanManager.getInstance().removeAllBeans("QRCodeScannerGetWhiteList");
        DXMSdkSAUtils.onEventStart("@getQRCodeScannerWhiteList");
        PayStatisticsUtil.onEventStart("@getQRCodeScannerWhiteList");
        com.baidu.wallet.qrcodescanner.beans.b bVar3 = (com.baidu.wallet.qrcodescanner.beans.b) QRCodeScannerBeanFactory.getInstance().getBean(context, QRCodeScannerBeanFactory.QRCODE_WHITE_LIST, "QRCodeScannerGetWhiteList");
        if (this.f26481a == null) {
            this.f26481a = a(context);
        }
        QRCodeWhiteListResponse qRCodeWhiteListResponse = this.f26481a;
        if (qRCodeWhiteListResponse != null) {
            a(qRCodeWhiteListResponse, bVar, bVar2);
        }
        QRCodeWhiteListResponse qRCodeWhiteListResponse2 = this.f26481a;
        if (qRCodeWhiteListResponse2 != null && (category = qRCodeWhiteListResponse2.whitelist) != null) {
            bVar3.a(category.fingerprint);
        }
        bVar3.setResponseCallback(new IBeanResponseCallback() { // from class: com.baidu.wallet.qrcodescanner.a.a.1
            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecFailure(int i2, int i3, String str) {
                DXMSdkSAUtils.onEventEnd("@getQRCodeScannerWhiteList", i3);
                PayStatisticsUtil.onEventEnd("@getQRCodeScannerWhiteList", i3);
            }

            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecSuccess(int i2, Object obj, String str) {
                DXMSdkSAUtils.onEventEnd("@getQRCodeScannerWhiteList", 0);
                PayStatisticsUtil.onEventEnd("@getQRCodeScannerWhiteList", 0);
                QRCodeWhiteListResponse qRCodeWhiteListResponse3 = obj instanceof QRCodeWhiteListResponse ? (QRCodeWhiteListResponse) obj : null;
                if (qRCodeWhiteListResponse3 != null && qRCodeWhiteListResponse3.checkResponseValidity() && qRCodeWhiteListResponse3.hasData()) {
                    a.this.f26481a = qRCodeWhiteListResponse3;
                    a.this.f26481a.doStoreResponse(context);
                    a.this.f26482b.post(new Runnable() { // from class: com.baidu.wallet.qrcodescanner.a.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a aVar = a.this;
                            QRCodeWhiteListResponse qRCodeWhiteListResponse4 = aVar.f26481a;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            aVar.a(qRCodeWhiteListResponse4, bVar, bVar2);
                        }
                    });
                }
            }
        });
        bVar3.execBean();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(QRCodeWhiteListResponse qRCodeWhiteListResponse, b bVar, b bVar2) {
        if (qRCodeWhiteListResponse == null || !qRCodeWhiteListResponse.hasData()) {
            return;
        }
        QRCodeWhiteListResponse.Group group = this.f26481a.whitelist.data[0];
        if (bVar2 != null) {
            bVar2.onResultSuccessCallBack(group.title_value, null, false);
        }
        if (TextUtils.isEmpty(group.title_advert_logo) && TextUtils.isEmpty(group.title_type) && TextUtils.isEmpty(group.title_link_addr)) {
            return;
        }
        b.a aVar = new b.a();
        aVar.f26498a = group.title_type;
        aVar.f26499b = group.title_link_addr;
        String str = group.start_time;
        String str2 = group.end_time;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            long time = simpleDateFormat.parse(str).getTime();
            long time2 = simpleDateFormat.parse(str2).getTime();
            long time3 = new Date().getTime();
            if (time3 < time || time3 > time2) {
                return;
            }
            bVar.onResultSuccessCallBack(group.title_advert_logo, aVar, true);
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:101:0x0120 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:114:0x0022 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x00ee */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f0 A[Catch: IOException -> 0x00d6, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x00d6, blocks: (B:77:0x00f0, B:88:0x0106, B:99:0x011c, B:62:0x00d2), top: B:120:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0106 A[Catch: IOException -> 0x00d6, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x00d6, blocks: (B:77:0x00f0, B:88:0x0106, B:99:0x011c, B:62:0x00d2), top: B:120:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011c A[Catch: IOException -> 0x00d6, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x00d6, blocks: (B:77:0x00f0, B:88:0x0106, B:99:0x011c, B:62:0x00d2), top: B:120:0x0022 }] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Class<com.baidu.wallet.qrcodescanner.datamodel.QRCodeWhiteListResponse>, java.lang.Class] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private QRCodeWhiteListResponse a(Context context) {
        QRCodeWhiteListResponse qRCodeWhiteListResponse;
        InputStreamReader inputStreamReader;
        InputStream inputStream;
        byte[] decode;
        InputStream inputStream2 = QRCodeWhiteListResponse.class;
        File file = new File(context.getCacheDir() + "/qrcode_scanner_1.cfg");
        InputStreamReader inputStreamReader2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        InputStream inputStream3 = null;
        inputStreamReader2 = null;
        inputStreamReader2 = null;
        inputStreamReader2 = null;
        inputStreamReader2 = null;
        try {
            try {
                try {
                    boolean z = true;
                    if (file.exists() && file.isFile()) {
                        inputStreamReader = new FileReader(file);
                        try {
                            try {
                                try {
                                    try {
                                        decode = Base64.decode(FileCopyUtils.copyToString(inputStreamReader));
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                    if (decode != null) {
                                        String str = new String(decode);
                                        if (!TextUtils.isEmpty(str)) {
                                            qRCodeWhiteListResponse = (QRCodeWhiteListResponse) JsonUtils.fromJson(str, inputStream2);
                                            if (qRCodeWhiteListResponse != null) {
                                                try {
                                                    if (qRCodeWhiteListResponse.checkResponseValidity()) {
                                                        z = false;
                                                    }
                                                } catch (FileNotFoundException e3) {
                                                    e = e3;
                                                    inputStream = inputStream3;
                                                    inputStreamReader2 = inputStreamReader;
                                                    inputStream2 = inputStream;
                                                    e.printStackTrace();
                                                    if (inputStreamReader2 != null) {
                                                    }
                                                    if (inputStream2 != 0) {
                                                    }
                                                    return qRCodeWhiteListResponse;
                                                } catch (IOException e4) {
                                                    e = e4;
                                                    inputStream2 = inputStream3;
                                                    inputStreamReader2 = inputStreamReader;
                                                    e.printStackTrace();
                                                    if (inputStreamReader2 != null) {
                                                    }
                                                    if (inputStream2 != null) {
                                                    }
                                                    return qRCodeWhiteListResponse;
                                                } catch (JSONException e5) {
                                                    e = e5;
                                                    inputStream2 = inputStream3;
                                                    inputStreamReader2 = inputStreamReader;
                                                    e.printStackTrace();
                                                    if (inputStreamReader2 != null) {
                                                    }
                                                    if (inputStream2 != null) {
                                                    }
                                                    return qRCodeWhiteListResponse;
                                                }
                                            }
                                            file.delete();
                                        }
                                    }
                                    qRCodeWhiteListResponse = null;
                                    if (qRCodeWhiteListResponse != null) {
                                    }
                                    file.delete();
                                } catch (JSONException e6) {
                                    e = e6;
                                    inputStream2 = null;
                                    qRCodeWhiteListResponse = null;
                                    inputStreamReader2 = inputStreamReader;
                                    e.printStackTrace();
                                    if (inputStreamReader2 != null) {
                                        try {
                                            inputStreamReader2.close();
                                        } catch (IOException e7) {
                                            e7.printStackTrace();
                                        }
                                    }
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    return qRCodeWhiteListResponse;
                                }
                            } catch (Throwable th) {
                                th = th;
                                inputStream2 = inputStream3;
                                inputStreamReader2 = inputStreamReader;
                                if (inputStreamReader2 != null) {
                                    try {
                                        inputStreamReader2.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e9) {
                                        e9.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e10) {
                            e = e10;
                            inputStream = null;
                            qRCodeWhiteListResponse = null;
                            inputStreamReader2 = inputStreamReader;
                            inputStream2 = inputStream;
                            e.printStackTrace();
                            if (inputStreamReader2 != null) {
                                try {
                                    inputStreamReader2.close();
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                }
                            }
                            if (inputStream2 != 0) {
                                inputStream2.close();
                            }
                            return qRCodeWhiteListResponse;
                        } catch (IOException e12) {
                            e = e12;
                            inputStream2 = null;
                            qRCodeWhiteListResponse = null;
                            inputStreamReader2 = inputStreamReader;
                            e.printStackTrace();
                            if (inputStreamReader2 != null) {
                                try {
                                    inputStreamReader2.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                }
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            return qRCodeWhiteListResponse;
                        }
                    } else {
                        inputStreamReader = null;
                        qRCodeWhiteListResponse = null;
                    }
                    if (z) {
                        inputStream3 = context.getAssets().open("qrcode_scanner.cfg");
                        InputStreamReader inputStreamReader3 = new InputStreamReader(inputStream3);
                        try {
                            String copyToString = FileCopyUtils.copyToString(inputStreamReader3);
                            if (TextUtils.isEmpty(copyToString)) {
                                inputStreamReader = inputStreamReader3;
                            } else {
                                inputStreamReader = inputStreamReader3;
                                qRCodeWhiteListResponse = (QRCodeWhiteListResponse) JsonUtils.fromJson(copyToString, inputStream2);
                            }
                        } catch (FileNotFoundException e14) {
                            inputStreamReader2 = inputStreamReader3;
                            e = e14;
                            inputStream2 = inputStream3;
                            e.printStackTrace();
                            if (inputStreamReader2 != null) {
                            }
                            if (inputStream2 != 0) {
                            }
                            return qRCodeWhiteListResponse;
                        } catch (IOException e15) {
                            inputStreamReader2 = inputStreamReader3;
                            e = e15;
                            inputStream2 = inputStream3;
                            e.printStackTrace();
                            if (inputStreamReader2 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            return qRCodeWhiteListResponse;
                        } catch (JSONException e16) {
                            inputStreamReader2 = inputStreamReader3;
                            e = e16;
                            inputStream2 = inputStream3;
                            e.printStackTrace();
                            if (inputStreamReader2 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            return qRCodeWhiteListResponse;
                        } catch (Throwable th2) {
                            inputStreamReader2 = inputStreamReader3;
                            th = th2;
                            inputStream2 = inputStream3;
                            if (inputStreamReader2 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            throw th;
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (FileNotFoundException e18) {
                e = e18;
                inputStream2 = 0;
                qRCodeWhiteListResponse = null;
            } catch (IOException e19) {
                e = e19;
                inputStream2 = null;
                qRCodeWhiteListResponse = null;
            } catch (JSONException e20) {
                e = e20;
                inputStream2 = null;
                qRCodeWhiteListResponse = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream2 = null;
            }
            if (inputStream3 != null) {
                inputStream3.close();
            }
        } catch (IOException e21) {
            e21.printStackTrace();
        }
        return qRCodeWhiteListResponse;
    }

    public void a(Context context, String str, b bVar, boolean z, boolean z2) {
        QRCodeWhiteListResponse qRCodeWhiteListResponse;
        this.f26483c = bVar;
        if (this.f26481a == null) {
            this.f26481a = a(context);
        }
        if (TextUtils.isEmpty(str) || (qRCodeWhiteListResponse = this.f26481a) == null) {
            bVar.onResultFail(str, "");
            this.f26483c = null;
        } else if (z) {
            a(str, false);
        } else {
            if (z2) {
                for (QRCodeWhiteListResponse.Group group : qRCodeWhiteListResponse.getDataGroup()) {
                    if (a(str, group.shorturl_preg)) {
                        a(context, str);
                        return;
                    }
                }
            }
            if (d(str)) {
                if (this.f26483c != null) {
                    b.a aVar = new b.a();
                    aVar.f26498a = "600";
                    aVar.f26499b = str;
                    this.f26483c.onResultSuccessCallBack(str, aVar, true);
                }
            } else if (b(str)) {
                if (a(str)) {
                    a(str, true);
                } else if (this.f26483c != null) {
                    b.a aVar2 = new b.a();
                    aVar2.f26498a = "300";
                    aVar2.f26499b = str;
                    this.f26483c.onResultSuccessCallBack(str, aVar2, true);
                }
            } else if (this.f26483c != null) {
                b.a aVar3 = new b.a();
                aVar3.f26498a = "100";
                aVar3.f26499b = str;
                this.f26483c.onResultSuccessCallBack(str, aVar3, true);
            }
            this.f26483c = null;
        }
    }

    public void a(String str, boolean z) {
        if (c(str)) {
            if (this.f26483c != null) {
                b.a aVar = new b.a();
                aVar.f26498a = "2";
                aVar.f26499b = str;
                this.f26483c.onResultSuccessCallBack(str, aVar, z);
            }
        } else if (this.f26483c != null) {
            b.a aVar2 = new b.a();
            aVar2.f26498a = "1";
            aVar2.f26499b = str;
            this.f26483c.onResultSuccessCallBack(str, aVar2, z);
        }
        this.f26483c = null;
    }

    public boolean a(String str) {
        QRCodeWhiteListResponse qRCodeWhiteListResponse = this.f26481a;
        if (qRCodeWhiteListResponse != null) {
            for (QRCodeWhiteListResponse.Item item : qRCodeWhiteListResponse.getWhiteLists()) {
                if (a(str, item.whitelist_preg)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean a(String str, String str2) {
        if (str2 != null) {
            try {
                return str.matches(str2);
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public BarcodeResult[] a(byte[] bArr, int i2, int i3, int i4) {
        return Barcode.readBarcode(bArr, i2, i3, i4, 600);
    }

    private void a(Context context, String str) {
        boolean z;
        BeanManager.getInstance().removeAllBeans("QRCodeScannerParseShortUrl");
        DXMSdkSAUtils.onEventStart("@parseQRCodeScannerShortUrl");
        PayStatisticsUtil.onEventStart("@parseQRCodeScannerShortUrl");
        com.baidu.wallet.qrcodescanner.beans.a aVar = (com.baidu.wallet.qrcodescanner.beans.a) QRCodeScannerBeanFactory.getInstance().getBean(context, QRCodeScannerBeanFactory.QRCODE_SHORT_URL, "QRCodeScannerParseShortUrl");
        QRCodeWhiteListResponse qRCodeWhiteListResponse = this.f26481a;
        if (qRCodeWhiteListResponse != null) {
            for (QRCodeWhiteListResponse.Group group : qRCodeWhiteListResponse.getDataGroup()) {
                if (a(str, group.shorturl_preg_new)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            aVar.a(str);
        } else {
            aVar.b(str);
        }
        aVar.setResponseCallback(new AnonymousClass2(str, context));
        aVar.execBean();
    }
}
