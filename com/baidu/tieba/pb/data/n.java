package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbTopAgreePost;
import tbclient.Post;
/* loaded from: classes.dex */
public class n {
    public String forum_top_list;
    public final List<PostData> eHD = new ArrayList();
    public final List<Long> eHE = new ArrayList();
    private int count = 0;

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void a(Context context, PbTopAgreePost pbTopAgreePost) {
        if (pbTopAgreePost.post_list != null && pbTopAgreePost.post_list.size() > 0) {
            for (Post post : pbTopAgreePost.post_list) {
                PostData postData = new PostData();
                postData.gqU = SapiSafeFacade.SAPIWEBVIEW_BACK;
                postData.a(post, context);
                this.eHD.add(postData);
            }
        }
        if (!v.v(this.eHD)) {
            this.eHD.get(0).gqV = true;
            setCount(this.eHD.size());
        }
        List<Long> list = pbTopAgreePost.post_id_list;
        if (list != null && list.size() > 0) {
            for (Long l : pbTopAgreePost.post_id_list) {
                this.eHE.add(l);
            }
        }
        this.forum_top_list = pbTopAgreePost.forum_top_list;
    }
}
