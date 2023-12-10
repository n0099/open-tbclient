package com.baidu.tieba;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes9.dex */
public class z5a implements y5a, PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public ArrayList<PreLoadImageInfo> d;
    public String e;

    @Override // com.baidu.tieba.y5a
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    public z5a(ExcContent excContent) {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {excContent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (excContent != null && (l = excContent.type) != null && l.equals(3L)) {
            this.d = new ArrayList<>(1);
            this.a = excContent.src;
            String str = excContent.bsize;
            this.e = str;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.b = JavaTypesHelper.toInt(split[0], 0);
                    this.c = JavaTypesHelper.toInt(split[1], 0);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.b <= 0) {
                this.b = 1;
            }
            if (this.c <= 0) {
                this.c = 1;
            }
            String str2 = excContent.cdn_src;
            PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
            preLoadImageInfo.procType = 17;
            preLoadImageInfo.height = this.c;
            preLoadImageInfo.width = this.b;
            if (StringUtils.isNull(str2)) {
                preLoadImageInfo.imgUrl = this.a;
            } else {
                preLoadImageInfo.imgUrl = str2;
            }
            this.d.add(preLoadImageInfo);
        }
    }

    public int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i <= 0) {
                return 0;
            }
            return (i * this.c) / this.b;
        }
        return invokeI.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (ArrayList) invokeV.objValue;
    }
}
