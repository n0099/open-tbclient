package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
public class RecordTabLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f21782e;

    /* renamed from: f  reason: collision with root package name */
    public View f21783f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21784g;

    /* renamed from: h  reason: collision with root package name */
    public int f21785h;

    /* renamed from: i  reason: collision with root package name */
    public c f21786i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21787e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordTabLayout f21788f;

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
            this.f21788f = recordTabLayout;
            this.f21787e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = this.f21788f.f21785h;
                int i3 = this.f21787e;
                if (i2 == i3) {
                    return;
                }
                this.f21788f.setCurrentTab(i3, true);
                if (this.f21788f.f21786i != null) {
                    this.f21788f.f21786i.onTabChoosed(this.f21787e, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f21789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f21790f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ RecordTabLayout f21791g;

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
            this.f21791g = recordTabLayout;
            this.f21789e = textView;
            this.f21790f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                float x = (this.f21789e.getX() + ((this.f21789e.getWidth() - this.f21791g.f21783f.getWidth()) / 2)) - this.f21791g.f21783f.getLeft();
                if (this.f21790f) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f21791g.f21783f, "translationX", this.f21791g.f21783f.getTranslationX(), x);
                    ofFloat.setDuration(500L);
                    ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                    ofFloat.start();
                    return;
                }
                this.f21791g.f21783f.setTranslationX(x);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f21784g = true;
        e();
    }

    public void d(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, l.g(getContext(), R.dimen.fontsize28));
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            textView.setText(str);
            textView.setTag(Integer.valueOf(i2));
            textView.setOnClickListener(new a(this, i2));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (this.f21782e.getChildCount() != 0) {
                layoutParams.leftMargin = l.g(getContext(), R.dimen.ds44);
            }
            this.f21782e.addView(textView, layoutParams);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f21782e = linearLayout;
            linearLayout.setOrientation(0);
            this.f21782e.setGravity(17);
            addView(this.f21782e, new ViewGroup.LayoutParams(-1, -2));
            View view = new View(getContext());
            this.f21783f = view;
            view.setBackgroundColor(getResources().getColor(R.color.CAM_X0101));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.ds44), l.g(getContext(), R.dimen.ds4));
            layoutParams.topMargin = l.g(getContext(), R.dimen.ds18);
            addView(this.f21783f, layoutParams);
        }
    }

    public int getCurrentTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21785h : invokeV.intValue;
    }

    public void setCurrentTab(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f21785h == i2) {
            return;
        }
        this.f21785h = i2;
        TextView textView = null;
        for (int i3 = 0; i3 < this.f21782e.getChildCount(); i3++) {
            View childAt = this.f21782e.getChildAt(i3);
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
        if (this.f21784g) {
            textView.post(new b(this, textView, z));
        }
    }

    public void setListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f21786i = cVar;
        }
    }

    public void setShowIndicator(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f21784g = z;
            if (z) {
                return;
            }
            this.f21783f.setVisibility(4);
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
        this.f21784g = true;
        e();
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
        this.f21784g = true;
        e();
    }
}
