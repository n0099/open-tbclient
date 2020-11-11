package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class b {
    private c lUQ;
    private List<q> lUR;
    private PersonMoreData lUS;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<h> abVar) {
        this.mPageContext = tbPageContext;
        this.lUQ = new c(tbPageContext);
        this.lUQ.c(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.lUS = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.lUQ.al(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        dtr();
        this.lUQ.setData(this.lUR);
    }

    public void onChangeSkinType() {
        if (this.lUQ != null) {
            this.lUQ.onChangeSkinType();
        }
    }

    private void dtr() {
        this.lUR = new ArrayList();
        if (this.lUS != null && !y.isEmpty(this.lUS.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.lUS.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aIk = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.lUR.add(hVar);
                }
            }
        }
    }
}
