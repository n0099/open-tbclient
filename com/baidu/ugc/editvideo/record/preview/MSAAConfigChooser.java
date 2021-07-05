package com.baidu.ugc.editvideo.record.preview;

import android.opengl.GLSurfaceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes6.dex */
public class MSAAConfigChooser implements GLSurfaceView.EGLConfigChooser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MSAAConfigChooser() {
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

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, egl10, eGLDisplay)) == null) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, new int[]{ZeusMonitorType.MONITOR_TYPE_NETINJECT_DETECT_COUNT, 0, 12352, 4, 12351, 12430, ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 8, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, 24, ZeusMonitorType.MONITOR_TYPE_MIP_PERFORMANCE_TIMING, 1, ZeusMonitorType.MONITOR_TYPE_SKELETON, 4, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, eGLConfigArr, 1, iArr);
            if (iArr[0] == 0) {
                return null;
            }
            return eGLConfigArr[0];
        }
        return (EGLConfig) invokeLL.objValue;
    }
}
