package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.b.e;
import com.bytedance.sdk.openadsdk.core.e.l;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.q.s;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f66305a;

    /* renamed from: b  reason: collision with root package name */
    public TTRoundRectImageView f66306b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f66307c;

    /* renamed from: d  reason: collision with root package name */
    public TTRatingBar f66308d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66309e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66310f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66311g;

    /* renamed from: h  reason: collision with root package name */
    public final Activity f66312h;

    /* renamed from: i  reason: collision with root package name */
    public m f66313i;

    /* renamed from: j  reason: collision with root package name */
    public int f66314j;
    public boolean k;

    public a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66312h = activity;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Activity activity = this.f66312h;
            this.f66305a = (LinearLayout) activity.findViewById(t.e(activity, "tt_reward_full_endcard_backup"));
            Activity activity2 = this.f66312h;
            this.f66306b = (TTRoundRectImageView) activity2.findViewById(t.e(activity2, "tt_reward_ad_icon_backup"));
            Activity activity3 = this.f66312h;
            this.f66307c = (TextView) activity3.findViewById(t.e(activity3, "tt_reward_ad_appname_backup"));
            Activity activity4 = this.f66312h;
            this.f66308d = (TTRatingBar) activity4.findViewById(t.e(activity4, "tt_rb_score_backup"));
            Activity activity5 = this.f66312h;
            this.f66309e = (TextView) activity5.findViewById(t.e(activity5, "tt_comment_backup"));
            Activity activity6 = this.f66312h;
            this.f66310f = (TextView) activity6.findViewById(t.e(activity6, "tt_reward_ad_download_backup"));
            Activity activity7 = this.f66312h;
            this.f66311g = (TextView) activity7.findViewById(t.e(activity7, "tt_endcard_ad_logo"));
            TTRatingBar tTRatingBar = this.f66308d;
            if (tTRatingBar != null) {
                tTRatingBar.setStarEmptyNum(1);
                this.f66308d.setStarFillNum(4);
                this.f66308d.setStarImageWidth(s.d(this.f66312h, 16.0f));
                this.f66308d.setStarImageHeight(s.d(this.f66312h, 16.0f));
                this.f66308d.setStarImagePadding(s.d(this.f66312h, 4.0f));
                this.f66308d.a();
            }
        }
    }

    private void d() {
        TTRoundRectImageView tTRoundRectImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.f66314j == 1 && (tTRoundRectImageView = this.f66306b) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, (int) s.b(this.f66312h, 50.0f), 0, 0);
            this.f66306b.setLayoutParams(layoutParams);
        }
    }

    public void a(m mVar, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, mVar, str, i2) == null) || this.k) {
            return;
        }
        this.k = true;
        this.f66313i = mVar;
        this.f66314j = i2;
        c();
        b();
        a(str);
        d();
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f66306b != null) {
                l Y = this.f66313i.Y();
                if (Y != null && !TextUtils.isEmpty(Y.a())) {
                    ImageLoaderWrapper.from(Y).to(this.f66306b);
                } else {
                    this.f66306b.setImageResource(t.d(this.f66312h, "tt_ad_logo_small"));
                }
            }
            if (this.f66307c != null) {
                if (this.f66313i.al() != null && !TextUtils.isEmpty(this.f66313i.al().c())) {
                    this.f66307c.setText(this.f66313i.al().c());
                } else {
                    this.f66307c.setText(this.f66313i.ah());
                }
            }
            if (this.f66309e != null) {
                int f2 = this.f66313i.al() != null ? this.f66313i.al().f() : 6870;
                String a2 = t.a(this.f66312h, "tt_comment_num_backup");
                if (f2 > 10000) {
                    str = (f2 / 10000) + "万";
                } else {
                    str = f2 + "";
                }
                this.f66309e.setText(String.format(a2, str));
            }
            TextView textView = this.f66311g;
            if (textView != null) {
                s.a(textView, this.f66313i);
            }
        }
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            s.a(this.f66305a, new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66315a;

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
                    this.f66315a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    }
                }
            }, "TTBaseVideoActivity#mLLEndCardBackup");
            this.f66310f.setOnClickListener(eVar);
            this.f66310f.setOnTouchListener(eVar);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            s.a((View) this.f66305a, 0);
        }
    }

    public void a(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str) || (textView = this.f66310f) == null) {
            return;
        }
        textView.setText(str);
    }
}
