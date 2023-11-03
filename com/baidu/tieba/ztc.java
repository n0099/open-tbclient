package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
import tbclient.FrsPage.Size;
/* loaded from: classes9.dex */
public class ztc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ActivityHead b(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            ActivityHead.Builder builder = new ActivityHead.Builder();
            if (jSONObject.has("activity_type")) {
                builder.activity_type = Integer.valueOf(jSONObject.optInt("activity_type"));
            }
            if (jSONObject.has("activity_title")) {
                builder.activity_title = jSONObject.optString("activity_title");
            }
            if (jSONObject.has("head_imgs") && (optJSONArray = jSONObject.optJSONArray("head_imgs")) != null) {
                builder.head_imgs = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        builder.head_imgs.add(qvc.b(optJSONObject2));
                    }
                }
            }
            if (jSONObject.has("top_size") && (optJSONObject = jSONObject.optJSONObject("top_size")) != null) {
                builder.top_size = axc.b(optJSONObject);
            }
            if (jSONObject.has("obj_id")) {
                builder.obj_id = jSONObject.optString("obj_id");
            }
            if (jSONObject.has("pull_down_url")) {
                builder.pull_down_url = jSONObject.optString("pull_down_url");
            }
            if (jSONObject.has("pull_down_interval")) {
                builder.pull_down_interval = Integer.valueOf(jSONObject.optInt("pull_down_interval"));
            }
            if (jSONObject.has("pull_down_pic_ios")) {
                builder.pull_down_pic_ios = jSONObject.optString("pull_down_pic_ios");
            }
            if (jSONObject.has("pull_down_pic_android")) {
                builder.pull_down_pic_android = jSONObject.optString("pull_down_pic_android");
            }
            if (jSONObject.has("pull_down_exposure_url")) {
                builder.pull_down_exposure_url = jSONObject.optString("pull_down_exposure_url");
            }
            if (jSONObject.has("pull_down_click_url")) {
                builder.pull_down_click_url = jSONObject.optString("pull_down_click_url");
            }
            if (jSONObject.has("is_ad")) {
                builder.is_ad = Boolean.valueOf(jSONObject.optBoolean("is_ad"));
            }
            if (jSONObject.has("pull_down_schema")) {
                builder.pull_down_schema = jSONObject.optString("pull_down_schema");
            }
            if (jSONObject.has("pull_down_package_name")) {
                builder.pull_down_package_name = jSONObject.optString("pull_down_package_name");
            }
            return builder.build(true);
        }
        return (ActivityHead) invokeL.objValue;
    }

    @NonNull
    public static JSONObject c(@NonNull ActivityHead activityHead) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activityHead)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "activity_type", activityHead.activity_type);
            poc.a(jSONObject, "activity_title", activityHead.activity_title);
            if (activityHead.head_imgs != null) {
                JSONArray jSONArray = new JSONArray();
                for (HeadImgs headImgs : activityHead.head_imgs) {
                    jSONArray.put(qvc.c(headImgs));
                }
                poc.a(jSONObject, "head_imgs", jSONArray);
            }
            Size size = activityHead.top_size;
            if (size != null) {
                poc.a(jSONObject, "top_size", axc.c(size));
            }
            poc.a(jSONObject, "obj_id", activityHead.obj_id);
            poc.a(jSONObject, "pull_down_url", activityHead.pull_down_url);
            poc.a(jSONObject, "pull_down_interval", activityHead.pull_down_interval);
            poc.a(jSONObject, "pull_down_pic_ios", activityHead.pull_down_pic_ios);
            poc.a(jSONObject, "pull_down_pic_android", activityHead.pull_down_pic_android);
            poc.a(jSONObject, "pull_down_exposure_url", activityHead.pull_down_exposure_url);
            poc.a(jSONObject, "pull_down_click_url", activityHead.pull_down_click_url);
            poc.a(jSONObject, "is_ad", activityHead.is_ad);
            poc.a(jSONObject, "pull_down_schema", activityHead.pull_down_schema);
            poc.a(jSONObject, "pull_down_package_name", activityHead.pull_down_package_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
