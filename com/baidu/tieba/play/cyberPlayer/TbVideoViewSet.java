package com.baidu.tieba.play.cyberPlayer;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class TbVideoViewSet {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static TbVideoViewSet f20426c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LRULinkedHashMap<String, TbCyberVideoView> f20427a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f20428b;

    /* loaded from: classes4.dex */
    public class LRULinkedHashMap<K extends String, V> extends LinkedHashMap<K, TbCyberVideoView> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public boolean removeEldestEntry(Map.Entry<K, TbCyberVideoView> entry) {
            InterceptResult invokeL;
            TbCyberVideoView value;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, entry)) == null) {
                boolean z = size() > 3;
                if (z && (value = entry.getValue()) != null) {
                    this.this$0.f20428b = true;
                    value.stopPlayback();
                    this.this$0.f20428b = false;
                }
                return z;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbVideoViewSet f20429a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbVideoViewSet tbVideoViewSet, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbVideoViewSet, Integer.valueOf(i2)};
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
            this.f20429a = tbVideoViewSet;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f20429a.c();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    public TbVideoViewSet() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20427a = new LRULinkedHashMap<>(this);
        MessageManager.getInstance().registerListener(new a(this, 2001011));
    }

    public static TbVideoViewSet d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f20426c == null) {
                synchronized (TbVideoViewSet.class) {
                    if (f20426c == null) {
                        f20426c = new TbVideoViewSet();
                    }
                }
            }
            return f20426c;
        }
        return (TbVideoViewSet) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator it = this.f20427a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (entry != null) {
                    TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) entry.getValue();
                    if (tbCyberVideoView != null) {
                        this.f20428b = true;
                        tbCyberVideoView.stopPlayback();
                        this.f20428b = false;
                    }
                    it.remove();
                }
            }
        }
    }

    public TbCyberVideoView e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (k.isEmpty(str) || !this.f20427a.containsKey(str)) {
                return null;
            }
            return this.f20427a.get(str);
        }
        return (TbCyberVideoView) invokeL.objValue;
    }

    public void f(String str) {
        TbCyberVideoView remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f20428b || !this.f20427a.containsKey(str) || (remove = this.f20427a.remove(str)) == null) {
            return;
        }
        remove.stopPlayback();
    }

    public void g(TbCyberVideoView tbCyberVideoView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, tbCyberVideoView, str) == null) {
            if (this.f20427a.containsKey(str) && tbCyberVideoView != this.f20427a.get(str)) {
                TbCyberVideoView tbCyberVideoView2 = this.f20427a.get(str);
                if (tbCyberVideoView2 != null && tbCyberVideoView2.isPlaying()) {
                    tbCyberVideoView2.stopPlayback();
                }
            } else if (this.f20427a.containsValue(tbCyberVideoView)) {
                String str2 = null;
                Iterator it = this.f20427a.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (entry.getValue() == tbCyberVideoView) {
                        str2 = (String) entry.getKey();
                        break;
                    }
                }
                if (!this.f20428b && !k.isEmpty(str2)) {
                    this.f20427a.remove(str2);
                }
            }
            this.f20427a.put(str, tbCyberVideoView);
        }
    }
}
