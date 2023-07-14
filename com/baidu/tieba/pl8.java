package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class pl8<ChildItemData extends BaseMsg, ChildViewHolder extends BaseViewHolder> extends ln<ChildItemData, ChildViewHolder> implements tl8<ChildItemData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public rl8<BaseMsg> a;
    @Nullable
    public rl8<ChildItemData> b;
    @Nullable
    public sl8<BaseMsg> c;
    @Nullable
    public sl8<ChildItemData> d;
    @Nullable
    public View.OnTouchListener e;
    @Nullable
    public tl8<ChildItemData> f;
    @Nullable
    public ml8 g;
    @Nullable
    public ll8 h;
    @NonNull
    public final vl8 i;
    @Nullable
    public c j;

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<pl8> a;
        @Nullable
        public HandlerThread b;
        @NonNull
        public final Handler c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Runnable a;

            public a(c cVar, Runnable runnable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, runnable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    dh.c(this.a);
                }
            }
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ArrayList();
            HandlerThread handlerThread = new HandlerThread("ChatAdapterFrame");
            this.b = handlerThread;
            handlerThread.start();
            this.c = new Handler(this.b.getLooper());
        }

        @NonNull
        public static c b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return new c();
            }
            return (c) invokeV.objValue;
        }

        public void c() {
            HandlerThread handlerThread;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (handlerThread = this.b) != null) {
                handlerThread.quit();
                this.b = null;
            }
        }

        public List<ln> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return new ArrayList(this.a);
            }
            return (List) invokeV.objValue;
        }

        public void a(@NonNull pl8 pl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pl8Var) == null) {
                pl8Var.z(this);
                this.a.add(pl8Var);
            }
        }

        public void f(@Nullable View.OnTouchListener onTouchListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, onTouchListener) == null) {
                for (pl8 pl8Var : this.a) {
                    pl8Var.I(onTouchListener);
                }
            }
        }

        public void d(@NonNull Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, runnable, j) == null) {
                if (j <= 0) {
                    dh.c(runnable);
                } else {
                    this.c.postDelayed(new a(this, runnable), j);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseViewHolder a;
        public final /* synthetic */ pl8 b;

        public a(pl8 pl8Var, BaseViewHolder baseViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pl8Var, baseViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pl8Var;
            this.a = baseViewHolder;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.baidu.tieba.rl8 */
        /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.rl8 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                try {
                    int adapterPosition = this.a.getAdapterPosition();
                    yn item = this.b.getItem(adapterPosition);
                    if (item == null) {
                        return;
                    }
                    if (this.b.a != null) {
                        this.b.a.a(view2, (BaseMsg) item, adapterPosition);
                    }
                    if (this.b.b != null) {
                        this.b.b.a(view2, (BaseMsg) item, adapterPosition);
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseViewHolder a;
        public final /* synthetic */ pl8 b;

        public b(pl8 pl8Var, BaseViewHolder baseViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pl8Var, baseViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pl8Var;
            this.a = baseViewHolder;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.sl8 */
        /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.sl8 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                int adapterPosition = this.a.getAdapterPosition();
                yn item = this.b.getItem(adapterPosition);
                boolean z = false;
                if (item == null) {
                    return false;
                }
                if (this.b.c != null) {
                    z = this.b.c.a(view2, (BaseMsg) item, adapterPosition);
                }
                if (!z && this.b.d != null) {
                    return this.b.d.a(view2, (BaseMsg) item, adapterPosition);
                }
                return z;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pl8(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new vl8();
    }

    public void H(ChildViewHolder childviewholder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, childviewholder) == null) {
            childviewholder.e(this.i);
            childviewholder.getView().setOnTouchListener(this.e);
            childviewholder.b(new a(this, childviewholder));
            childviewholder.c(new b(this, childviewholder));
        }
    }

    public void I(@Nullable View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onTouchListener) == null) {
            this.e = onTouchListener;
        }
    }

    @Override // com.baidu.tieba.tl8
    public void onEvent(@NonNull ChildItemData childitemdata) {
        tl8<ChildItemData> tl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, childitemdata) == null) && (tl8Var = this.f) != null) {
            tl8Var.onEvent(childitemdata);
        }
    }

    public final void z(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public void E(@Nullable ml8 ml8Var, @Nullable ll8 ll8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, ml8Var, ll8Var) == null) {
            this.g = ml8Var;
            this.h = ll8Var;
        }
    }

    public void F(@Nullable rl8<BaseMsg> rl8Var, @Nullable rl8<ChildItemData> rl8Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, rl8Var, rl8Var2) == null) {
            this.a = rl8Var;
            this.b = rl8Var2;
        }
    }

    public void G(@Nullable sl8<BaseMsg> sl8Var, @Nullable sl8<ChildItemData> sl8Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, sl8Var, sl8Var2) == null) {
            this.c = sl8Var;
            this.d = sl8Var2;
        }
    }

    @Nullable
    public ll8 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (ll8) invokeV.objValue;
    }

    @Nullable
    public ml8 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (ml8) invokeV.objValue;
    }

    @NonNull
    public c D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            py5.c(this.j, "请先绑定适配器帮助类");
            return this.j;
        }
        return (c) invokeV.objValue;
    }

    @NonNull
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: C */
    public void onFillViewHolder(int i, ViewGroup viewGroup, ChildViewHolder childviewholder, ChildItemData childitemdata, @NonNull List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, childviewholder, childitemdata, list}) == null) {
            super.onFillViewHolder(i, viewGroup, (ViewGroup) childviewholder, (ChildViewHolder) childitemdata, list);
            childitemdata.setItemEventCallback(this);
        }
    }
}
