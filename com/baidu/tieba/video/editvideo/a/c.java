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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import java.util.List;
/* loaded from: classes10.dex */
public class c extends BaseAdapter {
    private e dJb;
    public int lBA;
    public String lBB;
    private List<MusicData> mList;

    public c(e eVar) {
        this.dJb = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            Nz(this.lBB);
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
            view = LayoutInflater.from(this.dJb.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.lAK = (TbImageView) view.findViewById(R.id.music_image);
            aVar.lAN = (TextView) view.findViewById(R.id.music_title);
            aVar.lAM = view.findViewById(R.id.music_loading);
            aVar.lAK.setDrawerType(1);
            aVar.lAK.setIsRound(true);
            aVar.lAK.setDefaultBgResource(R.color.transparent);
            aVar.lAK.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            aVar.lAK.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.lAK.setBorderWidth(l.getDimens(this.dJb.getPageActivity(), R.dimen.ds4));
            aVar.lAK.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            aVar.lAK.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.lAK.startLoad(String.valueOf((int) R.drawable.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.lAK.startLoad(String.valueOf((int) R.drawable.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.lAK.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.lAM.setVisibility(4);
            aVar.lAN.setTextColor(am.getColor(R.color.cp_cont_j));
            aVar.lAN.setText(musicData.name);
            b(aVar.lAN, l.getDimens(this.dJb.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.lBA) {
                aVar.lAK.setDrawBorder(true);
            } else {
                aVar.lAK.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.getDimens(this.dJb.getPageActivity(), R.dimen.ds34), l.getDimens(this.dJb.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.getDimens(this.dJb.getPageActivity(), R.dimen.ds34), l.getDimens(this.dJb.getPageActivity(), R.dimen.ds44), l.getDimens(this.dJb.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.getDimens(this.dJb.getPageActivity(), R.dimen.ds28), l.getDimens(this.dJb.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.dJb.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.dJb.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.dJb.getPageActivity()).getLayoutMode().onModeChanged(view);
            } else if (this.dJb.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.dJb.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.dJb.getPageActivity()).getLayoutMode().onModeChanged(view);
            }
        }
        return view;
    }

    public void EV(int i) {
        this.lBA = i;
        notifyDataSetChanged();
    }

    public void Nz(String str) {
        this.lBB = str;
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
            this.lBA = i;
        }
    }

    public int din() {
        return this.lBA;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float dimens = l.getDimens(this.dJb.getPageActivity(), R.dimen.fontsize24);
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
        public TbImageView lAK;
        public View lAM;
        public TextView lAN;

        public a() {
        }
    }
}
