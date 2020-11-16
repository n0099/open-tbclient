package com.baidu.yuyinala.privatemessage.implugin.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import com.baidu.live.sdk.a;
import com.baidu.sumeru.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.baidu.sumeru.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.baidu.sumeru.universalimageloader.core.DisplayImageOptions;
import com.baidu.sumeru.universalimageloader.core.ImageLoader;
import com.baidu.sumeru.universalimageloader.core.ImageLoaderConfiguration;
import com.baidu.sumeru.universalimageloader.core.assist.ImageScaleType;
import com.baidu.sumeru.universalimageloader.core.assist.QueueProcessingType;
import com.baidubce.services.bos.BosClientConfiguration;
import java.io.File;
/* loaded from: classes4.dex */
public class b {
    private static b oFS;
    private static DisplayImageOptions oFU;
    private static DisplayImageOptions oFV;
    private static DisplayImageOptions oFW;
    public static final String oFT = Environment.getExternalStorageDirectory() + "/baidu/implugin/appcache";
    private static int oFX = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;

    private b(Context context) {
        gJ(context);
    }

    public static b gI(Context context) {
        if (oFS == null) {
            synchronized (b.class) {
                if (oFS == null) {
                    oFS = new b(context);
                }
            }
        }
        return oFS;
    }

    public static DisplayImageOptions ehZ() {
        return oFU;
    }

    public static DisplayImageOptions eia() {
        return oFV;
    }

    public static DisplayImageOptions eib() {
        return oFW;
    }

    private void gJ(Context context) {
        int i;
        oFU = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).showImageOnLoading(a.e.bd_im_head_left).showImageForEmptyUri(a.e.bd_im_head_left).showImageOnFail(a.e.bd_im_head_left).imageScaleType(ImageScaleType.EXACTLY).resetViewBeforeLoading(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        oFV = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).showImageOnLoading(a.e.bd_im_head_user).showImageForEmptyUri(a.e.bd_im_head_user).showImageOnFail(a.e.bd_im_head_user).imageScaleType(ImageScaleType.EXACTLY).resetViewBeforeLoading(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        oFW = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).showImageOnLoading(a.e.bd_im_loading_default).showImageForEmptyUri(a.e.bd_im_loading_failed).showImageOnFail(a.e.bd_im_loading_failed).imageScaleType(ImageScaleType.EXACTLY).resetViewBeforeLoading(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        int i2 = oFX;
        try {
            i = (int) (Runtime.getRuntime().freeMemory() / 10);
        } catch (Exception e) {
            e.printStackTrace();
            i = i2;
        }
        if (i <= 0) {
            i = oFX;
        }
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(context).threadPriority(3).denyCacheImageMultipleSizesInMemory().memoryCacheSize(i).discCache(new UnlimitedDiscCache(new File(oFT))).discCacheFileNameGenerator(new Md5FileNameGenerator()).imageDownloader(new com.baidu.yuyinala.privatemessage.implugin.util.a.a(context)).tasksProcessingOrder(QueueProcessingType.LIFO).build());
    }
}
