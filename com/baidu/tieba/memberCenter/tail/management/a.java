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
    private TbPageContext<?> eXu;
    private d lpc;
    private InterfaceC0812a lpi;
    private View.OnClickListener lpj = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dhU();
        }
    };
    private View.OnClickListener foD = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailData dhL;
            if (view != null && view.getTag() != null && (dhL = ((c) view.getTag()).dhL()) != null && !a.this.lpc.dhY()) {
                a.this.m(dhL.getId(), dhL.getContent(), dhL.getFontColor());
            }
        }
    };
    private View.OnClickListener lpk = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar;
            if (view != null && (cVar = (c) view.getTag()) != null && cVar.dhL() != null) {
                a.this.lpc.FV(cVar.dhL().getId());
            }
        }
    };
    private com.baidu.tieba.memberCenter.tail.a.a<Void> lpl = new com.baidu.tieba.memberCenter.tail.a.a<Void>() { // from class: com.baidu.tieba.memberCenter.tail.management.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Void r5) {
            if (z) {
                a.this.eXu.showToast(str);
            } else {
                a.this.setData(a.this.lpc.getTails());
            }
        }
    };
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lpm = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.management.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            if (z) {
                a.this.eXu.showToast(str);
                return;
            }
            TailData tailData = new TailData();
            tailData.setId(num.intValue());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_REFRESH, new com.baidu.tieba.memberCenter.tail.data.e(3, tailData)));
        }
    };
    private List<Object> lph = new ArrayList();

    /* renamed from: com.baidu.tieba.memberCenter.tail.management.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0812a {
        void dhT();
    }

    public a(TbPageContext<?> tbPageContext, d dVar, InterfaceC0812a interfaceC0812a) {
        this.eXu = tbPageContext;
        this.lpc = dVar;
        this.lpc.c(this.lpl);
        this.lpc.d(this.lpm);
        this.lpi = interfaceC0812a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, String str, String str2) {
        this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.eXu.getPageActivity(), i, str, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhU() {
        this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.eXu.getPageActivity(), this.lpc.getTails().isEmpty())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<TailData> list) {
        this.lpc.eV(list);
        refresh();
    }

    public void refresh() {
        dhV();
        notifyDataSetChanged();
    }

    private void dhV() {
        if (this.lpi != null) {
            this.lpi.dhT();
        }
        this.lph.clear();
        this.lph.addAll(this.lpc.getTails());
        if (!this.lpc.dhY()) {
            this.lph.add(new com.baidu.tieba.memberCenter.tail.data.a(this.lpc.dhX()));
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.lph.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object obj = this.lph.get(i);
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
            view = bVar.gC(this.eXu.getPageActivity());
            bVar.I(this.lpj);
            bVar.B(this.eXu);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.FU(this.lpc.dhX());
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
            view = cVar.gC(this.eXu.getPageActivity());
            cVar.J(this.foD);
            cVar.K(this.lpk);
            cVar.B(this.eXu);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.b(tailData);
        cVar.p(Boolean.valueOf(this.lpc.dhY()));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.lph.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
