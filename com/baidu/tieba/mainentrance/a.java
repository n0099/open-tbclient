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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private String erD;
    private final boolean lkI = true;
    private ArrayList<ForumSuggestModel.Forum> lkJ;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.lkJ = arrayList;
    }

    public void aK(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.lkJ = arrayList;
        if (this.lkJ != null) {
            notifyDataSetChanged();
        }
    }

    public void NW(String str) {
        this.erD = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lkJ == null) {
            return 0;
        }
        return this.lkJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: En */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.lkJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0796a c0796a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0796a c0796a2 = new C0796a();
            c0796a2.lkL = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0796a2.lkL.setGifIconSupport(false);
            c0796a2.fmq = (TextView) view.findViewById(R.id.name);
            c0796a2.lkM = (TextView) view.findViewById(R.id.forum_member_count);
            c0796a2.lkN = (TextView) view.findViewById(R.id.forum_thread_count);
            c0796a2.lkO = (TextView) view.findViewById(R.id.slogan);
            c0796a2.lkK = view.findViewById(R.id.offical_icon);
            view.setTag(c0796a2);
            c0796a = c0796a2;
        } else {
            c0796a = (C0796a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0796a.lkL.setTag(str2);
            c0796a.lkL.startLoad(str2, 10, false);
            c0796a.lkL.invalidate();
            if (this.lkI) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            e(c0796a.fmq, str);
            c0796a.lkL.setTag(item.avatar);
            c0796a.lkM.setText(this.mActivity.getPageContext().getString(R.string.attention) + " " + Eo(item.member_num));
            c0796a.lkN.setText(this.mActivity.getPageContext().getString(R.string.text_post) + " " + Eo(item.thread_num));
            if (this.lkI || !TextUtils.isEmpty(item.slogan)) {
                c0796a.lkO.setVisibility(0);
                c0796a.lkO.setText(item.slogan);
            } else {
                c0796a.lkO.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0796a.lkK.setVisibility(0);
                ap.setBackgroundResource(c0796a.lkK, R.drawable.icon_search_official);
            } else {
                c0796a.lkK.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String Eo(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void e(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.erD)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.erD.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.erD.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0796a {
        TextView fmq;
        View lkK;
        BarImageView lkL;
        TextView lkM;
        TextView lkN;
        TextView lkO;

        private C0796a() {
        }
    }
}
