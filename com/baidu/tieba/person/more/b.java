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
    private c lOU;
    private List<q> lOV;
    private PersonMoreData lOW;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<h> abVar) {
        this.mPageContext = tbPageContext;
        this.lOU = new c(tbPageContext);
        this.lOU.c(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.lOW = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.lOU.ah(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        dqP();
        this.lOU.setData(this.lOV);
    }

    public void onChangeSkinType() {
        if (this.lOU != null) {
            this.lOU.onChangeSkinType();
        }
    }

    private void dqP() {
        this.lOV = new ArrayList();
        if (this.lOW != null && !y.isEmpty(this.lOW.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.lOW.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aHs = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.lOV.add(hVar);
                }
            }
        }
    }
}
