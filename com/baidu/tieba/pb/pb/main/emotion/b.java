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
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> fhG;
    private a hYh;
    private EmotionView.a hYi;

    /* loaded from: classes4.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.fhG)) {
            return 0;
        }
        return this.fhG.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.fhG = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0487b c0487b;
        if (view == null) {
            C0487b c0487b2 = new C0487b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0487b2.hDt = (EmotionView) view.findViewById(R.id.emotion_view);
            c0487b2.hDt.bfS();
            c0487b2.hDt.setController(this.hYi);
            c0487b2.hDt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hYh != null && (view2 instanceof EmotionView)) {
                        b.this.hYh.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0487b2);
            c0487b = c0487b2;
        } else {
            c0487b = (C0487b) view.getTag();
        }
        if (this.fhG != null && i >= 0 && i < this.fhG.size()) {
            c0487b.hDt.a(this.fhG.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.hYh = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.hYi = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0487b {
        EmotionView hDt;

        C0487b() {
        }
    }
}
