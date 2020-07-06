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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;
    private HotTopicChangeFourmActivity mpx;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.mpx = hotTopicChangeFourmActivity;
        this.mContext = this.mpx.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.isEmpty(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: GL */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String OY(String str) {
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
        C0771a c0771a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0771a = a(view != null ? view.getTag() : null, item);
        } else {
            c0771a = null;
        }
        if (c0771a != null) {
            return c0771a.mRootView;
        }
        return null;
    }

    private C0771a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0771a c0771a;
        if (obj == null) {
            c0771a = drS();
        } else {
            c0771a = (C0771a) obj;
        }
        c0771a.mpz.setText(OY(hotTopicBussinessData.mForumName));
        c0771a.mpy.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        an.setBackgroundResource(c0771a.mRootView, R.drawable.select_forum_item_bg);
        an.setViewTextColor(c0771a.mpz, (int) R.color.cp_cont_b);
        an.setBackgroundColor(c0771a.hLe, R.color.cp_bg_line_e);
        return c0771a;
    }

    private C0771a drS() {
        C0771a c0771a = new C0771a();
        c0771a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        an.setBackgroundResource(c0771a.mRootView, R.drawable.select_forum_item_bg);
        an.setViewTextColor(c0771a.mpz, (int) R.color.cp_cont_b);
        c0771a.mpz = (TextView) c0771a.mRootView.findViewById(R.id.fourm_tv);
        c0771a.hLe = c0771a.mRootView.findViewById(R.id.line_view);
        c0771a.mpy = (TbImageView) c0771a.mRootView.findViewById(R.id.icon_img);
        c0771a.mpy.setDefaultBgResource(R.color.cp_bg_line_e);
        c0771a.mpy.setDefaultResource(R.drawable.transparent_bg);
        c0771a.mpy.setDefaultErrorResource(R.drawable.icon_default_ba_120);
        c0771a.mRootView.setTag(c0771a);
        return c0771a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0771a {
        public View hLe;
        public View mRootView;
        public TbImageView mpy;
        public TextView mpz;

        private C0771a() {
        }
    }
}
