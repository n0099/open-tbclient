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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class a extends BaseAdapter {
    private String drQ;
    private final boolean jGd = true;
    private ArrayList<ForumSuggestModel.Forum> jGe;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.jGe = arrayList;
    }

    public void aC(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.jGe = arrayList;
        if (this.jGe != null) {
            notifyDataSetChanged();
        }
    }

    public void IX(String str) {
        this.drQ = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jGe == null) {
            return 0;
        }
        return this.jGe.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Al */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.jGe.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0692a c0692a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0692a c0692a2 = new C0692a();
            c0692a2.jGg = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0692a2.jGg.setGifIconSupport(false);
            c0692a2.ekx = (TextView) view.findViewById(R.id.name);
            c0692a2.jGh = (TextView) view.findViewById(R.id.forum_member_count);
            c0692a2.jGi = (TextView) view.findViewById(R.id.forum_thread_count);
            c0692a2.jGj = (TextView) view.findViewById(R.id.slogan);
            c0692a2.jGf = view.findViewById(R.id.offical_icon);
            view.setTag(c0692a2);
            c0692a = c0692a2;
        } else {
            c0692a = (C0692a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0692a.jGg.setTag(str2);
            c0692a.jGg.startLoad(str2, 10, false);
            c0692a.jGg.invalidate();
            if (this.jGd) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0692a.ekx, str);
            c0692a.jGg.setTag(item.avatar);
            c0692a.jGh.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + Am(item.member_num));
            c0692a.jGi.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + Am(item.thread_num));
            if (this.jGd || !TextUtils.isEmpty(item.slogan)) {
                c0692a.jGj.setVisibility(0);
                c0692a.jGj.setText(item.slogan);
            } else {
                c0692a.jGj.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0692a.jGf.setVisibility(0);
                ao.setBackgroundResource(c0692a.jGf, R.drawable.icon_search_official);
            } else {
                c0692a.jGf.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String Am(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.drQ)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.drQ.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.drQ.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private class C0692a {
        TextView ekx;
        View jGf;
        BarImageView jGg;
        TextView jGh;
        TextView jGi;
        TextView jGj;

        private C0692a() {
        }
    }
}
