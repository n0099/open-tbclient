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
    private d lsM;
    private InterfaceC0798a lsS;
    private View.OnClickListener lsT = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dgj();
        }
    };
    private View.OnClickListener fml = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailData dga;
            if (view != null && view.getTag() != null && (dga = ((c) view.getTag()).dga()) != null && !a.this.lsM.dgn()) {
                a.this.m(dga.getId(), dga.getContent(), dga.getFontColor());
            }
        }
    };
    private View.OnClickListener lsU = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar;
            if (view != null && (cVar = (c) view.getTag()) != null && cVar.dga() != null) {
                a.this.lsM.EH(cVar.dga().getId());
            }
        }
    };
    private com.baidu.tieba.memberCenter.tail.a.a<Void> lsV = new com.baidu.tieba.memberCenter.tail.a.a<Void>() { // from class: com.baidu.tieba.memberCenter.tail.management.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Void r5) {
            if (z) {
                a.this.eUY.showToast(str);
            } else {
                a.this.setData(a.this.lsM.getTails());
            }
        }
    };
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lsW = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.management.a.5
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
    private List<Object> lsR = new ArrayList();

    /* renamed from: com.baidu.tieba.memberCenter.tail.management.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0798a {
        void dgi();
    }

    public a(TbPageContext<?> tbPageContext, d dVar, InterfaceC0798a interfaceC0798a) {
        this.eUY = tbPageContext;
        this.lsM = dVar;
        this.lsM.c(this.lsV);
        this.lsM.d(this.lsW);
        this.lsS = interfaceC0798a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str, String str2) {
        this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.eUY.getPageActivity(), i, str, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgj() {
        this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.eUY.getPageActivity(), this.lsM.getTails().isEmpty())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<TailData> list) {
        this.lsM.eT(list);
        refresh();
    }

    public void refresh() {
        dgk();
        notifyDataSetChanged();
    }

    private void dgk() {
        if (this.lsS != null) {
            this.lsS.dgi();
        }
        this.lsR.clear();
        this.lsR.addAll(this.lsM.getTails());
        if (!this.lsM.dgn()) {
            this.lsR.add(new com.baidu.tieba.memberCenter.tail.data.a(this.lsM.dgm()));
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.lsR.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object obj = this.lsR.get(i);
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
            bVar.I(this.lsT);
            bVar.D(this.eUY);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.EG(this.lsM.dgm());
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
            cVar.K(this.lsU);
            cVar.D(this.eUY);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.b(tailData);
        cVar.o(Boolean.valueOf(this.lsM.dgn()));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.lsR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
