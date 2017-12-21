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
    public int gRB;
    public String gRC;
    private List<MusicData> mList;
    private e mPageContext;

    public c(e eVar) {
        this.mPageContext = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            uc(this.gRC);
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
            aVar.gQJ = (TbImageView) view.findViewById(d.g.music_image);
            aVar.gQM = (TextView) view.findViewById(d.g.music_title);
            aVar.gQL = view.findViewById(d.g.music_loading);
            aVar.gQJ.setDrawerType(1);
            aVar.gQJ.setIsRound(true);
            aVar.gQJ.setDefaultBgResource(d.C0095d.transparent);
            aVar.gQJ.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            aVar.gQJ.setDefaultResource(d.f.bg_video_cloudmusic);
            aVar.gQJ.setBorderWidth(l.f(this.mPageContext.getPageActivity(), d.e.ds4));
            aVar.gQJ.setBorderColor(aj.getColor(d.C0095d.cp_link_tip_a));
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.gQJ.startLoad(String.valueOf(d.f.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.gQJ.startLoad(String.valueOf(d.f.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.gQJ.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.gQL.setVisibility(4);
            aVar.gQM.setTextColor(aj.getColor(d.C0095d.cp_cont_j));
            aVar.gQM.setText(musicData.name);
            b(aVar.gQM, l.f(this.mPageContext.getPageActivity(), d.e.ds120), musicData.name);
            if (i == this.gRB) {
                aVar.gQJ.setDrawBorder(true);
            } else {
                aVar.gQJ.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.f(this.mPageContext.getPageActivity(), d.e.ds34), l.f(this.mPageContext.getPageActivity(), d.e.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.f(this.mPageContext.getPageActivity(), d.e.ds34), l.f(this.mPageContext.getPageActivity(), d.e.ds44), l.f(this.mPageContext.getPageActivity(), d.e.ds34), 0);
            } else {
                view.setPadding(l.f(this.mPageContext.getPageActivity(), d.e.ds28), l.f(this.mPageContext.getPageActivity(), d.e.ds44), 0, 0);
            }
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.mPageContext.getPageActivity()).getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.mPageContext.getPageActivity()).getLayoutMode().t(view);
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.mPageContext.getPageActivity()).getLayoutMode().ag(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.mPageContext.getPageActivity()).getLayoutMode().t(view);
            }
        }
        return view;
    }

    public void vt(int i) {
        this.gRB = i;
        notifyDataSetChanged();
    }

    public void uc(String str) {
        this.gRC = str;
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
            this.gRB = i;
        }
    }

    public int bBG() {
        return this.gRB;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float f = l.f(this.mPageContext.getPageActivity(), d.e.fontsize24);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(f);
            while (textPaint.measureText(str) > i) {
                f -= 1.0f;
                textPaint.setTextSize(f);
            }
            textView.setTextSize(0, f);
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public TbImageView gQJ;
        public View gQL;
        public TextView gQM;

        public a() {
        }
    }
}
