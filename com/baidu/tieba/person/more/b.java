package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class b {
    private c lCx;
    private List<q> lCy;
    private PersonMoreData lCz;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, aa<h> aaVar) {
        this.mPageContext = tbPageContext;
        this.lCx = new c(tbPageContext);
        this.lCx.c(aaVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.lCz = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.lCx.an(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        dnI();
        this.lCx.setData(this.lCy);
    }

    public void onChangeSkinType() {
        if (this.lCx != null) {
            this.lCx.onChangeSkinType();
        }
    }

    private void dnI() {
        this.lCy = new ArrayList();
        if (this.lCz != null && !y.isEmpty(this.lCz.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.lCz.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aHf = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.lCy.add(hVar);
                }
            }
        }
    }
}
