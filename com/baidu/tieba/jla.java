package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes5.dex */
public class jla extends era {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<Ssp> a;
    public final Set<zla> b;
    public final Set<xla> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jla(int i, ObjectInput objectInput) {
        super(i);
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), objectInput};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int readInt = objectInput.readInt();
        HashSet hashSet2 = new HashSet(readInt);
        HashMap hashMap = new HashMap();
        for (int i4 = 0; i4 < readInt; i4++) {
            Ssp ssp = new Ssp(objectInput.readInt(), objectInput);
            hashSet2.add(ssp);
            for (Ssp.Pid pid : ssp.pids) {
                hashMap.put(Long.valueOf(pid.id), pid);
            }
        }
        int readInt2 = objectInput.readInt();
        HashSet hashSet3 = new HashSet(readInt2);
        for (int i5 = 0; i5 < readInt2; i5++) {
            hashSet3.add(new zla(objectInput.readInt(), objectInput, hashMap));
        }
        this.a = Collections.unmodifiableSet(hashSet2);
        this.b = Collections.unmodifiableSet(hashSet3);
        if (i == 1) {
            int readInt3 = objectInput.readInt();
            hashSet = new HashSet(readInt3);
            for (int i6 = 0; i6 < readInt3; i6++) {
                hashSet.add(new xla(objectInput.readInt(), objectInput, hashMap));
            }
        } else {
            hashSet = new HashSet();
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jla(Set<Ssp> set, Set<zla> set2, Set<xla> set3) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {set, set2, set3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = set;
        this.b = set2;
        this.c = set3;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || jla.class != obj.getClass()) {
                return false;
            }
            jla jlaVar = (jla) obj;
            return Objects.equals(this.a, jlaVar.a) && Objects.equals(this.b, jlaVar.b);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Objects.hash(this.a, this.b) : invokeV.intValue;
    }

    @Override // com.baidu.tieba.era
    public void srzableInternal(ObjectOutput objectOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objectOutput) == null) {
            objectOutput.writeInt(this.a.size());
            for (Ssp ssp : this.a) {
                ssp.srzable(objectOutput);
            }
            objectOutput.writeInt(this.b.size());
            for (zla zlaVar : this.b) {
                zlaVar.srzable(objectOutput);
            }
            objectOutput.writeInt(this.c.size());
            for (xla xlaVar : this.c) {
                xlaVar.srzable(objectOutput);
            }
        }
    }
}
