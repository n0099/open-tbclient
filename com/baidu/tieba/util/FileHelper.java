package com.baidu.tieba.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
        } else if (status.equals("unmounted")) {
            String error2 = TiebaApplication.app.getString(R.string.error_sd_unmount);
            return error2;
        } else if (status.equals("shared")) {
            String error3 = TiebaApplication.app.getString(R.string.error_sd_shared);
            return error3;
        } else {
            String error4 = TiebaApplication.app.getString(R.string.error_sd_full);
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
        File file = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + filename);
        return file;
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
                if (file.exists()) {
                    return file;
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

    public static String SaveFile(String path, String filename, Bitmap bm) {
        String all_path;
        if (path != null) {
            all_path = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + path + "/";
        } else {
            all_path = EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/";
        }
        if (!CheckTempDir(all_path) || bm == null) {
            return null;
        }
        File file = new File(all_path + filename);
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
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
        return BitmapFactory.decodeFile(all_path + filename);
    }

    public static String SaveFile(String filename, byte[] data) {
        if (!CheckTempDir() || data == null) {
            return null;
        }
        File file = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + filename);
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

    public static InputStream GetStreamFromFile(String filename) {
        File file = GetFile(filename);
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
