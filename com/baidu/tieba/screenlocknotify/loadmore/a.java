package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.tieba.screenlocknotify.s;
import java.util.ArrayList;
import tbclient.GetMoreMsg.DataRes;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes.dex */
public class a {
    private boolean mHasMore = true;
    private ArrayList<s> fiJ = null;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.mHasMore = dataRes.has_more.intValue() == 1;
            if (dataRes.msg_content != null && dataRes.msg_content.size() > 0) {
                this.fiJ = new ArrayList<>();
                for (MsgContent msgContent : dataRes.msg_content) {
                    this.fiJ.add(new s(msgContent));
                }
            }
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public ArrayList<s> bce() {
        return this.fiJ;
    }
}
