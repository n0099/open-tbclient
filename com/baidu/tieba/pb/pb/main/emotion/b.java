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
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> fVu;
    private a iMp;
    private EmotionView.a iMq;

    /* loaded from: classes6.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.fVu)) {
            return 0;
        }
        return this.fVu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.fVu = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0566b c0566b;
        if (view == null) {
            C0566b c0566b2 = new C0566b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0566b2.iqF = (EmotionView) view.findViewById(R.id.emotion_view);
            c0566b2.iqF.bxl();
            c0566b2.iqF.setController(this.iMq);
            c0566b2.iqF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.iMp != null && (view2 instanceof EmotionView)) {
                        b.this.iMp.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0566b2);
            c0566b = c0566b2;
        } else {
            c0566b = (C0566b) view.getTag();
        }
        if (this.fVu != null && i >= 0 && i < this.fVu.size()) {
            c0566b.iqF.a(this.fVu.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.iMp = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.iMq = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0566b {
        EmotionView iqF;

        C0566b() {
        }
    }
}
