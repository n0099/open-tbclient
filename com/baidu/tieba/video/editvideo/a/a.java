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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private f eXW;
    private List<PendantData> mList;
    private InterfaceC0899a nGT;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0899a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(f fVar) {
        this.eXW = fVar;
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
            view = LayoutInflater.from(this.eXW.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.nGV = (TextView) view.findViewById(R.id.cover_text);
            bVar.nGW = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.nGX = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.nGW.setDefaultBgResource(R.color.transparent);
            bVar.nGW.setDefaultResource(R.color.CAM_X0101);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.nGT != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.nGW.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.nGW.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.nGT.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.nGW.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.nGV.setVisibility(0);
                    bVar.nGW.setVisibility(8);
                    bVar.nGX.setVisibility(8);
                    bVar.nGV.setTextColor(ao.getColor(R.color.CAM_X0110));
                    bVar.nGV.setText("No");
                    bVar.nGV.setBackgroundDrawable(ao.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.nGV.setVisibility(0);
                    bVar.nGW.setVisibility(8);
                    bVar.nGX.setVisibility(8);
                    bVar.nGV.setTextColor(ao.getColor(R.color.CAM_X0111));
                    bVar.nGV.setText("T");
                    bVar.nGV.setBackgroundColor(ao.getColor(R.color.CAM_X0302));
                    break;
                case 2:
                    bVar.nGV.setVisibility(0);
                    bVar.nGW.setVisibility(8);
                    bVar.nGX.setVisibility(8);
                    bVar.nGV.setTextColor(ao.getColor(R.color.CAM_X0111));
                    bVar.nGV.setText("T");
                    bVar.nGV.setBackgroundColor(ao.getColor(R.color.CAM_X0109));
                    break;
                case 3:
                    bVar.nGV.setVisibility(0);
                    bVar.nGW.setVisibility(8);
                    bVar.nGX.setVisibility(8);
                    bVar.nGV.setTextColor(ao.getColor(R.color.CAM_X0109));
                    bVar.nGV.setText("T");
                    bVar.nGV.setBackgroundDrawable(ao.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.nGV.setVisibility(8);
                    bVar.nGW.setVisibility(0);
                    bVar.nGX.setVisibility(8);
                    bVar.nGW.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0899a interfaceC0899a) {
        this.nGT = interfaceC0899a;
    }

    /* loaded from: classes8.dex */
    public class b {
        public TextView nGV;
        public TbImageView nGW;
        public ProgressBar nGX;

        public b() {
        }
    }
}
