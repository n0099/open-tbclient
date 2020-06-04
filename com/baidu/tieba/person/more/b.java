package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.personCenter.c.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b {
    private c klC;
    private List<o> klD;
    private PersonMoreData klE;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, aa<g> aaVar) {
        this.mPageContext = tbPageContext;
        this.klC = new c(tbPageContext);
        this.klC.c(aaVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.klE = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.klC.ag(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        cNp();
        this.klC.setData(this.klD);
    }

    public void onChangeSkinType() {
        if (this.klC != null) {
            this.klC.onChangeSkinType();
        }
    }

    private void cNp() {
        this.klD = new ArrayList();
        if (this.klE != null && !v.isEmpty(this.klE.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.klE.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.auL = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.klD.add(gVar);
                }
            }
        }
    }
}
