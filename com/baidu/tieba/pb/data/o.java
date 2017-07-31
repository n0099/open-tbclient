package com.baidu.tieba.pb.data;

import android.content.Context;
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbTopAgreePost;
import tbclient.Post;
/* loaded from: classes.dex */
public class o {
    public List<PostData> eEO = new ArrayList();
    public List<Long> eEP = new ArrayList();
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
                postData.giy = SapiSafeFacade.SAPIWEBVIEW_BACK;
                postData.a(post, context);
                this.eEO.add(postData);
            }
        }
        if (!u.v(this.eEO)) {
            this.eEO.get(0).giz = true;
            setCount(this.eEO.size());
        }
        List<Long> list = pbTopAgreePost.post_id_list;
        if (list != null && list.size() > 0) {
            for (Long l : pbTopAgreePost.post_id_list) {
                this.eEP.add(l);
            }
        }
    }
}
