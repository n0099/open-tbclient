package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.PersonMoreData;
import com.baidu.tieba.personCenter.data.PersonMoreItemData;
import com.baidu.tieba.personCenter.data.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private c fPO;
    private List<h> fPP;
    private PersonMoreData fPQ;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<e> abVar) {
        this.mPageContext = tbPageContext;
        this.fPO = new c(tbPageContext);
        this.fPO.b(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.fPQ = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(d.i.person_center_more_layout);
        this.fPO.Y(this.mPageContext.getPageActivity().findViewById(d.g.person_more_layout));
        biF();
        this.fPO.setData(this.fPP);
    }

    public void onChangeSkinType() {
        if (this.fPO != null) {
            this.fPO.onChangeSkinType();
        }
    }

    private void biF() {
        this.fPP = new ArrayList();
        if (this.fPQ != null && !w.z(this.fPQ.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.fPQ.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    e eVar = new e();
                    eVar.title = personMoreItemData.mName;
                    eVar.type = 36;
                    eVar.dJm = personMoreItemData.mUrl;
                    eVar.itemId = personMoreItemData.mId;
                    this.fPP.add(eVar);
                }
            }
        }
    }
}
