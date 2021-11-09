package com.baidu.ufosdk.f;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f56695a;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? Build.VERSION.SDK_INT : invokeV.intValue;
    }

    public static int a(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? context.getResources().getIdentifier(str, "anim", context.getPackageName()) : invokeLL.intValue;
    }

    public static long a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.availMem / 1024;
        }
        return invokeL.longValue;
    }

    public static ColorStateList a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3, i4, i5)) == null) ? new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[]{16842910, 16842908}, new int[]{16842910}, new int[]{16842908}, new int[]{16842909}, new int[0]}, new int[]{i3, i4, i2, i4, i5, i2}) : (ColorStateList) invokeIIII.objValue;
    }

    public static Bitmap a(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, drawable)) == null) {
            Bitmap bitmap = null;
            if (drawable == null) {
                c.a("unknown resourse, drawable null!");
                return null;
            }
            try {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            } catch (Exception e2) {
                if (com.baidu.ufosdk.b.o <= 4) {
                    e2.printStackTrace();
                }
            }
            if (bitmap == null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                drawable.draw(new Canvas(createBitmap));
                return createBitmap;
            }
            return bitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Drawable a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, context, i2)) == null) ? context.getResources().getDrawable(i2) : (Drawable) invokeLI.objValue;
    }

    public static String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j)) == null) {
            if (f56695a == null) {
                f56695a = new SimpleDateFormat("MM-dd HH:mm");
            }
            return f56695a.format(new Date(j));
        }
        return (String) invokeJ.objValue;
    }

    public static void a(Context context, TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, context, textView) == null) || context == null || textView == null) {
            return;
        }
        textView.setText(s.a(Constants.VIA_ACT_TYPE_NINETEEN));
    }

    public static void a(RelativeLayout relativeLayout, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, relativeLayout, str) == null) {
            int childCount = relativeLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = relativeLayout.getChildAt(i2);
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
            return Pattern.compile("^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$").matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static byte[] a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[16384];
            while (true) {
                try {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (IOException e2) {
                    c.a("stream2ByteArray fail", e2);
                }
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public static View b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            RelativeLayout relativeLayout2 = new RelativeLayout(context);
            try {
                relativeLayout.setBackgroundDrawable(o.a(context, "ufo_loading_bg.9.png"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            ProgressBar progressBar = new ProgressBar(context);
            try {
                progressBar.setIndeterminateDrawable(new BitmapDrawable(m.a(context, "ufo_loading_icon.png")));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            LinearInterpolator linearInterpolator = new LinearInterpolator();
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(linearInterpolator);
            progressBar.startAnimation(rotateAnimation);
            progressBar.setId(R.drawable.res_0x7f080033_icon_mask_wo_list_gift24_svg__2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(context, 17.0f), a(context, 17.0f));
            layoutParams.addRule(15);
            layoutParams.setMargins(a(context, 3.0f), 0, 0, 0);
            relativeLayout2.addView(progressBar, layoutParams);
            TextView textView = new TextView(context);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, progressBar.getId());
            textView.setPadding(a(context, 5.0f), 0, a(context, 3.0f), 0);
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

    public static String b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65549, null, j)) == null) {
            if (f56695a == null) {
                f56695a = new SimpleDateFormat("yy-MM-dd");
            }
            return f56695a.format(new Date(j));
        }
        return (String) invokeJ.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (str == null) {
                return false;
            }
            return Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0-9]))\\d{8}$").matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static String c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65551, null, j)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");
            f56695a = simpleDateFormat;
            String format = simpleDateFormat.format(new Date(j));
            f56695a = null;
            return format.split(" ")[1];
        }
        return (String) invokeJ.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (str == null) {
                return false;
            }
            return Pattern.compile("^[1-9][0-9]{4,}$").matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static String d(long j) {
        InterceptResult invokeJ;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65553, null, j)) == null) {
            if (j / 1000000000 > 0) {
                long j2 = j / CoolPraiseView.BILLION;
                sb = new StringBuilder();
                sb.append(((float) j2) / 10.0f);
                str = "G";
            } else if (j / 1000000 > 0) {
                sb = new StringBuilder();
                sb.append(((float) (j / 100000)) / 10.0f);
                str = "M";
            } else if (j / 1000 > 0) {
                sb = new StringBuilder();
                sb.append(((float) (j / 100)) / 10.0f);
                str = "K";
            } else {
                sb = new StringBuilder();
                sb.append(j);
                str = "B";
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeJ.objValue;
    }
}
