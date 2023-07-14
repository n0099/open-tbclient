package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tbadk.switchs.FunnySpriteSwitch;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes7.dex */
public class o8a implements k75 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947987505, "Lcom/baidu/tieba/o8a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947987505, "Lcom/baidu/tieba/o8a;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(o8a o8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o8aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !o8a.a) {
                try {
                    Class.forName("com.baidu.tieba.homepage.framework.RecommendFrsStatic");
                } catch (Exception e) {
                    BdLog.i(e.getMessage());
                }
                DefaultLog.getInstance().c("SpriteTip", "展示动画时首次请求");
                mo5.i(1);
                boolean unused = o8a.a = true;
            }
        }
    }

    public o8a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.k75
    @NonNull
    public Map<String, Object> a(@NonNull DialogStrategiesData dialogStrategiesData, @NonNull Map<String, Object> map, @NonNull Map<String, Object> map2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dialogStrategiesData, map, map2)) == null) {
            HashMap hashMap = new HashMap(map);
            hashMap.putAll(map2);
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.k75
    public boolean b(@NonNull Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                YunDialogLog.getInstance().b("SpriteStrategy", "未登录状态");
                return false;
            } else if (!FunnySpriteSwitch.isOn()) {
                YunDialogLog.getInstance().b("SpriteStrategy", "精灵开关未打开");
                return false;
            } else {
                Object obj = map.get("use_hot");
                if (obj != null && "1".equals(obj.toString())) {
                    Object obj2 = map.get("dialog_url");
                    if (obj2 instanceof String) {
                        String str = (String) obj2;
                        if (!TextUtils.isEmpty(str) && !a06.b().e(str)) {
                            YunDialogLog.getInstance().b("SpriteStrategy", "H5弹窗未预热完成");
                            return false;
                        }
                    }
                }
                if (!FunnySpriteResDownloadUtil.k().invoke().booleanValue()) {
                    YunDialogLog.getInstance().b("SpriteStrategy", "资源未下载完成");
                    return false;
                }
                Object obj3 = map.get("use_offline");
                if (obj3 != null && "1".equals(obj3.toString())) {
                    Object obj4 = map.get("dialog_url");
                    if (obj4 instanceof String) {
                        String str2 = (String) obj4;
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                Object obj5 = map.get("module");
                                h29 yunDialogLog = YunDialogLog.getInstance();
                                yunDialogLog.c("SpriteStrategy", "开始手动初始化离线包:" + obj5);
                                if ((obj5 instanceof String) && !TextUtils.isEmpty((String) obj5)) {
                                    HashSet hashSet = new HashSet();
                                    hashSet.add((String) obj5);
                                    wz4.d(hashSet);
                                    h29 yunDialogLog2 = YunDialogLog.getInstance();
                                    yunDialogLog2.c("SpriteStrategy", "离线包手动初始化完成:" + obj5);
                                }
                            } catch (Exception e) {
                                h29 yunDialogLog3 = YunDialogLog.getInstance();
                                yunDialogLog3.b("SpriteStrategy", "离线包手动初始化异常:" + e);
                            }
                            boolean c = wz4.c(str2);
                            h29 yunDialogLog4 = YunDialogLog.getInstance();
                            yunDialogLog4.b("SpriteStrategy", "离线包是否可用:" + c);
                            if (!c) {
                                YunDialogLog.getInstance().b("SpriteStrategy", "离线包未下载完成");
                                return false;
                            }
                        }
                    }
                }
                lu6.b().b(new n7a());
                TbSingleton.getInstance().isShowSpriteDialog = true;
                zg.a().post(new a(this));
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
