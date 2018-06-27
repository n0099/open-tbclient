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
    private c fTQ;
    private List<h> fTR;
    private PersonMoreData fTS;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, ad<e> adVar) {
        this.mPageContext = tbPageContext;
        this.fTQ = new c(tbPageContext);
        this.fTQ.b(adVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.fTS = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(d.i.person_center_more_layout);
        this.fTQ.W(this.mPageContext.getPageActivity().findViewById(d.g.person_more_layout));
        bjl();
        this.fTQ.setData(this.fTR);
    }

    public void onChangeSkinType() {
        if (this.fTQ != null) {
            this.fTQ.onChangeSkinType();
        }
    }

    private void bjl() {
        this.fTR = new ArrayList();
        if (this.fTS != null && !w.A(this.fTS.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.fTS.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    e eVar = new e();
                    eVar.title = personMoreItemData.mName;
                    eVar.type = 36;
                    eVar.adc = personMoreItemData.mUrl;
                    eVar.itemId = personMoreItemData.mId;
                    this.fTR.add(eVar);
                }
            }
        }
    }
}
