package com.bytedance.pangle.res.a;

import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class c {
    public static com.bytedance.pangle.util.d<Integer, byte[]> a(MappedByteBuffer mappedByteBuffer, int i, String str) {
        if (mappedByteBuffer.getInt(i) == 67324752) {
            int i2 = mappedByteBuffer.getInt(i + 18);
            int i3 = mappedByteBuffer.getInt(i + 22);
            if (i2 == i3) {
                byte[] bArr = new byte[i3];
                int i4 = i + 30 + mappedByteBuffer.getShort(i + 26) + mappedByteBuffer.getShort(i + 28);
                for (int i5 = 0; i5 < i3; i5++) {
                    bArr[i5] = mappedByteBuffer.get(i4 + i5);
                }
                return new com.bytedance.pangle.util.d<>(Integer.valueOf(i4), bArr);
            }
            throw new RuntimeException(str + " is compressed. compressSize:" + i2 + " size:" + i3);
        }
        throw new RuntimeException("Expected: 0x04034b50, got: " + mappedByteBuffer.getInt(i) + " FileName:" + str);
    }

    public static void a(File file, HashSet<String> hashSet, h hVar) {
        int i;
        MappedByteBuffer b = b(file);
        int capacity = b.capacity();
        if (capacity >= 22) {
            int i2 = capacity - 22;
            int min = Math.min(i2, 65535);
            for (int i3 = 0; i3 < min; i3++) {
                i = i2 - i3;
                if (b.getInt(i) == 101010256 && b.getShort(i + 20) == i3) {
                    break;
                }
            }
        }
        i = -1;
        if (i != -1) {
            int i4 = b.getInt(i + 12);
            int i5 = b.getInt(i + 16);
            int i6 = i4 + i5;
            while (i5 < i6) {
                if (b.getInt(i5) == 33639248) {
                    int i7 = b.getShort(i5 + 28);
                    short s = b.getShort(i5 + 30);
                    byte[] bArr = new byte[i7];
                    for (int i8 = 0; i8 < i7; i8++) {
                        bArr[i8] = b.get(i5 + 46 + i8);
                    }
                    String str = new String(bArr);
                    int i9 = b.getInt(i5 + 20);
                    int i10 = b.getInt(i5 + 24);
                    if (hashSet.contains(str)) {
                        if (i9 == i10) {
                            com.bytedance.pangle.util.d<Integer, byte[]> a = a(b, b.getInt(i5 + 42), str);
                            try {
                                byte[] bArr2 = a.b;
                                if (!TextUtils.isEmpty(str) && hVar.a(str)) {
                                    if (str.equals("AndroidManifest.xml")) {
                                        k.a(bArr2, hVar);
                                    } else if ((str.endsWith(ActivityChooserModel.HISTORY_FILE_EXTENSION) && str.startsWith("res/")) || TextUtils.equals(str, "AndroidManifest.xml")) {
                                        k.a(bArr2, hVar);
                                    } else if (str.equals("resources.arsc")) {
                                        new a(bArr2, hVar).a();
                                    }
                                }
                                for (int i11 = 0; i11 < a.b.length; i11++) {
                                    b.put(a.a.intValue() + i11, a.b[i11]);
                                }
                            } catch (Throwable th) {
                                throw new RuntimeException(th);
                            }
                        } else {
                            throw new Throwable(str + " is compressed.");
                        }
                    }
                    i5 += i7 + 46 + s;
                } else {
                    throw new RuntimeException("Expected: 0x02014b50, got: " + b.getInt(i5));
                }
            }
            return;
        }
        throw new Throwable("endOfCentralPosition == -1");
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static MappedByteBuffer b(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            FileChannel channel = randomAccessFile.getChannel();
            long size = channel.size();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, size);
            byte[] bArr = new byte[4194304];
            long j = size / 4194304;
            int i = (int) (size % 4194304);
            for (int i2 = 0; i2 < j; i2++) {
                map.get(bArr);
            }
            if (i > 0) {
                map.get(new byte[i]);
            }
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (channel != null) {
                channel.close();
            }
            randomAccessFile.close();
            return map;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final boolean a(File file) {
        String byteArrayOutputStream;
        ZipFile zipFile = new ZipFile(file);
        try {
            File file2 = new File(file.getParentFile(), "resMappingBak");
            ZipEntry entry = zipFile.getEntry("assets/ZeusResMapping");
            if (entry == null) {
                zipFile.close();
                return false;
            }
            if (file2.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file2);
                FileChannel channel = fileInputStream.getChannel();
                byteArrayOutputStream = Charset.defaultCharset().newDecoder().decode(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).asReadOnlyBuffer()).toString();
                channel.close();
                fileInputStream.close();
            } else {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                com.bytedance.pangle.util.g.a(zipFile.getInputStream(entry), byteArrayOutputStream2);
                byteArrayOutputStream = byteArrayOutputStream2.toString();
            }
            if (TextUtils.isEmpty(byteArrayOutputStream)) {
                ZeusLogger.e(ZeusLogger.TAG_INSTALL, "zeusResMappingContent empty, resMappingBakFile:" + file2.exists());
                zipFile.close();
                return false;
            }
            JSONObject jSONObject = new JSONObject(byteArrayOutputStream);
            JSONObject jSONObject2 = new JSONObject(byteArrayOutputStream);
            JSONArray jSONArray = (JSONArray) jSONObject.get("fileNames");
            final HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add((String) jSONArray.get(i));
            }
            final JSONObject jSONObject3 = (JSONObject) jSONObject.get("resMapping");
            final JSONObject jSONObject4 = (JSONObject) jSONObject2.get("resMapping");
            final int[] iArr = {0};
            a(file, hashSet, new h() { // from class: com.bytedance.pangle.res.a.c.1
                @Override // com.bytedance.pangle.res.a.h
                public final int a(int i2) {
                    String str = "0x" + Integer.toHexString(i2);
                    String str2 = (String) jSONObject3.opt(str);
                    if (str2 == null) {
                        return i2;
                    }
                    int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1], str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                    if (identifier == 0) {
                        identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1].replaceAll("_", "."), str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                    }
                    if (identifier == 0) {
                        ZeusLogger.e(ZeusLogger.TAG_INSTALL, "getIdentifier failed. resName is ".concat(String.valueOf(str2)));
                        return i2;
                    }
                    String str3 = "0x" + Integer.toHexString(identifier);
                    jSONObject4.remove(str);
                    try {
                        jSONObject4.put(str3, str2);
                    } catch (Throwable th) {
                        ZeusLogger.e(ZeusLogger.TAG_INSTALL, "update resMappingBak failed.", th);
                    }
                    if (identifier != i2) {
                        int[] iArr2 = iArr;
                        iArr2[0] = iArr2[0] + 1;
                    }
                    return identifier;
                }

                @Override // com.bytedance.pangle.res.a.h
                public final boolean a(String str) {
                    return hashSet.contains(str);
                }
            });
            ZeusLogger.d(ZeusLogger.TAG_INSTALL, "modifyRes count = " + iArr[0]);
            boolean a = com.bytedance.pangle.util.g.a(jSONObject2.toString(), new File(file.getParentFile(), "resMappingBak"));
            zipFile.close();
            return a;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    zipFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
