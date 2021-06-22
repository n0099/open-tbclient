package com.baidu.wallet.core;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alipay.sdk.widget.j;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.FragmentResultReceiver;
import com.baidu.wallet.core.utils.FragmentUtils;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class BaseFragment extends SDKBaseFragment implements FragmentResultReceiver.a, NoProguard {
    public static final boolean DEBUG = false;
    public static final String EXTRA_FRAGMENT_RESULT_RECEIVER = "fragment result receiver";
    public static final String EXTRA_REQUEST_CODE = "request code";
    public static final String EXTRA_RESULT_CODE = "result code";
    public static final int MSG_RESPONSE_FAILURE = 2;
    public static final int MSG_RESPONSE_SUCCESS = 1;
    public static final String TAG_BASE = "BaseFragment";
    public BaseActivity mAct;
    public long mTimeVal;
    public ResultReceiver mReceiver = null;
    public int mRequestId = -1;
    public boolean mDestroyAct = true;

    public static String getClassFileLineMethod(String str) {
        StackTraceElement stackTraceElement = new Exception().getStackTrace()[1];
        StringBuilder sb = new StringBuilder();
        if (str != null && str.length() > 0) {
            sb.append(str);
            sb.append(": ");
        }
        sb.append(PreferencesUtil.LEFT_MOUNT);
        sb.append(stackTraceElement.getFileName());
        sb.append(" | ");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(" | ");
        sb.append(stackTraceElement.getMethodName());
        sb.append("()");
        sb.append(PreferencesUtil.RIGHT_MOUNT);
        return sb.toString();
    }

    public static void logFragmentStack(FragmentManager fragmentManager) {
    }

    public void finish() {
        finish(this.mDestroyAct);
    }

    public boolean getDestroyActFlag() {
        return this.mDestroyAct;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.mTimeVal = System.currentTimeMillis();
        super.onCreate(bundle);
        if (this.mAct != null) {
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(getClass().getSimpleName(), "push"));
            PayStatisticsUtil.onPush(getClass().getSimpleName());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(EXTRA_FRAGMENT_RESULT_RECEIVER) && arguments.containsKey(EXTRA_REQUEST_CODE)) {
            this.mReceiver = (ResultReceiver) getArguments().getParcelable(EXTRA_FRAGMENT_RESULT_RECEIVER);
            this.mRequestId = getArguments().getInt(EXTRA_REQUEST_CODE);
        }
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.mAct != null) {
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(getClass().getSimpleName(), j.j));
            PayStatisticsUtil.onBack(getClass().getSimpleName());
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ResultReceiver resultReceiver = this.mReceiver;
        if (resultReceiver != null && (resultReceiver instanceof FragmentResultReceiver)) {
            ((FragmentResultReceiver) resultReceiver).a();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        this.mAct = null;
        super.onDetach();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        if (this.mAct != null) {
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(getClass().getSimpleName(), "out"));
            PayStatisticsUtil.onOut(getClass().getSimpleName());
        }
        super.onPause();
    }

    @Override // com.baidu.wallet.core.FragmentResultReceiver.a
    public void onReceiveResult(int i2, Bundle bundle) {
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BaseActivity baseActivity = this.mAct;
        if (baseActivity != null) {
            baseActivity.getApplicationContext();
            if (0 != this.mTimeVal) {
                long currentTimeMillis = System.currentTimeMillis() - this.mTimeVal;
                DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(getClass().getSimpleName(), "in", String.valueOf(this.mTimeVal)));
                PayStatisticsUtil.onIn(getClass().getSimpleName(), currentTimeMillis);
                this.mTimeVal = 0L;
                return;
            }
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(getClass().getSimpleName(), "in", String.valueOf(0)));
            PayStatisticsUtil.onIn(getClass().getSimpleName(), 0L);
        }
    }

    public void popBackFragment(int i2, boolean z) {
        FragmentManager supportFragmentManager;
        BaseActivity baseActivity = this.mAct;
        if (baseActivity == null || baseActivity.getActivity() == null || (supportFragmentManager = ((FragmentActivity) this.mAct.getActivity()).getSupportFragmentManager()) == null) {
            return;
        }
        logFragmentStack(supportFragmentManager);
        while (i2 > 0 && this.mAct != null) {
            if (!FragmentUtils.popBackStackImmediate(supportFragmentManager)) {
                if (z) {
                    this.mAct.finish();
                    return;
                }
                return;
            }
            i2--;
        }
    }

    @Override // com.baidu.wallet.core.SDKBaseFragment
    public void setActivity(BaseActivity baseActivity) {
        this.mAct = baseActivity;
    }

    public void setResult(Bundle bundle) {
        ResultReceiver resultReceiver = this.mReceiver;
        if (resultReceiver != null) {
            resultReceiver.send(this.mRequestId, bundle);
        }
    }

    public void setUnDestroyActFlag() {
        this.mDestroyAct = false;
    }

    public void finish(boolean z) {
        popBackFragment(1, z);
    }
}
