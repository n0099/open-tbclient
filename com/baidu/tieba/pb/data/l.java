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
    private boolean ftw;
    public final List<PostData> ftu = new ArrayList();
    public final List<Long> ftv = new ArrayList();
    private int count = 0;

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void js(boolean z) {
        this.ftw = z;
    }

    public void a(Context context, PbTopAgreePost pbTopAgreePost) {
        if (pbTopAgreePost.post_list != null && pbTopAgreePost.post_list.size() > 0) {
            for (Post post : pbTopAgreePost.post_list) {
                PostData postData = new PostData();
                postData.gOC = 102;
                postData.js(this.ftw);
                postData.a(post, context);
                this.ftu.add(postData);
            }
        }
        if (!w.z(this.ftu)) {
            this.ftu.get(0).gOD = true;
            setCount(this.ftu.size());
        }
        List<Long> list = pbTopAgreePost.post_id_list;
        if (list != null && list.size() > 0) {
            for (Long l : pbTopAgreePost.post_id_list) {
                this.ftv.add(l);
            }
        }
        this.forum_top_list = pbTopAgreePost.forum_top_list;
    }
}
