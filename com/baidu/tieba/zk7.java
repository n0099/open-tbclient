package com.baidu.tieba;

import android.graphics.drawable.ShapeDrawable;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes8.dex */
public class zk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            switch (i) {
                case 1:
                    return "一";
                case 2:
                    return "二";
                case 3:
                    return "三";
                case 4:
                    return "四";
                case 5:
                    return "五";
                case 6:
                    return "六";
                case 7:
                    return "七";
                case 8:
                    return "八";
                case 9:
                    return "九";
                case 10:
                    return "十";
                case 11:
                    return "十一";
                case 12:
                    return "十二";
                case 13:
                    return "十三";
                case 14:
                    return "十四";
                case 15:
                    return "十五";
                case 16:
                    return "十六";
                case 17:
                    return "十七";
                case 18:
                    return "十八";
                case 19:
                    return "十九";
                case 20:
                    return "二十";
                default:
                    return "";
            }
        }
        return (String) invokeI.objValue;
    }

    /* loaded from: classes8.dex */
    public static class a extends ShapeDrawable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        public a(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i3;
            this.b = i4;
            setDither(false);
            getPaint().setColor(i);
            setIntrinsicWidth(i2);
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                super.setBounds(i, i2 + this.a, i3, i4 + this.b);
            }
        }
    }

    public static long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            long j = 0;
            if (StringUtils.isNull(str)) {
                return 0L;
            }
            try {
                Date parse = new SimpleDateFormat("yyyy.MM.dd").parse(str);
                if (parse != null) {
                    j = parse.getTime();
                }
                return j / 1000;
            } catch (ParseException e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static int b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) {
            if (j < 0) {
                return -1;
            }
            return (int) (j / 86400);
        }
        return invokeJ.intValue;
    }

    public static void c(int i, int i2, EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65538, null, i, i2, editText) == null) {
            try {
                Method declaredMethod = TextView.class.getDeclaredMethod("createEditorIfNeeded", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(editText, new Object[0]);
                Field declaredField = TextView.class.getDeclaredField("mEditor");
                Field declaredField2 = Class.forName("android.widget.Editor").getDeclaredField("mCursorDrawable");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(declaredField.get(editText));
                Array.set(obj, 0, new a(SkinManager.getColor(R.color.CAM_X0302), UtilHelper.getDimenPixelSize(R.dimen.tbds5), i, i2));
                Array.set(obj, 1, new a(SkinManager.getColor(R.color.CAM_X0302), UtilHelper.getDimenPixelSize(R.dimen.tbds5), i, i2));
            } catch (Exception unused) {
            }
        }
    }
}
