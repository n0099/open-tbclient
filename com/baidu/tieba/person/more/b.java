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
    private c kkw;
    private List<o> kkx;
    private PersonMoreData kky;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, aa<g> aaVar) {
        this.mPageContext = tbPageContext;
        this.kkw = new c(tbPageContext);
        this.kkw.c(aaVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.kky = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.kkw.ag(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        cMZ();
        this.kkw.setData(this.kkx);
    }

    public void onChangeSkinType() {
        if (this.kkw != null) {
            this.kkw.onChangeSkinType();
        }
    }

    private void cMZ() {
        this.kkx = new ArrayList();
        if (this.kky != null && !v.isEmpty(this.kky.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.kky.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.auL = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.kkx.add(gVar);
                }
            }
        }
    }
}
