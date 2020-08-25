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
    private c leh;
    private List<q> lei;
    private PersonMoreData lej;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, aa<h> aaVar) {
        this.mPageContext = tbPageContext;
        this.leh = new c(tbPageContext);
        this.leh.c(aaVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.lej = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.leh.ak(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        dgu();
        this.leh.setData(this.lei);
    }

    public void onChangeSkinType() {
        if (this.leh != null) {
            this.leh.onChangeSkinType();
        }
    }

    private void dgu() {
        this.lei = new ArrayList();
        if (this.lej != null && !y.isEmpty(this.lej.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.lej.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aDg = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.lei.add(hVar);
                }
            }
        }
    }
}
