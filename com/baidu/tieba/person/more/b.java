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
    private c jit;
    private List<m> jiu;
    private PersonMoreData jiv;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, z<g> zVar) {
        this.mPageContext = tbPageContext;
        this.jit = new c(tbPageContext);
        this.jit.c(zVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.jiv = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.jit.initView(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        cvv();
        this.jit.setData(this.jiu);
    }

    public void onChangeSkinType() {
        if (this.jit != null) {
            this.jit.onChangeSkinType();
        }
    }

    private void cvv() {
        this.jiu = new ArrayList();
        if (this.jiv != null && !v.isEmpty(this.jiv.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.jiv.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.cMd = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.jiu.add(gVar);
                }
            }
        }
    }
}
