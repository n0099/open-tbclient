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
    private List<EmotionImageData> eHy;
    private a hyF;
    private EmotionView.a hyG;

    /* loaded from: classes4.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.T(this.eHy)) {
            return 0;
        }
        return this.eHy.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.eHy = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0358b c0358b;
        if (view == null) {
            C0358b c0358b2 = new C0358b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_sug_emotion, (ViewGroup) null);
            c0358b2.heq = (EmotionView) view.findViewById(d.g.emotion_view);
            c0358b2.heq.aXI();
            c0358b2.heq.setController(this.hyG);
            c0358b2.heq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hyF != null && (view2 instanceof EmotionView)) {
                        b.this.hyF.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0358b2);
            c0358b = c0358b2;
        } else {
            c0358b = (C0358b) view.getTag();
        }
        if (this.eHy != null && i >= 0 && i < this.eHy.size()) {
            c0358b.heq.a(this.eHy.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.hyF = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.hyG = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0358b {
        EmotionView heq;

        C0358b() {
        }
    }
}
