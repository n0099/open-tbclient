package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonCreatorCenterFunView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final String c;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TextView b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(764866608, "Lcom/baidu/tieba/personCenter/view/PersonCreatorCenterFunView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(764866608, "Lcom/baidu/tieba/personCenter/view/PersonCreatorCenterFunView;");
                return;
            }
        }
        c = TbConfig.TIEBA_ADDRESS + "mo/q/wise-creative-core/creative-work?customfullscreen=1&nonavigationbar=1";
        d = TbConfig.TIEBA_ADDRESS + "mo/q/creativeData?nomenu=1&noclose=1";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCreatorCenterFunView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCreatorCenterFunView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCreatorCenterFunView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        b();
    }

    public final void e(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            TiebaStatic.log(new StatisticItem("c14149").param("obj_locate", str2));
            TiebaStatic.log(new StatisticItem("c14149").param("obj_type", str));
            TiebaStatic.log(new StatisticItem("c14149").param("obj_param1", str3));
            TiebaStatic.log(new StatisticItem("c14149").param("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
        }
    }

    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            this.a.setImageResource(i);
            this.b.setText(str);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0811, (ViewGroup) this, true);
            inflate.setOnClickListener(this);
            this.a = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e38);
            this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090e39);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TiebaStatic.log(new StatisticItem("c14149").param("obj_locate", "1"));
            TiebaStatic.log(new StatisticItem("c14149").param("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            UrlManager.getInstance().dealOneLink(c);
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            UrlManager.getInstance().dealOneLink(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            PersonCreatorCenterFunView personCreatorCenterFunView = (PersonCreatorCenterFunView) view2;
            if (view2.getId() == R.id.obfuscated_res_0x7f090e37) {
                c();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090e34) {
                e("2", "2", "");
                d(d);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090e35) {
                if (getContext().getString(R.string.tieba_string_god_guide).equals(personCreatorCenterFunView.b.getText().toString())) {
                    e("1", "2", "");
                    d(TbConfig.URL_GOD_AUTH + SkinManager.getCurrentSkinTypeString());
                    new StatisticItem("c15050").param("uid", TbadkCoreApplication.getCurrentAccountId()).eventStat();
                    return;
                }
                e("1", "2", "");
                d(TbConfig.URL_GOD_EXAMINE + SkinManager.getCurrentSkinTypeString());
            }
        }
    }
}
