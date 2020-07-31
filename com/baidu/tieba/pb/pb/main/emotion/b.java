package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes16.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> hrK;
    private a kyJ;
    private EmotionView.a kyK;

    /* loaded from: classes16.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.hrK)) {
            return 0;
        }
        return this.hrK.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.hrK = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0720b c0720b;
        if (view == null) {
            C0720b c0720b2 = new C0720b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0720b2.kac = (EmotionView) view.findViewById(R.id.emotion_view);
            c0720b2.kac.bXl();
            c0720b2.kac.setController(this.kyK);
            c0720b2.kac.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.kyJ != null && (view2 instanceof EmotionView)) {
                        b.this.kyJ.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0720b2);
            c0720b = c0720b2;
        } else {
            c0720b = (C0720b) view.getTag();
        }
        if (this.hrK != null && i >= 0 && i < this.hrK.size()) {
            c0720b.kac.a(this.hrK.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.kyJ = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.kyK = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    static class C0720b {
        EmotionView kac;

        C0720b() {
        }
    }
}
