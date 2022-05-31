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
import com.repackage.fn;
import com.repackage.hn;
import com.repackage.ip4;
import com.repackage.ki;
import com.repackage.kl4;
import com.repackage.li;
import com.repackage.qu4;
import com.repackage.wc5;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class GodRecommendLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public TextView b;
    public TextView c;
    public RecyclerView d;
    public GodRecommendListAdapter e;
    public hn f;
    public List<String> g;
    public boolean h;
    public CustomMessageListener i;
    public kl4 j;
    public RecyclerView.OnScrollListener k;

    /* loaded from: classes4.dex */
    public class GodRecommendListAdapter extends RecyclerView.Adapter<GodViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public TbPageContext b;
        public BdUniqueId c;
        public List<MetaData> d;
        public kl4<MetaData> e;
        public final /* synthetic */ GodRecommendLayout f;

        /* loaded from: classes4.dex */
        public class GodViewHolder extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public LinearLayout a;
            public TextView b;
            public TextView c;
            public HeadPendantClickableView d;
            public DynamicUserLikeButton e;
            public qu4 f;
            public boolean g;
            public final /* synthetic */ GodRecommendListAdapter h;

            /* loaded from: classes4.dex */
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
                    qu4 qu4Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (qu4Var = this.a.f) == null || qu4Var.j() == null || this.a.f.j().getIsLike()) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c13903").param(TiebaStatic.Params.FRIEND_UID, this.a.f.j().getUserId()).param("obj_name", this.a.c.getText().toString()));
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
                this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090693);
                HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view2.findViewById(R.id.obfuscated_res_0x7f09069d);
                this.d = headPendantClickableView;
                headPendantClickableView.getHeadView().setIsRound(true);
                this.d.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.d.getHeadView().setDefaultResource(17170445);
                this.d.getHeadView().setPlaceHolder(1);
                this.d.getHeadView().setBorderWidth(li.f(godRecommendListAdapter.a, R.dimen.tbds1));
                this.d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09069e);
                this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09069c);
                DynamicUserLikeButton dynamicUserLikeButton = (DynamicUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f0922ac);
                this.e = dynamicUserLikeButton;
                dynamicUserLikeButton.setGodRecommendStyle(true);
                this.e.setOnClickEvent(new a(this, godRecommendListAdapter));
                qu4 qu4Var = new qu4(godRecommendListAdapter.b, this.e);
                this.f = qu4Var;
                qu4Var.k(true);
            }

            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.g) {
                        SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0101);
                    } else {
                        SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0301);
                    }
                    SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
                    this.e.k();
                    TBSelector.makeDrawableSelector().setShape(0).defaultStrokeColor(R.color.CAM_X0614).defaultColor(R.color.CAM_X0614).strokeWidth(li.f(this.h.a, R.dimen.tbds1)).radius(li.f(this.h.a, R.dimen.tbds10)).into(this.a);
                }
            }

            public final void c(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    this.g = z;
                }
            }
        }

        /* loaded from: classes4.dex */
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
                    this.c.i(this.a, this.b);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g */
        public void onBindViewHolder(GodViewHolder godViewHolder, int i) {
            List<MetaData> list;
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, godViewHolder, i) == null) || godViewHolder == null || (list = this.d) == null || (metaData = list.get(i)) == null) {
                return;
            }
            godViewHolder.c(metaData.isNewGod());
            o(metaData, godViewHolder);
            s(metaData, godViewHolder);
            q(metaData, godViewHolder);
            r(metaData, godViewHolder);
            kl4<MetaData> kl4Var = this.e;
            if (kl4Var != null) {
                kl4Var.c(godViewHolder.itemView, metaData, i, i);
            }
            godViewHolder.b();
            godViewHolder.itemView.setTag(R.id.obfuscated_res_0x7f091ea3, metaData);
            godViewHolder.itemView.setTag(R.id.obfuscated_res_0x7f091e69, Boolean.TRUE);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        /* renamed from: h */
        public GodViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) ? new GodViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d070e, (ViewGroup) null)) : (GodViewHolder) invokeLI.objValue;
        }

        public final void i(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, metaData, godViewHolder) == null) || this.e == null) {
                return;
            }
            this.e.a(godViewHolder.itemView, metaData, godViewHolder.getAdapterPosition(), godViewHolder.getItemId());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j */
        public void onViewAttachedToWindow(@NonNull GodViewHolder godViewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, godViewHolder) == null) {
                super.onViewAttachedToWindow(godViewHolder);
                if (this.f.h && (view2 = godViewHolder.itemView) != null && (view2.getTag(R.id.obfuscated_res_0x7f091ea3) instanceof MetaData) && (godViewHolder.itemView.getTag(R.id.obfuscated_res_0x7f091e69) instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) godViewHolder.itemView.getTag(R.id.obfuscated_res_0x7f091e69)).booleanValue();
                    MetaData metaData = (MetaData) godViewHolder.itemView.getTag(R.id.obfuscated_res_0x7f091ea3);
                    if (!booleanValue || this.f.g.contains(metaData.getUserId())) {
                        return;
                    }
                    this.f.g.add(metaData.getUserId());
                    TiebaStatic.log(new StatisticItem("c13902").param("uid", metaData.getUserId()));
                    godViewHolder.itemView.setTag(R.id.obfuscated_res_0x7f091e69, Boolean.FALSE);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k */
        public void onViewDetachedFromWindow(@NonNull GodViewHolder godViewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, godViewHolder) == null) {
                super.onViewDetachedFromWindow(godViewHolder);
                if (this.f.g.isEmpty() && (view2 = godViewHolder.itemView) != null) {
                    view2.setTag(R.id.obfuscated_res_0x7f091e69, Boolean.TRUE);
                }
            }
        }

        public void l(kl4<MetaData> kl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, kl4Var) == null) {
                this.e = kl4Var;
            }
        }

        public void m(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) {
                this.b = tbPageContext;
            }
        }

        public void n(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
                this.c = bdUniqueId;
            }
        }

        public final void o(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, metaData, godViewHolder) == null) {
                godViewHolder.d.setData(metaData, true);
                godViewHolder.d.setOnClickListener(new a(this, metaData, godViewHolder));
            }
        }

        public final void q(MetaData metaData, GodViewHolder godViewHolder) {
            String c;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048590, this, metaData, godViewHolder) == null) || metaData == null || godViewHolder == null) {
                return;
            }
            String fieldName = metaData.isNewGod() ? metaData.getNewGodData().getFieldName() : null;
            if (!ki.isEmpty(fieldName)) {
                c = fieldName + wc5.c(metaData.isVideoGod());
            } else {
                c = wc5.c(metaData.isVideoGod());
            }
            godViewHolder.c.setText(c);
        }

        public final void r(MetaData metaData, GodViewHolder godViewHolder) {
            qu4 qu4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048591, this, metaData, godViewHolder) == null) || (qu4Var = godViewHolder.f) == null) {
                return;
            }
            qu4Var.l(this.c);
            qu4Var.n(metaData);
        }

        public final void s(MetaData metaData, GodViewHolder godViewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048592, this, metaData, godViewHolder) == null) || metaData == null || godViewHolder == null) {
                return;
            }
            String string = this.f.getResources().getString(R.string.obfuscated_res_0x7f0f07c6);
            if (!StringUtils.isNull(metaData.getName_show())) {
                string = metaData.getName_show();
            }
            godViewHolder.b.setText(string);
            if (metaData.isNewGod()) {
                SkinManager.setViewTextColor(godViewHolder.b, (int) R.color.CAM_X0301);
            }
        }

        public void setData(List<MetaData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
                this.d = list;
            }
        }
    }

    /* loaded from: classes4.dex */
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
                        this.a.f = new hn(new fn());
                    }
                    this.a.f.q(this.a.d, 1);
                } else if (this.a.f != null) {
                    this.a.f.w();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements kl4<MetaData> {
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
        @Override // com.repackage.kl4
        /* renamed from: b */
        public void c(View view2, MetaData metaData, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, metaData, Integer.valueOf(i), Long.valueOf(j)}) != null) || metaData == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.kl4
        /* renamed from: d */
        public void a(View view2, MetaData metaData, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, metaData, Integer.valueOf(i), Long.valueOf(j)}) == null) || metaData == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a, metaData.getUserId(), metaData.getName_show())));
        }
    }

    /* loaded from: classes4.dex */
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

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d070f, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f092017);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0905db);
            this.d = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091f84);
            GodRecommendListAdapter godRecommendListAdapter = new GodRecommendListAdapter(this, this.a);
            this.e = godRecommendListAdapter;
            godRecommendListAdapter.l(this.j);
            this.d.setAdapter(this.e);
            this.d.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                hn hnVar = new hn(new fn());
                this.f = hnVar;
                hnVar.q(this.d, 1);
            }
            int f = li.f(this.a, R.dimen.tbds21);
            int f2 = li.f(this.a, R.dimen.tbds44);
            this.d.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
            this.d.setItemAnimator(new DefaultItemAnimator());
            this.d.addItemDecoration(new SpaceItemDecoration(f2, f, f2));
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

    public void setCouldStatistic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.h = z;
        }
    }

    public void setData(ip4 ip4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, ip4Var) == null) || ip4Var == null) {
            return;
        }
        this.e.setData(ip4Var.e());
        this.e.notifyDataSetChanged();
        this.d.scrollToPosition(0);
        this.g.clear();
        this.h = true;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.e.m(tbPageContext);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.i.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.i);
            this.e.n(bdUniqueId);
        }
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.c.setOnClickListener(onClickListener);
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
        this.g = new ArrayList();
        this.h = true;
        this.i = new a(this, 2156674);
        this.j = new b(this);
        this.k = new c(this);
        this.a = context;
        g();
    }
}
