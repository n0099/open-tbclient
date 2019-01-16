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
    private c guV;
    private List<h> guW;
    private PersonMoreData guX;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ad<f> adVar) {
        this.mPageContext = tbPageContext;
        this.guV = new c(tbPageContext);
        this.guV.b(adVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.guX = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(e.h.person_center_more_layout);
        this.guV.initView(this.mPageContext.getPageActivity().findViewById(e.g.person_more_layout));
        bpT();
        this.guV.setData(this.guW);
    }

    public void onChangeSkinType() {
        if (this.guV != null) {
            this.guV.onChangeSkinType();
        }
    }

    private void bpT() {
        this.guW = new ArrayList();
        if (this.guX != null && !v.I(this.guX.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.guX.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    f fVar = new f();
                    fVar.title = personMoreItemData.mName;
                    fVar.type = 36;
                    fVar.aoW = personMoreItemData.mUrl;
                    fVar.itemId = personMoreItemData.mId;
                    this.guW.add(fVar);
                }
            }
        }
    }
}
