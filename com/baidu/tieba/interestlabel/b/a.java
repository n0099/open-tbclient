package com.baidu.tieba.interestlabel.b;

import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes5.dex */
public class a {
    public boolean isFollow;
    public int labelId;
    public String labelName;

    public void a(ResponseTagInfo responseTagInfo) {
        if (responseTagInfo != null) {
            this.labelId = responseTagInfo.tag_id.intValue();
            this.labelName = responseTagInfo.tag_name;
            this.isFollow = responseTagInfo.is_followed.intValue() == 1;
        }
    }
}
