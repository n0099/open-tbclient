package com.baidu.tieba.memberCenter.tail.management;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eUY;
    private InterfaceC0797a lsE;
    private d lsy;
    private View.OnClickListener lsF = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dgc();
        }
    };
    private View.OnClickListener fml = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailData dfT;
            if (view != null && view.getTag() != null && (dfT = ((c) view.getTag()).dfT()) != null && !a.this.lsy.dgg()) {
                a.this.m(dfT.getId(), dfT.getContent(), dfT.getFontColor());
            }
        }
    };
    private View.OnClickListener lsG = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar;
            if (view != null && (cVar = (c) view.getTag()) != null && cVar.dfT() != null) {
                a.this.lsy.EH(cVar.dfT().getId());
            }
        }
    };
    private com.baidu.tieba.memberCenter.tail.a.a<Void> lsH = new com.baidu.tieba.memberCenter.tail.a.a<Void>() { // from class: com.baidu.tieba.memberCenter.tail.management.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Void r5) {
            if (z) {
                a.this.eUY.showToast(str);
            } else {
                a.this.setData(a.this.lsy.getTails());
            }
        }
    };
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lsI = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.management.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            if (z) {
                a.this.eUY.showToast(str);
                return;
            }
            TailData tailData = new TailData();
            tailData.setId(num.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_REFRESH, new com.baidu.tieba.memberCenter.tail.data.e(3, tailData)));
        }
    };
    private List<Object> lsD = new ArrayList();

    /* renamed from: com.baidu.tieba.memberCenter.tail.management.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0797a {
        void dgb();
    }

    public a(TbPageContext<?> tbPageContext, d dVar, InterfaceC0797a interfaceC0797a) {
        this.eUY = tbPageContext;
        this.lsy = dVar;
        this.lsy.c(this.lsH);
        this.lsy.d(this.lsI);
        this.lsE = interfaceC0797a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str, String str2) {
        this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.eUY.getPageActivity(), i, str, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgc() {
        this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.eUY.getPageActivity(), this.lsy.getTails().isEmpty())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<TailData> list) {
        this.lsy.eT(list);
        refresh();
    }

    public void refresh() {
        dgd();
        notifyDataSetChanged();
    }

    private void dgd() {
        if (this.lsE != null) {
            this.lsE.dgb();
        }
        this.lsD.clear();
        this.lsD.addAll(this.lsy.getTails());
        if (!this.lsy.dgg()) {
            this.lsD.add(new com.baidu.tieba.memberCenter.tail.data.a(this.lsy.dgf()));
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.lsD.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object obj = this.lsD.get(i);
        if (obj instanceof TailData) {
            return 0;
        }
        if (obj instanceof com.baidu.tieba.memberCenter.tail.data.a) {
            return 1;
        }
        return -1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) == 0) {
            return a(getItem(i), view);
        }
        if (getItemViewType(i) == 1) {
            return dx(view);
        }
        return null;
    }

    private View dx(View view) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = bVar.gB(this.eUY.getPageActivity());
            bVar.I(this.lsF);
            bVar.D(this.eUY);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.EG(this.lsy.dgf());
        return view;
    }

    private View a(Object obj, View view) {
        c cVar;
        if (obj == null || !(obj instanceof TailData)) {
            return null;
        }
        TailData tailData = (TailData) obj;
        if (view == null) {
            cVar = new c();
            view = cVar.gB(this.eUY.getPageActivity());
            cVar.J(this.fml);
            cVar.K(this.lsG);
            cVar.D(this.eUY);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.b(tailData);
        cVar.o(Boolean.valueOf(this.lsy.dgg()));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.lsD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
