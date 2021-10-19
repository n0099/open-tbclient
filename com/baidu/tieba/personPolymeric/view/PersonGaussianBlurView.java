package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import c.a.q0.d1.l;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonGaussianBlurView extends PersonExpandImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public a f56125i;

    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Bitmap, String, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonGaussianBlurView f56126a;

        public a(PersonGaussianBlurView personGaussianBlurView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGaussianBlurView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56126a = personGaussianBlurView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Bitmap... bitmapArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmapArr)) == null) {
                if (bitmapArr != null) {
                    try {
                        if (bitmapArr.length == 0) {
                            return null;
                        }
                        Bitmap bitmap = bitmapArr[0];
                        if (c(bitmap)) {
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
                            return l.a(Bitmap.createBitmap(bitmap, 0, (int) (bitmap.getHeight() * 0.2f), bitmap.getWidth(), (int) (bitmap.getHeight() * 0.6f)), 15, false);
                        }
                        return null;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
            return (Bitmap) invokeL.objValue;
        }

        public final boolean c(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) ? (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) ? false : true : invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                super.onPostExecute((a) bitmap);
                if (c(bitmap)) {
                    this.f56126a.setImageBitmap(bitmap);
                }
            }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        a aVar = this.f56125i;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(this);
        this.f56125i = aVar2;
        aVar2.execute(bitmap);
    }
}
