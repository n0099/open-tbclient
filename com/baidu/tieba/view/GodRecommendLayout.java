package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.SpaceItemDecoration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.k.e.j;
import d.a.c.k.e.l;
import d.a.o0.m.f;
import d.a.o0.r.q.t1;
import d.a.o0.z0.n0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class GodRecommendLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f22071e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22072f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22073g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f22074h;

    /* renamed from: i  reason: collision with root package name */
    public GodRecommendListAdapter f22075i;
    public l j;
    public List<String> k;
    public boolean l;
    public CustomMessageListener m;
    public f n;
    public RecyclerView.OnScrollListener o;

    /* loaded from: classes4.dex */
    public class GodRecommendListAdapter extends RecyclerView.Adapter<GodViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f22076a;

        /* renamed from: b  reason: collision with root package name */
        public TbPageContext f22077b;

        /* renamed from: c  reason: collision with root package name */
        public BdUniqueId f22078c;

        /* renamed from: d  reason: collision with root package name */
        public List<MetaData> f22079d;

        /* renamed from: e  reason: collision with root package name */
        public f<MetaData> f22080e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GodRecommendLayout f22081f;

        /* loaded from: classes4.dex */
        public class GodViewHolder extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public LinearLayout f22082a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f22083b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f22084c;

            /* renamed from: d  reason: collision with root package name */
            public HeadPendantClickableView f22085d;

            /* renamed from: e  reason: collision with root package name */
            public DynamicUserLikeButton f22086e;

            /* renamed from: f  reason: collision with root package name */
            public d.a.o0.r.f0.t.c f22087f;

            /* renamed from: g  reason: collision with root package name */
            public boolean f22088g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ GodRecommendListAdapter f22089h;

            /* loaded from: classes4.dex */
            public class a implements DynamicUserLikeButton.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ GodViewHolder f22090a;

                public a(GodViewHolder godViewHolder, GodRecommendListAdapter godRecommendListAdapter) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {godViewHolder, godRecommendListAdapter};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f22090a = godViewHolder;
                }

                @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                public void a(View view) {
                    d.a.o0.r.f0.t.c cVar;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (cVar = this.f22090a.f22087f) == null || cVar.j() == null || this.f22090a.f22087f.j().getIsLike()) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c13903").param(TiebaStatic.Params.FRIEND_UID, this.f22090a.f22087f.j().getUserId()).param("obj_name", this.f22090a.f22084c.getText().toString()));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GodViewHolder(GodRecommendListAdapter godRecommendListAdapter, View view) {
                super(view);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {godRecommendListAdapter, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22089h = godRecommendListAdapter;
                this.f22088g = false;
                this.f22082a = (LinearLayout) view.findViewById(R.id.concern_container);
                HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.f22085d = headPendantClickableView;
                headPendantClickableView.getHeadView().setIsRound(true);
                this.f22085d.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f22085d.getHeadView().setDefaultResource(17170445);
                this.f22085d.getHeadView().setPlaceHolder(1);
                this.f22085d.getHeadView().setBorderWidth(d.a.c.e.p.l.g(godRecommendListAdapter.f22076a, R.dimen.tbds1));
                this.f22085d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                this.f22083b = (TextView) view.findViewById(R.id.concern_user_name);
                this.f22084c = (TextView) view.findViewById(R.id.concern_user_desc);
                DynamicUserLikeButton dynamicUserLikeButton = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.f22086e = dynamicUserLikeButton;
                dynamicUserLikeButton.setGodRecommendStyle(true);
                this.f22086e.setOnClickEvent(new a(this, godRecommendListAdapter));
                d.a.o0.r.f0.t.c cVar = new d.a.o0.r.f0.t.c(godRecommendListAdapter.f22077b, this.f22086e);
                this.f22087f = cVar;
                cVar.k(true);
            }

            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.f22088g) {
                        SkinManager.setViewTextColor(this.f22083b, R.color.CAM_X0101);
                    } else {
                        SkinManager.setViewTextColor(this.f22083b, R.color.CAM_X0301);
                    }
                    SkinManager.setViewTextColor(this.f22084c, R.color.CAM_X0101);
                    this.f22086e.k();
                    TBSelector.makeDrawableSelector().setShape(0).defaultStrokeColor(R.color.CAM_X0614).defaultColor(R.color.CAM_X0614).strokeWidth(d.a.c.e.p.l.g(this.f22089h.f22076a, R.dimen.tbds1)).radius(d.a.c.e.p.l.g(this.f22089h.f22076a, R.dimen.tbds10)).into(this.f22082a);
                }
            }

            public final void c(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.f22088g = z;
                }
            }
        }

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ MetaData f22091e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GodViewHolder f22092f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ GodRecommendListAdapter f22093g;

            public a(GodRecommendListAdapter godRecommendListAdapter, MetaData metaData, GodViewHolder godViewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {godRecommendListAdapter, metaData, godViewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22093g = godRecommendListAdapter;
                this.f22091e = metaData;
                this.f22092f = godViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f22093g.i(this.f22091e, this.f22092f);
                }
            }
        }

        public GodRecommendListAdapter(GodRecommendLayout godRecommendLayout, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {godRecommendLayout, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22081f = godRecommendLayout;
            this.f22076a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g */
        public void onBindViewHolder(GodViewHolder godViewHolder, int i2) {
            List<MetaData> list;
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, godViewHolder, i2) == null) || godViewHolder == null || (list = this.f22079d) == null || (metaData = list.get(i2)) == null) {
                return;
            }
            godViewHolder.c(metaData.isNewGod());
            o(metaData, godViewHolder);
            r(metaData, godViewHolder);
            p(metaData, godViewHolder);
            q(metaData, godViewHolder);
            f<MetaData> fVar = this.f22080e;
            if (fVar != null) {
                fVar.c(godViewHolder.itemView, metaData, i2, i2);
            }
            godViewHolder.b();
            godViewHolder.itemView.setTag(R.id.tag_user_id, metaData);
            godViewHolder.itemView.setTag(R.id.tag_holder, Boolean.TRUE);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<MetaData> list = this.f22079d;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: h */
        public GodViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) ? new GodViewHolder(this, LayoutInflater.from(this.f22076a).inflate(R.layout.recommend_god_item, (ViewGroup) null)) : (GodViewHolder) invokeLI.objValue;
        }

        public final void i(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, metaData, godViewHolder) == null) || this.f22080e == null) {
                return;
            }
            this.f22080e.a(godViewHolder.itemView, metaData, godViewHolder.getAdapterPosition(), godViewHolder.getItemId());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j */
        public void onViewAttachedToWindow(@NonNull GodViewHolder godViewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, godViewHolder) == null) {
                super.onViewAttachedToWindow(godViewHolder);
                if (this.f22081f.l && (view = godViewHolder.itemView) != null && (view.getTag(R.id.tag_user_id) instanceof MetaData) && (godViewHolder.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) godViewHolder.itemView.getTag(R.id.tag_holder)).booleanValue();
                    MetaData metaData = (MetaData) godViewHolder.itemView.getTag(R.id.tag_user_id);
                    if (!booleanValue || this.f22081f.k.contains(metaData.getUserId())) {
                        return;
                    }
                    this.f22081f.k.add(metaData.getUserId());
                    TiebaStatic.log(new StatisticItem("c13902").param("uid", metaData.getUserId()));
                    godViewHolder.itemView.setTag(R.id.tag_holder, Boolean.FALSE);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k */
        public void onViewDetachedFromWindow(@NonNull GodViewHolder godViewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, godViewHolder) == null) {
                super.onViewDetachedFromWindow(godViewHolder);
                if (this.f22081f.k.isEmpty() && (view = godViewHolder.itemView) != null) {
                    view.setTag(R.id.tag_holder, Boolean.TRUE);
                }
            }
        }

        public void l(f<MetaData> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
                this.f22080e = fVar;
            }
        }

        public void m(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) {
                this.f22077b = tbPageContext;
            }
        }

        public void n(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
                this.f22078c = bdUniqueId;
            }
        }

        public final void o(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, metaData, godViewHolder) == null) {
                godViewHolder.f22085d.setData(metaData, true);
                godViewHolder.f22085d.setOnClickListener(new a(this, metaData, godViewHolder));
            }
        }

        public final void p(MetaData metaData, GodViewHolder godViewHolder) {
            String d2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048590, this, metaData, godViewHolder) == null) || metaData == null || godViewHolder == null) {
                return;
            }
            String str = null;
            if (metaData.isBaijiahaoUser()) {
                str = metaData.getBaijiahaoInfo().auth_desc;
            } else if (metaData.isNewGod()) {
                str = metaData.getNewGodData().getFieldName();
            }
            if (!k.isEmpty(str)) {
                d2 = str + n0.d(metaData.isVideoGod());
            } else {
                d2 = n0.d(metaData.isVideoGod());
            }
            godViewHolder.f22084c.setText(d2);
        }

        public final void q(MetaData metaData, GodViewHolder godViewHolder) {
            d.a.o0.r.f0.t.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048591, this, metaData, godViewHolder) == null) || (cVar = godViewHolder.f22087f) == null) {
                return;
            }
            cVar.l(this.f22078c);
            cVar.n(metaData);
        }

        public final void r(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048592, this, metaData, godViewHolder) == null) || metaData == null || godViewHolder == null) {
                return;
            }
            String string = this.f22081f.getResources().getString(R.string.god_default_name);
            if (!StringUtils.isNull(metaData.getName_show())) {
                string = metaData.getName_show();
            }
            godViewHolder.f22083b.setText(string);
            if (metaData.isNewGod()) {
                SkinManager.setViewTextColor(godViewHolder.f22083b, R.color.CAM_X0301);
            }
        }

        public void setData(List<MetaData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
                this.f22079d = list;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GodRecommendLayout f22094a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GodRecommendLayout godRecommendLayout, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {godRecommendLayout, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22094a = godRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f22094a.j == null) {
                        this.f22094a.j = new l(new j());
                    }
                    this.f22094a.j.q(this.f22094a.f22074h, 1);
                } else if (this.f22094a.j != null) {
                    this.f22094a.j.w();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f<MetaData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GodRecommendLayout f22095e;

        public b(GodRecommendLayout godRecommendLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {godRecommendLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22095e = godRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.m.f
        /* renamed from: b */
        public void c(View view, MetaData metaData, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, metaData, Integer.valueOf(i2), Long.valueOf(j)}) != null) || metaData == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.m.f
        /* renamed from: d */
        public void a(View view, MetaData metaData, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, metaData, Integer.valueOf(i2), Long.valueOf(j)}) == null) || metaData == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f22095e.f22071e, metaData.getUserId(), metaData.getName_show())));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GodRecommendLayout f22096a;

        public c(GodRecommendLayout godRecommendLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {godRecommendLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22096a = godRecommendLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                this.f22096a.k.clear();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GodRecommendLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                Context context = this.f22071e;
                if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                    ((BaseFragmentActivity) this.f22071e).disableSwipeJustOnce();
                } else {
                    Context context2 = this.f22071e;
                    if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                        ((BaseActivity) this.f22071e).disableSwipeJustOnce();
                    }
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.recommend_god_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f22072f = (TextView) findViewById(R.id.title);
            this.f22073g = (TextView) findViewById(R.id.change);
            this.f22074h = (RecyclerView) findViewById(R.id.thread_card_list);
            GodRecommendListAdapter godRecommendListAdapter = new GodRecommendListAdapter(this, this.f22071e);
            this.f22075i = godRecommendListAdapter;
            godRecommendListAdapter.l(this.n);
            this.f22074h.setAdapter(this.f22075i);
            this.f22074h.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                l lVar = new l(new j());
                this.j = lVar;
                lVar.q(this.f22074h, 1);
            }
            int g2 = d.a.c.e.p.l.g(this.f22071e, R.dimen.tbds21);
            int g3 = d.a.c.e.p.l.g(this.f22071e, R.dimen.tbds44);
            this.f22074h.setLayoutManager(new LinearLayoutManager(this.f22071e, 0, false));
            this.f22074h.setItemAnimator(new DefaultItemAnimator());
            this.f22074h.addItemDecoration(new SpaceItemDecoration(g3, g2, g3));
            this.f22074h.addOnScrollListener(this.o);
            h();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f22072f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f22073g, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0604);
            this.f22075i.notifyDataSetChanged();
        }
    }

    public void setCouldStatistic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l = z;
        }
    }

    public void setData(t1 t1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, t1Var) == null) || t1Var == null) {
            return;
        }
        this.f22075i.setData(t1Var.c());
        this.f22075i.notifyDataSetChanged();
        this.f22074h.scrollToPosition(0);
        this.k.clear();
        this.l = true;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.f22075i.m(tbPageContext);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.m.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.m);
            this.f22075i.n(bdUniqueId);
        }
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f22073g.setOnClickListener(onClickListener);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        this.l = true;
        this.m = new a(this, 2156674);
        this.n = new b(this);
        this.o = new c(this);
        this.f22071e = context;
        g();
    }
}
