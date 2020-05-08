package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.personCenter.c.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b {
    private c jSE;
    private List<m> jSF;
    private PersonMoreData jSG;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, z<g> zVar) {
        this.mPageContext = tbPageContext;
        this.jSE = new c(tbPageContext);
        this.jSE.c(zVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.jSG = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.jSE.ag(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        cFZ();
        this.jSE.setData(this.jSF);
    }

    public void onChangeSkinType() {
        if (this.jSE != null) {
            this.jSE.onChangeSkinType();
        }
    }

    private void cFZ() {
        this.jSF = new ArrayList();
        if (this.jSG != null && !v.isEmpty(this.jSG.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.jSG.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.arb = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.jSF.add(gVar);
                }
            }
        }
    }
}
