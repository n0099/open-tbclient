package com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ho8;
import com.baidu.tieba.io8;
import com.baidu.tieba.js8;
import com.baidu.tieba.ks8;
import com.baidu.tieba.ls8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TagAdapter extends RecyclerView.Adapter<BaseTagItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ks8 a;
    public final js8 b;
    public final Context c;
    public RecyclerView d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class c extends BaseTagItemViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a extends ViewGroup {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.ViewGroup, android.view.View
            public void onLayout(boolean z, int i, int i2, int i3, int i4) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context) {
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
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(new a(context));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
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
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ls8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TagAdapter a;

        public b(TagAdapter tagAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tagAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tagAdapter;
        }

        public /* synthetic */ b(TagAdapter tagAdapter, a aVar) {
            this(tagAdapter);
        }

        @Override // com.baidu.tieba.ls8
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && i >= 0 && i2 > 0) {
                this.a.notifyItemRangeRemoved(i, i2);
            }
        }

        @Override // com.baidu.tieba.ls8
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && i >= 0 && i2 > 0) {
                this.a.notifyItemRangeInserted(i, i2);
            }
        }

        @Override // com.baidu.tieba.ls8
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) && i >= 0 && i2 > 0) {
                this.a.notifyItemRangeChanged(i, i2);
            }
        }
    }

    public TagAdapter(ks8 ks8Var, js8 js8Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ks8Var, js8Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ks8Var;
        this.c = context;
        this.b = js8Var;
        this.b.l(new b(this, null));
        this.a.a(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.e();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i >= 0 && i < this.b.e()) {
                return this.b.f().get(i).a();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onViewAttachedToWindow(BaseTagItemViewHolder baseTagItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, baseTagItemViewHolder) == null) {
            baseTagItemViewHolder.e(this.d);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onViewDetachedFromWindow(BaseTagItemViewHolder baseTagItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, baseTagItemViewHolder) == null) {
            baseTagItemViewHolder.g(this.d);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, recyclerView) == null) {
            this.d = recyclerView;
            this.b.b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, recyclerView) == null) {
            this.b.c();
            this.d = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onViewRecycled(BaseTagItemViewHolder baseTagItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, baseTagItemViewHolder) == null) {
            baseTagItemViewHolder.k();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(BaseTagItemViewHolder baseTagItemViewHolder, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, baseTagItemViewHolder, i) == null) && i >= 0 && i < this.b.e()) {
            baseTagItemViewHolder.b(this.b.f().get(i), this.c, i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public BaseTagItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            BaseTagItemViewHolder b2 = this.a.b(viewGroup, i);
            if (b2 != null) {
                return b2;
            }
            return new c(viewGroup.getContext());
        }
        return (BaseTagItemViewHolder) invokeLI.objValue;
    }

    public void q(io8 io8Var, ho8 ho8Var) {
        ks8 ks8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, io8Var, ho8Var) == null) && (ks8Var = this.a) != null) {
            ks8Var.d(io8Var);
            this.a.c(ho8Var);
        }
    }
}
