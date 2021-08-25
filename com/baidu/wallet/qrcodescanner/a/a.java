package com.baidu.wallet.qrcodescanner.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
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
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public QRCodeWhiteListResponse f63455a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f63456b;

    /* renamed from: c  reason: collision with root package name */
    public b f63457c;

    /* renamed from: com.baidu.wallet.qrcodescanner.a.a$2  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass2 implements IBeanResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f63463a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f63464b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f63465c;

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
            this.f63465c = aVar;
            this.f63463a = str;
            this.f63464b = context;
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                if (this.f63465c.f63456b == null) {
                    this.f63465c.f63456b = new Handler(Looper.getMainLooper());
                }
                this.f63465c.f63456b.post(new Runnable(this, i3) { // from class: com.baidu.wallet.qrcodescanner.a.a.2.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f63468a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass2 f63469b;

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
                        this.f63469b = this;
                        this.f63468a = i3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.f63468a == 5003) {
                                WalletLoginHelper.getInstance().login(new LoginBackListenerProxy(this.f63469b.f63464b, new ILoginBackListener(this) { // from class: com.baidu.wallet.qrcodescanner.a.a.2.2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ RunnableC18662 f63470a;

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
                                        this.f63470a = this;
                                    }

                                    @Override // com.baidu.wallet.api.ILoginBackListener
                                    public void onFail(int i4, String str2) {
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeIL(1048576, this, i4, str2) == null) || this.f63470a.f63469b.f63465c.f63457c == null) {
                                            return;
                                        }
                                        this.f63470a.f63469b.f63465c.f63457c.onResultFail(this.f63470a.f63469b.f63463a, str2);
                                        this.f63470a.f63469b.f63465c.f63457c = null;
                                    }

                                    @Override // com.baidu.wallet.api.ILoginBackListener
                                    public void onSuccess(int i4, String str2) {
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str2) == null) || this.f63470a.f63469b.f63465c.f63457c == null) {
                                            return;
                                        }
                                        this.f63470a.f63469b.f63465c.f63457c.onResultFail(this.f63470a.f63469b.f63463a, "");
                                        this.f63470a.f63469b.f63465c.f63457c = null;
                                    }
                                }));
                                return;
                            }
                            AnonymousClass2 anonymousClass2 = this.f63469b;
                            a aVar = anonymousClass2.f63465c;
                            aVar.a(anonymousClass2.f63464b, anonymousClass2.f63463a, aVar.f63457c, false, false);
                        }
                    }
                });
            }
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                QRCodeShortUrlResponse qRCodeShortUrlResponse = obj instanceof QRCodeShortUrlResponse ? (QRCodeShortUrlResponse) obj : null;
                if (qRCodeShortUrlResponse == null || !qRCodeShortUrlResponse.checkResponseValidity()) {
                    return;
                }
                if (this.f63465c.f63456b == null) {
                    this.f63465c.f63456b = new Handler(Looper.getMainLooper());
                }
                this.f63465c.f63456b.post(new Runnable(this, qRCodeShortUrlResponse) { // from class: com.baidu.wallet.qrcodescanner.a.a.2.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ QRCodeShortUrlResponse f63466a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass2 f63467b;

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
                        this.f63467b = this;
                        this.f63466a = qRCodeShortUrlResponse;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if ("500".equals(this.f63466a.type) || "3".equals(this.f63466a.type) || "501".equals(this.f63466a.type)) {
                                if (this.f63467b.f63465c.f63457c != null) {
                                    b.a aVar = new b.a();
                                    QRCodeShortUrlResponse qRCodeShortUrlResponse2 = this.f63466a;
                                    aVar.f63472a = qRCodeShortUrlResponse2.type;
                                    aVar.f63473b = qRCodeShortUrlResponse2.link_addr;
                                    aVar.f63474c = qRCodeShortUrlResponse2.params;
                                    aVar.f63475d = qRCodeShortUrlResponse2.err;
                                    this.f63467b.f63465c.f63457c.onResultSuccessCallBack(this.f63467b.f63463a, aVar, true);
                                    this.f63467b.f63465c.f63457c = null;
                                    return;
                                }
                                return;
                            }
                            AnonymousClass2 anonymousClass2 = this.f63467b;
                            a aVar2 = anonymousClass2.f63465c;
                            aVar2.a(anonymousClass2.f63464b, this.f63466a.link_addr, aVar2.f63457c, false, false);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.wallet.qrcodescanner.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1867a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f63471a;
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
            f63471a = new a();
        }
    }

    private boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, str)) == null) {
            if (this.f63455a == null || TextUtils.isEmpty(str)) {
                return false;
            }
            for (QRCodeWhiteListResponse.Group group : this.f63455a.getDataGroup()) {
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
        this.f63456b = new Handler(Looper.getMainLooper());
    }

    private boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, str)) == null) {
            for (QRCodeWhiteListResponse.Group group : this.f63455a.getDataGroup()) {
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
            if (this.f63455a == null || TextUtils.isEmpty(str)) {
                return false;
            }
            for (QRCodeWhiteListResponse.Group group : this.f63455a.getDataGroup()) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C1867a.f63471a : (a) invokeV.objValue;
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
        com.baidu.wallet.qrcodescanner.beans.b bVar3 = (com.baidu.wallet.qrcodescanner.beans.b) QRCodeScannerBeanFactory.getInstance().getBean(context, QRCodeScannerBeanFactory.QRCODE_WHITE_LIST, "QRCodeScannerGetWhiteList");
        if (this.f63455a == null) {
            this.f63455a = a(context);
        }
        QRCodeWhiteListResponse qRCodeWhiteListResponse = this.f63455a;
        if (qRCodeWhiteListResponse != null) {
            a(qRCodeWhiteListResponse, bVar, bVar2);
        }
        QRCodeWhiteListResponse qRCodeWhiteListResponse2 = this.f63455a;
        if (qRCodeWhiteListResponse2 != null && (category = qRCodeWhiteListResponse2.whitelist) != null) {
            bVar3.a(category.fingerprint);
        }
        bVar3.setResponseCallback(new IBeanResponseCallback(this, context, bVar, bVar2) { // from class: com.baidu.wallet.qrcodescanner.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f63458a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f63459b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f63460c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f63461d;

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
                this.f63461d = this;
                this.f63458a = context;
                this.f63459b = bVar;
                this.f63460c = bVar2;
            }

            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecFailure(int i2, int i3, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str) == null) {
                }
            }

            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecSuccess(int i2, Object obj, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                    QRCodeWhiteListResponse qRCodeWhiteListResponse3 = obj instanceof QRCodeWhiteListResponse ? (QRCodeWhiteListResponse) obj : null;
                    if (qRCodeWhiteListResponse3 != null && qRCodeWhiteListResponse3.checkResponseValidity() && qRCodeWhiteListResponse3.hasData()) {
                        this.f63461d.f63455a = qRCodeWhiteListResponse3;
                        this.f63461d.f63455a.doStoreResponse(this.f63458a);
                        this.f63461d.f63456b.post(new Runnable(this) { // from class: com.baidu.wallet.qrcodescanner.a.a.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f63462a;

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
                                this.f63462a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    a aVar = this.f63462a.f63461d;
                                    QRCodeWhiteListResponse qRCodeWhiteListResponse4 = aVar.f63455a;
                                    AnonymousClass1 anonymousClass1 = this.f63462a;
                                    aVar.a(qRCodeWhiteListResponse4, anonymousClass1.f63459b, anonymousClass1.f63460c);
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
            QRCodeWhiteListResponse.Group group = this.f63455a.whitelist.data[0];
            if (bVar2 != null) {
                bVar2.onResultSuccessCallBack(group.title_value, null, false);
            }
            if (TextUtils.isEmpty(group.title_advert_logo) && TextUtils.isEmpty(group.title_type) && TextUtils.isEmpty(group.title_link_addr)) {
                return;
            }
            b.a aVar = new b.a();
            aVar.f63472a = group.title_type;
            aVar.f63473b = group.title_link_addr;
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:115:0x0184 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:135:0x002d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:136:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:145:0x0028 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0092 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:89:0x013a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0152 A[Catch: IOException -> 0x0122, TRY_ENTER, TRY_LEAVE, TryCatch #26 {IOException -> 0x0122, blocks: (B:90:0x013c, B:101:0x0152, B:112:0x0168, B:75:0x011e), top: B:156:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0168 A[Catch: IOException -> 0x0122, TRY_ENTER, TRY_LEAVE, TryCatch #26 {IOException -> 0x0122, blocks: (B:90:0x013c, B:101:0x0152, B:112:0x0168, B:75:0x011e), top: B:156:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0191 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0187 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075 A[Catch: all -> 0x0101, JSONException -> 0x0106, IOException -> 0x010a, FileNotFoundException -> 0x010e, TryCatch #2 {JSONException -> 0x0106, blocks: (B:16:0x0055, B:25:0x0075, B:37:0x0094, B:28:0x007d, B:23:0x0070), top: B:135:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0094 A[Catch: all -> 0x0101, JSONException -> 0x0106, IOException -> 0x010a, FileNotFoundException -> 0x010e, TRY_LEAVE, TryCatch #2 {JSONException -> 0x0106, blocks: (B:16:0x0055, B:25:0x0075, B:37:0x0094, B:28:0x007d, B:23:0x0070), top: B:135:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x011e A[Catch: IOException -> 0x0122, TRY_ENTER, TRY_LEAVE, TryCatch #26 {IOException -> 0x0122, blocks: (B:90:0x013c, B:101:0x0152, B:112:0x0168, B:75:0x011e), top: B:156:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013c A[Catch: IOException -> 0x0122, TRY_ENTER, TRY_LEAVE, TryCatch #26 {IOException -> 0x0122, blocks: (B:90:0x013c, B:101:0x0152, B:112:0x0168, B:75:0x011e), top: B:156:0x0028 }] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Class<com.baidu.wallet.qrcodescanner.datamodel.QRCodeWhiteListResponse>, java.lang.Class] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.io.FileReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private QRCodeWhiteListResponse a(Context context) {
        InterceptResult invokeL;
        QRCodeWhiteListResponse qRCodeWhiteListResponse;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        InputStream inputStream2;
        InputStreamReader inputStreamReader3;
        InputStream inputStream3;
        byte[] decode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
            InputStream inputStream4 = QRCodeWhiteListResponse.class;
            File file = new File(context.getCacheDir() + "/qrcode_scanner_1.cfg");
            InputStreamReader inputStreamReader4 = null;
            r3 = null;
            r3 = null;
            r3 = null;
            r3 = null;
            InputStream inputStream5 = null;
            inputStreamReader4 = null;
            inputStreamReader4 = null;
            inputStreamReader4 = null;
            inputStreamReader4 = null;
            try {
                try {
                    try {
                        boolean exists = file.exists();
                        boolean z = true;
                        try {
                            if (exists && file.isFile()) {
                                exists = new FileReader(file);
                                try {
                                    try {
                                        try {
                                            try {
                                                decode = Base64.decode(FileCopyUtils.copyToString(exists));
                                            } catch (IOException e2) {
                                                e = e2;
                                                qRCodeWhiteListResponse = null;
                                            }
                                            if (decode != null) {
                                                String str = new String(decode);
                                                if (!TextUtils.isEmpty(str)) {
                                                    qRCodeWhiteListResponse = (QRCodeWhiteListResponse) JsonUtils.fromJson(str, inputStream4);
                                                    try {
                                                        LogUtil.d("qrcode_whitelist", "use cache data = " + str);
                                                    } catch (IOException e3) {
                                                        e = e3;
                                                        try {
                                                            e.printStackTrace();
                                                            if (qRCodeWhiteListResponse == null) {
                                                            }
                                                            file.delete();
                                                            exists = exists;
                                                            if (z) {
                                                            }
                                                            if (exists != 0) {
                                                            }
                                                            if (inputStream5 != null) {
                                                            }
                                                        } catch (FileNotFoundException e4) {
                                                            e = e4;
                                                            inputStream3 = inputStream5;
                                                            inputStreamReader3 = exists;
                                                            inputStreamReader4 = inputStreamReader3;
                                                            inputStream4 = inputStream3;
                                                            e.printStackTrace();
                                                            if (inputStreamReader4 != null) {
                                                                try {
                                                                    inputStreamReader4.close();
                                                                } catch (IOException e5) {
                                                                    e5.printStackTrace();
                                                                }
                                                            }
                                                            if (inputStream4 != 0) {
                                                                inputStream4.close();
                                                            }
                                                            LogUtil.d("qrcode_whitelist", "use server data = " + JsonUtils.toJson(qRCodeWhiteListResponse));
                                                            return qRCodeWhiteListResponse;
                                                        } catch (IOException e6) {
                                                            e = e6;
                                                            inputStream2 = inputStream5;
                                                            inputStreamReader2 = exists;
                                                            inputStreamReader4 = inputStreamReader2;
                                                            inputStream4 = inputStream2;
                                                            e.printStackTrace();
                                                            if (inputStreamReader4 != null) {
                                                                try {
                                                                    inputStreamReader4.close();
                                                                } catch (IOException e7) {
                                                                    e7.printStackTrace();
                                                                }
                                                            }
                                                            if (inputStream4 != null) {
                                                                inputStream4.close();
                                                            }
                                                            LogUtil.d("qrcode_whitelist", "use server data = " + JsonUtils.toJson(qRCodeWhiteListResponse));
                                                            return qRCodeWhiteListResponse;
                                                        }
                                                        LogUtil.d("qrcode_whitelist", "use server data = " + JsonUtils.toJson(qRCodeWhiteListResponse));
                                                        return qRCodeWhiteListResponse;
                                                    }
                                                    if (qRCodeWhiteListResponse == null && qRCodeWhiteListResponse.checkResponseValidity()) {
                                                        z = false;
                                                        exists = exists;
                                                    } else {
                                                        file.delete();
                                                        exists = exists;
                                                    }
                                                }
                                            }
                                            qRCodeWhiteListResponse = null;
                                            if (qRCodeWhiteListResponse == null) {
                                            }
                                            file.delete();
                                            exists = exists;
                                        } catch (JSONException e8) {
                                            e = e8;
                                            inputStream = null;
                                            qRCodeWhiteListResponse = null;
                                            inputStreamReader = exists;
                                            inputStreamReader4 = inputStreamReader;
                                            inputStream4 = inputStream;
                                            e.printStackTrace();
                                            if (inputStreamReader4 != null) {
                                                try {
                                                    inputStreamReader4.close();
                                                } catch (IOException e9) {
                                                    e9.printStackTrace();
                                                }
                                            }
                                            if (inputStream4 != null) {
                                                inputStream4.close();
                                            }
                                            LogUtil.d("qrcode_whitelist", "use server data = " + JsonUtils.toJson(qRCodeWhiteListResponse));
                                            return qRCodeWhiteListResponse;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        inputStream4 = inputStream5;
                                        inputStreamReader4 = exists;
                                        if (inputStreamReader4 != null) {
                                        }
                                        if (inputStream4 != null) {
                                        }
                                        throw th;
                                    }
                                } catch (FileNotFoundException e10) {
                                    e = e10;
                                    inputStream3 = null;
                                    qRCodeWhiteListResponse = null;
                                    inputStreamReader3 = exists;
                                    inputStreamReader4 = inputStreamReader3;
                                    inputStream4 = inputStream3;
                                    e.printStackTrace();
                                    if (inputStreamReader4 != null) {
                                    }
                                    if (inputStream4 != 0) {
                                    }
                                    LogUtil.d("qrcode_whitelist", "use server data = " + JsonUtils.toJson(qRCodeWhiteListResponse));
                                    return qRCodeWhiteListResponse;
                                } catch (IOException e11) {
                                    e = e11;
                                    inputStream2 = null;
                                    qRCodeWhiteListResponse = null;
                                    inputStreamReader2 = exists;
                                    inputStreamReader4 = inputStreamReader2;
                                    inputStream4 = inputStream2;
                                    e.printStackTrace();
                                    if (inputStreamReader4 != null) {
                                    }
                                    if (inputStream4 != null) {
                                    }
                                    LogUtil.d("qrcode_whitelist", "use server data = " + JsonUtils.toJson(qRCodeWhiteListResponse));
                                    return qRCodeWhiteListResponse;
                                }
                            } else {
                                exists = 0;
                                qRCodeWhiteListResponse = null;
                            }
                            if (z) {
                                inputStream5 = DxmApplicationContextImpl.getApplicationContext(context).getAssets().open("qrcode_scanner.cfg");
                                InputStreamReader inputStreamReader5 = new InputStreamReader(inputStream5);
                                try {
                                    try {
                                        String copyToString = FileCopyUtils.copyToString(inputStreamReader5);
                                        if (TextUtils.isEmpty(copyToString)) {
                                            exists = inputStreamReader5;
                                        } else {
                                            QRCodeWhiteListResponse qRCodeWhiteListResponse2 = (QRCodeWhiteListResponse) JsonUtils.fromJson(copyToString, inputStream4);
                                            try {
                                                LogUtil.d("qrcode_whitelist", "use default data = " + copyToString);
                                                exists = inputStreamReader5;
                                                qRCodeWhiteListResponse = qRCodeWhiteListResponse2;
                                            } catch (FileNotFoundException e12) {
                                                qRCodeWhiteListResponse = qRCodeWhiteListResponse2;
                                                inputStream4 = inputStream5;
                                                inputStreamReader4 = inputStreamReader5;
                                                e = e12;
                                                e.printStackTrace();
                                                if (inputStreamReader4 != null) {
                                                }
                                                if (inputStream4 != 0) {
                                                }
                                                LogUtil.d("qrcode_whitelist", "use server data = " + JsonUtils.toJson(qRCodeWhiteListResponse));
                                                return qRCodeWhiteListResponse;
                                            } catch (IOException e13) {
                                                qRCodeWhiteListResponse = qRCodeWhiteListResponse2;
                                                inputStream4 = inputStream5;
                                                inputStreamReader4 = inputStreamReader5;
                                                e = e13;
                                                e.printStackTrace();
                                                if (inputStreamReader4 != null) {
                                                }
                                                if (inputStream4 != null) {
                                                }
                                                LogUtil.d("qrcode_whitelist", "use server data = " + JsonUtils.toJson(qRCodeWhiteListResponse));
                                                return qRCodeWhiteListResponse;
                                            } catch (JSONException e14) {
                                                qRCodeWhiteListResponse = qRCodeWhiteListResponse2;
                                                inputStream4 = inputStream5;
                                                inputStreamReader4 = inputStreamReader5;
                                                e = e14;
                                                e.printStackTrace();
                                                if (inputStreamReader4 != null) {
                                                }
                                                if (inputStream4 != null) {
                                                }
                                                LogUtil.d("qrcode_whitelist", "use server data = " + JsonUtils.toJson(qRCodeWhiteListResponse));
                                                return qRCodeWhiteListResponse;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        inputStreamReader4 = inputStreamReader5;
                                        th = th2;
                                        inputStream4 = inputStream5;
                                        if (inputStreamReader4 != null) {
                                            try {
                                                inputStreamReader4.close();
                                            } catch (IOException e15) {
                                                e15.printStackTrace();
                                            }
                                        }
                                        if (inputStream4 != null) {
                                            try {
                                                inputStream4.close();
                                            } catch (IOException e16) {
                                                e16.printStackTrace();
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (FileNotFoundException e17) {
                                    inputStreamReader4 = inputStreamReader5;
                                    e = e17;
                                    inputStream4 = inputStream5;
                                } catch (IOException e18) {
                                    inputStreamReader4 = inputStreamReader5;
                                    e = e18;
                                    inputStream4 = inputStream5;
                                } catch (JSONException e19) {
                                    inputStreamReader4 = inputStreamReader5;
                                    e = e19;
                                    inputStream4 = inputStream5;
                                }
                            }
                            if (exists != 0) {
                                try {
                                    exists.close();
                                } catch (IOException e20) {
                                    e20.printStackTrace();
                                }
                            }
                        } catch (JSONException e21) {
                            e = e21;
                            inputStream = inputStream5;
                            inputStreamReader = exists;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (FileNotFoundException e22) {
                    e = e22;
                    inputStream4 = 0;
                    qRCodeWhiteListResponse = null;
                } catch (IOException e23) {
                    e = e23;
                    inputStream4 = null;
                    qRCodeWhiteListResponse = null;
                } catch (JSONException e24) {
                    e = e24;
                    inputStream4 = null;
                    qRCodeWhiteListResponse = null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream4 = null;
                }
                if (inputStream5 != null) {
                    inputStream5.close();
                }
            } catch (IOException e25) {
                e25.printStackTrace();
            }
            LogUtil.d("qrcode_whitelist", "use server data = " + JsonUtils.toJson(qRCodeWhiteListResponse));
            return qRCodeWhiteListResponse;
        }
        return (QRCodeWhiteListResponse) invokeL.objValue;
    }

    public void a(Context context, String str, b bVar, boolean z, boolean z2) {
        QRCodeWhiteListResponse qRCodeWhiteListResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, bVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f63457c = bVar;
            if (this.f63455a == null) {
                this.f63455a = a(context);
            }
            if (TextUtils.isEmpty(str) || (qRCodeWhiteListResponse = this.f63455a) == null) {
                bVar.onResultFail(str, "");
                this.f63457c = null;
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
                    if (this.f63457c != null) {
                        b.a aVar = new b.a();
                        aVar.f63472a = "600";
                        aVar.f63473b = str;
                        this.f63457c.onResultSuccessCallBack(str, aVar, true);
                    }
                } else if (b(str)) {
                    if (a(str)) {
                        a(str, true);
                    } else if (this.f63457c != null) {
                        b.a aVar2 = new b.a();
                        aVar2.f63472a = "300";
                        aVar2.f63473b = str;
                        this.f63457c.onResultSuccessCallBack(str, aVar2, true);
                    }
                } else if (this.f63457c != null) {
                    b.a aVar3 = new b.a();
                    aVar3.f63472a = "100";
                    aVar3.f63473b = str;
                    this.f63457c.onResultSuccessCallBack(str, aVar3, true);
                }
                this.f63457c = null;
            }
        }
    }

    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            if (c(str)) {
                if (this.f63457c != null) {
                    b.a aVar = new b.a();
                    aVar.f63472a = "2";
                    aVar.f63473b = str;
                    this.f63457c.onResultSuccessCallBack(str, aVar, z);
                }
            } else if (this.f63457c != null) {
                b.a aVar2 = new b.a();
                aVar2.f63472a = "1";
                aVar2.f63473b = str;
                this.f63457c.onResultSuccessCallBack(str, aVar2, z);
            }
            this.f63457c = null;
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            QRCodeWhiteListResponse qRCodeWhiteListResponse = this.f63455a;
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
            com.baidu.wallet.qrcodescanner.beans.a aVar = (com.baidu.wallet.qrcodescanner.beans.a) QRCodeScannerBeanFactory.getInstance().getBean(context, QRCodeScannerBeanFactory.QRCODE_SHORT_URL, "QRCodeScannerParseShortUrl");
            QRCodeWhiteListResponse qRCodeWhiteListResponse = this.f63455a;
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
