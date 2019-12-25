package com.baidu.tieba.tbadkCore;

import java.util.LinkedList;
import java.util.List;
import tbclient.FrsPage.BusinessPromot;
/* loaded from: classes5.dex */
public class h {
    private long id;
    private String img;
    private String img_popup;
    private int jZF;
    private List<i> jZG;
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
            this.jZF = businessPromot.join_num.intValue();
            this.id = businessPromot.id.longValue();
            if (businessPromot.comment_list != null) {
                this.jZG = new LinkedList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= businessPromot.comment_list.size()) {
                        break;
                    }
                    if (businessPromot.comment_list.get(i2) != null) {
                        i iVar = new i();
                        iVar.a(businessPromot.comment_list.get(i2));
                        this.jZG.add(iVar);
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

    public String avi() {
        return this.img;
    }

    public String cHr() {
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

    public int cHs() {
        return this.jZF;
    }

    public long getId() {
        return this.id;
    }

    public List<i> cHt() {
        return this.jZG;
    }

    public int getThreadType() {
        return this.thread_type;
    }
}
