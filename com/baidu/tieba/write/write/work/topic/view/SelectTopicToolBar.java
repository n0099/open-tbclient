package com.baidu.tieba.write.write.work.topic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.work.topic.view.SelectTopicToolItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gs4;
import com.repackage.mi;
import com.repackage.t37;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectTopicToolBar extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.Adapter<d> a;
    public final List<t37> b;
    public int c;
    public long d;
    public SelectTopicToolItem e;
    public View f;
    public e g;
    public final SelectTopicToolItem.b h;

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTopicToolBar;
        }

        @Override // com.baidu.tieba.write.write.work.topic.view.SelectTopicToolItem.b
        public void a(@NonNull t37 t37Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t37Var) == null) {
                t37Var.k(this.a.c == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921633, t37Var));
                if (t37Var.j() && this.a.c == 1) {
                    TiebaStatic.log(new StatisticItem("c14419").addParam("obj_locate", "1").addParam("is_video_topic", "1").addParam("topic_id", t37Var.d().longValue()));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTopicToolBar a;

        public b(SelectTopicToolBar selectTopicToolBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicToolBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTopicToolBar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g == null) {
                return;
            }
            this.a.g.onOpen();
        }
    }

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTopicToolBar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(@NonNull d dVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dVar, i) == null) {
                dVar.a.c((t37) this.a.b.get(i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: e */
        public d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) {
                SelectTopicToolItem selectTopicToolItem = new SelectTopicToolItem(viewGroup.getContext());
                if (this.a.c == 1) {
                    selectTopicToolItem.setFromBar(true);
                    selectTopicToolItem.setPadding(0, mi.f(this.a.getContext(), R.dimen.M_H_X005), 0, mi.f(this.a.getContext(), R.dimen.M_H_X007));
                }
                selectTopicToolItem.setItemClickListener(this.a.h);
                return new d(selectTopicToolItem);
            }
            return (d) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f */
        public void onViewAttachedToWindow(@NonNull d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                super.onViewAttachedToWindow(dVar);
                int adapterPosition = dVar.getAdapterPosition();
                t37 t37Var = (t37) this.a.b.get(adapterPosition);
                if (adapterPosition == 0 || !t37Var.j()) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c14417").addParam("is_video_topic", "1").addParam("topic_id", t37Var.d().longValue()));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.a.b == null) {
                    return 0;
                }
                return this.a.b.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SelectTopicToolItem a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            this.a = (SelectTopicToolItem) view2;
        }
    }

    /* loaded from: classes4.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.h = new a(this);
        f();
    }

    public void e(List<t37> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.b.clear();
        this.b.addAll(list);
        for (int i = 0; i < this.b.size(); i++) {
            t37 t37Var = this.b.get(i);
            if (t37Var != null) {
                t37Var.m(this.d == t37Var.d().longValue());
            }
        }
        this.a.notifyDataSetChanged();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(0);
            SelectTopicToolItem selectTopicToolItem = new SelectTopicToolItem(getContext());
            this.e = selectTopicToolItem;
            selectTopicToolItem.setIsAddTopicItem();
            this.e.setOnClickListener(new b(this));
            addView(this.e);
            this.f = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds1), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
            layoutParams.gravity = 16;
            addView(this.f, layoutParams);
            RecyclerView recyclerView = new RecyclerView(getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            recyclerView.setFadingEdgeLength(0);
            recyclerView.setOverScrollMode(2);
            c cVar = new c(this);
            this.a = cVar;
            recyclerView.setAdapter(cVar);
            recyclerView.setClipChildren(false);
            recyclerView.setClipToPadding(false);
            recyclerView.setHorizontalFadingEdgeEnabled(true);
            recyclerView.setFadingEdgeLength(UtilHelper.getDimenPixelSize(R.dimen.tbds70));
            addView(recyclerView);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.d();
            this.a.notifyDataSetChanged();
            gs4.d(this.f).f(R.color.CAM_X0401);
            gs4.d(this).f(R.color.CAM_X0201);
        }
    }

    public int getmFromType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : invokeV.intValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.e.setVisibility(z ? 0 : 8);
        }
    }

    public void setOpenTopicLayoutListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.g = eVar;
        }
    }

    public void setSelectTopicId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.d = j;
            for (int i = 0; i < this.b.size(); i++) {
                t37 t37Var = this.b.get(i);
                if (t37Var != null) {
                    t37Var.m(j == t37Var.d().longValue());
                }
            }
            RecyclerView.Adapter<d> adapter = this.a;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    public void setmFromType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.c = i;
            if (i == 1) {
                this.e.setPadding(0, mi.f(getContext(), R.dimen.M_H_X005), 0, mi.f(getContext(), R.dimen.M_H_X007));
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.h = new a(this);
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicToolBar(Context context, AttributeSet attributeSet, int i) {
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
        this.b = new ArrayList();
        this.h = new a(this);
        f();
    }
}
