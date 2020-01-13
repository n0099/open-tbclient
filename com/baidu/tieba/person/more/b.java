package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.personCenter.data.PersonMoreData;
import com.baidu.tieba.personCenter.data.PersonMoreItemData;
import com.baidu.tieba.personCenter.data.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private c jfE;
    private List<m> jfF;
    private PersonMoreData jfG;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, Bundle bundle, z<g> zVar) {
        this.mPageContext = tbPageContext;
        this.jfE = new c(tbPageContext);
        this.jfE.c(zVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.jfG = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.jfE.initView(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        ctE();
        this.jfE.setData(this.jfF);
    }

    public void onChangeSkinType() {
        if (this.jfE != null) {
            this.jfE.onChangeSkinType();
        }
    }

    private void ctE() {
        this.jfF = new ArrayList();
        if (this.jfG != null && !v.isEmpty(this.jfG.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.jfG.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    g gVar = new g();
                    gVar.title = personMoreItemData.mName;
                    gVar.type = 36;
                    gVar.cHN = personMoreItemData.mUrl;
                    gVar.itemId = personMoreItemData.mId;
                    this.jfF.add(gVar);
                }
            }
        }
    }
}
