package com.baidu.tieba.video.editvideo.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private f eTl;
    private List<PendantData> mList;
    private InterfaceC0882a nCo;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0882a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(f fVar) {
        this.eTl = fVar;
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
            view = LayoutInflater.from(this.eTl.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.nCq = (TextView) view.findViewById(R.id.cover_text);
            bVar.nCr = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.nCs = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.nCr.setDefaultBgResource(R.color.transparent);
            bVar.nCr.setDefaultResource(R.color.CAM_X0101);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.nCo != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.nCr.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.nCr.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.nCo.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.nCr.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.nCq.setVisibility(0);
                    bVar.nCr.setVisibility(8);
                    bVar.nCs.setVisibility(8);
                    bVar.nCq.setTextColor(ao.getColor(R.color.CAM_X0110));
                    bVar.nCq.setText("No");
                    bVar.nCq.setBackgroundDrawable(ao.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.nCq.setVisibility(0);
                    bVar.nCr.setVisibility(8);
                    bVar.nCs.setVisibility(8);
                    bVar.nCq.setTextColor(ao.getColor(R.color.CAM_X0111));
                    bVar.nCq.setText("T");
                    bVar.nCq.setBackgroundColor(ao.getColor(R.color.CAM_X0302));
                    break;
                case 2:
                    bVar.nCq.setVisibility(0);
                    bVar.nCr.setVisibility(8);
                    bVar.nCs.setVisibility(8);
                    bVar.nCq.setTextColor(ao.getColor(R.color.CAM_X0111));
                    bVar.nCq.setText("T");
                    bVar.nCq.setBackgroundColor(ao.getColor(R.color.CAM_X0109));
                    break;
                case 3:
                    bVar.nCq.setVisibility(0);
                    bVar.nCr.setVisibility(8);
                    bVar.nCs.setVisibility(8);
                    bVar.nCq.setTextColor(ao.getColor(R.color.CAM_X0109));
                    bVar.nCq.setText("T");
                    bVar.nCq.setBackgroundDrawable(ao.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.nCq.setVisibility(8);
                    bVar.nCr.setVisibility(0);
                    bVar.nCs.setVisibility(8);
                    bVar.nCr.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0882a interfaceC0882a) {
        this.nCo = interfaceC0882a;
    }

    /* loaded from: classes7.dex */
    public class b {
        public TextView nCq;
        public TbImageView nCr;
        public ProgressBar nCs;

        public b() {
        }
    }
}
