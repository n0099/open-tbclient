package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b {
    private c kFo;
    private List<q> kFp;
    private PersonMoreData kFq;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, aa<h> aaVar) {
        this.mPageContext = tbPageContext;
        this.kFo = new c(tbPageContext);
        this.kFo.c(aaVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.kFq = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.kFo.ag(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        cRH();
        this.kFo.setData(this.kFp);
    }

    public void onChangeSkinType() {
        if (this.kFo != null) {
            this.kFo.onChangeSkinType();
        }
    }

    private void cRH() {
        this.kFp = new ArrayList();
        if (this.kFq != null && !w.isEmpty(this.kFq.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.kFq.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.awR = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.kFp.add(hVar);
                }
            }
        }
    }
}
