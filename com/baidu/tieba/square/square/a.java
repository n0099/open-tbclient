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
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private Activity cft;
    private ArrayList<d> jdV;
    View.OnClickListener jdW = new View.OnClickListener() { // from class: com.baidu.tieba.square.square.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            Object tag = view.getTag();
            if ((tag instanceof C0517a) && (dVar = ((C0517a) tag).jea) != null) {
                if (dVar.jbR == null) {
                    BarFolderFirstDirActivity.e(a.this.cmT(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(a.this.cmT(), dVar.jbQ, dVar.jbR, dVar.jbS)));
                }
            }
        }
    };

    public a(Activity activity, b bVar, boolean z) {
        this.cft = activity;
        this.jdV = bVar.cmS();
    }

    public ArrayList<d> cmS() {
        return this.jdV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.tieba.square.square.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0517a {
        public TextView bGd;
        public BarImageView jdY;
        public BestStringsFitTextView jdZ;
        public d jea;

        protected C0517a() {
        }
    }

    public void aH(ArrayList<d> arrayList) {
        this.jdV = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jdV == null) {
            return 0;
        }
        return (this.jdV.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = v(viewGroup, itemViewType);
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
                a(viewGroup, (C0517a) view.getTag(), i);
            }
        }
        return view;
    }

    private View v(ViewGroup viewGroup, int i) {
        if (i == 3) {
            return LayoutInflater.from(this.cft).inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return LayoutInflater.from(this.cft).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.cft).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.jdW);
        C0517a c0517a = new C0517a();
        c0517a.jdY = (BarImageView) inflate.findViewById(R.id.portrait);
        c0517a.bGd = (TextView) inflate.findViewById(R.id.name);
        c0517a.jdZ = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(c0517a);
        return inflate;
    }

    private void a(ViewGroup viewGroup, C0517a c0517a, int i) {
        d dVar = this.jdV.get(i / 2);
        c0517a.jea = dVar;
        c0517a.bGd.setText(dVar.jbQ);
        if (dVar.jed != null) {
            c0517a.jdZ.setVisibility(0);
            String[] strArr = new String[dVar.jed.size()];
            for (int i2 = 0; i2 < dVar.jed.size(); i2++) {
                strArr[i2] = dVar.jed.get(i2).jbQ;
            }
            c0517a.jdZ.setTextArray(strArr);
        } else {
            c0517a.jdZ.setVisibility(8);
        }
        if (dVar.logoUrl != null) {
            int dip2px = l.dip2px(this.cft, 45.0f);
            c0517a.jdY.setTag(dVar.logoUrl);
            c0517a.jdY.a(dVar.logoUrl, 10, dip2px, dip2px, false);
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

    protected Activity cmT() {
        return this.cft;
    }
}
