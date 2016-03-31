package com.baidu.tieba.person.god.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
/* loaded from: classes.dex */
public class PersonInfoGodBarListView extends LinearLayout {
    private int duJ;
    private final List<a> dxt;
    private Context mContext;

    public PersonInfoGodBarListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dxt = new ArrayList();
        this.duJ = k.c(TbadkCoreApplication.m411getInst(), t.e.ds20);
        this.mContext = context;
        setOrientation(1);
    }

    public PersonInfoGodBarListView(Context context) {
        super(context);
        this.dxt = new ArrayList();
        this.duJ = k.c(TbadkCoreApplication.m411getInst(), t.e.ds20);
        this.mContext = context;
        setOrientation(1);
    }

    public void setData(List<ForumGodDetailInfo> list) {
        if (y.p(list) > 0) {
            this.dxt.clear();
            removeAllViews();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                a aCm = aCm();
                ForumGodDetailInfo forumGodDetailInfo = list.get(i);
                if (forumGodDetailInfo != null) {
                    aCm.aNL.setImageDrawable(at.getDrawable(t.f.icon_shen_mine));
                    at.b(aCm.aKg, t.d.cp_cont_f, 1);
                    at.b(aCm.bhA, t.d.cp_cont_c, 1);
                    aCm.aKg.setText(forumGodDetailInfo.forum_name);
                    aCm.bhA.setText(forumGodDetailInfo.intro);
                    if (i < size - 1) {
                        aCm.view.setPadding(0, 0, 0, this.duJ);
                    } else {
                        aCm.view.setPadding(0, 0, 0, 0);
                    }
                    addView(aCm.view);
                    this.dxt.add(aCm);
                }
            }
        }
    }

    private a aCm() {
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.god_bar_list_item, (ViewGroup) null);
        a aVar = new a(null);
        aVar.aNL = (ImageView) inflate.findViewById(t.g.iv_icon);
        aVar.aKg = (TextView) inflate.findViewById(t.g.tv_name);
        aVar.bhA = (TextView) inflate.findViewById(t.g.tv_intro);
        aVar.view = inflate;
        return aVar;
    }

    public void f(TbPageContext<?> tbPageContext) {
        for (a aVar : this.dxt) {
            if (aVar != null) {
                at.b(aVar.aKg, t.d.cp_cont_f, 1);
                at.b(aVar.bhA, t.d.cp_cont_c, 1);
                aVar.aNL.setImageDrawable(at.getDrawable(t.f.icon_shen_mine));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public TextView aKg;
        public ImageView aNL;
        public TextView bhA;
        public View view;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
