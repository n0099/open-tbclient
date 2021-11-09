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
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.r0.l1.f.i.c;
import b.a.r0.l3.h0;
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
/* loaded from: classes9.dex */
public class ImMessageCenterListAdapter extends b.a.r0.l1.f.i.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.m1.b.e f50662h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f50663i;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f50664e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f50665f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f50666g;

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
            this.f50666g = imMessageCenterListAdapter;
            this.f50664e = imMessageCenterShowItemData;
            this.f50665f = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f50664e.getIsLike() != 1) {
                    this.f50666g.B(this.f50665f, this.f50664e);
                    this.f50666g.A(this.f50664e, 1);
                    return;
                }
                this.f50666g.C(this.f50665f, this.f50664e);
                this.f50666g.A(this.f50664e, 2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LikeModel f50667a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f50668b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f50669c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f50670d;

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
            this.f50670d = imMessageCenterListAdapter;
            this.f50667a = likeModel;
            this.f50668b = imMessageCenterShowItemData;
            this.f50669c = gVar;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f50667a.getErrorCode() == 22) {
                    l.M(this.f50670d.f20025e, this.f50670d.f20025e.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.f50667a.getErrorCode() != 0) {
                        l.M(this.f50670d.f20025e, this.f50667a.getErrorString());
                        return;
                    }
                    this.f50668b.setIsLike(1);
                    this.f50670d.N(this.f50669c, true);
                    l.M(this.f50670d.f20025e, this.f50670d.f20025e.getString(R.string.attention_success));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements h0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f50671a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f50672b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f50673c;

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
            this.f50673c = imMessageCenterListAdapter;
            this.f50671a = imMessageCenterShowItemData;
            this.f50672b = gVar;
        }

        @Override // b.a.r0.l3.h0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // b.a.r0.l3.h0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.f50671a.setIsLike(0);
                this.f50673c.N(this.f50672b, false);
                l.M(this.f50673c.f20025e, this.f50673c.f20025e.getString(R.string.un_attention_success));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f50674a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f50675b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f50676c;

        /* renamed from: d  reason: collision with root package name */
        public View f50677d;

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

    /* loaded from: classes9.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f50678a;

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
            this.f50678a = (TextView) view.findViewById(R.id.im_rec_forum_no_more_tv);
        }
    }

    /* loaded from: classes9.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f50679a;

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
            this.f50679a = (TextView) view.findViewById(R.id.im_rec_forum_title_tv);
        }
    }

    /* loaded from: classes9.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f50680a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f50681b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f50682c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f50683d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f50684e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f50685f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f50686g;

        /* renamed from: h  reason: collision with root package name */
        public View f50687h;

        /* renamed from: i  reason: collision with root package name */
        public TBSpecificationBtn f50688i;

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
        this.f50662h = null;
        this.f50663i = null;
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
            LikeModel likeModel = new LikeModel(this.f50663i);
            if (!l.D()) {
                Context context = this.f20025e;
                UtilHelper.showToast(context, context.getString(R.string.neterror));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.f20025e)) {
            } else {
                likeModel.setLoadDataCallBack(new b(this, likeModel, imMessageCenterShowItemData, gVar));
                if (k.isForumName(imMessageCenterShowItemData.getForumName())) {
                    likeModel.L(imMessageCenterShowItemData.getForumName(), String.valueOf(imMessageCenterShowItemData.getForumId()));
                }
            }
        }
    }

    public final void C(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, imMessageCenterShowItemData) == null) {
            if (!l.D()) {
                Context context = this.f20025e;
                UtilHelper.showToast(context, context.getString(R.string.neterror));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.f20025e)) {
            } else {
                h0 h0Var = new h0();
                h0Var.b(new c(this, imMessageCenterShowItemData, gVar));
                h0Var.c(imMessageCenterShowItemData.getForumName(), imMessageCenterShowItemData.getForumId());
            }
        }
    }

    public final d D(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            d dVar = new d(this, null);
            dVar.f50674a = (TbImageView) view.findViewById(R.id.im_no_data_image);
            dVar.f50675b = (TextView) view.findViewById(R.id.im_no_data_text);
            dVar.f50676c = (TextView) view.findViewById(R.id.im_no_data_text2);
            dVar.f50677d = view.findViewById(R.id.im_no_data_dev);
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final g E(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            g gVar = new g(this, null);
            gVar.f50680a = (LinearLayout) view.findViewById(R.id.rootview);
            gVar.f50681b = (BarImageView) view.findViewById(R.id.im_rec_forum_bar_icon);
            gVar.f50682c = (TextView) view.findViewById(R.id.im_rec_forum_ranking);
            gVar.f50683d = (TextView) view.findViewById(R.id.im_rec_forum_title);
            gVar.f50684e = (TextView) view.findViewById(R.id.im_rec_forum_introduce);
            gVar.f50685f = (TextView) view.findViewById(R.id.im_rec_forum_attention_content);
            gVar.f50686g = (TextView) view.findViewById(R.id.im_rec_forum_pb_content);
            gVar.f50687h = view.findViewById(R.id.im_rec_item_line);
            gVar.f50688i = (TBSpecificationBtn) view.findViewById(R.id.im_rec_forum_attention_btn);
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public final void F(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            SkinManager.setImageResource(dVar.f50674a, R.drawable.im_no_data_icon);
            dVar.f50674a.setUseNightOrDarkMask(false);
            dVar.f50675b.setText(this.f20025e.getString(R.string.im_no_data_text));
            dVar.f50676c.setText(this.f20025e.getString(R.string.im_no_data_text2));
        }
    }

    public final void G(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(dVar.f50675b);
            d2.v(R.color.CAM_X0107);
            d2.z(R.dimen.T_X07);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(dVar.f50676c);
            d3.v(R.color.CAM_X0110);
            d3.z(R.dimen.T_X08);
            b.a.q0.s.u.c.d(dVar.f50677d).f(R.color.CAM_X0204);
        }
    }

    public final void H(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(eVar.f50678a);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X08);
        }
    }

    public final void I(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(fVar.f50679a);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
        }
    }

    public final void J(g gVar, int i2, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, gVar, i2, imMessageCenterShowItemData) == null) {
            gVar.f50681b.setShowOval(true);
            gVar.f50681b.setAutoChangeStyle(true);
            gVar.f50681b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            gVar.f50681b.setStrokeColorResId(R.color.CAM_X0401);
            gVar.f50681b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            gVar.f50681b.setPlaceHolder(1);
            gVar.f50681b.startLoad(imMessageCenterShowItemData.getAvatar(), 10, false);
            gVar.f50683d.setText(imMessageCenterShowItemData.getForumName() + this.f20025e.getString(R.string.forum));
            if (!StringUtils.isNull(imMessageCenterShowItemData.getSlogan())) {
                gVar.f50684e.setText(this.f20025e.getString(R.string.im_rec_forum_introduce, imMessageCenterShowItemData.getSlogan()));
            } else {
                gVar.f50684e.setText(this.f20025e.getString(R.string.im_rec_forum_no_introduce_content));
            }
            gVar.f50685f.setText(String.format(this.f20025e.getString(R.string.concern), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getMemberCount())));
            gVar.f50686g.setText(String.format(this.f20025e.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getThreadCount())));
            gVar.f50682c.setText(String.valueOf(i2 - 1));
            N(gVar, imMessageCenterShowItemData.getIsLike() == 1);
            gVar.f50688i.setOnClickListener(new a(this, imMessageCenterShowItemData, gVar));
        }
    }

    public final void K(g gVar, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, gVar, i2) == null) {
            if (i2 == 2) {
                i3 = R.color.CAM_X0301;
            } else if (i2 == 3) {
                i3 = R.color.CAM_X0319;
            } else if (i2 == 4) {
                i3 = R.color.CAM_X0305;
            } else {
                i3 = R.color.CAM_X0315;
            }
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(gVar.f50682c);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0101);
            d2.n(R.string.J_X04);
            d2.f(i3);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(gVar.f50683d);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X06);
            b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(gVar.f50684e);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X09);
            b.a.q0.s.u.c d5 = b.a.q0.s.u.c.d(gVar.f50685f);
            d5.v(R.color.CAM_X0109);
            d5.z(R.dimen.T_X09);
            b.a.q0.s.u.c d6 = b.a.q0.s.u.c.d(gVar.f50686g);
            d6.v(R.color.CAM_X0109);
            d6.z(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(gVar.f50680a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void L(b.a.r0.m1.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f50662h = eVar;
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
                b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
                bVar.s(R.color.CAM_X0109);
                gVar.f50688i.setConfig(bVar);
                gVar.f50688i.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
                gVar.f50688i.setClickState(false);
            } else {
                b.a.q0.s.g0.n.b bVar2 = new b.a.q0.s.g0.n.b();
                bVar2.r(R.color.CAM_X0302);
                gVar.f50688i.setConfig(bVar2);
                gVar.f50688i.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
                gVar.f50688i.setClickState(true);
            }
            gVar.f50688i.changeSkinType();
        }
    }

    @Override // b.a.r0.l1.f.i.c
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

    @Override // b.a.r0.l1.f.i.c
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

    @Override // b.a.r0.l1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.f20029b.setDrawerType(1);
            aVar.f20029b.setRadius(l.e(this.f20025e, 4.0f));
            aVar.f20030c.setClickable(false);
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f20029b.setDrawBorder(false);
                aVar.f20029b.setAutoChangeStyle(true);
                aVar.f20029b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f20029b.setVisibility(0);
                aVar.f20030c.setVisibility(8);
                if (MessageManager.getInstance().runTask(2001287, Integer.class) != null) {
                    SkinManager.setImageResource(aVar.f20029b, R.drawable.icon_new_test);
                }
                aVar.f20029b.setUserName(String.valueOf(2));
                aVar.f20029b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f20029b.setIsRound(false);
                aVar.f20029b.invalidate();
            } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f20029b.setDrawBorder(false);
                aVar.f20029b.setAutoChangeStyle(true);
                aVar.f20029b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f20029b.setUserName(String.valueOf(3));
                aVar.f20029b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f20029b.setVisibility(0);
                aVar.f20030c.setVisibility(8);
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, Integer.class);
                if (runTask != null) {
                    SkinManager.setImageResource(aVar.f20029b, ((Integer) runTask.getData()).intValue());
                }
                aVar.f20029b.setIsRound(false);
                aVar.f20029b.invalidate();
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f20029b.setDrawBorder(true);
                aVar.f20029b.setAutoChangeStyle(true);
                aVar.f20029b.setUserId(imMessageCenterShowItemData.getFriendId());
                String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f20029b.setImageDrawable(null);
                aVar.f20029b.setVisibility(0);
                aVar.f20030c.setVisibility(8);
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    aVar.f20029b.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
                } else {
                    aVar.f20029b.startLoad(friendBjhAvatar, 10, false);
                }
                aVar.f20029b.setClickable(false);
                aVar.f20029b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f20029b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f20029b.setUserName(String.valueOf(1));
                aVar.f20029b.setIsRound(false);
                aVar.f20029b.invalidate();
            } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f20029b.setDrawBorder(false);
                aVar.f20029b.setAutoChangeStyle(true);
                aVar.f20029b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f20029b.setUserName(String.valueOf(5));
                aVar.f20029b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f20029b.setVisibility(4);
                aVar.f20030c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f20030c, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
                aVar.f20029b.setIsRound(false);
                aVar.f20029b.invalidate();
            } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f20029b.setDrawBorder(true);
                aVar.f20029b.setAutoChangeStyle(true);
                String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f20029b.setVisibility(0);
                aVar.f20030c.setVisibility(8);
                aVar.f20029b.setImageDrawable(null);
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001289, Integer.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        aVar.f20029b.startLoad(((Integer) runTask2.getData()).toString(), 24, false);
                    }
                } else {
                    aVar.f20029b.startLoad(friendBjhAvatar2, 12, false);
                }
                aVar.f20029b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f20029b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f20029b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.f20029b.setIsRound(false);
                aVar.f20029b.invalidate();
            } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f20029b.setDrawBorder(false);
                aVar.f20029b.setAutoChangeStyle(true);
                aVar.f20029b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f20029b.setUserName(String.valueOf(7));
                aVar.f20029b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f20029b.setVisibility(4);
                aVar.f20030c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f20030c, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
                aVar.f20029b.setIsRound(false);
                aVar.f20029b.invalidate();
            } else {
                aVar.f20029b.setDrawBorder(true);
                aVar.f20029b.setAutoChangeStyle(true);
                String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar3)) {
                    friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f20029b.setImageDrawable(null);
                aVar.f20029b.setVisibility(0);
                aVar.f20030c.setVisibility(8);
                if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                    aVar.f20029b.startLoad(friendBjhAvatar3, 12, false);
                } else {
                    aVar.f20029b.startLoad(String.valueOf(R.drawable.person_photo), 24, false);
                }
                aVar.f20029b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f20029b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f20029b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.f20029b.setIsRound(false);
                aVar.f20029b.invalidate();
            }
        }
    }

    @Override // b.a.r0.l1.f.i.c, android.widget.Adapter
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
                        view = LayoutInflater.from(this.f20025e).inflate(R.layout.im_no_data_item_layout, viewGroup, false);
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
                        view = LayoutInflater.from(this.f20025e).inflate(R.layout.im_rec_forum_item_layout, viewGroup, false);
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
                        view = LayoutInflater.from(this.f20025e).inflate(R.layout.im_rec_forum_title_layout, viewGroup, false);
                        fVar = new f(this, view);
                        view.setTag(fVar);
                    }
                    I(fVar);
                    return view;
                } else if (item.getDataType() == 4) {
                    if (view != null && (view.getTag() instanceof e)) {
                        eVar = (e) view.getTag();
                    } else {
                        view = LayoutInflater.from(this.f20025e).inflate(R.layout.im_rec_forum_no_more_layout, viewGroup, false);
                        eVar = new e(this, view);
                        view.setTag(eVar);
                    }
                    H(eVar);
                    return view;
                }
            }
            if (item != null && String.valueOf(2).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    b.a.r0.m1.b.e eVar2 = this.f50662h;
                    if (eVar2 != null) {
                        eVar2.x0(true);
                    }
                } else {
                    b.a.r0.m1.b.e eVar3 = this.f50662h;
                    if (eVar3 != null) {
                        eVar3.x0(false);
                    }
                }
            }
            return super.getView(i2, view, viewGroup);
        }
        return (View) invokeILL.objValue;
    }

    @Override // b.a.r0.l1.f.i.c
    public void n(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            super.n(list);
            if (TbadkCoreApplication.isLogin()) {
                if (this.f20026f.size() <= 0) {
                    this.f50662h.y0(true, true);
                } else {
                    this.f50662h.y0(true, false);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // b.a.r0.l1.f.i.c
    public BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i2, String str) {
        InterceptResult invokeLIL;
        PersonalSettingItemData personalSettingItemData;
        GroupSettingItemData groupSettingItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048595, this, imMessageCenterShowItemData, i2, str)) == null) {
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName()) || (!String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName()) ? !(!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) : b.a.q0.t.d.d.d().p() : b.a.q0.t.d.d.d().p() && ((personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || personalSettingItemData.isAcceptNotify()) : b.a.q0.t.d.d.d().n() && ((groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || groupSettingItemData.isAcceptNotify())) : !(b.a.q0.t.d.d.d().z() && b.a.r0.l1.t.f.a().b()))) {
                str = "";
                i2 = 0;
            }
            return new BasicNameValuePair(String.valueOf(i2), str);
        }
        return (BasicNameValuePair) invokeLIL.objValue;
    }
}
