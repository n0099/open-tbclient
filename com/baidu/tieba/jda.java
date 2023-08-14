package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class jda extends hda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jda(String str, int i, int i2, long j, String str2) {
        super(str, i, i2, j, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.hda
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = true;
        }
    }

    @Override // com.baidu.tieba.hda
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hda
    public kda g(ArrayList<Integer> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, str, i)) == null) {
            kda kdaVar = new kda();
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.b), "r");
                int i2 = 0;
                int size = arrayList.size();
                Iterator<Integer> it = arrayList.iterator();
                while (it.hasNext()) {
                    int i3 = i2 + 1;
                    kda h = h(randomAccessFile, it.next().intValue(), i, str);
                    if (h == null) {
                        return null;
                    }
                    d((int) (((i3 * 50.0f) / size) + 30.0f));
                    if (!StringUtils.isNull(h.a)) {
                        return h;
                    }
                    if (h.b != 0) {
                        return h;
                    }
                    i2 = i3;
                    kdaVar = h;
                }
            } catch (FileNotFoundException unused) {
            }
            return kdaVar;
        }
        return (kda) invokeLLI.objValue;
    }
}
