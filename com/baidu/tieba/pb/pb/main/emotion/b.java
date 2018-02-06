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
    private List<EmotionImageData> drN;
    private a fWN;
    private EmotionView.a fWO;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.E(this.drN)) {
            return 0;
        }
        return this.drN.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.drN = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0211b c0211b;
        if (view == null) {
            C0211b c0211b2 = new C0211b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_sug_emotion, (ViewGroup) null);
            c0211b2.fCc = (EmotionView) view.findViewById(d.g.emotion_view);
            c0211b2.fCc.arl();
            c0211b2.fCc.setController(this.fWO);
            c0211b2.fCc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fWN != null && (view2 instanceof EmotionView)) {
                        b.this.fWN.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0211b2);
            c0211b = c0211b2;
        } else {
            c0211b = (C0211b) view.getTag();
        }
        if (this.drN != null && i >= 0 && i < this.drN.size()) {
            c0211b.fCc.a(this.drN.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.fWN = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.fWO = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0211b {
        EmotionView fCc;

        C0211b() {
        }
    }
}
