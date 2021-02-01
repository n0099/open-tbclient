package com.baidu.tieba.themeCenter.bubble.group;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.themeCenter.dressCenter.e;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBubbleByCategory.GetBubbleByCategoryResIdl;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
/* loaded from: classes9.dex */
public class BubbleGroupSocketResponseMessage extends SocketResponsedMessage {
    private List<b> mBubbleGroupList;
    private e mRecommand;

    public BubbleGroupSocketResponseMessage() {
        super(CmdConfigSocket.CMD_BUBBLE_CATEGORY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetBubbleByCategoryResIdl getBubbleByCategoryResIdl = (GetBubbleByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBubbleByCategoryResIdl.class);
        if (getBubbleByCategoryResIdl != null) {
            if (getBubbleByCategoryResIdl.error != null) {
                setError(getBubbleByCategoryResIdl.error.errorno.intValue());
                setErrorString(getBubbleByCategoryResIdl.error.usermsg);
            }
            if (getBubbleByCategoryResIdl.data != null) {
                if (getBubbleByCategoryResIdl.data.recommend != null) {
                    this.mRecommand = new e();
                    this.mRecommand.a(getBubbleByCategoryResIdl.data.recommend);
                }
                if (getBubbleByCategoryResIdl.data.bubbles != null) {
                    this.mBubbleGroupList = new ArrayList();
                    for (ThemeBubbleInMain themeBubbleInMain : getBubbleByCategoryResIdl.data.bubbles) {
                        if (themeBubbleInMain != null && !StringUtils.isNull(themeBubbleInMain.bubble_category)) {
                            b bVar = new b();
                            bVar.a(themeBubbleInMain);
                            this.mBubbleGroupList.add(bVar);
                        }
                    }
                }
            }
        }
    }

    public e getRecommand() {
        return this.mRecommand;
    }

    public List<b> getGroupList() {
        return this.mBubbleGroupList;
    }
}
