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
import com.baidu.android.util.io.PathUtils;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.apollon.imagemanager.ImageProcessor;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.DisplayUtils;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduPayServiceController;
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
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.qrcodescanner.ComfirmOrderActivity;
import com.baidu.wallet.qrcodescanner.a;
import com.baidu.wallet.qrcodescanner.a.b;
import com.baidu.wallet.qrcodescanner.datamodel.QRCodeShortUrlResponse;
import com.baidu.wallet.qrcodescanner.widget.MistLayorView;
import com.baidu.wallet.qrcodescanner.widget.ProgressView;
import com.baidu.wallet.qrcodescanner.widget.ScanLineView;
import com.baidu.wallet.utils.AccessibilityUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class QRScanCodeActivity extends CameraBaseActivity implements View.OnClickListener, IImageProcess, OnCameraChangeListener, com.baidu.wallet.qrcodescanner.a.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIALOG_ALIPAY_JD_WX_COPY = 294;
    public static final int DIALOG_CHECK_SAFE = 290;
    public static final int DIALOG_COLLECTION_CODE_TIP = 295;
    public static final int DIALOG_PROCESS_IMG_FAILED = 291;
    public static final int DIALOG_TXT_COPY = 289;

    /* renamed from: g  reason: collision with root package name */
    public static int f27083g = 10010;
    public static IScanCodeListener mLightAppListener;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler A;
    public View B;
    public TextView C;
    public View.OnTouchListener D;
    public boolean E;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f27084e;

    /* renamed from: f  reason: collision with root package name */
    public final int f27085f;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f27086h;

    /* renamed from: i  reason: collision with root package name */
    public ImageProcessor f27087i;
    public RelativeLayout j;
    public ScanLineView k;
    public MistLayorView l;
    public ProgressView m;
    public ImageView n;
    public ImageView o;
    public CameraCtrl p;
    public ImageView q;
    public NetImageView r;
    public RelativeLayout s;
    public SoundPool.OnLoadCompleteListener t;
    public SoundPool u;
    public com.baidu.wallet.qrcodescanner.a v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* renamed from: com.baidu.wallet.qrcodescanner.QRScanCodeActivity$13  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass13 implements com.baidu.wallet.qrcodescanner.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ QRScanCodeActivity f27094a;

        /* renamed from: com.baidu.wallet.qrcodescanner.QRScanCodeActivity$13$1  reason: invalid class name */
        /* loaded from: classes6.dex */
        public class AnonymousClass1 implements Html.ImageGetter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AnonymousClass13 f27095a;

            public AnonymousClass1(AnonymousClass13 anonymousClass13) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {anonymousClass13};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27095a = anonymousClass13;
            }

            @Override // android.text.Html.ImageGetter
            public Drawable getDrawable(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                    LevelListDrawable levelListDrawable = new LevelListDrawable();
                    ImageLoader.getInstance(this.f27095a.f27094a.getApplicationContext()).getBitmap(str, new ImageLoader.OnGetBitmapListener(this, DisplayUtils.dip2px(this.f27095a.f27094a.getActivity(), 22.0f), DisplayUtils.dip2px(this.f27095a.f27094a.getActivity(), 14.0f), levelListDrawable) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.13.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f27096a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ int f27097b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ LevelListDrawable f27098c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f27099d;

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
                            this.f27099d = this;
                            this.f27096a = r7;
                            this.f27097b = r8;
                            this.f27098c = levelListDrawable;
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
                            this.f27098c.addLevel(1, 1, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap, this.f27096a, this.f27097b, true)));
                            this.f27098c.setBounds(0, 0, this.f27096a, this.f27097b);
                            this.f27098c.setLevel(1);
                            this.f27099d.f27095a.f27094a.runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.13.1.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ C02931 f27100a;

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
                                    this.f27100a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f27100a.f27099d.f27095a.f27094a.C.refreshDrawableState();
                                        this.f27100a.f27099d.f27095a.f27094a.C.setText(this.f27100a.f27099d.f27095a.f27094a.C.getText());
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

        public AnonymousClass13(QRScanCodeActivity qRScanCodeActivity) {
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
            this.f27094a = qRScanCodeActivity;
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
                    this.f27094a.C.setVisibility(4);
                    return;
                }
                try {
                    this.f27094a.C.setText(Html.fromHtml(str, new AnonymousClass1(this), null));
                    this.f27094a.C.setVisibility(0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ QRScanCodeActivity f27125a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f27126b;

        /* renamed from: c  reason: collision with root package name */
        public int f27127c;

        /* renamed from: d  reason: collision with root package name */
        public int f27128d;

        /* renamed from: e  reason: collision with root package name */
        public int f27129e;

        public a(QRScanCodeActivity qRScanCodeActivity, byte[] bArr, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRScanCodeActivity, bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27125a = qRScanCodeActivity;
            this.f27126b = bArr;
            this.f27127c = i2;
            this.f27128d = i3;
            this.f27129e = i4;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BarcodeResult[] a2 = com.baidu.wallet.qrcodescanner.a.a.a().a(this.f27126b, this.f27127c, this.f27128d, this.f27129e);
                if (a2 != null) {
                    this.f27125a.onProcessImageOk(a2);
                } else {
                    this.f27125a.runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a f27130a;

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
                            this.f27130a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                WalletGlobalUtils.safeShowDialog(this.f27130a.f27125a, QRScanCodeActivity.DIALOG_PROCESS_IMG_FAILED, "");
                                this.f27130a.f27125a.restartScan();
                                this.f27130a.f27125a.k.start();
                            }
                        }
                    });
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements SoundPool.OnLoadCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SoundPool f27131a;

        /* renamed from: b  reason: collision with root package name */
        public int f27132b;

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
            this.f27131a = soundPool;
            this.f27132b = i2;
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, soundPool, i2, i3) == null) {
                soundPool.play(this.f27132b, 2.0f, 2.0f, 0, 0, 1.0f);
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
        this.f27085f = 17;
        this.E = false;
        this.f27084e = new Runnable(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ QRScanCodeActivity f27123a;

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
                this.f27123a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f27123a.m.setVisibility(8);
                }
            }
        };
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
        }
    }

    public static void encodeYUV420SP(byte[] bArr, int[] iArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65550, null, bArr, iArr, i2, i3) == null) {
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
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(65553, null, context, uri, str, strArr)) != null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, context, uri)) == null) {
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
                            uri2 = "audio".equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, uri)) == null) ? ImageClipActivity.l.equals(uri.getAuthority()) : invokeL.booleanValue;
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, uri)) == null) ? ImageClipActivity.m.equals(uri.getAuthority()) : invokeL.booleanValue;
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, uri)) == null) ? "com.google.android.apps.photos.content".equals(uri.getAuthority()) : invokeL.booleanValue;
    }

    public static boolean isMediaDocument(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, uri)) == null) ? ImageClipActivity.k.equals(uri.getAuthority()) : invokeL.booleanValue;
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
                    if (this.f27086h != null) {
                        this.f27086h.recycle();
                    }
                    if (getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
                        ParcelFileDescriptor openFileDescriptor = getContentResolver().openFileDescriptor(uri2, r.f7745a);
                        if (openFileDescriptor != null) {
                            this.f27086h = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
                        }
                        openFileDescriptor.close();
                    } else if (Build.VERSION.SDK_INT >= 19) {
                        this.f27086h = this.f27087i.decode(new File(getPath(getActivity(), uri2)), 0);
                    } else {
                        Cursor query = getActivity().getContentResolver().query(uri2, new String[]{"_data"}, null, null, null);
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                        query.moveToFirst();
                        String string = query.getString(columnIndexOrThrow);
                        query.close();
                        this.f27086h = this.f27087i.decode(new File(string), 0);
                    }
                    int width = this.f27086h.getWidth();
                    int height = this.f27086h.getHeight();
                    int i4 = width * height;
                    int[] iArr = new int[i4];
                    byte[] bArr = new byte[i4];
                    this.f27086h.getPixels(iArr, 0, width, 0, 0, width, height);
                    encodeYUV420SP(bArr, iArr, width, height);
                    new a(this, bArr, width, height, 2).start();
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
            this.n.setVisibility(CameraCtrl.isSupprtFlashLight(getPackageManager()) ? 0 : 8);
            this.E = this.p.isSupportZoom();
            this.k.start();
            if (this.p.isSupportZoom()) {
                this.m.setMaxPregress(this.p.getMaxZoom());
                this.m.setProgress(this.p.getCurrentZoom());
                this.v.a(new a.InterfaceC0295a(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ QRScanCodeActivity f27124a;

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
                        this.f27124a = this;
                    }

                    @Override // com.baidu.wallet.qrcodescanner.a.InterfaceC0295a
                    public void a(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                            int currentZoom = this.f27124a.p.getCurrentZoom();
                            int maxZoom = this.f27124a.p.getMaxZoom();
                            int i2 = z ? currentZoom + 2 : currentZoom - 2;
                            if (i2 < 0) {
                                maxZoom = 0;
                            } else if (i2 <= maxZoom) {
                                maxZoom = i2;
                            }
                            this.f27124a.p.setZoom(maxZoom);
                            this.f27124a.m.setProgress(maxZoom);
                            this.f27124a.m.invalidate();
                        }
                    }

                    @Override // com.baidu.wallet.qrcodescanner.a.InterfaceC0295a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f27124a.E) {
                            this.f27124a.showProgress();
                        }
                    }
                });
                this.j.setOnTouchListener(this.v);
                this.m.setProgressStatusChangeListener(new ProgressView.b(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ QRScanCodeActivity f27089a;

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
                        this.f27089a = this;
                    }

                    @Override // com.baidu.wallet.qrcodescanner.widget.ProgressView.b
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f27089a.E) {
                            this.f27089a.showProgress();
                        }
                    }

                    @Override // com.baidu.wallet.qrcodescanner.widget.ProgressView.b
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                            this.f27089a.p.setZoom(i2);
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
            if (view == this.n) {
                DXMSdkSAUtils.onEvent("scanCodeUseFlash");
                PayStatisticsUtil.onEvent("scanCodeUseFlash");
                triggerFlash();
            } else if (view == this.o) {
                DXMSdkSAUtils.onEvent("scanCodeFromAlbum");
                PayStatisticsUtil.onEvent("scanCodeFromAlbum");
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
                        public final /* synthetic */ QRScanCodeActivity f27122a;

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
                            this.f27122a = this;
                        }

                        @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                        public void isAllAgree(Boolean bool) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                                if (bool.booleanValue()) {
                                    if (PermissionManager.checkCallingOrSelfPermission(this.f27122a.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, QRScanCodeActivity.f27083g)) {
                                        return;
                                    }
                                    this.f27122a.c();
                                } else if (Build.VERSION.SDK_INT >= 23) {
                                    this.f27122a.onRequestPermissionsResult(1, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new int[]{-1});
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
            } else if (view == this.B) {
                DXMSdkSAUtils.onEvent("scanCodeBack");
                PayStatisticsUtil.onEvent("scanCodeBack");
                onBackPressed();
                finish();
            } else if (view == this.q) {
                DXMSdkSAUtils.onEvent("scanCodeCloseBanner");
                PayStatisticsUtil.onEvent("scanCodeCloseBanner");
                this.s.setVisibility(8);
            } else if (ResUtils.id(getActivity(), "qrcode_gen_out_btn") == id) {
                EventBus.getInstance().register(this, com.baidu.wallet.api.Constants.EVT_CLOSE, 0, EventBus.ThreadMode.MainThread);
                BaiduPayServiceController.getInstance().doScanCode(getActivity(), false, "QRScanCodeActivity", "");
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            this.k = (ScanLineView) findViewById(ResUtils.id(getActivity(), "camera_scanline"));
            this.C = (TextView) findViewById(ResUtils.id(getActivity(), "ad_union_text"));
            if (DisplayUtils.getDisplayHeight(this) < DisplayUtils.dip2px(this, 535.0f)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
                int dip2px = DisplayUtils.dip2px(this, 200.0f);
                layoutParams.width = dip2px;
                layoutParams.height = dip2px;
                ((RelativeLayout.LayoutParams) this.C.getLayoutParams()).width = layoutParams.width;
            }
            this.l = (MistLayorView) findViewById(ResUtils.id(getActivity(), "camera_mist"));
            this.m = (ProgressView) findViewById(ResUtils.id(getActivity(), "camera_progress_zoom"));
            this.n = (ImageView) findViewById(ResUtils.id(getActivity(), "flash_light_switch"));
            this.o = (ImageView) findViewById(ResUtils.id(getActivity(), "open_album"));
            this.j = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "camera_ui"));
            this.s = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "camera_ad_layout"));
            this.r = (NetImageView) findViewById(ResUtils.id(getActivity(), "camera_ad"));
            this.q = (ImageView) findViewById(ResUtils.id(getActivity(), "camera_ad_del"));
            this.z = ResUtils.getString(getActivity(), "wallet_qrscancode_safe_tips");
            this.q.setOnClickListener(this);
            View findViewById = findViewById(ResUtils.id(getActivity(), "camera_title_back"));
            this.B = findViewById;
            findViewById.setOnClickListener(this);
            AccessibilityUtils.setContentDescription(this.B, "返回");
            this.v = new com.baidu.wallet.qrcodescanner.a();
            this.p = CameraCtrl.getInstance();
            this.A = new Handler(getMainLooper());
            b();
            setOnCameraChangeListener(this);
            this.n.setOnClickListener(this);
            AccessibilityUtils.setContentDescription(this.n, "打开闪光灯");
            this.o.setOnClickListener(this);
            this.f27087i = new ImageProcessor(getApplicationContext());
            View.OnTouchListener onTouchListener = new View.OnTouchListener(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ QRScanCodeActivity f27088a;

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
                    this.f27088a = this;
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
            this.D = onTouchListener;
            this.o.setOnTouchListener(onTouchListener);
            com.baidu.wallet.qrcodescanner.a.a.a().a(getActivity(), new com.baidu.wallet.qrcodescanner.a.b(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ QRScanCodeActivity f27091a;

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
                    this.f27091a = this;
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
                        this.f27091a.r.setImageUrl(str);
                        this.f27091a.s.setVisibility(0);
                        if (aVar != null) {
                            this.f27091a.r.setOnClickListener(new View.OnClickListener(this, aVar) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.12.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ b.a f27092a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass12 f27093b;

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
                                    this.f27093b = this;
                                    this.f27092a = aVar;
                                }

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) {
                                        DXMSdkSAUtils.onEvent("scanCodeOpenBanner");
                                        PayStatisticsUtil.onEvent("scanCodeOpenBanner");
                                        if ("2".equals(this.f27092a.f27155a)) {
                                            WalletLoginHelper.getInstance().startPage(this.f27092a.f27156b);
                                        } else if ("1".equals(this.f27092a.f27155a)) {
                                            if (!NetworkUtils.isNetworkAvailable(this.f27093b.f27091a.getActivity())) {
                                                GlobalUtils.toast(this.f27093b.f27091a.getActivity(), ResUtils.getString(this.f27093b.f27091a.getActivity(), "ebpay_no_network"));
                                            } else {
                                                BaiduWalletDelegate.getInstance().openH5Module(this.f27093b.f27091a.getActivity(), this.f27092a.f27156b, false);
                                            }
                                        } else if ("3".equals(this.f27092a.f27155a)) {
                                            BaiduWalletServiceController.getInstance().gotoWalletService(this.f27093b.f27091a.getActivity(), this.f27092a.f27156b, "");
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
            }, new AnonymousClass13(this));
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
                findViewById2.setOnTouchListener(this.D);
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
            this.k.stop();
            SoundPool soundPool = this.u;
            if (soundPool != null) {
                soundPool.release();
                this.u.setOnLoadCompleteListener(null);
            }
            Handler handler = this.A;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.A = null;
            }
            this.t = null;
            com.baidu.wallet.qrcodescanner.a.a.a().b();
            super.onDestroy();
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, event) == null) && event != null && com.baidu.wallet.api.Constants.EVT_CLOSE.equals(event.mEventKey)) {
            EventBus.getInstance().unregister(this, com.baidu.wallet.api.Constants.EVT_CLOSE);
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
                    promptDialog.setMessage(this.w);
                    promptDialog.showCloseBtn(true);
                    promptDialog.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.16
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f27106a;

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
                            this.f27106a = this;
                        }

                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                this.f27106a.restartScan();
                            }
                        }
                    });
                    promptDialog.setNegativeBtn(ResUtils.getString(this, "wallet_scancode_cancel"), new View.OnClickListener(this, promptDialog) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.17
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f27107a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f27108b;

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
                            this.f27108b = this;
                            this.f27107a = promptDialog;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f27107a.dismiss();
                            }
                        }
                    });
                    promptDialog.setPositiveBtn(ResUtils.getString(this, "wallet_scancode_copy"), new View.OnClickListener(this, promptDialog) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.18
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f27109a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f27110b;

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
                            this.f27110b = this;
                            this.f27109a = promptDialog;
                        }

                        @Override // android.view.View.OnClickListener
                        @TargetApi(11)
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                ((ClipboardManager) this.f27110b.getSystemService("clipboard")).setText(this.f27110b.w.trim());
                                GlobalUtils.toast(this.f27110b.getActivity(), ResUtils.getString(this.f27110b.getActivity(), "wallet_scancode_copy_success"));
                                this.f27109a.dismiss();
                            }
                        }
                    });
                    return;
                case DIALOG_CHECK_SAFE /* 290 */:
                    PromptDialog promptDialog2 = (PromptDialog) dialog;
                    promptDialog2.setMessage(this.z + this.x);
                    promptDialog2.showCloseBtn(false);
                    promptDialog2.setNegativeBtn(ResUtils.getString(this, "wallet_scancode_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.19
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f27111a;

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
                            this.f27111a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                DXMSdkSAUtils.onEvent("Scancoderemindn");
                                PayStatisticsUtil.onEvent("Scancoderemindn");
                                this.f27111a.finish();
                            }
                        }
                    });
                    promptDialog2.setPositiveBtn(ResUtils.getString(this, "wallet_scancode_continue_open"), new View.OnClickListener(this, promptDialog2) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f27112a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f27113b;

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
                            this.f27113b = this;
                            this.f27112a = promptDialog2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                DXMSdkSAUtils.onEventWithValues("Scancoderemindy", Arrays.asList(this.f27113b.x));
                                PayStatisticsUtil.onEventWithValue("Scancoderemindy", this.f27113b.x);
                                QRScanCodeActivity qRScanCodeActivity = this.f27113b;
                                qRScanCodeActivity.startParserURl(qRScanCodeActivity.x, true);
                                this.f27112a.dismiss();
                            }
                        }
                    });
                    break;
                case DIALOG_PROCESS_IMG_FAILED /* 291 */:
                    PromptDialog promptDialog3 = (PromptDialog) dialog;
                    promptDialog3.setMessage(ResUtils.getString(getActivity(), "wallet_scancode_error"));
                    promptDialog3.showCloseBtn(false);
                    promptDialog3.hideNegativeButton();
                    promptDialog3.setPositiveBtn(ResUtils.getString(this, "ebpay_confirm"), new View.OnClickListener(this, promptDialog3) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f27114a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f27115b;

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
                            this.f27115b = this;
                            this.f27114a = promptDialog3;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f27114a.dismiss();
                            }
                        }
                    });
                    break;
                case DIALOG_ALIPAY_JD_WX_COPY /* 294 */:
                    String string = ResUtils.getString(getActivity(), "wallet_alipay_jd_wx_pay_tips");
                    PromptDialog promptDialog4 = (PromptDialog) dialog;
                    promptDialog4.setMessage(string + this.y);
                    promptDialog4.showCloseBtn(false);
                    promptDialog4.setNegativeBtn(ResUtils.getString(this, "wallet_scancode_cancel"), new View.OnClickListener(this, promptDialog4) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f27116a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f27117b;

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
                            this.f27117b = this;
                            this.f27116a = promptDialog4;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f27116a.dismiss();
                                this.f27117b.finish();
                            }
                        }
                    });
                    promptDialog4.setPositiveBtn(ResUtils.getString(this, "wallet_scancode_copy"), new View.OnClickListener(this, promptDialog4) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f27118a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f27119b;

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
                            this.f27119b = this;
                            this.f27118a = promptDialog4;
                        }

                        @Override // android.view.View.OnClickListener
                        @TargetApi(11)
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                ((ClipboardManager) this.f27119b.getSystemService("clipboard")).setText(this.f27119b.y.trim());
                                GlobalUtils.toast(this.f27119b.getActivity(), ResUtils.getString(this.f27119b.getActivity(), "wallet_alipay_wx_jd_copy_success"));
                                this.f27119b.restartScan();
                                this.f27118a.dismiss();
                            }
                        }
                    });
                    break;
                case DIALOG_COLLECTION_CODE_TIP /* 295 */:
                    PromptDialog promptDialog5 = (PromptDialog) dialog;
                    promptDialog5.setMessage(this.w);
                    promptDialog5.showCloseBtn(false);
                    promptDialog5.hideNegativeButton();
                    promptDialog5.setPositiveBtn(ResUtils.getString(this, "ebpay_confirm"), new View.OnClickListener(this, promptDialog5) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f27120a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QRScanCodeActivity f27121b;

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
                            this.f27121b = this;
                            this.f27120a = promptDialog5;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f27120a.dismiss();
                                this.f27121b.finishWithoutAnim();
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
            runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ QRScanCodeActivity f27101a;

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
                    this.f27101a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f27101a.k.stop();
                    }
                }
            });
            BarcodeResult a2 = a(objArr);
            if (a2 == null) {
                return;
            }
            try {
                String str = new String(a2.code, a2.encoding);
                DXMSdkSAUtils.onEventWithValues("scanResult", Arrays.asList(str));
                PayStatisticsUtil.onEventWithValue("scanResult", str);
                runOnUiThread(new Runnable(this, str) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f27102a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ QRScanCodeActivity f27103b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr2 = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f27103b = this;
                        this.f27102a = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            IScanCodeListener iScanCodeListener = QRScanCodeActivity.mLightAppListener;
                            if (iScanCodeListener != null) {
                                if (iScanCodeListener.shouldDispatchUrl(this.f27102a)) {
                                    QRScanCodeActivity.mLightAppListener.dispatchUrl(this.f27103b.getActivity(), this.f27102a, new IScannerDispatchListener(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.15.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass15 f27104a;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr2 = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f27104a = this;
                                        }

                                        @Override // com.baidu.wallet.api.IScannerDispatchListener
                                        public void onClose() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.f27104a.f27103b.b(true);
                                                this.f27104a.f27103b.finish();
                                            }
                                        }

                                        @Override // com.baidu.wallet.api.IScannerDispatchListener
                                        public void onRescan() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                                this.f27104a.f27103b.restartScan();
                                            }
                                        }
                                    });
                                    return;
                                }
                                QRScanCodeActivity.mLightAppListener = null;
                            }
                            if (!ScanCoderWrapper.getInstance().shouldDispatchUrl(this.f27102a)) {
                                WalletGlobalUtils.safeShowDialog(this.f27103b, -2, "");
                                this.f27103b.startParserURl(this.f27102a, false);
                                return;
                            }
                            ScanCoderWrapper.getInstance().dispatchUrl(this.f27103b, this.f27102a, new IScannerDispatchListener(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.15.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass15 f27105a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr2 = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f27105a = this;
                                }

                                @Override // com.baidu.wallet.api.IScannerDispatchListener
                                public void onClose() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f27105a.f27103b.b(true);
                                        this.f27105a.f27103b.finish();
                                    }
                                }

                                @Override // com.baidu.wallet.api.IScannerDispatchListener
                                public void onRescan() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                        this.f27105a.f27103b.restartScan();
                                    }
                                }
                            });
                        }
                    }
                });
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048595, this, i2, strArr, iArr) == null) {
            if (i2 == f27083g) {
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
                if ("500".equals(aVar.f27155a)) {
                    DXMSdkSAUtils.onEvent("scancodenative");
                    PayStatisticsUtil.onEvent("scancodenative");
                    b(z);
                    try {
                        if (aVar.f27157c != null) {
                            ComfirmOrderActivity.ComfirmScanOrderInfo(getActivity(), (QRCodeShortUrlResponse.OrderParam) JsonUtils.fromJson(aVar.f27157c.toString(), QRCodeShortUrlResponse.OrderParam.class), aVar.f27156b, new ComfirmOrderActivity.a(this) { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.11
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ QRScanCodeActivity f27090a;

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
                                    this.f27090a = this;
                                }

                                @Override // com.baidu.wallet.qrcodescanner.ComfirmOrderActivity.a
                                public void a() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.f27090a.finish();
                                    }
                                }

                                @Override // com.baidu.wallet.qrcodescanner.ComfirmOrderActivity.a
                                public void b() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                        this.f27090a.restartScan();
                                    }
                                }
                            });
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                } else if ("2".equals(aVar.f27155a)) {
                    DXMSdkSAUtils.onEvent("scancodeurl");
                    PayStatisticsUtil.onEvent("scancodeurl");
                    WalletLoginHelper.getInstance().startPage(aVar.f27156b);
                    b(z);
                    finishWithoutAnim();
                } else if ("100".equals(aVar.f27155a)) {
                    b(z);
                    DXMSdkSAUtils.onEvent("scancodetext");
                    PayStatisticsUtil.onEvent("scancodetext");
                    this.w = str;
                    WalletGlobalUtils.safeShowDialog(this, DIALOG_TXT_COPY, "");
                } else if ("600".equals(aVar.f27155a)) {
                    b(z);
                    this.y = str;
                    WalletGlobalUtils.safeShowDialog(this, DIALOG_ALIPAY_JD_WX_COPY, "");
                } else if ("1".equals(aVar.f27155a)) {
                    DXMSdkSAUtils.onEvent("scancodeurl");
                    PayStatisticsUtil.onEvent("scancodeurl");
                    if (!NetworkUtils.isNetworkAvailable(getActivity())) {
                        GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_no_network"));
                        restartScan();
                        return;
                    }
                    BaiduWalletDelegate.getInstance().openH5Module(getActivity(), aVar.f27156b, false);
                    b(z);
                    finishWithoutAnim();
                } else if ("3".equals(aVar.f27155a)) {
                    DXMSdkSAUtils.onEvent("scancodenative");
                    PayStatisticsUtil.onEvent("scancodenative");
                    BaiduWalletServiceController.getInstance().gotoWalletService(getActivity(), aVar.f27156b, "");
                    b(z);
                    finishWithoutAnim();
                } else if ("300".equals(aVar.f27155a)) {
                    b(z);
                    DXMSdkSAUtils.onEvent("scancoderemind");
                    PayStatisticsUtil.onEvent("scancoderemind");
                    this.x = str;
                    WalletGlobalUtils.safeShowDialog(this, DIALOG_CHECK_SAFE, "");
                } else if ("501".equals(aVar.f27155a)) {
                    b(z);
                    JSONObject jSONObject = aVar.f27158d;
                    if (jSONObject != null && jSONObject.has("errmsg")) {
                        try {
                            String string = aVar.f27158d.getString("errmsg");
                            if (!TextUtils.isEmpty(string)) {
                                this.w = string;
                                WalletGlobalUtils.safeShowDialog(this, DIALOG_COLLECTION_CODE_TIP, "");
                                return;
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    this.w = ResUtils.getString(this, "collection_code_off_line_remind_txt");
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
            this.u = soundPool;
            b bVar = new b(this.u, soundPool.load(context, i2, 1));
            this.t = bVar;
            this.u.setOnLoadCompleteListener(bVar);
        }
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImage(byte[] bArr, int i2, int i3, Rect rect, byte[] bArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), rect, bArr2})) == null) {
            Yuv.rotateCropLuminance(bArr, i2, i3, rect, 270, bArr2);
            return com.baidu.wallet.qrcodescanner.a.a.a().a(bArr2, rect.width(), rect.height(), 2);
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
            MistLayorView mistLayorView = this.l;
            if (mistLayorView != null) {
                mistLayorView.setFocusFrame(rect);
            }
            ProgressView progressView = this.m;
            if (progressView != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) progressView.getLayoutParams();
                int i2 = rect.top;
                layoutParams.topMargin = i2 + (((rect.bottom - i2) - layoutParams.height) / 2);
                this.m.requestLayout();
            }
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void restartScan() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.k.start();
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
            this.m.setVisibility(0);
            if (this.A == null) {
                this.A = new Handler(getMainLooper());
            }
            this.A.removeCallbacksAndMessages(null);
            this.A.postDelayed(this.f27084e, 2000L);
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
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || this.n == null) {
            return;
        }
        this.n.setImageResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
        AccessibilityUtils.setContentDescription(this.n, z ? "关闭闪光灯" : "打开闪光灯");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65545, this, z) == null) && z) {
            playAmazingSound(getActivity(), ResUtils.raw(this.k.getContext(), "sweep"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            restartScan();
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_scancode_album_error"));
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, this, z) == null) {
            findViewById(ResUtils.id(getActivity(), "qrcode_gen_out_btn")).setVisibility(z ? 0 : 4);
        }
    }

    private BarcodeResult a(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, objArr)) == null) {
            if (objArr == null) {
                return null;
            }
            BarcodeResult barcodeResult = (BarcodeResult) objArr[0];
            for (Object obj : objArr) {
                BarcodeResult barcodeResult2 = (BarcodeResult) obj;
                try {
                    String str = new String(barcodeResult2.code, barcodeResult2.encoding);
                    if (!TextUtils.isEmpty(str)) {
                        if (!str.contains("duxiaoman") && !str.contains("dxmpay")) {
                            if (str.contains("baifubao") || str.contains(PathUtils.DIRCTORY_BAIDU)) {
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
}
