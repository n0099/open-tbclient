package com.baidu.tieba;

import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tieba.d42;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class iq2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static d42.g b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947862079, "Lcom/baidu/tieba/iq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947862079, "Lcom/baidu/tieba/iq2;");
                return;
            }
        }
        a = eo1.a;
    }

    public static void a(d42.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, gVar) == null) {
            b = gVar;
        }
    }

    public static void b(EditText editText, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, editText, i) == null) {
            e(editText, ConstPath.KEY_BLUR, i);
        }
    }

    public static void d(EditText editText, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, editText, i) == null) {
            e(editText, "confirm", i);
        }
    }

    public static void f(EditText editText, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, editText, i) == null) {
            e(editText, AddFriendActivityConfig.TYPE_FOCUS, i);
        }
    }

    public static void c(e42 e42Var, EditText editText, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65539, null, e42Var, editText, i) == null) && editText != null && b != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", editText.getText());
                jSONObject.put("eventName", "change");
                jSONObject.put("cursorOffset", editText.getSelectionStart());
                jSONObject.put("keyCode", i);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            e42Var.j(editText.getText().toString());
            e42Var.l(editText.getSelectionStart(), editText.getSelectionEnd());
            b.a(String.valueOf(editText.getTag()), jSONObject);
        }
    }

    public static void e(EditText editText, String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65541, null, editText, str, i) == null) && editText != null && b != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", editText.getText());
                jSONObject.put("eventName", str);
                jSONObject.put("cursorOffset", editText.getText().length());
                jSONObject.put("keyboardHeight", "" + ll3.O(i));
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            b.a(String.valueOf(editText.getTag()), jSONObject);
        }
    }
}
