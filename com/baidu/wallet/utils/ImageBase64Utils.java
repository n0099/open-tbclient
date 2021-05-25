package com.baidu.wallet.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.fastjson.asm.Label;
import com.baidu.apollon.imagemanager.ImageProcessor;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes5.dex */
public class ImageBase64Utils {
    public static int JPEG_QUALITY = 70;
    public static final String TAG = "ImageBase64Utils";

    /* loaded from: classes5.dex */
    public class ImageBase64AsyncTask extends AsyncTask<String, Integer, String> {
        public Context mContext;
        public int mFixedWidth;
        public String mImagePath;
        public Uri mImageUri;
        public ImageBase64Listener mListener;
        public ParcelFileDescriptor mParcelFileDescriptor;
        public boolean mPrecise;
        public int mQuality;

        public ImageBase64AsyncTask(ImageBase64Listener imageBase64Listener, String str, int i2, int i3) {
            this.mPrecise = false;
            this.mListener = imageBase64Listener;
            this.mImagePath = str;
            this.mFixedWidth = i2;
            this.mQuality = i3;
            this.mParcelFileDescriptor = initFileDescriptorFromPath();
        }

        private ParcelFileDescriptor initFileDescriptonFromUri() {
            Context context = this.mContext;
            if (context != null && this.mImageUri != null) {
                try {
                    return context.getContentResolver().openFileDescriptor(this.mImageUri, r.f7672a);
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }

        private ParcelFileDescriptor initFileDescriptorFromPath() {
            if (!TextUtils.isEmpty(this.mImagePath)) {
                try {
                    return ParcelFileDescriptor.open(new File(this.mImagePath), Label.FORWARD_REFERENCE_TYPE_SHORT);
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) {
            int i2 = this.mFixedWidth;
            return i2 <= 0 ? ImageBase64Utils.getOriginImageBase64(this.mParcelFileDescriptor, this.mQuality) : ImageBase64Utils.getImageBase64(this.mParcelFileDescriptor, i2, this.mQuality);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((ImageBase64AsyncTask) str);
            ImageBase64Listener imageBase64Listener = this.mListener;
            if (imageBase64Listener != null) {
                imageBase64Listener.onBase64Result(str);
            }
        }

        public ImageBase64AsyncTask(ImageBase64Listener imageBase64Listener, Context context, Uri uri, int i2, int i3) {
            this.mPrecise = false;
            this.mListener = imageBase64Listener;
            this.mImageUri = uri;
            this.mFixedWidth = i2;
            this.mQuality = i3;
            this.mContext = context;
            this.mParcelFileDescriptor = initFileDescriptonFromUri();
        }
    }

    /* loaded from: classes5.dex */
    public interface ImageBase64Listener {
        void onBase64Result(String str);
    }

    /* loaded from: classes5.dex */
    public static class SingletonHolder {
        public static ImageBase64Utils sInstance = new ImageBase64Utils();
    }

    public static ImageBase64Utils getInstance() {
        return SingletonHolder.sInstance;
    }

    public static String getOriginImageBase64(ParcelFileDescriptor parcelFileDescriptor, int i2) {
        if (parcelFileDescriptor != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                if (decodeFileDescriptor != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    decodeFileDescriptor.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    LogUtil.d("ImageBase64Utils", "compress size:\t" + byteArray.length + "\t\twidth" + decodeFileDescriptor.getWidth());
                    decodeFileDescriptor.recycle();
                    byteArrayOutputStream.close();
                    byte[] encode = Base64.encode(byteArray, 0, byteArray.length, 2);
                    LogUtil.d("ImageBase64Utils", "base64 size:\t" + (byteArray.length / 1024));
                    String str = new String(encode);
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return str;
                }
                parcelFileDescriptor.close();
                return "";
            } catch (IOException e3) {
                e3.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public void getImageBase64(String str, int i2, ImageBase64Listener imageBase64Listener) {
        new ImageBase64AsyncTask(imageBase64Listener, str, i2, JPEG_QUALITY).execute("");
    }

    public ImageBase64Utils() {
    }

    public void getImageBase64(Context context, Uri uri, int i2, ImageBase64Listener imageBase64Listener) {
        new ImageBase64AsyncTask(imageBase64Listener, context, uri, i2, JPEG_QUALITY).execute("");
    }

    public void getImageBase64(String str, int i2, int i3, ImageBase64Listener imageBase64Listener) {
        new ImageBase64AsyncTask(imageBase64Listener, str, i2, i3).execute("");
    }

    public void getImageBase64(Context context, Uri uri, int i2, int i3, ImageBase64Listener imageBase64Listener) {
        new ImageBase64AsyncTask(imageBase64Listener, context, uri, i2, i3).execute("");
    }

    public static String getImageBase64(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3) {
        if (parcelFileDescriptor != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                int a2 = ImageProcessor.a(options, i2, -1);
                options.inSampleSize = a2;
                options.inJustDecodeBounds = false;
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                if (decodeFileDescriptor != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    decodeFileDescriptor.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    LogUtil.d("ImageBase64Utils", "compress size:\t" + byteArray.length + "\tsampleSize" + a2 + "\twidth" + decodeFileDescriptor.getWidth());
                    decodeFileDescriptor.recycle();
                    byteArrayOutputStream.close();
                    byte[] encode = Base64.encode(byteArray, 0, byteArray.length, 2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("base64 size:\t");
                    sb.append(byteArray.length / 1024);
                    LogUtil.d("ImageBase64Utils", sb.toString());
                    String str = new String(encode);
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return str;
                }
                parcelFileDescriptor.close();
                return "";
            } catch (IOException e3) {
                e3.printStackTrace();
                return "";
            }
        }
        return "";
    }
}
