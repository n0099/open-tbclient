package com.baidu.tieba;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
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
/* loaded from: classes6.dex */
public class ln5 implements Callable<Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mn5 a;
    public LinkedList<ImageFileInfo> b;
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
    public kn5 t;
    public WriteData u;

    public ln5(mn5 mn5Var, LinkedList<ImageFileInfo> linkedList, WriteImagesInfo writeImagesInfo, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mn5Var, linkedList, writeImagesInfo, Boolean.valueOf(z), Integer.valueOf(i)};
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
        this.a = mn5Var;
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
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() {
        InterceptResult invokeV;
        boolean isOriginalImg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ErrorData errorData = new ErrorData();
            ImageFileInfo imageFileInfo = this.b.get(this.e);
            if (TextUtils.isEmpty(imageFileInfo.getTempUploadFileName())) {
                imageFileInfo.setTempUploadFileName("img_upload_temp_file_" + this.e + ".temp");
            }
            vea.a("发帖：发送图片 上传图片 = " + this.e + " = " + imageFileInfo.toJson().toString());
            if (imageFileInfo.getImageType() == 1) {
                isOriginalImg = false;
            } else {
                isOriginalImg = this.c.isOriginalImg();
            }
            tea.m(this.u, imageFileInfo);
            ImageUploadResult d = d(imageFileInfo, isOriginalImg, this.d, this.e + 1, this.b.size());
            tea.d(this.u, imageFileInfo, d);
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
                vea.a("发帖：发送图片 上传图片 错误 1= " + this.e + " = " + imageFileInfo.toJson().toString());
                this.a.a(errorData);
                return Boolean.FALSE;
            }
            errorData.setError_code(-52);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
            vea.a("发帖：发送图片 上传图片 错误 2= " + this.e + " = " + imageFileInfo.toJson().toString());
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
                this.t = new kn5();
            }
            ImageUploadResult e = e(this.t.j(this.u, imageFileInfo, z), z, z2, i, i2);
            String filePath = imageFileInfo.getFilePath();
            if (pp5.b.a(filePath)) {
                e.setSharpText(filePath);
            }
            return e;
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:43|(13:47|48|(1:50)(1:314)|51|53|54|55|(2:56|(6:58|59|60|(1:293)(26:62|(1:64)(5:(2:288|289)(1:(2:275|276)(1:287))|(2:281|282)|278|279|280)|65|66|(5:255|256|257|258|259)(2:68|69)|70|71|(1:73)(1:253)|74|(1:78)|79|80|(1:82)|83|(1:85)(1:246)|86|87|(1:89)|(8:91|(1:93)|94|(1:98)|99|(1:103)|104|(8:106|(1:108)|109|(1:113)|114|(1:116)|117|(9:120|121|(3:218|219|(1:221))|123|(2:125|(2:129|130)(1:160))(4:161|162|163|(1:165)(14:166|(4:168|169|170|171)(1:214)|172|173|(1:175)|176|(5:192|193|194|195|196)(1:178)|179|180|(3:182|183|184)(1:186)|185|132|133|(2:136|137)(1:135)))|131|132|133|(0)(0))(2:244|243)))|245|109|(2:111|113)|114|(0)|117|(1:244)(9:120|121|(0)|123|(0)(0)|131|132|133|(0)(0)))|36|37)(2:307|308))|138|139|140|36|37)|315|316|317|318|319|320|321|140|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03b1, code lost:
        r3 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x03b5, code lost:
        r3.append(r27);
        r3.append(r4);
        com.baidu.tieba.vea.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = pic = null    p = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x03cf, code lost:
        r13 = r8;
        r25 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03d4, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03d5, code lost:
        r11 = r3;
        r2 = r8;
        r25 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x050f, code lost:
        r13 = r8;
        r25 = r17;
        r11 = r26;
        r16 = 0;
        r11.append(r27);
        r11.append(r4);
        r11.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0523, code lost:
        if (r13 != null) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0525, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0527, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0528, code lost:
        r11.append(r7);
        r11.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0530, code lost:
        if (r13 == null) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0532, code lost:
        r11.append(r13.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0537, code lost:
        if (r13 != null) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0539, code lost:
        r3 = new com.baidu.tbadk.img.ImageUploadResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x053f, code lost:
        r3.error_code = -7;
        r3.error_msg = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0544, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x05a4, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x05a5, code lost:
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x05a7, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x05b2, code lost:
        r3 = r0;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x05b4, code lost:
        r25 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0166, code lost:
        r9 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0168, code lost:
        r9.append("|startChunk=");
        r9.append(r4);
        r4 = new com.baidu.tbadk.img.ImageUploadResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0175, code lost:
        r4.error_code = -54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0177, code lost:
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x017a, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x017b, code lost:
        r3 = r0;
        r25 = r2;
        r2 = r4;
        r11 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01be, code lost:
        if (r15.length != r10) goto L278;
     */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0348 A[Catch: all -> 0x0206, Exception -> 0x020c, TRY_ENTER, TRY_LEAVE, TryCatch #19 {Exception -> 0x020c, blocks: (B:81:0x01fe, B:97:0x022c, B:102:0x026a, B:104:0x026e, B:107:0x02a0, B:110:0x02ab, B:116:0x02c0, B:118:0x02cd, B:120:0x02d7, B:121:0x02e0, B:125:0x02ed, B:126:0x02f4, B:128:0x0300, B:130:0x030c, B:131:0x0312, B:135:0x031b, B:140:0x0330, B:142:0x033c, B:145:0x0348), top: B:322:0x01fe }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x037b A[Catch: all -> 0x0206, Exception -> 0x036c, TRY_ENTER, TryCatch #2 {Exception -> 0x036c, blocks: (B:151:0x0362, B:158:0x037b, B:160:0x039b, B:163:0x03a0), top: B:304:0x0362 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04d9 A[LOOP:0: B:41:0x015b->B:212:0x04d9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x05ba A[Catch: all -> 0x0643, TryCatch #18 {all -> 0x0643, blocks: (B:276:0x05b6, B:278:0x05ba, B:282:0x05cb, B:284:0x05da, B:286:0x05de, B:288:0x05e5, B:287:0x05e1, B:279:0x05c0, B:209:0x04c3, B:211:0x04c7, B:206:0x04b4, B:224:0x050f, B:228:0x0528, B:230:0x0532, B:232:0x0539, B:234:0x053f), top: B:321:0x04c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x05c0 A[Catch: all -> 0x0643, TryCatch #18 {all -> 0x0643, blocks: (B:276:0x05b6, B:278:0x05ba, B:282:0x05cb, B:284:0x05da, B:286:0x05de, B:288:0x05e5, B:287:0x05e1, B:279:0x05c0, B:209:0x04c3, B:211:0x04c7, B:206:0x04b4, B:224:0x050f, B:228:0x0528, B:230:0x0532, B:232:0x0539, B:234:0x053f), top: B:321:0x04c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x05cb A[Catch: all -> 0x0643, TryCatch #18 {all -> 0x0643, blocks: (B:276:0x05b6, B:278:0x05ba, B:282:0x05cb, B:284:0x05da, B:286:0x05de, B:288:0x05e5, B:287:0x05e1, B:279:0x05c0, B:209:0x04c3, B:211:0x04c7, B:206:0x04b4, B:224:0x050f, B:228:0x0528, B:230:0x0532, B:232:0x0539, B:234:0x053f), top: B:321:0x04c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x05da A[Catch: all -> 0x0643, TryCatch #18 {all -> 0x0643, blocks: (B:276:0x05b6, B:278:0x05ba, B:282:0x05cb, B:284:0x05da, B:286:0x05de, B:288:0x05e5, B:287:0x05e1, B:279:0x05c0, B:209:0x04c3, B:211:0x04c7, B:206:0x04b4, B:224:0x050f, B:228:0x0528, B:230:0x0532, B:232:0x0539, B:234:0x053f), top: B:321:0x04c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x05de A[Catch: all -> 0x0643, TryCatch #18 {all -> 0x0643, blocks: (B:276:0x05b6, B:278:0x05ba, B:282:0x05cb, B:284:0x05da, B:286:0x05de, B:288:0x05e5, B:287:0x05e1, B:279:0x05c0, B:209:0x04c3, B:211:0x04c7, B:206:0x04b4, B:224:0x050f, B:228:0x0528, B:230:0x0532, B:232:0x0539, B:234:0x053f), top: B:321:0x04c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x05e1 A[Catch: all -> 0x0643, TryCatch #18 {all -> 0x0643, blocks: (B:276:0x05b6, B:278:0x05ba, B:282:0x05cb, B:284:0x05da, B:286:0x05de, B:288:0x05e5, B:287:0x05e1, B:279:0x05c0, B:209:0x04c3, B:211:0x04c7, B:206:0x04b4, B:224:0x050f, B:228:0x0528, B:230:0x0532, B:232:0x0539, B:234:0x053f), top: B:321:0x04c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0362 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x04c7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult e(String str, boolean z, boolean z2, int i, int i2) {
        InterceptResult invokeCommon;
        Throwable th;
        RandomAccessFile randomAccessFile;
        StringBuilder sb;
        char c;
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
        RandomAccessFile randomAccessFile4;
        StringBuilder sb4;
        int i6;
        long j5;
        BitmapFactory.Options options;
        String str4;
        long j6;
        long j7;
        byte[] bArr;
        long j8;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            String str5 = str;
            vea.a("发帖：正在上传图片 = " + str5);
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
                    } catch (Exception e) {
                        e = e;
                        sb = sb5;
                        c = 0;
                    }
                    try {
                        try {
                        } catch (Exception e2) {
                            exc = e2;
                            sb = sb5;
                            imageUploadResult = null;
                            randomAccessFile2 = null;
                        }
                        if ((!z && length > 5242880) || (z && length > Config.FULL_TRACE_LOG_LIMIT)) {
                            imageUploadResult = new ImageUploadResult();
                            try {
                                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
                                vea.a("发帖：正在上传图片 失败 限制大小 = " + length + "    p = " + str5);
                                vg.b(null);
                                this.s = null;
                                return imageUploadResult;
                            } catch (Exception e3) {
                                exc = e3;
                                sb = sb5;
                                randomAccessFile2 = null;
                            }
                        } else {
                            vea.a("发帖：正在上传图片 进行中 限制大小 = " + length + "    p = " + str5);
                            String b = fj.b(FileHelper.GetStreamFromFile(file));
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
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (Exception e4) {
                                    randomAccessFile2 = randomAccessFile;
                                    sb = sb5;
                                    c = 0;
                                    exc = e4;
                                    imageUploadResult = null;
                                }
                                while (true) {
                                    int i8 = (i3 > j ? 1 : (i3 == j ? 0 : -1));
                                    if (i8 > 0) {
                                        break;
                                    }
                                    try {
                                        if (this.k == z3) {
                                            break;
                                        }
                                        StringBuilder sb6 = sb2;
                                        if (i8 > 0) {
                                            j3 = j;
                                            sb3 = sb6;
                                            str3 = "|startChunk=";
                                            i5 = 0;
                                            bArr2 = null;
                                        } else {
                                            if (i8 < 0) {
                                                try {
                                                    try {
                                                        sb3 = sb6;
                                                        str3 = "|startChunk=";
                                                        i5 = this.f;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        th = th;
                                                        vg.b(randomAccessFile);
                                                        this.s = null;
                                                        throw th;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    randomAccessFile2 = randomAccessFile;
                                                    imageUploadResult = imageUploadResult2;
                                                    sb = sb6;
                                                    c = 0;
                                                    exc = e;
                                                    if (this.k) {
                                                    }
                                                    int i9 = -1002;
                                                    if (imageUploadResult == null) {
                                                    }
                                                    if (imageUploadResult != null) {
                                                    }
                                                    if (imageUploadResult != null) {
                                                    }
                                                    Object[] objArr = new Object[2];
                                                    objArr[c] = "comment";
                                                    objArr[1] = sb.toString();
                                                    s95.a("img", -1L, -1, "imageUpload", i9, message, objArr);
                                                    StringBuilder sb7 = new StringBuilder();
                                                    sb7.append("发帖：正在上传图片 上传失败 = ");
                                                    sb7.append(i9);
                                                    sb7.append(" ");
                                                    sb7.append(message);
                                                    sb7.append("    p = ");
                                                    str2 = str;
                                                    sb7.append(str2);
                                                    vea.a(sb7.toString());
                                                    vg.b(randomAccessFile2);
                                                    this.s = null;
                                                    vea.a("发帖：上传图片 结束      p = " + str2);
                                                    return imageUploadResult;
                                                }
                                            } else if (i8 == 0) {
                                                sb3 = sb6;
                                                str3 = "|startChunk=";
                                                i5 = (int) (length - (this.f * (j - 1)));
                                            } else {
                                                sb3 = sb6;
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
                                                    if (this.k) {
                                                    }
                                                    int i92 = -1002;
                                                    if (imageUploadResult == null) {
                                                    }
                                                    if (imageUploadResult != null) {
                                                    }
                                                    if (imageUploadResult != null) {
                                                    }
                                                    Object[] objArr2 = new Object[2];
                                                    objArr2[c] = "comment";
                                                    objArr2[1] = sb.toString();
                                                    s95.a("img", -1L, -1, "imageUpload", i92, message, objArr2);
                                                    StringBuilder sb72 = new StringBuilder();
                                                    sb72.append("发帖：正在上传图片 上传失败 = ");
                                                    sb72.append(i92);
                                                    sb72.append(" ");
                                                    sb72.append(message);
                                                    sb72.append("    p = ");
                                                    str2 = str;
                                                    sb72.append(str2);
                                                    vea.a(sb72.toString());
                                                    vg.b(randomAccessFile2);
                                                    this.s = null;
                                                    vea.a("发帖：上传图片 结束      p = " + str2);
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
                                                if (this.k) {
                                                }
                                                int i922 = -1002;
                                                if (imageUploadResult == null) {
                                                }
                                                if (imageUploadResult != null) {
                                                }
                                                if (imageUploadResult != null) {
                                                }
                                                Object[] objArr22 = new Object[2];
                                                objArr22[c] = "comment";
                                                objArr22[1] = sb.toString();
                                                s95.a("img", -1L, -1, "imageUpload", i922, message, objArr22);
                                                StringBuilder sb722 = new StringBuilder();
                                                sb722.append("发帖：正在上传图片 上传失败 = ");
                                                sb722.append(i922);
                                                sb722.append(" ");
                                                sb722.append(message);
                                                sb722.append("    p = ");
                                                str2 = str;
                                                sb722.append(str2);
                                                vea.a(sb722.toString());
                                                vg.b(randomAccessFile2);
                                                this.s = null;
                                                vea.a("发帖：上传图片 结束      p = " + str2);
                                                return imageUploadResult;
                                            }
                                        }
                                        NetWork netWork = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                        this.s = netWork;
                                        String str7 = str6;
                                        netWork.addPostData("resourceId", str7);
                                        this.s.addPostData("chunkNo", String.valueOf(i3));
                                        if (i8 >= 0) {
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
                                                        if (this.k) {
                                                        }
                                                        int i9222 = -1002;
                                                        if (imageUploadResult == null) {
                                                        }
                                                        if (imageUploadResult != null) {
                                                        }
                                                        if (imageUploadResult != null) {
                                                        }
                                                        Object[] objArr222 = new Object[2];
                                                        objArr222[c] = "comment";
                                                        objArr222[1] = sb.toString();
                                                        s95.a("img", -1L, -1, "imageUpload", i9222, message, objArr222);
                                                        StringBuilder sb7222 = new StringBuilder();
                                                        sb7222.append("发帖：正在上传图片 上传失败 = ");
                                                        sb7222.append(i9222);
                                                        sb7222.append(" ");
                                                        sb7222.append(message);
                                                        sb7222.append("    p = ");
                                                        str2 = str;
                                                        sb7222.append(str2);
                                                        vea.a(sb7222.toString());
                                                        vg.b(randomAccessFile2);
                                                        this.s = null;
                                                        vea.a("发帖：上传图片 结束      p = " + str2);
                                                        return imageUploadResult;
                                                    }
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    randomAccessFile = randomAccessFile3;
                                                    vg.b(randomAccessFile);
                                                    this.s = null;
                                                    throw th;
                                                }
                                            } catch (Exception e9) {
                                                e = e9;
                                                randomAccessFile3 = randomAccessFile;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                th = th;
                                                vg.b(randomAccessFile);
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
                                                    int b2 = a15.c().b();
                                                    if (b2 != 0) {
                                                        this.s.addPostData("pic_water_type", String.valueOf(b2));
                                                    }
                                                    String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                    if (!StringUtils.isNull(currentAccountName) && b2 == 1) {
                                                        this.s.addPostData("user_name", currentAccountName);
                                                    }
                                                    String a2 = a15.c().a();
                                                    if (this.u != null && !TextUtils.isEmpty(this.u.getForumName())) {
                                                        a2 = this.u.getForumName();
                                                    }
                                                    if (!StringUtils.isNull(a2)) {
                                                        if (b2 == 2) {
                                                            this.s.addPostData("forum_name", a2);
                                                        }
                                                        a = a15.c().a();
                                                        if (this.u != null && !TextUtils.isEmpty(this.u.getForumName())) {
                                                            a = this.u.getForumName();
                                                        }
                                                        if (!StringUtils.isNull(a)) {
                                                            this.s.addPostData("small_flow_fname", a);
                                                        }
                                                        postMultiNetData = this.s.postMultiNetData(false);
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
                                                                }
                                                            }
                                                            try {
                                                                try {
                                                                    if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                                        vea.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = " + parser.error_code + "    p = " + str5);
                                                                        if (i3 == parser.chunkNo || parser.chunkNo <= 0) {
                                                                            break;
                                                                        }
                                                                        i3 = parser.chunkNo;
                                                                        j5 = length;
                                                                        str4 = str7;
                                                                        options = options2;
                                                                        randomAccessFile2 = randomAccessFile3;
                                                                        i7 = i4 + 1;
                                                                        sb = sb3;
                                                                    } else {
                                                                        StringBuilder sb8 = sb3;
                                                                        try {
                                                                            if (ImageUploadResult.shouldReply(parser.error_code)) {
                                                                                sb = sb8;
                                                                                j5 = length;
                                                                                str4 = str7;
                                                                                options = options2;
                                                                                randomAccessFile2 = randomAccessFile3;
                                                                                i7 = i4 + 1;
                                                                            } else {
                                                                                int i10 = i3 + 1;
                                                                                j2 += i5;
                                                                                if (i10 > 1) {
                                                                                    try {
                                                                                        j4 = j2 + ((i10 - 1) * this.f);
                                                                                    } catch (Exception e11) {
                                                                                        e = e11;
                                                                                        sb = sb8;
                                                                                        randomAccessFile2 = randomAccessFile3;
                                                                                        imageUploadResult = parser;
                                                                                        c = 0;
                                                                                        exc = e;
                                                                                        if (this.k) {
                                                                                        }
                                                                                        int i92222 = -1002;
                                                                                        if (imageUploadResult == null) {
                                                                                        }
                                                                                        if (imageUploadResult != null) {
                                                                                        }
                                                                                        if (imageUploadResult != null) {
                                                                                        }
                                                                                        Object[] objArr2222 = new Object[2];
                                                                                        objArr2222[c] = "comment";
                                                                                        objArr2222[1] = sb.toString();
                                                                                        s95.a("img", -1L, -1, "imageUpload", i92222, message, objArr2222);
                                                                                        StringBuilder sb72222 = new StringBuilder();
                                                                                        sb72222.append("发帖：正在上传图片 上传失败 = ");
                                                                                        sb72222.append(i92222);
                                                                                        sb72222.append(" ");
                                                                                        sb72222.append(message);
                                                                                        sb72222.append("    p = ");
                                                                                        str2 = str;
                                                                                        sb72222.append(str2);
                                                                                        vea.a(sb72222.toString());
                                                                                        vg.b(randomAccessFile2);
                                                                                        this.s = null;
                                                                                        vea.a("发帖：上传图片 结束      p = " + str2);
                                                                                        return imageUploadResult;
                                                                                    }
                                                                                } else {
                                                                                    j4 = j2;
                                                                                }
                                                                                try {
                                                                                    if (this.c != null) {
                                                                                        this.c.hasUploadFileSize += i5;
                                                                                    }
                                                                                    vea.a("发帖：正在上传图片 已上传 = " + j4 + "    p = " + str5);
                                                                                    if (this.n != null) {
                                                                                        try {
                                                                                            randomAccessFile4 = randomAccessFile3;
                                                                                            sb4 = sb8;
                                                                                            i6 = i10;
                                                                                            j5 = length;
                                                                                            options = options2;
                                                                                            imageUploadResult3 = parser;
                                                                                            c = 0;
                                                                                            str4 = str7;
                                                                                            j6 = j3;
                                                                                            j7 = j4;
                                                                                            try {
                                                                                                this.n.a(str, this.p, j4, j5);
                                                                                            } catch (Exception e12) {
                                                                                                exc = e12;
                                                                                                imageUploadResult = imageUploadResult3;
                                                                                                randomAccessFile2 = randomAccessFile4;
                                                                                                sb = sb4;
                                                                                            } catch (Throwable th6) {
                                                                                                th = th6;
                                                                                                th = th;
                                                                                                randomAccessFile = randomAccessFile4;
                                                                                                vg.b(randomAccessFile);
                                                                                                this.s = null;
                                                                                                throw th;
                                                                                            }
                                                                                        } catch (Exception e13) {
                                                                                            e = e13;
                                                                                            c = 0;
                                                                                            sb = sb8;
                                                                                            imageUploadResult = parser;
                                                                                            randomAccessFile2 = randomAccessFile3;
                                                                                            exc = e;
                                                                                            if (this.k) {
                                                                                            }
                                                                                            int i922222 = -1002;
                                                                                            if (imageUploadResult == null) {
                                                                                            }
                                                                                            if (imageUploadResult != null) {
                                                                                            }
                                                                                            if (imageUploadResult != null) {
                                                                                            }
                                                                                            Object[] objArr22222 = new Object[2];
                                                                                            objArr22222[c] = "comment";
                                                                                            objArr22222[1] = sb.toString();
                                                                                            s95.a("img", -1L, -1, "imageUpload", i922222, message, objArr22222);
                                                                                            StringBuilder sb722222 = new StringBuilder();
                                                                                            sb722222.append("发帖：正在上传图片 上传失败 = ");
                                                                                            sb722222.append(i922222);
                                                                                            sb722222.append(" ");
                                                                                            sb722222.append(message);
                                                                                            sb722222.append("    p = ");
                                                                                            str2 = str;
                                                                                            sb722222.append(str2);
                                                                                            vea.a(sb722222.toString());
                                                                                            vg.b(randomAccessFile2);
                                                                                            this.s = null;
                                                                                            vea.a("发帖：上传图片 结束      p = " + str2);
                                                                                            return imageUploadResult;
                                                                                        } catch (Throwable th7) {
                                                                                            th = th7;
                                                                                            randomAccessFile4 = randomAccessFile3;
                                                                                        }
                                                                                    } else {
                                                                                        i6 = i10;
                                                                                        j5 = length;
                                                                                        options = options2;
                                                                                        randomAccessFile4 = randomAccessFile3;
                                                                                        imageUploadResult3 = parser;
                                                                                        c = 0;
                                                                                        sb4 = sb8;
                                                                                        str4 = str7;
                                                                                        j6 = j3;
                                                                                        j7 = j4;
                                                                                    }
                                                                                } catch (Exception e14) {
                                                                                    e = e14;
                                                                                    sb = sb8;
                                                                                    randomAccessFile2 = randomAccessFile3;
                                                                                    imageUploadResult3 = parser;
                                                                                    c = 0;
                                                                                    exc = e;
                                                                                    imageUploadResult = imageUploadResult3;
                                                                                    if (this.k) {
                                                                                    }
                                                                                    int i9222222 = -1002;
                                                                                    if (imageUploadResult == null) {
                                                                                    }
                                                                                    if (imageUploadResult != null) {
                                                                                    }
                                                                                    if (imageUploadResult != null) {
                                                                                    }
                                                                                    Object[] objArr222222 = new Object[2];
                                                                                    objArr222222[c] = "comment";
                                                                                    objArr222222[1] = sb.toString();
                                                                                    s95.a("img", -1L, -1, "imageUpload", i9222222, message, objArr222222);
                                                                                    StringBuilder sb7222222 = new StringBuilder();
                                                                                    sb7222222.append("发帖：正在上传图片 上传失败 = ");
                                                                                    sb7222222.append(i9222222);
                                                                                    sb7222222.append(" ");
                                                                                    sb7222222.append(message);
                                                                                    sb7222222.append("    p = ");
                                                                                    str2 = str;
                                                                                    sb7222222.append(str2);
                                                                                    vea.a(sb7222222.toString());
                                                                                    vg.b(randomAccessFile2);
                                                                                    this.s = null;
                                                                                    vea.a("发帖：上传图片 结束      p = " + str2);
                                                                                    return imageUploadResult;
                                                                                }
                                                                                try {
                                                                                    if (this.o != null) {
                                                                                        randomAccessFile2 = randomAccessFile4;
                                                                                        StringBuilder sb9 = sb4;
                                                                                        bArr = bArr2;
                                                                                        j8 = j6;
                                                                                        sb = sb9;
                                                                                        this.o.a(str, this.p, j7, j5, i, i2);
                                                                                    } else {
                                                                                        randomAccessFile2 = randomAccessFile4;
                                                                                        sb = sb4;
                                                                                        bArr = bArr2;
                                                                                        j8 = j6;
                                                                                    }
                                                                                    i7 = i4;
                                                                                    i3 = i6;
                                                                                    if (i7 > this.r) {
                                                                                        sb.append("|possbile dead loop found. tryCount=");
                                                                                        sb.append(i7);
                                                                                        sb.append(", chunkNo=");
                                                                                        sb.append(j8);
                                                                                        break;
                                                                                    }
                                                                                    i4 = i7;
                                                                                    sb2 = sb;
                                                                                    imageUploadResult2 = imageUploadResult3;
                                                                                    j = j8;
                                                                                    bArr2 = bArr;
                                                                                    str6 = str4;
                                                                                    randomAccessFile = randomAccessFile2;
                                                                                    options2 = options;
                                                                                    length = j5;
                                                                                    z3 = true;
                                                                                    str5 = str;
                                                                                } catch (Exception e15) {
                                                                                    e = e15;
                                                                                    randomAccessFile2 = randomAccessFile4;
                                                                                    sb = sb4;
                                                                                    exc = e;
                                                                                    imageUploadResult = imageUploadResult3;
                                                                                    if (this.k) {
                                                                                    }
                                                                                    int i92222222 = -1002;
                                                                                    if (imageUploadResult == null) {
                                                                                    }
                                                                                    if (imageUploadResult != null) {
                                                                                    }
                                                                                    if (imageUploadResult != null) {
                                                                                    }
                                                                                    Object[] objArr2222222 = new Object[2];
                                                                                    objArr2222222[c] = "comment";
                                                                                    objArr2222222[1] = sb.toString();
                                                                                    s95.a("img", -1L, -1, "imageUpload", i92222222, message, objArr2222222);
                                                                                    StringBuilder sb72222222 = new StringBuilder();
                                                                                    sb72222222.append("发帖：正在上传图片 上传失败 = ");
                                                                                    sb72222222.append(i92222222);
                                                                                    sb72222222.append(" ");
                                                                                    sb72222222.append(message);
                                                                                    sb72222222.append("    p = ");
                                                                                    str2 = str;
                                                                                    sb72222222.append(str2);
                                                                                    vea.a(sb72222222.toString());
                                                                                    vg.b(randomAccessFile2);
                                                                                    this.s = null;
                                                                                    vea.a("发帖：上传图片 结束      p = " + str2);
                                                                                    return imageUploadResult;
                                                                                } catch (Throwable th8) {
                                                                                    th = th8;
                                                                                    randomAccessFile2 = randomAccessFile4;
                                                                                    th = th;
                                                                                    randomAccessFile = randomAccessFile2;
                                                                                    vg.b(randomAccessFile);
                                                                                    this.s = null;
                                                                                    throw th;
                                                                                }
                                                                            }
                                                                        } catch (Exception e16) {
                                                                            e = e16;
                                                                            sb = sb8;
                                                                            imageUploadResult3 = parser;
                                                                            randomAccessFile2 = randomAccessFile3;
                                                                        }
                                                                    }
                                                                    if (i7 > this.r) {
                                                                    }
                                                                } catch (Throwable th9) {
                                                                    th = th9;
                                                                    th = th;
                                                                    randomAccessFile = randomAccessFile2;
                                                                    vg.b(randomAccessFile);
                                                                    this.s = null;
                                                                    throw th;
                                                                }
                                                            } catch (Exception e17) {
                                                                e = e17;
                                                                exc = e;
                                                                imageUploadResult = imageUploadResult3;
                                                                if (this.k) {
                                                                }
                                                                int i922222222 = -1002;
                                                                if (imageUploadResult == null) {
                                                                }
                                                                if (imageUploadResult != null) {
                                                                }
                                                                if (imageUploadResult != null) {
                                                                }
                                                                Object[] objArr22222222 = new Object[2];
                                                                objArr22222222[c] = "comment";
                                                                objArr22222222[1] = sb.toString();
                                                                s95.a("img", -1L, -1, "imageUpload", i922222222, message, objArr22222222);
                                                                StringBuilder sb722222222 = new StringBuilder();
                                                                sb722222222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb722222222.append(i922222222);
                                                                sb722222222.append(" ");
                                                                sb722222222.append(message);
                                                                sb722222222.append("    p = ");
                                                                str2 = str;
                                                                sb722222222.append(str2);
                                                                vea.a(sb722222222.toString());
                                                                vg.b(randomAccessFile2);
                                                                this.s = null;
                                                                vea.a("发帖：上传图片 结束      p = " + str2);
                                                                return imageUploadResult;
                                                            }
                                                            c = 0;
                                                            imageUploadResult3 = parser;
                                                            bArr = bArr2;
                                                            j8 = j3;
                                                        } catch (Exception e18) {
                                                            e = e18;
                                                            imageUploadResult3 = parser;
                                                            randomAccessFile2 = randomAccessFile3;
                                                            sb = sb3;
                                                        }
                                                    }
                                                }
                                                a = a15.c().a();
                                                if (this.u != null) {
                                                    a = this.u.getForumName();
                                                }
                                                if (!StringUtils.isNull(a)) {
                                                }
                                                postMultiNetData = this.s.postMultiNetData(false);
                                                parser = ImageUploadResult.parser(postMultiNetData);
                                                if (postMultiNetData != null) {
                                                    break;
                                                }
                                                if (parser.error_code != 0) {
                                                }
                                                if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                }
                                                c = 0;
                                                imageUploadResult3 = parser;
                                                bArr = bArr2;
                                                j8 = j3;
                                                if (i7 > this.r) {
                                                }
                                            } catch (Exception e19) {
                                                e = e19;
                                                randomAccessFile2 = randomAccessFile3;
                                                sb = sb3;
                                                c = 0;
                                                imageUploadResult = imageUploadResult2;
                                                exc = e;
                                                if (this.k) {
                                                }
                                                int i9222222222 = -1002;
                                                if (imageUploadResult == null) {
                                                }
                                                if (imageUploadResult != null) {
                                                }
                                                if (imageUploadResult != null) {
                                                }
                                                Object[] objArr222222222 = new Object[2];
                                                objArr222222222[c] = "comment";
                                                objArr222222222[1] = sb.toString();
                                                s95.a("img", -1L, -1, "imageUpload", i9222222222, message, objArr222222222);
                                                StringBuilder sb7222222222 = new StringBuilder();
                                                sb7222222222.append("发帖：正在上传图片 上传失败 = ");
                                                sb7222222222.append(i9222222222);
                                                sb7222222222.append(" ");
                                                sb7222222222.append(message);
                                                sb7222222222.append("    p = ");
                                                str2 = str;
                                                sb7222222222.append(str2);
                                                vea.a(sb7222222222.toString());
                                                vg.b(randomAccessFile2);
                                                this.s = null;
                                                vea.a("发帖：上传图片 结束      p = " + str2);
                                                return imageUploadResult;
                                            }
                                        } catch (Throwable th10) {
                                            th = th10;
                                            randomAccessFile2 = randomAccessFile3;
                                        }
                                    } catch (Exception e20) {
                                        e = e20;
                                        randomAccessFile2 = randomAccessFile;
                                        sb = sb2;
                                    }
                                    vea.a("发帖：上传图片 结束      p = " + str2);
                                    return imageUploadResult;
                                }
                                imageUploadResult2 = imageUploadResult3;
                                randomAccessFile = randomAccessFile2;
                                vg.b(randomAccessFile);
                                this.s = null;
                                imageUploadResult = imageUploadResult2;
                                str2 = str;
                                vea.a("发帖：上传图片 结束      p = " + str2);
                                return imageUploadResult;
                            }
                            sb = sb5;
                            c = 0;
                            imageUploadResult = new ImageUploadResult();
                            imageUploadResult.error_code = -1007;
                            imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_not_exist);
                            imageUploadResult2 = imageUploadResult;
                            randomAccessFile = null;
                            vg.b(randomAccessFile);
                            this.s = null;
                            imageUploadResult = imageUploadResult2;
                            str2 = str;
                            vea.a("发帖：上传图片 结束      p = " + str2);
                            return imageUploadResult;
                        }
                        c = 0;
                        vea.a("发帖：上传图片 结束      p = " + str2);
                        return imageUploadResult;
                    } catch (Throwable th11) {
                        th = th11;
                        randomAccessFile = null;
                    }
                    if (this.k) {
                        sb.append("|request cancelled.");
                    } else {
                        BdLog.e(exc.getMessage());
                    }
                    int i92222222222 = -1002;
                    if (imageUploadResult == null) {
                        imageUploadResult = new ImageUploadResult();
                        imageUploadResult.error_code = -1002;
                        imageUploadResult.error_msg = exc.getMessage();
                    }
                    if (imageUploadResult != null) {
                        i92222222222 = imageUploadResult.error_code;
                    }
                    if (imageUploadResult != null) {
                        message = imageUploadResult.error_msg;
                    } else {
                        message = exc.getMessage();
                    }
                    Object[] objArr2222222222 = new Object[2];
                    objArr2222222222[c] = "comment";
                    objArr2222222222[1] = sb.toString();
                    s95.a("img", -1L, -1, "imageUpload", i92222222222, message, objArr2222222222);
                    StringBuilder sb72222222222 = new StringBuilder();
                    sb72222222222.append("发帖：正在上传图片 上传失败 = ");
                    sb72222222222.append(i92222222222);
                    sb72222222222.append(" ");
                    sb72222222222.append(message);
                    sb72222222222.append("    p = ");
                    str2 = str;
                    sb72222222222.append(str2);
                    vea.a(sb72222222222.toString());
                    vg.b(randomAccessFile2);
                    this.s = null;
                } catch (Throwable th12) {
                    th = th12;
                    randomAccessFile = null;
                }
            } else {
                vea.a("发帖：正在上传图片 失败 = " + str5);
                return null;
            }
        } else {
            return (ImageUploadResult) invokeCommon.objValue;
        }
    }
}
