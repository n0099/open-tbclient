package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> imj;
    private List<PersonCommonForumItemView> imk;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> iml;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.imk = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.imj = list;
        aUY();
    }

    private void aUY() {
        if (!v.aa(this.imj)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.imj) {
                if (fVar != null) {
                    PersonCommonForumItemView iu = this.iml.iu();
                    iu.setData(fVar);
                    addView(iu, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.af(this.mContext) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.imk.add(iu);
                }
            }
        }
    }

    public void recycle() {
        if (!v.aa(this.imk)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.imk) {
                this.iml.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.iml = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.imk) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
