package com.baidu.yuyinala.privatemessage.implugin.util.a;

import android.content.Context;
import com.baidu.sumeru.universalimageloader.core.download.BaseImageDownloader;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes10.dex */
public class a extends BaseImageDownloader {
    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.sumeru.universalimageloader.core.download.BaseImageDownloader
    protected InputStream getStreamFromNetwork(String str, Object obj) throws IOException {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            url = null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.connectTimeout);
        httpURLConnection.setReadTimeout(this.readTimeout);
        return new BufferedInputStream(httpURLConnection.getInputStream(), 32768);
    }
}
