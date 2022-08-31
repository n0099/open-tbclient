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
import com.baidu.tieba.ac7;
import com.baidu.tieba.c9;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.lb7;
import com.baidu.tieba.ns4;
import com.baidu.tieba.nz4;
import com.baidu.tieba.qi;
import com.baidu.tieba.qv4;
import com.baidu.tieba.ri;
import com.baidu.tieba.rk8;
import com.baidu.tieba.t97;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.u67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class ImMessageCenterListAdapter extends u67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ac7 e;
    public TbPageContext f;

    /* loaded from: classes4.dex */
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
                    this.c.E(this.b, this.a);
                    this.c.D(this.a, 1);
                    return;
                }
                this.c.F(this.b, this.a);
                this.c.D(this.a, 2);
            }
        }
    }

    /* loaded from: classes4.dex */
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

        @Override // com.baidu.tieba.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.getErrorCode() == 22) {
                    ri.N(this.d.a, this.d.a.getString(R.string.obfuscated_res_0x7f0f0828));
                } else if (obj == null) {
                } else {
                    if (this.a.getErrorCode() != 0) {
                        ri.N(this.d.a, this.a.getErrorString());
                        return;
                    }
                    this.b.setIsLike(1);
                    this.d.Q(this.c, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements rk8.a {
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

        @Override // com.baidu.tieba.rk8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // com.baidu.tieba.rk8.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.setIsLike(0);
                this.c.Q(this.b, false);
                ri.N(this.c.a, this.c.a.getString(R.string.obfuscated_res_0x7f0f149b));
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e5e);
        }
    }

    /* loaded from: classes4.dex */
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e62);
        }
    }

    /* loaded from: classes4.dex */
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

    public final void D(ImMessageCenterShowItemData imMessageCenterShowItemData, int i) {
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

    public final void E(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, imMessageCenterShowItemData) == null) {
            LikeModel likeModel = new LikeModel(this.f);
            if (!ri.D()) {
                Context context = this.a;
                UtilHelper.showToast(context, context.getString(R.string.obfuscated_res_0x7f0f0c40));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.a)) {
            } else {
                likeModel.setLoadDataCallBack(new b(this, likeModel, imMessageCenterShowItemData, gVar));
                if (qi.isForumName(imMessageCenterShowItemData.getForumName())) {
                    likeModel.Q(imMessageCenterShowItemData.getForumName(), String.valueOf(imMessageCenterShowItemData.getForumId()));
                }
            }
        }
    }

    public final void F(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, imMessageCenterShowItemData) == null) {
            if (!ri.D()) {
                Context context = this.a;
                UtilHelper.showToast(context, context.getString(R.string.obfuscated_res_0x7f0f0c40));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.a)) {
            } else {
                rk8 rk8Var = new rk8();
                rk8Var.b(new c(this, imMessageCenterShowItemData, gVar));
                rk8Var.c(imMessageCenterShowItemData.getForumName(), imMessageCenterShowItemData.getForumId());
            }
        }
    }

    public final d G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            d dVar = new d(this, null);
            dVar.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e56);
            dVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e57);
            dVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e58);
            dVar.d = view2.findViewById(R.id.obfuscated_res_0x7f090e55);
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final g H(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            g gVar = new g(this, null);
            gVar.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c34);
            gVar.b = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e5c);
            gVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e60);
            gVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e61);
            gVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e5d);
            gVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e5b);
            gVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e5f);
            gVar.h = view2.findViewById(R.id.obfuscated_res_0x7f090e63);
            gVar.i = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090e5a);
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public final void I(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            SkinManager.setImageResource(dVar.a, R.drawable.im_no_data_icon);
            dVar.a.setUseNightOrDarkMask(false);
            dVar.b.setText(this.a.getString(R.string.obfuscated_res_0x7f0f08c0));
            dVar.c.setText(this.a.getString(R.string.obfuscated_res_0x7f0f08c1));
        }
    }

    public final void J(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            ns4 d2 = ns4.d(dVar.b);
            d2.v(R.color.CAM_X0107);
            d2.z(R.dimen.T_X07);
            ns4 d3 = ns4.d(dVar.c);
            d3.v(R.color.CAM_X0110);
            d3.z(R.dimen.T_X08);
            ns4.d(dVar.d).f(R.color.CAM_X0204);
        }
    }

    public final void K(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            ns4 d2 = ns4.d(eVar.a);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X08);
        }
    }

    public final void L(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            ns4 d2 = ns4.d(fVar.a);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
        }
    }

    public final void M(g gVar, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, gVar, i, imMessageCenterShowItemData) == null) {
            gVar.b.setShowOval(true);
            gVar.b.setAutoChangeStyle(true);
            gVar.b.setStrokeWith(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            gVar.b.setStrokeColorResId(R.color.CAM_X0401);
            gVar.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            gVar.b.setPlaceHolder(1);
            gVar.b.K(imMessageCenterShowItemData.getAvatar(), 10, false);
            gVar.d.setText(imMessageCenterShowItemData.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f065b));
            if (!StringUtils.isNull(imMessageCenterShowItemData.getSlogan())) {
                gVar.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f08c2, imMessageCenterShowItemData.getSlogan()));
            } else {
                gVar.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f08c4));
            }
            gVar.f.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0425), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getMemberCount())));
            gVar.g.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f06c4), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getThreadCount())));
            gVar.c.setText(String.valueOf(i - 1));
            Q(gVar, imMessageCenterShowItemData.getIsLike() == 1);
            gVar.i.setOnClickListener(new a(this, imMessageCenterShowItemData, gVar));
        }
    }

    public final void N(g gVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, gVar, i) == null) {
            int i2 = i == 2 ? R.color.CAM_X0301 : i == 3 ? R.color.CAM_X0319 : i == 4 ? R.color.CAM_X0305 : R.color.CAM_X0315;
            ns4 d2 = ns4.d(gVar.c);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0101);
            d2.n(R.string.J_X04);
            d2.f(i2);
            ns4 d3 = ns4.d(gVar.d);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X06);
            ns4 d4 = ns4.d(gVar.e);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X09);
            ns4 d5 = ns4.d(gVar.f);
            d5.v(R.color.CAM_X0109);
            d5.z(R.dimen.T_X09);
            ns4 d6 = ns4.d(gVar.g);
            d6.v(R.color.CAM_X0109);
            d6.z(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(gVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void O(ac7 ac7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ac7Var) == null) {
            this.e = ac7Var;
        }
    }

    public final void P(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, imMessageCenterShowItemData) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.IM_REC_FORUM_ITEM_SHOW_KEY);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", imMessageCenterShowItemData.getForumId());
            statisticItem.param("fname", imMessageCenterShowItemData.getForumName());
            TiebaStatic.log(statisticItem);
        }
    }

    public void Q(g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, gVar, z) == null) {
            if (z) {
                qv4 qv4Var = new qv4();
                qv4Var.t(R.color.CAM_X0109);
                gVar.i.setConfig(qv4Var);
                gVar.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fc0));
                gVar.i.setClickState(false);
            } else {
                qv4 qv4Var2 = new qv4();
                qv4Var2.r(R.color.CAM_X0302);
                gVar.i.setConfig(qv4Var2);
                gVar.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ac));
                gVar.i.setClickState(true);
            }
            gVar.i.k();
        }
    }

    @Override // com.baidu.tieba.u67
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
            return lb7.b(imMessageCenterShowItemData);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.u67
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

    @Override // com.baidu.tieba.u67, android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        f fVar;
        g H;
        d G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048592, this, i, view2, viewGroup)) == null) {
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null) {
                if (item.getDataType() == 1) {
                    if (view2 != null && (view2.getTag() instanceof d)) {
                        G = (d) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03ba, viewGroup, false);
                        G = G(view2);
                        view2.setTag(G);
                    }
                    J(G);
                    I(G);
                    return view2;
                } else if (item.getDataType() == 2) {
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        H = (g) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03bc, viewGroup, false);
                        H = H(view2);
                        view2.setTag(H);
                    }
                    N(H, i);
                    M(H, i, item);
                    P(item);
                    return view2;
                } else if (item.getDataType() == 3) {
                    if (view2 != null && (view2.getTag() instanceof f)) {
                        fVar = (f) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03be, viewGroup, false);
                        fVar = new f(this, view2);
                        view2.setTag(fVar);
                    }
                    L(fVar);
                    return view2;
                } else if (item.getDataType() == 4) {
                    if (view2 != null && (view2.getTag() instanceof e)) {
                        eVar = (e) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03bd, viewGroup, false);
                        eVar = new e(this, view2);
                        view2.setTag(eVar);
                    }
                    K(eVar);
                    return view2;
                }
            }
            if (item != null && String.valueOf(2).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    ac7 ac7Var = this.e;
                    if (ac7Var != null) {
                        ac7Var.L0(true);
                    }
                } else {
                    ac7 ac7Var2 = this.e;
                    if (ac7Var2 != null) {
                        ac7Var2.L0(false);
                    }
                }
            }
            return super.getView(i, view2, viewGroup);
        }
        return (View) invokeILL.objValue;
    }

    @Override // com.baidu.tieba.u67
    public void h(u67.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.b.setDrawerType(1);
            aVar.b.setRadius(ri.d(this.a, 4.0f));
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
                    aVar.b.K(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
                } else {
                    aVar.b.K(friendBjhAvatar, 10, false);
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
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.c, R.drawable.obfuscated_res_0x7f0805d9, SvgManager.SvgResourceStateType.NORMAL);
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
                        aVar.b.K(((Integer) runTask.getData()).toString(), 24, false);
                    }
                } else {
                    aVar.b.K(friendBjhAvatar2, 12, false);
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
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.c, R.drawable.obfuscated_res_0x7f0805e1, SvgManager.SvgResourceStateType.NORMAL);
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
                    aVar.b.K(friendBjhAvatar3, 12, false);
                } else {
                    aVar.b.K(String.valueOf((int) R.drawable.obfuscated_res_0x7f080edf), 24, false);
                }
                aVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.b.setIsRound(false);
                aVar.b.invalidate();
            }
        }
    }

    @Override // com.baidu.tieba.u67
    public BasicNameValuePair t(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        InterceptResult invokeLIL;
        OfficialSettingItemData officialSettingItemData;
        PersonalSettingItemData personalSettingItemData;
        GroupSettingItemData groupSettingItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048594, this, imMessageCenterShowItemData, i, str)) == null) {
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName()) || (!String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName()) ? !(!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) : nz4.d().u() && ((officialSettingItemData = (OfficialSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || officialSettingItemData.isAcceptNotify()) : (personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || personalSettingItemData.isAcceptNotify() : nz4.d().s() && ((groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || groupSettingItemData.isAcceptNotify())) : !(nz4.d().E() && t97.a().b()))) {
                str = "";
                i = 0;
            }
            return new BasicNameValuePair(String.valueOf(i), str);
        }
        return (BasicNameValuePair) invokeLIL.objValue;
    }
}
