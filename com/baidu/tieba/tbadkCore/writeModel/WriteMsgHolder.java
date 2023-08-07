package com.baidu.tieba.tbadkCore.writeModel;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class WriteMsgHolder {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId currentWriteActivityFromTag;
    public static String flutterPageId;
    public static int from;
    public static boolean isFromPersonCenter;
    public static String lastForumId;
    public static String lastForumName;
    public static String lastVideoThumbUrl;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-518816436, "Lcom/baidu/tieba/tbadkCore/writeModel/WriteMsgHolder;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-518816436, "Lcom/baidu/tieba/tbadkCore/writeModel/WriteMsgHolder;");
        }
    }

    public WriteMsgHolder() {
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

    public static BdUniqueId getCurrentWriteActivityFromTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return currentWriteActivityFromTag;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public static String getFlutterPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return flutterPageId;
        }
        return (String) invokeV.objValue;
    }

    public static String getLastForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return lastForumId;
        }
        return (String) invokeV.objValue;
    }

    public static String getLastForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return lastForumName;
        }
        return (String) invokeV.objValue;
    }

    public static String getLastVideoThumbUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return lastVideoThumbUrl;
        }
        return (String) invokeV.objValue;
    }

    public static boolean isFromPersonCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return isFromPersonCenter;
        }
        return invokeV.booleanValue;
    }

    public static boolean isFromVideoHotTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (from == 8) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void setCurrentWriteActivityFromTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bdUniqueId) == null) {
            currentWriteActivityFromTag = bdUniqueId;
        }
    }

    public static void setFlutterPageId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            flutterPageId = str;
        }
    }

    public static void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, null, i) == null) {
            from = i;
        }
    }

    public static void setFromPersonCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            isFromPersonCenter = z;
        }
    }

    public static void setLastForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            lastForumId = str;
        }
    }

    public static void setLastForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            lastForumName = str;
        }
    }

    public static void setLastVideoThumbUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            lastVideoThumbUrl = str;
        }
    }
}
