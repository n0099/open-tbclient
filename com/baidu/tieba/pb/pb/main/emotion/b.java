package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> iUs;
    private a mfb;
    private EmotionView.a mfc;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.iUs)) {
            return 0;
        }
        return this.iUs.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iUs = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0844b c0844b;
        if (view == null) {
            C0844b c0844b2 = new C0844b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0844b2.lEC = (EmotionView) view.findViewById(R.id.emotion_view);
            c0844b2.lEC.cyu();
            c0844b2.lEC.setController(this.mfc);
            c0844b2.lEC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mfb != null && (view2 instanceof EmotionView)) {
                        b.this.mfb.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0844b2);
            c0844b = c0844b2;
        } else {
            c0844b = (C0844b) view.getTag();
        }
        if (this.iUs != null && i >= 0 && i < this.iUs.size()) {
            c0844b.lEC.a(this.iUs.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.mfb = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.mfc = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0844b {
        EmotionView lEC;

        C0844b() {
        }
    }
}
