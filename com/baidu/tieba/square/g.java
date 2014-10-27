package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.view.BarImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter implements com.baidu.tieba.view.s {
    private aj bMd;
    private final Context mContext;
    private String stType = null;
    View.OnClickListener bMe = new h(this);

    public g(Context context) {
        this.mContext = context;
    }

    public void a(aj ajVar) {
        this.bMd = ajVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bMd == null || this.bMd.adl().size() == 0) {
            return 0;
        }
        ArrayList<ai> adl = this.bMd.adl();
        if (adl == null || adl.size() <= 0) {
            return 1;
        }
        return 1 + adl.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View findViewById;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = a(i, viewGroup, itemViewType);
            bn.n(view);
        }
        if (itemViewType == 0) {
            if (this.bMd != null) {
                ((TextView) view.findViewById(com.baidu.tieba.v.title)).setText(this.bMd.adw());
            }
        } else if (itemViewType == 2) {
            bn.m(view);
            a(viewGroup, (i) view.getTag(), i, "all");
        } else if (itemViewType == 1) {
            bn.m(view);
            a(viewGroup, (i) view.getTag(), i, WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
        int skinType = TbadkApplication.m251getInst().getSkinType();
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.mContext;
        baseFragmentActivity.getLayoutMode().L(skinType == 1);
        baseFragmentActivity.getLayoutMode().h(view);
        if (itemViewType == 0) {
            View findViewById2 = view.findViewById(com.baidu.tieba.v.post_recommend_line_up);
            View findViewById3 = view.findViewById(com.baidu.tieba.v.post_recommend_line_down);
            if (findViewById2 != null && findViewById3 != null) {
                aw.i(findViewById2, com.baidu.tieba.s.square_dividing_line);
                aw.i(findViewById3, com.baidu.tieba.s.square_dividing_line);
            }
        } else if (itemViewType == 1 && (findViewById = view.findViewById(com.baidu.tieba.v.bar_folder_item_bottom_line)) != null) {
            aw.i(findViewById, com.baidu.tieba.s.square_dividing_line);
        }
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.bar_home_header, null);
        }
        if (i2 == 2) {
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.bar_home_all_dir_item, null);
            ai aiVar = new ai();
            aiVar.bMX = "1";
            i iVar = new i();
            iVar.bLZ = (BarImageView) inflate.findViewById(com.baidu.tieba.v.portrait);
            iVar.UD = (TextView) inflate.findViewById(com.baidu.tieba.v.squre_name);
            iVar.bMa = (BestStringsFitTextView) inflate.findViewById(com.baidu.tieba.v.description);
            iVar.bMg = aiVar;
            inflate.setOnClickListener(this.bMe);
            inflate.setTag(iVar);
            return inflate;
        }
        View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.bar_home_first_dir_item, null);
        inflate2.setOnClickListener(this.bMe);
        ai aiVar2 = new ai();
        aiVar2.bMX = "0";
        i iVar2 = new i();
        iVar2.bLZ = (BarImageView) inflate2.findViewById(com.baidu.tieba.v.portrait);
        iVar2.UD = (TextView) inflate2.findViewById(com.baidu.tieba.v.squre_name);
        iVar2.bMa = (BestStringsFitTextView) inflate2.findViewById(com.baidu.tieba.v.description);
        iVar2.bMg = aiVar2;
        inflate2.setTag(iVar2);
        return inflate2;
    }

    private void a(ViewGroup viewGroup, i iVar, int i, String str) {
        ai aiVar = this.bMd.adl().get(i - 1);
        aiVar.index = i - 1;
        if (aiVar.bMX.equals("1") && str.equals("all")) {
            a(viewGroup, iVar, aiVar);
        } else if (aiVar.bMX.equals("0") && str.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
            a(viewGroup, iVar, aiVar);
        }
    }

    private void a(ViewGroup viewGroup, i iVar, ai aiVar) {
        iVar.bMg = aiVar;
        iVar.UD.setText(UtilHelper.getFixedText(aiVar.title, 11));
        if (aiVar.bMW != null) {
            iVar.bMa.setText(aiVar.bMW);
            iVar.bMa.setVisibility(0);
        } else {
            iVar.bMa.setVisibility(8);
        }
        if (aiVar.picUrl != null) {
            iVar.bLZ.setTag(aiVar.picUrl);
            int dip2px = com.baidu.adp.lib.util.m.dip2px(this.mContext, 45.0f);
            iVar.bLZ.a(aiVar.picUrl, 10, dip2px, dip2px, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == getCount() - 1) {
            return 2;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // com.baidu.tieba.view.s
    public void adn() {
    }

    @Override // com.baidu.tieba.view.s
    public void g(View view, int i, int i2) {
    }
}
