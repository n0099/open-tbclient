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
    private e efO;
    private List<MusicData> mList;
    public int mvQ;
    public String mvR;

    public c(e eVar) {
        this.efO = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            RG(this.mvR);
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
            view = LayoutInflater.from(this.efO.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.muX = (TbImageView) view.findViewById(R.id.music_image);
            aVar.mva = (TextView) view.findViewById(R.id.music_title);
            aVar.muZ = view.findViewById(R.id.music_loading);
            aVar.muX.setDrawerType(1);
            aVar.muX.setIsRound(true);
            aVar.muX.setDefaultBgResource(R.color.transparent);
            aVar.muX.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            aVar.muX.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.muX.setBorderWidth(l.getDimens(this.efO.getPageActivity(), R.dimen.ds4));
            aVar.muX.setBorderColor(ap.getColor(R.color.cp_link_tip_a));
            aVar.muX.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.muX.startLoad(String.valueOf(R.drawable.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.muX.startLoad(String.valueOf(R.drawable.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.muX.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.muZ.setVisibility(4);
            aVar.mva.setTextColor(ap.getColor(R.color.cp_cont_j));
            aVar.mva.setText(musicData.name);
            b(aVar.mva, l.getDimens(this.efO.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.mvQ) {
                aVar.muX.setDrawBorder(true);
            } else {
                aVar.muX.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.getDimens(this.efO.getPageActivity(), R.dimen.ds34), l.getDimens(this.efO.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.getDimens(this.efO.getPageActivity(), R.dimen.ds34), l.getDimens(this.efO.getPageActivity(), R.dimen.ds44), l.getDimens(this.efO.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.getDimens(this.efO.getPageActivity(), R.dimen.ds28), l.getDimens(this.efO.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.efO.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.efO.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.efO.getPageActivity()).getLayoutMode().onModeChanged(view);
            } else if (this.efO.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.efO.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.efO.getPageActivity()).getLayoutMode().onModeChanged(view);
            }
        }
        return view;
    }

    public void IR(int i) {
        this.mvQ = i;
        notifyDataSetChanged();
    }

    public void RG(String str) {
        this.mvR = str;
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
            this.mvQ = i;
        }
    }

    public int dBE() {
        return this.mvQ;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float dimens = l.getDimens(this.efO.getPageActivity(), R.dimen.fontsize24);
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
        public TbImageView muX;
        public View muZ;
        public TextView mva;

        public a() {
        }
    }
}
