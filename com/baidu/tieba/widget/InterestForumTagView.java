package com.baidu.tieba.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.rs;
import com.baidu.tieba.view.SymbolEMTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class InterestForumTagView extends LinearLayout implements rs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public SymbolEMTextView b;
    public ImageView c;
    public SelectForumData d;

    /* loaded from: classes8.dex */
    public interface b {
        void a(SelectForumData selectForumData);
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;
        public final /* synthetic */ InterestForumTagView b;

        public a(InterestForumTagView interestForumTagView, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestForumTagView, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = interestForumTagView;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (bVar = this.a) != null) {
                bVar.a(this.b.d);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InterestForumTagView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void b(SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) && selectForumData != null && getContext() != null) {
            this.d = selectForumData;
            SymbolEMTextView symbolEMTextView = this.b;
            if (symbolEMTextView != null) {
                symbolEMTextView.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0ac7, selectForumData.forumName));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InterestForumTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.rs
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            SymbolEMTextView symbolEMTextView = this.b;
            if (symbolEMTextView != null) {
                EMManager.from(symbolEMTextView).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0107).setTextLinePadding(R.dimen.tbds0).setTextStyle(R.string.F_X01);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_close22, R.color.CAM_X0108, WebPManager.ResourceStateType.NORMAL);
            }
            EMManager.from(this).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0202);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterestForumTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004) + BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X013);
        c();
    }

    public void d(float f) {
        SymbolEMTextView symbolEMTextView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) && (symbolEMTextView = this.b) != null) {
            symbolEMTextView.setMaxWidth((int) (f - this.a));
        }
    }

    public void setCloseListener(b bVar) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) && (imageView = this.c) != null) {
            imageView.setOnClickListener(new a(this, bVar));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004);
            int dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X002);
            setPadding(dimens, dimens2, 0, dimens2);
            setOrientation(0);
            setGravity(16);
            SymbolEMTextView symbolEMTextView = new SymbolEMTextView(getContext());
            this.b = symbolEMTextView;
            symbolEMTextView.setMaxLines(1);
            this.b.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int dimens3 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds5);
            layoutParams.setMargins(0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds3), dimens3, 0);
            addView(this.b, layoutParams);
            this.c = new ImageView(getContext());
            int dimens4 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds42);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimens4, dimens4);
            layoutParams2.setMargins(0, 0, dimens3 * 3, 0);
            addView(this.c, layoutParams2);
            setClickable(true);
        }
    }

    public int getInitialMeasuredWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.a;
            SymbolEMTextView symbolEMTextView = this.b;
            if (symbolEMTextView != null) {
                return i + BdUtilHelper.measureText(symbolEMTextView.getPaint(), this.b.getText().toString()).right;
            }
            return i;
        }
        return invokeV.intValue;
    }
}
