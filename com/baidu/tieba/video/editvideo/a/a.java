package com.baidu.tieba.video.editvideo.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private InterfaceC0222a gLC;
    private List<PendantData> mList;
    private e mPageContext;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0222a {
        void a(View view2, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        b bVar;
        if (view2 == null) {
            view2 = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.gLE = (TextView) view2.findViewById(d.g.cover_text);
            bVar.gLF = (TbImageView) view2.findViewById(d.g.pendant_image);
            bVar.gLG = (ProgressBar) view2.findViewById(d.g.pendant_progressbar);
            bVar.gLF.setDefaultBgResource(d.C0126d.transparent);
            bVar.gLF.setDefaultErrorResource(d.C0126d.cp_cont_i);
            bVar.gLF.setDefaultResource(d.C0126d.cp_cont_i);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (a.this.gLC != null) {
                        b bVar2 = (b) view3.getTag();
                        if (bVar2.gLF.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.gLF.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.gLC.a(view3, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view2.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            view2.setTag(bVar);
        } else {
            bVar = (b) view2.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.gLF.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.gLE.setVisibility(0);
                    bVar.gLF.setVisibility(8);
                    bVar.gLG.setVisibility(8);
                    bVar.gLE.setTextColor(ak.getColor(d.C0126d.cp_cont_e));
                    bVar.gLE.setText("No");
                    bVar.gLE.setBackgroundDrawable(ak.getDrawable(d.f.bg_cover_text_border));
                    break;
                case 1:
                    bVar.gLE.setVisibility(0);
                    bVar.gLF.setVisibility(8);
                    bVar.gLG.setVisibility(8);
                    bVar.gLE.setTextColor(ak.getColor(d.C0126d.cp_cont_g));
                    bVar.gLE.setText("T");
                    bVar.gLE.setBackgroundColor(ak.getColor(d.C0126d.cp_link_tip_a));
                    break;
                case 2:
                    bVar.gLE.setVisibility(0);
                    bVar.gLF.setVisibility(8);
                    bVar.gLG.setVisibility(8);
                    bVar.gLE.setTextColor(ak.getColor(d.C0126d.cp_cont_g));
                    bVar.gLE.setText("T");
                    bVar.gLE.setBackgroundColor(ak.getColor(d.C0126d.cp_cont_d));
                    break;
                case 3:
                    bVar.gLE.setVisibility(0);
                    bVar.gLF.setVisibility(8);
                    bVar.gLG.setVisibility(8);
                    bVar.gLE.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
                    bVar.gLE.setText("T");
                    bVar.gLE.setBackgroundDrawable(ak.getDrawable(d.f.bg_cover_text_border));
                    break;
                default:
                    bVar.gLE.setVisibility(8);
                    bVar.gLF.setVisibility(0);
                    bVar.gLG.setVisibility(8);
                    bVar.gLF.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view2;
    }

    public void a(InterfaceC0222a interfaceC0222a) {
        this.gLC = interfaceC0222a;
    }

    /* loaded from: classes2.dex */
    public class b {
        public TextView gLE;
        public TbImageView gLF;
        public ProgressBar gLG;

        public b() {
        }
    }
}
