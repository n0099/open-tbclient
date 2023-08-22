package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dz4;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Service
/* loaded from: classes9.dex */
public class zx7 implements dz4.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.dz4.d
    @NonNull
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "personCenter.sendGif" : (String) invokeV.objValue;
    }

    public zx7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.dz4.c
    public void a(@NonNull String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("picId");
                String optString2 = jSONObject.optString("url");
                String optString3 = jSONObject.optString("uid");
                int optInt = jSONObject.optInt("width");
                int optInt2 = jSONObject.optInt("height");
                String optString4 = jSONObject.optString("toUserName");
                String optString5 = jSONObject.optString("toUserNameShow");
                String optString6 = jSONObject.optString("toUserPortrait");
                int optInt3 = jSONObject.optInt("isFriend");
                if (!TextUtils.equals(optString3, TbadkCoreApplication.getCurrentAccount()) && !TextUtils.equals(optString6, TbadkCoreApplication.getCurrentPortrait())) {
                    long j = JavaTypesHelper.toLong(optString3, 0L);
                    if (optInt3 == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    MessageUtils.createAndSendPersonalReactionsPicChatMessage(optString, optString2, optInt, optInt2, j, optString4, optString5, optString6, z);
                }
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("SendGifHybridNotify", "发送私聊图片消息失败，uid或头像不一致" + optString3 + " " + TbadkCoreApplication.getCurrentAccount() + " " + optString6 + " " + TbadkCoreApplication.getCurrentPortrait());
            } catch (Exception e) {
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.i("SendGifHybridNotify", "发送私聊图片消息失败" + e);
            }
        }
    }
}
