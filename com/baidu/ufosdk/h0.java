package com.baidu.ufosdk;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.CustomCheckBox;
import com.baidu.ufosdk.ui.FeedbackReportActivity;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;
    public ArrayList<String> b;
    public Context c;
    public ArrayList<String> d;
    public i0 e;
    public boolean f;
    public int g;
    public boolean h;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomCheckBox a;
        public final /* synthetic */ h0 b;

        public a(h0 h0Var, CustomCheckBox customCheckBox) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h0Var, customCheckBox};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h0Var;
            this.a = customCheckBox;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                CustomCheckBox customCheckBox = this.a;
                boolean z = !customCheckBox.c;
                customCheckBox.c = z;
                customCheckBox.a(z, this.b.f);
                CustomCheckBox customCheckBox2 = this.a;
                if (customCheckBox2.c) {
                    this.b.d.add(customCheckBox2.getText());
                } else {
                    this.b.d.remove(customCheckBox2.getText());
                }
                for (int i = 0; i < this.b.d.size(); i++) {
                    String str = "选中的原因：" + this.b.d.get(i);
                }
                if (!this.b.d.contains("抄袭") && !this.b.d.contains("疑似抄袭") && !this.b.d.contains("恶意抄袭")) {
                    if (this.b.d.contains("虚假欺诈")) {
                        this.b.g = 2;
                    } else if (!this.b.d.contains("违法违规") && !this.b.d.contains("广告侵权") && !this.b.d.contains("体验不好")) {
                        if (!this.b.d.contains("色情") && !this.b.d.contains("违法犯罪") && !this.b.d.contains("欺诈") && !this.b.d.contains("骚扰") && !this.b.d.contains("虚假信息")) {
                            this.b.g = 0;
                        } else {
                            this.b.g = 4;
                        }
                    } else {
                        this.b.g = 3;
                    }
                } else {
                    this.b.g = 1;
                }
                if (this.b.d.contains("侵权")) {
                    this.b.g = 5;
                }
                h0 h0Var = this.b;
                i0 i0Var = h0Var.e;
                if (i0Var != null) {
                    ((FeedbackReportActivity.d) i0Var).a(h0Var.d, h0Var.g);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h0 a;

        public b(h0 h0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            h0 h0Var;
            i0 i0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (i0Var = (h0Var = this.a).e) != null) {
                ((FeedbackReportActivity.d) i0Var).a(h0Var.d, 1001);
            }
        }
    }

    public h0(ArrayList<String> arrayList, Context context, i0 i0Var, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, context, i0Var, bool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = 0;
        this.c = context;
        this.e = i0Var;
        this.f = bool.booleanValue();
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.d = new ArrayList<>();
        a(arrayList);
    }

    public LinearLayout a() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.c);
            linearLayout.setOrientation(1);
            if (this.f) {
                i = BDEmotionBagVerticalLayout.NIGHT_COLOR_EMOTION_BAG;
            } else {
                i = -1;
            }
            linearLayout.setBackgroundColor(i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(p1.a(this.c, 5.0f), p1.a(this.c, 0.0f), p1.a(this.c, 15.0f), p1.a(this.c, 14.0f));
            int size = this.b.size();
            if (!this.h && q1.a()) {
                size = this.b.size() - 1;
            }
            for (int i3 = 0; i3 < size; i3++) {
                CustomCheckBox customCheckBox = new CustomCheckBox(this.c, this.f);
                if (this.f) {
                    i2 = -10066330;
                } else {
                    i2 = -13421773;
                }
                customCheckBox.setTextColor(i2);
                customCheckBox.setText(this.b.get(i3));
                customCheckBox.setTextSize(14.0f);
                linearLayout.addView(customCheckBox, layoutParams);
                customCheckBox.setOnClickListener(new a(this, customCheckBox));
            }
            if (!this.h && q1.a()) {
                linearLayout.addView(a(this.b.get(size)), layoutParams);
            }
            return linearLayout;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public LinearLayout a(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.c);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(48);
            ImageView imageView = new ImageView(this.c);
            imageView.setBackgroundDrawable(new BitmapDrawable(p1.b(this.c, "ufo_tort_icon.png")));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(p1.a(this.c, 15.0f), p1.a(this.c, 15.0f));
            layoutParams.setMargins(0, p1.a(this.c, 3.0f), 0, 0);
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.c);
            textView.setText(str);
            textView.setTextSize(14.0f);
            if (this.f) {
                i = -10066330;
            } else {
                i = -13421773;
            }
            textView.setTextColor(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(p1.a(this.c, 10.0f), 0, 0, 0);
            linearLayout.addView(textView, layoutParams2);
            linearLayout.setOnClickListener(new b(this));
            return linearLayout;
        }
        return (LinearLayout) invokeL.objValue;
    }

    public final void a(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            if (q1.a()) {
                arrayList.add("侵权(侵犯名誉、肖像、隐私权等)");
                if (arrayList.size() % 2 == 1) {
                    this.h = true;
                }
            }
            int i = 0;
            while (i < arrayList.size()) {
                int i2 = i + 1;
                if (i2 % 2 == 1) {
                    this.a.add(arrayList.get(i));
                } else {
                    this.b.add(arrayList.get(i));
                }
                i = i2;
            }
        }
    }
}
