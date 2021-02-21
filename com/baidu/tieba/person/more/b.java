package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    private TbPageContext mPageContext;
    private c mtl;
    private List<n> mtm;
    private PersonMoreData mtn;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<h> abVar) {
        this.mPageContext = tbPageContext;
        this.mtl = new c(tbPageContext);
        this.mtl.c(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.mtn = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.mtl.am(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        dwy();
        this.mtl.setData(this.mtm);
    }

    public void onChangeSkinType() {
        if (this.mtl != null) {
            this.mtl.onChangeSkinType();
        }
    }

    private void dwy() {
        this.mtm = new ArrayList();
        if (this.mtn != null && !y.isEmpty(this.mtn.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.mtn.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aHq = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.mtm.add(hVar);
                }
            }
        }
    }
}
