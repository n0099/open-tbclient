package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbTopAgreePost;
import tbclient.Post;
/* loaded from: classes.dex */
public class m {
    public List<PostData> edU = new ArrayList();
    public List<Long> edV = new ArrayList();
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
                postData.fuS = SapiSafeFacade.SAPIWEBVIEW_BACK;
                postData.a(post, context);
                this.edU.add(postData);
            }
        }
        if (!x.r(this.edU)) {
            this.edU.get(0).fuT = true;
            setCount(this.edU.size());
        }
        List<Long> list = pbTopAgreePost.post_id_list;
        if (list != null && list.size() > 0) {
            for (Long l : pbTopAgreePost.post_id_list) {
                this.edV.add(l);
            }
        }
    }
}
