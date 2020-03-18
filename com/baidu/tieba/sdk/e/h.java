package com.baidu.tieba.sdk.e;

import android.content.Context;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.tbadk.scheme.ILiveScheme;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import java.util.Map;
/* loaded from: classes3.dex */
public class h implements ILiveScheme {
    @Override // com.baidu.live.tbadk.scheme.ILiveScheme
    public void excute(Context context, Map<String, String> map, SchemeCallback schemeCallback) {
        try {
            com.baidu.tieba.sdk.a.cED().bj(TbadkCoreApplication.getInst(), EncryptionHelper.getDecryptUserId(map.get(TbEnum.SystemMessage.KEY_USER_ID)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
