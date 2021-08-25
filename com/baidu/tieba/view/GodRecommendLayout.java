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
import c.a.e.e.p.k;
import c.a.e.l.e.j;
import c.a.e.l.e.l;
import c.a.p0.b1.q0;
import c.a.p0.n.f;
import c.a.p0.s.q.u1;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class GodRecommendLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String USER_LIKE_CLICK = "c13903";
    public static final String USER_SHOW = "c13902";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f58020e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58021f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58022g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f58023h;

    /* renamed from: i  reason: collision with root package name */
    public GodRecommendListAdapter f58024i;

    /* renamed from: j  reason: collision with root package name */
    public l f58025j;
    public List<String> k;
    public boolean l;
    public CustomMessageListener m;
    public f n;
    public RecyclerView.OnScrollListener o;

    /* loaded from: classes7.dex */
    public class GodRecommendListAdapter extends RecyclerView.Adapter<GodViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f58026a;

        /* renamed from: b  reason: collision with root package name */
        public TbPageContext f58027b;

        /* renamed from: c  reason: collision with root package name */
        public BdUniqueId f58028c;

        /* renamed from: d  reason: collision with root package name */
        public List<MetaData> f58029d;

        /* renamed from: e  reason: collision with root package name */
        public f<MetaData> f58030e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GodRecommendLayout f58031f;

        /* loaded from: classes7.dex */
        public class GodViewHolder extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f58032a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ GodRecommendListAdapter f58033b;
            public LinearLayout mContainer;
            public DynamicUserLikeButton mLikeButton;
            public TextView mUserDesc;
            public HeadPendantClickableView mUserImage;
            public c.a.p0.s.f0.t.c mUserLikePresenter;
            public TextView mUserName;

            /* loaded from: classes7.dex */
            public class a implements DynamicUserLikeButton.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ GodViewHolder f58034a;

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
                    this.f58034a = godViewHolder;
                }

                @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                public void a(View view) {
                    c.a.p0.s.f0.t.c cVar;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (cVar = this.f58034a.mUserLikePresenter) == null || cVar.j() == null || this.f58034a.mUserLikePresenter.j().getIsLike()) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(GodRecommendLayout.USER_LIKE_CLICK).param(TiebaStatic.Params.FRIEND_UID, this.f58034a.mUserLikePresenter.j().getUserId()).param("obj_name", this.f58034a.mUserDesc.getText().toString()));
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
                this.f58033b = godRecommendListAdapter;
                this.f58032a = false;
                this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
                HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.mUserImage = headPendantClickableView;
                headPendantClickableView.getHeadView().setIsRound(true);
                this.mUserImage.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.mUserImage.getHeadView().setDefaultResource(17170445);
                this.mUserImage.getHeadView().setPlaceHolder(1);
                this.mUserImage.getHeadView().setBorderWidth(c.a.e.e.p.l.g(godRecommendListAdapter.f58026a, R.dimen.tbds1));
                this.mUserImage.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                this.mUserName = (TextView) view.findViewById(R.id.concern_user_name);
                this.mUserDesc = (TextView) view.findViewById(R.id.concern_user_desc);
                DynamicUserLikeButton dynamicUserLikeButton = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.mLikeButton = dynamicUserLikeButton;
                dynamicUserLikeButton.setGodRecommendStyle(true);
                this.mLikeButton.setOnClickEvent(new a(this, godRecommendListAdapter));
                c.a.p0.s.f0.t.c cVar = new c.a.p0.s.f0.t.c(godRecommendListAdapter.f58027b, this.mLikeButton);
                this.mUserLikePresenter = cVar;
                cVar.k(true);
            }

            public void onChangeSkinType() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.f58032a) {
                        SkinManager.setViewTextColor(this.mUserName, R.color.CAM_X0101);
                    } else {
                        SkinManager.setViewTextColor(this.mUserName, R.color.CAM_X0301);
                    }
                    SkinManager.setViewTextColor(this.mUserDesc, R.color.CAM_X0101);
                    this.mLikeButton.changeSkinType();
                    TBSelector.makeDrawableSelector().setShape(0).defaultStrokeColor(R.color.CAM_X0614).defaultColor(R.color.CAM_X0614).strokeWidth(c.a.e.e.p.l.g(this.f58033b.f58026a, R.dimen.tbds1)).radius(c.a.e.e.p.l.g(this.f58033b.f58026a, R.dimen.tbds10)).into(this.mContainer);
                }
            }

            public final void setIsNewGod(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.f58032a = z;
                }
            }
        }

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ MetaData f58035e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GodViewHolder f58036f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ GodRecommendListAdapter f58037g;

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
                this.f58037g = godRecommendListAdapter;
                this.f58035e = metaData;
                this.f58036f = godViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f58037g.f(this.f58035e, this.f58036f);
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
            this.f58031f = godRecommendLayout;
            this.f58026a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(GodViewHolder godViewHolder, int i2) {
            List<MetaData> list;
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, godViewHolder, i2) == null) || godViewHolder == null || (list = this.f58029d) == null || (metaData = list.get(i2)) == null) {
                return;
            }
            godViewHolder.setIsNewGod(metaData.isNewGod());
            i(metaData, godViewHolder);
            l(metaData, godViewHolder);
            j(metaData, godViewHolder);
            k(metaData, godViewHolder);
            f<MetaData> fVar = this.f58030e;
            if (fVar != null) {
                fVar.c(godViewHolder.itemView, metaData, i2, i2);
            }
            godViewHolder.onChangeSkinType();
            godViewHolder.itemView.setTag(R.id.tag_user_id, metaData);
            godViewHolder.itemView.setTag(R.id.tag_holder, Boolean.TRUE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public GodViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new GodViewHolder(this, LayoutInflater.from(this.f58026a).inflate(R.layout.recommend_god_item, (ViewGroup) null)) : (GodViewHolder) invokeLI.objValue;
        }

        public final void f(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, metaData, godViewHolder) == null) || this.f58030e == null) {
                return;
            }
            this.f58030e.a(godViewHolder.itemView, metaData, godViewHolder.getAdapterPosition(), godViewHolder.getItemId());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g */
        public void onViewAttachedToWindow(@NonNull GodViewHolder godViewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, godViewHolder) == null) {
                super.onViewAttachedToWindow(godViewHolder);
                if (this.f58031f.l && (view = godViewHolder.itemView) != null && (view.getTag(R.id.tag_user_id) instanceof MetaData) && (godViewHolder.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) godViewHolder.itemView.getTag(R.id.tag_holder)).booleanValue();
                    MetaData metaData = (MetaData) godViewHolder.itemView.getTag(R.id.tag_user_id);
                    if (!booleanValue || this.f58031f.k.contains(metaData.getUserId())) {
                        return;
                    }
                    this.f58031f.k.add(metaData.getUserId());
                    TiebaStatic.log(new StatisticItem(GodRecommendLayout.USER_SHOW).param("uid", metaData.getUserId()));
                    godViewHolder.itemView.setTag(R.id.tag_holder, Boolean.FALSE);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                List<MetaData> list = this.f58029d;
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
        public void onViewDetachedFromWindow(@NonNull GodViewHolder godViewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, godViewHolder) == null) {
                super.onViewDetachedFromWindow(godViewHolder);
                if (this.f58031f.k.isEmpty() && (view = godViewHolder.itemView) != null) {
                    view.setTag(R.id.tag_holder, Boolean.TRUE);
                }
            }
        }

        public final void i(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, metaData, godViewHolder) == null) {
                godViewHolder.mUserImage.setData(metaData, true);
                godViewHolder.mUserImage.setOnClickListener(new a(this, metaData, godViewHolder));
            }
        }

        public final void j(MetaData metaData, GodViewHolder godViewHolder) {
            String d2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048583, this, metaData, godViewHolder) == null) || metaData == null || godViewHolder == null) {
                return;
            }
            String str = null;
            if (metaData.isBaijiahaoUser()) {
                str = metaData.getBaijiahaoInfo().auth_desc;
            } else if (metaData.isNewGod()) {
                str = metaData.getNewGodData().getFieldName();
            }
            if (!k.isEmpty(str)) {
                d2 = str + q0.d(metaData.isVideoGod());
            } else {
                d2 = q0.d(metaData.isVideoGod());
            }
            godViewHolder.mUserDesc.setText(d2);
        }

        public final void k(MetaData metaData, GodViewHolder godViewHolder) {
            c.a.p0.s.f0.t.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, metaData, godViewHolder) == null) || (cVar = godViewHolder.mUserLikePresenter) == null) {
                return;
            }
            cVar.l(this.f58028c);
            cVar.n(metaData);
        }

        public final void l(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048585, this, metaData, godViewHolder) == null) || metaData == null || godViewHolder == null) {
                return;
            }
            String string = this.f58031f.getResources().getString(R.string.god_default_name);
            if (!StringUtils.isNull(metaData.getName_show())) {
                string = metaData.getName_show();
            }
            godViewHolder.mUserName.setText(string);
            if (metaData.isNewGod()) {
                SkinManager.setViewTextColor(godViewHolder.mUserName, R.color.CAM_X0301);
            }
        }

        public void setData(List<MetaData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
                this.f58029d = list;
            }
        }

        public void setOnItemCoverListener(f<MetaData> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) {
                this.f58030e = fVar;
            }
        }

        public void setPageContext(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, tbPageContext) == null) {
                this.f58027b = tbPageContext;
            }
        }

        public void setPageUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
                this.f58028c = bdUniqueId;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GodRecommendLayout f58038a;

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
            this.f58038a = godRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f58038a.f58025j == null) {
                        this.f58038a.f58025j = new l(new j());
                    }
                    this.f58038a.f58025j.q(this.f58038a.f58023h, 1);
                } else if (this.f58038a.f58025j != null) {
                    this.f58038a.f58025j.w();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f<MetaData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GodRecommendLayout f58039e;

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
            this.f58039e = godRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f
        /* renamed from: b */
        public void c(View view, MetaData metaData, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, metaData, Integer.valueOf(i2), Long.valueOf(j2)}) != null) || metaData == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f
        /* renamed from: d */
        public void a(View view, MetaData metaData, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, metaData, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || metaData == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f58039e.f58020e, metaData.getUserId(), metaData.getName_show())));
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GodRecommendLayout f58040a;

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
            this.f58040a = godRecommendLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                this.f58040a.k.clear();
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
                Context context = this.f58020e;
                if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                    ((BaseFragmentActivity) this.f58020e).disableSwipeJustOnce();
                } else {
                    Context context2 = this.f58020e;
                    if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                        ((BaseActivity) this.f58020e).disableSwipeJustOnce();
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
            this.f58021f = (TextView) findViewById(R.id.title);
            this.f58022g = (TextView) findViewById(R.id.change);
            this.f58023h = (RecyclerView) findViewById(R.id.thread_card_list);
            GodRecommendListAdapter godRecommendListAdapter = new GodRecommendListAdapter(this, this.f58020e);
            this.f58024i = godRecommendListAdapter;
            godRecommendListAdapter.setOnItemCoverListener(this.n);
            this.f58023h.setAdapter(this.f58024i);
            this.f58023h.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                l lVar = new l(new j());
                this.f58025j = lVar;
                lVar.q(this.f58023h, 1);
            }
            int g2 = c.a.e.e.p.l.g(this.f58020e, R.dimen.tbds21);
            int g3 = c.a.e.e.p.l.g(this.f58020e, R.dimen.tbds44);
            this.f58023h.setLayoutManager(new LinearLayoutManager(this.f58020e, 0, false));
            this.f58023h.setItemAnimator(new DefaultItemAnimator());
            this.f58023h.addItemDecoration(new SpaceItemDecoration(g3, g2, g3));
            this.f58023h.addOnScrollListener(this.o);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f58021f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f58022g, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0604);
            this.f58024i.notifyDataSetChanged();
        }
    }

    public void setCouldStatistic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l = z;
        }
    }

    public void setData(u1 u1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, u1Var) == null) || u1Var == null) {
            return;
        }
        this.f58024i.setData(u1Var.g());
        this.f58024i.notifyDataSetChanged();
        this.f58023h.scrollToPosition(0);
        this.k.clear();
        this.l = true;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.f58024i.setPageContext(tbPageContext);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.m.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.m);
            this.f58024i.setPageUniqueId(bdUniqueId);
        }
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f58022g.setOnClickListener(onClickListener);
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
        this.f58020e = context;
        g();
    }
}
