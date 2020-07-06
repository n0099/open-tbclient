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
    public int lWv;
    public String lWw;
    private List<MusicData> mList;

    public c(e eVar) {
        this.dPR = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            Oa(this.lWw);
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
            aVar.lVC = (TbImageView) view.findViewById(R.id.music_image);
            aVar.lVF = (TextView) view.findViewById(R.id.music_title);
            aVar.lVE = view.findViewById(R.id.music_loading);
            aVar.lVC.setDrawerType(1);
            aVar.lVC.setIsRound(true);
            aVar.lVC.setDefaultBgResource(R.color.transparent);
            aVar.lVC.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            aVar.lVC.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.lVC.setBorderWidth(l.getDimens(this.dPR.getPageActivity(), R.dimen.ds4));
            aVar.lVC.setBorderColor(an.getColor(R.color.cp_link_tip_a));
            aVar.lVC.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.lVC.startLoad(String.valueOf((int) R.drawable.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.lVC.startLoad(String.valueOf((int) R.drawable.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.lVC.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.lVE.setVisibility(4);
            aVar.lVF.setTextColor(an.getColor(R.color.cp_cont_j));
            aVar.lVF.setText(musicData.name);
            b(aVar.lVF, l.getDimens(this.dPR.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.lWv) {
                aVar.lVC.setDrawBorder(true);
            } else {
                aVar.lVC.setDrawBorder(false);
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
        this.lWv = i;
        notifyDataSetChanged();
    }

    public void Oa(String str) {
        this.lWw = str;
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
            this.lWv = i;
        }
    }

    public int dmP() {
        return this.lWv;
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
        public TbImageView lVC;
        public View lVE;
        public TextView lVF;

        public a() {
        }
    }
}
