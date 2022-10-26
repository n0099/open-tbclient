package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ih5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PersonGaussianBlurView extends PersonExpandImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a e;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonGaussianBlurView a;

        public a(PersonGaussianBlurView personGaussianBlurView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGaussianBlurView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personGaussianBlurView;
        }

        public final boolean c(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) {
                if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                super.onPostExecute((a) bitmap);
                if (!c(bitmap)) {
                    return;
                }
                this.a.setImageBitmap(bitmap);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Bitmap... bitmapArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmapArr)) == null) {
                if (bitmapArr == null) {
                    return null;
                }
                try {
                    if (bitmapArr.length == 0) {
                        return null;
                    }
                    Bitmap bitmap = bitmapArr[0];
                    if (!c(bitmap)) {
                        return null;
                    }
                    if (bitmap.getWidth() >= 600 || bitmap.getHeight() >= 600) {
                        int round = Math.round(bitmap.getWidth() * 0.5f);
                        int round2 = Math.round(bitmap.getHeight() * 0.5f);
                        if (round > 0 && round2 > 0) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, round, round2, false);
                            if (!c(bitmap)) {
                                return null;
                            }
                        }
                        return null;
                    }
                    return ih5.a(Bitmap.createBitmap(bitmap, 0, (int) (bitmap.getHeight() * 0.2f), bitmap.getWidth(), (int) (bitmap.getHeight() * 0.6f)), 15, false);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return (Bitmap) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonGaussianBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setSrc(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) && bitmap != null && !bitmap.isRecycled()) {
            a aVar = this.e;
            if (aVar != null) {
                aVar.cancel();
            }
            a aVar2 = new a(this);
            this.e = aVar2;
            aVar2.execute(bitmap);
        }
    }
}
