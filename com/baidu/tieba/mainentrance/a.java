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
    private String cwV;
    private final boolean ieH = true;
    private ArrayList<ForumSuggestModel.Forum> ieI;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.ieI = arrayList;
    }

    public void ay(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.ieI = arrayList;
        if (this.ieI != null) {
            notifyDataSetChanged();
        }
    }

    public void Em(String str) {
        this.cwV = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ieI == null) {
            return 0;
        }
        return this.ieI.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xI */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.ieI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0558a c0558a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0558a c0558a2 = new C0558a();
            c0558a2.ieK = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0558a2.ieK.setGifIconSupport(false);
            c0558a2.dic = (TextView) view.findViewById(R.id.name);
            c0558a2.ieL = (TextView) view.findViewById(R.id.forum_member_count);
            c0558a2.ieM = (TextView) view.findViewById(R.id.forum_thread_count);
            c0558a2.ieN = (TextView) view.findViewById(R.id.slogan);
            c0558a2.ieJ = view.findViewById(R.id.offical_icon);
            view.setTag(c0558a2);
            c0558a = c0558a2;
        } else {
            c0558a = (C0558a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0558a.ieK.setTag(str2);
            c0558a.ieK.startLoad(str2, 10, false);
            c0558a.ieK.invalidate();
            if (this.ieH) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(c0558a.dic, str);
            c0558a.ieK.setTag(item.avatar);
            c0558a.ieL.setText(this.mActivity.getPageContext().getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + xJ(item.member_num));
            c0558a.ieM.setText(this.mActivity.getPageContext().getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + xJ(item.thread_num));
            if (this.ieH || !TextUtils.isEmpty(item.slogan)) {
                c0558a.ieN.setVisibility(0);
                c0558a.ieN.setText(item.slogan);
            } else {
                c0558a.ieN.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0558a.ieJ.setVisibility(0);
                am.setBackgroundResource(c0558a.ieJ, R.drawable.icon_search_official);
            } else {
                c0558a.ieJ.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String xJ(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.cwV)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.cwV.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.cwV.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0558a {
        TextView dic;
        View ieJ;
        BarImageView ieK;
        TextView ieL;
        TextView ieM;
        TextView ieN;

        private C0558a() {
        }
    }
}
