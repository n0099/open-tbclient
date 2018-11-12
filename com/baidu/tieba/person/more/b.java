package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.personCenter.data.PersonMoreData;
import com.baidu.tieba.personCenter.data.PersonMoreItemData;
import com.baidu.tieba.personCenter.data.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private c gkk;
    private List<h> gkl;
    private PersonMoreData gkm;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ad<f> adVar) {
        this.mPageContext = tbPageContext;
        this.gkk = new c(tbPageContext);
        this.gkk.b(adVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.gkm = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(e.h.person_center_more_layout);
        this.gkk.initView(this.mPageContext.getPageActivity().findViewById(e.g.person_more_layout));
        bmG();
        this.gkk.setData(this.gkl);
    }

    public void onChangeSkinType() {
        if (this.gkk != null) {
            this.gkk.onChangeSkinType();
        }
    }

    private void bmG() {
        this.gkl = new ArrayList();
        if (this.gkm != null && !v.I(this.gkm.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.gkm.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    f fVar = new f();
                    fVar.title = personMoreItemData.mName;
                    fVar.type = 36;
                    fVar.akS = personMoreItemData.mUrl;
                    fVar.itemId = personMoreItemData.mId;
                    this.gkl.add(fVar);
                }
            }
        }
    }
}
