package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.PersonMoreData;
import com.baidu.tieba.personCenter.data.PersonMoreItemData;
import com.baidu.tieba.personCenter.data.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private c fUd;
    private List<h> fUe;
    private PersonMoreData fUf;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ad<e> adVar) {
        this.mPageContext = tbPageContext;
        this.fUd = new c(tbPageContext);
        this.fUd.b(adVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.fUf = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(d.h.person_center_more_layout);
        this.fUd.Y(this.mPageContext.getPageActivity().findViewById(d.g.person_more_layout));
        bhE();
        this.fUd.setData(this.fUe);
    }

    public void onChangeSkinType() {
        if (this.fUd != null) {
            this.fUd.onChangeSkinType();
        }
    }

    private void bhE() {
        this.fUe = new ArrayList();
        if (this.fUf != null && !w.z(this.fUf.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.fUf.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    e eVar = new e();
                    eVar.title = personMoreItemData.mName;
                    eVar.type = 36;
                    eVar.acG = personMoreItemData.mUrl;
                    eVar.itemId = personMoreItemData.mId;
                    this.fUe.add(eVar);
                }
            }
        }
    }
}
