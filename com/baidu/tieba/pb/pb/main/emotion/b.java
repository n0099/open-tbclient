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
    private List<EmotionImageData> gZB;
    private a jUP;
    private EmotionView.a jUQ;

    /* loaded from: classes9.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gZB)) {
            return 0;
        }
        return this.gZB.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gZB = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0691b c0691b;
        if (view == null) {
            C0691b c0691b2 = new C0691b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0691b2.jxf = (EmotionView) view.findViewById(R.id.emotion_view);
            c0691b2.jxf.bQT();
            c0691b2.jxf.setController(this.jUQ);
            c0691b2.jxf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.jUP != null && (view2 instanceof EmotionView)) {
                        b.this.jUP.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0691b2);
            c0691b = c0691b2;
        } else {
            c0691b = (C0691b) view.getTag();
        }
        if (this.gZB != null && i >= 0 && i < this.gZB.size()) {
            c0691b.jxf.a(this.gZB.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.jUP = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.jUQ = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0691b {
        EmotionView jxf;

        C0691b() {
        }
    }
}
