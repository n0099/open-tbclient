package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.m.e;
import c.a.r0.s.v.c;
import c.a.s0.n4.d;
import c.a.s0.n4.f;
import c.a.s0.n4.g;
import c.a.s0.n4.h;
import c.a.s0.n4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class TitleTipView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f51470e;

    /* renamed from: f  reason: collision with root package name */
    public int f51471f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f51472g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f51473h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f51474i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f51475j;

    /* renamed from: k  reason: collision with root package name */
    public View f51476k;
    public View.OnClickListener l;
    public Runnable m;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TitleTipView f51477e;

        public a(TitleTipView titleTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {titleTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51477e = titleTipView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51477e.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TitleTipView f51478e;

        public b(TitleTipView titleTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {titleTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51478e = titleTipView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51478e.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleTipView(Context context) {
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
        this.f51470e = 3;
        this.f51471f = 5000;
        this.l = new a(this);
        this.m = new b(this);
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View.inflate(getContext(), h.title_tip_layout, this);
            this.f51472g = (LinearLayout) findViewById(g.tip_bg);
            this.f51473h = (ImageView) findViewById(g.img_icon);
            this.f51474i = (ImageView) findViewById(g.img_close);
            this.f51475j = (TextView) findViewById(g.tv_tip);
            this.f51476k = findViewById(g.tv_line);
            this.f51475j.setText(j.add_title_tip);
            this.f51474i.setOnClickListener(this.l);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(8);
            e.a().removeCallbacks(this.m);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f51470e != i2) {
                c d2 = c.d(this.f51472g);
                d2.n(j.J_X05);
                d2.l(c.a.s0.n4.e.L_X01);
                d2.k(d.CAM_X0602);
                d2.f(d.CAM_X0206);
                c.d(this.f51476k).f(d.CAM_X0203);
                c.d(this.f51475j).v(d.CAM_X0107);
                this.f51474i.setImageDrawable(WebPManager.getPureDrawable(f.icon_pure_home_delete16, SkinManager.getColor(d.CAM_X0107), null));
                if (this.f51473h != null) {
                    this.f51473h.setImageDrawable(WebPManager.getPureDrawable(f.pic_post_fatiemijue, SkinManager.getColor(d.CAM_X0302), null));
                }
            }
            this.f51470e = i2;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(0);
        }
    }

    public void showAndAutoDissmiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(0);
            e.a().postDelayed(this.m, this.f51471f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleTipView(Context context, AttributeSet attributeSet) {
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
        this.f51470e = 3;
        this.f51471f = 5000;
        this.l = new a(this);
        this.m = new b(this);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleTipView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f51470e = 3;
        this.f51471f = 5000;
        this.l = new a(this);
        this.m = new b(this);
        a();
    }
}
