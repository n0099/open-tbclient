package com.baidu.tieba.lego.card.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import d.b.b.e.p.l;
import d.b.i0.i1.o.i.a;
import d.b.i0.i1.o.k.b;
import d.b.i0.i1.o.k.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LPBigImgCard extends BaseCardInfo implements a<LPBigImgCard> {
    public final int bgColor;
    public final int bgColorNight;
    public final int btnColor;
    public final int btnColorNight;
    public final int btnHeight;
    public final String btnImgUrl;
    public final String btnLink;
    public final double btnPosRatio;
    public final String btnText;
    public final int btnWidth;
    public final int picHeight;
    public final String picUrl;
    public final int picWidth;

    public LPBigImgCard(JSONObject jSONObject) {
        super(jSONObject);
        this.picUrl = jSONObject.optString("pic_url");
        this.picWidth = d.a(jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH));
        this.picHeight = d.a(jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
        this.bgColor = b.b(jSONObject.optString("bg_color"));
        this.bgColorNight = b.b(jSONObject.optString("bg_color_n"));
        this.btnText = jSONObject.optString("btn_text");
        this.btnColor = b.b(jSONObject.optString("btn_color"));
        this.btnColorNight = b.b(jSONObject.optString("btn_color_n"));
        this.btnImgUrl = jSONObject.optString("btn_img");
        this.btnWidth = d.a(jSONObject.optInt("btn_width"));
        this.btnHeight = d.a(jSONObject.optInt("btn_height"));
        this.btnPosRatio = jSONObject.optDouble("btn_pos", 0.5d);
        this.btnLink = jSONObject.optString("link");
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public int getBgColorNight() {
        return this.bgColorNight;
    }

    public int getBtnColor() {
        return this.btnColor;
    }

    public int getBtnColorNight() {
        return this.btnColorNight;
    }

    public int getBtnHeight() {
        return this.btnHeight;
    }

    public String getBtnImgUrl() {
        return this.btnImgUrl;
    }

    public String getBtnLink() {
        return this.btnLink;
    }

    public double getBtnPosRatio() {
        return this.btnPosRatio;
    }

    public String getBtnText() {
        return this.btnText;
    }

    public int getBtnWidth() {
        return this.btnWidth;
    }

    public int getPicHeight() {
        return this.picHeight;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getPicWidth() {
        return this.picWidth;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        int i = this.picWidth;
        if (i > 0) {
            double d2 = this.picHeight;
            double d3 = i;
            Double.isNaN(d2);
            Double.isNaN(d3);
            return d2 / d3;
        }
        return super.getRatio();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.i1.o.i.a
    public void doLoad(LPBigImgCard lPBigImgCard, TbPageContext tbPageContext) {
        if (lPBigImgCard == null || tbPageContext == null) {
            return;
        }
        int k = l.k(TbadkCoreApplication.getInst());
        d.b.b.e.l.d.h().k(lPBigImgCard.getPicUrl(), 17, null, k, (int) ((lPBigImgCard.getPicHeight() / lPBigImgCard.getPicWidth()) * k), tbPageContext.getUniqueId(), new Object[0]);
    }
}
