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
    private List<EmotionImageData> gKP;
    private a jDq;
    private EmotionView.a jDr;

    /* loaded from: classes9.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gKP)) {
            return 0;
        }
        return this.gKP.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gKP = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0638b c0638b;
        if (view == null) {
            C0638b c0638b2 = new C0638b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0638b2.jic = (EmotionView) view.findViewById(R.id.emotion_view);
            c0638b2.jic.bKy();
            c0638b2.jic.setController(this.jDr);
            c0638b2.jic.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.jDq != null && (view2 instanceof EmotionView)) {
                        b.this.jDq.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0638b2);
            c0638b = c0638b2;
        } else {
            c0638b = (C0638b) view.getTag();
        }
        if (this.gKP != null && i >= 0 && i < this.gKP.size()) {
            c0638b.jic.a(this.gKP.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.jDq = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.jDr = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0638b {
        EmotionView jic;

        C0638b() {
        }
    }
}
