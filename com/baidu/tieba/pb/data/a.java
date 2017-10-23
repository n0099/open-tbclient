package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.PbPage.GodCard;
/* loaded from: classes.dex */
public class a extends PostData {
    public static final BdUniqueId exN = BdUniqueId.gen();
    private String Up;
    private String buttonText;
    private String exO;
    private int exP;
    private String picUrl;
    private String portrait;
    private String text;
    private String userName;

    public void a(GodCard godCard) {
        if (godCard != null) {
            this.userName = godCard.user_name;
            this.portrait = godCard.portrait;
            this.exO = godCard.time_ex;
            this.text = godCard.text;
            this.picUrl = godCard.pic_url;
            this.buttonText = godCard.button_text;
            this.Up = godCard.button_url;
            this.exP = godCard.show_floor.intValue();
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public String aMJ() {
        return this.exO;
    }

    public String getText() {
        return this.text;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String aMK() {
        return this.buttonText;
    }

    public String aML() {
        return this.Up;
    }

    public int aMM() {
        return this.exP;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return exN;
    }
}
