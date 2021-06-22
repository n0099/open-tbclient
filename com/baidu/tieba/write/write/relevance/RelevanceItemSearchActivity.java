package com.baidu.tieba.write.write.relevance;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import d.a.n0.t0.a;
/* loaded from: classes5.dex */
public class RelevanceItemSearchActivity extends SuspendedActivity {
    public RelevanceItemSearchView mSearchView;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
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

    public RelevanceItemSearchView getSearchView() {
        return this.mSearchView;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        RelevanceItemSearchView relevanceItemSearchView = new RelevanceItemSearchView(this, linearLayout, navigationBar);
        this.mSearchView = relevanceItemSearchView;
        return relevanceItemSearchView;
    }

    public boolean isShouldHideInput(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        return motionEvent.getX() <= ((float) i2) || motionEvent.getX() >= ((float) (view.getWidth() + i2)) || motionEvent.getY() <= ((float) i3) || motionEvent.getY() >= ((float) (view.getHeight() + i3));
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        RelevanceItemSearchView relevanceItemSearchView = this.mSearchView;
        if (relevanceItemSearchView != null) {
            relevanceItemSearchView.p();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
    }
}
