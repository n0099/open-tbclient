package com.baidu.ugc.editvideo.record.preview;

import android.opengl.GLSurfaceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes10.dex */
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
            egl10.eglChooseConfig(eGLDisplay, new int[]{12329, 0, 12352, 4, 12351, 12430, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12325, 24, 12338, 1, 12337, 4, 12344}, eGLConfigArr, 1, iArr);
            if (iArr[0] == 0) {
                return null;
            }
            return eGLConfigArr[0];
        }
        return (EGLConfig) invokeLL.objValue;
    }
}
