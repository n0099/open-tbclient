package com.baidu.tieba.video.editvideo.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private f eXa;
    private List<PendantData> mList;
    private InterfaceC0893a nOE;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0893a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(f fVar) {
        this.eXa = fVar;
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
            view = LayoutInflater.from(this.eXa.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.nOG = (TextView) view.findViewById(R.id.cover_text);
            bVar.nOH = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.nOI = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.nOH.setDefaultBgResource(R.color.transparent);
            bVar.nOH.setDefaultResource(R.color.CAM_X0101);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.nOE != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.nOH.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.nOH.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.nOE.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.nOH.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.nOG.setVisibility(0);
                    bVar.nOH.setVisibility(8);
                    bVar.nOI.setVisibility(8);
                    bVar.nOG.setTextColor(ap.getColor(R.color.CAM_X0110));
                    bVar.nOG.setText("No");
                    bVar.nOG.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.nOG.setVisibility(0);
                    bVar.nOH.setVisibility(8);
                    bVar.nOI.setVisibility(8);
                    bVar.nOG.setTextColor(ap.getColor(R.color.CAM_X0111));
                    bVar.nOG.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.nOG.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
                    break;
                case 2:
                    bVar.nOG.setVisibility(0);
                    bVar.nOH.setVisibility(8);
                    bVar.nOI.setVisibility(8);
                    bVar.nOG.setTextColor(ap.getColor(R.color.CAM_X0111));
                    bVar.nOG.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.nOG.setBackgroundColor(ap.getColor(R.color.CAM_X0109));
                    break;
                case 3:
                    bVar.nOG.setVisibility(0);
                    bVar.nOH.setVisibility(8);
                    bVar.nOI.setVisibility(8);
                    bVar.nOG.setTextColor(ap.getColor(R.color.CAM_X0109));
                    bVar.nOG.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.nOG.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.nOG.setVisibility(8);
                    bVar.nOH.setVisibility(0);
                    bVar.nOI.setVisibility(8);
                    bVar.nOH.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0893a interfaceC0893a) {
        this.nOE = interfaceC0893a;
    }

    /* loaded from: classes7.dex */
    public class b {
        public TextView nOG;
        public TbImageView nOH;
        public ProgressBar nOI;

        public b() {
        }
    }
}
