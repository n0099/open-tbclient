package com.baidu.tieba;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.MediaUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.dna;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.editvideo.muxer.VLogMultiAudioMixer;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.exoplayer2.extractor.ogg.OpusReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class vla {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] f(short s, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Short.valueOf(s), Boolean.valueOf(z)})) == null) {
            byte[] bArr = new byte[2];
            if (z) {
                bArr[1] = (byte) (s & 255);
                bArr[0] = (byte) (((short) (s >> 8)) & 255);
            } else {
                bArr[0] = (byte) (s & 255);
                bArr[1] = (byte) (((short) (s >> 8)) & 255);
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static short h(byte b2, byte b3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3), Boolean.valueOf(z)})) == null) {
            return (short) (z ? ((short) (((short) ((b2 & 255) | 0)) << 8)) | (b3 & 255) : (b2 & 255) | ((short) (((short) ((b3 & 255) | 0)) << 8)));
        }
        return invokeCommon.shortValue;
    }

    /* loaded from: classes7.dex */
    public static class a implements dna.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dna.a a;
        public final /* synthetic */ dna b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(dna.a aVar, dna dnaVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dnaVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = dnaVar;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.dna.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gna.e("FFmpegCmdExecutor-modifyAudioProperty", "onCompletion:src:" + this.c + ",:dest:" + this.d);
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onCompletion();
                }
                gna.e("FFmpegCmdExecutor-modifyAudioProperty", "release");
                this.b.release();
            }
        }

        @Override // com.baidu.tieba.dna.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = " null ";
                }
                sb.append(str);
                gna.e("FFmpegCmdExecutor-modifyAudioProperty", sb.toString());
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onError(i, i2, obj);
                }
                gna.e("FFmpegCmdExecutor-modifyAudioProperty", "release");
                this.b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.dna.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = " null ";
                }
                sb.append(str);
                gna.j("FFmpegCmdExecutor-modifyAudioProperty", sb.toString());
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onInfo(i, i2, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements dna.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dna.a a;
        public final /* synthetic */ dna b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public b(dna.a aVar, dna dnaVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dnaVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = dnaVar;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // com.baidu.tieba.dna.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gna.e("FFmpegCmdExecutor-mixAudio", "onCompletion:src:" + this.c + "," + this.d + ",:dest:" + this.e);
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onCompletion();
                }
                gna.e("FFmpegCmdExecutor-mixAudio", "release");
                this.b.release();
            }
        }

        @Override // com.baidu.tieba.dna.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = " null ";
                }
                sb.append(str);
                gna.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onError(i, i2, obj);
                }
                gna.e("FFmpegCmdExecutor-mixAudio", "release");
                this.b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.dna.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = " null ";
                }
                sb.append(str);
                gna.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onInfo(i, i2, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements dna.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dna.a a;
        public final /* synthetic */ dna b;

        public c(dna.a aVar, dna dnaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dnaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = dnaVar;
        }

        @Override // com.baidu.tieba.dna.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onCompletion();
                }
                this.b.release();
            }
        }

        @Override // com.baidu.tieba.dna.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = " null ";
                }
                sb.append(str);
                gna.e("FFmpegCmdExecutor-mixAudio", sb.toString());
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onError(i, i2, obj);
                }
                this.b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.dna.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = " null ";
                }
                sb.append(str);
                gna.j("FFmpegCmdExecutor-mixAudio", sb.toString());
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onInfo(i, i2, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements dna.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dna.a a;
        public final /* synthetic */ dna b;
        public final /* synthetic */ List c;
        public final /* synthetic */ String d;

        public d(dna.a aVar, dna dnaVar, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dnaVar, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = dnaVar;
            this.c = list;
            this.d = str;
        }

        @Override // com.baidu.tieba.dna.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gna.j("FFmpegCmdExecutor-concat", "onCompletion:inputsize:" + this.c.size() + ",dest:" + this.d);
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onCompletion();
                }
                this.b.release();
            }
        }

        @Override // com.baidu.tieba.dna.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = " null ";
                }
                sb.append(str);
                gna.j("FFmpegCmdExecutor-concat", sb.toString());
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onError(i, i2, obj);
                }
                this.b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.dna.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = " null ";
                }
                sb.append(str);
                gna.j("FFmpegCmdExecutor-concat", sb.toString());
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onInfo(i, i2, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements dna.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dna.a a;
        public final /* synthetic */ dna b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public e(dna.a aVar, dna dnaVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dnaVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = dnaVar;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // com.baidu.tieba.dna.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gna.e("FFmpegCmdExecutor-muxAudioVideo", "onCompletion:video:" + this.c + ",audio" + this.d + ",:dest:" + this.e);
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onCompletion();
                }
                gna.e("FFmpegCmdExecutor-muxAudioVideo", "release");
                this.b.release();
            }
        }

        @Override // com.baidu.tieba.dna.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = " null ";
                }
                sb.append(str);
                gna.e("FFmpegCmdExecutor-muxAudioVideo", sb.toString());
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onError(i, i2, obj);
                }
                gna.e("FFmpegCmdExecutor-muxAudioVideo", "release");
                this.b.release();
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.dna.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo i = ");
                sb.append(i);
                sb.append(" i1 = ");
                sb.append(i2);
                sb.append(" o ");
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = " null ";
                }
                sb.append(str);
                gna.e("FFmpegCmdExecutor-muxAudioVideo", sb.toString());
                dna.a aVar = this.a;
                if (aVar != null) {
                    aVar.onInfo(i, i2, obj);
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public String d;
        public int e;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = OpusReader.SAMPLE_RATE;
            this.b = 1;
            this.c = 16;
            this.e = 0;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = this.e;
                if (i != 5 && i != 6 && i != 8 && i != 9) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = this.e;
                if (i != 3 && i != 4 && i != 8 && i != 9) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.e;
                if (i == 1 || i == 4 || i == 6 || i == 9) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948246014, "Lcom/baidu/tieba/vla;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948246014, "Lcom/baidu/tieba/vla;");
                return;
            }
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            a = true;
        } else {
            a = false;
        }
    }

    public static byte[] a(byte b2, byte b3, byte b4, byte b5, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3), Byte.valueOf(b4), Byte.valueOf(b5), Boolean.valueOf(z)})) == null) {
            return f((short) ((h(b2, b3, z) / 2) + (h(b4, b5, z) / 2)), z);
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static void b(List<String> list, String str, String str2, dna.a aVar, boolean z, boolean z2) {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{list, str, str2, aVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            dna dnaVar = (dna) wna.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (lna.e(list)) {
                if (aVar != null) {
                    aVar.onError(-1, -1, "input list null");
                }
            } else if (dnaVar == null) {
                if (aVar != null) {
                    aVar.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                }
            } else {
                dnaVar.setListener(new d(aVar, dnaVar, list, str));
                if (TextUtils.isEmpty(str2)) {
                    file = new File(FileUtils.removeExtention(str) + System.currentTimeMillis() + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
                } else {
                    String fileNameWithOutExtention = FileUtils.getFileNameWithOutExtention(str);
                    file = new File(str2 + fileNameWithOutExtention + System.currentTimeMillis() + "concat.txt");
                }
                gna.j("FFmpegCmdExecutor-concat", "inputfilename:" + file.getPath());
                StringBuilder sb = new StringBuilder();
                for (String str3 : list) {
                    sb.append("file '");
                    sb.append(str3);
                    sb.append("'\n");
                }
                FileUtils.writeFile(file, sb.toString(), false);
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("-f");
                arrayList.add("concat");
                arrayList.add("-safe");
                arrayList.add("0");
                arrayList.add("-i");
                arrayList.add(file.getPath());
                if (!z) {
                    arrayList.add("-vn");
                }
                arrayList.add("-c");
                if (z2) {
                    arrayList.add("aac");
                } else {
                    arrayList.add(CommandUBCHelper.COMMAND_UBC_TYPE_COPY);
                }
                arrayList.add(str);
                dnaVar.setSource(arrayList);
                gna.e("FFmpegCmdExecutor-mixAudio", "start");
                dnaVar.start();
            }
        }
    }

    public static byte[] c(int i, int i2, byte[] bArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i, i2, bArr)) == null) {
            gna.b("convertByteWidth sourceByteWidth = " + i + " outputByteWidth = " + i2);
            if (i == i2) {
                return bArr;
            }
            int length = bArr.length;
            if (i != 1) {
                if (i == 2 && i2 == 1) {
                    int i3 = length / 2;
                    byte[] bArr2 = new byte[i3];
                    for (int i4 = 0; i4 < i3; i4++) {
                        int i5 = i4 * 2;
                        bArr2[i4] = (byte) (h(bArr[i5], bArr[i5 + 1], a) / 256);
                    }
                    return bArr2;
                }
            } else if (i2 == 2) {
                byte[] bArr3 = new byte[length * 2];
                for (int i6 = 0; i6 < length; i6++) {
                    byte[] f2 = f((short) (bArr[i6] * 256), a);
                    int i7 = i6 * 2;
                    bArr3[i7] = f2[0];
                    bArr3[i7 + 1] = f2[1];
                }
                return bArr3;
            }
            return bArr;
        }
        return (byte[]) invokeIIL.objValue;
    }

    public static byte[] d(int i, int i2, int i3, byte[] bArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bArr})) == null) {
            gna.b("convertChannelCount sourceChannelCount = " + i + " outputChannelCount = " + i2);
            if (i == i2) {
                return bArr;
            }
            if (i3 != 1 && i3 != 2) {
                return bArr;
            }
            int length = bArr.length;
            int i4 = 0;
            if (i != 1) {
                if (i == 2 && i2 == 1) {
                    int i5 = length / 2;
                    byte[] bArr2 = new byte[i5];
                    if (i3 != 1) {
                        if (i3 == 2) {
                            for (int i6 = 0; i6 < i5; i6 += 2) {
                                int i7 = i6 * 2;
                                byte[] a2 = a(bArr[i7], bArr[i7 + 1], bArr[i7 + 2], bArr[i7 + 3], a);
                                bArr2[i6] = a2[0];
                                bArr2[i6 + 1] = a2[1];
                            }
                        }
                    } else {
                        while (i4 < i5) {
                            int i8 = i4 * 2;
                            bArr2[i4] = (byte) (((short) (bArr[i8] + bArr[i8 + 1])) >> 1);
                            i4 += 2;
                        }
                    }
                    return bArr2;
                }
            } else if (i2 == 2) {
                byte[] bArr3 = new byte[length * 2];
                if (i3 != 1) {
                    if (i3 == 2) {
                        while (i4 < length) {
                            byte b2 = bArr[i4];
                            byte b3 = bArr[i4 + 1];
                            int i9 = i4 * 2;
                            bArr3[i9] = b2;
                            bArr3[i9 + 1] = b3;
                            bArr3[i9 + 2] = b2;
                            bArr3[i9 + 3] = b3;
                            i4 += 2;
                        }
                    }
                } else {
                    while (i4 < length) {
                        byte b4 = bArr[i4];
                        int i10 = i4 * 2;
                        bArr3[i10] = b4;
                        bArr3[i10 + 1] = b4;
                        i4++;
                    }
                }
                return bArr3;
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static void k(List<String> list, String str, int i, dna.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65547, null, list, str, i, aVar) == null) {
            if (lna.b(list) == 2) {
                j(list.get(0), list.get(1), str, i, aVar);
                return;
            }
            dna dnaVar = (dna) wna.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (dnaVar == null) {
                if (aVar != null) {
                    aVar.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            dnaVar.setListener(new c(aVar, dnaVar));
            ArrayList<String> arrayList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int i2 = 0;
            for (String str2 : list) {
                arrayList.add("-i");
                arrayList.add(str2);
                sb.append(PreferencesUtil.LEFT_MOUNT);
                sb.append(i2);
                sb.append(":a]volume=1");
                sb.append(PreferencesUtil.LEFT_MOUNT);
                sb.append("a");
                i2++;
                sb.append(i2);
                sb.append("];");
                sb2.append(PreferencesUtil.LEFT_MOUNT);
                sb2.append("a");
                sb2.append(i2);
                sb2.append(PreferencesUtil.RIGHT_MOUNT);
            }
            arrayList.add("-filter_complex");
            arrayList.add(String.format("%s%samix=inputs=%s[aout]", sb.toString(), sb2.toString(), Integer.valueOf(list.size())));
            arrayList.add("-map");
            arrayList.add("[aout]");
            if (i > 0) {
                arrayList.add("-ac");
                arrayList.add(String.valueOf(i));
            }
            arrayList.add(str);
            dnaVar.setSource(arrayList);
            dnaVar.start();
        }
    }

    public static void m(String str, String str2, String str3, dna.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, str, str2, str3, aVar) == null) {
            dna dnaVar = (dna) wna.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (dnaVar == null) {
                if (aVar != null) {
                    aVar.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            dnaVar.setListener(new e(aVar, dnaVar, str, str2, str3));
            long b2 = boa.b(str2);
            long f2 = boa.f(str);
            gna.j("VideoMuxer", "muxAudioVideo,audioduration:" + b2 + ",videoDuration:" + f2);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("-i");
            arrayList.add(str);
            arrayList.add("-i");
            arrayList.add(str2);
            if (Math.abs(f2 - b2) >= 100 && b2 <= f2) {
                arrayList.add("-filter_complex");
                arrayList.add("[1:a]aloop=loop=-1:size=2e+09[aout]");
                arrayList.add("-map");
                arrayList.add("0:v");
                arrayList.add("-map");
                arrayList.add("[aout]");
                arrayList.add("-c:v");
                arrayList.add(CommandUBCHelper.COMMAND_UBC_TYPE_COPY);
            } else {
                arrayList.add("-c");
                arrayList.add(CommandUBCHelper.COMMAND_UBC_TYPE_COPY);
                arrayList.add("-map");
                arrayList.add("0:v");
                arrayList.add("-map");
                arrayList.add("1:a");
            }
            arrayList.add("-shortest");
            arrayList.add(str3);
            dnaVar.setSource(arrayList);
            gna.e("FFmpegCmdExecutor-muxAudioVideo", "start");
            dnaVar.start();
        }
    }

    @TargetApi(16)
    public static f e(String str) {
        InterceptResult invokeL;
        MediaFormat mediaFormat;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(str);
                int i4 = 0;
                while (true) {
                    if (i4 < mediaExtractor.getTrackCount()) {
                        mediaFormat = mediaExtractor.getTrackFormat(i4);
                        if (mediaFormat.getString("mime").startsWith("audio/")) {
                            mediaExtractor.selectTrack(i4);
                            break;
                        }
                        i4++;
                    } else {
                        mediaFormat = null;
                        break;
                    }
                }
                if (mediaFormat == null) {
                    mediaExtractor.release();
                    return null;
                }
                f fVar = new f();
                fVar.d = mediaFormat.getString("mime");
                if (mediaFormat.containsKey("sample-rate")) {
                    i = mediaFormat.getInteger("sample-rate");
                } else {
                    i = OpusReader.SAMPLE_RATE;
                }
                fVar.a = i;
                if (mediaFormat.containsKey("channel-count")) {
                    i2 = mediaFormat.getInteger("channel-count");
                } else {
                    i2 = 1;
                }
                fVar.b = i2;
                if (mediaFormat.containsKey("bit-width")) {
                    i3 = mediaFormat.getInteger("bit-width");
                } else {
                    i3 = 16;
                }
                fVar.c = i3;
                mediaExtractor.release();
                return fVar;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (f) invokeL.objValue;
    }

    public static int g(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, mediaFormat)) == null) {
            String string = mediaFormat.getString("mime");
            if (string.startsWith(com.sina.weibo.sdk.utils.FileUtils.VIDEO_FILE_START)) {
                return 1;
            }
            if (string.startsWith("audio/")) {
                return 2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean i(f... fVarArr) {
        InterceptResult invokeL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, fVarArr)) == null) {
            if (fVarArr == null || fVarArr.length < 2 || (fVar = fVarArr[0]) == null) {
                return false;
            }
            boolean z = true;
            for (int i = 1; i < fVarArr.length; i++) {
                if (fVar.a != fVarArr[i].a) {
                    fVarArr[i].e++;
                    z = false;
                }
                if (fVar.b != fVarArr[i].b) {
                    fVarArr[i].e += 3;
                    z = false;
                }
                if (fVar.c != fVarArr[i].c) {
                    fVarArr[i].e += 5;
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void j(String str, String str2, String str3, int i, dna.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, str2, str3, Integer.valueOf(i), aVar}) == null) {
            dna dnaVar = (dna) wna.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            if (dnaVar == null) {
                if (aVar != null) {
                    aVar.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            gna.e("FFmpegCmdExecutor-mixAudio", "new mixAudio");
            dnaVar.setListener(new b(aVar, dnaVar, str, str2, str3));
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("-i");
            arrayList.add(str);
            arrayList.add("-i");
            arrayList.add(str2);
            arrayList.add("-filter_complex");
            arrayList.add("[0:a] [1:a]amerge=inputs=2[aout]");
            arrayList.add("-map");
            arrayList.add("[aout]");
            if (i > 0) {
                arrayList.add("-ac");
                arrayList.add(String.valueOf(i));
            }
            arrayList.add(str3);
            dnaVar.setSource(arrayList);
            dnaVar.start();
        }
    }

    public static void l(String str, String str2, int i, int i2, float f2, int i3, float f3, float f4, boolean z, dna.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z), aVar}) == null) {
            float f5 = f3 * 1000.0f;
            if (r9 < (f4 * 1000.0f) + f5 || f4 <= 0.0f) {
                f4 = (r9 - f5) / 1000.0f;
            }
            gna.c(VLogMultiAudioMixer.TAG, "modifyAudioProperty - duration" + f4);
            dna dnaVar = (dna) wna.a("com.baidu.ugc.api.ffmpeg.MFFmpegCmdExecutor");
            gna.e("FFmpegCmdExecutor-modifyAudioProperty", "MFFmpegCmdExecutor modifyAudioProperty new");
            if (dnaVar == null) {
                if (aVar != null) {
                    aVar.onError(-1, -1, "can not find MFFmpegCmdExecutor");
                    return;
                }
                return;
            }
            dnaVar.setListener(new a(aVar, dnaVar, str, str2));
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("-i");
            arrayList.add(str);
            if (f4 > 0.0f) {
                arrayList.add("-ss");
                arrayList.add(String.valueOf(f3));
                arrayList.add("-t");
                arrayList.add(String.valueOf(f4));
            }
            if (i > 0) {
                arrayList.add("-ar");
                arrayList.add(String.valueOf(i));
            }
            if (i2 > 0) {
                arrayList.add("-ac");
                arrayList.add(String.valueOf(i2));
            }
            if (f2 >= 0.0f) {
                arrayList.add("-af");
                arrayList.add("volume=" + f2);
            }
            arrayList.add("-acodec");
            arrayList.add("aac");
            arrayList.add(str2);
            dnaVar.setSource(arrayList);
            gna.e("FFmpegCmdExecutor-modifyAudioProperty", "start");
            dnaVar.start();
        }
    }

    public static boolean n(String str, String str2, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65550, null, str, str2, i, i2)) == null) {
            if (i2 == i) {
                return false;
            }
            File file = new File(str);
            File file2 = new File(str2);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                new xla(fileInputStream, fileOutputStream, i, i2, 2, 2, 1, Integer.MAX_VALUE, 0.0d, 0, true);
                fileInputStream.close();
                fileOutputStream.close();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                gna.e(MediaUtils.TAG, "resamplefail:" + e2.getMessage());
                return false;
            }
        }
        return invokeLLII.booleanValue;
    }
}
