package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class b {
    private c kOq;
    private List<q> kOr;
    private PersonMoreData kOs;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, aa<h> aaVar) {
        this.mPageContext = tbPageContext;
        this.kOq = new c(tbPageContext);
        this.kOq.c(aaVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.kOs = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.kOq.aj(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        cVx();
        this.kOq.setData(this.kOr);
    }

    public void onChangeSkinType() {
        if (this.kOq != null) {
            this.kOq.onChangeSkinType();
        }
    }

    private void cVx() {
        this.kOr = new ArrayList();
        if (this.kOs != null && !x.isEmpty(this.kOs.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.kOs.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aye = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.kOr.add(hVar);
                }
            }
        }
    }
}
