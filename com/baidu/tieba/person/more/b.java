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
    private c giE;
    private List<i> giF;
    private PersonMoreData giG;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, v<e> vVar) {
        this.mPageContext = tbPageContext;
        this.giE = new c(tbPageContext);
        this.giE.b(vVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.giG = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(d.h.person_center_more_layout);
        this.giE.bu(this.mPageContext.getPageActivity().findViewById(d.g.person_more_layout));
        biD();
        this.giE.setData(this.giF);
    }

    private void biD() {
        this.giF = new ArrayList();
        if (this.giG != null && !com.baidu.tbadk.core.util.v.E(this.giG.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.giG.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    e eVar = new e();
                    eVar.title = personMoreItemData.mName;
                    eVar.type = 36;
                    eVar.ecc = personMoreItemData.mUrl;
                    eVar.itemId = personMoreItemData.mId;
                    this.giF.add(eVar);
                }
            }
        }
    }
}
