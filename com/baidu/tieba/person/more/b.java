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
/* loaded from: classes23.dex */
public class b {
    private c lVi;
    private List<q> lVj;
    private PersonMoreData lVk;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<h> abVar) {
        this.mPageContext = tbPageContext;
        this.lVi = new c(tbPageContext);
        this.lVi.c(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.lVk = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.lVi.al(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        dsR();
        this.lVi.setData(this.lVj);
    }

    public void onChangeSkinType() {
        if (this.lVi != null) {
            this.lVi.onChangeSkinType();
        }
    }

    private void dsR() {
        this.lVj = new ArrayList();
        if (this.lVk != null && !y.isEmpty(this.lVk.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.lVk.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aGz = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.lVj.add(hVar);
                }
            }
        }
    }
}
