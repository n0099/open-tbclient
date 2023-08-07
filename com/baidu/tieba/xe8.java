package com.baidu.tieba;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xe8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(final String str, final boolean z, int i, final int i2, final boolean z2) {
        final boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            final Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (i == 3) {
                z3 = true;
            } else {
                z3 = false;
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ke8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        xe8.b(currentActivity, z, z2, z3, str, i2);
                    }
                }
            });
        }
    }

    public static /* synthetic */ void b(Activity activity, boolean z, boolean z2, boolean z3, String str, int i) {
        if (activity != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (z) {
                if (z2 && !z3 && ht4.d().b("share_thread")) {
                    return;
                }
                spannableStringBuilder.append((CharSequence) str);
            } else {
                spannableStringBuilder.append((CharSequence) c(str, i));
            }
            BdToast.makeText(TbadkCoreApplication.getInst().getContext(), spannableStringBuilder).show();
        }
    }

    @NonNull
    public static String c(@Nullable String str, int i) {
        InterceptResult invokeLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                str2 = TbadkCoreApplication.getInst().getResources().getString(R.string.share_failed);
            } else {
                str2 = str;
            }
            if (i == 2) {
                return str2;
            }
            try {
                JSONObject optJSONObject = new JSONArray(str).optJSONObject(0);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("text");
                    if (!TextUtils.isEmpty(optString)) {
                        return optString;
                    }
                    return str2;
                }
                return str2;
            } catch (Exception e) {
                e.printStackTrace();
                return str2;
            }
        }
        return (String) invokeLI.objValue;
    }
}
