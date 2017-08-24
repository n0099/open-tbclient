package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.tieba.screenlocknotify.e;
import java.util.ArrayList;
import tbclient.GetMoreMsg.DataRes;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes2.dex */
public class a {
    private boolean mHasMore = true;
    private ArrayList<e> fNb = null;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.mHasMore = dataRes.has_more.intValue() == 1;
            if (dataRes.msg_content != null && dataRes.msg_content.size() > 0) {
                this.fNb = new ArrayList<>();
                for (MsgContent msgContent : dataRes.msg_content) {
                    this.fNb.add(new e(msgContent));
                }
            }
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public ArrayList<e> bjy() {
        return this.fNb;
    }
}
