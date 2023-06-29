package com.baidu.ufosdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
@SuppressLint({"SimpleDateFormat", "InlinedApi"})
/* loaded from: classes8.dex */
public class p1 {
    public static /* synthetic */ Interceptable $ic;
    public static SimpleDateFormat a;
    public static ConnectivityManager b;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                return Build.VERSION.class.getField("SDK_INT").getInt(null);
            } catch (Exception unused) {
                return Integer.parseInt(Build.VERSION.SDK);
            }
        }
        return invokeV.intValue;
    }

    public static int a(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, context, f)) == null) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            return context.getResources().getIdentifier(str, "anim", context.getPackageName());
        }
        return invokeLL.intValue;
    }

    public static ColorStateList a(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65539, null, i, i2, i3, i4)) == null) {
            return new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[]{16842910, 16842908}, new int[]{16842910}, new int[]{16842908}, new int[]{16842909}, new int[0]}, new int[]{i2, i3, i, i3, i4, i});
        }
        return (ColorStateList) invokeIIII.objValue;
    }

    public static Drawable a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) {
            return context.getResources().getDrawable(i);
        }
        return (Drawable) invokeLI.objValue;
    }

    public static StateListDrawable a(Context context, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, context, i, i2)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            ColorDrawable colorDrawable = new ColorDrawable(i);
            stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(i2));
            stateListDrawable.addState(new int[0], colorDrawable);
            return stateListDrawable;
        }
        return (StateListDrawable) invokeLII.objValue;
    }

    public static StateListDrawable a(Context context, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65542, null, context, i, str)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            ColorDrawable colorDrawable = new ColorDrawable(i);
            stateListDrawable.addState(new int[]{16842919}, new BitmapDrawable(b(context, str)));
            stateListDrawable.addState(new int[0], colorDrawable);
            return stateListDrawable;
        }
        return (StateListDrawable) invokeLIL.objValue;
    }

    public static String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j)) == null) {
            if (j / 1000000000 > 0) {
                long j2 = j / CoolPraiseView.BILLION;
                return "" + (((float) j2) / 10.0f) + "G";
            } else if (j / 1000000 > 0) {
                return "" + (((float) (j / 100000)) / 10.0f) + "M";
            } else if (j / 1000 > 0) {
                return "" + (((float) (j / 100)) / 10.0f) + "K";
            } else {
                return "" + j + "B";
            }
        }
        return (String) invokeJ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0096 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            if (!e(context)) {
                return "none";
            }
            if (b == null) {
                b = (ConnectivityManager) context.getSystemService("connectivity");
            }
            ConnectivityManager connectivityManager = b;
            if (connectivityManager != null) {
                NetworkInfo networkInfo = null;
                try {
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                } catch (Exception unused) {
                }
                if (networkInfo != null) {
                    int type = networkInfo.getType();
                    int subtype = networkInfo.getSubtype();
                    if (type != 1 && type != 6) {
                        if (type != 0 && (type != 7 || subtype <= 0)) {
                            if (type != 2 && type != 7) {
                                c = 65535;
                            }
                        } else if (subtype != 3 && subtype != 5 && subtype != 6 && subtype != 8 && subtype != 9 && subtype != 10 && subtype != 12 && subtype != 14 && subtype != 15) {
                            if (subtype == 13) {
                                c = 5;
                            } else if (subtype == 20) {
                                c = 6;
                            } else {
                                c = 2;
                            }
                        } else {
                            c = 3;
                        }
                    } else {
                        c = 1;
                    }
                    if (c == 1) {
                        if (c != 2) {
                            if (c != 3) {
                                if (c != 5) {
                                    if (c != 6) {
                                        return "unknown";
                                    }
                                    return "5g";
                                }
                                return "4g";
                            }
                            return "3g";
                        }
                        return "2g";
                    }
                    return "wifi";
                }
            }
            c = 65534;
            if (c == 1) {
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static void a(Context context, TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, context, textView) == null) && context != null && textView != null) {
            textView.setText(t1.a("19"));
        }
    }

    public static void a(RelativeLayout relativeLayout, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, relativeLayout, str) == null) {
            int childCount = relativeLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = relativeLayout.getChildAt(i);
                if (childAt instanceof RelativeLayout) {
                    a((RelativeLayout) childAt, str);
                } else if (childAt instanceof TextView) {
                    ((TextView) childAt).setText(str);
                }
            }
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (str == null) {
                return false;
            }
            return Pattern.compile("[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}").matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (str == null) {
                return false;
            }
            return Pattern.compile("^((13[0-9])|(14([0|1]|[4-9]))|(15([0-3]|[5-9]))|(16[2|5|6|7])|(17[0-8])|(18[0-9])|(19([0-3]|[5-9])))\\d{8}$").matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static String c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65556, null, j)) == null) {
            if (a == null) {
                a = new SimpleDateFormat("MM-dd HH:mm");
            }
            return a.format(new Date(j));
        }
        return (String) invokeJ.objValue;
    }

    public static long d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.availMem / 1024;
        }
        return invokeL.longValue;
    }

    public static byte[] a(Context context) {
        InterceptResult invokeL;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            byte[] bArr = null;
            try {
                try {
                    inputStream = context.getAssets().open("ufo_res/ufo_addpic_icon.png");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    bArr = a(inputStream);
                } catch (IOException unused) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static Bitmap c(Context context) {
        InterceptResult invokeL;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            Bitmap bitmap = null;
            try {
                try {
                    inputStream = context.getAssets().open("ufo_res/ufo_defult_me_icon.png");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException unused) {
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            try {
                byte[] a2 = a(inputStream);
                bitmap = BitmapFactory.decodeByteArray(a2, 0, a2.length, null);
            } catch (IOException unused2) {
                if (inputStream != null) {
                    inputStream.close();
                }
                return bitmap;
            } catch (Throwable th3) {
                th = th3;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return bitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static byte[] a(Context context, boolean z) {
        InterceptResult invokeLZ;
        InputStream inputStream;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, context, z)) == null) {
            byte[] bArr = null;
            bArr = null;
            bArr = null;
            InputStream inputStream2 = null;
            try {
                try {
                    AssetManager assets = context.getAssets();
                    if (z) {
                        str = "ufo_res/ufo_addpicplus_icon_night.png";
                    } else {
                        str = "ufo_res/ufo_addpicplus_icon.png";
                    }
                    inputStream = assets.open(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException unused) {
                inputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                bArr = a(inputStream);
            } catch (IOException unused2) {
                if (inputStream != null) {
                    inputStream.close();
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return bArr;
        }
        return (byte[]) invokeLZ.objValue;
    }

    public static Bitmap b(Context context, String str) {
        InterceptResult invokeLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) {
            Bitmap bitmap = null;
            bitmap = null;
            bitmap = null;
            InputStream inputStream2 = null;
            try {
                try {
                    inputStream = context.getAssets().open("ufo_res/" + str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException unused) {
                inputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] a2 = a(inputStream);
                bitmap = BitmapFactory.decodeByteArray(a2, 0, a2.length, null);
            } catch (IOException unused2) {
                if (inputStream != null) {
                    inputStream.close();
                }
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return bitmap;
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static byte[] a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[16384];
            while (true) {
                try {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (IOException unused) {
                }
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
            if (str == null) {
                return false;
            }
            return Pattern.compile("^[1-9][0-9]{4,}$").matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static String b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65551, null, j)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");
            a = simpleDateFormat;
            String format = simpleDateFormat.format(new Date(j));
            a = null;
            return format.split(" ")[1];
        }
        return (String) invokeJ.objValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if (b == null) {
                b = (ConnectivityManager) context.getSystemService("connectivity");
            }
            ConnectivityManager connectivityManager = b;
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo networkInfo = null;
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception unused) {
            }
            if (networkInfo == null || !networkInfo.isConnected()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static View c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, str)) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            RelativeLayout relativeLayout2 = new RelativeLayout(context);
            try {
                relativeLayout.setBackgroundResource(com.baidu.tieba.R.drawable.obfuscated_res_0x7f081513);
            } catch (Exception e) {
                e.printStackTrace();
            }
            relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            ProgressBar progressBar = new ProgressBar(context);
            try {
                progressBar.setIndeterminateDrawable(new BitmapDrawable(b(context, "ufo_loading_icon.png")));
            } catch (Exception unused) {
            }
            LinearInterpolator linearInterpolator = new LinearInterpolator();
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(linearInterpolator);
            progressBar.startAnimation(rotateAnimation);
            progressBar.setId(2030567475);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(context, 17.0f), a(context, 17.0f));
            layoutParams.addRule(15);
            layoutParams.setMargins(a(context, 3.0f), 0, 0, 0);
            relativeLayout2.addView(progressBar, layoutParams);
            TextView textView = new TextView(context);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, progressBar.getId());
            textView.setGravity(17);
            textView.setTextColor(-1);
            textView.setText(str);
            layoutParams2.addRule(15);
            relativeLayout2.addView(textView, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            relativeLayout2.setPadding(a(context, 8.0f), a(context, 9.0f), a(context, 8.0f), a(context, 9.0f));
            layoutParams3.addRule(15);
            relativeLayout.addView(relativeLayout2, layoutParams3);
            return relativeLayout;
        }
        return (View) invokeLL.objValue;
    }
}
