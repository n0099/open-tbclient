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
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.base.core.uilist.BaseViewHolder;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class nq8<ChildItemData extends BaseItem<? extends TbBaseMsg>, ChildViewHolder extends BaseViewHolder> extends ci<ChildItemData, ChildViewHolder> implements qq8<ChildItemData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final sq8 a;
    @Nullable
    public oq8<BaseItem<? extends TbBaseMsg>> b;
    @Nullable
    public oq8<ChildItemData> c;
    @Nullable
    public pq8<BaseItem<? extends TbBaseMsg>> d;
    @Nullable
    public pq8<ChildItemData> e;
    @Nullable
    public View.OnTouchListener f;
    @Nullable
    public qq8<ChildItemData> g;
    @Nullable
    public lq8 h;
    @Nullable
    public kq8 i;
    @Nullable
    public rq8 j;
    @Nullable
    public c k;

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<nq8> a;
        @NonNull
        public final Handler b;
        @Nullable
        public HandlerThread c;

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
                    UiUtils.post(this.a);
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
            this.c = handlerThread;
            handlerThread.start();
            this.b = new Handler(this.c.getLooper());
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
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (handlerThread = this.c) != null) {
                handlerThread.quit();
                this.c = null;
            }
        }

        public List<ci> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return new ArrayList(this.a);
            }
            return (List) invokeV.objValue;
        }

        public void a(@NonNull nq8 nq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq8Var) == null) {
                nq8Var.A(this);
                this.a.add(nq8Var);
            }
        }

        public void f(@Nullable rq8 rq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, rq8Var) == null) {
                for (nq8 nq8Var : this.a) {
                    nq8Var.L(rq8Var);
                }
            }
        }

        public void d(@NonNull Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, runnable, j) == null) {
                if (j <= 0) {
                    UiUtils.post(runnable);
                } else {
                    this.b.postDelayed(new a(this, runnable), j);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseViewHolder a;
        public final /* synthetic */ nq8 b;

        public a(nq8 nq8Var, BaseViewHolder baseViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nq8Var, baseViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nq8Var;
            this.a = baseViewHolder;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.baidu.tieba.oq8 */
        /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.oq8 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                try {
                    int adapterPosition = this.a.getAdapterPosition();
                    pi item = this.b.getItem(adapterPosition);
                    if (item == null) {
                        return;
                    }
                    if (this.b.b != null) {
                        this.b.b.a(view2, (BaseItem) item, adapterPosition);
                    }
                    if (this.b.c != null) {
                        this.b.c.a(view2, (BaseItem) item, adapterPosition);
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
        public final /* synthetic */ nq8 b;

        public b(nq8 nq8Var, BaseViewHolder baseViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nq8Var, baseViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nq8Var;
            this.a = baseViewHolder;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.pq8 */
        /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.pq8 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                int adapterPosition = this.a.getAdapterPosition();
                pi item = this.b.getItem(adapterPosition);
                boolean z = false;
                if (item == null) {
                    return false;
                }
                if (this.b.d != null) {
                    z = this.b.d.a(view2, (BaseItem) item, adapterPosition);
                }
                if (!z && this.b.e != null) {
                    return this.b.e.a(view2, (BaseItem) item, adapterPosition);
                }
                return z;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nq8(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
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
        this.a = new sq8();
    }

    public final void A(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.k = cVar;
        }
    }

    public void K(ChildViewHolder childviewholder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, childviewholder) == null) {
            childviewholder.d(this.a);
            childviewholder.getView().setOnTouchListener(this.f);
            childviewholder.a(new a(this, childviewholder));
            childviewholder.b(new b(this, childviewholder));
        }
    }

    public void L(@Nullable rq8 rq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rq8Var) == null) {
            this.j = rq8Var;
        }
    }

    @Override // com.baidu.tieba.qq8
    public void onEvent(@NonNull ChildItemData childitemdata) {
        qq8<ChildItemData> qq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, childitemdata) == null) && (qq8Var = this.g) != null) {
            qq8Var.onEvent(childitemdata);
        }
    }

    public void H(@Nullable lq8 lq8Var, @Nullable kq8 kq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, lq8Var, kq8Var) == null) {
            this.h = lq8Var;
            this.i = kq8Var;
        }
    }

    public void I(@Nullable oq8<BaseItem<? extends TbBaseMsg>> oq8Var, @Nullable oq8<ChildItemData> oq8Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oq8Var, oq8Var2) == null) {
            this.b = oq8Var;
            this.c = oq8Var2;
        }
    }

    public void J(@Nullable pq8<BaseItem<? extends TbBaseMsg>> pq8Var, @Nullable pq8<ChildItemData> pq8Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, pq8Var, pq8Var2) == null) {
            this.d = pq8Var;
            this.e = pq8Var2;
        }
    }

    @Nullable
    public kq8 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.i;
        }
        return (kq8) invokeV.objValue;
    }

    @Nullable
    public lq8 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (lq8) invokeV.objValue;
    }

    @NonNull
    public Context D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    @Nullable
    public rq8 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (rq8) invokeV.objValue;
    }

    @NonNull
    public c G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            gu5.c(this.k, "请先绑定适配器帮助类");
            return this.k;
        }
        return (c) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: F */
    public void onFillViewHolder(int i, ViewGroup viewGroup, ChildViewHolder childviewholder, ChildItemData childitemdata, @NonNull List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), viewGroup, childviewholder, childitemdata, list}) == null) {
            super.onFillViewHolder(i, viewGroup, (ViewGroup) childviewholder, (ChildViewHolder) childitemdata, list);
            childitemdata.setItemEventCallback(this);
        }
    }
}
