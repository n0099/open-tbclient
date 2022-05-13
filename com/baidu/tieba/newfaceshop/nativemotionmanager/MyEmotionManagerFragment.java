package com.baidu.tieba.newfaceshop.nativemotionmanager;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.ao7;
import com.repackage.ki;
import com.repackage.ng;
import com.repackage.po7;
import com.repackage.ro7;
import com.repackage.uo7;
import com.repackage.yn7;
import com.repackage.yo7;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MyEmotionManagerFragment extends BaseFragment implements uo7<Pair<List<EmotionPackageData>, Integer>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yo7 a;
    public MyEmotionManagerModel b;
    public ro7 c;
    public CustomMessageListener d;
    public CustomMessageListener e;
    public CustomMessageListener f;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyEmotionManagerFragment a;

        /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0211a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;
            public final /* synthetic */ a b;

            public RunnableC0211a(a aVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String valueOf = String.valueOf(this.a.getData());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(valueOf);
                    if (!ao7.i().c(arrayList, true) || !ki.z()) {
                        if (this.b.a.b != null) {
                            this.b.a.b.K();
                        }
                    } else if (this.b.a.b != null) {
                        this.b.a.b.loadData();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MyEmotionManagerFragment myEmotionManagerFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerFragment, Integer.valueOf(i)};
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
            this.a = myEmotionManagerFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                yn7.b().a(new RunnableC0211a(this, customResponsedMessage));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyEmotionManagerFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MyEmotionManagerFragment myEmotionManagerFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerFragment, Integer.valueOf(i)};
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
            this.a = myEmotionManagerFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.b == null) {
                return;
            }
            this.a.b.loadData();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyEmotionManagerFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MyEmotionManagerFragment myEmotionManagerFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerFragment, Integer.valueOf(i)};
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
            this.a = myEmotionManagerFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.b == null) {
                return;
            }
            this.a.b.O();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Pair a;
        public final /* synthetic */ MyEmotionManagerFragment b;

        public d(MyEmotionManagerFragment myEmotionManagerFragment, Pair pair) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerFragment, pair};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = myEmotionManagerFragment;
            this.a = pair;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
                return;
            }
            if (this.b.a != null) {
                this.b.a.update((List) this.a.first);
                this.b.a.e();
            }
            if (this.b.c == null || (obj = this.a.second) == null) {
                return;
            }
            this.b.G0(((Integer) obj).intValue() > 0);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MyEmotionManagerFragment a;

        public e(MyEmotionManagerFragment myEmotionManagerFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionManagerFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myEmotionManagerFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.a != null) {
                    this.a.a.m();
                }
                if (this.a.c != null) {
                    this.a.G0(false);
                }
            }
        }
    }

    public MyEmotionManagerFragment() {
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
        this.d = new a(this, 2921311);
        this.e = new b(this, 2921054);
        this.f = new c(this, 2921310);
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.loadData();
        }
    }

    public void G0(boolean z) {
        ro7 ro7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (ro7Var = this.c) == null) {
            return;
        }
        ro7Var.onUpdate(Boolean.valueOf(z));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uo7
    /* renamed from: H0 */
    public void onSuccess(Pair<List<EmotionPackageData>, Integer> pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pair) == null) {
            ng.a().post(new d(this, pair));
        }
    }

    public void I0(ro7 ro7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ro7Var) == null) || ro7Var == null) {
            return;
        }
        this.c = ro7Var;
    }

    @Override // com.repackage.uo7
    public void c0() {
        yo7 yo7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (yo7Var = this.a) == null) {
            return;
        }
        yo7Var.h();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            yo7 yo7Var = this.a;
            if (yo7Var != null) {
                yo7Var.g(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            po7.b().c();
            registerListener(this.e);
            registerListener(this.f);
            registerListener(this.d);
            this.a = new yo7(getPageContext());
            MyEmotionManagerModel myEmotionManagerModel = new MyEmotionManagerModel(getPageContext());
            this.b = myEmotionManagerModel;
            myEmotionManagerModel.Q(this);
            return this.a.c();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            MyEmotionManagerModel myEmotionManagerModel = this.b;
            if (myEmotionManagerModel != null) {
                myEmotionManagerModel.L();
            }
            if (this.e != null) {
                MessageManager.getInstance().unRegisterListener(this.e);
            }
            if (this.f != null) {
                MessageManager.getInstance().unRegisterListener(this.f);
            }
            if (this.d != null) {
                MessageManager.getInstance().unRegisterListener(this.d);
            }
        }
    }

    @Override // com.repackage.uo7
    public void onFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ng.a().post(new e(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            F0();
        }
    }
}
