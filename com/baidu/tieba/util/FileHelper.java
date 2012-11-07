package com.baidu.tieba.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class FileHelper {
    public static final File EXTERNAL_STORAGE_DIRECTORY = Environment.getExternalStorageDirectory();

    public static boolean checkSD() {
        String status = Environment.getExternalStorageState();
        return status.equals("mounted");
    }

    public static String getSdErrorString() {
        String status = Environment.getExternalStorageState();
        if (status.equals("removed")) {
            String error = TiebaApplication.app.getString(R.string.error_no_sdcard);
            return error;
        } else if (status.equals("unmounted") || status.equals("unmountable")) {
            String error2 = TiebaApplication.app.getString(R.string.error_sd_unmount);
            return error2;
        } else if (status.equals("shared")) {
            String error3 = TiebaApplication.app.getString(R.string.error_sd_shared);
            return error3;
        } else {
            String error4 = TiebaApplication.app.getString(R.string.error_sd_error);
            return error4;
        }
    }

    public static boolean CheckTempDir(String path) {
        if (checkSD()) {
            File tf = new File(path);
            if (!tf.exists()) {
                try {
                    return tf.mkdir();
                } catch (Exception e) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean CheckTempDir() {
        return CheckTempDir(EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/");
    }

    public static boolean CheckFile(String file) {
        if (checkSD()) {
            try {
                File tf = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + file);
                return tf.exists();
            } catch (Exception ex) {
                TiebaLog.e("FileHelper", "CheckFile", "error = " + ex.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean CheckFile(String path, String file) {
        if (checkSD()) {
            try {
                File tf = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + path + "/" + file);
                return tf.exists();
            } catch (Exception ex) {
                TiebaLog.e("FileHelper", "CheckFile", "error = " + ex.getMessage());
                return false;
            }
        }
        return false;
    }

    public static File GetFile(String filename) {
        if (CheckTempDir()) {
            File file = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + filename);
            try {
                if (file.exists()) {
                    return file;
                }
                return null;
            } catch (SecurityException ex) {
                TiebaLog.e("FileHelper", "GetFile", "error = " + ex.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File FileObject(String filename) {
        if (!CheckTempDir()) {
            return null;
        }
        return new File(EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + filename);
    }

    public static File CreateFile(String filename) {
        if (CheckTempDir()) {
            File file = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + filename);
            try {
                if (file.exists()) {
                    file.delete();
                }
                if (file.createNewFile()) {
                    return file;
                }
                return null;
            } catch (Exception ex) {
                TiebaLog.e("FileHelper", "CreateFile", "error = " + ex.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File CreateFileIfNotFound(String filename) {
        if (CheckTempDir()) {
            File file = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + filename);
            try {
                if (!file.exists()) {
                    if (file.createNewFile()) {
                        return file;
                    }
                    return null;
                }
                return file;
            } catch (Exception ex) {
                TiebaLog.e("FileHelper", "CreateFile", "error = " + ex.getMessage());
                return null;
            }
        }
        return null;
    }

    public static FileOutputStream CreateFileOutputStream(String filename) {
        try {
            File file = CreateFile(filename);
            if (file != null) {
                return new FileOutputStream(file, true);
            }
            return null;
        } catch (Exception ex) {
            TiebaLog.e("FileHelper", "FileOutputStream", "error = " + ex.getMessage());
            return null;
        }
    }

    public static String SaveGifFile(String path, String filename, byte[] imageData) {
        String all_path;
        if (path != null) {
            all_path = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + path + "/";
        } else {
            all_path = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/";
        }
        if (!CheckTempDir(all_path) || imageData == null) {
            return null;
        }
        File file = new File(String.valueOf(all_path) + filename);
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            fOut.write(imageData);
            fOut.flush();
            fOut.close();
            return file.getPath();
        } catch (Exception ex) {
            TiebaLog.e("FileHelper", "SaveGifFile", ex.getMessage());
            return null;
        }
    }

    public static boolean isGif(String path, String filename) {
        String all_path;
        InputStream fStream;
        boolean result = false;
        if (path != null) {
            all_path = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + path + "/";
        } else {
            all_path = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/";
        }
        File file = new File(String.valueOf(all_path) + filename);
        try {
            fStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        }
        try {
            byte[] temp = new byte[7];
            fStream.read(temp, 0, 6);
            result = UtilHelper.isGif(temp);
            if (fStream != null) {
                fStream.close();
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            e.printStackTrace();
            return result;
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            return result;
        }
        return result;
    }

    public static String SaveFile(String path, String filename, Bitmap bm, int quality) {
        String all_path;
        if (path != null) {
            all_path = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + path + "/";
        } else {
            all_path = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/";
        }
        if (!CheckTempDir(all_path) || bm == null) {
            return null;
        }
        File file = new File(String.valueOf(all_path) + filename);
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.JPEG, quality, fOut);
            fOut.flush();
            fOut.close();
            return file.getPath();
        } catch (Exception ex) {
            TiebaLog.e("FileHelper", "SaveFile", ex.getMessage());
            return null;
        }
    }

    public static Bitmap getImage(String path, String filename) {
        String all_path;
        if (path != null) {
            all_path = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + path + "/";
        } else {
            all_path = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/";
        }
        return BitmapFactory.decodeFile(String.valueOf(all_path) + filename);
    }

    public static String SaveFile(String filename, byte[] data) {
        return SaveFile(null, filename, data);
    }

    public static String SaveFile(String path, String filename, byte[] data) {
        String all_path;
        if (!CheckTempDir() || data == null || filename == null) {
            return null;
        }
        if (path != null) {
            all_path = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + path + "/";
        } else {
            all_path = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/";
        }
        File file = new File(String.valueOf(all_path) + filename);
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            fOut.write(data, 0, data.length);
            fOut.flush();
            fOut.close();
            return file.getPath();
        } catch (IOException ex) {
            TiebaLog.e("FileHelper", "SaveFile", "error = " + ex.getMessage());
            return null;
        }
    }

    public static byte[] GetFileData(String path, String filename) {
        String all_path;
        if (!CheckTempDir() || filename == null) {
            return null;
        }
        if (path != null) {
            all_path = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + path + "/";
        } else {
            all_path = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/";
        }
        File file = new File(String.valueOf(all_path) + filename);
        try {
            if (file.exists()) {
                FileInputStream fStream = new FileInputStream(file);
                ByteArrayOutputStream outputstream = new ByteArrayOutputStream(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END);
                byte[] temp = new byte[AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END];
                while (true) {
                    int num = fStream.read(temp, 0, AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END);
                    if (num == -1) {
                        break;
                    }
                    outputstream.write(temp, 0, num);
                }
                if (fStream != null) {
                    fStream.close();
                }
                return outputstream.toByteArray();
            }
            return null;
        } catch (IOException ex) {
            TiebaLog.e("FileHelper", "GetFileData", "error = " + ex.getMessage());
            return null;
        }
    }

    public static boolean CopyFile(String srcPath, String dstPath) {
        OutputStream fosto;
        String fromPath = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + srcPath;
        String toPath = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + dstPath;
        try {
            File srcFile = new File(fromPath);
            File dstFile = new File(toPath);
            if (srcFile.exists()) {
                InputStream fosfrom = new FileInputStream(srcFile);
                try {
                    fosto = new FileOutputStream(dstFile);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    byte[] bt = new byte[AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END];
                    while (true) {
                        int c = fosfrom.read(bt);
                        if (c <= 0) {
                            break;
                        }
                        fosto.write(bt, 0, c);
                    }
                    fosfrom.close();
                    fosto.close();
                } catch (Exception e2) {
                    e = e2;
                    TiebaLog.e("FileHelper", "CopyFile", e.toString());
                    return false;
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        return false;
    }

    public static InputStream GetStreamFromFile(String filename) {
        return GetStreamFromFile(GetFile(filename));
    }

    public static InputStream GetStreamFromFile(File file) {
        if (file != null) {
            try {
                return new FileInputStream(file);
            } catch (Exception ex) {
                TiebaLog.e("FileHelper", "GetStreamFromFile", "error = " + ex.getMessage());
                return null;
            }
        }
        return null;
    }

    public static Bitmap GetBitmapFromFile(String filename, int maxsize) {
        String filepath = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + filename;
        return BitmapHelper.resizeBitmap(filepath, maxsize);
    }

    public static boolean DelFile(String filename) {
        if (CheckTempDir()) {
            File file = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + filename);
            try {
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            } catch (Exception ex) {
                TiebaLog.e("FileHelper", "DelFile", "error = " + ex.getMessage());
                return false;
            }
        }
        return false;
    }
}
