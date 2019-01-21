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
    private c guW;
    private List<h> guX;
    private PersonMoreData guY;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ad<f> adVar) {
        this.mPageContext = tbPageContext;
        this.guW = new c(tbPageContext);
        this.guW.b(adVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.guY = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(e.h.person_center_more_layout);
        this.guW.initView(this.mPageContext.getPageActivity().findViewById(e.g.person_more_layout));
        bpT();
        this.guW.setData(this.guX);
    }

    public void onChangeSkinType() {
        if (this.guW != null) {
            this.guW.onChangeSkinType();
        }
    }

    private void bpT() {
        this.guX = new ArrayList();
        if (this.guY != null && !v.I(this.guY.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.guY.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    f fVar = new f();
                    fVar.title = personMoreItemData.mName;
                    fVar.type = 36;
                    fVar.aoX = personMoreItemData.mUrl;
                    fVar.itemId = personMoreItemData.mId;
                    this.guX.add(fVar);
                }
            }
        }
    }
}
