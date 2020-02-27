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
    private c jgF;
    private List<m> jgG;
    private PersonMoreData jgH;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, z<g> zVar) {
        this.mPageContext = tbPageContext;
        this.jgF = new c(tbPageContext);
        this.jgF.c(zVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.jgH = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.jgF.initView(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        cuZ();
        this.jgF.setData(this.jgG);
    }

    public void onChangeSkinType() {
        if (this.jgF != null) {
            this.jgF.onChangeSkinType();
        }
    }

    private void cuZ() {
        this.jgG = new ArrayList();
        if (this.jgH != null && !v.isEmpty(this.jgH.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.jgH.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.cLQ = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.jgG.add(gVar);
                }
            }
        }
    }
}
