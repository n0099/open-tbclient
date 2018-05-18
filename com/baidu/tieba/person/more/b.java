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
    private c fEu;
    private List<h> fEv;
    private PersonMoreData fEw;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<e> abVar) {
        this.mPageContext = tbPageContext;
        this.fEu = new c(tbPageContext);
        this.fEu.b(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.fEw = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(d.i.person_center_more_layout);
        this.fEu.Y(this.mPageContext.getPageActivity().findViewById(d.g.person_more_layout));
        bdF();
        this.fEu.setData(this.fEv);
    }

    public void onChangeSkinType() {
        if (this.fEu != null) {
            this.fEu.onChangeSkinType();
        }
    }

    private void bdF() {
        this.fEv = new ArrayList();
        if (this.fEw != null && !v.w(this.fEw.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.fEw.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    e eVar = new e();
                    eVar.title = personMoreItemData.mName;
                    eVar.type = 36;
                    eVar.dyc = personMoreItemData.mUrl;
                    eVar.itemId = personMoreItemData.mId;
                    this.fEv.add(eVar);
                }
            }
        }
    }
}
