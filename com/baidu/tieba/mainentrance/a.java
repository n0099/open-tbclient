package com.baidu.tieba.mainentrance;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private final BaseActivity<?> bcJ;
    private final boolean eBF = true;
    private ArrayList<ForumSuggestModel.Forum> eBG;
    private String eBH;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.bcJ = baseActivity;
        this.eBG = arrayList;
    }

    public void Y(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.eBG = arrayList;
        if (this.eBG != null) {
            notifyDataSetChanged();
        }
    }

    public void oH(String str) {
        this.eBH = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eBG == null) {
            return 0;
        }
        return this.eBG.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oK */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.eBG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0179a c0179a;
        String str;
        if (view2 == null) {
            view2 = LayoutInflater.from(this.bcJ.getPageContext().getPageActivity()).inflate(d.i.square_dialog_search_item, (ViewGroup) null);
            C0179a c0179a2 = new C0179a();
            c0179a2.eBJ = (BarImageView) view2.findViewById(d.g.forum_avatar);
            c0179a2.eBJ.setGifIconSupport(false);
            c0179a2.apV = (TextView) view2.findViewById(d.g.name);
            c0179a2.eBK = (TextView) view2.findViewById(d.g.forum_member_count);
            c0179a2.eBL = (TextView) view2.findViewById(d.g.forum_thread_count);
            c0179a2.eBM = (TextView) view2.findViewById(d.g.slogan);
            c0179a2.eBI = view2.findViewById(d.g.offical_icon);
            view2.setTag(c0179a2);
            c0179a = c0179a2;
        } else {
            c0179a = (C0179a) view2.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0179a.eBJ.setTag(str2);
            c0179a.eBJ.startLoad(str2, 10, false);
            c0179a.eBJ.invalidate();
            if (this.eBF) {
                str = this.bcJ.getPageContext().getPageActivity().getString(d.k.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0179a.apV, str);
            c0179a.eBJ.setTag(item.avatar);
            c0179a.eBK.setText(this.bcJ.getPageContext().getString(d.k.attention) + " " + oL(item.member_num));
            c0179a.eBL.setText(this.bcJ.getPageContext().getString(d.k.text_post) + " " + oL(item.thread_num));
            if (this.eBF || !TextUtils.isEmpty(item.slogan)) {
                c0179a.eBM.setVisibility(0);
                c0179a.eBM.setText(item.slogan);
            } else {
                c0179a.eBM.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0179a.eBI.setVisibility(0);
                ak.i(c0179a.eBI, d.f.icon_search_official);
            } else {
                c0179a.eBI.setVisibility(8);
            }
            this.bcJ.getLayoutMode().setNightMode(skinType == 1);
            this.bcJ.getLayoutMode().u(view2);
        }
        return view2;
    }

    public String oL(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.bcJ.getPageContext().getString(d.k.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.eBH)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.eBH.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ak.getColor(d.C0126d.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.eBH.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0179a {
        TextView apV;
        View eBI;
        BarImageView eBJ;
        TextView eBK;
        TextView eBL;
        TextView eBM;

        private C0179a() {
        }
    }
}
