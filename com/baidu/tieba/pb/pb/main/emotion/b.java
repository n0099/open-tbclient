package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> gbA;
    private a iTd;
    private EmotionView.a iTe;

    /* loaded from: classes9.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gbA)) {
            return 0;
        }
        return this.gbA.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gbA = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0579b c0579b;
        if (view == null) {
            C0579b c0579b2 = new C0579b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0579b2.ixS = (EmotionView) view.findViewById(R.id.emotion_view);
            c0579b2.ixS.bzY();
            c0579b2.ixS.setController(this.iTe);
            c0579b2.ixS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.iTd != null && (view2 instanceof EmotionView)) {
                        b.this.iTd.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0579b2);
            c0579b = c0579b2;
        } else {
            c0579b = (C0579b) view.getTag();
        }
        if (this.gbA != null && i >= 0 && i < this.gbA.size()) {
            c0579b.ixS.a(this.gbA.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.iTd = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.iTe = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0579b {
        EmotionView ixS;

        C0579b() {
        }
    }
}
