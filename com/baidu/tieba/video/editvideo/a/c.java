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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.MusicData;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    public int hog;
    public String hoh;
    private List<MusicData> mList;
    private e mPageContext;

    public c(e eVar) {
        this.mPageContext = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            ty(this.hoh);
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
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.hno = (TbImageView) view.findViewById(d.g.music_image);
            aVar.hnr = (TextView) view.findViewById(d.g.music_title);
            aVar.hnq = view.findViewById(d.g.music_loading);
            aVar.hno.setDrawerType(1);
            aVar.hno.setIsRound(true);
            aVar.hno.setDefaultBgResource(d.C0107d.transparent);
            aVar.hno.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            aVar.hno.setDefaultResource(d.f.bg_video_cloudmusic);
            aVar.hno.setBorderWidth(l.s(this.mPageContext.getPageActivity(), d.e.ds4));
            aVar.hno.setBorderColor(aj.getColor(d.C0107d.cp_link_tip_a));
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.hno.startLoad(String.valueOf(d.f.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.hno.startLoad(String.valueOf(d.f.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.hno.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.hnq.setVisibility(4);
            aVar.hnr.setTextColor(aj.getColor(d.C0107d.cp_cont_j));
            aVar.hnr.setText(musicData.name);
            b(aVar.hnr, l.s(this.mPageContext.getPageActivity(), d.e.ds120), musicData.name);
            if (i == this.hog) {
                aVar.hno.setDrawBorder(true);
            } else {
                aVar.hno.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.s(this.mPageContext.getPageActivity(), d.e.ds34), l.s(this.mPageContext.getPageActivity(), d.e.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.s(this.mPageContext.getPageActivity(), d.e.ds34), l.s(this.mPageContext.getPageActivity(), d.e.ds44), l.s(this.mPageContext.getPageActivity(), d.e.ds34), 0);
            } else {
                view.setPadding(l.s(this.mPageContext.getPageActivity(), d.e.ds28), l.s(this.mPageContext.getPageActivity(), d.e.ds44), 0, 0);
            }
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.mPageContext.getPageActivity()).getLayoutMode().aM(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.mPageContext.getPageActivity()).getLayoutMode().aM(view);
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.mPageContext.getPageActivity()).getLayoutMode().aM(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.mPageContext.getPageActivity()).getLayoutMode().aM(view);
            }
        }
        return view;
    }

    public void wL(int i) {
        this.hog = i;
        notifyDataSetChanged();
    }

    public void ty(String str) {
        this.hoh = str;
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
            this.hog = i;
        }
    }

    public int bAA() {
        return this.hog;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float s = l.s(this.mPageContext.getPageActivity(), d.e.fontsize24);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(s);
            while (textPaint.measureText(str) > i) {
                s -= 1.0f;
                textPaint.setTextSize(s);
            }
            textView.setTextSize(0, s);
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public TbImageView hno;
        public View hnq;
        public TextView hnr;

        public a() {
        }
    }
}
