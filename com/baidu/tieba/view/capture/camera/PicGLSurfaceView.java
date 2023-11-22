package com.baidu.tieba.view.capture.camera;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.k1b;
import com.baidu.tieba.zq6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.faceunity.gles.GeneratedTexture;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes8.dex */
public class PicGLSurfaceView extends AspectGLSurfaceView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zq6.c e;
    public boolean f;
    public int g;
    public int h;
    public String i;

    /* loaded from: classes8.dex */
    public class a implements GLSurfaceView.Renderer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PicGLSurfaceView a;

        public a(PicGLSurfaceView picGLSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {picGLSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = picGLSurfaceView;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gl10) == null) {
                GLSurfaceView.Renderer renderer = this.a.d;
                if (renderer == null) {
                    gl10.glClear(16640);
                } else {
                    renderer.onDrawFrame(gl10);
                }
                if (this.a.f) {
                    PicGLSurfaceView picGLSurfaceView = this.a;
                    picGLSurfaceView.k(picGLSurfaceView, gl10);
                    this.a.f = false;
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gl10, i, i2) == null) {
                GLSurfaceView.Renderer renderer = this.a.d;
                if (renderer == null) {
                    gl10.glViewport(0, 0, i, i2);
                } else {
                    renderer.onSurfaceChanged(gl10, i, i2);
                }
                this.a.g = i;
                this.a.h = i2;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gl10, eGLConfig) == null) {
                GLSurfaceView.Renderer renderer = this.a.d;
                if (renderer == null) {
                    gl10.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
                } else {
                    renderer.onSurfaceCreated(gl10, eGLConfig);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ PicGLSurfaceView b;
        public final /* synthetic */ PicGLSurfaceView c;

        public b(PicGLSurfaceView picGLSurfaceView, Bitmap bitmap, PicGLSurfaceView picGLSurfaceView2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {picGLSurfaceView, bitmap, picGLSurfaceView2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = picGLSurfaceView;
            this.a = bitmap;
            this.b = picGLSurfaceView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r5) {
            PicGLSurfaceView picGLSurfaceView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, r5) == null) && (picGLSurfaceView = this.b) != null && picGLSurfaceView.e != null) {
                this.b.e.a(true, this.c.i);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                Bitmap bitmap = this.a;
                try {
                    String str = "pic_" + System.currentTimeMillis();
                    if (this.b.getContext() != null) {
                        bitmap = BitmapHelper.getClipBitmap(bitmap, (BdUtilHelper.getEquipmentHeight(context) * 1.0f) / BdUtilHelper.getEquipmentWidth(context));
                    }
                    this.c.i = FileHelper.saveFileAsPic(k1b.i, str, bitmap, 80, Bitmap.CompressFormat.JPEG);
                    return null;
                } finally {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                }
            }
            return (Void) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PicGLSurfaceView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PicGLSurfaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void l(PicGLSurfaceView picGLSurfaceView, Bitmap bitmap) {
        zq6.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, picGLSurfaceView, bitmap) == null) {
            this.i = null;
            if (bitmap != null && !bitmap.isRecycled()) {
                new b(this, bitmap, picGLSurfaceView).execute(new Void[0]);
            } else if (picGLSurfaceView != null && (cVar = picGLSurfaceView.e) != null) {
                cVar.a(false, this.i);
            }
        }
    }

    @Override // com.baidu.tieba.view.capture.camera.AspectGLSurfaceView
    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            this.c = new a(this);
            b(i, i2);
        }
    }

    public void m(zq6.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.e = cVar;
            this.f = true;
            requestRender();
        }
    }

    public final void k(PicGLSurfaceView picGLSurfaceView, GL10 gl10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, picGLSurfaceView, gl10) == null) {
            Bitmap bitmap = null;
            try {
                System.gc();
                System.gc();
                int i = picGLSurfaceView.g;
                int i2 = picGLSurfaceView.h;
                int i3 = i * i2;
                int[] iArr = new int[i3];
                int[] iArr2 = new int[i3];
                IntBuffer wrap = IntBuffer.wrap(iArr);
                wrap.position(0);
                gl10.glReadPixels(0, 0, i, i2, GeneratedTexture.FORMAT, 5121, wrap);
                for (int i4 = 0; i4 < i2; i4++) {
                    int i5 = i4 * i;
                    int i6 = ((i2 - i4) - 1) * i;
                    for (int i7 = 0; i7 < i; i7++) {
                        int i8 = iArr[i5 + i7];
                        iArr2[i6 + i7] = (i8 & DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK) | ((i8 << 16) & 16711680) | ((i8 >> 16) & 255);
                    }
                }
                bitmap = Bitmap.createBitmap(iArr2, i, i2, Bitmap.Config.ARGB_8888);
            } catch (GLException unused) {
            } catch (OutOfMemoryError unused2) {
                if (picGLSurfaceView != null) {
                    Context context = picGLSurfaceView.getContext();
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
                System.gc();
                System.gc();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                l(picGLSurfaceView, bitmap);
            }
        }
    }
}
