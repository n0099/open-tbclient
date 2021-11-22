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
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import b.a.r0.l1.f.i.c;
import b.a.r0.m3.h0;
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
    public b.a.r0.m1.b.e f51574h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f51575i;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f51576e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f51577f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f51578g;

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
            this.f51578g = imMessageCenterListAdapter;
            this.f51576e = imMessageCenterShowItemData;
            this.f51577f = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f51576e.getIsLike() != 1) {
                    this.f51578g.B(this.f51577f, this.f51576e);
                    this.f51578g.A(this.f51576e, 1);
                    return;
                }
                this.f51578g.C(this.f51577f, this.f51576e);
                this.f51578g.A(this.f51576e, 2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LikeModel f51579a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f51580b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f51581c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f51582d;

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
            this.f51582d = imMessageCenterListAdapter;
            this.f51579a = likeModel;
            this.f51580b = imMessageCenterShowItemData;
            this.f51581c = gVar;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f51579a.getErrorCode() == 22) {
                    l.M(this.f51582d.f21547e, this.f51582d.f21547e.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.f51579a.getErrorCode() != 0) {
                        l.M(this.f51582d.f21547e, this.f51579a.getErrorString());
                        return;
                    }
                    this.f51580b.setIsLike(1);
                    this.f51582d.N(this.f51581c, true);
                    l.M(this.f51582d.f21547e, this.f51582d.f21547e.getString(R.string.attention_success));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements h0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f51583a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f51584b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f51585c;

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
            this.f51585c = imMessageCenterListAdapter;
            this.f51583a = imMessageCenterShowItemData;
            this.f51584b = gVar;
        }

        @Override // b.a.r0.m3.h0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // b.a.r0.m3.h0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.f51583a.setIsLike(0);
                this.f51585c.N(this.f51584b, false);
                l.M(this.f51585c.f21547e, this.f51585c.f21547e.getString(R.string.un_attention_success));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f51586a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f51587b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f51588c;

        /* renamed from: d  reason: collision with root package name */
        public View f51589d;

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
        public TextView f51590a;

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
            this.f51590a = (TextView) view.findViewById(R.id.im_rec_forum_no_more_tv);
        }
    }

    /* loaded from: classes9.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f51591a;

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
            this.f51591a = (TextView) view.findViewById(R.id.im_rec_forum_title_tv);
        }
    }

    /* loaded from: classes9.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f51592a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f51593b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f51594c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f51595d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f51596e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f51597f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f51598g;

        /* renamed from: h  reason: collision with root package name */
        public View f51599h;

        /* renamed from: i  reason: collision with root package name */
        public TBSpecificationBtn f51600i;

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
        this.f51574h = null;
        this.f51575i = null;
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
            LikeModel likeModel = new LikeModel(this.f51575i);
            if (!l.D()) {
                Context context = this.f21547e;
                UtilHelper.showToast(context, context.getString(R.string.neterror));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.f21547e)) {
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
                Context context = this.f21547e;
                UtilHelper.showToast(context, context.getString(R.string.neterror));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.f21547e)) {
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
            dVar.f51586a = (TbImageView) view.findViewById(R.id.im_no_data_image);
            dVar.f51587b = (TextView) view.findViewById(R.id.im_no_data_text);
            dVar.f51588c = (TextView) view.findViewById(R.id.im_no_data_text2);
            dVar.f51589d = view.findViewById(R.id.im_no_data_dev);
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final g E(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            g gVar = new g(this, null);
            gVar.f51592a = (LinearLayout) view.findViewById(R.id.rootview);
            gVar.f51593b = (BarImageView) view.findViewById(R.id.im_rec_forum_bar_icon);
            gVar.f51594c = (TextView) view.findViewById(R.id.im_rec_forum_ranking);
            gVar.f51595d = (TextView) view.findViewById(R.id.im_rec_forum_title);
            gVar.f51596e = (TextView) view.findViewById(R.id.im_rec_forum_introduce);
            gVar.f51597f = (TextView) view.findViewById(R.id.im_rec_forum_attention_content);
            gVar.f51598g = (TextView) view.findViewById(R.id.im_rec_forum_pb_content);
            gVar.f51599h = view.findViewById(R.id.im_rec_item_line);
            gVar.f51600i = (TBSpecificationBtn) view.findViewById(R.id.im_rec_forum_attention_btn);
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public final void F(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            SkinManager.setImageResource(dVar.f51586a, R.drawable.im_no_data_icon);
            dVar.f51586a.setUseNightOrDarkMask(false);
            dVar.f51587b.setText(this.f21547e.getString(R.string.im_no_data_text));
            dVar.f51588c.setText(this.f21547e.getString(R.string.im_no_data_text2));
        }
    }

    public final void G(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(dVar.f51587b);
            d2.v(R.color.CAM_X0107);
            d2.z(R.dimen.T_X07);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(dVar.f51588c);
            d3.v(R.color.CAM_X0110);
            d3.z(R.dimen.T_X08);
            b.a.q0.s.u.c.d(dVar.f51589d).f(R.color.CAM_X0204);
        }
    }

    public final void H(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(eVar.f51590a);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X08);
        }
    }

    public final void I(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(fVar.f51591a);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
        }
    }

    public final void J(g gVar, int i2, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, gVar, i2, imMessageCenterShowItemData) == null) {
            gVar.f51593b.setShowOval(true);
            gVar.f51593b.setAutoChangeStyle(true);
            gVar.f51593b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            gVar.f51593b.setStrokeColorResId(R.color.CAM_X0401);
            gVar.f51593b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            gVar.f51593b.setPlaceHolder(1);
            gVar.f51593b.startLoad(imMessageCenterShowItemData.getAvatar(), 10, false);
            gVar.f51595d.setText(imMessageCenterShowItemData.getForumName() + this.f21547e.getString(R.string.forum));
            if (!StringUtils.isNull(imMessageCenterShowItemData.getSlogan())) {
                gVar.f51596e.setText(this.f21547e.getString(R.string.im_rec_forum_introduce, imMessageCenterShowItemData.getSlogan()));
            } else {
                gVar.f51596e.setText(this.f21547e.getString(R.string.im_rec_forum_no_introduce_content));
            }
            gVar.f51597f.setText(String.format(this.f21547e.getString(R.string.concern), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getMemberCount())));
            gVar.f51598g.setText(String.format(this.f21547e.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getThreadCount())));
            gVar.f51594c.setText(String.valueOf(i2 - 1));
            N(gVar, imMessageCenterShowItemData.getIsLike() == 1);
            gVar.f51600i.setOnClickListener(new a(this, imMessageCenterShowItemData, gVar));
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
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(gVar.f51594c);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0101);
            d2.n(R.string.J_X04);
            d2.f(i3);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(gVar.f51595d);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X06);
            b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(gVar.f51596e);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X09);
            b.a.q0.s.u.c d5 = b.a.q0.s.u.c.d(gVar.f51597f);
            d5.v(R.color.CAM_X0109);
            d5.z(R.dimen.T_X09);
            b.a.q0.s.u.c d6 = b.a.q0.s.u.c.d(gVar.f51598g);
            d6.v(R.color.CAM_X0109);
            d6.z(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(gVar.f51592a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void L(b.a.r0.m1.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f51574h = eVar;
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
                gVar.f51600i.setConfig(bVar);
                gVar.f51600i.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
                gVar.f51600i.setClickState(false);
            } else {
                b.a.q0.s.g0.n.b bVar2 = new b.a.q0.s.g0.n.b();
                bVar2.r(R.color.CAM_X0302);
                gVar.f51600i.setConfig(bVar2);
                gVar.f51600i.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
                gVar.f51600i.setClickState(true);
            }
            gVar.f51600i.changeSkinType();
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
            aVar.f21551b.setDrawerType(1);
            aVar.f21551b.setRadius(l.e(this.f21547e, 4.0f));
            aVar.f21552c.setClickable(false);
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21551b.setDrawBorder(false);
                aVar.f21551b.setAutoChangeStyle(true);
                aVar.f21551b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f21551b.setVisibility(0);
                aVar.f21552c.setVisibility(8);
                if (MessageManager.getInstance().runTask(2001287, Integer.class) != null) {
                    SkinManager.setImageResource(aVar.f21551b, R.drawable.icon_new_test);
                }
                aVar.f21551b.setUserName(String.valueOf(2));
                aVar.f21551b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21551b.setIsRound(false);
                aVar.f21551b.invalidate();
            } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21551b.setDrawBorder(false);
                aVar.f21551b.setAutoChangeStyle(true);
                aVar.f21551b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f21551b.setUserName(String.valueOf(3));
                aVar.f21551b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21551b.setVisibility(0);
                aVar.f21552c.setVisibility(8);
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, Integer.class);
                if (runTask != null) {
                    SkinManager.setImageResource(aVar.f21551b, ((Integer) runTask.getData()).intValue());
                }
                aVar.f21551b.setIsRound(false);
                aVar.f21551b.invalidate();
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21551b.setDrawBorder(true);
                aVar.f21551b.setAutoChangeStyle(true);
                aVar.f21551b.setUserId(imMessageCenterShowItemData.getFriendId());
                String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f21551b.setImageDrawable(null);
                aVar.f21551b.setVisibility(0);
                aVar.f21552c.setVisibility(8);
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    aVar.f21551b.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
                } else {
                    aVar.f21551b.startLoad(friendBjhAvatar, 10, false);
                }
                aVar.f21551b.setClickable(false);
                aVar.f21551b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f21551b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21551b.setUserName(String.valueOf(1));
                aVar.f21551b.setIsRound(false);
                aVar.f21551b.invalidate();
            } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21551b.setDrawBorder(false);
                aVar.f21551b.setAutoChangeStyle(true);
                aVar.f21551b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f21551b.setUserName(String.valueOf(5));
                aVar.f21551b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21551b.setVisibility(4);
                aVar.f21552c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f21552c, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
                aVar.f21551b.setIsRound(false);
                aVar.f21551b.invalidate();
            } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21551b.setDrawBorder(true);
                aVar.f21551b.setAutoChangeStyle(true);
                String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f21551b.setVisibility(0);
                aVar.f21552c.setVisibility(8);
                aVar.f21551b.setImageDrawable(null);
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001289, Integer.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        aVar.f21551b.startLoad(((Integer) runTask2.getData()).toString(), 24, false);
                    }
                } else {
                    aVar.f21551b.startLoad(friendBjhAvatar2, 12, false);
                }
                aVar.f21551b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f21551b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21551b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.f21551b.setIsRound(false);
                aVar.f21551b.invalidate();
            } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21551b.setDrawBorder(false);
                aVar.f21551b.setAutoChangeStyle(true);
                aVar.f21551b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f21551b.setUserName(String.valueOf(7));
                aVar.f21551b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21551b.setVisibility(4);
                aVar.f21552c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f21552c, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
                aVar.f21551b.setIsRound(false);
                aVar.f21551b.invalidate();
            } else {
                aVar.f21551b.setDrawBorder(true);
                aVar.f21551b.setAutoChangeStyle(true);
                String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar3)) {
                    friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f21551b.setImageDrawable(null);
                aVar.f21551b.setVisibility(0);
                aVar.f21552c.setVisibility(8);
                if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                    aVar.f21551b.startLoad(friendBjhAvatar3, 12, false);
                } else {
                    aVar.f21551b.startLoad(String.valueOf(R.drawable.person_photo), 24, false);
                }
                aVar.f21551b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f21551b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21551b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.f21551b.setIsRound(false);
                aVar.f21551b.invalidate();
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
                        view = LayoutInflater.from(this.f21547e).inflate(R.layout.im_no_data_item_layout, viewGroup, false);
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
                        view = LayoutInflater.from(this.f21547e).inflate(R.layout.im_rec_forum_item_layout, viewGroup, false);
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
                        view = LayoutInflater.from(this.f21547e).inflate(R.layout.im_rec_forum_title_layout, viewGroup, false);
                        fVar = new f(this, view);
                        view.setTag(fVar);
                    }
                    I(fVar);
                    return view;
                } else if (item.getDataType() == 4) {
                    if (view != null && (view.getTag() instanceof e)) {
                        eVar = (e) view.getTag();
                    } else {
                        view = LayoutInflater.from(this.f21547e).inflate(R.layout.im_rec_forum_no_more_layout, viewGroup, false);
                        eVar = new e(this, view);
                        view.setTag(eVar);
                    }
                    H(eVar);
                    return view;
                }
            }
            if (item != null && String.valueOf(2).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    b.a.r0.m1.b.e eVar2 = this.f51574h;
                    if (eVar2 != null) {
                        eVar2.x0(true);
                    }
                } else {
                    b.a.r0.m1.b.e eVar3 = this.f51574h;
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
                if (this.f21548f.size() <= 0) {
                    this.f51574h.y0(true, true);
                } else {
                    this.f51574h.y0(true, false);
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
