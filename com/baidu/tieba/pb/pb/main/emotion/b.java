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
    private List<EmotionImageData> iSv;
    private a mcJ;
    private EmotionView.a mcK;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.iSv)) {
            return 0;
        }
        return this.iSv.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iSv = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0837b c0837b;
        if (view == null) {
            C0837b c0837b2 = new C0837b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0837b2.lCm = (EmotionView) view.findViewById(R.id.emotion_view);
            c0837b2.lCm.cyh();
            c0837b2.lCm.setController(this.mcK);
            c0837b2.lCm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.mcJ != null && (view2 instanceof EmotionView)) {
                        b.this.mcJ.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0837b2);
            c0837b = c0837b2;
        } else {
            c0837b = (C0837b) view.getTag();
        }
        if (this.iSv != null && i >= 0 && i < this.iSv.size()) {
            c0837b.lCm.a(this.iSv.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.mcJ = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.mcK = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0837b {
        EmotionView lCm;

        C0837b() {
        }
    }
}
