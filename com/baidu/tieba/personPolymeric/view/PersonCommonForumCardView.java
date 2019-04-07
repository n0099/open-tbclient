package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> hTv;
    private List<PersonCommonForumItemView> hTw;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> hTx;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.hTw = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.hTv = list;
        aOO();
    }

    private void aOO() {
        if (!v.T(this.hTv)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.hTv) {
                if (fVar != null) {
                    PersonCommonForumItemView jA = this.hTx.jA();
                    jA.setData(fVar);
                    addView(jA, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.aO(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds88)) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds96)) / 2, -2));
                    this.hTw.add(jA);
                }
            }
        }
    }

    public void recycle() {
        if (!v.T(this.hTw)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.hTw) {
                this.hTx.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.hTx = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.hTw) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
