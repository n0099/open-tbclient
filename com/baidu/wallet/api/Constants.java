package com.baidu.wallet.api;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
/* loaded from: classes11.dex */
public final class Constants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BDL_KEY_BANKINFO_EXTRA = "baidu.wallet.listbankcard.extra";
    public static final String BDL_KEY_BINDCARD_EXTRA = "baidu.wallet.bindcard.extra";
    public static final String BDL_KEY_BINDCATEGORY = "baidu.wallet.bindcard.category";
    public static final String BDL_KEY_BINDFORPWD = "baidu.wallet.bindcard.pwd";
    public static final String BDL_KEY_BIZTYPE = "baidu.wallet.lightapp.biztype";
    public static final String BDL_KEY_FROM = "baidu.wallet.from";
    public static final int BIZ_RN_AUTH = 12;
    public static final int BIZ_UNBIND_CARD = 11;
    public static final int CHECK_PWD_CANCLE = 2;
    public static final int CHECK_PWD_NO_PWD = 1;
    public static final int CHECK_PWD_OTHER_ERROR = 3;
    public static final int CHECK_PWD_SUCCESS = 0;
    public static final float DISABLE_ALPHA_VALUE = 0.4f;
    public static final String EVT_CLOSE = "QRScanCodeActivity.evt_close";
    public static final int FAILED = -1;
    public static final String HALF_SCREEN_PWD_VERIFY = "half_screen_pwd_verify";
    public static final String INTERFACE_ID_KEY = "interface_id";
    public static final String JUMP_URL = "jump_url";
    public static final String KEY_CREATE_TIME_STAMP = "createTime";
    public static final String KEY_HAS_NEW_BALANCE = "hasNewBalance";
    public static final String KEY_ORDERINFO_DESCARRAY = "orderInfoDescArray";
    public static final String KEY_OUTER_RESPONSE = "response_data";
    public static final String KEY_OUTER_SERVICEID = "service_id";
    public static final String KEY_REMOTE_APP_NAME = "key_remote_app_name";
    public static final String KEY_REMOTE_PKG_NAME = "key_remote_pkg_name";
    public static final String KEY_REMOTE_PKG_VER = "key_remote_pkg_ver";
    public static final String KEY_REMOTE_WHERE_TO_BACK = "key_remote_where_to_back";
    public static final String LONG_TITLE = "long_title";
    public static final String NO = "0";
    public static final String ONLY_ICONS = "only_icons";
    public static final String ORDERTYPE_FLAG = "order_type";
    public static final String ORDER_LIST_TITLE = "order_list_title";
    public static final int PAY_STATUS_CANCEL = 2;
    public static final int PAY_STATUS_ERROR = 6;
    public static final int PAY_STATUS_LOGIN_ERROR = 5;
    public static final int PAY_STATUS_NOSUPPORT = 3;
    public static final int PAY_STATUS_PAYING = 1;
    public static final int PAY_STATUS_SUCCESS = 0;
    public static final int PAY_STATUS_TOKEN_INVALID = 4;
    public static final int SUCCESS = 0;
    public static final String TOKEN_VALUE_KEY = "tokenValue";
    public static final String USER_TYPE_KEY = "userType";
    public static String WALLET_VERSION_NO = null;
    public static final String YES = "1";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class InterfaceId {
        public static final /* synthetic */ InterfaceId[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final InterfaceId accessWalletService;
        public static final InterfaceId directCallThirdPay;
        public static final InterfaceId doNFCBusCardCharge;
        public static final InterfaceId doPay;
        public static final InterfaceId doRemotePay;
        public static final InterfaceId init;
        public static final InterfaceId initWallet;
        public static final InterfaceId lbsPayWallet;
        public static final InterfaceId startWallet;
        public static final InterfaceId walletBindCard;
        public static final InterfaceId walletScanCode;
        public static final InterfaceId walletTraffic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(75610649, "Lcom/baidu/wallet/api/Constants$InterfaceId;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(75610649, "Lcom/baidu/wallet/api/Constants$InterfaceId;");
                    return;
                }
            }
            init = new InterfaceId("init", 0);
            startWallet = new InterfaceId("startWallet", 1);
            initWallet = new InterfaceId("initWallet", 2);
            doPay = new InterfaceId("doPay", 3);
            doRemotePay = new InterfaceId("doRemotePay", 4);
            accessWalletService = new InterfaceId(LightappBusinessClient.METHOD_ACCESS_WALLET_SERVICE, 5);
            lbsPayWallet = new InterfaceId("lbsPayWallet", 6);
            doNFCBusCardCharge = new InterfaceId("doNFCBusCardCharge", 7);
            directCallThirdPay = new InterfaceId("directCallThirdPay", 8);
            walletScanCode = new InterfaceId("walletScanCode", 9);
            walletTraffic = new InterfaceId("walletTraffic", 10);
            InterfaceId interfaceId = new InterfaceId("walletBindCard", 11);
            walletBindCard = interfaceId;
            $VALUES = new InterfaceId[]{init, startWallet, initWallet, doPay, doRemotePay, accessWalletService, lbsPayWallet, doNFCBusCardCharge, directCallThirdPay, walletScanCode, walletTraffic, interfaceId};
        }

        public InterfaceId(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static InterfaceId valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (InterfaceId) Enum.valueOf(InterfaceId.class, str) : (InterfaceId) invokeL.objValue;
        }

        public static InterfaceId[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (InterfaceId[]) $VALUES.clone() : (InterfaceId[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(883164809, "Lcom/baidu/wallet/api/Constants;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(883164809, "Lcom/baidu/wallet/api/Constants;");
                return;
            }
        }
        WALLET_VERSION_NO = BeanConstants.VERSION_NO;
    }

    public Constants() {
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
