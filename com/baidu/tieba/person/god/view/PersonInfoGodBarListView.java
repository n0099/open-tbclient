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
    private int eqc;
    private final List<a> etk;
    private Context mContext;

    public PersonInfoGodBarListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etk = new ArrayList();
        this.eqc = k.c(TbadkCoreApplication.m10getInst(), u.e.ds20);
        this.mContext = context;
        setOrientation(1);
    }

    public PersonInfoGodBarListView(Context context) {
        super(context);
        this.etk = new ArrayList();
        this.eqc = k.c(TbadkCoreApplication.m10getInst(), u.e.ds20);
        this.mContext = context;
        setOrientation(1);
    }

    public void setData(List<ForumGodDetailInfo> list) {
        if (y.s(list) > 0) {
            this.etk.clear();
            removeAllViews();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                a aOd = aOd();
                ForumGodDetailInfo forumGodDetailInfo = list.get(i);
                if (forumGodDetailInfo != null) {
                    aOd.aOn.setImageDrawable(av.getDrawable(u.f.icon_shen_mine));
                    av.c(aOd.aHI, u.d.cp_cont_f, 1);
                    av.c(aOd.bBH, u.d.cp_cont_c, 1);
                    aOd.aHI.setText(forumGodDetailInfo.forum_name);
                    aOd.bBH.setText(forumGodDetailInfo.intro);
                    if (i < size - 1) {
                        aOd.view.setPadding(0, 0, 0, this.eqc);
                    } else {
                        aOd.view.setPadding(0, 0, 0, 0);
                    }
                    addView(aOd.view);
                    this.etk.add(aOd);
                }
            }
        }
    }

    private a aOd() {
        View inflate = LayoutInflater.from(this.mContext).inflate(u.h.god_bar_list_item, (ViewGroup) null);
        a aVar = new a(null);
        aVar.aOn = (ImageView) inflate.findViewById(u.g.iv_icon);
        aVar.aHI = (TextView) inflate.findViewById(u.g.tv_name);
        aVar.bBH = (TextView) inflate.findViewById(u.g.tv_intro);
        aVar.view = inflate;
        return aVar;
    }

    public void n(TbPageContext<?> tbPageContext) {
        for (a aVar : this.etk) {
            if (aVar != null) {
                av.c(aVar.aHI, u.d.cp_cont_f, 1);
                av.c(aVar.bBH, u.d.cp_cont_c, 1);
                aVar.aOn.setImageDrawable(av.getDrawable(u.f.icon_shen_mine));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public TextView aHI;
        public ImageView aOn;
        public TextView bBH;
        public View view;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
