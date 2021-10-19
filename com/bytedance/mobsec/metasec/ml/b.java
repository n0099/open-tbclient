package com.bytedance.mobsec.metasec.ml;

import android.app.Application;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.bytedance.JProtect;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
import ms.bd.c.h;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f64427i;

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f64428j;
    public static final String[] k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Point f64429a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f64430b;

    /* renamed from: c  reason: collision with root package name */
    public a f64431c;

    /* renamed from: d  reason: collision with root package name */
    public a f64432d;

    /* renamed from: e  reason: collision with root package name */
    public HandlerThread f64433e;

    /* renamed from: f  reason: collision with root package name */
    public Context f64434f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64435g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64436h;

    /* loaded from: classes9.dex */
    public class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Uri f64437a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f64438b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Uri uri, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, uri, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64438b = bVar;
            this.f64437a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.onChange(z);
                this.f64438b.a(this.f64437a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1085442522, "Lcom/bytedance/mobsec/metasec/ml/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1085442522, "Lcom/bytedance/mobsec/metasec/ml/b;");
                return;
            }
        }
        f64427i = new String[]{(String) h.a(16777217, 0, 0L, "8ea7ac", new byte[]{22, 99, 19, 87, 95}), (String) h.a(16777217, 0, 0L, "5ec0a3", new byte[]{32, 102, 4, 65, 74, 37, 61, 65, 60})};
        f64428j = new String[]{(String) h.a(16777217, 0, 0L, "b5464f", new byte[]{76, 51, 70, 86, 10}), (String) h.a(16777217, 0, 0L, "047856", new byte[]{37, 55, 80, 73, 30, 32, 56, 16, 104}), (String) h.a(16777217, 0, 0L, "776176", new byte[]{49, 60, 65, 81, 0}), (String) h.a(16777217, 0, 0L, "169526", new byte[]{40, 49, 67, 70, 5, 53})};
        k = new String[]{(String) h.a(16777217, 0, 0L, "6fcf17", new byte[]{52, 103, 2, 23, 11, 46, 38, 79, 61, 34}), (String) h.a(16777217, 0, 0L, "15143f", new byte[]{51, 52, 80, 69, 9, ByteCompanionObject.MAX_VALUE, 13, 7, 104, 107, 52}), (String) h.a(16777217, 0, 0L, "229f26", new byte[]{48, 51, 88, 23, 8, 47, 124, 0, 96, 57, 55}), (String) h.a(16777217, 0, 0L, "fbee72", new byte[]{100, 99, 4, 20, 13, 43, 37, 80, 60, 58, 99}), (String) h.a(16777217, 0, 0L, "856b74", new byte[]{58, 52, 87, 19, 13, UtilsBlink.VER_TYPE_SEPARATOR, 56, 21, 119, 38, 60, 37, 64}), (String) h.a(16777217, 0, 0L, "0e3a2d", new byte[]{50, 100, 82, 16, 8, 125, StandardMessageCodec.LIST, 71, 99, PublicSuffixDatabase.EXCEPTION_MARKER, 53, 114, 82, 16}), (String) h.a(16777217, 0, 0L, "0e63be", new byte[]{50, 100, 87, 66, 88, 124, 126, 71, 102, 115, 53, 114, 87, 66}), (String) h.a(16777217, 0, 0L, "0f0845", new byte[]{50, 103, 81, 73, 14, 44, 115, 68, 96, 120, 53, 113, 81, 73}), (String) h.a(16777217, 0, 0L, "b645c2", new byte[]{96, 55, 85, 68, 89, 43, 98, 22, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1}), (String) h.a(16777217, 0, 0L, "0a8303", new byte[]{50, 96, 89, 66, 10, 42, StandardMessageCodec.LIST, 67, 104, 115}), (String) h.a(16777217, 0, 0L, "a5cc37", new byte[]{99, 52, 2, 18, 9, 46, 47, 23, 51, Base64.INTERNAL_PADDING}), (String) h.a(16777217, 0, 0L, "296531", new byte[]{48, 56, 87, 68, 9, 40, 113, 27, 102, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1})};
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: android.graphics.Point */
    /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: android.graphics.Point */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0175 A[Catch: all -> 0x023f, TRY_LEAVE, TryCatch #4 {all -> 0x023f, blocks: (B:16:0x0142, B:19:0x0175), top: B:46:0x0142 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0262  */
    @JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(Context context) {
        Context context2;
        Context context3;
        Point point;
        WindowManager windowManager;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64430b = new ArrayList();
        this.f64435g = false;
        this.f64436h = false;
        Context applicationContext = context.getApplicationContext();
        this.f64434f = applicationContext;
        if (applicationContext instanceof Application) {
            context2 = null;
        } else {
            try {
                context2 = null;
                try {
                    context3 = (Application) Class.forName((String) h.a(16777217, 0, 0L, "0b8fd7", new byte[]{32, 110, 79, 0, 84, 41, 55, 13, 104, 38, 49, 46, 106, 17, 79, 41, 37, 74, 125, 47, 21, 104, 89, 23, 90, 36})).getMethod((String) h.a(16777217, 0, 0L, "c46932", new byte[]{113, Base64.INTERNAL_PADDING, 87, 95, 9, 43, 116, 52, 119, 121, 126, 63, 70, 76, 24, 44, 111, 27}), new Class[0]).invoke(null, null);
                } catch (Throwable unused) {
                    context3 = context2;
                    this.f64434f = context3 == null ? this.f64434f : context3;
                    windowManager = (WindowManager) context.getSystemService((String) h.a(16777217, 0, 0L, "1cf2da", new byte[]{55, 104, 27, 66, 84, 97}));
                    if (windowManager != null) {
                    }
                }
            } catch (Throwable unused2) {
                context2 = null;
            }
            this.f64434f = context3 == null ? this.f64434f : context3;
        }
        try {
            windowManager = (WindowManager) context.getSystemService((String) h.a(16777217, 0, 0L, "1cf2da", new byte[]{55, 104, 27, 66, 84, 97}));
        } catch (Throwable unused3) {
        }
        if (windowManager != null) {
            point = context2;
            this.f64429a = point;
            this.f64433e = new HandlerThread((String) h.a(16777217, 0, 0L, "861e4c", new byte[]{26, 7}));
            this.f64436h = Build.VERSION.SDK_INT >= 29;
        }
        Point point2 = new Point();
        try {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point2);
            } else {
                point2.set(((Integer) Display.class.getMethod((String) h.a(16777217, 0, 0L, "322d67", new byte[]{37, 53, 85, 34, 8, 55, 7, 26, 103, 32, 42}), new Class[0]).invoke(defaultDisplay, new Object[0])).intValue(), ((Integer) Display.class.getMethod((String) h.a(16777217, 0, 0L, "5e744d", new byte[]{Base64.INTERNAL_PADDING, 98, 80, 114, 10, 100, 30, 65, 111, 99, 44, 115}), new Class[0]).invoke(defaultDisplay, new Object[0])).intValue());
            }
        } catch (Throwable unused4) {
        }
        point = point2;
        this.f64429a = point;
        this.f64433e = new HandlerThread((String) h.a(16777217, 0, 0L, "861e4c", new byte[]{26, 7}));
        this.f64436h = Build.VERSION.SDK_INT >= 29;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:123:0x023b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0248 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0235 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0237 A[LOOP:0: B:79:0x0237->B:126:0x0237, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x0235 -> B:79:0x0237). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x023f -> B:79:0x0237). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x0245 -> B:81:0x023b). Please submit an issue!!! */
    @androidx.annotation.Keep
    @com.bytedance.JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(android.net.Uri r36) {
        /*
            r35 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.bytedance.mobsec.metasec.ml.b.$ic
            if (r0 != 0) goto L297
        L4:
            r0 = r35
            int r1 = ms.bd.c.c0.a()
            r2 = 32
            r5 = 9
            r6 = 2
            r7 = 3
            r8 = 1
            if (r1 == r8) goto L1c
            r1 = 33
            r3 = 40
            r4 = 33
            r5 = 1
            goto L237
        L1c:
            android.content.Context r9 = r0.f64434f     // Catch: java.lang.Throwable -> L289
            android.content.ContentResolver r10 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L289
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L289
            r15 = 16
            if (r9 >= r15) goto L2b
            java.lang.String[] r9 = com.bytedance.mobsec.metasec.ml.b.f64427i     // Catch: java.lang.Throwable -> L289
            goto L2d
        L2b:
            java.lang.String[] r9 = com.bytedance.mobsec.metasec.ml.b.f64428j     // Catch: java.lang.Throwable -> L289
        L2d:
            r12 = r9
            r9 = 23
            byte[] r9 = new byte[r9]     // Catch: java.lang.Throwable -> L289
            r14 = 0
            r9[r14] = r2     // Catch: java.lang.Throwable -> L289
            r11 = 51
            r9[r8] = r11     // Catch: java.lang.Throwable -> L289
            r9[r6] = r7     // Catch: java.lang.Throwable -> L289
            r11 = 66
            r9[r7] = r11     // Catch: java.lang.Throwable -> L289
            r11 = 55
            r22 = 4
            r9[r22] = r11     // Catch: java.lang.Throwable -> L289
            r23 = 34
            r13 = 5
            r9[r13] = r23     // Catch: java.lang.Throwable -> L289
            r24 = 50
            r11 = 6
            r9[r11] = r24     // Catch: java.lang.Throwable -> L289
            r16 = 21
            r25 = 7
            r9[r25] = r16     // Catch: java.lang.Throwable -> L289
            r17 = 48
            r26 = 8
            r9[r26] = r17     // Catch: java.lang.Throwable -> L289
            r27 = 103(0x67, float:1.44E-43)
            r9[r5] = r27     // Catch: java.lang.Throwable -> L289
            r18 = 10
            r19 = 100
            r9[r18] = r19     // Catch: java.lang.Throwable -> L289
            r18 = 54
            r19 = 11
            r9[r19] = r18     // Catch: java.lang.Throwable -> L289
            r18 = 12
            r20 = 18
            r9[r18] = r20     // Catch: java.lang.Throwable -> L289
            r18 = 13
            r20 = 84
            r9[r18] = r20     // Catch: java.lang.Throwable -> L289
            r18 = 14
            r9[r18] = r19     // Catch: java.lang.Throwable -> L289
            r18 = 15
            r19 = 99
            r9[r18] = r19     // Catch: java.lang.Throwable -> L289
            r18 = 58
            r9[r15] = r18     // Catch: java.lang.Throwable -> L289
            r18 = 17
            r28 = 24
            r9[r18] = r28     // Catch: java.lang.Throwable -> L289
            r18 = 18
            r19 = 56
            r9[r18] = r19     // Catch: java.lang.Throwable -> L289
            r18 = 19
            r19 = 106(0x6a, float:1.49E-43)
            r9[r18] = r19     // Catch: java.lang.Throwable -> L289
            r18 = 20
            r9[r18] = r17     // Catch: java.lang.Throwable -> L289
            r17 = 114(0x72, float:1.6E-43)
            r9[r16] = r17     // Catch: java.lang.Throwable -> L289
            r16 = 22
            r17 = 70
            r9[r16] = r17     // Catch: java.lang.Throwable -> L289
            r29 = 0
            r30 = 0
            r16 = 16777217(0x1000001, float:2.350989E-38)
            r17 = 0
            r18 = 0
            java.lang.String r20 = "50d374"
            r21 = r9
            java.lang.Object r9 = ms.bd.c.h.a(r16, r17, r18, r20, r21)     // Catch: java.lang.Throwable -> L289
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L289
            r1 = 6
            r11 = r36
            r2 = 5
            r13 = r29
            r3 = 0
            r14 = r30
            r4 = 16
            r15 = r9
            android.database.Cursor r9 = r10.query(r11, r12, r13, r14, r15)     // Catch: java.lang.Throwable -> L289
            if (r9 != 0) goto Le0
            if (r9 == 0) goto L244
            boolean r1 = r9.isClosed()
            if (r1 != 0) goto Ld9
            r9.close()
            goto L244
        Ld9:
            r3 = 40
            r4 = 82
            r5 = 3
            goto L23b
        Le0:
            boolean r10 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L287
            if (r10 != 0) goto Lf0
            boolean r1 = r9.isClosed()
            if (r1 != 0) goto Lef
            r9.close()
        Lef:
            return
        Lf0:
            byte[] r15 = new byte[r2]     // Catch: java.lang.Throwable -> L287
            r15[r3] = r28     // Catch: java.lang.Throwable -> L287
            r10 = 98
            r15[r8] = r10     // Catch: java.lang.Throwable -> L287
            r10 = 67
            r15[r6] = r10     // Catch: java.lang.Throwable -> L287
            r15[r7] = r8     // Catch: java.lang.Throwable -> L287
            r10 = 12
            r15[r22] = r10     // Catch: java.lang.Throwable -> L287
            r10 = 16777217(0x1000001, float:2.350989E-38)
            r11 = 0
            r12 = 0
            java.lang.String r14 = "6d1a24"
            java.lang.Object r10 = ms.bd.c.h.a(r10, r11, r12, r14, r15)     // Catch: java.lang.Throwable -> L287
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L287
            int r10 = r9.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L287
            byte[] r15 = new byte[r5]     // Catch: java.lang.Throwable -> L287
            r11 = 115(0x73, float:1.61E-43)
            r15[r3] = r11     // Catch: java.lang.Throwable -> L287
            r11 = 59
            r15[r8] = r11     // Catch: java.lang.Throwable -> L287
            r11 = 95
            r15[r6] = r11     // Catch: java.lang.Throwable -> L287
            r11 = 73
            r15[r7] = r11     // Catch: java.lang.Throwable -> L287
            r15[r22] = r28     // Catch: java.lang.Throwable -> L287
            r15[r2] = r23     // Catch: java.lang.Throwable -> L287
            r11 = 110(0x6e, float:1.54E-43)
            r15[r1] = r11     // Catch: java.lang.Throwable -> L287
            r11 = 28
            r15[r25] = r11     // Catch: java.lang.Throwable -> L287
            r15[r26] = r27     // Catch: java.lang.Throwable -> L287
            r11 = 16777217(0x1000001, float:2.350989E-38)
            r12 = 0
            r13 = 0
            java.lang.String r16 = "f88834"
            r18 = r15
            r15 = r16
            r16 = r18
            java.lang.Object r11 = ms.bd.c.h.a(r11, r12, r13, r15, r16)     // Catch: java.lang.Throwable -> L287
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L287
            int r11 = r9.getColumnIndex(r11)     // Catch: java.lang.Throwable -> L287
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L287
            r14 = -1
            if (r12 < r4) goto L1a6
            byte[] r4 = new byte[r2]     // Catch: java.lang.Throwable -> L287
            r4[r3] = r24     // Catch: java.lang.Throwable -> L287
            r12 = 109(0x6d, float:1.53E-43)
            r4[r8] = r12     // Catch: java.lang.Throwable -> L287
            r12 = 19
            r4[r6] = r12     // Catch: java.lang.Throwable -> L287
            r12 = 82
            r4[r7] = r12     // Catch: java.lang.Throwable -> L287
            r4[r22] = r8     // Catch: java.lang.Throwable -> L287
            r29 = 16777217(0x1000001, float:2.350989E-38)
            r30 = 0
            r31 = 0
            java.lang.String r33 = "4fd269"
            r34 = r4
            java.lang.Object r4 = ms.bd.c.h.a(r29, r30, r31, r33, r34)     // Catch: java.lang.Throwable -> L287
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L287
            int r4 = r9.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L287
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L287
            r13 = 125(0x7d, float:1.75E-43)
            r1[r3] = r13     // Catch: java.lang.Throwable -> L287
            r13 = 102(0x66, float:1.43E-43)
            r1[r8] = r13     // Catch: java.lang.Throwable -> L287
            r1[r6] = r28     // Catch: java.lang.Throwable -> L287
            r13 = 17
            r1[r7] = r13     // Catch: java.lang.Throwable -> L287
            r13 = 14
            r1[r22] = r13     // Catch: java.lang.Throwable -> L287
            r13 = 59
            r1[r2] = r13     // Catch: java.lang.Throwable -> L287
            r29 = 16777217(0x1000001, float:2.350989E-38)
            r30 = 0
            r31 = 0
            java.lang.String r33 = "dabb98"
            r34 = r1
            java.lang.Object r1 = ms.bd.c.h.a(r29, r30, r31, r33, r34)     // Catch: java.lang.Throwable -> L287
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L287
            int r1 = r9.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L287
            goto L1aa
        L1a6:
            r12 = 82
            r1 = -1
            r4 = -1
        L1aa:
            java.lang.String r2 = r9.getString(r10)     // Catch: java.lang.Throwable -> L287
            long r10 = r9.getLong(r11)     // Catch: java.lang.Throwable -> L287
            if (r4 < 0) goto L1bf
            if (r1 < 0) goto L1bf
            int r4 = r9.getInt(r4)     // Catch: java.lang.Throwable -> L287
            int r1 = r9.getInt(r1)     // Catch: java.lang.Throwable -> L287
            goto L1c1
        L1bf:
            r1 = -1
            r4 = -1
        L1c1:
            if (r4 == r14) goto L1e1
            if (r1 == r14) goto L1e1
            android.graphics.Point r13 = r0.f64429a     // Catch: java.lang.Throwable -> L287
            if (r13 != 0) goto L1ca
            goto L1e1
        L1ca:
            int r15 = r13.x     // Catch: java.lang.Throwable -> L287
            if (r4 > r15) goto L1d2
            int r13 = r13.y     // Catch: java.lang.Throwable -> L287
            if (r1 <= r13) goto L1dd
        L1d2:
            android.graphics.Point r13 = r0.f64429a     // Catch: java.lang.Throwable -> L287
            int r15 = r13.x     // Catch: java.lang.Throwable -> L287
            if (r1 > r15) goto L1df
            int r1 = r13.y     // Catch: java.lang.Throwable -> L287
            if (r4 <= r1) goto L1dd
            goto L1df
        L1dd:
            r1 = 1
            goto L1e2
        L1df:
            r1 = -1
            goto L1e2
        L1e1:
            r1 = 0
        L1e2:
            if (r1 != r14) goto L1f1
            boolean r1 = r9.isClosed()
            if (r1 != 0) goto L1ee
            r9.close()
            goto L244
        L1ee:
            r4 = 82
            goto L245
        L1f1:
            long r12 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L287
            long r12 = r12 - r10
            r10 = 10000(0x2710, double:4.9407E-320)
            int r1 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r1 <= 0) goto L206
            boolean r1 = r9.isClosed()
            if (r1 != 0) goto L205
            r9.close()
        L205:
            return
        L206:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L287
            if (r1 == 0) goto L20d
            goto L224
        L20d:
            java.lang.String r1 = r2.toLowerCase()     // Catch: java.lang.Throwable -> L287
            java.lang.String[] r4 = com.bytedance.mobsec.metasec.ml.b.k     // Catch: java.lang.Throwable -> L287
            int r10 = r4.length
            r11 = 0
        L215:
            if (r11 >= r10) goto L224
            r12 = r4[r11]     // Catch: java.lang.Throwable -> L287
            boolean r12 = r1.contains(r12)     // Catch: java.lang.Throwable -> L287
            if (r12 == 0) goto L221
            r1 = 1
            goto L225
        L221:
            int r11 = r11 + 1
            goto L215
        L224:
            r1 = -1
        L225:
            if (r1 != r14) goto L249
            boolean r1 = r9.isClosed()
            if (r1 != 0) goto L231
            r9.close()
            goto L248
        L231:
            r1 = 53
            r3 = 53
        L235:
            r4 = 32
        L237:
            switch(r4) {
                case 32: goto L248;
                case 33: goto L23b;
                case 34: goto L237;
                default: goto L23a;
            }
        L23a:
            goto L235
        L23b:
            switch(r3) {
                case 38: goto L244;
                case 39: goto L244;
                case 40: goto L23f;
                default: goto L23e;
            }
        L23e:
            goto L245
        L23f:
            if (r5 == r6) goto L237
            if (r5 == r7) goto L244
        L244:
            return
        L245:
            r3 = 39
            goto L23b
        L248:
            return
        L249:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L287
            if (r1 == 0) goto L250
            goto L258
        L250:
            java.util.List<java.lang.String> r1 = r0.f64430b     // Catch: java.lang.Throwable -> L287
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Throwable -> L287
            if (r1 == 0) goto L25a
        L258:
            r8 = -1
            goto L26e
        L25a:
            java.util.List<java.lang.String> r1 = r0.f64430b     // Catch: java.lang.Throwable -> L287
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L287
            r4 = 20
            if (r1 < r4) goto L269
            java.util.List<java.lang.String> r1 = r0.f64430b     // Catch: java.lang.Throwable -> L287
            r1.remove(r3)     // Catch: java.lang.Throwable -> L287
        L269:
            java.util.List<java.lang.String> r1 = r0.f64430b     // Catch: java.lang.Throwable -> L287
            r1.add(r2)     // Catch: java.lang.Throwable -> L287
        L26e:
            if (r8 != r14) goto L27a
            boolean r1 = r9.isClosed()
            if (r1 != 0) goto L279
            r9.close()
        L279:
            return
        L27a:
            r1 = 268435458(0x10000002, float:2.5243555E-29)
            ms.bd.c.b.a(r1)     // Catch: java.lang.Throwable -> L287
            boolean r1 = r9.isClosed()
            if (r1 != 0) goto L296
            goto L293
        L287:
            r1 = r9
            goto L28a
        L289:
            r1 = 0
        L28a:
            if (r1 == 0) goto L296
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto L296
            r9 = r1
        L293:
            r9.close()
        L296:
            return
        L297:
            r33 = r0
            r34 = 65538(0x10002, float:9.1838E-41)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r33.invokeL(r34, r35, r36)
            if (r0 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.mobsec.metasec.ml.b.a(android.net.Uri):void");
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.f64435g) {
                    return;
                }
                this.f64435g = true;
                try {
                    this.f64433e.start();
                    Handler handler = new Handler(this.f64433e.getLooper());
                    this.f64431c = new a(this, MediaStore.Images.Media.INTERNAL_CONTENT_URI, handler);
                    this.f64432d = new a(this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, handler);
                    this.f64434f.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.f64436h, this.f64431c);
                    this.f64434f.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.f64436h, this.f64432d);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f64431c != null) {
                    try {
                        this.f64434f.getContentResolver().unregisterContentObserver(this.f64431c);
                    } catch (Throwable unused) {
                    }
                    this.f64431c = null;
                }
                if (this.f64432d != null) {
                    try {
                        this.f64434f.getContentResolver().unregisterContentObserver(this.f64432d);
                    } catch (Throwable unused2) {
                    }
                    this.f64432d = null;
                }
                HandlerThread handlerThread = this.f64433e;
                if (handlerThread != null) {
                    try {
                        handlerThread.quit();
                    } catch (Throwable unused3) {
                    }
                }
            }
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c();
            super.finalize();
        }
    }
}
