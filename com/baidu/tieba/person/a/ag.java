package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ThUserActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ag extends c<com.baidu.tieba.person.data.s, com.baidu.tieba.person.b.p> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ag(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ba */
    public com.baidu.tieba.person.b.p b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.p(LayoutInflater.from(this.mContext).inflate(t.h.person_info_togetherhi_user_item, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.s sVar, com.baidu.tieba.person.b.p pVar) {
        if (sVar != null && pVar != null) {
            pVar.aCN();
            String string = this.mContext.getResources().getString(t.j.person_user_togetherhi_him);
            if (sVar.getSex() == 2) {
                string = this.mContext.getResources().getString(t.j.person_user_togetherhi_her);
            }
            pVar.KC.setText(string);
            a(view, sVar);
            pVar.dDL.setClickListener(new a(sVar));
            if (this.bUL) {
                pVar.a(sVar);
                this.bUL = false;
            }
        }
        return view;
    }

    private void a(View view, com.baidu.tieba.person.data.s sVar) {
        view.setOnClickListener(new a(sVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private com.baidu.tieba.person.data.s dyv;

        public a(com.baidu.tieba.person.data.s sVar) {
            this.dyv = sVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bl.ac(ag.this.mContext)) {
                ThUserActivityConfig thUserActivityConfig = new ThUserActivityConfig(ag.this.mContext);
                thUserActivityConfig.initUserActivityConfig(this.dyv.aCs());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thUserActivityConfig));
            }
        }
    }
}
