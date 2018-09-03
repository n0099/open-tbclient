package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.f;
import com.baidu.tieba.personCenter.data.PersonMoreData;
import com.baidu.tieba.personCenter.data.PersonMoreItemData;
import com.baidu.tieba.personCenter.data.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private c fTV;
    private List<h> fTW;
    private PersonMoreData fTX;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ad<f> adVar) {
        this.mPageContext = tbPageContext;
        this.fTV = new c(tbPageContext);
        this.fTV.b(adVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.fTX = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(f.h.person_center_more_layout);
        this.fTV.Y(this.mPageContext.getPageActivity().findViewById(f.g.person_more_layout));
        bhz();
        this.fTV.setData(this.fTW);
    }

    public void onChangeSkinType() {
        if (this.fTV != null) {
            this.fTV.onChangeSkinType();
        }
    }

    private void bhz() {
        this.fTW = new ArrayList();
        if (this.fTX != null && !w.z(this.fTX.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.fTX.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    com.baidu.tieba.personCenter.data.f fVar = new com.baidu.tieba.personCenter.data.f();
                    fVar.title = personMoreItemData.mName;
                    fVar.type = 36;
                    fVar.acH = personMoreItemData.mUrl;
                    fVar.itemId = personMoreItemData.mId;
                    this.fTW.add(fVar);
                }
            }
        }
    }
}
