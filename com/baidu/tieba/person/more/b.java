package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.personCenter.data.PersonMoreData;
import com.baidu.tieba.personCenter.data.PersonMoreItemData;
import com.baidu.tieba.personCenter.data.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private c jfJ;
    private List<m> jfK;
    private PersonMoreData jfL;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, z<g> zVar) {
        this.mPageContext = tbPageContext;
        this.jfJ = new c(tbPageContext);
        this.jfJ.c(zVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.jfL = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.jfJ.initView(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        ctG();
        this.jfJ.setData(this.jfK);
    }

    public void onChangeSkinType() {
        if (this.jfJ != null) {
            this.jfJ.onChangeSkinType();
        }
    }

    private void ctG() {
        this.jfK = new ArrayList();
        if (this.jfL != null && !v.isEmpty(this.jfL.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.jfL.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.cHN = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.jfK.add(gVar);
                }
            }
        }
    }
}
