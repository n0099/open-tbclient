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
    public static final String f23897e = BankCardDetectionActivity.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    public MistView f23898f;

    /* renamed from: i  reason: collision with root package name */
    public BankCardProcessing f23901i;

    /* renamed from: g  reason: collision with root package name */
    public View f23899g = null;

    /* renamed from: h  reason: collision with root package name */
    public View f23900h = null;
    public AtomicInteger j = new AtomicInteger(0);

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public void destroyProcessor() {
        if (this.f23901i != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (2 <= i2 || 1 == this.j.intValue()) {
                    break;
                }
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                i2 = i3;
            }
            if (1 == this.j.intValue()) {
                this.j.set(3);
                this.f23901i.release();
                this.f23901i = null;
                return;
            }
            String str = f23897e;
            LogUtil.w(str, "destroyProcessor() Classifyer state=" + this.j.intValue());
        }
    }

    public int dip2pixel(float f2) {
        return (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public View getCustomizedView() {
        MistView mistView = (MistView) View.inflate(this, ResUtils.layout(getActivity(), "wallet_bankcard_detection_activity"), null);
        this.f23898f = mistView;
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
    public int getRecycledBufSize(int i2, int i3) {
        return i2 * i3 * 3;
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public boolean initProcessor() {
        try {
            BankCardProcessing.init(CameraBaseActivity.getToken());
            BankCardProcessing bankCardProcessing = BankCardProcessing.getInstance();
            this.f23901i = bankCardProcessing;
            if (bankCardProcessing.init(getAssets(), PathUtils.model_path, PathUtils.mean_path, PathUtils.dtc_model_path_fst, PathUtils.dtc_mean_path_fst, PathUtils.dtc_model_path_scd, PathUtils.dtc_mean_path_scd, PathUtils.captcha_path) < 0) {
                LogUtil.e(f23897e, "Model initialization failure.", null);
                this.f23901i = null;
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

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
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

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = f23897e;
        LogUtil.i(str, "onCreate(" + bundle + SmallTailInfo.EMOTION_SUFFIX);
        this.f23899g = findViewById(ResUtils.id(getActivity(), "focus_view"));
        this.f23900h = findViewById(ResUtils.id(getActivity(), "flash_light_switch"));
        if (CameraCtrl.isSupprtFlashLight(getPackageManager())) {
            this.f23900h.setOnClickListener(this);
            this.f23900h.setVisibility(0);
            AccessibilityUtils.setContentDescription(this.f23900h, "打开闪光灯");
        } else {
            this.f23900h.setVisibility(4);
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
    public Object[] processImage(byte[] bArr, int i2, int i3, Rect rect, byte[] bArr2) {
        if (1 != this.j.intValue()) {
            return null;
        }
        this.j.set(2);
        Yuv.rotateCrop(bArr, i2, i3, rect, 270, bArr2);
        BCResult runBankCardProcess = this.f23901i.runBankCardProcess(bArr2, rect.width(), rect.height(), 1, 1, rect.height() - 1, rect.width() - 1, 1, false);
        this.j.set(1);
        if (runBankCardProcess == null || !runBankCardProcess.bFlag) {
            return null;
        }
        return new BCResult[]{runBankCardProcess};
    }

    @Override // com.baidu.wallet.base.camera.IImageProcess
    public Object[] processImageJpegData(byte[] bArr, int i2, int i3) {
        return null;
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void relayoutUi() {
        ViewGroup.LayoutParams layoutParams = this.f23899g.getLayoutParams();
        int width = this.f23899g.getWidth();
        layoutParams.width = width;
        layoutParams.height = Math.round(width * getFocusDataYXRatioal() * this.mScaleCoefficient);
        this.f23899g.setLayoutParams(layoutParams);
        this.f23899g.requestLayout();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        this.mPreviewView.getLocationOnScreen(iArr2);
        this.f23899g.getLocationOnScreen(iArr);
        Rect rect = this.mFocusViewRect;
        int i2 = iArr[0] - iArr2[0];
        rect.left = i2;
        rect.right = i2 + layoutParams.width;
        int i3 = iArr[1] - iArr2[1];
        rect.top = i3;
        rect.bottom = i3 + layoutParams.height;
        this.f23898f.getFocusFrame().set(this.mFocusViewRect);
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void setFocusRectValue(Rect rect) {
    }

    @Override // com.baidu.wallet.base.camera.CameraBaseActivity
    public void updateFlashLightUi(boolean z) {
        if (this.f23900h == null) {
            return;
        }
        this.f23900h.setBackgroundResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
        AccessibilityUtils.setContentDescription(this.f23900h, z ? "关闭闪光灯" : "打开闪光灯");
    }
}
