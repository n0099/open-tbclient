package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
        h(0, 0, l.g(context, R.dimen.ds30), 0);
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
                this.j.setText("new");
                this.j.setTextAppearance(this.f12966e, z2 ? R.style.setting_version_prompt_text_1 : R.style.setting_version_prompt_text);
                SkinManager.setBackgroundResource(this.j, R.drawable.icon_news_text_prompt);
                return;
            }
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !k.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            this.j.setText(version);
            this.j.setBackgroundDrawable(null);
            this.j.setTextAppearance(this.f12966e, z2 ? R.style.setting_version_text_1 : R.style.setting_version_text);
        }
    }
}
