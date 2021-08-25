package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.e.a.j;
import c.a.e.e.m.b;
import c.a.p0.s.q.d1;
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
/* loaded from: classes7.dex */
public class PbGiftListView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f55536e;

    /* renamed from: f  reason: collision with root package name */
    public View f55537f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f55538g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f55539h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f55540i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f55541j;
    public TextView k;
    public TextView l;
    public String m;
    public String n;
    public long o;
    public long p;
    public long q;
    public int r;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbGiftListView f55542e;

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
            this.f55542e = pbGiftListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tbPageContext = (TbPageContext) j.a(this.f55542e.f55536e)) == null) {
                return;
            }
            if (TbadkCoreApplication.isLogin()) {
                if (StringUtils.isNull(this.f55542e.m)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), this.f55542e.o, this.f55542e.m, this.f55542e.n, GiftTabActivityConfig.FROM_PB, this.f55542e.p, this.f55542e.q)));
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

    public void fillGiftData(d1 d1Var, String str, String str2, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{d1Var, str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            this.o = j2;
            this.m = str;
            this.n = str2;
            this.q = j4;
            this.p = j3;
            if (d1Var != null && d1Var.a() != null && d1Var.a().size() > 0) {
                int size = d1Var.a().size() > 4 ? 4 : d1Var.a().size();
                if (size == 1) {
                    this.f55538g.startLoad(d1Var.a().get(0).f14185a, 10, false);
                    this.f55538g.setVisibility(0);
                    this.f55539h.setVisibility(8);
                    this.f55540i.setVisibility(8);
                    this.f55541j.setVisibility(8);
                } else if (size == 2) {
                    this.f55538g.startLoad(d1Var.a().get(0).f14185a, 10, false);
                    this.f55539h.startLoad(d1Var.a().get(1).f14185a, 10, false);
                    this.f55538g.setVisibility(0);
                    this.f55539h.setVisibility(0);
                    this.f55540i.setVisibility(8);
                    this.f55541j.setVisibility(8);
                } else if (size == 3) {
                    this.f55538g.startLoad(d1Var.a().get(0).f14185a, 10, false);
                    this.f55539h.startLoad(d1Var.a().get(1).f14185a, 10, false);
                    this.f55540i.startLoad(d1Var.a().get(2).f14185a, 10, false);
                    this.f55538g.setVisibility(0);
                    this.f55539h.setVisibility(0);
                    this.f55540i.setVisibility(0);
                    this.f55541j.setVisibility(8);
                } else if (size == 4) {
                    this.f55538g.startLoad(d1Var.a().get(0).f14185a, 10, false);
                    this.f55539h.startLoad(d1Var.a().get(1).f14185a, 10, false);
                    this.f55540i.startLoad(d1Var.a().get(2).f14185a, 10, false);
                    this.f55541j.startLoad(d1Var.a().get(3).f14185a, 10, false);
                    this.f55538g.setVisibility(0);
                    this.f55539h.setVisibility(0);
                    this.f55540i.setVisibility(0);
                    this.f55541j.setVisibility(0);
                }
                if (d1Var.b() > 0) {
                    this.k.setText(String.format(this.f55536e.getResources().getString(R.string.gift_counts), Integer.valueOf(d1Var.b())));
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
                if (j2 == b.f(TbadkCoreApplication.getCurrentAccount(), 0L)) {
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

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = View.inflate(this.f55536e, R.layout.pb_gift_list_item, this);
            this.f55537f = inflate;
            this.f55538g = (TbImageView) inflate.findViewById(R.id.pb_gift_view1);
            this.f55539h = (TbImageView) this.f55537f.findViewById(R.id.pb_gift_view2);
            this.f55540i = (TbImageView) this.f55537f.findViewById(R.id.pb_gift_view3);
            this.f55541j = (TbImageView) this.f55537f.findViewById(R.id.pb_gift_view4);
            this.f55538g.setDefaultBgResource(R.drawable.transparent_bg);
            this.f55539h.setDefaultBgResource(R.drawable.transparent_bg);
            this.f55540i.setDefaultBgResource(R.drawable.transparent_bg);
            this.f55541j.setDefaultBgResource(R.drawable.transparent_bg);
            this.f55538g.setDefaultResource(R.drawable.icon_gift_moren);
            this.f55539h.setDefaultResource(R.drawable.icon_gift_moren);
            this.f55540i.setDefaultResource(R.drawable.icon_gift_moren);
            this.f55541j.setDefaultResource(R.drawable.icon_gift_moren);
            this.k = (TextView) this.f55537f.findViewById(R.id.pb_gift_number_view);
            TextView textView = (TextView) this.f55537f.findViewById(R.id.pb_gift_send_view);
            this.l = textView;
            textView.setOnClickListener(new a(this));
        }
    }

    public long getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : invokeV.longValue;
    }

    public long getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.p : invokeV.longValue;
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.r == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.r = skinType;
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0304, 1);
    }

    public void setPostId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.q = j2;
        }
    }

    public void setThreadId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.p = j2;
        }
    }

    public void showGiftSendView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
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
        this.f55536e = context;
        g();
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
        this.f55536e = context;
        g();
    }
}
