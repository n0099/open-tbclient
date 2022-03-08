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
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.baidu.wallet.base.iddetect.beans.IDDetectBean;
import com.baidu.wallet.base.iddetect.beans.IDDetectBeanFactory;
import com.baidu.wallet.base.iddetect.datamodel.IDDetectResponse;
import com.baidu.wallet.base.iddetect.utils.BitmapUtil;
import com.baidu.wallet.base.iddetect.utils.IdcardUtils;
import com.baidu.wallet.base.iddetect.utils.StorageUtils;
import com.baidu.wallet.base.iddetect.utils.Utils;
import com.baidu.wallet.base.iddetect.view.LaserScannerForScan;
import com.baidu.wallet.base.iddetect.view.SurfaceViewForScan;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.utils.ImageUtils;
import com.baidu.webkit.sdk.PermissionRequest;
import com.coremedia.iso.boxes.TrackReferenceTypeBox;
import com.kwad.v8.debug.ExecutionState;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IdCardActivity extends BeanActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CAMERA_REQUEST_CODE = 3;
    public static final int DELAY_START_TIME = 2000;
    public static final String KEY_IMG_PATH = "card_img_path";
    public static final String KEY_NAME = "name";
    public static final String KEY_NUMBER = "number";
    public static final int MAX_INTERVAL_TIME = 200;
    public static final int MAX_TIMES = 50;
    public static final int MESSAGE_BACK = 7;
    public static final int MESSAGE_CHECK_SUCCESS = 0;
    public static final int MESSAGE_DEBUG_FOR_SERVER = 3;
    public static final int MESSAGE_DELAY = 2;
    public static final int MESSAGE_DONE = 6;
    public static final int MESSAGE_NOT_RECOGNIZE = 1;
    public static final int MESSAGE_SHOW_TOAST = 4;
    public static final int MESSAGE_TIMES_OUT = 5;
    public static final int RESULT_INNER_ERROR = 3;
    public static final int RESULT_NO_PERMISSION = 2;
    public static final String RESULT_PERMISSION_KEY = "permission_name";
    public static final String TAG = "IdCardActivity";
    public static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCanShoot;
    public Bitmap mCardBmp;
    public String mCardImagePath;
    public String mCardName;
    public String mCardNumber;
    public String mCardRealPath;
    public Activity mContext;
    public int mCurrentTimes;
    public String mDebugInfo;
    public final Handler mHandler;
    public TextView mHint;
    public boolean mIsDebugForServer;
    public boolean mIsProcess;
    public boolean mIsResume;
    public boolean mIsStart;
    public long mLastTime;
    public View mLeftView;
    public Bitmap mMaskBmp;
    public CameraSizeInfo mPermissionTest;
    public LaserScannerForScan mScanFrame;
    public SurfaceViewForScan mSurfaceView;
    public int mTargetHeight;
    public float mTargetRatioH;
    public float mTargetRatioW;
    public int mTargetWidth;
    public int mTargetXpos;
    public int mTargetYpos;
    public LinearLayout mTitleBar;
    public View mTitleBarMargin;
    public String mToastInfo;
    public View mTopView;

    /* loaded from: classes6.dex */
    public static class MyHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<IdCardActivity> mActivity;

        public MyHandler(IdCardActivity idCardActivity) {
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
            this.mActivity = new WeakReference<>(idCardActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IdCardActivity idCardActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (idCardActivity = this.mActivity.get()) == null) {
                return;
            }
            int i2 = message.what;
            if (i2 == 0) {
                LogUtil.i(IdCardActivity.TAG, "成功" + idCardActivity.mCurrentTimes + ";姓名=" + idCardActivity.mCardName + ";号码=" + idCardActivity.mCardNumber);
                idCardActivity.mCanShoot = false;
                idCardActivity.mHandler.sendEmptyMessage(6);
            } else if (i2 == 1) {
                LogUtil.i(IdCardActivity.TAG, "失败" + idCardActivity.mCurrentTimes);
                idCardActivity.mCanShoot = true;
                idCardActivity.mIsProcess = false;
                idCardActivity.mSurfaceView.autoFocus();
            } else if (i2 == 2) {
                idCardActivity.mIsStart = true;
            } else if (i2 == 3) {
                if (idCardActivity.mIsDebugForServer) {
                    idCardActivity.mHint.setText(idCardActivity.mDebugInfo);
                }
            } else if (i2 == 5) {
                idCardActivity.mIsStart = false;
                idCardActivity.mHandler.sendEmptyMessage(7);
            } else if (i2 != 6) {
                if (i2 != 7) {
                    return;
                }
                idCardActivity.release();
                IdCardController.getInstance().fail(0, null);
                idCardActivity.finish();
            } else {
                idCardActivity.release();
                Bundle bundle = new Bundle();
                bundle.putString("name", idCardActivity.mCardName);
                bundle.putString(IdCardActivity.KEY_IMG_PATH, idCardActivity.mCardRealPath);
                bundle.putString("number", idCardActivity.mCardNumber);
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
        this.mTargetRatioH = -1.0f;
        this.mTargetRatioW = -1.0f;
        this.mCardImagePath = "";
        this.mIsStart = false;
        this.mIsProcess = false;
        this.mCanShoot = true;
        this.mLastTime = 0L;
        this.mCurrentTimes = 0;
        this.mIsDebugForServer = false;
        this.mPermissionTest = null;
        this.mHandler = new MyHandler(this);
    }

    private JSONObject addParams(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, bitmap)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(UrlOcrConfig.IdCardKey.IDCARD_PIC, BitmapUtil.getBase64(bitmap));
                jSONObject.put(UrlOcrConfig.IdCardKey.METHODDATA, jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(UrlOcrConfig.IdCardKey.OS, "android");
                jSONObject3.put("osversion", Build.VERSION.RELEASE);
                jSONObject3.put("brand", Build.BRAND);
                jSONObject3.put("model", Build.MODEL);
                jSONObject3.put(UrlOcrConfig.IdCardKey.VERSION_CODE, Utils.getVersionCode(this.mContext));
                jSONObject3.put(UrlOcrConfig.IdCardKey.VERSION_NAME, Utils.getVersionName(this.mContext));
                jSONObject.put("channeldata", jSONObject3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    private boolean checkCardInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            String str = this.mCardName;
            return (str == null || str.equals("")) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void checkWritePermission(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, activity) == null) {
            if (PermissionManager.checkCallingPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                initActivity();
            } else {
                BaiduWalletUtils.requestPermissionsDialog(null, getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new BaiduWalletUtils.IRequestPermissionCallBack(this, activity) { // from class: com.baidu.wallet.base.iddetect.IdCardActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IdCardActivity this$0;
                    public final /* synthetic */ Activity val$activity;

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
                        this.this$0 = this;
                        this.val$activity = activity;
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            if (bool.booleanValue()) {
                                if (PermissionManager.checkCallingOrSelfPermission(this.val$activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1)) {
                                    return;
                                }
                                this.this$0.handleNoExternalStoragePermission();
                            } else if (Build.VERSION.SDK_INT >= 23) {
                                this.this$0.onRequestPermissionsResult(1, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new int[]{-1});
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
    public void dealData(byte[] bArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65561, this, bArr, i2, i3, i4) == null) || this.mIsProcess) {
            return;
        }
        this.mIsProcess = true;
        int i5 = this.mCurrentTimes;
        if (i5 >= 50) {
            this.mHandler.sendEmptyMessage(5);
            return;
        }
        this.mCurrentTimes = i5 + 1;
        Bitmap bitmapFromData = getBitmapFromData(bArr, i2, i3);
        this.mMaskBmp = bitmapFromData;
        Bitmap dealWithSmall = dealWithSmall(bitmapFromData);
        this.mCardBmp = dealWithSmall;
        saveFaceImage(dealWithSmall, this.mCardImagePath, "IdCard");
        IDDetectBean iDDetectBean = (IDDetectBean) IDDetectBeanFactory.getInstance().getBean((Context) this.mContext, IDDetectBeanFactory.BEAN_ID_ID_DETECT, TAG);
        iDDetectBean.setBeanParams(BitmapUtil.getBase64(this.mCardBmp));
        iDDetectBean.setResponseCallback(this);
        iDDetectBean.execBean();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d8 -> B:45:0x00e8). Please submit an issue!!! */
    private void dealResult(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, bArr) == null) {
            if (bArr != null && bArr.length != 0) {
                if (this.mIsDebugForServer) {
                    try {
                        this.mDebugInfo = new String(bArr, "UTF-8");
                        this.mHandler.sendEmptyMessage(3);
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
                try {
                    LogUtil.i(TAG, "dealResult=:" + new String(bArr, "UTF-8") + "data.length =" + bArr.length);
                    JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                    int optInt = jSONObject.optInt("status");
                    if (optInt == 0) {
                        if (!jSONObject.isNull("result")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                            String optString = jSONObject2.optString(UrlOcrConfig.IdCardKey.IDCARD_NO);
                            this.mCardNumber = optString;
                            if (TextUtils.isEmpty(optString)) {
                                this.mHandler.sendEmptyMessage(1);
                            } else if (IdcardUtils.validateIdCard18(this.mCardNumber)) {
                                this.mCardName = jSONObject2.optString("name");
                                if (checkCardInfo()) {
                                    this.mHandler.sendEmptyMessage(0);
                                } else {
                                    this.mHandler.sendEmptyMessage(1);
                                }
                            } else {
                                this.mHandler.sendEmptyMessage(1);
                            }
                        } else {
                            this.mHandler.sendEmptyMessage(1);
                        }
                    } else {
                        this.mHandler.sendEmptyMessage(1);
                        String optString2 = jSONObject.optString("msg");
                        if (optString2 != null) {
                            if (optInt == 2) {
                                LogUtil.d(TAG, "联网错误信息：" + optString2);
                            } else {
                                this.mToastInfo = optString2;
                                this.mHandler.sendEmptyMessage(4);
                            }
                        }
                    }
                } catch (Exception unused) {
                    this.mHandler.sendEmptyMessage(1);
                }
                return;
            }
            LogUtil.i(TAG, "data==null");
            this.mHandler.sendEmptyMessage(1);
        }
    }

    private Bitmap dealWithSmall(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, bitmap)) == null) {
            if (this.mTargetRatioH == -1.0f) {
                initRatio(bitmap.getWidth(), bitmap.getHeight());
            }
            return Bitmap.createBitmap(bitmap, this.mTargetXpos, this.mTargetYpos, this.mTargetWidth, this.mTargetHeight);
        }
        return (Bitmap) invokeL.objValue;
    }

    private Bitmap getBitmapFromData(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65564, this, bArr, i2, i3)) == null) ? Bitmap.createBitmap(ImageUtils.decodeYUV420SP(bArr, i2, i3), i2, i3, Bitmap.Config.ARGB_8888) : (Bitmap) invokeLII.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNoCamaraPermission() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            Bundle bundle = new Bundle();
            bundle.putString(RESULT_PERMISSION_KEY, "访问相机的权限");
            IdCardController.getInstance().fail(2, bundle);
            dialogPermission();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNoExternalStoragePermission() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            Bundle bundle = new Bundle();
            bundle.putString(RESULT_PERMISSION_KEY, "读写存储卡的权限");
            IdCardController.getInstance().fail(2, bundle);
            finish();
        }
    }

    private void initActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            try {
                setContentView(ResUtils.layout(this.mContext, "wallet_base_id_detect"));
                initView();
                initData();
            } catch (Exception unused) {
                dialogPermission();
            }
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            this.mScanFrame.startScan();
            findViewById(ResUtils.id(this.mContext, "back_btn")).setOnClickListener(this);
            this.mSurfaceView.setPreviewCallback(new SurfaceViewForScan.Callback(this) { // from class: com.baidu.wallet.base.iddetect.IdCardActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IdCardActivity this$0;

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
                    this.this$0 = this;
                }

                @Override // com.baidu.wallet.base.iddetect.view.SurfaceViewForScan.Callback
                public void onFrame(byte[] bArr, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLIII(1048576, this, bArr, i2, i3, i4) == null) && this.this$0.mIsStart && this.this$0.mIsResume && this.this$0.mCanShoot) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.this$0.mLastTime >= 200) {
                            this.this$0.mLastTime = currentTimeMillis;
                            this.this$0.dealData(bArr, i2, i3, i4);
                        }
                    }
                }
            });
            if (this.mCanShoot) {
                this.mHandler.sendEmptyMessageDelayed(2, 2000L);
            }
        }
    }

    private void initPermission(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, activity) == null) {
            if (PermissionManager.checkCallingPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                if (PermissionManager.checkCallingPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    initActivity();
                    return;
                } else {
                    BaiduWalletUtils.requestPermissionsDialog(null, getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new BaiduWalletUtils.IRequestPermissionCallBack(this, activity) { // from class: com.baidu.wallet.base.iddetect.IdCardActivity.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ IdCardActivity this$0;
                        public final /* synthetic */ Activity val$activity;

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
                            this.this$0 = this;
                            this.val$activity = activity;
                        }

                        @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                        public void isAllAgree(Boolean bool) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                                if (bool.booleanValue()) {
                                    if (PermissionManager.checkCallingOrSelfPermission(this.val$activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1)) {
                                        return;
                                    }
                                    this.this$0.handleNoExternalStoragePermission();
                                } else if (Build.VERSION.SDK_INT >= 23) {
                                    this.this$0.onRequestPermissionsResult(1, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new int[]{-1});
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
                public final /* synthetic */ IdCardActivity this$0;
                public final /* synthetic */ Activity val$activity;

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
                    this.this$0 = this;
                    this.val$activity = activity;
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isAllAgree(Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                        if (bool.booleanValue()) {
                            if (PermissionManager.checkCallingOrSelfPermission(this.val$activity, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 3)) {
                                return;
                            }
                            this.this$0.handleNoCamaraPermission();
                        } else if (Build.VERSION.SDK_INT >= 23) {
                            this.this$0.onRequestPermissionsResult(3, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, new int[]{-1});
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

    private void initRatio(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65570, this, i2, i3) == null) {
            this.mTargetRatioH = (i3 * 1.0f) / this.mSurfaceView.getHeight();
            float width = (i2 * 1.0f) / this.mSurfaceView.getWidth();
            this.mTargetRatioW = width;
            this.mTargetXpos = (int) (width * this.mLeftView.getWidth());
            this.mTargetYpos = (int) (this.mTargetRatioH * (this.mTopView.getHeight() + this.mTitleBar.getHeight()));
            this.mTargetWidth = (int) (this.mTargetRatioW * this.mScanFrame.getWidth());
            this.mTargetHeight = (int) (this.mTargetRatioH * this.mScanFrame.getHeight());
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            SurfaceViewForScan surfaceViewForScan = (SurfaceViewForScan) findViewById(ResUtils.id(this.mContext, "surface_view"));
            this.mSurfaceView = surfaceViewForScan;
            surfaceViewForScan.setAttachedActivity(this);
            LaserScannerForScan laserScannerForScan = (LaserScannerForScan) findViewById(ResUtils.id(this.mContext, ExecutionState.FRAME));
            this.mScanFrame = laserScannerForScan;
            laserScannerForScan.setAttachedActivity(this);
            this.mTopView = findViewById(ResUtils.id(this.mContext, "view_top"));
            this.mLeftView = findViewById(ResUtils.id(this.mContext, "view_left"));
            this.mTitleBar = (LinearLayout) findViewById(ResUtils.id(this.mContext, "title_bar"));
            this.mHint = (TextView) findViewById(ResUtils.id(this.mContext, TrackReferenceTypeBox.TYPE1));
            View findViewById = findViewById(ResUtils.id(getActivity(), "title_bar_margin"));
            this.mTitleBarMargin = findViewById;
            setTop(findViewById);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            this.mScanFrame.stopScan();
            this.mSurfaceView.setPreviewCallback(null);
            this.mSurfaceView.releaseSource();
        }
    }

    private void saveFaceImage(Bitmap bitmap, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65573, this, bitmap, str, str2) == null) {
            File cacheDirectory = StorageUtils.getCacheDirectory(getActivity());
            if (!cacheDirectory.exists()) {
                cacheDirectory.mkdirs();
            }
            String str3 = cacheDirectory.getAbsolutePath() + File.separator + str2 + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
            File file = new File(str3);
            if (file.exists()) {
                file.delete();
            }
            System.out.println(str3);
            BitmapUtil.saveImage(this.mContext, bitmap, str3, Bitmap.CompressFormat.JPEG, 70);
            this.mCardRealPath = str3;
        }
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
            this.mHandler.sendEmptyMessage(1);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) && i2 == 57345) {
            if (obj != null && (obj instanceof IDDetectResponse)) {
                IDDetectResponse iDDetectResponse = (IDDetectResponse) obj;
                if (!TextUtils.isEmpty(iDDetectResponse.name) && !TextUtils.isEmpty(iDDetectResponse.id_card) && IdcardUtils.validateIdCard18(iDDetectResponse.id_card)) {
                    this.mCardName = iDDetectResponse.name;
                    this.mCardNumber = iDDetectResponse.id_card;
                    this.mHandler.sendEmptyMessage(0);
                    return;
                }
            }
            this.mHandler.sendEmptyMessage(1);
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
            this.mHandler.sendEmptyMessage(7);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view) == null) && view.getId() == ResUtils.id(this.mContext, "back_btn")) {
            this.mHandler.sendEmptyMessage(7);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            this.mContext = getActivity();
            initPermission(getActivity());
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
            this.mIsResume = false;
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
                    public final /* synthetic */ IdCardActivity this$0;

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
                        this.this$0 = this;
                    }

                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            Bundle bundle = new Bundle();
                            if (PermissionManager.checkCallingPermission(this.this$0.getActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                                IdCardController.getInstance().fail(3, null);
                            } else {
                                bundle.putString(IdCardActivity.RESULT_PERMISSION_KEY, "访问相机的权限");
                                IdCardController.getInstance().fail(2, bundle);
                            }
                            this.this$0.finish();
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
                    initActivity();
                } else {
                    handleNoExternalStoragePermission();
                }
            } else if (i2 != 3) {
            } else {
                if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                    checkWritePermission(getActivity());
                } else {
                    handleNoCamaraPermission();
                }
            }
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            this.mIsResume = true;
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
}
