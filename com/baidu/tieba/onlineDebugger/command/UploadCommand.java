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
    private static /* synthetic */ int[] eiv;
    private EnumUploadType eiu;
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

        /* JADX DEBUG: Replace access to removed values field (eiw) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static EnumUploadType[] valuesCustom() {
            EnumUploadType[] valuesCustom = values();
            int length = valuesCustom.length;
            EnumUploadType[] enumUploadTypeArr = new EnumUploadType[length];
            System.arraycopy(valuesCustom, 0, enumUploadTypeArr, 0, length);
            return enumUploadTypeArr;
        }
    }

    static /* synthetic */ int[] aLl() {
        int[] iArr = eiv;
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
            eiv = iArr;
        }
        return iArr;
    }

    public UploadCommand(EnumUploadType enumUploadType, String str) {
        this.eiu = enumUploadType;
        this.path = str;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public Object aLi() throws IOException {
        String str = null;
        try {
            switch (aLl()[this.eiu.ordinal()]) {
                case 1:
                    str = c(oE(this.path), this.path);
                    break;
                case 2:
                    str = c(oF(this.path), this.path);
                    break;
                case 3:
                    if (!this.path.contains("..")) {
                        str = c(x(m.cW(this.path)), this.path);
                        break;
                    } else {
                        str = "illegal path ..";
                        break;
                    }
                case 4:
                    str = oC(this.path);
                    break;
                case 5:
                    str = c(x(new File("/data/anr/traces.txt")), "traces.txt");
                    break;
                case 6:
                    if (!this.path.contains("..")) {
                        str = c(oG(this.path), this.path);
                        break;
                    } else {
                        str = "illegal path ..";
                        break;
                    }
                case 7:
                    str = oD(this.path);
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

    private String oC(String str) {
        File cW = m.cW(str);
        if (cW == null) {
            return String.valueOf(str) + " not exist.";
        }
        if (cW != null && cW.isDirectory()) {
            String[] list = cW.list();
            if (list == null) {
                return "";
            }
            for (int i = 0; i < list.length; i++) {
                if (new File(cW.getAbsolutePath(), list[i]).isDirectory()) {
                    list[i] = String.valueOf(list[i]) + "(d)";
                }
            }
            return com.baidu.tieba.onlineDebugger.d.R(list);
        }
        return cW.getName();
    }

    private String oD(String str) {
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
            return com.baidu.tieba.onlineDebugger.d.R(list);
        }
        return file.getName();
    }

    private byte[] oE(String str) {
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

    private byte[] oF(String str) throws IOException {
        return oG("databases//" + str);
    }

    private byte[] oG(String str) throws IOException {
        return x(new File(Environment.getDataDirectory(), "//data//" + TbadkCoreApplication.m9getInst().getApplicationContext().getPackageName() + "//" + str));
    }

    private byte[] x(File file) throws IOException {
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
        return abVar.ux();
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aLj() {
        return !this.path.contains("..");
    }
}
