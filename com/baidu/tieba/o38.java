package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class o38 extends lm<b48, CardViewHolder<b>> {
    public static /* synthetic */ Interceptable $ic;
    public static final int b;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* loaded from: classes7.dex */
    public class a implements in {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;
        public final /* synthetic */ o38 b;

        public a(o38 o38Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o38Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o38Var;
            this.a = bVar;
        }

        @Override // com.baidu.tieba.in
        public void b(View view2, ym ymVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ymVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && view2 != null && (bVar = this.a) != null && !bi.isEmpty(bVar.l)) {
                w48.a(this.a.m);
                UrlManager.getInstance().dealOneLink(this.b.a, new String[]{this.a.l});
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends em6<b48> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView i;
        public ImageView j;
        public View k;
        public String l;
        public List<String> m;

        @Override // com.baidu.tieba.em6
        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01d7 : invokeV.intValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            TbImageView tbImageView = (TbImageView) h().findViewById(R.id.obfuscated_res_0x7f091e01);
            this.i = tbImageView;
            tbImageView.setAutoChangeStyle(true);
            this.i.setRadiusById(R.string.J_X06);
            this.i.setConrers(15);
            this.i.setScaleType(ImageView.ScaleType.FIT_XY);
            this.i.setPlaceHolder(2);
            this.k = h().findViewById(R.id.obfuscated_res_0x7f09073e);
            this.j = (ImageView) h().findViewById(R.id.obfuscated_res_0x7f09072f);
            this.k.setOnClickListener(this);
            h().setOnClickListener(this);
            WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, null);
            j(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && view2 == this.k) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016569));
            }
        }

        public void x(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
                this.k.setOnClickListener(onClickListener);
            }
        }

        public void y(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
                h().setOnClickListener(onClickListener);
            }
        }

        @Override // com.baidu.tieba.em6
        public void j(TbPageContext tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
                SkinManager.setBackgroundColor(h(), R.color.transparent);
                WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.em6
        /* renamed from: t */
        public void i(b48 b48Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, b48Var) == null) {
                if (b48Var != null) {
                    u(b48Var.c, b48Var.b);
                    this.i.setPlaceHolder(2);
                    this.i.startLoad(b48Var.d, 10, false);
                    this.l = b48Var.e;
                    this.m = b48Var.g;
                }
                j(g(), TbadkCoreApplication.getInst().getSkinType());
            }
        }

        public final void u(int i, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeII(1048581, this, i, i2) != null) || this.i == null) {
                return;
            }
            Context context = TbadkCoreApplication.getInst().getContext();
            ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
            if (context != null && layoutParams != null) {
                int i4 = o38.b;
                if (i > 0 && i2 > 0) {
                    i3 = (int) (((i4 * 1.0f) * i2) / i);
                } else {
                    i3 = (int) (((i4 * 1.0f) * 182.0f) / 988.0f);
                }
                layoutParams.width = -1;
                layoutParams.height = i3;
                this.i.setLayoutParams(layoutParams);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947981429, "Lcom/baidu/tieba/o38;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947981429, "Lcom/baidu/tieba/o38;");
                return;
            }
        }
        b = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o38(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: u */
    public CardViewHolder<b> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            b bVar = new b(this.a, viewGroup);
            bVar.h().setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
            setOnAdapterItemClickListener(new a(this, bVar));
            return new CardViewHolder<>(bVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, b48 b48Var, CardViewHolder<b> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, b48Var, cardViewHolder})) == null) {
            if (b48Var != null && cardViewHolder != null && cardViewHolder.b() != null) {
                w48.b(b48Var.f);
                cardViewHolder.b().i(b48Var);
                return cardViewHolder.b().h();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
