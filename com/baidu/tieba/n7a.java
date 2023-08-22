package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class n7a extends k7a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n7a(Context context) {
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
    }

    @Override // com.baidu.tieba.q7a
    public void a(ShareEntity shareEntity, r7a r7aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, shareEntity, r7aVar) == null) {
            if (shareEntity != null && !TextUtils.isEmpty(shareEntity.getContent())) {
                if (TextUtils.isEmpty(shareEntity.getContent())) {
                    str = shareEntity.getTitle() + shareEntity.getLinkUrl();
                } else {
                    str = shareEntity.getContent() + shareEntity.getLinkUrl();
                }
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", str);
                intent.setType("text/plain");
                Context context = this.b;
                if (t7a.startActivity(context, Intent.createChooser(intent, context.getString(R.string.obfuscated_res_0x7f0f13c3)))) {
                    if (r7aVar != null) {
                        r7aVar.X0(0, 1);
                        return;
                    }
                    return;
                } else if (r7aVar != null) {
                    r7aVar.X0(0, 2);
                    return;
                } else {
                    return;
                }
            }
            BdUtilHelper.showToast(d(), (int) R.string.obfuscated_res_0x7f0f1392);
            if (r7aVar != null) {
                r7aVar.X0(0, 2);
            }
        }
    }
}
