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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import java.util.List;
/* loaded from: classes17.dex */
public class c extends BaseAdapter {
    private e efK;
    private List<MusicData> mList;
    public int mvy;
    public String mvz;

    public c(e eVar) {
        this.efK = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            RG(this.mvz);
            notifyDataSetChanged();
        }
    }

    public List<MusicData> getData() {
        return this.mList;
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
            view = LayoutInflater.from(this.efK.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.muF = (TbImageView) view.findViewById(R.id.music_image);
            aVar.muI = (TextView) view.findViewById(R.id.music_title);
            aVar.muH = view.findViewById(R.id.music_loading);
            aVar.muF.setDrawerType(1);
            aVar.muF.setIsRound(true);
            aVar.muF.setDefaultBgResource(R.color.transparent);
            aVar.muF.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            aVar.muF.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.muF.setBorderWidth(l.getDimens(this.efK.getPageActivity(), R.dimen.ds4));
            aVar.muF.setBorderColor(ap.getColor(R.color.cp_link_tip_a));
            aVar.muF.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.muF.startLoad(String.valueOf(R.drawable.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.muF.startLoad(String.valueOf(R.drawable.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.muF.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.muH.setVisibility(4);
            aVar.muI.setTextColor(ap.getColor(R.color.cp_cont_j));
            aVar.muI.setText(musicData.name);
            b(aVar.muI, l.getDimens(this.efK.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.mvy) {
                aVar.muF.setDrawBorder(true);
            } else {
                aVar.muF.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.getDimens(this.efK.getPageActivity(), R.dimen.ds34), l.getDimens(this.efK.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.getDimens(this.efK.getPageActivity(), R.dimen.ds34), l.getDimens(this.efK.getPageActivity(), R.dimen.ds44), l.getDimens(this.efK.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.getDimens(this.efK.getPageActivity(), R.dimen.ds28), l.getDimens(this.efK.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.efK.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.efK.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.efK.getPageActivity()).getLayoutMode().onModeChanged(view);
            } else if (this.efK.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.efK.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.efK.getPageActivity()).getLayoutMode().onModeChanged(view);
            }
        }
        return view;
    }

    public void IR(int i) {
        this.mvy = i;
        notifyDataSetChanged();
    }

    public void RG(String str) {
        this.mvz = str;
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
            this.mvy = i;
        }
    }

    public int dBv() {
        return this.mvy;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float dimens = l.getDimens(this.efK.getPageActivity(), R.dimen.fontsize24);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(dimens);
            while (textPaint.measureText(str) > i) {
                dimens -= 1.0f;
                textPaint.setTextSize(dimens);
            }
            textView.setTextSize(0, dimens);
        }
    }

    /* loaded from: classes17.dex */
    public class a {
        public TbImageView muF;
        public View muH;
        public TextView muI;

        public a() {
        }
    }
}
