package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.PersonMoreData;
import com.baidu.tieba.personCenter.data.PersonMoreItemData;
import com.baidu.tieba.personCenter.data.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private c fDo;
    private List<h> fDp;
    private PersonMoreData fDq;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<e> abVar) {
        this.mPageContext = tbPageContext;
        this.fDo = new c(tbPageContext);
        this.fDo.b(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.fDq = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(d.i.person_center_more_layout);
        this.fDo.Y(this.mPageContext.getPageActivity().findViewById(d.g.person_more_layout));
        bdF();
        this.fDo.setData(this.fDp);
    }

    public void onChangeSkinType() {
        if (this.fDo != null) {
            this.fDo.onChangeSkinType();
        }
    }

    private void bdF() {
        this.fDp = new ArrayList();
        if (this.fDq != null && !v.w(this.fDq.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.fDq.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    e eVar = new e();
                    eVar.title = personMoreItemData.mName;
                    eVar.type = 36;
                    eVar.dwV = personMoreItemData.mUrl;
                    eVar.itemId = personMoreItemData.mId;
                    this.fDp.add(eVar);
                }
            }
        }
    }
}
