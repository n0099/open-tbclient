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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private String bol;
    private final BaseActivity<?> cVp;
    private final boolean hed = true;
    private ArrayList<ForumSuggestModel.Forum> hee;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.cVp = baseActivity;
        this.hee = arrayList;
    }

    public void aj(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.hee = arrayList;
        if (this.hee != null) {
            notifyDataSetChanged();
        }
    }

    public void zx(String str) {
        this.bol = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hee == null) {
            return 0;
        }
        return this.hee.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wh */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.hee.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0355a c0355a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.cVp.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0355a c0355a2 = new C0355a();
            c0355a2.heg = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0355a2.heg.setGifIconSupport(false);
            c0355a2.caT = (TextView) view.findViewById(R.id.name);
            c0355a2.heh = (TextView) view.findViewById(R.id.forum_member_count);
            c0355a2.hei = (TextView) view.findViewById(R.id.forum_thread_count);
            c0355a2.hej = (TextView) view.findViewById(R.id.slogan);
            c0355a2.hef = view.findViewById(R.id.offical_icon);
            view.setTag(c0355a2);
            c0355a = c0355a2;
        } else {
            c0355a = (C0355a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0355a.heg.setTag(str2);
            c0355a.heg.startLoad(str2, 10, false);
            c0355a.heg.invalidate();
            if (this.hed) {
                str = this.cVp.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0355a.caT, str);
            c0355a.heg.setTag(item.avatar);
            c0355a.heh.setText(this.cVp.getPageContext().getString(R.string.attention) + " " + wi(item.member_num));
            c0355a.hei.setText(this.cVp.getPageContext().getString(R.string.text_post) + " " + wi(item.thread_num));
            if (this.hed || !TextUtils.isEmpty(item.slogan)) {
                c0355a.hej.setVisibility(0);
                c0355a.hej.setText(item.slogan);
            } else {
                c0355a.hej.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0355a.hef.setVisibility(0);
                al.k(c0355a.hef, R.drawable.icon_search_official);
            } else {
                c0355a.hef.setVisibility(8);
            }
            this.cVp.getLayoutMode().setNightMode(skinType == 1);
            this.cVp.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String wi(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.cVp.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bol)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bol.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bol.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0355a {
        TextView caT;
        View hef;
        BarImageView heg;
        TextView heh;
        TextView hei;
        TextView hej;

        private C0355a() {
        }
    }
}
