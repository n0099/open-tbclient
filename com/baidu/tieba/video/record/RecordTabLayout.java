package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes12.dex */
public class RecordTabLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f48632e;

    /* renamed from: f  reason: collision with root package name */
    public View f48633f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48634g;

    /* renamed from: h  reason: collision with root package name */
    public int f48635h;

    /* renamed from: i  reason: collision with root package name */
    public c f48636i;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f48637e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordTabLayout f48638f;

        public a(RecordTabLayout recordTabLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordTabLayout, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48638f = recordTabLayout;
            this.f48637e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = this.f48638f.f48635h;
                int i3 = this.f48637e;
                if (i2 == i3) {
                    return;
                }
                this.f48638f.setCurrentTab(i3, true);
                if (this.f48638f.f48636i != null) {
                    this.f48638f.f48636i.onTabChoosed(this.f48637e, true);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f48639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f48640f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ RecordTabLayout f48641g;

        public b(RecordTabLayout recordTabLayout, TextView textView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordTabLayout, textView, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48641g = recordTabLayout;
            this.f48639e = textView;
            this.f48640f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                float x = (this.f48639e.getX() + ((this.f48639e.getWidth() - this.f48641g.f48633f.getWidth()) / 2)) - this.f48641g.f48633f.getLeft();
                if (this.f48640f) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f48641g.f48633f, AnimationProperty.TRANSLATE_X, this.f48641g.f48633f.getTranslationX(), x);
                    ofFloat.setDuration(500L);
                    ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                    ofFloat.start();
                    return;
                }
                this.f48641g.f48633f.setTranslationX(x);
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface c {
        void onTabChoosed(int i2, boolean z);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48634g = true;
        d();
    }

    public void addTab(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, n.f(getContext(), R.dimen.fontsize28));
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            textView.setText(str);
            textView.setTag(Integer.valueOf(i2));
            textView.setOnClickListener(new a(this, i2));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (this.f48632e.getChildCount() != 0) {
                layoutParams.leftMargin = n.f(getContext(), R.dimen.ds44);
            }
            this.f48632e.addView(textView, layoutParams);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f48632e = linearLayout;
            linearLayout.setOrientation(0);
            this.f48632e.setGravity(17);
            addView(this.f48632e, new ViewGroup.LayoutParams(-1, -2));
            View view = new View(getContext());
            this.f48633f = view;
            view.setBackgroundColor(getResources().getColor(R.color.CAM_X0101));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n.f(getContext(), R.dimen.ds44), n.f(getContext(), R.dimen.ds4));
            layoutParams.topMargin = n.f(getContext(), R.dimen.ds18);
            addView(this.f48633f, layoutParams);
        }
    }

    public int getCurrentTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48635h : invokeV.intValue;
    }

    public void setCurrentTab(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f48635h == i2) {
            return;
        }
        this.f48635h = i2;
        TextView textView = null;
        for (int i3 = 0; i3 < this.f48632e.getChildCount(); i3++) {
            View childAt = this.f48632e.getChildAt(i3);
            if (childAt instanceof TextView) {
                Object tag = childAt.getTag();
                if ((tag instanceof Integer) && ((Integer) tag).intValue() == i2) {
                    TextView textView2 = (TextView) childAt;
                    textView2.setTextColor(getResources().getColor(R.color.CAM_X0101));
                    textView = textView2;
                } else {
                    ((TextView) childAt).setTextColor(getResources().getColor(R.color.white_alpha80));
                }
            }
        }
        if (this.f48634g) {
            textView.post(new b(this, textView, z));
        }
    }

    public void setListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f48636i = cVar;
        }
    }

    public void setShowIndicator(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f48634g = z;
            if (z) {
                return;
            }
            this.f48633f.setVisibility(4);
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48634g = true;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f48634g = true;
        d();
    }
}
