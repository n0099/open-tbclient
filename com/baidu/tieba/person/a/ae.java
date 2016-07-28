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
import com.baidu.tbadk.core.util.bn;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.a.a<com.baidu.tieba.person.data.r, com.baidu.tieba.person.holder.p> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ae(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bP */
    public com.baidu.tieba.person.holder.p a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.p(LayoutInflater.from(this.mContext).inflate(u.h.person_info_togetherhi_user_item, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.r rVar, com.baidu.tieba.person.holder.p pVar) {
        if (rVar != null && pVar != null) {
            pVar.aOp();
            String string = this.mContext.getResources().getString(u.j.person_user_togetherhi_him);
            if (rVar.getSex() == 2) {
                string = this.mContext.getResources().getString(u.j.person_user_togetherhi_her);
            }
            pVar.KB.setText(string);
            a(view, rVar);
            pVar.ewW.setClickListener(new a(rVar));
            if (this.aNz) {
                pVar.a(rVar);
                this.aNz = false;
            }
        }
        return view;
    }

    private void a(View view, com.baidu.tieba.person.data.r rVar) {
        view.setOnClickListener(new a(rVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private com.baidu.tieba.person.data.r eqQ;

        public a(com.baidu.tieba.person.data.r rVar) {
            this.eqQ = rVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bn.ab(ae.this.mContext)) {
                ThUserActivityConfig thUserActivityConfig = new ThUserActivityConfig(ae.this.mContext);
                thUserActivityConfig.initUserActivityConfig(this.eqQ.aNR());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thUserActivityConfig));
            }
        }
    }
}
