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
    private c giN;
    private List<h> giO;
    private PersonMoreData giP;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ad<f> adVar) {
        this.mPageContext = tbPageContext;
        this.giN = new c(tbPageContext);
        this.giN.b(adVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.giP = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(e.h.person_center_more_layout);
        this.giN.initView(this.mPageContext.getPageActivity().findViewById(e.g.person_more_layout));
        bnl();
        this.giN.setData(this.giO);
    }

    public void onChangeSkinType() {
        if (this.giN != null) {
            this.giN.onChangeSkinType();
        }
    }

    private void bnl() {
        this.giO = new ArrayList();
        if (this.giP != null && !v.J(this.giP.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.giP.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    f fVar = new f();
                    fVar.title = personMoreItemData.mName;
                    fVar.type = 36;
                    fVar.akf = personMoreItemData.mUrl;
                    fVar.itemId = personMoreItemData.mId;
                    this.giO.add(fVar);
                }
            }
        }
    }
}
