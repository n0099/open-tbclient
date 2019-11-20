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
    private Activity ceC;
    private ArrayList<d> jde;
    View.OnClickListener jdf = new View.OnClickListener() { // from class: com.baidu.tieba.square.square.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            Object tag = view.getTag();
            if ((tag instanceof C0517a) && (dVar = ((C0517a) tag).jdj) != null) {
                if (dVar.jba == null) {
                    BarFolderFirstDirActivity.e(a.this.cmR(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(a.this.cmR(), dVar.jaZ, dVar.jba, dVar.jbb)));
                }
            }
        }
    };

    public a(Activity activity, b bVar, boolean z) {
        this.ceC = activity;
        this.jde = bVar.cmQ();
    }

    public ArrayList<d> cmQ() {
        return this.jde;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.tieba.square.square.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0517a {
        public TextView bFm;
        public BarImageView jdh;
        public BestStringsFitTextView jdi;
        public d jdj;

        protected C0517a() {
        }
    }

    public void aH(ArrayList<d> arrayList) {
        this.jde = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jde == null) {
            return 0;
        }
        return (this.jde.size() * 2) + 1;
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
            return LayoutInflater.from(this.ceC).inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return LayoutInflater.from(this.ceC).inflate(R.layout.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View inflate = LayoutInflater.from(this.ceC).inflate(R.layout.bar_folder_first_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.jdf);
        C0517a c0517a = new C0517a();
        c0517a.jdh = (BarImageView) inflate.findViewById(R.id.portrait);
        c0517a.bFm = (TextView) inflate.findViewById(R.id.name);
        c0517a.jdi = (BestStringsFitTextView) inflate.findViewById(R.id.description);
        inflate.setTag(c0517a);
        return inflate;
    }

    private void a(ViewGroup viewGroup, C0517a c0517a, int i) {
        d dVar = this.jde.get(i / 2);
        c0517a.jdj = dVar;
        c0517a.bFm.setText(dVar.jaZ);
        if (dVar.jdm != null) {
            c0517a.jdi.setVisibility(0);
            String[] strArr = new String[dVar.jdm.size()];
            for (int i2 = 0; i2 < dVar.jdm.size(); i2++) {
                strArr[i2] = dVar.jdm.get(i2).jaZ;
            }
            c0517a.jdi.setTextArray(strArr);
        } else {
            c0517a.jdi.setVisibility(8);
        }
        if (dVar.logoUrl != null) {
            int dip2px = l.dip2px(this.ceC, 45.0f);
            c0517a.jdh.setTag(dVar.logoUrl);
            c0517a.jdh.a(dVar.logoUrl, 10, dip2px, dip2px, false);
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

    protected Activity cmR() {
        return this.ceC;
    }
}
