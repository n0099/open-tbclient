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
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c77;
import com.repackage.c9;
import com.repackage.dh8;
import com.repackage.f47;
import com.repackage.fr4;
import com.repackage.i97;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.rx4;
import com.repackage.u87;
import com.repackage.xt4;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
public class ImMessageCenterListAdapter extends f47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i97 e;
    public TbPageContext f;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterShowItemData a;
        public final /* synthetic */ g b;
        public final /* synthetic */ ImMessageCenterListAdapter c;

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
            this.c = imMessageCenterListAdapter;
            this.a = imMessageCenterShowItemData;
            this.b = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.getIsLike() != 1) {
                    this.c.G(this.b, this.a);
                    this.c.F(this.a, 1);
                    return;
                }
                this.c.H(this.b, this.a);
                this.c.F(this.a, 2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LikeModel a;
        public final /* synthetic */ ImMessageCenterShowItemData b;
        public final /* synthetic */ g c;
        public final /* synthetic */ ImMessageCenterListAdapter d;

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
            this.d = imMessageCenterListAdapter;
            this.a = likeModel;
            this.b = imMessageCenterShowItemData;
            this.c = gVar;
        }

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.getErrorCode() == 22) {
                    pi.O(this.d.a, this.d.a.getString(R.string.obfuscated_res_0x7f0f080e));
                } else if (obj == null) {
                } else {
                    if (this.a.getErrorCode() != 0) {
                        pi.O(this.d.a, this.a.getErrorString());
                        return;
                    }
                    this.b.setIsLike(1);
                    this.d.S(this.c, true);
                    pi.O(this.d.a, this.d.a.getString(R.string.obfuscated_res_0x7f0f02b3));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements dh8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterShowItemData a;
        public final /* synthetic */ g b;
        public final /* synthetic */ ImMessageCenterListAdapter c;

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
            this.c = imMessageCenterListAdapter;
            this.a = imMessageCenterShowItemData;
            this.b = gVar;
        }

        @Override // com.repackage.dh8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // com.repackage.dh8.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.setIsLike(0);
                this.c.S(this.b, false);
                pi.O(this.c.a, this.c.a.getString(R.string.obfuscated_res_0x7f0f14af));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public TextView b;
        public TextView c;
        public View d;

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

    /* loaded from: classes3.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        public e(ImMessageCenterListAdapter imMessageCenterListAdapter, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterListAdapter, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e0a);
        }
    }

    /* loaded from: classes3.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        public f(ImMessageCenterListAdapter imMessageCenterListAdapter, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterListAdapter, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e0e);
        }
    }

    /* loaded from: classes3.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public BarImageView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public View h;
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
        this.e = null;
        this.f = null;
    }

    public final void F(ImMessageCenterShowItemData imMessageCenterShowItemData, int i) {
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

    public final void G(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, imMessageCenterShowItemData) == null) {
            LikeModel likeModel = new LikeModel(this.f);
            if (!pi.D()) {
                Context context = this.a;
                UtilHelper.showToast(context, context.getString(R.string.obfuscated_res_0x7f0f0c37));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.a)) {
            } else {
                likeModel.setLoadDataCallBack(new b(this, likeModel, imMessageCenterShowItemData, gVar));
                if (oi.isForumName(imMessageCenterShowItemData.getForumName())) {
                    likeModel.Q(imMessageCenterShowItemData.getForumName(), String.valueOf(imMessageCenterShowItemData.getForumId()));
                }
            }
        }
    }

    public final void H(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, imMessageCenterShowItemData) == null) {
            if (!pi.D()) {
                Context context = this.a;
                UtilHelper.showToast(context, context.getString(R.string.obfuscated_res_0x7f0f0c37));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.a)) {
            } else {
                dh8 dh8Var = new dh8();
                dh8Var.b(new c(this, imMessageCenterShowItemData, gVar));
                dh8Var.c(imMessageCenterShowItemData.getForumName(), imMessageCenterShowItemData.getForumId());
            }
        }
    }

    public final d I(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            d dVar = new d(this, null);
            dVar.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e02);
            dVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e03);
            dVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e04);
            dVar.d = view2.findViewById(R.id.obfuscated_res_0x7f090e01);
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final g J(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            g gVar = new g(this, null);
            gVar.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ad4);
            gVar.b = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e08);
            gVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e0c);
            gVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e0d);
            gVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e09);
            gVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e07);
            gVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e0b);
            gVar.h = view2.findViewById(R.id.obfuscated_res_0x7f090e0f);
            gVar.i = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090e06);
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public final void K(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            SkinManager.setImageResource(dVar.a, R.drawable.im_no_data_icon);
            dVar.a.setUseNightOrDarkMask(false);
            dVar.b.setText(this.a.getString(R.string.obfuscated_res_0x7f0f08b3));
            dVar.c.setText(this.a.getString(R.string.obfuscated_res_0x7f0f08b4));
        }
    }

    public final void L(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            fr4 d2 = fr4.d(dVar.b);
            d2.v(R.color.CAM_X0107);
            d2.z(R.dimen.T_X07);
            fr4 d3 = fr4.d(dVar.c);
            d3.v(R.color.CAM_X0110);
            d3.z(R.dimen.T_X08);
            fr4.d(dVar.d).f(R.color.CAM_X0204);
        }
    }

    public final void M(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            fr4 d2 = fr4.d(eVar.a);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X08);
        }
    }

    public final void N(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            fr4 d2 = fr4.d(fVar.a);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
        }
    }

    public final void O(g gVar, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, gVar, i, imMessageCenterShowItemData) == null) {
            gVar.b.setShowOval(true);
            gVar.b.setAutoChangeStyle(true);
            gVar.b.setStrokeWith(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            gVar.b.setStrokeColorResId(R.color.CAM_X0401);
            gVar.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            gVar.b.setPlaceHolder(1);
            gVar.b.J(imMessageCenterShowItemData.getAvatar(), 10, false);
            gVar.d.setText(imMessageCenterShowItemData.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f0646));
            if (!StringUtils.isNull(imMessageCenterShowItemData.getSlogan())) {
                gVar.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f08b5, imMessageCenterShowItemData.getSlogan()));
            } else {
                gVar.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f08b7));
            }
            gVar.f.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0412), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getMemberCount())));
            gVar.g.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f06af), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getThreadCount())));
            gVar.c.setText(String.valueOf(i - 1));
            S(gVar, imMessageCenterShowItemData.getIsLike() == 1);
            gVar.i.setOnClickListener(new a(this, imMessageCenterShowItemData, gVar));
        }
    }

    public final void P(g gVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, gVar, i) == null) {
            int i2 = i == 2 ? R.color.CAM_X0301 : i == 3 ? R.color.CAM_X0319 : i == 4 ? R.color.CAM_X0305 : R.color.CAM_X0315;
            fr4 d2 = fr4.d(gVar.c);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0101);
            d2.n(R.string.J_X04);
            d2.f(i2);
            fr4 d3 = fr4.d(gVar.d);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X06);
            fr4 d4 = fr4.d(gVar.e);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X09);
            fr4 d5 = fr4.d(gVar.f);
            d5.v(R.color.CAM_X0109);
            d5.z(R.dimen.T_X09);
            fr4 d6 = fr4.d(gVar.g);
            d6.v(R.color.CAM_X0109);
            d6.z(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(gVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void Q(i97 i97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, i97Var) == null) {
            this.e = i97Var;
        }
    }

    public final void R(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, imMessageCenterShowItemData) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.IM_REC_FORUM_ITEM_SHOW_KEY);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", imMessageCenterShowItemData.getForumId());
            statisticItem.param("fname", imMessageCenterShowItemData.getForumName());
            TiebaStatic.log(statisticItem);
        }
    }

    public void S(g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, gVar, z) == null) {
            if (z) {
                xt4 xt4Var = new xt4();
                xt4Var.t(R.color.CAM_X0109);
                gVar.i.setConfig(xt4Var);
                gVar.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa3));
                gVar.i.setClickState(false);
            } else {
                xt4 xt4Var2 = new xt4();
                xt4Var2.r(R.color.CAM_X0302);
                gVar.i.setConfig(xt4Var2);
                gVar.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02a4));
                gVar.i.setClickState(true);
            }
            gVar.i.k();
        }
    }

    @Override // com.repackage.f47
    public boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null) {
                return false;
            }
            if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                return true;
            }
            return u87.b(imMessageCenterShowItemData);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.f47
    public boolean f(ImMessageCenterShowItemData imMessageCenterShowItemData) {
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

    @Override // com.repackage.f47, android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        f fVar;
        g J;
        d I;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048592, this, i, view2, viewGroup)) == null) {
            ImMessageCenterShowItemData item = getItem(i);
            if (TbSingleton.getInstance().isImRecForumShow() && item != null) {
                if (item.getDataType() == 1) {
                    if (view2 != null && (view2.getTag() instanceof d)) {
                        I = (d) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03b3, viewGroup, false);
                        I = I(view2);
                        view2.setTag(I);
                    }
                    L(I);
                    K(I);
                    return view2;
                } else if (item.getDataType() == 2) {
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        J = (g) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03b5, viewGroup, false);
                        J = J(view2);
                        view2.setTag(J);
                    }
                    P(J, i);
                    O(J, i, item);
                    R(item);
                    return view2;
                } else if (item.getDataType() == 3) {
                    if (view2 != null && (view2.getTag() instanceof f)) {
                        fVar = (f) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03b7, viewGroup, false);
                        fVar = new f(this, view2);
                        view2.setTag(fVar);
                    }
                    N(fVar);
                    return view2;
                } else if (item.getDataType() == 4) {
                    if (view2 != null && (view2.getTag() instanceof e)) {
                        eVar = (e) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03b6, viewGroup, false);
                        eVar = new e(this, view2);
                        view2.setTag(eVar);
                    }
                    M(eVar);
                    return view2;
                }
            }
            if (item != null && String.valueOf(2).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    i97 i97Var = this.e;
                    if (i97Var != null) {
                        i97Var.E0(true);
                    }
                } else {
                    i97 i97Var2 = this.e;
                    if (i97Var2 != null) {
                        i97Var2.E0(false);
                    }
                }
            }
            return super.getView(i, view2, viewGroup);
        }
        return (View) invokeILL.objValue;
    }

    @Override // com.repackage.f47
    public void h(f47.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.b.setDrawerType(1);
            aVar.b.setRadius(pi.d(this.a, 4.0f));
            aVar.c.setClickable(false);
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.b.setDrawBorder(false);
                aVar.b.setAutoChangeStyle(true);
                aVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.b.setVisibility(0);
                aVar.c.setVisibility(8);
                if (MessageManager.getInstance().runTask(2001287, Integer.class) != null) {
                    SkinManager.setImageResource(aVar.b, R.drawable.icon_new_test);
                }
                aVar.b.setUserName(String.valueOf(2));
                aVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.b.setIsRound(false);
                aVar.b.invalidate();
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.b.setDrawBorder(true);
                aVar.b.setAutoChangeStyle(true);
                aVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.b.setImageDrawable(null);
                aVar.b.setVisibility(0);
                aVar.c.setVisibility(8);
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    aVar.b.J(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
                } else {
                    aVar.b.J(friendBjhAvatar, 10, false);
                }
                aVar.b.setClickable(false);
                aVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.b.setUserName(String.valueOf(1));
                aVar.b.setIsRound(false);
                aVar.b.invalidate();
            } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.b.setDrawBorder(false);
                aVar.b.setAutoChangeStyle(true);
                aVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.b.setUserName(String.valueOf(5));
                aVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.b.setVisibility(4);
                aVar.c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.c, R.drawable.obfuscated_res_0x7f0805d3, SvgManager.SvgResourceStateType.NORMAL);
                aVar.b.setIsRound(false);
                aVar.b.invalidate();
            } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.b.setDrawBorder(true);
                aVar.b.setAutoChangeStyle(true);
                String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.b.setVisibility(0);
                aVar.c.setVisibility(8);
                aVar.b.setImageDrawable(null);
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001289, Integer.class);
                    if (runTask != null && runTask.getData() != null) {
                        aVar.b.J(((Integer) runTask.getData()).toString(), 24, false);
                    }
                } else {
                    aVar.b.J(friendBjhAvatar2, 12, false);
                }
                aVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.b.setIsRound(false);
                aVar.b.invalidate();
            } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.b.setDrawBorder(false);
                aVar.b.setAutoChangeStyle(true);
                aVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.b.setUserName(String.valueOf(7));
                aVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.b.setVisibility(4);
                aVar.c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.c, R.drawable.obfuscated_res_0x7f0805db, SvgManager.SvgResourceStateType.NORMAL);
                aVar.b.setIsRound(false);
                aVar.b.invalidate();
            } else {
                aVar.b.setDrawBorder(true);
                aVar.b.setAutoChangeStyle(true);
                String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar3)) {
                    friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.b.setImageDrawable(null);
                aVar.b.setVisibility(0);
                aVar.c.setVisibility(8);
                if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                    aVar.b.J(friendBjhAvatar3, 12, false);
                } else {
                    aVar.b.J(String.valueOf((int) R.drawable.obfuscated_res_0x7f080ef6), 24, false);
                }
                aVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.b.setIsRound(false);
                aVar.b.invalidate();
            }
        }
    }

    @Override // com.repackage.f47
    public BasicNameValuePair t(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        InterceptResult invokeLIL;
        OfficialSettingItemData officialSettingItemData;
        PersonalSettingItemData personalSettingItemData;
        GroupSettingItemData groupSettingItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048594, this, imMessageCenterShowItemData, i, str)) == null) {
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName()) || (!String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName()) ? !(!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) : rx4.d().t() && ((officialSettingItemData = (OfficialSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || officialSettingItemData.isAcceptNotify()) : (personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || personalSettingItemData.isAcceptNotify() : rx4.d().r() && ((groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || groupSettingItemData.isAcceptNotify())) : !(rx4.d().D() && c77.a().b()))) {
                str = "";
                i = 0;
            }
            return new BasicNameValuePair(String.valueOf(i), str);
        }
        return (BasicNameValuePair) invokeLIL.objValue;
    }
}
