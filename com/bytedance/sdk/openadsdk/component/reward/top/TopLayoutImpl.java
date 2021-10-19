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
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.q.s;
/* loaded from: classes9.dex */
public class TopLayoutImpl extends FrameLayout implements a<TopLayoutImpl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f66285a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f66286b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f66287c;

    /* renamed from: d  reason: collision with root package name */
    public View f66288d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66289e;

    /* renamed from: f  reason: collision with root package name */
    public b f66290f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f66291g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f66292h;

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
            View view = this.f66285a;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutImpl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TopLayoutImpl f66293a;

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
                        this.f66293a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.f66293a.f66290f == null) {
                            return;
                        }
                        this.f66293a.f66290f.c(view2);
                    }
                });
            }
            ImageView imageView = this.f66286b;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutImpl.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TopLayoutImpl f66294a;

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
                        this.f66294a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            TopLayoutImpl topLayoutImpl = this.f66294a;
                            topLayoutImpl.f66289e = !topLayoutImpl.f66289e;
                            this.f66294a.f66286b.setImageResource(this.f66294a.f66289e ? t.d(this.f66294a.getContext(), "tt_mute") : t.d(this.f66294a.getContext(), "tt_unmute"));
                            if (this.f66294a.f66290f != null) {
                                this.f66294a.f66290f.b(view2);
                            }
                        }
                    }
                });
            }
            TextView textView = this.f66287c;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutImpl.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TopLayoutImpl f66295a;

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
                        this.f66295a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.f66295a.f66290f == null) {
                            return;
                        }
                        this.f66295a.f66290f.a(view2);
                    }
                });
            }
            View view2 = this.f66288d;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutImpl.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TopLayoutImpl f66296a;

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
                        this.f66296a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) || this.f66296a.f66290f == null) {
                            return;
                        }
                        this.f66296a.f66290f.d(view3);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f66292h = "";
        }
    }

    public TopLayoutImpl e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LayoutInflater.from(getContext()).inflate(t.f(getContext(), "tt_top_reward_dislike_2"), (ViewGroup) this, true);
            this.f66285a = findViewById(t.e(getContext(), "tt_top_dislike"));
            this.f66286b = (ImageView) findViewById(t.e(getContext(), "tt_top_mute"));
            this.f66287c = (TextView) findViewById(t.e(getContext(), "tt_top_skip"));
            this.f66288d = findViewById(t.e(getContext(), "tt_video_ad_close_layout"));
            this.f66287c.setVisibility(0);
            this.f66287c.setText("");
            this.f66287c.setEnabled(false);
            this.f66287c.setClickable(false);
            f();
            return this;
        }
        return (TopLayoutImpl) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public View getCloseButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f66288d : (View) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setCloseButtonAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            s.a(this.f66288d, f2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f66290f = bVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowClose(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (view = this.f66288d) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 4);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (view = this.f66285a) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (textView = this.f66287c) == null) {
            return;
        }
        if (!z) {
            textView.setText("");
        }
        if (this.f66287c.getVisibility() == 4) {
            return;
        }
        this.f66287c.setVisibility(z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSound(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (imageView = this.f66286b) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipEnable(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (textView = this.f66287c) == null) {
            return;
        }
        textView.setEnabled(z);
        this.f66287c.setClickable(z);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f66289e = z;
            if (z) {
                d2 = t.d(getContext(), "tt_mute");
            } else {
                d2 = t.d(getContext(), "tt_unmute");
            }
            this.f66286b.setImageResource(d2);
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (view = this.f66288d) == null) {
            return;
        }
        view.performClick();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (imageView = this.f66286b) == null) {
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
        this.f66291g = "";
        this.f66292h = "";
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, charSequence2) == null) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.f66291g = charSequence;
            }
            if (!TextUtils.isEmpty(charSequence2)) {
                this.f66292h = charSequence2;
            }
            if (this.f66287c != null) {
                String str = ((Object) this.f66291g) + "s";
                if (!TextUtils.isEmpty(this.f66292h)) {
                    str = ((Object) str) + " | " + ((Object) this.f66292h);
                }
                this.f66287c.setText(str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (textView = this.f66287c) == null) {
            return;
        }
        textView.performClick();
    }
}
