package com.baidu.tieba.person.more;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.personCenter.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    private TbPageContext mPageContext;
    private c mvn;
    private List<n> mvo;
    private PersonMoreData mvp;

    public b(TbPageContext tbPageContext, Bundle bundle, ab<h> abVar) {
        this.mPageContext = tbPageContext;
        this.mvn = new c(tbPageContext);
        this.mvn.c(abVar);
        if (bundle != null && (OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            this.mvp = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
        }
    }

    public void initView() {
        this.mPageContext.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.mvn.am(this.mPageContext.getPageActivity().findViewById(R.id.person_more_layout));
        dwH();
        this.mvn.setData(this.mvo);
    }

    public void onChangeSkinType() {
        if (this.mvn != null) {
            this.mvn.onChangeSkinType();
        }
    }

    private void dwH() {
        this.mvo = new ArrayList();
        if (this.mvp != null && !y.isEmpty(this.mvp.mUrlMaps)) {
            for (PersonMoreItemData personMoreItemData : this.mvp.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.title = personMoreItemData.mName;
                    hVar.type = 36;
                    hVar.aIQ = personMoreItemData.mUrl;
                    hVar.itemId = personMoreItemData.mId;
                    this.mvo.add(hVar);
                }
            }
        }
    }
}
