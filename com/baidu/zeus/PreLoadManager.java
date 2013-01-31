package com.baidu.zeus;

import android.content.Context;
import android.os.FileUtils;
import com.baidu.browser.explorer.BdWebErrorView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class PreLoadManager {
    private static File mBaseDir;
    private static String mDirectory;
    private static Map preloadMaps;
    private static PreLoadManager sRef = null;

    private PreLoadManager() {
        preloadMaps = new HashMap();
    }

    public static synchronized PreLoadManager getInstance() {
        PreLoadManager preLoadManager;
        synchronized (PreLoadManager.class) {
            if (sRef == null) {
                sRef = new PreLoadManager();
            }
            preLoadManager = sRef;
        }
        return preLoadManager;
    }

    public static void init(Context context) {
        mDirectory = context.getDir("preloadCache", 0).getPath();
        mBaseDir = new File(mDirectory);
        if (createCacheDirectory()) {
            removeAllCacheFiles();
        }
    }

    static boolean removeAllCacheFiles() {
        if (mBaseDir != null) {
            new Thread(new Runnable() { // from class: com.baidu.zeus.PreLoadManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String[] list = PreLoadManager.mBaseDir.list();
                        if (list != null) {
                            for (String str : list) {
                                if (!new File(PreLoadManager.mBaseDir, str).delete()) {
                                }
                            }
                        }
                    } catch (SecurityException e) {
                    }
                    if (PreLoadManager.preloadMaps != null) {
                        PreLoadManager.preloadMaps.clear();
                    }
                }
            }).start();
        }
        return true;
    }

    private static boolean createCacheDirectory() {
        if (mBaseDir.exists()) {
            return true;
        }
        if (!mBaseDir.mkdirs()) {
            return false;
        }
        FileUtils.setPermissions(mBaseDir.toString(), BdWebErrorView.ERROR_CODE_505, -1, -1);
        return true;
    }

    public void setPreLoadUrl(int i, String str) {
        if (preloadMaps != null) {
            preloadMaps.put(Integer.valueOf(i), str);
        }
    }

    public String urlPreLoad(int i) {
        Object obj;
        if (preloadMaps == null || (obj = preloadMaps.get(Integer.valueOf(i))) == null) {
            return null;
        }
        return (String) obj;
    }

    public String urlPreLoadPath(int i) {
        return "file://" + mDirectory + "/preload" + i;
    }

    public synchronized OutputStream createCacheFile(int i) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(mBaseDir, "preload" + i));
        } catch (FileNotFoundException e) {
            fileOutputStream = null;
        }
        return fileOutputStream;
    }

    public synchronized boolean removePreLoad(int i) {
        boolean z;
        if (preloadMaps != null) {
            File file = new File(mBaseDir, "preload" + i);
            if (file.exists() && !file.delete()) {
                z = false;
            } else {
                preloadMaps.remove(Integer.valueOf(i));
            }
        }
        z = true;
        return z;
    }

    public void removeAllPreloads() {
        removeAllCacheFiles();
    }
}
