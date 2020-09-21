package com.baidu.tieba.video.editvideo.a;

import android.support.media.ExifInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private e eid;
    private InterfaceC0811a mFu;
    private List<PendantData> mList;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0811a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.eid = eVar;
    }

    public void setData(List<PendantData> list) {
        if (list != null) {
            this.mList = list;
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
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.eid.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.mFw = (TextView) view.findViewById(R.id.cover_text);
            bVar.mFx = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.mFy = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.mFx.setDefaultBgResource(R.color.transparent);
            bVar.mFx.setDefaultErrorResource(R.color.cp_cont_a);
            bVar.mFx.setDefaultResource(R.color.cp_cont_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mFu != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.mFx.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.mFx.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.mFu.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.mFx.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.mFw.setVisibility(0);
                    bVar.mFx.setVisibility(8);
                    bVar.mFy.setVisibility(8);
                    bVar.mFw.setTextColor(ap.getColor(R.color.cp_cont_e));
                    bVar.mFw.setText("No");
                    bVar.mFw.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.mFw.setVisibility(0);
                    bVar.mFx.setVisibility(8);
                    bVar.mFy.setVisibility(8);
                    bVar.mFw.setTextColor(ap.getColor(R.color.cp_cont_g));
                    bVar.mFw.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.mFw.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.mFw.setVisibility(0);
                    bVar.mFx.setVisibility(8);
                    bVar.mFy.setVisibility(8);
                    bVar.mFw.setTextColor(ap.getColor(R.color.cp_cont_g));
                    bVar.mFw.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.mFw.setBackgroundColor(ap.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.mFw.setVisibility(0);
                    bVar.mFx.setVisibility(8);
                    bVar.mFy.setVisibility(8);
                    bVar.mFw.setTextColor(ap.getColor(R.color.cp_cont_d));
                    bVar.mFw.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.mFw.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.mFw.setVisibility(8);
                    bVar.mFx.setVisibility(0);
                    bVar.mFy.setVisibility(8);
                    bVar.mFx.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0811a interfaceC0811a) {
        this.mFu = interfaceC0811a;
    }

    /* loaded from: classes22.dex */
    public class b {
        public TextView mFw;
        public TbImageView mFx;
        public ProgressBar mFy;

        public b() {
        }
    }
}
