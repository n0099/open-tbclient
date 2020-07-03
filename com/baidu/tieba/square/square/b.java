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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.view.BestStringsFitTextView;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private Activity bdo;
    private ArrayList<e> lBj;
    View.OnClickListener lBk = new View.OnClickListener() { // from class: com.baidu.tieba.square.square.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            Object tag = view.getTag();
            if ((tag instanceof a) && (eVar = ((a) tag).lBo) != null) {
                if (eVar.lzl == null) {
                    com.baidu.tieba.square.square.a.g(b.this.dgG(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(b.this.dgG(), eVar.lzk, eVar.lzl, eVar.lzm)));
                }
            }
        }
    };

    public b(Activity activity, c cVar, boolean z) {
        this.bdo = activity;
        this.lBj = cVar.dgF();
    }

    public ArrayList<e> dgF() {
        return this.lBj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class a {
        public TextView djl;
        public BarImageView lBm;
        public BestStringsFitTextView lBn;
        public e lBo;

        protected a() {
        }
    }

    public void aU(ArrayList<e> arrayList) {
        this.lBj = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lBj == null) {
            return 0;
        }
        return (this.lBj.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = I(viewGroup, itemViewType);
            be.prepareNewView(view);
        }
        be.processCurrentSkin(view);
        if (itemViewType != 3) {
            TbadkCoreApplication.getInst().getSkinType();
            View findViewById = view.findViewById(R.id.container);
            an.setBackgroundResource(findViewById, R.drawable.addresslist_item_bg);
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

    private View I(ViewGroup viewGroup, int i) {
        if (i == 3) {
            return LayoutInflater.from(this.bdo).inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return LayoutInflater.from(this.bdo).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.bdo).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.lBk);
        a aVar = new a();
        aVar.lBm = (BarImageView) inflate.findViewById(R.id.portrait);
        aVar.djl = (TextView) inflate.findViewById(R.id.name);
        aVar.lBn = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(aVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, a aVar, int i) {
        e eVar = this.lBj.get(i / 2);
        aVar.lBo = eVar;
        aVar.djl.setText(eVar.lzk);
        if (eVar.lBr != null) {
            aVar.lBn.setVisibility(0);
            String[] strArr = new String[eVar.lBr.size()];
            for (int i2 = 0; i2 < eVar.lBr.size(); i2++) {
                strArr[i2] = eVar.lBr.get(i2).lzk;
            }
            aVar.lBn.setTextArray(strArr);
        } else {
            aVar.lBn.setVisibility(8);
        }
        if (eVar.logoUrl != null) {
            int dip2px = l.dip2px(this.bdo, 45.0f);
            aVar.lBm.setTag(eVar.logoUrl);
            aVar.lBm.a(eVar.logoUrl, 10, dip2px, dip2px, false);
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

    protected Activity dgG() {
        return this.bdo;
    }
}
