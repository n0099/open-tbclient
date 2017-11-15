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
    private PersonMoreData fiY;
    private g fjT;
    private List<com.baidu.adp.widget.ListView.f> fjU;
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.fjT = new g(tbPageContext);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.fiY = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(d.h.person_center_more_layout);
        this.fjT.Z(this.mPageContext.getPageActivity().findViewById(d.g.person_more_layout));
        aYC();
        this.fjT.setData(this.fjU);
    }

    private void aYC() {
        this.fjU = new ArrayList();
        if (this.fiY != null && !v.v(this.fiY.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.fiY.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    com.baidu.tieba.personCenter.data.e eVar = new com.baidu.tieba.personCenter.data.e();
                    eVar.title = personMoreItemData.mName;
                    eVar.type = 37;
                    eVar.dax = personMoreItemData.mUrl;
                    eVar.itemId = personMoreItemData.mId;
                    this.fjU.add(eVar);
                }
            }
        }
    }
}
