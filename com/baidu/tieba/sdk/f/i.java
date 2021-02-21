package com.baidu.tieba.sdk.f;

import android.content.Context;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.tbadk.scheme.ILiveScheme;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import java.util.Map;
/* loaded from: classes11.dex */
public class i implements ILiveScheme {
    @Override // com.baidu.live.tbadk.scheme.ILiveScheme
    public void excute(Context context, Map<String, String> map, SchemeCallback schemeCallback) {
        try {
            com.baidu.tieba.sdk.a.dFx().y(TbadkCoreApplication.getInst(), EncryptionHelper.getDecryptUserId(map.get(TbEnum.SystemMessage.KEY_USER_ID)), map.get("certifyStatus"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
