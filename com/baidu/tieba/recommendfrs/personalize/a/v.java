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
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.recommendfrs.data.i, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public v(Context context) {
        super(context, com.baidu.tieba.recommendfrs.data.i.dZU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bA */
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
        aVar.onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        if (iVar != null && iVar.dZW != null) {
            bx.Ki().a(new aw("c10985").ac("obj_name", iVar.dZW));
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.recommendfrs.data.i iVar) {
        if (iVar != null && iVar.dZV != null && iVar.dZV.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.recommendfrs.data.j jVar : iVar.dZV) {
                if (jVar != null && jVar.dZY && !StringUtils.isNull(jVar.dZX)) {
                    arrayList.add(jVar.dZX);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        private int aej;
        private TextView ebB;
        private View ebC;
        private GridView ebD;
        private u ebE;
        private AdapterView.OnItemClickListener ebF;

        public a(View view) {
            super(view);
            this.aej = 3;
            this.ebE = new u();
            this.ebF = new w(this);
            this.ebB = (TextView) view.findViewById(t.g.interest_guide_tip);
            this.ebC = view.findViewById(t.g.interest_guide_close);
            this.ebD = (GridView) view.findViewById(t.g.interest_guide_tags_layout);
            this.ebD.setAdapter((ListAdapter) this.ebE);
            this.ebD.setOnItemClickListener(this.ebF);
            this.ebC.setOnClickListener(new x(this));
        }

        protected void onChangeSkinType(int i) {
            if (this.aej != i) {
                at.l(getView(), t.d.cp_bg_line_d);
                at.j((View) this.ebB, t.d.cp_cont_d);
                at.k(this.ebC, t.f.icon_x_normal);
            }
        }

        protected void c(com.baidu.tieba.recommendfrs.data.i iVar) {
            this.ebE.a(iVar);
        }
    }
}
