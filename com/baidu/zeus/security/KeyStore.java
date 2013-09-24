package com.baidu.zeus.security;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import com.baidu.zeus.WebChromeClient;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class KeyStore {
    public static final String EXTRA_CERTIFICATE = "CERT";
    public static final String EXTRA_PKCS12 = "PKCS12";
    public static final int KEY_NOT_FOUND = 7;
    public static final int LOCKED = 2;
    public static final int NO_ERROR = 1;
    public static final int PERMISSION_DENIED = 6;
    public static final int PROTOCOL_ERROR = 5;
    public static final int SYSTEM_ERROR = 4;
    public static final int UNDEFINED_ACTION = 9;
    public static final int UNINITIALIZED = 3;
    public static final int VALUE_CORRUPTED = 8;
    public static final int WRONG_PASSWORD = 10;
    private static final LocalSocketAddress sAddress = new LocalSocketAddress("keystore", LocalSocketAddress.Namespace.RESERVED);
    private int mError = 1;

    private KeyStore() {
    }

    public static KeyStore getInstance() {
        return new KeyStore();
    }

    public int test() {
        execute(116, new byte[0]);
        return this.mError;
    }

    public byte[] get(byte[] bArr) {
        ArrayList<byte[]> execute = execute(103, bArr);
        if (execute == null || execute.isEmpty()) {
            return null;
        }
        return execute.get(0);
    }

    public String get(String str) {
        byte[] bArr = get(getBytes(str));
        if (bArr == null) {
            return null;
        }
        return toString(bArr);
    }

    public boolean put(byte[] bArr, byte[] bArr2) {
        execute(WebChromeClient.STRING_DLG_TITLE_COLOR, bArr, bArr2);
        return this.mError == 1;
    }

    public boolean put(String str, String str2) {
        return put(getBytes(str), getBytes(str2));
    }

    public boolean delete(byte[] bArr) {
        execute(100, bArr);
        return this.mError == 1;
    }

    public boolean delete(String str) {
        return delete(getBytes(str));
    }

    public boolean contains(byte[] bArr) {
        execute(WebChromeClient.STRING_DLG_TITLE_DATETIME, bArr);
        return this.mError == 1;
    }

    public boolean contains(String str) {
        return contains(getBytes(str));
    }

    public byte[][] saw(byte[] bArr) {
        ArrayList<byte[]> execute = execute(115, bArr);
        if (execute == null) {
            return null;
        }
        return (byte[][]) execute.toArray(new byte[execute.size()]);
    }

    public String[] saw(String str) {
        byte[][] saw = saw(getBytes(str));
        if (saw == null) {
            return null;
        }
        String[] strArr = new String[saw.length];
        for (int i = 0; i < saw.length; i++) {
            strArr[i] = toString(saw[i]);
        }
        return strArr;
    }

    public boolean reset() {
        execute(114, new byte[0]);
        return this.mError == 1;
    }

    public boolean password(byte[] bArr, byte[] bArr2) {
        execute(112, bArr, bArr2);
        return this.mError == 1;
    }

    public boolean password(String str, String str2) {
        return password(getBytes(str), getBytes(str2));
    }

    public boolean password(byte[] bArr) {
        return password(bArr, bArr);
    }

    public boolean password(String str) {
        return password(getBytes(str));
    }

    public boolean lock() {
        execute(108, new byte[0]);
        return this.mError == 1;
    }

    public boolean unlock(byte[] bArr) {
        execute(117, bArr);
        return this.mError == 1;
    }

    public boolean unlock(String str) {
        return unlock(getBytes(str));
    }

    public int getLastError() {
        return this.mError;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [222=6, 223=6] */
    private ArrayList<byte[]> execute(int i, byte[]... bArr) {
        this.mError = 5;
        for (byte[] bArr2 : bArr) {
            if (bArr2 == null || bArr2.length > 65535) {
                return null;
            }
        }
        LocalSocket localSocket = new LocalSocket();
        try {
            localSocket.connect(sAddress);
            OutputStream outputStream = localSocket.getOutputStream();
            outputStream.write(i);
            for (byte[] bArr3 : bArr) {
                outputStream.write(bArr3.length >> 8);
                outputStream.write(bArr3.length);
                outputStream.write(bArr3);
            }
            outputStream.flush();
            localSocket.shutdownOutput();
            InputStream inputStream = localSocket.getInputStream();
            int read = inputStream.read();
            if (read != 1) {
                if (read != -1) {
                    this.mError = read;
                }
                try {
                    localSocket.close();
                    return null;
                } catch (IOException e) {
                    return null;
                }
            }
            ArrayList<byte[]> arrayList = new ArrayList<>();
            while (true) {
                int read2 = inputStream.read();
                if (read2 == -1) {
                    this.mError = 1;
                    try {
                        localSocket.close();
                    } catch (IOException e2) {
                    }
                    return arrayList;
                }
                int read3 = inputStream.read();
                if (read3 == -1) {
                    try {
                        localSocket.close();
                        return null;
                    } catch (IOException e3) {
                        return null;
                    }
                }
                byte[] bArr4 = new byte[(read2 << 8) | read3];
                int i2 = 0;
                while (i2 < bArr4.length) {
                    int read4 = inputStream.read(bArr4, i2, bArr4.length - i2);
                    if (read4 == -1) {
                        try {
                            localSocket.close();
                            return null;
                        } catch (IOException e4) {
                            return null;
                        }
                    }
                    i2 += read4;
                }
                arrayList.add(bArr4);
            }
        } catch (IOException e5) {
            try {
                localSocket.close();
                return null;
            } catch (IOException e6) {
                return null;
            }
        } catch (Throwable th) {
            try {
                localSocket.close();
            } catch (IOException e7) {
            }
            throw th;
        }
    }

    private static byte[] getBytes(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String toString(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
