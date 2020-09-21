package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class b {
    private c lnf;
    private List<q> lnh;
    private PersonMoreData lni;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, aa<h> aaVar) {
        this.mPageContext = tbPageContext;
        this.lnf = new c(tbPageContext);
        this.lnf.c(aaVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.lni = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.lnf.am(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        djY();
        this.lnf.setData(this.lnh);
    }

    public void onChangeSkinType() {
        if (this.lnf != null) {
            this.lnf.onChangeSkinType();
        }
    }

    private void djY() {
        this.lnh = new ArrayList();
        if (this.lni != null && !y.isEmpty(this.lni.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.lni.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aEb = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.lnh.add(hVar);
                }
            }
        }
    }
}
