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
import c.a.r0.s1.f.i.c;
import c.a.r0.y3.i0;
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
public class ImMessageCenterListAdapter extends c.a.r0.s1.f.i.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.t1.b.e f43759h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f43760i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f43761e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f43762f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f43763g;

        public a(ImMessageCenterListAdapter imMessageCenterListAdapter, ImMessageCenterShowItemData imMessageCenterShowItemData, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterListAdapter, imMessageCenterShowItemData, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43763g = imMessageCenterListAdapter;
            this.f43761e = imMessageCenterShowItemData;
            this.f43762f = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f43761e.getIsLike() != 1) {
                    this.f43763g.B(this.f43762f, this.f43761e);
                    this.f43763g.A(this.f43761e, 1);
                    return;
                }
                this.f43763g.C(this.f43762f, this.f43761e);
                this.f43763g.A(this.f43761e, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LikeModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f43764b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f43765c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f43766d;

        public b(ImMessageCenterListAdapter imMessageCenterListAdapter, LikeModel likeModel, ImMessageCenterShowItemData imMessageCenterShowItemData, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterListAdapter, likeModel, imMessageCenterShowItemData, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43766d = imMessageCenterListAdapter;
            this.a = likeModel;
            this.f43764b = imMessageCenterShowItemData;
            this.f43765c = gVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.getErrorCode() == 22) {
                    n.N(this.f43766d.f21710e, this.f43766d.f21710e.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.a.getErrorCode() != 0) {
                        n.N(this.f43766d.f21710e, this.a.getErrorString());
                        return;
                    }
                    this.f43764b.setIsLike(1);
                    this.f43766d.N(this.f43765c, true);
                    n.N(this.f43766d.f21710e, this.f43766d.f21710e.getString(R.string.attention_success));
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
        public final /* synthetic */ g f43767b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f43768c;

        public c(ImMessageCenterListAdapter imMessageCenterListAdapter, ImMessageCenterShowItemData imMessageCenterShowItemData, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterListAdapter, imMessageCenterShowItemData, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43768c = imMessageCenterListAdapter;
            this.a = imMessageCenterShowItemData;
            this.f43767b = gVar;
        }

        @Override // c.a.r0.y3.i0.a
        public void a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            }
        }

        @Override // c.a.r0.y3.i0.a
        public void b(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                this.a.setIsLike(0);
                this.f43768c.N(this.f43767b, false);
                n.N(this.f43768c.f21710e, this.f43768c.f21710e.getString(R.string.un_attention_success));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f43769b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f43770c;

        /* renamed from: d  reason: collision with root package name */
        public View f43771d;

        public d(ImMessageCenterListAdapter imMessageCenterListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TextView) view.findViewById(R.id.im_rec_forum_no_more_tv);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TextView) view.findViewById(R.id.im_rec_forum_title_tv);
        }
    }

    /* loaded from: classes5.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f43772b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f43773c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f43774d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f43775e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f43776f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f43777g;

        /* renamed from: h  reason: collision with root package name */
        public View f43778h;

        /* renamed from: i  reason: collision with root package name */
        public TBSpecificationBtn f43779i;

        public g(ImMessageCenterListAdapter imMessageCenterListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imMessageCenterListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43759h = null;
        this.f43760i = null;
    }

    public final void A(ImMessageCenterShowItemData imMessageCenterShowItemData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, imMessageCenterShowItemData, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.IM_REC_FORUM_ATTENTION_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", imMessageCenterShowItemData.getForumId());
            statisticItem.param("fname", imMessageCenterShowItemData.getForumName());
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void B(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, imMessageCenterShowItemData) == null) {
            LikeModel likeModel = new LikeModel(this.f43760i);
            if (!n.C()) {
                Context context = this.f21710e;
                UtilHelper.showToast(context, context.getString(R.string.neterror));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.f21710e)) {
            } else {
                likeModel.setLoadDataCallBack(new b(this, likeModel, imMessageCenterShowItemData, gVar));
                if (m.isForumName(imMessageCenterShowItemData.getForumName())) {
                    likeModel.N(imMessageCenterShowItemData.getForumName(), String.valueOf(imMessageCenterShowItemData.getForumId()));
                }
            }
        }
    }

    public final void C(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, imMessageCenterShowItemData) == null) {
            if (!n.C()) {
                Context context = this.f21710e;
                UtilHelper.showToast(context, context.getString(R.string.neterror));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.f21710e)) {
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
            dVar.a = (TbImageView) view.findViewById(R.id.im_no_data_image);
            dVar.f43769b = (TextView) view.findViewById(R.id.im_no_data_text);
            dVar.f43770c = (TextView) view.findViewById(R.id.im_no_data_text2);
            dVar.f43771d = view.findViewById(R.id.im_no_data_dev);
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final g E(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            g gVar = new g(this, null);
            gVar.a = (LinearLayout) view.findViewById(R.id.rootview);
            gVar.f43772b = (BarImageView) view.findViewById(R.id.im_rec_forum_bar_icon);
            gVar.f43773c = (TextView) view.findViewById(R.id.im_rec_forum_ranking);
            gVar.f43774d = (TextView) view.findViewById(R.id.im_rec_forum_title);
            gVar.f43775e = (TextView) view.findViewById(R.id.im_rec_forum_introduce);
            gVar.f43776f = (TextView) view.findViewById(R.id.im_rec_forum_attention_content);
            gVar.f43777g = (TextView) view.findViewById(R.id.im_rec_forum_pb_content);
            gVar.f43778h = view.findViewById(R.id.im_rec_item_line);
            gVar.f43779i = (TBSpecificationBtn) view.findViewById(R.id.im_rec_forum_attention_btn);
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public final void F(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            SkinManager.setImageResource(dVar.a, R.drawable.im_no_data_icon);
            dVar.a.setUseNightOrDarkMask(false);
            dVar.f43769b.setText(this.f21710e.getString(R.string.im_no_data_text));
            dVar.f43770c.setText(this.f21710e.getString(R.string.im_no_data_text2));
        }
    }

    public final void G(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(dVar.f43769b);
            d2.v(R.color.CAM_X0107);
            d2.z(R.dimen.T_X07);
            c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(dVar.f43770c);
            d3.v(R.color.CAM_X0110);
            d3.z(R.dimen.T_X08);
            c.a.q0.r.v.c.d(dVar.f43771d).f(R.color.CAM_X0204);
        }
    }

    public final void H(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(eVar.a);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X08);
        }
    }

    public final void I(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(fVar.a);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
        }
    }

    public final void J(g gVar, int i2, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, gVar, i2, imMessageCenterShowItemData) == null) {
            gVar.f43772b.setShowOval(true);
            gVar.f43772b.setAutoChangeStyle(true);
            gVar.f43772b.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            gVar.f43772b.setStrokeColorResId(R.color.CAM_X0401);
            gVar.f43772b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            gVar.f43772b.setPlaceHolder(1);
            gVar.f43772b.startLoad(imMessageCenterShowItemData.getAvatar(), 10, false);
            gVar.f43774d.setText(imMessageCenterShowItemData.getForumName() + this.f21710e.getString(R.string.forum));
            if (!StringUtils.isNull(imMessageCenterShowItemData.getSlogan())) {
                gVar.f43775e.setText(this.f21710e.getString(R.string.im_rec_forum_introduce, imMessageCenterShowItemData.getSlogan()));
            } else {
                gVar.f43775e.setText(this.f21710e.getString(R.string.im_rec_forum_no_introduce_content));
            }
            gVar.f43776f.setText(String.format(this.f21710e.getString(R.string.concern), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getMemberCount())));
            gVar.f43777g.setText(String.format(this.f21710e.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getThreadCount())));
            gVar.f43773c.setText(String.valueOf(i2 - 1));
            N(gVar, imMessageCenterShowItemData.getIsLike() == 1);
            gVar.f43779i.setOnClickListener(new a(this, imMessageCenterShowItemData, gVar));
        }
    }

    public final void K(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, gVar, i2) == null) {
            int i3 = i2 == 2 ? R.color.CAM_X0301 : i2 == 3 ? R.color.CAM_X0319 : i2 == 4 ? R.color.CAM_X0305 : R.color.CAM_X0315;
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(gVar.f43773c);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0101);
            d2.n(R.string.J_X04);
            d2.f(i3);
            c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(gVar.f43774d);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X06);
            c.a.q0.r.v.c d4 = c.a.q0.r.v.c.d(gVar.f43775e);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X09);
            c.a.q0.r.v.c d5 = c.a.q0.r.v.c.d(gVar.f43776f);
            d5.v(R.color.CAM_X0109);
            d5.z(R.dimen.T_X09);
            c.a.q0.r.v.c d6 = c.a.q0.r.v.c.d(gVar.f43777g);
            d6.v(R.color.CAM_X0109);
            d6.z(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(gVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void L(c.a.r0.t1.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f43759h = eVar;
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
                c.a.q0.r.l0.n.b bVar = new c.a.q0.r.l0.n.b();
                bVar.t(R.color.CAM_X0109);
                gVar.f43779i.setConfig(bVar);
                gVar.f43779i.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
                gVar.f43779i.setClickState(false);
            } else {
                c.a.q0.r.l0.n.b bVar2 = new c.a.q0.r.l0.n.b();
                bVar2.r(R.color.CAM_X0302);
                gVar.f43779i.setConfig(bVar2);
                gVar.f43779i.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
                gVar.f43779i.setClickState(true);
            }
            gVar.f43779i.changeSkinType();
        }
    }

    @Override // c.a.r0.s1.f.i.c
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

    @Override // c.a.r0.s1.f.i.c
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

    @Override // c.a.r0.s1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.f21713b.setDrawerType(1);
            aVar.f21713b.setRadius(n.d(this.f21710e, 4.0f));
            aVar.f21714c.setClickable(false);
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21713b.setDrawBorder(false);
                aVar.f21713b.setAutoChangeStyle(true);
                aVar.f21713b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f21713b.setVisibility(0);
                aVar.f21714c.setVisibility(8);
                if (MessageManager.getInstance().runTask(2001287, Integer.class) != null) {
                    SkinManager.setImageResource(aVar.f21713b, R.drawable.icon_new_test);
                }
                aVar.f21713b.setUserName(String.valueOf(2));
                aVar.f21713b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21713b.setIsRound(false);
                aVar.f21713b.invalidate();
            } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21713b.setDrawBorder(false);
                aVar.f21713b.setAutoChangeStyle(true);
                aVar.f21713b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f21713b.setUserName(String.valueOf(3));
                aVar.f21713b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21713b.setVisibility(0);
                aVar.f21714c.setVisibility(8);
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, Integer.class);
                if (runTask != null) {
                    SkinManager.setImageResource(aVar.f21713b, ((Integer) runTask.getData()).intValue());
                }
                aVar.f21713b.setIsRound(false);
                aVar.f21713b.invalidate();
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21713b.setDrawBorder(true);
                aVar.f21713b.setAutoChangeStyle(true);
                aVar.f21713b.setUserId(imMessageCenterShowItemData.getFriendId());
                String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f21713b.setImageDrawable(null);
                aVar.f21713b.setVisibility(0);
                aVar.f21714c.setVisibility(8);
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    aVar.f21713b.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
                } else {
                    aVar.f21713b.startLoad(friendBjhAvatar, 10, false);
                }
                aVar.f21713b.setClickable(false);
                aVar.f21713b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f21713b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21713b.setUserName(String.valueOf(1));
                aVar.f21713b.setIsRound(false);
                aVar.f21713b.invalidate();
            } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21713b.setDrawBorder(false);
                aVar.f21713b.setAutoChangeStyle(true);
                aVar.f21713b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f21713b.setUserName(String.valueOf(5));
                aVar.f21713b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21713b.setVisibility(4);
                aVar.f21714c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f21714c, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
                aVar.f21713b.setIsRound(false);
                aVar.f21713b.invalidate();
            } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21713b.setDrawBorder(true);
                aVar.f21713b.setAutoChangeStyle(true);
                String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f21713b.setVisibility(0);
                aVar.f21714c.setVisibility(8);
                aVar.f21713b.setImageDrawable(null);
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001289, Integer.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        aVar.f21713b.startLoad(((Integer) runTask2.getData()).toString(), 24, false);
                    }
                } else {
                    aVar.f21713b.startLoad(friendBjhAvatar2, 12, false);
                }
                aVar.f21713b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f21713b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21713b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.f21713b.setIsRound(false);
                aVar.f21713b.invalidate();
            } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21713b.setDrawBorder(false);
                aVar.f21713b.setAutoChangeStyle(true);
                aVar.f21713b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f21713b.setUserName(String.valueOf(7));
                aVar.f21713b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21713b.setVisibility(4);
                aVar.f21714c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f21714c, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
                aVar.f21713b.setIsRound(false);
                aVar.f21713b.invalidate();
            } else {
                aVar.f21713b.setDrawBorder(true);
                aVar.f21713b.setAutoChangeStyle(true);
                String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar3)) {
                    friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f21713b.setImageDrawable(null);
                aVar.f21713b.setVisibility(0);
                aVar.f21714c.setVisibility(8);
                if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                    aVar.f21713b.startLoad(friendBjhAvatar3, 12, false);
                } else {
                    aVar.f21713b.startLoad(String.valueOf((int) R.drawable.person_photo), 24, false);
                }
                aVar.f21713b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f21713b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21713b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.f21713b.setIsRound(false);
                aVar.f21713b.invalidate();
            }
        }
    }

    @Override // c.a.r0.s1.f.i.c, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        f fVar;
        g E;
        d D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048593, this, i2, view, viewGroup)) == null) {
            ImMessageCenterShowItemData item = getItem(i2);
            if (TbSingleton.getInstance().isImRecForumShow() && item != null) {
                if (item.getDataType() == 1) {
                    if (view != null && (view.getTag() instanceof d)) {
                        D = (d) view.getTag();
                    } else {
                        view = LayoutInflater.from(this.f21710e).inflate(R.layout.im_no_data_item_layout, viewGroup, false);
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
                        view = LayoutInflater.from(this.f21710e).inflate(R.layout.im_rec_forum_item_layout, viewGroup, false);
                        E = E(view);
                        view.setTag(E);
                    }
                    K(E, i2);
                    J(E, i2, item);
                    M(item);
                    return view;
                } else if (item.getDataType() == 3) {
                    if (view != null && (view.getTag() instanceof f)) {
                        fVar = (f) view.getTag();
                    } else {
                        view = LayoutInflater.from(this.f21710e).inflate(R.layout.im_rec_forum_title_layout, viewGroup, false);
                        fVar = new f(this, view);
                        view.setTag(fVar);
                    }
                    I(fVar);
                    return view;
                } else if (item.getDataType() == 4) {
                    if (view != null && (view.getTag() instanceof e)) {
                        eVar = (e) view.getTag();
                    } else {
                        view = LayoutInflater.from(this.f21710e).inflate(R.layout.im_rec_forum_no_more_layout, viewGroup, false);
                        eVar = new e(this, view);
                        view.setTag(eVar);
                    }
                    H(eVar);
                    return view;
                }
            }
            if (item != null && String.valueOf(2).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    c.a.r0.t1.b.e eVar2 = this.f43759h;
                    if (eVar2 != null) {
                        eVar2.q0(true);
                    }
                } else {
                    c.a.r0.t1.b.e eVar3 = this.f43759h;
                    if (eVar3 != null) {
                        eVar3.q0(false);
                    }
                }
            }
            return super.getView(i2, view, viewGroup);
        }
        return (View) invokeILL.objValue;
    }

    @Override // c.a.r0.s1.f.i.c
    public void n(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            super.n(list);
            if (TbadkCoreApplication.isLogin()) {
                if (this.f21711f.size() <= 0) {
                    this.f43759h.r0(true, true);
                } else {
                    this.f43759h.r0(true, false);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // c.a.r0.s1.f.i.c
    public BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i2, String str) {
        InterceptResult invokeLIL;
        PersonalSettingItemData personalSettingItemData;
        GroupSettingItemData groupSettingItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048595, this, imMessageCenterShowItemData, i2, str)) == null) {
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName()) || (!String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName()) ? !(!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) : c.a.q0.s.d.d.d().r() : c.a.q0.s.d.d.d().r() && ((personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || personalSettingItemData.isAcceptNotify()) : c.a.q0.s.d.d.d().p() && ((groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || groupSettingItemData.isAcceptNotify())) : !(c.a.q0.s.d.d.d().B() && c.a.r0.s1.t.f.a().b()))) {
                str = "";
                i2 = 0;
            }
            return new BasicNameValuePair(String.valueOf(i2), str);
        }
        return (BasicNameValuePair) invokeLIL.objValue;
    }
}
