package com.baidu.tieba;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.zb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class yb extends zb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect e;

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
        this.e = null;
        this.e = new Rect();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e A[RETURN] */
    @Override // com.baidu.tieba.zb, com.baidu.adp.lib.Disk.ops.DiskFileOperate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean formatData(byte[] bArr) {
        InterceptResult invokeL;
        ByteArrayInputStream byteArrayInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr != null && this.c.b(bArr)) {
                long j = this.c.b;
                if (j == 0 || j >= System.currentTimeMillis()) {
                    if (this.b == null) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        this.b = options;
                        options.inDither = false;
                        int g = g();
                        BitmapFactory.Options options2 = this.b;
                        options2.inScreenDensity = g;
                        options2.inTargetDensity = g;
                        options2.inDensity = g;
                    }
                    int a = zb.a.a();
                    ByteArrayInputStream byteArrayInputStream2 = null;
                    try {
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(bArr, a, bArr.length - a);
                        } catch (Error e) {
                            e = e;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        this.a = BitmapFactory.decodeStream(byteArrayInputStream, this.e, this.b);
                        BdCloseHelper.close((InputStream) byteArrayInputStream);
                    } catch (Error e2) {
                        e = e2;
                        byteArrayInputStream2 = byteArrayInputStream;
                        BdLog.e(e.getMessage());
                        BdCloseHelper.close((InputStream) byteArrayInputStream2);
                        if (this.a != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayInputStream2 = byteArrayInputStream;
                        BdCloseHelper.close((InputStream) byteArrayInputStream2);
                        throw th;
                    }
                    if (this.a != null) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return BdBaseApplication.getInst().getContext().getResources().getDisplayMetrics().densityDpi;
        }
        return invokeV.intValue;
    }

    public Rect h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (Rect) invokeV.objValue;
    }
}
