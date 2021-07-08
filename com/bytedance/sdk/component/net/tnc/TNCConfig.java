package com.bytedance.sdk.component.net.tnc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class TNCConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> hostReplaceMap;
    public String httpCodeBlack;
    public boolean localEnable;
    public Map<String, Integer> localHostFilterList;
    public int probeCmd;
    public boolean probeEnable;
    public long probeVersion;
    public int reqErrApiCnt;
    public int reqErrCnt;
    public int reqErrIpCnt;
    public int reqToApiCnt;
    public int reqToCnt;
    public int reqToIpCnt;
    public int updateInterval;
    public int updateRandomRange;

    public TNCConfig() {
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
        this.localEnable = false;
        this.probeEnable = true;
        this.localHostFilterList = null;
        this.hostReplaceMap = null;
        this.reqToCnt = 10;
        this.reqToApiCnt = 1;
        this.reqToIpCnt = 1;
        this.reqErrCnt = 10;
        this.reqErrApiCnt = 1;
        this.reqErrIpCnt = 1;
        this.updateInterval = 900;
        this.updateRandomRange = 120;
        this.httpCodeBlack = null;
        this.probeCmd = 0;
        this.probeVersion = 0L;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(" localEnable: ");
            sb.append(this.localEnable);
            sb.append(" probeEnable: ");
            sb.append(this.probeEnable);
            sb.append(" hostFilter: ");
            Map<String, Integer> map = this.localHostFilterList;
            sb.append(map != null ? map.size() : 0);
            sb.append(" hostMap: ");
            Map<String, String> map2 = this.hostReplaceMap;
            sb.append(map2 != null ? map2.size() : 0);
            sb.append(" reqTo: ");
            sb.append(this.reqToCnt);
            sb.append("#");
            sb.append(this.reqToApiCnt);
            sb.append("#");
            sb.append(this.reqToIpCnt);
            sb.append(" reqErr: ");
            sb.append(this.reqErrCnt);
            sb.append("#");
            sb.append(this.reqErrApiCnt);
            sb.append("#");
            sb.append(this.reqErrIpCnt);
            sb.append(" updateInterval: ");
            sb.append(this.updateInterval);
            sb.append(" updateRandom: ");
            sb.append(this.updateRandomRange);
            sb.append(" httpBlack: ");
            sb.append(this.httpCodeBlack);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
