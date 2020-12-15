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
    private e eNZ;
    private List<PendantData> mList;
    private InterfaceC0878a nCP;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0878a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.eNZ = eVar;
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
            view = LayoutInflater.from(this.eNZ.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.nCR = (TextView) view.findViewById(R.id.cover_text);
            bVar.nCS = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.nCT = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.nCS.setDefaultBgResource(R.color.transparent);
            bVar.nCS.setDefaultErrorResource(R.color.CAM_X0101);
            bVar.nCS.setDefaultResource(R.color.CAM_X0101);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.nCP != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.nCS.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.nCS.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.nCP.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.nCS.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.nCR.setVisibility(0);
                    bVar.nCS.setVisibility(8);
                    bVar.nCT.setVisibility(8);
                    bVar.nCR.setTextColor(ap.getColor(R.color.CAM_X0110));
                    bVar.nCR.setText("No");
                    bVar.nCR.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.nCR.setVisibility(0);
                    bVar.nCS.setVisibility(8);
                    bVar.nCT.setVisibility(8);
                    bVar.nCR.setTextColor(ap.getColor(R.color.CAM_X0111));
                    bVar.nCR.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.nCR.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
                    break;
                case 2:
                    bVar.nCR.setVisibility(0);
                    bVar.nCS.setVisibility(8);
                    bVar.nCT.setVisibility(8);
                    bVar.nCR.setTextColor(ap.getColor(R.color.CAM_X0111));
                    bVar.nCR.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.nCR.setBackgroundColor(ap.getColor(R.color.CAM_X0109));
                    break;
                case 3:
                    bVar.nCR.setVisibility(0);
                    bVar.nCS.setVisibility(8);
                    bVar.nCT.setVisibility(8);
                    bVar.nCR.setTextColor(ap.getColor(R.color.CAM_X0109));
                    bVar.nCR.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.nCR.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.nCR.setVisibility(8);
                    bVar.nCS.setVisibility(0);
                    bVar.nCT.setVisibility(8);
                    bVar.nCS.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0878a interfaceC0878a) {
        this.nCP = interfaceC0878a;
    }

    /* loaded from: classes23.dex */
    public class b {
        public TextView nCR;
        public TbImageView nCS;
        public ProgressBar nCT;

        public b() {
        }
    }
}
