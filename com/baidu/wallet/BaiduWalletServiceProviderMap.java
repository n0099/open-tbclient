package com.baidu.wallet;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletServiceBeanConst;
import com.baidu.wallet.core.NoProguard;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class BaiduWalletServiceProviderMap implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PLUGIN_FASTPAY = "fastpay";
    public static final String PLUGIN_LANGBRIGE = "langbrige";
    public static final String PLUGIN_NFC = "nfc";
    public static final String PLUGIN_PERSONAL = "personal";
    public static final String PLUGIN_QRCODESCANNER = "saoyisao";
    public static final String PLUGIN_TAB = "tab";
    public static final String PLUGIN_TRNASFER = "transfer";
    public static final String PLUGIN_WALLETHOME = "home";
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Long, String> maps;

    /* renamed from: com.baidu.wallet.BaiduWalletServiceProviderMap$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final BaiduWalletServiceProviderMap a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1410633404, "Lcom/baidu/wallet/BaiduWalletServiceProviderMap$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1410633404, "Lcom/baidu/wallet/BaiduWalletServiceProviderMap$a;");
                    return;
                }
            }
            a = new BaiduWalletServiceProviderMap(null);
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public /* synthetic */ BaiduWalletServiceProviderMap(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static final BaiduWalletServiceProviderMap getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (BaiduWalletServiceProviderMap) invokeV.objValue;
    }

    private void initMaps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.maps.put(1L, "fastpay");
            this.maps.put(4096L, "fastpay");
            this.maps.put(2L, "transfer");
            this.maps.put(64L, "personal");
            this.maps.put(1024L, "nfc");
            this.maps.put(32768L, "saoyisao");
            this.maps.put(16384L, "home");
            this.maps.put(Long.valueOf((long) WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_CREDIT), "home");
            this.maps.put(Long.valueOf((long) WalletServiceBeanConst.SERVICE_ID_WALLET_NFC_BUS_CARD_SETTING), "nfc");
            this.maps.put(Long.valueOf((long) WalletServiceBeanConst.SERVICE_ID_WALLET_LANGBRIGE), "langbrige");
            this.maps.put(Long.valueOf((long) WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_FINANCE), "tab");
        }
    }

    public void addDatas(Map<Long, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            if (this.maps == null) {
                this.maps = new HashMap();
            }
            this.maps.putAll(map);
        }
    }

    public String getProviderNameBySerID(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            Map<Long, String> map = this.maps;
            return (map == null || map.size() <= 0) ? "" : this.maps.get(Long.valueOf(j2));
        }
        return (String) invokeJ.objValue;
    }

    public BaiduWalletServiceProviderMap() {
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
        this.maps = new HashMap();
        initMaps();
    }
}
