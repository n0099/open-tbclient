package com.baidu.tieba.video.editvideo.a;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends BaseAdapter {
    public int jzc;
    public String jzd;
    private List<MusicData> mList;
    private e mPageContext;

    public c(e eVar) {
        this.mPageContext = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            Gl(this.jzd);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mList == null) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.jyl = (TbImageView) view.findViewById(R.id.music_image);
            aVar.jyo = (TextView) view.findViewById(R.id.music_title);
            aVar.jyn = view.findViewById(R.id.music_loading);
            aVar.jyl.setDrawerType(1);
            aVar.jyl.setIsRound(true);
            aVar.jyl.setDefaultBgResource(R.color.transparent);
            aVar.jyl.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            aVar.jyl.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.jyl.setBorderWidth(l.g(this.mPageContext.getPageActivity(), R.dimen.ds4));
            aVar.jyl.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            aVar.jyl.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.jyl.startLoad(String.valueOf((int) R.drawable.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.jyl.startLoad(String.valueOf((int) R.drawable.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.jyl.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.jyn.setVisibility(4);
            aVar.jyo.setTextColor(am.getColor(R.color.cp_cont_j));
            aVar.jyo.setText(musicData.name);
            b(aVar.jyo, l.g(this.mPageContext.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.jzc) {
                aVar.jyl.setDrawBorder(true);
            } else {
                aVar.jyl.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.g(this.mPageContext.getPageActivity(), R.dimen.ds34), l.g(this.mPageContext.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.g(this.mPageContext.getPageActivity(), R.dimen.ds34), l.g(this.mPageContext.getPageActivity(), R.dimen.ds44), l.g(this.mPageContext.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.g(this.mPageContext.getPageActivity(), R.dimen.ds28), l.g(this.mPageContext.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.mPageContext.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.mPageContext.getPageActivity()).getLayoutMode().onModeChanged(view);
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.mPageContext.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.mPageContext.getPageActivity()).getLayoutMode().onModeChanged(view);
            }
        }
        return view;
    }

    public void Cm(int i) {
        this.jzc = i;
        notifyDataSetChanged();
    }

    public void Gl(String str) {
        this.jzd = str;
        if (!TextUtils.isEmpty(str) && this.mList != null) {
            int i = -1;
            for (int i2 = 0; i2 < this.mList.size(); i2++) {
                if (str.equals(this.mList.get(i2).id)) {
                    i = i2;
                }
            }
            if (i == -1) {
                i = 1;
            }
            this.jzc = i;
        }
    }

    public int cvr() {
        return this.jzc;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float g = l.g(this.mPageContext.getPageActivity(), R.dimen.fontsize24);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(g);
            while (textPaint.measureText(str) > i) {
                g -= 1.0f;
                textPaint.setTextSize(g);
            }
            textView.setTextSize(0, g);
        }
    }

    /* loaded from: classes5.dex */
    public class a {
        public TbImageView jyl;
        public View jyn;
        public TextView jyo;

        public a() {
        }
    }
}
