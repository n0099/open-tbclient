package com.baidu.tieba.tblauncherInterestGuide.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class InterestFrsData extends OrmObject implements Serializable {
    public static final long serialVersionUID = 3148930531307087667L;
    public String errmsg;
    public int errno;
    public ArrayList<Tag> tag_list = new ArrayList<>();

    /* loaded from: classes5.dex */
    public static class Card extends OrmObject implements Serializable {
        public static final long serialVersionUID = -6381883030119073721L;
        public String avatar;
        public String cdesc;
        public int cid;
        public int fid;
        public String fname;
        public String icon_url;
        public int is_like;
        public int order;
        public String slogan;

        public String getAvatar() {
            return this.avatar;
        }

        public String getCdesc() {
            return this.cdesc;
        }

        public int getCid() {
            return this.cid;
        }

        public int getFid() {
            return this.fid;
        }

        public String getFname() {
            return this.fname;
        }

        public String getIcon_url() {
            return this.icon_url;
        }

        public int getIs_like() {
            return this.is_like;
        }

        public int getOrder() {
            return this.order;
        }

        public String getSlogan() {
            return this.slogan;
        }

        public void setIs_like(int i) {
            this.is_like = i;
        }
    }

    /* loaded from: classes5.dex */
    public static class Tag extends OrmObject implements Serializable {
        public static final long serialVersionUID = -161320459489433271L;
        public String bdesc;
        public String bgpic;
        public String bicon;
        public int bid;
        public String bname;
        public int btype;
        public ArrayList<Card> card_list = new ArrayList<>();

        public String getBdesc() {
            return this.bdesc;
        }

        public String getBgpic() {
            return this.bgpic;
        }

        public String getBicon() {
            return this.bicon;
        }

        public int getBid() {
            return this.bid;
        }

        public String getBname() {
            return this.bname;
        }

        public int getBtype() {
            return this.btype;
        }

        public ArrayList<Card> getCard_list() {
            return this.card_list;
        }
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public int getErrno() {
        return this.errno;
    }

    public ArrayList<Tag> getTag_list() {
        return this.tag_list;
    }

    public void setErrmsg(String str) {
        this.errmsg = str;
    }

    public void setErrno(int i) {
        this.errno = i;
    }
}
