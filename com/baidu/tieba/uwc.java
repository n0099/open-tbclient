package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.RecommendForum;
/* loaded from: classes8.dex */
public class uwc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecommendForum recommendForum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recommendForum)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "name", recommendForum.name);
            poc.a(jSONObject, "avatar", recommendForum.avatar);
            poc.a(jSONObject, "link", recommendForum.link);
            poc.a(jSONObject, "st_param", recommendForum.st_param);
            poc.a(jSONObject, "member_num", recommendForum.member_num);
            poc.a(jSONObject, "thread_num", recommendForum.thread_num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
