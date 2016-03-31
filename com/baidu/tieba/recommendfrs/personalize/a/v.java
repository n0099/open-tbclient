package com.baidu.tieba.recommendfrs.personalize.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.recommendfrs.data.i, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public v(Context context) {
        super(context, com.baidu.tieba.recommendfrs.data.i.dWK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public a b(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), t.h.interest_guide, null);
        a aVar = new a(inflate);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendfrs.data.i iVar, a aVar) {
        aVar.c(iVar);
        aVar.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (iVar != null && iVar.dWM != null) {
            cf.Lx().a(new aw("c10985").ac("obj_name", iVar.dWM));
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.recommendfrs.data.i iVar) {
        if (iVar != null && iVar.dWL != null && iVar.dWL.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.recommendfrs.data.j jVar : iVar.dWL) {
                if (jVar != null && jVar.dWO && !StringUtils.isNull(jVar.dWN)) {
                    arrayList.add(jVar.dWN);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
        }
    }

    /* loaded from: classes.dex */
    public class a extends x.a {
        private int aik;
        private TextView dYu;
        private View dYv;
        private GridView dYw;
        private u dYx;
        private AdapterView.OnItemClickListener dYy;

        public a(View view) {
            super(view);
            this.aik = 3;
            this.dYx = new u();
            this.dYy = new w(this);
            this.dYu = (TextView) view.findViewById(t.g.interest_guide_tip);
            this.dYv = view.findViewById(t.g.interest_guide_close);
            this.dYw = (GridView) view.findViewById(t.g.interest_guide_tags_layout);
            this.dYw.setAdapter((ListAdapter) this.dYx);
            this.dYw.setOnItemClickListener(this.dYy);
            this.dYv.setOnClickListener(new x(this));
        }

        protected void onChangeSkinType(int i) {
            if (this.aik != i) {
                at.l(getView(), t.d.cp_bg_line_d);
                at.j((View) this.dYu, t.d.cp_cont_d);
                at.k(this.dYv, t.f.icon_x_normal);
            }
        }

        protected void c(com.baidu.tieba.recommendfrs.data.i iVar) {
            this.dYx.a(iVar);
        }
    }
}
