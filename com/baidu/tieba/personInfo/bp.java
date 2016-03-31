package com.baidu.tieba.personInfo;

import java.util.ArrayList;
import java.util.List;
import tbclient.UcCard;
import tbclient.UcCardInfo;
/* loaded from: classes.dex */
public class bp {
    private String dwI;
    private String dwJ;
    private List<a> dwK;
    private String icon;
    private String name;

    public String getName() {
        return this.name;
    }

    public String getIcon() {
        return this.icon;
    }

    public String aBZ() {
        return this.dwI;
    }

    public String aCa() {
        return this.dwJ;
    }

    public List<a> aCb() {
        return this.dwK;
    }

    public void a(UcCard ucCard) {
        if (ucCard != null) {
            this.name = ucCard.name;
            this.icon = ucCard.icon;
            this.dwI = ucCard.doc;
            this.dwJ = ucCard.jmp;
            this.dwK = new ArrayList();
            if (ucCard.uc_cards != null) {
                for (UcCardInfo ucCardInfo : ucCard.uc_cards) {
                    if (ucCardInfo != null) {
                        a aVar = new a();
                        aVar.a(ucCardInfo);
                        this.dwK.add(aVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        private String dwJ;
        private String pic;
        private String tip;
        private String title;

        public String getTitle() {
            return this.title;
        }

        public String getPic() {
            return this.pic;
        }

        public String aCa() {
            return this.dwJ;
        }

        public String uy() {
            return this.tip;
        }

        public void a(UcCardInfo ucCardInfo) {
            if (ucCardInfo != null) {
                this.title = ucCardInfo.title;
                this.pic = ucCardInfo.pic;
                this.dwJ = ucCardInfo.jmp;
                this.tip = ucCardInfo.tip;
            }
        }
    }
}
