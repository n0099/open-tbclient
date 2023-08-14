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
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.bi;
import com.baidu.tieba.l35;
import com.baidu.tieba.mz4;
import com.baidu.tieba.um;
import com.baidu.tieba.view.DynamicUserLikeButton;
import com.baidu.tieba.wm;
import com.baidu.tieba.xw5;
import com.baidu.tieba.za5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class GodRecommendLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public TextView b;
    public TextView c;
    public RecyclerView d;
    public GodRecommendListAdapter e;
    public wm f;
    public List<String> g;
    public boolean h;
    public CustomMessageListener i;
    public mz4 j;
    public RecyclerView.OnScrollListener k;

    /* loaded from: classes8.dex */
    public class GodRecommendListAdapter extends RecyclerView.Adapter<GodViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public TbPageContext b;
        public BdUniqueId c;
        public List<MetaData> d;
        public mz4<MetaData> e;
        public final /* synthetic */ GodRecommendLayout f;

        /* loaded from: classes8.dex */
        public class GodViewHolder extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public LinearLayout a;
            public TextView b;
            public TextView c;
            public HeadPendantClickableView d;
            public DynamicUserLikeButton e;
            public za5 f;
            public boolean g;
            public final /* synthetic */ GodRecommendListAdapter h;

            /* loaded from: classes8.dex */
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = godViewHolder;
                }

                @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                public void a(View view2) {
                    za5 za5Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (za5Var = this.a.f) != null && za5Var.h() != null && !this.a.f.h().getIsLike()) {
                        TiebaStatic.log(new StatisticItem("c13903").param(TiebaStatic.Params.FRIEND_UID, this.a.f.h().getUserId()).param("obj_name", this.a.c.getText().toString()));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GodViewHolder(GodRecommendListAdapter godRecommendListAdapter, View view2) {
                super(view2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {godRecommendListAdapter, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.h = godRecommendListAdapter;
                this.g = false;
                this.a = (LinearLayout) view2.findViewById(R.id.concern_container);
                HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view2.findViewById(R.id.concern_user_image);
                this.d = headPendantClickableView;
                headPendantClickableView.getHeadView().setIsRound(true);
                this.d.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.d.getHeadView().setDefaultResource(17170445);
                this.d.getHeadView().setPlaceHolder(1);
                this.d.getHeadView().setBorderWidth(BdUtilHelper.getDimens(godRecommendListAdapter.a, R.dimen.tbds1));
                this.d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                this.b = (TextView) view2.findViewById(R.id.concern_user_name);
                this.c = (TextView) view2.findViewById(R.id.concern_user_desc);
                DynamicUserLikeButton dynamicUserLikeButton = (DynamicUserLikeButton) view2.findViewById(R.id.user_recommend_like_btn);
                this.e = dynamicUserLikeButton;
                dynamicUserLikeButton.setGodRecommendStyle(true);
                this.e.setOnClickEvent(new a(this, godRecommendListAdapter));
                za5 za5Var = new za5(godRecommendListAdapter.b, this.e);
                this.f = za5Var;
                za5Var.i(true);
            }

            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.g) {
                        SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0101);
                    } else {
                        SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0301);
                    }
                    SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
                    this.e.k();
                    TBSelector.makeDrawableSelector().setShape(0).defaultStrokeColor(R.color.CAM_X0614).defaultColor(R.color.CAM_X0614).strokeWidth(BdUtilHelper.getDimens(this.h.a, R.dimen.tbds1)).radius(BdUtilHelper.getDimens(this.h.a, R.dimen.tbds10)).into(this.a);
                }
            }

            public final void c(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.g = z;
                }
            }
        }

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MetaData a;
            public final /* synthetic */ GodViewHolder b;
            public final /* synthetic */ GodRecommendListAdapter c;

            public a(GodRecommendListAdapter godRecommendListAdapter, MetaData metaData, GodViewHolder godViewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {godRecommendListAdapter, metaData, godViewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = godRecommendListAdapter;
                this.a = metaData;
                this.b = godViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.c.q(this.a, this.b);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = godRecommendLayout;
            this.a = context;
        }

        public final void B(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData, godViewHolder) == null) && metaData != null && godViewHolder != null) {
                String string = this.f.getResources().getString(R.string.god_default_name);
                if (!StringUtils.isNull(metaData.getName_show())) {
                    string = metaData.getName_show();
                }
                godViewHolder.b.setText(string);
                if (metaData.isNewGod()) {
                    SkinManager.setViewTextColor(godViewHolder.b, (int) R.color.CAM_X0301);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: s */
        public void onViewDetachedFromWindow(@NonNull GodViewHolder godViewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, godViewHolder) == null) {
                super.onViewDetachedFromWindow(godViewHolder);
                if (this.f.g.isEmpty() && (view2 = godViewHolder.itemView) != null) {
                    view2.setTag(R.id.tag_holder, Boolean.TRUE);
                }
            }
        }

        public void setData(List<MetaData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
                this.d = list;
            }
        }

        public void t(mz4<MetaData> mz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, mz4Var) == null) {
                this.e = mz4Var;
            }
        }

        public void u(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, tbPageContext) == null) {
                this.b = tbPageContext;
            }
        }

        public void x(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) {
                this.c = bdUniqueId;
            }
        }

        public final void A(MetaData metaData, GodViewHolder godViewHolder) {
            za5 za5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, metaData, godViewHolder) == null) && (za5Var = godViewHolder.f) != null) {
                za5Var.j(this.c);
                za5Var.l(metaData);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: p */
        public GodViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i)) == null) {
                return new GodViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.recommend_god_item, (ViewGroup) null));
            }
            return (GodViewHolder) invokeLI.objValue;
        }

        public final void q(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048585, this, metaData, godViewHolder) == null) && this.e != null) {
                this.e.d(godViewHolder.itemView, metaData, godViewHolder.getAdapterPosition(), godViewHolder.getItemId());
            }
        }

        public final void y(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048592, this, metaData, godViewHolder) == null) {
                godViewHolder.d.setData(metaData, true);
                godViewHolder.d.setOnClickListener(new a(this, metaData, godViewHolder));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                List<MetaData> list = this.d;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: o */
        public void onBindViewHolder(GodViewHolder godViewHolder, int i) {
            List<MetaData> list;
            MetaData metaData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048579, this, godViewHolder, i) == null) && godViewHolder != null && (list = this.d) != null && (metaData = list.get(i)) != null) {
                godViewHolder.c(metaData.isNewGod());
                y(metaData, godViewHolder);
                B(metaData, godViewHolder);
                z(metaData, godViewHolder);
                A(metaData, godViewHolder);
                mz4<MetaData> mz4Var = this.e;
                if (mz4Var != null) {
                    mz4Var.c(godViewHolder.itemView, metaData, i, i);
                }
                godViewHolder.a();
                godViewHolder.itemView.setTag(R.id.tag_user_id, metaData);
                godViewHolder.itemView.setTag(R.id.tag_holder, Boolean.TRUE);
            }
        }

        public final void z(MetaData metaData, GodViewHolder godViewHolder) {
            String c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048593, this, metaData, godViewHolder) == null) && metaData != null && godViewHolder != null) {
                String str = null;
                if (metaData.isNewGod()) {
                    str = metaData.getNewGodData().getFieldName();
                }
                if (!bi.isEmpty(str)) {
                    c = str + xw5.c(metaData.isVideoGod());
                } else {
                    c = xw5.c(metaData.isVideoGod());
                }
                godViewHolder.c.setText(c);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: r */
        public void onViewAttachedToWindow(@NonNull GodViewHolder godViewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, godViewHolder) == null) {
                super.onViewAttachedToWindow(godViewHolder);
                if (this.f.h && (view2 = godViewHolder.itemView) != null && (view2.getTag(R.id.tag_user_id) instanceof MetaData) && (godViewHolder.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) godViewHolder.itemView.getTag(R.id.tag_holder)).booleanValue();
                    MetaData metaData = (MetaData) godViewHolder.itemView.getTag(R.id.tag_user_id);
                    if (booleanValue && !this.f.g.contains(metaData.getUserId())) {
                        this.f.g.add(metaData.getUserId());
                        TiebaStatic.log(new StatisticItem("c13902").param("uid", metaData.getUserId()));
                        godViewHolder.itemView.setTag(R.id.tag_holder, Boolean.FALSE);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GodRecommendLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GodRecommendLayout godRecommendLayout, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {godRecommendLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    if (this.a.f == null) {
                        this.a.f = new wm(new um());
                    }
                    this.a.f.q(this.a.d, 1);
                } else if (this.a.f != null) {
                    this.a.f.w();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements mz4<MetaData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GodRecommendLayout a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mz4
        /* renamed from: a */
        public void c(View view2, MetaData metaData, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, metaData, Integer.valueOf(i), Long.valueOf(j)}) != null) || metaData == null) {
            }
        }

        public b(GodRecommendLayout godRecommendLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {godRecommendLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = godRecommendLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mz4
        /* renamed from: b */
        public void d(View view2, MetaData metaData, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, metaData, Integer.valueOf(i), Long.valueOf(j)}) == null) && metaData != null && !StringUtils.isNull(metaData.getUserId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a, metaData.getUserId(), metaData.getName_show())));
            }
        }
    }

    /* loaded from: classes8.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = godRecommendLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                this.a.g.clear();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                Context context = this.a;
                if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                    ((BaseFragmentActivity) this.a).disableSwipeJustOnce();
                } else {
                    Context context2 = this.a;
                    if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                        ((BaseActivity) this.a).disableSwipeJustOnce();
                    }
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.g = new ArrayList();
        this.h = true;
        this.i = new a(this, 2156674);
        this.j = new b(this);
        this.k = new c(this);
        this.a = context;
        g();
    }

    public void setCouldStatistic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.h = z;
        }
    }

    public void setData(l35 l35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, l35Var) != null) || l35Var == null) {
            return;
        }
        this.e.setData(l35Var.c());
        this.e.notifyDataSetChanged();
        this.d.scrollToPosition(0);
        this.g.clear();
        this.h = true;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.e.u(tbPageContext);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.i.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.i);
            this.e.x(bdUniqueId);
        }
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.c.setOnClickListener(onClickListener);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.recommend_god_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f092560);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0906a4);
            this.d = (RecyclerView) findViewById(R.id.thread_card_list);
            GodRecommendListAdapter godRecommendListAdapter = new GodRecommendListAdapter(this, this.a);
            this.e = godRecommendListAdapter;
            godRecommendListAdapter.t(this.j);
            this.d.setAdapter(this.e);
            this.d.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                wm wmVar = new wm(new um());
                this.f = wmVar;
                wmVar.q(this.d, 1);
            }
            int dimens = BdUtilHelper.getDimens(this.a, R.dimen.tbds21);
            int dimens2 = BdUtilHelper.getDimens(this.a, R.dimen.tbds44);
            this.d.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
            this.d.setItemAnimator(new DefaultItemAnimator());
            this.d.addItemDecoration(new SpaceItemDecoration(dimens2, dimens, dimens2));
            this.d.addOnScrollListener(this.k);
            h();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0604);
            this.e.notifyDataSetChanged();
        }
    }
}
