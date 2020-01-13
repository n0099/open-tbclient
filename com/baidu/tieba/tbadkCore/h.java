package com.baidu.tieba.tbadkCore;

import java.util.LinkedList;
import java.util.List;
import tbclient.FrsPage.BusinessPromot;
/* loaded from: classes6.dex */
public class h {
    private long id;
    private String img;
    private String img_popup;
    private int kdi;
    private List<i> kdj;
    private String thread_id;
    private int thread_type;
    private String title;
    private int type;
    private String url;

    public void a(BusinessPromot businessPromot) {
        if (businessPromot != null) {
            this.title = businessPromot.title;
            this.img = businessPromot.img;
            this.img_popup = businessPromot.img_popup;
            this.type = businessPromot.type.intValue();
            this.thread_id = businessPromot.thread_id;
            this.url = businessPromot.url;
            this.kdi = businessPromot.join_num.intValue();
            this.id = businessPromot.id.longValue();
            if (businessPromot.comment_list != null) {
                this.kdj = new LinkedList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= businessPromot.comment_list.size()) {
                        break;
                    }
                    if (businessPromot.comment_list.get(i2) != null) {
                        i iVar = new i();
                        iVar.a(businessPromot.comment_list.get(i2));
                        this.kdj.add(iVar);
                    }
                    i = i2 + 1;
                }
            }
            this.thread_type = businessPromot.thread_type.intValue();
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String avB() {
        return this.img;
    }

    public String cIv() {
        return this.img_popup;
    }

    public int getType() {
        return this.type;
    }

    public String getThreadId() {
        return this.thread_id;
    }

    public String getUrl() {
        return this.url;
    }

    public int cIw() {
        return this.kdi;
    }

    public long getId() {
        return this.id;
    }

    public List<i> cIx() {
        return this.kdj;
    }

    public int getThreadType() {
        return this.thread_type;
    }
}
