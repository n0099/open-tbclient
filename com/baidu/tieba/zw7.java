package com.baidu.tieba;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.img.GetEmotionInfosModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.ImageUploader;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.tieba.newfaceshop.facemake.UploadFaceGroupModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class zw7 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zw7 e;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public BlockingQueue<ImageUploader> b;
    public boolean c;
    public FaceGroupDraft d;

    /* loaded from: classes7.dex */
    public interface j {
        void a(uw7 uw7Var);

        void onFail(String str);
    }

    /* loaded from: classes7.dex */
    public interface k {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes7.dex */
    public interface l {
        void a(String str, List<FaceData> list);

        void onFail(String str);
    }

    /* loaded from: classes7.dex */
    public interface m {
        void a(ImageUploadResult imageUploadResult);
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<FaceData> a;
        public List<String> b;
        public Map<String, Integer> c;
        public List<FaceData> d;
        public final /* synthetic */ List e;
        public final /* synthetic */ l f;
        public final /* synthetic */ String g;
        public final /* synthetic */ int h;
        public final /* synthetic */ zw7 i;

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.zw7$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0507a implements GetEmotionInfosModel.b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                public C0507a(b bVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = bVar;
                }

                @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
                public void onFail(int i, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                        a aVar = this.a.a;
                        aVar.i.t(aVar.f, "get pid fail");
                    }
                }

                @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
                public void onSuccess(List<q95> list) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                        for (q95 q95Var : list) {
                            if (q95Var != null) {
                                FaceData faceData = new FaceData();
                                faceData.type = 2;
                                faceData.index = this.a.a.c.get(q95Var.g).intValue();
                                faceData.pid = q95Var.a;
                                faceData.width = q95Var.b;
                                faceData.height = q95Var.c;
                                EmotionImageData emotionImageData = new EmotionImageData();
                                emotionImageData.setPicId(q95Var.a);
                                emotionImageData.setThumbUrl(q95Var.e);
                                emotionImageData.setPicUrl(q95Var.d);
                                emotionImageData.setWidth(q95Var.b);
                                emotionImageData.setHeight(q95Var.c);
                                faceData.emotionImageData = emotionImageData;
                                this.a.a.a.add(faceData);
                            }
                        }
                        UploadFaceGroupModel uploadFaceGroupModel = new UploadFaceGroupModel();
                        a aVar = this.a.a;
                        uploadFaceGroupModel.I(aVar.g, aVar.a, aVar.f, aVar.h);
                    }
                }
            }

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
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
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.b.size() > 0) {
                        new GetEmotionInfosModel().I(this.a.b, new C0507a(this));
                        return;
                    }
                    UploadFaceGroupModel uploadFaceGroupModel = new UploadFaceGroupModel();
                    a aVar = this.a;
                    uploadFaceGroupModel.I(aVar.g, aVar.a, aVar.f, aVar.h);
                }
            }
        }

        /* renamed from: com.baidu.tieba.zw7$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0506a implements m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ vw7 a;
            public final /* synthetic */ FaceData b;
            public final /* synthetic */ AtomicInteger c;
            public final /* synthetic */ a d;

            public C0506a(a aVar, vw7 vw7Var, FaceData faceData, AtomicInteger atomicInteger) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, vw7Var, faceData, atomicInteger};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = vw7Var;
                this.b = faceData;
                this.c = atomicInteger;
            }

            @Override // com.baidu.tieba.zw7.m
            public void a(ImageUploadResult imageUploadResult) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, imageUploadResult) != null) || !this.a.a()) {
                    return;
                }
                if (imageUploadResult != null && imageUploadResult.error_code == 0) {
                    this.b.pid = String.valueOf(imageUploadResult.picId);
                    FaceData faceData = this.b;
                    ImageUploadResult.PicDetailedInfo picDetailedInfo = imageUploadResult.picInfo.bigPic;
                    faceData.width = picDetailedInfo.width;
                    faceData.height = picDetailedInfo.height;
                    this.d.a.add(faceData);
                    if (this.c.decrementAndGet() == 0) {
                        this.d.b();
                    }
                } else if (this.a.a()) {
                    this.a.setResult(false);
                    a aVar = this.d;
                    aVar.i.t(aVar.f, "failed to upload image");
                }
            }
        }

        public a(zw7 zw7Var, List list, l lVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw7Var, list, lVar, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = zw7Var;
            this.e = list;
            this.f = lVar;
            this.g = str;
            this.h = i;
            this.a = new CopyOnWriteArrayList();
            this.b = new ArrayList();
            this.c = new HashMap();
            this.d = new CopyOnWriteArrayList();
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                new Handler(Looper.getMainLooper()).post(new b(this));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            EmotionImageData emotionImageData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (int i = 0; i < this.e.size(); i++) {
                    FaceData faceData = (FaceData) this.e.get(i);
                    faceData.index = i;
                    int i2 = faceData.type;
                    if (i2 == 2) {
                        EmotionImageData emotionImageData2 = faceData.emotionImageData;
                        if (emotionImageData2 != null) {
                            if (!TextUtils.isEmpty(emotionImageData2.getPicId())) {
                                faceData.pid = emotionImageData2.getPicId();
                                faceData.width = emotionImageData2.getWidth();
                                faceData.height = emotionImageData2.getHeight();
                                this.a.add(faceData);
                            } else {
                                this.b.add(faceData.emotionImageData.getPicUrl());
                                this.c.put(faceData.emotionImageData.getPicUrl(), Integer.valueOf(faceData.index));
                            }
                        }
                    } else if (i2 == 3) {
                        this.d.add(faceData);
                    } else if (i2 == 1 && (emotionImageData = faceData.emotionImageData) != null) {
                        faceData.pid = emotionImageData.getPicId();
                        faceData.width = emotionImageData.getWidth();
                        faceData.height = emotionImageData.getHeight();
                        this.a.add(faceData);
                    }
                }
                if (this.d.size() > 0) {
                    AtomicInteger atomicInteger = new AtomicInteger(this.d.size());
                    vw7 vw7Var = new vw7(Boolean.TRUE);
                    for (int i3 = 0; i3 < Math.min(this.d.size(), 4); i3++) {
                        this.i.b.offer(new ImageUploader("face group"));
                    }
                    for (int i4 = 0; i4 < this.d.size() && vw7Var.a(); i4++) {
                        FaceData faceData2 = this.d.get(i4);
                        this.i.B(faceData2.imageFileInfo, new C0506a(this, vw7Var, faceData2, atomicInteger));
                    }
                    return;
                }
                b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageFileInfo a;
        public final /* synthetic */ m b;
        public final /* synthetic */ zw7 c;

        public b(zw7 zw7Var, ImageFileInfo imageFileInfo, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw7Var, imageFileInfo, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zw7Var;
            this.a = imageFileInfo;
            this.b = mVar;
        }

        public final void a(m mVar, ImageUploadResult imageUploadResult) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, mVar, imageUploadResult) == null) && mVar != null) {
                mVar.a(imageUploadResult);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    String filePath = this.a.getFilePath();
                    if (this.a.isGif()) {
                        ImageUploader imageUploader = (ImageUploader) this.c.b.poll(10L, TimeUnit.SECONDS);
                        if (imageUploader != null) {
                            a(this.b, imageUploader.uploadInBackground(filePath, true, false));
                            this.c.v(imageUploader);
                            return;
                        }
                        a(this.b, null);
                        return;
                    }
                    Bitmap b = ww7.b(this.a);
                    if (b == null) {
                        this.b.a(null);
                        return;
                    }
                    String y = zw7.y("face_" + Math.abs(filePath.hashCode()), b, 60);
                    b.recycle();
                    if (TextUtils.isEmpty(y)) {
                        a(this.b, null);
                        return;
                    }
                    ImageUploader imageUploader2 = (ImageUploader) this.c.b.poll(10L, TimeUnit.SECONDS);
                    if (imageUploader2 != null) {
                        ImageUploadResult uploadInBackground = imageUploader2.uploadInBackground(y, false, false);
                        FileHelper.deleteFile(new File(y));
                        a(this.b, uploadInBackground);
                        this.c.v(imageUploader2);
                        return;
                    }
                    a(this.b, null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vw7 a;
        public final /* synthetic */ List b;
        public final /* synthetic */ List c;
        public final /* synthetic */ tw7 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ k f;
        public final /* synthetic */ zw7 g;

        public c(zw7 zw7Var, vw7 vw7Var, List list, List list2, tw7 tw7Var, String str, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw7Var, vw7Var, list, list2, tw7Var, str, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = zw7Var;
            this.a = vw7Var;
            this.b = list;
            this.c = list2;
            this.d = tw7Var;
            this.e = str;
            this.f = kVar;
        }

        @Override // com.baidu.tieba.zw7.j
        public void a(uw7 uw7Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, uw7Var) != null) || !this.a.a()) {
                return;
            }
            this.b.add(uw7Var);
            if (this.b.size() == this.c.size()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.b);
                Collections.sort(arrayList);
                this.d.e = arrayList;
                if (!this.g.j(this.e + ((uw7) arrayList.get(0)).d, this.e)) {
                    onFail("face group:fail to create panel");
                } else {
                    this.g.o(this.d, this.f);
                }
            }
        }

        @Override // com.baidu.tieba.zw7.j
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.a.a()) {
                this.a.setResult(false);
                this.g.s(this.f, false);
                if (!TextUtils.isEmpty(str)) {
                    BdLog.e(str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceData a;
        public final /* synthetic */ String b;
        public final /* synthetic */ j c;

        public d(zw7 zw7Var, FaceData faceData, String str, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw7Var, faceData, str, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceData;
            this.b = str;
            this.c = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap resizeBitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ImageFileInfo imageFileInfo = this.a.imageFileInfo;
                String filePath = imageFileInfo.getFilePath();
                String substring = filePath.substring(filePath.lastIndexOf("/") + 1);
                if (TextUtils.isEmpty(substring)) {
                    substring = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis() + ".jpg";
                }
                String str = "t_" + substring;
                if (FileHelper.copyFileByAbsolutelyPath(filePath, this.b + substring)) {
                    Bitmap b = ww7.b(imageFileInfo);
                    if (b == null) {
                        this.c.onFail("face group: fail to get origin bitmap when install album emotion");
                        return;
                    }
                    if (!imageFileInfo.isGif() && (resizeBitmap = BitmapHelper.resizeBitmap(b, 240, 240, false)) != null) {
                        ow7.e(this.b, substring, resizeBitmap, 100);
                        if (resizeBitmap != b) {
                            resizeBitmap.recycle();
                        }
                    }
                    Bitmap resizeBitmap2 = BitmapHelper.resizeBitmap(b, 150, 150, false);
                    if (resizeBitmap2 == null) {
                        this.c.onFail("face group: fail to create small file when install album emotion");
                        return;
                    }
                    ow7.e(this.b, str, resizeBitmap2, 100);
                    if (resizeBitmap2 != b) {
                        resizeBitmap2.recycle();
                    }
                    b.recycle();
                    uw7 uw7Var = new uw7();
                    FaceData faceData = this.a;
                    uw7Var.a = faceData.index;
                    uw7Var.b = faceData.pid;
                    uw7Var.c = substring;
                    uw7Var.d = str;
                    uw7Var.f = faceData.width;
                    uw7Var.e = faceData.height;
                    this.c.a(uw7Var);
                    return;
                }
                this.c.onFail("face group: fail to copy file when install album emotion");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceData a;
        public final /* synthetic */ String b;
        public final /* synthetic */ j c;

        public e(zw7 zw7Var, FaceData faceData, String str, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw7Var, faceData, str, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceData;
            this.b = str;
            this.c = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EmotionImageData emotionImageData = this.a.emotionImageData;
                String str = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis();
                String str2 = "t_" + str;
                String p = ig6.p(this.a.pid, true);
                String p2 = ig6.p(this.a.pid, false);
                if (!FileHelper.copyFileByAbsolutelyPath(p, this.b + str)) {
                    this.c.onFail("face group: fail to copy big file when install collect emotion");
                    return;
                }
                if (!FileHelper.copyFileByAbsolutelyPath(p2, this.b + str2)) {
                    this.c.onFail("face group: fail to copy small file when install collect emotion");
                    return;
                }
                uw7 uw7Var = new uw7();
                FaceData faceData = this.a;
                uw7Var.a = faceData.index;
                uw7Var.b = faceData.pid;
                uw7Var.c = str;
                uw7Var.d = str2;
                uw7Var.f = faceData.width;
                uw7Var.e = faceData.height;
                this.c.a(uw7Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceData a;
        public final /* synthetic */ j b;
        public final /* synthetic */ String c;
        public final /* synthetic */ zw7 d;

        public f(zw7 zw7Var, FaceData faceData, j jVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw7Var, faceData, jVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = zw7Var;
            this.a = faceData;
            this.b = jVar;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EmotionImageData emotionImageData = this.a.emotionImageData;
                String substring = emotionImageData.getPicUrl().substring(emotionImageData.getPicUrl().lastIndexOf(IStringUtil.WINDOWS_FOLDER_SEPARATOR) + 1);
                String str = "t_" + substring;
                WebClient webClient = new WebClient();
                byte[] downloadImageBytes = webClient.downloadImageBytes(emotionImageData.getPicUrl(), false);
                if (downloadImageBytes == null || !webClient.IsRequestSuccess()) {
                    this.b.onFail("face group: fail to download big file when install search emotion");
                    return;
                }
                this.d.x(this.c, substring, downloadImageBytes);
                byte[] downloadImageBytes2 = webClient.downloadImageBytes(emotionImageData.getThumbUrl(), false);
                if (downloadImageBytes2 == null || !webClient.IsRequestSuccess()) {
                    this.b.onFail("face group: fail to download small file when install search emotion");
                    return;
                }
                this.d.x(this.c, str, downloadImageBytes2);
                uw7 uw7Var = new uw7();
                FaceData faceData = this.a;
                uw7Var.a = faceData.index;
                uw7Var.b = faceData.pid;
                uw7Var.c = substring;
                uw7Var.d = str;
                uw7Var.f = faceData.width;
                uw7Var.e = faceData.height;
                this.b.a(uw7Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ boolean b;

        public g(zw7 zw7Var, k kVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw7Var, kVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k kVar = this.a;
                if (kVar != null) {
                    if (this.b) {
                        kVar.onSuccess();
                    } else {
                        kVar.onFail();
                    }
                }
                if (this.b) {
                    qw7.o().z();
                    MessageManager.getInstance().runTask(2004603, (Class) null);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("upload_result", new Boolean(true));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, hashMap));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;
        public final /* synthetic */ String b;
        public final /* synthetic */ zw7 c;

        public h(zw7 zw7Var, l lVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw7Var, lVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zw7Var;
            this.a = lVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l lVar = this.a;
                if (lVar != null) {
                    lVar.onFail(this.b);
                }
                if (this.b != null) {
                    BdLog.e("face group:" + this.b);
                }
                this.c.u(false, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HashMap a;

        public i(zw7 zw7Var, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw7Var, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, this.a));
            }
        }
    }

    public zw7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Handler(Looper.getMainLooper());
        this.b = new LinkedBlockingQueue(4);
    }

    public final void v(ImageUploader imageUploader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, imageUploader) == null) {
            this.b.offer(imageUploader);
        }
    }

    public final void m(FaceData faceData, String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, faceData, str, jVar) == null) {
            mw7.b().a(new d(this, faceData, str, jVar));
        }
    }

    public final void n(FaceData faceData, String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, faceData, str, jVar) == null) {
            mw7.b().a(new e(this, faceData, str, jVar));
        }
    }

    public final void q(FaceData faceData, String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, faceData, str, jVar) == null) {
            mw7.b().a(new f(this, faceData, jVar, str));
        }
    }

    public void w(String str, List<FaceData> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048591, this, str, list, i2) == null) {
            FaceGroupDraft faceGroupDraft = new FaceGroupDraft();
            this.d = faceGroupDraft;
            faceGroupDraft.setName(str);
            this.d.setList(list);
            this.d.setForumId(i2);
        }
    }

    public final void B(ImageFileInfo imageFileInfo, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, mVar) == null) {
            mw7.b().a(new b(this, imageFileInfo, mVar));
        }
    }

    public final void s(k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, kVar, z) == null) {
            this.a.post(new g(this, kVar, z));
        }
    }

    public final void t(l lVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, lVar, str) == null) {
            this.a.post(new h(this, lVar, str));
        }
    }

    public static zw7 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (e == null) {
                synchronized (zw7.class) {
                    if (e == null) {
                        e = new zw7();
                    }
                }
            }
            return e;
        }
        return (zw7) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d = null;
            xw7.a();
        }
    }

    public FaceGroupDraft k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.d == null) {
                this.d = xw7.b();
            }
            return this.d;
        }
        return (FaceGroupDraft) invokeV.objValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public static String y(String str, Bitmap bitmap, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, null, str, bitmap, i2)) == null) {
            if (bitmap == null) {
                return null;
            }
            File cacheDir = TbadkCoreApplication.getInst().getCacheDir();
            if (cacheDir.exists() && !cacheDir.isDirectory()) {
                cacheDir.delete();
            }
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            File file = new File(cacheDir, str);
            try {
                if ((file.exists() && !file.delete()) || !file.createNewFile()) {
                    return null;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getAbsolutePath();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, xi.join("FileHelper", ".", "saveFileToSDOrMemory", " ", file.getAbsolutePath()));
                return null;
            }
        }
        return (String) invokeLLI.objValue;
    }

    public void p(String str, List<FaceData> list, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, list, kVar) == null) {
            String str2 = pw7.c + str + "/";
            new File(str2).mkdirs();
            tw7 tw7Var = new tw7();
            TbadkCoreApplication.getCurrentAccount();
            TbadkCoreApplication.getCurrentAccountName();
            tw7Var.a = str;
            String.valueOf(System.currentTimeMillis());
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            vw7 vw7Var = new vw7(Boolean.TRUE);
            c cVar = new c(this, vw7Var, copyOnWriteArrayList, list, tw7Var, str2, kVar);
            for (FaceData faceData : list) {
                if (!vw7Var.a()) {
                    return;
                }
                int i2 = faceData.type;
                if (i2 == 3) {
                    m(faceData, str2, cVar);
                } else if (i2 == 1) {
                    n(faceData, str2, cVar);
                } else if (i2 == 2) {
                    q(faceData, str2, cVar);
                } else {
                    cVar.onFail("facegroup:un support type in list");
                    return;
                }
            }
        }
    }

    public void A(String str, List<FaceData> list, l lVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048576, this, str, list, lVar, i2) == null) {
            this.c = true;
            w(str, list, i2);
            if (TextUtils.isEmpty(str)) {
                t(lVar, "name empty");
            } else if (list == null) {
                t(lVar, "list empty");
            } else {
                z(list);
                mw7.b().a(new a(this, list, lVar, str, i2));
            }
        }
    }

    public final boolean j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            Bitmap a2 = ww7.a(str);
            if (a2 == null) {
                BdLog.e("cover bitmap null");
                return false;
            } else if (TextUtils.isEmpty(ow7.e(str2, "panel.png", a2, 60))) {
                BdLog.e("fail to save Panel");
                return false;
            } else if (TextUtils.isEmpty(ow7.e(str2, "panel_momo.png", a2, 60))) {
                BdLog.e("fail to save PanelMomo");
                return false;
            } else {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void o(tw7 tw7Var, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, tw7Var, kVar) == null) {
            int f2 = qf6.c().f(tw7Var);
            if (f2 == 0) {
                BdLog.e("no valid emotion");
                s(kVar, false);
                return;
            }
            EmotionGroupData emotionGroupData = new EmotionGroupData();
            emotionGroupData.setGroupId(tw7Var.a);
            emotionGroupData.setEmotionsCount(f2);
            emotionGroupData.setHeight(tw7Var.e.get(0).e);
            emotionGroupData.setWidth(tw7Var.e.get(0).f);
            emotionGroupData.setDownloadTime(System.currentTimeMillis());
            emotionGroupData.setGroupName(tw7Var.b);
            emotionGroupData.setStatus(1);
            yf6.o().g(emotionGroupData);
            yf6.o().h(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
            s(kVar, true);
        }
    }

    public void u(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, str) == null) {
            if (this.c) {
                this.c = false;
            }
            if (z) {
                i();
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("upload_result", new Boolean(false));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("upload_msg", str);
                FaceGroupDraft faceGroupDraft = this.d;
                if (faceGroupDraft != null) {
                    faceGroupDraft.setFailMsg(str);
                }
            }
            xw7.c(this.d);
            this.a.postDelayed(new i(this, hashMap), 1000L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String x(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, str, str2, bArr)) == null) {
            File file = new File(str + str2);
            String parent = file.getParent();
            if (!StringUtils.isNull(parent)) {
                File file2 = new File(parent);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                if ((file.exists() && !file.delete()) || !file.createNewFile()) {
                    return null;
                }
                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                try {
                    fileOutputStream3.write(bArr, 0, bArr.length);
                    fileOutputStream3.flush();
                    fileOutputStream3.close();
                    return file.getPath();
                } catch (IOException e2) {
                    fileOutputStream = fileOutputStream3;
                    e = e2;
                    try {
                        BdLog.e(e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable th3) {
                                BdLog.e(th3.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream2 = fileOutputStream3;
                    if (fileOutputStream2 != null) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
            }
        } else {
            return (String) invokeLLL.objValue;
        }
    }

    public final void z(List<FaceData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, list) == null) && list != null && !list.isEmpty()) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (FaceData faceData : list) {
                if (faceData != null) {
                    int i5 = faceData.type;
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 == 3) {
                                i4++;
                            }
                        } else {
                            i2++;
                        }
                    } else {
                        i3++;
                    }
                }
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_UPLOAD_SOURCE);
            statisticItem.param("obj_source", 3);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_UPLOAD_SOURCE);
            statisticItem2.param("obj_source", 2);
            statisticItem2.param("obj_type", i3);
            TiebaStatic.log(statisticItem2);
            StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_UPLOAD_SOURCE);
            statisticItem3.param("obj_source", 1);
            statisticItem3.param("obj_type", i4);
            TiebaStatic.log(statisticItem3);
        }
    }
}
