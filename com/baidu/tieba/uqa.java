package com.baidu.tieba;

import android.media.MediaMetadataRetriever;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class uqa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(InputStream inputStream, String str, hhb hhbVar) throws IOException {
        double d;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, inputStream, str, hhbVar)) == null) {
            try {
                if (inputStream instanceof FileInputStream) {
                    d = ((FileInputStream) inputStream).getChannel().size();
                } else {
                    d = 0.0d;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                byte[] bArr = new byte[1444];
                int i = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                    if (hhbVar != null && d != 0.0d) {
                        hhbVar.b((int) ((i / d) * 100.0d));
                    } else if (hhbVar != null && d == 0.0d) {
                        hhbVar.b(80);
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                return true;
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(String str, String str2, hhb hhbVar) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, hhbVar)) == null) {
            return a(new FileInputStream(str), str2, hhbVar);
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0082 -> B:25:0x0085). Please submit an issue!!! */
    public static VideoFileInfo c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                VideoFileInfo videoFileInfo = new VideoFileInfo();
                videoFileInfo.videoPath = str;
                videoFileInfo.lastModified = file.lastModified();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(str);
                            videoFileInfo.videoDuration = JavaTypesHelper.toInt(mediaMetadataRetriever.extractMetadata(9), 0);
                            videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                            videoFileInfo.videoWidth = JavaTypesHelper.toInt(mediaMetadataRetriever.extractMetadata(18), 0);
                            videoFileInfo.videoHeight = JavaTypesHelper.toInt(mediaMetadataRetriever.extractMetadata(19), 0);
                            int i = JavaTypesHelper.toInt(mediaMetadataRetriever.extractMetadata(24), 0);
                            if (i == 90 || i == 270) {
                                int i2 = videoFileInfo.videoWidth;
                                videoFileInfo.videoWidth = videoFileInfo.videoHeight;
                                videoFileInfo.videoHeight = i2;
                            }
                            mediaMetadataRetriever.release();
                        } catch (Exception e) {
                            e.printStackTrace();
                            mediaMetadataRetriever.release();
                        }
                    } catch (Throwable th) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                return videoFileInfo;
            }
            return null;
        }
        return (VideoFileInfo) invokeL.objValue;
    }
}
