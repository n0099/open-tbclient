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
    private c ikj;
    private List<m> ikk;
    private PersonMoreData ikl;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<g> abVar) {
        this.mPageContext = tbPageContext;
        this.ikj = new c(tbPageContext);
        this.ikj.d(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.ikl = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.ikj.W(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        bZf();
        this.ikj.setData(this.ikk);
    }

    public void onChangeSkinType() {
        if (this.ikj != null) {
            this.ikj.onChangeSkinType();
        }
    }

    private void bZf() {
        this.ikk = new ArrayList();
        if (this.ikl != null && !v.isEmpty(this.ikl.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.ikl.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.bVl = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.ikk.add(gVar);
                }
            }
        }
    }
}
