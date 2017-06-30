package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.tieba.screenlocknotify.s;
import java.util.ArrayList;
import tbclient.GetMoreMsg.DataRes;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes2.dex */
public class a {
    private boolean mHasMore = true;
    private ArrayList<s> fwK = null;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.mHasMore = dataRes.has_more.intValue() == 1;
            if (dataRes.msg_content != null && dataRes.msg_content.size() > 0) {
                this.fwK = new ArrayList<>();
                for (MsgContent msgContent : dataRes.msg_content) {
                    this.fwK.add(new s(msgContent));
                }
            }
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public ArrayList<s> bfm() {
        return this.fwK;
    }
}
