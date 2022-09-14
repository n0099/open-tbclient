package com.baidu.ufosdk;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
/* loaded from: classes6.dex */
public class r0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ImageView a;
    public final /* synthetic */ FeedbackEditActivity b;

    public r0(FeedbackEditActivity feedbackEditActivity, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity, imageView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = feedbackEditActivity;
        this.a = imageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        BitmapDrawable bitmapDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            FeedbackEditActivity feedbackEditActivity = this.b;
            feedbackEditActivity.O = !feedbackEditActivity.O;
            ImageView imageView = this.a;
            FeedbackEditActivity feedbackEditActivity2 = this.b;
            boolean z = feedbackEditActivity2.O;
            boolean z2 = feedbackEditActivity2.d;
            if (z) {
                bitmapDrawable = new BitmapDrawable(p1.b(feedbackEditActivity2, z2 ? "ufo_checkbox_checked_night.png" : "ufo_checkbox_checked.png"));
            } else {
                bitmapDrawable = new BitmapDrawable(p1.b(feedbackEditActivity2, z2 ? "ufo_checkbox_default_night.png" : "ufo_checkbox_default.png"));
            }
            imageView.setBackgroundDrawable(bitmapDrawable);
        }
    }
}
