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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private String dhj;
    private final boolean jgo = true;
    private ArrayList<ForumSuggestModel.Forum> jgp;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.jgp = arrayList;
    }

    public void aA(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.jgp = arrayList;
        if (this.jgp != null) {
            notifyDataSetChanged();
        }
    }

    public void HG(String str) {
        this.dhj = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jgp == null) {
            return 0;
        }
        return this.jgp.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: za */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.jgp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0668a c0668a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0668a c0668a2 = new C0668a();
            c0668a2.jgr = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0668a2.jgr.setGifIconSupport(false);
            c0668a2.dWR = (TextView) view.findViewById(R.id.name);
            c0668a2.jgs = (TextView) view.findViewById(R.id.forum_member_count);
            c0668a2.jgt = (TextView) view.findViewById(R.id.forum_thread_count);
            c0668a2.jgu = (TextView) view.findViewById(R.id.slogan);
            c0668a2.jgq = view.findViewById(R.id.offical_icon);
            view.setTag(c0668a2);
            c0668a = c0668a2;
        } else {
            c0668a = (C0668a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0668a.jgr.setTag(str2);
            c0668a.jgr.startLoad(str2, 10, false);
            c0668a.jgr.invalidate();
            if (this.jgo) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0668a.dWR, str);
            c0668a.jgr.setTag(item.avatar);
            c0668a.jgs.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + zb(item.member_num));
            c0668a.jgt.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + zb(item.thread_num));
            if (this.jgo || !TextUtils.isEmpty(item.slogan)) {
                c0668a.jgu.setVisibility(0);
                c0668a.jgu.setText(item.slogan);
            } else {
                c0668a.jgu.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0668a.jgq.setVisibility(0);
                am.setBackgroundResource(c0668a.jgq, R.drawable.icon_search_official);
            } else {
                c0668a.jgq.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String zb(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.dhj)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.dhj.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.dhj.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0668a {
        TextView dWR;
        View jgq;
        BarImageView jgr;
        TextView jgs;
        TextView jgt;
        TextView jgu;

        private C0668a() {
        }
    }
}
