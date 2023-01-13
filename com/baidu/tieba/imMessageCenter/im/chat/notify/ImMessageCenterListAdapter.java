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
import com.baidu.tieba.a05;
import com.baidu.tieba.cx4;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.jn7;
import com.baidu.tieba.oi7;
import com.baidu.tieba.qf7;
import com.baidu.tieba.r9;
import com.baidu.tieba.sw8;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.um7;
import com.baidu.tieba.yi;
import com.baidu.tieba.z35;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class ImMessageCenterListAdapter extends qf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jn7 e;
    public TbPageContext f;
    public LikeModel g;

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
                    this.c.J(this.b, this.a);
                    this.c.I(this.a, 1);
                    return;
                }
                this.c.K(this.b, this.a);
                this.c.I(this.a, 2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends r9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterShowItemData a;
        public final /* synthetic */ g b;
        public final /* synthetic */ ImMessageCenterListAdapter c;

        public b(ImMessageCenterListAdapter imMessageCenterListAdapter, ImMessageCenterShowItemData imMessageCenterShowItemData, g gVar) {
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

        @Override // com.baidu.tieba.r9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.c.g.getErrorCode() == 22) {
                    zi.Q(this.c.a, this.c.a.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.c.g.getErrorCode() != 0) {
                        zi.Q(this.c.a, this.c.g.getErrorString());
                        return;
                    }
                    this.a.setIsLike(1);
                    this.c.W(this.b, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements sw8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterShowItemData a;
        public final /* synthetic */ g b;
        public final /* synthetic */ ImMessageCenterListAdapter c;

        @Override // com.baidu.tieba.sw8.a
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

        @Override // com.baidu.tieba.sw8.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.setIsLike(0);
                this.c.W(this.b, false);
                zi.Q(this.c.a, this.c.a.getString(R.string.un_attention_success));
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090efd);
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f01);
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
        this.g = null;
    }

    public final d L(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            d dVar = new d(this, null);
            dVar.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ef5);
            dVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ef6);
            dVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ef7);
            dVar.d = view2.findViewById(R.id.obfuscated_res_0x7f090ef4);
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final void O(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            SkinManager.setImageResource(dVar.a, R.drawable.im_no_data_icon);
            dVar.a.setUseNightOrDarkMask(false);
            dVar.b.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0939));
            dVar.c.setText(this.a.getString(R.string.obfuscated_res_0x7f0f093a));
        }
    }

    public final void P(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            cx4 d2 = cx4.d(dVar.b);
            d2.v(R.color.CAM_X0107);
            d2.z(R.dimen.T_X07);
            cx4 d3 = cx4.d(dVar.c);
            d3.v(R.color.CAM_X0110);
            d3.z(R.dimen.T_X08);
            cx4.d(dVar.d).f(R.color.CAM_X0204);
        }
    }

    public final void V(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, imMessageCenterShowItemData) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.IM_REC_FORUM_ITEM_SHOW_KEY);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", imMessageCenterShowItemData.getForumId());
            statisticItem.param("fname", imMessageCenterShowItemData.getForumName());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.qf7
    public boolean g(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, imMessageCenterShowItemData)) == null) {
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

    public final void Q(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            cx4 d2 = cx4.d(eVar.a);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X08);
        }
    }

    public final void R(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            cx4 d2 = cx4.d(fVar.a);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
        }
    }

    public void U(jn7 jn7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jn7Var) == null) {
            this.e = jn7Var;
        }
    }

    public final void I(ImMessageCenterShowItemData imMessageCenterShowItemData, int i) {
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

    @Override // com.baidu.tieba.qf7
    public void u(qf7.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, aVar, imMessageCenterShowItemData) == null) {
            if (String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.n.setImageResource(R.drawable.icon_chat_group_logo);
                aVar.n.setVisibility(0);
                return;
            }
            aVar.n.setVisibility(8);
        }
    }

    public final void J(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, imMessageCenterShowItemData) == null) {
            if (this.g == null) {
                this.g = new LikeModel(this.f);
            }
            if (!zi.F()) {
                Context context = this.a;
                UtilHelper.showToast(context, context.getString(R.string.obfuscated_res_0x7f0f0cd1));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.a)) {
            } else {
                this.g.setLoadDataCallBack(new b(this, imMessageCenterShowItemData, gVar));
                if (yi.isForumName(imMessageCenterShowItemData.getForumName())) {
                    this.g.U();
                    this.g.Y(imMessageCenterShowItemData.getForumName(), String.valueOf(imMessageCenterShowItemData.getForumId()));
                }
            }
        }
    }

    public final void T(g gVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, gVar, i) == null) {
            if (i == 2) {
                i2 = R.color.CAM_X0301;
            } else if (i == 3) {
                i2 = R.color.CAM_X0319;
            } else if (i == 4) {
                i2 = R.color.CAM_X0305;
            } else {
                i2 = R.color.CAM_X0315;
            }
            cx4 d2 = cx4.d(gVar.c);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0101);
            d2.n(R.string.J_X04);
            d2.f(i2);
            cx4 d3 = cx4.d(gVar.d);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X06);
            cx4 d4 = cx4.d(gVar.e);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X09);
            cx4 d5 = cx4.d(gVar.f);
            d5.v(R.color.CAM_X0109);
            d5.z(R.dimen.T_X09);
            cx4 d6 = cx4.d(gVar.g);
            d6.v(R.color.CAM_X0109);
            d6.z(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(gVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public final void K(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, imMessageCenterShowItemData) == null) {
            if (!zi.F()) {
                Context context = this.a;
                UtilHelper.showToast(context, context.getString(R.string.obfuscated_res_0x7f0f0cd1));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.a)) {
            } else {
                sw8 sw8Var = new sw8();
                sw8Var.b(new c(this, imMessageCenterShowItemData, gVar));
                sw8Var.c(imMessageCenterShowItemData.getForumName(), imMessageCenterShowItemData.getForumId());
            }
        }
    }

    public void W(g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, gVar, z) == null) {
            if (z) {
                a05 a05Var = new a05();
                a05Var.v(R.color.CAM_X0109);
                gVar.i.setConfig(a05Var);
                gVar.i.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
                gVar.i.setClickState(false);
            } else {
                a05 a05Var2 = new a05();
                a05Var2.t(R.color.CAM_X0302);
                gVar.i.setConfig(a05Var2);
                gVar.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ba));
                gVar.i.setClickState(true);
            }
            gVar.i.k();
        }
    }

    public final g M(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            g gVar = new g(this, null);
            gVar.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d61);
            gVar.b = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090efb);
            gVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090eff);
            gVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f00);
            gVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090efc);
            gVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090efa);
            gVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090efe);
            gVar.h = view2.findViewById(R.id.obfuscated_res_0x7f090f02);
            gVar.i = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090ef9);
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public void N() {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (likeModel = this.g) != null) {
            likeModel.onDestroy();
        }
    }

    public final void S(g gVar, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, gVar, i, imMessageCenterShowItemData) == null) {
            boolean z = true;
            gVar.b.setShowOval(true);
            gVar.b.setAutoChangeStyle(true);
            gVar.b.setStrokeWith(zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            gVar.b.setStrokeColorResId(R.color.CAM_X0401);
            gVar.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            gVar.b.setPlaceHolder(1);
            gVar.b.K(imMessageCenterShowItemData.getAvatar(), 10, false);
            gVar.d.setText(imMessageCenterShowItemData.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f068b));
            if (!StringUtils.isNull(imMessageCenterShowItemData.getSlogan())) {
                gVar.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f093b, imMessageCenterShowItemData.getSlogan()));
            } else {
                gVar.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f093d));
            }
            gVar.f.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f043f), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getMemberCount())));
            gVar.g.setText(String.format(this.a.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getThreadCount())));
            gVar.c.setText(String.valueOf(i - 1));
            if (imMessageCenterShowItemData.getIsLike() != 1) {
                z = false;
            }
            W(gVar, z);
            gVar.i.setOnClickListener(new a(this, imMessageCenterShowItemData, gVar));
        }
    }

    @Override // com.baidu.tieba.qf7, android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        f fVar;
        g M;
        d L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048593, this, i, view2, viewGroup)) == null) {
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null) {
                if (item.getDataType() == 1) {
                    if (view2 != null && (view2.getTag() instanceof d)) {
                        L = (d) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03ce, viewGroup, false);
                        L = L(view2);
                        view2.setTag(L);
                    }
                    P(L);
                    O(L);
                    return view2;
                } else if (item.getDataType() == 2) {
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        M = (g) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03d0, viewGroup, false);
                        M = M(view2);
                        view2.setTag(M);
                    }
                    T(M, i);
                    S(M, i, item);
                    V(item);
                    return view2;
                } else if (item.getDataType() == 3) {
                    if (view2 != null && (view2.getTag() instanceof f)) {
                        fVar = (f) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03d2, viewGroup, false);
                        fVar = new f(this, view2);
                        view2.setTag(fVar);
                    }
                    R(fVar);
                    return view2;
                } else if (item.getDataType() == 4) {
                    if (view2 != null && (view2.getTag() instanceof e)) {
                        eVar = (e) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03d1, viewGroup, false);
                        eVar = new e(this, view2);
                        view2.setTag(eVar);
                    }
                    Q(eVar);
                    return view2;
                }
            }
            if (item != null && String.valueOf(2).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    jn7 jn7Var = this.e;
                    if (jn7Var != null) {
                        jn7Var.d1(true);
                    }
                } else {
                    jn7 jn7Var2 = this.e;
                    if (jn7Var2 != null) {
                        jn7Var2.d1(false);
                    }
                }
            }
            return super.getView(i, view2, viewGroup);
        }
        return (View) invokeILL.objValue;
    }

    @Override // com.baidu.tieba.qf7
    public boolean f(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null) {
                return false;
            }
            if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName())) {
                return true;
            }
            return um7.c(imMessageCenterShowItemData);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.qf7
    public void j(qf7.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.b.setDrawerType(1);
            aVar.b.setRadius(zi.d(this.a, 4.0f));
            aVar.c.setClickable(false);
            if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.b.setDrawBorder(false);
                aVar.b.setAutoChangeStyle(true);
                aVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.b.setUserName(String.valueOf(5));
                aVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.b.setVisibility(4);
                aVar.c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.c, R.drawable.obfuscated_res_0x7f080619, SvgManager.SvgResourceStateType.NORMAL);
                aVar.b.setIsRound(false);
                aVar.b.invalidate();
            } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.b.setDrawBorder(true);
                aVar.b.setAutoChangeStyle(true);
                String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.b.setVisibility(0);
                aVar.c.setVisibility(8);
                aVar.b.setImageDrawable(null);
                if (!TextUtils.isEmpty(friendBjhAvatar)) {
                    aVar.b.K(friendBjhAvatar, 12, false);
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
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.c, R.drawable.obfuscated_res_0x7f080621, SvgManager.SvgResourceStateType.NORMAL);
                aVar.b.setIsRound(false);
                aVar.b.invalidate();
            } else if (String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.b.setDrawBorder(true);
                aVar.b.setAutoChangeStyle(true);
                String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.b.setImageDrawable(null);
                aVar.b.setVisibility(0);
                aVar.c.setVisibility(8);
                if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                    aVar.b.K(friendBjhAvatar2, 12, false);
                } else {
                    aVar.b.K(String.valueOf((int) R.drawable.obfuscated_res_0x7f080f81), 24, false);
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
                    aVar.b.K(String.valueOf((int) R.drawable.obfuscated_res_0x7f080f81), 24, false);
                }
                aVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.b.setIsRound(false);
                aVar.b.invalidate();
            }
        }
    }

    @Override // com.baidu.tieba.qf7
    public BasicNameValuePair x(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        InterceptResult invokeLIL;
        OfficialSettingItemData officialSettingItemData;
        PersonalSettingItemData personalSettingItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048596, this, imMessageCenterShowItemData, i, str)) == null) {
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName()) || (!String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName()) ? !(!String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) : z35.d().v() && ((officialSettingItemData = (OfficialSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || officialSettingItemData.isAcceptNotify()) : (personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || personalSettingItemData.isAcceptNotify()) : !(z35.d().F() && oi7.a().b()))) {
                str = "";
                i = 0;
            }
            return new BasicNameValuePair(String.valueOf(i), str);
        }
        return (BasicNameValuePair) invokeLIL.objValue;
    }
}
