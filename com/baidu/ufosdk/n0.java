package com.baidu.ufosdk;

import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes6.dex */
public class n0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FeedbackEditActivity a;

    public n0(FeedbackEditActivity feedbackEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            FeedbackEditActivity feedbackEditActivity = this.a;
            if (feedbackEditActivity.x) {
                return;
            }
            String obj = feedbackEditActivity.m.getText().toString();
            if (obj != null && obj.trim().length() > 0) {
                this.a.a.putString("cryptContactData", b.b(obj));
            } else {
                this.a.a.putString("cryptContactData", "");
            }
            this.a.a.commit();
            FeedbackEditActivity feedbackEditActivity2 = this.a;
            if (!feedbackEditActivity2.x) {
                if (feedbackEditActivity2.m.getText().toString().trim().length() > 30) {
                    Toast.makeText(feedbackEditActivity2, t1.a(PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK), 0).show();
                } else if (!feedbackEditActivity2.O) {
                    Toast.makeText(feedbackEditActivity2, "请勾选投诉须知", 0).show();
                } else if (feedbackEditActivity2.l.getText().toString().trim().length() < 8) {
                    Toast.makeText(feedbackEditActivity2, t1.a("37"), 0).show();
                } else if (feedbackEditActivity2.l.getText().toString().trim().length() > 200) {
                    Toast.makeText(feedbackEditActivity2, t1.a("16"), 0).show();
                } else if (!p1.e(feedbackEditActivity2)) {
                    Toast.makeText(feedbackEditActivity2, t1.a("19"), 1).show();
                } else if (TextUtils.isEmpty(feedbackEditActivity2.K.b)) {
                    Toast.makeText(feedbackEditActivity2, t1.a("18"), 1).show();
                    feedbackEditActivity2.K.a(false);
                } else {
                    if (feedbackEditActivity2.getCurrentFocus() != null && feedbackEditActivity2.getCurrentFocus().getWindowToken() != null) {
                        ((InputMethodManager) feedbackEditActivity2.getSystemService("input_method")).hideSoftInputFromWindow(feedbackEditActivity2.getCurrentFocus().getWindowToken(), 2);
                    }
                    feedbackEditActivity2.w.setVisibility(0);
                    feedbackEditActivity2.w.bringToFront();
                    feedbackEditActivity2.x = true;
                    feedbackEditActivity2.i.setTextColor(-6710887);
                    new Thread(new s0(feedbackEditActivity2)).start();
                }
            }
        }
    }
}
