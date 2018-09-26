package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.personCenter.data.PersonMoreData;
import com.baidu.tieba.personCenter.data.PersonMoreItemData;
import com.baidu.tieba.personCenter.data.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private c gbl;
    private List<h> gbm;
    private PersonMoreData gbn;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ad<f> adVar) {
        this.mPageContext = tbPageContext;
        this.gbl = new c(tbPageContext);
        this.gbl.b(adVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.gbn = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(e.h.person_center_more_layout);
        this.gbl.am(this.mPageContext.getPageActivity().findViewById(e.g.person_more_layout));
        bka();
        this.gbl.setData(this.gbm);
    }

    public void onChangeSkinType() {
        if (this.gbl != null) {
            this.gbl.onChangeSkinType();
        }
    }

    private void bka() {
        this.gbm = new ArrayList();
        if (this.gbn != null && !v.z(this.gbn.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.gbn.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    f fVar = new f();
                    fVar.title = personMoreItemData.mName;
                    fVar.type = 36;
                    fVar.afi = personMoreItemData.mUrl;
                    fVar.itemId = personMoreItemData.mId;
                    this.gbm.add(fVar);
                }
            }
        }
    }
}
