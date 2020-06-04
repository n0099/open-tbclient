package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.BusinessPromotCommentList;
/* loaded from: classes.dex */
public class j {
    private int ljN;
    private String title;
    private long uid;
    private String username;

    public void a(BusinessPromotCommentList businessPromotCommentList) {
        if (businessPromotCommentList != null) {
            this.title = businessPromotCommentList.title;
            this.username = businessPromotCommentList.username;
            this.uid = businessPromotCommentList.uid.longValue();
            this.ljN = businessPromotCommentList.is_lz.intValue();
        }
    }

    public String getTitle() {
        return this.title;
    }

    public boolean dcO() {
        return this.ljN == 1;
    }
}
