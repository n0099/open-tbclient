package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBgByCategory.GetBgByCategoryResIdl;
import tbclient.GetBgByCategory.ThemeBgInMain;
/* loaded from: classes9.dex */
public class BackgroundGroupHttpResponseMessage extends TbHttpResponsedMessage {
    private List<b> mBackgroundGroupList;
    private com.baidu.tieba.themeCenter.dressCenter.e mRecommand;

    public BackgroundGroupHttpResponseMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetBgByCategoryResIdl getBgByCategoryResIdl = (GetBgByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBgByCategoryResIdl.class);
        if (getBgByCategoryResIdl != null) {
            if (getBgByCategoryResIdl.error != null) {
                setError(getBgByCategoryResIdl.error.errorno.intValue());
                setErrorString(getBgByCategoryResIdl.error.usermsg);
            }
            if (getBgByCategoryResIdl.data != null) {
                if (getBgByCategoryResIdl.data.recommend != null) {
                    this.mRecommand = new com.baidu.tieba.themeCenter.dressCenter.e();
                    this.mRecommand.a(getBgByCategoryResIdl.data.recommend);
                }
                if (getBgByCategoryResIdl.data.bgs != null) {
                    this.mBackgroundGroupList = new ArrayList();
                    for (ThemeBgInMain themeBgInMain : getBgByCategoryResIdl.data.bgs) {
                        if (themeBgInMain != null && !StringUtils.isNull(themeBgInMain.bg_category)) {
                            b bVar = new b();
                            bVar.a(themeBgInMain);
                            this.mBackgroundGroupList.add(bVar);
                        }
                    }
                }
            }
        }
    }

    public com.baidu.tieba.themeCenter.dressCenter.e getRecommand() {
        return this.mRecommand;
    }

    public List<b> getGroupList() {
        return this.mBackgroundGroupList;
    }
}
