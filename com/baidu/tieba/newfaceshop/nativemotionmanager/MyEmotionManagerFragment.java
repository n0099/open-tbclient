package com.baidu.tieba.newfaceshop.nativemotionmanager;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.e.e.p.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class MyEmotionManagerFragment extends BaseFragment implements c.a.p0.d2.h.e.a.a<Pair<List<EmotionPackageData>, Integer>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.d2.h.f.d f54377e;

    /* renamed from: f  reason: collision with root package name */
    public MyEmotionManagerModel f54378f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.d2.h.c.a f54379g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f54380h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f54381i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f54382j;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerFragment f54383a;

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1773a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f54384e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f54385f;

            public RunnableC1773a(a aVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54385f = aVar;
                this.f54384e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String valueOf = String.valueOf(this.f54384e.getData());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(valueOf);
                    if (!c.a.p0.d2.c.i().c(arrayList, true) || !j.z()) {
                        if (this.f54385f.f54383a.f54378f != null) {
                            this.f54385f.f54383a.f54378f.J();
                        }
                    } else if (this.f54385f.f54383a.f54378f != null) {
                        this.f54385f.f54383a.f54378f.I();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MyEmotionManagerFragment myEmotionManagerFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerFragment, Integer.valueOf(i2)};
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
            this.f54383a = myEmotionManagerFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                c.a.p0.d2.a.b().a(new RunnableC1773a(this, customResponsedMessage));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerFragment f54386a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MyEmotionManagerFragment myEmotionManagerFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerFragment, Integer.valueOf(i2)};
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
            this.f54386a = myEmotionManagerFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f54386a.f54378f == null) {
                return;
            }
            this.f54386a.f54378f.I();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerFragment f54387a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MyEmotionManagerFragment myEmotionManagerFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerFragment, Integer.valueOf(i2)};
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
            this.f54387a = myEmotionManagerFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f54387a.f54378f == null) {
                return;
            }
            this.f54387a.f54378f.N();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Pair f54388e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerFragment f54389f;

        public d(MyEmotionManagerFragment myEmotionManagerFragment, Pair pair) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerFragment, pair};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54389f = myEmotionManagerFragment;
            this.f54388e = pair;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f54388e == null) {
                return;
            }
            if (this.f54389f.f54377e != null) {
                this.f54389f.f54377e.m((List) this.f54388e.first);
                this.f54389f.f54377e.d();
            }
            if (this.f54389f.f54379g == null || (obj = this.f54388e.second) == null) {
                return;
            }
            this.f54389f.isEnableShowEdit(((Integer) obj).intValue() > 0);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MyEmotionManagerFragment f54390e;

        public e(MyEmotionManagerFragment myEmotionManagerFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54390e = myEmotionManagerFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f54390e.f54377e != null) {
                    this.f54390e.f54377e.l();
                }
                if (this.f54390e.f54379g != null) {
                    this.f54390e.isEnableShowEdit(false);
                }
            }
        }
    }

    public MyEmotionManagerFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54380h = new a(this, 2921311);
        this.f54381i = new b(this, 2921054);
        this.f54382j = new c(this, 2921310);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f54378f.I();
        }
    }

    public void isEnableShowEdit(boolean z) {
        c.a.p0.d2.h.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (aVar = this.f54379g) == null) {
            return;
        }
        aVar.onUpdate(Boolean.valueOf(z));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.p0.d2.h.f.d dVar = this.f54377e;
            if (dVar != null) {
                dVar.f(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            c.a.p0.d2.h.a.b().c();
            registerListener(this.f54381i);
            registerListener(this.f54382j);
            registerListener(this.f54380h);
            this.f54377e = new c.a.p0.d2.h.f.d(getPageContext());
            MyEmotionManagerModel myEmotionManagerModel = new MyEmotionManagerModel(getPageContext());
            this.f54378f = myEmotionManagerModel;
            myEmotionManagerModel.P(this);
            return this.f54377e.c();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            MyEmotionManagerModel myEmotionManagerModel = this.f54378f;
            if (myEmotionManagerModel != null) {
                myEmotionManagerModel.K();
            }
            if (this.f54381i != null) {
                MessageManager.getInstance().unRegisterListener(this.f54381i);
            }
            if (this.f54382j != null) {
                MessageManager.getInstance().unRegisterListener(this.f54382j);
            }
            if (this.f54380h != null) {
                MessageManager.getInstance().unRegisterListener(this.f54380h);
            }
        }
    }

    @Override // c.a.p0.d2.h.e.a.a
    public void onFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.e.e.m.e.a().post(new e(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            g();
        }
    }

    @Override // c.a.p0.d2.h.e.a.a
    public void redraw() {
        c.a.p0.d2.h.f.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (dVar = this.f54377e) == null) {
            return;
        }
        dVar.g();
    }

    public void setFragmentManagerListener(c.a.p0.d2.h.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f54379g = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.d2.h.e.a.a
    public void onSuccess(Pair<List<EmotionPackageData>, Integer> pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pair) == null) {
            c.a.e.e.m.e.a().post(new d(this, pair));
        }
    }
}
