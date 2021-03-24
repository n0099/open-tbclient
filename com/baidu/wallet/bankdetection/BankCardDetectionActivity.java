package com.baidu.wallet.bankdetection;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.bankdetection.BCResult;
import com.baidu.bankdetection.BankCardProcessing;
import com.baidu.bankdetection.PathUtils;
import com.baidu.idl.authority.AlgorithmOnMainThreadException;
import com.baidu.idl.authority.IDLAuthorityException;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.wallet.base.camera.CameraBaseActivity;
import com.baidu.wallet.base.camera.IImageProcess;
import com.baidu.wallet.base.camera.internal.CameraCtrl;
import com.baidu.wallet.base.camera.internal.Yuv;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.MistView;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.utils.AccessibilityUtils;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class BankCardDetectionActivity extends CameraBaseActivity implements View.OnClickListener, IImageProcess {

    /* renamed from: e  reason: collision with root package name */
    public static final String f23490e = BankCardDetectionActivity.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    public MistView f23491f;
    public BankCardProcessing i;

    /* renamed from: g  reason: collision with root package name */
    public View f23492g = null;

    /* renamed from: h  reason: collision with root package name */
    public View f23493h = null;
    public AtomicInteger j = new AtomicInteger(0);

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public void destroyProcessor() {
        if (this.i != null) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (2 <= i || 1 == this.j.intValue()) {
                    break;
                }
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                i = i2;
            }
            if (1 == this.j.intValue()) {
                this.j.set(3);
                this.i.release();
                this.i = null;
                return;
            }
            String str = f23490e;
            LogUtil.w(str, "destroyProcessor() Classifyer state=" + this.j.intValue());
        }
    }

    public int dip2pixel(float f2) {
        return (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public View getCustomizedView() {
        MistView mistView = (MistView) View.inflate(this, ResUtils.layout(getActivity(), "wallet_bankcard_detection_activity"), null);
        this.f23491f = mistView;
        return mistView;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public float getFocusDataYXRatioal() {
        return 0.631f;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public IImageProcess getImageProcessor() {
        return this;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public int getRecycledBufSize(int i, int i2) {
        return i * i2 * 3;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public boolean initProcessor() {
        try {
            BankCardProcessing.init(CameraBaseActivity.getToken());
            BankCardProcessing bankCardProcessing = BankCardProcessing.getInstance();
            this.i = bankCardProcessing;
            if (bankCardProcessing.init(getAssets(), PathUtils.model_path, PathUtils.mean_path, PathUtils.dtc_model_path_fst, PathUtils.dtc_mean_path_fst, PathUtils.dtc_model_path_scd, PathUtils.dtc_mean_path_scd, PathUtils.captcha_path) < 0) {
                LogUtil.e(f23490e, "Model initialization failure.", null);
                this.i = null;
                return false;
            }
            this.j.set(1);
            return true;
        } catch (AlgorithmOnMainThreadException e2) {
            e2.printStackTrace();
            return false;
        } catch (IDLAuthorityException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        PayStatisticsUtil.onEvent(StatServiceEvent.STAT_EXITDETECT);
        BankcardDetectionController.getInstance().updateFail(-2, "");
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (ResUtils.id(getActivity(), "flash_light_switch") == id) {
            triggerFlash();
        } else if (ResUtils.id(getActivity(), "manal_input_prompt") == id) {
            PayStatisticsUtil.onEvent(StatServiceEvent.STAT_MANUAINPUT);
            BankcardDetectionController.getInstance().update(null, "");
            finish();
            overridePendingTransition(0, 0);
        } else if (ResUtils.id(getActivity(), "title_back") == id) {
            PayStatisticsUtil.onEvent(StatServiceEvent.STAT_EXITDETECT);
            BankcardDetectionController.getInstance().updateFail(-2, "");
            finish();
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = f23490e;
        LogUtil.i(str, "onCreate(" + bundle + SmallTailInfo.EMOTION_SUFFIX);
        this.f23492g = findViewById(ResUtils.id(getActivity(), "focus_view"));
        this.f23493h = findViewById(ResUtils.id(getActivity(), "flash_light_switch"));
        if (CameraCtrl.isSupprtFlashLight(getPackageManager())) {
            this.f23493h.setOnClickListener(this);
            this.f23493h.setVisibility(0);
            AccessibilityUtils.setContentDescription(this.f23493h, "打开闪光灯");
        } else {
            this.f23493h.setVisibility(4);
        }
        findViewById(ResUtils.id(getActivity(), "title_back")).setOnClickListener(this);
        findViewById(ResUtils.id(getActivity(), "manal_input_prompt")).setOnClickListener(this);
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onPermissionDenied() {
        BankcardDetectionController.getInstance().updateFail(-1, "no camera permission");
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void onProcessImageOk(Object[] objArr) {
        final BCResult bCResult = (BCResult) objArr[0];
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.wallet.bankdetection.BankCardDetectionActivity.1
            @Override // java.lang.Runnable
            public void run() {
                EventBus eventBus = EventBus.getInstance();
                eventBus.getClass();
                eventBus.postStickyEvent(new EventBus.Event("BankCardResult", bCResult));
                BankCardDetectionActivity.this.startActivityForResult(new Intent(BankCardDetectionActivity.this.getActivity(), BankCardResultActivity.class), 132);
                BankCardDetectionActivity.this.overridePendingTransition(0, 0);
            }
        });
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImage(byte[] bArr, int i, int i2, Rect rect, byte[] bArr2) {
        if (1 != this.j.intValue()) {
            return null;
        }
        this.j.set(2);
        Yuv.rotateCrop(bArr, i, i2, rect, 270, bArr2);
        BCResult runBankCardProcess = this.i.runBankCardProcess(bArr2, rect.width(), rect.height(), 1, 1, rect.height() - 1, rect.width() - 1, 1, false);
        this.j.set(1);
        if (runBankCardProcess == null || !runBankCardProcess.bFlag) {
            return null;
        }
        return new BCResult[]{runBankCardProcess};
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImageJpegData(byte[] bArr, int i, int i2) {
        return null;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void relayoutUi() {
        ViewGroup.LayoutParams layoutParams = this.f23492g.getLayoutParams();
        int width = this.f23492g.getWidth();
        layoutParams.width = width;
        layoutParams.height = Math.round(width * getFocusDataYXRatioal() * this.mScaleCoefficient);
        this.f23492g.setLayoutParams(layoutParams);
        this.f23492g.requestLayout();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        this.mPreviewView.getLocationOnScreen(iArr2);
        this.f23492g.getLocationOnScreen(iArr);
        Rect rect = this.mFocusViewRect;
        int i = iArr[0] - iArr2[0];
        rect.left = i;
        rect.right = i + layoutParams.width;
        int i2 = iArr[1] - iArr2[1];
        rect.top = i2;
        rect.bottom = i2 + layoutParams.height;
        this.f23491f.getFocusFrame().set(this.mFocusViewRect);
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void setFocusRectValue(Rect rect) {
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void updateFlashLightUi(boolean z) {
        if (this.f23493h == null) {
            return;
        }
        this.f23493h.setBackgroundResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
        AccessibilityUtils.setContentDescription(this.f23493h, z ? "关闭闪光灯" : "打开闪光灯");
    }
}
