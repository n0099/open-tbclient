package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class kn5 {
    public static /* synthetic */ Interceptable $ic;
    public static final String h;
    public transient /* synthetic */ FieldHolder $fh;
    public hn5 a;
    public boolean b;
    public ImageFileInfo c;
    public jn5 d;
    public jn5 e;
    public jn5 f;
    public jn5 g;

    /* loaded from: classes6.dex */
    public class a implements jn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kn5 a;

        public a(kn5 kn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kn5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kn5Var;
        }

        @Override // com.baidu.tieba.jn5
        public String a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            String m;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
                if (imageFileInfo == null) {
                    return null;
                }
                if (this.a.a == null) {
                    this.a.a = new hn5();
                }
                String filePath = imageFileInfo.getFilePath();
                LinkedList<ImageOperation> pageActionsList = imageFileInfo.getPageActionsList();
                imageFileInfo.setPageActionsList(null);
                if (filePath.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    File file = new File(pp5.b.d(imageFileInfo.getFilePath(), true));
                    if (file.exists()) {
                        return file.getAbsolutePath();
                    }
                }
                jn c = this.a.a.c(imageFileInfo, true);
                if (c == null) {
                    Bitmap k = this.a.k(imageFileInfo);
                    if (k == null) {
                        return null;
                    }
                    int readPictureDegree = BitmapHelper.readPictureDegree(filePath);
                    if (readPictureDegree != 0) {
                        k = BitmapHelper.rotateBitmapBydegree(k, readPictureDegree);
                    }
                    m = this.a.m(k, 5242880L, 100);
                } else {
                    m = this.a.m(c.p(), 5242880L, 100);
                }
                imageFileInfo.setPageActionsList(pageActionsList);
                return m;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements jn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kn5 a;

        public b(kn5 kn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kn5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kn5Var;
        }

        @Override // com.baidu.tieba.jn5
        public String a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
                if (imageFileInfo == null) {
                    return null;
                }
                return this.a.g(imageFileInfo.getFilePath());
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements jn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kn5 a;

        public c(kn5 kn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kn5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kn5Var;
        }

        @Override // com.baidu.tieba.jn5
        public String a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
                if (imageFileInfo == null) {
                    return null;
                }
                return this.a.m(this.a.i(imageFileInfo.getFilePath()), 5242880L, 100);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947918871, "Lcom/baidu/tieba/kn5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947918871, "Lcom/baidu/tieba/kn5;");
                return;
            }
        }
        h = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/dynamicimgtmp";
    }

    public kn5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.d = new a(this);
        b bVar = new b(this);
        this.e = bVar;
        this.f = bVar;
        this.g = new c(this);
    }

    public final String h(String str) {
        InterceptResult invokeL;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return ".jpg";
            }
            try {
                substring = str.substring(str.lastIndexOf("."));
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(substring)) {
                return ".jpg";
            }
            return substring;
        }
        return (String) invokeL.objValue;
    }

    public final BitmapFactory.Options l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return options;
        }
        return (BitmapFactory.Options) invokeL.objValue;
    }

    public final String g(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            long fileSize = FileHelper.getFileSize(str);
            if (fileSize >= 31457280) {
                i = 80;
            } else if (fileSize >= DownloadManager.MIN_LEFT_SIZE) {
                i = 85;
            } else if (fileSize >= 15728640) {
                i = 90;
            } else if (fileSize >= Config.FULL_TRACE_LOG_LIMIT) {
                i = 95;
            } else {
                i = 100;
            }
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0 || i != 100) {
                    Bitmap i2 = i(str);
                    if (readPictureDegree != 0 && i2 != null) {
                        return m(BitmapHelper.rotateBitmapBydegree(i2, readPictureDegree), Config.FULL_TRACE_LOG_LIMIT, i);
                    }
                    return m(i2, Config.FULL_TRACE_LOG_LIMIT, i);
                }
                return str;
            } catch (Throwable unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final Bitmap i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            BitmapFactory.Options l = l(str);
            int i = l.outWidth;
            int i2 = l.outHeight;
            if (i != 0 && i2 != 0) {
                Bitmap loadBitmap = BitmapHelper.loadBitmap(str);
                if (loadBitmap != null && !loadBitmap.isRecycled()) {
                    return loadBitmap;
                }
                int i3 = 2;
                for (int i4 = 0; i4 < 3; i4++) {
                    l.inSampleSize = i3;
                    Bitmap loadBitmap2 = BitmapHelper.loadBitmap(str, l);
                    if (loadBitmap2 != null && !loadBitmap2.isRecycled()) {
                        return loadBitmap2;
                    }
                    i3 *= 2;
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public String j(WriteData writeData, ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLLZ;
        jn5 jn5Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, writeData, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            this.c = imageFileInfo;
            String filePath = imageFileInfo.getFilePath();
            boolean checkIsLongImage = FileHelper.checkIsLongImage(filePath);
            boolean checkIsHeifImage = FileHelper.checkIsHeifImage(filePath);
            if (!imageFileInfo.isGif() && (!z || imageFileInfo.hasActionsWithoutResize() || checkIsHeifImage)) {
                if (checkIsLongImage) {
                    jn5Var = this.g;
                    str = "正常·长图";
                } else {
                    jn5Var = this.d;
                    str = "正常·图";
                }
            } else if (checkIsLongImage) {
                jn5Var = this.f;
                str = "原始·长图";
            } else {
                jn5Var = this.e;
                str = "原始·图";
            }
            tea.s(writeData, imageFileInfo, filePath, FileHelper.getImageFileWH(filePath), FileHelper.getFileSize(filePath), checkIsLongImage, checkIsHeifImage, imageFileInfo.hasActionsWithoutResize(), str);
            String a2 = jn5Var.a(imageFileInfo);
            tea.j(writeData, imageFileInfo, a2, FileHelper.getImageFileWH(a2), FileHelper.getFileSize(a2));
            return a2;
        }
        return (String) invokeLLZ.objValue;
    }

    public final String m(Bitmap bitmap, long j, int i) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{bitmap, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            if (this.b) {
                ImageFileInfo imageFileInfo = this.c;
                if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                    return FileHelper.compressBitmapToFile(h, fj.c(this.c.toCachedKey(false)) + h(this.c.getFilePath()), bitmap, (float) j, i);
                }
                return "";
            }
            ImageFileInfo imageFileInfo2 = this.c;
            if (imageFileInfo2 != null && !TextUtils.isEmpty(imageFileInfo2.getTempUploadFileName())) {
                str = this.c.getTempUploadFileName();
            } else {
                str = "img_upload_temp_file.temp";
            }
            return FileHelper.compressBitmapToFile(str, bitmap, (float) j, i);
        }
        return (String) invokeCommon.objValue;
    }

    public final Bitmap k(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        tg i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.a == null) {
                this.a = new hn5();
            }
            if (imageFileInfo.getImageType() == 0) {
                return this.a.f(imageFileInfo, true);
            }
            if (imageFileInfo.getImageType() == 1 && (i = sg.h().i(20)) != null) {
                try {
                    Object fromLocal = i.getFromLocal(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), Boolean.FALSE, null);
                    if (fromLocal instanceof jn) {
                        return ((jn) fromLocal).p();
                    }
                } catch (OutOfMemoryError unused) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }
}
