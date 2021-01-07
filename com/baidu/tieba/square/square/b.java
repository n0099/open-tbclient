package com.baidu.tieba.square.square;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.view.BestStringsFitTextView;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private Activity mContext;
    private ArrayList<e> nmM;
    View.OnClickListener nmN = new View.OnClickListener() { // from class: com.baidu.tieba.square.square.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            Object tag = view.getTag();
            if ((tag instanceof a) && (eVar = ((a) tag).nmR) != null) {
                if (eVar.nkP == null) {
                    com.baidu.tieba.square.square.a.h(b.this.dNH(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(b.this.dNH(), eVar.nkO, eVar.nkP, eVar.nkQ)));
                }
            }
        }
    };

    public b(Activity activity, c cVar, boolean z) {
        this.mContext = activity;
        this.nmM = cVar.dNG();
    }

    public ArrayList<e> dNG() {
        return this.nmM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes8.dex */
    public static class a {
        public TextView epX;
        public BarImageView nmP;
        public BestStringsFitTextView nmQ;
        public e nmR;

        protected a() {
        }
    }

    public void bj(ArrayList<e> arrayList) {
        this.nmM = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nmM == null) {
            return 0;
        }
        return (this.nmM.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = R(viewGroup, itemViewType);
            bg.by(view);
        }
        bg.bx(view);
        if (itemViewType != 3) {
            TbadkCoreApplication.getInst().getSkinType();
            View findViewById = view.findViewById(R.id.container);
            ao.setBackgroundResource(findViewById, R.drawable.addresslist_item_bg);
            if (itemViewType == 2) {
                if (getCount() > 1) {
                    findViewById.setVisibility(0);
                }
            } else if (itemViewType == 1) {
                a(viewGroup, (a) view.getTag(), i);
            }
        }
        return view;
    }

    private View R(ViewGroup viewGroup, int i) {
        if (i == 3) {
            return LayoutInflater.from(this.mContext).inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return LayoutInflater.from(this.mContext).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.nmN);
        a aVar = new a();
        aVar.nmP = (BarImageView) inflate.findViewById(R.id.portrait);
        aVar.epX = (TextView) inflate.findViewById(R.id.name);
        aVar.nmQ = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(aVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, a aVar, int i) {
        e eVar = this.nmM.get(i / 2);
        aVar.nmR = eVar;
        aVar.epX.setText(eVar.nkO);
        if (eVar.nmU != null) {
            aVar.nmQ.setVisibility(0);
            String[] strArr = new String[eVar.nmU.size()];
            for (int i2 = 0; i2 < eVar.nmU.size(); i2++) {
                strArr[i2] = eVar.nmU.get(i2).nkO;
            }
            aVar.nmQ.setTextArray(strArr);
        } else {
            aVar.nmQ.setVisibility(8);
        }
        if (eVar.logoUrl != null) {
            int dip2px = l.dip2px(this.mContext, 45.0f);
            aVar.nmP.setTag(eVar.logoUrl);
            aVar.nmP.a(eVar.logoUrl, 10, dip2px, dip2px, false);
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getCount() <= 0 || i != getCount() - 1) {
            return Math.abs(i) % 2 == 1 ? 3 : 1;
        }
        return 2;
    }

    protected Activity dNH() {
        return this.mContext;
    }
}
