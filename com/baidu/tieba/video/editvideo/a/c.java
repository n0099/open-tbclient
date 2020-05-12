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
    private e dvg;
    public int liP;
    public String liQ;
    private List<MusicData> mList;

    public c(e eVar) {
        this.dvg = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            LM(this.liQ);
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
            view = LayoutInflater.from(this.dvg.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.lhZ = (TbImageView) view.findViewById(R.id.music_image);
            aVar.lic = (TextView) view.findViewById(R.id.music_title);
            aVar.lib = view.findViewById(R.id.music_loading);
            aVar.lhZ.setDrawerType(1);
            aVar.lhZ.setIsRound(true);
            aVar.lhZ.setDefaultBgResource(R.color.transparent);
            aVar.lhZ.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            aVar.lhZ.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.lhZ.setBorderWidth(l.getDimens(this.dvg.getPageActivity(), R.dimen.ds4));
            aVar.lhZ.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            aVar.lhZ.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.lhZ.startLoad(String.valueOf((int) R.drawable.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.lhZ.startLoad(String.valueOf((int) R.drawable.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.lhZ.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.lib.setVisibility(4);
            aVar.lic.setTextColor(am.getColor(R.color.cp_cont_j));
            aVar.lic.setText(musicData.name);
            b(aVar.lic, l.getDimens(this.dvg.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.liP) {
                aVar.lhZ.setDrawBorder(true);
            } else {
                aVar.lhZ.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.getDimens(this.dvg.getPageActivity(), R.dimen.ds34), l.getDimens(this.dvg.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.getDimens(this.dvg.getPageActivity(), R.dimen.ds34), l.getDimens(this.dvg.getPageActivity(), R.dimen.ds44), l.getDimens(this.dvg.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.getDimens(this.dvg.getPageActivity(), R.dimen.ds28), l.getDimens(this.dvg.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.dvg.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.dvg.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.dvg.getPageActivity()).getLayoutMode().onModeChanged(view);
            } else if (this.dvg.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.dvg.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.dvg.getPageActivity()).getLayoutMode().onModeChanged(view);
            }
        }
        return view;
    }

    public void Ek(int i) {
        this.liP = i;
        notifyDataSetChanged();
    }

    public void LM(String str) {
        this.liQ = str;
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
            this.liP = i;
        }
    }

    public int daZ() {
        return this.liP;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float dimens = l.getDimens(this.dvg.getPageActivity(), R.dimen.fontsize24);
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
        public TbImageView lhZ;
        public View lib;
        public TextView lic;

        public a() {
        }
    }
}
