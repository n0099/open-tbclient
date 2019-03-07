package com.baidu.tieba.lego.card.model;

import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LPBigImgCard extends BaseCardInfo implements com.baidu.tieba.lego.card.c.a<LPBigImgCard> {
    private final int bgColor;
    private final int bgColorNight;
    private final int btnColor;
    private final int btnColorNight;
    private final int btnHeight;
    private final String btnImgUrl;
    private final String btnLink;
    private final double btnPosRatio;
    private final String btnText;
    private final int btnWidth;
    private final int picHeight;
    private final String picUrl;
    private final int picWidth;

    public LPBigImgCard(JSONObject jSONObject) {
        super(jSONObject);
        this.picUrl = jSONObject.optString("pic_url");
        this.picWidth = com.baidu.tieba.lego.card.d.c.uQ(jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH));
        this.picHeight = com.baidu.tieba.lego.card.d.c.uQ(jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
        this.bgColor = com.baidu.tieba.lego.card.d.a.parseColor(jSONObject.optString("bg_color"));
        this.bgColorNight = com.baidu.tieba.lego.card.d.a.parseColor(jSONObject.optString("bg_color_n"));
        this.btnText = jSONObject.optString("btn_text");
        this.btnColor = com.baidu.tieba.lego.card.d.a.parseColor(jSONObject.optString("btn_color"));
        this.btnColorNight = com.baidu.tieba.lego.card.d.a.parseColor(jSONObject.optString("btn_color_n"));
        this.btnImgUrl = jSONObject.optString("btn_img");
        this.btnWidth = com.baidu.tieba.lego.card.d.c.uQ(jSONObject.optInt("btn_width"));
        this.btnHeight = com.baidu.tieba.lego.card.d.c.uQ(jSONObject.optInt("btn_height"));
        this.btnPosRatio = jSONObject.optDouble("btn_pos", 0.5d);
        this.btnLink = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getPicWidth() {
        return this.picWidth;
    }

    public int getPicHeight() {
        return this.picHeight;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public int getBgColorNight() {
        return this.bgColorNight;
    }

    public String getBtnText() {
        return this.btnText;
    }

    public int getBtnColor() {
        return this.btnColor;
    }

    public int getBtnColorNight() {
        return this.btnColorNight;
    }

    public String getBtnImgUrl() {
        return this.btnImgUrl;
    }

    public int getBtnWidth() {
        return this.btnWidth;
    }

    public int getBtnHeight() {
        return this.btnHeight;
    }

    public double getBtnPosRatio() {
        return this.btnPosRatio;
    }

    public String getBtnLink() {
        return this.btnLink;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.c.a
    public void doLoad(LPBigImgCard lPBigImgCard, TbPageContext tbPageContext) {
        if (lPBigImgCard != null && tbPageContext != null) {
            int aO = l.aO(TbadkCoreApplication.getInst());
            com.baidu.adp.lib.f.c.jB().a(lPBigImgCard.getPicUrl(), 17, null, aO, (int) ((lPBigImgCard.getPicHeight() / lPBigImgCard.getPicWidth()) * aO), tbPageContext.getUniqueId(), new Object[0]);
        }
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return this.picWidth > 0 ? this.picHeight / this.picWidth : super.getRatio();
    }
}
