package com.baidu.tieba.wallet;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class CurrencySwitchUtil {
    public static int getGiftMoneyIconResId(int i2) {
        if (isYyIsConvert(i2)) {
            return R.drawable.icon_gift_my_ydou;
        }
        return R.drawable.icon_gift_my_tdou;
    }

    public static Drawable getMoneyIcon() {
        if (isYyIsConvert()) {
            return SkinManager.getDrawable(R.drawable.icon_huobi_ydou);
        }
        return SkinManager.getDrawable(R.drawable.icon_huobi_tdou);
    }

    public static Bitmap getMoneyIconBitmap(int i2) {
        if (isYyIsConvert(i2)) {
            return SkinManager.getBitmap(R.drawable.icon_huobi_ydou);
        }
        return SkinManager.getBitmap(R.drawable.icon_huobi_tdou);
    }

    public static Drawable getNormalSkinMoneyIcon() {
        if (isYyIsConvert()) {
            return SkinManager.getDrawable(0, R.drawable.icon_huobi_ydou);
        }
        return SkinManager.getDrawable(0, R.drawable.icon_huobi_tdou);
    }

    public static boolean isNeedConfirmTDouToYBeanSwitchOpen() {
        if (TbSingleton.getInstance() == null || TbSingleton.getInstance().getYYLiveConfig() == null) {
            return false;
        }
        return TbSingleton.getInstance().getYYLiveConfig().isYYPayNeedConfirm();
    }

    public static boolean isYyIsConvert() {
        if (TbSingleton.getInstance() == null || TbSingleton.getInstance().getYYLiveConfig() == null) {
            return false;
        }
        return TbSingleton.getInstance().getYYLiveConfig().isYyIsConvert();
    }

    public static boolean isYyIsConvert(int i2) {
        return i2 == 1;
    }

    public static Drawable getMoneyIcon(int i2) {
        if (isYyIsConvert(i2)) {
            return SkinManager.getDrawable(R.drawable.icon_huobi_ydou);
        }
        return SkinManager.getDrawable(R.drawable.icon_huobi_tdou);
    }

    public static Bitmap getMoneyIconBitmap() {
        if (isYyIsConvert()) {
            return SkinManager.getBitmap(R.drawable.icon_huobi_ydou);
        }
        return SkinManager.getBitmap(R.drawable.icon_huobi_tdou);
    }
}
