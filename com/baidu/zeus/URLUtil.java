package com.baidu.zeus;

import android.net.Uri;
import android.util.Log;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.loginshare.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class URLUtil {
    static final String ASSET_BASE = "file:///android_asset/";
    private static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);
    static final String FILE_BASE = "file://";
    private static final String LOGTAG = "webkit";
    static final String PROXY_BASE = "file:///cookieless_proxy/";
    static final String RESOURCE_BASE = "file:///android_res/";

    public static String guessUrl(String str) {
        Log.v(LOGTAG, "guessURL before queueRequest: " + str);
        if (str.length() != 0 && !str.startsWith("about:") && !str.startsWith("data:") && !str.startsWith("file:") && !str.startsWith("javascript:")) {
            try {
                WebAddress webAddress = new WebAddress(str.endsWith(".") ? str.substring(0, str.length() - 1) : str);
                if (webAddress.mHost.indexOf(46) == -1) {
                    webAddress.mHost = "www." + webAddress.mHost + ".com";
                }
                return webAddress.toString();
            } catch (ParseException e) {
                return str;
            }
        }
        return str;
    }

    public static String composeSearchUrl(String str, String str2, String str3) {
        int indexOf = str2.indexOf(str3);
        if (indexOf < 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2.substring(0, indexOf));
        try {
            sb.append(URLEncoder.encode(str, BdUtil.UTF8));
            sb.append(str2.substring(str3.length() + indexOf));
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static byte[] decode(byte[] bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            byte b = bArr[i];
            if (b == 37) {
                if (bArr.length - i > 2) {
                    b = (byte) ((parseHex(bArr[i + 1]) * 16) + parseHex(bArr[i + 2]));
                    i += 2;
                } else {
                    throw new IllegalArgumentException("Invalid format");
                }
            }
            bArr2[i2] = b;
            i++;
            i2++;
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 0, i2);
        return bArr3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean verifyURLEncoding(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int indexOf = str.indexOf(37);
        while (indexOf >= 0 && indexOf < length) {
            char charAt = str.charAt(indexOf + 1);
            if (charAt == 'u' || charAt == 'U') {
                indexOf++;
            }
            if (indexOf >= length - 2) {
                return false;
            }
            int i = indexOf + 1;
            try {
                parseHex((byte) str.charAt(i));
                int i2 = i + 1;
                parseHex((byte) str.charAt(i2));
                indexOf = str.indexOf(37, i2 + 1);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return true;
    }

    private static int parseHex(byte b) {
        if (b < 48 || b > 57) {
            if (b < 65 || b > 70) {
                if (b < 97 || b > 102) {
                    throw new IllegalArgumentException("Invalid hex char '" + ((int) b) + "'");
                }
                return (b - 97) + 10;
            }
            return (b - 65) + 10;
        }
        return b - 48;
    }

    public static boolean isAssetUrl(String str) {
        return str != null && str.startsWith(ASSET_BASE);
    }

    public static boolean isResourceUrl(String str) {
        return str != null && str.startsWith(RESOURCE_BASE);
    }

    @Deprecated
    public static boolean isCookielessProxyUrl(String str) {
        return str != null && str.startsWith(PROXY_BASE);
    }

    public static boolean isFileUrl(String str) {
        return (str == null || !str.startsWith(FILE_BASE) || str.startsWith(ASSET_BASE) || str.startsWith(PROXY_BASE)) ? false : true;
    }

    public static boolean isAboutUrl(String str) {
        return str != null && str.startsWith("about:");
    }

    public static boolean isDataUrl(String str) {
        return str != null && str.startsWith("data:");
    }

    public static boolean isJavaScriptUrl(String str) {
        return str != null && str.startsWith("javascript:");
    }

    public static boolean isHttpUrl(String str) {
        return str != null && str.length() > 6 && str.substring(0, 7).equalsIgnoreCase(e.f);
    }

    public static boolean isHttpsUrl(String str) {
        return str != null && str.length() > 7 && str.substring(0, 8).equalsIgnoreCase(e.g);
    }

    public static boolean isNetworkUrl(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return isHttpUrl(str) || isHttpsUrl(str);
    }

    public static boolean isContentUrl(String str) {
        return str != null && str.startsWith("content:");
    }

    public static boolean isValidUrl(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return isAssetUrl(str) || isResourceUrl(str) || isFileUrl(str) || isAboutUrl(str) || isHttpUrl(str) || isHttpsUrl(str) || isJavaScriptUrl(str) || isContentUrl(str);
    }

    public static String stripAnchor(String str) {
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String guessFileName(String str, String str2, String str3) {
        String str4;
        String str5;
        int indexOf;
        String decode;
        int lastIndexOf;
        int lastIndexOf2;
        String str6 = null;
        if (0 != 0 || str2 == null) {
            str4 = null;
        } else {
            str4 = parseContentDisposition(str2);
            if (str4 != null && (lastIndexOf2 = str4.lastIndexOf(47) + 1) > 0) {
                str4 = str4.substring(lastIndexOf2);
            }
        }
        if (str4 == null && (decode = Uri.decode(str)) != null) {
            int indexOf2 = decode.indexOf(63);
            if (indexOf2 > 0) {
                decode = decode.substring(0, indexOf2);
            }
            if (!decode.endsWith("/") && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
                str5 = decode.substring(lastIndexOf);
                if (str5 == null) {
                    str5 = "downloadfile";
                }
                indexOf = str5.indexOf(46);
                if (indexOf >= 0) {
                    if (str3 != null && (str6 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3)) != null) {
                        str6 = "." + str6;
                    }
                    if (str6 == null) {
                        if (str3 != null && str3.toLowerCase().startsWith("text/")) {
                            if (str3.equalsIgnoreCase("text/html")) {
                                str6 = ".html";
                            } else {
                                str6 = ".txt";
                            }
                        } else {
                            str6 = ".bin";
                        }
                    }
                } else {
                    if (str3 != null) {
                        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str5.substring(str5.lastIndexOf(46) + 1));
                        if (mimeTypeFromExtension != null && !mimeTypeFromExtension.equalsIgnoreCase(str3) && (str6 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3)) != null) {
                            str6 = "." + str6;
                        }
                    }
                    if (str6 == null) {
                        str6 = str5.substring(indexOf);
                    }
                    str5 = str5.substring(0, indexOf);
                }
                return str5 + str6;
            }
        }
        str5 = str4;
        if (str5 == null) {
        }
        indexOf = str5.indexOf(46);
        if (indexOf >= 0) {
        }
        return str5 + str6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String parseContentDisposition(String str) {
        try {
            Matcher matcher = CONTENT_DISPOSITION_PATTERN.matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
        } catch (IllegalStateException e) {
        }
        return null;
    }
}
