package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class k4a extends l4a<k5a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout g;
    public TbImageView h;
    public View i;
    public EMTextView j;
    public ImageView k;
    public b l;

    /* loaded from: classes5.dex */
    public interface b {
        void onClick();
    }

    @Override // com.baidu.tieba.q4a
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.q4a
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.q4a
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k4a a;

        public a(k4a k4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k4aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.l != null) {
                this.a.l.onClick();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k4a(@NonNull TbPageContext<?> tbPageContext) {
        super(tbPageContext, k5a.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void A(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public void B(int i) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (relativeLayout = this.g) != null) {
            relativeLayout.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.q4a
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            q25 d = q25.d(this.g);
            d.o(R.string.J_X05);
            d.m(R.dimen.L_X01);
            d.l(R.color.CAM_X0112);
            d.f(R.color.CAM_X0212);
            q25.d(this.i).f(R.color.CAM_X0203);
            q25 d2 = q25.d(this.j);
            d2.w(R.color.CAM_X0107);
            d2.B(R.dimen.T_X08);
            WebPManager.setPureDrawable(this.k, R.drawable.obfuscated_res_0x7f080a60, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setMaskDrawable(this.h, R.drawable.obfuscated_res_0x7f0808a0, WebPManager.ResourceStateType.NORMAL);
        }
    }

    @Override // com.baidu.tieba.q4a
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            this.g = new RelativeLayout(this.a.getPageActivity());
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, ii.g(this.a.getPageActivity(), R.dimen.tbds117));
            marginLayoutParams.setMargins(ii.g(this.a.getPageActivity(), R.dimen.M_W_X007), 0, ii.g(this.a.getPageActivity(), R.dimen.M_W_X007), ii.g(this.a.getPageActivity(), R.dimen.M_H_X004));
            this.g.setLayoutParams(marginLayoutParams);
            LinearLayout linearLayout = new LinearLayout(this.a.getPageActivity());
            linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            this.h = new TbImageView(this.a.getPageActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ii.g(this.a.getPageActivity(), R.dimen.tbds104), ii.g(this.a.getPageActivity(), R.dimen.tbds75));
            layoutParams.setMargins(ii.g(this.a.getPageActivity(), R.dimen.tbds39), 0, 0, 0);
            this.h.setLayoutParams(layoutParams);
            linearLayout.addView(this.h);
            this.i = new View(this.a.getPageActivity());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ii.g(this.a.getPageActivity(), R.dimen.L_X01), ii.g(this.a.getPageActivity(), R.dimen.tbds69));
            layoutParams2.setMargins(ii.g(this.a.getPageActivity(), R.dimen.M_W_X004), 0, ii.g(this.a.getPageActivity(), R.dimen.M_W_X004), 0);
            this.i.setLayoutParams(layoutParams2);
            linearLayout.addView(this.i);
            EMTextView eMTextView = new EMTextView(this.a.getPageActivity());
            this.j = eMTextView;
            eMTextView.setText(R.string.obfuscated_res_0x7f0f03e1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(0, 0, ii.g(this.a.getPageActivity(), R.dimen.tbds55), 0);
            layoutParams3.weight = 1.0f;
            this.j.setLayoutParams(layoutParams3);
            linearLayout.addView(this.j);
            ImageView imageView = new ImageView(this.a.getPageActivity());
            this.k = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(ii.g(this.a.getPageActivity(), R.dimen.tbds42), ii.g(this.a.getPageActivity(), R.dimen.tbds42));
            layoutParams4.setMargins(0, 0, ii.g(this.a.getPageActivity(), R.dimen.M_W_X004), 0);
            this.k.setLayoutParams(layoutParams4);
            linearLayout.addView(this.k);
            this.k.setOnClickListener(new a(this));
            this.g.addView(linearLayout);
            return this.g;
        }
        return (View) invokeL.objValue;
    }
}
