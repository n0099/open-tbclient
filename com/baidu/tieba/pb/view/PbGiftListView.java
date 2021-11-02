package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.a.e.a.j;
import b.a.e.e.m.b;
import b.a.q0.s.q.d1;
import b.a.r0.k2.f;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.l;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PbGiftListView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f52907e;

    /* renamed from: f  reason: collision with root package name */
    public View f52908f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f52909g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f52910h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f52911i;
    public TbImageView j;
    public TextView k;
    public TextView l;
    public String m;
    public String n;
    public long o;
    public long p;
    public long q;
    public int r;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbGiftListView f52912e;

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
            this.f52912e = pbGiftListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tbPageContext = (TbPageContext) j.a(this.f52912e.f52907e)) == null) {
                return;
            }
            if (TbadkCoreApplication.isLogin()) {
                if (StringUtils.isNull(this.f52912e.m)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), this.f52912e.o, this.f52912e.m, this.f52912e.n, GiftTabActivityConfig.FROM_PB, this.f52912e.p, this.f52912e.q)));
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

    public void fillGiftData(d1 d1Var, String str, String str2, long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{d1Var, str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.o = j;
            this.m = str;
            this.n = str2;
            this.q = j3;
            this.p = j2;
            if (d1Var != null && d1Var.a() != null && d1Var.a().size() > 0) {
                int size = d1Var.a().size() > 4 ? 4 : d1Var.a().size();
                if (size == 1) {
                    this.f52909g.startLoad(d1Var.a().get(0).f13270a, 10, false);
                    this.f52909g.setVisibility(0);
                    this.f52910h.setVisibility(8);
                    this.f52911i.setVisibility(8);
                    this.j.setVisibility(8);
                } else if (size == 2) {
                    this.f52909g.startLoad(d1Var.a().get(0).f13270a, 10, false);
                    this.f52910h.startLoad(d1Var.a().get(1).f13270a, 10, false);
                    this.f52909g.setVisibility(0);
                    this.f52910h.setVisibility(0);
                    this.f52911i.setVisibility(8);
                    this.j.setVisibility(8);
                } else if (size == 3) {
                    this.f52909g.startLoad(d1Var.a().get(0).f13270a, 10, false);
                    this.f52910h.startLoad(d1Var.a().get(1).f13270a, 10, false);
                    this.f52911i.startLoad(d1Var.a().get(2).f13270a, 10, false);
                    this.f52909g.setVisibility(0);
                    this.f52910h.setVisibility(0);
                    this.f52911i.setVisibility(0);
                    this.j.setVisibility(8);
                } else if (size == 4) {
                    this.f52909g.startLoad(d1Var.a().get(0).f13270a, 10, false);
                    this.f52910h.startLoad(d1Var.a().get(1).f13270a, 10, false);
                    this.f52911i.startLoad(d1Var.a().get(2).f13270a, 10, false);
                    this.j.startLoad(d1Var.a().get(3).f13270a, 10, false);
                    this.f52909g.setVisibility(0);
                    this.f52910h.setVisibility(0);
                    this.f52911i.setVisibility(0);
                    this.j.setVisibility(0);
                }
                if (d1Var.b() > 0) {
                    this.k.setText(String.format(this.f52907e.getResources().getString(l.gift_counts), Integer.valueOf(d1Var.b())));
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
                if (j == b.g(TbadkCoreApplication.getCurrentAccount(), 0L)) {
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
            View inflate = View.inflate(this.f52907e, b.a.r0.k2.j.pb_gift_list_item, this);
            this.f52908f = inflate;
            this.f52909g = (TbImageView) inflate.findViewById(i.pb_gift_view1);
            this.f52910h = (TbImageView) this.f52908f.findViewById(i.pb_gift_view2);
            this.f52911i = (TbImageView) this.f52908f.findViewById(i.pb_gift_view3);
            this.j = (TbImageView) this.f52908f.findViewById(i.pb_gift_view4);
            this.f52909g.setDefaultBgResource(h.transparent_bg);
            this.f52910h.setDefaultBgResource(h.transparent_bg);
            this.f52911i.setDefaultBgResource(h.transparent_bg);
            this.j.setDefaultBgResource(h.transparent_bg);
            this.f52909g.setDefaultResource(h.icon_gift_moren);
            this.f52910h.setDefaultResource(h.icon_gift_moren);
            this.f52911i.setDefaultResource(h.icon_gift_moren);
            this.j.setDefaultResource(h.icon_gift_moren);
            this.k = (TextView) this.f52908f.findViewById(i.pb_gift_number_view);
            TextView textView = (TextView) this.f52908f.findViewById(i.pb_gift_send_view);
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
        SkinManager.setViewTextColor(this.k, f.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.l, f.CAM_X0304, 1);
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
        this.f52907e = context;
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
        this.f52907e = context;
        g();
    }
}
