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
    private c icX;
    private List<m> icY;
    private PersonMoreData icZ;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<g> abVar) {
        this.mPageContext = tbPageContext;
        this.icX = new c(tbPageContext);
        this.icX.d(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.icZ = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.icX.O(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        bYk();
        this.icX.setData(this.icY);
    }

    public void onChangeSkinType() {
        if (this.icX != null) {
            this.icX.onChangeSkinType();
        }
    }

    private void bYk() {
        this.icY = new ArrayList();
        if (this.icZ != null && !v.aa(this.icZ.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.icZ.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.bCQ = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.icY.add(gVar);
                }
            }
        }
    }
}
