package com.baidu.tieba.livesdk.e;

import com.baidu.adp.lib.e.c;
import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoader;
import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener;
import java.net.URLDecoder;
/* loaded from: classes4.dex */
public class b implements IImageLoader {
    @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoader
    public void loadImage(final String str, final IImageLoaderListener iImageLoaderListener) {
        String str2;
        int i;
        int i2;
        String[] split;
        try {
            str2 = URLDecoder.decode(str);
        } catch (Exception e) {
            e.printStackTrace();
            str2 = null;
        }
        if (str2 == null || !str2.contains("@resize") || (split = str2.split("@resize")) == null || split.length != 2) {
            i = 0;
            i2 = 0;
        } else {
            str2 = split[0];
            String[] split2 = split[1].split(",");
            i2 = com.baidu.adp.lib.f.b.toInt(split2[0].replace("{w:", ""), 0);
            i = com.baidu.adp.lib.f.b.toInt(split2[1].replace("h:", "").replace("}", ""), 0);
        }
        if (str2 != null) {
            if (str2.toLowerCase().startsWith("file://")) {
                c.mS().a(str2.substring(7), 43, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.livesdk.e.b.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str3, int i3) {
                        if (aVar != null && aVar.getRawBitmap() != null && iImageLoaderListener != null) {
                            iImageLoaderListener.onLoadComplete(str, aVar.getRawBitmap());
                        }
                    }
                }, i2, i, null, new Object[0]);
            } else {
                c.mS().a(str2, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.livesdk.e.b.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str3, int i3) {
                        if (aVar != null && aVar.getRawBitmap() != null && iImageLoaderListener != null) {
                            iImageLoaderListener.onLoadComplete(str, aVar.getRawBitmap());
                        }
                    }
                }, i2, i, null, new Object[0]);
            }
        }
    }

    @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoader
    public void loadBlurImage(final String str, String str2, final IImageLoaderListener iImageLoaderListener) {
        c.mS().a(str, 39, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.livesdk.e.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str3, int i) {
                if (aVar != null && aVar.getRawBitmap() != null && iImageLoaderListener != null) {
                    iImageLoaderListener.onLoadComplete(str, aVar.getRawBitmap());
                }
            }
        }, null);
    }

    @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoader
    public void cancelLoad(String str) {
        if (str != null) {
            try {
                if (str.toLowerCase().startsWith("file://")) {
                    c.mS().l(str, 36);
                } else {
                    c.mS().l(str, 10);
                    c.mS().l(str, 39);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
