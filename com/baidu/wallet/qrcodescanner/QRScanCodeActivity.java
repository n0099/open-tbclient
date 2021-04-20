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
import androidx.recyclerview.widget.ItemTouchHelper;
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
import com.baidu.sapi2.activity.ImageClipActivity;
import com.baidu.wallet.BaiduPayServiceController;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.Constants;
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
/* loaded from: classes5.dex */
public class QRScanCodeActivity extends CameraBaseActivity implements View.OnClickListener, IImageProcess, OnCameraChangeListener, com.baidu.wallet.qrcodescanner.a.b {
    public static final int DIALOG_ALIPAY_JD_WX_COPY = 294;
    public static final int DIALOG_CHECK_SAFE = 290;
    public static final int DIALOG_COLLECTION_CODE_TIP = 295;
    public static final int DIALOG_PROCESS_IMG_FAILED = 291;
    public static final int DIALOG_TXT_COPY = 289;

    /* renamed from: g  reason: collision with root package name */
    public static int f26367g = 10010;
    public static IScanCodeListener mLightAppListener;
    public Handler A;
    public View B;
    public TextView C;
    public View.OnTouchListener D;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f26370h;
    public ImageProcessor i;
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

    /* renamed from: f  reason: collision with root package name */
    public final int f26369f = 17;
    public boolean E = false;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f26368e = new Runnable() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.8
        @Override // java.lang.Runnable
        public void run() {
            QRScanCodeActivity.this.m.setVisibility(8);
        }
    };

    /* renamed from: com.baidu.wallet.qrcodescanner.QRScanCodeActivity$13  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass13 implements com.baidu.wallet.qrcodescanner.a.b {

        /* renamed from: com.baidu.wallet.qrcodescanner.QRScanCodeActivity$13$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        public class AnonymousClass1 implements Html.ImageGetter {
            public AnonymousClass1() {
            }

            @Override // android.text.Html.ImageGetter
            public Drawable getDrawable(String str) {
                final LevelListDrawable levelListDrawable = new LevelListDrawable();
                final int dip2px = DisplayUtils.dip2px(QRScanCodeActivity.this.getActivity(), 22.0f);
                final int dip2px2 = DisplayUtils.dip2px(QRScanCodeActivity.this.getActivity(), 14.0f);
                ImageLoader.getInstance(QRScanCodeActivity.this.getApplicationContext()).getBitmap(str, new ImageLoader.OnGetBitmapListener() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.13.1.1
                    @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                    public boolean needCancel(String str2, Object obj) {
                        return false;
                    }

                    @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                    public void onError(String str2, Object obj) {
                    }

                    @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                    public void onGetBitmap(String str2, Object obj, Bitmap bitmap) {
                        if (bitmap != null) {
                            levelListDrawable.addLevel(1, 1, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap, dip2px, dip2px2, true)));
                            levelListDrawable.setBounds(0, 0, dip2px, dip2px2);
                            levelListDrawable.setLevel(1);
                            QRScanCodeActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.13.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    QRScanCodeActivity.this.C.refreshDrawableState();
                                    QRScanCodeActivity.this.C.setText(QRScanCodeActivity.this.C.getText());
                                }
                            });
                        }
                    }
                }, null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
                return levelListDrawable;
            }
        }

        public AnonymousClass13() {
        }

        @Override // com.baidu.wallet.qrcodescanner.a.b
        public void onResultFail(String str, String str2) {
        }

        @Override // com.baidu.wallet.qrcodescanner.a.b
        public void onResultSuccessCallBack(String str, b.a aVar, boolean z) {
            if (TextUtils.isEmpty(str)) {
                QRScanCodeActivity.this.C.setVisibility(4);
                return;
            }
            try {
                QRScanCodeActivity.this.C.setText(Html.fromHtml(str, new AnonymousClass1(), null));
                QRScanCodeActivity.this.C.setVisibility(0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        public byte[] f26409b;

        /* renamed from: c  reason: collision with root package name */
        public int f26410c;

        /* renamed from: d  reason: collision with root package name */
        public int f26411d;

        /* renamed from: e  reason: collision with root package name */
        public int f26412e;

        public a(byte[] bArr, int i, int i2, int i3) {
            this.f26409b = bArr;
            this.f26410c = i;
            this.f26411d = i2;
            this.f26412e = i3;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BarcodeResult[] a2 = com.baidu.wallet.qrcodescanner.a.a.a().a(this.f26409b, this.f26410c, this.f26411d, this.f26412e);
            if (a2 != null) {
                QRScanCodeActivity.this.onProcessImageOk(a2);
            } else {
                QRScanCodeActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WalletGlobalUtils.safeShowDialog(QRScanCodeActivity.this, QRScanCodeActivity.DIALOG_PROCESS_IMG_FAILED, "");
                        QRScanCodeActivity.this.restartScan();
                        QRScanCodeActivity.this.k.start();
                    }
                });
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements SoundPool.OnLoadCompleteListener {

        /* renamed from: a  reason: collision with root package name */
        public SoundPool f26414a;

        /* renamed from: b  reason: collision with root package name */
        public int f26415b;

        public b(SoundPool soundPool, int i) {
            this.f26414a = soundPool;
            this.f26415b = i;
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i, int i2) {
            soundPool.play(this.f26415b, 2.0f, 2.0f, 0, 0, 1.0f);
        }
    }

    private void b() {
    }

    public static void encodeYUV420SP(byte[] bArr, int[] iArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i * i3;
            int i5 = 0;
            while (i5 < i) {
                int i6 = 255;
                int i7 = (((((((iArr[i4] & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16) * 66) + (((iArr[i4] & 65280) >> 8) * 129)) + ((iArr[i4] & 255) * 25)) + 128) >> 8) + 16;
                int i8 = i4 + 1;
                if (i7 < 0) {
                    i6 = 0;
                } else if (i7 <= 255) {
                    i6 = i7;
                }
                bArr[i4] = (byte) i6;
                i5++;
                i4 = i8;
            }
        }
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
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
        Uri uri2;
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

    public static boolean isDownloadsDocument(Uri uri) {
        return ImageClipActivity.l.equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return ImageClipActivity.m.equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return ImageClipActivity.k.equals(uri.getAuthority());
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public void destroyProcessor() {
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        mLightAppListener = null;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public View getCustomizedView() {
        return View.inflate(this, ResUtils.layout(getActivity(), "wallet_qrscanner_main_view"), null);
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public float getFocusDataYXRatioal() {
        return 1.0f;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public IImageProcess getImageProcessor() {
        return this;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public int getRecycledBufSize(int i, int i2) {
        return i * i2;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public boolean initProcessor() {
        return true;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            pauseCamera();
            Uri uri = null;
            if (i == 17) {
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
                    if (this.f26370h != null) {
                        this.f26370h.recycle();
                    }
                    if (getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
                        ParcelFileDescriptor openFileDescriptor = getContentResolver().openFileDescriptor(uri2, r.f7699a);
                        if (openFileDescriptor != null) {
                            this.f26370h = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
                        }
                        openFileDescriptor.close();
                    } else if (Build.VERSION.SDK_INT >= 19) {
                        this.f26370h = this.i.decode(new File(getPath(getActivity(), uri2)), 0);
                    } else {
                        Cursor query = getActivity().getContentResolver().query(uri2, new String[]{"_data"}, null, null, null);
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                        query.moveToFirst();
                        String string = query.getString(columnIndexOrThrow);
                        query.close();
                        this.f26370h = this.i.decode(new File(string), 0);
                    }
                    int width = this.f26370h.getWidth();
                    int height = this.f26370h.getHeight();
                    int i3 = width * height;
                    int[] iArr = new int[i3];
                    byte[] bArr = new byte[i3];
                    this.f26370h.getPixels(iArr, 0, width, 0, 0, width, height);
                    encodeYUV420SP(bArr, iArr, width, height);
                    new a(bArr, width, height, 2).start();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        IScanCodeListener iScanCodeListener = mLightAppListener;
        if (iScanCodeListener != null) {
            iScanCodeListener.onResult(0, "");
        }
        super.onBackPressed();
    }

    @Override // com.baidu.wallet.base.camera.OnCameraChangeListener
    public void onCameraClose() {
    }

    @Override // com.baidu.wallet.base.camera.OnCameraChangeListener
    public void onCameraOpen() {
        this.n.setVisibility(CameraCtrl.isSupprtFlashLight(getPackageManager()) ? 0 : 8);
        this.E = this.p.isSupportZoom();
        this.k.start();
        if (this.p.isSupportZoom()) {
            this.m.setMaxPregress(this.p.getMaxZoom());
            this.m.setProgress(this.p.getCurrentZoom());
            this.v.a(new a.InterfaceC0280a() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.9
                @Override // com.baidu.wallet.qrcodescanner.a.InterfaceC0280a
                public void a(boolean z) {
                    int currentZoom = QRScanCodeActivity.this.p.getCurrentZoom();
                    int maxZoom = QRScanCodeActivity.this.p.getMaxZoom();
                    int i = z ? currentZoom + 2 : currentZoom - 2;
                    if (i < 0) {
                        maxZoom = 0;
                    } else if (i <= maxZoom) {
                        maxZoom = i;
                    }
                    QRScanCodeActivity.this.p.setZoom(maxZoom);
                    QRScanCodeActivity.this.m.setProgress(maxZoom);
                    QRScanCodeActivity.this.m.invalidate();
                }

                @Override // com.baidu.wallet.qrcodescanner.a.InterfaceC0280a
                public void a() {
                    if (QRScanCodeActivity.this.E) {
                        QRScanCodeActivity.this.showProgress();
                    }
                }
            });
            this.j.setOnTouchListener(this.v);
            this.m.setProgressStatusChangeListener(new ProgressView.b() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.10
                @Override // com.baidu.wallet.qrcodescanner.widget.ProgressView.b
                public void a() {
                    if (QRScanCodeActivity.this.E) {
                        QRScanCodeActivity.this.showProgress();
                    }
                }

                @Override // com.baidu.wallet.qrcodescanner.widget.ProgressView.b
                public void a(int i) {
                    QRScanCodeActivity.this.p.setZoom(i);
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
                BaiduWalletUtils.requestPermissionsDialog(null, getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.7
                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        if (bool.booleanValue()) {
                            if (PermissionManager.checkCallingOrSelfPermission(QRScanCodeActivity.this.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, QRScanCodeActivity.f26367g)) {
                                return;
                            }
                            QRScanCodeActivity.this.c();
                        } else if (Build.VERSION.SDK_INT >= 23) {
                            QRScanCodeActivity.this.onRequestPermissionsResult(1, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new int[]{-1});
                        }
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isShow(String str, Boolean bool) {
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void requestResult(String str, Boolean bool) {
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
            EventBus.getInstance().register(this, Constants.EVT_CLOSE, 0, EventBus.ThreadMode.MainThread);
            BaiduPayServiceController.getInstance().doScanCode(getActivity(), false, "QRScanCodeActivity", "");
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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
        this.i = new ImageProcessor(getApplicationContext());
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                    ViewHelper.setAlpha(view, 1.0f);
                    return false;
                }
                ViewHelper.setAlpha(view, 0.5f);
                return false;
            }
        };
        this.D = onTouchListener;
        this.o.setOnTouchListener(onTouchListener);
        com.baidu.wallet.qrcodescanner.a.a.a().a(getActivity(), new com.baidu.wallet.qrcodescanner.a.b() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.12
            @Override // com.baidu.wallet.qrcodescanner.a.b
            public void onResultFail(String str, String str2) {
            }

            @Override // com.baidu.wallet.qrcodescanner.a.b
            public void onResultSuccessCallBack(String str, final b.a aVar, boolean z) {
                QRScanCodeActivity.this.r.setImageUrl(str);
                QRScanCodeActivity.this.s.setVisibility(0);
                if (aVar != null) {
                    QRScanCodeActivity.this.r.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.12.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DXMSdkSAUtils.onEvent("scanCodeOpenBanner");
                            PayStatisticsUtil.onEvent("scanCodeOpenBanner");
                            if ("2".equals(aVar.f26438a)) {
                                WalletLoginHelper.getInstance().startPage(aVar.f26439b);
                            } else if ("1".equals(aVar.f26438a)) {
                                if (!NetworkUtils.isNetworkAvailable(QRScanCodeActivity.this.getActivity())) {
                                    GlobalUtils.toast(QRScanCodeActivity.this.getActivity(), ResUtils.getString(QRScanCodeActivity.this.getActivity(), "ebpay_no_network"));
                                } else {
                                    BaiduWalletDelegate.getInstance().openH5Module(QRScanCodeActivity.this.getActivity(), aVar.f26439b, false);
                                }
                            } else if ("3".equals(aVar.f26438a)) {
                                BaiduWalletServiceController.getInstance().gotoWalletService(QRScanCodeActivity.this.getActivity(), aVar.f26439b, "");
                            }
                        }
                    });
                }
            }
        }, new AnonymousClass13());
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

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i != 289) {
            if (i != 291) {
                if (i != 295) {
                    return super.onCreateDialog(i);
                }
                return new PromptDialog(getActivity());
            }
            return new PromptDialog(getActivity());
        }
        return new PromptDialog(getActivity());
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
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

    public void onModuleEvent(EventBus.Event event) {
        if (event == null || !Constants.EVT_CLOSE.equals(event.mEventKey)) {
            return;
        }
        EventBus.getInstance().unregister(this, Constants.EVT_CLOSE);
        if (isFinishing()) {
            return;
        }
        finish();
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onPermissionDenied() {
        IScanCodeListener iScanCodeListener = mLightAppListener;
        if (iScanCodeListener != null) {
            iScanCodeListener.onResult(2, "camera_permission_denied");
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        switch (i) {
            case DIALOG_TXT_COPY /* 289 */:
                final PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(this.w);
                promptDialog.showCloseBtn(true);
                promptDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.16
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        QRScanCodeActivity.this.restartScan();
                    }
                });
                promptDialog.setNegativeBtn(ResUtils.getString(this, "wallet_scancode_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.17
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        promptDialog.dismiss();
                    }
                });
                promptDialog.setPositiveBtn(ResUtils.getString(this, "wallet_scancode_copy"), new View.OnClickListener() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.18
                    @Override // android.view.View.OnClickListener
                    @TargetApi(11)
                    public void onClick(View view) {
                        ((ClipboardManager) QRScanCodeActivity.this.getSystemService("clipboard")).setText(QRScanCodeActivity.this.w.trim());
                        GlobalUtils.toast(QRScanCodeActivity.this.getActivity(), ResUtils.getString(QRScanCodeActivity.this.getActivity(), "wallet_scancode_copy_success"));
                        promptDialog.dismiss();
                    }
                });
                return;
            case DIALOG_CHECK_SAFE /* 290 */:
                final PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setMessage(this.z + this.x);
                promptDialog2.showCloseBtn(false);
                promptDialog2.setNegativeBtn(ResUtils.getString(this, "wallet_scancode_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.19
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DXMSdkSAUtils.onEvent("Scancoderemindn");
                        PayStatisticsUtil.onEvent("Scancoderemindn");
                        QRScanCodeActivity.this.finish();
                    }
                });
                promptDialog2.setPositiveBtn(ResUtils.getString(this, "wallet_scancode_continue_open"), new View.OnClickListener() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DXMSdkSAUtils.onEventWithValues("Scancoderemindy", Arrays.asList(QRScanCodeActivity.this.x));
                        PayStatisticsUtil.onEventWithValue("Scancoderemindy", QRScanCodeActivity.this.x);
                        QRScanCodeActivity qRScanCodeActivity = QRScanCodeActivity.this;
                        qRScanCodeActivity.startParserURl(qRScanCodeActivity.x, true);
                        promptDialog2.dismiss();
                    }
                });
                break;
            case DIALOG_PROCESS_IMG_FAILED /* 291 */:
                final PromptDialog promptDialog3 = (PromptDialog) dialog;
                promptDialog3.setMessage(ResUtils.getString(getActivity(), "wallet_scancode_error"));
                promptDialog3.showCloseBtn(false);
                promptDialog3.hideNegativeButton();
                promptDialog3.setPositiveBtn(ResUtils.getString(this, "ebpay_confirm"), new View.OnClickListener() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        promptDialog3.dismiss();
                    }
                });
                break;
            case DIALOG_ALIPAY_JD_WX_COPY /* 294 */:
                String string = ResUtils.getString(getActivity(), "wallet_alipay_jd_wx_pay_tips");
                final PromptDialog promptDialog4 = (PromptDialog) dialog;
                promptDialog4.setMessage(string + this.y);
                promptDialog4.showCloseBtn(false);
                promptDialog4.setNegativeBtn(ResUtils.getString(this, "wallet_scancode_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        promptDialog4.dismiss();
                        QRScanCodeActivity.this.finish();
                    }
                });
                promptDialog4.setPositiveBtn(ResUtils.getString(this, "wallet_scancode_copy"), new View.OnClickListener() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.5
                    @Override // android.view.View.OnClickListener
                    @TargetApi(11)
                    public void onClick(View view) {
                        ((ClipboardManager) QRScanCodeActivity.this.getSystemService("clipboard")).setText(QRScanCodeActivity.this.y.trim());
                        GlobalUtils.toast(QRScanCodeActivity.this.getActivity(), ResUtils.getString(QRScanCodeActivity.this.getActivity(), "wallet_alipay_wx_jd_copy_success"));
                        QRScanCodeActivity.this.restartScan();
                        promptDialog4.dismiss();
                    }
                });
                break;
            case DIALOG_COLLECTION_CODE_TIP /* 295 */:
                final PromptDialog promptDialog5 = (PromptDialog) dialog;
                promptDialog5.setMessage(this.w);
                promptDialog5.showCloseBtn(false);
                promptDialog5.hideNegativeButton();
                promptDialog5.setPositiveBtn(ResUtils.getString(this, "ebpay_confirm"), new View.OnClickListener() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        promptDialog5.dismiss();
                        QRScanCodeActivity.this.finishWithoutAnim();
                    }
                });
                break;
        }
        super.onPrepareDialog(i, dialog);
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onProcessImageOk(Object[] objArr) {
        runOnUiThread(new Runnable() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.14
            @Override // java.lang.Runnable
            public void run() {
                QRScanCodeActivity.this.k.stop();
            }
        });
        BarcodeResult a2 = a(objArr);
        if (a2 == null) {
            return;
        }
        try {
            final String str = new String(a2.code, a2.encoding);
            DXMSdkSAUtils.onEventWithValues("scanResult", Arrays.asList(str));
            PayStatisticsUtil.onEventWithValue("scanResult", str);
            runOnUiThread(new Runnable() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.15
                @Override // java.lang.Runnable
                public void run() {
                    IScanCodeListener iScanCodeListener = QRScanCodeActivity.mLightAppListener;
                    if (iScanCodeListener != null) {
                        if (iScanCodeListener.shouldDispatchUrl(str)) {
                            QRScanCodeActivity.mLightAppListener.dispatchUrl(QRScanCodeActivity.this.getActivity(), str, new IScannerDispatchListener() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.15.1
                                @Override // com.baidu.wallet.api.IScannerDispatchListener
                                public void onClose() {
                                    QRScanCodeActivity.this.b(true);
                                    QRScanCodeActivity.this.finish();
                                }

                                @Override // com.baidu.wallet.api.IScannerDispatchListener
                                public void onRescan() {
                                    QRScanCodeActivity.this.restartScan();
                                }
                            });
                            return;
                        }
                        QRScanCodeActivity.mLightAppListener = null;
                    }
                    if (!ScanCoderWrapper.getInstance().shouldDispatchUrl(str)) {
                        WalletGlobalUtils.safeShowDialog(QRScanCodeActivity.this, -2, "");
                        QRScanCodeActivity.this.startParserURl(str, false);
                        return;
                    }
                    ScanCoderWrapper.getInstance().dispatchUrl(QRScanCodeActivity.this, str, new IScannerDispatchListener() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.15.2
                        @Override // com.baidu.wallet.api.IScannerDispatchListener
                        public void onClose() {
                            QRScanCodeActivity.this.b(true);
                            QRScanCodeActivity.this.finish();
                        }

                        @Override // com.baidu.wallet.api.IScannerDispatchListener
                        public void onRescan() {
                            QRScanCodeActivity.this.restartScan();
                        }
                    });
                }
            });
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == f26367g) {
            if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if ("android.permission.READ_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i2]) && iArr != null && iArr.length > i2) {
                        if (iArr[i2] == 0) {
                            Intent intent = new Intent();
                            intent.addCategory("android.intent.category.OPENABLE");
                            if (Build.VERSION.SDK_INT < 19) {
                                intent.setAction("android.intent.action.GET_CONTENT");
                            } else {
                                intent.setAction("android.intent.action.OPEN_DOCUMENT");
                            }
                            intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, BdUploadHandler.IMAGE_MIME_TYPE);
                            startActivityForResult(Intent.createChooser(intent, "选择图片"), 17);
                        } else if (-1 == iArr[i2]) {
                            c();
                        }
                    }
                }
                return;
            }
            c();
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.wallet.qrcodescanner.a.b
    public void onResultFail(String str, String str2) {
        WalletGlobalUtils.safeDismissDialog(this, -2);
        restartScan();
    }

    @Override // com.baidu.wallet.qrcodescanner.a.b
    public void onResultSuccessCallBack(String str, b.a aVar, boolean z) {
        WalletGlobalUtils.safeDismissDialog(this, -2);
        if (aVar != null) {
            if ("500".equals(aVar.f26438a)) {
                DXMSdkSAUtils.onEvent("scancodenative");
                PayStatisticsUtil.onEvent("scancodenative");
                b(z);
                try {
                    if (aVar.f26440c != null) {
                        ComfirmOrderActivity.ComfirmScanOrderInfo(getActivity(), (QRCodeShortUrlResponse.OrderParam) JsonUtils.fromJson(aVar.f26440c.toString(), QRCodeShortUrlResponse.OrderParam.class), aVar.f26439b, new ComfirmOrderActivity.a() { // from class: com.baidu.wallet.qrcodescanner.QRScanCodeActivity.11
                            @Override // com.baidu.wallet.qrcodescanner.ComfirmOrderActivity.a
                            public void a() {
                                QRScanCodeActivity.this.finish();
                            }

                            @Override // com.baidu.wallet.qrcodescanner.ComfirmOrderActivity.a
                            public void b() {
                                QRScanCodeActivity.this.restartScan();
                            }
                        });
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else if ("2".equals(aVar.f26438a)) {
                DXMSdkSAUtils.onEvent("scancodeurl");
                PayStatisticsUtil.onEvent("scancodeurl");
                WalletLoginHelper.getInstance().startPage(aVar.f26439b);
                b(z);
                finishWithoutAnim();
            } else if ("100".equals(aVar.f26438a)) {
                b(z);
                DXMSdkSAUtils.onEvent("scancodetext");
                PayStatisticsUtil.onEvent("scancodetext");
                this.w = str;
                WalletGlobalUtils.safeShowDialog(this, DIALOG_TXT_COPY, "");
            } else if ("600".equals(aVar.f26438a)) {
                b(z);
                this.y = str;
                WalletGlobalUtils.safeShowDialog(this, DIALOG_ALIPAY_JD_WX_COPY, "");
            } else if ("1".equals(aVar.f26438a)) {
                DXMSdkSAUtils.onEvent("scancodeurl");
                PayStatisticsUtil.onEvent("scancodeurl");
                if (!NetworkUtils.isNetworkAvailable(getActivity())) {
                    GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_no_network"));
                    restartScan();
                    return;
                }
                BaiduWalletDelegate.getInstance().openH5Module(getActivity(), aVar.f26439b, false);
                b(z);
                finishWithoutAnim();
            } else if ("3".equals(aVar.f26438a)) {
                DXMSdkSAUtils.onEvent("scancodenative");
                PayStatisticsUtil.onEvent("scancodenative");
                BaiduWalletServiceController.getInstance().gotoWalletService(getActivity(), aVar.f26439b, "");
                b(z);
                finishWithoutAnim();
            } else if ("300".equals(aVar.f26438a)) {
                b(z);
                DXMSdkSAUtils.onEvent("scancoderemind");
                PayStatisticsUtil.onEvent("scancoderemind");
                this.x = str;
                WalletGlobalUtils.safeShowDialog(this, DIALOG_CHECK_SAFE, "");
            } else if ("501".equals(aVar.f26438a)) {
                b(z);
                JSONObject jSONObject = aVar.f26441d;
                if (jSONObject != null && jSONObject.has("errmsg")) {
                    try {
                        String string = aVar.f26441d.getString("errmsg");
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

    public void playAmazingSound(Context context, int i) {
        SoundPool soundPool = new SoundPool(1, 3, 5);
        this.u = soundPool;
        b bVar = new b(this.u, soundPool.load(context, i, 1));
        this.t = bVar;
        this.u.setOnLoadCompleteListener(bVar);
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImage(byte[] bArr, int i, int i2, Rect rect, byte[] bArr2) {
        Yuv.rotateCropLuminance(bArr, i, i2, rect, 270, bArr2);
        return com.baidu.wallet.qrcodescanner.a.a.a().a(bArr2, rect.width(), rect.height(), 2);
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImageJpegData(byte[] bArr, int i, int i2) {
        return null;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void relayoutUi() {
    }

    public void relayoutUi(Rect rect) {
        MistLayorView mistLayorView = this.l;
        if (mistLayorView != null) {
            mistLayorView.setFocusFrame(rect);
        }
        ProgressView progressView = this.m;
        if (progressView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) progressView.getLayoutParams();
            int i = rect.top;
            layoutParams.topMargin = i + (((rect.bottom - i) - layoutParams.height) / 2);
            this.m.requestLayout();
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void restartScan() {
        this.k.start();
        super.restartScan();
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void setFocusRectValue(Rect rect) {
    }

    public void showProgress() {
        this.m.setVisibility(0);
        if (this.A == null) {
            this.A = new Handler(getMainLooper());
        }
        this.A.removeCallbacksAndMessages(null);
        this.A.postDelayed(this.f26368e, 2000L);
    }

    public void startParserURl(String str, boolean z) {
        com.baidu.wallet.qrcodescanner.a.a.a().a(this, str, this, z, true);
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void updateFlashLightUi(boolean z) {
        if (this.n == null) {
            return;
        }
        this.n.setImageResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
        AccessibilityUtils.setContentDescription(this.n, z ? "关闭闪光灯" : "打开闪光灯");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            playAmazingSound(getActivity(), ResUtils.raw(this.k.getContext(), "sweep"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        restartScan();
        GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "wallet_scancode_album_error"));
    }

    private void a(boolean z) {
        findViewById(ResUtils.id(getActivity(), "qrcode_gen_out_btn")).setVisibility(z ? 0 : 4);
    }

    private BarcodeResult a(Object[] objArr) {
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
}
