package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class yb extends DiskFileOperate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap a;
    public BitmapFactory.Options b;
    public a c;
    public boolean d;
    public long e;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic = null;
        public static byte d = Byte.MIN_VALUE;
        public static byte e = Byte.MIN_VALUE;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public long b;
        public boolean c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(268499559, "Lcom/baidu/tieba/yb$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(268499559, "Lcom/baidu/tieba/yb$a;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return 14;
            }
            return invokeV.intValue;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = false;
            this.b = 0L;
            this.c = true;
        }

        public boolean b(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
                if (bArr == null || bArr.length < a()) {
                    return false;
                }
                ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, a());
                if (wrap.getInt() != 1786600511) {
                    return false;
                }
                if ((wrap.get() & d) != 0) {
                    this.a = true;
                }
                this.b = wrap.getLong();
                if ((wrap.get() & e) != 0) {
                    this.c = false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public byte[] c() {
            InterceptResult invokeV;
            byte b;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ByteBuffer allocate = ByteBuffer.allocate(a());
                allocate.putInt(1786600511);
                byte b2 = 0;
                if (this.a) {
                    b = (byte) (d | 0);
                } else {
                    b = 0;
                }
                allocate.put(b);
                allocate.putLong(this.b);
                if (!this.c) {
                    b2 = (byte) (e | 0);
                }
                allocate.put(b2);
                allocate.flip();
                return allocate.array();
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yb(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, action};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = true;
        this.c = new a();
    }

    public static int a(BitmapFactory.Options options, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, options, i, i2)) == null) {
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            int i5 = 1;
            if (i3 > i2 || i4 > i) {
                int i6 = i3 / 2;
                int i7 = i4 / 2;
                while (i6 / i5 >= i2 && i7 / i5 >= i) {
                    i5 *= 2;
                }
            }
            return i5;
        }
        return invokeLII.intValue;
    }

    public boolean b(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i, i2)) == null) {
            if (bArr == null || !this.c.b(bArr)) {
                return false;
            }
            long j = this.c.b;
            if (j != 0 && j < System.currentTimeMillis()) {
                return false;
            }
            int a2 = a.a();
            try {
                if (this.b == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    this.b = options;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                this.b.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.b);
            } catch (Error e) {
                BdLog.e(e.getMessage());
            }
            if (!this.b.mCancel && this.b.outWidth != -1 && this.b.outHeight != -1) {
                this.b.inSampleSize = a(this.b, i, i2);
                this.b.inJustDecodeBounds = false;
                this.a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.b);
                if (this.a == null) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mData != null && this.d) {
                return this.c.c();
            }
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int a2 = a.a();
            int length = this.mData.length - a2;
            byte[] bArr = new byte[length];
            System.arraycopy(this.mData, a2, bArr, 0, length);
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c.c;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void endLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            zf.k(isSuccess(), System.currentTimeMillis() - this.e);
        }
    }

    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return (Bitmap) invokeV.objValue;
    }

    public boolean isGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c.a;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void startLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e = System.currentTimeMillis();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.c.c = z;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.d = z;
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bArr) == null) {
            super.setData(bArr);
            if (!isGif() && hi.D(bArr)) {
                setGif(true);
            }
        }
    }

    public void setGif(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.c.a = z;
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bArr)) == null) {
            if (bArr != null && this.c.b(bArr)) {
                long j = this.c.b;
                if (j == 0 || j >= System.currentTimeMillis()) {
                    if (this.b == null) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        this.b = options;
                        options.inPreferredConfig = Bitmap.Config.RGB_565;
                    }
                    int a2 = a.a();
                    try {
                        this.a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.b);
                    } catch (Error e) {
                        BdLog.e(e.getMessage());
                    }
                    if (this.a == null) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
