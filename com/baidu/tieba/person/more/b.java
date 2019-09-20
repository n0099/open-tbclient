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
    private c imr;
    private List<m> ims;
    private PersonMoreData imt;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<g> abVar) {
        this.mPageContext = tbPageContext;
        this.imr = new c(tbPageContext);
        this.imr.d(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.imt = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.imr.Q(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        ccf();
        this.imr.setData(this.ims);
    }

    public void onChangeSkinType() {
        if (this.imr != null) {
            this.imr.onChangeSkinType();
        }
    }

    private void ccf() {
        this.ims = new ArrayList();
        if (this.imt != null && !v.aa(this.imt.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.imt.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.bEl = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.ims.add(gVar);
                }
            }
        }
    }
}
