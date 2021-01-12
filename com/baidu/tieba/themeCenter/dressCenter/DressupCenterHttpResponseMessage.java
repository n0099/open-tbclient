package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetThemeList.GetThemeListResIdl;
import tbclient.GetThemeList.ThemeCarousel;
import tbclient.GetThemeList.ThemeList;
/* loaded from: classes8.dex */
public class DressupCenterHttpResponseMessage extends TbHttpResponsedMessage {
    private e mRecommand;
    private List<a> mThemeCarouselList;
    private List<d> mThemeList;

    public DressupCenterHttpResponseMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetThemeListResIdl getThemeListResIdl = (GetThemeListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetThemeListResIdl.class);
        if (getThemeListResIdl != null) {
            if (getThemeListResIdl.error != null) {
                setError(getThemeListResIdl.error.errorno.intValue());
                setErrorString(getThemeListResIdl.error.usermsg);
            }
            if (getThemeListResIdl.data != null) {
                if (getThemeListResIdl.data.carousel != null) {
                    this.mThemeCarouselList = new ArrayList();
                    for (ThemeCarousel themeCarousel : getThemeListResIdl.data.carousel) {
                        if (themeCarousel != null && (!StringUtils.isNull(themeCarousel.pic_url) || !StringUtils.isNull(themeCarousel.active_url))) {
                            a aVar = new a();
                            aVar.a(themeCarousel);
                            this.mThemeCarouselList.add(aVar);
                        }
                    }
                }
                if (getThemeListResIdl.data.theme_list != null) {
                    this.mThemeList = new ArrayList();
                    for (ThemeList themeList : getThemeListResIdl.data.theme_list) {
                        if (themeList != null && !StringUtils.isNull(themeList.name)) {
                            d dVar = new d();
                            dVar.a(themeList);
                            this.mThemeList.add(dVar);
                        }
                    }
                }
                if (getThemeListResIdl.data.recommend != null) {
                    this.mRecommand = new e();
                    this.mRecommand.a(getThemeListResIdl.data.recommend);
                }
            }
        }
    }

    public List<d> getThemeList() {
        return this.mThemeList;
    }

    public void setThemeList(List<d> list) {
        this.mThemeList = list;
    }

    public List<a> getThemeCarouselList() {
        return this.mThemeCarouselList;
    }

    public void setThemeCarouselList(List<a> list) {
        this.mThemeCarouselList = list;
    }

    public e getRecommand() {
        return this.mRecommand;
    }

    public void setRecommand(e eVar) {
        this.mRecommand = eVar;
    }
}
