package com.baidu.tieba.video;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class EditVideoData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String coverPath;
    public String filterName;
    public String finalPath;
    public boolean isMute;
    public String musicId;
    public String musicPath;
    public String originPath;

    public EditVideoData() {
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

    public void delete() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !StringHelper.equals(this.originPath, this.finalPath) && !xi.isEmpty(this.finalPath)) {
            FileHelper.deleteFile(new File(this.finalPath));
        }
    }

    public boolean isLegal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!xi.isEmpty(this.originPath) && !xi.isEmpty(this.coverPath)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void copy(EditVideoData editVideoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, editVideoData) != null) || editVideoData == null) {
            return;
        }
        this.originPath = editVideoData.originPath;
        this.coverPath = editVideoData.coverPath;
        this.musicPath = editVideoData.musicPath;
        this.musicId = editVideoData.musicId;
        this.isMute = editVideoData.isMute;
        this.filterName = editVideoData.filterName;
        this.finalPath = editVideoData.finalPath;
    }
}
