package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbTopAgreePost;
import tbclient.Post;
/* loaded from: classes2.dex */
public class k {
    private boolean fBf;
    public String forum_top_list;
    public final List<PostData> fBd = new ArrayList();
    public final List<Long> fBe = new ArrayList();
    private int count = 0;

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void jT(boolean z) {
        this.fBf = z;
    }

    public void a(Context context, PbTopAgreePost pbTopAgreePost) {
        if (pbTopAgreePost.post_list != null && pbTopAgreePost.post_list.size() > 0) {
            for (Post post : pbTopAgreePost.post_list) {
                PostData postData = new PostData();
                postData.gWg = 102;
                postData.jT(this.fBf);
                postData.a(post, context);
                this.fBd.add(postData);
            }
        }
        if (!v.z(this.fBd)) {
            this.fBd.get(0).gWh = true;
            setCount(this.fBd.size());
        }
        List<Long> list = pbTopAgreePost.post_id_list;
        if (list != null && list.size() > 0) {
            for (Long l : pbTopAgreePost.post_id_list) {
                this.fBe.add(l);
            }
        }
        this.forum_top_list = pbTopAgreePost.forum_top_list;
    }
}
