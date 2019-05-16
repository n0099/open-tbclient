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
    private c icT;
    private List<m> icU;
    private PersonMoreData icV;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<g> abVar) {
        this.mPageContext = tbPageContext;
        this.icT = new c(tbPageContext);
        this.icT.d(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.icV = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.icT.O(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        bYg();
        this.icT.setData(this.icU);
    }

    public void onChangeSkinType() {
        if (this.icT != null) {
            this.icT.onChangeSkinType();
        }
    }

    private void bYg() {
        this.icU = new ArrayList();
        if (this.icV != null && !v.aa(this.icV.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.icV.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.bCP = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.icU.add(gVar);
                }
            }
        }
    }
}
