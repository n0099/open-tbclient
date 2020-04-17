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
    private c jSA;
    private List<m> jSB;
    private PersonMoreData jSC;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, z<g> zVar) {
        this.mPageContext = tbPageContext;
        this.jSA = new c(tbPageContext);
        this.jSA.c(zVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.jSC = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.jSA.ag(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        cGc();
        this.jSA.setData(this.jSB);
    }

    public void onChangeSkinType() {
        if (this.jSA != null) {
            this.jSA.onChangeSkinType();
        }
    }

    private void cGc() {
        this.jSB = new ArrayList();
        if (this.jSC != null && !v.isEmpty(this.jSC.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.jSC.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.aqV = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.jSB.add(gVar);
                }
            }
        }
    }
}
