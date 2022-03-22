package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.d.f.m.b;
import c.a.o0.r.r.b1;
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
/* loaded from: classes5.dex */
public class PbGiftListView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f35270b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f35271c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f35272d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f35273e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f35274f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f35275g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f35276h;
    public String i;
    public String j;
    public long k;
    public long l;
    public long m;
    public int n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbGiftListView a;

        public a(PbGiftListView pbGiftListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbGiftListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbGiftListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (tbPageContext = (TbPageContext) j.a(this.a.a)) == null) {
                return;
            }
            if (TbadkCoreApplication.isLogin()) {
                if (StringUtils.isNull(this.a.i)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), this.a.k, this.a.i, this.a.j, GiftTabActivityConfig.FROM_PB, this.a.l, this.a.m)));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 3;
    }

    public void g(b1 b1Var, String str, String str2, long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{b1Var, str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.k = j;
            this.i = str;
            this.j = str2;
            this.m = j3;
            this.l = j2;
            if (b1Var != null && b1Var.a() != null && b1Var.a().size() > 0) {
                int size = b1Var.a().size() > 4 ? 4 : b1Var.a().size();
                if (size == 1) {
                    this.f35271c.J(b1Var.a().get(0).a, 10, false);
                    this.f35271c.setVisibility(0);
                    this.f35272d.setVisibility(8);
                    this.f35273e.setVisibility(8);
                    this.f35274f.setVisibility(8);
                } else if (size == 2) {
                    this.f35271c.J(b1Var.a().get(0).a, 10, false);
                    this.f35272d.J(b1Var.a().get(1).a, 10, false);
                    this.f35271c.setVisibility(0);
                    this.f35272d.setVisibility(0);
                    this.f35273e.setVisibility(8);
                    this.f35274f.setVisibility(8);
                } else if (size == 3) {
                    this.f35271c.J(b1Var.a().get(0).a, 10, false);
                    this.f35272d.J(b1Var.a().get(1).a, 10, false);
                    this.f35273e.J(b1Var.a().get(2).a, 10, false);
                    this.f35271c.setVisibility(0);
                    this.f35272d.setVisibility(0);
                    this.f35273e.setVisibility(0);
                    this.f35274f.setVisibility(8);
                } else if (size == 4) {
                    this.f35271c.J(b1Var.a().get(0).a, 10, false);
                    this.f35272d.J(b1Var.a().get(1).a, 10, false);
                    this.f35273e.J(b1Var.a().get(2).a, 10, false);
                    this.f35274f.J(b1Var.a().get(3).a, 10, false);
                    this.f35271c.setVisibility(0);
                    this.f35272d.setVisibility(0);
                    this.f35273e.setVisibility(0);
                    this.f35274f.setVisibility(0);
                }
                if (b1Var.b() > 0) {
                    this.f35275g.setText(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0793), Integer.valueOf(b1Var.b())));
                    this.f35275g.setVisibility(0);
                } else {
                    this.f35275g.setVisibility(8);
                }
                if (j == b.g(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                    this.f35276h.setVisibility(8);
                    return;
                } else {
                    this.f35276h.setVisibility(0);
                    return;
                }
            }
            setVisibility(8);
        }
    }

    public long getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : invokeV.longValue;
    }

    public long getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : invokeV.longValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = View.inflate(this.a, R.layout.obfuscated_res_0x7f0d067e, this);
            this.f35270b = inflate;
            this.f35271c = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0916c1);
            this.f35272d = (TbImageView) this.f35270b.findViewById(R.id.obfuscated_res_0x7f0916c2);
            this.f35273e = (TbImageView) this.f35270b.findViewById(R.id.obfuscated_res_0x7f0916c3);
            this.f35274f = (TbImageView) this.f35270b.findViewById(R.id.obfuscated_res_0x7f0916c4);
            this.f35271c.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
            this.f35272d.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
            this.f35273e.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
            this.f35274f.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
            this.f35271c.setDefaultResource(R.drawable.icon_gift_moren);
            this.f35272d.setDefaultResource(R.drawable.icon_gift_moren);
            this.f35273e.setDefaultResource(R.drawable.icon_gift_moren);
            this.f35274f.setDefaultResource(R.drawable.icon_gift_moren);
            this.f35275g = (TextView) this.f35270b.findViewById(R.id.obfuscated_res_0x7f0916bf);
            TextView textView = (TextView) this.f35270b.findViewById(R.id.obfuscated_res_0x7f0916c0);
            this.f35276h = textView;
            textView.setOnClickListener(new a(this));
        }
    }

    public void i() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.n == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.n = skinType;
        SkinManager.setViewTextColor(this.f35275g, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.f35276h, R.color.CAM_X0304, 1);
    }

    public void setPostId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.m = j;
        }
    }

    public void setThreadId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.l = j;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = 3;
        this.a = context;
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbGiftListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.n = 3;
        this.a = context;
        h();
    }
}
