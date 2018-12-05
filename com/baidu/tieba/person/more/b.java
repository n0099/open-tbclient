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
    private c gra;
    private List<h> grb;
    private PersonMoreData grc;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ad<f> adVar) {
        this.mPageContext = tbPageContext;
        this.gra = new c(tbPageContext);
        this.gra.b(adVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.grc = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(e.h.person_center_more_layout);
        this.gra.initView(this.mPageContext.getPageActivity().findViewById(e.g.person_more_layout));
        boz();
        this.gra.setData(this.grb);
    }

    public void onChangeSkinType() {
        if (this.gra != null) {
            this.gra.onChangeSkinType();
        }
    }

    private void boz() {
        this.grb = new ArrayList();
        if (this.grc != null && !v.I(this.grc.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.grc.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    f fVar = new f();
                    fVar.title = personMoreItemData.mName;
                    fVar.type = 36;
                    fVar.aou = personMoreItemData.mUrl;
                    fVar.itemId = personMoreItemData.mId;
                    this.grb.add(fVar);
                }
            }
        }
    }
}
