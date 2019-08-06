package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.personCenter.data.PersonMoreData;
import com.baidu.tieba.personCenter.data.PersonMoreItemData;
import com.baidu.tieba.personCenter.data.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private c ikr;
    private List<m> iks;
    private PersonMoreData ikt;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<g> abVar) {
        this.mPageContext = tbPageContext;
        this.ikr = new c(tbPageContext);
        this.ikr.d(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.ikt = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.ikr.Q(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        cbr();
        this.ikr.setData(this.iks);
    }

    public void onChangeSkinType() {
        if (this.ikr != null) {
            this.ikr.onChangeSkinType();
        }
    }

    private void cbr() {
        this.iks = new ArrayList();
        if (this.ikt != null && !v.aa(this.ikt.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.ikt.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.bDN = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.iks.add(gVar);
                }
            }
        }
    }
}
