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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import java.util.List;
/* loaded from: classes10.dex */
public class c extends BaseAdapter {
    private e dPR;
    public int lWs;
    public String lWt;
    private List<MusicData> mList;

    public c(e eVar) {
        this.dPR = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            NZ(this.lWt);
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
            view = LayoutInflater.from(this.dPR.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.lVz = (TbImageView) view.findViewById(R.id.music_image);
            aVar.lVC = (TextView) view.findViewById(R.id.music_title);
            aVar.lVB = view.findViewById(R.id.music_loading);
            aVar.lVz.setDrawerType(1);
            aVar.lVz.setIsRound(true);
            aVar.lVz.setDefaultBgResource(R.color.transparent);
            aVar.lVz.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            aVar.lVz.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.lVz.setBorderWidth(l.getDimens(this.dPR.getPageActivity(), R.dimen.ds4));
            aVar.lVz.setBorderColor(an.getColor(R.color.cp_link_tip_a));
            aVar.lVz.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.lVz.startLoad(String.valueOf((int) R.drawable.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.lVz.startLoad(String.valueOf((int) R.drawable.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.lVz.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.lVB.setVisibility(4);
            aVar.lVC.setTextColor(an.getColor(R.color.cp_cont_j));
            aVar.lVC.setText(musicData.name);
            b(aVar.lVC, l.getDimens(this.dPR.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.lWs) {
                aVar.lVz.setDrawBorder(true);
            } else {
                aVar.lVz.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.getDimens(this.dPR.getPageActivity(), R.dimen.ds34), l.getDimens(this.dPR.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.getDimens(this.dPR.getPageActivity(), R.dimen.ds34), l.getDimens(this.dPR.getPageActivity(), R.dimen.ds44), l.getDimens(this.dPR.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.getDimens(this.dPR.getPageActivity(), R.dimen.ds28), l.getDimens(this.dPR.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.dPR.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.dPR.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.dPR.getPageActivity()).getLayoutMode().onModeChanged(view);
            } else if (this.dPR.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.dPR.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.dPR.getPageActivity()).getLayoutMode().onModeChanged(view);
            }
        }
        return view;
    }

    public void FZ(int i) {
        this.lWs = i;
        notifyDataSetChanged();
    }

    public void NZ(String str) {
        this.lWt = str;
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
            this.lWs = i;
        }
    }

    public int dmL() {
        return this.lWs;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float dimens = l.getDimens(this.dPR.getPageActivity(), R.dimen.fontsize24);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(dimens);
            while (textPaint.measureText(str) > i) {
                dimens -= 1.0f;
                textPaint.setTextSize(dimens);
            }
            textView.setTextSize(0, dimens);
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public View lVB;
        public TextView lVC;
        public TbImageView lVz;

        public a() {
        }
    }
}
