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
    private static b ouW;
    private static DisplayImageOptions ouY;
    private static DisplayImageOptions ouZ;
    private static DisplayImageOptions ova;
    public static final String ouX = Environment.getExternalStorageDirectory() + "/baidu/implugin/appcache";
    private static int ovb = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;

    private b(Context context) {
        gL(context);
    }

    public static b gK(Context context) {
        if (ouW == null) {
            synchronized (b.class) {
                if (ouW == null) {
                    ouW = new b(context);
                }
            }
        }
        return ouW;
    }

    public static DisplayImageOptions eem() {
        return ouY;
    }

    public static DisplayImageOptions een() {
        return ouZ;
    }

    public static DisplayImageOptions eeo() {
        return ova;
    }

    private void gL(Context context) {
        int i;
        ouY = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).showImageOnLoading(a.f.bd_im_head_left).showImageForEmptyUri(a.f.bd_im_head_left).showImageOnFail(a.f.bd_im_head_left).imageScaleType(ImageScaleType.EXACTLY).resetViewBeforeLoading(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        ouZ = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).showImageOnLoading(a.f.bd_im_head_user).showImageForEmptyUri(a.f.bd_im_head_user).showImageOnFail(a.f.bd_im_head_user).imageScaleType(ImageScaleType.EXACTLY).resetViewBeforeLoading(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        ova = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).showImageOnLoading(a.f.bd_im_loading_default).showImageForEmptyUri(a.f.bd_im_loading_failed).showImageOnFail(a.f.bd_im_loading_failed).imageScaleType(ImageScaleType.EXACTLY).resetViewBeforeLoading(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        int i2 = ovb;
        try {
            i = (int) (Runtime.getRuntime().freeMemory() / 10);
        } catch (Exception e) {
            e.printStackTrace();
            i = i2;
        }
        if (i <= 0) {
            i = ovb;
        }
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(context).threadPriority(3).denyCacheImageMultipleSizesInMemory().memoryCacheSize(i).discCache(new UnlimitedDiscCache(new File(ouX))).discCacheFileNameGenerator(new Md5FileNameGenerator()).imageDownloader(new com.baidu.yuyinala.privatemessage.implugin.util.a.a(context)).tasksProcessingOrder(QueueProcessingType.LIFO).build());
    }
}
