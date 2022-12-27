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
import com.baidu.tieba.hi7;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.p35;
import com.baidu.tieba.pz4;
import com.baidu.tieba.q9;
import com.baidu.tieba.rb7;
import com.baidu.tieba.rw4;
import com.baidu.tieba.se7;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.wi7;
import com.baidu.tieba.wr8;
import com.baidu.tieba.xi;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class ImMessageCenterListAdapter extends rb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wi7 e;
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
                    this.c.G(this.b, this.a);
                    this.c.F(this.a, 1);
                    return;
                }
                this.c.H(this.b, this.a);
                this.c.F(this.a, 2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends q9 {
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

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.getErrorCode() == 22) {
                    yi.Q(this.d.a, this.d.a.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.a.getErrorCode() != 0) {
                        yi.Q(this.d.a, this.a.getErrorString());
                        return;
                    }
                    this.b.setIsLike(1);
                    this.d.S(this.c, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements wr8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterShowItemData a;
        public final /* synthetic */ g b;
        public final /* synthetic */ ImMessageCenterListAdapter c;

        @Override // com.baidu.tieba.wr8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

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

        @Override // com.baidu.tieba.wr8.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.setIsLike(0);
                this.c.S(this.b, false);
                yi.Q(this.c.a, this.c.a.getString(R.string.un_attention_success));
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ef1);
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ef5);
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

    public final d I(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            d dVar = new d(this, null);
            dVar.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ee9);
            dVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090eea);
            dVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090eeb);
            dVar.d = view2.findViewById(R.id.obfuscated_res_0x7f090ee8);
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final void K(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            SkinManager.setImageResource(dVar.a, R.drawable.im_no_data_icon);
            dVar.a.setUseNightOrDarkMask(false);
            dVar.b.setText(this.a.getString(R.string.obfuscated_res_0x7f0f091f));
            dVar.c.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0920));
        }
    }

    public final void L(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            rw4 d2 = rw4.d(dVar.b);
            d2.v(R.color.CAM_X0107);
            d2.z(R.dimen.T_X07);
            rw4 d3 = rw4.d(dVar.c);
            d3.v(R.color.CAM_X0110);
            d3.z(R.dimen.T_X08);
            rw4.d(dVar.d).f(R.color.CAM_X0204);
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

    @Override // com.baidu.tieba.rb7
    public boolean g(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null) {
                return false;
            }
            if (!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) && !String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void M(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            rw4 d2 = rw4.d(eVar.a);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X08);
        }
    }

    public final void N(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            rw4 d2 = rw4.d(fVar.a);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
        }
    }

    public void Q(wi7 wi7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, wi7Var) == null) {
            this.e = wi7Var;
        }
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

    @Override // com.baidu.tieba.rb7
    public void t(rb7.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, aVar, imMessageCenterShowItemData) == null) {
            if (String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.n.setImageResource(R.drawable.icon_chat_group_logo);
                aVar.n.setVisibility(0);
                return;
            }
            aVar.n.setVisibility(8);
        }
    }

    public final void G(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, imMessageCenterShowItemData) == null) {
            LikeModel likeModel = new LikeModel(this.f);
            if (!yi.F()) {
                Context context = this.a;
                UtilHelper.showToast(context, context.getString(R.string.obfuscated_res_0x7f0f0cb8));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.a)) {
            } else {
                likeModel.setLoadDataCallBack(new b(this, likeModel, imMessageCenterShowItemData, gVar));
                if (xi.isForumName(imMessageCenterShowItemData.getForumName())) {
                    likeModel.X(imMessageCenterShowItemData.getForumName(), String.valueOf(imMessageCenterShowItemData.getForumId()));
                }
            }
        }
    }

    public final void P(g gVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, gVar, i) == null) {
            if (i == 2) {
                i2 = R.color.CAM_X0301;
            } else if (i == 3) {
                i2 = R.color.CAM_X0319;
            } else if (i == 4) {
                i2 = R.color.CAM_X0305;
            } else {
                i2 = R.color.CAM_X0315;
            }
            rw4 d2 = rw4.d(gVar.c);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0101);
            d2.n(R.string.J_X04);
            d2.f(i2);
            rw4 d3 = rw4.d(gVar.d);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X06);
            rw4 d4 = rw4.d(gVar.e);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X09);
            rw4 d5 = rw4.d(gVar.f);
            d5.v(R.color.CAM_X0109);
            d5.z(R.dimen.T_X09);
            rw4 d6 = rw4.d(gVar.g);
            d6.v(R.color.CAM_X0109);
            d6.z(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(gVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public final void H(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, imMessageCenterShowItemData) == null) {
            if (!yi.F()) {
                Context context = this.a;
                UtilHelper.showToast(context, context.getString(R.string.obfuscated_res_0x7f0f0cb8));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.a)) {
            } else {
                wr8 wr8Var = new wr8();
                wr8Var.b(new c(this, imMessageCenterShowItemData, gVar));
                wr8Var.c(imMessageCenterShowItemData.getForumName(), imMessageCenterShowItemData.getForumId());
            }
        }
    }

    public void S(g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, gVar, z) == null) {
            if (z) {
                pz4 pz4Var = new pz4();
                pz4Var.t(R.color.CAM_X0109);
                gVar.i.setConfig(pz4Var);
                gVar.i.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
                gVar.i.setClickState(false);
            } else {
                pz4 pz4Var2 = new pz4();
                pz4Var2.r(R.color.CAM_X0302);
                gVar.i.setConfig(pz4Var2);
                gVar.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02b6));
                gVar.i.setClickState(true);
            }
            gVar.i.k();
        }
    }

    public final g J(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            g gVar = new g(this, null);
            gVar.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d42);
            gVar.b = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090eef);
            gVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ef3);
            gVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ef4);
            gVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ef0);
            gVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090eee);
            gVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ef2);
            gVar.h = view2.findViewById(R.id.obfuscated_res_0x7f090ef6);
            gVar.i = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090eed);
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public final void O(g gVar, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, gVar, i, imMessageCenterShowItemData) == null) {
            boolean z = true;
            gVar.b.setShowOval(true);
            gVar.b.setAutoChangeStyle(true);
            gVar.b.setStrokeWith(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            gVar.b.setStrokeColorResId(R.color.CAM_X0401);
            gVar.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            gVar.b.setPlaceHolder(1);
            gVar.b.K(imMessageCenterShowItemData.getAvatar(), 10, false);
            gVar.d.setText(imMessageCenterShowItemData.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f0683));
            if (!StringUtils.isNull(imMessageCenterShowItemData.getSlogan())) {
                gVar.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0921, imMessageCenterShowItemData.getSlogan()));
            } else {
                gVar.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0923));
            }
            gVar.f.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0439), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getMemberCount())));
            gVar.g.setText(String.format(this.a.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getThreadCount())));
            gVar.c.setText(String.valueOf(i - 1));
            if (imMessageCenterShowItemData.getIsLike() != 1) {
                z = false;
            }
            S(gVar, z);
            gVar.i.setOnClickListener(new a(this, imMessageCenterShowItemData, gVar));
        }
    }

    @Override // com.baidu.tieba.rb7, android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        f fVar;
        g J;
        d I;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048592, this, i, view2, viewGroup)) == null) {
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null) {
                if (item.getDataType() == 1) {
                    if (view2 != null && (view2.getTag() instanceof d)) {
                        I = (d) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03ce, viewGroup, false);
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
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03d0, viewGroup, false);
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
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03d2, viewGroup, false);
                        fVar = new f(this, view2);
                        view2.setTag(fVar);
                    }
                    N(fVar);
                    return view2;
                } else if (item.getDataType() == 4) {
                    if (view2 != null && (view2.getTag() instanceof e)) {
                        eVar = (e) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03d1, viewGroup, false);
                        eVar = new e(this, view2);
                        view2.setTag(eVar);
                    }
                    M(eVar);
                    return view2;
                }
            }
            if (item != null && String.valueOf(2).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    wi7 wi7Var = this.e;
                    if (wi7Var != null) {
                        wi7Var.b1(true);
                    }
                } else {
                    wi7 wi7Var2 = this.e;
                    if (wi7Var2 != null) {
                        wi7Var2.b1(false);
                    }
                }
            }
            return super.getView(i, view2, viewGroup);
        }
        return (View) invokeILL.objValue;
    }

    @Override // com.baidu.tieba.rb7
    public BasicNameValuePair v(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        InterceptResult invokeLIL;
        OfficialSettingItemData officialSettingItemData;
        PersonalSettingItemData personalSettingItemData;
        GroupSettingItemData groupSettingItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048595, this, imMessageCenterShowItemData, i, str)) == null) {
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName()) || (!String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName()) ? !(!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) : p35.d().v() && ((officialSettingItemData = (OfficialSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || officialSettingItemData.isAcceptNotify()) : (personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || personalSettingItemData.isAcceptNotify() : p35.d().t() && ((groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || groupSettingItemData.isAcceptNotify())) : !(p35.d().F() && se7.a().b()))) {
                str = "";
                i = 0;
            }
            return new BasicNameValuePair(String.valueOf(i), str);
        }
        return (BasicNameValuePair) invokeLIL.objValue;
    }

    @Override // com.baidu.tieba.rb7
    public boolean f(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null) {
                return false;
            }
            if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName())) {
                return true;
            }
            return hi7.c(imMessageCenterShowItemData);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.rb7
    public void i(rb7.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.b.setDrawerType(1);
            aVar.b.setRadius(yi.d(this.a, 4.0f));
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
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.c, R.drawable.obfuscated_res_0x7f080607, SvgManager.SvgResourceStateType.NORMAL);
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
                if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                    aVar.b.K(friendBjhAvatar2, 12, false);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001289, Integer.class);
                    if (runTask != null && runTask.getData() != null) {
                        aVar.b.K(((Integer) runTask.getData()).toString(), 24, false);
                    }
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
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.c, R.drawable.obfuscated_res_0x7f08060f, SvgManager.SvgResourceStateType.NORMAL);
                aVar.b.setIsRound(false);
                aVar.b.invalidate();
            } else if (String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName())) {
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
                    aVar.b.K(String.valueOf((int) R.drawable.obfuscated_res_0x7f080f70), 24, false);
                }
                aVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.b.setIsRound(false);
                aVar.b.setIsBigV(false);
                aVar.b.invalidate();
            } else {
                aVar.b.setDrawBorder(true);
                aVar.b.setAutoChangeStyle(true);
                String friendBjhAvatar4 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar4)) {
                    friendBjhAvatar4 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.b.setImageDrawable(null);
                aVar.b.setVisibility(0);
                aVar.c.setVisibility(8);
                if (!TextUtils.isEmpty(friendBjhAvatar4)) {
                    aVar.b.K(friendBjhAvatar4, 12, false);
                } else {
                    aVar.b.K(String.valueOf((int) R.drawable.obfuscated_res_0x7f080f70), 24, false);
                }
                aVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.b.setIsRound(false);
                aVar.b.invalidate();
            }
        }
    }
}
