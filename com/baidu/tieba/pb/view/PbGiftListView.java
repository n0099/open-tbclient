package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.d.f.m.b;
import c.a.q0.s.q.d1;
import c.a.r0.q2.f;
import c.a.r0.q2.h;
import c.a.r0.q2.i;
import c.a.r0.q2.l;
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
/* loaded from: classes11.dex */
public class PbGiftListView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f48080e;

    /* renamed from: f  reason: collision with root package name */
    public View f48081f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f48082g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f48083h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f48084i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f48085j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f48086k;
    public TextView l;
    public String m;
    public String n;
    public long o;
    public long p;
    public long q;
    public int r;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbGiftListView f48087e;

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
            this.f48087e = pbGiftListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tbPageContext = (TbPageContext) j.a(this.f48087e.f48080e)) == null) {
                return;
            }
            if (TbadkCoreApplication.isLogin()) {
                if (StringUtils.isNull(this.f48087e.m)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), this.f48087e.o, this.f48087e.m, this.f48087e.n, GiftTabActivityConfig.FROM_PB, this.f48087e.p, this.f48087e.q)));
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
                    this.f48082g.startLoad(d1Var.a().get(0).a, 10, false);
                    this.f48082g.setVisibility(0);
                    this.f48083h.setVisibility(8);
                    this.f48084i.setVisibility(8);
                    this.f48085j.setVisibility(8);
                } else if (size == 2) {
                    this.f48082g.startLoad(d1Var.a().get(0).a, 10, false);
                    this.f48083h.startLoad(d1Var.a().get(1).a, 10, false);
                    this.f48082g.setVisibility(0);
                    this.f48083h.setVisibility(0);
                    this.f48084i.setVisibility(8);
                    this.f48085j.setVisibility(8);
                } else if (size == 3) {
                    this.f48082g.startLoad(d1Var.a().get(0).a, 10, false);
                    this.f48083h.startLoad(d1Var.a().get(1).a, 10, false);
                    this.f48084i.startLoad(d1Var.a().get(2).a, 10, false);
                    this.f48082g.setVisibility(0);
                    this.f48083h.setVisibility(0);
                    this.f48084i.setVisibility(0);
                    this.f48085j.setVisibility(8);
                } else if (size == 4) {
                    this.f48082g.startLoad(d1Var.a().get(0).a, 10, false);
                    this.f48083h.startLoad(d1Var.a().get(1).a, 10, false);
                    this.f48084i.startLoad(d1Var.a().get(2).a, 10, false);
                    this.f48085j.startLoad(d1Var.a().get(3).a, 10, false);
                    this.f48082g.setVisibility(0);
                    this.f48083h.setVisibility(0);
                    this.f48084i.setVisibility(0);
                    this.f48085j.setVisibility(0);
                }
                if (d1Var.b() > 0) {
                    this.f48086k.setText(String.format(this.f48080e.getResources().getString(l.gift_counts), Integer.valueOf(d1Var.b())));
                    this.f48086k.setVisibility(0);
                } else {
                    this.f48086k.setVisibility(8);
                }
                if (j2 == b.g(TbadkCoreApplication.getCurrentAccount(), 0L)) {
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
            View inflate = View.inflate(this.f48080e, c.a.r0.q2.j.pb_gift_list_item, this);
            this.f48081f = inflate;
            this.f48082g = (TbImageView) inflate.findViewById(i.pb_gift_view1);
            this.f48083h = (TbImageView) this.f48081f.findViewById(i.pb_gift_view2);
            this.f48084i = (TbImageView) this.f48081f.findViewById(i.pb_gift_view3);
            this.f48085j = (TbImageView) this.f48081f.findViewById(i.pb_gift_view4);
            this.f48082g.setDefaultBgResource(h.transparent_bg);
            this.f48083h.setDefaultBgResource(h.transparent_bg);
            this.f48084i.setDefaultBgResource(h.transparent_bg);
            this.f48085j.setDefaultBgResource(h.transparent_bg);
            this.f48082g.setDefaultResource(h.icon_gift_moren);
            this.f48083h.setDefaultResource(h.icon_gift_moren);
            this.f48084i.setDefaultResource(h.icon_gift_moren);
            this.f48085j.setDefaultResource(h.icon_gift_moren);
            this.f48086k = (TextView) this.f48081f.findViewById(i.pb_gift_number_view);
            TextView textView = (TextView) this.f48081f.findViewById(i.pb_gift_send_view);
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
        SkinManager.setViewTextColor(this.f48086k, f.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.l, f.CAM_X0304, 1);
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
        this.f48080e = context;
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
        this.f48080e = context;
        g();
    }
}
