package com.baidu.wallet.bankdetection;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.bankdetection.BCResult;
import com.baidu.bankdetection.BankCardProcessing;
import com.baidu.bankdetection.PathUtils;
import com.baidu.idl.authority.AlgorithmOnMainThreadException;
import com.baidu.idl.authority.IDLAuthorityException;
import com.baidu.wallet.base.camera.CameraBaseActivity;
import com.baidu.wallet.base.camera.IImageProcess;
import com.baidu.wallet.base.camera.internal.CameraCtrl;
import com.baidu.wallet.base.camera.internal.Yuv;
import com.baidu.wallet.base.widget.MistView;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.utils.AccessibilityUtils;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes14.dex */
public class BankCardDetectionActivity extends CameraBaseActivity implements View.OnClickListener, IImageProcess {
    private static final String e = BankCardDetectionActivity.class.getSimpleName();
    private MistView f;
    private BankCardProcessing i;
    private View g = null;
    private View h = null;
    private AtomicInteger j = new AtomicInteger(0);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtil.i(e, "onCreate(" + bundle + ")");
        this.g = findViewById(ResUtils.id(getActivity(), "focus_view"));
        this.h = findViewById(ResUtils.id(getActivity(), "flash_light_switch"));
        if (CameraCtrl.isSupprtFlashLight(getPackageManager())) {
            this.h.setOnClickListener(this);
            this.h.setVisibility(0);
            AccessibilityUtils.setContentDescription(this.h, "打开闪光灯");
        } else {
            this.h.setVisibility(4);
        }
        findViewById(ResUtils.id(getActivity(), "title_back")).setOnClickListener(this);
        findViewById(ResUtils.id(getActivity(), "manal_input_prompt")).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (ResUtils.id(getActivity(), "flash_light_switch") == id) {
            triggerFlash();
        } else if (ResUtils.id(getActivity(), "manal_input_prompt") == id) {
            PayStatisticsUtil.onEvent("manualInputBankCard");
            BankcardDetectionController.getInstance().update(null, "");
            finish();
            overridePendingTransition(0, 0);
        } else if (ResUtils.id(getActivity(), "title_back") == id) {
            PayStatisticsUtil.onEvent("exitBankCardDetection");
            BankcardDetectionController.getInstance().updateFail(-2, "");
            finish();
            overridePendingTransition(0, 0);
        }
    }

    public void onBackPressed() {
        PayStatisticsUtil.onEvent("exitBankCardDetection");
        BankcardDetectionController.getInstance().updateFail(-2, "");
        super.onBackPressed();
    }

    public int dip2pixel(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public void setFocusRectValue(Rect rect) {
    }

    public void relayoutUi() {
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        layoutParams.width = this.g.getWidth();
        layoutParams.height = Math.round(layoutParams.width * getFocusDataYXRatioal() * this.mScaleCoefficient);
        this.g.setLayoutParams(layoutParams);
        this.g.requestLayout();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        this.mPreviewView.getLocationOnScreen(iArr2);
        this.g.getLocationOnScreen(iArr);
        this.mFocusViewRect.left = iArr[0] - iArr2[0];
        this.mFocusViewRect.right = this.mFocusViewRect.left + layoutParams.width;
        this.mFocusViewRect.top = iArr[1] - iArr2[1];
        this.mFocusViewRect.bottom = layoutParams.height + this.mFocusViewRect.top;
        this.f.getFocusFrame().set(this.mFocusViewRect);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.wallet.bankdetection.BankCardDetectionActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public View getCustomizedView() {
        MistView inflate = View.inflate(this, ResUtils.layout(getActivity(), "wallet_bankcard_detection_activity"), null);
        this.f = inflate;
        return inflate;
    }

    public void updateFlashLightUi(boolean z) {
        if (this.h != null) {
            this.h.setBackgroundResource(ResUtils.drawable(getActivity(), z ? "wallet_base_camera_flashlight_on_btn" : "wallet_base_camera_flashlight_off_btn"));
            AccessibilityUtils.setContentDescription(this.h, z ? "关闭闪光灯" : "打开闪光灯");
        }
    }

    public IImageProcess getImageProcessor() {
        return this;
    }

    public float getFocusDataYXRatioal() {
        return 0.631f;
    }

    public void onProcessImageOk(Object[] objArr) {
        final BCResult bCResult = (BCResult) objArr[0];
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.wallet.bankdetection.BankCardDetectionActivity.1
            @Override // java.lang.Runnable
            public void run() {
                EventBus eventBus = EventBus.getInstance();
                eventBus.getClass();
                eventBus.postStickyEvent(new EventBus.Event(eventBus, "BankCardResult", bCResult));
                BankCardDetectionActivity.this.startActivityForResult(new Intent(BankCardDetectionActivity.this.getActivity(), BankCardResultActivity.class), IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER);
                BankCardDetectionActivity.this.overridePendingTransition(0, 0);
            }
        });
    }

    public boolean initProcessor() {
        try {
            BankCardProcessing.init(getToken());
            this.i = BankCardProcessing.getInstance();
            if (this.i.init(getAssets(), PathUtils.model_path, PathUtils.mean_path, PathUtils.dtc_model_path_fst, PathUtils.dtc_mean_path_fst, PathUtils.dtc_model_path_scd, PathUtils.dtc_mean_path_scd, PathUtils.captcha_path) < 0) {
                LogUtil.e(e, "Model initialization failure.", (Throwable) null);
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

    public Object[] processImageJpegData(byte[] bArr, int i, int i2) {
        return null;
    }

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
                    i = i2;
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    i = i2;
                }
            }
            if (1 == this.j.intValue()) {
                this.j.set(3);
                this.i.release();
                this.i = null;
                return;
            }
            LogUtil.w(e, "destroyProcessor() Classifyer state=" + this.j.intValue());
        }
    }

    public int getRecycledBufSize(int i, int i2) {
        return i * i2 * 3;
    }

    public void onPermissionDenied() {
        BankcardDetectionController.getInstance().updateFail(-1, "no camera permission");
    }
}
