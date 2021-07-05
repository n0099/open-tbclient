package com.baidu.webkit.sdk.performance;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebViewFactory;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class UMALogger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "UMALogger";
    public static UMALogger sDummyUMALogger;
    public transient /* synthetic */ FieldHolder $fh;

    public UMALogger() {
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

    public static UMALogger getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!WebViewFactory.hasProvider() || WebViewFactory.getProvider().getUMALogger() == null) {
                if (sDummyUMALogger == null) {
                    sDummyUMALogger = new UMALogger() { // from class: com.baidu.webkit.sdk.performance.UMALogger.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        @Override // com.baidu.webkit.sdk.performance.UMALogger
                        public void addCount1000HistogramSample(String str, int i2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048576, this, str, i2) == null) {
                            }
                        }

                        @Override // com.baidu.webkit.sdk.performance.UMALogger
                        public void addCount100HistogramSample(String str, int i2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                            }
                        }

                        @Override // com.baidu.webkit.sdk.performance.UMALogger
                        public void addCount1MHistogramSample(String str, int i2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
                            }
                        }

                        @Override // com.baidu.webkit.sdk.performance.UMALogger
                        public void addCustomCountHistogramSample(String str, int i2, int i3, int i4, int i5) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                            }
                        }

                        @Override // com.baidu.webkit.sdk.performance.UMALogger
                        public void addSpareHistogramSample(String str, int i2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048580, this, str, i2) == null) {
                            }
                        }

                        @Override // com.baidu.webkit.sdk.performance.UMALogger
                        public void addTimesHistogramSample(String str, long j) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLJ(1048581, this, str, j) == null) {
                            }
                        }
                    };
                }
                Log.i(TAG, "UMALogger.getInstance(), dummy UMALogger used");
                return sDummyUMALogger;
            }
            return WebViewFactory.getProvider().getUMALogger();
        }
        return (UMALogger) invokeV.objValue;
    }

    public abstract void addCount1000HistogramSample(String str, int i2);

    public abstract void addCount100HistogramSample(String str, int i2);

    public abstract void addCount1MHistogramSample(String str, int i2);

    public abstract void addCustomCountHistogramSample(String str, int i2, int i3, int i4, int i5);

    public abstract void addSpareHistogramSample(String str, int i2);

    public abstract void addTimesHistogramSample(String str, long j);

    public void record(JSONObject jSONObject, List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, jSONObject, list, str) == null) || jSONObject == null) {
            return;
        }
        Log.i(TAG, BundleOpProvider.METHOD_BUNDLE_RECORD);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (list == null || !list.contains(next)) {
                String str2 = str + next;
                try {
                    long j = jSONObject.getLong(next);
                    Log.i(TAG, "adding " + str2 + "=" + j);
                    addTimesHistogramSample(str2, j);
                } catch (JSONException e2) {
                    Log.e(TAG, "failed to get long for ".concat(String.valueOf(next)), e2);
                }
            } else {
                Log.i(TAG, "skipping ".concat(String.valueOf(next)));
            }
        }
    }
}
