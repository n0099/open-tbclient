package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes8.dex */
public class xc1 implements zc1<ImageView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, h> c;
    public final Lock d;

    /* loaded from: classes8.dex */
    public interface g {
        void a();

        void b(Bitmap bitmap);
    }

    /* loaded from: classes8.dex */
    public static final class d implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<ImageView> a;
        public int b;
        public int c;

        @Override // com.baidu.tieba.xc1.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageView a;
            public final /* synthetic */ Bitmap b;
            public final /* synthetic */ d c;

            public a(d dVar, ImageView imageView, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, imageView, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = dVar;
                this.a = imageView;
                this.b = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.setImageBitmap(this.b);
                    if (this.c.c >= 0) {
                        this.a.setAlpha(this.c.c / 100.0f);
                    }
                }
            }
        }

        public d(ImageView imageView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(imageView);
            this.b = i;
            this.c = i2;
        }

        @Override // com.baidu.tieba.xc1.g
        public void b(Bitmap bitmap) {
            ImageView imageView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) != null) || (imageView = this.a.get()) == null) {
                return;
            }
            imageView.post(new a(this, imageView, ((xc1) rc1.a()).k(imageView, bitmap, this.b, this.c)));
        }
    }

    /* loaded from: classes8.dex */
    public static final class e implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<ImageView> a;
        public Boolean b;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageView a;
            public final /* synthetic */ Bitmap b;
            public final /* synthetic */ e c;

            public a(e eVar, ImageView imageView, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, imageView, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = eVar;
                this.a = imageView;
                this.b = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.setImageBitmap(this.b);
                    this.a.setBackgroundResource(17170445);
                    if (this.c.b.booleanValue()) {
                        this.a.setVisibility(0);
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageView a;

            public b(e eVar, ImageView imageView) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, imageView};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = imageView;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.setImageDrawable(((xc1) rc1.a()).l(this.a));
            }
        }

        public e(ImageView imageView, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView, bool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(imageView);
            this.b = bool;
        }

        @Override // com.baidu.tieba.xc1.g
        public void b(Bitmap bitmap) {
            ImageView imageView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) != null) || (imageView = this.a.get()) == null) {
                return;
            }
            zk0.b(new a(this, imageView, bitmap));
        }

        @Override // com.baidu.tieba.xc1.g
        public void a() {
            ImageView imageView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (imageView = this.a.get()) == null) {
                return;
            }
            zk0.b(new b(this, imageView));
        }
    }

    /* loaded from: classes8.dex */
    public class a implements jt0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ h b;
        public final /* synthetic */ xc1 c;

        public a(xc1 xc1Var, String str, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc1Var, str, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xc1Var;
            this.a = str;
            this.b = hVar;
        }

        @Override // com.baidu.tieba.jt0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                this.c.d.lock();
                try {
                    this.c.c.remove(this.a);
                    this.b.a();
                } finally {
                    this.c.d.unlock();
                }
            }
        }

        @Override // com.baidu.tieba.jt0
        public void c(Headers headers, InputStream inputStream, int i) {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPurgeable = true;
                options.inInputShareable = true;
                Bitmap decodeStream = BitmapFactory.decodeStream(new f(inputStream), null, options);
                if (decodeStream != null) {
                    String str = this.a;
                    if (!str.substring(str.lastIndexOf("/") + 1).toUpperCase().contains("PNG")) {
                        bitmap = xc1.p(xc1.q(decodeStream, 100 - (this.c.r(decodeStream) * 10)), xc1.s(options));
                    } else {
                        bitmap = decodeStream;
                    }
                    if (bitmap != null) {
                        decodeStream = bitmap;
                    }
                    ij0.d().j(this.a, decodeStream);
                    this.c.d.lock();
                    try {
                        this.c.c.remove(this.a);
                        this.b.b(decodeStream);
                        return;
                    } finally {
                    }
                }
                this.c.d.lock();
                try {
                    this.c.c.remove(this.a);
                    this.b.a();
                } finally {
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ep0 a;

        public b(xc1 xc1Var, ep0 ep0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc1Var, ep0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ep0Var;
        }

        @Override // com.baidu.tieba.xc1.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }

        @Override // com.baidu.tieba.xc1.g
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.a.b(bitmap);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ep0 a;

        public c(xc1 xc1Var, ep0 ep0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc1Var, ep0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ep0Var;
        }

        @Override // com.baidu.tieba.xc1.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }

        @Override // com.baidu.tieba.xc1.g
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.a.b(bitmap);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class f extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InputStream inputStream) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                long j2 = 0;
                while (j2 < j) {
                    long skip = ((FilterInputStream) this).in.skip(j - j2);
                    if (skip == 0) {
                        if (read() < 0) {
                            break;
                        }
                        skip = 1;
                    }
                    j2 += skip;
                }
                return j2;
            }
            return invokeJ.longValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class h implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final List<g> a;

        public h() {
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
            this.a = new LinkedList();
        }

        @Override // com.baidu.tieba.xc1.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (g gVar : this.a) {
                    gVar.a();
                }
            }
        }

        @Override // com.baidu.tieba.xc1.g
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                for (g gVar : this.a) {
                    gVar.b(bitmap);
                }
            }
        }

        public void c(@Nullable g gVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) && gVar != null) {
                x21.b(this.a, gVar);
            }
        }
    }

    public xc1() {
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
        this.c = new ConcurrentHashMap();
        this.d = new ReentrantLock();
    }

    public static int j(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bitmap)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                return bitmap.getAllocationByteCount();
            }
            if (i >= 12) {
                return bitmap.getByteCount();
            }
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
        return invokeL.intValue;
    }

    public static int s(BitmapFactory.Options options) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, options)) == null) {
            int i2 = options.outHeight;
            int i3 = options.outWidth;
            if (i2 <= 1140 && i3 <= 1140) {
                i = 1;
            } else {
                int i4 = 2;
                int i5 = i2 / 2;
                int i6 = i3 / 2;
                while (true) {
                    if (i5 < 1140 && i6 < 1140) {
                        break;
                    }
                    i4 *= 2;
                }
                i = i4;
            }
            if (i > 6) {
                return 6;
            }
            return i;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.fp0
    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || ij0.d().h(str) != null) {
            return;
        }
        n(str, null);
    }

    public int r(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bitmap)) == null) {
            int j = j(bitmap);
            if (j > 2457600) {
                int i = j / 2457600;
                if (i > 6) {
                    return 6;
                }
                return i;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.fp0
    public void c(String str, ep0 ep0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ep0Var) != null) || ep0Var == null) {
            return;
        }
        Bitmap h2 = ij0.d().h(str);
        if (h2 == null) {
            n(str, new c(this, ep0Var));
        } else {
            ep0Var.b(h2);
        }
    }

    @Override // com.baidu.tieba.zc1
    public void e(@NonNull String str, ep0 ep0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, ep0Var) == null) {
            Bitmap h2 = ij0.d().h(str);
            if (h2 == null) {
                n(str, new b(this, ep0Var));
            } else {
                ep0Var.b(h2);
            }
        }
    }

    public final void o(String str, @NonNull h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, hVar) == null) {
            st0 st0Var = new st0();
            st0Var.l(str);
            st0Var.c();
            zs0.b().a().b(st0Var, new a(this, str, hVar));
        }
    }

    public static Bitmap p(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, bitmap, i)) == null) {
            if (i <= 1) {
                return bitmap;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            float f2 = 1.0f / i;
            matrix.postScale(f2, f2);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap q(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, bitmap, i)) == null) {
            if (i == 100) {
                return bitmap;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            try {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.zc1
    public void a(String str, ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048576, this, str, imageView, z) != null) || imageView == null) {
            return;
        }
        Bitmap h2 = ij0.d().h(str);
        if (h2 == null) {
            imageView.setImageDrawable(m(imageView));
            n(str, new e(imageView, Boolean.valueOf(z)));
            return;
        }
        imageView.setImageBitmap(h2);
        imageView.setBackgroundResource(17170445);
        if (z) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.zc1
    public void b(String str, ImageView imageView, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, imageView, i, i2) != null) || imageView == null) {
            return;
        }
        Bitmap h2 = ij0.d().h(str);
        if (h2 == null) {
            n(str, new d(imageView, i, i2));
            return;
        }
        imageView.setImageBitmap(k(imageView, h2, i, i2));
        if (i2 >= 0) {
            imageView.setAlpha(i2 / 100.0f);
        }
    }

    public final Bitmap k(View view2, Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048581, this, view2, bitmap, i, i2)) == null) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
            Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
            RenderScript create = RenderScript.create(view2.getContext());
            if (Build.VERSION.SDK_INT >= 17) {
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(i);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
            }
            return createBitmap;
        }
        return (Bitmap) invokeLLII.objValue;
    }

    public final Drawable l(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            if (!(view2 instanceof AdImageView)) {
                return sc1.b().a(view2.getContext());
            }
            int i = ((AdImageView) view2).getConfig().c;
            if (i != 0) {
                return view2.getResources().getDrawable(i);
            }
            return sc1.b().a(view2.getContext());
        }
        return (Drawable) invokeL.objValue;
    }

    public final Drawable m(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            if (!(view2 instanceof AdImageView)) {
                return sc1.b().b(view2.getContext());
            }
            AdImageView adImageView = (AdImageView) view2;
            if (adImageView.getConfig().b != null) {
                return adImageView.getConfig().b;
            }
            int i = adImageView.getConfig().a;
            if (i != 0) {
                return view2.getResources().getDrawable(i);
            }
            return sc1.b().b(view2.getContext());
        }
        return (Drawable) invokeL.objValue;
    }

    public final void n(String str, @Nullable g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, gVar) == null) {
            this.d.lock();
            try {
                h hVar = this.c.get(str);
                if (hVar == null) {
                    h hVar2 = new h();
                    this.c.put(str, hVar2);
                    hVar2.c(gVar);
                    o(str, hVar2);
                } else {
                    kl0.a(ImageLoader.TAG, DataEntryUrlBox.TYPE + str + " cached connection!");
                    hVar.c(gVar);
                }
            } finally {
                this.d.unlock();
            }
        }
    }
}
