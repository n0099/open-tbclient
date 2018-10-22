package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> djt;
    private a fWJ;
    private EmotionView.a fWK;

    /* loaded from: classes6.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.J(this.djt)) {
            return 0;
        }
        return this.djt.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.djt = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0249b c0249b;
        if (view == null) {
            C0249b c0249b2 = new C0249b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_sug_emotion, (ViewGroup) null);
            c0249b2.fCr = (EmotionView) view.findViewById(e.g.emotion_view);
            c0249b2.fCr.auN();
            c0249b2.fCr.setController(this.fWK);
            c0249b2.fCr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fWJ != null && (view2 instanceof EmotionView)) {
                        b.this.fWJ.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0249b2);
            c0249b = c0249b2;
        } else {
            c0249b = (C0249b) view.getTag();
        }
        if (this.djt != null && i >= 0 && i < this.djt.size()) {
            c0249b.fCr.a(this.djt.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.fWJ = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.fWK = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0249b {
        EmotionView fCr;

        C0249b() {
        }
    }
}
