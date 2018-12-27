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
    private c gtR;
    private List<h> gtS;
    private PersonMoreData gtT;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ad<f> adVar) {
        this.mPageContext = tbPageContext;
        this.gtR = new c(tbPageContext);
        this.gtR.b(adVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.gtT = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(e.h.person_center_more_layout);
        this.gtR.initView(this.mPageContext.getPageActivity().findViewById(e.g.person_more_layout));
        bpk();
        this.gtR.setData(this.gtS);
    }

    public void onChangeSkinType() {
        if (this.gtR != null) {
            this.gtR.onChangeSkinType();
        }
    }

    private void bpk() {
        this.gtS = new ArrayList();
        if (this.gtT != null && !v.I(this.gtT.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.gtT.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    f fVar = new f();
                    fVar.title = personMoreItemData.mName;
                    fVar.type = 36;
                    fVar.aou = personMoreItemData.mUrl;
                    fVar.itemId = personMoreItemData.mId;
                    this.gtS.add(fVar);
                }
            }
        }
    }
}
