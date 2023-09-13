package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class wl5 extends jm5<gm5, hm5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hm5 v;
    public int w;
    public final Paint x;
    public final b y;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte a;
        public Rect b;
        public ByteBuffer c;

        public b() {
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
            this.b = new Rect();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wl5(sm5 sm5Var, km5 km5Var) {
        super(sm5Var, km5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sm5Var, km5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((sm5) objArr2[0], (km5) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = new Paint();
        this.y = new b(null);
        this.x.setAntiAlias(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jm5
    /* renamed from: Q */
    public gm5 x(om5 om5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, om5Var)) == null) {
            return new gm5(om5Var);
        }
        return (gm5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.jm5
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.y.c = null;
            this.v = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jm5
    /* renamed from: R */
    public hm5 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.v == null) {
                this.v = new hm5();
            }
            return this.v;
        }
        return (hm5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jm5
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jm5
    public void J(im5<gm5, hm5> im5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, im5Var) == null) && im5Var != null && this.o != null) {
            try {
                Bitmap E = E(this.o.width() / this.j, this.o.height() / this.j);
                Canvas canvas = this.m.get(E);
                if (canvas == null) {
                    canvas = new Canvas(E);
                    this.m.put(E, canvas);
                }
                Canvas canvas2 = canvas;
                if (im5Var instanceof xl5) {
                    this.n.rewind();
                    E.copyPixelsFromBuffer(this.n);
                    if (this.d == 0) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else {
                        canvas2.save();
                        canvas2.clipRect(this.y.b);
                        byte b2 = this.y.a;
                        if (b2 != 1) {
                            if (b2 == 2) {
                                this.y.c.rewind();
                                E.copyPixelsFromBuffer(this.y.c);
                            }
                        } else {
                            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                        }
                        canvas2.restore();
                    }
                    if (((xl5) im5Var).j == 2 && this.y.a != 2) {
                        this.y.c.rewind();
                        E.copyPixelsToBuffer(this.y.c);
                    }
                    this.y.a = ((xl5) im5Var).j;
                    canvas2.save();
                    if (((xl5) im5Var).i == 0) {
                        canvas2.clipRect(im5Var.d / this.j, im5Var.e / this.j, (im5Var.d + im5Var.b) / this.j, (im5Var.e + im5Var.c) / this.j);
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    }
                    this.y.b.set(im5Var.d / this.j, im5Var.e / this.j, (im5Var.d + im5Var.b) / this.j, (im5Var.e + im5Var.c) / this.j);
                    canvas2.restore();
                }
                Bitmap E2 = E(im5Var.b, im5Var.c);
                G(im5Var.a(canvas2, this.x, this.j, E2, z()));
                G(E2);
                this.n.rewind();
                E.copyPixelsToBuffer(this.n);
                G(E);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jm5
    /* renamed from: S */
    public Rect F(gm5 gm5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gm5Var)) == null) {
            List<zl5> a2 = yl5.a(gm5Var);
            ArrayList arrayList = new ArrayList();
            byte[] bArr = new byte[0];
            Iterator<zl5> it = a2.iterator();
            xl5 xl5Var = null;
            boolean z = false;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                zl5 next = it.next();
                if (next instanceof vl5) {
                    this.w = ((vl5) next).c;
                    z = true;
                } else if (next instanceof am5) {
                    xl5Var = new xl5(gm5Var, (am5) next);
                    xl5Var.m = arrayList;
                    xl5Var.k = bArr;
                    this.c.add(xl5Var);
                } else if (next instanceof bm5) {
                    if (xl5Var != null) {
                        xl5Var.l.add(next);
                    }
                } else if (next instanceof cm5) {
                    if (!z) {
                        fm5 fm5Var = new fm5(gm5Var);
                        fm5Var.b = i;
                        fm5Var.c = i2;
                        this.c.add(fm5Var);
                        this.w = 1;
                        break;
                    } else if (xl5Var != null) {
                        xl5Var.l.add(next);
                    }
                } else if (next instanceof em5) {
                    em5 em5Var = (em5) next;
                    i = em5Var.c;
                    i2 = em5Var.d;
                    bArr = em5Var.e;
                } else if (!(next instanceof dm5)) {
                    arrayList.add(next);
                }
            }
            int i3 = i * i2;
            int i4 = this.j;
            this.n = ByteBuffer.allocate(((i3 / (i4 * i4)) + 1) * 4);
            b bVar = this.y;
            int i5 = this.j;
            bVar.c = ByteBuffer.allocate(((i3 / (i5 * i5)) + 1) * 4);
            return new Rect(0, 0, i, i2);
        }
        return (Rect) invokeL.objValue;
    }
}
