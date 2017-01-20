package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.p;
import tbclient.PbPage.GodCard;
/* loaded from: classes.dex */
public class a extends p {
    public static final BdUniqueId eff = BdUniqueId.gen();
    private String OW;
    private String buttonText;
    private String efg;
    private int efh;
    private String picUrl;
    private String portrait;
    private String text;
    private String userName;

    public void a(GodCard godCard) {
        if (godCard != null) {
            this.userName = godCard.user_name;
            this.portrait = godCard.portrait;
            this.efg = godCard.time_ex;
            this.text = godCard.text;
            this.picUrl = godCard.pic_url;
            this.buttonText = godCard.button_text;
            this.OW = godCard.button_url;
            this.efh = godCard.show_floor.intValue();
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.p
    public String aJM() {
        return this.efg;
    }

    public String getText() {
        return this.text;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String aJN() {
        return this.buttonText;
    }

    public String aJO() {
        return this.OW;
    }

    public int aJP() {
        return this.efh;
    }

    @Override // com.baidu.tieba.tbadkCore.data.p, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eff;
    }
}
