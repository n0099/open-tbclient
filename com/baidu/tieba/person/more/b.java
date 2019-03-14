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
    private c hLh;
    private List<m> hLi;
    private PersonMoreData hLj;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<f> abVar) {
        this.mPageContext = tbPageContext;
        this.hLh = new c(tbPageContext);
        this.hLh.d(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.hLj = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(d.h.person_center_more_layout);
        this.hLh.O(this.mPageContext.getPageActivity().findViewById(d.g.person_more_layout));
        bQr();
        this.hLh.setData(this.hLi);
    }

    public void onChangeSkinType() {
        if (this.hLh != null) {
            this.hLh.onChangeSkinType();
        }
    }

    private void bQr() {
        this.hLi = new ArrayList();
        if (this.hLj != null && !v.T(this.hLj.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.hLj.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    f fVar = new f();
                    fVar.title = personMoreItemData.mName;
                    fVar.type = 36;
                    fVar.bvI = personMoreItemData.mUrl;
                    fVar.itemId = personMoreItemData.mId;
                    this.hLi.add(fVar);
                }
            }
        }
    }
}
