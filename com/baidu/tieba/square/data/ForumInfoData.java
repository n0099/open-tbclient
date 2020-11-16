package com.baidu.tieba.square.data;

import com.baidu.tbadk.core.util.AbstractImageProvider;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class ForumInfoData extends AbstractImageProvider implements Serializable {
    private static final long serialVersionUID = 1;
    public String forum_name = "";
    public int forum_id = 0;
    public String avatar = "";
    public String slogan = "";
    public int member_count = 0;
    public int thread_count = 0;
    public int is_like = 0;
    public int mbr_inter_rank = 0;

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider
    public ArrayList<String> getForumPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.avatar);
        return arrayList;
    }
}
