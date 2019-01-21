package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> gDK;
    private List<PersonCommonForumItemView> gDL;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> gDM;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.gDL = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.gDK = list;
        aog();
    }

    private void aog() {
        if (!v.I(this.gDK)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.gDK) {
                if (fVar != null) {
                    PersonCommonForumItemView jy = this.gDM.jy();
                    jy.setData(fVar);
                    addView(jy, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.aO(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds88)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds96)) / 2, -2));
                    this.gDL.add(jy);
                }
            }
        }
    }

    public void recycle() {
        if (!v.I(this.gDL)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.gDL) {
                this.gDM.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.gDM = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.gDL) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
