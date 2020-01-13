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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private HotTopicChangeFourmActivity kNZ;
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.kNZ = hotTopicChangeFourmActivity;
        this.mContext = this.kNZ.getPageContext().getContext();
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
    /* renamed from: Ee */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String KF(String str) {
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
        C0625a c0625a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0625a = a(view != null ? view.getTag() : null, item);
        } else {
            c0625a = null;
        }
        if (c0625a != null) {
            return c0625a.mRootView;
        }
        return null;
    }

    private C0625a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0625a c0625a;
        if (obj == null) {
            c0625a = cTD();
        } else {
            c0625a = (C0625a) obj;
        }
        c0625a.kOb.setText(KF(hotTopicBussinessData.mForumName));
        c0625a.kOa.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        am.setBackgroundResource(c0625a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0625a.kOb, (int) R.color.cp_cont_b);
        am.setBackgroundColor(c0625a.gwt, R.color.cp_bg_line_e);
        return c0625a;
    }

    private C0625a cTD() {
        C0625a c0625a = new C0625a();
        c0625a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        am.setBackgroundResource(c0625a.mRootView, R.drawable.select_forum_item_bg);
        am.setViewTextColor(c0625a.kOb, (int) R.color.cp_cont_b);
        c0625a.kOb = (TextView) c0625a.mRootView.findViewById(R.id.fourm_tv);
        c0625a.gwt = c0625a.mRootView.findViewById(R.id.line_view);
        c0625a.kOa = (TbImageView) c0625a.mRootView.findViewById(R.id.icon_img);
        c0625a.kOa.setDefaultBgResource(R.color.cp_bg_line_e);
        c0625a.kOa.setDefaultResource(R.drawable.transparent_bg);
        c0625a.kOa.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0625a.mRootView.setTag(c0625a);
        return c0625a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0625a {
        public View gwt;
        public TbImageView kOa;
        public TextView kOb;
        public View mRootView;

        private C0625a() {
        }
    }
}
