package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes9.dex */
public class VideoBlockUploadResult extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 6275774976385764456L;
    public transient /* synthetic */ FieldHolder $fh;
    public Error error;
    public String upload_id;
    public String video_url;

    public VideoBlockUploadResult() {
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

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Error error = this.error;
            if (error != null) {
                return error.errno;
            }
            return -3;
        }
        return invokeV.intValue;
    }

    public String getErrorMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Error error = this.error;
            if (error != null) {
                return error.usermsg;
            }
            return TbErrInfo.getErrMsg(-3);
        }
        return (String) invokeV.objValue;
    }

    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Error error = this.error;
            return error != null && error.errno == 0;
        }
        return invokeV.booleanValue;
    }

    public void setErrorMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (this.error == null) {
                this.error = new Error();
            }
            this.error.usermsg = str;
        }
    }

    public void setErrorNo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (this.error == null) {
                this.error = new Error();
            }
            this.error.errno = i2;
        }
    }
}
