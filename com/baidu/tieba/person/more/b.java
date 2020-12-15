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
    private TbPageContext mPageContext;
    private c mjr;
    private List<q> mjs;
    private PersonMoreData mjt;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<h> abVar) {
        this.mPageContext = tbPageContext;
        this.mjr = new c(tbPageContext);
        this.mjr.c(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.mjt = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.mjr.an(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        dyk();
        this.mjr.setData(this.mjs);
    }

    public void onChangeSkinType() {
        if (this.mjr != null) {
            this.mjr.onChangeSkinType();
        }
    }

    private void dyk() {
        this.mjs = new ArrayList();
        if (this.mjt != null && !y.isEmpty(this.mjt.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.mjt.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aJj = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.mjs.add(hVar);
                }
            }
        }
    }
}
