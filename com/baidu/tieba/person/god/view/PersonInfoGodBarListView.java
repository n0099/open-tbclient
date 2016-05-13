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
    private final List<a> dAz;
    private int dxF;
    private Context mContext;

    public PersonInfoGodBarListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dAz = new ArrayList();
        this.dxF = k.c(TbadkCoreApplication.m11getInst(), t.e.ds20);
        this.mContext = context;
        setOrientation(1);
    }

    public PersonInfoGodBarListView(Context context) {
        super(context);
        this.dAz = new ArrayList();
        this.dxF = k.c(TbadkCoreApplication.m11getInst(), t.e.ds20);
        this.mContext = context;
        setOrientation(1);
    }

    public void setData(List<ForumGodDetailInfo> list) {
        if (y.r(list) > 0) {
            this.dAz.clear();
            removeAllViews();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                a aCG = aCG();
                ForumGodDetailInfo forumGodDetailInfo = list.get(i);
                if (forumGodDetailInfo != null) {
                    aCG.aJV.setImageDrawable(at.getDrawable(t.f.icon_shen_mine));
                    at.c(aCG.aGp, t.d.cp_cont_f, 1);
                    at.c(aCG.bdq, t.d.cp_cont_c, 1);
                    aCG.aGp.setText(forumGodDetailInfo.forum_name);
                    aCG.bdq.setText(forumGodDetailInfo.intro);
                    if (i < size - 1) {
                        aCG.view.setPadding(0, 0, 0, this.dxF);
                    } else {
                        aCG.view.setPadding(0, 0, 0, 0);
                    }
                    addView(aCG.view);
                    this.dAz.add(aCG);
                }
            }
        }
    }

    private a aCG() {
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.god_bar_list_item, (ViewGroup) null);
        a aVar = new a(null);
        aVar.aJV = (ImageView) inflate.findViewById(t.g.iv_icon);
        aVar.aGp = (TextView) inflate.findViewById(t.g.tv_name);
        aVar.bdq = (TextView) inflate.findViewById(t.g.tv_intro);
        aVar.view = inflate;
        return aVar;
    }

    public void g(TbPageContext<?> tbPageContext) {
        for (a aVar : this.dAz) {
            if (aVar != null) {
                at.c(aVar.aGp, t.d.cp_cont_f, 1);
                at.c(aVar.bdq, t.d.cp_cont_c, 1);
                aVar.aJV.setImageDrawable(at.getDrawable(t.f.icon_shen_mine));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public TextView aGp;
        public ImageView aJV;
        public TextView bdq;
        public View view;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
