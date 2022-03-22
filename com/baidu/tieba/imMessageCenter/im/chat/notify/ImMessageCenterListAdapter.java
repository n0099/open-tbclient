package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.p0.a4.i0;
import c.a.p0.u1.f.i.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes5.dex */
public class ImMessageCenterListAdapter extends c.a.p0.u1.f.i.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.v1.b.e f33962d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f33963e;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterShowItemData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f33964b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f33965c;

        public a(ImMessageCenterListAdapter imMessageCenterListAdapter, ImMessageCenterShowItemData imMessageCenterShowItemData, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterListAdapter, imMessageCenterShowItemData, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33965c = imMessageCenterListAdapter;
            this.a = imMessageCenterShowItemData;
            this.f33964b = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.getIsLike() != 1) {
                    this.f33965c.B(this.f33964b, this.a);
                    this.f33965c.A(this.a, 1);
                    return;
                }
                this.f33965c.C(this.f33964b, this.a);
                this.f33965c.A(this.a, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LikeModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f33966b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f33967c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f33968d;

        public b(ImMessageCenterListAdapter imMessageCenterListAdapter, LikeModel likeModel, ImMessageCenterShowItemData imMessageCenterShowItemData, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterListAdapter, likeModel, imMessageCenterShowItemData, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33968d = imMessageCenterListAdapter;
            this.a = likeModel;
            this.f33966b = imMessageCenterShowItemData;
            this.f33967c = gVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.getErrorCode() == 22) {
                    n.N(this.f33968d.a, this.f33968d.a.getString(R.string.obfuscated_res_0x7f0f0802));
                } else if (obj == null) {
                } else {
                    if (this.a.getErrorCode() != 0) {
                        n.N(this.f33968d.a, this.a.getErrorString());
                        return;
                    }
                    this.f33966b.setIsLike(1);
                    this.f33968d.N(this.f33967c, true);
                    n.N(this.f33968d.a, this.f33968d.a.getString(R.string.obfuscated_res_0x7f0f02ab));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements i0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterShowItemData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f33969b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f33970c;

        public c(ImMessageCenterListAdapter imMessageCenterListAdapter, ImMessageCenterShowItemData imMessageCenterShowItemData, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterListAdapter, imMessageCenterShowItemData, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33970c = imMessageCenterListAdapter;
            this.a = imMessageCenterShowItemData;
            this.f33969b = gVar;
        }

        @Override // c.a.p0.a4.i0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // c.a.p0.a4.i0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.setIsLike(0);
                this.f33970c.N(this.f33969b, false);
                n.N(this.f33970c.a, this.f33970c.a.getString(R.string.obfuscated_res_0x7f0f145f));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f33971b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f33972c;

        /* renamed from: d  reason: collision with root package name */
        public View f33973d;

        public d(ImMessageCenterListAdapter imMessageCenterListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(ImMessageCenterListAdapter imMessageCenterListAdapter, a aVar) {
            this(imMessageCenterListAdapter);
        }
    }

    /* loaded from: classes5.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        public e(ImMessageCenterListAdapter imMessageCenterListAdapter, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterListAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090e63);
        }
    }

    /* loaded from: classes5.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        public f(ImMessageCenterListAdapter imMessageCenterListAdapter, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterListAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090e67);
        }
    }

    /* loaded from: classes5.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f33974b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f33975c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f33976d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f33977e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f33978f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f33979g;

        /* renamed from: h  reason: collision with root package name */
        public View f33980h;
        public TBSpecificationBtn i;

        public g(ImMessageCenterListAdapter imMessageCenterListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(ImMessageCenterListAdapter imMessageCenterListAdapter, a aVar) {
            this(imMessageCenterListAdapter);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImMessageCenterListAdapter(Context context) {
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
        this.f33962d = null;
        this.f33963e = null;
    }

    public final void A(ImMessageCenterShowItemData imMessageCenterShowItemData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, imMessageCenterShowItemData, i) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.IM_REC_FORUM_ATTENTION_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", imMessageCenterShowItemData.getForumId());
            statisticItem.param("fname", imMessageCenterShowItemData.getForumName());
            statisticItem.param("obj_type", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void B(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, imMessageCenterShowItemData) == null) {
            LikeModel likeModel = new LikeModel(this.f33963e);
            if (!n.C()) {
                Context context = this.a;
                UtilHelper.showToast(context, context.getString(R.string.obfuscated_res_0x7f0f0c15));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.a)) {
            } else {
                likeModel.setLoadDataCallBack(new b(this, likeModel, imMessageCenterShowItemData, gVar));
                if (m.isForumName(imMessageCenterShowItemData.getForumName())) {
                    likeModel.P(imMessageCenterShowItemData.getForumName(), String.valueOf(imMessageCenterShowItemData.getForumId()));
                }
            }
        }
    }

    public final void C(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, imMessageCenterShowItemData) == null) {
            if (!n.C()) {
                Context context = this.a;
                UtilHelper.showToast(context, context.getString(R.string.obfuscated_res_0x7f0f0c15));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.a)) {
            } else {
                i0 i0Var = new i0();
                i0Var.b(new c(this, imMessageCenterShowItemData, gVar));
                i0Var.c(imMessageCenterShowItemData.getForumName(), imMessageCenterShowItemData.getForumId());
            }
        }
    }

    public final d D(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            d dVar = new d(this, null);
            dVar.a = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090e5b);
            dVar.f33971b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090e5c);
            dVar.f33972c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090e5d);
            dVar.f33973d = view.findViewById(R.id.obfuscated_res_0x7f090e5a);
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final g E(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            g gVar = new g(this, null);
            gVar.a = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091aef);
            gVar.f33974b = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f090e61);
            gVar.f33975c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090e65);
            gVar.f33976d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090e66);
            gVar.f33977e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090e62);
            gVar.f33978f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090e60);
            gVar.f33979g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090e64);
            gVar.f33980h = view.findViewById(R.id.obfuscated_res_0x7f090e68);
            gVar.i = (TBSpecificationBtn) view.findViewById(R.id.obfuscated_res_0x7f090e5f);
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public final void F(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            SkinManager.setImageResource(dVar.a, R.drawable.im_no_data_icon);
            dVar.a.setUseNightOrDarkMask(false);
            dVar.f33971b.setText(this.a.getString(R.string.obfuscated_res_0x7f0f089f));
            dVar.f33972c.setText(this.a.getString(R.string.obfuscated_res_0x7f0f08a0));
        }
    }

    public final void G(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(dVar.f33971b);
            d2.v(R.color.CAM_X0107);
            d2.z(R.dimen.T_X07);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(dVar.f33972c);
            d3.v(R.color.CAM_X0110);
            d3.z(R.dimen.T_X08);
            c.a.o0.r.v.c.d(dVar.f33973d).f(R.color.CAM_X0204);
        }
    }

    public final void H(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(eVar.a);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X08);
        }
    }

    public final void I(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(fVar.a);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
        }
    }

    public final void J(g gVar, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, gVar, i, imMessageCenterShowItemData) == null) {
            gVar.f33974b.setShowOval(true);
            gVar.f33974b.setAutoChangeStyle(true);
            gVar.f33974b.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            gVar.f33974b.setStrokeColorResId(R.color.CAM_X0401);
            gVar.f33974b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            gVar.f33974b.setPlaceHolder(1);
            gVar.f33974b.J(imMessageCenterShowItemData.getAvatar(), 10, false);
            gVar.f33976d.setText(imMessageCenterShowItemData.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f063c));
            if (!StringUtils.isNull(imMessageCenterShowItemData.getSlogan())) {
                gVar.f33977e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f08a1, imMessageCenterShowItemData.getSlogan()));
            } else {
                gVar.f33977e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f08a3));
            }
            gVar.f33978f.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f040e), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getMemberCount())));
            gVar.f33979g.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f06a6), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getThreadCount())));
            gVar.f33975c.setText(String.valueOf(i - 1));
            N(gVar, imMessageCenterShowItemData.getIsLike() == 1);
            gVar.i.setOnClickListener(new a(this, imMessageCenterShowItemData, gVar));
        }
    }

    public final void K(g gVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, gVar, i) == null) {
            int i2 = i == 2 ? R.color.CAM_X0301 : i == 3 ? R.color.CAM_X0319 : i == 4 ? R.color.CAM_X0305 : R.color.CAM_X0315;
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(gVar.f33975c);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0101);
            d2.n(R.string.J_X04);
            d2.f(i2);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(gVar.f33976d);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X06);
            c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(gVar.f33977e);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X09);
            c.a.o0.r.v.c d5 = c.a.o0.r.v.c.d(gVar.f33978f);
            d5.v(R.color.CAM_X0109);
            d5.z(R.dimen.T_X09);
            c.a.o0.r.v.c d6 = c.a.o0.r.v.c.d(gVar.f33979g);
            d6.v(R.color.CAM_X0109);
            d6.z(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(gVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void L(c.a.p0.v1.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f33962d = eVar;
        }
    }

    public final void M(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, imMessageCenterShowItemData) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.IM_REC_FORUM_ITEM_SHOW_KEY);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", imMessageCenterShowItemData.getForumId());
            statisticItem.param("fname", imMessageCenterShowItemData.getForumName());
            TiebaStatic.log(statisticItem);
        }
    }

    public void N(g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, gVar, z) == null) {
            if (z) {
                c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
                bVar.t(R.color.CAM_X0109);
                gVar.i.setConfig(bVar);
                gVar.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f68));
                gVar.i.setClickState(false);
            } else {
                c.a.o0.r.l0.n.b bVar2 = new c.a.o0.r.l0.n.b();
                bVar2.r(R.color.CAM_X0302);
                gVar.i.setConfig(bVar2);
                gVar.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029b));
                gVar.i.setClickState(true);
            }
            gVar.i.k();
        }
    }

    @Override // c.a.p0.u1.f.i.c
    public boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null) {
                return false;
            }
            return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.u1.f.i.c
    public boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null) {
                return false;
            }
            return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.u1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.f18694b.setDrawerType(1);
            aVar.f18694b.setRadius(n.d(this.a, 4.0f));
            aVar.f18695c.setClickable(false);
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f18694b.setDrawBorder(false);
                aVar.f18694b.setAutoChangeStyle(true);
                aVar.f18694b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f18694b.setVisibility(0);
                aVar.f18695c.setVisibility(8);
                if (MessageManager.getInstance().runTask(2001287, Integer.class) != null) {
                    SkinManager.setImageResource(aVar.f18694b, R.drawable.icon_new_test);
                }
                aVar.f18694b.setUserName(String.valueOf(2));
                aVar.f18694b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f18694b.setIsRound(false);
                aVar.f18694b.invalidate();
            } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f18694b.setDrawBorder(false);
                aVar.f18694b.setAutoChangeStyle(true);
                aVar.f18694b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f18694b.setUserName(String.valueOf(3));
                aVar.f18694b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f18694b.setVisibility(0);
                aVar.f18695c.setVisibility(8);
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, Integer.class);
                if (runTask != null) {
                    SkinManager.setImageResource(aVar.f18694b, ((Integer) runTask.getData()).intValue());
                }
                aVar.f18694b.setIsRound(false);
                aVar.f18694b.invalidate();
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f18694b.setDrawBorder(true);
                aVar.f18694b.setAutoChangeStyle(true);
                aVar.f18694b.setUserId(imMessageCenterShowItemData.getFriendId());
                String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f18694b.setImageDrawable(null);
                aVar.f18694b.setVisibility(0);
                aVar.f18695c.setVisibility(8);
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    aVar.f18694b.J(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
                } else {
                    aVar.f18694b.J(friendBjhAvatar, 10, false);
                }
                aVar.f18694b.setClickable(false);
                aVar.f18694b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f18694b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f18694b.setUserName(String.valueOf(1));
                aVar.f18694b.setIsRound(false);
                aVar.f18694b.invalidate();
            } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f18694b.setDrawBorder(false);
                aVar.f18694b.setAutoChangeStyle(true);
                aVar.f18694b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f18694b.setUserName(String.valueOf(5));
                aVar.f18694b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f18694b.setVisibility(4);
                aVar.f18695c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f18695c, R.drawable.obfuscated_res_0x7f0805e7, SvgManager.SvgResourceStateType.NORMAL);
                aVar.f18694b.setIsRound(false);
                aVar.f18694b.invalidate();
            } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f18694b.setDrawBorder(true);
                aVar.f18694b.setAutoChangeStyle(true);
                String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f18694b.setVisibility(0);
                aVar.f18695c.setVisibility(8);
                aVar.f18694b.setImageDrawable(null);
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001289, Integer.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        aVar.f18694b.J(((Integer) runTask2.getData()).toString(), 24, false);
                    }
                } else {
                    aVar.f18694b.J(friendBjhAvatar2, 12, false);
                }
                aVar.f18694b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f18694b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f18694b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.f18694b.setIsRound(false);
                aVar.f18694b.invalidate();
            } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f18694b.setDrawBorder(false);
                aVar.f18694b.setAutoChangeStyle(true);
                aVar.f18694b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f18694b.setUserName(String.valueOf(7));
                aVar.f18694b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f18694b.setVisibility(4);
                aVar.f18695c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f18695c, R.drawable.obfuscated_res_0x7f0805ef, SvgManager.SvgResourceStateType.NORMAL);
                aVar.f18694b.setIsRound(false);
                aVar.f18694b.invalidate();
            } else {
                aVar.f18694b.setDrawBorder(true);
                aVar.f18694b.setAutoChangeStyle(true);
                String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar3)) {
                    friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f18694b.setImageDrawable(null);
                aVar.f18694b.setVisibility(0);
                aVar.f18695c.setVisibility(8);
                if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                    aVar.f18694b.J(friendBjhAvatar3, 12, false);
                } else {
                    aVar.f18694b.J(String.valueOf((int) R.drawable.obfuscated_res_0x7f080ecd), 24, false);
                }
                aVar.f18694b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f18694b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f18694b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.f18694b.setIsRound(false);
                aVar.f18694b.invalidate();
            }
        }
    }

    @Override // c.a.p0.u1.f.i.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        f fVar;
        g E;
        d D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048593, this, i, view, viewGroup)) == null) {
            ImMessageCenterShowItemData item = getItem(i);
            if (TbSingleton.getInstance().isImRecForumShow() && item != null) {
                if (item.getDataType() == 1) {
                    if (view != null && (view.getTag() instanceof d)) {
                        D = (d) view.getTag();
                    } else {
                        view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03cd, viewGroup, false);
                        D = D(view);
                        view.setTag(D);
                    }
                    G(D);
                    F(D);
                    return view;
                } else if (item.getDataType() == 2) {
                    if (view != null && (view.getTag() instanceof g)) {
                        E = (g) view.getTag();
                    } else {
                        view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03cf, viewGroup, false);
                        E = E(view);
                        view.setTag(E);
                    }
                    K(E, i);
                    J(E, i, item);
                    M(item);
                    return view;
                } else if (item.getDataType() == 3) {
                    if (view != null && (view.getTag() instanceof f)) {
                        fVar = (f) view.getTag();
                    } else {
                        view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03d1, viewGroup, false);
                        fVar = new f(this, view);
                        view.setTag(fVar);
                    }
                    I(fVar);
                    return view;
                } else if (item.getDataType() == 4) {
                    if (view != null && (view.getTag() instanceof e)) {
                        eVar = (e) view.getTag();
                    } else {
                        view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03d0, viewGroup, false);
                        eVar = new e(this, view);
                        view.setTag(eVar);
                    }
                    H(eVar);
                    return view;
                }
            }
            if (item != null && String.valueOf(2).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    c.a.p0.v1.b.e eVar2 = this.f33962d;
                    if (eVar2 != null) {
                        eVar2.v0(true);
                    }
                } else {
                    c.a.p0.v1.b.e eVar3 = this.f33962d;
                    if (eVar3 != null) {
                        eVar3.v0(false);
                    }
                }
            }
            return super.getView(i, view, viewGroup);
        }
        return (View) invokeILL.objValue;
    }

    @Override // c.a.p0.u1.f.i.c
    public void n(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            super.n(list);
            if (TbadkCoreApplication.isLogin()) {
                if (this.f18692b.size() <= 0) {
                    this.f33962d.w0(true, true);
                } else {
                    this.f33962d.w0(true, false);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // c.a.p0.u1.f.i.c
    public BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        InterceptResult invokeLIL;
        PersonalSettingItemData personalSettingItemData;
        GroupSettingItemData groupSettingItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048595, this, imMessageCenterShowItemData, i, str)) == null) {
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName()) || (!String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName()) ? !(!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) : c.a.o0.s.d.d.d().r() : c.a.o0.s.d.d.d().r() && ((personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || personalSettingItemData.isAcceptNotify()) : c.a.o0.s.d.d.d().p() && ((groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || groupSettingItemData.isAcceptNotify())) : !(c.a.o0.s.d.d.d().B() && c.a.p0.u1.t.f.a().b()))) {
                str = "";
                i = 0;
            }
            return new BasicNameValuePair(String.valueOf(i), str);
        }
        return (BasicNameValuePair) invokeLIL.objValue;
    }
}
