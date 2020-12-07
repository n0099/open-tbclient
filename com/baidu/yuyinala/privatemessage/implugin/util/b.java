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
    private static b oUY;
    private static DisplayImageOptions oVa;
    private static DisplayImageOptions oVb;
    private static DisplayImageOptions oVc;
    public static final String oUZ = Environment.getExternalStorageDirectory() + "/baidu/implugin/appcache";
    private static int oVd = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;

    private b(Context context) {
        hs(context);
    }

    public static b hr(Context context) {
        if (oUY == null) {
            synchronized (b.class) {
                if (oUY == null) {
                    oUY = new b(context);
                }
            }
        }
        return oUY;
    }

    public static DisplayImageOptions enO() {
        return oVa;
    }

    public static DisplayImageOptions enP() {
        return oVb;
    }

    public static DisplayImageOptions enQ() {
        return oVc;
    }

    private void hs(Context context) {
        int i;
        oVa = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).showImageOnLoading(a.e.bd_im_head_left).showImageForEmptyUri(a.e.bd_im_head_left).showImageOnFail(a.e.bd_im_head_left).imageScaleType(ImageScaleType.EXACTLY).resetViewBeforeLoading(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        oVb = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).showImageOnLoading(a.e.bd_im_head_user).showImageForEmptyUri(a.e.bd_im_head_user).showImageOnFail(a.e.bd_im_head_user).imageScaleType(ImageScaleType.EXACTLY).resetViewBeforeLoading(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        oVc = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).showImageOnLoading(a.e.bd_im_loading_default).showImageForEmptyUri(a.e.bd_im_loading_failed).showImageOnFail(a.e.bd_im_loading_failed).imageScaleType(ImageScaleType.EXACTLY).resetViewBeforeLoading(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        int i2 = oVd;
        try {
            i = (int) (Runtime.getRuntime().freeMemory() / 10);
        } catch (Exception e) {
            e.printStackTrace();
            i = i2;
        }
        if (i <= 0) {
            i = oVd;
        }
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(context).threadPriority(3).denyCacheImageMultipleSizesInMemory().memoryCacheSize(i).discCache(new UnlimitedDiscCache(new File(oUZ))).discCacheFileNameGenerator(new Md5FileNameGenerator()).imageDownloader(new com.baidu.yuyinala.privatemessage.implugin.util.a.a(context)).tasksProcessingOrder(QueueProcessingType.LIFO).build());
    }
}
