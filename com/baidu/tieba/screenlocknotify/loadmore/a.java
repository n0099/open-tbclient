package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.tieba.screenlocknotify.d;
import java.util.ArrayList;
import tbclient.GetMoreMsg.DataRes;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes8.dex */
public class a {
    private boolean mHasMore = true;
    private ArrayList<d> kSD = null;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.mHasMore = dataRes.has_more.intValue() == 1;
            if (dataRes.msg_content != null && dataRes.msg_content.size() > 0) {
                this.kSD = new ArrayList<>();
                for (MsgContent msgContent : dataRes.msg_content) {
                    this.kSD.add(new d(msgContent));
                }
            }
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public ArrayList<d> cWd() {
        return this.kSD;
    }
}
