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
    private List<EmotionImageData> eHx;
    private a hyE;
    private EmotionView.a hyF;

    /* loaded from: classes4.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.T(this.eHx)) {
            return 0;
        }
        return this.eHx.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.eHx = list;
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
            c0358b2.hep = (EmotionView) view.findViewById(d.g.emotion_view);
            c0358b2.hep.aXI();
            c0358b2.hep.setController(this.hyF);
            c0358b2.hep.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hyE != null && (view2 instanceof EmotionView)) {
                        b.this.hyE.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0358b2);
            c0358b = c0358b2;
        } else {
            c0358b = (C0358b) view.getTag();
        }
        if (this.eHx != null && i >= 0 && i < this.eHx.size()) {
            c0358b.hep.a(this.eHx.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.hyE = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.hyF = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0358b {
        EmotionView hep;

        C0358b() {
        }
    }
}
