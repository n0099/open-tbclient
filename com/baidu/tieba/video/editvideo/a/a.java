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
    private e eGT;
    private List<PendantData> mList;
    private InterfaceC0862a noM;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0862a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.eGT = eVar;
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
            view = LayoutInflater.from(this.eGT.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.noO = (TextView) view.findViewById(R.id.cover_text);
            bVar.noP = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.noQ = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.noP.setDefaultBgResource(R.color.transparent);
            bVar.noP.setDefaultErrorResource(R.color.CAM_X0101);
            bVar.noP.setDefaultResource(R.color.CAM_X0101);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.noM != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.noP.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.noP.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.noM.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.noP.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.noO.setVisibility(0);
                    bVar.noP.setVisibility(8);
                    bVar.noQ.setVisibility(8);
                    bVar.noO.setTextColor(ap.getColor(R.color.CAM_X0110));
                    bVar.noO.setText("No");
                    bVar.noO.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.noO.setVisibility(0);
                    bVar.noP.setVisibility(8);
                    bVar.noQ.setVisibility(8);
                    bVar.noO.setTextColor(ap.getColor(R.color.CAM_X0111));
                    bVar.noO.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.noO.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
                    break;
                case 2:
                    bVar.noO.setVisibility(0);
                    bVar.noP.setVisibility(8);
                    bVar.noQ.setVisibility(8);
                    bVar.noO.setTextColor(ap.getColor(R.color.CAM_X0111));
                    bVar.noO.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.noO.setBackgroundColor(ap.getColor(R.color.CAM_X0109));
                    break;
                case 3:
                    bVar.noO.setVisibility(0);
                    bVar.noP.setVisibility(8);
                    bVar.noQ.setVisibility(8);
                    bVar.noO.setTextColor(ap.getColor(R.color.CAM_X0109));
                    bVar.noO.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.noO.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.noO.setVisibility(8);
                    bVar.noP.setVisibility(0);
                    bVar.noQ.setVisibility(8);
                    bVar.noP.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0862a interfaceC0862a) {
        this.noM = interfaceC0862a;
    }

    /* loaded from: classes22.dex */
    public class b {
        public TextView noO;
        public TbImageView noP;
        public ProgressBar noQ;

        public b() {
        }
    }
}
