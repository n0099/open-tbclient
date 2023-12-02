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
/* loaded from: classes6.dex */
public class jj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Queue<lj5> a;
    public volatile a b;

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Void, lj5, lj5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<lj5> a;
        public final /* synthetic */ jj5 b;

        public a(jj5 jj5Var, Queue<lj5> queue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jj5Var, queue};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jj5Var;
            this.a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public lj5 doInBackground(Void... voidArr) {
            boolean z;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, voidArr)) != null) {
                return (lj5) invokeL.objValue;
            }
            while (true) {
                lj5 poll = this.a.poll();
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.a.add(poll);
                    return null;
                }
                ImageFileInfo imageFileInfo = poll.a;
                if (imageFileInfo != null) {
                    poll.d = jj5.f(imageFileInfo, poll.c);
                    if (TbImageMemoryCache.w().D(poll.a.toCachedKey(poll.c)) != null) {
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
        public void onPostExecute(lj5 lj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lj5Var) == null) {
                super.onPostExecute(lj5Var);
                this.b.b = null;
                this.b.h();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(lj5... lj5VarArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lj5VarArr) == null) && lj5VarArr != null) {
                for (lj5 lj5Var : lj5VarArr) {
                    BdImage bdImage = lj5Var.d;
                    if (bdImage != null && !lj5Var.e) {
                        TbImageMemoryCache.w().k(lj5Var.a.toCachedKey(lj5Var.c), bdImage);
                    }
                    gj5 gj5Var = lj5Var.b;
                    if (gj5Var != null) {
                        gj5Var.a(bdImage, lj5Var.a.toCachedKey(lj5Var.c), lj5Var.e);
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
                    lj5 poll = this.a.poll();
                    if (poll == null) {
                        return;
                    }
                    gj5 gj5Var = poll.b;
                    if (gj5Var != null) {
                        gj5Var.a(null, poll.a.toCachedKey(poll.c), false);
                    }
                }
            }
        }
    }

    public jj5() {
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
            return TbImageMemoryCache.w().D(imageFileInfo.toCachedKey(z));
        }
        return (BdImage) invokeLZ.objValue;
    }

    @Nullable
    public static BdImage f(@NonNull ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, imageFileInfo, z)) == null) {
            BdImage D = TbImageMemoryCache.w().D(imageFileInfo.toCachedKey(z));
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
                    sj5 d = sj5.d();
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
                    return sj5.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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

    public BdImage d(ImageFileInfo imageFileInfo, gj5 gj5Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, imageFileInfo, gj5Var, z)) == null) {
            return e(imageFileInfo, gj5Var, z, false);
        }
        return (BdImage) invokeLLZ.objValue;
    }

    public BdImage e(ImageFileInfo imageFileInfo, gj5 gj5Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{imageFileInfo, gj5Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            BdImage c = c(imageFileInfo, z);
            if (c != null) {
                return c;
            }
            if (z2) {
                return null;
            }
            lj5 lj5Var = new lj5();
            lj5Var.b = gj5Var;
            lj5Var.a = imageFileInfo;
            lj5Var.c = z;
            this.a.add(lj5Var);
            h();
            return null;
        }
        return (BdImage) invokeCommon.objValue;
    }
}
