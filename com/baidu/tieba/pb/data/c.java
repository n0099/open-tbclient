package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.s;
import tbclient.PbPage.GodCard;
/* loaded from: classes.dex */
public class c extends s {
    public static final BdUniqueId dXK = BdUniqueId.gen();
    private String FG;
    private String dXL;
    private String dXM;
    private int dXN;
    private String picUrl;
    private String portrait;
    private String text;
    private String userName;

    public void a(GodCard godCard) {
        if (godCard != null) {
            this.userName = godCard.user_name;
            this.portrait = godCard.portrait;
            this.dXL = godCard.time_ex;
            this.text = godCard.text;
            this.picUrl = godCard.pic_url;
            this.FG = godCard.button_text;
            this.dXM = godCard.button_url;
            this.dXN = godCard.show_floor.intValue();
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.s
    public String aGL() {
        return this.dXL;
    }

    public String getText() {
        return this.text;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String aGM() {
        return this.FG;
    }

    public String aGN() {
        return this.dXM;
    }

    public int aGO() {
        return this.dXN;
    }

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dXK;
    }
}
