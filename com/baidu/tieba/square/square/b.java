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
    private ArrayList<e> kbY;
    View.OnClickListener kbZ = new View.OnClickListener() { // from class: com.baidu.tieba.square.square.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            Object tag = view.getTag();
            if ((tag instanceof a) && (eVar = ((a) tag).kcd) != null) {
                if (eVar.kad == null) {
                    com.baidu.tieba.square.square.a.e(b.this.getContext(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(b.this.getContext(), eVar.kac, eVar.kad, eVar.kae)));
                }
            }
        }
    };
    private Activity mContext;

    public b(Activity activity, c cVar, boolean z) {
        this.mContext = activity;
        this.kbY = cVar.cJH();
    }

    public ArrayList<e> cJH() {
        return this.kbY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class a {
        public TextView cug;
        public BarImageView kcb;
        public BestStringsFitTextView kcc;
        public e kcd;

        protected a() {
        }
    }

    public void aQ(ArrayList<e> arrayList) {
        this.kbY = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kbY == null) {
            return 0;
        }
        return (this.kbY.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = z(viewGroup, itemViewType);
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

    private View z(ViewGroup viewGroup, int i) {
        if (i == 3) {
            return LayoutInflater.from(this.mContext).inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return LayoutInflater.from(this.mContext).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.kbZ);
        a aVar = new a();
        aVar.kcb = (BarImageView) inflate.findViewById(R.id.portrait);
        aVar.cug = (TextView) inflate.findViewById(R.id.name);
        aVar.kcc = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(aVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, a aVar, int i) {
        e eVar = this.kbY.get(i / 2);
        aVar.kcd = eVar;
        aVar.cug.setText(eVar.kac);
        if (eVar.kcg != null) {
            aVar.kcc.setVisibility(0);
            String[] strArr = new String[eVar.kcg.size()];
            for (int i2 = 0; i2 < eVar.kcg.size(); i2++) {
                strArr[i2] = eVar.kcg.get(i2).kac;
            }
            aVar.kcc.setTextArray(strArr);
        } else {
            aVar.kcc.setVisibility(8);
        }
        if (eVar.logoUrl != null) {
            int dip2px = l.dip2px(this.mContext, 45.0f);
            aVar.kcb.setTag(eVar.logoUrl);
            aVar.kcb.a(eVar.logoUrl, 10, dip2px, dip2px, false);
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

    protected Activity getContext() {
        return this.mContext;
    }
}
