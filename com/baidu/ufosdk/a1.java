package com.baidu.ufosdk;

import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.FeedbackReportActivity;
/* loaded from: classes6.dex */
public class a1 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FeedbackReportActivity a;

    public a1(FeedbackReportActivity feedbackReportActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackReportActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            FeedbackReportActivity feedbackReportActivity = this.a;
            if (feedbackReportActivity.A) {
                return;
            }
            String obj = feedbackReportActivity.t.getText().toString();
            if (obj != null && obj.trim().length() > 0) {
                this.a.a.putString("cryptContactData", b.b(obj));
            } else {
                this.a.a.putString("cryptContactData", "");
            }
            this.a.a.commit();
            FeedbackReportActivity feedbackReportActivity2 = this.a;
            if (feedbackReportActivity2.A) {
                return;
            }
            if (feedbackReportActivity2.S.d.size() == 0) {
                Toast.makeText(feedbackReportActivity2, "请选择举报内容问题", 0).show();
            } else if (feedbackReportActivity2.S.d.size() == 1 && feedbackReportActivity2.S.d.get(0).contains("其他") && feedbackReportActivity2.s.getText().toString().isEmpty()) {
                Toast.makeText(feedbackReportActivity2, "请填写更多问题和建议", 0).show();
            } else {
                if (feedbackReportActivity2.l == 1) {
                    if (feedbackReportActivity2.f.getText().toString().trim().length() < 5) {
                        Toast.makeText(feedbackReportActivity2, t1.a("33"), 0).show();
                        return;
                    } else if (feedbackReportActivity2.w.size() <= 1) {
                        Toast.makeText(feedbackReportActivity2, t1.a("34"), 0).show();
                        return;
                    }
                }
                if (feedbackReportActivity2.m) {
                    if (feedbackReportActivity2.l == 2) {
                        if (feedbackReportActivity2.s.getText().toString().trim().length() < 1 && feedbackReportActivity2.t.getText().toString().trim().length() < 1) {
                            Toast.makeText(feedbackReportActivity2, "更多问题及建议未填写", 0).show();
                            return;
                        } else if (feedbackReportActivity2.s.getText().toString().trim().length() < 1 && feedbackReportActivity2.t.getText().toString().trim().length() > 1) {
                            Toast.makeText(feedbackReportActivity2, "更多问题及建议未填写", 0).show();
                            return;
                        } else if (feedbackReportActivity2.s.getText().toString().trim().length() > 1 && feedbackReportActivity2.t.getText().toString().trim().length() < 1) {
                            Toast.makeText(feedbackReportActivity2, "联系方式未填写", 0).show();
                            return;
                        }
                    }
                    if (feedbackReportActivity2.l == 3 && feedbackReportActivity2.s.getText().toString().trim().length() < 1) {
                        Toast.makeText(feedbackReportActivity2, "更多问题及建议未填写", 0).show();
                        return;
                    }
                }
                if (feedbackReportActivity2.n) {
                    int i = feedbackReportActivity2.l;
                    if ((i == 4 || i == 5) && feedbackReportActivity2.w.size() <= 1) {
                        Toast.makeText(feedbackReportActivity2, t1.a("34"), 0).show();
                        return;
                    } else if (feedbackReportActivity2.l == 5 && feedbackReportActivity2.t.getText().toString().trim().length() < 1) {
                        Toast.makeText(feedbackReportActivity2, "联系方式未填写", 0).show();
                        return;
                    }
                }
                if (feedbackReportActivity2.t.getText().toString().trim().length() > 30) {
                    Toast.makeText(feedbackReportActivity2, t1.a("32"), 0).show();
                } else if (feedbackReportActivity2.S.d.size() == 0 && feedbackReportActivity2.s.getText().toString().trim().length() < 4) {
                    Toast.makeText(feedbackReportActivity2, t1.a("12"), 0).show();
                } else if (feedbackReportActivity2.s.getText().toString().trim().length() > 200) {
                    Toast.makeText(feedbackReportActivity2, t1.a("16"), 0).show();
                } else if (!p1.e(feedbackReportActivity2)) {
                    Toast.makeText(feedbackReportActivity2, t1.a("19"), 1).show();
                } else if (TextUtils.isEmpty(feedbackReportActivity2.U.b)) {
                    Toast.makeText(feedbackReportActivity2, t1.a("18"), 1).show();
                    feedbackReportActivity2.U.a(false);
                } else {
                    if (feedbackReportActivity2.getCurrentFocus() != null && feedbackReportActivity2.getCurrentFocus().getWindowToken() != null) {
                        ((InputMethodManager) feedbackReportActivity2.getSystemService("input_method")).hideSoftInputFromWindow(feedbackReportActivity2.getCurrentFocus().getWindowToken(), 2);
                    }
                    feedbackReportActivity2.z.setVisibility(0);
                    feedbackReportActivity2.z.bringToFront();
                    feedbackReportActivity2.A = true;
                    feedbackReportActivity2.i.setTextColor(feedbackReportActivity2.e ? -15387825 : -12814593);
                    feedbackReportActivity2.i.setAlpha(feedbackReportActivity2.e ? 0.5f : 0.3f);
                    new Thread(new b1(feedbackReportActivity2)).start();
                }
            }
        }
    }
}
