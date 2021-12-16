package com.baidu.wallet.base.iddetect;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public final class UrlOcrConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes13.dex */
    public class IdCardKey {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String ADDRESS = "address";
        public static final String BIRTH = "birth";
        public static final String IDCARD_NO = "id_card";
        public static final String IDCARD_PIC = "idcard_picture";
        public static final String IMEI = "imei";
        public static final String METHODDATA = "methoddata";
        public static final String MSG = "msg";
        public static final String NAME = "name";
        public static final String NATION = "nation";
        public static final String OS = "os";
        public static final String OS_BRAND = "brand";
        public static final String OS_MODEL = "model";
        public static final String OS_VERSION = "osversion";
        public static final String RESULT = "result";
        public static final String SEX = "sex";
        public static final String STATUS = "status";
        public static final String UUID = "uuid";
        public static final String VERSION_CODE = "appversioncode";
        public static final String VERSION_NAME = "appversionname";
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlOcrConfig this$0;

        public IdCardKey(UrlOcrConfig urlOcrConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlOcrConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = urlOcrConfig;
        }
    }

    public UrlOcrConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
