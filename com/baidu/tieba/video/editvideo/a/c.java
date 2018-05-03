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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.MusicData;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    public int gLH;
    public String gLI;
    private List<MusicData> mList;
    private e mPageContext;

    public c(e eVar) {
        this.mPageContext = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            tR(this.gLI);
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            view2 = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.gKP = (TbImageView) view2.findViewById(d.g.music_image);
            aVar.gKS = (TextView) view2.findViewById(d.g.music_title);
            aVar.gKR = view2.findViewById(d.g.music_loading);
            aVar.gKP.setDrawerType(1);
            aVar.gKP.setIsRound(true);
            aVar.gKP.setDefaultBgResource(d.C0126d.transparent);
            aVar.gKP.setDefaultErrorResource(d.f.bg_video_cloudmusic);
            aVar.gKP.setDefaultResource(d.f.bg_video_cloudmusic);
            aVar.gKP.setBorderWidth(l.e(this.mPageContext.getPageActivity(), d.e.ds4));
            aVar.gKP.setBorderColor(ak.getColor(d.C0126d.cp_link_tip_a));
            view2.setTag(aVar);
        } else {
            aVar = (a) view2.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.gKP.startLoad(String.valueOf(d.f.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.gKP.startLoad(String.valueOf(d.f.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.gKP.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.gKR.setVisibility(4);
            aVar.gKS.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
            aVar.gKS.setText(musicData.name);
            b(aVar.gKS, l.e(this.mPageContext.getPageActivity(), d.e.ds120), musicData.name);
            if (i == this.gLH) {
                aVar.gKP.setDrawBorder(true);
            } else {
                aVar.gKP.setDrawBorder(false);
            }
            if (i == 0) {
                view2.setPadding(l.e(this.mPageContext.getPageActivity(), d.e.ds34), l.e(this.mPageContext.getPageActivity(), d.e.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view2.setPadding(l.e(this.mPageContext.getPageActivity(), d.e.ds34), l.e(this.mPageContext.getPageActivity(), d.e.ds44), l.e(this.mPageContext.getPageActivity(), d.e.ds34), 0);
            } else {
                view2.setPadding(l.e(this.mPageContext.getPageActivity(), d.e.ds28), l.e(this.mPageContext.getPageActivity(), d.e.ds44), 0, 0);
            }
            if (this.mPageContext.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.mPageContext.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.mPageContext.getPageActivity()).getLayoutMode().u(view2);
            } else if (this.mPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.mPageContext.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.mPageContext.getPageActivity()).getLayoutMode().u(view2);
            }
        }
        return view2;
    }

    public void un(int i) {
        this.gLH = i;
        notifyDataSetChanged();
    }

    public void tR(String str) {
        this.gLI = str;
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
            this.gLH = i;
        }
    }

    public int bwv() {
        return this.gLH;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float e = l.e(this.mPageContext.getPageActivity(), d.e.fontsize24);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(e);
            while (textPaint.measureText(str) > i) {
                e -= 1.0f;
                textPaint.setTextSize(e);
            }
            textView.setTextSize(0, e);
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public TbImageView gKP;
        public View gKR;
        public TextView gKS;

        public a() {
        }
    }
}
