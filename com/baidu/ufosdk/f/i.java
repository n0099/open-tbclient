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
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.tieba.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f5669a;

    public static int a() {
        return Build.VERSION.SDK_INT;
    }

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int a(Context context, String str) {
        return context.getResources().getIdentifier(str, ResUtils.ANIM, context.getPackageName());
    }

    public static long a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    public static ColorStateList a(int i, int i2, int i3, int i4) {
        return new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[]{16842910, 16842908}, new int[]{16842910}, new int[]{16842908}, new int[]{16842909}, new int[0]}, new int[]{i2, i3, i, i3, i4, i});
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            c.a("unknown resourse, drawable null!");
            return null;
        }
        try {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } catch (Exception e) {
            if (com.baidu.ufosdk.b.o <= 4) {
                e.printStackTrace();
            }
            bitmap = null;
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

    public static Drawable a(Context context, int i) {
        return context.getResources().getDrawable(i);
    }

    public static String a(long j) {
        if (f5669a == null) {
            f5669a = new SimpleDateFormat("MM-dd HH:mm");
        }
        return f5669a.format(new Date(j));
    }

    public static void a(Context context, TextView textView) {
        if (context == null || textView == null) {
            return;
        }
        textView.setText(s.a(Constants.VIA_ACT_TYPE_NINETEEN));
    }

    public static void a(RelativeLayout relativeLayout, String str) {
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

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$").matcher(str).matches();
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, 16384);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                c.a("stream2ByteArray fail", e);
            }
        }
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static View b(Context context, String str) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        try {
            relativeLayout.setBackgroundDrawable(o.a(context, "ufo_loading_bg.9.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        ProgressBar progressBar = new ProgressBar(context);
        try {
            progressBar.setIndeterminateDrawable(new BitmapDrawable(m.a(context, "ufo_loading_icon.png")));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(linearInterpolator);
        progressBar.startAnimation(rotateAnimation);
        progressBar.setId(R.drawable.res_0x7f080033_ic_pic_mask_newuser_background_svg__1);
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

    public static String b(long j) {
        if (f5669a == null) {
            f5669a = new SimpleDateFormat("yy-MM-dd");
        }
        return f5669a.format(new Date(j));
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0-9]))\\d{8}$").matcher(str).matches();
    }

    public static String c(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");
        f5669a = simpleDateFormat;
        String format = simpleDateFormat.format(new Date(j));
        f5669a = null;
        return format.split(" ")[1];
    }

    public static boolean c(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("^[1-9][0-9]{4,}$").matcher(str).matches();
    }

    public static String d(long j) {
        return j / 1000000000 > 0 ? (((float) (j / 100000000)) / 10.0f) + "G" : j / TimeUtils.NANOS_PER_MS > 0 ? (((float) (j / 100000)) / 10.0f) + "M" : j / 1000 > 0 ? (((float) (j / 100)) / 10.0f) + "K" : j + "B";
    }
}
