package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.LocalChannelTopicListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.write.view.LocalChannelTopicSelectView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ydb extends ieb<zeb> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public LocalChannelTopicSelectView g;
    @Nullable
    public String h;

    @Override // com.baidu.tieba.neb
    public void c(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.neb
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ydb(TbPageContext<?> tbPageContext) {
        super(tbPageContext, zeb.class);
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

    @Override // com.baidu.tieba.neb
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d054a, viewGroup, false);
            this.c = inflate;
            LocalChannelTopicSelectView localChannelTopicSelectView = (LocalChannelTopicSelectView) inflate.findViewById(R.id.obfuscated_res_0x7f092ad6);
            this.g = localChannelTopicSelectView;
            if (localChannelTopicSelectView != null) {
                localChannelTopicSelectView.setLocalChannelTopic(this.h);
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.neb
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
            writeData.setLocalChannelDynamic(true);
            writeData.setLocalChannelTopic(this.h);
        }
    }

    @Override // com.baidu.tieba.neb
    public void onChangeSkinType(int i) {
        LocalChannelTopicSelectView localChannelTopicSelectView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (localChannelTopicSelectView = this.g) != null) {
            localChannelTopicSelectView.b();
        }
    }

    @Override // com.baidu.tieba.ieb, com.baidu.tieba.neb
    public void h(@Nullable String str, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, str, writeData) != null) || StringUtils.isNull(str)) {
            return;
        }
        try {
            writeData.setLocalChannelTopic(new JSONObject(str).optString("t"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.ieb, com.baidu.tieba.neb
    public void m(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
            if (bundle != null) {
                this.h = bundle.getString(WriteActivityConfig.KEY_LOCAL_CHANNEL_TOPIC);
            } else if (intent != null) {
                this.h = intent.getStringExtra(WriteActivityConfig.KEY_LOCAL_CHANNEL_TOPIC);
            }
            if (StringUtils.isNull(this.h)) {
                this.h = writeData.getLocalChannelTopic();
            }
        }
    }

    @Override // com.baidu.tieba.ieb, com.baidu.tieba.neb
    public void onActivityResult(int i, int i2, Intent intent) {
        LocalChannelTopicSelectView localChannelTopicSelectView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 25068 && intent != null && (localChannelTopicSelectView = this.g) != null && localChannelTopicSelectView.getVisibility() == 0) {
                String stringExtra = intent.getStringExtra(LocalChannelTopicListActivityConfig.KEY_RESPONSE_TOPIC);
                this.h = stringExtra;
                this.g.setLocalChannelTopic(stringExtra);
            }
        }
    }
}
