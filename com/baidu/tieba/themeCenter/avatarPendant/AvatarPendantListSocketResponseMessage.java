package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.squareup.wire.Wire;
import d.a.k0.j3.d.a;
import d.a.k0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetPendantByCategory.DataRes;
import tbclient.GetPendantByCategory.GetPendantByCategoryResIdl;
import tbclient.GetPendantByCategory.ThemePendantInMain;
/* loaded from: classes5.dex */
public class AvatarPendantListSocketResponseMessage extends SocketResponsedMessage {
    public List<a> mAvatarPendantList;
    public e mRecommand;

    public AvatarPendantListSocketResponseMessage() {
        super(309371);
    }

    public List<a> getAvatarPendantListList() {
        return this.mAvatarPendantList;
    }

    public e getRecommand() {
        return this.mRecommand;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetPendantByCategoryResIdl getPendantByCategoryResIdl = (GetPendantByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPendantByCategoryResIdl.class);
        if (getPendantByCategoryResIdl == null) {
            return;
        }
        Error error = getPendantByCategoryResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getPendantByCategoryResIdl.error.usermsg);
        }
        DataRes dataRes = getPendantByCategoryResIdl.data;
        if (dataRes == null) {
            return;
        }
        if (dataRes.recommend != null) {
            e eVar = new e();
            this.mRecommand = eVar;
            eVar.d(getPendantByCategoryResIdl.data.recommend);
        }
        if (getPendantByCategoryResIdl.data.pendant != null) {
            this.mAvatarPendantList = new ArrayList();
            for (ThemePendantInMain themePendantInMain : getPendantByCategoryResIdl.data.pendant) {
                if (themePendantInMain != null && !StringUtils.isNull(themePendantInMain.pendant_category)) {
                    a aVar = new a();
                    aVar.c(themePendantInMain);
                    this.mAvatarPendantList.add(aVar);
                }
            }
        }
    }
}
