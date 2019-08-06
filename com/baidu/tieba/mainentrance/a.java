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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private String boY;
    private final BaseActivity<?> cWT;
    private final boolean hlj = true;
    private ArrayList<ForumSuggestModel.Forum> hlk;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.cWT = baseActivity;
        this.hlk = arrayList;
    }

    public void aj(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.hlk = arrayList;
        if (this.hlk != null) {
            notifyDataSetChanged();
        }
    }

    public void Al(String str) {
        this.boY = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hlk == null) {
            return 0;
        }
        return this.hlk.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wM */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.hlk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0360a c0360a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.cWT.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0360a c0360a2 = new C0360a();
            c0360a2.hlm = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0360a2.hlm.setGifIconSupport(false);
            c0360a2.ccd = (TextView) view.findViewById(R.id.name);
            c0360a2.hln = (TextView) view.findViewById(R.id.forum_member_count);
            c0360a2.hlo = (TextView) view.findViewById(R.id.forum_thread_count);
            c0360a2.hlp = (TextView) view.findViewById(R.id.slogan);
            c0360a2.hll = view.findViewById(R.id.offical_icon);
            view.setTag(c0360a2);
            c0360a = c0360a2;
        } else {
            c0360a = (C0360a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0360a.hlm.setTag(str2);
            c0360a.hlm.startLoad(str2, 10, false);
            c0360a.hlm.invalidate();
            if (this.hlj) {
                str = this.cWT.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0360a.ccd, str);
            c0360a.hlm.setTag(item.avatar);
            c0360a.hln.setText(this.cWT.getPageContext().getString(R.string.attention) + " " + wN(item.member_num));
            c0360a.hlo.setText(this.cWT.getPageContext().getString(R.string.text_post) + " " + wN(item.thread_num));
            if (this.hlj || !TextUtils.isEmpty(item.slogan)) {
                c0360a.hlp.setVisibility(0);
                c0360a.hlp.setText(item.slogan);
            } else {
                c0360a.hlp.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0360a.hll.setVisibility(0);
                am.k(c0360a.hll, R.drawable.icon_search_official);
            } else {
                c0360a.hll.setVisibility(8);
            }
            this.cWT.getLayoutMode().setNightMode(skinType == 1);
            this.cWT.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String wN(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.cWT.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.boY)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.boY.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.boY.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0360a {
        TextView ccd;
        View hll;
        BarImageView hlm;
        TextView hln;
        TextView hlo;
        TextView hlp;

        private C0360a() {
        }
    }
}
