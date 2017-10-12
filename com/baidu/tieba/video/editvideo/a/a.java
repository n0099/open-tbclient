package com.baidu.tieba.video.editvideo.a;

import android.text.TextPaint;
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
public class a extends BaseAdapter {
    public int gvq;
    private List<MusicData> mList;
    private e mPageContext;

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
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
        C0130a c0130a;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.j.layout_music_item, (ViewGroup) null);
            c0130a = new C0130a();
            c0130a.guC = (TbImageView) view.findViewById(d.h.music_image);
            c0130a.guF = (TextView) view.findViewById(d.h.music_title);
            c0130a.guE = view.findViewById(d.h.music_loading);
            c0130a.guC.setDrawerType(1);
            c0130a.guC.setIsRound(true);
            c0130a.guC.setDefaultBgResource(d.e.transparent);
            c0130a.guC.setDefaultErrorResource(d.g.bg_video_cloudmusic);
            c0130a.guC.setDefaultResource(d.g.bg_video_cloudmusic);
            c0130a.guC.setBorderWidth(l.f(this.mPageContext.getPageActivity(), d.f.ds4));
            c0130a.guC.setBorderColor(aj.getColor(d.e.cp_link_tip_a));
            view.setTag(c0130a);
        } else {
            c0130a = (C0130a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    c0130a.guC.c(String.valueOf(d.g.icon_video_mute), 24, false);
                    break;
                case 2:
                    c0130a.guC.c(String.valueOf(d.g.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    c0130a.guC.c(musicData.img, 10, false);
                    break;
            }
            c0130a.guE.setVisibility(4);
            c0130a.guF.setTextColor(aj.getColor(d.e.cp_cont_j));
            c0130a.guF.setText(musicData.name);
            b(c0130a.guF, l.f(this.mPageContext.getPageActivity(), d.f.ds120), musicData.name);
            if (i == this.gvq) {
                c0130a.guC.setDrawBorder(true);
            } else {
                c0130a.guC.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.f(this.mPageContext.getPageActivity(), d.f.ds34), l.f(this.mPageContext.getPageActivity(), d.f.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.f(this.mPageContext.getPageActivity(), d.f.ds34), l.f(this.mPageContext.getPageActivity(), d.f.ds44), l.f(this.mPageContext.getPageActivity(), d.f.ds34), 0);
            } else {
                view.setPadding(l.f(this.mPageContext.getPageActivity(), d.f.ds28), l.f(this.mPageContext.getPageActivity(), d.f.ds44), 0, 0);
            }
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.mPageContext.getPageActivity()).getLayoutMode().ai(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.mPageContext.getPageActivity()).getLayoutMode().t(view);
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.mPageContext.getPageActivity()).getLayoutMode().ai(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.mPageContext.getPageActivity()).getLayoutMode().t(view);
            }
        }
        return view;
    }

    public void ux(int i) {
        this.gvq = i;
        notifyDataSetChanged();
    }

    public int bvR() {
        return this.gvq;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float f = l.f(this.mPageContext.getPageActivity(), d.f.fontsize24);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(f);
            while (textPaint.measureText(str) > i) {
                f -= 1.0f;
                textPaint.setTextSize(f);
            }
            textView.setTextSize(0, f);
        }
    }

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0130a {
        public TbImageView guC;
        public View guE;
        public TextView guF;

        public C0130a() {
        }
    }
}
