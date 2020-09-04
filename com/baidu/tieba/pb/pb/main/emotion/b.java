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
/* loaded from: classes16.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> hFg;
    private a kOx;
    private EmotionView.a kOy;

    /* loaded from: classes16.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.hFg)) {
            return 0;
        }
        return this.hFg.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.hFg = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0771b c0771b;
        if (view == null) {
            C0771b c0771b2 = new C0771b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0771b2.kpH = (EmotionView) view.findViewById(R.id.emotion_view);
            c0771b2.kpH.chI();
            c0771b2.kpH.setController(this.kOy);
            c0771b2.kpH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.kOx != null && (view2 instanceof EmotionView)) {
                        b.this.kOx.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0771b2);
            c0771b = c0771b2;
        } else {
            c0771b = (C0771b) view.getTag();
        }
        if (this.hFg != null && i >= 0 && i < this.hFg.size()) {
            c0771b.kpH.a(this.hFg.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.kOx = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.kOy = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    static class C0771b {
        EmotionView kpH;

        C0771b() {
        }
    }
}
