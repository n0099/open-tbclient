package com.baidu.tieba.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.tieba.util.TiebaLog;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Date;
import java.util.StringTokenizer;
import org.apache.http.util.EncodingUtils;
/* loaded from: classes.dex */
public class SingleBaUtility {
    Context context;
    private static char[] g_chMsgKeyArray = "stlDEFABCNOPyzghijQRSTUwxkVWXYZabcdefIJK67nopqr89LMmGH012345uv".toCharArray();
    private static char[] g_chMsgPassword = "TiebaHbrid".toCharArray();
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] base64EncodeChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    SingleBaUtility(Context mcontext) {
        this.context = mcontext;
    }

    public String getCurrentVersionName() throws PackageManager.NameNotFoundException {
        PackageManager pm = this.context.getPackageManager();
        String PackageName = this.context.getPackageName();
        PackageInfo info = pm.getPackageInfo(PackageName, 1);
        String versionName = info.versionName;
        return versionName;
    }

    public String getChannel() {
        InputStream in = null;
        try {
            try {
                in = this.context.getResources().getAssets().open("channel");
            } catch (FileNotFoundException e) {
                Log.i("singleba", "found no channel file!!!");
            }
            if (in == null) {
                return "found no channel!";
            }
            int len = in.available();
            byte[] buffer = new byte[len];
            in.read(buffer);
            String ret = EncodingUtils.getString(buffer, "UTF-8");
            return ret;
        } catch (IOException e2) {
            TiebaLog.i(getClass().getName(), "", e2.getMessage());
            return null;
        }
    }

    public static String toHexString(byte[] b) {
        if (b == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEX_DIGITS[(b[i] & 240) >>> 4]);
            sb.append(HEX_DIGITS[b[i] & 15]);
        }
        return sb.toString().toLowerCase();
    }

    public static String ToMd5(InputStream in) {
        String ret = null;
        if (in == null) {
            return null;
        }
        try {
            byte[] buffer = new byte[1024];
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            while (true) {
                int numRead = in.read(buffer);
                if (numRead <= 0) {
                    break;
                }
                md5.update(buffer, 0, numRead);
            }
            in.close();
            ret = toHexString(md5.digest());
        } catch (Exception e) {
        }
        return ret;
    }

    public static String ToMd5(String str) {
        try {
            byte[] bMsg = str.getBytes("UTF-8");
            InputStream in = new ByteArrayInputStream(bMsg);
            String ret = ToMd5(in);
            return ret;
        } catch (Exception e) {
            return null;
        }
    }

    public static String encode(byte[] data) {
        StringBuffer sb = new StringBuffer();
        int len = data.length;
        int i = 0;
        while (true) {
            if (i >= len) {
                break;
            }
            int i2 = i + 1;
            int b1 = data[i] & 255;
            if (i2 == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 3) << 4]);
                sb.append("==");
                break;
            }
            int i3 = i2 + 1;
            int b2 = data[i2] & 255;
            if (i3 == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[((b1 & 3) << 4) | ((b2 & 240) >>> 4)]);
                sb.append(base64EncodeChars[(b2 & 15) << 2]);
                sb.append("=");
                break;
            }
            int b3 = data[i3] & 255;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(base64EncodeChars[((b1 & 3) << 4) | ((b2 & 240) >>> 4)]);
            sb.append(base64EncodeChars[((b2 & 15) << 2) | ((b3 & 192) >>> 6)]);
            sb.append(base64EncodeChars[b3 & 63]);
            i = i3 + 1;
        }
        return sb.toString();
    }

    public static int strcspn(char[] s, char[] charset) {
        StringTokenizer tokenizer = new StringTokenizer(String.valueOf(s), String.valueOf(charset));
        if (tokenizer.hasMoreTokens()) {
            return tokenizer.nextToken().length();
        }
        return 0;
    }

    public static String EncryptCode(String pSrc, int iLen) {
        Date date = new Date();
        Long ulTick = Long.valueOf(date.getTime());
        int iIndex = (int) (ulTick.longValue() % (g_chMsgKeyArray.length - 1));
        char[] cArr = new char[33];
        char[] md5Str = ToMd5(pSrc).toCharArray();
        if (md5Str == null || md5Str.length != 32) {
            return null;
        }
        char[] chPassword = new char[g_chMsgPassword.length + 1];
        char[] cArr2 = new char[34];
        System.arraycopy(g_chMsgPassword, 0, chPassword, 0, g_chMsgPassword.length);
        char[] temp1 = {g_chMsgKeyArray[iIndex]};
        System.arraycopy(temp1, 0, chPassword, g_chMsgPassword.length, 1);
        char[] chPasswordMd5 = ToMd5(String.valueOf(chPassword)).toCharArray();
        if (chPasswordMd5 == null || chPasswordMd5.length != 32) {
            return null;
        }
        char[] en = new char[128];
        for (int i = 0; i < en.length; i++) {
            en[i] = 0;
        }
        String ss = String.valueOf(md5Str);
        String ss1 = encode(ss.getBytes());
        char[] temp = ss1.toCharArray();
        if (temp.length < 128) {
            en = new char[temp.length];
            for (int i2 = 0; i2 < en.length; i2++) {
                en[i2] = 0;
            }
        }
        System.arraycopy(temp, 0, en, 0, temp.length);
        int nBase64Len = en.length;
        int k = 0;
        char[] chTemp = new char[nBase64Len + 1];
        for (int i3 = 0; i3 < chTemp.length; i3++) {
            chTemp[i3] = 0;
        }
        for (int i4 = 0; i4 < nBase64Len; i4++) {
            if (k == 32) {
                k = 0;
            }
            char[] ch = {en[i4]};
            int s = strcspn(g_chMsgKeyArray, ch);
            int j = ((s + iIndex) + chPasswordMd5[k]) % g_chMsgKeyArray.length;
            char[] temp2 = {g_chMsgKeyArray[j]};
            System.arraycopy(temp2, 0, chTemp, i4, 1);
            k++;
        }
        char[] temp3 = {g_chMsgKeyArray[iIndex]};
        System.arraycopy(temp3, 0, chTemp, nBase64Len, 1);
        return String.valueOf(chTemp);
    }

    public static boolean isWebUrl(String mobiles) {
        return mobiles.startsWith("http://");
    }
}
