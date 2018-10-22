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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.video.editvideo.data.MusicData;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends BaseAdapter {
    public int hsM;
    public String hsN;
    private List<MusicData> mList;
    private e mPageContext;

    public c(e eVar) {
        this.mPageContext = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            vX(this.hsN);
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
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.hrW = (TbImageView) view.findViewById(e.g.music_image);
            aVar.hrZ = (TextView) view.findViewById(e.g.music_title);
            aVar.hrY = view.findViewById(e.g.music_loading);
            aVar.hrW.setDrawerType(1);
            aVar.hrW.setIsRound(true);
            aVar.hrW.setDefaultBgResource(e.d.transparent);
            aVar.hrW.setDefaultErrorResource(e.f.bg_video_cloudmusic);
            aVar.hrW.setDefaultResource(e.f.bg_video_cloudmusic);
            aVar.hrW.setBorderWidth(l.h(this.mPageContext.getPageActivity(), e.C0175e.ds4));
            aVar.hrW.setBorderColor(al.getColor(e.d.cp_link_tip_a));
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.hrW.startLoad(String.valueOf(e.f.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.hrW.startLoad(String.valueOf(e.f.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.hrW.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.hrY.setVisibility(4);
            aVar.hrZ.setTextColor(al.getColor(e.d.cp_cont_j));
            aVar.hrZ.setText(musicData.name);
            b(aVar.hrZ, l.h(this.mPageContext.getPageActivity(), e.C0175e.ds120), musicData.name);
            if (i == this.hsM) {
                aVar.hrW.setDrawBorder(true);
            } else {
                aVar.hrW.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.h(this.mPageContext.getPageActivity(), e.C0175e.ds34), l.h(this.mPageContext.getPageActivity(), e.C0175e.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.h(this.mPageContext.getPageActivity(), e.C0175e.ds34), l.h(this.mPageContext.getPageActivity(), e.C0175e.ds44), l.h(this.mPageContext.getPageActivity(), e.C0175e.ds34), 0);
            } else {
                view.setPadding(l.h(this.mPageContext.getPageActivity(), e.C0175e.ds28), l.h(this.mPageContext.getPageActivity(), e.C0175e.ds44), 0, 0);
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

    public void vD(int i) {
        this.hsM = i;
        notifyDataSetChanged();
    }

    public void vX(String str) {
        this.hsN = str;
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
            this.hsM = i;
        }
    }

    public int bGQ() {
        return this.hsM;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float h = l.h(this.mPageContext.getPageActivity(), e.C0175e.fontsize24);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(h);
            while (textPaint.measureText(str) > i) {
                h -= 1.0f;
                textPaint.setTextSize(h);
            }
            textView.setTextSize(0, h);
        }
    }

    /* loaded from: classes5.dex */
    public class a {
        public TbImageView hrW;
        public View hrY;
        public TextView hrZ;

        public a() {
        }
    }
}
