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
    private c msW;
    private List<n> msX;
    private PersonMoreData msY;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<h> abVar) {
        this.mPageContext = tbPageContext;
        this.msW = new c(tbPageContext);
        this.msW.c(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.msY = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.msW.am(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        dwr();
        this.msW.setData(this.msX);
    }

    public void onChangeSkinType() {
        if (this.msW != null) {
            this.msW.onChangeSkinType();
        }
    }

    private void dwr() {
        this.msX = new ArrayList();
        if (this.msY != null && !y.isEmpty(this.msY.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.msY.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aHq = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.msX.add(hVar);
                }
            }
        }
    }
}
