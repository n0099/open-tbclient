package com.baidu.wallet.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes8.dex */
public class SoftKeyBoardListener implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener;
    public View rootView;
    public int rootViewVisibleHeight;

    /* loaded from: classes8.dex */
    public interface OnSoftKeyBoardChangeListener {
        void keyBoardHide(int i2);

        void keyBoardShow(int i2);
    }

    public SoftKeyBoardListener(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View decorView = activity.getWindow().getDecorView();
        this.rootView = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.wallet.utils.SoftKeyBoardListener.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SoftKeyBoardListener f63355a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f63355a = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    Rect rect = new Rect();
                    this.f63355a.rootView.getWindowVisibleDisplayFrame(rect);
                    int height = rect.height();
                    SoftKeyBoardListener softKeyBoardListener = this.f63355a;
                    int i4 = softKeyBoardListener.rootViewVisibleHeight;
                    if (i4 == 0) {
                        softKeyBoardListener.rootViewVisibleHeight = height;
                    } else if (i4 == height) {
                    } else {
                        if (i4 - height > 200) {
                            if (softKeyBoardListener.onSoftKeyBoardChangeListener != null) {
                                this.f63355a.onSoftKeyBoardChangeListener.keyBoardShow(this.f63355a.rootViewVisibleHeight - height);
                            }
                            this.f63355a.rootViewVisibleHeight = height;
                        } else if (height - i4 > 200) {
                            if (softKeyBoardListener.onSoftKeyBoardChangeListener != null) {
                                this.f63355a.onSoftKeyBoardChangeListener.keyBoardHide(height - this.f63355a.rootViewVisibleHeight);
                            }
                            this.f63355a.rootViewVisibleHeight = height;
                        }
                    }
                }
            }
        });
    }

    public static void setListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, onSoftKeyBoardChangeListener) == null) {
            new SoftKeyBoardListener(activity).setOnSoftKeyBoardChangeListener(onSoftKeyBoardChangeListener);
        }
    }

    private void setOnSoftKeyBoardChangeListener(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, onSoftKeyBoardChangeListener) == null) {
            this.onSoftKeyBoardChangeListener = onSoftKeyBoardChangeListener;
        }
    }
}
