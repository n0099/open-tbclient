package com.baidu.tieba.write.write.work.topic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.t0.s1.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.write.write.work.topic.view.SelectTopicToolItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class SelectTopicToolBar extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_TYPE_GENERAL = 2;
    public static final int FROM_TYPE_RECOMMENT = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter<d> f50071e;

    /* renamed from: f  reason: collision with root package name */
    public final List<f> f50072f;

    /* renamed from: g  reason: collision with root package name */
    public int f50073g;

    /* renamed from: h  reason: collision with root package name */
    public long f50074h;

    /* renamed from: i  reason: collision with root package name */
    public SelectTopicToolItem f50075i;

    /* renamed from: j  reason: collision with root package name */
    public View f50076j;
    public e k;
    public final SelectTopicToolItem.b l;

    /* loaded from: classes13.dex */
    public class a implements SelectTopicToolItem.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTopicToolBar a;

        public a(SelectTopicToolBar selectTopicToolBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicToolBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTopicToolBar;
        }

        @Override // com.baidu.tieba.write.write.work.topic.view.SelectTopicToolItem.b
        public void a(@NonNull f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                fVar.k(this.a.f50073g == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921633, fVar));
                if (fVar.j() && this.a.f50073g == 1) {
                    TiebaStatic.log(new StatisticItem("c14419").addParam("obj_locate", "1").addParam("is_video_topic", "1").addParam("topic_id", fVar.d().longValue()));
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTopicToolBar f50077e;

        public b(SelectTopicToolBar selectTopicToolBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicToolBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50077e = selectTopicToolBar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50077e.k == null) {
                return;
            }
            this.f50077e.k.onOpen();
        }
    }

    /* loaded from: classes13.dex */
    public class c extends RecyclerView.Adapter<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTopicToolBar a;

        public c(SelectTopicToolBar selectTopicToolBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicToolBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTopicToolBar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull d dVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dVar, i2) == null) {
                dVar.a.bindData((f) this.a.f50072f.get(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: c */
        public d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
                SelectTopicToolItem selectTopicToolItem = new SelectTopicToolItem(viewGroup.getContext());
                if (this.a.f50073g == 1) {
                    selectTopicToolItem.setFromBar(true);
                    selectTopicToolItem.setPadding(0, n.f(this.a.getContext(), c.a.t0.p4.e.M_H_X005), 0, n.f(this.a.getContext(), c.a.t0.p4.e.M_H_X007));
                }
                selectTopicToolItem.setItemClickListener(this.a.l);
                return new d(selectTopicToolItem);
            }
            return (d) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onViewAttachedToWindow(@NonNull d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                super.onViewAttachedToWindow(dVar);
                int adapterPosition = dVar.getAdapterPosition();
                f fVar = (f) this.a.f50072f.get(adapterPosition);
                if (adapterPosition == 0 || !fVar.j()) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c14417").addParam("is_video_topic", "1").addParam("topic_id", fVar.d().longValue()));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.a.f50072f == null) {
                    return 0;
                }
                return this.a.f50072f.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes13.dex */
    public static class d extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SelectTopicToolItem a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NonNull View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.a = (SelectTopicToolItem) view;
        }
    }

    /* loaded from: classes13.dex */
    public interface e {
        void onOpen();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicToolBar(Context context) {
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
        this.f50072f = new ArrayList();
        this.l = new a(this);
        e();
    }

    public void bindData(List<f> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f50072f.clear();
        this.f50072f.addAll(list);
        for (int i2 = 0; i2 < this.f50072f.size(); i2++) {
            f fVar = this.f50072f.get(i2);
            if (fVar != null) {
                fVar.m(this.f50074h == fVar.d().longValue());
            }
        }
        this.f50071e.notifyDataSetChanged();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(0);
            SelectTopicToolItem selectTopicToolItem = new SelectTopicToolItem(getContext());
            this.f50075i = selectTopicToolItem;
            selectTopicToolItem.setIsAddTopicItem();
            this.f50075i.setOnClickListener(new b(this));
            addView(this.f50075i);
            this.f50076j = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(c.a.t0.p4.e.tbds1), UtilHelper.getDimenPixelSize(c.a.t0.p4.e.tbds42));
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(c.a.t0.p4.e.tbds26);
            layoutParams.gravity = 16;
            addView(this.f50076j, layoutParams);
            RecyclerView recyclerView = new RecyclerView(getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            recyclerView.setFadingEdgeLength(0);
            recyclerView.setOverScrollMode(2);
            c cVar = new c(this);
            this.f50071e = cVar;
            recyclerView.setAdapter(cVar);
            recyclerView.setClipChildren(false);
            recyclerView.setClipToPadding(false);
            recyclerView.setHorizontalFadingEdgeEnabled(true);
            recyclerView.setFadingEdgeLength(UtilHelper.getDimenPixelSize(c.a.t0.p4.e.tbds70));
            addView(recyclerView);
        }
    }

    public int getmFromType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50073g : invokeV.intValue;
    }

    public void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f50075i.changeSkin();
            this.f50071e.notifyDataSetChanged();
            c.a.s0.s.u.c.d(this.f50076j).f(c.a.t0.p4.d.CAM_X0401);
            c.a.s0.s.u.c.d(this).f(c.a.t0.p4.d.CAM_X0201);
        }
    }

    public void setOpenTopicLayoutListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public void setSelectTopicId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f50074h = j2;
            for (int i2 = 0; i2 < this.f50072f.size(); i2++) {
                f fVar = this.f50072f.get(i2);
                if (fVar != null) {
                    fVar.m(j2 == fVar.d().longValue());
                }
            }
            RecyclerView.Adapter<d> adapter = this.f50071e;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    public void setmFromType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f50073g = i2;
            if (i2 == 1) {
                this.f50075i.setPadding(0, n.f(getContext(), c.a.t0.p4.e.M_H_X005), 0, n.f(getContext(), c.a.t0.p4.e.M_H_X007));
            }
        }
    }

    public void showAddTopicItem(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f50075i.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicToolBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50072f = new ArrayList();
        this.l = new a(this);
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicToolBar(Context context, AttributeSet attributeSet, int i2) {
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
        this.f50072f = new ArrayList();
        this.l = new a(this);
        e();
    }
}
