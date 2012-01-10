package com.baidu.tieba.write;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.TiebaLog;
import java.io.File;
/* loaded from: classes.dex */
public class WriteUtil {
    private static final String TMP_IMAGE_NAME = "camera.jpg";
    public static int REQUEST_CAMERA = 100;
    public static int REQUEST_ALBUM_IMAGE = 101;
    public static int REQUEST_IMAGE_VIEW = 102;
    public static int REQUEST_AT_SELECT = 103;
    public static int REQUEST_VCODE = 104;

    public static void takePhoto(BaseActivity activity) {
        try {
            if (!FileHelper.checkSD()) {
                activity.showToast(FileHelper.getSdErrorString());
            } else {
                File out = FileHelper.CreateFile(TMP_IMAGE_NAME);
                if (out != null) {
                    Uri uri = Uri.fromFile(out);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", uri);
                    activity.startActivityForResult(intent, REQUEST_CAMERA);
                } else {
                    activity.showToast(activity.getString(R.string.error_sd_error));
                }
            }
        } catch (Exception ex) {
            TiebaLog.e("WriteUtil", "takePhoto", "error = " + ex.getMessage());
        }
    }

    public static void getAlbumImage(BaseActivity activity) {
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            activity.startActivityForResult(intent, REQUEST_ALBUM_IMAGE);
        } catch (Exception ex) {
            TiebaLog.e("WriteUtil", "getAlbumImage", "error = " + ex.getMessage());
        }
    }

    private static Bitmap photoResult(int max_size) {
        try {
            Bitmap bm = BitmapHelper.subSampleBitmap(TMP_IMAGE_NAME, max_size);
            return bm;
        } catch (Exception ex) {
            TiebaLog.e("WriteUtil", "photoResult", "error = " + ex.getMessage());
            return null;
        }
    }

    private static Bitmap AlbumImageResult(Context context, Uri uri, int max_size) {
        try {
            Bitmap bm = BitmapHelper.subSampleBitmap(context, uri, max_size);
            return bm;
        } catch (Exception ex) {
            TiebaLog.e("WriteUtil", "AlbumImageResult", "error = " + ex.getMessage());
            return null;
        }
    }

    public static Bitmap ImageResult(int requestCode, Context context, Uri uri, int max_size) {
        if (requestCode == REQUEST_CAMERA) {
            Bitmap bm = photoResult(max_size);
            return bm;
        } else if (requestCode != REQUEST_ALBUM_IMAGE) {
            return null;
        } else {
            Bitmap bm2 = AlbumImageResult(context, uri, max_size);
            return bm2;
        }
    }
}
