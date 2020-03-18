package com.baidu.tieba.mainentrance;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private String cxh;
    private final boolean igt = true;
    private ArrayList<ForumSuggestModel.Forum> igu;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.igu = arrayList;
    }

    public void ay(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.igu = arrayList;
        if (this.igu != null) {
            notifyDataSetChanged();
        }
    }

    public void Em(String str) {
        this.cxh = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.igu == null) {
            return 0;
        }
        return this.igu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xQ */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.igu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0559a c0559a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0559a c0559a2 = new C0559a();
            c0559a2.igw = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0559a2.igw.setGifIconSupport(false);
            c0559a2.diF = (TextView) view.findViewById(R.id.name);
            c0559a2.igx = (TextView) view.findViewById(R.id.forum_member_count);
            c0559a2.igy = (TextView) view.findViewById(R.id.forum_thread_count);
            c0559a2.igz = (TextView) view.findViewById(R.id.slogan);
            c0559a2.igv = view.findViewById(R.id.offical_icon);
            view.setTag(c0559a2);
            c0559a = c0559a2;
        } else {
            c0559a = (C0559a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0559a.igw.setTag(str2);
            c0559a.igw.startLoad(str2, 10, false);
            c0559a.igw.invalidate();
            if (this.igt) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0559a.diF, str);
            c0559a.igw.setTag(item.avatar);
            c0559a.igx.setText(this.mActivity.getPageContext().getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + xR(item.member_num));
            c0559a.igy.setText(this.mActivity.getPageContext().getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + xR(item.thread_num));
            if (this.igt || !TextUtils.isEmpty(item.slogan)) {
                c0559a.igz.setVisibility(0);
                c0559a.igz.setText(item.slogan);
            } else {
                c0559a.igz.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0559a.igv.setVisibility(0);
                am.setBackgroundResource(c0559a.igv, R.drawable.icon_search_official);
            } else {
                c0559a.igv.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String xR(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.cxh)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.cxh.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.cxh.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0559a {
        TextView diF;
        View igv;
        BarImageView igw;
        TextView igx;
        TextView igy;
        TextView igz;

        private C0559a() {
        }
    }
}
