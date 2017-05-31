package com.baidu.tieba.write.selectForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private List<HotTopicBussinessData> aTD;
    private ViewGroup dkH = null;
    private HotTopicChangeFourmActivity fWv;
    private final Context mContext;

    public b(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.fWv = hotTopicChangeFourmActivity;
        this.mContext = this.fWv.getPageContext().getContext();
    }

    public void setData(List<HotTopicBussinessData> list) {
        this.aTD = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.r(this.aTD)) {
            return 0;
        }
        return this.aTD.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tp */
    public HotTopicBussinessData getItem(int i) {
        if (this.aTD != null && i < this.aTD.size()) {
            return this.aTD.get(i);
        }
        return null;
    }

    private String rm(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > 14) {
            return String.valueOf(str.substring(0, 13)) + "...";
        }
        return str;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.dkH == null) {
            this.dkH = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            aVar = a(view != null ? view.getTag() : null, item);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.mRootView;
        }
        return null;
    }

    private a a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        a aVar;
        if (obj == null) {
            aVar = bos();
        } else {
            aVar = (a) obj;
        }
        aVar.fWx.setText(rm(hotTopicBussinessData.mForumName));
        aVar.fWw.c(hotTopicBussinessData.mForumAvatar, 10, false);
        aq.j(aVar.mRootView, w.g.select_forum_item_bg);
        aq.i(aVar.fWx, w.e.cp_cont_b);
        aq.k(aVar.bZY, w.e.cp_bg_line_e);
        return aVar;
    }

    private a bos() {
        a aVar = new a(this, null);
        aVar.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.hot_topic_change_item, (ViewGroup) null);
        aq.j(aVar.mRootView, w.g.select_forum_item_bg);
        aq.i(aVar.fWx, w.e.cp_cont_b);
        aVar.fWx = (TextView) aVar.mRootView.findViewById(w.h.fourm_tv);
        aVar.bZY = aVar.mRootView.findViewById(w.h.line_view);
        aVar.fWw = (TbImageView) aVar.mRootView.findViewById(w.h.icon_img);
        aVar.fWw.setDefaultBgResource(w.e.cp_bg_line_e);
        aVar.fWw.setDefaultResource(w.g.transparent_bg);
        aVar.fWw.setDefaultErrorResource(w.g.icon_default_ba_120);
        aVar.mRootView.setTag(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public View bZY;
        public TbImageView fWw;
        public TextView fWx;
        public View mRootView;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
