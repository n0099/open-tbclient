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
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.d.o.e.j;
import c.a.d.o.e.l;
import c.a.o0.c1.s0;
import c.a.o0.m.f;
import c.a.o0.r.r.s1;
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
/* loaded from: classes6.dex */
public class GodRecommendLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f36865b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36866c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f36867d;

    /* renamed from: e  reason: collision with root package name */
    public GodRecommendListAdapter f36868e;

    /* renamed from: f  reason: collision with root package name */
    public l f36869f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f36870g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36871h;
    public CustomMessageListener i;
    public f j;
    public RecyclerView.OnScrollListener k;

    /* loaded from: classes6.dex */
    public class GodRecommendListAdapter extends RecyclerView.Adapter<GodViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public TbPageContext f36872b;

        /* renamed from: c  reason: collision with root package name */
        public BdUniqueId f36873c;

        /* renamed from: d  reason: collision with root package name */
        public List<MetaData> f36874d;

        /* renamed from: e  reason: collision with root package name */
        public f<MetaData> f36875e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GodRecommendLayout f36876f;

        /* loaded from: classes6.dex */
        public class GodViewHolder extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public LinearLayout a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f36877b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f36878c;

            /* renamed from: d  reason: collision with root package name */
            public HeadPendantClickableView f36879d;

            /* renamed from: e  reason: collision with root package name */
            public DynamicUserLikeButton f36880e;

            /* renamed from: f  reason: collision with root package name */
            public c.a.o0.r.l0.t.c f36881f;

            /* renamed from: g  reason: collision with root package name */
            public boolean f36882g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ GodRecommendListAdapter f36883h;

            /* loaded from: classes6.dex */
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
                public void a(View view) {
                    c.a.o0.r.l0.t.c cVar;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (cVar = this.a.f36881f) == null || cVar.j() == null || this.a.f36881f.j().getIsLike()) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c13903").param(TiebaStatic.Params.FRIEND_UID, this.a.f36881f.j().getUserId()).param("obj_name", this.a.f36878c.getText().toString()));
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36883h = godRecommendListAdapter;
                this.f36882g = false;
                this.a = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0906ac);
                HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.obfuscated_res_0x7f0906b6);
                this.f36879d = headPendantClickableView;
                headPendantClickableView.getHeadView().setIsRound(true);
                this.f36879d.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f36879d.getHeadView().setDefaultResource(17170445);
                this.f36879d.getHeadView().setPlaceHolder(1);
                this.f36879d.getHeadView().setBorderWidth(n.f(godRecommendListAdapter.a, R.dimen.tbds1));
                this.f36879d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                this.f36877b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0906b7);
                this.f36878c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0906b5);
                DynamicUserLikeButton dynamicUserLikeButton = (DynamicUserLikeButton) view.findViewById(R.id.obfuscated_res_0x7f0922cf);
                this.f36880e = dynamicUserLikeButton;
                dynamicUserLikeButton.setGodRecommendStyle(true);
                this.f36880e.setOnClickEvent(new a(this, godRecommendListAdapter));
                c.a.o0.r.l0.t.c cVar = new c.a.o0.r.l0.t.c(godRecommendListAdapter.f36872b, this.f36880e);
                this.f36881f = cVar;
                cVar.k(true);
            }

            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.f36882g) {
                        SkinManager.setViewTextColor(this.f36877b, (int) R.color.CAM_X0101);
                    } else {
                        SkinManager.setViewTextColor(this.f36877b, (int) R.color.CAM_X0301);
                    }
                    SkinManager.setViewTextColor(this.f36878c, (int) R.color.CAM_X0101);
                    this.f36880e.k();
                    TBSelector.makeDrawableSelector().setShape(0).defaultStrokeColor(R.color.CAM_X0614).defaultColor(R.color.CAM_X0614).strokeWidth(n.f(this.f36883h.a, R.dimen.tbds1)).radius(n.f(this.f36883h.a, R.dimen.tbds10)).into(this.a);
                }
            }

            public final void c(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.f36882g = z;
                }
            }
        }

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MetaData a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ GodViewHolder f36884b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ GodRecommendListAdapter f36885c;

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
                this.f36885c = godRecommendListAdapter;
                this.a = metaData;
                this.f36884b = godViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f36885c.i(this.a, this.f36884b);
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
            this.f36876f = godRecommendLayout;
            this.a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g */
        public void onBindViewHolder(GodViewHolder godViewHolder, int i) {
            List<MetaData> list;
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, godViewHolder, i) == null) || godViewHolder == null || (list = this.f36874d) == null || (metaData = list.get(i)) == null) {
                return;
            }
            godViewHolder.c(metaData.isNewGod());
            o(metaData, godViewHolder);
            r(metaData, godViewHolder);
            p(metaData, godViewHolder);
            q(metaData, godViewHolder);
            f<MetaData> fVar = this.f36875e;
            if (fVar != null) {
                fVar.c(godViewHolder.itemView, metaData, i, i);
            }
            godViewHolder.b();
            godViewHolder.itemView.setTag(R.id.obfuscated_res_0x7f091eb7, metaData);
            godViewHolder.itemView.setTag(R.id.obfuscated_res_0x7f091e7e, Boolean.TRUE);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<MetaData> list = this.f36874d;
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
        public GodViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) ? new GodViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d072d, (ViewGroup) null)) : (GodViewHolder) invokeLI.objValue;
        }

        public final void i(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, metaData, godViewHolder) == null) || this.f36875e == null) {
                return;
            }
            this.f36875e.a(godViewHolder.itemView, metaData, godViewHolder.getAdapterPosition(), godViewHolder.getItemId());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j */
        public void onViewAttachedToWindow(@NonNull GodViewHolder godViewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, godViewHolder) == null) {
                super.onViewAttachedToWindow(godViewHolder);
                if (this.f36876f.f36871h && (view = godViewHolder.itemView) != null && (view.getTag(R.id.obfuscated_res_0x7f091eb7) instanceof MetaData) && (godViewHolder.itemView.getTag(R.id.obfuscated_res_0x7f091e7e) instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) godViewHolder.itemView.getTag(R.id.obfuscated_res_0x7f091e7e)).booleanValue();
                    MetaData metaData = (MetaData) godViewHolder.itemView.getTag(R.id.obfuscated_res_0x7f091eb7);
                    if (!booleanValue || this.f36876f.f36870g.contains(metaData.getUserId())) {
                        return;
                    }
                    this.f36876f.f36870g.add(metaData.getUserId());
                    TiebaStatic.log(new StatisticItem("c13902").param("uid", metaData.getUserId()));
                    godViewHolder.itemView.setTag(R.id.obfuscated_res_0x7f091e7e, Boolean.FALSE);
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
                if (this.f36876f.f36870g.isEmpty() && (view = godViewHolder.itemView) != null) {
                    view.setTag(R.id.obfuscated_res_0x7f091e7e, Boolean.TRUE);
                }
            }
        }

        public void l(f<MetaData> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
                this.f36875e = fVar;
            }
        }

        public void m(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) {
                this.f36872b = tbPageContext;
            }
        }

        public void n(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
                this.f36873c = bdUniqueId;
            }
        }

        public final void o(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, metaData, godViewHolder) == null) {
                godViewHolder.f36879d.setData(metaData, true);
                godViewHolder.f36879d.setOnClickListener(new a(this, metaData, godViewHolder));
            }
        }

        public final void p(MetaData metaData, GodViewHolder godViewHolder) {
            String c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048590, this, metaData, godViewHolder) == null) || metaData == null || godViewHolder == null) {
                return;
            }
            String fieldName = metaData.isNewGod() ? metaData.getNewGodData().getFieldName() : null;
            if (!m.isEmpty(fieldName)) {
                c2 = fieldName + s0.c(metaData.isVideoGod());
            } else {
                c2 = s0.c(metaData.isVideoGod());
            }
            godViewHolder.f36878c.setText(c2);
        }

        public final void q(MetaData metaData, GodViewHolder godViewHolder) {
            c.a.o0.r.l0.t.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048591, this, metaData, godViewHolder) == null) || (cVar = godViewHolder.f36881f) == null) {
                return;
            }
            cVar.l(this.f36873c);
            cVar.n(metaData);
        }

        public final void r(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048592, this, metaData, godViewHolder) == null) || metaData == null || godViewHolder == null) {
                return;
            }
            String string = this.f36876f.getResources().getString(R.string.obfuscated_res_0x7f0f07b2);
            if (!StringUtils.isNull(metaData.getName_show())) {
                string = metaData.getName_show();
            }
            godViewHolder.f36877b.setText(string);
            if (metaData.isNewGod()) {
                SkinManager.setViewTextColor(godViewHolder.f36877b, (int) R.color.CAM_X0301);
            }
        }

        public void setData(List<MetaData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
                this.f36874d = list;
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    if (this.a.f36869f == null) {
                        this.a.f36869f = new l(new j());
                    }
                    this.a.f36869f.q(this.a.f36867d, 1);
                } else if (this.a.f36869f != null) {
                    this.a.f36869f.w();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements f<MetaData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GodRecommendLayout a;

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
        @Override // c.a.o0.m.f
        /* renamed from: b */
        public void c(View view, MetaData metaData, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, metaData, Integer.valueOf(i), Long.valueOf(j)}) != null) || metaData == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.m.f
        /* renamed from: d */
        public void a(View view, MetaData metaData, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, metaData, Integer.valueOf(i), Long.valueOf(j)}) == null) || metaData == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a, metaData.getUserId(), metaData.getName_show())));
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.f36870g.clear();
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

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d072e, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f36865b = (TextView) findViewById(R.id.obfuscated_res_0x7f09202b);
            this.f36866c = (TextView) findViewById(R.id.obfuscated_res_0x7f0905df);
            this.f36867d = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091f99);
            GodRecommendListAdapter godRecommendListAdapter = new GodRecommendListAdapter(this, this.a);
            this.f36868e = godRecommendListAdapter;
            godRecommendListAdapter.l(this.j);
            this.f36867d.setAdapter(this.f36868e);
            this.f36867d.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                l lVar = new l(new j());
                this.f36869f = lVar;
                lVar.q(this.f36867d, 1);
            }
            int f2 = n.f(this.a, R.dimen.tbds21);
            int f3 = n.f(this.a, R.dimen.tbds44);
            this.f36867d.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
            this.f36867d.setItemAnimator(new DefaultItemAnimator());
            this.f36867d.addItemDecoration(new SpaceItemDecoration(f3, f2, f3));
            this.f36867d.addOnScrollListener(this.k);
            h();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f36865b, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f36866c, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0604);
            this.f36868e.notifyDataSetChanged();
        }
    }

    public void setCouldStatistic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f36871h = z;
        }
    }

    public void setData(s1 s1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, s1Var) == null) || s1Var == null) {
            return;
        }
        this.f36868e.setData(s1Var.e());
        this.f36868e.notifyDataSetChanged();
        this.f36867d.scrollToPosition(0);
        this.f36870g.clear();
        this.f36871h = true;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.f36868e.m(tbPageContext);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.i.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.i);
            this.f36868e.n(bdUniqueId);
        }
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f36866c.setOnClickListener(onClickListener);
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
        this.f36870g = new ArrayList();
        this.f36871h = true;
        this.i = new a(this, 2156674);
        this.j = new b(this);
        this.k = new c(this);
        this.a = context;
        g();
    }
}
