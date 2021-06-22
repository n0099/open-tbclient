package com.baidu.wallet.base.iddetect;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.iddetect.beans.IDDetectBeanFactory;
import com.baidu.wallet.base.iddetect.datamodel.IDDetectResponse;
import com.baidu.wallet.base.iddetect.utils.d;
import com.baidu.wallet.base.iddetect.utils.e;
import com.baidu.wallet.base.iddetect.utils.f;
import com.baidu.wallet.base.iddetect.view.LaserScannerForScan;
import com.baidu.wallet.base.iddetect.view.SurfaceViewForScan;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.webkit.sdk.PermissionRequest;
import com.coremedia.iso.boxes.TrackReferenceTypeBox;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class IdCardActivity extends BeanActivity implements View.OnClickListener {
    public static final String KEY_IMG_PATH = "card_img_path";
    public static final String KEY_NAME = "name";
    public static final String KEY_NUMBER = "number";
    public static final int RESULT_INNER_ERROR = 3;
    public static final int RESULT_NO_PERMISSION = 2;
    public static final String RESULT_PERMISSION_KEY = "permission_name";
    public static final String TAG = "IdCardActivity";
    public View C;

    /* renamed from: a  reason: collision with root package name */
    public Activity f23375a;

    /* renamed from: b  reason: collision with root package name */
    public View f23376b;

    /* renamed from: c  reason: collision with root package name */
    public View f23377c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f23378d;

    /* renamed from: e  reason: collision with root package name */
    public LaserScannerForScan f23379e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceViewForScan f23380f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23381g;
    public int j;
    public int k;
    public int l;
    public int m;
    public String n;
    public String o;
    public String q;
    public Bitmap r;
    public Bitmap s;
    public boolean w;
    public String z;

    /* renamed from: h  reason: collision with root package name */
    public float f23382h = -1.0f;

    /* renamed from: i  reason: collision with root package name */
    public float f23383i = -1.0f;
    public String p = "";
    public boolean t = false;
    public boolean u = false;
    public boolean v = true;
    public long x = 0;
    public int y = 0;
    public boolean A = false;
    public com.baidu.wallet.base.iddetect.a B = null;
    public final Handler D = new a(this);

    /* loaded from: classes5.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<IdCardActivity> f23392a;

        public a(IdCardActivity idCardActivity) {
            this.f23392a = new WeakReference<>(idCardActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IdCardActivity idCardActivity = this.f23392a.get();
            if (idCardActivity == null) {
                return;
            }
            int i2 = message.what;
            if (i2 == 0) {
                LogUtil.i(IdCardActivity.TAG, "成功" + idCardActivity.y + ";姓名=" + idCardActivity.o + ";号码=" + idCardActivity.n);
                idCardActivity.v = false;
                idCardActivity.D.sendEmptyMessage(6);
            } else if (i2 == 1) {
                LogUtil.i(IdCardActivity.TAG, "失败" + idCardActivity.y);
                idCardActivity.v = true;
                idCardActivity.u = false;
                idCardActivity.f23380f.autoFocus();
            } else if (i2 == 2) {
                idCardActivity.t = true;
            } else if (i2 == 3) {
                if (idCardActivity.A) {
                    idCardActivity.f23381g.setText(idCardActivity.z);
                }
            } else if (i2 == 5) {
                PayStatisticsUtil.onEvent(StatServiceEvent.IDCARD_DETECT_EVENTID_FAIL_TIMEOUT);
                idCardActivity.t = false;
                idCardActivity.D.sendEmptyMessage(7);
            } else if (i2 != 6) {
                if (i2 != 7) {
                    return;
                }
                idCardActivity.f();
                IdCardController.getInstance().fail(0, null);
                idCardActivity.finish();
            } else {
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.IDCARD_DETECT_EVENTID_SUCCESS_TIMES, "" + idCardActivity.y);
                idCardActivity.f();
                Bundle bundle = new Bundle();
                bundle.putString("name", idCardActivity.o);
                bundle.putString(IdCardActivity.KEY_IMG_PATH, idCardActivity.q);
                bundle.putString(IdCardActivity.KEY_NUMBER, idCardActivity.n);
                IdCardController.getInstance().success(bundle);
                idCardActivity.finish();
            }
        }
    }

    public void dialogPermission() {
        String format = String.format(ResUtils.getString(getActivity(), "wallet_camera_error"), PhoneUtils.getApplicationName(getActivity()));
        this.mDialogMsg = format;
        WalletGlobalUtils.safeShowDialog(this, 3, format);
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        if (i2 == 57345) {
            PayStatisticsUtil.onEventEndWithValue(StatServiceEvent.IDCARD_DETECT_API_DETECT, i3, str);
            this.D.sendEmptyMessage(1);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        if (i2 == 57345) {
            PayStatisticsUtil.onEventEnd(StatServiceEvent.IDCARD_DETECT_API_DETECT, 0);
            if (obj != null && (obj instanceof IDDetectResponse)) {
                IDDetectResponse iDDetectResponse = (IDDetectResponse) obj;
                if (!TextUtils.isEmpty(iDDetectResponse.name) && !TextUtils.isEmpty(iDDetectResponse.id_card) && d.a(iDDetectResponse.id_card)) {
                    this.o = iDDetectResponse.name;
                    this.n = iDDetectResponse.id_card;
                    this.D.sendEmptyMessage(0);
                    return;
                }
            }
            this.D.sendEmptyMessage(1);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean isStatusbarTextColorBlack() {
        return false;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PayStatisticsUtil.onEventWithValue(StatServiceEvent.IDCARD_DETECT_EVENTID_FAIL_TIMES, "" + this.y);
        this.D.sendEmptyMessage(7);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == ResUtils.id(this.f23375a, "back_btn")) {
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.IDCARD_DETECT_EVENTID_FAIL_TIMES, "" + this.y);
            this.D.sendEmptyMessage(7);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f23375a = getActivity();
        a(getActivity());
        setIsMultiWindowAvailable(false);
        setIsShowMultiWindowTips(true);
        setMultiWindowTipsId("wallet_base_multi_window_close");
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BeanManager.getInstance().removeAllBeans(TAG);
        super.onDestroy();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.w = false;
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        super.onPrepareDialog(i2, dialog);
        if (i2 == 3) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.wallet.base.iddetect.IdCardActivity.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    Bundle bundle = new Bundle();
                    if (PermissionManager.checkCallingPermission(IdCardActivity.this.getActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                        IdCardController.getInstance().fail(3, null);
                    } else {
                        bundle.putString(IdCardActivity.RESULT_PERMISSION_KEY, "访问相机的权限");
                        IdCardController.getInstance().fail(2, bundle);
                    }
                    IdCardActivity.this.finish();
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1) {
            if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                c();
            } else {
                b();
            }
        } else if (i2 != 3) {
        } else {
            if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                b(getActivity());
            } else {
                a();
            }
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.w = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00b6 A[Catch: IOException -> 0x00b2, TryCatch #4 {IOException -> 0x00b2, blocks: (B:55:0x00ae, B:59:0x00b6, B:61:0x00bb), top: B:70:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bb A[Catch: IOException -> 0x00b2, TRY_LEAVE, TryCatch #4 {IOException -> 0x00b2, blocks: (B:55:0x00ae, B:59:0x00b6, B:61:0x00bb), top: B:70:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] sendDataAndGetResult(String str, JSONObject jSONObject) {
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        Throwable th;
        InputStream inputStream;
        byte[] bArr;
        InputStream inputStream2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setRequestMethod("POST");
            outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(jSONObject.toString().getBytes());
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            try {
                                byte[] bArr2 = new byte[8192];
                                while (true) {
                                    int read = inputStream.read(bArr2);
                                    if (read < 1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                }
                                inputStream2 = inputStream;
                                bArr = byteArrayOutputStream.toByteArray();
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                        return null;
                                    }
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                    return null;
                                }
                                return null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        byteArrayOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                        if (inputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                } else {
                    bArr = null;
                    byteArrayOutputStream = null;
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr;
            } catch (Exception e7) {
                e = e7;
                inputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                inputStream = null;
            }
        } catch (Exception e8) {
            e = e8;
            inputStream = null;
            byteArrayOutputStream = null;
            outputStream = null;
        } catch (Throwable th5) {
            byteArrayOutputStream = null;
            outputStream = null;
            th = th5;
            inputStream = null;
        }
    }

    public void setTop(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(this.mAct)));
            ImmersiveStatusBarManager.setTopBar(getActivity(), view, isStatusbarTextColorBlack());
        }
    }

    private void d() {
        SurfaceViewForScan surfaceViewForScan = (SurfaceViewForScan) findViewById(ResUtils.id(this.f23375a, "surface_view"));
        this.f23380f = surfaceViewForScan;
        surfaceViewForScan.setAttachedActivity(this);
        LaserScannerForScan laserScannerForScan = (LaserScannerForScan) findViewById(ResUtils.id(this.f23375a, "frame"));
        this.f23379e = laserScannerForScan;
        laserScannerForScan.setAttachedActivity(this);
        this.f23376b = findViewById(ResUtils.id(this.f23375a, "view_top"));
        this.f23377c = findViewById(ResUtils.id(this.f23375a, "view_left"));
        this.f23378d = (LinearLayout) findViewById(ResUtils.id(this.f23375a, "title_bar"));
        this.f23381g = (TextView) findViewById(ResUtils.id(this.f23375a, TrackReferenceTypeBox.TYPE1));
        View findViewById = findViewById(ResUtils.id(getActivity(), "title_bar_margin"));
        this.C = findViewById;
        setTop(findViewById);
    }

    private void e() {
        this.f23379e.startScan();
        findViewById(ResUtils.id(this.f23375a, "back_btn")).setOnClickListener(this);
        this.f23380f.setPreviewCallback(new SurfaceViewForScan.a() { // from class: com.baidu.wallet.base.iddetect.IdCardActivity.5
            @Override // com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.a
            public void a(byte[] bArr, int i2, int i3, int i4) {
                if (IdCardActivity.this.t && IdCardActivity.this.w && IdCardActivity.this.v) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - IdCardActivity.this.x >= 200) {
                        IdCardActivity.this.x = currentTimeMillis;
                        IdCardActivity.this.a(bArr, i2, i3, i4);
                    }
                }
            }
        });
        if (this.v) {
            this.D.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f23379e.stopScan();
        this.f23380f.setPreviewCallback(null);
        this.f23380f.releaseSource();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Bundle bundle = new Bundle();
        bundle.putString(RESULT_PERMISSION_KEY, "读写存储卡的权限");
        IdCardController.getInstance().fail(2, bundle);
        finish();
    }

    private void c() {
        try {
            setContentView(ResUtils.layout(this.f23375a, "wallet_base_id_detect"));
            d();
            e();
        } catch (Exception unused) {
            dialogPermission();
        }
    }

    private void a(final Activity activity) {
        if (PermissionManager.checkCallingPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
            if (PermissionManager.checkCallingPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                c();
                return;
            } else {
                BaiduWalletUtils.requestPermissionsDialog(null, getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.base.iddetect.IdCardActivity.2
                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        if (bool.booleanValue()) {
                            if (PermissionManager.checkCallingOrSelfPermission(activity, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 1)) {
                                return;
                            }
                            IdCardActivity.this.b();
                        } else if (Build.VERSION.SDK_INT >= 23) {
                            IdCardActivity.this.onRequestPermissionsResult(1, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{-1});
                        }
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isShow(String str, Boolean bool) {
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void requestResult(String str, Boolean bool) {
                    }
                });
                return;
            }
        }
        BaiduWalletUtils.requestPermissionsDialog(null, activity, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.base.iddetect.IdCardActivity.3
            @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
            public void isAllAgree(Boolean bool) {
                if (bool.booleanValue()) {
                    if (PermissionManager.checkCallingOrSelfPermission(activity, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 3)) {
                        return;
                    }
                    IdCardActivity.this.a();
                } else if (Build.VERSION.SDK_INT >= 23) {
                    IdCardActivity.this.onRequestPermissionsResult(3, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new int[]{-1});
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

    private void b(final Activity activity) {
        if (PermissionManager.checkCallingPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            c();
        } else {
            BaiduWalletUtils.requestPermissionsDialog(null, getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.base.iddetect.IdCardActivity.4
                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isAllAgree(Boolean bool) {
                    if (bool.booleanValue()) {
                        if (PermissionManager.checkCallingOrSelfPermission(activity, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 1)) {
                            return;
                        }
                        IdCardActivity.this.b();
                    } else if (Build.VERSION.SDK_INT >= 23) {
                        IdCardActivity.this.onRequestPermissionsResult(1, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{-1});
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Bundle bundle = new Bundle();
        bundle.putString(RESULT_PERMISSION_KEY, "访问相机的权限");
        IdCardController.getInstance().fail(2, bundle);
        dialogPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, int i2, int i3, int i4) {
        if (this.u) {
            return;
        }
        this.u = true;
        int i5 = this.y;
        if (i5 >= 50) {
            this.D.sendEmptyMessage(5);
            return;
        }
        this.y = i5 + 1;
        Bitmap a2 = a(bArr, i2, i3);
        this.r = a2;
        Bitmap a3 = a(a2);
        this.s = a3;
        a(a3, this.p, "IdCard");
        com.baidu.wallet.base.iddetect.beans.a aVar = (com.baidu.wallet.base.iddetect.beans.a) IDDetectBeanFactory.getInstance().getBean((Context) this.f23375a, IDDetectBeanFactory.BEAN_ID_ID_DETECT, TAG);
        aVar.a(com.baidu.wallet.base.iddetect.utils.a.a(this.s));
        aVar.setResponseCallback(this);
        aVar.execBean();
        PayStatisticsUtil.onEventStart(StatServiceEvent.IDCARD_DETECT_API_DETECT);
    }

    private Bitmap a(byte[] bArr, int i2, int i3) {
        return Bitmap.createBitmap(e.a(bArr, i2, i3), i2, i3, Bitmap.Config.ARGB_8888);
    }

    private void a(int i2, int i3) {
        this.f23382h = (i3 * 1.0f) / this.f23380f.getHeight();
        float width = (i2 * 1.0f) / this.f23380f.getWidth();
        this.f23383i = width;
        this.j = (int) (width * this.f23377c.getWidth());
        this.k = (int) (this.f23382h * (this.f23376b.getHeight() + this.f23378d.getHeight()));
        this.l = (int) (this.f23383i * this.f23379e.getWidth());
        this.m = (int) (this.f23382h * this.f23379e.getHeight());
    }

    private Bitmap a(Bitmap bitmap) {
        if (this.f23382h == -1.0f) {
            a(bitmap.getWidth(), bitmap.getHeight());
        }
        return Bitmap.createBitmap(bitmap, this.j, this.k, this.l, this.m);
    }

    private void a(Bitmap bitmap, String str, String str2) {
        File a2 = f.a(getActivity());
        if (!a2.exists()) {
            a2.mkdirs();
        }
        String str3 = a2.getAbsolutePath() + File.separator + str2 + ".jpg";
        File file = new File(str3);
        if (file.exists()) {
            file.delete();
        }
        System.out.println(str3);
        com.baidu.wallet.base.iddetect.utils.a.a(this.f23375a, bitmap, str3, Bitmap.CompressFormat.JPEG, 70);
        this.q = str3;
    }
}
