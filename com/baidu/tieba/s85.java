package com.baidu.tieba;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.ImageUploader;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.concurrent.Callable;
/* loaded from: classes5.dex */
public class s85 implements Callable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t85 a;
    public LinkedList b;
    public WriteImagesInfo c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public String m;
    public ImageUploader.a n;
    public ImageUploader.b o;
    public Object p;
    public boolean q;
    public int r;
    public NetWork s;
    public r85 t;
    public WriteData u;

    public s85(t85 t85Var, LinkedList linkedList, WriteImagesInfo writeImagesInfo, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t85Var, linkedList, writeImagesInfo, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = null;
        this.a = t85Var;
        this.b = linkedList;
        this.c = writeImagesInfo;
        this.d = z;
        this.e = i;
    }

    public void a() {
        NetWork netWork;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (netWork = this.s) != null) {
            netWork.cancelNetConnect();
        }
    }

    public void b(int i, int i2, int i3, int i4, int i5, boolean z, int i6, String str, ImageUploader.a aVar, ImageUploader.b bVar, Object obj, boolean z2, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Integer.valueOf(i6), str, aVar, bVar, obj, Boolean.valueOf(z2), Integer.valueOf(i7)}) == null) {
            this.f = i;
            this.g = i2;
            this.h = i3;
            this.i = i4;
            this.j = i5;
            this.k = z;
            this.l = i6;
            this.m = str;
            this.n = aVar;
            this.o = bVar;
            this.p = obj;
            this.q = z2;
            this.r = i7;
        }
    }

    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
            this.u = writeData;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public Boolean call() {
        InterceptResult invokeV;
        boolean isOriginalImg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ErrorData errorData = new ErrorData();
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.b.get(this.e);
            if (TextUtils.isEmpty(imageFileInfo.getTempUploadFileName())) {
                imageFileInfo.setTempUploadFileName("img_upload_temp_file_" + this.e + ".temp");
            }
            mp8.a("发帖：发送图片 上传图片 = " + this.e + " = " + imageFileInfo.toJson().toString());
            if (imageFileInfo.getImageType() == 1) {
                isOriginalImg = false;
            } else {
                isOriginalImg = this.c.isOriginalImg();
            }
            kp8.m(this.u, imageFileInfo);
            ImageUploadResult d = d(imageFileInfo, isOriginalImg, this.d, this.e + 1, this.b.size());
            kp8.d(this.u, imageFileInfo, d);
            if (d != null) {
                UploadedImageInfo uploadedPicInfo = d.getUploadedPicInfo();
                if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                    uploadedPicInfo.isGif = imageFileInfo.isGif();
                    uploadedPicInfo.isBJH = this.q;
                    imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                    return Boolean.TRUE;
                }
                errorData.setError_code(d.error_code);
                errorData.setError_msg(d.error_msg);
                mp8.a("发帖：发送图片 上传图片 错误 1= " + this.e + " = " + imageFileInfo.toJson().toString());
                this.a.a(errorData);
                return Boolean.FALSE;
            }
            errorData.setError_code(-52);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f150a));
            mp8.a("发帖：发送图片 上传图片 错误 2= " + this.e + " = " + imageFileInfo.toJson().toString());
            this.a.a(errorData);
            return Boolean.FALSE;
        }
        return (Boolean) invokeV.objValue;
    }

    public final ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z, boolean z2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.t == null) {
                this.t = new r85();
            }
            ImageUploadResult e = e(this.t.j(this.u, imageFileInfo, z), z, z2, i, i2);
            String filePath = imageFileInfo.getFilePath();
            if (z95.b.a(filePath)) {
                e.setSharpText(filePath);
            }
            return e;
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:43|(13:47|48|(1:50)(1:293)|51|52|53|54|(2:55|(6:57|58|59|(1:271)(24:61|(1:63)(5:(2:266|267)(1:(2:253|254)(1:265))|(2:259|260)|256|257|258)|64|65|(5:232|233|234|235|236)(2:67|68)|69|70|(2:72|73)(1:230)|74|(1:78)|79|80|(1:82)|83|(1:85)(1:223)|86|87|(1:89)|(6:91|(1:93)|94|(1:98)|99|(6:101|(1:103)|104|(1:106)|107|(5:110|111|(3:194|195|(1:197))|113|(2:115|(5:119|120|121|122|(2:125|126)(1:124))(1:147))(7:148|149|150|(1:152)(10:153|(4:155|156|157|158)(1:189)|159|(1:161)(1:188)|162|(5:176|177|178|179|180)(1:164)|165|166|(3:168|169|170)(1:172)|171)|121|122|(0)(0)))(2:221|220)))|222|104|(0)|107|(1:221)(5:110|111|(0)|113|(0)(0)))|36|37)(2:285|286))|127|128|129|36|37)|294|295|296|297|298|299|300|129|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0393, code lost:
        r8 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0397, code lost:
        r8.append(r27);
        r8.append(r4);
        com.baidu.tieba.mp8.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = pic = null    p = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03b1, code lost:
        r11 = r7;
        r29 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x04d3, code lost:
        r11 = r7;
        r29 = r17;
        r15 = r26;
        r16 = 0;
        r15.append(r27);
        r15.append(r4);
        r15.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x04e7, code lost:
        if (r11 != null) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x04e9, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x04eb, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x04ec, code lost:
        r15.append(r7);
        r15.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x04f4, code lost:
        if (r11 == null) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04f6, code lost:
        r15.append(r11.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x04fb, code lost:
        if (r11 != null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x04fd, code lost:
        r3 = new com.baidu.tbadk.img.ImageUploadResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0503, code lost:
        r3.error_code = -7;
        r3.error_msg = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0508, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0568, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0569, code lost:
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x056b, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0576, code lost:
        r3 = r0;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0578, code lost:
        r29 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x057e, code lost:
        r15.append("|request cancelled.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0584, code lost:
        com.baidu.adp.lib.util.BdLog.e(r3.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x058f, code lost:
        r2 = new com.baidu.tbadk.img.ImageUploadResult();
        r2.error_code = -1002;
        r2.error_msg = r3.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x059e, code lost:
        r4 = r2.error_code;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x05a2, code lost:
        r3 = r2.error_msg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x05a5, code lost:
        r3 = r3.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0165, code lost:
        r9 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0167, code lost:
        r9.append("|startChunk=");
        r9.append(r4);
        r4 = new com.baidu.tbadk.img.ImageUploadResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0174, code lost:
        r4.error_code = -54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0176, code lost:
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0179, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x017a, code lost:
        r3 = r0;
        r29 = r2;
        r2 = r4;
        r15 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01bf, code lost:
        if (r15.length != r10) goto L256;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x031e A[Catch: all -> 0x0207, Exception -> 0x020d, TRY_ENTER, TRY_LEAVE, TryCatch #11 {Exception -> 0x020d, blocks: (B:82:0x01ff, B:98:0x022d, B:103:0x026c, B:105:0x0270, B:108:0x02a2, B:111:0x02ad, B:117:0x02c2, B:119:0x02cf, B:121:0x02d9, B:122:0x02e2, B:126:0x02ef, B:127:0x02f6, B:131:0x0307, B:136:0x031e), top: B:301:0x01ff }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0351 A[Catch: all -> 0x0207, Exception -> 0x0342, TRY_ENTER, TryCatch #15 {all -> 0x0207, blocks: (B:82:0x01ff, B:98:0x022d, B:103:0x026c, B:105:0x0270, B:108:0x02a2, B:111:0x02ad, B:117:0x02c2, B:119:0x02cf, B:121:0x02d9, B:122:0x02e2, B:126:0x02ef, B:127:0x02f6, B:131:0x0307, B:136:0x031e, B:142:0x0338, B:149:0x0351, B:151:0x0371, B:154:0x0376, B:157:0x0397, B:166:0x03e2, B:173:0x03f8), top: B:301:0x01ff }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x04ab A[LOOP:0: B:41:0x015a->B:198:0x04ab, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x057e A[Catch: all -> 0x0607, TryCatch #16 {all -> 0x0607, blocks: (B:258:0x057a, B:260:0x057e, B:264:0x058f, B:266:0x059e, B:268:0x05a2, B:270:0x05a9, B:269:0x05a5, B:261:0x0584, B:195:0x0495, B:197:0x0499, B:180:0x0444, B:188:0x046f, B:190:0x0473, B:192:0x0489, B:206:0x04d3, B:210:0x04ec, B:212:0x04f6, B:214:0x04fd, B:216:0x0503), top: B:298:0x0495 }] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0584 A[Catch: all -> 0x0607, TryCatch #16 {all -> 0x0607, blocks: (B:258:0x057a, B:260:0x057e, B:264:0x058f, B:266:0x059e, B:268:0x05a2, B:270:0x05a9, B:269:0x05a5, B:261:0x0584, B:195:0x0495, B:197:0x0499, B:180:0x0444, B:188:0x046f, B:190:0x0473, B:192:0x0489, B:206:0x04d3, B:210:0x04ec, B:212:0x04f6, B:214:0x04fd, B:216:0x0503), top: B:298:0x0495 }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x058f A[Catch: all -> 0x0607, TryCatch #16 {all -> 0x0607, blocks: (B:258:0x057a, B:260:0x057e, B:264:0x058f, B:266:0x059e, B:268:0x05a2, B:270:0x05a9, B:269:0x05a5, B:261:0x0584, B:195:0x0495, B:197:0x0499, B:180:0x0444, B:188:0x046f, B:190:0x0473, B:192:0x0489, B:206:0x04d3, B:210:0x04ec, B:212:0x04f6, B:214:0x04fd, B:216:0x0503), top: B:298:0x0495 }] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x059e A[Catch: all -> 0x0607, TryCatch #16 {all -> 0x0607, blocks: (B:258:0x057a, B:260:0x057e, B:264:0x058f, B:266:0x059e, B:268:0x05a2, B:270:0x05a9, B:269:0x05a5, B:261:0x0584, B:195:0x0495, B:197:0x0499, B:180:0x0444, B:188:0x046f, B:190:0x0473, B:192:0x0489, B:206:0x04d3, B:210:0x04ec, B:212:0x04f6, B:214:0x04fd, B:216:0x0503), top: B:298:0x0495 }] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x05a2 A[Catch: all -> 0x0607, TryCatch #16 {all -> 0x0607, blocks: (B:258:0x057a, B:260:0x057e, B:264:0x058f, B:266:0x059e, B:268:0x05a2, B:270:0x05a9, B:269:0x05a5, B:261:0x0584, B:195:0x0495, B:197:0x0499, B:180:0x0444, B:188:0x046f, B:190:0x0473, B:192:0x0489, B:206:0x04d3, B:210:0x04ec, B:212:0x04f6, B:214:0x04fd, B:216:0x0503), top: B:298:0x0495 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x05a5 A[Catch: all -> 0x0607, TryCatch #16 {all -> 0x0607, blocks: (B:258:0x057a, B:260:0x057e, B:264:0x058f, B:266:0x059e, B:268:0x05a2, B:270:0x05a9, B:269:0x05a5, B:261:0x0584, B:195:0x0495, B:197:0x0499, B:180:0x0444, B:188:0x046f, B:190:0x0473, B:192:0x0489, B:206:0x04d3, B:210:0x04ec, B:212:0x04f6, B:214:0x04fd, B:216:0x0503), top: B:298:0x0495 }] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0338 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0499 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult e(String str, boolean z, boolean z2, int i, int i2) {
        InterceptResult invokeCommon;
        StringBuilder sb;
        char c;
        Throwable th;
        RandomAccessFile randomAccessFile;
        Exception exc;
        ImageUploadResult imageUploadResult;
        RandomAccessFile randomAccessFile2;
        String str2;
        String message;
        File file;
        long length;
        ImageUploadResult imageUploadResult2;
        long j;
        StringBuilder sb2;
        int i3;
        long j2;
        int i4;
        StringBuilder sb3;
        String str3;
        int i5;
        long j3;
        RandomAccessFile randomAccessFile3;
        String a;
        String postMultiNetData;
        ImageUploadResult parser;
        ImageUploadResult imageUploadResult3;
        long j4;
        int i6;
        ImageUploadResult imageUploadResult4;
        long j5;
        int i7;
        long j6;
        String str4;
        StringBuilder sb4;
        BitmapFactory.Options options;
        long j7;
        byte[] bArr;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            String str5 = str;
            mp8.a("发帖：正在上传图片 = " + str5);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            boolean z3 = true;
            options2.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str5, options2);
            byte[] bArr2 = null;
            if (options2.outWidth != 0 && options2.outHeight != 0) {
                StringBuilder sb5 = new StringBuilder();
                try {
                    try {
                        file = new File(str5);
                        length = file.length();
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile = null;
                    }
                } catch (Exception e) {
                    e = e;
                    sb = sb5;
                    c = 0;
                }
                try {
                    try {
                    } catch (Exception e2) {
                        exc = e2;
                        imageUploadResult = null;
                        randomAccessFile2 = null;
                    }
                    if ((!z && length > 5242880) || (z && length > Config.FULL_TRACE_LOG_LIMIT)) {
                        imageUploadResult = new ImageUploadResult();
                        try {
                            imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                            imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0632);
                            mp8.a("发帖：正在上传图片 失败 限制大小 = " + length + "    p = " + str5);
                            dh.b(null);
                            this.s = null;
                            return imageUploadResult;
                        } catch (Exception e3) {
                            exc = e3;
                            randomAccessFile2 = null;
                            c = 0;
                            sb = sb5;
                            if (!this.k) {
                            }
                            int i9 = -1002;
                            if (imageUploadResult == null) {
                            }
                            if (imageUploadResult != null) {
                            }
                            if (imageUploadResult == null) {
                            }
                            Object[] objArr = new Object[2];
                            objArr[c] = "comment";
                            objArr[1] = sb.toString();
                            jx4.a("img", -1L, -1, "imageUpload", i9, message, objArr);
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("发帖：正在上传图片 上传失败 = ");
                            sb6.append(i9);
                            sb6.append(" ");
                            sb6.append(message);
                            sb6.append("    p = ");
                            str2 = str;
                            sb6.append(str2);
                            mp8.a(sb6.toString());
                            dh.b(randomAccessFile2);
                            this.s = null;
                            mp8.a("发帖：上传图片 结束      p = " + str2);
                            return imageUploadResult;
                        }
                    }
                    mp8.a("发帖：正在上传图片 进行中 限制大小 = " + length + "    p = " + str5);
                    String b = mj.b(FileHelper.GetStreamFromFile(file));
                    sb5.append("path=");
                    sb5.append(str5);
                    sb5.append("|length=");
                    sb5.append(length);
                    sb5.append("|md5=");
                    sb5.append(b);
                    if (length != 0 && b != null) {
                        String str6 = b + this.f;
                        if (length % this.f == 0) {
                            j = length / this.f;
                        } else {
                            j = (length / this.f) + 1;
                        }
                        sb5.append("|chunkNo=");
                        sb5.append(j);
                        randomAccessFile = new RandomAccessFile(str5, "r");
                        try {
                            try {
                                sb5.append("|width=");
                                sb5.append(this.g);
                                sb5.append("|height=");
                                sb5.append(this.h);
                                sb5.append("|smallWidth=");
                                sb5.append(this.i);
                                sb5.append("|smallHeight=");
                                sb5.append(this.j);
                                sb5.append("|groupId=");
                                sb5.append(this.m);
                                sb2 = sb5;
                                imageUploadResult2 = null;
                                i3 = 1;
                                j2 = 0;
                                i4 = 0;
                            } catch (Exception e4) {
                                randomAccessFile2 = randomAccessFile;
                                sb = sb5;
                                c = 0;
                                exc = e4;
                                imageUploadResult = null;
                            }
                            while (true) {
                                int i10 = (i3 > j ? 1 : (i3 == j ? 0 : -1));
                                if (i10 > 0) {
                                    break;
                                }
                                try {
                                    if (this.k == z3) {
                                        break;
                                    }
                                    StringBuilder sb7 = sb2;
                                    if (i10 > 0) {
                                        j3 = j;
                                        sb3 = sb7;
                                        str3 = "|startChunk=";
                                        i5 = 0;
                                        bArr2 = null;
                                    } else {
                                        if (i10 < 0) {
                                            try {
                                                try {
                                                    sb3 = sb7;
                                                    str3 = "|startChunk=";
                                                    i5 = this.f;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    th = th;
                                                    dh.b(randomAccessFile);
                                                    this.s = null;
                                                    throw th;
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                                randomAccessFile2 = randomAccessFile;
                                                imageUploadResult = imageUploadResult2;
                                                sb = sb7;
                                                c = 0;
                                                exc = e;
                                                if (!this.k) {
                                                }
                                                int i92 = -1002;
                                                if (imageUploadResult == null) {
                                                }
                                                if (imageUploadResult != null) {
                                                }
                                                if (imageUploadResult == null) {
                                                }
                                                Object[] objArr2 = new Object[2];
                                                objArr2[c] = "comment";
                                                objArr2[1] = sb.toString();
                                                jx4.a("img", -1L, -1, "imageUpload", i92, message, objArr2);
                                                StringBuilder sb62 = new StringBuilder();
                                                sb62.append("发帖：正在上传图片 上传失败 = ");
                                                sb62.append(i92);
                                                sb62.append(" ");
                                                sb62.append(message);
                                                sb62.append("    p = ");
                                                str2 = str;
                                                sb62.append(str2);
                                                mp8.a(sb62.toString());
                                                dh.b(randomAccessFile2);
                                                this.s = null;
                                                mp8.a("发帖：上传图片 结束      p = " + str2);
                                                return imageUploadResult;
                                            }
                                        } else if (i10 == 0) {
                                            sb3 = sb7;
                                            str3 = "|startChunk=";
                                            i5 = (int) (length - (this.f * (j - 1)));
                                        } else {
                                            sb3 = sb7;
                                            str3 = "|startChunk=";
                                            i5 = 0;
                                        }
                                        if (bArr2 != null) {
                                            try {
                                            } catch (Exception e6) {
                                                e = e6;
                                                randomAccessFile2 = randomAccessFile;
                                                imageUploadResult = imageUploadResult2;
                                                sb = sb3;
                                                c = 0;
                                                exc = e;
                                                if (!this.k) {
                                                }
                                                int i922 = -1002;
                                                if (imageUploadResult == null) {
                                                }
                                                if (imageUploadResult != null) {
                                                }
                                                if (imageUploadResult == null) {
                                                }
                                                Object[] objArr22 = new Object[2];
                                                objArr22[c] = "comment";
                                                objArr22[1] = sb.toString();
                                                jx4.a("img", -1L, -1, "imageUpload", i922, message, objArr22);
                                                StringBuilder sb622 = new StringBuilder();
                                                sb622.append("发帖：正在上传图片 上传失败 = ");
                                                sb622.append(i922);
                                                sb622.append(" ");
                                                sb622.append(message);
                                                sb622.append("    p = ");
                                                str2 = str;
                                                sb622.append(str2);
                                                mp8.a(sb622.toString());
                                                dh.b(randomAccessFile2);
                                                this.s = null;
                                                mp8.a("发帖：上传图片 结束      p = " + str2);
                                                return imageUploadResult;
                                            }
                                        }
                                        try {
                                            bArr2 = new byte[i5];
                                            j3 = j;
                                            randomAccessFile.seek(this.f * (i3 - 1));
                                            randomAccessFile.read(bArr2, 0, i5);
                                        } catch (Exception e7) {
                                            e = e7;
                                            randomAccessFile2 = randomAccessFile;
                                            sb = sb3;
                                            c = 0;
                                            imageUploadResult = imageUploadResult2;
                                            exc = e;
                                            if (!this.k) {
                                            }
                                            int i9222 = -1002;
                                            if (imageUploadResult == null) {
                                            }
                                            if (imageUploadResult != null) {
                                            }
                                            if (imageUploadResult == null) {
                                            }
                                            Object[] objArr222 = new Object[2];
                                            objArr222[c] = "comment";
                                            objArr222[1] = sb.toString();
                                            jx4.a("img", -1L, -1, "imageUpload", i9222, message, objArr222);
                                            StringBuilder sb6222 = new StringBuilder();
                                            sb6222.append("发帖：正在上传图片 上传失败 = ");
                                            sb6222.append(i9222);
                                            sb6222.append(" ");
                                            sb6222.append(message);
                                            sb6222.append("    p = ");
                                            str2 = str;
                                            sb6222.append(str2);
                                            mp8.a(sb6222.toString());
                                            dh.b(randomAccessFile2);
                                            this.s = null;
                                            mp8.a("发帖：上传图片 结束      p = " + str2);
                                            return imageUploadResult;
                                        }
                                    }
                                    NetWork netWork = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                    this.s = netWork;
                                    String str7 = str6;
                                    netWork.addPostData("resourceId", str7);
                                    this.s.addPostData("chunkNo", String.valueOf(i3));
                                    if (i10 >= 0) {
                                        try {
                                            randomAccessFile3 = randomAccessFile;
                                            try {
                                                try {
                                                    this.s.addPostData("isFinish", String.valueOf(1));
                                                } catch (Exception e8) {
                                                    e = e8;
                                                    imageUploadResult = imageUploadResult2;
                                                    randomAccessFile2 = randomAccessFile3;
                                                    sb = sb3;
                                                    c = 0;
                                                    exc = e;
                                                    if (!this.k) {
                                                    }
                                                    int i92222 = -1002;
                                                    if (imageUploadResult == null) {
                                                    }
                                                    if (imageUploadResult != null) {
                                                    }
                                                    if (imageUploadResult == null) {
                                                    }
                                                    Object[] objArr2222 = new Object[2];
                                                    objArr2222[c] = "comment";
                                                    objArr2222[1] = sb.toString();
                                                    jx4.a("img", -1L, -1, "imageUpload", i92222, message, objArr2222);
                                                    StringBuilder sb62222 = new StringBuilder();
                                                    sb62222.append("发帖：正在上传图片 上传失败 = ");
                                                    sb62222.append(i92222);
                                                    sb62222.append(" ");
                                                    sb62222.append(message);
                                                    sb62222.append("    p = ");
                                                    str2 = str;
                                                    sb62222.append(str2);
                                                    mp8.a(sb62222.toString());
                                                    dh.b(randomAccessFile2);
                                                    this.s = null;
                                                    mp8.a("发帖：上传图片 结束      p = " + str2);
                                                    return imageUploadResult;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                randomAccessFile = randomAccessFile3;
                                                dh.b(randomAccessFile);
                                                this.s = null;
                                                throw th;
                                            }
                                        } catch (Exception e9) {
                                            e = e9;
                                            randomAccessFile3 = randomAccessFile;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            th = th;
                                            dh.b(randomAccessFile);
                                            this.s = null;
                                            throw th;
                                        }
                                    } else {
                                        randomAccessFile3 = randomAccessFile;
                                        this.s.addPostData("isFinish", String.valueOf(0));
                                    }
                                    if (this.q) {
                                        this.s.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(1));
                                    } else {
                                        this.s.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(0));
                                    }
                                    this.s.addPostData("size", String.valueOf(length));
                                    this.s.addPostData("width", String.valueOf(options2.outWidth));
                                    this.s.addPostData("height", String.valueOf(options2.outHeight));
                                    if (this.i > 0 && this.j > 0) {
                                        this.s.addPostData("smallWidth", String.valueOf(this.i));
                                        this.s.addPostData("smallHeight", String.valueOf(this.j));
                                    }
                                    try {
                                        try {
                                            this.s.addPostData(TbEnum.SystemMessage.KEY_GROUP_ID, String.valueOf(this.m));
                                            this.s.addPostData("alt", "json");
                                            if (bArr2 != null) {
                                                this.s.addPostData("chunk", bArr2);
                                            }
                                            if (z) {
                                                this.s.addPostData("saveOrigin", "1");
                                            } else {
                                                this.s.addPostData("saveOrigin", "0");
                                            }
                                            if (this.l != 0) {
                                                this.s.addPostData("pic_water_type", String.valueOf(this.l));
                                            }
                                            if (z2) {
                                                int b2 = jq4.c().b();
                                                if (b2 != 0) {
                                                    this.s.addPostData("pic_water_type", String.valueOf(b2));
                                                }
                                                String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                if (!StringUtils.isNull(currentAccountName) && b2 == 1) {
                                                    this.s.addPostData("user_name", currentAccountName);
                                                }
                                                String a2 = jq4.c().a();
                                                if (!StringUtils.isNull(a2)) {
                                                    if (b2 == 2) {
                                                        this.s.addPostData("forum_name", a2);
                                                    }
                                                    a = jq4.c().a();
                                                    if (!StringUtils.isNull(a)) {
                                                        this.s.addPostData("small_flow_fname", a);
                                                    }
                                                    postMultiNetData = this.s.postMultiNetData(true);
                                                    parser = ImageUploadResult.parser(postMultiNetData);
                                                    if (postMultiNetData != null || parser == null) {
                                                        break;
                                                        break;
                                                    }
                                                    try {
                                                        if (parser.error_code != 0) {
                                                            try {
                                                                if (!ImageUploadResult.shouldReply(parser.error_code)) {
                                                                    break;
                                                                }
                                                            } catch (Exception e10) {
                                                                exc = e10;
                                                                imageUploadResult = parser;
                                                                randomAccessFile2 = randomAccessFile3;
                                                                sb = sb3;
                                                                c = 0;
                                                                if (!this.k) {
                                                                }
                                                                int i922222 = -1002;
                                                                if (imageUploadResult == null) {
                                                                }
                                                                if (imageUploadResult != null) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                Object[] objArr22222 = new Object[2];
                                                                objArr22222[c] = "comment";
                                                                objArr22222[1] = sb.toString();
                                                                jx4.a("img", -1L, -1, "imageUpload", i922222, message, objArr22222);
                                                                StringBuilder sb622222 = new StringBuilder();
                                                                sb622222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb622222.append(i922222);
                                                                sb622222.append(" ");
                                                                sb622222.append(message);
                                                                sb622222.append("    p = ");
                                                                str2 = str;
                                                                sb622222.append(str2);
                                                                mp8.a(sb622222.toString());
                                                                dh.b(randomAccessFile2);
                                                                this.s = null;
                                                                mp8.a("发帖：上传图片 结束      p = " + str2);
                                                                return imageUploadResult;
                                                            }
                                                        }
                                                        if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                            mp8.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = " + parser.error_code + "    p = " + str5);
                                                            if (i3 == parser.chunkNo || parser.chunkNo <= 0) {
                                                                break;
                                                            }
                                                            i3 = parser.chunkNo;
                                                            j6 = length;
                                                            imageUploadResult3 = parser;
                                                            str4 = str7;
                                                            i8 = i4 + 1;
                                                            c = 0;
                                                            long j8 = j3;
                                                            options = options2;
                                                            randomAccessFile2 = randomAccessFile3;
                                                            j7 = j8;
                                                            StringBuilder sb8 = sb3;
                                                            bArr = bArr2;
                                                            sb = sb8;
                                                            try {
                                                                try {
                                                                    if (i8 <= this.r) {
                                                                        sb.append("|possbile dead loop found. tryCount=");
                                                                        sb.append(i8);
                                                                        sb.append(", chunkNo=");
                                                                        sb.append(j7);
                                                                        break;
                                                                    }
                                                                    i4 = i8;
                                                                    imageUploadResult2 = imageUploadResult3;
                                                                    j = j7;
                                                                    sb2 = sb;
                                                                    str6 = str4;
                                                                    bArr2 = bArr;
                                                                    options2 = options;
                                                                    randomAccessFile = randomAccessFile2;
                                                                    length = j6;
                                                                    z3 = true;
                                                                    str5 = str;
                                                                } catch (Exception e11) {
                                                                    e = e11;
                                                                    exc = e;
                                                                    imageUploadResult = imageUploadResult3;
                                                                    if (!this.k) {
                                                                    }
                                                                    int i9222222 = -1002;
                                                                    if (imageUploadResult == null) {
                                                                    }
                                                                    if (imageUploadResult != null) {
                                                                    }
                                                                    if (imageUploadResult == null) {
                                                                    }
                                                                    Object[] objArr222222 = new Object[2];
                                                                    objArr222222[c] = "comment";
                                                                    objArr222222[1] = sb.toString();
                                                                    jx4.a("img", -1L, -1, "imageUpload", i9222222, message, objArr222222);
                                                                    StringBuilder sb6222222 = new StringBuilder();
                                                                    sb6222222.append("发帖：正在上传图片 上传失败 = ");
                                                                    sb6222222.append(i9222222);
                                                                    sb6222222.append(" ");
                                                                    sb6222222.append(message);
                                                                    sb6222222.append("    p = ");
                                                                    str2 = str;
                                                                    sb6222222.append(str2);
                                                                    mp8.a(sb6222222.toString());
                                                                    dh.b(randomAccessFile2);
                                                                    this.s = null;
                                                                    mp8.a("发帖：上传图片 结束      p = " + str2);
                                                                    return imageUploadResult;
                                                                }
                                                            } catch (Throwable th6) {
                                                                th = th6;
                                                                th = th;
                                                                randomAccessFile = randomAccessFile2;
                                                                dh.b(randomAccessFile);
                                                                this.s = null;
                                                                throw th;
                                                            }
                                                        } else {
                                                            StringBuilder sb9 = sb3;
                                                            try {
                                                                if (ImageUploadResult.shouldReply(parser.error_code)) {
                                                                    j6 = length;
                                                                    imageUploadResult3 = parser;
                                                                    str4 = str7;
                                                                    bArr = bArr2;
                                                                    i8 = i4 + 1;
                                                                    c = 0;
                                                                    sb = sb9;
                                                                    long j9 = j3;
                                                                    options = options2;
                                                                    randomAccessFile2 = randomAccessFile3;
                                                                    j7 = j9;
                                                                } else {
                                                                    int i11 = i3 + 1;
                                                                    j2 += i5;
                                                                    if (i11 > 1) {
                                                                        try {
                                                                            j4 = j2 + ((i11 - 1) * this.f);
                                                                        } catch (Exception e12) {
                                                                            exc = e12;
                                                                            imageUploadResult = parser;
                                                                            sb = sb9;
                                                                            randomAccessFile2 = randomAccessFile3;
                                                                            c = 0;
                                                                            if (!this.k) {
                                                                            }
                                                                            int i92222222 = -1002;
                                                                            if (imageUploadResult == null) {
                                                                            }
                                                                            if (imageUploadResult != null) {
                                                                            }
                                                                            if (imageUploadResult == null) {
                                                                            }
                                                                            Object[] objArr2222222 = new Object[2];
                                                                            objArr2222222[c] = "comment";
                                                                            objArr2222222[1] = sb.toString();
                                                                            jx4.a("img", -1L, -1, "imageUpload", i92222222, message, objArr2222222);
                                                                            StringBuilder sb62222222 = new StringBuilder();
                                                                            sb62222222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb62222222.append(i92222222);
                                                                            sb62222222.append(" ");
                                                                            sb62222222.append(message);
                                                                            sb62222222.append("    p = ");
                                                                            str2 = str;
                                                                            sb62222222.append(str2);
                                                                            mp8.a(sb62222222.toString());
                                                                            dh.b(randomAccessFile2);
                                                                            this.s = null;
                                                                            mp8.a("发帖：上传图片 结束      p = " + str2);
                                                                            return imageUploadResult;
                                                                        }
                                                                    } else {
                                                                        j4 = j2;
                                                                    }
                                                                    if (this.c != null) {
                                                                        i6 = i11;
                                                                        this.c.hasUploadFileSize += i5;
                                                                    } else {
                                                                        i6 = i11;
                                                                    }
                                                                    mp8.a("发帖：正在上传图片 已上传 = " + j4 + "    p = " + str5);
                                                                    if (this.n != null) {
                                                                        try {
                                                                            j5 = j4;
                                                                            RandomAccessFile randomAccessFile4 = randomAccessFile3;
                                                                            i7 = i6;
                                                                            j6 = length;
                                                                            imageUploadResult4 = parser;
                                                                            str4 = str7;
                                                                            c = 0;
                                                                            sb4 = sb9;
                                                                            long j10 = j3;
                                                                            options = options2;
                                                                            randomAccessFile2 = randomAccessFile4;
                                                                            j7 = j10;
                                                                        } catch (Exception e13) {
                                                                            imageUploadResult4 = parser;
                                                                            randomAccessFile2 = randomAccessFile3;
                                                                            c = 0;
                                                                            exc = e13;
                                                                            sb = sb9;
                                                                        }
                                                                        try {
                                                                            this.n.a(str, this.p, j5, j6);
                                                                        } catch (Exception e14) {
                                                                            exc = e14;
                                                                            sb = sb4;
                                                                            imageUploadResult = imageUploadResult4;
                                                                            if (!this.k) {
                                                                            }
                                                                            int i922222222 = -1002;
                                                                            if (imageUploadResult == null) {
                                                                            }
                                                                            if (imageUploadResult != null) {
                                                                            }
                                                                            if (imageUploadResult == null) {
                                                                            }
                                                                            Object[] objArr22222222 = new Object[2];
                                                                            objArr22222222[c] = "comment";
                                                                            objArr22222222[1] = sb.toString();
                                                                            jx4.a("img", -1L, -1, "imageUpload", i922222222, message, objArr22222222);
                                                                            StringBuilder sb622222222 = new StringBuilder();
                                                                            sb622222222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb622222222.append(i922222222);
                                                                            sb622222222.append(" ");
                                                                            sb622222222.append(message);
                                                                            sb622222222.append("    p = ");
                                                                            str2 = str;
                                                                            sb622222222.append(str2);
                                                                            mp8.a(sb622222222.toString());
                                                                            dh.b(randomAccessFile2);
                                                                            this.s = null;
                                                                            mp8.a("发帖：上传图片 结束      p = " + str2);
                                                                            return imageUploadResult;
                                                                        }
                                                                    } else {
                                                                        j5 = j4;
                                                                        j6 = length;
                                                                        imageUploadResult4 = parser;
                                                                        c = 0;
                                                                        sb4 = sb9;
                                                                        int i12 = i6;
                                                                        str4 = str7;
                                                                        long j11 = j3;
                                                                        options = options2;
                                                                        randomAccessFile2 = randomAccessFile3;
                                                                        i7 = i12;
                                                                        j7 = j11;
                                                                    }
                                                                    try {
                                                                        if (this.o != null) {
                                                                            long j12 = j5;
                                                                            bArr = bArr2;
                                                                            imageUploadResult3 = imageUploadResult4;
                                                                            sb = sb4;
                                                                            this.o.a(str, this.p, j12, j6, i, i2);
                                                                        } else {
                                                                            imageUploadResult3 = imageUploadResult4;
                                                                            bArr = bArr2;
                                                                            sb = sb4;
                                                                        }
                                                                        i3 = i7;
                                                                        i8 = i4;
                                                                    } catch (Exception e15) {
                                                                        e = e15;
                                                                        sb = sb4;
                                                                        imageUploadResult3 = imageUploadResult4;
                                                                        exc = e;
                                                                        imageUploadResult = imageUploadResult3;
                                                                        if (!this.k) {
                                                                        }
                                                                        int i9222222222 = -1002;
                                                                        if (imageUploadResult == null) {
                                                                        }
                                                                        if (imageUploadResult != null) {
                                                                        }
                                                                        if (imageUploadResult == null) {
                                                                        }
                                                                        Object[] objArr222222222 = new Object[2];
                                                                        objArr222222222[c] = "comment";
                                                                        objArr222222222[1] = sb.toString();
                                                                        jx4.a("img", -1L, -1, "imageUpload", i9222222222, message, objArr222222222);
                                                                        StringBuilder sb6222222222 = new StringBuilder();
                                                                        sb6222222222.append("发帖：正在上传图片 上传失败 = ");
                                                                        sb6222222222.append(i9222222222);
                                                                        sb6222222222.append(" ");
                                                                        sb6222222222.append(message);
                                                                        sb6222222222.append("    p = ");
                                                                        str2 = str;
                                                                        sb6222222222.append(str2);
                                                                        mp8.a(sb6222222222.toString());
                                                                        dh.b(randomAccessFile2);
                                                                        this.s = null;
                                                                        mp8.a("发帖：上传图片 结束      p = " + str2);
                                                                        return imageUploadResult;
                                                                    }
                                                                }
                                                                if (i8 <= this.r) {
                                                                }
                                                            } catch (Exception e16) {
                                                                e = e16;
                                                                imageUploadResult3 = parser;
                                                                sb = sb9;
                                                                randomAccessFile2 = randomAccessFile3;
                                                                c = 0;
                                                                exc = e;
                                                                imageUploadResult = imageUploadResult3;
                                                                if (!this.k) {
                                                                }
                                                                int i92222222222 = -1002;
                                                                if (imageUploadResult == null) {
                                                                }
                                                                if (imageUploadResult != null) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                Object[] objArr2222222222 = new Object[2];
                                                                objArr2222222222[c] = "comment";
                                                                objArr2222222222[1] = sb.toString();
                                                                jx4.a("img", -1L, -1, "imageUpload", i92222222222, message, objArr2222222222);
                                                                StringBuilder sb62222222222 = new StringBuilder();
                                                                sb62222222222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb62222222222.append(i92222222222);
                                                                sb62222222222.append(" ");
                                                                sb62222222222.append(message);
                                                                sb62222222222.append("    p = ");
                                                                str2 = str;
                                                                sb62222222222.append(str2);
                                                                mp8.a(sb62222222222.toString());
                                                                dh.b(randomAccessFile2);
                                                                this.s = null;
                                                                mp8.a("发帖：上传图片 结束      p = " + str2);
                                                                return imageUploadResult;
                                                            }
                                                        }
                                                    } catch (Exception e17) {
                                                        e = e17;
                                                        imageUploadResult3 = parser;
                                                        randomAccessFile2 = randomAccessFile3;
                                                        sb = sb3;
                                                    }
                                                }
                                            }
                                            a = jq4.c().a();
                                            if (!StringUtils.isNull(a)) {
                                            }
                                            postMultiNetData = this.s.postMultiNetData(true);
                                            parser = ImageUploadResult.parser(postMultiNetData);
                                            if (postMultiNetData != null) {
                                                break;
                                            }
                                            if (parser.error_code != 0) {
                                            }
                                            if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                            }
                                        } catch (Exception e18) {
                                            e = e18;
                                            randomAccessFile2 = randomAccessFile3;
                                            sb = sb3;
                                            c = 0;
                                            imageUploadResult = imageUploadResult2;
                                            exc = e;
                                            if (!this.k) {
                                            }
                                            int i922222222222 = -1002;
                                            if (imageUploadResult == null) {
                                            }
                                            if (imageUploadResult != null) {
                                            }
                                            if (imageUploadResult == null) {
                                            }
                                            Object[] objArr22222222222 = new Object[2];
                                            objArr22222222222[c] = "comment";
                                            objArr22222222222[1] = sb.toString();
                                            jx4.a("img", -1L, -1, "imageUpload", i922222222222, message, objArr22222222222);
                                            StringBuilder sb622222222222 = new StringBuilder();
                                            sb622222222222.append("发帖：正在上传图片 上传失败 = ");
                                            sb622222222222.append(i922222222222);
                                            sb622222222222.append(" ");
                                            sb622222222222.append(message);
                                            sb622222222222.append("    p = ");
                                            str2 = str;
                                            sb622222222222.append(str2);
                                            mp8.a(sb622222222222.toString());
                                            dh.b(randomAccessFile2);
                                            this.s = null;
                                            mp8.a("发帖：上传图片 结束      p = " + str2);
                                            return imageUploadResult;
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        randomAccessFile2 = randomAccessFile3;
                                    }
                                } catch (Exception e19) {
                                    e = e19;
                                    randomAccessFile2 = randomAccessFile;
                                    sb = sb2;
                                }
                                mp8.a("发帖：上传图片 结束      p = " + str2);
                                return imageUploadResult;
                            }
                            imageUploadResult2 = imageUploadResult3;
                            randomAccessFile = randomAccessFile2;
                            dh.b(randomAccessFile);
                            this.s = null;
                            imageUploadResult = imageUploadResult2;
                            str2 = str;
                            mp8.a("发帖：上传图片 结束      p = " + str2);
                            return imageUploadResult;
                        } catch (Throwable th8) {
                            th = th8;
                        }
                    }
                    sb = sb5;
                    c = 0;
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = -1007;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0630);
                    imageUploadResult2 = imageUploadResult;
                    randomAccessFile = null;
                    dh.b(randomAccessFile);
                    this.s = null;
                    imageUploadResult = imageUploadResult2;
                    str2 = str;
                    mp8.a("发帖：上传图片 结束      p = " + str2);
                    return imageUploadResult;
                } catch (Throwable th9) {
                    th = th9;
                    randomAccessFile = null;
                }
            } else {
                mp8.a("发帖：正在上传图片 失败 = " + str5);
                return null;
            }
        } else {
            return (ImageUploadResult) invokeCommon.objValue;
        }
    }
}
