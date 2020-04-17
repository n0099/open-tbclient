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
    private List<EmotionImageData> gKJ;
    private a jDm;
    private EmotionView.a jDn;

    /* loaded from: classes9.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gKJ)) {
            return 0;
        }
        return this.gKJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gKJ = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0617b c0617b;
        if (view == null) {
            C0617b c0617b2 = new C0617b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0617b2.jhY = (EmotionView) view.findViewById(R.id.emotion_view);
            c0617b2.jhY.bKz();
            c0617b2.jhY.setController(this.jDn);
            c0617b2.jhY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.jDm != null && (view2 instanceof EmotionView)) {
                        b.this.jDm.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0617b2);
            c0617b = c0617b2;
        } else {
            c0617b = (C0617b) view.getTag();
        }
        if (this.gKJ != null && i >= 0 && i < this.gKJ.size()) {
            c0617b.jhY.a(this.gKJ.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.jDm = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.jDn = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0617b {
        EmotionView jhY;

        C0617b() {
        }
    }
}
