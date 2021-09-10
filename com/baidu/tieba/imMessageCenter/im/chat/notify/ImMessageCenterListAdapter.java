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
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.r0.j3.g0;
import c.a.r0.k1.f.i.c;
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
/* loaded from: classes7.dex */
public class ImMessageCenterListAdapter extends c.a.r0.k1.f.i.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.l1.b.e f53373h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f53374i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f53375e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f53376f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f53377g;

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
            this.f53377g = imMessageCenterListAdapter;
            this.f53375e = imMessageCenterShowItemData;
            this.f53376f = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f53375e.getIsLike() != 1) {
                    this.f53377g.B(this.f53376f, this.f53375e);
                    this.f53377g.A(this.f53375e, 1);
                    return;
                }
                this.f53377g.C(this.f53376f, this.f53375e);
                this.f53377g.A(this.f53375e, 2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LikeModel f53378a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f53379b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f53380c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f53381d;

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
            this.f53381d = imMessageCenterListAdapter;
            this.f53378a = likeModel;
            this.f53379b = imMessageCenterShowItemData;
            this.f53380c = gVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f53378a.getErrorCode() == 22) {
                    l.M(this.f53381d.f21236e, this.f53381d.f21236e.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.f53378a.getErrorCode() != 0) {
                        l.M(this.f53381d.f21236e, this.f53378a.getErrorString());
                        return;
                    }
                    this.f53379b.setIsLike(1);
                    this.f53381d.N(this.f53380c, true);
                    l.M(this.f53381d.f21236e, this.f53381d.f21236e.getString(R.string.attention_success));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements g0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f53382a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f53383b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f53384c;

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
            this.f53384c = imMessageCenterListAdapter;
            this.f53382a = imMessageCenterShowItemData;
            this.f53383b = gVar;
        }

        @Override // c.a.r0.j3.g0.a
        public void a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            }
        }

        @Override // c.a.r0.j3.g0.a
        public void b(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                this.f53382a.setIsLike(0);
                this.f53384c.N(this.f53383b, false);
                l.M(this.f53384c.f21236e, this.f53384c.f21236e.getString(R.string.un_attention_success));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f53385a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f53386b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f53387c;

        /* renamed from: d  reason: collision with root package name */
        public View f53388d;

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

    /* loaded from: classes7.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f53389a;

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
            this.f53389a = (TextView) view.findViewById(R.id.im_rec_forum_no_more_tv);
        }
    }

    /* loaded from: classes7.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f53390a;

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
            this.f53390a = (TextView) view.findViewById(R.id.im_rec_forum_title_tv);
        }
    }

    /* loaded from: classes7.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f53391a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f53392b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f53393c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f53394d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f53395e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f53396f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f53397g;

        /* renamed from: h  reason: collision with root package name */
        public View f53398h;

        /* renamed from: i  reason: collision with root package name */
        public TBSpecificationBtn f53399i;

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
        this.f53373h = null;
        this.f53374i = null;
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
            LikeModel likeModel = new LikeModel(this.f53374i);
            if (!l.D()) {
                Context context = this.f21236e;
                UtilHelper.showToast(context, context.getString(R.string.neterror));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.f21236e)) {
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
                Context context = this.f21236e;
                UtilHelper.showToast(context, context.getString(R.string.neterror));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.f21236e)) {
            } else {
                g0 g0Var = new g0();
                g0Var.b(new c(this, imMessageCenterShowItemData, gVar));
                g0Var.c(imMessageCenterShowItemData.getForumName(), imMessageCenterShowItemData.getForumId());
            }
        }
    }

    public final d D(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            d dVar = new d(this, null);
            dVar.f53385a = (TbImageView) view.findViewById(R.id.im_no_data_image);
            dVar.f53386b = (TextView) view.findViewById(R.id.im_no_data_text);
            dVar.f53387c = (TextView) view.findViewById(R.id.im_no_data_text2);
            dVar.f53388d = view.findViewById(R.id.im_no_data_dev);
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public final g E(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            g gVar = new g(this, null);
            gVar.f53391a = (LinearLayout) view.findViewById(R.id.rootview);
            gVar.f53392b = (BarImageView) view.findViewById(R.id.im_rec_forum_bar_icon);
            gVar.f53393c = (TextView) view.findViewById(R.id.im_rec_forum_ranking);
            gVar.f53394d = (TextView) view.findViewById(R.id.im_rec_forum_title);
            gVar.f53395e = (TextView) view.findViewById(R.id.im_rec_forum_introduce);
            gVar.f53396f = (TextView) view.findViewById(R.id.im_rec_forum_attention_content);
            gVar.f53397g = (TextView) view.findViewById(R.id.im_rec_forum_pb_content);
            gVar.f53398h = view.findViewById(R.id.im_rec_item_line);
            gVar.f53399i = (TBSpecificationBtn) view.findViewById(R.id.im_rec_forum_attention_btn);
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public final void F(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            SkinManager.setImageResource(dVar.f53385a, R.drawable.im_no_data_icon);
            dVar.f53385a.setUseNightOrDarkMask(false);
            dVar.f53386b.setText(this.f21236e.getString(R.string.im_no_data_text));
            dVar.f53387c.setText(this.f21236e.getString(R.string.im_no_data_text2));
        }
    }

    public final void G(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(dVar.f53386b);
            d2.w(R.color.CAM_X0107);
            d2.A(R.dimen.T_X07);
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(dVar.f53387c);
            d3.w(R.color.CAM_X0110);
            d3.A(R.dimen.T_X08);
            c.a.q0.s.u.c.d(dVar.f53388d).f(R.color.CAM_X0204);
        }
    }

    public final void H(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(eVar.f53389a);
            d2.w(R.color.CAM_X0108);
            d2.A(R.dimen.T_X08);
        }
    }

    public final void I(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(fVar.f53390a);
            d2.w(R.color.CAM_X0105);
            d2.A(R.dimen.T_X05);
            d2.B(R.string.F_X02);
        }
    }

    public final void J(g gVar, int i2, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, gVar, i2, imMessageCenterShowItemData) == null) {
            gVar.f53392b.setShowOval(true);
            gVar.f53392b.setAutoChangeStyle(true);
            gVar.f53392b.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            gVar.f53392b.setStrokeColorResId(R.color.CAM_X0401);
            gVar.f53392b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            gVar.f53392b.setPlaceHolder(1);
            gVar.f53392b.startLoad(imMessageCenterShowItemData.getAvatar(), 10, false);
            gVar.f53394d.setText(imMessageCenterShowItemData.getForumName() + this.f21236e.getString(R.string.forum));
            if (!StringUtils.isNull(imMessageCenterShowItemData.getSlogan())) {
                gVar.f53395e.setText(this.f21236e.getString(R.string.im_rec_forum_introduce, imMessageCenterShowItemData.getSlogan()));
            } else {
                gVar.f53395e.setText(this.f21236e.getString(R.string.im_rec_forum_no_introduce_content));
            }
            gVar.f53396f.setText(String.format(this.f21236e.getString(R.string.concern), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getMemberCount())));
            gVar.f53397g.setText(String.format(this.f21236e.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getThreadCount())));
            gVar.f53393c.setText(String.valueOf(i2 - 1));
            N(gVar, imMessageCenterShowItemData.getIsLike() == 1);
            gVar.f53399i.setOnClickListener(new a(this, imMessageCenterShowItemData, gVar));
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
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(gVar.f53393c);
            d2.A(R.dimen.T_X09);
            d2.w(R.color.CAM_X0101);
            d2.o(R.string.J_X04);
            d2.f(i3);
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(gVar.f53394d);
            d3.w(R.color.CAM_X0105);
            d3.A(R.dimen.T_X06);
            c.a.q0.s.u.c d4 = c.a.q0.s.u.c.d(gVar.f53395e);
            d4.w(R.color.CAM_X0109);
            d4.A(R.dimen.T_X09);
            c.a.q0.s.u.c d5 = c.a.q0.s.u.c.d(gVar.f53396f);
            d5.w(R.color.CAM_X0109);
            d5.A(R.dimen.T_X09);
            c.a.q0.s.u.c d6 = c.a.q0.s.u.c.d(gVar.f53397g);
            d6.w(R.color.CAM_X0109);
            d6.A(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(gVar.f53391a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void L(c.a.r0.l1.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f53373h = eVar;
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
                c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
                bVar.r(R.color.CAM_X0109);
                gVar.f53399i.setConfig(bVar);
                gVar.f53399i.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
                gVar.f53399i.setClickState(false);
            } else {
                c.a.q0.s.f0.n.b bVar2 = new c.a.q0.s.f0.n.b();
                bVar2.q(R.color.CAM_X0302);
                gVar.f53399i.setConfig(bVar2);
                gVar.f53399i.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
                gVar.f53399i.setClickState(true);
            }
            gVar.f53399i.changeSkinType();
        }
    }

    @Override // c.a.r0.k1.f.i.c
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

    @Override // c.a.r0.k1.f.i.c
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

    @Override // c.a.r0.k1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.f21240b.setDrawerType(1);
            aVar.f21240b.setRadius(l.e(this.f21236e, 4.0f));
            aVar.f21241c.setClickable(false);
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21240b.setDrawBorder(false);
                aVar.f21240b.setAutoChangeStyle(true);
                aVar.f21240b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f21240b.setVisibility(0);
                aVar.f21241c.setVisibility(8);
                if (MessageManager.getInstance().runTask(2001287, Integer.class) != null) {
                    SkinManager.setImageResource(aVar.f21240b, R.drawable.icon_new_test);
                }
                aVar.f21240b.setUserName(String.valueOf(2));
                aVar.f21240b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21240b.setIsRound(false);
                aVar.f21240b.invalidate();
            } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21240b.setDrawBorder(false);
                aVar.f21240b.setAutoChangeStyle(true);
                aVar.f21240b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f21240b.setUserName(String.valueOf(3));
                aVar.f21240b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21240b.setVisibility(0);
                aVar.f21241c.setVisibility(8);
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, Integer.class);
                if (runTask != null) {
                    SkinManager.setImageResource(aVar.f21240b, ((Integer) runTask.getData()).intValue());
                }
                aVar.f21240b.setIsRound(false);
                aVar.f21240b.invalidate();
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21240b.setDrawBorder(true);
                aVar.f21240b.setAutoChangeStyle(true);
                aVar.f21240b.setUserId(imMessageCenterShowItemData.getFriendId());
                String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f21240b.setImageDrawable(null);
                aVar.f21240b.setVisibility(0);
                aVar.f21241c.setVisibility(8);
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    aVar.f21240b.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
                } else {
                    aVar.f21240b.startLoad(friendBjhAvatar, 10, false);
                }
                aVar.f21240b.setClickable(false);
                aVar.f21240b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f21240b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21240b.setUserName(String.valueOf(1));
                aVar.f21240b.setIsRound(false);
                aVar.f21240b.invalidate();
            } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21240b.setDrawBorder(false);
                aVar.f21240b.setAutoChangeStyle(true);
                aVar.f21240b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f21240b.setUserName(String.valueOf(5));
                aVar.f21240b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21240b.setVisibility(4);
                aVar.f21241c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f21241c, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
                aVar.f21240b.setIsRound(false);
                aVar.f21240b.invalidate();
            } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21240b.setDrawBorder(true);
                aVar.f21240b.setAutoChangeStyle(true);
                String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f21240b.setVisibility(0);
                aVar.f21241c.setVisibility(8);
                aVar.f21240b.setImageDrawable(null);
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001289, Integer.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        aVar.f21240b.startLoad(((Integer) runTask2.getData()).toString(), 24, false);
                    }
                } else {
                    aVar.f21240b.startLoad(friendBjhAvatar2, 12, false);
                }
                aVar.f21240b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f21240b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21240b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.f21240b.setIsRound(false);
                aVar.f21240b.invalidate();
            } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f21240b.setDrawBorder(false);
                aVar.f21240b.setAutoChangeStyle(true);
                aVar.f21240b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f21240b.setUserName(String.valueOf(7));
                aVar.f21240b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21240b.setVisibility(4);
                aVar.f21241c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f21241c, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
                aVar.f21240b.setIsRound(false);
                aVar.f21240b.invalidate();
            } else {
                aVar.f21240b.setDrawBorder(true);
                aVar.f21240b.setAutoChangeStyle(true);
                String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar3)) {
                    friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f21240b.setImageDrawable(null);
                aVar.f21240b.setVisibility(0);
                aVar.f21241c.setVisibility(8);
                if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                    aVar.f21240b.startLoad(friendBjhAvatar3, 12, false);
                } else {
                    aVar.f21240b.startLoad(String.valueOf(R.drawable.person_photo), 24, false);
                }
                aVar.f21240b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f21240b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f21240b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.f21240b.setIsRound(false);
                aVar.f21240b.invalidate();
            }
        }
    }

    @Override // c.a.r0.k1.f.i.c, android.widget.Adapter
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
                        view = LayoutInflater.from(this.f21236e).inflate(R.layout.im_no_data_item_layout, viewGroup, false);
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
                        view = LayoutInflater.from(this.f21236e).inflate(R.layout.im_rec_forum_item_layout, viewGroup, false);
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
                        view = LayoutInflater.from(this.f21236e).inflate(R.layout.im_rec_forum_title_layout, viewGroup, false);
                        fVar = new f(this, view);
                        view.setTag(fVar);
                    }
                    I(fVar);
                    return view;
                } else if (item.getDataType() == 4) {
                    if (view != null && (view.getTag() instanceof e)) {
                        eVar = (e) view.getTag();
                    } else {
                        view = LayoutInflater.from(this.f21236e).inflate(R.layout.im_rec_forum_no_more_layout, viewGroup, false);
                        eVar = new e(this, view);
                        view.setTag(eVar);
                    }
                    H(eVar);
                    return view;
                }
            }
            if (item != null && String.valueOf(2).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    c.a.r0.l1.b.e eVar2 = this.f53373h;
                    if (eVar2 != null) {
                        eVar2.x0(true);
                    }
                } else {
                    c.a.r0.l1.b.e eVar3 = this.f53373h;
                    if (eVar3 != null) {
                        eVar3.x0(false);
                    }
                }
            }
            return super.getView(i2, view, viewGroup);
        }
        return (View) invokeILL.objValue;
    }

    @Override // c.a.r0.k1.f.i.c
    public void n(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            super.n(list);
            if (TbadkCoreApplication.isLogin()) {
                if (this.f21237f.size() <= 0) {
                    this.f53373h.y0(true, true);
                } else {
                    this.f53373h.y0(true, false);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // c.a.r0.k1.f.i.c
    public BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i2, String str) {
        InterceptResult invokeLIL;
        PersonalSettingItemData personalSettingItemData;
        GroupSettingItemData groupSettingItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048595, this, imMessageCenterShowItemData, i2, str)) == null) {
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName()) || (!String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName()) ? !(!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) : c.a.q0.t.d.d.d().p() : c.a.q0.t.d.d.d().p() && ((personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || personalSettingItemData.isAcceptNotify()) : c.a.q0.t.d.d.d().n() && ((groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || groupSettingItemData.isAcceptNotify())) : !(c.a.q0.t.d.d.d().z() && c.a.r0.k1.t.f.a().b()))) {
                str = "";
                i2 = 0;
            }
            return new BasicNameValuePair(String.valueOf(i2), str);
        }
        return (BasicNameValuePair) invokeLIL.objValue;
    }
}
