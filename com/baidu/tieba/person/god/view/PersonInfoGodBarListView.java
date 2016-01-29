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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
/* loaded from: classes.dex */
public class PersonInfoGodBarListView extends LinearLayout {
    private int daf;
    private final List<a> dcR;
    private Context mContext;

    public PersonInfoGodBarListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dcR = new ArrayList();
        this.daf = k.c(TbadkCoreApplication.m411getInst(), t.e.ds20);
        this.mContext = context;
        setOrientation(1);
    }

    public PersonInfoGodBarListView(Context context) {
        super(context);
        this.dcR = new ArrayList();
        this.daf = k.c(TbadkCoreApplication.m411getInst(), t.e.ds20);
        this.mContext = context;
        setOrientation(1);
    }

    public void setData(List<ForumGodDetailInfo> list) {
        if (x.o(list) > 0) {
            this.dcR.clear();
            removeAllViews();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                a auG = auG();
                ForumGodDetailInfo forumGodDetailInfo = list.get(i);
                if (forumGodDetailInfo != null) {
                    auG.aKP.setImageDrawable(ar.getDrawable(t.f.icon_shen_mine));
                    ar.b(auG.aHk, t.d.cp_cont_f, 1);
                    ar.b(auG.bcP, t.d.cp_cont_c, 1);
                    auG.aHk.setText(forumGodDetailInfo.forum_name);
                    auG.bcP.setText(forumGodDetailInfo.intro);
                    if (i < size - 1) {
                        auG.view.setPadding(0, 0, 0, this.daf);
                    } else {
                        auG.view.setPadding(0, 0, 0, 0);
                    }
                    addView(auG.view);
                    this.dcR.add(auG);
                }
            }
        }
    }

    private a auG() {
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.god_bar_list_item, (ViewGroup) null);
        a aVar = new a(null);
        aVar.aKP = (ImageView) inflate.findViewById(t.g.iv_icon);
        aVar.aHk = (TextView) inflate.findViewById(t.g.tv_name);
        aVar.bcP = (TextView) inflate.findViewById(t.g.tv_intro);
        aVar.view = inflate;
        return aVar;
    }

    public void f(TbPageContext<?> tbPageContext) {
        for (a aVar : this.dcR) {
            if (aVar != null) {
                ar.b(aVar.aHk, t.d.cp_cont_f, 1);
                ar.b(aVar.bcP, t.d.cp_cont_c, 1);
                aVar.aKP.setImageDrawable(ar.getDrawable(t.f.icon_shen_mine));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public TextView aHk;
        public ImageView aKP;
        public TextView bcP;
        public View view;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
