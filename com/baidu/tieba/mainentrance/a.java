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
    private String bpw;
    private final BaseActivity<?> cXM;
    private final boolean hnd = true;
    private ArrayList<ForumSuggestModel.Forum> hne;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.cXM = baseActivity;
        this.hne = arrayList;
    }

    public void aj(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.hne = arrayList;
        if (this.hne != null) {
            notifyDataSetChanged();
        }
    }

    public void AK(String str) {
        this.bpw = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hne == null) {
            return 0;
        }
        return this.hne.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wP */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.hne.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0371a c0371a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.cXM.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0371a c0371a2 = new C0371a();
            c0371a2.hng = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0371a2.hng.setGifIconSupport(false);
            c0371a2.ccX = (TextView) view.findViewById(R.id.name);
            c0371a2.hnh = (TextView) view.findViewById(R.id.forum_member_count);
            c0371a2.hni = (TextView) view.findViewById(R.id.forum_thread_count);
            c0371a2.hnj = (TextView) view.findViewById(R.id.slogan);
            c0371a2.hnf = view.findViewById(R.id.offical_icon);
            view.setTag(c0371a2);
            c0371a = c0371a2;
        } else {
            c0371a = (C0371a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0371a.hng.setTag(str2);
            c0371a.hng.startLoad(str2, 10, false);
            c0371a.hng.invalidate();
            if (this.hnd) {
                str = this.cXM.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            a(c0371a.ccX, str);
            c0371a.hng.setTag(item.avatar);
            c0371a.hnh.setText(this.cXM.getPageContext().getString(R.string.attention) + " " + wQ(item.member_num));
            c0371a.hni.setText(this.cXM.getPageContext().getString(R.string.text_post) + " " + wQ(item.thread_num));
            if (this.hnd || !TextUtils.isEmpty(item.slogan)) {
                c0371a.hnj.setVisibility(0);
                c0371a.hnj.setText(item.slogan);
            } else {
                c0371a.hnj.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0371a.hnf.setVisibility(0);
                am.k(c0371a.hnf, R.drawable.icon_search_official);
            } else {
                c0371a.hnf.setVisibility(8);
            }
            this.cXM.getLayoutMode().setNightMode(skinType == 1);
            this.cXM.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String wQ(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.cXM.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bpw)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bpw.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bpw.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0371a {
        TextView ccX;
        View hnf;
        BarImageView hng;
        TextView hnh;
        TextView hni;
        TextView hnj;

        private C0371a() {
        }
    }
}
