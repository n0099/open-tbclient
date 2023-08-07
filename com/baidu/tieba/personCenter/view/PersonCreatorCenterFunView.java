package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class PersonCreatorCenterFunView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TextView b;
    public String c;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCreatorCenterFunView(Context context) {
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
        this.c = "https://tieba.baidu.com/mo/q/creativeData?source=videouser";
        this.d = "https://tieba.baidu.com/mo/q/creativeData";
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
        this.c = "https://tieba.baidu.com/mo/q/creativeData?source=videouser";
        this.d = "https://tieba.baidu.com/mo/q/creativeData";
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
        this.c = "https://tieba.baidu.com/mo/q/creativeData?source=videouser";
        this.d = "https://tieba.baidu.com/mo/q/creativeData";
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
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07d6, (ViewGroup) this, true);
            inflate.setOnClickListener(this);
            this.a = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091bc0);
            this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091bc2);
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            TbWebViewActivityConfig activityConfig = BrowserHelper.getActivityConfig(getContext(), "", str, true);
            activityConfig.setFixTitle(true);
            activityConfig.start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            String charSequence = ((PersonCreatorCenterFunView) view2).b.getText().toString();
            if (view2.getId() == R.id.obfuscated_res_0x7f091bca) {
                TiebaStatic.log(new StatisticItem("c14149").param("obj_locate", "1"));
                TiebaStatic.log(new StatisticItem("c14149").param("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(TbadkCoreApplication.getInst().getApplicationContext(), "CreateCenterPage", new HashMap())));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091bcb) {
                d("1", "1", "");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(TbadkCoreApplication.getInst().getApplicationContext(), "VideoWorkListPage", new HashMap())));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091bc9) {
                d("2", "1", "");
                c(this.c);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091bc8) {
                if (getContext().getString(R.string.tieba_string_god_guide).equals(charSequence)) {
                    d("1", "2", "");
                    c(TbConfig.URL_GOD_AUTH + SkinManager.getCurrentSkinTypeString());
                    new StatisticItem("c15050").param("uid", TbadkCoreApplication.getCurrentAccountId()).eventStat();
                    return;
                }
                d("1", "2", "");
                c(TbConfig.URL_GOD_EXAMINE + SkinManager.getCurrentSkinTypeString());
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091bcc) {
                d("2", "2", "");
                c(this.d);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091bd0 || view2.getId() == R.id.obfuscated_res_0x7f091bce || view2.getId() == R.id.obfuscated_res_0x7f091bc7 || view2.getId() == R.id.obfuscated_res_0x7f091bcd) {
                WorkPublishGuideActivityConfig workPublishGuideActivityConfig = new WorkPublishGuideActivityConfig(getContext());
                workPublishGuideActivityConfig.setRequestCode(25064);
                workPublishGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishGuideActivityConfig));
            }
        }
    }
}
