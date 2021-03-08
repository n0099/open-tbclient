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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eWx;
    private d luP;
    private InterfaceC0804a luV;
    private View.OnClickListener luW = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dgs();
        }
    };
    private View.OnClickListener fnL = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailData dgj;
            if (view != null && view.getTag() != null && (dgj = ((c) view.getTag()).dgj()) != null && !a.this.luP.dgw()) {
                a.this.m(dgj.getId(), dgj.getContent(), dgj.getFontColor());
            }
        }
    };
    private View.OnClickListener luX = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar;
            if (view != null && (cVar = (c) view.getTag()) != null && cVar.dgj() != null) {
                a.this.luP.EK(cVar.dgj().getId());
            }
        }
    };
    private com.baidu.tieba.memberCenter.tail.a.a<Void> luY = new com.baidu.tieba.memberCenter.tail.a.a<Void>() { // from class: com.baidu.tieba.memberCenter.tail.management.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Void r5) {
            if (z) {
                a.this.eWx.showToast(str);
            } else {
                a.this.setData(a.this.luP.getTails());
            }
        }
    };
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> luZ = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.management.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            if (z) {
                a.this.eWx.showToast(str);
                return;
            }
            TailData tailData = new TailData();
            tailData.setId(num.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_REFRESH, new com.baidu.tieba.memberCenter.tail.data.e(3, tailData)));
        }
    };
    private List<Object> luU = new ArrayList();

    /* renamed from: com.baidu.tieba.memberCenter.tail.management.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0804a {
        void dgr();
    }

    public a(TbPageContext<?> tbPageContext, d dVar, InterfaceC0804a interfaceC0804a) {
        this.eWx = tbPageContext;
        this.luP = dVar;
        this.luP.c(this.luY);
        this.luP.d(this.luZ);
        this.luV = interfaceC0804a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str, String str2) {
        this.eWx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.eWx.getPageActivity(), i, str, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgs() {
        this.eWx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.eWx.getPageActivity(), this.luP.getTails().isEmpty())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<TailData> list) {
        this.luP.eT(list);
        refresh();
    }

    public void refresh() {
        dgt();
        notifyDataSetChanged();
    }

    private void dgt() {
        if (this.luV != null) {
            this.luV.dgr();
        }
        this.luU.clear();
        this.luU.addAll(this.luP.getTails());
        if (!this.luP.dgw()) {
            this.luU.add(new com.baidu.tieba.memberCenter.tail.data.a(this.luP.dgv()));
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.luU.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object obj = this.luU.get(i);
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
            view = bVar.gA(this.eWx.getPageActivity());
            bVar.J(this.luW);
            bVar.D(this.eWx);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.EJ(this.luP.dgv());
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
            view = cVar.gA(this.eWx.getPageActivity());
            cVar.K(this.fnL);
            cVar.L(this.luX);
            cVar.D(this.eWx);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.b(tailData);
        cVar.o(Boolean.valueOf(this.luP.dgw()));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.luU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
