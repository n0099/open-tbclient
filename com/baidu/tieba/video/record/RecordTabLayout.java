package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class RecordTabLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public View b;
    public boolean c;
    public int d;
    public c e;

    /* loaded from: classes8.dex */
    public interface c {
        void s(int i, boolean z);
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ RecordTabLayout b;

        public a(RecordTabLayout recordTabLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordTabLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordTabLayout;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            int i = this.b.d;
            int i2 = this.a;
            if (i == i2) {
                return;
            }
            this.b.setCurrentTab(i2, true);
            if (this.b.e != null) {
                this.b.e.s(this.a, true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ RecordTabLayout c;

        public b(RecordTabLayout recordTabLayout, TextView textView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordTabLayout, textView, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = recordTabLayout;
            this.a = textView;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                float x = (this.a.getX() + ((this.a.getWidth() - this.c.b.getWidth()) / 2)) - this.c.b.getLeft();
                if (this.b) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c.b, Key.TRANSLATION_X, this.c.b.getTranslationX(), x);
                    ofFloat.setDuration(500L);
                    ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                    ofFloat.start();
                    return;
                }
                this.c.b.setTranslationX(x);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordTabLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = true;
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = true;
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.c = true;
        e();
    }

    public void setListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.e = cVar;
        }
    }

    public void setShowIndicator(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.c = z;
            if (!z) {
                this.b.setVisibility(4);
            }
        }
    }

    public void d(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0702b5));
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            textView.setText(str);
            textView.setTag(Integer.valueOf(i));
            textView.setOnClickListener(new a(this, i));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (this.a.getChildCount() != 0) {
                layoutParams.leftMargin = BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0703e1);
            }
            this.a.addView(textView, layoutParams);
        }
    }

    public void setCurrentTab(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.d == i) {
            return;
        }
        this.d = i;
        TextView textView = null;
        for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
            View childAt = this.a.getChildAt(i2);
            if (childAt instanceof TextView) {
                Object tag = childAt.getTag();
                if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                    TextView textView2 = (TextView) childAt;
                    textView2.setTextColor(getResources().getColor(R.color.CAM_X0101));
                    textView = textView2;
                } else {
                    ((TextView) childAt).setTextColor(getResources().getColor(R.color.white_alpha80));
                }
            }
        }
        if (this.c) {
            textView.post(new b(this, textView, z));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.a = linearLayout;
            linearLayout.setOrientation(0);
            this.a.setGravity(17);
            addView(this.a, new ViewGroup.LayoutParams(-1, -2));
            View view2 = new View(getContext());
            this.b = view2;
            view2.setBackgroundColor(getResources().getColor(R.color.CAM_X0101));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0703e1), BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f070224));
            layoutParams.topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f070389);
            addView(this.b, layoutParams);
        }
    }

    public int getCurrentTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }
}
