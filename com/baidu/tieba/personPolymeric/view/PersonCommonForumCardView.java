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
    private List<com.baidu.tieba.personPolymeric.c.f> gDJ;
    private List<PersonCommonForumItemView> gDK;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> gDL;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.gDK = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.gDJ = list;
        aog();
    }

    private void aog() {
        if (!v.I(this.gDJ)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.gDJ) {
                if (fVar != null) {
                    PersonCommonForumItemView jy = this.gDL.jy();
                    jy.setData(fVar);
                    addView(jy, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.aO(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds88)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds96)) / 2, -2));
                    this.gDK.add(jy);
                }
            }
        }
    }

    public void recycle() {
        if (!v.I(this.gDK)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.gDK) {
                this.gDL.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.gDL = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.gDK) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
