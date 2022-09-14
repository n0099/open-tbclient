package com.baidu.tieba;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.ImageUploader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class qc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicInteger a;
        public final /* synthetic */ List b;
        public final /* synthetic */ c c;

        public a(qc6 qc6Var, AtomicInteger atomicInteger, List list, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc6Var, atomicInteger, list, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicInteger;
            this.b = list;
            this.c = cVar;
        }

        @Override // com.baidu.tieba.qc6.d
        public void a(ImageUploadResult imageUploadResult) {
            ImageUploadResult.picInfo picinfo;
            ImageUploadResult.PicDetailedInfo picDetailedInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imageUploadResult) == null) {
                this.a.decrementAndGet();
                if (imageUploadResult != null && (picinfo = imageUploadResult.picInfo) != null && (picDetailedInfo = picinfo.bigPic) != null && !TextUtils.isEmpty(picDetailedInfo.picUrl)) {
                    this.b.add(imageUploadResult.picInfo.bigPic.picUrl);
                }
                if (this.a.get() == 0) {
                    if (!ListUtils.isEmpty(this.b)) {
                        this.c.d0(this.b);
                    } else {
                        this.c.B0();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageFileInfo a;
        public final /* synthetic */ d b;

        public b(qc6 qc6Var, ImageFileInfo imageFileInfo, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc6Var, imageFileInfo, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageFileInfo;
            this.b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String filePath = this.a.getFilePath();
                ImageUploader imageUploader = new ImageUploader("from_user_collect");
                if (this.a.isGif()) {
                    this.b.a(imageUploader.uploadInBackground(filePath, true, false));
                    return;
                }
                Bitmap b = dr7.b(this.a);
                if (b == null) {
                    this.b.a(null);
                    return;
                }
                String saveBitmapByAbsolutelyPath = FileHelper.saveBitmapByAbsolutelyPath(TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath(), "face_" + Math.abs(filePath.hashCode()), b, 60);
                b.recycle();
                if (TextUtils.isEmpty(saveBitmapByAbsolutelyPath)) {
                    this.b.a(null);
                    return;
                }
                ImageUploadResult uploadInBackground = imageUploader.uploadInBackground(saveBitmapByAbsolutelyPath, false, false);
                FileHelper.deleteFile(new File(saveBitmapByAbsolutelyPath));
                this.b.a(uploadInBackground);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void B0();

        void d0(List<String> list);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(ImageUploadResult imageUploadResult);
    }

    public qc6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(ArrayList<ImageFileInfo> arrayList, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, arrayList, cVar) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(arrayList.size());
        ArrayList arrayList2 = new ArrayList();
        Iterator<ImageFileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            b(it.next(), new a(this, atomicInteger, arrayList2, cVar));
        }
    }

    public final void b(ImageFileInfo imageFileInfo, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, dVar) == null) {
            tq7.b().a(new b(this, imageFileInfo, dVar));
        }
    }
}
