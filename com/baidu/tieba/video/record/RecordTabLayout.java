package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class RecordTabLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f57800e;

    /* renamed from: f  reason: collision with root package name */
    public View f57801f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57802g;

    /* renamed from: h  reason: collision with root package name */
    public int f57803h;

    /* renamed from: i  reason: collision with root package name */
    public c f57804i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f57805e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordTabLayout f57806f;

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
            this.f57806f = recordTabLayout;
            this.f57805e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = this.f57806f.f57803h;
                int i3 = this.f57805e;
                if (i2 == i3) {
                    return;
                }
                this.f57806f.setCurrentTab(i3, true);
                if (this.f57806f.f57804i != null) {
                    this.f57806f.f57804i.onTabChoosed(this.f57805e, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f57807e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f57808f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ RecordTabLayout f57809g;

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
            this.f57809g = recordTabLayout;
            this.f57807e = textView;
            this.f57808f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                float x = (this.f57807e.getX() + ((this.f57807e.getWidth() - this.f57809g.f57801f.getWidth()) / 2)) - this.f57809g.f57801f.getLeft();
                if (this.f57808f) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f57809g.f57801f, "translationX", this.f57809g.f57801f.getTranslationX(), x);
                    ofFloat.setDuration(500L);
                    ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                    ofFloat.start();
                    return;
                }
                this.f57809g.f57801f.setTranslationX(x);
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.f57802g = true;
        d();
    }

    public void addTab(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, l.g(getContext(), R.dimen.fontsize28));
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            textView.setText(str);
            textView.setTag(Integer.valueOf(i2));
            textView.setOnClickListener(new a(this, i2));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (this.f57800e.getChildCount() != 0) {
                layoutParams.leftMargin = l.g(getContext(), R.dimen.ds44);
            }
            this.f57800e.addView(textView, layoutParams);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f57800e = linearLayout;
            linearLayout.setOrientation(0);
            this.f57800e.setGravity(17);
            addView(this.f57800e, new ViewGroup.LayoutParams(-1, -2));
            View view = new View(getContext());
            this.f57801f = view;
            view.setBackgroundColor(getResources().getColor(R.color.CAM_X0101));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.ds44), l.g(getContext(), R.dimen.ds4));
            layoutParams.topMargin = l.g(getContext(), R.dimen.ds18);
            addView(this.f57801f, layoutParams);
        }
    }

    public int getCurrentTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57803h : invokeV.intValue;
    }

    public void setCurrentTab(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f57803h == i2) {
            return;
        }
        this.f57803h = i2;
        TextView textView = null;
        for (int i3 = 0; i3 < this.f57800e.getChildCount(); i3++) {
            View childAt = this.f57800e.getChildAt(i3);
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
        if (this.f57802g) {
            textView.post(new b(this, textView, z));
        }
    }

    public void setListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f57804i = cVar;
        }
    }

    public void setShowIndicator(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f57802g = z;
            if (z) {
                return;
            }
            this.f57801f.setVisibility(4);
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
        this.f57802g = true;
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
        this.f57802g = true;
        d();
    }
}
