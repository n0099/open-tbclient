package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.BusinessPromotCommentList;
/* loaded from: classes.dex */
public class j {
    private int njF;
    private String title;
    private long uid;
    private String username;

    public void a(BusinessPromotCommentList businessPromotCommentList) {
        if (businessPromotCommentList != null) {
            this.title = businessPromotCommentList.title;
            this.username = businessPromotCommentList.username;
            this.uid = businessPromotCommentList.uid.longValue();
            this.njF = businessPromotCommentList.is_lz.intValue();
        }
    }

    public String getTitle() {
        return this.title;
    }

    public boolean dOl() {
        return this.njF == 1;
    }
}
