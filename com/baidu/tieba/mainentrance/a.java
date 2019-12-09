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
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private String bHr;
    private final boolean hkZ = true;
    private ArrayList<ForumSuggestModel.Forum> hla;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.hla = arrayList;
    }

    public void an(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.hla = arrayList;
        if (this.hla != null) {
            notifyDataSetChanged();
        }
    }

    public void ze(String str) {
        this.bHr = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hla == null) {
            return 0;
        }
        return this.hla.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vv */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.hla.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0460a c0460a;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            C0460a c0460a2 = new C0460a();
            c0460a2.hlc = (BarImageView) view.findViewById(R.id.forum_avatar);
            c0460a2.hlc.setGifIconSupport(false);
            c0460a2.cqt = (TextView) view.findViewById(R.id.name);
            c0460a2.hld = (TextView) view.findViewById(R.id.forum_member_count);
            c0460a2.hle = (TextView) view.findViewById(R.id.forum_thread_count);
            c0460a2.hlf = (TextView) view.findViewById(R.id.slogan);
            c0460a2.hlb = view.findViewById(R.id.offical_icon);
            view.setTag(c0460a2);
            c0460a = c0460a2;
        } else {
            c0460a = (C0460a) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            c0460a.hlc.setTag(str2);
            c0460a.hlc.startLoad(str2, 10, false);
            c0460a.hlc.invalidate();
            if (this.hkZ) {
                str = this.mActivity.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            b(c0460a.cqt, str);
            c0460a.hlc.setTag(item.avatar);
            c0460a.hld.setText(this.mActivity.getPageContext().getString(R.string.attention) + HanziToPinyin.Token.SEPARATOR + vw(item.member_num));
            c0460a.hle.setText(this.mActivity.getPageContext().getString(R.string.text_post) + HanziToPinyin.Token.SEPARATOR + vw(item.thread_num));
            if (this.hkZ || !TextUtils.isEmpty(item.slogan)) {
                c0460a.hlf.setVisibility(0);
                c0460a.hlf.setText(item.slogan);
            } else {
                c0460a.hlf.setVisibility(8);
            }
            if (item.is_offical == 1) {
                c0460a.hlb.setVisibility(0);
                am.setBackgroundResource(c0460a.hlb, R.drawable.icon_search_official);
            } else {
                c0460a.hlb.setVisibility(8);
            }
            this.mActivity.getLayoutMode().setNightMode(skinType == 1);
            this.mActivity.getLayoutMode().onModeChanged(view);
        }
        return view;
    }

    public String vw(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.mActivity.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.bHr)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.bHr.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_h));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.bHr.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: com.baidu.tieba.mainentrance.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0460a {
        TextView cqt;
        View hlb;
        BarImageView hlc;
        TextView hld;
        TextView hle;
        TextView hlf;

        private C0460a() {
        }
    }
}
