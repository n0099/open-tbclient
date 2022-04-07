package com.baidu.titan.sdk.verifier;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.internal.util.Closes;
import com.baidu.titan.sdk.internal.util.EncodeUtils;
import com.baidu.titan.sdk.pm.PatchInstallInfo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes4.dex */
public class SignatureVerifierKITKAT extends SignatureVerifier {
    public static final String TAG = "SigVerifier";
    public Context mContext;
    public PatchInstallInfo mInstallInfo;
    public File mPatchFile;

    public SignatureVerifierKITKAT(Context context, PatchInstallInfo patchInstallInfo) {
        super(context, patchInstallInfo.getPatchFile());
        this.mContext = context;
        this.mPatchFile = patchInstallInfo.getPatchFile();
        this.mInstallInfo = patchInstallInfo;
    }

    private int verifyExtractedDex(List<File> list) {
        ZipFile zipFile;
        InputStream inputStream;
        ZipFile zipFile2 = null;
        InputStream inputStream2 = null;
        zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(this.mPatchFile);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            for (File file : list) {
                ZipFile zipFile3 = new ZipFile(file);
                try {
                    String replace = file.getName().replace(".jar", ".dex");
                    ZipEntry entry = zipFile3.getEntry(replace);
                    ZipEntry entry2 = zipFile.getEntry(replace);
                    if (entry != null && entry2 != null) {
                        InputStream inputStream3 = zipFile3.getInputStream(entry);
                        try {
                            byte[] sha256 = EncodeUtils.sha256(inputStream3);
                            inputStream = zipFile.getInputStream(entry2);
                            try {
                                if (!Arrays.equals(sha256, EncodeUtils.sha256(inputStream))) {
                                    Closes.closeQuiet(zipFile3);
                                    Closes.closeQuiet(inputStream3);
                                    Closes.closeQuiet(inputStream);
                                    Closes.closeQuiet(zipFile);
                                    return -8;
                                }
                                Closes.closeQuiet(zipFile3);
                                Closes.closeQuiet(inputStream3);
                                Closes.closeQuiet(inputStream);
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream3;
                                Closes.closeQuiet(zipFile3);
                                Closes.closeQuiet(inputStream2);
                                Closes.closeQuiet(inputStream);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                        }
                    } else {
                        Closes.closeQuiet(zipFile3);
                        Closes.closeQuiet((InputStream) null);
                        Closes.closeQuiet((InputStream) null);
                        Closes.closeQuiet(zipFile);
                        return -8;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            }
            Closes.closeQuiet(zipFile);
            return 0;
        } catch (IOException e2) {
            e = e2;
            zipFile2 = zipFile;
            e.printStackTrace();
            Closes.closeQuiet(zipFile2);
            return -8;
        } catch (Throwable th5) {
            th = th5;
            zipFile2 = zipFile;
            Closes.closeQuiet(zipFile2);
            throw th;
        }
    }

    private int verifyOptDex() {
        File[] listFiles;
        File dexOptDir = this.mInstallInfo.getDexOptDir();
        HashMap<String, String> readOptDigests = this.mInstallInfo.readOptDigests();
        for (File file : dexOptDir.listFiles()) {
            if (!file.isDirectory() && !TextUtils.equals(EncodeUtils.bytesToHex(EncodeUtils.sha256(file)), readOptDigests.get(file.getName()))) {
                return -9;
            }
        }
        return 0;
    }

    @Override // com.baidu.titan.sdk.verifier.SignatureVerifier
    public int verifySignature() {
        System.currentTimeMillis();
        int verifySignature = super.verifySignature();
        System.currentTimeMillis();
        if (verifySignature != 0) {
            return verifySignature;
        }
        List<File> orderedDexList = this.mInstallInfo.getOrderedDexList();
        System.currentTimeMillis();
        if (!orderedDexList.isEmpty()) {
            int verifyExtractedDex = verifyExtractedDex(orderedDexList);
            System.currentTimeMillis();
            if (verifyExtractedDex != 0) {
                return verifyExtractedDex;
            }
        }
        System.currentTimeMillis();
        int verifyOptDex = verifyOptDex();
        System.currentTimeMillis();
        return verifyOptDex;
    }
}
