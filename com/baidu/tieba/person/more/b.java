package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.PersonMoreData;
import com.baidu.tieba.personCenter.data.PersonMoreItemData;
import com.baidu.tieba.personCenter.data.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private c giP;
    private List<i> giQ;
    private PersonMoreData giR;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, v<e> vVar) {
        this.mPageContext = tbPageContext;
        this.giP = new c(tbPageContext);
        this.giP.b(vVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.giR = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(d.h.person_center_more_layout);
        this.giP.bu(this.mPageContext.getPageActivity().findViewById(d.g.person_more_layout));
        biE();
        this.giP.setData(this.giQ);
    }

    private void biE() {
        this.giQ = new ArrayList();
        if (this.giR != null && !com.baidu.tbadk.core.util.v.E(this.giR.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.giR.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    e eVar = new e();
                    eVar.title = personMoreItemData.mName;
                    eVar.type = 36;
                    eVar.eco = personMoreItemData.mUrl;
                    eVar.itemId = personMoreItemData.mId;
                    this.giQ.add(eVar);
                }
            }
        }
    }
}
