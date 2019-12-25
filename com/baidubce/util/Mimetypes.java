package com.baidubce.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/* loaded from: classes.dex */
public class Mimetypes {
    public static final String MIMETYPE_OCTET_STREAM = "application/octet-stream";
    private static Mimetypes mimetypes = null;
    private HashMap<String, String> extensionToMimetypeMap = new HashMap<>();

    private Mimetypes() {
    }

    public static synchronized Mimetypes getInstance() {
        Mimetypes mimetypes2;
        synchronized (Mimetypes.class) {
            if (mimetypes != null) {
                mimetypes2 = mimetypes;
            } else {
                mimetypes = new Mimetypes();
                InputStream resourceAsStream = mimetypes.getClass().getResourceAsStream("/mime.types");
                if (resourceAsStream != null) {
                    BLog.debug("Loading mime types from file in the classpath: mime.types");
                    try {
                        mimetypes.loadAndReplaceMimetypes(resourceAsStream);
                        try {
                            resourceAsStream.close();
                        } catch (IOException e) {
                            BLog.debug("", (Throwable) e);
                        }
                    } catch (IOException e2) {
                        BLog.error("Failed to load mime types from file in the classpath: mime.types", (Throwable) e2);
                        try {
                            resourceAsStream.close();
                        } catch (IOException e3) {
                            BLog.debug("", (Throwable) e3);
                        }
                    }
                } else {
                    BLog.warn("Unable to find 'mime.types' file in classpath");
                }
                mimetypes2 = mimetypes;
            }
        }
        return mimetypes2;
    }

    public void loadAndReplaceMimetypes(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String trim = readLine.trim();
                if (!trim.startsWith("#") && trim.length() != 0) {
                    StringTokenizer stringTokenizer = new StringTokenizer(trim, " \t");
                    if (stringTokenizer.countTokens() > 1) {
                        String nextToken = stringTokenizer.nextToken();
                        while (stringTokenizer.hasMoreTokens()) {
                            String nextToken2 = stringTokenizer.nextToken();
                            this.extensionToMimetypeMap.put(nextToken2.toLowerCase(), nextToken);
                            BLog.debug("Setting mime type for extension '" + nextToken2.toLowerCase() + "' to '" + nextToken + "'");
                        }
                    } else {
                        BLog.debug("Ignoring mimetype with no associated file extensions: '" + trim + "'");
                    }
                }
            } else {
                return;
            }
        }
    }

    public String getMimetype(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf > 0 && lastIndexOf + 1 < str.length()) {
            String lowerCase = str.substring(lastIndexOf + 1).toLowerCase();
            if (this.extensionToMimetypeMap.keySet().contains(lowerCase)) {
                String str2 = this.extensionToMimetypeMap.get(lowerCase);
                BLog.debug("Recognised extension '" + lowerCase + "', mimetype is: '" + str2 + "'");
                return str2;
            }
            BLog.debug("Extension '" + lowerCase + "' is unrecognized in mime type listing, using default mime type: 'application/octet-stream'");
        } else {
            BLog.debug("File name has no extension, mime type cannot be recognised for: " + str);
        }
        return "application/octet-stream";
    }

    public String getMimetype(File file) {
        return getMimetype(file.getName());
    }
}
