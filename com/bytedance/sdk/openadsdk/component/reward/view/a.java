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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f29691a;

    /* renamed from: b  reason: collision with root package name */
    public TTRoundRectImageView f29692b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f29693c;

    /* renamed from: d  reason: collision with root package name */
    public TTRatingBar f29694d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f29695e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f29696f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f29697g;

    /* renamed from: h  reason: collision with root package name */
    public final Activity f29698h;

    /* renamed from: i  reason: collision with root package name */
    public m f29699i;
    public int j;
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
        this.f29698h = activity;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Activity activity = this.f29698h;
            this.f29691a = (LinearLayout) activity.findViewById(t.e(activity, "tt_reward_full_endcard_backup"));
            Activity activity2 = this.f29698h;
            this.f29692b = (TTRoundRectImageView) activity2.findViewById(t.e(activity2, "tt_reward_ad_icon_backup"));
            Activity activity3 = this.f29698h;
            this.f29693c = (TextView) activity3.findViewById(t.e(activity3, "tt_reward_ad_appname_backup"));
            Activity activity4 = this.f29698h;
            this.f29694d = (TTRatingBar) activity4.findViewById(t.e(activity4, "tt_rb_score_backup"));
            Activity activity5 = this.f29698h;
            this.f29695e = (TextView) activity5.findViewById(t.e(activity5, "tt_comment_backup"));
            Activity activity6 = this.f29698h;
            this.f29696f = (TextView) activity6.findViewById(t.e(activity6, "tt_reward_ad_download_backup"));
            Activity activity7 = this.f29698h;
            this.f29697g = (TextView) activity7.findViewById(t.e(activity7, "tt_endcard_ad_logo"));
            TTRatingBar tTRatingBar = this.f29694d;
            if (tTRatingBar != null) {
                tTRatingBar.setStarEmptyNum(1);
                this.f29694d.setStarFillNum(4);
                this.f29694d.setStarImageWidth(s.d(this.f29698h, 16.0f));
                this.f29694d.setStarImageHeight(s.d(this.f29698h, 16.0f));
                this.f29694d.setStarImagePadding(s.d(this.f29698h, 4.0f));
                this.f29694d.a();
            }
        }
    }

    private void d() {
        TTRoundRectImageView tTRoundRectImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.j == 1 && (tTRoundRectImageView = this.f29692b) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, (int) s.b(this.f29698h, 50.0f), 0, 0);
            this.f29692b.setLayoutParams(layoutParams);
        }
    }

    public void a(m mVar, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, mVar, str, i2) == null) || this.k) {
            return;
        }
        this.k = true;
        this.f29699i = mVar;
        this.j = i2;
        c();
        b();
        a(str);
        d();
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f29692b != null) {
                l Y = this.f29699i.Y();
                if (Y != null && !TextUtils.isEmpty(Y.a())) {
                    ImageLoaderWrapper.from(Y).to(this.f29692b);
                } else {
                    this.f29692b.setImageResource(t.d(this.f29698h, "tt_ad_logo_small"));
                }
            }
            if (this.f29693c != null) {
                if (this.f29699i.al() != null && !TextUtils.isEmpty(this.f29699i.al().c())) {
                    this.f29693c.setText(this.f29699i.al().c());
                } else {
                    this.f29693c.setText(this.f29699i.ah());
                }
            }
            if (this.f29695e != null) {
                int f2 = this.f29699i.al() != null ? this.f29699i.al().f() : 6870;
                String a2 = t.a(this.f29698h, "tt_comment_num_backup");
                if (f2 > 10000) {
                    str = (f2 / 10000) + "万";
                } else {
                    str = f2 + "";
                }
                this.f29695e.setText(String.format(a2, str));
            }
            TextView textView = this.f29697g;
            if (textView != null) {
                s.a(textView, this.f29699i);
            }
        }
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            s.a(this.f29691a, new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f29700a;

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
                    this.f29700a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    }
                }
            }, "TTBaseVideoActivity#mLLEndCardBackup");
            this.f29696f.setOnClickListener(eVar);
            this.f29696f.setOnTouchListener(eVar);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            s.a((View) this.f29691a, 0);
        }
    }

    public void a(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str) || (textView = this.f29696f) == null) {
            return;
        }
        textView.setText(str);
    }
}
