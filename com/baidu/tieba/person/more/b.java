package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class b {
    private c lep;
    private List<q> leq;
    private PersonMoreData ler;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, aa<h> aaVar) {
        this.mPageContext = tbPageContext;
        this.lep = new c(tbPageContext);
        this.lep.c(aaVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.ler = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.lep.ak(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        dgv();
        this.lep.setData(this.leq);
    }

    public void onChangeSkinType() {
        if (this.lep != null) {
            this.lep.onChangeSkinType();
        }
    }

    private void dgv() {
        this.leq = new ArrayList();
        if (this.ler != null && !y.isEmpty(this.ler.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.ler.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aDi = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.leq.add(hVar);
                }
            }
        }
    }
}
