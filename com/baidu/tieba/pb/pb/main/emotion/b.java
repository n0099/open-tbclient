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
    private List<EmotionImageData> itB;
    private a lEM;
    private EmotionView.a lEN;

    /* loaded from: classes22.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.itB)) {
            return 0;
        }
        return this.itB.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.itB = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0816b c0816b;
        if (view == null) {
            C0816b c0816b2 = new C0816b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0816b2.lfN = (EmotionView) view.findViewById(R.id.emotion_view);
            c0816b2.lfN.cub();
            c0816b2.lfN.setController(this.lEN);
            c0816b2.lfN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.lEM != null && (view2 instanceof EmotionView)) {
                        b.this.lEM.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0816b2);
            c0816b = c0816b2;
        } else {
            c0816b = (C0816b) view.getTag();
        }
        if (this.itB != null && i >= 0 && i < this.itB.size()) {
            c0816b.lfN.a(this.itB.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.lEM = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.lEN = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    static class C0816b {
        EmotionView lfN;

        C0816b() {
        }
    }
}
