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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.view.BestStringsFitTextView;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private Activity clq;
    private ArrayList<e> lhm;
    View.OnClickListener lhn = new View.OnClickListener() { // from class: com.baidu.tieba.square.square.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            Object tag = view.getTag();
            if ((tag instanceof a) && (eVar = ((a) tag).lhr) != null) {
                if (eVar.lfo == null) {
                    com.baidu.tieba.square.square.a.g(b.this.dcr(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(b.this.dcr(), eVar.lfn, eVar.lfo, eVar.lfp)));
                }
            }
        }
    };

    public b(Activity activity, c cVar, boolean z) {
        this.clq = activity;
        this.lhm = cVar.dcq();
    }

    public ArrayList<e> dcq() {
        return this.lhm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class a {
        public TextView dez;
        public BarImageView lhp;
        public BestStringsFitTextView lhq;
        public e lhr;

        protected a() {
        }
    }

    public void aT(ArrayList<e> arrayList) {
        this.lhm = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lhm == null) {
            return 0;
        }
        return (this.lhm.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = D(viewGroup, itemViewType);
            bc.prepareNewView(view);
        }
        bc.processCurrentSkin(view);
        if (itemViewType != 3) {
            TbadkCoreApplication.getInst().getSkinType();
            View findViewById = view.findViewById(R.id.container);
            am.setBackgroundResource(findViewById, R.drawable.addresslist_item_bg);
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

    private View D(ViewGroup viewGroup, int i) {
        if (i == 3) {
            return LayoutInflater.from(this.clq).inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return LayoutInflater.from(this.clq).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.clq).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.lhn);
        a aVar = new a();
        aVar.lhp = (BarImageView) inflate.findViewById(R.id.portrait);
        aVar.dez = (TextView) inflate.findViewById(R.id.name);
        aVar.lhq = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(aVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, a aVar, int i) {
        e eVar = this.lhm.get(i / 2);
        aVar.lhr = eVar;
        aVar.dez.setText(eVar.lfn);
        if (eVar.lhu != null) {
            aVar.lhq.setVisibility(0);
            String[] strArr = new String[eVar.lhu.size()];
            for (int i2 = 0; i2 < eVar.lhu.size(); i2++) {
                strArr[i2] = eVar.lhu.get(i2).lfn;
            }
            aVar.lhq.setTextArray(strArr);
        } else {
            aVar.lhq.setVisibility(8);
        }
        if (eVar.logoUrl != null) {
            int dip2px = l.dip2px(this.clq, 45.0f);
            aVar.lhp.setTag(eVar.logoUrl);
            aVar.lhp.a(eVar.logoUrl, 10, dip2px, dip2px, false);
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

    protected Activity dcr() {
        return this.clq;
    }
}
