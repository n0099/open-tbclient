package com.baidu.tieba.play.cyberPlayer;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class TbVideoViewSet {
    public static /* synthetic */ Interceptable $ic;
    public static TbVideoViewSet c;
    public transient /* synthetic */ FieldHolder $fh;
    public LRULinkedHashMap<String, TbVideoViewContainer> a;
    public boolean b;

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1742074889, "Lcom/baidu/tieba/play/cyberPlayer/TbVideoViewSet;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1742074889, "Lcom/baidu/tieba/play/cyberPlayer/TbVideoViewSet;");
        }
    }

    /* loaded from: classes5.dex */
    public class LRULinkedHashMap<K extends String, V> extends LinkedHashMap<K, TbVideoViewContainer> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MAX_PLAYERS = 3;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbVideoViewSet this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LRULinkedHashMap(TbVideoViewSet tbVideoViewSet) {
            super(3, 0.75f, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbVideoViewSet};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue(), ((Boolean) objArr2[2]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tbVideoViewSet;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, TbVideoViewContainer> entry) {
            InterceptResult invokeL;
            boolean z;
            TbVideoViewContainer value;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, entry)) == null) {
                if (size() > 3) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (value = entry.getValue()) != null) {
                    this.this$0.b = true;
                    value.getControl().stopPlayback();
                    this.this$0.b = false;
                }
                return z;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbVideoViewSet tbVideoViewSet, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbVideoViewSet, Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean)) {
                ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    public TbVideoViewSet() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LRULinkedHashMap<>(this);
        MessageManager.getInstance().registerListener(new a(this, 2001011));
    }

    public TbVideoViewContainer d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!xi.isEmpty(str) && this.a.containsKey(str)) {
                return this.a.get(str);
            }
            return null;
        }
        return (TbVideoViewContainer) invokeL.objValue;
    }

    public void e(String str) {
        TbVideoViewContainer remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !this.b && this.a.containsKey(str) && (remove = this.a.remove(str)) != null) {
            remove.getControl().stopPlayback();
        }
    }

    public static TbVideoViewSet c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (c == null) {
                synchronized (TbVideoViewSet.class) {
                    if (c == null) {
                        c = new TbVideoViewSet();
                    }
                }
            }
            return c;
        }
        return (TbVideoViewSet) invokeV.objValue;
    }

    public void f(TbVideoViewContainer tbVideoViewContainer, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbVideoViewContainer, str) == null) {
            if (this.a.containsKey(str) && tbVideoViewContainer != this.a.get(str)) {
                TbVideoViewContainer tbVideoViewContainer2 = this.a.get(str);
                if (tbVideoViewContainer2 != null && tbVideoViewContainer2.getControl().isPlaying()) {
                    tbVideoViewContainer2.getControl().stopPlayback();
                }
            } else if (this.a.containsValue(tbVideoViewContainer)) {
                String str2 = null;
                Iterator it = this.a.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (entry.getValue() == tbVideoViewContainer) {
                        str2 = (String) entry.getKey();
                        break;
                    }
                }
                if (!this.b && !xi.isEmpty(str2)) {
                    this.a.remove(str2);
                }
            }
            this.a.put(str, tbVideoViewContainer);
            if (tbVideoViewContainer != null) {
                Context context = tbVideoViewContainer.getContext();
                if (context instanceof LifecycleOwner) {
                    ((LifecycleOwner) context).getLifecycle().addObserver(new LifecycleObserver(this, str) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ String a;
                        public final /* synthetic */ TbVideoViewSet b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.b = this;
                            this.a = str;
                        }

                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        private void onDestroy() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                                this.b.a.remove(this.a);
                            }
                        }
                    });
                }
            }
        }
    }
}
