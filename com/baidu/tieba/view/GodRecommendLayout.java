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
import c.a.d.f.p.k;
import c.a.d.m.e.j;
import c.a.d.m.e.l;
import c.a.q0.d1.q0;
import c.a.q0.n.f;
import c.a.q0.s.q.v1;
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
/* loaded from: classes11.dex */
public class GodRecommendLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String USER_LIKE_CLICK = "c13903";
    public static final String USER_SHOW = "c13902";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f50254e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f50255f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50256g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f50257h;

    /* renamed from: i  reason: collision with root package name */
    public GodRecommendListAdapter f50258i;

    /* renamed from: j  reason: collision with root package name */
    public l f50259j;

    /* renamed from: k  reason: collision with root package name */
    public List<String> f50260k;
    public boolean l;
    public CustomMessageListener m;
    public f n;
    public RecyclerView.OnScrollListener o;

    /* loaded from: classes11.dex */
    public class GodRecommendListAdapter extends RecyclerView.Adapter<GodViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public TbPageContext f50261b;

        /* renamed from: c  reason: collision with root package name */
        public BdUniqueId f50262c;

        /* renamed from: d  reason: collision with root package name */
        public List<MetaData> f50263d;

        /* renamed from: e  reason: collision with root package name */
        public f<MetaData> f50264e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GodRecommendLayout f50265f;

        /* loaded from: classes11.dex */
        public class GodViewHolder extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ GodRecommendListAdapter f50266b;
            public LinearLayout mContainer;
            public DynamicUserLikeButton mLikeButton;
            public TextView mUserDesc;
            public HeadPendantClickableView mUserImage;
            public c.a.q0.s.g0.t.c mUserLikePresenter;
            public TextView mUserName;

            /* loaded from: classes11.dex */
            public class a implements DynamicUserLikeButton.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GodViewHolder a;

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
                    this.a = godViewHolder;
                }

                @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                public void a(View view) {
                    c.a.q0.s.g0.t.c cVar;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (cVar = this.a.mUserLikePresenter) == null || cVar.j() == null || this.a.mUserLikePresenter.j().getIsLike()) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(GodRecommendLayout.USER_LIKE_CLICK).param(TiebaStatic.Params.FRIEND_UID, this.a.mUserLikePresenter.j().getUserId()).param("obj_name", this.a.mUserDesc.getText().toString()));
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
                this.f50266b = godRecommendListAdapter;
                this.a = false;
                this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
                HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.mUserImage = headPendantClickableView;
                headPendantClickableView.getHeadView().setIsRound(true);
                this.mUserImage.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.mUserImage.getHeadView().setDefaultResource(17170445);
                this.mUserImage.getHeadView().setPlaceHolder(1);
                this.mUserImage.getHeadView().setBorderWidth(c.a.d.f.p.l.f(godRecommendListAdapter.a, R.dimen.tbds1));
                this.mUserImage.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                this.mUserName = (TextView) view.findViewById(R.id.concern_user_name);
                this.mUserDesc = (TextView) view.findViewById(R.id.concern_user_desc);
                DynamicUserLikeButton dynamicUserLikeButton = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.mLikeButton = dynamicUserLikeButton;
                dynamicUserLikeButton.setGodRecommendStyle(true);
                this.mLikeButton.setOnClickEvent(new a(this, godRecommendListAdapter));
                c.a.q0.s.g0.t.c cVar = new c.a.q0.s.g0.t.c(godRecommendListAdapter.f50261b, this.mLikeButton);
                this.mUserLikePresenter = cVar;
                cVar.k(true);
            }

            public void onChangeSkinType() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.a) {
                        SkinManager.setViewTextColor(this.mUserName, R.color.CAM_X0101);
                    } else {
                        SkinManager.setViewTextColor(this.mUserName, R.color.CAM_X0301);
                    }
                    SkinManager.setViewTextColor(this.mUserDesc, R.color.CAM_X0101);
                    this.mLikeButton.changeSkinType();
                    TBSelector.makeDrawableSelector().setShape(0).defaultStrokeColor(R.color.CAM_X0614).defaultColor(R.color.CAM_X0614).strokeWidth(c.a.d.f.p.l.f(this.f50266b.a, R.dimen.tbds1)).radius(c.a.d.f.p.l.f(this.f50266b.a, R.dimen.tbds10)).into(this.mContainer);
                }
            }

            public final void setIsNewGod(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.a = z;
                }
            }
        }

        /* loaded from: classes11.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ MetaData f50267e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GodViewHolder f50268f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ GodRecommendListAdapter f50269g;

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
                this.f50269g = godRecommendListAdapter;
                this.f50267e = metaData;
                this.f50268f = godViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f50269g.f(this.f50267e, this.f50268f);
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
            this.f50265f = godRecommendLayout;
            this.a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(GodViewHolder godViewHolder, int i2) {
            List<MetaData> list;
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, godViewHolder, i2) == null) || godViewHolder == null || (list = this.f50263d) == null || (metaData = list.get(i2)) == null) {
                return;
            }
            godViewHolder.setIsNewGod(metaData.isNewGod());
            i(metaData, godViewHolder);
            l(metaData, godViewHolder);
            j(metaData, godViewHolder);
            k(metaData, godViewHolder);
            f<MetaData> fVar = this.f50264e;
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
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new GodViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.recommend_god_item, (ViewGroup) null)) : (GodViewHolder) invokeLI.objValue;
        }

        public final void f(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, metaData, godViewHolder) == null) || this.f50264e == null) {
                return;
            }
            this.f50264e.a(godViewHolder.itemView, metaData, godViewHolder.getAdapterPosition(), godViewHolder.getItemId());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g */
        public void onViewAttachedToWindow(@NonNull GodViewHolder godViewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, godViewHolder) == null) {
                super.onViewAttachedToWindow(godViewHolder);
                if (this.f50265f.l && (view = godViewHolder.itemView) != null && (view.getTag(R.id.tag_user_id) instanceof MetaData) && (godViewHolder.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) godViewHolder.itemView.getTag(R.id.tag_holder)).booleanValue();
                    MetaData metaData = (MetaData) godViewHolder.itemView.getTag(R.id.tag_user_id);
                    if (!booleanValue || this.f50265f.f50260k.contains(metaData.getUserId())) {
                        return;
                    }
                    this.f50265f.f50260k.add(metaData.getUserId());
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
                List<MetaData> list = this.f50263d;
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
                if (this.f50265f.f50260k.isEmpty() && (view = godViewHolder.itemView) != null) {
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
            String c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048583, this, metaData, godViewHolder) == null) || metaData == null || godViewHolder == null) {
                return;
            }
            String fieldName = metaData.isNewGod() ? metaData.getNewGodData().getFieldName() : null;
            if (!k.isEmpty(fieldName)) {
                c2 = fieldName + q0.c(metaData.isVideoGod());
            } else {
                c2 = q0.c(metaData.isVideoGod());
            }
            godViewHolder.mUserDesc.setText(c2);
        }

        public final void k(MetaData metaData, GodViewHolder godViewHolder) {
            c.a.q0.s.g0.t.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, metaData, godViewHolder) == null) || (cVar = godViewHolder.mUserLikePresenter) == null) {
                return;
            }
            cVar.l(this.f50262c);
            cVar.n(metaData);
        }

        public final void l(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048585, this, metaData, godViewHolder) == null) || metaData == null || godViewHolder == null) {
                return;
            }
            String string = this.f50265f.getResources().getString(R.string.god_default_name);
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
                this.f50263d = list;
            }
        }

        public void setOnItemCoverListener(f<MetaData> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) {
                this.f50264e = fVar;
            }
        }

        public void setPageContext(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, tbPageContext) == null) {
                this.f50261b = tbPageContext;
            }
        }

        public void setPageUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
                this.f50262c = bdUniqueId;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GodRecommendLayout a;

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
            this.a = godRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.f50259j == null) {
                        this.a.f50259j = new l(new j());
                    }
                    this.a.f50259j.q(this.a.f50257h, 1);
                } else if (this.a.f50259j != null) {
                    this.a.f50259j.w();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements f<MetaData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GodRecommendLayout f50270e;

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
            this.f50270e = godRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.n.f
        /* renamed from: b */
        public void c(View view, MetaData metaData, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, metaData, Integer.valueOf(i2), Long.valueOf(j2)}) != null) || metaData == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.n.f
        /* renamed from: d */
        public void a(View view, MetaData metaData, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, metaData, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || metaData == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f50270e.f50254e, metaData.getUserId(), metaData.getName_show())));
        }
    }

    /* loaded from: classes11.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GodRecommendLayout a;

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
            this.a = godRecommendLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                this.a.f50260k.clear();
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
                Context context = this.f50254e;
                if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                    ((BaseFragmentActivity) this.f50254e).disableSwipeJustOnce();
                } else {
                    Context context2 = this.f50254e;
                    if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                        ((BaseActivity) this.f50254e).disableSwipeJustOnce();
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
            this.f50255f = (TextView) findViewById(R.id.title);
            this.f50256g = (TextView) findViewById(R.id.change);
            this.f50257h = (RecyclerView) findViewById(R.id.thread_card_list);
            GodRecommendListAdapter godRecommendListAdapter = new GodRecommendListAdapter(this, this.f50254e);
            this.f50258i = godRecommendListAdapter;
            godRecommendListAdapter.setOnItemCoverListener(this.n);
            this.f50257h.setAdapter(this.f50258i);
            this.f50257h.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                l lVar = new l(new j());
                this.f50259j = lVar;
                lVar.q(this.f50257h, 1);
            }
            int f2 = c.a.d.f.p.l.f(this.f50254e, R.dimen.tbds21);
            int f3 = c.a.d.f.p.l.f(this.f50254e, R.dimen.tbds44);
            this.f50257h.setLayoutManager(new LinearLayoutManager(this.f50254e, 0, false));
            this.f50257h.setItemAnimator(new DefaultItemAnimator());
            this.f50257h.addItemDecoration(new SpaceItemDecoration(f3, f2, f3));
            this.f50257h.addOnScrollListener(this.o);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f50255f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f50256g, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0604);
            this.f50258i.notifyDataSetChanged();
        }
    }

    public void setCouldStatistic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l = z;
        }
    }

    public void setData(v1 v1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, v1Var) == null) || v1Var == null) {
            return;
        }
        this.f50258i.setData(v1Var.g());
        this.f50258i.notifyDataSetChanged();
        this.f50257h.scrollToPosition(0);
        this.f50260k.clear();
        this.l = true;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.f50258i.setPageContext(tbPageContext);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.m.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.m);
            this.f50258i.setPageUniqueId(bdUniqueId);
        }
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f50256g.setOnClickListener(onClickListener);
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
        this.f50260k = new ArrayList();
        this.l = true;
        this.m = new a(this, 2156674);
        this.n = new b(this);
        this.o = new c(this);
        this.f50254e = context;
        g();
    }
}
