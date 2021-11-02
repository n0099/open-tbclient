package com.baidu.wallet.personal.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f60614a;

    /* renamed from: b  reason: collision with root package name */
    public int f60615b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f60616c;

    /* renamed from: d  reason: collision with root package name */
    public Resources f60617d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Integer> f60618e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Integer> f60619f;

    public a(Resources resources, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources, bitmap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60618e = new ArrayList<>();
        this.f60619f = new ArrayList<>();
        this.f60614a = bitmap.getWidth();
        this.f60615b = bitmap.getHeight();
        this.f60616c = bitmap;
        this.f60617d = resources;
    }

    public a a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = (this.f60615b - i2) / 2;
            this.f60619f.add(Integer.valueOf(i3));
            this.f60619f.add(Integer.valueOf(i3 + i2));
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            this.f60618e.add(Integer.valueOf(i2));
            this.f60618e.add(Integer.valueOf(i2 + i3));
            return this;
        }
        return (a) invokeII.objValue;
    }

    public byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f60618e.size() == 0) {
                this.f60618e.add(0);
                this.f60618e.add(Integer.valueOf(this.f60614a));
            }
            if (this.f60619f.size() == 0) {
                this.f60619f.add(0);
                this.f60619f.add(Integer.valueOf(this.f60615b));
            }
            ByteBuffer order = ByteBuffer.allocate((this.f60618e.size() + 8 + this.f60619f.size() + 9) * 4).order(ByteOrder.nativeOrder());
            order.put((byte) 1);
            order.put((byte) this.f60618e.size());
            order.put((byte) this.f60619f.size());
            order.put((byte) 9);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            Iterator<Integer> it = this.f60618e.iterator();
            while (it.hasNext()) {
                order.putInt(it.next().intValue());
            }
            Iterator<Integer> it2 = this.f60619f.iterator();
            while (it2.hasNext()) {
                order.putInt(it2.next().intValue());
            }
            for (int i2 = 0; i2 < 9; i2++) {
                order.putInt(1);
            }
            return order.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public NinePatch b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            byte[] a2 = a();
            if (this.f60616c != null) {
                return new NinePatch(this.f60616c, a2, null);
            }
            return null;
        }
        return (NinePatch) invokeV.objValue;
    }

    public a b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            this.f60619f.add(Integer.valueOf(i2));
            this.f60619f.add(Integer.valueOf(i2 + i3));
            return this;
        }
        return (a) invokeII.objValue;
    }

    public NinePatchDrawable c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            NinePatch b2 = b();
            if (b2 != null) {
                return new NinePatchDrawable(this.f60617d, b2);
            }
            return null;
        }
        return (NinePatchDrawable) invokeV.objValue;
    }
}
