package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.PersonMoreData;
import com.baidu.tieba.personCenter.data.PersonMoreItemData;
import com.baidu.tieba.personCenter.data.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private c hKT;
    private List<m> hKU;
    private PersonMoreData hKV;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<f> abVar) {
        this.mPageContext = tbPageContext;
        this.hKT = new c(tbPageContext);
        this.hKT.d(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.hKV = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(d.h.person_center_more_layout);
        this.hKT.O(this.mPageContext.getPageActivity().findViewById(d.g.person_more_layout));
        bQn();
        this.hKT.setData(this.hKU);
    }

    public void onChangeSkinType() {
        if (this.hKT != null) {
            this.hKT.onChangeSkinType();
        }
    }

    private void bQn() {
        this.hKU = new ArrayList();
        if (this.hKV != null && !v.T(this.hKV.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.hKV.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    f fVar = new f();
                    fVar.title = personMoreItemData.mName;
                    fVar.type = 36;
                    fVar.bvL = personMoreItemData.mUrl;
                    fVar.itemId = personMoreItemData.mId;
                    this.hKU.add(fVar);
                }
            }
        }
    }
}
