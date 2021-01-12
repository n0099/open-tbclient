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
    private TbPageContext<?> eSJ;
    private d lks;
    private InterfaceC0795a lky;
    private View.OnClickListener lkz = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dec();
        }
    };
    private View.OnClickListener fjU = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailData ddT;
            if (view != null && view.getTag() != null && (ddT = ((c) view.getTag()).ddT()) != null && !a.this.lks.deg()) {
                a.this.m(ddT.getId(), ddT.getContent(), ddT.getFontColor());
            }
        }
    };
    private View.OnClickListener lkA = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar;
            if (view != null && (cVar = (c) view.getTag()) != null && cVar.ddT() != null) {
                a.this.lks.Ep(cVar.ddT().getId());
            }
        }
    };
    private com.baidu.tieba.memberCenter.tail.a.a<Void> lkB = new com.baidu.tieba.memberCenter.tail.a.a<Void>() { // from class: com.baidu.tieba.memberCenter.tail.management.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Void r5) {
            if (z) {
                a.this.eSJ.showToast(str);
            } else {
                a.this.setData(a.this.lks.getTails());
            }
        }
    };
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lkC = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.management.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            if (z) {
                a.this.eSJ.showToast(str);
                return;
            }
            TailData tailData = new TailData();
            tailData.setId(num.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_REFRESH, new com.baidu.tieba.memberCenter.tail.data.e(3, tailData)));
        }
    };
    private List<Object> lkx = new ArrayList();

    /* renamed from: com.baidu.tieba.memberCenter.tail.management.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0795a {
        void deb();
    }

    public a(TbPageContext<?> tbPageContext, d dVar, InterfaceC0795a interfaceC0795a) {
        this.eSJ = tbPageContext;
        this.lks = dVar;
        this.lks.c(this.lkB);
        this.lks.d(this.lkC);
        this.lky = interfaceC0795a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str, String str2) {
        this.eSJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.eSJ.getPageActivity(), i, str, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dec() {
        this.eSJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.eSJ.getPageActivity(), this.lks.getTails().isEmpty())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<TailData> list) {
        this.lks.eV(list);
        refresh();
    }

    public void refresh() {
        ded();
        notifyDataSetChanged();
    }

    private void ded() {
        if (this.lky != null) {
            this.lky.deb();
        }
        this.lkx.clear();
        this.lkx.addAll(this.lks.getTails());
        if (!this.lks.deg()) {
            this.lkx.add(new com.baidu.tieba.memberCenter.tail.data.a(this.lks.def()));
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.lkx.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object obj = this.lkx.get(i);
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
            return dz(view);
        }
        return null;
    }

    private View dz(View view) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = bVar.gA(this.eSJ.getPageActivity());
            bVar.I(this.lkz);
            bVar.B(this.eSJ);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.Eo(this.lks.def());
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
            view = cVar.gA(this.eSJ.getPageActivity());
            cVar.J(this.fjU);
            cVar.K(this.lkA);
            cVar.B(this.eSJ);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.b(tailData);
        cVar.p(Boolean.valueOf(this.lks.deg()));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.lkx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
