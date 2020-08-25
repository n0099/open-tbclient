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
    private Activity czY;
    private ArrayList<e> mah;
    View.OnClickListener mai = new View.OnClickListener() { // from class: com.baidu.tieba.square.square.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            Object tag = view.getTag();
            if ((tag instanceof a) && (eVar = ((a) tag).mam) != null) {
                if (eVar.lYj == null) {
                    com.baidu.tieba.square.square.a.g(b.this.dvn(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(b.this.dvn(), eVar.lYi, eVar.lYj, eVar.lYk)));
                }
            }
        }
    };

    public b(Activity activity, c cVar, boolean z) {
        this.czY = activity;
        this.mah = cVar.dvm();
    }

    public ArrayList<e> dvm() {
        return this.mah;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes17.dex */
    public static class a {
        public TextView dzi;
        public BarImageView mak;
        public BestStringsFitTextView mal;
        public e mam;

        protected a() {
        }
    }

    public void bb(ArrayList<e> arrayList) {
        this.mah = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mah == null) {
            return 0;
        }
        return (this.mah.size() * 2) + 1;
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
            return LayoutInflater.from(this.czY).inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return LayoutInflater.from(this.czY).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.czY).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.mai);
        a aVar = new a();
        aVar.mak = (BarImageView) inflate.findViewById(R.id.portrait);
        aVar.dzi = (TextView) inflate.findViewById(R.id.name);
        aVar.mal = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(aVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, a aVar, int i) {
        e eVar = this.mah.get(i / 2);
        aVar.mam = eVar;
        aVar.dzi.setText(eVar.lYi);
        if (eVar.maq != null) {
            aVar.mal.setVisibility(0);
            String[] strArr = new String[eVar.maq.size()];
            for (int i2 = 0; i2 < eVar.maq.size(); i2++) {
                strArr[i2] = eVar.maq.get(i2).lYi;
            }
            aVar.mal.setTextArray(strArr);
        } else {
            aVar.mal.setVisibility(8);
        }
        if (eVar.logoUrl != null) {
            int dip2px = l.dip2px(this.czY, 45.0f);
            aVar.mak.setTag(eVar.logoUrl);
            aVar.mak.a(eVar.logoUrl, 10, dip2px, dip2px, false);
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

    protected Activity dvn() {
        return this.czY;
    }
}
