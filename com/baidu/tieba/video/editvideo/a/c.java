package com.baidu.tieba.video.editvideo.a;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends BaseAdapter {
    private f eTl;
    private List<MusicData> mList;
    public int nCx;
    public String nCy;

    public c(f fVar) {
        this.eTl = fVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            Tj(this.nCy);
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
            view = LayoutInflater.from(this.eTl.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.nBG = (TbImageView) view.findViewById(R.id.music_image);
            aVar.nBJ = (TextView) view.findViewById(R.id.music_title);
            aVar.nBI = view.findViewById(R.id.music_loading);
            aVar.nBG.setDrawerType(1);
            aVar.nBG.setIsRound(true);
            aVar.nBG.setDefaultBgResource(R.color.transparent);
            aVar.nBG.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.nBG.setBorderWidth(l.getDimens(this.eTl.getPageActivity(), R.dimen.ds4));
            aVar.nBG.setBorderColor(ao.getColor(R.color.CAM_X0302));
            aVar.nBG.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.nBG.startLoad(String.valueOf(R.drawable.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.nBG.startLoad(String.valueOf(R.drawable.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.nBG.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.nBI.setVisibility(4);
            aVar.nBJ.setTextColor(ao.getColor(R.color.CAM_X0107));
            aVar.nBJ.setText(musicData.name);
            a(aVar.nBJ, l.getDimens(this.eTl.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.nCx) {
                aVar.nBG.setDrawBorder(true);
            } else {
                aVar.nBG.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.getDimens(this.eTl.getPageActivity(), R.dimen.ds34), l.getDimens(this.eTl.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.getDimens(this.eTl.getPageActivity(), R.dimen.ds34), l.getDimens(this.eTl.getPageActivity(), R.dimen.ds44), l.getDimens(this.eTl.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.getDimens(this.eTl.getPageActivity(), R.dimen.ds28), l.getDimens(this.eTl.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.eTl.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.eTl.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.eTl.getPageActivity()).getLayoutMode().onModeChanged(view);
            } else if (this.eTl.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.eTl.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.eTl.getPageActivity()).getLayoutMode().onModeChanged(view);
            }
        }
        return view;
    }

    public void Ki(int i) {
        this.nCx = i;
        notifyDataSetChanged();
    }

    public void Tj(String str) {
        this.nCy = str;
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
            this.nCx = i;
        }
    }

    public int dQm() {
        return this.nCx;
    }

    public void a(TextView textView, int i, String str) {
        if (i > 0) {
            float dimens = l.getDimens(this.eTl.getPageActivity(), R.dimen.fontsize24);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(dimens);
            while (textPaint.measureText(str) > i) {
                dimens -= 1.0f;
                textPaint.setTextSize(dimens);
            }
            textView.setTextSize(0, dimens);
        }
    }

    /* loaded from: classes7.dex */
    public class a {
        public TbImageView nBG;
        public View nBI;
        public TextView nBJ;

        public a() {
        }
    }
}
