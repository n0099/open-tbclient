package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetSkinList.GetSkinListResIdl;
import tbclient.ThemeSkinPropMain;
/* loaded from: classes.dex */
public class AllThemeListHttpResponsedMessage extends TbHttpResponsedMessage {
    private boolean hasMore;
    private k mRecommand;
    private List<com.baidu.tieba.themeCenter.b> mThemeList;

    public AllThemeListHttpResponsedMessage(int i) {
        super(i);
        this.hasMore = true;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        GetSkinListResIdl getSkinListResIdl = (GetSkinListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSkinListResIdl.class);
        if (getSkinListResIdl != null) {
            if (getSkinListResIdl.error != null) {
                setError(getSkinListResIdl.error.errorno.intValue());
                setErrorString(getSkinListResIdl.error.usermsg);
            }
            if (getSkinListResIdl.data != null) {
                if (getSkinListResIdl.data.hasmore.intValue() == 1) {
                    this.hasMore = true;
                } else {
                    this.hasMore = false;
                }
                if (getSkinListResIdl.data.recommend != null) {
                    this.mRecommand = new k();
                    this.mRecommand.a(getSkinListResIdl.data.recommend);
                }
                if (getSkinListResIdl.data.skins != null && getSkinListResIdl.data.skins.size() > 0) {
                    this.mThemeList = new ArrayList();
                    for (ThemeSkinPropMain themeSkinPropMain : getSkinListResIdl.data.skins) {
                        if (themeSkinPropMain != null && !StringUtils.isNull(themeSkinPropMain.title)) {
                            com.baidu.tieba.themeCenter.b bVar = new com.baidu.tieba.themeCenter.b();
                            bVar.a(themeSkinPropMain);
                            this.mThemeList.add(bVar);
                        }
                    }
                }
            }
        }
    }

    public k getRecommand() {
        return this.mRecommand;
    }

    public List<com.baidu.tieba.themeCenter.b> getThemeList() {
        return this.mThemeList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }
}
