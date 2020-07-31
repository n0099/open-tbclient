package com.baidu.tieba.livesdk.e;

import com.baidu.adp.lib.e.c;
import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoader;
import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderListener;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLDecoder;
/* loaded from: classes4.dex */
public class b implements IImageLoader {
    @Override // com.baidu.live.adp.lib.image.loader.interfaces.IImageLoader
    public void loadImage(final String str, final IImageLoaderListener iImageLoaderListener) {
        int i;
        int i2;
        String[] split;
        String decode = URLDecoder.decode(str);
        if (decode == null || !decode.contains("@resize") || (split = decode.split("@resize")) == null || split.length != 2) {
            i = 0;
            i2 = 0;
        } else {
            decode = split[0];
            String[] split2 = split[1].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            i2 = com.baidu.adp.lib.f.b.toInt(split2[0].replace("{w:", ""), 0);
            i = com.baidu.adp.lib.f.b.toInt(split2[1].replace("h:", "").replace("}", ""), 0);
        }
        if (decode != null) {
            if (decode.toLowerCase().startsWith("file://")) {
                c.ln().a(decode.substring(7), 43, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.livesdk.e.b.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i3) {
                        if (aVar != null && aVar.getRawBitmap() != null && iImageLoaderListener != null) {
                            iImageLoaderListener.onLoadComplete(str, aVar.getRawBitmap());
                        }
                    }
                }, i2, i, null, new Object[0]);
            } else {
                c.ln().a(decode, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.livesdk.e.b.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i3) {
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
        c.ln().a(str, 39, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.livesdk.e.b.3
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
                    c.ln().k(str, 36);
                } else {
                    c.ln().k(str, 10);
                    c.ln().k(str, 39);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
