package com.baidu.tieba.onlineDebugger.command;

import android.content.SharedPreferences;
import android.os.Environment;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UploadCommand implements d {
    public static final String URL = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/debugupload";
    private static /* synthetic */ int[] cvS;
    private EnumUploadType cvR;
    private String path;

    /* loaded from: classes.dex */
    public enum EnumUploadType {
        SharePerference,
        DB,
        File,
        List;

        /* JADX DEBUG: Replace access to removed values field (cvT) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static EnumUploadType[] valuesCustom() {
            EnumUploadType[] valuesCustom = values();
            int length = valuesCustom.length;
            EnumUploadType[] enumUploadTypeArr = new EnumUploadType[length];
            System.arraycopy(valuesCustom, 0, enumUploadTypeArr, 0, length);
            return enumUploadTypeArr;
        }
    }

    static /* synthetic */ int[] aiC() {
        int[] iArr = cvS;
        if (iArr == null) {
            iArr = new int[EnumUploadType.valuesCustom().length];
            try {
                iArr[EnumUploadType.DB.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EnumUploadType.File.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EnumUploadType.List.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EnumUploadType.SharePerference.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            cvS = iArr;
        }
        return iArr;
    }

    public UploadCommand(EnumUploadType enumUploadType, String str) {
        this.cvR = enumUploadType;
        this.path = str;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.d
    public Object aiA() {
        String str = null;
        try {
            switch (aiC()[this.cvR.ordinal()]) {
                case 1:
                    str = c(kd(this.path), this.path);
                    break;
                case 2:
                    str = c(ke(this.path), this.path);
                    break;
                case 3:
                    if (!this.path.contains("..")) {
                        str = c(x(n.cR(this.path)), this.path);
                        break;
                    } else {
                        str = "illegal path ..";
                        break;
                    }
                case 4:
                    str = kc(this.path);
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

    private String kc(String str) {
        File cR = n.cR(str);
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
            return com.baidu.tieba.onlineDebugger.c.J(list);
        }
        return cR.getName();
    }

    private byte[] kd(String str) {
        SharedPreferences sharedPreferences = TbadkCoreApplication.m411getInst().getSharedPreferences(str, 0);
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

    private byte[] ke(String str) {
        return x(new File(Environment.getDataDirectory(), "//data//" + TbadkCoreApplication.m411getInst().getApplicationContext().getPackageName() + "//databases//" + str));
    }

    private byte[] x(File file) {
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
        abVar.o("tbs", TbadkCoreApplication.m411getInst().getTbs());
        abVar.o("type", SocialConstants.ANDROID_CLIENT_TYPE);
        return abVar.uo();
    }

    @Override // com.baidu.tieba.onlineDebugger.command.d
    public boolean aiB() {
        return !this.path.contains("..");
    }
}
