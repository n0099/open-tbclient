package com.baidu.tieba.write.write.relevance;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.s85;
/* loaded from: classes4.dex */
public class RelevanceItemSearchActivity extends SuspendedActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelevanceItemSearchView mSearchView;

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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                View currentFocus = getCurrentFocus();
                if (isShouldHideInput(currentFocus, motionEvent) && (inputMethodManager = (InputMethodManager) getSystemService("input_method")) != null) {
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

    public RelevanceItemSearchView getSearchView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSearchView : (RelevanceItemSearchView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public s85 getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, linearLayout, navigationBar)) == null) {
            RelevanceItemSearchView relevanceItemSearchView = new RelevanceItemSearchView(this, linearLayout, navigationBar);
            this.mSearchView = relevanceItemSearchView;
            return relevanceItemSearchView;
        }
        return (s85) invokeLL.objValue;
    }

    public boolean isShouldHideInput(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, motionEvent)) == null) {
            if (view2 == null || !(view2 instanceof EditText)) {
                return false;
            }
            int[] iArr = {0, 0};
            view2.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            return motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) (view2.getWidth() + i)) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) (view2.getHeight() + i2));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            RelevanceItemSearchView relevanceItemSearchView = this.mSearchView;
            if (relevanceItemSearchView != null) {
                relevanceItemSearchView.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }
}
