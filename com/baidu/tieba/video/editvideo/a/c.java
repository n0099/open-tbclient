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
    private e cVC;
    public int kwD;
    public String kwE;
    private List<MusicData> mList;

    public c(e eVar) {
        this.cVC = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            JY(this.kwE);
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
            view = LayoutInflater.from(this.cVC.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.kvO = (TbImageView) view.findViewById(R.id.music_image);
            aVar.kvR = (TextView) view.findViewById(R.id.music_title);
            aVar.kvQ = view.findViewById(R.id.music_loading);
            aVar.kvO.setDrawerType(1);
            aVar.kvO.setIsRound(true);
            aVar.kvO.setDefaultBgResource(R.color.transparent);
            aVar.kvO.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            aVar.kvO.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.kvO.setBorderWidth(l.getDimens(this.cVC.getPageActivity(), R.dimen.ds4));
            aVar.kvO.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            aVar.kvO.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.kvO.startLoad(String.valueOf((int) R.drawable.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.kvO.startLoad(String.valueOf((int) R.drawable.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.kvO.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.kvQ.setVisibility(4);
            aVar.kvR.setTextColor(am.getColor(R.color.cp_cont_j));
            aVar.kvR.setText(musicData.name);
            b(aVar.kvR, l.getDimens(this.cVC.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.kwD) {
                aVar.kvO.setDrawBorder(true);
            } else {
                aVar.kvO.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.getDimens(this.cVC.getPageActivity(), R.dimen.ds34), l.getDimens(this.cVC.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.getDimens(this.cVC.getPageActivity(), R.dimen.ds34), l.getDimens(this.cVC.getPageActivity(), R.dimen.ds44), l.getDimens(this.cVC.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.getDimens(this.cVC.getPageActivity(), R.dimen.ds28), l.getDimens(this.cVC.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.cVC.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.cVC.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.cVC.getPageActivity()).getLayoutMode().onModeChanged(view);
            } else if (this.cVC.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.cVC.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.cVC.getPageActivity()).getLayoutMode().onModeChanged(view);
            }
        }
        return view;
    }

    public void Dy(int i) {
        this.kwD = i;
        notifyDataSetChanged();
    }

    public void JY(String str) {
        this.kwE = str;
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
            this.kwD = i;
        }
    }

    public int cPI() {
        return this.kwD;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float dimens = l.getDimens(this.cVC.getPageActivity(), R.dimen.fontsize24);
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
        public TbImageView kvO;
        public View kvQ;
        public TextView kvR;

        public a() {
        }
    }
}
