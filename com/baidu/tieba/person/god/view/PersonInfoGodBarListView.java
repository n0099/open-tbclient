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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
/* loaded from: classes.dex */
public class PersonInfoGodBarListView extends LinearLayout {
    private int egb;
    private final List<a> ejf;
    private Context mContext;

    public PersonInfoGodBarListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ejf = new ArrayList();
        this.egb = k.c(TbadkCoreApplication.m9getInst(), u.e.ds20);
        this.mContext = context;
        setOrientation(1);
    }

    public PersonInfoGodBarListView(Context context) {
        super(context);
        this.ejf = new ArrayList();
        this.egb = k.c(TbadkCoreApplication.m9getInst(), u.e.ds20);
        this.mContext = context;
        setOrientation(1);
    }

    public void setData(List<ForumGodDetailInfo> list) {
        if (y.s(list) > 0) {
            this.ejf.clear();
            removeAllViews();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                a aLA = aLA();
                ForumGodDetailInfo forumGodDetailInfo = list.get(i);
                if (forumGodDetailInfo != null) {
                    aLA.aNt.setImageDrawable(av.getDrawable(u.f.icon_shen_mine));
                    av.c(aLA.aGR, u.d.cp_cont_f, 1);
                    av.c(aLA.bzt, u.d.cp_cont_c, 1);
                    aLA.aGR.setText(forumGodDetailInfo.forum_name);
                    aLA.bzt.setText(forumGodDetailInfo.intro);
                    if (i < size - 1) {
                        aLA.view.setPadding(0, 0, 0, this.egb);
                    } else {
                        aLA.view.setPadding(0, 0, 0, 0);
                    }
                    addView(aLA.view);
                    this.ejf.add(aLA);
                }
            }
        }
    }

    private a aLA() {
        View inflate = LayoutInflater.from(this.mContext).inflate(u.h.god_bar_list_item, (ViewGroup) null);
        a aVar = new a(null);
        aVar.aNt = (ImageView) inflate.findViewById(u.g.iv_icon);
        aVar.aGR = (TextView) inflate.findViewById(u.g.tv_name);
        aVar.bzt = (TextView) inflate.findViewById(u.g.tv_intro);
        aVar.view = inflate;
        return aVar;
    }

    public void n(TbPageContext<?> tbPageContext) {
        for (a aVar : this.ejf) {
            if (aVar != null) {
                av.c(aVar.aGR, u.d.cp_cont_f, 1);
                av.c(aVar.bzt, u.d.cp_cont_c, 1);
                aVar.aNt.setImageDrawable(av.getDrawable(u.f.icon_shen_mine));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public TextView aGR;
        public ImageView aNt;
        public TextView bzt;
        public View view;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
