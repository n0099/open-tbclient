package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class b {
    private TbPageContext mPageContext;
    private c mjp;
    private List<q> mjq;
    private PersonMoreData mjr;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<h> abVar) {
        this.mPageContext = tbPageContext;
        this.mjp = new c(tbPageContext);
        this.mjp.c(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.mjr = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.mjp.an(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        dyj();
        this.mjp.setData(this.mjq);
    }

    public void onChangeSkinType() {
        if (this.mjp != null) {
            this.mjp.onChangeSkinType();
        }
    }

    private void dyj() {
        this.mjq = new ArrayList();
        if (this.mjr != null && !y.isEmpty(this.mjr.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.mjr.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aJj = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.mjq.add(hVar);
                }
            }
        }
    }
}
