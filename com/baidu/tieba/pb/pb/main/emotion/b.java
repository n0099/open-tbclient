package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> hlY;
    private a kpL;
    private EmotionView.a kpM;

    /* loaded from: classes9.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.isEmpty(this.hlY)) {
            return 0;
        }
        return this.hlY.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.hlY = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0708b c0708b;
        if (view == null) {
            C0708b c0708b2 = new C0708b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0708b2.jRE = (EmotionView) view.findViewById(R.id.emotion_view);
            c0708b2.jRE.bTR();
            c0708b2.jRE.setController(this.kpM);
            c0708b2.jRE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.kpL != null && (view2 instanceof EmotionView)) {
                        b.this.kpL.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0708b2);
            c0708b = c0708b2;
        } else {
            c0708b = (C0708b) view.getTag();
        }
        if (this.hlY != null && i >= 0 && i < this.hlY.size()) {
            c0708b.jRE.a(this.hlY.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.kpL = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.kpM = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0708b {
        EmotionView jRE;

        C0708b() {
        }
    }
}
