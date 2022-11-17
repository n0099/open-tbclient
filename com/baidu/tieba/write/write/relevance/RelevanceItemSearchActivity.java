package com.baidu.tieba.write.write.relevance;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.sf5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class RelevanceItemSearchActivity extends SuspendedActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelevanceItemSearchView k;

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public RelevanceItemSearchActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public RelevanceItemSearchView d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.k;
        }
        return (RelevanceItemSearchView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            RelevanceItemSearchView relevanceItemSearchView = this.k;
            if (relevanceItemSearchView != null) {
                relevanceItemSearchView.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public sf5 N0(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, linearLayout, navigationBar)) == null) {
            RelevanceItemSearchView relevanceItemSearchView = new RelevanceItemSearchView(this, linearLayout, navigationBar);
            this.k = relevanceItemSearchView;
            return relevanceItemSearchView;
        }
        return (sf5) invokeLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                View currentFocus = getCurrentFocus();
                if (f1(currentFocus, motionEvent) && (inputMethodManager = (InputMethodManager) getSystemService("input_method")) != null) {
                    inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                }
                return super.dispatchTouchEvent(motionEvent);
            } else if (getWindow().superDispatchTouchEvent(motionEvent)) {
                return true;
            } else {
                return onTouchEvent(motionEvent);
            }
        }
        return invokeL.booleanValue;
    }

    public boolean f1(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view2, motionEvent)) == null) {
            if (view2 == null || !(view2 instanceof EditText)) {
                return false;
            }
            int[] iArr = {0, 0};
            view2.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int height = view2.getHeight() + i2;
            int width = view2.getWidth() + i;
            if (motionEvent.getX() > i && motionEvent.getX() < width && motionEvent.getY() > i2 && motionEvent.getY() < height) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
