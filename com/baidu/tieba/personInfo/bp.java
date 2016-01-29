package com.baidu.tieba.personInfo;

import java.util.ArrayList;
import java.util.List;
import tbclient.UcCard;
import tbclient.UcCardInfo;
/* loaded from: classes.dex */
public class bp {
    private String dcf;
    private String dcg;
    private List<a> dch;
    private String icon;
    private String name;

    public String getName() {
        return this.name;
    }

    public String getIcon() {
        return this.icon;
    }

    public String aut() {
        return this.dcf;
    }

    public String auu() {
        return this.dcg;
    }

    public List<a> auv() {
        return this.dch;
    }

    public void a(UcCard ucCard) {
        if (ucCard != null) {
            this.name = ucCard.name;
            this.icon = ucCard.icon;
            this.dcf = ucCard.doc;
            this.dcg = ucCard.jmp;
            this.dch = new ArrayList();
            if (ucCard.uc_cards != null) {
                for (UcCardInfo ucCardInfo : ucCard.uc_cards) {
                    if (ucCardInfo != null) {
                        a aVar = new a();
                        aVar.a(ucCardInfo);
                        this.dch.add(aVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        private String dcg;
        private String pic;
        private String tip;
        private String title;

        public String getTitle() {
            return this.title;
        }

        public String getPic() {
            return this.pic;
        }

        public String auu() {
            return this.dcg;
        }

        public String ut() {
            return this.tip;
        }

        public void a(UcCardInfo ucCardInfo) {
            if (ucCardInfo != null) {
                this.title = ucCardInfo.title;
                this.pic = ucCardInfo.pic;
                this.dcg = ucCardInfo.jmp;
                this.tip = ucCardInfo.tip;
            }
        }
    }
}
