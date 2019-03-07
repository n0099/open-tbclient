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
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> eHP;
    private a hyX;
    private EmotionView.a hyY;

    /* loaded from: classes4.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.T(this.eHP)) {
            return 0;
        }
        return this.eHP.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.eHP = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0285b c0285b;
        if (view == null) {
            C0285b c0285b2 = new C0285b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_sug_emotion, (ViewGroup) null);
            c0285b2.heC = (EmotionView) view.findViewById(d.g.emotion_view);
            c0285b2.heC.aXL();
            c0285b2.heC.setController(this.hyY);
            c0285b2.heC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hyX != null && (view2 instanceof EmotionView)) {
                        b.this.hyX.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0285b2);
            c0285b = c0285b2;
        } else {
            c0285b = (C0285b) view.getTag();
        }
        if (this.eHP != null && i >= 0 && i < this.eHP.size()) {
            c0285b.heC.a(this.eHP.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.hyX = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.hyY = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0285b {
        EmotionView heC;

        C0285b() {
        }
    }
}
