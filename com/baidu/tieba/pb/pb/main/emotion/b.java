package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> djY;
    private a fRG;
    private EmotionView.a fRH;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.G(this.djY)) {
            return 0;
        }
        return this.djY.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.djY = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0143b c0143b;
        if (view == null) {
            C0143b c0143b2 = new C0143b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_sug_emotion, (ViewGroup) null);
            c0143b2.fwH = (EmotionView) view.findViewById(d.g.emotion_view);
            c0143b2.fwH.apn();
            c0143b2.fwH.setController(this.fRH);
            c0143b2.fwH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fRG != null && (view2 instanceof EmotionView)) {
                        b.this.fRG.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0143b2);
            c0143b = c0143b2;
        } else {
            c0143b = (C0143b) view.getTag();
        }
        if (this.djY != null && i >= 0 && i < this.djY.size()) {
            c0143b.fwH.a(this.djY.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.fRG = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.fRH = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0143b {
        EmotionView fwH;

        C0143b() {
        }
    }
}
