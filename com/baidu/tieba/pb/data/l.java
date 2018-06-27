package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbTopAgreePost;
import tbclient.Post;
/* loaded from: classes2.dex */
public class l {
    public String forum_top_list;
    private boolean fts;
    public final List<PostData> ftq = new ArrayList();
    public final List<Long> ftr = new ArrayList();
    private int count = 0;

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void jG(boolean z) {
        this.fts = z;
    }

    public void a(Context context, PbTopAgreePost pbTopAgreePost) {
        if (pbTopAgreePost.post_list != null && pbTopAgreePost.post_list.size() > 0) {
            for (Post post : pbTopAgreePost.post_list) {
                PostData postData = new PostData();
                postData.gNC = 102;
                postData.jG(this.fts);
                postData.a(post, context);
                this.ftq.add(postData);
            }
        }
        if (!w.A(this.ftq)) {
            this.ftq.get(0).gND = true;
            setCount(this.ftq.size());
        }
        List<Long> list = pbTopAgreePost.post_id_list;
        if (list != null && list.size() > 0) {
            for (Long l : pbTopAgreePost.post_id_list) {
                this.ftr.add(l);
            }
        }
        this.forum_top_list = pbTopAgreePost.forum_top_list;
    }
}
