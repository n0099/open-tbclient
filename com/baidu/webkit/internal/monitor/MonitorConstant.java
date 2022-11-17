package com.baidu.webkit.internal.monitor;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
/* loaded from: classes7.dex */
public class MonitorConstant implements INoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class KeySectionType implements INoProGuard {
        public static final /* synthetic */ KeySectionType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final KeySectionType DID_FIRST_LAYOUT;
        public static final KeySectionType DID_FIRST_PAINT;
        public static final KeySectionType DID_UNSAFE_PAGE_DETECTED;
        public static final KeySectionType DO_UPDATE_VISITED_HISTORY;
        public static final KeySectionType FIRST_SCREEN_PAINT;
        public static final KeySectionType FIRST_SCREEN_PAINT_COMMIT;
        public static final KeySectionType GET_VISITED_HISTORY;
        public static final KeySectionType HIT_MAGIC_FILTER;
        public static final KeySectionType NEW_HISTORY_ITEM;
        public static final KeySectionType PAGEFINISH;
        public static final KeySectionType PAGESTART;
        public static final KeySectionType PAGE_COMMIT_VISIBLE;
        public static final KeySectionType PROGRESSCHANGED;
        public static final KeySectionType RECEIVED_ERROR;
        public static final KeySectionType RECEIVED_TITLE;
        public static final KeySectionType RESOURCE_BEFORE_REQUEST;
        public static final KeySectionType RESOURCE_HEADERS_RECEIVED;
        public static final KeySectionType RESOURCE_REQUEST_COMPLETED;
        public static final KeySectionType RESTORE_FROM_CACHE;
        public static final KeySectionType SHOULD_INTERCEPT_REQUEST;
        public static final KeySectionType SHOULD_OVERRIDE_URL_LOADING;
        public static final KeySectionType SHOULD_SPECIAL_LOADING;
        public static final KeySectionType START_NAVIGATION;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(650248493, "Lcom/baidu/webkit/internal/monitor/MonitorConstant$KeySectionType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(650248493, "Lcom/baidu/webkit/internal/monitor/MonitorConstant$KeySectionType;");
                    return;
                }
            }
            GET_VISITED_HISTORY = new KeySectionType("GET_VISITED_HISTORY", 0);
            DO_UPDATE_VISITED_HISTORY = new KeySectionType("DO_UPDATE_VISITED_HISTORY", 1);
            RESTORE_FROM_CACHE = new KeySectionType("RESTORE_FROM_CACHE", 2);
            PROGRESSCHANGED = new KeySectionType("PROGRESSCHANGED", 3);
            SHOULD_INTERCEPT_REQUEST = new KeySectionType("SHOULD_INTERCEPT_REQUEST", 4);
            SHOULD_OVERRIDE_URL_LOADING = new KeySectionType("SHOULD_OVERRIDE_URL_LOADING", 5);
            SHOULD_SPECIAL_LOADING = new KeySectionType("SHOULD_SPECIAL_LOADING", 6);
            PAGESTART = new KeySectionType("PAGESTART", 7);
            PAGEFINISH = new KeySectionType("PAGEFINISH", 8);
            PAGE_COMMIT_VISIBLE = new KeySectionType("PAGE_COMMIT_VISIBLE", 9);
            FIRST_SCREEN_PAINT_COMMIT = new KeySectionType("FIRST_SCREEN_PAINT_COMMIT", 10);
            RECEIVED_ERROR = new KeySectionType("RECEIVED_ERROR", 11);
            RECEIVED_TITLE = new KeySectionType("RECEIVED_TITLE", 12);
            HIT_MAGIC_FILTER = new KeySectionType("HIT_MAGIC_FILTER", 13);
            NEW_HISTORY_ITEM = new KeySectionType("NEW_HISTORY_ITEM", 14);
            DID_FIRST_LAYOUT = new KeySectionType("DID_FIRST_LAYOUT", 15);
            DID_FIRST_PAINT = new KeySectionType("DID_FIRST_PAINT", 16);
            FIRST_SCREEN_PAINT = new KeySectionType("FIRST_SCREEN_PAINT", 17);
            DID_UNSAFE_PAGE_DETECTED = new KeySectionType("DID_UNSAFE_PAGE_DETECTED", 18);
            RESOURCE_REQUEST_COMPLETED = new KeySectionType("RESOURCE_REQUEST_COMPLETED", 19);
            START_NAVIGATION = new KeySectionType("START_NAVIGATION", 20);
            RESOURCE_HEADERS_RECEIVED = new KeySectionType("RESOURCE_HEADERS_RECEIVED", 21);
            KeySectionType keySectionType = new KeySectionType("RESOURCE_BEFORE_REQUEST", 22);
            RESOURCE_BEFORE_REQUEST = keySectionType;
            $VALUES = new KeySectionType[]{GET_VISITED_HISTORY, DO_UPDATE_VISITED_HISTORY, RESTORE_FROM_CACHE, PROGRESSCHANGED, SHOULD_INTERCEPT_REQUEST, SHOULD_OVERRIDE_URL_LOADING, SHOULD_SPECIAL_LOADING, PAGESTART, PAGEFINISH, PAGE_COMMIT_VISIBLE, FIRST_SCREEN_PAINT_COMMIT, RECEIVED_ERROR, RECEIVED_TITLE, HIT_MAGIC_FILTER, NEW_HISTORY_ITEM, DID_FIRST_LAYOUT, DID_FIRST_PAINT, FIRST_SCREEN_PAINT, DID_UNSAFE_PAGE_DETECTED, RESOURCE_REQUEST_COMPLETED, START_NAVIGATION, RESOURCE_HEADERS_RECEIVED, keySectionType};
        }

        public KeySectionType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static KeySectionType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (KeySectionType) Enum.valueOf(KeySectionType.class, str) : (KeySectionType) invokeL.objValue;
        }

        public static KeySectionType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (KeySectionType[]) $VALUES.clone() : (KeySectionType[]) invokeV.objValue;
        }
    }

    public MonitorConstant() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
