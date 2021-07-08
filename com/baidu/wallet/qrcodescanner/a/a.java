package com.baidu.wallet.qrcodescanner.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.support.Base64;
import com.baidu.idl.barcode.Barcode;
import com.baidu.idl.barcode.BarcodeResult;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public QRCodeWhiteListResponse f27248a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f27249b;

    /* renamed from: c  reason: collision with root package name */
    public b f27250c;

    /* renamed from: com.baidu.wallet.qrcodescanner.a.a$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass2 implements IBeanResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f27256a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f27257b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f27258c;

        public AnonymousClass2(a aVar, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27258c = aVar;
            this.f27256a = str;
            this.f27257b = context;
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                DXMSdkSAUtils.onEventEnd("@parseQRCodeScannerShortUrl", i3);
                PayStatisticsUtil.onEventEnd("@parseQRCodeScannerShortUrl", i3);
                if (this.f27258c.f27249b == null) {
                    this.f27258c.f27249b = new Handler(Looper.getMainLooper());
                }
                this.f27258c.f27249b.post(new Runnable(this, i3) { // from class: com.baidu.wallet.qrcodescanner.a.a.2.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f27261a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass2 f27262b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i3)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f27262b = this;
                        this.f27261a = i3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.f27261a == 5003) {
                                WalletLoginHelper.getInstance().login(new LoginBackListenerProxy(this.f27262b.f27257b, new ILoginBackListener(this) { // from class: com.baidu.wallet.qrcodescanner.a.a.2.2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ RunnableC02972 f27263a;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i4 = newInitContext.flag;
                                            if ((i4 & 1) != 0) {
                                                int i5 = i4 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f27263a = this;
                                    }

                                    @Override // com.baidu.wallet.api.ILoginBackListener
                                    public void onFail(int i4, String str2) {
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeIL(1048576, this, i4, str2) == null) || this.f27263a.f27262b.f27258c.f27250c == null) {
                                            return;
                                        }
                                        this.f27263a.f27262b.f27258c.f27250c.onResultFail(this.f27263a.f27262b.f27256a, str2);
                                        this.f27263a.f27262b.f27258c.f27250c = null;
                                    }

                                    @Override // com.baidu.wallet.api.ILoginBackListener
                                    public void onSuccess(int i4, String str2) {
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str2) == null) || this.f27263a.f27262b.f27258c.f27250c == null) {
                                            return;
                                        }
                                        this.f27263a.f27262b.f27258c.f27250c.onResultFail(this.f27263a.f27262b.f27256a, "");
                                        this.f27263a.f27262b.f27258c.f27250c = null;
                                    }
                                }));
                                return;
                            }
                            AnonymousClass2 anonymousClass2 = this.f27262b;
                            a aVar = anonymousClass2.f27258c;
                            aVar.a(anonymousClass2.f27257b, anonymousClass2.f27256a, aVar.f27250c, false, false);
                        }
                    }
                });
            }
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                DXMSdkSAUtils.onEventEnd("@parseQRCodeScannerShortUrl", 0);
                PayStatisticsUtil.onEventEnd("@parseQRCodeScannerShortUrl", 0);
                QRCodeShortUrlResponse qRCodeShortUrlResponse = obj instanceof QRCodeShortUrlResponse ? (QRCodeShortUrlResponse) obj : null;
                if (qRCodeShortUrlResponse == null || !qRCodeShortUrlResponse.checkResponseValidity()) {
                    return;
                }
                if (this.f27258c.f27249b == null) {
                    this.f27258c.f27249b = new Handler(Looper.getMainLooper());
                }
                this.f27258c.f27249b.post(new Runnable(this, qRCodeShortUrlResponse) { // from class: com.baidu.wallet.qrcodescanner.a.a.2.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ QRCodeShortUrlResponse f27259a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass2 f27260b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, qRCodeShortUrlResponse};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f27260b = this;
                        this.f27259a = qRCodeShortUrlResponse;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if ("500".equals(this.f27259a.type) || "3".equals(this.f27259a.type) || "501".equals(this.f27259a.type)) {
                                if (this.f27260b.f27258c.f27250c != null) {
                                    b.a aVar = new b.a();
                                    QRCodeShortUrlResponse qRCodeShortUrlResponse2 = this.f27259a;
                                    aVar.f27265a = qRCodeShortUrlResponse2.type;
                                    aVar.f27266b = qRCodeShortUrlResponse2.link_addr;
                                    aVar.f27267c = qRCodeShortUrlResponse2.params;
                                    aVar.f27268d = qRCodeShortUrlResponse2.err;
                                    this.f27260b.f27258c.f27250c.onResultSuccessCallBack(this.f27260b.f27256a, aVar, true);
                                    this.f27260b.f27258c.f27250c = null;
                                    return;
                                }
                                return;
                            }
                            AnonymousClass2 anonymousClass2 = this.f27260b;
                            a aVar2 = anonymousClass2.f27258c;
                            aVar2.a(anonymousClass2.f27257b, this.f27259a.link_addr, aVar2.f27250c, false, false);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.wallet.qrcodescanner.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0298a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f27264a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1474036526, "Lcom/baidu/wallet/qrcodescanner/a/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1474036526, "Lcom/baidu/wallet/qrcodescanner/a/a$a;");
                    return;
                }
            }
            f27264a = new a();
        }
    }

    private boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, str)) == null) {
            if (this.f27248a == null || TextUtils.isEmpty(str)) {
                return false;
            }
            for (QRCodeWhiteListResponse.Group group : this.f27248a.getDataGroup()) {
                if (a(str, group.blacklist_preg)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27249b = new Handler(Looper.getMainLooper());
    }

    private boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, str)) == null) {
            for (QRCodeWhiteListResponse.Group group : this.f27248a.getDataGroup()) {
                if (a(str, group.lightapp_outer_open_preg)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (this.f27248a == null || TextUtils.isEmpty(str)) {
                return false;
            }
            for (QRCodeWhiteListResponse.Group group : this.f27248a.getDataGroup()) {
                if (a(str, group.url_preg)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0298a.f27264a : (a) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BeanManager.getInstance().removeAllBeans("QRCodeScannerGetWhiteList");
            BeanManager.getInstance().removeAllBeans("QRCodeScannerParseShortUrl");
        }
    }

    public void a(Context context, b bVar, b bVar2) {
        QRCodeWhiteListResponse.Category category;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, bVar, bVar2) == null) || bVar == null) {
            return;
        }
        BeanManager.getInstance().removeAllBeans("QRCodeScannerGetWhiteList");
        DXMSdkSAUtils.onEventStart("@getQRCodeScannerWhiteList");
        PayStatisticsUtil.onEventStart("@getQRCodeScannerWhiteList");
        com.baidu.wallet.qrcodescanner.beans.b bVar3 = (com.baidu.wallet.qrcodescanner.beans.b) QRCodeScannerBeanFactory.getInstance().getBean(context, QRCodeScannerBeanFactory.QRCODE_WHITE_LIST, "QRCodeScannerGetWhiteList");
        if (this.f27248a == null) {
            this.f27248a = a(context);
        }
        QRCodeWhiteListResponse qRCodeWhiteListResponse = this.f27248a;
        if (qRCodeWhiteListResponse != null) {
            a(qRCodeWhiteListResponse, bVar, bVar2);
        }
        QRCodeWhiteListResponse qRCodeWhiteListResponse2 = this.f27248a;
        if (qRCodeWhiteListResponse2 != null && (category = qRCodeWhiteListResponse2.whitelist) != null) {
            bVar3.a(category.fingerprint);
        }
        bVar3.setResponseCallback(new IBeanResponseCallback(this, context, bVar, bVar2) { // from class: com.baidu.wallet.qrcodescanner.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f27251a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f27252b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f27253c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f27254d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, bVar, bVar2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27254d = this;
                this.f27251a = context;
                this.f27252b = bVar;
                this.f27253c = bVar2;
            }

            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecFailure(int i2, int i3, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str) == null) {
                    DXMSdkSAUtils.onEventEnd("@getQRCodeScannerWhiteList", i3);
                    PayStatisticsUtil.onEventEnd("@getQRCodeScannerWhiteList", i3);
                }
            }

            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecSuccess(int i2, Object obj, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                    DXMSdkSAUtils.onEventEnd("@getQRCodeScannerWhiteList", 0);
                    PayStatisticsUtil.onEventEnd("@getQRCodeScannerWhiteList", 0);
                    QRCodeWhiteListResponse qRCodeWhiteListResponse3 = obj instanceof QRCodeWhiteListResponse ? (QRCodeWhiteListResponse) obj : null;
                    if (qRCodeWhiteListResponse3 != null && qRCodeWhiteListResponse3.checkResponseValidity() && qRCodeWhiteListResponse3.hasData()) {
                        this.f27254d.f27248a = qRCodeWhiteListResponse3;
                        this.f27254d.f27248a.doStoreResponse(this.f27251a);
                        this.f27254d.f27249b.post(new Runnable(this) { // from class: com.baidu.wallet.qrcodescanner.a.a.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f27255a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f27255a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    a aVar = this.f27255a.f27254d;
                                    QRCodeWhiteListResponse qRCodeWhiteListResponse4 = aVar.f27248a;
                                    AnonymousClass1 anonymousClass1 = this.f27255a;
                                    aVar.a(qRCodeWhiteListResponse4, anonymousClass1.f27252b, anonymousClass1.f27253c);
                                }
                            }
                        });
                    }
                }
            }
        });
        bVar3.execBean();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(QRCodeWhiteListResponse qRCodeWhiteListResponse, b bVar, b bVar2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, this, qRCodeWhiteListResponse, bVar, bVar2) == null) && qRCodeWhiteListResponse != null && qRCodeWhiteListResponse.hasData()) {
            QRCodeWhiteListResponse.Group group = this.f27248a.whitelist.data[0];
            if (bVar2 != null) {
                bVar2.onResultSuccessCallBack(group.title_value, null, false);
            }
            if (TextUtils.isEmpty(group.title_advert_logo) && TextUtils.isEmpty(group.title_type) && TextUtils.isEmpty(group.title_link_addr)) {
                return;
            }
            b.a aVar = new b.a();
            aVar.f27265a = group.title_type;
            aVar.f27266b = group.title_link_addr;
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
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:103:0x0124 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:125:0x0026 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:140:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0078 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x00f2 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0120 A[Catch: IOException -> 0x00da, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IOException -> 0x00da, blocks: (B:79:0x00f4, B:90:0x010a, B:101:0x0120, B:64:0x00d6), top: B:122:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f4 A[Catch: IOException -> 0x00da, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IOException -> 0x00da, blocks: (B:79:0x00f4, B:90:0x010a, B:101:0x0120, B:64:0x00d6), top: B:122:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010a A[Catch: IOException -> 0x00da, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IOException -> 0x00da, blocks: (B:79:0x00f4, B:90:0x010a, B:101:0x0120, B:64:0x00d6), top: B:122:0x0026 }] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Class<com.baidu.wallet.qrcodescanner.datamodel.QRCodeWhiteListResponse>, java.lang.Class] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v32, types: [com.baidu.wallet.qrcodescanner.datamodel.QRCodeWhiteListResponse] */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r9v23, types: [java.io.Reader, java.io.InputStreamReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private QRCodeWhiteListResponse a(Context context) {
        InterceptResult invokeL;
        QRCodeWhiteListResponse qRCodeWhiteListResponse;
        FileReader fileReader;
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        byte[] decode;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) != null) {
            return (QRCodeWhiteListResponse) invokeL.objValue;
        }
        InputStream inputStream4 = QRCodeWhiteListResponse.class;
        File file = new File(context.getCacheDir() + "/qrcode_scanner_1.cfg");
        FileReader fileReader2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        InputStream inputStream5 = null;
        fileReader2 = null;
        fileReader2 = null;
        fileReader2 = null;
        fileReader2 = 0;
        try {
            try {
                try {
                    boolean z = true;
                    if (file.exists() && file.isFile()) {
                        fileReader = new FileReader(file);
                        try {
                            try {
                                try {
                                    try {
                                        decode = Base64.decode(FileCopyUtils.copyToString(fileReader));
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                    if (decode != null) {
                                        String str = new String(decode);
                                        if (!TextUtils.isEmpty(str)) {
                                            qRCodeWhiteListResponse = (QRCodeWhiteListResponse) JsonUtils.fromJson(str, inputStream4);
                                            if (qRCodeWhiteListResponse != null) {
                                                try {
                                                    if (qRCodeWhiteListResponse.checkResponseValidity()) {
                                                        z = false;
                                                    }
                                                } catch (FileNotFoundException e3) {
                                                    e = e3;
                                                    inputStream3 = inputStream5;
                                                    fileReader2 = fileReader;
                                                    inputStream4 = inputStream3;
                                                    e.printStackTrace();
                                                    if (fileReader2 != null) {
                                                    }
                                                    if (inputStream4 != 0) {
                                                    }
                                                    return qRCodeWhiteListResponse;
                                                } catch (IOException e4) {
                                                    e = e4;
                                                    inputStream2 = inputStream5;
                                                    fileReader2 = fileReader;
                                                    inputStream4 = inputStream2;
                                                    e.printStackTrace();
                                                    if (fileReader2 != null) {
                                                    }
                                                    if (inputStream4 != null) {
                                                    }
                                                    return qRCodeWhiteListResponse;
                                                } catch (JSONException e5) {
                                                    e = e5;
                                                    inputStream = inputStream5;
                                                    fileReader2 = fileReader;
                                                    inputStream4 = inputStream;
                                                    e.printStackTrace();
                                                    if (fileReader2 != null) {
                                                    }
                                                    if (inputStream4 != null) {
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
                                    inputStream = null;
                                    qRCodeWhiteListResponse = null;
                                    fileReader2 = fileReader;
                                    inputStream4 = inputStream;
                                    e.printStackTrace();
                                    if (fileReader2 != null) {
                                        try {
                                            fileReader2.close();
                                        } catch (IOException e7) {
                                            e7.printStackTrace();
                                        }
                                    }
                                    if (inputStream4 != null) {
                                        inputStream4.close();
                                        inputStream4 = inputStream4;
                                        fileReader2 = fileReader2;
                                    }
                                    return qRCodeWhiteListResponse;
                                }
                            } catch (Throwable th) {
                                th = th;
                                inputStream4 = inputStream5;
                                fileReader2 = fileReader;
                                if (fileReader2 != null) {
                                    try {
                                        fileReader2.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                if (inputStream4 != 0) {
                                    try {
                                        inputStream4.close();
                                    } catch (IOException e9) {
                                        e9.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e10) {
                            e = e10;
                            inputStream3 = null;
                            qRCodeWhiteListResponse = null;
                            fileReader2 = fileReader;
                            inputStream4 = inputStream3;
                            e.printStackTrace();
                            if (fileReader2 != null) {
                                try {
                                    fileReader2.close();
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                }
                            }
                            if (inputStream4 != 0) {
                                inputStream4.close();
                                inputStream4 = inputStream4;
                                fileReader2 = fileReader2;
                            }
                            return qRCodeWhiteListResponse;
                        } catch (IOException e12) {
                            e = e12;
                            inputStream2 = null;
                            qRCodeWhiteListResponse = null;
                            fileReader2 = fileReader;
                            inputStream4 = inputStream2;
                            e.printStackTrace();
                            if (fileReader2 != null) {
                                try {
                                    fileReader2.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                }
                            }
                            if (inputStream4 != null) {
                                inputStream4.close();
                                inputStream4 = inputStream4;
                                fileReader2 = fileReader2;
                            }
                            return qRCodeWhiteListResponse;
                        }
                    } else {
                        fileReader = null;
                        qRCodeWhiteListResponse = null;
                    }
                    if (z) {
                        inputStream5 = context.getAssets().open("qrcode_scanner.cfg");
                        ?? inputStreamReader = new InputStreamReader(inputStream5);
                        try {
                            String copyToString = FileCopyUtils.copyToString(inputStreamReader);
                            if (TextUtils.isEmpty(copyToString)) {
                                fileReader = inputStreamReader;
                            } else {
                                inputStream4 = (QRCodeWhiteListResponse) JsonUtils.fromJson(copyToString, inputStream4);
                                fileReader = inputStreamReader;
                                qRCodeWhiteListResponse = inputStream4;
                            }
                        } catch (FileNotFoundException e14) {
                            fileReader2 = inputStreamReader;
                            e = e14;
                            inputStream4 = inputStream5;
                            e.printStackTrace();
                            if (fileReader2 != null) {
                            }
                            if (inputStream4 != 0) {
                            }
                            return qRCodeWhiteListResponse;
                        } catch (IOException e15) {
                            fileReader2 = inputStreamReader;
                            e = e15;
                            inputStream4 = inputStream5;
                            e.printStackTrace();
                            if (fileReader2 != null) {
                            }
                            if (inputStream4 != null) {
                            }
                            return qRCodeWhiteListResponse;
                        } catch (JSONException e16) {
                            fileReader2 = inputStreamReader;
                            e = e16;
                            inputStream4 = inputStream5;
                            e.printStackTrace();
                            if (fileReader2 != null) {
                            }
                            if (inputStream4 != null) {
                            }
                            return qRCodeWhiteListResponse;
                        } catch (Throwable th2) {
                            fileReader2 = inputStreamReader;
                            th = th2;
                            inputStream4 = inputStream5;
                            if (fileReader2 != null) {
                            }
                            if (inputStream4 != 0) {
                            }
                            throw th;
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            } catch (FileNotFoundException e19) {
                e = e19;
                inputStream4 = 0;
                qRCodeWhiteListResponse = null;
            } catch (IOException e20) {
                e = e20;
                inputStream4 = null;
                qRCodeWhiteListResponse = null;
            } catch (JSONException e21) {
                e = e21;
                inputStream4 = null;
                qRCodeWhiteListResponse = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream4 = 0;
            }
            if (inputStream5 != null) {
                inputStream5.close();
                inputStream4 = inputStream4;
                fileReader2 = inputStream5;
            }
            return qRCodeWhiteListResponse;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public void a(Context context, String str, b bVar, boolean z, boolean z2) {
        QRCodeWhiteListResponse qRCodeWhiteListResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, bVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f27250c = bVar;
            if (this.f27248a == null) {
                this.f27248a = a(context);
            }
            if (TextUtils.isEmpty(str) || (qRCodeWhiteListResponse = this.f27248a) == null) {
                bVar.onResultFail(str, "");
                this.f27250c = null;
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
                    if (this.f27250c != null) {
                        b.a aVar = new b.a();
                        aVar.f27265a = "600";
                        aVar.f27266b = str;
                        this.f27250c.onResultSuccessCallBack(str, aVar, true);
                    }
                } else if (b(str)) {
                    if (a(str)) {
                        a(str, true);
                    } else if (this.f27250c != null) {
                        b.a aVar2 = new b.a();
                        aVar2.f27265a = "300";
                        aVar2.f27266b = str;
                        this.f27250c.onResultSuccessCallBack(str, aVar2, true);
                    }
                } else if (this.f27250c != null) {
                    b.a aVar3 = new b.a();
                    aVar3.f27265a = "100";
                    aVar3.f27266b = str;
                    this.f27250c.onResultSuccessCallBack(str, aVar3, true);
                }
                this.f27250c = null;
            }
        }
    }

    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            if (c(str)) {
                if (this.f27250c != null) {
                    b.a aVar = new b.a();
                    aVar.f27265a = "2";
                    aVar.f27266b = str;
                    this.f27250c.onResultSuccessCallBack(str, aVar, z);
                }
            } else if (this.f27250c != null) {
                b.a aVar2 = new b.a();
                aVar2.f27265a = "1";
                aVar2.f27266b = str;
                this.f27250c.onResultSuccessCallBack(str, aVar2, z);
            }
            this.f27250c = null;
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            QRCodeWhiteListResponse qRCodeWhiteListResponse = this.f27248a;
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
        return invokeL.booleanValue;
    }

    private boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, str, str2)) == null) {
            if (str2 != null) {
                try {
                    return str.matches(str2);
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public BarcodeResult[] a(byte[] bArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048580, this, bArr, i2, i3, i4)) == null) ? Barcode.readBarcode(bArr, i2, i3, i4, 600) : (BarcodeResult[]) invokeLIII.objValue;
    }

    private void a(Context context, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, context, str) == null) {
            BeanManager.getInstance().removeAllBeans("QRCodeScannerParseShortUrl");
            DXMSdkSAUtils.onEventStart("@parseQRCodeScannerShortUrl");
            PayStatisticsUtil.onEventStart("@parseQRCodeScannerShortUrl");
            com.baidu.wallet.qrcodescanner.beans.a aVar = (com.baidu.wallet.qrcodescanner.beans.a) QRCodeScannerBeanFactory.getInstance().getBean(context, QRCodeScannerBeanFactory.QRCODE_SHORT_URL, "QRCodeScannerParseShortUrl");
            QRCodeWhiteListResponse qRCodeWhiteListResponse = this.f27248a;
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
            aVar.setResponseCallback(new AnonymousClass2(this, str, context));
            aVar.execBean();
        }
    }
}
