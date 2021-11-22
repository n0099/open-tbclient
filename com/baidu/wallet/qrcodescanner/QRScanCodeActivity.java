package com.baidu.wallet.qrcodescanner;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.Html;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.apollon.imagemanager.ImageProcessor;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.idl.barcode.BarcodeResult;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.activity.ImageClipActivity;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.IScannerDispatchListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.camera.CameraBaseActivity;
import com.baidu.wallet.base.camera.IImageProcess;
import com.baidu.wallet.base.camera.OnCameraChangeListener;
import com.baidu.wallet.base.camera.internal.CameraCtrl;
import com.baidu.wallet.base.camera.internal.Yuv;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.qrcodescanner.ComfirmOrderActivity;
import com.baidu.wallet.qrcodescanner.ScanCodeController;
import com.baidu.wallet.qrcodescanner.a;
import com.baidu.wallet.qrcodescanner.a.b;
import com.baidu.wallet.qrcodescanner.datamodel.QRCodeShortUrlResponse;
import com.baidu.wallet.qrcodescanner.widget.MistLayorView;
import com.baidu.wallet.qrcodescanner.widget.ProgressView;
import com.baidu.wallet.qrcodescanner.widget.ScanLineView;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.AccessibilityUtils;
import com.bumptech.glide.load.engine.GlideException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes10.dex */
public class QRScanCodeActivity extends CameraBaseActivity implements View.OnClickListener, IImageProcess, OnCameraChangeListener, com.baidu.wallet.qrcodescanner.a.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIALOG_ALIPAY_JD_WX_COPY = 294;
    public static final int DIALOG_CHECK_SAFE = 290;
    public static final int DIALOG_COLLECTION_CODE_TIP = 295;
    public static final int DIALOG_PROCESS_IMG_FAILED = 291;
    public static final int DIALOG_TXT_COPY = 289;

    /* renamed from: c  reason: collision with root package name */
    public static int f61679c = 10010;
    public static IScanCodeListener mLightAppListener;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;

    /* renamed from: a  reason: collision with root package name */
    public Runnable f61680a;

    /* renamed from: b  reason: collision with root package name */
    public final int f61681b;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f61682d;

    /* renamed from: e  reason: collision with root package name */
    public ImageProcessor f61683e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f61684f;

    /* renamed from: g  reason: collision with root package name */
    public ScanLineView f61685g;

    /* renamed from: h  reason: collision with root package name */
    public MistLayorView f61686h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressView f61687i;
    public ImageView j;
    public ImageView k;
    public CameraCtrl l;
    public ImageView m;
    public NetImageView n;
    public RelativeLayout o;
    public SoundPool.OnLoadCompleteListener p;
    public SoundPool q;
    public com.baidu.wallet.qrcodescanner.a r;
    public String s;
    public String t;
    public String u;
    public String v;
    public Handler w;
    public View x;
    public TextView y;
    public View.OnTouchListener z;

    /* renamed from: com.baidu.wallet.qrcodescanner.QRScanCodeActivity$15  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass15 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f61698a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1995196724, "Lcom/baidu/wallet/qrcodescanner/QRScanCodeActivity$15;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1995196724, "Lcom/baidu/wallet/qrcodescanner/QRScanCodeActivity$15;");
                    return;
                }
            }
            int[] iArr = new int[ScanCodeController.DecodeTool.values().length];
            f61698a = iArr;
            try {
                iArr[ScanCodeController.DecodeTool.ZXING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: com.baidu.wallet.qrcodescanner.QRScanCodeActivity$16  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass16 implements com.baidu.wallet.qrcodescanner.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ QRScanCodeActivity f61699a;

        /* renamed from: com.baidu.wallet.qrcodescanner.QRScanCodeActivity$16$1  reason: invalid class name */
        /* loaded from: classes10.dex */
        public class AnonymousClass1 implements Html.ImageGetter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AnonymousClass16 f61700a;

            public AnonymousClass1(AnonymousClass16 anonymousClass16) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {anonymousClass16};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61700a = anonymousClass16;
            }

            @Override // android.text.Html.ImageGetter
            public Drawable getDrawable(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                    LevelListDrawable levelListDrawable = new LevelListDrawable();
                    ImageLoader.getInstance(DxmApplicationContextImpl.getApplicationContext(this.f61700a.f61699a.getActivity())).getBitmap(str, new ImageLoader.OnGetBitmapListener(this, DisplayUtils.dip2px(this.f61700a.f61699a.getActivity(), 22.0f), DisplayUtils.dip2px(this.f61700a.f61699a.getActivity(), 14.0f), levelListDrawable) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.16.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f61701a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ int f61702b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ LevelListDrawable f61703c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f61704d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(r7), Integer.valueOf(r8), levelListDrawable};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61704d = this;
                            this.f61701a = r7;
                            this.f61702b = r8;
                            this.f61703c = levelListDrawable;
                        }

                        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                        public boolean needCancel(String str2, Object obj) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str2, obj)) == null) {
                                return false;
                            }
                            return invokeLL.booleanValue;
                        }

                        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                        public void onError(String str2, Object obj) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, obj) == null) {
                            }
                        }

                        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                        public void onGetBitmap(String str2, Object obj, Bitmap bitmap) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str2, obj, bitmap) == null) || bitmap == null) {
                                return;
                            }
                            this.f61703c.addLevel(1, 1, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap, this.f61701a, this.f61702b, true)));
                            this.f61703c.setBounds(0, 0, this.f61701a, this.f61702b);
                            this.f61703c.setLevel(1);
                            this.f61704d.f61700a.f61699a.runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.16.1.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ C18681 f61705a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f61705a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f61705a.f61704d.f61700a.f61699a.y.refreshDrawableState();
                                        this.f61705a.f61704d.f61700a.f61699a.y.setText(this.f61705a.f61704d.f61700a.f61699a.y.getText());
                                    }
                                }
                            });
                        }
                    }, null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
                    return levelListDrawable;
                }
                return (Drawable) invokeL.objValue;
            }
        }

        public AnonymousClass16(QRScanCodeActivity qRScanCodeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRScanCodeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61699a = qRScanCodeActivity;
        }

        @Override // com.baidu.wallet.qrcodescanner.a.b
        public void onResultFail(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // com.baidu.wallet.qrcodescanner.a.b
        public void onResultSuccessCallBack(String str, b.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar, z) == null) {
                if (TextUtils.isEmpty(str)) {
                    this.f61699a.y.setVisibility(4);
                    return;
                }
                try {
                    this.f61699a.y.setText(Html.fromHtml(str, new AnonymousClass1(this), null));
                    this.f61699a.y.setVisibility(0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ QRScanCodeActivity f61730a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f61731b;

        /* renamed from: c  reason: collision with root package name */
        public int f61732c;

        /* renamed from: d  reason: collision with root package name */
        public int f61733d;

        /* renamed from: e  reason: collision with root package name */
        public int f61734e;

        /* renamed from: f  reason: collision with root package name */
        public Object[] f61735f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f61736g;

        public a(QRScanCodeActivity qRScanCodeActivity, byte[] bArr, int i2, int i3, int i4, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRScanCodeActivity, bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61730a = qRScanCodeActivity;
            this.f61731b = bArr;
            this.f61732c = i2;
            this.f61733d = i3;
            this.f61734e = i4;
            this.f61736g = iArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (AnonymousClass15.f61698a[ScanCodeController.a().ordinal()] != 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    LogUtil.i("zxing", "zxing result cost " + currentTimeMillis);
                    this.f61735f = com.baidu.wallet.qrcodescanner.a.a.a().a(this.f61731b, this.f61732c, this.f61733d, this.f61734e);
                    LogUtil.i("zxing", "zxing result cost " + (System.currentTimeMillis() - currentTimeMillis));
                    DXMSdkSAUtils.onEventEndWithValues("qrcodeIdlCost", (int) (System.currentTimeMillis() - currentTimeMillis), Arrays.asList("album"));
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    LogUtil.i("zxing", "zxing result cost " + currentTimeMillis2);
                    this.f61735f = this.f61730a.a(this.f61732c, this.f61733d, this.f61736g);
                    LogUtil.i("zxing", "zxing result cost " + (System.currentTimeMillis() - currentTimeMillis2));
                    DXMSdkSAUtils.onEventEndWithValues("qrcodeZxingCost", (int) (System.currentTimeMillis() - currentTimeMillis2), Arrays.asList("album"));
                }
                Object[] objArr = this.f61735f;
                if (objArr != null) {
                    this.f61730a.onProcessImageOk(objArr);
                } else {
                    this.f61730a.runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a f61737a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr2 = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61737a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                WalletGlobalUtils.safeShowDialog(this.f61737a.f61730a, QRScanCodeActivity.DIALOG_PROCESS_IMG_FAILED, "");
                                this.f61737a.f61730a.restartScan();
                                this.f61737a.f61730a.f61685g.start();
                            }
                        }
                    });
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements SoundPool.OnLoadCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SoundPool f61738a;

        /* renamed from: b  reason: collision with root package name */
        public int f61739b;

        public b(SoundPool soundPool, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {soundPool, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61738a = soundPool;
            this.f61739b = i2;
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, soundPool, i2, i3) == null) {
                soundPool.play(this.f61739b, 2.0f, 2.0f, 0, 0, 1.0f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1904263834, "Lcom/baidu/wallet/qrcodescanner/QRScanCodeActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1904263834, "Lcom/baidu/wallet/qrcodescanner/QRScanCodeActivity;");
        }
    }

    public QRScanCodeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61681b = 17;
        this.A = true;
        this.B = true;
        this.C = false;
        this.f61680a = new Runnable(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ QRScanCodeActivity f61728a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f61728a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f61728a.f61687i.setVisibility(8);
                }
            }
        };
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
        }
    }

    public static byte[] clipyuv420sp(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            if (i4 > i2 || i5 > i3) {
                return null;
            }
            int i8 = i6 * i7;
            byte[] bArr2 = new byte[(i8 / 2) + i8];
            int i9 = i8 - ((i5 / 2) * i6);
            int i10 = (i3 * i2) + i4;
            int i11 = i5 * i2;
            int i12 = 0;
            for (int i13 = i5; i13 < i5 + i7; i13++) {
                System.arraycopy(bArr, i11 + i4, bArr2, i12, i6);
                i11 += i2;
                i12 += i6;
                if ((i13 & 1) == 0) {
                    System.arraycopy(bArr, i10, bArr2, i9, i6);
                    i10 += i2;
                    i9 += i6;
                }
            }
            return bArr2;
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static void encodeYUV420SP(byte[] bArr, int[] iArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65555, null, bArr, iArr, i2, i3) == null) {
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i2 * i4;
                int i6 = 0;
                while (i6 < i2) {
                    int i7 = 255;
                    int i8 = (((((((iArr[i5] & 16711680) >> 16) * 66) + (((iArr[i5] & 65280) >> 8) * 129)) + ((iArr[i5] & 255) * 25)) + 128) >> 8) + 16;
                    int i9 = i5 + 1;
                    if (i8 < 0) {
                        i7 = 0;
                    } else if (i8 <= 255) {
                        i7 = i8;
                    }
                    bArr[i5] = (byte) i7;
                    i6++;
                    i5 = i9;
                }
            }
        }
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(65558, null, context, uri, str, strArr)) != null) {
            return (String) invokeLLLL.objValue;
        }
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        if (query != null) {
                            query.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @TargetApi(19)
    public static String getPath(Context context, Uri uri) {
        InterceptResult invokeLL;
        Uri uri2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, uri)) == null) {
            if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
                if (isExternalStorageDocument(uri)) {
                    String[] split = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(split[0]) && split.length > 1) {
                        return Environment.getExternalStorageDirectory() + "/" + split[1];
                    }
                } else if (isDownloadsDocument(uri)) {
                    return getDataColumn(context, ContentUris.withAppendedId(Uri.parse(ImageClipActivity.n), Long.parseLong(DocumentsContract.getDocumentId(uri))), null, null);
                } else {
                    if (isMediaDocument(uri)) {
                        String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = split2[0];
                        if ("image".equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if ("video".equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = MediaStreamTrack.AUDIO_TRACK_KIND.equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
                        }
                        return getDataColumn(context, uri2, "_id=?", split2.length > 1 ? new String[]{split2[1]} : null);
                    }
                }
            } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return getDataColumn(context, uri, null, null);
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, uri)) == null) ? ImageClipActivity.l.equals(uri.getAuthority()) : invokeL.booleanValue;
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, uri)) == null) ? ImageClipActivity.m.equals(uri.getAuthority()) : invokeL.booleanValue;
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, uri)) == null) ? "com.google.android.apps.photos.content".equals(uri.getAuthority()) : invokeL.booleanValue;
    }

    public static boolean isMediaDocument(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, uri)) == null) ? ImageClipActivity.k.equals(uri.getAuthority()) : invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public void destroyProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.finish();
            mLightAppListener = null;
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public View getCustomizedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? View.inflate(this, ResUtils.layout(getActivity(), "wallet_qrscanner_main_view"), null) : (View) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public float getFocusDataYXRatioal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public IImageProcess getImageProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (IImageProcess) invokeV.objValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public int getRecycledBufSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) ? i2 * i3 : invokeII.intValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public boolean initProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, intent) == null) && i3 == -1) {
            pauseCamera();
            Uri uri = null;
            if (i2 == 17) {
                if (intent != null && intent.getData() != null) {
                    uri = intent.getData();
                }
                Uri uri2 = uri;
                if (uri2 == null) {
                    return;
                }
                Intent intent2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent2.setData(uri2);
                sendBroadcast(intent2);
                getContentResolver();
                try {
                    if (this.f61682d != null) {
                        this.f61682d.recycle();
                    }
                    if (getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
                        ParcelFileDescriptor openFileDescriptor = getContentResolver().openFileDescriptor(uri2, r.f41000a);
                        if (openFileDescriptor != null) {
                            this.f61682d = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
                        }
                        openFileDescriptor.close();
                    } else if (Build.VERSION.SDK_INT >= 19) {
                        this.f61682d = this.f61683e.decode(new File(getPath(getActivity(), uri2)), 0);
                    } else {
                        Cursor query = getActivity().getContentResolver().query(uri2, new String[]{"_data"}, null, null, null);
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                        query.moveToFirst();
                        String string = query.getString(columnIndexOrThrow);
                        query.close();
                        this.f61682d = this.f61683e.decode(new File(string), 0);
                    }
                    int width = this.f61682d.getWidth();
                    int height = this.f61682d.getHeight();
                    int i4 = width * height;
                    int[] iArr = new int[i4];
                    byte[] bArr = new byte[i4];
                    this.f61682d.getPixels(iArr, 0, width, 0, 0, width, height);
                    encodeYUV420SP(bArr, iArr, width, height);
                    LogUtil.d("zxing", "idl pixels = " + iArr);
                    new a(this, bArr, width, height, 2, iArr).start();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            IScanCodeListener iScanCodeListener = mLightAppListener;
            if (iScanCodeListener != null) {
                iScanCodeListener.onResult(0, "");
            }
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.base.camera.OnCameraChangeListener
    public void onCameraClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.baidu.wallet.base.camera.OnCameraChangeListener
    public void onCameraOpen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.j.setVisibility(CameraCtrl.isSupprtFlashLight(getPackageManager()) ? 0 : 8);
            this.C = this.l.isSupportZoom();
            this.f61685g.start();
            if (this.l.isSupportZoom()) {
                this.f61687i.setMaxPregress(this.l.getMaxZoom());
                this.f61687i.setProgress(this.l.getCurrentZoom());
                this.r.a(new a.InterfaceC1870a(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ QRScanCodeActivity f61729a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61729a = this;
                    }

                    @Override // com.baidu.wallet.qrcodescanner.a.InterfaceC1870a
                    public void a(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                            int currentZoom = this.f61729a.l.getCurrentZoom();
                            int maxZoom = this.f61729a.l.getMaxZoom();
                            int i2 = z ? currentZoom + 2 : currentZoom - 2;
                            if (i2 < 0) {
                                maxZoom = 0;
                            } else if (i2 <= maxZoom) {
                                maxZoom = i2;
                            }
                            this.f61729a.l.setZoom(maxZoom);
                            this.f61729a.f61687i.setProgress(maxZoom);
                            this.f61729a.f61687i.invalidate();
                        }
                    }

                    @Override // com.baidu.wallet.qrcodescanner.a.InterfaceC1870a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f61729a.C) {
                            this.f61729a.showProgress();
                        }
                    }
                });
                this.f61684f.setOnTouchListener(this.r);
                this.f61687i.setProgressStatusChangeListener(new ProgressView.b(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ QRScanCodeActivity f61689a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61689a = this;
                    }

                    @Override // com.baidu.wallet.qrcodescanner.widget.ProgressView.b
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f61689a.C) {
                            this.f61689a.showProgress();
                        }
                    }

                    @Override // com.baidu.wallet.qrcodescanner.widget.ProgressView.b
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                            this.f61689a.l.setZoom(i2);
                        }
                    }
                });
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            int id = view.getId();
            if (view == this.j) {
                DXMSdkSAUtils.onEvent("scanCodeUseFlash");
                triggerFlash();
            } else if (view == this.k) {
                DXMSdkSAUtils.onEvent("scanCodeFromAlbum");
                if (PermissionManager.checkCallingPermission(getActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
                    Intent intent = new Intent();
                    intent.addCategory("android.intent.category.OPENABLE");
                    if (Build.VERSION.SDK_INT < 19) {
                        intent.setAction("android.intent.action.GET_CONTENT");
                    } else {
                        intent.setAction("android.intent.action.OPEN_DOCUMENT");
                    }
                    intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, BdUploadHandler.IMAGE_MIME_TYPE);
                    startActivityForResult(Intent.createChooser(intent, "选择图片"), 17);
                } else if (Build.VERSION.SDK_INT >= 16) {
                    BaiduWalletUtils.requestPermissionsDialog(null, getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new BaiduWalletUtils.IRequestPermissionCallBack(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f61727a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61727a = this;
                        }

                        @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                        public void isAllAgree(Boolean bool) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                                if (bool.booleanValue()) {
                                    if (PermissionManager.checkCallingOrSelfPermission(this.f61727a.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, QRScanCodeActivity.f61679c)) {
                                        return;
                                    }
                                    this.f61727a.c();
                                } else if (Build.VERSION.SDK_INT >= 23) {
                                    this.f61727a.onRequestPermissionsResult(1, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new int[]{-1});
                                }
                            }
                        }

                        @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                        public void isShow(String str, Boolean bool) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bool) == null) {
                            }
                        }

                        @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                        public void requestResult(String str, Boolean bool) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bool) == null) {
                            }
                        }
                    });
                }
            } else if (view == this.x) {
                DXMSdkSAUtils.onEvent("scanCodeBack");
                onBackPressed();
                finish();
            } else if (view == this.m) {
                DXMSdkSAUtils.onEvent("scanCodeCloseBanner");
                this.o.setVisibility(8);
            } else if (ResUtils.id(getActivity(), "qrcode_gen_out_btn") == id) {
                EventBus.getInstance().register(this, "QRScanCodeActivity.evt_close", 0, EventBus.ThreadMode.MainThread);
                BaiduWalletServiceController.getInstance().gotoWalletService((Context) getActivity(), 512L, "", false);
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, com.baidu.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            this.f61685g = (ScanLineView) findViewById(ResUtils.id(getActivity(), "camera_scanline"));
            this.y = (TextView) findViewById(ResUtils.id(getActivity(), "ad_union_text"));
            if (DisplayUtils.getDisplayHeight(this) < DisplayUtils.dip2px(this, 535.0f)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f61685g.getLayoutParams();
                int dip2px = DisplayUtils.dip2px(this, 200.0f);
                layoutParams.width = dip2px;
                layoutParams.height = dip2px;
                ((RelativeLayout.LayoutParams) this.y.getLayoutParams()).width = layoutParams.width;
            }
            this.f61686h = (MistLayorView) findViewById(ResUtils.id(getActivity(), "camera_mist"));
            this.f61687i = (ProgressView) findViewById(ResUtils.id(getActivity(), "camera_progress_zoom"));
            this.j = (ImageView) findViewById(ResUtils.id(getActivity(), "flash_light_switch"));
            this.k = (ImageView) findViewById(ResUtils.id(getActivity(), "open_album"));
            this.f61684f = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "camera_ui"));
            this.o = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "camera_ad_layout"));
            this.n = (NetImageView) findViewById(ResUtils.id(getActivity(), "camera_ad"));
            this.m = (ImageView) findViewById(ResUtils.id(getActivity(), "camera_ad_del"));
            this.v = ResUtils.getString(getActivity(), "wallet_qrscancode_safe_tips");
            this.m.setOnClickListener(this);
            View findViewById = findViewById(ResUtils.id(getActivity(), "camera_title_back"));
            this.x = findViewById;
            findViewById.setOnClickListener(this);
            AccessibilityUtils.setContentDescription(this.x, "返回");
            this.r = new com.baidu.wallet.qrcodescanner.a();
            this.l = CameraCtrl.getInstance();
            this.w = new Handler(getMainLooper());
            b();
            setOnCameraChangeListener(this);
            this.j.setOnClickListener(this);
            AccessibilityUtils.setContentDescription(this.j, "打开闪光灯");
            this.k.setOnClickListener(this);
            this.f61683e = new ImageProcessor(DxmApplicationContextImpl.getApplicationContext(this));
            View.OnTouchListener onTouchListener = new View.OnTouchListener(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ QRScanCodeActivity f61688a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61688a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                            ViewHelper.setAlpha(view, 1.0f);
                            return false;
                        }
                        ViewHelper.setAlpha(view, 0.5f);
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            };
            this.z = onTouchListener;
            this.k.setOnTouchListener(onTouchListener);
            com.baidu.wallet.qrcodescanner.a.a.a().a(getActivity(), new com.baidu.wallet.qrcodescanner.a.b(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ QRScanCodeActivity f61691a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61691a = this;
                }

                @Override // com.baidu.wallet.qrcodescanner.a.b
                public void onResultFail(String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, str2) == null) {
                    }
                }

                @Override // com.baidu.wallet.qrcodescanner.a.b
                public void onResultSuccessCallBack(String str, b.a aVar, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar, z) == null) {
                        this.f61691a.n.setImageUrl(str);
                        this.f61691a.o.setVisibility(0);
                        if (aVar != null) {
                            this.f61691a.n.setOnClickListener(new View.OnClickListener(this, aVar) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.12.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ b.a f61692a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f61693b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, aVar};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f61693b = this;
                                    this.f61692a = aVar;
                                }

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) {
                                        DXMSdkSAUtils.onEvent("scanCodeOpenBanner");
                                        if ("2".equals(this.f61692a.f61762a)) {
                                            WalletLoginHelper.getInstance().startPage(this.f61692a.f61763b);
                                        } else if ("1".equals(this.f61692a.f61762a)) {
                                            if (!NetworkUtils.isNetworkAvailable(this.f61693b.f61691a.getActivity())) {
                                                GlobalUtils.toast(this.f61693b.f61691a.getActivity(), ResUtils.getString(this.f61693b.f61691a.getActivity(), "ebpay_no_network"));
                                            } else {
                                                BaiduWalletDelegate.getInstance().openH5Module(this.f61693b.f61691a.getActivity(), this.f61692a.f61763b, false);
                                            }
                                        } else if ("3".equals(this.f61692a.f61762a)) {
                                            BaiduWalletServiceController.getInstance().gotoWalletService(this.f61693b.f61691a.getActivity(), this.f61692a.f61763b, "");
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
            }, new AnonymousClass16(this));
            if (ScanCodeController.a(2)) {
                ((TextView) findViewById(ResUtils.id(getActivity(), "camera_scandesc"))).setText(ResUtils.getString(getActivity(), "wallet_bar_qr_scancode_desc"));
            }
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            Bundle extras = intent.getExtras();
            if (extras != null && extras.getBoolean("showQrCodeBtns", false)) {
                a(true);
                View findViewById2 = findViewById(ResUtils.id(getActivity(), "qrcode_gen_out_btn"));
                findViewById2.setOnClickListener(this);
                findViewById2.setOnTouchListener(this.z);
                return;
            }
            a(false);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (i2 != 289) {
                if (i2 != 291) {
                    if (i2 != 295) {
                        return super.onCreateDialog(i2);
                    }
                    return new PromptDialog(getActivity());
                }
                return new PromptDialog(getActivity());
            }
            return new PromptDialog(getActivity());
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f61685g.stop();
            SoundPool soundPool = this.q;
            if (soundPool != null) {
                soundPool.release();
                this.q.setOnLoadCompleteListener(null);
            }
            Handler handler = this.w;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.w = null;
            }
            this.p = null;
            com.baidu.wallet.qrcodescanner.a.a.a().b();
            super.onDestroy();
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, event) == null) && event != null && "QRScanCodeActivity.evt_close".equals(event.mEventKey)) {
            EventBus.getInstance().unregister(this, "QRScanCodeActivity.evt_close");
            if (isFinishing()) {
                return;
            }
            finish();
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onPermissionDenied() {
        IScanCodeListener iScanCodeListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (iScanCodeListener = mLightAppListener) == null) {
            return;
        }
        iScanCodeListener.onResult(2, "camera_permission_denied");
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i2, dialog) == null) {
            switch (i2) {
                case DIALOG_TXT_COPY /* 289 */:
                    PromptDialog promptDialog = (PromptDialog) dialog;
                    promptDialog.setMessage(this.s);
                    promptDialog.showCloseBtn(true);
                    promptDialog.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.19
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f61711a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61711a = this;
                        }

                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                this.f61711a.restartScan();
                            }
                        }
                    });
                    promptDialog.setNegativeBtn(ResUtils.getString(this, "wallet_qr_scancode_cancel"), new View.OnClickListener(this, promptDialog) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.20
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f61714a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f61715b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, promptDialog};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61715b = this;
                            this.f61714a = promptDialog;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f61714a.dismiss();
                            }
                        }
                    });
                    promptDialog.setPositiveBtn(ResUtils.getString(this, "wallet_qr_scancode_copy"), new View.OnClickListener(this, promptDialog) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.21
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f61716a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f61717b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, promptDialog};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61717b = this;
                            this.f61716a = promptDialog;
                        }

                        @Override // android.view.View.OnClickListener
                        @TargetApi(11)
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                ((ClipboardManager) this.f61717b.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(this.f61717b.s.trim());
                                GlobalUtils.toast(this.f61717b.getActivity(), ResUtils.getString(this.f61717b.getActivity(), "wallet_qr_scancode_copy_success"));
                                this.f61716a.dismiss();
                            }
                        }
                    });
                    return;
                case DIALOG_CHECK_SAFE /* 290 */:
                    PromptDialog promptDialog2 = (PromptDialog) dialog;
                    promptDialog2.setMessage(this.v + this.t);
                    promptDialog2.showCloseBtn(false);
                    promptDialog2.setNegativeBtn(ResUtils.getString(this, "wallet_qr_scancode_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.22
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f61718a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61718a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                DXMSdkSAUtils.onEvent("Scancoderemindn");
                                this.f61718a.finish();
                            }
                        }
                    });
                    promptDialog2.setPositiveBtn(ResUtils.getString(this, "wallet_qr_scancode_continue_open"), new View.OnClickListener(this, promptDialog2) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f61712a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f61713b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, promptDialog2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61713b = this;
                            this.f61712a = promptDialog2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                DXMSdkSAUtils.onEventWithValues("Scancoderemindy", Arrays.asList(this.f61713b.t));
                                QRScanCodeActivity qRScanCodeActivity = this.f61713b;
                                qRScanCodeActivity.startParserURl(qRScanCodeActivity.t, true);
                                this.f61712a.dismiss();
                            }
                        }
                    });
                    break;
                case DIALOG_PROCESS_IMG_FAILED /* 291 */:
                    PromptDialog promptDialog3 = (PromptDialog) dialog;
                    promptDialog3.setMessage(ResUtils.getString(getActivity(), "wallet_qr_scancode_error"));
                    promptDialog3.showCloseBtn(false);
                    promptDialog3.hideNegativeButton();
                    promptDialog3.setPositiveBtn(ResUtils.getString(this, "ebpay_confirm"), new View.OnClickListener(this, promptDialog3) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f61719a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f61720b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, promptDialog3};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61720b = this;
                            this.f61719a = promptDialog3;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f61719a.dismiss();
                            }
                        }
                    });
                    break;
                case DIALOG_ALIPAY_JD_WX_COPY /* 294 */:
                    String string = ResUtils.getString(getActivity(), "wallet_alipay_jd_wx_pay_tips");
                    PromptDialog promptDialog4 = (PromptDialog) dialog;
                    promptDialog4.setMessage(string + this.u);
                    promptDialog4.showCloseBtn(false);
                    promptDialog4.setNegativeBtn(ResUtils.getString(this, "wallet_qr_scancode_cancel"), new View.OnClickListener(this, promptDialog4) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f61721a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f61722b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, promptDialog4};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61722b = this;
                            this.f61721a = promptDialog4;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f61721a.dismiss();
                                this.f61722b.finish();
                            }
                        }
                    });
                    promptDialog4.setPositiveBtn(ResUtils.getString(this, "wallet_qr_scancode_copy"), new View.OnClickListener(this, promptDialog4) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f61723a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f61724b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, promptDialog4};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61724b = this;
                            this.f61723a = promptDialog4;
                        }

                        @Override // android.view.View.OnClickListener
                        @TargetApi(11)
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                ((ClipboardManager) this.f61724b.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(this.f61724b.u.trim());
                                GlobalUtils.toast(this.f61724b.getActivity(), ResUtils.getString(this.f61724b.getActivity(), "wallet_qr_alipay_wx_jd_copy_success"));
                                this.f61724b.restartScan();
                                this.f61723a.dismiss();
                            }
                        }
                    });
                    break;
                case DIALOG_COLLECTION_CODE_TIP /* 295 */:
                    PromptDialog promptDialog5 = (PromptDialog) dialog;
                    promptDialog5.setMessage(this.s);
                    promptDialog5.showCloseBtn(false);
                    promptDialog5.hideNegativeButton();
                    promptDialog5.setPositiveBtn(ResUtils.getString(this, "ebpay_confirm"), new View.OnClickListener(this, promptDialog5) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f61725a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f61726b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, promptDialog5};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61726b = this;
                            this.f61725a = promptDialog5;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f61725a.dismiss();
                                this.f61726b.finishWithoutAnim();
                            }
                        }
                    });
                    break;
            }
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onProcessImageOk(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, objArr) == null) {
            runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ QRScanCodeActivity f61706a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61706a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f61706a.f61685g.stop();
                    }
                }
            });
            if (objArr != null) {
                try {
                    if (objArr.length > 0 && (objArr[0] instanceof HashMap)) {
                        HashMap hashMap = (HashMap) objArr[0];
                        if (hashMap == null || !"zxing".equals(hashMap.get("decodedBy"))) {
                            return;
                        }
                        a((String) hashMap.get("zxing_decode_result"));
                        return;
                    }
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            BarcodeResult a2 = a(objArr);
            if (a2 == null) {
                return;
            }
            a(new String(a2.code, a2.encoding));
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048595, this, i2, strArr, iArr) == null) {
            if (i2 == f61679c) {
                if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                    for (int i3 = 0; i3 < strArr.length; i3++) {
                        if ("android.permission.READ_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i3]) && iArr != null && iArr.length > i3) {
                            if (iArr[i3] == 0) {
                                Intent intent = new Intent();
                                intent.addCategory("android.intent.category.OPENABLE");
                                if (Build.VERSION.SDK_INT < 19) {
                                    intent.setAction("android.intent.action.GET_CONTENT");
                                } else {
                                    intent.setAction("android.intent.action.OPEN_DOCUMENT");
                                }
                                intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, BdUploadHandler.IMAGE_MIME_TYPE);
                                startActivityForResult(Intent.createChooser(intent, "选择图片"), 17);
                            } else if (-1 == iArr[i3]) {
                                c();
                            }
                        }
                    }
                    return;
                }
                c();
                return;
            }
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // com.baidu.wallet.qrcodescanner.a.b
    public void onResultFail(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, str2) == null) {
            WalletGlobalUtils.safeDismissDialog(this, -2);
            restartScan();
        }
    }

    @Override // com.baidu.wallet.qrcodescanner.a.b
    public void onResultSuccessCallBack(String str, b.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048597, this, str, aVar, z) == null) {
            WalletGlobalUtils.safeDismissDialog(this, -2);
            if (aVar != null) {
                if ("500".equals(aVar.f61762a)) {
                    DXMSdkSAUtils.onEvent("scancodenative");
                    b(z);
                    try {
                        if (aVar.f61764c != null) {
                            ComfirmOrderActivity.ComfirmScanOrderInfo(getActivity(), (QRCodeShortUrlResponse.OrderParam) JsonUtils.fromJson(aVar.f61764c.toString(), QRCodeShortUrlResponse.OrderParam.class), aVar.f61763b, new ComfirmOrderActivity.a(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.11
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ QRScanCodeActivity f61690a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f61690a = this;
                                }

                                @Override // com.baidu.wallet.qrcodescanner.ComfirmOrderActivity.a
                                public void a() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.f61690a.finish();
                                    }
                                }

                                @Override // com.baidu.wallet.qrcodescanner.ComfirmOrderActivity.a
                                public void b() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                        this.f61690a.restartScan();
                                    }
                                }
                            });
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                } else if ("2".equals(aVar.f61762a)) {
                    DXMSdkSAUtils.onEvent("scancodeurl");
                    WalletLoginHelper.getInstance().startPage(aVar.f61763b);
                    b(z);
                    finishWithoutAnim();
                } else if (HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP.equals(aVar.f61762a)) {
                    b(z);
                    DXMSdkSAUtils.onEvent("scancodetext");
                    this.s = str;
                    WalletGlobalUtils.safeShowDialog(this, DIALOG_TXT_COPY, "");
                } else if ("600".equals(aVar.f61762a)) {
                    b(z);
                    this.u = str;
                    WalletGlobalUtils.safeShowDialog(this, DIALOG_ALIPAY_JD_WX_COPY, "");
                } else if ("1".equals(aVar.f61762a)) {
                    DXMSdkSAUtils.onEvent("scancodeurl");
                    if (!NetworkUtils.isNetworkAvailable(getActivity())) {
                        GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_no_network"));
                        restartScan();
                        return;
                    }
                    BaiduWalletDelegate.getInstance().openH5Module(getActivity(), aVar.f61763b, false);
                    b(z);
                    finishWithoutAnim();
                } else if ("3".equals(aVar.f61762a)) {
                    DXMSdkSAUtils.onEvent("scancodenative");
                    BaiduWalletServiceController.getInstance().gotoWalletService(getActivity(), aVar.f61763b, "");
                    b(z);
                    finishWithoutAnim();
                } else if (CloudControlRequest.DEFAULT_TIME.equals(aVar.f61762a)) {
                    b(z);
                    DXMSdkSAUtils.onEvent("scancoderemind");
                    this.t = str;
                    WalletGlobalUtils.safeShowDialog(this, DIALOG_CHECK_SAFE, "");
                } else if ("501".equals(aVar.f61762a)) {
                    b(z);
                    JSONObject jSONObject = aVar.f61765d;
                    if (jSONObject != null && jSONObject.has("errmsg")) {
                        try {
                            String string = aVar.f61765d.getString("errmsg");
                            if (!TextUtils.isEmpty(string)) {
                                this.s = string;
                                WalletGlobalUtils.safeShowDialog(this, DIALOG_COLLECTION_CODE_TIP, "");
                                return;
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    this.s = ResUtils.getString(this, "collection_code_off_line_remind_txt");
                    WalletGlobalUtils.safeShowDialog(this, DIALOG_COLLECTION_CODE_TIP, "");
                } else {
                    restartScan();
                }
            }
        }
    }

    public void playAmazingSound(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, context, i2) == null) {
            SoundPool soundPool = new SoundPool(1, 3, 5);
            this.q = soundPool;
            b bVar = new b(this.q, soundPool.load(context, i2, 1));
            this.p = bVar;
            this.q.setOnLoadCompleteListener(bVar);
        }
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImage(byte[] bArr, int i2, int i3, Rect rect, byte[] bArr2) {
        InterceptResult invokeCommon;
        Object[] a2;
        HashMap hashMap;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), rect, bArr2})) == null) {
            if (AnonymousClass15.f61698a[ScanCodeController.a().ordinal()] != 1) {
                if (this.A) {
                    this.A = false;
                    DXMSdkSAUtils.onEventStart("qrcodeIdlCost");
                    LogUtil.i("zxing", "idlTimes" + this.A);
                }
                long currentTimeMillis = System.currentTimeMillis();
                Yuv.rotateCropLuminance(bArr, i2, i3, rect, 270, bArr2);
                LogUtil.i("zxing", "idl pickready" + (System.currentTimeMillis() - currentTimeMillis));
                a2 = com.baidu.wallet.qrcodescanner.a.a.a().a(bArr2, rect.width(), rect.height(), 2);
                BarcodeResult a3 = a(a2);
                if (a3 != null) {
                    try {
                        str = new String(a3.code, a3.encoding);
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                        str = "";
                    }
                    LogUtil.i("zxing", "idl result cost " + (System.currentTimeMillis() - currentTimeMillis) + GlideException.IndentedAppendable.INDENT + this.A);
                    DXMSdkSAUtils.onEventEndWithValues("qrcodeIdlCost", (int) (System.currentTimeMillis() - currentTimeMillis), Arrays.asList("yuv", str));
                    this.A = true;
                }
            } else {
                if (this.B) {
                    this.B = false;
                    DXMSdkSAUtils.onEventStart("qrcodeZxingCost");
                    LogUtil.i("zxing", "zxingTimes" + this.B);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                a2 = a(bArr, i2, i3, new Rect(0, 0, i2, i3));
                if (a2 != null && a2.length > 0 && (a2[0] instanceof HashMap) && (hashMap = (HashMap) a2[0]) != null && "zxing".equals(hashMap.get("decodedBy"))) {
                    LogUtil.i("zxing", "zxing result cost " + (System.currentTimeMillis() - currentTimeMillis2) + GlideException.IndentedAppendable.INDENT + this.B);
                    DXMSdkSAUtils.onEventEndWithValues("qrcodeZxingCost", (int) (System.currentTimeMillis() - currentTimeMillis2), Arrays.asList("yuv", (String) hashMap.get("zxing_decode_result"), (String) hashMap.get("format")));
                    this.B = true;
                }
            }
            return a2;
        }
        return (Object[]) invokeCommon.objValue;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImageJpegData(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048600, this, bArr, i2, i3)) == null) {
            return null;
        }
        return (Object[]) invokeLII.objValue;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void relayoutUi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    public void relayoutUi(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, rect) == null) {
            MistLayorView mistLayorView = this.f61686h;
            if (mistLayorView != null) {
                mistLayorView.setFocusFrame(rect);
            }
            ProgressView progressView = this.f61687i;
            if (progressView != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) progressView.getLayoutParams();
                int i2 = rect.top;
                layoutParams.topMargin = i2 + (((rect.bottom - i2) - layoutParams.height) / 2);
                this.f61687i.requestLayout();
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void restartScan() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f61685g.start();
            super.restartScan();
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void setFocusRectValue(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, rect) == null) {
        }
    }

    public void showProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.f61687i.setVisibility(0);
            if (this.w == null) {
                this.w = new Handler(getMainLooper());
            }
            this.w.removeCallbacksAndMessages(null);
            this.w.postDelayed(this.f61680a, 2000L);
        }
    }

    public void startParserURl(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, str, z) == null) {
            com.baidu.wallet.qrcodescanner.a.a.a().a(this, str, this, z, true);
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void updateFlashLightUi(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || this.j == null) {
            return;
        }
        this.j.setImageResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
        AccessibilityUtils.setContentDescription(this.j, z ? "关闭闪光灯" : "打开闪光灯");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65549, this, z) == null) && z) {
            playAmazingSound(getActivity(), ResUtils.raw(this.f61685g.getContext(), "sweep"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            restartScan();
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_base_permission_open_album_error"));
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, this, z) == null) {
            findViewById(ResUtils.id(getActivity(), "qrcode_gen_out_btn")).setVisibility(z ? 0 : 4);
        }
    }

    private BarcodeResult a(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, objArr)) == null) {
            if (objArr == null) {
                return null;
            }
            BarcodeResult barcodeResult = (BarcodeResult) objArr[0];
            for (Object obj : objArr) {
                BarcodeResult barcodeResult2 = (BarcodeResult) obj;
                if (barcodeResult2 != null) {
                    LogUtil.d("zxing", "idl result ; code = " + barcodeResult2.code.toString() + " ; encoding = " + barcodeResult2.encoding + " ; codeType = " + barcodeResult2.codeType + " ; quality = " + barcodeResult2.quality + " ; rect = " + barcodeResult2.rect);
                }
                try {
                    String str = new String(barcodeResult2.code, barcodeResult2.encoding);
                    if (!TextUtils.isEmpty(str)) {
                        if (!str.contains("duxiaoman") && !str.contains("dxmpay")) {
                            if (str.contains("baifubao") || str.contains("baidu")) {
                                barcodeResult = barcodeResult2;
                            }
                        }
                        return barcodeResult2;
                    }
                    continue;
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
            return barcodeResult;
        }
        return (BarcodeResult) invokeL.objValue;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
            DXMSdkSAUtils.onEventWithValues("scanResult", Arrays.asList(str));
            runOnUiThread(new Runnable(this, str) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f61707a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ QRScanCodeActivity f61708b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61708b = this;
                    this.f61707a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        IScanCodeListener iScanCodeListener = QRScanCodeActivity.mLightAppListener;
                        if (iScanCodeListener != null) {
                            if (iScanCodeListener.shouldDispatchUrl(this.f61707a)) {
                                QRScanCodeActivity.mLightAppListener.dispatchUrl(this.f61708b.getActivity(), this.f61707a, new IScannerDispatchListener(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.18.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass18 f61709a;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f61709a = this;
                                    }

                                    @Override // com.baidu.wallet.api.IScannerDispatchListener
                                    public void onClose() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.f61709a.f61708b.b(true);
                                            this.f61709a.f61708b.finish();
                                        }
                                    }

                                    @Override // com.baidu.wallet.api.IScannerDispatchListener
                                    public void onRescan() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                            this.f61709a.f61708b.restartScan();
                                        }
                                    }
                                });
                                return;
                            }
                            QRScanCodeActivity.mLightAppListener = null;
                        }
                        if (!ScanCoderWrapper.getInstance().shouldDispatchUrl(this.f61707a)) {
                            WalletGlobalUtils.safeShowDialog(this.f61708b, -2, "");
                            this.f61708b.startParserURl(this.f61707a, false);
                            return;
                        }
                        ScanCoderWrapper.getInstance().dispatchUrl(this.f61708b, this.f61707a, new IScannerDispatchListener(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.18.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass18 f61710a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f61710a = this;
                            }

                            @Override // com.baidu.wallet.api.IScannerDispatchListener
                            public void onClose() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f61710a.f61708b.b(true);
                                    this.f61710a.f61708b.finish();
                                }
                            }

                            @Override // com.baidu.wallet.api.IScannerDispatchListener
                            public void onRescan() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                    this.f61710a.f61708b.restartScan();
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private Object[] a(byte[] bArr, int i2, int i3, Rect rect) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), rect})) == null) {
            Object[][] objArr = {null};
            HashMap hashMap = new HashMap();
            hashMap.put("yuv_data", bArr);
            hashMap.put("width", Integer.valueOf(i2));
            hashMap.put("height", Integer.valueOf(i3));
            hashMap.put("crop", rect);
            LocalRouter.getInstance(getActivity()).route(getActivity(), new RouterRequest().provider("barqrdecode").action("enterbarqrdecode").data("imageDatas", hashMap), new RouterCallback(this, objArr) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Object[][] f61694a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ QRScanCodeActivity f61695b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this, objArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61695b = this;
                    this.f61694a = objArr;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i4, HashMap hashMap2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, hashMap2) == null) {
                        if (i4 != 0) {
                            if (i4 == 2) {
                                LogUtil.d("zxing", "fail 不支持该能力");
                                return;
                            }
                            return;
                        }
                        if (hashMap2 != null && hashMap2.size() > 0) {
                            this.f61694a[0] = (Object[]) hashMap2.get("barqrdecodeResult");
                        }
                        LogUtil.d("zxing", "success Result = " + this.f61694a[2][0]);
                    }
                }
            });
            return objArr[0];
        }
        return (Object[]) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] a(int i2, int i3, int[] iArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65544, this, i2, i3, iArr)) == null) {
            Object[][] objArr = {null};
            HashMap hashMap = new HashMap();
            hashMap.put("fromAlbum", Boolean.TRUE);
            hashMap.put("width", Integer.valueOf(i2));
            hashMap.put("height", Integer.valueOf(i3));
            hashMap.put("pixels", iArr);
            LocalRouter.getInstance(getActivity()).route(getActivity(), new RouterRequest().provider("barqrdecode").action("enterbarqrdecode").data("imageDatas", hashMap), new RouterCallback(this, objArr) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Object[][] f61696a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ QRScanCodeActivity f61697b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this, objArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61697b = this;
                    this.f61696a = objArr;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i4, HashMap hashMap2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, hashMap2) == null) {
                        if (i4 != 0) {
                            if (i4 == 2) {
                                LogUtil.d("zxing", "fail 不支持该能力");
                                return;
                            }
                            return;
                        }
                        if (hashMap2 != null && hashMap2.size() > 0) {
                            this.f61696a[0] = (Object[]) hashMap2.get("barqrdecodeResult");
                        }
                        LogUtil.d("zxing", "success Result = " + this.f61696a[0]);
                    }
                }
            });
            return objArr[0];
        }
        return (Object[]) invokeIIL.objValue;
    }
}
