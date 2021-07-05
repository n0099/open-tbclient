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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes6.dex */
public class IdCardActivity extends BeanActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_IMG_PATH = "card_img_path";
    public static final String KEY_NAME = "name";
    public static final String KEY_NUMBER = "number";
    public static final int RESULT_INNER_ERROR = 3;
    public static final int RESULT_NO_PERMISSION = 2;
    public static final String RESULT_PERMISSION_KEY = "permission_name";
    public static final String TAG = "IdCardActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public com.baidu.wallet.base.iddetect.a B;
    public View C;
    public final Handler D;

    /* renamed from: a  reason: collision with root package name */
    public Activity f23918a;

    /* renamed from: b  reason: collision with root package name */
    public View f23919b;

    /* renamed from: c  reason: collision with root package name */
    public View f23920c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f23921d;

    /* renamed from: e  reason: collision with root package name */
    public LaserScannerForScan f23922e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceViewForScan f23923f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23924g;

    /* renamed from: h  reason: collision with root package name */
    public float f23925h;

    /* renamed from: i  reason: collision with root package name */
    public float f23926i;
    public int j;
    public int k;
    public int l;
    public int m;
    public String n;
    public String o;
    public String p;
    public String q;
    public Bitmap r;
    public Bitmap s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public long x;
    public int y;
    public String z;

    /* loaded from: classes6.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<IdCardActivity> f23935a;

        public a(IdCardActivity idCardActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {idCardActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23935a = new WeakReference<>(idCardActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IdCardActivity idCardActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (idCardActivity = this.f23935a.get()) == null) {
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
                idCardActivity.f23923f.autoFocus();
            } else if (i2 == 2) {
                idCardActivity.t = true;
            } else if (i2 == 3) {
                if (idCardActivity.A) {
                    idCardActivity.f23924g.setText(idCardActivity.z);
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

    public IdCardActivity() {
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
        this.f23925h = -1.0f;
        this.f23926i = -1.0f;
        this.p = "";
        this.t = false;
        this.u = false;
        this.v = true;
        this.x = 0L;
        this.y = 0;
        this.A = false;
        this.B = null;
        this.D = new a(this);
    }

    public void dialogPermission() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String format = String.format(ResUtils.getString(getActivity(), "wallet_camera_error"), PhoneUtils.getApplicationName(getActivity()));
            this.mDialogMsg = format;
            WalletGlobalUtils.safeShowDialog(this, 3, format);
        }
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) && i2 == 57345) {
            PayStatisticsUtil.onEventEndWithValue(StatServiceEvent.IDCARD_DETECT_API_DETECT, i3, str);
            this.D.sendEmptyMessage(1);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) && i2 == 57345) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.IDCARD_DETECT_EVENTID_FAIL_TIMES, "" + this.y);
            this.D.sendEmptyMessage(7);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view) == null) && view.getId() == ResUtils.id(this.f23918a, "back_btn")) {
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.IDCARD_DETECT_EVENTID_FAIL_TIMES, "" + this.y);
            this.D.sendEmptyMessage(7);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            this.f23918a = getActivity();
            a(getActivity());
            setIsMultiWindowAvailable(false);
            setIsShowMultiWindowTips(true);
            setMultiWindowTipsId("wallet_base_multi_window_close");
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BeanManager.getInstance().removeAllBeans(TAG);
            super.onDestroy();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            this.w = false;
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, dialog) == null) {
            super.onPrepareDialog(i2, dialog);
            if (i2 == 3) {
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.baidu.wallet.base.iddetect.IdCardActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ IdCardActivity f23927a;

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
                        this.f23927a = this;
                    }

                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            Bundle bundle = new Bundle();
                            if (PermissionManager.checkCallingPermission(this.f23927a.getActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                                IdCardController.getInstance().fail(3, null);
                            } else {
                                bundle.putString(IdCardActivity.RESULT_PERMISSION_KEY, "访问相机的权限");
                                IdCardController.getInstance().fail(2, bundle);
                            }
                            this.f23927a.finish();
                        }
                    }
                });
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i2, strArr, iArr) == null) {
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
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            this.w = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00ba A[Catch: IOException -> 0x00b6, TryCatch #2 {IOException -> 0x00b6, blocks: (B:57:0x00b2, B:61:0x00ba, B:63:0x00bf), top: B:74:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bf A[Catch: IOException -> 0x00b6, TRY_LEAVE, TryCatch #2 {IOException -> 0x00b6, blocks: (B:57:0x00b2, B:61:0x00ba, B:63:0x00bf), top: B:74:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] sendDataAndGetResult(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        Throwable th;
        InputStream inputStream;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048589, this, str, jSONObject)) != null) {
            return (byte[]) invokeLL.objValue;
        }
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, view) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(this.mAct)));
        ImmersiveStatusBarManager.setTopBar(getActivity(), view, isStatusbarTextColorBlack());
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            SurfaceViewForScan surfaceViewForScan = (SurfaceViewForScan) findViewById(ResUtils.id(this.f23918a, "surface_view"));
            this.f23923f = surfaceViewForScan;
            surfaceViewForScan.setAttachedActivity(this);
            LaserScannerForScan laserScannerForScan = (LaserScannerForScan) findViewById(ResUtils.id(this.f23918a, "frame"));
            this.f23922e = laserScannerForScan;
            laserScannerForScan.setAttachedActivity(this);
            this.f23919b = findViewById(ResUtils.id(this.f23918a, "view_top"));
            this.f23920c = findViewById(ResUtils.id(this.f23918a, "view_left"));
            this.f23921d = (LinearLayout) findViewById(ResUtils.id(this.f23918a, "title_bar"));
            this.f23924g = (TextView) findViewById(ResUtils.id(this.f23918a, TrackReferenceTypeBox.TYPE1));
            View findViewById = findViewById(ResUtils.id(getActivity(), "title_bar_margin"));
            this.C = findViewById;
            setTop(findViewById);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            this.f23922e.startScan();
            findViewById(ResUtils.id(this.f23918a, "back_btn")).setOnClickListener(this);
            this.f23923f.setPreviewCallback(new SurfaceViewForScan.a(this) { // from class: com.baidu.wallet.base.iddetect.IdCardActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IdCardActivity f23934a;

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
                    this.f23934a = this;
                }

                @Override // com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.a
                public void a(byte[] bArr, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLIII(1048576, this, bArr, i2, i3, i4) == null) && this.f23934a.t && this.f23934a.w && this.f23934a.v) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.f23934a.x >= 200) {
                            this.f23934a.x = currentTimeMillis;
                            this.f23934a.a(bArr, i2, i3, i4);
                        }
                    }
                }
            });
            if (this.v) {
                this.D.sendEmptyMessageDelayed(2, 2000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.f23922e.stopScan();
            this.f23923f.setPreviewCallback(null);
            this.f23923f.releaseSource();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            Bundle bundle = new Bundle();
            bundle.putString(RESULT_PERMISSION_KEY, "读写存储卡的权限");
            IdCardController.getInstance().fail(2, bundle);
            finish();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            try {
                setContentView(ResUtils.layout(this.f23918a, "wallet_base_id_detect"));
                d();
                e();
            } catch (Exception unused) {
                dialogPermission();
            }
        }
    }

    private void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, activity) == null) {
            if (PermissionManager.checkCallingPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                if (PermissionManager.checkCallingPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                    c();
                    return;
                } else {
                    BaiduWalletUtils.requestPermissionsDialog(null, getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new BaiduWalletUtils.IRequestPermissionCallBack(this, activity) { // from class: com.baidu.wallet.base.iddetect.IdCardActivity.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Activity f23928a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ IdCardActivity f23929b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, activity};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f23929b = this;
                            this.f23928a = activity;
                        }

                        @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                        public void isAllAgree(Boolean bool) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                                if (bool.booleanValue()) {
                                    if (PermissionManager.checkCallingOrSelfPermission(this.f23928a, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 1)) {
                                        return;
                                    }
                                    this.f23929b.b();
                                } else if (Build.VERSION.SDK_INT >= 23) {
                                    this.f23929b.onRequestPermissionsResult(1, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{-1});
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
                    return;
                }
            }
            BaiduWalletUtils.requestPermissionsDialog(null, activity, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack(this, activity) { // from class: com.baidu.wallet.base.iddetect.IdCardActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Activity f23930a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ IdCardActivity f23931b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f23931b = this;
                    this.f23930a = activity;
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isAllAgree(Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                        if (bool.booleanValue()) {
                            if (PermissionManager.checkCallingOrSelfPermission(this.f23930a, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 3)) {
                                return;
                            }
                            this.f23931b.a();
                        } else if (Build.VERSION.SDK_INT >= 23) {
                            this.f23931b.onRequestPermissionsResult(3, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new int[]{-1});
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
    }

    private void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, activity) == null) {
            if (PermissionManager.checkCallingPermission(activity, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                c();
            } else {
                BaiduWalletUtils.requestPermissionsDialog(null, getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new BaiduWalletUtils.IRequestPermissionCallBack(this, activity) { // from class: com.baidu.wallet.base.iddetect.IdCardActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Activity f23932a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ IdCardActivity f23933b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, activity};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f23933b = this;
                        this.f23932a = activity;
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            if (bool.booleanValue()) {
                                if (PermissionManager.checkCallingOrSelfPermission(this.f23932a, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 1)) {
                                    return;
                                }
                                this.f23933b.b();
                            } else if (Build.VERSION.SDK_INT >= 23) {
                                this.f23933b.onRequestPermissionsResult(1, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{-1});
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            Bundle bundle = new Bundle();
            bundle.putString(RESULT_PERMISSION_KEY, "访问相机的权限");
            IdCardController.getInstance().fail(2, bundle);
            dialogPermission();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65546, this, bArr, i2, i3, i4) == null) || this.u) {
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
        com.baidu.wallet.base.iddetect.beans.a aVar = (com.baidu.wallet.base.iddetect.beans.a) IDDetectBeanFactory.getInstance().getBean((Context) this.f23918a, IDDetectBeanFactory.BEAN_ID_ID_DETECT, TAG);
        aVar.a(com.baidu.wallet.base.iddetect.utils.a.a(this.s));
        aVar.setResponseCallback(this);
        aVar.execBean();
        PayStatisticsUtil.onEventStart(StatServiceEvent.IDCARD_DETECT_API_DETECT);
    }

    private Bitmap a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65540, this, bArr, i2, i3)) == null) ? Bitmap.createBitmap(e.a(bArr, i2, i3), i2, i3, Bitmap.Config.ARGB_8888) : (Bitmap) invokeLII.objValue;
    }

    private void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(AdIconUtil.BAIDU_LOGO_ID, this, i2, i3) == null) {
            this.f23925h = (i3 * 1.0f) / this.f23923f.getHeight();
            float width = (i2 * 1.0f) / this.f23923f.getWidth();
            this.f23926i = width;
            this.j = (int) (width * this.f23920c.getWidth());
            this.k = (int) (this.f23925h * (this.f23919b.getHeight() + this.f23921d.getHeight()));
            this.l = (int) (this.f23926i * this.f23922e.getWidth());
            this.m = (int) (this.f23925h * this.f23922e.getHeight());
        }
    }

    private Bitmap a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, bitmap)) == null) {
            if (this.f23925h == -1.0f) {
                a(bitmap.getWidth(), bitmap.getHeight());
            }
            return Bitmap.createBitmap(bitmap, this.j, this.k, this.l, this.m);
        }
        return (Bitmap) invokeL.objValue;
    }

    private void a(Bitmap bitmap, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, this, bitmap, str, str2) == null) {
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
            com.baidu.wallet.base.iddetect.utils.a.a(this.f23918a, bitmap, str3, Bitmap.CompressFormat.JPEG, 70);
            this.q = str3;
        }
    }
}
