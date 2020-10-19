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
/* loaded from: classes22.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> ibc;
    private a lmm;
    private EmotionView.a lmn;

    /* loaded from: classes22.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.ibc)) {
            return 0;
        }
        return this.ibc.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.ibc = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0786b c0786b;
        if (view == null) {
            C0786b c0786b2 = new C0786b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0786b2.kNs = (EmotionView) view.findViewById(R.id.emotion_view);
            c0786b2.kNs.cot();
            c0786b2.kNs.setController(this.lmn);
            c0786b2.kNs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.lmm != null && (view2 instanceof EmotionView)) {
                        b.this.lmm.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0786b2);
            c0786b = c0786b2;
        } else {
            c0786b = (C0786b) view.getTag();
        }
        if (this.ibc != null && i >= 0 && i < this.ibc.size()) {
            c0786b.kNs.a(this.ibc.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.lmm = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.lmn = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    static class C0786b {
        EmotionView kNs;

        C0786b() {
        }
    }
}
