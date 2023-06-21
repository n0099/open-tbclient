package com.baidu.tieba;

import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class n06 extends s06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConstrainImageLayout.c e;

    /* loaded from: classes6.dex */
    public class a implements ConstrainImageLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(n06 n06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.widget.layout.ConstrainImageLayout.c
        public void a(TbImageView tbImageView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, tbImageView, i, i2) == null) {
                tbImageView.setRadiusById(R.string.J_X05);
                tbImageView.s();
                tbImageView.setDrawCorner(true);
                tbImageView.setConrers(0);
                if (i2 == 1) {
                    tbImageView.setConrers(15);
                } else if (i2 > 1) {
                    if (i == 0) {
                        tbImageView.setConrers(5);
                    } else if (i == i2 - 1) {
                        tbImageView.setConrers(10);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n06(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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
        this.e = new a(this);
    }

    @Override // com.baidu.tieba.s06, com.baidu.tieba.p06
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, constrainImageLayout, list, i, i2)) == null) {
            if (list.size() < this.b) {
                list.size();
            }
            constrainImageLayout.setTbImageViewConfiguration(this.e);
            return super.a(constrainImageLayout, list, i, i2);
        }
        return invokeLLII.intValue;
    }
}
