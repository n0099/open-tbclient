package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.RecommendForum;
/* loaded from: classes8.dex */
public class v1d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecommendForum recommendForum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recommendForum)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "name", recommendForum.name);
            ktc.a(jSONObject, "avatar", recommendForum.avatar);
            ktc.a(jSONObject, "link", recommendForum.link);
            ktc.a(jSONObject, "st_param", recommendForum.st_param);
            ktc.a(jSONObject, "member_num", recommendForum.member_num);
            ktc.a(jSONObject, "thread_num", recommendForum.thread_num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
