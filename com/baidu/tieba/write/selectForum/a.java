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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private final Context mContext;
    private List<HotTopicBussinessData> mData;
    private ViewGroup mParent = null;
    private HotTopicChangeFourmActivity nVN;

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.nVN = hotTopicChangeFourmActivity;
        this.mContext = this.nVN.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.mData)) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: KU */
    public HotTopicBussinessData getItem(int i) {
        if (this.mData != null && i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }

    private String Uf(String str) {
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
        C0896a c0896a;
        if (this.mParent == null) {
            this.mParent = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            c0896a = a(view != null ? view.getTag() : null, item);
        } else {
            c0896a = null;
        }
        if (c0896a != null) {
            return c0896a.mRootView;
        }
        return null;
    }

    private C0896a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        C0896a c0896a;
        if (obj == null) {
            c0896a = dUV();
        } else {
            c0896a = (C0896a) obj;
        }
        c0896a.nVP.setText(Uf(hotTopicBussinessData.mForumName));
        c0896a.nVO.startLoad(hotTopicBussinessData.mForumAvatar, 10, false);
        ao.setBackgroundResource(c0896a.mRootView, R.drawable.select_forum_item_bg);
        ao.setViewTextColor(c0896a.nVP, R.color.CAM_X0105);
        ao.setBackgroundColor(c0896a.jnl, R.color.CAM_X0205);
        return c0896a;
    }

    private C0896a dUV() {
        C0896a c0896a = new C0896a();
        c0896a.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        ao.setBackgroundResource(c0896a.mRootView, R.drawable.select_forum_item_bg);
        ao.setViewTextColor(c0896a.nVP, R.color.CAM_X0105);
        c0896a.nVP = (TextView) c0896a.mRootView.findViewById(R.id.fourm_tv);
        c0896a.jnl = c0896a.mRootView.findViewById(R.id.line_view);
        c0896a.nVO = (TbImageView) c0896a.mRootView.findViewById(R.id.icon_img);
        c0896a.nVO.setDefaultBgResource(R.color.CAM_X0205);
        c0896a.nVO.setDefaultResource(R.drawable.transparent_bg);
        c0896a.mRootView.setTag(c0896a);
        return c0896a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.write.selectForum.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0896a {
        public View jnl;
        public View mRootView;
        public TbImageView nVO;
        public TextView nVP;

        private C0896a() {
        }
    }
}
