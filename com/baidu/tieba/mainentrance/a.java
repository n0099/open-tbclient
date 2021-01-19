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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private String enU;
    private final boolean lao = true;
    private ArrayList<ForumSuggestModel.Forum> lap;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.lap = arrayList;
    }

    public void aL(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.lap = arrayList;
        if (this.lap != null) {
            notifyDataSetChanged();
        }
    }

    public void Nb(String str) {
        this.enU = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lap == null) {
            return 0;
        }
        return this.lap.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DS */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.lap.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0787a c0787a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0787a c0787a2 = new C0787a();
            c0787a2.lar = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0787a2.lar.setGifIconSupport(false);
            c0787a2.fiz = (TextView) view.findViewById(R.id.name);
            c0787a2.las = (TextView) view.findViewById(R.id.forum_member_count);
            c0787a2.lau = (TextView) view.findViewById(R.id.forum_thread_count);
            c0787a2.lav = (TextView) view.findViewById(R.id.slogan);
            c0787a2.laq = view.findViewById(R.id.offical_icon);
            view.setTag(c0787a2);
            c0787a = c0787a2;
        } else {
            c0787a = (C0787a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0787a.lar.setTag(str2);
            c0787a.lar.startLoad(str2, 10, false);
            c0787a.lar.invalidate();
            if (this.lao) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            e(c0787a.fiz, str);
            c0787a.lar.setTag(item.avatar);
            c0787a.las.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + DT(item.member_num));
            c0787a.lau.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + DT(item.thread_num));
            if (this.lao || !TextUtils.isEmpty(item.slogan)) {
                c0787a.lav.setVisibility(0);
                c0787a.lav.setText(item.slogan);
            } else {
                c0787a.lav.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0787a.laq.setVisibility(0);
                ao.setBackgroundResource(c0787a.laq, R.drawable.icon_search_official);
            } else {
                c0787a.laq.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String DT(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void e(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.enU)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.enU.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.enU.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0787a {
        TextView fiz;
        View laq;
        BarImageView lar;
        TextView las;
        TextView lau;
        TextView lav;

        private C0787a() {
        }
    }
}
