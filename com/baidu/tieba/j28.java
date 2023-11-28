package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes6.dex */
public final class j28 extends yfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yfa
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "forum_follow" : (String) invokeV.objValue;
    }

    public j28() {
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

    @Override // com.baidu.tieba.yfa
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return fa5.e().o();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yfa, com.baidu.tieba.push.guide.DialogParamProvider
    public String provideForumIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object d = d();
            String str = null;
            if (!(d instanceof ForumData)) {
                d = null;
            }
            ForumData forumData = (ForumData) d;
            if (forumData != null) {
                str = forumData.getImage_url();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yfa, com.baidu.tieba.push.guide.DialogParamProvider
    public String provideForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object d = d();
            String str = null;
            if (!(d instanceof ForumData)) {
                d = null;
            }
            ForumData forumData = (ForumData) d;
            if (forumData != null) {
                str = forumData.getId();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yfa, com.baidu.tieba.push.guide.DialogParamProvider
    public String provideForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object d = d();
            String str = null;
            if (!(d instanceof ForumData)) {
                d = null;
            }
            ForumData forumData = (ForumData) d;
            if (forumData != null) {
                str = forumData.getName();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yfa, com.baidu.tieba.push.guide.DialogParamProvider
    public String provideForumSlogan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Object d = d();
            String str = null;
            if (!(d instanceof ForumData)) {
                d = null;
            }
            ForumData forumData = (ForumData) d;
            if (forumData != null) {
                str = forumData.getSlogan();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
