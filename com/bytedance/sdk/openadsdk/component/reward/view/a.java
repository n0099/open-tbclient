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
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.core.b.e;
import com.bytedance.sdk.openadsdk.core.e.l;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.r.q;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f29593a;

    /* renamed from: b  reason: collision with root package name */
    public TTRoundRectImageView f29594b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f29595c;

    /* renamed from: d  reason: collision with root package name */
    public TTRatingBar f29596d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f29597e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f29598f;

    /* renamed from: g  reason: collision with root package name */
    public final Activity f29599g;

    /* renamed from: h  reason: collision with root package name */
    public m f29600h;

    /* renamed from: i  reason: collision with root package name */
    public int f29601i;
    public boolean j;

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
        this.f29599g = activity;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Activity activity = this.f29599g;
            this.f29593a = (LinearLayout) activity.findViewById(r.e(activity, "tt_reward_full_endcard_backup"));
            Activity activity2 = this.f29599g;
            this.f29594b = (TTRoundRectImageView) activity2.findViewById(r.e(activity2, "tt_reward_ad_icon_backup"));
            Activity activity3 = this.f29599g;
            this.f29595c = (TextView) activity3.findViewById(r.e(activity3, "tt_reward_ad_appname_backup"));
            Activity activity4 = this.f29599g;
            this.f29596d = (TTRatingBar) activity4.findViewById(r.e(activity4, "tt_rb_score_backup"));
            Activity activity5 = this.f29599g;
            this.f29597e = (TextView) activity5.findViewById(r.e(activity5, "tt_comment_backup"));
            Activity activity6 = this.f29599g;
            this.f29598f = (TextView) activity6.findViewById(r.e(activity6, "tt_reward_ad_download_backup"));
            TTRatingBar tTRatingBar = this.f29596d;
            if (tTRatingBar != null) {
                tTRatingBar.setStarEmptyNum(1);
                this.f29596d.setStarFillNum(4);
                this.f29596d.setStarImageWidth(q.d(this.f29599g, 16.0f));
                this.f29596d.setStarImageHeight(q.d(this.f29599g, 16.0f));
                this.f29596d.setStarImagePadding(q.d(this.f29599g, 4.0f));
                this.f29596d.a();
            }
        }
    }

    private void d() {
        TTRoundRectImageView tTRoundRectImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.f29601i == 1 && (tTRoundRectImageView = this.f29594b) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, (int) q.b(this.f29599g, 50.0f), 0, 0);
            this.f29594b.setLayoutParams(layoutParams);
        }
    }

    public void a(m mVar, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, mVar, str, i2) == null) || this.j) {
            return;
        }
        this.j = true;
        this.f29600h = mVar;
        this.f29601i = i2;
        c();
        b();
        a(str);
        d();
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f29594b != null) {
                l Y = this.f29600h.Y();
                if (Y != null && !TextUtils.isEmpty(Y.a())) {
                    com.bytedance.sdk.openadsdk.g.a.a(Y).a(this.f29594b);
                } else {
                    this.f29594b.setImageResource(r.d(this.f29599g, "tt_ad_logo_small"));
                }
            }
            if (this.f29595c != null) {
                if (this.f29600h.al() != null && !TextUtils.isEmpty(this.f29600h.al().c())) {
                    this.f29595c.setText(this.f29600h.al().c());
                } else {
                    this.f29595c.setText(this.f29600h.ah());
                }
            }
            if (this.f29597e != null) {
                int f2 = this.f29600h.al() != null ? this.f29600h.al().f() : 6870;
                String a2 = r.a(this.f29599g, "tt_comment_num_backup");
                if (f2 > 10000) {
                    str = (f2 / 10000) + "万";
                } else {
                    str = f2 + "";
                }
                this.f29597e.setText(String.format(a2, str));
            }
        }
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            q.a(this.f29593a, new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f29602a;

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
                    this.f29602a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    }
                }
            }, "TTBaseVideoActivity#mLLEndCardBackup");
            this.f29598f.setOnClickListener(eVar);
            this.f29598f.setOnTouchListener(eVar);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q.a((View) this.f29593a, 0);
        }
    }

    public void a(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str) || (textView = this.f29598f) == null) {
            return;
        }
        textView.setText(str);
    }
}
