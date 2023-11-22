package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.RecommendForum;
/* loaded from: classes8.dex */
public class vwc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecommendForum recommendForum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recommendForum)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "name", recommendForum.name);
            qoc.a(jSONObject, "avatar", recommendForum.avatar);
            qoc.a(jSONObject, "link", recommendForum.link);
            qoc.a(jSONObject, "st_param", recommendForum.st_param);
            qoc.a(jSONObject, "member_num", recommendForum.member_num);
            qoc.a(jSONObject, "thread_num", recommendForum.thread_num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
