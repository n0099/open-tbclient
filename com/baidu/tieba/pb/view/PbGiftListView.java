package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.j;
import d.a.d.e.m.b;
import d.a.p0.s.q.c1;
/* loaded from: classes4.dex */
public class PbGiftListView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f20010e;

    /* renamed from: f  reason: collision with root package name */
    public View f20011f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f20012g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f20013h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f20014i;
    public TbImageView j;
    public TextView k;
    public TextView l;
    public String m;
    public String n;
    public long o;
    public long p;
    public long q;
    public int r;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbGiftListView f20015e;

        public a(PbGiftListView pbGiftListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbGiftListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20015e = pbGiftListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tbPageContext = (TbPageContext) j.a(this.f20015e.f20010e)) == null) {
                return;
            }
            if (TbadkCoreApplication.isLogin()) {
                if (StringUtils.isNull(this.f20015e.m)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), this.f20015e.o, this.f20015e.m, this.f20015e.n, GiftTabActivityConfig.FROM_PB, this.f20015e.p, this.f20015e.q)));
                return;
            }
            ViewHelper.checkUpIsLogin(tbPageContext.getPageActivity());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbGiftListView(Context context) {
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
        this.r = 3;
    }

    public void g(c1 c1Var, String str, String str2, long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{c1Var, str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.o = j;
            this.m = str;
            this.n = str2;
            this.q = j3;
            this.p = j2;
            if (c1Var != null && c1Var.a() != null && c1Var.a().size() > 0) {
                int size = c1Var.a().size() > 4 ? 4 : c1Var.a().size();
                if (size == 1) {
                    this.f20012g.M(c1Var.a().get(0).f53273a, 10, false);
                    this.f20012g.setVisibility(0);
                    this.f20013h.setVisibility(8);
                    this.f20014i.setVisibility(8);
                    this.j.setVisibility(8);
                } else if (size == 2) {
                    this.f20012g.M(c1Var.a().get(0).f53273a, 10, false);
                    this.f20013h.M(c1Var.a().get(1).f53273a, 10, false);
                    this.f20012g.setVisibility(0);
                    this.f20013h.setVisibility(0);
                    this.f20014i.setVisibility(8);
                    this.j.setVisibility(8);
                } else if (size == 3) {
                    this.f20012g.M(c1Var.a().get(0).f53273a, 10, false);
                    this.f20013h.M(c1Var.a().get(1).f53273a, 10, false);
                    this.f20014i.M(c1Var.a().get(2).f53273a, 10, false);
                    this.f20012g.setVisibility(0);
                    this.f20013h.setVisibility(0);
                    this.f20014i.setVisibility(0);
                    this.j.setVisibility(8);
                } else if (size == 4) {
                    this.f20012g.M(c1Var.a().get(0).f53273a, 10, false);
                    this.f20013h.M(c1Var.a().get(1).f53273a, 10, false);
                    this.f20014i.M(c1Var.a().get(2).f53273a, 10, false);
                    this.j.M(c1Var.a().get(3).f53273a, 10, false);
                    this.f20012g.setVisibility(0);
                    this.f20013h.setVisibility(0);
                    this.f20014i.setVisibility(0);
                    this.j.setVisibility(0);
                }
                if (c1Var.b() > 0) {
                    this.k.setText(String.format(this.f20010e.getResources().getString(R.string.gift_counts), Integer.valueOf(c1Var.b())));
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
                if (j == b.f(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                    this.l.setVisibility(8);
                    return;
                } else {
                    this.l.setVisibility(0);
                    return;
                }
            }
            setVisibility(8);
        }
    }

    public long getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q : invokeV.longValue;
    }

    public long getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : invokeV.longValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = View.inflate(this.f20010e, R.layout.pb_gift_list_item, this);
            this.f20011f = inflate;
            this.f20012g = (TbImageView) inflate.findViewById(R.id.pb_gift_view1);
            this.f20013h = (TbImageView) this.f20011f.findViewById(R.id.pb_gift_view2);
            this.f20014i = (TbImageView) this.f20011f.findViewById(R.id.pb_gift_view3);
            this.j = (TbImageView) this.f20011f.findViewById(R.id.pb_gift_view4);
            this.f20012g.setDefaultBgResource(R.drawable.transparent_bg);
            this.f20013h.setDefaultBgResource(R.drawable.transparent_bg);
            this.f20014i.setDefaultBgResource(R.drawable.transparent_bg);
            this.j.setDefaultBgResource(R.drawable.transparent_bg);
            this.f20012g.setDefaultResource(R.drawable.icon_gift_moren);
            this.f20013h.setDefaultResource(R.drawable.icon_gift_moren);
            this.f20014i.setDefaultResource(R.drawable.icon_gift_moren);
            this.j.setDefaultResource(R.drawable.icon_gift_moren);
            this.k = (TextView) this.f20011f.findViewById(R.id.pb_gift_number_view);
            TextView textView = (TextView) this.f20011f.findViewById(R.id.pb_gift_send_view);
            this.l = textView;
            textView.setOnClickListener(new a(this));
        }
    }

    public void i() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.r == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.r = skinType;
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0304, 1);
    }

    public void setPostId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.q = j;
        }
    }

    public void setThreadId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.p = j;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbGiftListView(Context context, AttributeSet attributeSet) {
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
        this.r = 3;
        this.f20010e = context;
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbGiftListView(Context context, AttributeSet attributeSet, int i2) {
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
        this.r = 3;
        this.f20010e = context;
        h();
    }
}
