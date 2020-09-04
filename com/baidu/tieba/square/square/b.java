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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.view.BestStringsFitTextView;
import java.util.ArrayList;
/* loaded from: classes17.dex */
public class b extends BaseAdapter {
    private Activity cAc;
    private ArrayList<e> may;
    View.OnClickListener maz = new View.OnClickListener() { // from class: com.baidu.tieba.square.square.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            Object tag = view.getTag();
            if ((tag instanceof a) && (eVar = ((a) tag).maD) != null) {
                if (eVar.lYy == null) {
                    com.baidu.tieba.square.square.a.g(b.this.dvs(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(b.this.dvs(), eVar.lYx, eVar.lYy, eVar.lYz)));
                }
            }
        }
    };

    public b(Activity activity, c cVar, boolean z) {
        this.cAc = activity;
        this.may = cVar.dvr();
    }

    public ArrayList<e> dvr() {
        return this.may;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes17.dex */
    public static class a {
        public TextView dzm;
        public BarImageView maB;
        public BestStringsFitTextView maC;
        public e maD;

        protected a() {
        }
    }

    public void bb(ArrayList<e> arrayList) {
        this.may = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.may == null) {
            return 0;
        }
        return (this.may.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = J(viewGroup, itemViewType);
            bg.prepareNewView(view);
        }
        bg.processCurrentSkin(view);
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

    private View J(ViewGroup viewGroup, int i) {
        if (i == 3) {
            return LayoutInflater.from(this.cAc).inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return LayoutInflater.from(this.cAc).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.cAc).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.maz);
        a aVar = new a();
        aVar.maB = (BarImageView) inflate.findViewById(R.id.portrait);
        aVar.dzm = (TextView) inflate.findViewById(R.id.name);
        aVar.maC = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(aVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, a aVar, int i) {
        e eVar = this.may.get(i / 2);
        aVar.maD = eVar;
        aVar.dzm.setText(eVar.lYx);
        if (eVar.maG != null) {
            aVar.maC.setVisibility(0);
            String[] strArr = new String[eVar.maG.size()];
            for (int i2 = 0; i2 < eVar.maG.size(); i2++) {
                strArr[i2] = eVar.maG.get(i2).lYx;
            }
            aVar.maC.setTextArray(strArr);
        } else {
            aVar.maC.setVisibility(8);
        }
        if (eVar.logoUrl != null) {
            int dip2px = l.dip2px(this.cAc, 45.0f);
            aVar.maB.setTag(eVar.logoUrl);
            aVar.maB.a(eVar.logoUrl, 10, dip2px, dip2px, false);
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

    protected Activity dvs() {
        return this.cAc;
    }
}
