package com.baidu.zeus;

import android.util.Log;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class ZeusScaleStore {
    static final String LOGTAG = "ScaleStore";
    private static int mCount = 0;
    private final int CAPACITY = 100;
    private final String FILE_NAME = "/zeus_scale.1.dat";
    private Hashtable mHashTab = null;
    private String mPath;

    public ZeusScaleStore(String str) {
        this.mPath = str;
    }

    private String genKey(String str) {
        int indexOf;
        String str2 = "";
        try {
            URL url = new URL(str);
            str2 = url.getHost();
            String path = url.getPath();
            if (path.length() > 1) {
                if (path.indexOf("/", 1) == -1) {
                    str2 = str2 + path;
                } else {
                    str2 = str2 + path.substring(0, indexOf);
                }
            }
        } catch (MalformedURLException e) {
        }
        return str2;
    }

    public synchronized void put(String str, float f) {
        if (str != null) {
            if (str.length() != 0 && f > 0.1f) {
                if (this.mHashTab == null) {
                    this.mHashTab = new Hashtable(100);
                }
                if (this.mHashTab.size() == 100) {
                    this.mHashTab.remove(this.mHashTab.keys().nextElement());
                }
                String genKey = genKey(str);
                if (genKey.length() > 0) {
                    if (this.mHashTab.containsKey(genKey)) {
                        this.mHashTab.remove(genKey);
                    }
                    this.mHashTab.put(genKey, Float.valueOf(f));
                }
            }
        }
    }

    public synchronized void remove(String str) {
        if (this.mHashTab != null && str != null && str.length() != 0) {
            String genKey = genKey(str);
            if (genKey.length() > 0 && this.mHashTab.containsKey(genKey)) {
                this.mHashTab.remove(genKey);
            }
        }
    }

    public synchronized float get(String str) {
        float f = 0.0f;
        synchronized (this) {
            if (this.mHashTab != null && str != null && str.length() != 0) {
                String genKey = genKey(str);
                if (genKey.length() > 0 && this.mHashTab.containsKey(genKey)) {
                    f = new Float(this.mHashTab.get(genKey).toString()).floatValue();
                }
            }
        }
        return f;
    }

    public void save() {
        if (this.mHashTab != null) {
            Log.e(LOGTAG, "saving...");
            try {
                String str = this.mPath + "/zeus_scale.1.dat";
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(this.mHashTab);
                objectOutputStream.close();
                fileOutputStream.close();
                Log.e(LOGTAG, "save to " + str + " num=" + this.mHashTab.size());
            } catch (FileNotFoundException e) {
            } catch (IOException e2) {
            }
        }
    }

    public void load() {
        if (this.mHashTab == null) {
            mCount++;
            Log.e(LOGTAG, "loading... " + mCount);
            try {
                String str = this.mPath + "/zeus_scale.1.dat";
                FileInputStream fileInputStream = new FileInputStream(str);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                this.mHashTab = (Hashtable) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                Log.e(LOGTAG, "load from " + str + " num=" + this.mHashTab.size());
            } catch (FileNotFoundException e) {
            } catch (IOException e2) {
            } catch (ClassNotFoundException e3) {
            }
        }
    }

    public void list() {
        if (this.mHashTab != null) {
            int i = 0;
            Enumeration keys = this.mHashTab.keys();
            while (keys.hasMoreElements()) {
                Object nextElement = keys.nextElement();
                i++;
                Log.e(LOGTAG, i + ") host " + nextElement + " scale " + this.mHashTab.get(nextElement));
            }
        }
    }
}
