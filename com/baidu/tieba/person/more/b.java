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
    private c ila;
    private List<m> ilb;
    private PersonMoreData ilc;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<g> abVar) {
        this.mPageContext = tbPageContext;
        this.ila = new c(tbPageContext);
        this.ila.d(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.ilc = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.ila.W(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        bZh();
        this.ila.setData(this.ilb);
    }

    public void onChangeSkinType() {
        if (this.ila != null) {
            this.ila.onChangeSkinType();
        }
    }

    private void bZh() {
        this.ilb = new ArrayList();
        if (this.ilc != null && !v.isEmpty(this.ilc.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.ilc.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.bWc = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.ilb.add(gVar);
                }
            }
        }
    }
}
