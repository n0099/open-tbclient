package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.rd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
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
        h(0, 0, BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f070201), 0);
    }

    public void i() {
        boolean z;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z2 = false;
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            VersionData versionData = TbadkCoreApplication.getInst().getVersionData();
            if (versionData != null && versionData.hasNewVer()) {
                z2 = true;
            }
            if (z2) {
                this.e.setText("new");
                TextView textView = this.e;
                Context context = this.a;
                if (z) {
                    i2 = R.style.obfuscated_res_0x7f10041e;
                } else {
                    i2 = R.style.obfuscated_res_0x7f10041d;
                }
                textView.setTextAppearance(context, i2);
                SkinManager.setBackgroundResource(this.e, R.drawable.icon_news_text_prompt);
                return;
            }
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !rd.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            this.e.setText(version);
            this.e.setBackgroundDrawable(null);
            TextView textView2 = this.e;
            Context context2 = this.a;
            if (z) {
                i = R.style.obfuscated_res_0x7f100420;
            } else {
                i = R.style.obfuscated_res_0x7f10041f;
            }
            textView2.setTextAppearance(context2, i);
        }
    }
}
