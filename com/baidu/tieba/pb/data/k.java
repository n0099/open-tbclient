package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbTopAgreePost;
import tbclient.Post;
/* loaded from: classes6.dex */
public class k {
    private boolean fQW;
    public String forum_top_list;
    public final List<PostData> fQU = new ArrayList();
    public final List<Long> fQV = new ArrayList();
    private int count = 0;

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void kx(boolean z) {
        this.fQW = z;
    }

    public void a(Context context, PbTopAgreePost pbTopAgreePost) {
        if (pbTopAgreePost.post_list != null && pbTopAgreePost.post_list.size() > 0) {
            for (Post post : pbTopAgreePost.post_list) {
                PostData postData = new PostData();
                postData.hlT = 102;
                postData.kx(this.fQW);
                postData.a(post, context);
                this.fQU.add(postData);
            }
        }
        if (!v.I(this.fQU)) {
            this.fQU.get(0).hlU = true;
            setCount(this.fQU.size());
        }
        List<Long> list = pbTopAgreePost.post_id_list;
        if (list != null && list.size() > 0) {
            for (Long l : pbTopAgreePost.post_id_list) {
                this.fQV.add(l);
            }
        }
        this.forum_top_list = pbTopAgreePost.forum_top_list;
    }
}
