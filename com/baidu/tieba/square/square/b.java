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
/* loaded from: classes23.dex */
public class b extends BaseAdapter {
    private Activity bIs;
    private ArrayList<e> mMk;
    View.OnClickListener mMl = new View.OnClickListener() { // from class: com.baidu.tieba.square.square.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            Object tag = view.getTag();
            if ((tag instanceof a) && (eVar = ((a) tag).mMp) != null) {
                if (eVar.mKn == null) {
                    com.baidu.tieba.square.square.a.g(b.this.dGe(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(b.this.dGe(), eVar.mKm, eVar.mKn, eVar.mKo)));
                }
            }
        }
    };

    public b(Activity activity, c cVar, boolean z) {
        this.bIs = activity;
        this.mMk = cVar.dGd();
    }

    public ArrayList<e> dGd() {
        return this.mMk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes23.dex */
    public static class a {
        public TextView dVL;
        public BarImageView mMn;
        public BestStringsFitTextView mMo;
        public e mMp;

        protected a() {
        }
    }

    public void bg(ArrayList<e> arrayList) {
        this.mMk = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mMk == null) {
            return 0;
        }
        return (this.mMk.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = N(viewGroup, itemViewType);
            bg.bf(view);
        }
        bg.be(view);
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
            return LayoutInflater.from(this.bIs).inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return LayoutInflater.from(this.bIs).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.bIs).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.mMl);
        a aVar = new a();
        aVar.mMn = (BarImageView) inflate.findViewById(R.id.portrait);
        aVar.dVL = (TextView) inflate.findViewById(R.id.name);
        aVar.mMo = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(aVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, a aVar, int i) {
        e eVar = this.mMk.get(i / 2);
        aVar.mMp = eVar;
        aVar.dVL.setText(eVar.mKm);
        if (eVar.mMs != null) {
            aVar.mMo.setVisibility(0);
            String[] strArr = new String[eVar.mMs.size()];
            for (int i2 = 0; i2 < eVar.mMs.size(); i2++) {
                strArr[i2] = eVar.mMs.get(i2).mKm;
            }
            aVar.mMo.setTextArray(strArr);
        } else {
            aVar.mMo.setVisibility(8);
        }
        if (eVar.logoUrl != null) {
            int dip2px = l.dip2px(this.bIs, 45.0f);
            aVar.mMn.setTag(eVar.logoUrl);
            aVar.mMn.a(eVar.logoUrl, 10, dip2px, dip2px, false);
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

    protected Activity dGe() {
        return this.bIs;
    }
}
