package com.baidu.tieba.write.write.work.topic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.e.p.l;
import b.a.r0.k1.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.work.topic.view.SelectTopicToolItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class SelectTopicToolBar extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter<d> f56322e;

    /* renamed from: f  reason: collision with root package name */
    public final List<f> f56323f;

    /* renamed from: g  reason: collision with root package name */
    public int f56324g;

    /* renamed from: h  reason: collision with root package name */
    public long f56325h;

    /* renamed from: i  reason: collision with root package name */
    public SelectTopicToolItem f56326i;
    public e j;
    public final SelectTopicToolItem.b k;

    /* loaded from: classes10.dex */
    public class a implements SelectTopicToolItem.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectTopicToolBar f56327a;

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
            this.f56327a = selectTopicToolBar;
        }

        @Override // com.baidu.tieba.write.write.work.topic.view.SelectTopicToolItem.b
        public void a(@NonNull f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                fVar.j(this.f56327a.f56324g == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921633, fVar));
                if (fVar.i() && this.f56327a.f56324g == 1) {
                    TiebaStatic.log(new StatisticItem("c14419").addParam("obj_locate", "1").addParam(IntentConfig.IS_VIDEO_TOPIC, "1").addParam("topic_id", fVar.c().topic_id.longValue()));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTopicToolBar f56328e;

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
            this.f56328e = selectTopicToolBar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f56328e.j == null) {
                return;
            }
            this.f56328e.j.onOpen();
        }
    }

    /* loaded from: classes10.dex */
    public class c extends RecyclerView.Adapter<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectTopicToolBar f56329a;

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
            this.f56329a = selectTopicToolBar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull d dVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dVar, i2) == null) {
                dVar.f56330a.bindData((f) this.f56329a.f56323f.get(i2));
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
                selectTopicToolItem.setItemClickListener(this.f56329a.k);
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
                f fVar = (f) this.f56329a.f56323f.get(adapterPosition);
                if (adapterPosition == 0 || !fVar.i()) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c14417").addParam(IntentConfig.IS_VIDEO_TOPIC, "1").addParam("topic_id", fVar.c().topic_id.longValue()));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f56329a.f56323f == null) {
                    return 0;
                }
                return this.f56329a.f56323f.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class d extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SelectTopicToolItem f56330a;

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
            this.f56330a = (SelectTopicToolItem) view;
        }
    }

    /* loaded from: classes10.dex */
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
        this.f56323f = new ArrayList();
        this.k = new a(this);
        e();
    }

    public void bindData(List<f> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f56323f.clear();
        this.f56323f.addAll(list);
        for (int i2 = 0; i2 < this.f56323f.size(); i2++) {
            f fVar = this.f56323f.get(i2);
            if (fVar != null) {
                fVar.l(this.f56325h == fVar.c().topic_id.longValue());
            }
        }
        this.f56322e.notifyDataSetChanged();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(0);
            SelectTopicToolItem selectTopicToolItem = new SelectTopicToolItem(getContext());
            this.f56326i = selectTopicToolItem;
            selectTopicToolItem.setPadding(l.g(getContext(), R.dimen.M_W_X007), 0, 0, 0);
            this.f56326i.setIsAddTopicItem();
            this.f56326i.setOnClickListener(new b(this));
            addView(this.f56326i);
            RecyclerView recyclerView = new RecyclerView(getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            recyclerView.setFadingEdgeLength(0);
            recyclerView.setOverScrollMode(2);
            c cVar = new c(this);
            this.f56322e = cVar;
            recyclerView.setAdapter(cVar);
            recyclerView.setClipChildren(false);
            recyclerView.setClipToPadding(false);
            addView(recyclerView);
        }
    }

    public int getmFromType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56324g : invokeV.intValue;
    }

    public void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f56326i.changeSkin();
            this.f56322e.notifyDataSetChanged();
        }
    }

    public void setOpenTopicLayoutListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.j = eVar;
        }
    }

    public void setSelectTopicId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.f56325h = j;
            for (int i2 = 0; i2 < this.f56323f.size(); i2++) {
                f fVar = this.f56323f.get(i2);
                if (fVar != null) {
                    fVar.l(j == fVar.c().topic_id.longValue());
                }
            }
            RecyclerView.Adapter<d> adapter = this.f56322e;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    public void setmFromType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f56324g = i2;
        }
    }

    public void showAddTopicItem(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f56326i.setVisibility(z ? 0 : 8);
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
        this.f56323f = new ArrayList();
        this.k = new a(this);
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
        this.f56323f = new ArrayList();
        this.k = new a(this);
        e();
    }
}
