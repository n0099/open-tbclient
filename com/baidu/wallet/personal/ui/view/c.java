package com.baidu.wallet.personal.ui.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.personal.a.a;
import com.baidu.wallet.personal.datamodel.CouponList;
/* loaded from: classes8.dex */
public class c implements a.b<CouponList.Coupon> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f63875a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f63876b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63877c;

    /* renamed from: d  reason: collision with root package name */
    public View f63878d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f63879e;

    /* renamed from: f  reason: collision with root package name */
    public View f63880f;

    /* renamed from: g  reason: collision with root package name */
    public a f63881g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f63882h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f63883i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f63884j;
    public b k;
    public TextView l;
    public TextView m;
    public TextView n;
    public LinearLayout o;
    public NetImageView p;
    public TextView q;
    public TextView r;
    public ImageView s;
    public boolean t;
    public boolean u;
    public View.OnClickListener v;
    public View.OnClickListener w;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f63897a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f63898b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f63899c;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63899c = cVar;
            this.f63898b = false;
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f63900a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f63901b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f63902c;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63902c = cVar;
            this.f63901b = false;
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = false;
        this.u = false;
        this.f63875a = false;
        this.f63881g = new a(this);
        this.k = new b(this);
        this.v = new View.OnClickListener(this) { // from class: com.baidu.wallet.personal.ui.view.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f63895a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f63895a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                }
            }
        };
        this.w = new View.OnClickListener(this) { // from class: com.baidu.wallet.personal.ui.view.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f63896a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f63896a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                }
            }
        };
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f63875a) {
            this.f63880f.getBackground().setAlpha(102);
            TextView textView = this.k.f63900a;
            textView.setTextColor(textView.getTextColors().withAlpha(102));
            this.k.f63900a.getBackground().setAlpha(102);
            TextView textView2 = this.f63882h;
            textView2.setTextColor(textView2.getTextColors().withAlpha(102));
            TextView textView3 = this.l;
            textView3.setTextColor(textView3.getTextColors().withAlpha(102));
            TextView textView4 = this.f63883i;
            textView4.setTextColor(textView4.getTextColors().withAlpha(102));
            TextView textView5 = this.f63884j;
            textView5.setTextColor(textView5.getTextColors().withAlpha(102));
            TextView textView6 = this.m;
            textView6.setTextColor(textView6.getTextColors().withAlpha(102));
            TextView textView7 = this.n;
            textView7.setTextColor(textView7.getTextColors().withAlpha(102));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.wallet.personal.a.a.b
    public void a(int i2, CouponList.Coupon coupon) {
        TextView textView;
        String string;
        TextView textView2;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, coupon) == null) || i2 < 0 || coupon == null) {
            return;
        }
        if (!this.t || TextUtils.isEmpty(coupon.groupDesc)) {
            this.f63877c.setVisibility(8);
        } else {
            this.f63877c.setVisibility(0);
            this.f63877c.setText(coupon.groupDesc);
            this.f63877c.setOnClickListener(this.v);
        }
        if (!TextUtils.isEmpty(coupon.coupon_color_bg)) {
            ImageLoader.getInstance(this.f63876b.getContext()).getBitmap(coupon.coupon_color_bg, new ImageLoader.OnGetBitmapListener(this) { // from class: com.baidu.wallet.personal.ui.view.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f63885a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63885a = this;
                }

                @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                public boolean needCancel(String str2, Object obj) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str2, obj)) == null) {
                        return false;
                    }
                    return invokeLL.booleanValue;
                }

                @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                public void onError(String str2, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, obj) == null) {
                        this.f63885a.f63881g.f63898b = false;
                    }
                }

                @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                public void onGetBitmap(String str2, Object obj, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str2, obj, bitmap) == null) || bitmap == null) {
                        return;
                    }
                    this.f63885a.f63881g.f63897a.post(new Runnable(this, bitmap) { // from class: com.baidu.wallet.personal.ui.view.c.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Bitmap f63886a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f63887b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bitmap};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f63887b = this;
                            this.f63886a = bitmap;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f63887b.f63885a.f63881g.f63897a.setBackgroundDrawable(new BitmapDrawable(this.f63886a));
                                this.f63887b.f63885a.f63881g.f63898b = true;
                            }
                        }
                    });
                }
            }, null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
        }
        if (!TextUtils.isEmpty(coupon.coupon_color) && Build.VERSION.SDK_INT >= 16) {
            this.f63880f.setBackground(com.baidu.wallet.personal.b.b.a(this.f63876b.getContext(), com.baidu.wallet.personal.b.b.a(this.f63876b.getContext(), coupon.coupon_color, "coupon_base_red_f75348"), 0));
        }
        if (!TextUtils.isEmpty(coupon.coupon_name)) {
            if (coupon.coupon_name.length() > 7) {
                textView2 = this.f63882h;
                str = coupon.coupon_name.substring(0, 7);
            } else {
                textView2 = this.f63882h;
                str = coupon.coupon_name;
            }
            textView2.setText(str);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.f63900a.getLayoutParams();
        layoutParams.height = DisplayUtils.dip2px(this.f63876b.getContext(), 14.0f);
        this.k.f63900a.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(coupon.marketing_label)) {
            int dip2px = DisplayUtils.dip2px(this.f63876b.getContext(), 2.0f);
            this.k.f63900a.setPadding(dip2px, 0, dip2px, 0);
            this.k.f63900a.setText(coupon.marketing_label.length() > 6 ? coupon.marketing_label.substring(0, 6) : coupon.marketing_label);
            this.k.f63900a.setVisibility(0);
        }
        if (!TextUtils.isEmpty(coupon.marketing_label_bgpic)) {
            ImageLoader.getInstance(this.f63876b.getContext()).getBitmap(coupon.marketing_label_bgpic, new ImageLoader.OnGetBitmapListener(this, coupon, layoutParams) { // from class: com.baidu.wallet.personal.ui.view.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CouponList.Coupon f63888a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ RelativeLayout.LayoutParams f63889b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ c f63890c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, coupon, layoutParams};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63890c = this;
                    this.f63888a = coupon;
                    this.f63889b = layoutParams;
                }

                @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                public boolean needCancel(String str2, Object obj) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str2, obj)) == null) {
                        return false;
                    }
                    return invokeLL.booleanValue;
                }

                @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                public void onError(String str2, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, obj) == null) {
                        this.f63890c.k.f63901b = false;
                    }
                }

                @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
                public void onGetBitmap(String str2, Object obj, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str2, obj, bitmap) == null) || bitmap == null) {
                        return;
                    }
                    if (TextUtils.isEmpty(this.f63888a.marketing_label)) {
                        this.f63890c.f63876b.post(new Runnable(this, bitmap) { // from class: com.baidu.wallet.personal.ui.view.c.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Bitmap f63891a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f63892b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, bitmap};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f63892b = this;
                                this.f63891a = bitmap;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    AnonymousClass2 anonymousClass2 = this.f63892b;
                                    c cVar = anonymousClass2.f63890c;
                                    cVar.k.f63901b = true;
                                    anonymousClass2.f63889b.width = DisplayUtils.dip2px(cVar.f63876b.getContext(), 57.0f);
                                    AnonymousClass2 anonymousClass22 = this.f63892b;
                                    anonymousClass22.f63889b.height = DisplayUtils.dip2px(anonymousClass22.f63890c.f63876b.getContext(), 14.0f);
                                    AnonymousClass2 anonymousClass23 = this.f63892b;
                                    anonymousClass23.f63890c.k.f63900a.setLayoutParams(anonymousClass23.f63889b);
                                    this.f63892b.f63890c.k.f63900a.setBackgroundDrawable(new BitmapDrawable(this.f63891a));
                                    this.f63892b.f63890c.k.f63900a.setVisibility(0);
                                }
                            }
                        });
                        return;
                    }
                    com.baidu.wallet.personal.b.a aVar = new com.baidu.wallet.personal.b.a(this.f63890c.f63876b.getResources(), bitmap);
                    aVar.a(bitmap.getWidth() / 2, 1).b(bitmap.getHeight() / 2, 1);
                    NinePatchDrawable c2 = aVar.c();
                    if (c2 != null) {
                        this.f63890c.f63876b.post(new Runnable(this, c2) { // from class: com.baidu.wallet.personal.ui.view.c.2.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ NinePatchDrawable f63893a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f63894b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, c2};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f63894b = this;
                                this.f63893a = c2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    b bVar = this.f63894b.f63890c.k;
                                    bVar.f63901b = true;
                                    bVar.f63900a.setBackgroundDrawable(this.f63893a);
                                    if (this.f63894b.f63890c.k.f63900a.getVisibility() == 8) {
                                        this.f63894b.f63890c.k.f63900a.setVisibility(0);
                                    }
                                }
                            }
                        });
                    }
                }
            }, null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
        }
        if (TextUtils.isEmpty(coupon.date_message)) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
            this.l.setText(coupon.date_message);
        }
        if (TextUtils.isEmpty(coupon.sub_title)) {
            this.m.setVisibility(8);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams2.topMargin = DisplayUtils.dip2px(this.f63876b.getContext(), 8.5f);
            this.m.setLayoutParams(layoutParams2);
            this.m.setText(coupon.sub_title);
            this.m.setVisibility(0);
        }
        if (TextUtils.isEmpty(coupon.sub_title2)) {
            this.n.setVisibility(8);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams3.topMargin = DisplayUtils.dip2px(this.f63876b.getContext(), 7.0f);
            this.n.setLayoutParams(layoutParams3);
            this.n.setText(coupon.sub_title2);
            this.n.setVisibility(0);
        }
        if (TextUtils.isEmpty(coupon.list_scene_service_label)) {
            textView = this.r;
            string = ResUtils.getString(this.f63876b.getContext(), "去使用");
        } else {
            textView = this.r;
            string = coupon.list_scene_service_label;
        }
        textView.setText(string);
        if (TextUtils.isEmpty(coupon.use_limit) || this.f63875a) {
            this.o.setVisibility(8);
        } else {
            this.f63879e.bringToFront();
            this.q.setText(coupon.use_limit);
            if (!TextUtils.isEmpty(coupon.icon_url)) {
                this.p.setImageUrl(coupon.icon_url);
            }
            this.o.setVisibility(0);
            this.o.setOnClickListener(this.w);
        }
        if (!TextUtils.isEmpty(coupon.coupon_title_head)) {
            this.f63883i.setText(coupon.coupon_title_head);
        }
        if (!TextUtils.isEmpty(coupon.coupon_title_desc)) {
            this.f63884j.setText(coupon.coupon_title_desc);
        }
        if (coupon.app_scene_service != null || !TextUtils.isEmpty(coupon.list_scene_service_label)) {
            this.r.setText(coupon.list_scene_service_label);
        }
        if (!this.u) {
            this.s.setVisibility(8);
            return;
        }
        this.s.setBackgroundDrawable(ResUtils.getDrawable(this.f63876b.getContext(), "wallet_personal_coupon_new_icon"));
        this.s.setVisibility(0);
    }

    @Override // com.baidu.wallet.personal.a.a.b
    public void a(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.f63876b == null) {
            ViewGroup viewGroup = (ViewGroup) view;
            this.f63876b = viewGroup;
            this.f63879e = (RelativeLayout) viewGroup.findViewById(ResUtils.id(viewGroup.getContext(), "coupon_item_title_layout"));
            a aVar = this.f63881g;
            ViewGroup viewGroup2 = this.f63876b;
            aVar.f63897a = (RelativeLayout) viewGroup2.findViewById(ResUtils.id(viewGroup2.getContext(), "coupon_item_layout"));
            ViewGroup viewGroup3 = this.f63876b;
            this.f63878d = viewGroup3.findViewById(ResUtils.id(viewGroup3.getContext(), "mist_view"));
            ViewGroup viewGroup4 = this.f63876b;
            this.f63877c = (TextView) viewGroup4.findViewById(ResUtils.id(viewGroup4.getContext(), "group_title"));
            ViewGroup viewGroup5 = this.f63876b;
            this.f63880f = viewGroup5.findViewById(ResUtils.id(viewGroup5.getContext(), "icon"));
            ViewGroup viewGroup6 = this.f63876b;
            this.f63882h = (TextView) viewGroup6.findViewById(ResUtils.id(viewGroup6.getContext(), "coupon_name"));
            b bVar = this.k;
            ViewGroup viewGroup7 = this.f63876b;
            bVar.f63900a = (TextView) viewGroup7.findViewById(ResUtils.id(viewGroup7.getContext(), "market_label"));
            ViewGroup viewGroup8 = this.f63876b;
            this.l = (TextView) viewGroup8.findViewById(ResUtils.id(viewGroup8.getContext(), "date_msg"));
            ViewGroup viewGroup9 = this.f63876b;
            this.f63883i = (TextView) viewGroup9.findViewById(ResUtils.id(viewGroup9.getContext(), "coupon_title_head"));
            ViewGroup viewGroup10 = this.f63876b;
            this.f63884j = (TextView) viewGroup10.findViewById(ResUtils.id(viewGroup10.getContext(), "coupon_title_desc"));
            ViewGroup viewGroup11 = this.f63876b;
            this.m = (TextView) viewGroup11.findViewById(ResUtils.id(viewGroup11.getContext(), "sub_title"));
            ViewGroup viewGroup12 = this.f63876b;
            this.n = (TextView) viewGroup12.findViewById(ResUtils.id(viewGroup12.getContext(), "sub_title2"));
            ViewGroup viewGroup13 = this.f63876b;
            this.r = (TextView) viewGroup13.findViewById(ResUtils.id(viewGroup13.getContext(), "scene_service_label"));
            ViewGroup viewGroup14 = this.f63876b;
            this.s = (ImageView) viewGroup14.findViewById(ResUtils.id(viewGroup14.getContext(), "coupn_new"));
            ViewGroup viewGroup15 = this.f63876b;
            this.o = (LinearLayout) viewGroup15.findViewById(ResUtils.id(viewGroup15.getContext(), "use_limit_layout"));
            ViewGroup viewGroup16 = this.f63876b;
            this.p = (NetImageView) viewGroup16.findViewById(ResUtils.id(viewGroup16.getContext(), "use_limit_icon"));
            ViewGroup viewGroup17 = this.f63876b;
            this.q = (TextView) viewGroup17.findViewById(ResUtils.id(viewGroup17.getContext(), "use_limit"));
        }
    }

    @Override // com.baidu.wallet.personal.a.a.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.t = z;
        }
    }

    @Override // com.baidu.wallet.personal.a.a.b
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.u = z;
        }
    }

    @Override // com.baidu.wallet.personal.a.a.b
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f63875a = z;
        }
    }
}
