package com.baidu.tieba.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.ContentData;
import java.io.File;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class UtilHelper {
    public static int dip2px(Context context, float dipValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dipValue * scale) + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((pxValue / scale) + 0.5f);
    }

    public static int getEquipmentWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getEquipmentHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static void showToast(Context context, String str) {
        if (str != null && str.length() > 0) {
            Toast toast = Toast.makeText(TiebaApplication.app, str, 2000);
            int y_offset = dip2px(context, 100.0f);
            toast.setGravity(17, 0, y_offset);
            toast.show();
        }
    }

    public static void quitDialog(final Activity activity) {
        new AlertDialog.Builder(activity).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(R.string.alert_quit_confirm).setPositiveButton(R.string.alert_yes_button, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.util.UtilHelper.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                activity.finish();
            }
        }).setNegativeButton(R.string.alert_no_button, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.util.UtilHelper.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).create().show();
    }

    public static void hideSoftKeyPad(Context context, View view) {
        try {
            InputMethodManager inputManager = (InputMethodManager) context.getSystemService("input_method");
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception ex) {
            TiebaLog.e("UtilHelper", "hideSoftKeyPad", "error = " + ex.getMessage());
        }
    }

    public static void showSoftKeyPad(Context context, View view) {
        try {
            InputMethodManager inputManager = (InputMethodManager) context.getSystemService("input_method");
            inputManager.showSoftInput(view, 0);
        } catch (Exception ex) {
            TiebaLog.e("UtilHelper", "showSoftKeyPad", "error = " + ex.getMessage());
        }
    }

    public static int getStatusBarHeight(Activity activity) {
        Rect rect = new Rect();
        Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static int[] getScreenDimensions(Context context) {
        Display display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int[] dimensions = {display.getWidth(), display.getHeight()};
        return dimensions;
    }

    public static void install_apk(Context context, String file_name) {
        if (file_name != null && file_name.length() > 0) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            File file = FileHelper.GetFile(file_name);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }

    public static Field getDeclaredField(Object object, String field_name) {
        for (Class<?> cla = object.getClass(); cla != Object.class; cla = cla.getSuperclass()) {
            try {
                Field field = cla.getDeclaredField(field_name);
                field.setAccessible(true);
                return field;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static int[] getPbImageSize(ContentData seg, int max_width) {
        int[] size = new int[2];
        int width = seg.getWidth();
        int height = seg.getHeight();
        if (max_width <= 0) {
            max_width = 1;
        }
        if (max_width > 370) {
            max_width = Config.PB_IMAGE_NEW_MAX_WIDTH;
        }
        int max_height = (int) (max_width * 1.62f);
        if (height > max_height) {
            width = (width * max_height) / height;
            height = max_height;
        }
        if (width > max_width) {
            height = (height * max_width) / width;
            width = max_width;
        }
        Bitmap bm = BitmapHelper.getCashBitmap(R.drawable.image_default);
        if (height < bm.getHeight()) {
            height = bm.getHeight();
        }
        if (width < bm.getWidth()) {
            width = bm.getWidth();
        }
        size[0] = width;
        size[1] = height;
        return size;
    }

    public static int getBitmapMaxMemory(Context context) {
        int memory = CompatibleUtile.getBitmapMaxMemory(context);
        TiebaLog.d("UtilHelper", "getBitmapMaxMemory", String.valueOf(memory));
        return memory;
    }

    public static boolean isGif(byte[] data) {
        try {
            if (data[0] == 71 && data[1] == 73) {
                if (data[2] != 70) {
                    return false;
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isSupportGesture() {
        return Build.VERSION.SDK_INT > 4;
    }
}
