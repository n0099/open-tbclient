package com.baidu.tieba.screenlocknotify.loadmore;

import com.baidu.tieba.screenlocknotify.e;
import java.util.ArrayList;
import tbclient.GetMoreMsg.DataRes;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes2.dex */
public class a {
    private boolean mHasMore = true;
    private ArrayList<e> fSf = null;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.mHasMore = dataRes.has_more.intValue() == 1;
            if (dataRes.msg_content != null && dataRes.msg_content.size() > 0) {
                this.fSf = new ArrayList<>();
                for (MsgContent msgContent : dataRes.msg_content) {
                    this.fSf.add(new e(msgContent));
                }
            }
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public ArrayList<e> bkC() {
        return this.fSf;
    }
}
