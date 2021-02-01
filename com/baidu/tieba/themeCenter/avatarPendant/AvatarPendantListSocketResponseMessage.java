package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.themeCenter.dressCenter.e;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetPendantByCategory.GetPendantByCategoryResIdl;
import tbclient.GetPendantByCategory.ThemePendantInMain;
/* loaded from: classes9.dex */
public class AvatarPendantListSocketResponseMessage extends SocketResponsedMessage {
    private List<a> mAvatarPendantList;
    private e mRecommand;

    public AvatarPendantListSocketResponseMessage() {
        super(CmdConfigSocket.CMD_AVATAR_APENDANT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetPendantByCategoryResIdl getPendantByCategoryResIdl = (GetPendantByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPendantByCategoryResIdl.class);
        if (getPendantByCategoryResIdl != null) {
            if (getPendantByCategoryResIdl.error != null) {
                setError(getPendantByCategoryResIdl.error.errorno.intValue());
                setErrorString(getPendantByCategoryResIdl.error.usermsg);
            }
            if (getPendantByCategoryResIdl.data != null) {
                if (getPendantByCategoryResIdl.data.recommend != null) {
                    this.mRecommand = new e();
                    this.mRecommand.a(getPendantByCategoryResIdl.data.recommend);
                }
                if (getPendantByCategoryResIdl.data.pendant != null) {
                    this.mAvatarPendantList = new ArrayList();
                    for (ThemePendantInMain themePendantInMain : getPendantByCategoryResIdl.data.pendant) {
                        if (themePendantInMain != null && !StringUtils.isNull(themePendantInMain.pendant_category)) {
                            a aVar = new a();
                            aVar.a(themePendantInMain);
                            this.mAvatarPendantList.add(aVar);
                        }
                    }
                }
            }
        }
    }

    public e getRecommand() {
        return this.mRecommand;
    }

    public List<a> getAvatarPendantListList() {
        return this.mAvatarPendantList;
    }
}
