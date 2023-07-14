package com.baidu.tieba;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class wh9<T, V extends TypeAdapter.ViewHolder> extends ln<T, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bn9 a;
    public PbFragment b;
    public AbsVideoPbFragment c;
    public int d;
    public boolean e;
    public SparseIntArray f;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public wh9(bn9 bn9Var, BdUniqueId bdUniqueId) {
        super(r0, bdUniqueId);
        AbsPbActivity X;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bn9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (bn9Var == null) {
            X = null;
        } else {
            X = bn9Var.X();
        }
        this.d = 3;
        this.e = false;
        this.f = new SparseIntArray();
        t(bn9Var);
    }

    @Override // com.baidu.tieba.ln
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t, v})) == null) {
            this.d = TbadkCoreApplication.getInst().getSkinType();
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public int s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int i2 = this.f.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.f.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return invokeI.intValue;
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.e = z;
        }
    }

    public void t(bn9 bn9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bn9Var) == null) && bn9Var != null) {
            this.a = bn9Var;
            this.b = bn9Var.z1();
            AbsVideoPbFragment N = bn9Var.N();
            this.c = N;
            PbFragment pbFragment = this.b;
            if (pbFragment != null) {
                this.mContext = pbFragment.getActivity();
            } else if (N != null) {
                this.mContext = N.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }
}
