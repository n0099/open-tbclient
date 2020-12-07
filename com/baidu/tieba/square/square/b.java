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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.view.BestStringsFitTextView;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class b extends BaseAdapter {
    private Activity beD;
    private ArrayList<e> nhf;
    View.OnClickListener nhg = new View.OnClickListener() { // from class: com.baidu.tieba.square.square.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            Object tag = view.getTag();
            if ((tag instanceof a) && (eVar = ((a) tag).nhk) != null) {
                if (eVar.nfi == null) {
                    com.baidu.tieba.square.square.a.g(b.this.dNN(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(b.this.dNN(), eVar.nfh, eVar.nfi, eVar.nfj)));
                }
            }
        }
    };

    public b(Activity activity, c cVar, boolean z) {
        this.beD = activity;
        this.nhf = cVar.dNM();
    }

    public ArrayList<e> dNM() {
        return this.nhf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes23.dex */
    public static class a {
        public TextView egV;
        public BarImageView nhi;
        public BestStringsFitTextView nhj;
        public e nhk;

        protected a() {
        }
    }

    public void bj(ArrayList<e> arrayList) {
        this.nhf = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nhf == null) {
            return 0;
        }
        return (this.nhf.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = N(viewGroup, itemViewType);
            bh.bp(view);
        }
        bh.bo(view);
        if (itemViewType != 3) {
            TbadkCoreApplication.getInst().getSkinType();
            View findViewById = view.findViewById(R.id.container);
            ap.setBackgroundResource(findViewById, R.drawable.addresslist_item_bg);
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

    private View N(ViewGroup viewGroup, int i) {
        if (i == 3) {
            return LayoutInflater.from(this.beD).inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return LayoutInflater.from(this.beD).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.beD).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.nhg);
        a aVar = new a();
        aVar.nhi = (BarImageView) inflate.findViewById(R.id.portrait);
        aVar.egV = (TextView) inflate.findViewById(R.id.name);
        aVar.nhj = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(aVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, a aVar, int i) {
        e eVar = this.nhf.get(i / 2);
        aVar.nhk = eVar;
        aVar.egV.setText(eVar.nfh);
        if (eVar.nhn != null) {
            aVar.nhj.setVisibility(0);
            String[] strArr = new String[eVar.nhn.size()];
            for (int i2 = 0; i2 < eVar.nhn.size(); i2++) {
                strArr[i2] = eVar.nhn.get(i2).nfh;
            }
            aVar.nhj.setTextArray(strArr);
        } else {
            aVar.nhj.setVisibility(8);
        }
        if (eVar.logoUrl != null) {
            int dip2px = l.dip2px(this.beD, 45.0f);
            aVar.nhi.setTag(eVar.logoUrl);
            aVar.nhi.a(eVar.logoUrl, 10, dip2px, dip2px, false);
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

    protected Activity dNN() {
        return this.beD;
    }
}
