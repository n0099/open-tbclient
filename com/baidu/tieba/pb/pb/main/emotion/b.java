package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> dky;
    private a fYi;
    private EmotionView.a fYj;

    /* loaded from: classes6.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.dky)) {
            return 0;
        }
        return this.dky.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.dky = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0276b c0276b;
        if (view == null) {
            C0276b c0276b2 = new C0276b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_sug_emotion, (ViewGroup) null);
            c0276b2.fDO = (EmotionView) view.findViewById(e.g.emotion_view);
            c0276b2.fDO.aul();
            c0276b2.fDO.setController(this.fYj);
            c0276b2.fDO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fYi != null && (view2 instanceof EmotionView)) {
                        b.this.fYi.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0276b2);
            c0276b = c0276b2;
        } else {
            c0276b = (C0276b) view.getTag();
        }
        if (this.dky != null && i >= 0 && i < this.dky.size()) {
            c0276b.fDO.a(this.dky.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.fYi = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.fYj = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0276b {
        EmotionView fDO;

        C0276b() {
        }
    }
}
