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
    private List<EmotionImageData> eXH;
    private a hQp;
    private EmotionView.a hQq;

    /* loaded from: classes4.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.eXH)) {
            return 0;
        }
        return this.eXH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.eXH = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0377b c0377b;
        if (view == null) {
            C0377b c0377b2 = new C0377b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0377b2.hvI = (EmotionView) view.findViewById(R.id.emotion_view);
            c0377b2.hvI.bfc();
            c0377b2.hvI.setController(this.hQq);
            c0377b2.hvI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hQp != null && (view2 instanceof EmotionView)) {
                        b.this.hQp.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0377b2);
            c0377b = c0377b2;
        } else {
            c0377b = (C0377b) view.getTag();
        }
        if (this.eXH != null && i >= 0 && i < this.eXH.size()) {
            c0377b.hvI.a(this.eXH.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.hQp = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.hQq = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0377b {
        EmotionView hvI;

        C0377b() {
        }
    }
}
