package com.baidu.titan.sdk.internal.util;

import android.content.Context;
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes11.dex */
public class Files {
    public static String getAssetFileContent(Context context, String str) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(context.getAssets().open(str));
            try {
                char[] cArr = new char[10240];
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read > 0) {
                        charArrayWriter.write(cArr, 0, read);
                    } else {
                        String charArrayWriter2 = charArrayWriter.toString();
                        Closes.closeQuiet((Reader) inputStreamReader);
                        return charArrayWriter2;
                    }
                }
            } catch (Exception unused) {
                Closes.closeQuiet((Reader) inputStreamReader);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStreamReader2 = inputStreamReader;
                Closes.closeQuiet((Reader) inputStreamReader2);
                throw th;
            }
        } catch (Exception unused2) {
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String getFileStringContent(File file) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                char[] cArr = new char[8192];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read > 0) {
                        charArrayWriter.write(cArr, 0, read);
                    } else {
                        String charArrayWriter2 = charArrayWriter.toString();
                        Closes.closeQuiet((Reader) bufferedReader);
                        return charArrayWriter2;
                    }
                }
            } catch (IOException unused) {
                Closes.closeQuiet((Reader) bufferedReader);
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                Closes.closeQuiet((Reader) bufferedReader2);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
