package com.baidu.tieba.write.selectForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes13.dex */
public class a extends BaseAdapter {
    private HotTopicChangeFourmActivity kQy;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.kQy = hotTopicChangeFourmActivity;
        this.mContext = this.kQy.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Eq */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String KS(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > 14) {
            return str.substring(0, 13) + StringHelper.STRING_MORE;
        }
        return str;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0634a c0634a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0634a = a(view != null ? view.getTag() : null, item);
        } else {
            c0634a = null;
        }
        if (c0634a != null) {
            return c0634a.mRootView;
        }
        return null;
    }

    private C0634a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0634a c0634a;
        if (obj == null) {
            c0634a = cVq();
        } else {
            c0634a = (C0634a) obj;
        }
        c0634a.kQA.setText(KS(hotTopicBussinessData.mForumName));
        c0634a.kQz.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        am.setBackgroundResource(c0634a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0634a.kQA, (int) R.color.cp_cont_b);
        am.setBackgroundColor(c0634a.gzG, R.color.cp_bg_line_e);
        return c0634a;
    }

    private C0634a cVq() {
        C0634a c0634a = new C0634a();
        c0634a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        am.setBackgroundResource(c0634a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0634a.kQA, (int) R.color.cp_cont_b);
        c0634a.kQA = (TextView) c0634a.mRootView.findViewById(R.id.fourm_tv);
        c0634a.gzG = c0634a.mRootView.findViewById(R.id.line_view);
        c0634a.kQz = (TbImageView) c0634a.mRootView.findViewById(R.id.icon_img);
        c0634a.kQz.setDefaultBgResource(R.color.cp_bg_line_e);
        c0634a.kQz.setDefaultResource(R.drawable.transparent_bg);
        c0634a.kQz.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0634a.mRootView.setTag(c0634a);
        return c0634a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0634a {
        public View gzG;
        public TextView kQA;
        public TbImageView kQz;
        public View mRootView;

        private C0634a() {
        }
    }
}
