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
    private c giO;
    private List<h> giP;
    private PersonMoreData giQ;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ad<f> adVar) {
        this.mPageContext = tbPageContext;
        this.giO = new c(tbPageContext);
        this.giO.b(adVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.giQ = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(e.h.person_center_more_layout);
        this.giO.initView(this.mPageContext.getPageActivity().findViewById(e.g.person_more_layout));
        bnl();
        this.giO.setData(this.giP);
    }

    public void onChangeSkinType() {
        if (this.giO != null) {
            this.giO.onChangeSkinType();
        }
    }

    private void bnl() {
        this.giP = new ArrayList();
        if (this.giQ != null && !v.J(this.giQ.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.giQ.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    f fVar = new f();
                    fVar.title = personMoreItemData.mName;
                    fVar.type = 36;
                    fVar.akf = personMoreItemData.mUrl;
                    fVar.itemId = personMoreItemData.mId;
                    this.giP.add(fVar);
                }
            }
        }
    }
}
