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
    private List<EmotionImageData> gZM;
    private a jVV;
    private EmotionView.a jVW;

    /* loaded from: classes9.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gZM)) {
            return 0;
        }
        return this.gZM.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gZM = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0692b c0692b;
        if (view == null) {
            C0692b c0692b2 = new C0692b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0692b2.jyl = (EmotionView) view.findViewById(R.id.emotion_view);
            c0692b2.jyl.bQV();
            c0692b2.jyl.setController(this.jVW);
            c0692b2.jyl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.jVV != null && (view2 instanceof EmotionView)) {
                        b.this.jVV.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0692b2);
            c0692b = c0692b2;
        } else {
            c0692b = (C0692b) view.getTag();
        }
        if (this.gZM != null && i >= 0 && i < this.gZM.size()) {
            c0692b.jyl.a(this.gZM.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.jVV = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.jVW = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0692b {
        EmotionView jyl;

        C0692b() {
        }
    }
}
