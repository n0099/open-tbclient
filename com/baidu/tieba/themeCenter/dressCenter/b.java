package com.baidu.tieba.themeCenter.dressCenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> eUY;
    private List<d> mThemeList;

    /* loaded from: classes9.dex */
    public static class a {
        public View gft;
        public View jlo;
        public TextView mTitleView;
        public HeadImageView nIP;
    }

    public b(TbPageContext<?> tbPageContext) {
        this.eUY = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mThemeList != null) {
            return this.mThemeList.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Kk */
    public d getItem(int i) {
        if (this.mThemeList == null || this.mThemeList.size() <= 0 || i < 0 || i >= this.mThemeList.size()) {
            return null;
        }
        return this.mThemeList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        d item = getItem(i);
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.dressup_item_view, viewGroup, false);
            a aVar2 = new a();
            aVar2.nIP = (HeadImageView) view.findViewById(R.id.dress_icon);
            aVar2.nIP.setDefaultResource(R.drawable.img_default_100);
            aVar2.nIP.setDefaultBgResource(R.color.CAM_X0204);
            aVar2.mTitleView = (TextView) view.findViewById(R.id.dress_desc_view);
            aVar2.jlo = view.findViewById(R.id.tip_view);
            aVar2.gft = view.findViewById(R.id.divider_line);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        if (item != null) {
            aVar.nIP.startLoad(item.getIconUrl(), 10, false);
            aVar.mTitleView.setText(item.getName());
            if (item.getUpdateTime() - com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.DRESSUP_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + item.getType(), 0L) > 0) {
                aVar.jlo.setVisibility(0);
            } else {
                aVar.jlo.setVisibility(4);
            }
            if (i == getCount() - 1) {
                aVar.gft.setVisibility(8);
            } else {
                aVar.gft.setVisibility(0);
            }
        }
        this.eUY.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<d> list) {
        this.mThemeList = list;
    }
}
