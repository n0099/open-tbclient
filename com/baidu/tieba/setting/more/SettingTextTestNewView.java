package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.qi;
import com.baidu.tieba.ri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class SettingTextTestNewView extends TbSettingTextTipView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
        h(0, 0, ri.f(context, R.dimen.obfuscated_res_0x7f070201), 0);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = false;
            boolean z2 = TbadkCoreApplication.getInst().getSkinType() == 1;
            VersionData versionData = TbadkCoreApplication.getInst().getVersionData();
            if (versionData != null && versionData.hasNewVer()) {
                z = true;
            }
            if (z) {
                this.e.setText("new");
                this.e.setTextAppearance(this.a, z2 ? R.style.obfuscated_res_0x7f1003f3 : R.style.obfuscated_res_0x7f1003f2);
                SkinManager.setBackgroundResource(this.e, R.drawable.icon_news_text_prompt);
                return;
            }
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !qi.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            this.e.setText(version);
            this.e.setBackgroundDrawable(null);
            this.e.setTextAppearance(this.a, z2 ? R.style.obfuscated_res_0x7f1003f5 : R.style.obfuscated_res_0x7f1003f4);
        }
    }
}
