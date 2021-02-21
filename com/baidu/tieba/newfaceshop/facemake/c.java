package com.baidu.tieba.newfaceshop.facemake;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/* loaded from: classes9.dex */
public class c {
    public static final String lAt = com.baidu.tieba.newfaceshop.c.lAt + "draft/";
    public static final String lAT = lAt + "upload_draft";

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [46=4] */
    public static void a(FaceGroupDraft faceGroupDraft) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                File file = new File(lAt);
                if (!file.exists()) {
                    file.mkdirs();
                }
                diE();
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(lAT));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            objectOutputStream.writeObject(faceGroupDraft);
            com.baidu.adp.lib.f.a.close((OutputStream) objectOutputStream);
        } catch (FileNotFoundException e3) {
            e = e3;
            objectOutputStream2 = objectOutputStream;
            e.printStackTrace();
            com.baidu.adp.lib.f.a.close((OutputStream) objectOutputStream2);
        } catch (IOException e4) {
            e = e4;
            objectOutputStream2 = objectOutputStream;
            e.printStackTrace();
            com.baidu.adp.lib.f.a.close((OutputStream) objectOutputStream2);
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream2 = objectOutputStream;
            th.printStackTrace();
            com.baidu.adp.lib.f.a.close((OutputStream) objectOutputStream2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4] */
    public static FaceGroupDraft diD() {
        ObjectInputStream objectInputStream;
        FaceGroupDraft faceGroupDraft;
        File file = new File(lAT);
        try {
            if (!file.exists()) {
                return null;
            }
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                try {
                    Object readObject = objectInputStream.readObject();
                    faceGroupDraft = (readObject == null || !(readObject instanceof FaceGroupDraft)) ? null : (FaceGroupDraft) readObject;
                } catch (IOException e) {
                    e = e;
                    faceGroupDraft = null;
                } catch (ClassNotFoundException e2) {
                    e = e2;
                    faceGroupDraft = null;
                } catch (Throwable th) {
                    th = th;
                    faceGroupDraft = null;
                }
                try {
                    objectInputStream.close();
                    com.baidu.adp.lib.f.a.close((InputStream) objectInputStream);
                    return faceGroupDraft;
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    com.baidu.adp.lib.f.a.close((InputStream) objectInputStream);
                    return faceGroupDraft;
                } catch (ClassNotFoundException e4) {
                    e = e4;
                    e.printStackTrace();
                    com.baidu.adp.lib.f.a.close((InputStream) objectInputStream);
                    return faceGroupDraft;
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    com.baidu.adp.lib.f.a.close((InputStream) objectInputStream);
                    return faceGroupDraft;
                }
            } catch (IOException e5) {
                e = e5;
                objectInputStream = null;
                faceGroupDraft = null;
            } catch (ClassNotFoundException e6) {
                e = e6;
                objectInputStream = null;
                faceGroupDraft = null;
            } catch (Throwable th3) {
                th = th3;
                com.baidu.adp.lib.f.a.close((InputStream) null);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static void diE() {
        File file = new File(lAT);
        if (file.exists()) {
            file.delete();
        }
    }
}
