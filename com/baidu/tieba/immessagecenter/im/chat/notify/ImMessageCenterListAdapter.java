package com.baidu.tieba.immessagecenter.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
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
import com.baidu.tieba.a88;
import com.baidu.tieba.bm8;
import com.baidu.tieba.ik8;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.k9;
import com.baidu.tieba.pa5;
import com.baidu.tieba.s75;
import com.baidu.tieba.se5;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.wi;
import com.baidu.tieba.x3a;
import com.baidu.tieba.xi;
import com.baidu.tieba.xk8;
import com.baidu.tieba.za8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes6.dex */
public class ImMessageCenterListAdapter extends a88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public bm8 e;
    public TbPageContext f;
    public LikeModel g;

    public void Y(xk8 xk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, xk8Var) == null) {
        }
    }

    /* loaded from: classes6.dex */
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
                    this.c.M(this.b, this.a);
                    this.c.L(this.a, 1);
                    return;
                }
                this.c.N(this.b, this.a);
                this.c.L(this.a, 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends k9 {
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

        @Override // com.baidu.tieba.k9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.c.g.getErrorCode() == 22) {
                    xi.Q(this.c.a, this.c.a.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.c.g.getErrorCode() != 0) {
                        xi.Q(this.c.a, this.c.g.getErrorString());
                        return;
                    }
                    this.a.setIsLike(1);
                    this.c.a0(this.b, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements x3a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterShowItemData a;
        public final /* synthetic */ g b;
        public final /* synthetic */ ImMessageCenterListAdapter c;

        @Override // com.baidu.tieba.x3a.a
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

        @Override // com.baidu.tieba.x3a.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.setIsLike(0);
                this.c.a0(this.b, false);
                xi.Q(this.c.a, this.c.a.getString(R.string.un_attention_success));
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091030);
        }
    }

    /* loaded from: classes6.dex */
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091034);
        }
    }

    /* loaded from: classes6.dex */
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
        this.f = null;
        this.g = null;
    }

    public final d O(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            d dVar = new d(this, null);
            dVar.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091027);
            dVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091028);
            dVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091029);
            dVar.d = view2.findViewById(R.id.obfuscated_res_0x7f091026);
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final void R(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            SkinManager.setImageResource(dVar.a, R.drawable.im_no_data_icon);
            dVar.a.setUseNightOrDarkMask(false);
            dVar.b.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0a49));
            dVar.c.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0a4a));
        }
    }

    public final void S(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            s75 d2 = s75.d(dVar.b);
            d2.x(R.color.CAM_X0107);
            d2.C(R.dimen.T_X07);
            s75 d3 = s75.d(dVar.c);
            d3.x(R.color.CAM_X0110);
            d3.C(R.dimen.T_X08);
            s75.d(dVar.d).f(R.color.CAM_X0204);
        }
    }

    public final void Z(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, imMessageCenterShowItemData) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.IM_REC_FORUM_ITEM_SHOW_KEY);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", imMessageCenterShowItemData.getForumId());
            statisticItem.param("fname", imMessageCenterShowItemData.getForumName());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.a88
    public boolean h(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, imMessageCenterShowItemData)) == null) {
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

    public final void T(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            s75 d2 = s75.d(eVar.a);
            d2.x(R.color.CAM_X0108);
            d2.C(R.dimen.T_X08);
        }
    }

    public final void U(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            s75 d2 = s75.d(fVar.a);
            d2.x(R.color.CAM_X0105);
            d2.C(R.dimen.T_X05);
            d2.D(R.string.F_X02);
        }
    }

    public void X(bm8 bm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bm8Var) == null) {
            this.e = bm8Var;
        }
    }

    public final void L(ImMessageCenterShowItemData imMessageCenterShowItemData, int i) {
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

    public final void M(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, imMessageCenterShowItemData) == null) {
            if (this.g == null) {
                this.g = new LikeModel(this.f);
            }
            if (!xi.F()) {
                Context context = this.a;
                UtilHelper.showToast(context, context.getString(R.string.obfuscated_res_0x7f0f0e0f));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.a)) {
            } else {
                this.g.setLoadDataCallBack(new b(this, imMessageCenterShowItemData, gVar));
                if (wi.isForumName(imMessageCenterShowItemData.getForumName())) {
                    this.g.i0();
                    this.g.m0(imMessageCenterShowItemData.getForumName(), String.valueOf(imMessageCenterShowItemData.getForumId()));
                }
            }
        }
    }

    public final void W(g gVar, int i) {
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
            s75 d2 = s75.d(gVar.c);
            d2.C(R.dimen.T_X09);
            d2.x(R.color.CAM_X0101);
            d2.o(R.string.J_X04);
            d2.f(i2);
            s75 d3 = s75.d(gVar.d);
            d3.x(R.color.CAM_X0105);
            d3.C(R.dimen.T_X06);
            s75 d4 = s75.d(gVar.e);
            d4.x(R.color.CAM_X0109);
            d4.C(R.dimen.T_X09);
            s75 d5 = s75.d(gVar.f);
            d5.x(R.color.CAM_X0109);
            d5.C(R.dimen.T_X09);
            s75 d6 = s75.d(gVar.g);
            d6.x(R.color.CAM_X0109);
            d6.C(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(gVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public final void N(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, imMessageCenterShowItemData) == null) {
            if (!xi.F()) {
                Context context = this.a;
                UtilHelper.showToast(context, context.getString(R.string.obfuscated_res_0x7f0f0e0f));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.a)) {
            } else {
                x3a x3aVar = new x3a();
                x3aVar.b(new c(this, imMessageCenterShowItemData, gVar));
                x3aVar.c(imMessageCenterShowItemData.getForumName(), imMessageCenterShowItemData.getForumId());
            }
        }
    }

    public void a0(g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, gVar, z) == null) {
            if (z) {
                pa5 pa5Var = new pa5();
                pa5Var.v(R.color.CAM_X0109);
                gVar.i.setConfig(pa5Var);
                gVar.i.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
                gVar.i.setClickState(false);
            } else {
                pa5 pa5Var2 = new pa5();
                pa5Var2.t(R.color.CAM_X0302);
                gVar.i.setConfig(pa5Var2);
                gVar.i.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e8));
                gVar.i.setClickState(true);
            }
            gVar.i.k();
        }
    }

    public final g P(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            g gVar = new g(this, null);
            gVar.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f39);
            gVar.b = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f09102e);
            gVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091032);
            gVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091033);
            gVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09102f);
            gVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09102d);
            gVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091031);
            gVar.h = view2.findViewById(R.id.obfuscated_res_0x7f091035);
            gVar.i = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f09102c);
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public void Q() {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (likeModel = this.g) != null) {
            likeModel.onDestroy();
        }
    }

    public final void V(g gVar, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, gVar, i, imMessageCenterShowItemData) == null) {
            boolean z = true;
            gVar.b.setShowOval(true);
            gVar.b.setAutoChangeStyle(true);
            gVar.b.setStrokeWith(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            gVar.b.setStrokeColorResId(R.color.CAM_X0401);
            gVar.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            gVar.b.setPlaceHolder(1);
            gVar.b.N(imMessageCenterShowItemData.getAvatar(), 10, false);
            gVar.d.setText(imMessageCenterShowItemData.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f076a));
            if (!StringUtils.isNull(imMessageCenterShowItemData.getSlogan())) {
                gVar.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0a4b, imMessageCenterShowItemData.getSlogan()));
            } else {
                gVar.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0a4d));
            }
            gVar.f.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f04b2), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getMemberCount())));
            gVar.g.setText(String.format(this.a.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getThreadCount())));
            gVar.c.setText(String.valueOf(i - 1));
            if (imMessageCenterShowItemData.getIsLike() != 1) {
                z = false;
            }
            a0(gVar, z);
            gVar.i.setOnClickListener(new a(this, imMessageCenterShowItemData, gVar));
        }
    }

    @Override // com.baidu.tieba.a88, android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        f fVar;
        g P;
        d O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048593, this, i, view2, viewGroup)) == null) {
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null) {
                if (item.getDataType() == 1) {
                    if (view2 != null && (view2.getTag() instanceof d)) {
                        O = (d) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0417, viewGroup, false);
                        O = O(view2);
                        view2.setTag(O);
                    }
                    S(O);
                    R(O);
                    return view2;
                } else if (item.getDataType() == 2) {
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        P = (g) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d041a, viewGroup, false);
                        P = P(view2);
                        view2.setTag(P);
                    }
                    W(P, i);
                    V(P, i, item);
                    Z(item);
                    return view2;
                } else if (item.getDataType() == 3) {
                    if (view2 != null && (view2.getTag() instanceof f)) {
                        fVar = (f) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d041c, viewGroup, false);
                        fVar = new f(this, view2);
                        view2.setTag(fVar);
                    }
                    U(fVar);
                    return view2;
                } else if (item.getDataType() == 4) {
                    if (view2 != null && (view2.getTag() instanceof e)) {
                        eVar = (e) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d041b, viewGroup, false);
                        eVar = new e(this, view2);
                        view2.setTag(eVar);
                    }
                    T(eVar);
                    return view2;
                }
            }
            if (item != null && String.valueOf(2).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    bm8 bm8Var = this.e;
                    if (bm8Var != null) {
                        bm8Var.u(true);
                    }
                } else {
                    bm8 bm8Var2 = this.e;
                    if (bm8Var2 != null) {
                        bm8Var2.u(false);
                    }
                }
            }
            return super.getView(i, view2, viewGroup);
        }
        return (View) invokeILL.objValue;
    }

    @Override // com.baidu.tieba.a88
    public boolean g(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null) {
                return false;
            }
            if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName())) {
                return true;
            }
            return ik8.c(imMessageCenterShowItemData);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.a88
    public void k(a88.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.b.setDrawerType(1);
            aVar.b.setRadius(xi.d(this.a, 4.0f));
            aVar.c.setClickable(false);
            if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.b.setDrawBorder(false);
                aVar.b.setAutoChangeStyle(true);
                aVar.b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.b.setUserName(String.valueOf(5));
                aVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.b.setVisibility(4);
                aVar.c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.c, R.drawable.obfuscated_res_0x7f080767, SvgManager.SvgResourceStateType.NORMAL);
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
                    aVar.b.N(friendBjhAvatar, 12, false);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001289, Integer.class);
                    if (runTask != null && runTask.getData() != null) {
                        aVar.b.N(((Integer) runTask.getData()).toString(), 24, false);
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
                SkinManager.setImageResource(aVar.c, R.drawable.obfuscated_res_0x7f08076f);
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
                    aVar.b.N(friendBjhAvatar2, 12, false);
                } else {
                    aVar.b.N(String.valueOf((int) R.drawable.obfuscated_res_0x7f081176), 24, false);
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
                    aVar.b.N(friendBjhAvatar3, 12, false);
                } else {
                    aVar.b.N(String.valueOf((int) R.drawable.obfuscated_res_0x7f081176), 24, false);
                }
                aVar.b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.b.setIsRound(false);
                aVar.b.invalidate();
            }
        }
    }

    @Override // com.baidu.tieba.a88
    public void v(a88.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, aVar, imMessageCenterShowItemData) == null) {
            if (String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f.setVisibility(0);
            } else {
                aVar.f.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a88
    public BasicNameValuePair z(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        InterceptResult invokeLIL;
        OfficialSettingItemData officialSettingItemData;
        PersonalSettingItemData personalSettingItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048597, this, imMessageCenterShowItemData, i, str)) == null) {
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName()) || (!String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName()) ? !(!String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) : se5.d().w() && ((officialSettingItemData = (OfficialSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || officialSettingItemData.isAcceptNotify()) : (personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || personalSettingItemData.isAcceptNotify()) : !(se5.d().G() && za8.a().b()))) {
                str = "";
                i = 0;
            }
            return new BasicNameValuePair(String.valueOf(i), str);
        }
        return (BasicNameValuePair) invokeLIL.objValue;
    }
}
