package com.baidu.tieba.memberCenter.tail.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.base.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TailManagementActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailDataList;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private View.OnClickListener lsF;
    private g ltd;
    private Context mContext;
    private View.OnClickListener lte = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.tool.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailManagementActivityConfig tailManagementActivityConfig = new TailManagementActivityConfig(view.getContext());
            tailManagementActivityConfig.getIntent().putExtra("list", new TailDataList(b.this.ltd.getTails()));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tailManagementActivityConfig));
        }
    };
    private View.OnClickListener ltf = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.tool.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.mContext, 1, false, 6);
            memberPayActivityConfig.setSceneId("4009001001");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_TAILS_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }
    };
    private View.OnClickListener fml = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.tool.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null) {
                if (!b.this.ltd.dgq()) {
                    b.this.On(b.this.mContext.getString(R.string.become_member_to_use));
                    return;
                }
                TailData dfT = ((e) view.getTag()).dfT();
                b.this.ltd.ab(dfT.getId(), !dfT.isSelected());
            }
        }
    };
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> ltg = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.tool.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            if (z) {
                l.showToast(b.this.mContext, str);
            } else if (num != null && b.this.ltd.getTails() != null && b.this.ltd.getTails().size() != 0) {
                for (TailData tailData : b.this.ltd.getTails()) {
                    if (tailData.getId() == num.intValue()) {
                        tailData.setSelected(!tailData.isSelected());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT, Boolean.valueOf(tailData.isSelected())));
                    } else {
                        tailData.setSelected(false);
                    }
                }
                b.this.notifyDataSetChanged();
            }
        }
    };
    private com.baidu.tieba.memberCenter.tail.a.a<Void> lsH = new com.baidu.tieba.memberCenter.tail.a.a<Void>() { // from class: com.baidu.tieba.memberCenter.tail.tool.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Void r4) {
            if (z) {
                l.showToast(b.this.mContext, str);
            } else {
                b.this.notifyDataSetChanged();
            }
        }
    };

    public b(Context context, g gVar, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.lsF = onClickListener;
        this.ltd = gVar;
        this.ltd.f(this.ltg);
        this.ltd.e(this.lsH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void On(String str) {
        com.baidu.adp.base.f<?> K = j.K(this.mContext);
        if (K != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(K.getPageActivity());
            aVar.ny(R.color.CAM_X0305);
            aVar.Au(str).b(this.mContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.memberCenter.tail.tool.b.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            }).a(this.mContext.getString(R.string.open_now), new a.b() { // from class: com.baidu.tieba.memberCenter.tail.tool.b.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.mContext, 1, false, 6);
                    memberPayActivityConfig.setSceneId("4009001001");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_TAILS_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            }).b(K).bqx();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ltd.getTails().size() + 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.ltd.getTails().size() == 0) {
            return 2;
        }
        if (i == this.ltd.getTails().size()) {
            return 1;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: EI */
    public TailData getItem(int i) {
        if (i >= this.ltd.getTails().size()) {
            return null;
        }
        return this.ltd.getTails().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) == 0) {
            return a(getItem(i), view);
        }
        if (getItemViewType(i) == 1) {
            return dz(view);
        }
        if (getItemViewType(i) == 2) {
            return dx(view);
        }
        if (getItemViewType(i) == 3) {
            return dy(view);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    private View dy(View view) {
        if (view == null || !(view.getTag() instanceof f)) {
            f fVar = new f();
            View gB = fVar.gB(this.mContext);
            fVar.N(this.ltf);
            fVar.onChangeSkinType();
            return gB;
        }
        return view;
    }

    private View dx(View view) {
        c cVar;
        if (view == null || !(view.getTag() instanceof c)) {
            cVar = new c();
            view = cVar.gB(this.mContext);
            cVar.I(this.lsF);
            cVar.onChangeSkinType();
        } else {
            cVar = (c) view.getTag();
        }
        cVar.EG(3);
        return view;
    }

    private View dz(View view) {
        if (view == null || !(view.getTag() instanceof d)) {
            d dVar = new d();
            View gB = dVar.gB(this.mContext);
            dVar.L(this.lte);
            dVar.onChangeSkinType();
            return gB;
        }
        return view;
    }

    private View a(TailData tailData, View view) {
        e eVar;
        if (tailData == null) {
            return null;
        }
        if (view == null || !(view.getTag() instanceof e)) {
            eVar = new e();
            view = eVar.gB(this.mContext);
            eVar.M(this.fml);
            eVar.onChangeSkinType();
        } else {
            eVar = (e) view.getTag();
        }
        eVar.b(tailData);
        eVar.a(tailData);
        return view;
    }
}
