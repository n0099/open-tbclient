package com.baidu.tieba;

import com.baidu.tieba.write.util.PhotoType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
/* loaded from: classes6.dex */
public class t2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0072: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:47:0x0072 */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0044 -> B:61:0x0070). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PhotoType a(String str) {
        InterceptResult invokeL;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            PhotoType photoType = null;
            photoType = null;
            photoType = null;
            photoType = null;
            photoType = null;
            photoType = null;
            photoType = null;
            photoType = null;
            photoType = null;
            photoType = null;
            photoType = null;
            RandomAccessFile randomAccessFile3 = null;
            try {
                try {
                    try {
                        randomAccessFile = new RandomAccessFile(str, "r");
                        try {
                            MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, randomAccessFile.length());
                            if (map != null && map.getInt() == -1991225785 && map.getInt(4) == 218765834 && map.getInt(37) == 1633899596) {
                                photoType = PhotoType.APNG;
                            }
                            randomAccessFile.close();
                        } catch (FileNotFoundException e) {
                            e = e;
                            e.printStackTrace();
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            return photoType;
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            return photoType;
                        } catch (BufferUnderflowException e3) {
                            e = e3;
                            e.printStackTrace();
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            return photoType;
                        }
                    } catch (Throwable th) {
                        th = th;
                        randomAccessFile3 = randomAccessFile2;
                        if (randomAccessFile3 != null) {
                            try {
                                randomAccessFile3.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    randomAccessFile = null;
                } catch (IOException e6) {
                    e = e6;
                    randomAccessFile = null;
                } catch (BufferUnderflowException e7) {
                    e = e7;
                    randomAccessFile = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile3 != null) {
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e8.printStackTrace();
            }
            return photoType;
        }
        return (PhotoType) invokeL.objValue;
    }
}
