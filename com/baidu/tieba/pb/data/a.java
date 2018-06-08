package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.PbPage.GodCard;
/* loaded from: classes2.dex */
public class a extends PostData {
    public static final BdUniqueId foj = BdUniqueId.gen();
    private String aen;
    private String buttonText;
    private String fok;
    private int fol;
    private String picUrl;
    private String portrait;
    private String text;
    private String userName;

    public void a(GodCard godCard) {
        if (godCard != null) {
            this.userName = godCard.user_name;
            this.portrait = godCard.portrait;
            this.fok = godCard.time_ex;
            this.text = godCard.text;
            this.picUrl = godCard.pic_url;
            this.buttonText = godCard.button_text;
            this.aen = godCard.button_url;
            this.fol = godCard.show_floor.intValue();
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPortrait() {
        return this.portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public String bah() {
        return this.fok;
    }

    public String getText() {
        return this.text;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String bai() {
        return this.buttonText;
    }

    public String baj() {
        return this.aen;
    }

    public int bak() {
        return this.fol;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return foj;
    }
}
