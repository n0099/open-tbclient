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
/* loaded from: classes21.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> hMh;
    private a kWZ;
    private EmotionView.a kXa;

    /* loaded from: classes21.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.hMh)) {
            return 0;
        }
        return this.hMh.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.hMh = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0768b c0768b;
        if (view == null) {
            C0768b c0768b2 = new C0768b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0768b2.kyg = (EmotionView) view.findViewById(R.id.emotion_view);
            c0768b2.kyg.ckV();
            c0768b2.kyg.setController(this.kXa);
            c0768b2.kyg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.kWZ != null && (view2 instanceof EmotionView)) {
                        b.this.kWZ.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0768b2);
            c0768b = c0768b2;
        } else {
            c0768b = (C0768b) view.getTag();
        }
        if (this.hMh != null && i >= 0 && i < this.hMh.size()) {
            c0768b.kyg.a(this.hMh.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.kWZ = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.kXa = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    static class C0768b {
        EmotionView kyg;

        C0768b() {
        }
    }
}
