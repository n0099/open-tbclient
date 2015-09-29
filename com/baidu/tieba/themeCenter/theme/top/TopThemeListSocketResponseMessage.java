package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetSkinByCategory.GetSkinByCategoryResIdl;
import tbclient.GetSkinByCategory.ThemeSkinInMain;
/* loaded from: classes.dex */
public class TopThemeListSocketResponseMessage extends SocketResponsedMessage {
    private k mRecommand;
    private List<a> mThemeList;

    public TopThemeListSocketResponseMessage() {
        super(309010);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        GetSkinByCategoryResIdl getSkinByCategoryResIdl = (GetSkinByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSkinByCategoryResIdl.class);
        if (getSkinByCategoryResIdl != null) {
            if (getSkinByCategoryResIdl.error != null) {
                setError(getSkinByCategoryResIdl.error.errorno.intValue());
                setErrorString(getSkinByCategoryResIdl.error.usermsg);
            }
            if (getSkinByCategoryResIdl.data != null) {
                if (getSkinByCategoryResIdl.data.recommend != null) {
                    this.mRecommand = new k();
                    this.mRecommand.a(getSkinByCategoryResIdl.data.recommend);
                }
                if (getSkinByCategoryResIdl.data.skins != null && getSkinByCategoryResIdl.data.skins.size() > 0) {
                    this.mThemeList = new ArrayList();
                    for (ThemeSkinInMain themeSkinInMain : getSkinByCategoryResIdl.data.skins) {
                        if (themeSkinInMain != null && themeSkinInMain.props != null && themeSkinInMain.props.size() > 0) {
                            a aVar = new a();
                            aVar.a(themeSkinInMain);
                            this.mThemeList.add(aVar);
                        }
                    }
                }
            }
        }
    }

    public k getRecommand() {
        return this.mRecommand;
    }

    public List<a> getThemeList() {
        return this.mThemeList;
    }
}
