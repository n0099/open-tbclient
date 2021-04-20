package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.j3.d.a;
import d.b.i0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetPendantByCategory.DataRes;
import tbclient.GetPendantByCategory.GetPendantByCategoryResIdl;
import tbclient.GetPendantByCategory.ThemePendantInMain;
/* loaded from: classes5.dex */
public class AvatarPendantListHttpResponseMessage extends TbHttpResponsedMessage {
    public List<a> mAvatarPendantList;
    public e mRecommand;

    public AvatarPendantListHttpResponseMessage(int i) {
        super(i);
    }

    public List<a> getAvatarPendantListList() {
        return this.mAvatarPendantList;
    }

    public e getRecommand() {
        return this.mRecommand;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
