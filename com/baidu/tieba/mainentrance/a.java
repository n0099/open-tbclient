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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class a extends BaseAdapter {
    private String dBR;
    private final boolean jVu = true;
    private ArrayList<ForumSuggestModel.Forum> jVv;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.jVv = arrayList;
    }

    public void aI(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.jVv = arrayList;
        if (this.jVv != null) {
            notifyDataSetChanged();
        }
    }

    public void LP(String str) {
        this.dBR = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jVv == null) {
            return 0;
        }
        return this.jVv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: CE */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.jVv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0743a c0743a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0743a c0743a2 = new C0743a();
            c0743a2.jVx = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0743a2.jVx.setGifIconSupport(false);
            c0743a2.eus = (TextView) view.findViewById(R.id.name);
            c0743a2.jVy = (TextView) view.findViewById(R.id.forum_member_count);
            c0743a2.jVz = (TextView) view.findViewById(R.id.forum_thread_count);
            c0743a2.jVA = (TextView) view.findViewById(R.id.slogan);
            c0743a2.jVw = view.findViewById(R.id.offical_icon);
            view.setTag(c0743a2);
            c0743a = c0743a2;
        } else {
            c0743a = (C0743a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0743a.jVx.setTag(str2);
            c0743a.jVx.startLoad(str2, 10, false);
            c0743a.jVx.invalidate();
            if (this.jVu) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0743a.eus, str);
            c0743a.jVx.setTag(item.avatar);
            c0743a.jVy.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + CF(item.member_num));
            c0743a.jVz.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + CF(item.thread_num));
            if (this.jVu || !TextUtils.isEmpty(item.slogan)) {
                c0743a.jVA.setVisibility(0);
                c0743a.jVA.setText(item.slogan);
            } else {
                c0743a.jVA.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0743a.jVw.setVisibility(0);
                ap.setBackgroundResource(c0743a.jVw, R.drawable.icon_search_official);
            } else {
                c0743a.jVw.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String CF(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.dBR)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.dBR.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.dBR.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private class C0743a {
        TextView eus;
        TextView jVA;
        View jVw;
        BarImageView jVx;
        TextView jVy;
        TextView jVz;

        private C0743a() {
        }
    }
}
