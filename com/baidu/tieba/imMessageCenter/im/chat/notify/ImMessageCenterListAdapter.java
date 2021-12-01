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
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.r0.r1.f.i.c;
import c.a.r0.t3.h0;
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
/* loaded from: classes10.dex */
public class ImMessageCenterListAdapter extends c.a.r0.r1.f.i.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.s1.b.e f46202h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f46203i;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f46204e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f46205f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f46206g;

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
            this.f46206g = imMessageCenterListAdapter;
            this.f46204e = imMessageCenterShowItemData;
            this.f46205f = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f46204e.getIsLike() != 1) {
                    this.f46206g.B(this.f46205f, this.f46204e);
                    this.f46206g.A(this.f46204e, 1);
                    return;
                }
                this.f46206g.C(this.f46205f, this.f46204e);
                this.f46206g.A(this.f46204e, 2);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LikeModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f46207b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f46208c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f46209d;

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
            this.f46209d = imMessageCenterListAdapter;
            this.a = likeModel;
            this.f46207b = imMessageCenterShowItemData;
            this.f46208c = gVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.getErrorCode() == 22) {
                    l.M(this.f46209d.f22840e, this.f46209d.f22840e.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.a.getErrorCode() != 0) {
                        l.M(this.f46209d.f22840e, this.a.getErrorString());
                        return;
                    }
                    this.f46207b.setIsLike(1);
                    this.f46209d.N(this.f46208c, true);
                    l.M(this.f46209d.f22840e, this.f46209d.f22840e.getString(R.string.attention_success));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements h0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterShowItemData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f46210b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterListAdapter f46211c;

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
            this.f46211c = imMessageCenterListAdapter;
            this.a = imMessageCenterShowItemData;
            this.f46210b = gVar;
        }

        @Override // c.a.r0.t3.h0.a
        public void a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            }
        }

        @Override // c.a.r0.t3.h0.a
        public void b(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                this.a.setIsLike(0);
                this.f46211c.N(this.f46210b, false);
                l.M(this.f46211c.f22840e, this.f46211c.f22840e.getString(R.string.un_attention_success));
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f46212b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f46213c;

        /* renamed from: d  reason: collision with root package name */
        public View f46214d;

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

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f46215b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f46216c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f46217d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f46218e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f46219f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f46220g;

        /* renamed from: h  reason: collision with root package name */
        public View f46221h;

        /* renamed from: i  reason: collision with root package name */
        public TBSpecificationBtn f46222i;

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
        this.f46202h = null;
        this.f46203i = null;
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
            LikeModel likeModel = new LikeModel(this.f46203i);
            if (!l.C()) {
                Context context = this.f22840e;
                UtilHelper.showToast(context, context.getString(R.string.neterror));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.f22840e)) {
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
            if (!l.C()) {
                Context context = this.f22840e;
                UtilHelper.showToast(context, context.getString(R.string.neterror));
            } else if (imMessageCenterShowItemData == null || StringUtils.isNull(imMessageCenterShowItemData.getForumName()) || imMessageCenterShowItemData.getForumId() <= 0 || !ViewHelper.checkUpIsLogin(this.f22840e)) {
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
            dVar.a = (TbImageView) view.findViewById(R.id.im_no_data_image);
            dVar.f46212b = (TextView) view.findViewById(R.id.im_no_data_text);
            dVar.f46213c = (TextView) view.findViewById(R.id.im_no_data_text2);
            dVar.f46214d = view.findViewById(R.id.im_no_data_dev);
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
            gVar.f46215b = (BarImageView) view.findViewById(R.id.im_rec_forum_bar_icon);
            gVar.f46216c = (TextView) view.findViewById(R.id.im_rec_forum_ranking);
            gVar.f46217d = (TextView) view.findViewById(R.id.im_rec_forum_title);
            gVar.f46218e = (TextView) view.findViewById(R.id.im_rec_forum_introduce);
            gVar.f46219f = (TextView) view.findViewById(R.id.im_rec_forum_attention_content);
            gVar.f46220g = (TextView) view.findViewById(R.id.im_rec_forum_pb_content);
            gVar.f46221h = view.findViewById(R.id.im_rec_item_line);
            gVar.f46222i = (TBSpecificationBtn) view.findViewById(R.id.im_rec_forum_attention_btn);
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public final void F(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            SkinManager.setImageResource(dVar.a, R.drawable.im_no_data_icon);
            dVar.a.setUseNightOrDarkMask(false);
            dVar.f46212b.setText(this.f22840e.getString(R.string.im_no_data_text));
            dVar.f46213c.setText(this.f22840e.getString(R.string.im_no_data_text2));
        }
    }

    public final void G(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(dVar.f46212b);
            d2.v(R.color.CAM_X0107);
            d2.z(R.dimen.T_X07);
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(dVar.f46213c);
            d3.v(R.color.CAM_X0110);
            d3.z(R.dimen.T_X08);
            c.a.q0.s.u.c.d(dVar.f46214d).f(R.color.CAM_X0204);
        }
    }

    public final void H(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(eVar.a);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X08);
        }
    }

    public final void I(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(fVar.a);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
        }
    }

    public final void J(g gVar, int i2, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, gVar, i2, imMessageCenterShowItemData) == null) {
            gVar.f46215b.setShowOval(true);
            gVar.f46215b.setAutoChangeStyle(true);
            gVar.f46215b.setStrokeWith(l.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            gVar.f46215b.setStrokeColorResId(R.color.CAM_X0401);
            gVar.f46215b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            gVar.f46215b.setPlaceHolder(1);
            gVar.f46215b.startLoad(imMessageCenterShowItemData.getAvatar(), 10, false);
            gVar.f46217d.setText(imMessageCenterShowItemData.getForumName() + this.f22840e.getString(R.string.forum));
            if (!StringUtils.isNull(imMessageCenterShowItemData.getSlogan())) {
                gVar.f46218e.setText(this.f22840e.getString(R.string.im_rec_forum_introduce, imMessageCenterShowItemData.getSlogan()));
            } else {
                gVar.f46218e.setText(this.f22840e.getString(R.string.im_rec_forum_no_introduce_content));
            }
            gVar.f46219f.setText(String.format(this.f22840e.getString(R.string.concern), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getMemberCount())));
            gVar.f46220g.setText(String.format(this.f22840e.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(imMessageCenterShowItemData.getThreadCount())));
            gVar.f46216c.setText(String.valueOf(i2 - 1));
            N(gVar, imMessageCenterShowItemData.getIsLike() == 1);
            gVar.f46222i.setOnClickListener(new a(this, imMessageCenterShowItemData, gVar));
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
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(gVar.f46216c);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0101);
            d2.n(R.string.J_X04);
            d2.f(i3);
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(gVar.f46217d);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X06);
            c.a.q0.s.u.c d4 = c.a.q0.s.u.c.d(gVar.f46218e);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X09);
            c.a.q0.s.u.c d5 = c.a.q0.s.u.c.d(gVar.f46219f);
            d5.v(R.color.CAM_X0109);
            d5.z(R.dimen.T_X09);
            c.a.q0.s.u.c d6 = c.a.q0.s.u.c.d(gVar.f46220g);
            d6.v(R.color.CAM_X0109);
            d6.z(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(gVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void L(c.a.r0.s1.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f46202h = eVar;
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
                c.a.q0.s.g0.n.b bVar = new c.a.q0.s.g0.n.b();
                bVar.s(R.color.CAM_X0109);
                gVar.f46222i.setConfig(bVar);
                gVar.f46222i.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
                gVar.f46222i.setClickState(false);
            } else {
                c.a.q0.s.g0.n.b bVar2 = new c.a.q0.s.g0.n.b();
                bVar2.r(R.color.CAM_X0302);
                gVar.f46222i.setConfig(bVar2);
                gVar.f46222i.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
                gVar.f46222i.setClickState(true);
            }
            gVar.f46222i.changeSkinType();
        }
    }

    @Override // c.a.r0.r1.f.i.c
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

    @Override // c.a.r0.r1.f.i.c
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

    @Override // c.a.r0.r1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.f22843b.setDrawerType(1);
            aVar.f22843b.setRadius(l.d(this.f22840e, 4.0f));
            aVar.f22844c.setClickable(false);
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f22843b.setDrawBorder(false);
                aVar.f22843b.setAutoChangeStyle(true);
                aVar.f22843b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f22843b.setVisibility(0);
                aVar.f22844c.setVisibility(8);
                if (MessageManager.getInstance().runTask(2001287, Integer.class) != null) {
                    SkinManager.setImageResource(aVar.f22843b, R.drawable.icon_new_test);
                }
                aVar.f22843b.setUserName(String.valueOf(2));
                aVar.f22843b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f22843b.setIsRound(false);
                aVar.f22843b.invalidate();
            } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f22843b.setDrawBorder(false);
                aVar.f22843b.setAutoChangeStyle(true);
                aVar.f22843b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f22843b.setUserName(String.valueOf(3));
                aVar.f22843b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f22843b.setVisibility(0);
                aVar.f22844c.setVisibility(8);
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, Integer.class);
                if (runTask != null) {
                    SkinManager.setImageResource(aVar.f22843b, ((Integer) runTask.getData()).intValue());
                }
                aVar.f22843b.setIsRound(false);
                aVar.f22843b.invalidate();
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f22843b.setDrawBorder(true);
                aVar.f22843b.setAutoChangeStyle(true);
                aVar.f22843b.setUserId(imMessageCenterShowItemData.getFriendId());
                String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f22843b.setImageDrawable(null);
                aVar.f22843b.setVisibility(0);
                aVar.f22844c.setVisibility(8);
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    aVar.f22843b.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
                } else {
                    aVar.f22843b.startLoad(friendBjhAvatar, 10, false);
                }
                aVar.f22843b.setClickable(false);
                aVar.f22843b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f22843b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f22843b.setUserName(String.valueOf(1));
                aVar.f22843b.setIsRound(false);
                aVar.f22843b.invalidate();
            } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f22843b.setDrawBorder(false);
                aVar.f22843b.setAutoChangeStyle(true);
                aVar.f22843b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f22843b.setUserName(String.valueOf(5));
                aVar.f22843b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f22843b.setVisibility(4);
                aVar.f22844c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f22844c, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
                aVar.f22843b.setIsRound(false);
                aVar.f22843b.invalidate();
            } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f22843b.setDrawBorder(true);
                aVar.f22843b.setAutoChangeStyle(true);
                String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f22843b.setVisibility(0);
                aVar.f22844c.setVisibility(8);
                aVar.f22843b.setImageDrawable(null);
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001289, Integer.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        aVar.f22843b.startLoad(((Integer) runTask2.getData()).toString(), 24, false);
                    }
                } else {
                    aVar.f22843b.startLoad(friendBjhAvatar2, 12, false);
                }
                aVar.f22843b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f22843b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f22843b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.f22843b.setIsRound(false);
                aVar.f22843b.invalidate();
            } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f22843b.setDrawBorder(false);
                aVar.f22843b.setAutoChangeStyle(true);
                aVar.f22843b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f22843b.setUserName(String.valueOf(7));
                aVar.f22843b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f22843b.setVisibility(4);
                aVar.f22844c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f22844c, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
                aVar.f22843b.setIsRound(false);
                aVar.f22843b.invalidate();
            } else {
                aVar.f22843b.setDrawBorder(true);
                aVar.f22843b.setAutoChangeStyle(true);
                String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar3)) {
                    friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f22843b.setImageDrawable(null);
                aVar.f22843b.setVisibility(0);
                aVar.f22844c.setVisibility(8);
                if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                    aVar.f22843b.startLoad(friendBjhAvatar3, 12, false);
                } else {
                    aVar.f22843b.startLoad(String.valueOf(R.drawable.person_photo), 24, false);
                }
                aVar.f22843b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f22843b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f22843b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.f22843b.setIsRound(false);
                aVar.f22843b.invalidate();
            }
        }
    }

    @Override // c.a.r0.r1.f.i.c, android.widget.Adapter
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
                        view = LayoutInflater.from(this.f22840e).inflate(R.layout.im_no_data_item_layout, viewGroup, false);
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
                        view = LayoutInflater.from(this.f22840e).inflate(R.layout.im_rec_forum_item_layout, viewGroup, false);
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
                        view = LayoutInflater.from(this.f22840e).inflate(R.layout.im_rec_forum_title_layout, viewGroup, false);
                        fVar = new f(this, view);
                        view.setTag(fVar);
                    }
                    I(fVar);
                    return view;
                } else if (item.getDataType() == 4) {
                    if (view != null && (view.getTag() instanceof e)) {
                        eVar = (e) view.getTag();
                    } else {
                        view = LayoutInflater.from(this.f22840e).inflate(R.layout.im_rec_forum_no_more_layout, viewGroup, false);
                        eVar = new e(this, view);
                        view.setTag(eVar);
                    }
                    H(eVar);
                    return view;
                }
            }
            if (item != null && String.valueOf(2).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    c.a.r0.s1.b.e eVar2 = this.f46202h;
                    if (eVar2 != null) {
                        eVar2.x0(true);
                    }
                } else {
                    c.a.r0.s1.b.e eVar3 = this.f46202h;
                    if (eVar3 != null) {
                        eVar3.x0(false);
                    }
                }
            }
            return super.getView(i2, view, viewGroup);
        }
        return (View) invokeILL.objValue;
    }

    @Override // c.a.r0.r1.f.i.c
    public void n(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            super.n(list);
            if (TbadkCoreApplication.isLogin()) {
                if (this.f22841f.size() <= 0) {
                    this.f46202h.y0(true, true);
                } else {
                    this.f46202h.y0(true, false);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // c.a.r0.r1.f.i.c
    public BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i2, String str) {
        InterceptResult invokeLIL;
        PersonalSettingItemData personalSettingItemData;
        GroupSettingItemData groupSettingItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048595, this, imMessageCenterShowItemData, i2, str)) == null) {
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName()) || (!String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName()) ? !(!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) : c.a.q0.t.d.d.d().p() : c.a.q0.t.d.d.d().p() && ((personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || personalSettingItemData.isAcceptNotify()) : c.a.q0.t.d.d.d().n() && ((groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || groupSettingItemData.isAcceptNotify())) : !(c.a.q0.t.d.d.d().z() && c.a.r0.r1.t.f.a().b()))) {
                str = "";
                i2 = 0;
            }
            return new BasicNameValuePair(String.valueOf(i2), str);
        }
        return (BasicNameValuePair) invokeLIL.objValue;
    }
}
