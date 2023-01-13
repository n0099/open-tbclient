package com.baidu.tieba;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class l08 extends ln<b18, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public TextView b;
        public View c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view2, TextView textView, View view3) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, textView, view3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
            this.b = textView;
            this.c = view3;
        }

        public void a(b18 b18Var) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, b18Var) == null) && b18Var != null) {
                this.b.setText(b18Var.a);
                View view2 = this.c;
                if (b18Var.b) {
                    i = 0;
                } else {
                    i = 8;
                }
                view2.setVisibility(i);
            }
        }

        public void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && this.a != i) {
                SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0204);
                this.a = i;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l08(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), z08.b);
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
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: s */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
            linearLayout.setOrientation(1);
            linearLayout.setPadding(zi.g(viewGroup.getContext(), R.dimen.tbds44), 0, zi.g(viewGroup.getContext(), R.dimen.tbds44), zi.g(viewGroup.getContext(), R.dimen.tbds12));
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            View view2 = new View(viewGroup.getContext());
            linearLayout.addView(view2, new LinearLayout.LayoutParams(-1, zi.g(viewGroup.getContext(), R.dimen.tbds1)));
            TextView textView = new TextView(viewGroup.getContext());
            textView.setTextColor(viewGroup.getContext().getResources().getColor(R.color.CAM_X0105));
            textView.setTextSize(0, zi.g(viewGroup.getContext(), R.dimen.tbds47));
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setIncludeFontPadding(false);
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(0, zi.g(viewGroup.getContext(), R.dimen.tbds48), 0, 0);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            a aVar = new a(linearLayout, textView, view2);
            aVar.b(TbadkCoreApplication.getInst().getSkinType());
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, b18 b18Var, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, b18Var, aVar})) == null) {
            if (b18Var != null && aVar != null) {
                aVar.a(b18Var);
                aVar.b(TbadkCoreApplication.getInst().getSkinType());
                return aVar.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
