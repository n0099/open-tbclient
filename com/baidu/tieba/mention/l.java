package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tieba.data.FeedData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    private FeedData bnq;
    private Context mContext;
    private int mType;

    public l(Context context, int i) {
        this.mContext = context;
        this.mType = i;
    }

    public void c(FeedData feedData) {
        this.bnq = feedData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bnq != null) {
            if (FeedData.TYPE_ZAN.equals(this.bnq.getPraiseItemType())) {
                List<com.baidu.tieba.data.x> praiseList = this.bnq.getPraiseList();
                if (praiseList != null && praiseList.size() > 0) {
                    com.baidu.tieba.data.x xVar = praiseList.get(0);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mContext, xVar.getId(), xVar.zv(), xVar.getPortrait(), this.bnq.getFname(), false, AddFriendActivityConfig.TYPE_REPLY_ME)));
                }
            } else if (this.mType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mContext, this.bnq.getReplyer().getUserId(), this.bnq.getReplyer().getName_show(), this.bnq.getReplyer().getPortrait(), this.bnq.getFname(), false, AddFriendActivityConfig.TYPE_REPLY_ME)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this.mContext, this.bnq.getReplyer().getUserId(), this.bnq.getReplyer().getName_show(), this.bnq.getReplyer().getPortrait(), this.bnq.getFname(), false, AddFriendActivityConfig.TYPE_AT_ME)));
            }
        }
    }
}
