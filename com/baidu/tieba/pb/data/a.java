package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.q;
import tbclient.PbPage.GodCard;
/* loaded from: classes.dex */
public class a extends q {
    public static final BdUniqueId dWm = BdUniqueId.gen();
    private String PO;
    private String buttonText;
    private String dWn;
    private int dWo;
    private String picUrl;
    private String portrait;
    private String text;
    private String userName;

    public void a(GodCard godCard) {
        if (godCard != null) {
            this.userName = godCard.user_name;
            this.portrait = godCard.portrait;
            this.dWn = godCard.time_ex;
            this.text = godCard.text;
            this.picUrl = godCard.pic_url;
            this.buttonText = godCard.button_text;
            this.PO = godCard.button_url;
            this.dWo = godCard.show_floor.intValue();
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String aHY() {
        return this.dWn;
    }

    public String getText() {
        return this.text;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String aHZ() {
        return this.buttonText;
    }

    public String aIa() {
        return this.PO;
    }

    public int aIb() {
        return this.dWo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dWm;
    }
}
