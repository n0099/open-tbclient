package com.baidu.tieba.tbadkCore;

import java.util.LinkedList;
import java.util.List;
import tbclient.FrsPage.BusinessPromot;
/* loaded from: classes3.dex */
public class h {
    private long id;
    private String img;
    private String img_popup;
    private int jdX;
    private List<i> jdY;
    private String thread_id;
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
            this.jdX = businessPromot.join_num.intValue();
            this.id = businessPromot.id.longValue();
            if (businessPromot.comment_list != null) {
                this.jdY = new LinkedList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < businessPromot.comment_list.size()) {
                        if (businessPromot.comment_list.get(i2) != null) {
                            i iVar = new i();
                            iVar.a(businessPromot.comment_list.get(i2));
                            this.jdY.add(iVar);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String Zy() {
        return this.img;
    }

    public String coJ() {
        return this.img_popup;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int coK() {
        return this.jdX;
    }

    public long getId() {
        return this.id;
    }

    public List<i> coL() {
        return this.jdY;
    }
}
