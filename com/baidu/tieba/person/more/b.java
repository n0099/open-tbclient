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
/* loaded from: classes8.dex */
public class b {
    private c jcb;
    private List<m> jcc;
    private PersonMoreData jcd;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, z<g> zVar) {
        this.mPageContext = tbPageContext;
        this.jcb = new c(tbPageContext);
        this.jcb.c(zVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.jcd = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.jcb.initView(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        csx();
        this.jcb.setData(this.jcc);
    }

    public void onChangeSkinType() {
        if (this.jcb != null) {
            this.jcb.onChangeSkinType();
        }
    }

    private void csx() {
        this.jcc = new ArrayList();
        if (this.jcd != null && !v.isEmpty(this.jcd.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.jcd.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.cHB = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.jcc.add(gVar);
                }
            }
        }
    }
}
