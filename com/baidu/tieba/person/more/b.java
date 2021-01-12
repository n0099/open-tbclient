package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    private TbPageContext mPageContext;
    private c mjU;
    private List<n> mjV;
    private PersonMoreData mjW;

    public b(TbPageContext tbPageContext, Bundle bundle, aa<h> aaVar) {
        this.mPageContext = tbPageContext;
        this.mjU = new c(tbPageContext);
        this.mjU.c(aaVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.mjW = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.mjU.ap(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        dui();
        this.mjU.setData(this.mjV);
    }

    public void onChangeSkinType() {
        if (this.mjU != null) {
            this.mjU.onChangeSkinType();
        }
    }

    private void dui() {
        this.mjV = new ArrayList();
        if (this.mjW != null && !x.isEmpty(this.mjW.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.mjW.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aEU = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.mjV.add(hVar);
                }
            }
        }
    }
}
