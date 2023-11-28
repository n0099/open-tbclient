package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.AdverSegmentData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class z5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(AdverSegmentData adverSegmentData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, adverSegmentData, i)) == null) {
            if (adverSegmentData == null || StringHelper.isTaday(SharedPrefHelper.getInstance().getLong("key_pb_falling_ad_feedback_click_time", 0L))) {
                return false;
            }
            try {
                if (i == 2) {
                    int i2 = SharedPrefHelper.getInstance().getInt("key_pb_commont_egg_limlit_a", 0);
                    if (TbSingleton.getInstance().getAdVertiSementData() != null && i2 < TbSingleton.getInstance().getAdVertiSementData().a()) {
                        SharedPrefHelper.getInstance().putInt("key_pb_commont_egg_limlit_a", i2 + 1);
                        return true;
                    }
                } else {
                    String string = SharedPrefHelper.getInstance().getString("key_pb_commont_egg_limlit_bc", new JSONObject().toString());
                    if (TextUtils.isEmpty(adverSegmentData.getAdSegmentId())) {
                        return false;
                    }
                    JSONObject jSONObject = new JSONObject(string);
                    JSONArray jSONArray = new JSONArray();
                    JSONArray optJSONArray = jSONObject.optJSONArray(adverSegmentData.getAdSegmentId());
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            long optLong = optJSONArray.optLong(i3);
                            if (StringHelper.isTaday(optLong)) {
                                jSONArray.put(optLong);
                            }
                        }
                    }
                    if (TbSingleton.getInstance().getAdVertiSementData() != null && jSONArray.length() < TbSingleton.getInstance().getAdVertiSementData().b()) {
                        jSONArray.put(System.currentTimeMillis());
                        jSONObject.remove(adverSegmentData.getAdSegmentId());
                        jSONObject.put(adverSegmentData.getAdSegmentId(), jSONArray);
                        SharedPrefHelper.getInstance().putString("key_pb_commont_egg_limlit_bc", jSONObject.toString());
                        return true;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static final int b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return view2.getMeasuredWidth();
        }
        return invokeL.intValue;
    }

    public static final int c(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                if (mode == 1073741824) {
                    return size;
                }
                return i;
            }
            return Math.min(i, size);
        }
        return invokeII.intValue;
    }
}
