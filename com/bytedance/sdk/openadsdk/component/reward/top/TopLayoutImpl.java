package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.r.q;
/* loaded from: classes6.dex */
public class TopLayoutImpl extends FrameLayout implements a<TopLayoutImpl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f29463a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f29464b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f29465c;

    /* renamed from: d  reason: collision with root package name */
    public View f29466d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29467e;

    /* renamed from: f  reason: collision with root package name */
    public b f29468f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f29469g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f29470h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopLayoutImpl(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            View view = this.f29463a;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutImpl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TopLayoutImpl f29471a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29471a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.f29471a.f29468f == null) {
                            return;
                        }
                        this.f29471a.f29468f.c(view2);
                    }
                });
            }
            ImageView imageView = this.f29464b;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutImpl.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TopLayoutImpl f29472a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29472a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            TopLayoutImpl topLayoutImpl = this.f29472a;
                            topLayoutImpl.f29467e = !topLayoutImpl.f29467e;
                            this.f29472a.f29464b.setImageResource(this.f29472a.f29467e ? r.d(this.f29472a.getContext(), "tt_mute") : r.d(this.f29472a.getContext(), "tt_unmute"));
                            if (this.f29472a.f29468f != null) {
                                this.f29472a.f29468f.b(view2);
                            }
                        }
                    }
                });
            }
            TextView textView = this.f29465c;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutImpl.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TopLayoutImpl f29473a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29473a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.f29473a.f29468f == null) {
                            return;
                        }
                        this.f29473a.f29468f.a(view2);
                    }
                });
            }
            View view2 = this.f29466d;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutImpl.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TopLayoutImpl f29474a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29474a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) || this.f29474a.f29468f == null) {
                            return;
                        }
                        this.f29474a.f29468f.d(view3);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f29470h = "";
        }
    }

    public TopLayoutImpl e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LayoutInflater.from(getContext()).inflate(r.f(getContext(), "tt_top_reward_dislike_2"), (ViewGroup) this, true);
            this.f29463a = findViewById(r.e(getContext(), "tt_top_dislike"));
            this.f29464b = (ImageView) findViewById(r.e(getContext(), "tt_top_mute"));
            this.f29465c = (TextView) findViewById(r.e(getContext(), "tt_top_skip"));
            this.f29466d = findViewById(r.e(getContext(), "tt_video_ad_close_layout"));
            this.f29465c.setVisibility(0);
            this.f29465c.setText("");
            this.f29465c.setEnabled(false);
            this.f29465c.setClickable(false);
            f();
            return this;
        }
        return (TopLayoutImpl) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public View getCloseButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29466d : (View) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setCloseButtonAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            q.a(this.f29466d, f2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f29468f = bVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowClose(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (view = this.f29466d) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 4);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (view = this.f29463a) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (textView = this.f29465c) == null) {
            return;
        }
        if (!z) {
            textView.setText("");
        }
        if (this.f29465c.getVisibility() == 4) {
            return;
        }
        this.f29465c.setVisibility(z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSound(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (imageView = this.f29464b) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipEnable(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (textView = this.f29465c) == null) {
            return;
        }
        textView.setEnabled(z);
        this.f29465c.setClickable(z);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f29467e = z;
            if (z) {
                d2 = r.d(getContext(), "tt_mute");
            } else {
                d2 = r.d(getContext(), "tt_unmute");
            }
            this.f29464b.setImageResource(d2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopLayoutImpl(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void b() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (view = this.f29466d) == null) {
            return;
        }
        view.performClick();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (imageView = this.f29464b) == null) {
            return;
        }
        imageView.performClick();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopLayoutImpl(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f29469g = "";
        this.f29470h = "";
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, charSequence2) == null) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.f29469g = charSequence;
            }
            if (!TextUtils.isEmpty(charSequence2)) {
                this.f29470h = charSequence2;
            }
            if (this.f29465c != null) {
                String str = ((Object) this.f29469g) + "s";
                if (!TextUtils.isEmpty(this.f29470h)) {
                    str = ((Object) str) + " | " + ((Object) this.f29470h);
                }
                this.f29465c.setText(str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (textView = this.f29465c) == null) {
            return;
        }
        textView.performClick();
    }
}
