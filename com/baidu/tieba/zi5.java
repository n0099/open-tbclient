package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes9.dex */
public class zi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Queue<bj5> a;
    public volatile a b;

    /* loaded from: classes9.dex */
    public class a extends BdAsyncTask<Void, bj5, bj5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<bj5> a;
        public final /* synthetic */ zi5 b;

        public a(zi5 zi5Var, Queue<bj5> queue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi5Var, queue};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zi5Var;
            this.a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public bj5 doInBackground(Void... voidArr) {
            boolean z;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, voidArr)) != null) {
                return (bj5) invokeL.objValue;
            }
            while (true) {
                bj5 poll = this.a.poll();
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.a.add(poll);
                    return null;
                }
                ImageFileInfo imageFileInfo = poll.a;
                if (imageFileInfo != null) {
                    poll.d = zi5.f(imageFileInfo, poll.c);
                    if (TbImageMemoryCache.B().D(poll.a.toCachedKey(poll.c)) != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    poll.e = z;
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(bj5 bj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bj5Var) == null) {
                super.onPostExecute(bj5Var);
                this.b.b = null;
                this.b.h();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(bj5... bj5VarArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bj5VarArr) == null) && bj5VarArr != null) {
                for (bj5 bj5Var : bj5VarArr) {
                    BdImage bdImage = bj5Var.d;
                    if (bdImage != null && !bj5Var.e) {
                        TbImageMemoryCache.B().l(bj5Var.a.toCachedKey(bj5Var.c), bdImage);
                    }
                    wi5 wi5Var = bj5Var.b;
                    if (wi5Var != null) {
                        wi5Var.a(bdImage, bj5Var.a.toCachedKey(bj5Var.c), bj5Var.e);
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onCancelled();
                this.b.b = null;
                while (true) {
                    bj5 poll = this.a.poll();
                    if (poll == null) {
                        return;
                    }
                    wi5 wi5Var = poll.b;
                    if (wi5Var != null) {
                        wi5Var.a(null, poll.a.toCachedKey(poll.c), false);
                    }
                }
            }
        }
    }

    public zi5() {
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
        this.a = new ConcurrentLinkedQueue();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = new ConcurrentLinkedQueue();
            if (this.b != null) {
                this.b.cancel(true);
                this.b = null;
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.b == null && !this.a.isEmpty()) {
            this.b = new a(this, this.a);
            this.b.execute(new Void[0]);
        }
    }

    public BdImage c(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            return TbImageMemoryCache.B().D(imageFileInfo.toCachedKey(z));
        }
        return (BdImage) invokeLZ.objValue;
    }

    @Nullable
    public static BdImage f(@NonNull ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, imageFileInfo, z)) == null) {
            BdImage D = TbImageMemoryCache.B().D(imageFileInfo.toCachedKey(z));
            if (D != null) {
                return D;
            }
            Bitmap g = g(imageFileInfo, z);
            if (g != null) {
                int i = 0;
                Bitmap bitmap = null;
                try {
                    i = BitmapHelper.readPictureDegree(imageFileInfo.getFilePath());
                    if (i != 0) {
                        Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(g, i);
                        if (g != rotateBitmapBydegree) {
                            try {
                                g.recycle();
                                g = null;
                            } catch (Exception unused) {
                            }
                        }
                        bitmap = rotateBitmapBydegree;
                    }
                } catch (Exception unused2) {
                }
                if (i != 0 && bitmap != null) {
                    return new BdImage(bitmap, imageFileInfo.isGif(), imageFileInfo.getFilePath());
                }
                return new BdImage(g, imageFileInfo.isGif(), imageFileInfo.getFilePath());
            }
            return D;
        }
        return (BdImage) invokeLZ.objValue;
    }

    public static Bitmap g(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            if (z && imageFileInfo.getPersistActionsList() != null) {
                linkedList.addAll(imageFileInfo.getPersistActionsList());
            }
            if (imageFileInfo.getPageActionsList() != null) {
                linkedList.addAll(imageFileInfo.getPageActionsList());
            }
            if (imageFileInfo.getOrginalBitmap() != null) {
                try {
                    ij5 d = ij5.d();
                    Bitmap orginalBitmap = imageFileInfo.getOrginalBitmap();
                    if (!imageFileInfo.isOrginalBitmapShared()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    return d.b(orginalBitmap, z2, linkedList, imageFileInfo);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            } else if (imageFileInfo.hasActions(z)) {
                try {
                    return ij5.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            } else {
                return BitmapHelper.loadBitmap(imageFileInfo.getFilePath());
            }
        }
        return (Bitmap) invokeLZ.objValue;
    }

    public BdImage d(ImageFileInfo imageFileInfo, wi5 wi5Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, imageFileInfo, wi5Var, z)) == null) {
            return e(imageFileInfo, wi5Var, z, false);
        }
        return (BdImage) invokeLLZ.objValue;
    }

    public BdImage e(ImageFileInfo imageFileInfo, wi5 wi5Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{imageFileInfo, wi5Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            BdImage c = c(imageFileInfo, z);
            if (c != null) {
                return c;
            }
            if (z2) {
                return null;
            }
            bj5 bj5Var = new bj5();
            bj5Var.b = wi5Var;
            bj5Var.a = imageFileInfo;
            bj5Var.c = z;
            this.a.add(bj5Var);
            h();
            return null;
        }
        return (BdImage) invokeCommon.objValue;
    }
}
