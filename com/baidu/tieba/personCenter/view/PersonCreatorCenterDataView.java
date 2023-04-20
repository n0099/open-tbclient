package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ii;
import com.baidu.tieba.jt4;
import com.baidu.tieba.r25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PersonCreatorCenterDataView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public TextView c;
    public RoundLinearLayout d;
    public LinearLayout e;
    public ImageView f;
    public ImageView g;
    public TextView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCreatorCenterDataView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "https://tieba.baidu.com/mo/q/creativeData?source=videouser";
        this.b = "https://tieba.baidu.com/mo/q/creativeData";
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCreatorCenterDataView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "https://tieba.baidu.com/mo/q/creativeData?source=videouser";
        this.b = "https://tieba.baidu.com/mo/q/creativeData";
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCreatorCenterDataView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = "https://tieba.baidu.com/mo/q/creativeData?source=videouser";
        this.b = "https://tieba.baidu.com/mo/q/creativeData";
        b();
    }

    public final void d(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            TiebaStatic.log(new StatisticItem("c14149").param("obj_locate", str2));
            TiebaStatic.log(new StatisticItem("c14149").param("obj_type", str));
            TiebaStatic.log(new StatisticItem("c14149").param("obj_param1", str3));
            TiebaStatic.log(new StatisticItem("c14149").param("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
        }
    }

    public void a(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            this.c.setText(Integer.toString(i));
            this.h.setText(str);
            if (i2 == 0) {
                this.e.setVisibility(0);
                this.f.setVisibility(8);
                this.g.setVisibility(8);
            } else if (i2 > 0) {
                this.e.setVisibility(8);
                this.f.setVisibility(0);
                this.g.setVisibility(8);
            } else {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
                this.g.setVisibility(0);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d075f, (ViewGroup) this, true);
            inflate.setOnClickListener(this);
            this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091aa2);
            this.h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091aa4);
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091aaa);
            this.d = roundLinearLayout;
            roundLinearLayout.setRadius(ii.g(getContext(), R.dimen.obfuscated_res_0x7f070288));
            this.d.setRoundCount(8);
            r25.d(this.d).o(R.string.J_X03);
            this.e = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091aab);
            this.f = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091aac);
            this.g = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091aa5);
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            TbWebViewActivityConfig g = jt4.g(getContext(), "", str, true);
            g.setFixTitle(true);
            g.start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            String str = (String) ((PersonCreatorCenterDataView) view2).h.getText();
            if (getContext().getString(R.string.obfuscated_res_0x7f0f1742).equals(str)) {
                d("3", "1", "2");
                c(this.a);
            } else if (getContext().getString(R.string.obfuscated_res_0x7f0f1743).equals(str)) {
                d("3", "1", "3");
                c(this.a);
            } else if (getContext().getString(R.string.obfuscated_res_0x7f0f1741).equals(str)) {
                d("3", "1", "1");
                c(this.a);
            } else if (getContext().getString(R.string.obfuscated_res_0x7f0f1740).equals(str)) {
                d("3", "2", "2");
                c(this.b);
            } else if (getContext().getString(R.string.obfuscated_res_0x7f0f173f).equals(str)) {
                d("3", "2", "3");
                c(this.b);
            } else if (getContext().getString(R.string.obfuscated_res_0x7f0f173e).equals(str)) {
                d("3", "2", "1");
                c(this.b);
            }
        }
    }
}
