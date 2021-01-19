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
/* loaded from: classes10.dex */
public class b {
    private static b oWD;
    private static DisplayImageOptions oWF;
    private static DisplayImageOptions oWG;
    private static DisplayImageOptions oWH;
    public static final String oWE = Environment.getExternalStorageDirectory() + "/baidu/implugin/appcache";
    private static int oWI = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;

    private b(Context context) {
        hD(context);
    }

    public static b hC(Context context) {
        if (oWD == null) {
            synchronized (b.class) {
                if (oWD == null) {
                    oWD = new b(context);
                }
            }
        }
        return oWD;
    }

    public static DisplayImageOptions ejX() {
        return oWF;
    }

    public static DisplayImageOptions ejY() {
        return oWG;
    }

    public static DisplayImageOptions ejZ() {
        return oWH;
    }

    private void hD(Context context) {
        int i;
        oWF = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).showImageOnLoading(a.e.bd_im_head_left).showImageForEmptyUri(a.e.bd_im_head_left).showImageOnFail(a.e.bd_im_head_left).imageScaleType(ImageScaleType.EXACTLY).resetViewBeforeLoading(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        oWG = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).showImageOnLoading(a.e.bd_im_head_user).showImageForEmptyUri(a.e.bd_im_head_user).showImageOnFail(a.e.bd_im_head_user).imageScaleType(ImageScaleType.EXACTLY).resetViewBeforeLoading(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        oWH = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).showImageOnLoading(a.e.bd_im_loading_default).showImageForEmptyUri(a.e.bd_im_loading_failed).showImageOnFail(a.e.bd_im_loading_failed).imageScaleType(ImageScaleType.EXACTLY).resetViewBeforeLoading(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        int i2 = oWI;
        try {
            i = (int) (Runtime.getRuntime().freeMemory() / 10);
        } catch (Exception e) {
            e.printStackTrace();
            i = i2;
        }
        if (i <= 0) {
            i = oWI;
        }
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(context).threadPriority(3).denyCacheImageMultipleSizesInMemory().memoryCacheSize(i).discCache(new UnlimitedDiscCache(new File(oWE))).discCacheFileNameGenerator(new Md5FileNameGenerator()).imageDownloader(new com.baidu.yuyinala.privatemessage.implugin.util.a.a(context)).tasksProcessingOrder(QueueProcessingType.LIFO).build());
    }
}
