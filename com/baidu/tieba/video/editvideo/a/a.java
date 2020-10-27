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
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private e eCK;
    private List<PendantData> mList;
    private InterfaceC0844a nhH;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0844a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.eCK = eVar;
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
            view = LayoutInflater.from(this.eCK.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.nhJ = (TextView) view.findViewById(R.id.cover_text);
            bVar.nhK = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.nhL = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.nhK.setDefaultBgResource(R.color.transparent);
            bVar.nhK.setDefaultErrorResource(R.color.cp_cont_a);
            bVar.nhK.setDefaultResource(R.color.cp_cont_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.nhH != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.nhK.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.nhK.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.nhH.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.nhK.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.nhJ.setVisibility(0);
                    bVar.nhK.setVisibility(8);
                    bVar.nhL.setVisibility(8);
                    bVar.nhJ.setTextColor(ap.getColor(R.color.cp_cont_e));
                    bVar.nhJ.setText("No");
                    bVar.nhJ.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.nhJ.setVisibility(0);
                    bVar.nhK.setVisibility(8);
                    bVar.nhL.setVisibility(8);
                    bVar.nhJ.setTextColor(ap.getColor(R.color.cp_cont_g));
                    bVar.nhJ.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.nhJ.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.nhJ.setVisibility(0);
                    bVar.nhK.setVisibility(8);
                    bVar.nhL.setVisibility(8);
                    bVar.nhJ.setTextColor(ap.getColor(R.color.cp_cont_g));
                    bVar.nhJ.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.nhJ.setBackgroundColor(ap.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.nhJ.setVisibility(0);
                    bVar.nhK.setVisibility(8);
                    bVar.nhL.setVisibility(8);
                    bVar.nhJ.setTextColor(ap.getColor(R.color.cp_cont_d));
                    bVar.nhJ.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.nhJ.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.nhJ.setVisibility(8);
                    bVar.nhK.setVisibility(0);
                    bVar.nhL.setVisibility(8);
                    bVar.nhK.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0844a interfaceC0844a) {
        this.nhH = interfaceC0844a;
    }

    /* loaded from: classes23.dex */
    public class b {
        public TextView nhJ;
        public TbImageView nhK;
        public ProgressBar nhL;

        public b() {
        }
    }
}
