package com.baidu.tieba.personInfo;

import java.util.ArrayList;
import java.util.List;
import tbclient.UcCard;
import tbclient.UcCardInfo;
/* loaded from: classes.dex */
public class bq {
    private String dzQ;
    private String dzR;
    private List<a> dzS;
    private String icon;
    private String name;

    public String getName() {
        return this.name;
    }

    public String getIcon() {
        return this.icon;
    }

    public String aCw() {
        return this.dzQ;
    }

    public String aCx() {
        return this.dzR;
    }

    public List<a> aCy() {
        return this.dzS;
    }

    public void a(UcCard ucCard) {
        if (ucCard != null) {
            this.name = ucCard.name;
            this.icon = ucCard.icon;
            this.dzQ = ucCard.doc;
            this.dzR = ucCard.jmp;
            this.dzS = new ArrayList();
            if (ucCard.uc_cards != null) {
                for (UcCardInfo ucCardInfo : ucCard.uc_cards) {
                    if (ucCardInfo != null) {
                        a aVar = new a();
                        aVar.a(ucCardInfo);
                        this.dzS.add(aVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        private String dzR;
        private String pic;
        private String tip;
        private String title;

        public String getTitle() {
            return this.title;
        }

        public String getPic() {
            return this.pic;
        }

        public String aCx() {
            return this.dzR;
        }

        public String se() {
            return this.tip;
        }

        public void a(UcCardInfo ucCardInfo) {
            if (ucCardInfo != null) {
                this.title = ucCardInfo.title;
                this.pic = ucCardInfo.pic;
                this.dzR = ucCardInfo.jmp;
                this.tip = ucCardInfo.tip;
            }
        }
    }
}
