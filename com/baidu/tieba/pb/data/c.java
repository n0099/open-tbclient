package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.s;
import tbclient.PbPage.GodCard;
/* loaded from: classes.dex */
public class c extends s {
    public static final BdUniqueId dLB = BdUniqueId.gen();
    private String Fg;
    private String dLC;
    private String dLD;
    private int dLE;
    private String picUrl;
    private String portrait;
    private String text;
    private String userName;

    public void a(GodCard godCard) {
        if (godCard != null) {
            this.userName = godCard.user_name;
            this.portrait = godCard.portrait;
            this.dLC = godCard.time_ex;
            this.text = godCard.text;
            this.picUrl = godCard.pic_url;
            this.Fg = godCard.button_text;
            this.dLD = godCard.button_url;
            this.dLE = godCard.show_floor.intValue();
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.s
    public String aDB() {
        return this.dLC;
    }

    public String getText() {
        return this.text;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String aDC() {
        return this.Fg;
    }

    public String aDD() {
        return this.dLD;
    }

    public int aDE() {
        return this.dLE;
    }

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dLB;
    }
}
