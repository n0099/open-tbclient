package com.baidu.tieba.onlineDebugger.command;

import android.content.SharedPreferences;
import android.os.Environment;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UploadCommand implements h {
    public static final String URL = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/debugupload";
    private static /* synthetic */ int[] dIm;
    private EnumUploadType dIl;
    private String path;

    /* loaded from: classes.dex */
    public enum EnumUploadType {
        SharePerference,
        DB,
        File,
        List,
        ANR,
        DataFile,
        DataList;

        /* JADX DEBUG: Replace access to removed values field (dIn) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static EnumUploadType[] valuesCustom() {
            EnumUploadType[] valuesCustom = values();
            int length = valuesCustom.length;
            EnumUploadType[] enumUploadTypeArr = new EnumUploadType[length];
            System.arraycopy(valuesCustom, 0, enumUploadTypeArr, 0, length);
            return enumUploadTypeArr;
        }
    }

    static /* synthetic */ int[] aCI() {
        int[] iArr = dIm;
        if (iArr == null) {
            iArr = new int[EnumUploadType.valuesCustom().length];
            try {
                iArr[EnumUploadType.ANR.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EnumUploadType.DB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EnumUploadType.DataFile.ordinal()] = 6;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EnumUploadType.DataList.ordinal()] = 7;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[EnumUploadType.File.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[EnumUploadType.List.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[EnumUploadType.SharePerference.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            dIm = iArr;
        }
        return iArr;
    }

    public UploadCommand(EnumUploadType enumUploadType, String str) {
        this.dIl = enumUploadType;
        this.path = str;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public Object aCF() {
        String str = null;
        try {
            switch (aCI()[this.dIl.ordinal()]) {
                case 1:
                    str = c(mV(this.path), this.path);
                    break;
                case 2:
                    str = c(mW(this.path), this.path);
                    break;
                case 3:
                    if (!this.path.contains("..")) {
                        str = c(w(m.cR(this.path)), this.path);
                        break;
                    } else {
                        str = "illegal path ..";
                        break;
                    }
                case 4:
                    str = mT(this.path);
                    break;
                case 5:
                    str = c(w(new File("/data/anr/traces.txt")), "traces.txt");
                    break;
                case 6:
                    if (!this.path.contains("..")) {
                        str = c(mX(this.path), this.path);
                        break;
                    } else {
                        str = "illegal path ..";
                        break;
                    }
                case 7:
                    str = mU(this.path);
                    break;
            }
        } catch (Exception e) {
            str = String.valueOf(this.path) + " not exist.";
        }
        if (str != null && !str.isEmpty()) {
            try {
                return new JSONObject(str).getString("url");
            } catch (JSONException e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return str;
    }

    private String mT(String str) {
        File cR = m.cR(str);
        if (cR == null) {
            return String.valueOf(str) + " not exist.";
        }
        if (cR != null && cR.isDirectory()) {
            String[] list = cR.list();
            if (list == null) {
                return "";
            }
            for (int i = 0; i < list.length; i++) {
                if (new File(cR.getAbsolutePath(), list[i]).isDirectory()) {
                    list[i] = String.valueOf(list[i]) + "(d)";
                }
            }
            return com.baidu.tieba.onlineDebugger.d.M(list);
        }
        return cR.getName();
    }

    private String mU(String str) {
        File file = new File(Environment.getDataDirectory(), "//data//" + TbadkCoreApplication.m9getInst().getApplicationContext().getPackageName() + "//" + str);
        if (file == null) {
            return String.valueOf(str) + " not exist.";
        }
        if (file != null && file.isDirectory()) {
            String[] list = file.list();
            if (list == null) {
                return "";
            }
            for (int i = 0; i < list.length; i++) {
                if (new File(file.getAbsolutePath(), list[i]).isDirectory()) {
                    list[i] = String.valueOf(list[i]) + "(d)";
                }
            }
            return com.baidu.tieba.onlineDebugger.d.M(list);
        }
        return file.getName();
    }

    private byte[] mV(String str) {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m9getInst().getSharedPreferences(str, 0);
        try {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                sb.append(String.valueOf(entry.getKey()) + "->" + entry.getValue().toString() + "\n");
            }
            return sb.toString().getBytes();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private byte[] mW(String str) {
        return mX("databases//" + str);
    }

    private byte[] mX(String str) {
        return w(new File(Environment.getDataDirectory(), "//data//" + TbadkCoreApplication.m9getInst().getApplicationContext().getPackageName() + "//" + str));
    }

    private byte[] w(File file) {
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            if (file.length() > 2147483647L) {
                fileInputStream.close();
                throw new IOException(String.valueOf(this.path) + " is too large.");
            }
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return bArr;
        }
        return null;
    }

    private String c(byte[] bArr, String str) {
        ab abVar = new ab(String.valueOf(URL) + "?fn=" + str.replace("/", "_"));
        abVar.d("debugfile", bArr);
        abVar.n("tbs", TbadkCoreApplication.m9getInst().getTbs());
        abVar.n("type", SocialConstants.ANDROID_CLIENT_TYPE);
        return abVar.td();
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aCG() {
        return !this.path.contains("..");
    }
}
