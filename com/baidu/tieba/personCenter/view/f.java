package com.baidu.tieba.personCenter.view;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.PersonMoreData;
import com.baidu.tieba.personCenter.data.PersonMoreItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private PersonMoreData fiB;
    private g fjw;
    private List<com.baidu.adp.widget.ListView.f> fjx;
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.fjw = new g(tbPageContext);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.fiB = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(d.h.person_center_more_layout);
        this.fjw.Z(this.mPageContext.getPageActivity().findViewById(d.g.person_more_layout));
        aYu();
        this.fjw.setData(this.fjx);
    }

    private void aYu() {
        this.fjx = new ArrayList();
        if (this.fiB != null && !v.v(this.fiB.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.fiB.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    com.baidu.tieba.personCenter.data.e eVar = new com.baidu.tieba.personCenter.data.e();
                    eVar.title = personMoreItemData.mName;
                    eVar.type = 37;
                    eVar.dac = personMoreItemData.mUrl;
                    eVar.itemId = personMoreItemData.mId;
                    this.fjx.add(eVar);
                }
            }
        }
    }
}
