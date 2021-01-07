package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    private TbPageContext mPageContext;
    private List<n> moA;
    private PersonMoreData moB;
    private c moz;

    public b(TbPageContext tbPageContext, Bundle bundle, aa<h> aaVar) {
        this.mPageContext = tbPageContext;
        this.moz = new c(tbPageContext);
        this.moz.c(aaVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.moB = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.moz.ap(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        dya();
        this.moz.setData(this.moA);
    }

    public void onChangeSkinType() {
        if (this.moz != null) {
            this.moz.onChangeSkinType();
        }
    }

    private void dya() {
        this.moA = new ArrayList();
        if (this.moB != null && !x.isEmpty(this.moB.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.moB.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aJH = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.moA.add(hVar);
                }
            }
        }
    }
}
